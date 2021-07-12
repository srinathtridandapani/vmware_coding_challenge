package com.vmware.util;

import com.vmware.ConnectFour;
import com.vmware.model.ConnectFourModel;

/**
 * A utility class representing ConnectFour functions and returns the board state.
 *
 * @author Srinath Tridandapani
 */
public class ConnectFourUtil {


    /**
     * Allows a user to input their symbol on to the board.
     *
     * @return ConnectFour - State of the board.
     */
    public ConnectFourModel chooseAndDrop(char symbol, Integer col, ConnectFourModel connectFour) {
        do {
            if (! (0 <= col && col < connectFour.getWidth())) {
                System.out.println("Column must be between 0 and " +
                        (connectFour.getWidth() - 1));
                throw new IllegalStateException("Column must be between 0 and " +
                        (connectFour.getWidth() - 1));
            }
            for (int h = connectFour.getHeight() - 1; h >= 0; h--) {
                if (connectFour.getGrid()[h][col] == '.') {
                    connectFour.getGrid()[h][col] = symbol;
                    connectFour.setLastTop(h);
                    connectFour.setLastCol(col);
                    return connectFour;
                }
            }

            System.out.println("Column " + col + " is full.");
        } while (true);
    }

    /**
     * Checks if a player is won on the board, depending on the state.
     *
     * @return true if any players move matches either horizonal, vertical, diagonal or backslashDiagonal.
     */
    public boolean isWinningPlay(ConnectFourModel connectFour) {
        if (connectFour.getLastCol() == -1) {
            throw new IllegalStateException("No move has been made yet");
        }
        char sym = connectFour.getGrid()[connectFour.getLastTop()][connectFour.getLastCol()];
        String streak = String.format("%c%c%c%c", sym, sym, sym, sym);
        return contains(this.horizontal(connectFour), streak) ||
                contains(this.vertical(connectFour), streak) ||
                contains(this.slashDiagonal(connectFour), streak) ||
                contains(this.backslashDiagonal(connectFour), streak);
    }

    /**
     * State of a row containing the last played chip.
     */
    private String horizontal(ConnectFourModel connectFour) {
        return new String(connectFour.getGrid()[connectFour.getLastTop()]);
    }

    /**
     * State of a column containing the last played chip.
     */
    private String vertical(ConnectFourModel connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());
        for (int h = 0; h < connectFour.getHeight(); h++) {
            sb.append(connectFour.getGrid()[h][connectFour.getLastCol()]);
        }
        return sb.toString();
    }

    /**
     * State of a diagonal containing the last played chip
     */
    private String slashDiagonal(ConnectFourModel connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());
        for (int h = 0; h < connectFour.getHeight(); h++) {
            int w = connectFour.getLastCol() + connectFour.getLastTop() - h;
            if (0 <= w && w < connectFour.getWidth()) {
                sb.append(connectFour.getGrid()[h][w]);
            }
        }
        return sb.toString();
    }

    /**
     * State of a reverse diagonal containing the last played chip
     */
    private String backslashDiagonal(ConnectFourModel connectFour) {
        StringBuilder sb = new StringBuilder(connectFour.getHeight());
        for (int h = 0; h < connectFour.getHeight(); h++) {
            int w = connectFour.getLastCol() - connectFour.getLastTop() + h;
            if (0 <= w && w < connectFour.getWidth()) {
                sb.append(connectFour.getGrid()[h][w]);
            }
        }
        return sb.toString();
    }

    private boolean contains(String pattern, String matchedInput) {
        return pattern.indexOf(matchedInput) >= 0;
    }


}
