package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.lifediary.mvp.contract.MainContract;

public class MainPresenter implements MainContract.Presenter {
    private Context context;
    private MainContract.View view;

    public MainPresenter(Context context, MainContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }
}