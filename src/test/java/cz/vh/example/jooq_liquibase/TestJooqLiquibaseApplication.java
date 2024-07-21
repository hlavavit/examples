package cz.vh.example.jooq_liquibase;

import org.springframework.boot.SpringApplication;

public class TestJooqLiquibaseApplication {

	public static void main(String[] args) {
		SpringApplication.from(JooqLiquibaseApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
