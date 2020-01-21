package com.epam.webapp.mapper;

import com.epam.webapp.entity.Identifiable;
import com.epam.webapp.entity.User;

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
            default:
                throw new IllegalArgumentException("Unknown table");
        }
    }
}
