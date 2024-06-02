package oop.lernquiz.quiz;

/**
 * @author Julian Michels
 */
public abstract class FilterElement<T> {
	public abstract T get();

	public abstract long getGewicht();
	public abstract long bewerte(long wert);
}
