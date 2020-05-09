package dkh.demo.service1.rs.converters;

import dkh.demo.service1.rs.apimodel.HelloResponse;

public class StringIntoHelloResponseConverter {

	public static HelloResponse converter(String message) {
		return new HelloResponse(message);
	}
}
