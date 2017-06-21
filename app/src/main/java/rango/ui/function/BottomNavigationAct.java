package rango.ui.function;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.rg.ui.baseactivity.TBaseFragmentGroupActivity;
import com.rg.ui.basefragment.TBaseFragment;

import java.util.HashMap;

import rango.tbaseui.R;

/**
 * Created by Administrator on 2016/7/4.
 */
public class BottomNavigationAct extends TBaseFragmentGroupActivity {
    //返回 将用来显示fragment的 frameLayout id !! id
    @Override
    public int fragmentContainerId() {
        return R.id.bn_buttomNaviagte_framelayout;
    }

    @Override
    public View setLayoutView() {
        return LayoutInflater.from(this).inflate(R.layout.act_buttomnavigate,null);
    }

    @Override
    public void onLayoutloaded() {
       final HashMap<Integer,Class<?extends TBaseFragment>> map = new HashMap<>();
        map.put(0,FragmentA.class);
        map.put(1,FragmentB.class);
        map.put(2,FragmentC.class);
        map.put(3,FragmentD.class);

      final AHBottomNavigation ahBottomNavigation = (AHBottomNavigation) findViewById(R.id.bn_bottomNaviagte);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Plan",0);
        item1.setColor(getResources().getColor(R.color.testmodelblue));
        item1.setTitle("Plan");
        item1.setDrawable(R.drawable.ic_import_contacts_white_24dp);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Do",0);
        item2.setColor(getResources().getColor(R.color.testModelcpink));
        item2.setDrawable(R.drawable.ic_business_white_24dp);

        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Rest",R.drawable.ic_flag_white_24dp);
        item3.setColor(getResources().getColor(R.color.colorPrimaryDark));

        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Dogain",0);
        item4.setColor(getResources().getColor(R.color.testModelgreen));
        item4.setDrawable(R.drawable.ic_business_white_24dp);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);
// Set background color
        ahBottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.testmodelblue));
       //activity Size / inactivity size
        ahBottomNavigation.setTitleTextSize(25.0F,19.0F);

        //是否始终显示titleText
        ahBottomNavigation.setForceTitlesDisplay(true);
//
//        //设置按钮高亮色 包括文字和icon
//        ahBottomNavigation.setAccentColor(Color.parseColor("#ffffff"));
//        //设置按钮默认色 包括文字和icon
//        ahBottomNavigation.setInactiveColor(getResources().getColor(R.color.testmodelf));

// 使用彩色导航循环显示效果 (设置此属性则单独按钮高亮颜色check无效)
        ahBottomNavigation.setColored(true);

        ahBottomNavigation.restoreBottomNavigation(true);
        ahBottomNavigation.setCurrentItem(0);
        switchFragment(FragmentA.class);
        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                    switchFragment(map.get(position));
                return true;
            }
        });
    }
}
