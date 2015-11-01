package pubsub;

/**
 * 
 * This is a generic Interface which should be implemented when creating
 * different Message Classes
 *
 */
public interface Message {

	public NewMessage getMessage();

	public void sendMessage();

}
