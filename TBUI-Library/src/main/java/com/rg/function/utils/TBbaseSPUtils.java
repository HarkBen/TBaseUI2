package com.rg.function.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.ColorInt;
import android.support.annotation.StyleRes;

/**
 *仅用于保存主题 或 语言配置
 */
public class TBbaseSPUtils {
    public final static String TAG = "SharedPreferencesUtils";

    public final static String THEME_ID = "theme_id";
    public final static String THEME_COLOR = "theme_color";

    public static void saveInt(Context con, String key, int value) {
        SharedPreferences.Editor sp = con.getSharedPreferences(TAG,
                Context.MODE_PRIVATE).edit();
        sp.putInt(key, value).commit();
    }


    public static int getInt(Context con, String key) {
        SharedPreferences sp = con.getSharedPreferences(TAG,
                Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }

    public static void initTeme(Context con, @StyleRes int styleId, @ColorInt int color) {
        TBbaseSPUtils.saveInt(con, TBbaseSPUtils.THEME_ID, styleId);
        TBbaseSPUtils.saveInt(con, TBbaseSPUtils.THEME_COLOR, color);
    }


}
