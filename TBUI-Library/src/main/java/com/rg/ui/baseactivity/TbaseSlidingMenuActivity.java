package com.rg.ui.baseactivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.rg.function.customview.CustomDrawLayout;
import com.rg.ui.R;
import com.rg.ui.basetitle.TbaseTitleBar;

/**
 * author  z.sw
 * time  2016/8/25.
 * email  zhusw@visionet.com.cn
 * Description-侧滑的Activity 直接继承使用
 */
public abstract class TbaseSlidingMenuActivity extends  TBaseFragmentGroupActivity{

    /**
     * 菜单控制器
     */
    private CustomDrawLayout menuSwitch;
    /**
     * 菜单布局容器
     */
    private RelativeLayout menuGroup;

    /**
     * TbaseTitleBar
     */
    private TbaseTitleBar titleBar;



    @Override
    public void onLayoutloaded() {
        initView();
        onLayoutInitialized();
    }

    private void initView(){
        removeTitleBar();
        menuSwitch = (CustomDrawLayout) findViewById(R.id.tsl_drawer_layout);
        menuGroup = (RelativeLayout) findViewById(R.id.tsl_menuLayout);
        titleBar = (TbaseTitleBar) findViewById(R.id.tsl_titleBar);
        //装载菜单布局
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        if(menuGroup.getChildCount() >0) menuGroup.removeAllViews();
        menuGroup.addView(setMenuView(),0,params);


    }

    public void closeMenu(){
        menuSwitch.closeDrawers();
    }

    public void openMenu(){
        menuSwitch.openDrawer(Gravity.LEFT);
    }



    /**
     * 提供一个TbaseTitleBar,和TbaseActivity中一致
     * @return
     */
    private TbaseTitleBar getSlidingTitleBar(){
        return titleBar;
    }

    /**
     * 提供初始化变量的抽象方法
     */
    public abstract  void onLayoutInitialized();

    public abstract View setMenuView();

    @Override
    public int fragmentContainerId() {
        return R.id.tsl_frameLayout;
    }

    @Override
    public View setLayoutView() {
        return LayoutInflater.from(this).inflate(R.layout.tbase_slidingmenu_layout,null);
    }


    /**
     * tbaseAct的title
     * @return
     */
    @Override
    public TbaseTitleBar getTitleBar() {
        return getSlidingTitleBar();
    }


}
