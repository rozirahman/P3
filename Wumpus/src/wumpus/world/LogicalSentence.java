package wumpus.world;



public class LogicalSentence {	
	public LogicalConnector getLogicalConnector(){
		return null;
	}
	
	public int getNumberSimpleSentences() {
		return 0;
	}
	
	public LogicalSentence getSimplerSentence(int idx) {
		return null;
	}
	
	public boolean isNotSentence() {
		return hasLogicalConnector(LogicalConnector.NOT);
	}
	
	public boolean isAndSentence() {
		return hasLogicalConnector(LogicalConnector.AND);
	}
	
	public boolean isOrSentence() {
		return hasLogicalConnector(LogicalConnector.OR);
	}
	
	public boolean isImplicationSentence() {
		return hasLogicalConnector(LogicalConnector.IMPLICATION);
	}
	
	public boolean isBiimplicationSentence() {
		return hasLogicalConnector(LogicalConnector.BIIMPLICATION);
	}
	
	public boolean isPropositionSymbol(){
		return getLogicalConnector() == null;
	}
	
	public boolean isUnarySentence(){
		return hasLogicalConnector(LogicalConnector.NOT);
	}
	
	//not a simple and not a unary
	public boolean isBinarySentence(){
		return getLogicalConnector() != null && !hasLogicalConnector(LogicalConnector.NOT);
	}
	
	protected boolean hasLogicalConnector(LogicalConnector connector) {
		// Note: can use '==' as Connective is an enum.
		return getLogicalConnector().equals(connector);
	}
	
	public String bracketSentenceIfNecessary(LogicalConnector connector,
			LogicalSentence sentence) {
		String result = null;
		if (sentence instanceof ComplexLogicalSentence) {
			ComplexLogicalSentence cs = (ComplexLogicalSentence) sentence;
			if (cs.connector.precedence < connector.precedence) {
				result = "(" + sentence + ")";
			}
		}

		if (result == null) {
			result = sentence.toString();
		}

		return result;
	}
}
