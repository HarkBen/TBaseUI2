package rango.ui.function;

import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class FragmentC extends FragmentA {

    @Override
    public @ColorInt int getBgColor() {
        return getTBaseFGActivity().getResources().getColor(R.color.colorPrimaryDark);
    }
    @NonNull
    @Override
    public String getTitle(){
        return "FragmentC";
    }
}
