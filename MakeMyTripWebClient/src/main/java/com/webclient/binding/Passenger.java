package com.webclient.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {

	private Integer pid;

	private String name;

	private String journeyDate;

	private Integer trainNum;

	private String destination;
}
