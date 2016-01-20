package Algorithms.DijkstraAlgorithm;

import java.util.Random;

/**
 * Created by Sebastian Börebäck on 2016-01-20.
 */
public class DijkstraAlgorithm {



	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		Random rnd = new Random();

//		int[][] matrix = new int[5][5];

		int[][] matrix = {
				{0,6 ,11,16,33},
				{3,7 ,12,17,24},
				{3,8 ,13,18,999},
				{4,9 ,999,19,22},
				{5,10,15,20,12},
		};

		//updates with new nodes
		int[] distance = new int[5];
		//have allready visit
		int[] visited = new int[5];
		//acutall path
		int[] preD = new int[5];
		int min, nextNode= 0;

		System.out.println("Enter the matrix");

//		//fill matrix with random nr from 1-10
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				matrix[i][j] = rnd.nextInt(10);
//			}
//		}



		//first row
		distance = matrix[0];
		//start pos
		distance[0] = 0;
		//allready visit
		visited[0] = 1;

		//start algorith
		for (int i = 0; i < 5; i++) {
			min = 999;
			for (int j = 0; j < 5; j++) {
				if (min > distance[j] && visited[j] != 1) {
					min = distance[j];
					nextNode = j;
				}
			}

			visited[nextNode] = 1;

			//actuall algorithm
			for (int c = 0; c < 5; c++) {

				if (visited[c] != 1) {
					if (min + matrix[nextNode][c] < distance[c]) {
						distance[c] = min + matrix[nextNode][c];
						preD[c] = nextNode;
					}
				}

			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.print("|" + distance[i]);
		}
		System.out.println("|");

		//pritn path
		for (int i = 0; i < 5; i++) {
			int j;
			System.out.print("path = " + i);
			j = i;

			do {
				j = preD[j];
				System.out.print(" <- "+j);
			} while (j != 0);

			System.out.println("");
		}
	}
}
