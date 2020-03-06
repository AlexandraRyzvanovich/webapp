package com.epam.webapp.tag;

import com.epam.webapp.entity.Diet;

import javax.servlet.jsp.tagext.TagSupport;
import java.util.Set;

@SuppressWarnings("serial")
public class DietsEnumLocaleTag extends TagSupport {

    @Override
    public int doStartTag() {
       Object sessionLocale =  pageContext.getSession().getAttribute("language");
       Set<String> values = null;
       if(sessionLocale != null) {
           if (sessionLocale.equals("ru")) {
               values = Diet.DIET_MAP_RU.keySet();
           }
       } else {
           values = Diet.DIET_MAP_EN.keySet();
       }
        pageContext.setAttribute("diets", values);

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
