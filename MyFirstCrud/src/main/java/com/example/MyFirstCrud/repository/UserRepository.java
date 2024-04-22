package com.example.MyFirstCrud.repository;

import com.example.MyFirstCrud.model.User;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@AllArgsConstructor
public class UserRepository {
    private final JdbcTemplate jdbc;

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод удаления записи пользователя из БД по ID
     *
     * @param id идентификатор пользователя
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Метод получает user из БД по id
     *
     * @param id
     * @return - если нет записи, возвращает null
     */
    public User getById(int id) {
        if (!existUserById(id)) return null;
        String sql = "SELECT id,firstName,lastName FROM userTable WHERE id = ?";
        return jdbc.queryForObject(sql,
                (resultSet, rowNum) -> {
                    User newUser = new User();
                    newUser.setId(Integer.parseInt(resultSet.getString("id")));
                    newUser.setFirstName(resultSet.getString("firstName"));
                    newUser.setLastName(resultSet.getString("lastName"));
                    return newUser;
                },
                id);
    }

    /**
     * Метод обновления данных пользователя по ID
     *
     * @param user
     */
    public void update(User user) {
        if (existUserById(user.getId())) {
            String sql = "UPDATE userTable SET firstName = ?, lastName = ? where id = ?";
            jdbc.update(sql,
                    user.getFirstName(),
                    user.getLastName(),
                    user.getId());
        }
    }


    /**
     * Метод проверяет есть ли запись с id в БД
     *
     * @param id id
     * @return true
     */
    private boolean existUserById(int id) {
        String sql = "SELECT count(*) FROM userTable WHERE id = ?";
        int countRow = jdbc.queryForObject(sql, Integer.class, id);
        return countRow > 0;
    }


}