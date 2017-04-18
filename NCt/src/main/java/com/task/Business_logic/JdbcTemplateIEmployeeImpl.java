package com.task.Business_logic;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.task.Work_with_db.Comm_Add;
import com.task.Work_with_db.Comm_Delete;
import com.task.Work_with_db.Comm_Read;
import com.task.Work_with_db.Comm_Search;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by YFJ on 18.04.2017.
 */
public class JdbcTemplateIEmployeeImpl implements IEmployee {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;


    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addEmployee(BufferedReader reader) {
        Comm_Add comm_add = new Comm_Add(reader, jdbcTemplate);
        comm_add.execute();
    }

    @Override
    public Employee getEmployeeByEmpno(BufferedReader reader) {
        Comm_Read comm_read = new Comm_Read(reader, jdbcTemplate);
        comm_read.execute();
        return comm_read.getEmp();
    }

    @Override
    public void removeEmployee(BufferedReader reader) {
        Comm_Delete comm_delete = new Comm_Delete(reader, jdbcTemplate);
        comm_delete.execute();
    }
    @Override
    public Employee searchEmployee(BufferedReader reader){
            Comm_Search comm_search= new Comm_Search(reader, jdbcTemplate);
            comm_search.execute();
            return  comm_search.getEmp();
    }

}
