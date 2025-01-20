package com.webclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webclient.binding.Passenger;
import com.webclient.binding.Ticket;
import com.webclient.service.MMTService;

@RestController
@RequestMapping("/MMT")
public class MMTController {

	
	@Autowired
	private MMTService mmtService1;
	
	@PostMapping("/bookTicket")
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		Ticket ticket = mmtService1.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAlltickets")
	public ResponseEntity<List<Ticket>> getTicket(){
		List<Ticket> allTickets = mmtService1.getAllTickets();
		return ResponseEntity.ok(allTickets);	
	}
	
	@DeleteMapping("deleteTicket/{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id") Integer ticketId){
		String deleteTicket = mmtService1.deleteTicket(ticketId);
		return ResponseEntity.ok(deleteTicket);		
	}
	
	@PutMapping("/updateTicket/{id}")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Passenger passenger, @PathVariable("id") Integer ticketId){
		Ticket updateTicket = mmtService1.updateTicket(passenger, ticketId);
		return ResponseEntity.ok(updateTicket);			
	}
}
