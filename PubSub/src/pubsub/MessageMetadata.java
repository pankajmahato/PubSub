package pubsub;

import java.util.Date;

/**
 * This is a message metadate class which contains some important information
 * regarding the message
 */
public class MessageMetadata {

	private String messageType;
	private String messageTitle;
	private Date time;

	public MessageMetadata(String messageType, String messageTitle, Date time) {
		this.messageType = messageType;
		this.messageTitle = messageTitle;
		this.time = time;
	}

	public String getMessageType() {
		return messageType;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public Date getTime() {
		return time;
	}

}
