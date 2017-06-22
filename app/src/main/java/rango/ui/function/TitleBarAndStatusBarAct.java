package rango.ui.function;

import android.os.Bundle;

import com.rg.ui.baseactivity.TBaseActivity;
import com.rg.ui.basetitle.TbaseTitleBar;

import rango.tbaseui.R;

/**
 * Create on 2017/6/22.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/22
 */
public class TitleBarAndStatusBarAct extends TBaseActivity {

    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        reSetStatusColorRes(R.color.testmodelblue);
        getTitleBar().setTitleText("颜色默认跟随初始化配置");
        getTitleBar().setBackgroundResource(R.color.testmodelblue);
        getTitleBar().setButtonBackGroundDrawableRes(R.drawable.ic_arrow_back_white_36dp, TbaseTitleBar.POSITION_LEFT);
        getTitleBar().getRightBtn().setButtonDrawable(R.drawable.ic_flag_white_24dp);
        getTitleBar().getRightBtn().setText("标记");

    }

}
