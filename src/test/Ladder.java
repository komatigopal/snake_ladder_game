package test;

public class Ladder {
	private int start;
	private int upPosition;

	public int getUpPosition() {
		return upPosition;
	}

	public void setUpPosition(int upPosition) {
		this.upPosition = upPosition;
	}

	public int getStart() {
		return start;
	}

	public void setstart(int start) {
		this.start = start;
	}

	public Ladder(int start, int upPosition, GetLaddersSnackesUsers instance) throws Exception {
		if (start < 1) {
			throw new Exception("start position should be greater then 0");
		}

		if (upPosition > 100) {
			throw new Exception("start position should be less then or equal to 100");
		}

		if (upPosition <= start) {
			throw new Exception("up position should be greater then end position for snake");
		}

		checkLadderPositionsExist(start, upPosition, instance);
		this.start = start;
		this.upPosition = upPosition;
	}

	private void checkLadderPositionsExist(int start, int upPosition, GetLaddersSnackesUsers instance)
			throws Exception {
		Boolean found = instance.getLadders().stream().anyMatch(ladder -> ladder.getUpPosition() == upPosition
				|| ladder.getUpPosition() == start || ladder.getStart() == upPosition || ladder.getStart() == start);

		if (found) {
			throw new Exception("ladder position is already exist");
		}
	}

	@Override
	public String toString() {
		return "Ladder [start=" + start + ", upPosition=" + upPosition + "]";
	}

}
