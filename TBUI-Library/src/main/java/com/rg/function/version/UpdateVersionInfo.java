package com.rg.function.version;

/**
 * Create on 2017/6/20.
 * github  https://github.com/HarkBen
 * Description:
 * ----所有属性都必须初始化，否则会导致文件处理失败-------
 * author Ben
 * Last_Update - 2017/6/20
 */
public class UpdateVersionInfo {
    private boolean mandatory;//是否做强制更新
    private String description;
    private String projectName;
    private String newVersionName;
    private String apkLoadUrl;


    public UpdateVersionInfo() {

    }

    public UpdateVersionInfo(boolean mandatory, String description, String projectName, String newVersionName, String apkLoadUrl) {
        this.mandatory = mandatory;
        this.description = description;
        this.projectName = projectName;
        this.newVersionName = newVersionName;
        this.apkLoadUrl = apkLoadUrl;
    }

    public String getNewVersionName() {
        return newVersionName;
    }

    public void setNewVersionName(String newVersionName) {
        this.newVersionName = newVersionName;
    }

    public String getApkLoadUrl() {
        return apkLoadUrl;
    }

    public void setApkLoadUrl(String apkLoadUrl) {
        this.apkLoadUrl = apkLoadUrl;
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
