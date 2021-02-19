package com.example.school.dao;

import com.example.school.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDAOImpl implements ContactDAO{

    private final JdbcTemplate jdbcTemplate;

    public ContactDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Contact contact) {

        String sql = "INSERT INTO contact (name, email, address, phone) VALUES (?,?,?,?)";

        return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());

    }

    @Override
    public int update(Contact contact) {
        String sql = "UPDATE contact SET name = ?, email = ?, address = ? , phone = ? WHERE contact_id = ?";

        return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getContactId());

    }

    @Override
    public Contact get(Integer id) {
        String sql = "SELECT * FROM contact WHERE contact_id = " + id;
        ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {
            @Override
            public Contact extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                if(resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");

                    return new Contact(id, name, email, address, phone);
                }
                return null;
            }
        };
        return jdbcTemplate.query(sql,extractor);
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM contact WHERE contact_id = " + id;

        return jdbcTemplate.update(sql);

    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT * FROM contact";

        RowMapper<Contact> rowMapper = new RowMapper<Contact>() {
            @Override
            public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
                Integer contact_id = resultSet.getInt("contact_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");

                return new Contact(contact_id, name, email, address, phone);
            }
        };
        return jdbcTemplate.query(sql, rowMapper);
    }
}
