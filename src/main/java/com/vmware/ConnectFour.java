package com.vmware;

import com.vmware.model.ConnectFourModel;
import com.vmware.util.ConnectFourUtil;

import java.util.Scanner;

/**
 * Solution for Connect Four.
 *
 * @author Srinath Tridandapani
 */
public class ConnectFour {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            int height = 6, width = 8, moves = height * width;
            ConnectFourModel board = new ConnectFourModel(width, height);
            ConnectFourUtil connectFourUtil = new ConnectFourUtil();
            System.out.println("Use 0-" + (width - 1) + " to choose a column.");
            System.out.println(board);

            for (int player = 0; moves-- > 0; player = 1 - player) {
                char symbol = ConnectFourModel.getPlayers()[player];
                System.out.print("\nPlayer " + symbol + " turn: ");
                int col = input.nextInt();
                connectFourUtil.chooseAndDrop(symbol, col, board);

                System.out.println(board);
                if (connectFourUtil.isWinningPlay(board)) {
                    System.out.println("Player " + symbol + " wins!");
                    return;
                }
            }
            System.out.println("Game over, no winner.");
        }
    }
}
