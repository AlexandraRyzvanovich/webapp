package com.epam.webapp.dao.reviewImpl;

import com.epam.webapp.dao.AbstractDao;
import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.Review;
import com.epam.webapp.exception.DaoException;

import java.sql.Connection;
import java.util.Optional;

public class ReviewDaoImpl extends AbstractDao<Review> implements ReviewDao {
    private static final String GET_REVIEW_BY_ID_QUERY = "SELECT * FROM review WHERE id = ?";
    private static final String SAVE_REVIEW_QUERY = "INSERT INTO review (user_id, review_msg, star, date) VALUES (?, ?, ?, ?)";

    public ReviewDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Review.REVIEW_TABLE_NAME;
    }

    @Override
    public Optional getById(Long id) throws DaoException {
        return executeForStringResult(GET_REVIEW_BY_ID_QUERY, id);
    }

    @Override
    public void save(Identifiable item) throws DaoException {
       executeQuery(SAVE_REVIEW_QUERY, item);

    }

    @Override
    public void removeById(Long id) throws DaoException {


    }
}
