package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue druide " + nomVisiteur + " dans le village !");
	    
	    int force = Clavier.entrerEntier("Quelle est votre force ?");
	    int effetPotionMin = Clavier.entrerEntier("Quelle est la dose minimale de potion magique ?");
	    int effetPotionMax = Clavier.entrerEntier("Quelle est la dose maximale de potion magique ?");
	    
	    while (effetPotionMax <= effetPotionMin) {
	        System.out.println("Erreur : la dose maximale doit être supérieure à la dose minimale !");
	        effetPotionMax = Clavier.entrerEntier("Quelle est la dose maximale de potion magique ?");
	    }
	    
	    controlEmmenager.ajouterDruide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}

	private void emmenagerGaulois(String nomVisiteur) {
	    System.out.println("Bienvenue gaulois " + nomVisiteur + " dans le village !");
	    int force = Clavier.entrerEntier("Quelle est votre force ?");
	    
	    controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
