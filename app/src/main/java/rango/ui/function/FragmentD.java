package rango.ui.function;

import android.support.annotation.ColorInt;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class FragmentD extends FragmentA {

    @Override
    public @ColorInt int getBgColor() {

        return getTBaseFGActivity().getResources().getColor(R.color.testModelgreen);
    }

    @Override
    public String getTitle(){
        return "FragmentD";
    }

}
