package rango.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rg.ui.baseactivity.TBaseActivity;
import com.rg.ui.basetitle.TbaseTitleBar;

import java.util.ArrayList;
import java.util.List;

import rango.tbaseui.R;
import rango.ui.function.BottomNavigationAct;
import rango.ui.function.FunctionAdapter;
import rango.ui.function.FunctionListBean;
import rango.ui.function.SlidingMenuAct1;
import rango.ui.function.SlidingMenuAct2;
import rango.ui.function.SwipeBackAct;
import rango.ui.function.UpdateVersionAct;

public class MainActivity extends TBaseActivity {

    private RecyclerView recyclerView;
    private FunctionAdapter adapter;
    private List<FunctionListBean> datas;

    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        setContentLayout(R.layout.act_functionlist);
        //设置状态栏颜色
        reSetStatusColorRes(R.color.colorAccent);
        //设置 titleBar颜色
        getTitleBar().setBackgroundResource(R.color.colorAccent);
        getTitleBar().setText("主页", TbaseTitleBar.POSITION_CENTER)
                .setTextColor(Color.WHITE);
        startLoadAnim();
        initData();
        initView();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stopLoadAnim();
            }
        },2000);

    }

    private void initData() {
        datas = new ArrayList<>();
        adapter = new FunctionAdapter(datas,this);
        datas.add(new FunctionListBean(SlidingMenuAct1.class,"快速实现侧滑 - 1"));
        datas.add(new FunctionListBean(SlidingMenuAct2.class,"快速实现侧滑 - 2"));
        datas.add(new FunctionListBean(BottomNavigationAct.class,"快速实现底部导航及fragment切换"));
        datas.add(new FunctionListBean( SwipeBackAct.class,"边缘右滑返回"));
        datas.add(new FunctionListBean( UpdateVersionAct.class,"版本更新"));
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.af_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new FunctionAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FunctionListBean bean, View view) {
                Intent intent = new Intent(MainActivity.this,bean.getClzz());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean openSwipeBack() {
        return false;
    }


}
