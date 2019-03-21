package com.lifediary.manager;

import android.app.Activity;

import com.lifediary.util.ActivityGo;
import com.lifediary.view.activity.LogInActivity;
import com.lifediary.view.activity.MainActivity;
import com.lifediary.view.activity.RegisterActivity;


/**
 * 页面跳转管理
 */
public class ActivityGoManager {
    /**
     * 跳转到首页
     *
     * @param activity
     */
    public static void goMainPage(Activity activity) {
        ActivityGo.build(activity, MainActivity.class).go();
    }

    /**
     * 跳转到注册
     *
     * @param activity
     */
    public static void goRegister(Activity activity) {
        ActivityGo.build(activity, RegisterActivity.class).go();
    }

    /**
     * 跳转登录
     *
     * @param activity
     */
    public static void goLogIn(Activity activity) {
        ActivityGo.build(activity, LogInActivity.class).go();
    }
}