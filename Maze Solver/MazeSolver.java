/**
 * this file is called MazeSolver. It's used to
 * solve a maze problem. It contains a MazeSolver class
 * it can find a shortest path for a maze from start to end
 * Xianghong Lin
 * xil113@ucsd.edu
 * A16632477
 *
 */

import java.util.ArrayList;

public abstract class MazeSolver {


	/**
	 * this will return a square which stores the solution for
	 * maze.
	 * @param maze
	 * @param pq
	 * @return
	 */
	public static Square solve(Maze maze, PriorityQueue<Integer,Square> pq) {
		pq.add(maze.start.getCost(), maze.start);
		while(!pq.isEmpty()){
			Entry cur = pq.poll();
			Square curSquare = (Square) cur.value;
			curSquare.visit();
			if(curSquare.getCol() == maze.finish.getCol() &&
					curSquare.getRow() == maze.finish.getRow()){
				return curSquare;
			}
			else {
				ArrayList<Square> neighbors = neighbors(maze,curSquare);
				if(neighbors.size() >0) {
					for(Square s: neighbors){
						int curCost = (int) cur.key;
						curCost = curCost + s.getCost();
						if(curCost < s.getRunningCost()){

							s.setPrevious(curSquare);
							s.setRunningCost(curCost);
							pq.add(curCost, s);
						}

					}
				}
			}

		}
		return null;
	}


	/**
	 * This helper method will return the neighbors of a given Square in a maze.
	 *
	 * @param maze a maze
	 * @param cur given Square
	 * @return a arraylist of neighbor square.
	 */
	private static ArrayList<Square> neighbors(Maze maze, Square cur){
		ArrayList<Square> neighbors = new ArrayList<>();

		//north neighbor
		if( (cur.getRow()-1)>=0  &&
				!( maze.contents[cur.getRow()-1][cur.getCol()].getIsWall() )  &&
				!( maze.contents[cur.getRow()-1][cur.getCol()].isVisited() ) )

			neighbors.add(maze.contents[cur.getRow()-1][cur.getCol()]);


		//south neighbor
		if( (cur.getRow()+1)<maze.rows  &&
				!(maze.contents[cur.getRow()+1][cur.getCol()].getIsWall()) &&
				!(maze.contents[cur.getRow()+1][cur.getCol()].isVisited()) )

			neighbors.add( maze.contents[cur.getRow()+1][cur.getCol()] );

		//east neighbor
		if(  (cur.getCol()+1)<maze.cols  &&
				!( maze.contents[cur.getRow()][cur.getCol()+1].getIsWall()) &&
				!( maze.contents[cur.getRow()][cur.getCol()+1].isVisited() ) )

			neighbors.add(maze.contents[cur.getRow()][cur.getCol()+1]);


		//west neighbor
		if( (cur.getCol()-1)>=0  &&
				!( maze.contents[cur.getRow()][cur.getCol()-1].getIsWall()) &&
				!( maze.contents[cur.getRow()][cur.getCol()-1].isVisited() ) )

			neighbors.add( maze.contents[cur.getRow()][cur.getCol()-1] );



		return neighbors;
	}



}
	
