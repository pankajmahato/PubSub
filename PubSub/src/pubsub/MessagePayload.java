package pubsub;

/**
 * This is a Message Payload class which contains the main content of the
 * message which will be sent and received
 */
public class MessagePayload {

	private String messageContent;

	public MessagePayload(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageContent() {
		return messageContent;
	}

}
