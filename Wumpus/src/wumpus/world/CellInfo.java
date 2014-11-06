package wumpus.world;

public class CellInfo {

	Cell cell;
	// observed is four boolean elements representing observed situation of the
	// room after visited
	// the first represents pit, the second represents the bat, the third
	// represents the wumpus, the fourth represents the gold
	// it's empty in the beginning
	boolean[] observed;
	// predicted is four boolean elements representing predicted situation of
	// the room by its neighbour
	// the first represents pit, the second represents the bat, the third
	// represents the wumpus, the fourth represents the gold
	// it's empty in the beginning
	boolean[] predicted;
	// sensed is four boolean elements representing observed situation of the
	// room after visited
	// the first represents breeze, the second represents the rattling sound,
	// the third represents the stench, the fourth represents the glitter
	boolean[] sensed;
	boolean visited;
	double weight;

	public final static int BREEZE = 0;
	public final static int RATTLE = 1;
	public final static int SMELLY = 2;
	public final static int GLITTER = 3;

	public final static int PIT = 0;
	public final static int BAT = 1;
	public final static int WUMPUS = 2;
	public final static int GOLD = 3;

	public CellInfo(Cell cell) {
		this.cell = cell;
		observed = new boolean[4];
		predicted = new boolean[4];
		sensed = new boolean[4];
		visited = false;
		weight = 1;

		initialiseSensed();
	}

	private void initialiseSensed() {
		sensed[BREEZE] = cell.hasBreeze();
		sensed[RATTLE] = cell.isRattling();
		sensed[SMELLY] = cell.isSmelly();
		sensed[GLITTER] = cell.hasGlitter();
	}

	public void setObserved(boolean pit, boolean bat, boolean wumpus,
			boolean gold) {
		observed[PIT] = pit;
		observed[BAT] = bat;
		observed[WUMPUS] = wumpus;
		observed[GOLD] = gold;
	}

	public void setPredicted(boolean pit, boolean bat, boolean wumpus,
			boolean gold) {
		predicted[PIT] = pit;
		predicted[BAT] = bat;
		predicted[WUMPUS] = wumpus;
		predicted[GOLD] = gold;
		setWeight();
	}

	public void noPitPredicted(){
		predicted[PIT] = false;
	}
	
	public void noBatPredicted(){
		predicted[BAT] = false;
	}
	
	public void noWumpusPredicted(){
		predicted[WUMPUS] = false;
	}
	
	private void setWeight() {
		if (predicted[PIT]) {
			weight -= 0.3;
		}
		if (predicted[BAT]) {
			weight -= 0.3;
		}
		if (predicted[WUMPUS]) {
			weight -= 0.3;
		}
	}

	public int getId(){
		return cell.getId(); 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cell == null) ? 0 : cell.hashCode());
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
		CellInfo other = (CellInfo) obj;
		if (cell == null) {
			if (other.cell != null)
				return false;
		} else if (!cell.equals(other.cell))
			return false;
		return true;
	}

	public void setVisited(boolean visited){
		this.visited = visited;
	}
	
	public boolean getVisited(){
		return visited;
	}
}
