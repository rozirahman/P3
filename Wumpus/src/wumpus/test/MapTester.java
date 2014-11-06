package wumpus.test;

import wumpus.world.Cell;
import wumpus.world.Map;

public class MapTester {

	public static void main(String[] args) {
		Map map = new Map();
//		System.out.println(map);
//		map.printCells();
		
		Cell start = Map.cell[0];
		System.out.println(start);
	}
}