package rango;

import android.app.Application;

import com.rg.function.utils.TBaseManager;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class CustomAPL extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TBaseManager.init(this,R.style.AppTheme,getResources()
                .getColor(R.color.colorAccent));
    }

}
