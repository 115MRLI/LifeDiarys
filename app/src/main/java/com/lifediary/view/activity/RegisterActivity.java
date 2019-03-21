package com.lifediary.view.activity;

import android.os.Bundle;

import com.lifediary.R;
import com.lifediary.mvp.contract.RegisterContract;
import com.lifediary.mvp.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {
    private RegisterContract.Presenter presenter;

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
}