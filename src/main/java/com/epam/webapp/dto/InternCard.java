package com.epam.webapp.dto;

import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.ProgramStatus;

import java.util.Date;
import java.util.Objects;

public class InternCard implements Identifiable {
    public static final String INTERN_TABLE_NAME_FOR_MAPPER = "internCard";

    private Long userId;
    private Diet diet;
    private Date startDate;
    private Date endDate;
    ProgramStatus status;
    private String exerciseName;
    private Integer frequency;

    private String lastName;
    private String exerciseDescription;
    private String exerciseList;
    private String dietDescription;
    private String foodList;
    private String additionalInfo;

}
