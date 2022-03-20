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
		initLine();
	}

	private static void initLine() {
		Line line2 = findLine("2호선");
		Line line3 = findLine("2호선");
		Line shinbundangLine = findLine("2호선");
		line2.addStation(StationRepository.findStation("교대역"));
		line2.addStation(StationRepository.findStation("강남역"));
		line2.addStation(StationRepository.findStation("역삼역"));
		line3.addStation(StationRepository.findStation("교대역"));
		line3.addStation(StationRepository.findStation("남부터미널역"));
		line3.addStation(StationRepository.findStation("양재역"));
		line3.addStation(StationRepository.findStation("매봉역"));
		shinbundangLine.addStation(StationRepository.findStation("강남역"));
		shinbundangLine.addStation(StationRepository.findStation("양재역"));
		shinbundangLine.addStation(StationRepository.findStation("양재시민의숲역"));
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

	public void addStationInLine(Station ascend, Station descend, String lineName) {
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

	public boolean findLineName(String name) {
		return lines.stream().anyMatch(line -> line.getName().equals(name));
	}

}