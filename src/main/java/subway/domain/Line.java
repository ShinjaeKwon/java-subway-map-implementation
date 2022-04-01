package subway.domain;

import java.util.ArrayList;
import java.util.List;

import subway.handler.view.ErrorView;

public class Line {
	private static final int LINE_NAME_LENGTH_STANDARD = 2;
	private final String name;

	private final List<Station> stationList;

	public Line(String name) {
		checkLineNameValid(name);
		this.name = name;
		this.stationList = new ArrayList<>();
	}

	private void checkLineNameValid(String name) {
		if (name.length() < LINE_NAME_LENGTH_STANDARD) {
			throw new IllegalArgumentException(ErrorView.ERROR_LINE_LENGTH);
		}
		if (!name.endsWith("선")) {
			throw new IllegalArgumentException(ErrorView.ERROR_STATION_END_CHAR_NOT_LINE);
		}

	}

	public String getName() {
		return name;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void addStation(Station station) {
		stationList.add(station);
	}

	public void addStationOrder(Station station, int order) {
		for (int i = 0; i < stationList.size(); i++) {
			if (i == order) {
				stationList.add(i, station);
				break;
			}
		}
	}
}