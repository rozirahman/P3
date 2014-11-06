package wumpus.world;

public class Cell {
	int id;
	boolean breeze;
	boolean rattling;
	boolean smelly;
	boolean glitter;
	boolean pit;
	boolean bat;
	boolean wumpus;
	boolean gold;
	boolean start;
	boolean exit;

	public Cell() {
		this(-1);
	}

	public Cell(int id) {
		this.id = id;
	}

	public boolean hasBreeze() {
		return breeze;
	}

	public void setBreeze(boolean breeze) {
		this.breeze = breeze;
	}

	public boolean isRattling() {
		return rattling;
	}

	public void setRattling(boolean rattling) {
		this.rattling = rattling;
	}

	public boolean isSmelly() {
		return smelly;
	}

	public void setSmelly(boolean smelly) {
		this.smelly = smelly;
	}

	public boolean hasGlitter() {
		return glitter;
	}

	public void setGlitter(boolean glitter) {
		this.glitter = glitter;
	}

	public int getId() {
		return id;
	}

	public boolean isPit() {
		return pit;
	}

	public void setPit(boolean pit) {
		this.pit = pit;
	}

	public boolean isBat() {
		return bat;
	}

	public void setBat(boolean bat) {
		this.bat = bat;
	}

	public boolean isWumpus() {
		return wumpus;
	}

	public void setWumpus(boolean wumpus) {
		this.wumpus = wumpus;
	}

	public boolean isGold() {
		return gold;
	}

	public void setGold(boolean gold) {
		this.gold = gold;
	}

	public boolean isStart() {
		return start;
	}

	public void setStart(boolean start) {
		this.start = start;
	}

	public boolean isExit() {
		return exit;
	}

	public void setExit(boolean exit) {
		this.exit = exit;
	}	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Cell other = (Cell) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cell [id=" + id + ", brz=" + breeze + ", rtl="
				+ rattling + ", sml=" + smelly + ", glt=" + glitter
				+ ", pit=" + pit + ", bat=" + bat + ", wumpus=" + wumpus
				+ ", gold=" + gold + ", strt=" + start + ", xit=" + exit
				+ "]";
	}

}
