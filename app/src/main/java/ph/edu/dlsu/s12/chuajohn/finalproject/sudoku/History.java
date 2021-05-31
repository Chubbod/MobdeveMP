package ph.edu.dlsu.s12.chuajohn.finalproject.sudoku;

public class History {
    private String difficulty = "";
    private String time = "";

    public History(){}

    public History(String difficulty, String time) {
        this.difficulty = difficulty;
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
