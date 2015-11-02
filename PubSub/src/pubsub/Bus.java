package pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bus {

	private Set<Publisher> publishers = new HashSet<Publisher>();

	private Map<Subscriber, ArrayList<String>> subscriberMap = new HashMap<Subscriber, ArrayList<String>>();

	/**
	 * Adds the given Publisher to the system.
	 * 
	 * @param pub
	 *            The given Publisher object
	 * @return Returns true if the Publisher was added successfully else return
	 *         false
	 */
	public boolean addPublisher(Publisher pub) {

		if (pub == null || pub.getPublisher().getType() == null || pub.getPublisher().getType().contains(null))
			return false;
		return publishers.add(pub.getPublisher());

	}

	/**
	 * Removes the given Publisher from the system.
	 * 
	 * @param pub
	 *            The given Publisher object
	 * @return Returns true if the Publisher was removed successfully else
	 *         returns false
	 */
	public boolean removePublisher(Publisher pub) {

		if (pub == null || pub.getPublisher() == null)
			return false;
		return publishers.remove(pub.getPublisher());
	}

	/**
	 * Subscribes a given Subscriber with the given subscription type
	 * 
	 * @param subscriber
	 *            The given Subscriber object
	 * @param type
	 *            Type of subscription
	 * @return Returns true if the subscription was successfully applied for the
	 *         given type
	 */
	public boolean subscribe(Subscriber subscriber, String type) {

		boolean flag = false;

		if (subscriber != null && type != null) {

			for (Publisher pub : publishers) {

				if (pub.getPublisher().getType().contains(type)) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return false;

			NewSubscriber newSubscriber = subscriber.getSubscriber();
			ArrayList<String> temp = subscriberMap.get(newSubscriber);

			if (temp != null) {
				if (temp.contains(type))
					return false;

				subscriberMap.get(newSubscriber).add(type);
				return true;
			} else {
				ArrayList<String> tempType = new ArrayList<String>();
				tempType.add(type);
				subscriberMap.put(newSubscriber, tempType);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the given subscriber from the system.
	 * 
	 * @param sub
	 *            The given Subscriber object
	 * @return Returns true if the Subscriber was removed successfully else
	 *         returns false
	 */
	public boolean removeSubscriber(Subscriber sub) {

		if (sub == null || sub.getSubscriber() == null)
			return false;
		if (subscriberMap.remove(sub.getSubscriber()) != null)
			return true;
		else
			return false;
	}

	/**
	 * Removes the subscription from the given type.
	 * 
	 * @param subscriber
	 *            The given Publisher object
	 * @param type
	 *            Type of subscription
	 * @return Returns true if the subscription of the type <code>type</code>
	 *         was removed successfully else returns false
	 */
	public boolean unsubscribe(Subscriber subscriber, String type) {

		if (subscriber != null && type != null) {

			NewSubscriber newSubscriber = subscriber.getSubscriber();
			ArrayList<String> temp = subscriberMap.get(newSubscriber);

			if (temp != null) {
				if (temp.remove(type)) {
					if (temp.size() == 0) {
						subscriberMap.remove(newSubscriber);
						return true;
					}
					subscriberMap.replace(newSubscriber, temp);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Publishes the given message from Publisher
	 * 
	 * @param publisherName
	 *            The given Publisher object
	 * @param messageDetails
	 *            Message to be published
	 * @return Returns true if the subscription of the type <b>type</b> was
	 *         removed successfully else returns false
	 */
	public boolean publishMessage(Publisher publisherName, Message messageDetails) {

		if (publisherName != null && messageDetails != null) {

			NewPublisher publisher = publisherName.getPublisher();
			if (!publishers.contains(publisher)) {

				return false;
			}

			for (Subscriber sub : subscriberMap.keySet()) {

				if (subscriberMap.get(sub).contains(messageDetails.getMessage().getMetadata().getMessageType())) {

					sub.getSubscriber().receivedMessage(messageDetails);

				}

			}

		}
		return false;

	}

}
