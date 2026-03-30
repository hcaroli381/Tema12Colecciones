package ejercicios12Mapas;

import java.util.Objects;

public class Libro {
	private String titulo;
	private int isbn;
	private String autor;

	public Libro(String titulo, int isbn, String autor) {
		this.titulo = titulo;
		this.isbn = isbn;
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(isbn, other.isbn);
	}

	public String getTitulo() {
		return titulo;
	}

	public int getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return String.format("Titulo : %s ISBN : %s", titulo, isbn);
	}

}
