package ejercicios12Arboles;

public enum Category {
	BOSS('B'), MANAGER('M'), EMPLOYEE('E');

	private final char code;

	Category(char code) {
		this.code = code;
	}

	public char getCode() {
		return code;
	}
}
