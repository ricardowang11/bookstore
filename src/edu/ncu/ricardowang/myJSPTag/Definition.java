package edu.ncu.ricardowang.myJSPTag;

import java.util.HashMap;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:41
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class Definition {
    private HashMap<String,Parameter> params=new HashMap<String,Parameter>();
    public void setParam(Parameter parameter) {
        String paramName=parameter.getParamName();
        if (paramName.equals("title")){
            this.params.put("title",parameter);
        }else if (paramName.equals("body")){
            this.params.put("body",parameter);
        }else{
            this.params.put("banner",parameter);
        }

    }
    public Parameter getParam(String parameterName){
        return params.get(parameterName);
    }
}
