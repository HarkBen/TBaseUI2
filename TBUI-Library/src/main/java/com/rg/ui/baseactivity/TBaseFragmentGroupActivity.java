package com.rg.ui.baseactivity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.rg.ui.basefragment.TBaseFragment;

import java.io.Serializable;

/**
 * 切换Fragment的Activity
 * author rango 2016-06-16 13:43:31
 */
public abstract class TBaseFragmentGroupActivity extends TBaseActivity {
    private TBaseFragment showFragment;

    public final static String BEAN = "Serializable_BEAN";
    public final static String STRING = "Serializable_STRING";

    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        super.setContentLayout(setLayoutView());
        onLayoutloaded();
    }

    /**
     * 在布局加载完成以后调用
     */
    public abstract void onLayoutloaded();

    /**
     * @return FrameLayout  view id
     */
    public abstract int fragmentContainerId();

    /**
     * @return layout View
     */
    public abstract View setLayoutView();

    public TBaseFragment switchFragment(Class<? extends TBaseFragment> clazz) {
        return switchFragment(fragmentContainerId(), clazz, null, null);
    }

    public TBaseFragment switchFragment(Class<? extends TBaseFragment> clazz, Serializable s) {
        return switchFragment(fragmentContainerId(), clazz, s, null);
    }

    public TBaseFragment switchFragment(Class<? extends TBaseFragment> clazz, Serializable s, String str) {
        return switchFragment(fragmentContainerId(), clazz, s, str);
    }

    public TBaseFragment switchFragment(Class<? extends TBaseFragment> clazz, String str) {
        return switchFragment(fragmentContainerId(), clazz, null, str);
    }

    public TBaseFragment findFragmentByTag(Class clazz) {
        FragmentManager fm = getSupportFragmentManager();
        return (TBaseFragment) fm.findFragmentByTag(clazz.getName());
    }

    /**
     * @param frameId frameLayout container
     * @param clazz   position fragment
     * @return current show fragment
     */
    private TBaseFragment switchFragment(int frameId, Class<? extends TBaseFragment> clazz, Serializable s, String str) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle bundle = null;
        TBaseFragment currentFragment = (TBaseFragment) fm.findFragmentByTag(clazz.getName());
        if (null == currentFragment) {
            try {
                currentFragment = clazz.newInstance();
                bundle = new Bundle();
                if (null != s) {
                    bundle.putSerializable(BEAN, s);
                }
                if (str != null) {
                    bundle.putString(STRING, str);
                }
                currentFragment.setArguments(bundle);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        else {
//            currentFragment.setArguments(bundle);
//        }
        //如果选择的fragment 不是第一个也不是正在显示的 则隐藏正在显示的
        if (null != showFragment && showFragment != currentFragment) {
            ft.hide(showFragment);
        }
        //对选择的fragment 处理
        if (!currentFragment.isAdded()) {
            ft.add(frameId, currentFragment, clazz.getName());
        } else {
            ft.show(currentFragment);
        }
        ft.commitAllowingStateLoss();
        showFragment = currentFragment;
        return currentFragment;
    }

    /**
     * 隐藏一个Fragment
     *
     * @param clazz
     */
    public void hideFragment(Class<? extends TBaseFragment> clazz) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TBaseFragment currentFragment = (TBaseFragment) fm.findFragmentByTag(clazz.getName());
        if (!currentFragment.isHidden()) {
            ft.hide(currentFragment);
            ft.commit();
        }
    }


    /**
     * 移除一个Fragment
     *
     * @param clazz
     */
    public void removeFragment(Class<? extends TBaseFragment> clazz) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        TBaseFragment currentFragment = (TBaseFragment) fm.findFragmentByTag(clazz.getName());
        ft.remove(currentFragment);
        ft.commit();
    }

    @Override
    public void startLoadAnim() {
        super.startLoadAnim();
    }

    @Override
    public void stopLoadAnim() {
        super.stopLoadAnim();
    }


    public void postbundle(Bundle T) {
        if (showFragment.isAdded()) {
            Bundle bundle = new Bundle();
            bundle.putAll(T);
            showFragment.setArguments(bundle);
        }
    }

    public void postArguments(String tag, Serializable serializable) {
        if (showFragment.isAdded()) {
            Bundle bundle = new Bundle();
            bundle.putSerializable(tag, serializable);
            showFragment.setArguments(bundle);
        }
    }


}
