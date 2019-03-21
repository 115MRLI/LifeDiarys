package com.lifediary.manager;

import android.Manifest;
import android.app.Activity;

import com.lifediary.manager.base.BasePermissionManager;
import com.lifediary.manager.base.PermissionListener;


/**
 * 权限管理
 */
public class PermissionManager extends BasePermissionManager {
    //必须权限
    private final static String[] mustPermission = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.RECEIVE_BOOT_COMPLETED
    };

    /**
     * 检查必备权限
     *
     * @param activity
     * @param listener
     */
    public static void checkMust(Activity activity, PermissionListener listener) {
        checkMultiple(activity, mustPermission, listener);
    }
}