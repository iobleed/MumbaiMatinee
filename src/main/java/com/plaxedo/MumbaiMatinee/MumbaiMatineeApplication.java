package com.plaxedo.MumbaiMatinee;

import com.plaxedo.MumbaiMatinee.web.cli.CliController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@SpringBootApplication
@EnableScheduling
@EnableAsync
public class MumbaiMatineeApplication implements CommandLineRunner {

	@Autowired
	private CliController cliController;

	public static void main(String[] args) {
		SpringApplication.run(MumbaiMatineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting Console Application...");
		cliController.run();
	}

	@Bean
	public Executor taskExecutor(){
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("PVRLookupService-");
		executor.initialize();
		return executor;
	}
}
