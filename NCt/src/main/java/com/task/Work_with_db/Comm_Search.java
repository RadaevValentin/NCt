package com.task.Work_with_db;

import com.task.Business_logic.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by Your Friend Jesus on 16.04.2017.
 */
public class Comm_Search implements IServer_command {
    private JdbcTemplate jdbcTemplate;
    BufferedReader reader;

    public Employee getEmp() {
        return emp;
    }

    private Employee emp;

    public Comm_Search(BufferedReader reader, JdbcTemplate jdbcTemplate) {
        this.reader = reader;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void execute() {
        String s = "yes";
        try {
            while (s.equalsIgnoreCase("yes")) {
                System.out.println("How would you like to search? \n1 - by deptno \n2 - by job");
                String sol = reader.readLine();
                if (Integer.parseInt(sol) == 1) {
                    System.out.println("Insert deptno:");
                    Employee e = new Employee(new Integer(Integer.parseInt(reader.readLine())));
                    System.out.println("Do you want to find employees with deptno " + e.getDeptno());
                    if (reader.readLine().equalsIgnoreCase("yes")) {
                        System.out.println("========Searching INFO About employees by deptno========");
                        String SQL = "SELECT * FROM emp WHERE deptno= " + e.getDeptno();
                        System.out.println("Employees found : " + jdbcTemplate.queryForObject(SQL, Employee.class, e.getDeptno()).toString());
                    } else {
                        break;
                    }
                    System.out.println("Do you want to continue?");
                    s = reader.readLine();
                } else {
                    if (Integer.parseInt(sol) == 2) {
                        System.out.println("Insert job:");
                        Employee e = new Employee(reader.readLine());
                        System.out.println("Do you want to find employees with deptno " + e.getJob());
                        if (reader.readLine().equalsIgnoreCase("yes")) {
                            System.out.println("========Searching INFO About employees by job========");
                            String SQL = "SELECT * FROM emp WHERE job= " + e.getJob();
                            emp = jdbcTemplate.queryForObject(SQL, Employee.class, e.getJob());
                            System.out.println("Employees found : " + emp.toString());
                        } else {
                            break;
                        }
                        System.out.println("Do you want to continue?");
                        s = reader.readLine();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
