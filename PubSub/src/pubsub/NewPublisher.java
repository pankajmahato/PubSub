package pubsub;

import java.util.ArrayList;

/**
 * This is a concrete Publisher class implementing the Publisher interface. This
 * contains the <b>Name</b> and the subscription <b>type</b> of the publisher.
 *
 */
public class NewPublisher implements Publisher {

	private String name;
	private ArrayList<String> type = new ArrayList<String>();

	public NewPublisher(String name, ArrayList<String> type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public NewPublisher getPublisher() {
		// TODO Auto-generated method stub
		return this;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String> getType() {
		return type;
	}

}
