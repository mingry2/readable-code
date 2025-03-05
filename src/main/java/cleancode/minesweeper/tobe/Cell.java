package cleancode.minesweeper.tobe;

public class Cell {

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    // final 불편 데이터 명시
    private int nearbyLandMineCount;
    private boolean isLandMine;
    private boolean isFlagged;
    private boolean isOpened;

    private Cell(int nearbyLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        this.nearbyLandMineCount = nearbyLandMineCount;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    // 생성자로 new Cell() 말고도 정적 팩터링 메서드로 객체를 생성할 수도 있다.
    // Cell.of(sing); -> 이름을 줄 수 있다. 검증도 서로 다르게 할수도있고
    public static Cell of(int nearbyLandMineCount, boolean isLandMine, boolean isFlagged, boolean isOccupied) {
        return new Cell(nearbyLandMineCount, isLandMine, isFlagged, isOccupied);
    }

    public static Cell create() { // 빈 셀을 생성
        return of(0,  false, false, false);
    }

    public void turnOnLandMine() { // 지뢰 셀
        this.isLandMine = true;
    }

    public void open() {
        this.isOpened = true;
    }

    public String getSign() {
        // 열림
        if (isOpened) {
            if (isLandMine) {
                return LAND_MINE_SIGN;
            }
            if (hasLandMineCount()) {
                return String.valueOf(nearbyLandMineCount);
            }
            return EMPTY_SIGN;
        }

        // 닫힘
        if (isFlagged) {
            return FLAG_SIGN;
        }

        return UNCHECKED_SIGN;
    }

    public void updateNearbyLandMineCount(int count) {
        this.nearbyLandMineCount = count;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public boolean isLandMine() {
        return isLandMine;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean hasLandMineCount() {
        return this.nearbyLandMineCount != 0;
    }
}
