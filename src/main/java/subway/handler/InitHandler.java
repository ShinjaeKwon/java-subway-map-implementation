package subway.handler;

import static subway.repository.LineRepository.*;
import static subway.repository.StationRepository.*;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class InitHandler {

	public static void initialize() {
		initStation();
		initLine();
		initSection();
	}

	private static void initStation() {
		StationRepository.addStation(new Station("교대역"));
		StationRepository.addStation(new Station("강남역"));
		StationRepository.addStation(new Station("역삼역"));
		StationRepository.addStation(new Station("남부터미널역"));
		StationRepository.addStation(new Station("양재역"));
		StationRepository.addStation(new Station("양재시민의숲역"));
		StationRepository.addStation(new Station("매봉역"));
	}

	private static void initLine() {
		LineRepository.lines.add(new Line("2호선"));
		LineRepository.lines.add(new Line("3호선"));
		LineRepository.lines.add(new Line("신분당선"));
	}

	private static void initSection() {
		Line line2 = findLine("2호선");
		Line line3 = findLine("3호선");
		Line shinBunDangLine = findLine("신분당선");
		addStationInLine(findStation("교대역"), findStation("역삼역"), line2.getName());
		line2.addStationOrder(findStation("강남역"), 1);
		addStationInLine(findStation("교대역"), findStation("매봉역"), line3.getName());
		line3.addStationOrder(findStation("남부터미널역"), 1);
		line3.addStationOrder(findStation("양재역"), 2);
		addStationInLine(findStation("강남역"), findStation("양재시민의숲역"), shinBunDangLine.getName());
		shinBunDangLine.addStationOrder(findStation("양재역"), 1);
	}

}
