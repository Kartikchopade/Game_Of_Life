package game_of_life;

public class Game_of_life
{

    public static void main(String[] args)
    {
        int col = 3, row = 4;
        // Initializing the board.
        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };
        System.out.println("Matrix");
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (board[i][j] == 0)
                {
                    System.out.print(" 0 ");
                } 
                else 
                {
                    System.out.print(" 1 ");
                }
            }
            System.out.println();
        }
        System.out.println();

        int[][] next = new int[row][col];

        // Loop for each cell
        for (int l = 0; l < row; l++)
        {
            for (int m = 0; m < col; m++)
            {
                // toatal live Neighbours
                int liveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                {
                    for (int j = -1; j <= 1; j++)
                    {
                        if ((l + i >= 0 && l + i < row) && (m + j >= 0 && m + j < col))
                        {
                            liveNeighbours = liveNeighbours + board[l + i][m + j];
                        }
                        //System.out.println(liveNeighbours);
                    }
                }
                liveNeighbours = liveNeighbours - board[l][m];

                // Implementing the Rules 
                // live is < 2 change to 0
                if ((board[l][m] == 1) && (liveNeighbours < 2))
                {
                    next[l][m] = 0;
                } // live is more than 3 chnage to 0 
                else if ((board[l][m] == 1) && (liveNeighbours > 3))
                {
                    next[l][m] = 0;
                } //live is exact 3 then change 1
                else if ((board[l][m] == 0) && (liveNeighbours == 3))
                {
                    next[l][m] = 1;
                } // Remains the same
                else {
                    next[l][m] = board[l][m];
                }

            }
        }

        System.out.println("OUTPUT");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (next[i][j] == 0) {
                    System.out.print(" 0 ");
                } else {
                    System.out.print(" 1 ");
                }
            }
            System.out.println();

        }

    }
}
