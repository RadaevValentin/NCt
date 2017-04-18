package com.task.Business_logic;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.sql.Date;
import java.util.List;


/**
 * Created by YFJ on 18.04.2017.
 */
public interface IEmployee {
    public void setDataSource(DataSource dataSource);

    public void addEmployee(BufferedReader reader);

    public Employee getEmployeeByEmpno(BufferedReader reader);

    public void removeEmployee(BufferedReader reader);

    public Employee searchEmployee(BufferedReader reader);
}
