package com.example.MyFirstCrud.repository;

import com.example.MyFirstCrud.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

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
        return  user;
    }

    /**
     * Метод удаления записи пользователя из БД по ID
     * @param id идентификатор пользователя
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    //- User update(User user)
    //- User getOne(int id)
    public User update(User user) {
        // есть кнопка редактировать
        // при нажатии на кнопку вывести форму, которая была при добавлении
        // после заполнения новыми данными сделать обновление списка
        // можно добавить сообщение данные успешно изменены
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
        return user;
    }

    public void getById(int id) {
        String sql = "SELECT FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
}