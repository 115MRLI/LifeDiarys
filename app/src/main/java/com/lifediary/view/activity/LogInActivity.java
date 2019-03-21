package com.lifediary.view.activity;

import android.os.Bundle;

import com.lifediary.R;
import com.lifediary.mvp.contract.LogInContract;
import com.lifediary.mvp.presenter.LogInPresenter;

public class LogInActivity extends BaseActivity implements LogInContract.View {
    private LogInContract.Presenter presenter;

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
}