package com.lifediary.view.activity;

import android.os.Bundle;

import com.lifediary.R;
import com.lifediary.mvp.contract.MainContract;
import com.lifediary.mvp.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainContract.View {
    private MainContract.Presenter presenter;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new MainPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void loadData() {
    }
}