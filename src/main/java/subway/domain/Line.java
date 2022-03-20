package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private String name;

	private List<Station> stationList;

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
}