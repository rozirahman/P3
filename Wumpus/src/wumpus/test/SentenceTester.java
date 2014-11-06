package wumpus.test;

import wumpus.world.ComplexLogicalSentence;
import wumpus.world.LogicalConnector;

public class SentenceTester {

	// ~A & B | C
	// (
	public static void main(String[] arg){			
		ComplexLogicalSentence propSymbol = new ComplexLogicalSentence(null, null, "A");
		System.out.println(propSymbol);
		ComplexLogicalSentence[] sen = new ComplexLogicalSentence[1];
		sen[0] = propSymbol;
		
		ComplexLogicalSentence notSymbol = new ComplexLogicalSentence(LogicalConnector.NOT, sen, null);
		System.out.println(notSymbol);
	}
}
