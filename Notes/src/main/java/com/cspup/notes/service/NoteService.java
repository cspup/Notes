package com.cspup.notes.service;

import com.cspup.notes.entity.Note;
import com.cspup.notes.utils.SqlUtil;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author csp
 * @date 2022/2/22 16:36
 * @description
 */
@Service
public class NoteService {

    private final DataSource dataSource;

    public NoteService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Note createNote(String content, String label){
        Note note = new Note();
        note.setContent(content);
        note.setLabel(label);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "insert into note(content,label) values(?,?)";
        Object[] objects = new Object[]{content,label};
        jdbcTemplate.update(sql,objects);
        return note;
    }

    public String getLastContent(String label){
        String sql = "SELECT content FROM note WHERE label = ? ORDER BY id desc limit 1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sql = SqlUtil.toSql(sql,label);
        try{
            return jdbcTemplate.queryForObject(sql,String.class);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
