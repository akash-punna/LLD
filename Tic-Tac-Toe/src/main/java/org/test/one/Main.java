package org.test.one;

import org.test.one.Model.PlayingPiece;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game=new TicTacToeGame();
        game.initialize();
        System.out.println("winner is "+ game.startGame());
    }
}