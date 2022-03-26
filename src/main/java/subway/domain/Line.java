package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private final String name;

	private final List<Station> stationList;

	public Line(String name) {
		this.name = name;
		this.stationList = new ArrayList<>();
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