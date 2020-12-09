package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -20:58
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class InsertTag extends TagSupport {
    private boolean directInclude=false;
    private String parameterName=null;
    private String dedinitionName=null;
    private Definition definition=null;
    private Parameter parameter=null;
    public InsertTag(){
        super();
    }

    public void setDefinition(String name) {
        this.dedinitionName = name;
    }

    public void setParameter(String name) {
        this.parameterName = name;
    }

    @Override
    public int doStartTag() throws JspException {
        definition=(Definition)pageContext.getAttribute(dedinitionName);
        if (parameterName != null&& definition!=null) {
            parameter= definition.getParam(parameterName);
        }
        if (parameter != null) {
            directInclude=parameter.isDirect();
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        try {
            if (directInclude&&parameter!=null){
                pageContext.getOut().print(parameter.getValue());
            }else{
                if (parameter!=null&&parameter.getValue()!=null){
                    pageContext.include(parameter.getValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        directInclude=false;
        parameterName=null;
        definition=null;
        dedinitionName=null;
        parameter=null;
        super.release();
    }
}
