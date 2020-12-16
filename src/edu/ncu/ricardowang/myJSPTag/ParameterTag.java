package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:42
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class ParameterTag extends TagSupport {
    private String isDirectString;
    private String paramName;
    private String paramValue;

    public ParameterTag() {
        super();
    }

    public void setDirect(String isDirectString) {
        this.isDirectString = isDirectString;
    }

    public void setName(String paramName) {
        this.paramName = paramName;
    }

    public void setValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public int doStartTag() throws JspException {
        boolean isDirect=false;
        ArrayList params= (ArrayList) ((TagSupport)getParent()).getValue("params");
        if (params == null) {
            return SKIP_BODY;
        }
        if (isDirectString!=null&&isDirectString.equals("true")){
            isDirect=true;
        }
        Parameter parameter=new Parameter(isDirect,paramName,paramValue);
        params.add(parameter);
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public void release() {
        isDirectString=null;
        paramValue=null;
        paramName=null;
        super.release();
    }
}
