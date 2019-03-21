package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.lifediary.mvp.contract.RegisterContract;

public class RegisterPresenter implements RegisterContract.Presenter {
    private Context context;
    private RegisterContract.View view;

    public RegisterPresenter(Context context, RegisterContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }
}