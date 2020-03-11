package com.epam.webapp.tag;

import com.epam.webapp.entity.ProgramStatus;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ProgramStatusValueTag extends TagSupport {
    private ProgramStatus status;

    public void setStatus(ProgramStatus status) {
        this.status = status;
    }

    @Override
    public int doStartTag() {
        Object sessionLocale = pageContext.getSession().getAttribute("language");
        Set<Map.Entry<String, ProgramStatus>> entrySet;
        if (sessionLocale.equals("ru")) {
            entrySet = ProgramStatus.PROGRAM_STATUS_MAP_RU.entrySet();
        } else {
            entrySet = ProgramStatus.PROGRAM_STATUS_MAP_EN.entrySet();
        }
        Optional<String> result = entrySet
                .stream()
                .filter(entry -> status.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            try {
                pageContext.getOut().write(result.get());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return SKIP_BODY;

    }
}
