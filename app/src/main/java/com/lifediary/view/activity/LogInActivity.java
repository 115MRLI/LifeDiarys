package com.lifediary.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lifediary.R;
import com.lifediary.manager.ActivityGoManager;
import com.lifediary.mvp.contract.LogInContract;
import com.lifediary.mvp.presenter.LogInPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class LogInActivity extends BaseActivity implements LogInContract.View {
    private LogInContract.Presenter presenter;
    //用户名
    @BindView(R.id.user_name)
    EditText userName;
    //用户密码
    @BindView(R.id.password)
    EditText password;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new LogInPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_log_in);
    }

    @Override
    protected void loadData() {
    }

    @OnClick({
            R.id.register,
            R.id.log_on
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                ActivityGoManager.goRegister(getActivity());
                break;
            case R.id.log_on:
                String account = userName.getText().toString();
                String passw = password.getText().toString();
                presenter.loginByAccount(account, passw);
                break;
        }
    }

    @Override
    public void loginSuccess() {
        ActivityGoManager.goMainPage(getActivity());
        onBackPressed();
    }
}