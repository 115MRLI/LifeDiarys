package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.lifediary.mvp.contract.SplashContract;

public class SplashPresenter implements SplashContract.Presenter {
    private Context context;
    private SplashContract.View view;

    public SplashPresenter(Context context, SplashContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }
}