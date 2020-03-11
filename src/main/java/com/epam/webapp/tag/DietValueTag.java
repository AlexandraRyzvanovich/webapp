package com.epam.webapp.tag;

import com.epam.webapp.entity.Diet;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class DietValueTag extends TagSupport {
    private Diet diet;

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    @Override
    public int doStartTag() {
        Object sessionLocale = pageContext.getSession().getAttribute("language");
        Set<Map.Entry<String, Diet>> entrySet;
        if (diet != null) {
            if (sessionLocale.equals("ru")) {
                entrySet = Diet.DIET_MAP_RU.entrySet();
            } else {
                entrySet = Diet.DIET_MAP_EN.entrySet();
            }
            Optional<String> result = entrySet
                    .stream()
                    .filter(entry -> diet.equals(entry.getValue()))
                    .map(Map.Entry::getKey)
                    .findFirst();

            if (result.isPresent()) {
                try {
                    pageContext.getOut().write(result.get());
                    return SKIP_BODY;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        return EVAL_PAGE;
    }
}

