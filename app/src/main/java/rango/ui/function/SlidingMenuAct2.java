package rango.ui.function;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.rg.ui.baseactivity.TbaseSlidingMenuActivity;
import com.rg.ui.basetitle.TbaseTitleBar;

import rango.tbaseui.R;

/**
 * author  rango
 * time  2016/8/26.
 */
public class SlidingMenuAct2 extends TbaseSlidingMenuActivity {

    @Override
    public void onLayoutInitialized() {
        getTitleBar().setBackgroundResource(R.color.colorAccent);
        getTitleBar().setText("TitleBar 侧滑菜单", TbaseTitleBar.POSITION_CENTER)
        .setTextColor(Color.WHITE);
        getTitleBar().setButtonDrawableRes(R.drawable.ic_menu_white_36dp, TbaseTitleBar.POSITION_LEFT)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openMenu();
                    }
                });

    }

    @Override
    public View setMenuView() {
        return LayoutInflater.from(this).inflate(R.layout.menu_layout, null);
    }

    @Override
    public boolean openSwipeBack() {
        return false;
    }
}
