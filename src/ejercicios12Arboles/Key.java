package ejercicios12Arboles;

public class Key {
	private Category category;
	private int keyValue;
	private static int countB = 0;
	private static int countM = 0;
	private static int countE = 0;

	public Key(Category category) {
		this.category = category;
		getKeyValue();
	}

	public void getKeyValue() {
		if (category == Category.BOSS) {
			countB++;
			keyValue = countB;
		} else if (category == Category.MANAGER) {
			countM++;
			keyValue = countM;
		} else if (category == Category.EMPLOYEE) {
			countE++;
			keyValue = countE;
		}
	}

	public Category getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return String.format("%s%d", category.getCode(), keyValue);
	}
}
