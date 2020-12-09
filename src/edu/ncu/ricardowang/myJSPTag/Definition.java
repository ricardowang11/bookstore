package edu.ncu.ricardowang.myJSPTag;

import java.util.HashMap;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -20:41
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class Definition {
    private HashMap params=new HashMap();

    public void setParam(Parameter p) {
        params.put(p.getName(),p);
    }
    public Parameter getParam(String name){
        return (Parameter)params.get(name);
    }
}
