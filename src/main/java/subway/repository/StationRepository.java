package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import subway.domain.Station;
import subway.handler.view.ErrorView;

public class StationRepository {

	private static final List<Station> stations = new ArrayList<>();

	public static List<Station> stations() {
		return Collections.unmodifiableList(stations);
	}

	public static void addStation(Station station) {
		Optional<Station> any = stations.stream()
			.filter(it -> it.getName().equals(station.getName()))
			.findAny();
		if (any.isPresent()) {
			throw new IllegalArgumentException(ErrorView.ERROR_ALREADY_STATION_NAME);
		}
		stations.add(station);
	}

	public static boolean deleteStation(String name) {
		return stations.removeIf(station -> Objects.equals(station.getName(), name));
	}

	public static boolean findExistStationName(String name) {
		return stations.stream()
			.anyMatch(station -> station.getName().equals(name));
	}

	public static Station findStation(String name) {
		return stations.stream()
			.filter(station -> station.getName().equals(name))
			.findFirst()
			.orElse(null);
	}

}