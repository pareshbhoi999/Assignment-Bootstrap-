package graphs;

import java.util.Scanner;

public class Graphs {

	int arr[][];
	int no_nodes;
	Scanner sc = new Scanner(System.in);
	
	public Graphs()
	{
		arr = null;
		no_nodes = 0;
	}
	
	public void createGraph()
	{
		System.out.println("Enter no. of vertices:: ");
		no_nodes = sc.nextInt();
		
		arr = new int[no_nodes][no_nodes];
		
		for(int i=0;i<no_nodes;i++)
		{
			System.out.println("Enter adjacency for vertex "+(i+1)+" ::  ");
			for(int j=0;j<no_nodes;j++)
			{
				System.out.println("\t"+(i+1)+"->"+(j+1)+"::  ");
				int adj = sc.nextInt();
				
				if(adj==1 || adj==0)
				{
					arr[i][j] = adj;
				}//if				
			}//j
		}//i
		
	}//createGraph
	
	public void adjacencyMatrix()
	{
		int i,j;
		
		for(i=0;i<no_nodes;i++)
		{
			for(j=0;j<no_nodes;j++)
			{
				System.out.print("\t"+arr[i][j]);
			}
			System.out.println("");
		}
	}
	
	public void degree()
	{
		int i,j,deg=0;
		
		for(i=0;i<no_nodes;i++)
		{
			deg=0;
			for(j=0;j<no_nodes;j++)
			{
				if(arr[i][j]==1)
					deg++;
			}
			System.out.println("Degree of vertex "+(i+1)+" :: "+deg);
		}
	}
	
	public void DFS()
	{
		int i, j, k = 0, visited[];

		visited = new int[no_nodes];
		//initialize to 0 since it is array of counter
		for (i = 0;i < no_nodes;i++)
			visited[i] = 0;

		for (i = 0; i< no_nodes; i++)  
		{
			if(visited[i]==0)
			{
			     System.out.print("  "+(i+1));
			}
			visited[i] = 1;
			k=i;
			for (j = 0; j<no_nodes;)
			{
				if (arr[k][j] != 0) //!arr[i][j]
				{
					if (visited[j] == 0) //not visited
					{
						System.out.print("  "+(j+1));
						visited[j] = 1;
						k = j;
						j = 0;
					}
					else  j++;
				}
				else  j++;
			}//for_j
		}//for_i
		//display pending unvisited nodes
		for (; i < no_nodes; i++)
			System.out.print("  "+(i+1));		
	}//DFS
	
	public void BFS()
	{
		int i, j, k = 0, visited[];
		visited = new int[no_nodes];
		for (i = 0;i < no_nodes;i++)
			visited[i] = 0;

		System.out.print("1 ");
		for (i = 0;i<no_nodes;i++)
		{
			visited[i] = 1;

			for (j = 0;j<no_nodes;)
			{
				if (arr[i][j] != 0)  //or ==1
				{
					if (visited[j] == 0)  //not visited
					{
						System.out.print("   "+(j+1));
						visited[j] = 1;
					}
					else  j++;
				}
				else  j++;
			}//for_j
		}//for_i
	}//BFS

	
}//class













