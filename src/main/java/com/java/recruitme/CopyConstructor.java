package com.java.recruitme;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CopyConstructor {
	
	public static Messaging init() {
		InboundService inboundService = new InboundService();
		inboundService.setInboundService("Inbound-A");
		OutboundService outboundService = new OutboundService();
		outboundService.setOutboundService("Outbound-A");
		Messaging messaging = new Messaging();
		messaging.setInboundService(inboundService);
		messaging.setOutboundService(outboundService);
		return messaging;
	}

	public static void main(String[] args) {
		Messaging messaging = init();
		Map<String, Messaging> map = new HashMap<String, Messaging>();
		map.put("A", messaging);
		Service service = new Service();
		System.out.println(service.getMap(map).get("A").getInboundService().getInboundService());
	}
}

class Service {

	private ConcurrentHashMap<String, Messaging> concurrentHashMap = new ConcurrentHashMap<>();

	public ConcurrentHashMap<String, Messaging> getMap(Map<String, Messaging> map) {
		concurrentHashMap = new ConcurrentHashMap<String, Messaging>(map);
		return concurrentHashMap;
	}
}

class Messaging {

	private InboundService inboundService;
	private OutboundService outboundService;

	public InboundService getInboundService() {
		return inboundService;
	}

	public void setInboundService(InboundService inboundService) {
		this.inboundService = inboundService;
	}

	public OutboundService getOutboundService() {
		return outboundService;
	}

	public void setOutboundService(OutboundService outboundService) {
		this.outboundService = outboundService;
	}

}

class InboundService {

	private String inboundService;

	public String getInboundService() {
		return inboundService;
	}

	public void setInboundService(String inboundService) {
		this.inboundService = inboundService;
	}

}

class OutboundService {

	private String outboundService;

	public String getOutboundService() {
		return outboundService;
	}

	public void setOutboundService(String outboundService) {
		this.outboundService = outboundService;
	}

}