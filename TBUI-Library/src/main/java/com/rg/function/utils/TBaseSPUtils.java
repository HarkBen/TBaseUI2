package com.rg.function.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

/**
 *仅用于保存主题 或 语言配置
 */
public class TBaseSPUtils {
    public final static String TAG = "SharedPreferencesUtils";

    public final static String THEME_ID = "theme_id";
    public final static String THEME_COLOR = "theme_color";

    public static void saveInt(@NonNull Context con, String key, int value) {
        SharedPreferences.Editor sp = con.getSharedPreferences(TAG,
                Context.MODE_PRIVATE).edit();
        sp.putInt(key, value).commit();
    }


    public static int getInt(@NonNull Context con, String key) {
        SharedPreferences sp = con.getSharedPreferences(TAG,
                Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }

    public static void initTeme(@NonNull Context con, @StyleRes int styleId, @ColorInt int color) {
        TBaseSPUtils.saveInt(con, TBaseSPUtils.THEME_ID, styleId);
        TBaseSPUtils.saveInt(con, TBaseSPUtils.THEME_COLOR, color);
    }


}
