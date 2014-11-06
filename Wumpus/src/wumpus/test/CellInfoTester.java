package wumpus.test;

import wumpus.world.CellInfo;
import wumpus.world.Map;

public class CellInfoTester {
	public static void main(String[] arg) {
		Map map = new Map();
		
		CellInfo cell0 = new CellInfo(Map.cell[0]);
		CellInfo cell1 = new CellInfo(Map.cell[1]);
		CellInfo cell2 = new CellInfo(Map.cell[0]);
		
		System.out.println(cell0.equals(cell1));
		System.out.println(cell0.equals(cell2));
	}
}
