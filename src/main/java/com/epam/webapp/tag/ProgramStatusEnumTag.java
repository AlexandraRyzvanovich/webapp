package com.epam.webapp.tag;

import com.epam.webapp.entity.ProgramStatus;

import javax.servlet.jsp.tagext.TagSupport;
import java.util.Set;

public class ProgramStatusEnumTag extends TagSupport {

    @Override
    public int doStartTag() {
        Object sessionLocale = pageContext.getSession().getAttribute("language");
        Set<String> values;
        if (sessionLocale.equals("ru")) {
            values = ProgramStatus.PROGRAM_STATUS_MAP_RU.keySet();
        } else {
            values = ProgramStatus.PROGRAM_STATUS_MAP_EN.keySet();
        }
        pageContext.setAttribute("programStatuses", values);

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() {
        return EVAL_PAGE;
    }
}
