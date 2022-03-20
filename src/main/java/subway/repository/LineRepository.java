package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Line;
import subway.domain.Station;

public class LineRepository {

	private static final List<Line> lines = new ArrayList<>();

	public LineRepository() {
		lines.add(new Line("2호선"));
		lines.add(new Line("3호선"));
		lines.add(new Line("신분당선"));
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

	public static void addStationListInLine(List<Station> stationList, Line line) {
		for (Station station : stationList) {
			lines.get(lines.indexOf(line)).addStationList(station);
		}
	}

}
