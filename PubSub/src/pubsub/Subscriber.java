package pubsub;

/**
 * 
 * This is a generic Interface which should be implemented when creating
 * different Subscriber Classes
 *
 */
public interface Subscriber {

	public void receivedMessage(Message message);

	public NewSubscriber getSubscriber();

}
