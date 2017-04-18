package com.task.Start_module;

import com.task.Business_logic.JdbcTemplateIEmployeeImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

@SpringBootApplication
public class NCtApplication {

	public static void main(String[] args) {
		SpringApplication.run(NCtApplication.class, args);
        Locale.setDefault(Locale.ENGLISH);
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationConfig.xml");

		JdbcTemplateIEmployeeImpl jdbcTemplateIEmployeeImpl = (JdbcTemplateIEmployeeImpl) context.getBean("jdbcTemplateIEmployee");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		jdbcTemplateIEmployeeImpl.addEmployee(reader);
        jdbcTemplateIEmployeeImpl.getEmployeeByEmpno(reader);
        jdbcTemplateIEmployeeImpl.searchEmployee(reader);
        jdbcTemplateIEmployeeImpl.removeEmployee(reader);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
