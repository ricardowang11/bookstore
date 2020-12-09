package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -19:42
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class ParameterTag extends TagSupport {
    private String paramName = null;
    private String paramValue = null;
    private String isDirectString = null;

    public ParameterTag() {
        super();
    }

    public void setName(String paramName) {
        this.paramName = paramName;
    }

    public void setValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public void setDirect(String isDirectString) {
        this.isDirectString = isDirectString;
    }

    @Override
    public int doStartTag() throws JspException {
        boolean isDirect = false;
        if ((isDirectString != null) && isDirectString.toLowerCase().equals("true"))
            isDirect = true;

        if (paramName != null) {
            ArrayList parameters = (ArrayList) ((TagSupport) getParent()).getValue("parameters");
            if (parameters != null) {
                Parameter param = new Parameter(paramName, isDirect, paramValue);
                parameters.add(param);
            }
        }

        return SKIP_BODY;

    }
    public void release(){
        paramName=null;
        paramValue=null;
        isDirectString=null;
    }
}
