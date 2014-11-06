package wumpus.world;

import java.util.Arrays;

public class AdjacencyList {

	final int NEIGHBOURS_SIZE = 3;
	Cell[] neighbours;

	public AdjacencyList() {
		this(null, null, null);
	}

	public AdjacencyList(Cell cell1, Cell cell2, Cell cell3) {
		neighbours = new Cell[NEIGHBOURS_SIZE];
		initializeNeighbours();
		setNeighbours(cell1, cell2, cell3);
	}

	private void initializeNeighbours() {
		for (int i = 0; i < NEIGHBOURS_SIZE; i++) {
			neighbours[i] = new Cell();
		}
	}

	public void setNeighbours(Cell cell1, Cell cell2, Cell cell3) {
		neighbours[0] = cell1;
		neighbours[1] = cell2;
		neighbours[2] = cell3;
	}

	public Cell[] getNeighbours() {
		return neighbours;
	}

	@Override
	public String toString() {
		return "AdjacencyList [neighbours=" + Arrays.toString(neighbours) + "]";
	}
}
