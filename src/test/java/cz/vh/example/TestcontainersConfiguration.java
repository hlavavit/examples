package cz.vh.example;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@SuppressWarnings("resource")
class TestcontainersConfiguration implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	static final PostgreSQLContainer<?> postgreSQLContainer;

	static {
		postgreSQLContainer = new PostgreSQLContainer<>(
				DockerImageName.parse("postgres:latest"))
				.withDatabaseName("test")
				.withUsername("duke")
				.withPassword("s3cret");
		postgreSQLContainer.start();
	}

	@Override
	public void initialize(ConfigurableApplicationContext ctx) {
		TestPropertyValues
				.of("spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
					"spring.datasource.username=" + postgreSQLContainer.getUsername(),
					"spring.datasource.password=" + postgreSQLContainer.getPassword())
				.applyTo(ctx.getEnvironment());

	}

}
