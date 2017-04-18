package com.task.Business_logic;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by YFJ on 18.04.2017.
 */
public class EmployeeMapper implements RowMapper {
    @Override
    public Employee mapRow(ResultSet res, int rowNum) throws SQLException {
        Employee emp = new Employee();
        emp.setEmpno(res.getInt("EMPNO"));
        emp.setEname(res.getString("ENAME"));
        emp.setJob(res.getString("JOB"));
        emp.setMgr(res.getInt("MGR"));
        emp.setHiredate(res.getDate("HIREDATE"));
        emp.setSal(res.getInt("SAL"));
        emp.setComm(res.getInt("COMM"));
        emp.setDeptno(res.getInt("DEPTNO"));
        return emp;
    }
}