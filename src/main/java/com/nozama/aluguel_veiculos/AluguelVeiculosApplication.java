package com.nozama.aluguel_veiculos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

@SpringBootApplication
public class AluguelVeiculosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluguelVeiculosApplication.class, args);
	}

    public CommandLineRunner checkDatabaseVersion(DataSource dataSource) {
        return args -> {
            try (Connection conn = dataSource.getConnection();
                 ResultSet rs = conn.createStatement().executeQuery("SELECT VERSION()")) {
                if (rs.next()) {
                    System.out.println("MySQL versão que o Spring Boot está usando: " + rs.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}
