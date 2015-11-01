package pubsub;

/**
 * This is a concrete Subscriber class implementing the Subscriber interface.
 * This contains the <b>Name</b> of the subscriber.
 *
 */
public class NewSubscriber implements Subscriber {

	private String name;

	public NewSubscriber(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public NewSubscriber getSubscriber() {
		return this;
	}

	@Override
	public void receivedMessage(Message message) {
		// TODO Auto-generated method stub

		System.out.println(
				"\n" + name + " received message:\n" + message.getMessage().getPayload().getMessageContent() + "\n");

	}

}
