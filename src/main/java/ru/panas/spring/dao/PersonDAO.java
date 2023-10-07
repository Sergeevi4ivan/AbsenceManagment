package ru.panas.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.panas.spring.models.Person;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Workers", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(final int id) {
        return jdbcTemplate.query("SELECT * FROM Workers WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Workers(reason, startDate, duration, discounted, description) VALUES (?, ?, ?, ?, ?)",
                person.getReason(),
                person.getStartDate(),
                person.getDuration(),
                person.isDiscounted(),
                person.getDescription());
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Workers SET reason=?, startDate=?, duration=?, discounted=?, description=? WHERE id=?",
                updatedPerson.getReason(),
                updatedPerson.getStartDate(),
                updatedPerson.getDuration(),
                updatedPerson.isDiscounted(),
                updatedPerson.getDescription(),
                id);

    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Workers WHERE id=?", id);
    }


}
