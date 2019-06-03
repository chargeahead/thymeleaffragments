package com.example.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class FolderAccessHealthIndicator  implements HealthIndicator{

	@Override
	public Health health() {
		try(Stream<Path> paths = Files.walk(Paths.get("/home/parallels/Documents/mydocs1"))){
			paths.filter(Files::isRegularFile)
			     .forEach(System.out::println);
			return Health.up().build();
		}
		catch(IOException e) {
			e.printStackTrace();
			return Health.down().withDetail("FolderAccess", "N").build();
		}
	}

}
