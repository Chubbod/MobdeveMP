package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku.game;

public class SudokuChecker {
    private static SudokuChecker instance;

    private SudokuChecker() {
    }

    public static SudokuChecker getInstance() {
        if(instance==null) {
            instance = new SudokuChecker();
        }
        return instance;
    }

    //Checking Horizontally, Vertically, and Regionally.
    //Return true if all is good, false if all is not
    public boolean SudokuCheck(int[][] sudoku) {
        return (HorizontalCheck(sudoku) || VerticalCheck(sudoku) || RegionalCheck(sudoku));
    }

    //Checking Regionally
    private boolean RegionalCheck(int[][] sudoku) {
        for(int xReg = 0; xReg < 3; xReg++) {
            for(int yReg = 0; yReg < 3; yReg++) {
                if(!RegionalChecks(sudoku, xReg, yReg)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Condition Equation to checking regionally
    private boolean RegionalChecks(int[][] sudoku, int xReg, int yReg) {
        for(int i = xReg * 3; i < xReg * 3 + 3; i++) {
            for(int j = yReg * 3; j < yReg * 3 + 3; j++) {
                for(int k = i; k < xReg * 3 + 3; k++) {
                    for(int l = j; l < yReg * 3 + 3; l++) {
                        if(((k!=i || l!=j) && sudoku[i][j] == sudoku[k][l]) || sudoku[k][l] == 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    //Checking Vertically
    private boolean VerticalCheck(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[i][j]==0) {
                    return false;
                }

                for(int k = j + 1; j < 9; j++) {
                    if(sudoku[i][j] == sudoku[i][k] || sudoku[i][k] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //Checking Horizontally
    private boolean HorizontalCheck(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[j][i]==0) {
                    return false;
                }

                for(int k = j + 1; j < 9; j++) {
                    if(sudoku[j][i] == sudoku[k][i] || sudoku[k][i] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
