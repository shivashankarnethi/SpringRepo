package com.webclient.service;

import java.util.List;

import com.webclient.binding.Passenger;
import com.webclient.binding.Ticket;

public interface MMTService {

	Ticket bookTicket(Passenger passenger);

	List<Ticket> getAllTickets();

	String deleteTicket(Integer ticketId);

	Ticket updateTicket(Passenger passenger, Integer ticketId);

}
