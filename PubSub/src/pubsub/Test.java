package pubsub;

import java.util.ArrayList;
import java.util.Date;

public class Test {
	/**
	 * 
	 * main method to demonstrate the program
	 */
	public static void main(String[] args) {

		/**
		 * Creating the <b>Bus</b> object to perform send and receive
		 * functionalities
		 */
		Bus bus = new Bus();

		// Creating the list of subscriptions offered by publisher one
		ArrayList<String> publisherOneArray = new ArrayList<String>();
		publisherOneArray.add("Science");
		publisherOneArray.add("Entertainment");

		// Creating the publisher one object
		Publisher publisherOne = new NewPublisher("Publisher one", publisherOneArray);

		// Creating the list of subscriptions offered by publisher two
		ArrayList<String> publisherTwoArray = new ArrayList<String>();
		publisherTwoArray.add("Science");
		publisherTwoArray.add("Music");

		// Creating the publisher two object
		Publisher publisherTwo = new NewPublisher("Publisher two", publisherTwoArray);

		// Adding all the publishers to the system
		if (bus.addPublisher(publisherOne))
			System.out.println(publisherOne.getPublisher().getName() + " added successfully");
		else
			System.out.println(publisherOne.getPublisher().getName() + " was not added");
		if (bus.addPublisher(publisherTwo))
			System.out.println(publisherTwo.getPublisher().getName() + " added successfully");
		else
			System.out.println(publisherTwo.getPublisher().getName() + " was not added");

		// Creating two subscribers
		Subscriber subscrberOne = new NewSubscriber("Subscriber one");
		Subscriber subscriberTwo = new NewSubscriber("Subscriber two");

		// Subscribing the subscribers to available types
		if (bus.subscribe(subscrberOne, "Science"))
			System.out.println(subscrberOne.getSubscriber().getName() + " subscribed to " + "Science");
		else
			System.out.println(subscrberOne.getSubscriber().getName() + " cannot be subscribed to " + "Science");
		if (bus.subscribe(subscriberTwo, "Music"))
			System.out.println(subscriberTwo.getSubscriber().getName() + " subscribed to " + "Music");
		else
			System.out.println(subscrberOne.getSubscriber().getName() + " cannot be subscribed to " + "Music");
		if (bus.subscribe(subscrberOne, "Music"))
			System.out.println(subscrberOne.getSubscriber().getName() + " subscribed to " + "Music");
		else
			System.out.println(subscrberOne.getSubscriber().getName() + " cannot be subscribed to " + "Music");
		// Comedy type subscription is not offered by any publisher so it will
		// not be added
		if (bus.subscribe(subscrberOne, "Comedy"))
			System.out.println(subscrberOne.getSubscriber().getName() + " subscribed to " + "Comedy");
		else
			System.out.println(subscrberOne.getSubscriber().getName() + " cannot be subscribed to " + "Comedy");

		// Creating the messages which will be sent to the system
		Message msg1 = new NewMessage(new MessageMetadata("Science", "Science title", new Date()),
				new MessagePayload("This is the content of Science message"));
		Message msg2 = new NewMessage(new MessageMetadata("Entertainment", "Entertainment title", new Date()),
				new MessagePayload("This is the content of Entertainment message"));
		Message msg3 = new NewMessage(new MessageMetadata("Music", "Music title", new Date()),
				new MessagePayload("This is the content of Music message"));

		// Publishing all the messages but only subscribed Subscribers will
		// receive them
		System.out.println("\nPublishing all the messages");
		bus.publishMessage(publisherOne, msg1);
		bus.publishMessage(publisherTwo, msg2);
		bus.publishMessage(publisherOne, msg2);
		bus.publishMessage(publisherTwo, msg3);

		// Unsubscribing subscriber two from Music
		if (bus.unsubscribe(subscrberOne, "Music"))
			System.out.println(subscrberOne.getSubscriber().getName() + " unsubscribed from " + "Music");
		// Unsubscribing subscriber one from Entertainment
		if (bus.subscribe(subscrberOne, "Entertainment"))
			System.out.println(subscrberOne.getSubscriber().getName() + " subscribed to " + "Entertainment");

		// Publishing all the messages but only subscribed Subscribers will
		// receive them
		System.out.println("\nPublishing all the messages");
		bus.publishMessage(publisherOne, msg1);
		bus.publishMessage(publisherTwo, msg2);
		bus.publishMessage(publisherOne, msg2);
		bus.publishMessage(publisherTwo, msg3);

		// Removing subscriber one
		if (bus.removeSubscriber(subscrberOne))
			System.out.println(subscrberOne.getSubscriber().getName() + " removed");

		// Publishing all the messages but only subscribed Subscribers will
		// receive them
		System.out.println("\nPublishing all the messages");
		bus.publishMessage(publisherOne, msg1);
		bus.publishMessage(publisherTwo, msg2);
		bus.publishMessage(publisherOne, msg2);
		bus.publishMessage(publisherTwo, msg3);

		// Removing publisher one
		if (bus.removePublisher(publisherOne))
			System.out.println(publisherOne.getPublisher().getName() + " removed successfully");

		// Publishing all the messages but only subscribed Subscribers will
		// receive them
		System.out.println("\nPublishing all the messages");
		bus.publishMessage(publisherOne, msg1);
		bus.publishMessage(publisherTwo, msg2);
		bus.publishMessage(publisherOne, msg2);
		bus.publishMessage(publisherTwo, msg3);
	}

}
