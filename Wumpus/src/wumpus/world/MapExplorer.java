package wumpus.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapExplorer {
	Map map;
	HashMap<Cell, CellInfo> visitedNodes;
	ArrayList<Cell> visitedKey;
	LinkedHashMap<Cell, CellInfo> nextToGo;
	ArrayList<Cell> nextKey;
	HashMap<Cell, CellInfo> unknownNodes;
	HashMap<Cell, CellInfo> unsafeNodes;
	Cell current;

	boolean hasGold = false;
	boolean reachExit = false;
	
	public MapExplorer() {
		map = new Map();
		visitedNodes = new HashMap<Cell, CellInfo>();
		nextToGo = new LinkedHashMap<Cell, CellInfo>();
		nextKey = new ArrayList<Cell>();
		unknownNodes = new HashMap<Cell, CellInfo>();
		unsafeNodes = new HashMap<Cell, CellInfo>();

		initialiseStart();
	}

	private void initialiseStart() {
		Cell start = Map.cell[0];
		CellInfo cell = new CellInfo(start);
		// should be all false
		cell.setObserved(start.isPit(), start.isBat(), start.isWumpus(),
				start.isGold());
		// should be all false
		cell.setPredicted(start.isPit(), start.isBat(), start.isWumpus(),
				start.isGold());
		cell.setVisited(true);
		visitedNodes.put(start, cell);
		visitedKey.add(start);
		checkNeighbors(start);
	}
	
	private void checkNeighbors(Cell cell){
		Cell[] neighbors = map.getNeighbors(cell.getId());
		boolean safeNeighbors = isSafeNeighbors(cell);
		for(Cell c : neighbors){
			//this is wrong
			//skip only if the neighbor has been visited (safe) or in nextToGo (safe) or unsafeNode(already known to be unsafe)
			if(visitedNodes.containsKey(c) || nextToGo.containsKey(c) || unsafeNodes.containsKey(c)){
				continue;
			}
			//first, a cell in unknown if there is a true value for pit/bat/wumpus
			//check one by one, if current cell predicted false, change the respective prediction value from unknown to false
			//if all are false, move to toGo
				//fire check all its parent neighbors (case C4 goes to UnSafe)
			if(unknownNodes.containsKey(c)){
				CellInfo cellInfo = unknownNodes.get(c);
				if(!cell.hasBreeze()){
					cellInfo.noPitPredicted();
				}
				if(!cell.isRattling()){
					cellInfo.noBatPredicted();
				}
				if(!cell.isSmelly()){
					cellInfo.noWumpusPredicted();
				}
				
				if(isSafeNow(cellInfo)){
					nextToGo.put(c, cellInfo);
					nextKey.add(c);
					unknownNodes.remove(c);
					
					checkParentNeighbors(c);
				}
			}else{
				CellInfo cInfo = new CellInfo(c);
				cInfo.setPredicted(cell.isPit(), cell.isBat(), cell.isWumpus(), cell.isGold());
				
				if(safeNeighbors){
					nextToGo.put(c, cInfo);
					nextKey.add(c);
				}else{
					unknownNodes.put(c, cInfo);
				}
			}					
		}
		current = cell;
	}
	
	//how now brown co TODO
	
	
	private void checkParentNeighbors(Cell cell){
		Cell[] parents = map.getNeighbors(cell.getId());
		
		for(Cell c : parents){
			//check only if it has been visited
			if(visitedNodes.containsKey(c)){
				Cell[] kids = map.getNeighbors(c.getId());
				ArrayList<Cell> temp = new ArrayList<Cell>();
				for(Cell k : kids){
					if(unknownNodes.containsKey(k))
						temp.add(k);
				}
				
				if(temp.size() == 1){
					//there is only one cell in unknown from this parent then it should be put in the unsafe
					Cell t = temp.get(0);
					unsafeNodes.put(t, unknownNodes.get(t));
					unknownNodes.remove(t);
				}
			}
		}
	}
	
	private boolean isSafeNeighbors(Cell cell){
		return !cell.hasBreeze() && !cell.isRattling() && !cell.isSmelly();
	}
	
	private boolean isSafeNow(CellInfo cellInfo){
		return !cellInfo.predicted[CellInfo.PIT] && !cellInfo.predicted[CellInfo.BAT] && !cellInfo.predicted[CellInfo.WUMPUS];
	}

	public void exploreMap() {
		//have to make sure the order in cellKey is the same with the order of the key in nextQueue
		while(!hasGold){
			if(!nextToGo.isEmpty()){
				Cell toGo = nextKey.get(0);
				
				if(!map.isDirectlyConnected(current, toGo)){
					for(Cell c : visitedKey){
						if(map.isDirectlyConnected(c, current) && map.isDirectlyConnected(c, toGo)){
							//this operation only wants to show the agent do backtracking
							current = c;
//							break;
						}
					}
				}
				
				//now current is directly connected to toGo
				//remove toGo from nextToGo
				CellInfo next = nextToGo.remove(toGo);
				next.setObserved(toGo.isPit(), toGo.isBat(), toGo.isWumpus(), toGo.isGold());
				//update the value
				//put into visited
				//remove from nextKey
				
			}
		}
	}
}
