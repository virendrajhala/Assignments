package org.fretron.day3;

import java.util.*;

public class Day3Assignment {

    public static void main(String[] args) {
        int[][] board = handleInput();

        int[][] vis = new int[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){

                vis[i][j] = 0;
            }
        }

        Scanner s = new Scanner(System.in);

        System.out.print("Enter the coordinates for your “special” castle: ");

        int i1 = s.nextInt();
        int i2 = s.nextInt();

        board[i2][i1] = 2;

        int count = 0;
        int soldierKillCount = 0;
        findMyHomeCastleSoldiers(board,i2,i1,count,soldierKillCount,vis);
    }


    public static void findMyHomeCastleSoldiers(int[][] board, int i2, int i1, int count, int soldierKillCount, int[][] vis){

        if(i2 > 0 || i1 > 0 || i2 < board.length || i1 < board.length)
        {
            return;
        }

        if(board[i2][i1] == 2 && soldierKillCount == 11)
        {
            count++;
            return;
        }

        //downwards
        if(i1+1 < 10 && vis[i2][i1+1] != 1) {

            if(board[i2][i1] == 0)
            findMyHomeCastleSoldiers(board, i2, i1 + 1, count, soldierKillCount,vis);

            else{
                vis[i2][i1] = 1;
                findMyHomeCastleSoldiers(board, i2+1, i1, count, soldierKillCount+1,vis);
                vis[i2][i1] = 0;
            }

        }

        // left
        if(i2-1 > 0 && vis[i2-1][i1] != 1) {

            if(board[i2][i1] == 0)
                findMyHomeCastleSoldiers(board, i2-1, i1, count, soldierKillCount,vis);

            else{
                vis[i2][i1] = 1;
                findMyHomeCastleSoldiers(board, i2, i1-1, count, soldierKillCount+1,vis);
                vis[i2][i1] = 0;
            }

        }

       // right
        if(i2+1 < 10 && vis[i2+1][i1] != 1) {

            if(board[i2][i1] == 0)
                findMyHomeCastleSoldiers(board, i2+1, i1, count, soldierKillCount,vis);

            else{
                vis[i2][i1] = 1;
                findMyHomeCastleSoldiers(board, i2, i1-1, count, soldierKillCount+1,vis);
                vis[i2][i1] = 0;
            }

        }

        // upwards
        if(i1-1 > 0 && vis[i2][i1-1] != 1) {

            if(board[i2][i1] == 0)
                findMyHomeCastleSoldiers(board, i2, i1 - 1, count, soldierKillCount,vis);

            else{
                vis[i2][i1] = 1;
                findMyHomeCastleSoldiers(board, i2-1, i1, count, soldierKillCount+1,vis);
                vis[i2][i1] = 0;
            }

        }

        System.out.println(count);

    }

    public static int[][] handleInput() {

        int[][] board = new int[10][10];

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){

                board[i][j] = 0;
            }
        }

        Scanner s = new Scanner(System.in);
        for(int i=1;i<=11;i++){

            System.out.print("Enter coordinates for soldier "+i+": ");
            int i1 = s.nextInt();
            int i2 = s.nextInt();

            board[i2][i1] = 1;

            System.out.println();
        }
        return board;
    }
}
