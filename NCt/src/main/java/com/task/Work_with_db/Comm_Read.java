package com.task.Work_with_db;

import com.task.Business_logic.Employee;
import com.task.Business_logic.EmployeeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Your Friend Jesus on 16.04.2017.
 */
public class Comm_Read implements IServer_command {
    private JdbcTemplate jdbcTemplate;
    BufferedReader reader;
    public Comm_Read(BufferedReader reader, JdbcTemplate jdbcTemplate){
        this.reader = reader;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee getEmp() {
        return emp;
    }

    private Employee emp;


    @Override
    public void execute() {
        String s = "yes";
        try {
            while (s.equalsIgnoreCase("yes")) {
                System.out.println("Insert empno:");
                String q = reader.readLine();
                Employee e = new Employee(Integer.parseInt(q));
                System.out.println("Do you want to find employee with empno " + e.getEmpno());
                if (reader.readLine().equalsIgnoreCase("yes")) {
                    System.out.println("========Searching INFO About employee by empno========");
                    String SQL = "SELECT * FROM emp WHERE empno= ?";
                    e = jdbcTemplate.queryForObject(SQL, Employee.class, e.getEmpno());
                    System.out.println("Employee found : " + emp.toString());
                }
                else{break;}
                System.out.println("Do you want to continue?");
                s = reader.readLine();
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
