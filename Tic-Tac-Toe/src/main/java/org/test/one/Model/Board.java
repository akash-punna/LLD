package org.test.one.Model;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size)
    {
        this.size=size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(PlayingPiece piece, int x, int y)
    {
        if(board[x][y]!=null) return false;
        board[x][y]=piece;
        return true;
    }

    public boolean isFull()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(board[i][j]==null) return false;
            }
        }

        return true;
    }

    public void printBoard() {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType + "   ");
                } else {
                    System.out.print("    ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
    }


}
