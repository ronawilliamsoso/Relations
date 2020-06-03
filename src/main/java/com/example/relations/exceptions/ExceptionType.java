package com.example.relations.exceptions;


public enum ExceptionType {
	OPEN_DRAW_NOT_EXIST("20101", "Open draw period does not exist "),
	DRAW_PERIOD_NOT_EXIST("20102", "The given draw period number could not be found "),
	DRAW_PERIOD_ALREADY_APPROVED("20103", "The given draw period is already approved."),
	DRAW_PERIOD_ALREADY_IMPORTED("20104", "The given draw period is already imported"),
	DRAW_PERIOD_ALREADY_EXPORTED("20105", "The given draw period is already exported"),
	PRIZE_EXPORT_PATH_UNDEFINED("20106", "Prize export directory is undefined."),
	DRAW_IMPORT_PATH_UNDEFINED("20107", "Draw import directory is undefined."),
	DRAW_FILE_CHECKSUM_INVALID("20108", "The md5 checksum of the file does not match with given checksum before read."),
	DIRECTORY_PATH_UNDEFINED("20109", "The given directory name could not be found."),
	TICKET_FILE_CHECKSUM_INVALID("20110", "The md5 checksum of ticket file does not match with given checksum before read."),
	TICKET_FILE_RECORD_COUNT_NOT_MATCHED("20111", "The number of the records do not match with given number of records before reading ticket file."),
	TICKET_FILE_ALREADY_IMPORTED("20112", "The ticket file for draw period is already imported"),
	TICKET_FILE_NOT_EXPORTED("20113", "The ticket file for draw period could not be exported."),
	DRAW_PERIOD_FILE_NOT_EXIST("20114", "The draw period file could not be found."),
	CHECKSUM_NOT_CALCULATED("20115", "Checksum of the file cannot be calculated."),
	DRAW_PERIOD_CUTOFF_NOT_EXIST("20116", "DrawPeriodCutOff cannot be found with the given drawPeriodNumber and paymentMethod."),
	DRAW_PERIOD_CUTOFF_ALREADY_EXIST("20117", "DrawPeriodCutOff already exists with the given drawPeriodNumber and paymentMethod."),
	DRAW_PERIOD_ALREADY_EXIST("20118", "DrawPeriod already exists with the given code."),
	DRAW_REMOVAL_NOT_ALLOWED("20119", "Draw removal not allowed since the draw period is in a non changable state"),
	DRAW_NOT_EXIST("20120", "The given draw number could not be found "),
	DRAW_ALREADY_EXIST("20121", "Draw already exists with the given code."),
	PRIZE_NOT_EXIST("20122", "The given prize could not be found."),
	DRAW_MASK_NOT_EXIST("20123", "The given draw mask could not be found."),
	DRAW_PRIZE_NOT_EXIST("20124", "The given draw prize could not be found."),
	DERIVED_DRAW_PRIZE_NOT_EXIST("20125", "The given derived draw prize could not be found."),
	DRAW_PRIZE_ALREADY_EXIST("20126", "Draw prize already exists with the given code."),
	TICKET_NOT_LOADED("20127", "No tickets are loaded for the given draw period"),
	DRAW_PERIOD_NOT_EXIST_OR_NOT_IMPORTED("20128", "The given drawPeriodNumber could not be found or the draw period is not imported yet");
	
	private String errorCode;
	private String errorMessage;
	
	ExceptionType(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
