package com.rg.ui.basefragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;

import com.rg.ui.baseactivity.TBaseFragmentGroupActivity;
import com.rg.ui.baseexception.NotFindFGActivityException;


/**
 * from support v4 packages
 * Created by rango on 2016/7/4.
 */
public abstract class TBaseFragment extends Fragment {
    private TBaseFragmentGroupActivity fgActivity;

    /**
     * 根布局
     * @param activity
     */
    private LinearLayout rootView;

    /**
     * 内容布局容器
     * @param activity
     */
    private ViewGroup contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
           rootView = new LinearLayout(this.getActivity());
           rootView.setOrientation(LinearLayout.VERTICAL);
           contentView = new RelativeLayout(this.getActivity());
        LayoutParams params =
                new LayoutParams(LayoutParams.MATCH_PARENT
                ,LayoutParams.MATCH_PARENT);
            contentView.setLayoutParams(params);
            rootView.addView(contentView);
        onInitLayout(inflater,container,savedInstanceState);
        return rootView;
    }

    /**
     * 提供给子类加载器
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    public abstract  void onInitLayout(LayoutInflater inflater, ViewGroup container,
                                       Bundle savedInstanceState);

    /**
     * 设置子类布局
     * @param view
     */
    public void setContentLayout(@Nullable View view){
        if(null != contentView && null != view){
            if(contentView.getChildCount() > 0 ){
                contentView.removeAllViews();
            }
            view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            contentView.addView(view);
        }
    }


    //防止重复引用同一个Activity  Fragment重叠
    @Override
    public void onAttach(Activity activity) {
        if(activity instanceof  TBaseFragmentGroupActivity){
            fgActivity = (TBaseFragmentGroupActivity) activity;
        }else{
            try {
                throw new NotFindFGActivityException();
            } catch (NotFindFGActivityException e) {
                e.printStackTrace();
            }
        }
        super.onAttach(activity);
    }

    @NonNull
    public TBaseFragmentGroupActivity getTBaseFGActivity() {
        Activity activity = getActivity();
        if(activity instanceof  TBaseFragmentGroupActivity){
            return (TBaseFragmentGroupActivity) activity;
        }else{
            throw new ClassCastException("this Activity can't not cast to TBaseFragmentGroupActivity!");
        }

    }

    public void startLoadAnim(){
        fgActivity.startLoadAnim();
    }

    public void stopLoadAnim(){
        fgActivity.stopLoadAnim();
    }


}
