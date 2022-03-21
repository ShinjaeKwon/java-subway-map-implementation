package subway.repository;

import static subway.repository.StationRepository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Line;
import subway.domain.Station;

public class LineRepository {

	private static final List<Line> lines = new ArrayList<>();

	public static void init() {
		lines.add(new Line("2호선"));
		lines.add(new Line("3호선"));
		lines.add(new Line("신분당선"));
		initLine();
	}

	private static void initLine() {
		Line line2 = findLine("2호선");
		Line line3 = findLine("2호선");
		Line shinBunDangLine = findLine("2호선");
		addStationInLine(findStation("교대역"), findStation("역삼역"), line2.getName());
		line2.addStationOrder(findStation("강남역"), 1);
		addStationInLine(findStation("교대역"), findStation("매봉역"), line3.getName());
		line3.addStationOrder(findStation("남부터미널역"), 1);
		line3.addStationOrder(findStation("양재역"), 2);
		addStationInLine(findStation("강남역"), findStation("양재시민의숲역"), shinBunDangLine.getName());
		shinBunDangLine.addStationOrder(findStation("양재역"), 1);
	}

	public List<Line> lines() {
		return Collections.unmodifiableList(lines);
	}

	public void addLine(Line line) {
		lines.add(line);
	}

	public boolean deleteLineByName(String name) {
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
		return lines.stream().filter(station -> station.getName().equals(lineName)).findFirst().orElse(null);
	}

	public static boolean findExistLineName(String name) {
		return lines.stream().anyMatch(line -> line.getName().equals(name));
	}

}