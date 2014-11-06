package wumpus.world;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Map {

	final static int MAP_SIZE = 20;
	public final static Cell[] cell = new Cell[MAP_SIZE];
	public final static AdjacencyList[] neighbors = new AdjacencyList[MAP_SIZE];

	public Map() {
		initializeCell();
		initializeMap();
		readMap();
		initializeNeighbours();
	}

	private void initializeCell() {
		for (int i = 0; i < MAP_SIZE; i++) {
			cell[i] = new Cell(i);
		}
	}

	private void initializeMap() {
		for (int i = 0; i < MAP_SIZE; i++) {
			neighbors[i] = new AdjacencyList();
		}
	}

	private void initializeNeighbours() {
		// can we do it automatically
		neighbors[0].setNeighbours(cell[1], cell[4], cell[5]);
		neighbors[1].setNeighbours(cell[0], cell[2], cell[7]);
		neighbors[2].setNeighbours(cell[1], cell[3], cell[9]);
		neighbors[3].setNeighbours(cell[2], cell[4], cell[11]);
		neighbors[4].setNeighbours(cell[0], cell[3], cell[13]);
		neighbors[5].setNeighbours(cell[0], cell[6], cell[14]);
		neighbors[6].setNeighbours(cell[5], cell[7], cell[15]);
		neighbors[7].setNeighbours(cell[1], cell[6], cell[8]);
		neighbors[8].setNeighbours(cell[7], cell[9], cell[16]);
		neighbors[9].setNeighbours(cell[2], cell[8], cell[10]);
		neighbors[10].setNeighbours(cell[9], cell[11], cell[17]);
		neighbors[11].setNeighbours(cell[3], cell[10], cell[12]);
		neighbors[12].setNeighbours(cell[11], cell[13], cell[18]);
		neighbors[13].setNeighbours(cell[4], cell[12], cell[14]);
		neighbors[14].setNeighbours(cell[5], cell[13], cell[19]);
		neighbors[15].setNeighbours(cell[6], cell[16], cell[19]);
		neighbors[16].setNeighbours(cell[8], cell[15], cell[17]);
		neighbors[17].setNeighbours(cell[10], cell[16], cell[18]);
		neighbors[18].setNeighbours(cell[12], cell[17], cell[19]);
		neighbors[19].setNeighbours(cell[14], cell[15], cell[18]);

		for (int i = 0; i < MAP_SIZE; i++) {
			Cell[] neighbours = neighbors[i].getNeighbours();
			setNeighboursConfiguration(cell[i], neighbours);
		}
	}

	public Cell[] getNeighbors(int i) {
		return neighbors[i].getNeighbours();
	}

	public void readMap() {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("map.txt"));
			int idx = 0;
			while (sc.hasNextLine()) {
				String[] data = sc.nextLine().split(",");
				for (int i = 0; i < data.length; i++) {
					setCellConfiguration(cell[idx++], data[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
	}

	// S,X,B,P,W,E

	private void setCellConfiguration(Cell cell, String input) {
		if (input.equals("S")) {
			cell.setStart(true);
		} else if (input.equals("B")) {
			cell.setBat(true);
		} else if (input.equals("P")) {
			cell.setPit(true);
		} else if (input.equals("W")) {
			cell.setWumpus(true);
		} else if (input.equals("E")) {
			cell.setExit(true);
		} else if (input.equals("G")) {
			cell.setGold(true);
		}
	}

	public boolean isDirectlyConnected(Cell c1, Cell c2) {
		Cell[] neighbors = getNeighbors(c1.getId());
		for (Cell c : neighbors) {
			if (c2.equals(c)) {
				return true;
			}
		}

		return false;
	}

	private void setNeighboursConfiguration(Cell cell, Cell[] neighbours) {
		for (int i = 0; i < neighbours.length; i++) {
			if (cell.isBat()) {
				neighbours[i].setRattling(true);
			}
			if (cell.isGold()) {
				neighbours[i].setGlitter(true);
			}
			if (cell.isPit()) {
				neighbours[i].setBreeze(true);
			}
			if (cell.isWumpus()) {
				neighbours[i].setSmelly(true);
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < MAP_SIZE; i++) {
			sb.append(i + ": " + neighbors[i] + "\n");
		}
		return sb.toString();
	}

	// public void printCells() {
	// for (int i = 0; i < MAP_SIZE; i++) {
	// System.out.println(cell[i]);
	// }
	// }
}
