package subway.domain.menu;

import subway.management.LineManagement;

public enum LineMenu {
	ADD_LINE("1") {
		public void selectMenu() {
			LineManagement.addLine();
		}
	}, DELETE_LINE("2") {
		public void selectMenu() {
			LineManagement.deleteLineByName();
		}
	}, LOOK_UP_LINE("3") {
		public void selectMenu() {
			LineManagement.lookupLines();
		}
	}, BACK("B") {
		public void selectMenu() {
			return;
		}
	};

	private final String value;

	LineMenu(String value) {
		this.value = value;
	}

	public static LineMenu findLineMenu(String input) {
		LineMenu[] menus = LineMenu.values();
		for (LineMenu menu : menus) {
			if (menu.value.equals(input)) {
				return menu;
			}
		}
		return null;
	}

	public abstract void selectMenu();

}