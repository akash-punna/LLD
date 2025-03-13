package org.test.one;

import org.test.one.Model.*;


import java.util.*;

public class TicTacToeGame {
    Board board;
    Deque<Player> players;
    public void initialize()
    {
        LinkedList<Player> list=new LinkedList<>();
        Player p1=new Player("player1", new PieceX());
        Player p2=new Player("player2",new PieceO());

        list.add(p1);
        list.add(p2);
        this.players=list;
        this.board=new Board(3);
    }

    public String startGame()
    {
        boolean noWinner = true;

        while(noWinner) {
            //getFreeSpaces() -> tie
            Player currPlayer = players.getFirst();
            players.removeFirst();

            boolean isFull = board.isFull();
            if(isFull)
            {
                return "tie";
            }

            board.printBoard();
            //user input
            System.out.println("Enter co-ordinates between 0  and 2 ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            boolean isCorrectPlace=board.addPiece(currPlayer.piece,inputRow,inputColumn);
            if(!isCorrectPlace)
            {
                System.out.println("Not a correct path, please try again");
                players.addFirst(currPlayer);
                continue;
            }

            players.addLast(currPlayer);

            boolean winner = isThereWinner(inputRow, inputColumn, currPlayer.piece);
            if(winner)
            {
                noWinner=false;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int x, int y, PlayingPiece p)
    {
        boolean rowMatch =true, colMatch = true, diagonalMatch =true , aDiagonalMatch = true;
        for(int i=0;i<board.size;i++)
        {
            if(board.board[x][i]== null|| board.board[x][i]!=p) {
                rowMatch = false;
                break;
            }
        }

        for(int i=0;i<board.size;i++)
        {
            if(board.board[i][y]== null|| board.board[i][y]!=p) {
                colMatch = false;
                break;
            }
        }

        for(int i=0,j=0;i<board.size;i++,j++)
        {
            if(board.board[i][j]==null || board.board[i][j]!=p)
            {
                diagonalMatch=false;
                break;
            }
        }

        for(int i=0,j=board.size-1;i<board.size;i++,j--)
        {
            if(board.board[i][j]==null || board.board[i][j]!=p)
            {
                aDiagonalMatch=false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || aDiagonalMatch;
    }
}
