package didiInterviewEscapeFromMaze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 时间限制：1秒
 * 
 * 空间限制：32768k
 * 
 * 题目描述
 * 
 * 小青蛙有一天不小心落入了一个地下迷宫，小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。
 * 为了让问题简单，假设这是一个n*m的各自迷宫。迷宫每个位置为0或者1. 0代表这个位置有障碍物，
 * 小青蛙到达不了这个位置；1代表小青蛙可以达到的位置。小青蛙出事在(0,0)位置。
 * 地下迷宫的出口在(0,m-1)(保证这两个位置都是1，并且保证一定有起点到终点可达的路径)。
 * 小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值。向上爬一个单位距离需要消耗3个体力值，
 * 向下移动不消耗体力值。当小青蛙的体力值等于0时候还没有到达出口，小青蛙将无法逃离迷宫。
 * 现在需要你帮助小青蛙计算出能否用今生的体力值跳出迷宫（即达到(0,m-1)的位置）
 * 
 * 输入：
 * 
 * 输入 n+1行：
 * 
 * 第一行为3个整数n,m(3<=m,n<=10),P(1<=P<=100)
 * 
 * 接下来的n行：
 * 
 * 每行m个0或者1，以空格分隔
 * 
 * 
 * 输出：
 * 
 * 如果能逃离迷宫，则输出一行体力消耗最小的路径，输出格式见样例所示；如果不能逃离迷宫，则输出“Can not escape!”。
 * 
 * 测试数据保证答案唯一
 * 
 * 输入例子：
 * 
 * 4 4 10
 * 
 * 1 0 0 1 1 1 0 1 0 1 1 1 0 0 1 1 输出例子：
 * 
 * [0,0],[1,0],[1,1],[2,1],[2,2],[2,3],[1,3],[0,3]
 * 
 * @author kai
 *
 */
public class DidiEscapeFromMaze {

	public static void main(String[] args) {
		int m = 4, n = 4;
		int[][] maze = { { 1, 0, 0, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 1 }, { 0, 0, 1, 1 } };
		int P = 10;
		FindPathForFrog(maze, P);

	}

	public static void FindPathForFrog(int[][] maze, int P) {
		Queue<Integer[]> route = new LinkedList<Integer[]>();
		if(findPath(maze, P, 0, 0, route, P)<0)
			System.out.println("Can not escape!");
	}

	private static int findPath(int[][] maze, int restEnergy, int n, int m, Queue<Integer[]> route, int oe) {
		// when out of range or frog cannot get through from this place, then
		// return
		if (n < 0 || m < 0 || n > maze.length - 1 || m > maze[0].length - 1 || maze[n][m] == 0 || restEnergy < 0)
			return -oe;

		// Reach exit with negative energy
		if (n == 0 && m == maze[0].length - 1 && restEnergy < 0) {
			return -oe;
		}

		// Reach to exit with non-negative energy
		if (n == 0 && m == maze[0].length - 1 && restEnergy >= 0) {
			route.add(new Integer[] { 0, 0 });
			for (Integer[] element : route) {
				if (element.length != 2)
					System.err.println("Error ocurred!");
				System.out.println("[" + element[0] + "," + element[1] + "]");
			}
			return restEnergy;
		}
//		System.out.println("n: " + n + " m: " + m + " rest: " + restEnergy);
		if (maze[n][m] == 1)
			route.add(new Integer[] { n, m });
		int fromUp = findPath(maze, restEnergy - 3, n + 1, m, route, oe);
		int fromright = findPath(maze, restEnergy - 1, n, m + 1, route, oe);
		int fromdown = findPath(maze, restEnergy, n - 1, m, route, oe);

		int mam = Math.max(fromUp, Math.max(fromright, fromdown));

		if (mam == fromUp)
			route.add(new Integer[] { n + 1, m });
		else if (mam == fromright)
			route.add(new Integer[] { n, m + 1 });
		else if (mam == fromdown)
			route.add(new Integer[] { n - 1, m });
		return mam;
	}

}
