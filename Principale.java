/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */


public class Principale{

    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // 	private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    //= {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    //"YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;

	public static String tempListe(int code, String[] tab,char operation,int taille, String placement) {
		double somme = 0;
		String typeListe = "";
		for(int j = 0; j < 100; j++){
			ListeTriee lt;
			switch (code) {
				case 1:
					ListeContigue listeCon = new ListeContigue(taille);
					lt = new ListeTriee(listeCon);
					typeListe = "Contigue";
					break;
				case 2:
					ListeChainee listeChainee = new ListeChainee(taille);
					lt = new ListeTriee(listeChainee);
					typeListe = "Chainee";
					break;
				default:
					ListeChaineePlacesLibres listeChaineePL = new ListeChaineePlacesLibres(taille);
					lt = new ListeTriee(listeChaineePL);
					typeListe = "Chainee avec place libre";
			}
			remplir_liste(lt, "noms10000.txt");
			long date_debut;
			long date_fin;
			if (operation == '-') {
				date_debut = System.nanoTime();
				for (int i = 0; i < 10; i++) {
					lt.suplisT(tab[i]);
				}
				date_fin = System.nanoTime();
			} else {
				date_debut = System.nanoTime();
				for (int i = 0; i < 10; i++) {
					lt.adjlisT(tab[i]);
				}
				date_fin = System.nanoTime();

			}
			long duree = date_fin - date_debut;
			somme = somme + duree;
		}
		double moyenne = somme / 100;
		return ";"+typeListe + ";" + operation + ";" + placement + ";" + moyenne;
	}


    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
		LectureFichier lf = new LectureFichier(nom_fichier);
		//
		String[] liste_noms = lf.lireFichier();
		for(int i = 0; i < liste_noms.length; i++) {
			liste.adjlisT(liste_noms[i]);
		}
    }
		
    public static void main(String [] args){
	System.out.println("Bienvenue !");

	//Exemple d'utilisation de la classe EcritureFichier
	EcritureFichier fichier = new EcritureFichier("resultats.csv");
	fichier.ouvrirFichier();
	fichier.ecrireLigne("type liste;operation;emplacement;duree");
	fichier.fermerFichier();

	//###################################################################
		//Ouverture du fichier
		//LectureFichier lf = new LectureFichier("noms10000.txt");
		// lecture du fichier dans un tableau de String
		//String[] tab = lf.lireFichier();
		// creation d'une liste chainee
		//ListeChainee lc = new ListeChainee(10000);
		// creation d'une liste triee
		//ListeTriee lt = new ListeTriee(lc);
		// ajout des lignes du fichier a la liste

		//Question 7
		fichier.ouvrirFichier();
		fichier.ecrireLigne(";Type de liste; Operation; Placement; Duree moyenne");
		fichier.ecrireLigne("QUESTION 7");

		fichier.ecrireLigne(tempListe(1,ELEMENTS_DE_DEBUT,'+',10010,"debut"));
		fichier.ecrireLigne(tempListe(2,ELEMENTS_DE_DEBUT,'+',10010,"debut"));
		fichier.ecrireLigne(tempListe(3,ELEMENTS_DE_DEBUT,'+',10010,"debut"));

		fichier.ecrireLigne("QUESTION 8");
		fichier.ecrireLigne(tempListe(1,ELEMENTS_DE_FIN,'+',10010,"fin"));
		fichier.ecrireLigne(tempListe(2,ELEMENTS_DE_FIN,'+',10010,"fin"));
		fichier.ecrireLigne(tempListe(3,ELEMENTS_DE_FIN,'+',10010,"fin"));

		fichier.ecrireLigne("QUESTION 10");
		fichier.ecrireLigne(tempListe(1,ELEMENTS_DE_DEBUT,'-',10010,"debut"));
		fichier.ecrireLigne(tempListe(2,ELEMENTS_DE_DEBUT,'-',10010,"debut"));
		fichier.ecrireLigne(tempListe(3,ELEMENTS_DE_DEBUT,'-',10010,"debut"));

		fichier.ecrireLigne("QUESTION 11");
		fichier.ecrireLigne(tempListe(1,ELEMENTS_DE_FIN,'-',10010,"fin"));
		fichier.ecrireLigne(tempListe(2,ELEMENTS_DE_FIN,'-',10010,"fin"));
		fichier.ecrireLigne(tempListe(3,ELEMENTS_DE_FIN,'-',10010,"fin"));

		fichier.fermerFichier();

	}
}
