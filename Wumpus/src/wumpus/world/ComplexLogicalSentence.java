package wumpus.world;

import java.util.Arrays;

public class ComplexLogicalSentence extends LogicalSentence {
	LogicalConnector connector;
	LogicalSentence[] sentences;
	String symbol = null;

	/**
	 * One connector
	 * 
	 * @param connector
	 * @param sentences
	 */
	public ComplexLogicalSentence(LogicalConnector connector,
			LogicalSentence[] sentences) {
		this.connector = connector;
		this.sentences = sentences;
	}

	public ComplexLogicalSentence(LogicalConnector connector,
			LogicalSentence[] sentences, String symbol) {
		this.connector = connector;
		this.sentences = sentences;
		this.symbol = symbol;
	}

	public int getNumberSimpleSentences() {
		return sentences.length;
	}

	public LogicalSentence getSimplerSentence(int idx) {
		return sentences[idx];
	}
	
	public LogicalConnector getLogicalConnector(){
		return connector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connector == null) ? 0 : connector.hashCode());
		result = prime * result + Arrays.hashCode(sentences);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComplexLogicalSentence other = (ComplexLogicalSentence) obj;
		if (connector == null) {
			if (other.connector != null)
				return false;
		} else if (!connector.equals(other.connector))
			return false;
		if (!Arrays.equals(sentences, other.sentences))
			return false;
		return true;
	}

	public String toString() {
		String output = "";
		if (symbol == null) {
			if (isUnarySentence()) {
				output = getLogicalConnector().toString() + " "
						+ bracketSentenceIfNecessary(getLogicalConnector(), getSimplerSentence(0));
			}
		}
		return symbol;
	}
}
