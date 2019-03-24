package com.lifediary;



import android.app.Application;

import cn.bmob.v3.Bmob;


public class LifeDiaryApplication extends Application {
    //除非特殊情况，否则尽量少用
    private static LifeDiaryApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "a0997a556c4b71b7fd38ccc3018f5a16");
    }
    /**
     * 获取application实例
     *
     * @return
     */
    public static LifeDiaryApplication get() {
        return application;
    }
}
