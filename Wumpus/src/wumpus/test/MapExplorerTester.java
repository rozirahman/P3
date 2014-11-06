package wumpus.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import wumpus.world.Cell;
import wumpus.world.CellInfo;
import wumpus.world.Map;

public class MapExplorerTester {

	public static void main(String[] arg) {
		HashMap<Cell, CellInfo> visitedNodes = new HashMap<Cell, CellInfo>();
		HashMap<Cell, CellInfo> nextQueue = new HashMap<Cell, CellInfo>();
		HashMap<Cell, CellInfo> unknownNodes = new HashMap<Cell, CellInfo>();
		HashMap<Cell, CellInfo> unsafeNodes = new HashMap<Cell, CellInfo>();

		Map m = new Map();
		Cell c0 = Map.cell[0];
		CellInfo ci0 = new CellInfo(c0);
		visitedNodes.put(c0, ci0);

		Cell[] cells = m.getNeighbors(c0.getId());

		CellInfo ci1 = new CellInfo(cells[0]);
		CellInfo ci2 = new CellInfo(cells[1]);
		CellInfo ci3 = new CellInfo(cells[2]);

		nextQueue.put(cells[0], ci1);
		nextQueue.put(cells[1], ci2);
		nextQueue.put(cells[2], ci3);

		if (visitedNodes.containsKey(c0)) {
			System.out.println(c0 + " has been visited");

		}

		for (Cell c : cells) {
			if (nextQueue.containsKey(c)) {
				System.out.println(c + " is in the next queue");
			}
			if (unknownNodes.containsKey(c)) {
				System.out.println(c + " is in unknown nodes");
			}
			if (unsafeNodes.containsKey(c)) {
				System.out.println(c + " is in unsafe nodes");
			}
		}
		
		LinkedHashMap<Integer, Integer> linkedMap = new LinkedHashMap<Integer, Integer>();
		linkedMap.put(3, 5);
		linkedMap.put(7, 23);
		linkedMap.put(1, 2);
		
		Set<Integer> key = linkedMap.keySet();
		for(Integer i : key){
			System.out.println(i + "\t" + linkedMap.get(i));
		}
	}
}
