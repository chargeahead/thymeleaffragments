package com.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="locations")
public class LocationEndPoint {
	
	private Map<String,String> locations = new ConcurrentHashMap<>();
	
	@ReadOperation
	public Map<String, String> get(){
		locations.put("SF", "123 Main St. , San Francisco");
		locations.put("SEA", "123 Main St., Seattle");
		return locations;
	}
	@ReadOperation
	public String getByName(@Selector String name) {
		return locations.get(name);
	}
	
	@WriteOperation
	public void add(@Selector String name, String value) {
		locations.put(name, value);
	}
	@DeleteOperation
	public void delete(@Selector String name) {
		locations.remove(name);
	}

}
