package wumpus.test;

import wumpus.world.Map;


public class CellTester {

	public static void main(String[] arg){
		Map map = new Map();
		System.out.println(Map.cell[0].equals(Map.cell[0]));
		System.out.println(Map.cell[0].equals(Map.cell[1]));
	}
}
