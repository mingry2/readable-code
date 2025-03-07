package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    boolean isChecked();

    boolean isOpened();

    String getSign();

    void flag();

    void open();

    boolean isLandMine();

    boolean hasLandMineCount();
}
