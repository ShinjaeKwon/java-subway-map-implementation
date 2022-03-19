package subway.domain.menu;

import subway.management.StationManagement;

public enum MainMenu {
	ONE("1") {
		public void selectMenu() {
			StationManagement.selectStationManagement();
		}
	}, TWO("2") {
		public void selectMenu() {
			// 2. 노선 관리
		}
	}, THREE("3") {
		public void selectMenu() {
			// 3. 구간 관리
		}
	}, FORE("4") {
		public void selectMenu() {
			// 4. 지하철 노선도 출력
		}
	}, QUIT("Q") {
		public void selectMenu() {
			//Q. 종료
		}
	};

	MainMenu(String value) {
		this.value = value;
	}

	private final String value;

	public abstract void selectMenu();

	public static MainMenu findMenu(String input) {
		MainMenu[] menus = MainMenu.values();
		for (MainMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

}
