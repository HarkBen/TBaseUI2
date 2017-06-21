package rango.ui.function;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.rg.ui.baseactivity.TBaseFragmentGroupActivity;

import rango.tbaseui.R;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----含toolbar的侧滑一------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class SlidingMenuAct1 extends TBaseFragmentGroupActivity {

    @Override
    public void onLayoutloaded() {
        removeTitleBar();
        reSetStatusColorRes(R.color.mohei_tp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("toolBar下方滑动");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public int fragmentContainerId() {
        return R.id.asl_frameLayout;
    }

    @Override
    public View setLayoutView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_slidinglayout,null);
    }

    /**
     * 避免右滑动返回 与侧滑冲突
     * @return
     */
    @Override
    public boolean openSwipeBack() {
        return false;
    }
}
