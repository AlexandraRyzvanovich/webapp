package com.epam.webapp.mapper;

import com.epam.webapp.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifiable> {

    /**
     * Получает значения столбцов из запроса и компанует ими сущность.
     *
     * @param resultSet результат запроса из БД
     *
     * @return запись из БД в виде сущности
     */
    T map(ResultSet resultSet) throws SQLException;

    /**
     * В зависимости от названия таблицы возвращает соответствующий мапер
     *
     * @param table название таблицы
     *
     * @return мапер, если таблица существует, в ином случае IllegalArgumentException
     */
    static RowMapper<? extends Identifiable> create(String table) {
        switch (table) {
            case User.USER_TABLE_NAME:
                return new UserRowMapper();
            case Program.PROGRAM_TABLE_NAME:
                return new ProgramRowMapper();
            case Review.REVIEW_TABLE_NAME:
                return new ReviewRowMapper();
            case Subscription.SUBSCRIPTION_TABLE_NAME:
                return new SubscriptionRowMapper();
            case Trainer.TRAINER_TABLE_NAME:
                return new TrainerRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
