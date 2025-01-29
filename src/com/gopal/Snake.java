package com.gopal;

public class Snake {
    private final int start;
    private final int downPosition;

    public int getDownPosition() {
        return downPosition;
    }

    public int getStart() {
        return start;
    }

    public Snake(int start, int downPosition, GetLaddersSnackesUsers instance) throws Exception {
        if (start >= 100) {
            throw new Exception("start position should be less then 100");
        }

        if (downPosition < 1) {
            throw new Exception("start position should be graeter then 0");
        }

        if (start <= downPosition) {
            throw new Exception("start position should be graeter then down position for snake");
        }

        checkSnakePositionsExist(start, downPosition, instance);

        checkLadderAndSnakePositionsSame(start, downPosition, instance);
        this.start = start;
        this.downPosition = downPosition;
    }

    private void checkSnakePositionsExist(int start, int downPosition, GetLaddersSnackesUsers instance)
            throws Exception {
        Boolean found = instance.getSnakes().stream()
                .anyMatch(snake -> snake.getStart() == start || snake.getStart() == downPosition
                        || snake.getDownPosition() == start || snake.getDownPosition() == downPosition);

        if (found) {
            throw new Exception("snake position is already exist");
        }
    }

    private void checkLadderAndSnakePositionsSame(int start, int downPosition, GetLaddersSnackesUsers instance)
            throws Exception {
        Boolean found = instance.getLadders().stream().anyMatch(ladder -> ladder.getUpPosition() == downPosition
                || ladder.getUpPosition() == start || ladder.getStart() == downPosition || ladder.getStart() == start);

        if (found) {
            throw new Exception("ladder and snake positions can not be same");
        }
    }

    @Override
    public String toString() {
        return "Snake [start=" + start + ", downPosition=" + downPosition + "]";
    }

}
