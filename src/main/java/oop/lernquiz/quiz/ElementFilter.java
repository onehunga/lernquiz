package oop.lernquiz.quiz;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ElementFilter<E, T extends FilterElement<E>> {
	private long gewicht;
	private List<T> elements;

	public ElementFilter(List<T> elements) {
		this.elements = elements;

		this.gewicht = elements
			.stream()
			.mapToLong(T::getGewicht)
			.sum();
	}

	public FilterElement<E> nextElement() {
		long idx = ThreadLocalRandom.current().nextLong(this.gewicht);

		FilterElement<E> element = filter(idx);

		if (element == null) {
			throw new IllegalStateException("Element " + idx + " wurde nicht gefunden");
		}

		return element;
	}

	private FilterElement<E> filter(long idx) {
		long total = 0;

		for (var element : elements) {
			var next = total + element.getGewicht();

			if(total <= idx && idx < next) {
				return element;
			}

			total = next;
		}

		return null;
	}

	public void bewerte(FilterElement<E> element, long bewertung) {
		this.gewicht += element.bewerte(bewertung);
	}

	public int getElementCount() {
		return this.elements.size();
	}

	public FilterElement<E> getElement(E base) {
		for (var element : this.elements) {
			if (element.get() == base) {
				return element;
			}
		}

		return null;
	}
}
