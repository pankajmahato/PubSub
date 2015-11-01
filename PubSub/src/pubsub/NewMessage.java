package pubsub;

/**
 * This is a concrete Message class implementing the Message interface. This
 * contains the <b>Metadata</b> and the <b>Payload</b>.
 *
 */
public class NewMessage implements Message {

	private MessageMetadata metadata;
	private MessagePayload payload;

	public NewMessage(MessageMetadata metadata, MessagePayload payload) {
		this.metadata = metadata;
		this.payload = payload;
	}

	public MessageMetadata getMetadata() {
		return metadata;
	}

	public MessagePayload getPayload() {
		return payload;
	}

	@Override
	public NewMessage getMessage() {
		return this;
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub

	}

}
