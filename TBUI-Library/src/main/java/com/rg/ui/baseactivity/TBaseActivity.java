package com.rg.ui.baseactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.victor.loading.rotate.RotateLoading;
import com.rg.ui.R;
import com.rg.ui.basetitle.TbaseTitleBar;
import com.rg.function.customview.swipebaklayout.SwipeBackActivity;
import com.rg.function.utils.TBbaseSPUtils;

/**
 * BaseActivity
 * loadBaseLayout
 * loadBaseTitleBar
 * author zhusw 2016-06-16 13:43:31
 */
public abstract class TBaseActivity extends SwipeBackActivity {
    /**
     * rootLayout
     */
    private LinearLayout rootLayout;
    /**
     * use to  loading childActivityLayout
     */
    private LinearLayout childContentLayout;

    private LinearLayout loadingLayout;

    //    private ProgressBar loadAnimationImageView;
    private RotateLoading rotateLoading;

    /**
     * onLoading anmination
     */
    private AnimationDrawable animationDrawable;

    private TbaseTitleBar titleBar;

    /**
     * 是否添加了statusBar
     */
    private boolean isAddStatus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initSystemSet();
        initRootLayout();
        onLayoutLoaded(savedInstanceState);
    }

    public boolean openSwipeBack() {
        return true;
    }

    private void initSystemSet() {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        //是否添加过 statusBar 默认为 false
        isAddStatus = false;
        //设置状态栏透明
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //初始化侧滑范围
        getSwipeBackLayout().setEdgeSize(40);
        getSwipeBackLayout().setEnableGesture(openSwipeBack());
        //设置主题
        if (TBbaseSPUtils.getInt(this, TBbaseSPUtils.THEME_ID) != 0) {
            setTheme(TBbaseSPUtils.getInt(this, TBbaseSPUtils.THEME_ID));
        }
    }


    /**
     * 为子类提供抽象 设置子类布局
     */
    public abstract void onLayoutLoaded(Bundle savedInstanceState);


    private void initRootLayout() {
        View rootView = LayoutInflater.from(this).inflate(R.layout.tbase_activity_layout, null);
        rootLayout = (LinearLayout) rootView.findViewById(R.id.tbase_activity_rootlayout);
        childContentLayout = (LinearLayout) rootView.findViewById(
                R.id.tbase_activity_childContentLayout);
        titleBar = (TbaseTitleBar) rootView.findViewById(R.id.tbase_activity_titleBar);
        loadingLayout = (LinearLayout) rootView.findViewById(R.id.tbase_activity_loadingLayout);
        rotateLoading = (RotateLoading) rootView.findViewById(
                R.id.tbasr_activity_loadingImage);
        rotateLoading.setLoadingColor(getThemeColor());
        titleBar.setBackgroundColorInt(getThemeColor());
        addSetStatus(getThemeColor());
        setContentView(rootLayout);
    }


    public  TbaseTitleBar getTitleBar() {
        if (null != titleBar) {
            return titleBar;
        } else {
            throw new NullPointerException("TbaseTitle has been deleted!");
        }
    }


    public final void hiddenTitleBar() {
        if (null != titleBar) titleBar.setVisibility(View.GONE);
    }


    public final void showTitleBar() {
        if (null != titleBar) titleBar.setVisibility(View.VISIBLE);
    }


    /**
     * 在当前Activity删除以后 将不再提供重新设置
     * 避免与statusBar重叠
     */
    public final void removeTitleBar() {
        if (null != titleBar) {
            rootLayout.removeView(titleBar);
            titleBar = null;
        }
    }

    /**
     * 启用重绘
     */
    public final void switchTheme(@StyleRes int styleId, @ColorInt int color) {
        TBbaseSPUtils.saveInt(this, TBbaseSPUtils.THEME_ID, styleId);
        TBbaseSPUtils.saveInt(this, TBbaseSPUtils.THEME_COLOR, color);
        Intent intent = getIntent();
        overridePendingTransition(0, 0);//不设置进入退出动画
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }

    private int getThemeColor() {
        int color = TBbaseSPUtils.getInt(this, TBbaseSPUtils.THEME_COLOR);
        if (color == -1) {
            color = getResources().getColor(R.color.tbaseColorcolorNormal_status);
        }
        Log.d("getThemeColor","color="+color);
        return color;
    }

    protected final void reSetStatusColorRes(@ColorRes int id) {
        if (isAddStatus) {
            reSetStatusColor(getResources().getColor(id));
        }
    }
    protected final void reSetStatusColor(@ColorInt int id) {
        if (isAddStatus) {
            rootLayout.getChildAt(0).setBackgroundColor(id);
        }
    }


    /**
     * @param ff 状态栏颜透明度
     */
    protected void reSetStatusAlpha(float ff) {
        if (isAddStatus) rootLayout.getChildAt(0).setAlpha(ff);
    }


    /**
     * 从根布局删除 statusbar
     * 在子类中 就需要在当前 activity的布局文件中声明 firstSystemWindows  true
     * 来指向拉伸到状态栏的view
     */
    protected final void removeStatusBar() {
        if (isAddStatus) {
            rootLayout.removeViewAt(0);
            isAddStatus = false;
        }
    }


    /**
     * 添加 statusBar
     * 如果没有添加 statusBar则新建并添加到rootLayout
     */
    public final void addSetStatus(@ColorInt int color) {
        if (!isAddStatus) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                addStatusToRootLayout(this, color);
            }
        }

    }


    /**
     * 生成一个和状态栏大小相同的矩形条
     * * @param activity 需要设置的activity
     * * @param color 状态栏颜色值
     *
     * @return 状态栏矩形条
     */
    private View createStatusView(Activity activity, @ColorInt int color) {
        // 获得状态栏高度
        int resourceId = activity.getResources()
                .getIdentifier("status_bar_height", "dimen", "android");
        int statusBarHeight = activity.getResources().getDimensionPixelSize(resourceId);

        // 绘制一个和状态栏一样高的矩形
        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }


    /**
     * 设置状态栏颜色 * * @param activity 需要设置的activity * @param color 状态栏颜色值
     */
    private void addStatusToRootLayout(Activity activity, @ColorInt int color) {
        // 生成一个状态栏大小的矩形
        View statusView = createStatusView(activity, color);
        statusView.setFitsSystemWindows(true);
        // 添加到 rootLayout最顶层
        rootLayout.addView(statusView, 0);
        isAddStatus = true;

    }


    /**
     * 设置当前打开的Activity的布局
     */
    public final void setContentLayout(View view) {
        childContentLayout.addView(view, childContentLayout.getChildCount());
    }
    public final void setContentLayout(@LayoutRes int layoutId){
        View view = LayoutInflater.from(this).inflate(layoutId, null);
        setContentLayout(view);
    }

    private void showLoadAnimation() {
        if (!rotateLoading.isStart()) {
            rotateLoading.start();
        }
        if (childContentLayout.getVisibility() == View.VISIBLE) {
            childContentLayout.setVisibility(View.GONE);
            loadingLayout.setVisibility(View.VISIBLE);
        }
    }


    private final void dismissLoadAnimation() {
        if (rotateLoading.isStart()) {
            rotateLoading.stop();
        }
        if (childContentLayout.getVisibility() == View.GONE) {
            rotateLoading.postDelayed(new Runnable() {
                @Override
                public void run() {
                    childContentLayout.setVisibility(View.VISIBLE);
                    loadingLayout.setVisibility(View.GONE);
                }
            }, 900);
        }

    }


    public void startLoadAnim() {
        showLoadAnimation();
    }

    public void stopLoadAnim() {
        dismissLoadAnimation();
    }

}
