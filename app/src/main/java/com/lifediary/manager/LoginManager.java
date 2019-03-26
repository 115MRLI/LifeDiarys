package com.lifediary.manager;

import android.content.Context;

import com.lifediary.manager.base.BaseCacheManager;
import com.lifediary.model.User;

/**
 * 登录管理
 */
public class LoginManager extends BaseCacheManager {
    private final static String KEY_LOGIN_INFO = "keyLoginInfo";

    private static LoginManager manager;

    private User user;

    public LoginManager(Context context) {
        super(context);
    }


    /**
     * 获取单利
     *
     * @param context
     * @return
     */
    public static LoginManager get(Context context) {
        if (null == manager) {
            manager = new LoginManager(context);
        }
        return manager;
    }

    /**
     * 判断是否存在登录信息
     *
     * @param context
     * @return
     */
    public static boolean hasLoginInfo(Context context) {
        return null != get(context).getUserInfo();
    }

    /**
     * 存储用户信息
     *
     * @param model
     */
    public void setupUserInfo(User model) {
        this.user = model;
        put(KEY_LOGIN_INFO, model);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public User getUserInfo() {
        if (null == user) {
            this.user = getSerializable(KEY_LOGIN_INFO);
        }
        return this.user;
    }

    /**
     * 清空用户信息
     */
    public void clearUserInfo() {
        this.user = null;
        deleteByKey(KEY_LOGIN_INFO);
    }
}