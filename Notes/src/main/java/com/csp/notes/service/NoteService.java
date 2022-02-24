package com.csp.notes.service;

import com.csp.notes.entity.Note;
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

    public Note createNote(String content,String label){
        Note note = new Note();
        note.setContent(content);
        note.setLabel(label);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "insert into note(content,label) values(?,?)";
        Object[] objects = new Object[]{content,label};
        jdbcTemplate.update(sql,objects);
        return note;
    }
}
