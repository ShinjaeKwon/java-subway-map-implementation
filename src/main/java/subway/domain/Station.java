package subway.domain;

import subway.handler.view.ErrorView;

public class Station {

	public static final int STATION_NAME_LENGTH_STANDARD = 2;
	private final String name;

	public Station(String name) {
		checkStationNameValid(name);
		this.name = name;
	}

	private void checkStationNameValid(String name) {
		if (name.length() < STATION_NAME_LENGTH_STANDARD) {
			throw new IllegalArgumentException(ErrorView.ERROR_STATION_LENGTH);
		}
		if (!name.endsWith("역")) {
			throw new IllegalArgumentException(ErrorView.ERROR_STATION_END_CHAR_NOT_STATION);
		}
	}

	public String getName() {
		return name;
	}

}