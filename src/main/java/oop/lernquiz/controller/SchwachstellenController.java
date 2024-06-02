package oop.lernquiz.controller;

import oop.lernquiz.model.Schwierigkeit;
import oop.lernquiz.model.SortierteFrage;
import oop.lernquiz.navigator.Navigator;
import oop.lernquiz.store.ThemaStore;
import oop.lernquiz.view.SchwachstellenView;

import java.util.ArrayList;

/**
 * @author Simon Resing
 */
public class SchwachstellenController extends Controller<SchwachstellenView> {

	public void zurueck() {
		Navigator.goBack();
	}

	@Override
	public void setView(SchwachstellenView view) {
		super.setView(view);

		filterFragen(Schwierigkeit.ALLE);
	}

	public void changeFilter(Schwierigkeit schwierigkeit) {
		filterFragen(schwierigkeit);
	}

	private void filterFragen(Schwierigkeit schwierigkeit) {
		var schlechteFragen = new ArrayList<SortierteFrage>();

		for(var thema : ThemaStore.getInstance().getThemen()) {
			var fragen = thema.getFragen();

			for (var frage : fragen) {
				if (frage.getSchwierigkeit() != schwierigkeit && schwierigkeit != Schwierigkeit.ALLE) {
					continue;
				}

				if (schlechteFragen.size() < 10) {
					schlechteFragen.add(new SortierteFrage(thema, frage));
					continue;
				}

				for (int i = 0; i < schlechteFragen.size(); i++) {
					if(schlechteFragen.get(i).frage().getGewicht() < frage.getGewicht()) {
						schlechteFragen.add(i, new SortierteFrage(thema, frage));
						break;
					}
				}
			}
		}

		schlechteFragen.sort((o1, o2) -> Math.toIntExact(o2.frage().getGewicht() - o1.frage().getGewicht()));
		this.view.setListe(schlechteFragen.stream().limit(10).toList());
	}
}
