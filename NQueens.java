public class NQueens {
    private int row;
    private int queens;
    private int collumns;
    int [][] board;
    public NQueens(int n)
    {
        row = n;
        collumns = n;
        queens = n;
        board = new int[n][n];

    }
    public boolean placeNQueens() throws Exception
    {
        if (queens < 1)
            throw new Exception();
        if (queens < 4 && queens > 1)
            throw new Exception();
        if (row==queens)
            return true;
        for (int col=0; col<queens; col++)
        {
            if(!isAttacked(row, col))
                board[row][col] = 1;
            row++;
            if(placeNQueens())
                return true;
            else
                board[row][col] = 0;
        }
        row = queens;
        return false;
    }
    public boolean isAttacked(int row, int col)
    {
        int i, j;
        for (i = 0; i < queens; i++)
        {
            for ( j = 0; j < queens; j++)
                if (board[i][j] == 1)
                    if (i == row || j == col)
                        return true;
                    for (int k = i, l = j; k < queens || l < queens; k++,l++)
                        if (i+k == row && j+l == col)
                            return true;
        }
        return false;
    }

    public void printToConsole()
    {
        for (int i = 0; i < queens; i++)
        {
            for (int j = 0; j < queens; j++)
            {
                if (board[i][j] == 0)
                    System.out.print("_ ");
                else
                    System.out.print("Q ");
            }
            System.out.println();
        }
    }
}
