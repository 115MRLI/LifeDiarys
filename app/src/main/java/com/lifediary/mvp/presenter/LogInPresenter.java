package com.lifediary.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.lifediary.mvp.contract.LogInContract;

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
}