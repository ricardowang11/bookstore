package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:41
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class DefinitionTag extends TagSupport {
    private String name;
    private String screenId;
    private int screenNum;

    public DefinitionTag() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public void setScreenNum(int screenNum) {
        this.screenNum = screenNum;
    }

    @Override
    public int doStartTag() throws JspException {
        HashMap screens= (HashMap) pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);
        if (screens==null){
            pageContext.setAttribute("screens",new HashMap(),pageContext.APPLICATION_SCOPE);
        }
        if (screens.size()==screenNum) {
            return SKIP_BODY;
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        HashMap screens= (HashMap) pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);
        ArrayList<Parameter> params= (ArrayList) screens.get(screenId);
        if (params == null) {
            return SKIP_PAGE;
        }
        Definition definition=new Definition();
        for (Parameter param : params) {
            definition.setParam(param);
        }
        pageContext.setAttribute(name,definition);
        return EVAL_PAGE;
    }
}
