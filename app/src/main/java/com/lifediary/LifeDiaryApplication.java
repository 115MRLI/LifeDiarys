package com.lifediary;



import android.app.Application;

import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;

public class LifeDiaryApplication extends Application {
    //除非特殊情况，否则尽量少用
    private static LifeDiaryApplication application;

    @Override
    public void onCreate() {
        super.onCreate();

        // 在 AVOSCloud.initialize 之前调用
        AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"LwK6u0GzOsgYISOPSA2RJavm-gzGzoHsz","Bml3LHmELsSN0SbWJkXAnabc");
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
