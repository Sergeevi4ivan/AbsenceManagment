package ru.panas.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.panas.spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setReason(resultSet.getString("reason"));
        person.setDuration(resultSet.getInt("duration"));
        person.setDiscounted(resultSet.getBoolean("discounted"));
        person.setDescription(resultSet.getString("description"));

        return person;
    }
}
