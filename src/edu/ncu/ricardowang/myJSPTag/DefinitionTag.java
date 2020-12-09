package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -20:46
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class DefinitionTag extends TagSupport {
    private String definitionName=null;
    private String screenId;
    private int screenNum;

    public DefinitionTag() {
        super();
    }

    public void setName(String definitionName) {
        this.definitionName = definitionName;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public void setScreenNum(int screenNum) {
        this.screenNum = screenNum;
    }

    @Override
    public int doStartTag() throws JspException {
        HashMap screens=null;
        screens=(HashMap)pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);
        if (screens == null) {
            pageContext.setAttribute("screens",new HashMap(),pageContext.APPLICATION_SCOPE);
        }else  {
            if (screens.size()==screenNum){
                return SKIP_BODY;
            }
        }
        return EVAL_BODY_INCLUDE;
    }

    @Override
    public int doEndTag() throws JspException {
        Definition definition=new Definition();
        HashMap screens=null;
        ArrayList parameters=null;
        TagSupport screen=null;

        screens=(HashMap)pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);
        if (screens != null) {
            parameters=(ArrayList)screens.get(screenId);
        }
        Iterator ir=null;
        if (parameters != null) {
            ir=parameters.iterator();
            while((ir!=null)&&ir.hasNext()){
                definition.setParam((Parameter)ir.next());
            }
            pageContext.setAttribute(definitionName,definition);
        }
        return EVAL_PAGE;
    }
    public void release(){
        definitionName=null;
        screenId=null;
        super.release();
    }
}
