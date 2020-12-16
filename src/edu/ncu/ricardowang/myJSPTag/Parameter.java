package edu.ncu.ricardowang.myJSPTag;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:41
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class Parameter {
    private boolean isDirect;
    private String paramName;
    private String paramValue;

    public Parameter(boolean isDirect, String paramName, String paramValue) {
        this.isDirect = isDirect;
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public String getParamName() {
        return paramName;
    }

    public String getParamValue() {
        return paramValue;
    }
}
