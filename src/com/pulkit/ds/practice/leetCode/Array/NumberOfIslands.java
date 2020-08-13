package com.pulkit.ds.practice.leetCode.Array;

//Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
public class NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = {
				{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}
		};
		int noOfIslands = numIslands(grid);
		System.out.println(noOfIslands);
	}

	private static int numIslands(char[][] grid) {
		int count = 0;
		int m = grid.length;
		if(m==0){
			return count;
		}
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]=='1'){
					dfs(i,j,m,n,grid);
					count++;
				}
			}
		}
		return count;
	}

	private static void dfs(int i, int j, int m, int n, char[][] grid) {
		if(i<0 || j<0 || i>=m || j>=n || grid[i][j]!='1'){
			return;
		}
		grid[i][j]='0';
		dfs(i,j+1,m,n,grid);
		dfs(i,j-1,m,n,grid);
		dfs(i+1,j,m,n,grid);
		dfs(i-1,j,m,n,grid);
	}
}
