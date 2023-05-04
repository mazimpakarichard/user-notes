package rw.user.notes.exceptions;

import org.springframework.http.HttpStatus;

public class ResponseObject {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static String sucessMessage = "action completed sucessfully";

	private String message ;

	private HttpStatus status;

	private Object response;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getMessage() {
		return message;
	}


	public HttpStatus getStatus() {
		return status;
	}

	public Object getResponse() {
		return response;
	}

	public ResponseObject(HttpStatus status, Object response) {
		this.response = response;
		this.status = status;

	}

	public ResponseObject(Object response, HttpStatus status) {
		this.response = response;
		this.status = status;

	}
	
	public ResponseObject(String message, HttpStatus status) {
		this.message = message;
		this.status = status;

	}

}
