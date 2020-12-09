package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: wangqin
 * @Date: 2020/12/8 0008 - 12 -08 -20:34
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class ScreenTag extends TagSupport {
    public ScreenTag() {
        super();
    }
    //id字段继承自TagSupport

    @Override
    public int doStartTag() throws JspException {
        setValue("parameters",new ArrayList());
        HashMap screens=(HashMap)pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);
        if (screens == null) {
            return SKIP_BODY;
        }else {
            if (!screens.containsKey(getId())){
                screens.put(getId(), getValue("parameters"));
                return EVAL_BODY_INCLUDE;
            }else{
                return SKIP_BODY;
            }
        }
    }
    public void release(){
        super.release();
    }
}
