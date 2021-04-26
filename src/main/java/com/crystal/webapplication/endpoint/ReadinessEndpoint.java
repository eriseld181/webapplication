package com.crystal.webapplication.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id= "readiness")
public class ReadinessEndpoint {
	
	private String ready = "NOT_READY";
	
	@ReadOperation
	private String getReadiness() {
		return ready;
	}
	
	@EventListener(ApplicationReadyEvent.class)
	private void setReady() {
		ready= "READY ";
	}
}
