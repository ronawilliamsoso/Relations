package com.example.relations.exceptions;


public enum ErrorCode {

	SUCCESS("200"),
	NO_CONTENT("204.001"),

	BAD_REQUEST("400.001"),
	NO_SEARCH_PARAMETER_DEFINED("400.002"),
	NOT_FOUND("404.001"),

	INTERNAL_SERVER_ERROR("500");
	
	private String code;
	
	private ErrorCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static ErrorCode fromValue(String code) {
		for (ErrorCode t : values()) {
			if (t.getCode().equals(code)) {
				return t;
			}
		}
		return INTERNAL_SERVER_ERROR;
	}
}
