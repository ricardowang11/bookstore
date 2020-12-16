package edu.ncu.ricardowang.myJSPTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: wangqin
 * @Date: 2020/12/9 0009 - 12 -09 -10:42
 * @Description: edu.ncu.ricardowang.myJSPTag
 * @version: 1.0
 */
public class ScreenTag extends TagSupport {
    public ScreenTag() {
        super();
    }

    @Override
    public int doStartTag() throws JspException {
        //通过setValue设置一个ArrayList存放parameters
        //获取父标签中设置的设置的screens如果其中不包含当前页面，就添加当前页面，如果包含就跳过
        HashMap screens= (HashMap) pageContext.getAttribute("screens",pageContext.APPLICATION_SCOPE);

        if (screens != null&& !screens.containsKey(getId())){
            setValue("params",new ArrayList());
            screens.put(getId(), getValue("params"));
            return EVAL_BODY_INCLUDE;
        }
        return SKIP_BODY;
    }


}
