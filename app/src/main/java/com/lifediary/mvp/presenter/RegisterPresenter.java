package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.lifediary.model.User;
import com.lifediary.mvp.contract.RegisterContract;
import com.lifediary.util.ToastUtils;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;


public class RegisterPresenter implements RegisterContract.Presenter {
    private Context context;
    private RegisterContract.View view;

    public RegisterPresenter(Context context, RegisterContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void requestMobilePhone(String phone) {
        /**
         * TODO template 如果是自定义短信模板，此处替换为你在控制台设置的自定义短信模板名称；如果没有对应的自定义短信模板，则使用默认短信模板。
         */
        BmobSMS.requestSMSCode(phone, "DataSDK", new QueryListener<Integer>() {
            @Override
            public void done(Integer smsId, BmobException e) {
                if (e == null) {
                    ToastUtils.showShort(context, "发送验证码成功，短信ID：" + smsId + "\n");
                    view.showVerificationCode();
                } else {
                    ToastUtils.showShort(context, "发送验证码失败：" + e.getErrorCode() + "-" + e.getMessage() + "\n");
                }
            }
        });
        //暂时找不

    }

    @Override
    public void register(String UserName, String password, String verification) {
        BmobSMS.verifySmsCode(UserName, verification, new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    User user = new User();
                    user.setUsername("" + UserName);
                    user.setPassword("" + password);
                    user.setGender(0);
                    user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User user, BmobException e) {
                            if (e == null) {
                                ToastUtils.showShort(context, "注册成功");
                                view.registerSuccess();
                            } else {
                                ToastUtils.showShort(context, "尚未失败");
                            }
                        }
                    });
                } else {
                    ToastUtils.showShort(context, "验证码验证失败：" + e.getErrorCode() + "-" + e.getMessage() + "\n");
                }
            }
        });
    }
}