package dfs;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[][] grid;
    private static boolean[][] visited;
    private static int n_length;
    private static int m_length;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        n_length = n;
        m_length = m;
        grid = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    visited = new boolean[n_length][m_length];
                    counter = 0;
                    int local_max = dfs(i, j);
                    if (local_max > max) {
                        max = local_max;
                    }
                }
            }
        }

        System.out.println(max);
    }

    static int counter = 0;

    public static int dfs(int i, int j) {
        counter++;
        visited[i][j] = true;
        if (i - 1 >= 0 && j - 1 >= 0 && !visited[i - 1][j - 1]) {
            if (grid[i - 1][j - 1] == 1) {
                dfs(i - 1, j - 1);
            }
        }
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            if (grid[i - 1][j] == 1) {
                dfs(i - 1, j);
            }
        }
        if (i - 1 >= 0 && j + 1 < m_length && !visited[i - 1][j + 1]) {
            if (grid[i - 1][j + 1] == 1) {
                dfs(i - 1, j + 1);
            }
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            if (grid[i][j - 1] == 1) {
                dfs(i, j - 1);
            }
        }
        if (j + 1 < m_length && !visited[i][j + 1]) {
            if (grid[i][j + 1] == 1) {
                dfs(i, j + 1);
            }
        }
        if (i + 1 < n_length && j - 1 >= 0 && !visited[i + 1][j - 1]) {
            if (grid[i + 1][j - 1] == 1) {
                dfs(i + 1, j - 1);
            }
        }
        if (i + 1 < n_length && !visited[i + 1][j]) {
            if (grid[i + 1][j] == 1) {
                dfs(i + 1, j);
            }
        }
        if (i + 1 < n_length && j + 1 < m_length && !visited[i + 1][j + 1]) {
            if (grid[i + 1][j + 1] == 1) {
                dfs(i + 1, j + 1);
            }
        }
        return counter;
    }

}