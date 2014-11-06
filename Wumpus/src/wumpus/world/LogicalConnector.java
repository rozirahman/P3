package wumpus.world;

import java.util.ArrayList;

/**
 * 
 * @author 130026145
 *
 */
public class LogicalConnector {
	public static final LogicalConnector NOT = new LogicalConnector("~", 1);
	public static final LogicalConnector AND = new LogicalConnector("&", 2);
	public static final LogicalConnector OR = new LogicalConnector("|", 3);
	public static final LogicalConnector IMPLICATION = new LogicalConnector(
			"=>", 4);
	public static final LogicalConnector BIIMPLICATION = new LogicalConnector(
			"<=>", 5);
	ArrayList<Character> connectorChar = new ArrayList<Character>();
	ArrayList<LogicalConnector> connectorList = new ArrayList<LogicalConnector>();

	String connector;
	int precedence;

	public LogicalConnector(String connector, int precedence) {
		this.connector = connector;
		this.precedence = precedence;
	}

	public LogicalConnector() {
		fillConnectorString();
		fillConnectorChar();
	}

	private void fillConnectorString() {
		connectorList.add(NOT);
		connectorList.add(AND);
		connectorList.add(OR);
		connectorList.add(IMPLICATION);
		connectorList.add(BIIMPLICATION);
	}

	private void fillConnectorChar() {
		connectorChar.add('~');
		connectorChar.add('&');
		connectorChar.add('|');
		connectorChar.add('=');
		connectorChar.add('<');
		connectorChar.add('>');
	}

	public boolean isConnectorChar(char c) {
		return connectorChar.contains(c);
	}

	public boolean isAConnector(String connector) {
		boolean isConnector = false;

		if (NOT.connector.equals(connector)) {
			isConnector = true;
		} else if (AND.connector.equals(connector)) {
			isConnector = true;
		} else if (OR.connector.equals(connector)) {
			isConnector = true;
		} else if (IMPLICATION.connector.equals(connector)) {
			isConnector = true;
		} else if (BIIMPLICATION.connector.equals(connector)) {
			isConnector = true;
		}

		return isConnector;
	}

	public LogicalConnector getConnector(String connector) {
		LogicalConnector theConnector = null;
		if (NOT.connector.equals(connector)) {
			theConnector = NOT;
		} else if (AND.connector.equals(connector)) {
			theConnector = AND;
		} else if (OR.connector.equals(connector)) {
			theConnector = OR;
		} else if (IMPLICATION.connector.equals(connector)) {
			theConnector = IMPLICATION;
		} else if (BIIMPLICATION.connector.equals(connector)) {
			theConnector = BIIMPLICATION;
		}
		return theConnector;
	}
	
	public String toString(){
		String output = "";
		if (NOT.connector.equals(connector)) {
			output = NOT.connector;
		} else if (AND.connector.equals(connector)) {
			output = AND.connector;
		} else if (OR.connector.equals(connector)) {
			output = OR.connector;
		} else if (IMPLICATION.connector.equals(connector)) {
			output = IMPLICATION.connector;
		} else if (BIIMPLICATION.connector.equals(connector)) {
			output = BIIMPLICATION.connector;
		}
		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connector == null) ? 0 : connector.hashCode());
		result = prime * result + precedence;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		LogicalConnector other = (LogicalConnector) obj;
		if (connector == null) {
			if (other.connector != null)
				return false;
		} else if (!connector.equals(other.connector))
			return false;
		if (precedence != other.precedence)
			return false;
		return true;
	}

}
