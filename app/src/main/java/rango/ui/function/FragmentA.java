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
public class FragmentA extends TBaseFragment {

    private View view;
    private TextView tvName;

    @Override
    public void onInitLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        setContentLayout(view);
        tvName = (TextView) view.findViewById(R.id.fa_tv_Name);
        tvName.setText(getTitle());
        view.setBackgroundColor(getBgColor());
    }
    public @ColorInt int getBgColor() {
        return getTBaseFGActivity().getResources().getColor(R.color.testmodelblue);
    }
    public String getTitle(){
        return "FragmentA";
    }
}
