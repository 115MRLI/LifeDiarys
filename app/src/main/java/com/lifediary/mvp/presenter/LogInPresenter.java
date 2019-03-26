package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.lifediary.manager.LoginManager;
import com.lifediary.model.User;
import com.lifediary.mvp.contract.LogInContract;
import com.lifediary.util.ToastUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

/**
 * 登录
 */
public class LogInPresenter implements LogInContract.Presenter {
    private Context context;
    private LogInContract.View view;

    public LogInPresenter(Context context, LogInContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }

    @Override
    public void loginByAccount(String account, String password) {
        //此处替换为你的用户名密码
        BmobUser.loginByAccount(account, password, new LogInListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    LoginManager.get(context).setupUserInfo(user);
                    view.loginSuccess();
                } else {
                    ToastUtils.showShort(context, "登录失败");
                }
            }
        });
    }
}