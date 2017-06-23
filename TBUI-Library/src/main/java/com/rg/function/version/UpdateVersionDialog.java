package com.rg.function.version;

import android.app.Dialog;
import android.content.Context;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;
import com.liulishuo.filedownloader.FileDownloader;
import com.rg.ui.R;

import java.io.File;
import java.math.BigDecimal;

/**
 * Create on 2017/6/20.
 * github  https://github.com/HarkBen
 * Description:
 * ------版本更新的Dialog-----
 * author Ben
 * Last_Update - 2017/6/20
 */
public class UpdateVersionDialog extends Dialog implements View.OnClickListener {
    private double flexX = 1.0;// 宽度比
    private double flexY = 1.0;// 高度比

    private static String fileSavePath;
    private ProgressBar progressBar;
    private TextView  tvDescription, tvOnStartDownLoad;
    private Button  tvLeftBtn, tvRightBtn;
    private View duv_verticalLine;
    private VersionCallback versionCallback;
    private UpdateVersionInfo mVersionBean;
    private String progressDesc;

    public static   UpdateVersionDialog create(@NonNull Context context, @NonNull UpdateVersionInfo versionBean, VersionCallback versionCallback){
        return new UpdateVersionDialog(context,versionBean,versionCallback);
    }

    public UpdateVersionDialog(@NonNull Context context, @NonNull UpdateVersionInfo versionBean, VersionCallback versionCallback) {
        super(context, R.style.update_dialogNoTitle);
        this.mVersionBean = versionBean;
        this.versionCallback = versionCallback;
        setContentView(R.layout.dialog_updateversion);
        initView(mVersionBean);
        createDirectory();
    }


    private void initView(UpdateVersionInfo versionBean) {
        progressBar = (ProgressBar) findViewById(R.id.duv_progressbar);
        tvRightBtn = (Button) findViewById(R.id.duv_rightBtn);
        tvLeftBtn = (Button) findViewById(R.id.duv_leftBtn);
        tvDescription = (TextView) findViewById(R.id.duv_description);
        tvOnStartDownLoad = (TextView) findViewById(R.id.duv_onStartDownload);
        duv_verticalLine = findViewById(R.id.duv_verticalLine);
        tvRightBtn.setOnClickListener(this);
        tvLeftBtn.setOnClickListener(this);
        tvDescription.setText(mVersionBean.getDescription());
        if (versionBean.isMandatory()) {
            tvLeftBtn.setText(R.string.tbaseExitApp);
        }
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.duv_leftBtn) {
            if (mVersionBean.isMandatory()) {
                versionCallback.exit();
            } else {
                versionCallback.onSkipUpdate();
            }
            dismiss();
        } else if (view.getId() == R.id.duv_rightBtn) {
            tvLeftBtn.setVisibility(View.GONE);
            tvRightBtn.setVisibility(View.GONE);
            duv_verticalLine.setVisibility(View.GONE);
            tvOnStartDownLoad.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            //开始下载
            startLoadApkTak();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, @NonNull KeyEvent event) {
        return false;
    }

    public static boolean hasSDcard() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }

    private void createDirectory() {
        String fileDirectory = Environment
                .getExternalStorageDirectory().toString() + "/" + mVersionBean.getProjectName() + "/";
        File apkFileDirectory = new File(fileDirectory);
        if (!apkFileDirectory.exists()) {
            apkFileDirectory.mkdirs();
        }
        String apkFilePath = fileDirectory + mVersionBean.getProjectName() + "-v" + mVersionBean.getNewVersionName() + ".apk";
        File apkFile = new File(apkFilePath);
        if (!apkFileDirectory.exists()) {
            apkFileDirectory.mkdir();
        }
        fileSavePath = apkFile.getPath();

    }

    private void startLoadApkTak() {
        FileDownloader.getImpl().create(mVersionBean.getApkLoadUrl())
                .setPath(fileSavePath)
                .setListener(new FileDownloadListener() {
                    @Override
                    protected void pending(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        tvOnStartDownLoad.setText("正在链接...");
                    }

                    @Override
                    protected void connected(BaseDownloadTask task, String etag, boolean isContinue, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    protected void progress(BaseDownloadTask task, int soFarBytes, int totalBytes) {
                        BigDecimal soFar = new BigDecimal(soFarBytes);
                        BigDecimal total = new BigDecimal(totalBytes);
                        BigDecimal divide = soFar.divide(total, 3, BigDecimal.ROUND_HALF_EVEN);
                        int progress = (int) (divide.doubleValue() * 100);
                        progressBar.setProgress(progress);
                        progressDesc = getContext().getResources().getString(R.string.tbaseDownloading) + progress + "%";
                        tvOnStartDownLoad.setText(progressDesc);
                    }

                    @Override
                    protected void blockComplete(BaseDownloadTask task) {
                    }

                    @Override
                    protected void retry(final BaseDownloadTask task, final Throwable ex, final int retryingTimes, final int soFarBytes) {
                    }

                    @Override
                    protected void completed(BaseDownloadTask task) {
                        versionCallback.onDownCompile(task.getPath());
                        dismiss();
                    }

                    @Override
                    protected void paused(BaseDownloadTask task, int soFarBytes, int totalBytes) {

                    }

                    @Override
                    protected void error(BaseDownloadTask task, Throwable e) {
                        versionCallback.onDownFaild(mVersionBean.isMandatory(),e);
                        dismiss();
                    }

                    @Override
                    protected void warn(BaseDownloadTask task) {

                    }
                }).start();
    }


    @Override
    public void show() {
        Window dialogWindow = this.getWindow();
        WindowManager windowManager = dialogWindow.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL
                | Gravity.CENTER_VERTICAL);
        lp.width = (int) (display.getWidth() * flexX);
        if (flexY > 0) {
            lp.height = (int) (display.getHeight() * flexY);
        }
        dialogWindow.setAttributes(lp);
        super.show();
    }

    public interface VersionCallback {
        void onSkipUpdate();

        void exit();

        void onDownFaild(boolean mandatory,Throwable e);

        void onDownCompile(String filePath);
    }

}
