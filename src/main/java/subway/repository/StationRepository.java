package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import subway.domain.Station;

public class StationRepository {

	private static final List<Station> stations = new ArrayList<>();

	public static void init() {
		stations.add(new Station("교대역"));
		stations.add(new Station("강남역"));
		stations.add(new Station("역삼역"));
		stations.add(new Station("남부터미널역"));
		stations.add(new Station("양재역"));
		stations.add(new Station("양재시민의숲역"));
		stations.add(new Station("매봉역"));
		LineRepository.init();
	}

	public List<Station> stations() {
		return Collections.unmodifiableList(stations);
	}

	public void addStation(Station station) {
		stations.add(station);
	}

	public boolean deleteStation(String name) {
		return stations.removeIf(station -> Objects.equals(station.getName(), name));
	}

	public static boolean findExistStationName(String name) {
		return stations.stream().anyMatch(station -> station.getName().equals(name));
	}

	public static Station findStation(String name) {
		return stations.stream().filter(station -> station.getName().equals(name)).findFirst().orElse(null);
	}

}