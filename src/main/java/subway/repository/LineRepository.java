package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Line;
import subway.domain.Station;

public class LineRepository {

	public static final List<Line> lines = new ArrayList<>();

	public static List<Line> getLines() {
		return lines;
	}

	public static void deleteStationInLine(Line deleteLine, Station deleteStation) {
		List<Station> stationList = deleteLine.getStationList();
		stationList.remove(deleteStation);
	}

	public static List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	public static void addLine(Line line) {
		lines.add(line);
	}

	public static boolean deleteLineByName(String name) {
		return lines.removeIf(line -> Objects.equals(line.getName(), name));
	}

	public static void addStationInLine(Station ascend, Station descend, String lineName) {
		for (Line line : lines) {
			if (line.getName().equals(lineName)) {
				line.addStation(ascend);
				line.addStation(descend);
			}
		}
	}

	public static Line findLine(String lineName) {
		return lines.stream()
			.filter(station -> station.getName().equals(lineName))
			.findFirst()
			.orElse(null);
	}

	public static boolean findExistLineName(String name) {
		return lines.stream()
			.anyMatch(line -> line.getName().equals(name));
	}

}