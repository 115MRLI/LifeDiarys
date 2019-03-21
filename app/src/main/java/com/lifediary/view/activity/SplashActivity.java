package com.lifediary.view.activity;

import android.os.Bundle;

import com.lifediary.R;
import com.lifediary.manager.ActivityGoManager;
import com.lifediary.manager.PermissionManager;
import com.lifediary.mvp.contract.SplashContract;
import com.lifediary.mvp.presenter.SplashPresenter;

public class SplashActivity extends BaseActivity implements SplashContract.View {
    private SplashContract.Presenter presenter;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new SplashPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void loadData() {
        //检查必备权限
        PermissionManager.checkMust(getActivity(), allGranted -> {
            //跳转到首页
            ActivityGoManager.goLogIn(getActivity());
            onBackPressed();
        });
    }
}