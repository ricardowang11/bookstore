package edu.ncu.ricardowang.myJSPTag;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -19:27
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class Parameter {
    private String name;
    private boolean isDirect;
    private String value;

    public Parameter(String name, boolean isDirect, String value) {
        this.name = name;
        this.isDirect = isDirect;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public boolean isDirect() {
        return isDirect;
    }

    public String getValue() {
        return value;
    }
}
