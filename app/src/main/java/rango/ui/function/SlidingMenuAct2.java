package rango.ui.function;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.rg.ui.baseactivity.TbaseSlidingMenuActivity;
import com.rg.ui.basefragment.TBaseFragment;
import com.rg.ui.basetitle.TbaseTitleBar;

import rango.tbaseui.R;

/**
 * author  rango
 * time  2016/8/26.
 */
public class SlidingMenuAct2 extends TbaseSlidingMenuActivity {
    private View menu1,menu2;
    @Override
    public void onLayoutInitialized() {
        reSetStatusColorRes(R.color.colorAccent);
        getTitleBar().setBackgroundResource(R.color.colorAccent);
        getTitleBar().setText("TitleBar 侧滑菜单", TbaseTitleBar.POSITION_CENTER);
        getTitleBar().setButtonBackGroundDrawableRes(R.drawable.ic_menu_white_36dp, TbaseTitleBar.POSITION_LEFT)
                .setOnClickListener(v->  openMenu());

        menu1 = findViewById(R.id.menu_item1);
        menu2 = findViewById(R.id.menu_item2);
        menu1.setOnClickListener(v-> {
            switchFragment(FragmentA.class);
            closeMenu();
        });
        menu2.setOnClickListener(v-> {
            switchFragment(FragmentB.class);
            closeMenu();
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
