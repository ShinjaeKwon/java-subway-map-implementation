package subway.repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import subway.domain.Station;

public class LineRepository {

	private static Map<String, List<Station>> lines = new HashMap<>();

	public static Map<String, List<Station>> lines() {
		return Collections.unmodifiableMap(lines);
	}

	public static void addLine(String lineName, List<Station> stations) {
		lines.put(lineName, stations);
	}

	public static void deleteStation(String name) {
		lines.remove(name);
	}

}
