package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:42
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class InsertTag extends TagSupport {
    private Definition definition;
    private String definitionName;
    private Parameter parameter;
    private String parameterName;
    private boolean isDirect;

    public void setDefinition(String definitionName) {
        this.definitionName = definitionName;
    }

    public void setParameter(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public int doStartTag() throws JspException {
        definition= (Definition) pageContext.getAttribute(definitionName);
        if (definition==null){
            return SKIP_BODY;
        }
        parameter= definition.getParam(parameterName);
        if (parameter == null) {
            return SKIP_BODY;
        }
        isDirect=parameter.isDirect();
        try {
            if (isDirect){
                pageContext.getOut().print(parameter.getParamValue());
            }else{
                pageContext.include(parameter.getParamValue());
            }
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        definition=null;
        definitionName=null;
        parameter=null;
        parameterName=null;
        super.release();
    }
}
