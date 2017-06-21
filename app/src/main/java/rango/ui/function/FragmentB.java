package rango.ui.function;

import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rg.ui.basefragment.TBaseFragment;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class FragmentB extends FragmentA {

    @Override
    public @ColorInt int getBgColor() {
        return getTBaseFGActivity().getResources().getColor(R.color.testModelcpink);
    }
    @Override
    public String getTitle(){
        return "FragmentB";
    }
}
