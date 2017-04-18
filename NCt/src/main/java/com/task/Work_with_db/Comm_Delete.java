package com.task.Work_with_db;

import com.task.Business_logic.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Your Friend Jesus on 16.04.2017.
 */
public class Comm_Delete implements IServer_command {
    private JdbcTemplate jdbcTemplate;
    BufferedReader reader;

    public Comm_Delete(BufferedReader reader, JdbcTemplate jdbcTemplate){
        this.reader = reader;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute() {
        String s = "yes";
        try {
            while (s.equalsIgnoreCase("yes")) {
                System.out.println("Insert empno:");
                Employee e = new Employee(Integer.parseInt(reader.readLine()));
                String SQL = "DELETE FROM emp WHERE empno =" + e.getEmpno();
                System.out.println("Do you want to delete employee with empno " + e.getEmpno());
                if (reader.readLine().equalsIgnoreCase("yes")) {
                    jdbcTemplate.update(SQL);
                    System.out.println("Employee successfully deleted.\n" + e.toString());
                }
                else{break;}
                System.out.println("Do you want to continue?");
                s = reader.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
