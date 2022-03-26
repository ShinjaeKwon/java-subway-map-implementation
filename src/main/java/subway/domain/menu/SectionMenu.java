package subway.domain.menu;

import subway.management.SectionManagement;

public enum SectionMenu {
	ADD_SECTION("1") {
		public void selectMenu() {
			SectionManagement.addSection();
		}
	}, DELETE_SECTION("2") {
		public void selectMenu() {
			SectionManagement.deleteStationByNameInSection();
		}
	}, BACK("B") {
		public void selectMenu() {
			return;
		}
	};

	private final String value;

	public abstract void selectMenu();

	SectionMenu(String value) {
		this.value = value;
	}

	public static SectionMenu findSectionMenu(String input) {
		SectionMenu[] menus = SectionMenu.values();
		for (SectionMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

}