package com.epam.webapp.dao;

import com.epam.webapp.dto.InternCard;
import com.epam.webapp.exception.DaoException;

import java.util.Optional;

public interface InternCardDao {
    Optional<InternCard> getInternInfo(Long userId);

}
