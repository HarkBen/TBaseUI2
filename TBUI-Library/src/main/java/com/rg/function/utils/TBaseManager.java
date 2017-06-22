package com.rg.function.utils;

import android.app.Application;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.liulishuo.filedownloader.FileDownloader;
import com.rg.function.version.UpdateVersionDialog;
import com.rg.function.version.UpdateVersionInfo;

/**
 * Create on 2017/6/22.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/22
 */
public class TBaseManager {
    private static UpdateVersionDialog updateVersionDialog = null;

    public static void init(Application context, @StyleRes int styleId, @ColorInt
         int color) {
        FileDownloader.init(context);
        TBaseSPUtils.initTeme(context,styleId,color);
    }

    public static void showUpdateVersionDialog(@NonNull Context context, @NonNull UpdateVersionInfo versionBean, UpdateVersionDialog.VersionCallback versionCallback){
        if(null  == updateVersionDialog){
            updateVersionDialog = UpdateVersionDialog.create(context,versionBean,versionCallback);
        }
        updateVersionDialog.show();
    }

}
