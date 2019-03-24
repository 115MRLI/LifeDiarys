package com.lifediary.view.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lifediary.R;
import com.lifediary.manager.ActivityGoManager;
import com.lifediary.mvp.contract.RegisterContract;
import com.lifediary.mvp.presenter.RegisterPresenter;
import com.lifediary.util.ToastUtils;
import com.lifediary.util.Utils;

import butterknife.BindView;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private RegisterContract.Presenter presenter;

    //手机号
    @BindView(R.id.user_phone)
    EditText userPhone;

    //验证码
    @BindView(R.id.verification_code)
    EditText verificationCode;

    //密码
    @BindView(R.id.password)
    EditText password;

    //获取验证码
    @BindView(R.id.verification_code_get)
    TextView verificationCodeGet;
    //发送验证码的手机号
    private String phone;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new RegisterPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void loadData() {
    }

    @OnClick({
            R.id.verification_code_get,
            R.id.submit_register
    })
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.verification_code_get:
                phone = userPhone.getText().toString();
                if (Utils.isMobileNO(phone)) {
                    presenter.requestMobilePhone(phone);
                } else {
                    ToastUtils.showShort(getActivity(), "请输入正确手机号");
                }
                break;
            case R.id.submit_register:
                String passwordStr = password.getText().toString();
                String verification = verificationCode.getText().toString();

                if (!TextUtils.isEmpty(passwordStr) && passwordStr.length() > 5 && Utils.isMobileNO(phone) && !TextUtils.isEmpty(verification)) {
                    presenter.register(phone, passwordStr, verification);
                } else {
                    ToastUtils.showShort(getActivity(), "请输入规范密码");
                }
                break;
        }
    }

    @Override
    public void showVerificationCode() {
        /** 倒计时60秒，一次1秒 */
        CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
                verificationCodeGet.setText("还剩" + millisUntilFinished / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                verificationCodeGet.setText("获取验证码");
            }
        }.start();
    }

    @Override
    public void registerSuccess() {
        ActivityGoManager.goLogIn(getActivity());
        onBackPressed();
    }
}