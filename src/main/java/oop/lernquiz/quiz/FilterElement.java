package oop.lernquiz.quiz;

public abstract class FilterElement<T> {
	public abstract T get();

	public abstract long getGewicht();
	public abstract long bewerte(long wert);
}
