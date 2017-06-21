package rango.ui.function;

import java.io.Serializable;

/**
 * Create on 2017/6/21.
 * github  https://github.com/HarkBen
 * Description:
 * -----------
 * author Ben
 * Last_Update - 2017/6/21
 */
public class FunctionListBean implements Serializable {
    private Class clzz;
    private String functionName;

    public FunctionListBean(Class clzz, String functionName) {
        this.clzz = clzz;
        this.functionName = functionName;
    }

    public Class getClzz() {
        return clzz;
    }

    public void setClzz(Class clzz) {
        this.clzz = clzz;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }
}
