package ejercicios12Arboles;

public class Key {
	private Category category;
	private int keyValue;

	public Key(Category category) {

	}

	@Override
	public String toString() {
		return String.format("%s%d", category.getCode(), keyValue);
	}
}
