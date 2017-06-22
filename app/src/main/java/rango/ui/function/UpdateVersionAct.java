package rango.ui.function;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText editText;

    @Override
    public void onLayoutLoaded(Bundle savedInstanceState) {
        getTitleBar().setText("使用更新", TbaseTitleBar.POSITION_CENTER);

        editText = new EditText(this);
        editText.setText("https://github.com/HarkBen/TBaseUI2/raw/master/file%20list/app-debug.apk");
        Button button = new Button(this);
        button.setText("建议版本更新");
        button.setBackgroundResource(R.drawable.btn_ripple);
        setContentLayout(button);
        button.setOnClickListener(v -> updateVersion(false));
        Button button2 = new Button(this);
        button2.setText("强制版本更新");
        button2.setBackgroundResource(R.drawable.btn_ripple);
        setContentLayout(button2);
        button2.setOnClickListener(v -> updateVersion(true));
    }

    private void updateVersion(boolean mandatory){
        UpdateVersionInfo info = new UpdateVersionInfo();
        info.setMandatory(mandatory);//是否强制更新
        info.setApkLoadUrl(editText.getText().toString().trim());
        info.setDescription("新版本添加了终极无敌新功能，赶快下载更新吧");
        info.setProjectName("TBaseUI");
        info.setNewVersionName("1.2");
        TBaseManager.showUpdateVersionDialog(this, info, new UpdateVersionDialog.VersionCallback() {
            @Override
            public void onSkipUpdate() {
                Toast.makeText(UpdateVersionAct.this,"选择跳过本次更新,正常登陆",Toast.LENGTH_LONG).show();
            }

            @Override
            public void exit() {
                Toast.makeText(UpdateVersionAct.this,"强制更新不可跳过,退出程序",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDownFaild(boolean mandatory,Throwable e) {
                Toast.makeText(UpdateVersionAct.this,"下载apk文件失败="+e.getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDownCompile(String filePath) {
                Toast.makeText(UpdateVersionAct.this,"安装包下载完成="+filePath,Toast.LENGTH_LONG).show();
            }
        });
    }

}
