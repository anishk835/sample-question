package com.java.recruitme.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
 
class SubMatrixSum {
    
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        String[] inp = br.readLine().split(" ");
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);
        int Q = Integer.parseInt(inp[2]);
        int[][] A = new int[N][M];
        for(int i=0;i<N;i++)
        {
            String[] inp1 = br.readLine().split(" ");
            for(int j=0;j<M;j++) 
            {
                A[i][j] = Integer.parseInt(inp1[j]);
            }
        }
        getSummationmatrix(N, M, A);
        for(int i=0;i<Q;i++) 
        {
            String[] inp2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(inp2[0]);
            int y1 = Integer.parseInt(inp2[1]);
            int x2 = Integer.parseInt(inp2[2]);
            int y2 = Integer.parseInt(inp2[3]);
            int out_ = solve(N, M, A, x1, y1, x2, y2);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }
    
    static int[][] dp;
    
    private static void getSummationmatrix(int N, int M, int[][] A) {
        dp = new int[N + 1][M + 1];
        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                dp[i][j] = A[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        
    }
    static int solve(int N, int M, int[][] A, int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
    }
}