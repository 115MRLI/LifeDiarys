package com.lifediary.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.lifediary.common.Constants;
import com.lifediary.manager.base.BaseCacheManager;


/**
 * 常用参数缓存管理
 */
public class ParamsCacheManager extends BaseCacheManager {
    @SuppressLint("StaticFieldLeak")
    private static ParamsCacheManager manager;
    private Context context;
    //当前使用的语言
    private String currentLang = "";

    private ParamsCacheManager(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    /**
     * 获取缓存目录名
     *
     * @return
     */
    @Override
    public String getCacheName() {
        return Constants.CACHE_PATH;
    }

    /**
     * 获取单利
     *
     * @param context
     * @return
     */
    public static ParamsCacheManager get(@NonNull Context context) {
        if (null == manager) {
            manager = new ParamsCacheManager(context);
        }
        return manager;
    }

    /**
     * 获取当前语言 en_us vi zh_cn
     *
     * @param context
     * @return
     */
    public static String getCurrentLang(@NonNull Context context) {
        return get(context).getCurrentLang();
    }

    /**
     * 获取当前语言
     *
     * @return
     */
    private String getCurrentLang() {
        if (TextUtils.isEmpty(currentLang)) {
            String systemLang = context.getResources()
                    .getConfiguration().locale.getCountry();
            switch (systemLang) {
                case "US":
                    this.currentLang = "en_us";
                    break;
                case "TH":
                    this.currentLang = "vi";
                    break;
                default:
                    this.currentLang = "zh_cn";
                    break;
            }
        }
        return currentLang;
    }
}