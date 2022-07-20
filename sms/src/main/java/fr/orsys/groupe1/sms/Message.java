package fr.orsys.groupe1.sms;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Message {

	private String[] receivers;
	private String message;
	private String priority;
	private boolean senderForResponse;
	
	@JsonProperty("receivers")
    private List<String> destinataires;
    
    @JsonProperty("message")
    private String contenu;
    
    @JsonProperty("priority")
    private String priorite;
    
    @JsonProperty("senderForResponse")
    private boolean autoriseReponse;

	public Message(String message, String[] receivers, String priority, boolean senderForResponse) {
		super();
		this.receivers = receivers;
		this.message = message;
		this.priority = priority;
		this.senderForResponse = senderForResponse;
	}

	public String[] getReceivers() {
		return receivers;
	}

	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public boolean isSenderForResponse() {
		return senderForResponse;
	}

	public void setSenderForResponse(boolean senderForResponse) {
		this.senderForResponse = senderForResponse;
	}

	@Override
	public String toString() {
		return "Message [receivers=" + Arrays.toString(receivers) + ", message=" + message + ", priority=" + priority
				+ ", senderForResponse=" + senderForResponse + "]";
	}

}
