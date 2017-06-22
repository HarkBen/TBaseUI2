package rango.ui.function;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.rg.function.utils.TBaseManager;
import com.rg.function.version.UpdateVersionDialog;
import com.rg.function.version.UpdateVersionInfo;
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
public class UpdateVersionAct extends TBaseActivity {
    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        getTitleBar().setText("使用更新", TbaseTitleBar.POSITION_CENTER);
        Button button = new Button(this);
        button.setText("开启版本更新");
        button.setBackgroundResource(R.drawable.se_btn_gray_white);
        setContentLayout(button);
        button.setOnClickListener(v -> updateVersion());
    }

    private void updateVersion(){
        UpdateVersionInfo info = new UpdateVersionInfo();
        info.setMandatory(false);//非强制更新
        info.setApkLoadUrl("http://192.168.0.18:8080/JenkinsApk/2017-06-09-14-22/DangJianAND-v2.0-debug.apk");
        info.setDescription("我这一生走过最长的路，就是你的套路。");
        info.setProjectName("TBaseUITest");
        info.setNewVersionName("0.9");
        TBaseManager.showUpdateVersionDialog(this, info, new UpdateVersionDialog.VersionCallback() {
            @Override
            public void onSkipUpdate() {
                Toast.makeText(UpdateVersionAct.this,"选择跳过本次更新",Toast.LENGTH_LONG).show();
            }

            @Override
            public void exit() {
                Toast.makeText(UpdateVersionAct.this,"强制更新不可跳过",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDownFaild(boolean mandatory) {
                Toast.makeText(UpdateVersionAct.this,"下载更新文件失败",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDownCompile(String filePath) {
                Toast.makeText(UpdateVersionAct.this,"安装包下载完成="+filePath,Toast.LENGTH_LONG).show();
            }
        });
    }

}
