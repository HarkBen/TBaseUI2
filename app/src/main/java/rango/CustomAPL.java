package rango;

import android.app.Application;
import android.util.Log;

import com.rg.function.utils.TBbaseSPUtils;

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
        TBbaseSPUtils.initTeme(this, R.style.AppTheme,getResources()
                .getColor(R.color.colorAccent));
        Log.d("CustomAPL","color="+getResources()
                .getColor(R.color.colorAccent));
    }

}
