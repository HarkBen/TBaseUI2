package rango.ui.function;

import android.os.Bundle;
import android.view.View;

import com.rg.ui.baseactivity.TBaseActivity;
import com.rg.ui.basetitle.TbaseTitleBar;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class SwipeBackAct extends TBaseActivity {
    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        getTitleBar().setText("边缘右滑返回", TbaseTitleBar.POSITION_CENTER);
        getTitleBar().setButtonBackGroundDrawableRes(R.drawable.ic_arrow_back_white_36dp,TbaseTitleBar.POSITION_LEFT)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
    }

    /**
     * 默认返回 true
     * @return 开启 true  \关闭 false
     */
    @Override
    public boolean openSwipeBack() {
        return super.openSwipeBack();
    }
}
