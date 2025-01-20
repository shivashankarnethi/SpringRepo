package com.webclient.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webclient.binding.Passenger;
import com.webclient.binding.Ticket;
import com.webclient.configuration.ProfileConfiguration;
@Service
@Component
public class MMTServiceimpl implements MMTService {
	
	@Autowired
	private ProfileConfiguration profileconfig;
	
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		Map<String,String> map = profileconfig.getLinks();
		String bookResponse = map.get("bookUrl");
		
		Passenger pass = new Passenger();
		pass.setPid(passenger.getPid());
		pass.setName(passenger.getName());
		pass.setJourneyDate(passenger.getJourneyDate());
		pass.setTrainNum(passenger.getTrainNum());
		pass.setDestination(passenger.getDestination());
		        Ticket ticket = WebClient
				.create()
				.post()
				.uri(bookResponse)
				.bodyValue(pass)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
		System.out.println(ticket);
		return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() {
		Map<String,String> map = profileconfig.getLinks();
		String getAllResponse = map.get("getAllUrl");
		
		Ticket[] ticket = WebClient
				.create()
				.get()
				.uri(getAllResponse)
				.retrieve()
				.bodyToMono(Ticket[].class)
				.block();
		List<Ticket> list = Arrays.asList(ticket);
		return list;
	}

	@Override
	public String deleteTicket(Integer ticketId) {
		Map<String,String> map = profileconfig.getLinks();
		String deleteResponse = map.get("url");
		
		String deleteTicket = WebClient
				.create()
				.delete()
				.uri(deleteResponse,ticketId)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return deleteTicket;
	}

	@Override
	public Ticket updateTicket(Passenger passenger, Integer ticketId) {
		
		Map<String,String> map = profileconfig.getLinks();
		String updateResponse = map.get("updateUrl");
		
		Map<String, Integer> ticketMap = new HashMap<>();
		ticketMap.put("id", ticketId);
		Passenger updatePassenger = new Passenger();
		updatePassenger.setJourneyDate(passenger.getJourneyDate());
		updatePassenger.setName(passenger.getName());
		updatePassenger.setPid(ticketId);
		updatePassenger.setTrainNum(passenger.getTrainNum());
		updatePassenger.setDestination(passenger.getDestination());
				Ticket ticket = WebClient
				.create()
				.put()
				.uri(updateResponse,ticketId)
				.bodyValue(updatePassenger)
				.retrieve()
				.bodyToMono(Ticket.class)
				.block();
				System.out.println(ticket);
		return ticket;
	}

}
