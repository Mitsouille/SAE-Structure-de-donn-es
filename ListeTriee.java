/**
 * Classe ListeTriee
 * @author Étienne André
 * @since 2021-11-12
 *
 */



public class ListeTriee{

    // Attribut de liste sous-jacente
    private Liste liste;
    
    public ListeTriee(Liste listevide){
	// Affectation de la liste vide à l'attribut privé
	liste = listevide;
    }
    
    /**
     * retourne la premiere place de la liste
     * @return tete de liste
     */
    public int tete(){
	return this.liste.tete();
    }
	
    /**
     * permet de connaitre la place suivante dans la liste
     * @param p place en cours
     * @return place derriere p dans la liste
     */
    public int suc(int p){
	return this.liste.suc(p);
    }
    
    /**
     * retourne la valeur associee a la place p
     * @param p place de la liste
     * @return la valeur associee  p
     */
    public String val(int p){
	//A COMPLETER
	return this.liste.val(p);
    }
 
    /**
     * indique si la place p est a la fin de la liste ou non
     * @param p place de la liste
     * @return vrai si p est a la fin de la liste, faux sinon
     */   
    public boolean finliste(int p){
	//A COMPLETER
        return this.liste.finliste(p);
    }
	
    
    /**
     * ajoute un element au bon endroit dans la liste triee
     * @param chaine element a inserer
     */
    public void adjlisT(String chaine){
	//A COMPLETER
        //Ajouter liste triée
        //Si la liste est vide on met direct
        //Si la comparaison retourne > 0 alors on continue d'avancer jusqu'à la fin de la liste
        //Sinon si on arrive a < 0 alors on ajoute a -1
            if(this.finliste(this.tete()) == true){
            this.liste.adjlis(this.tete(), chaine);
        }else{
            int i = 0;
            int precedent = 0;
            while(chaine.compareTo(this.val(i)) > 0 && this.finliste(i) == false){
                if(i <= this.tete()){
                    precedent = i;
                }
                i = this.suc(i);


            }
            if(this.finliste(i) == true){
                this.liste.adjlis(i,chaine);
            }else {
                this.liste.adjlis(precedent, chaine);
            }
        }
    }
	
    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    public void suplisT(String chaine){
	//A COMPLETER
	throw (new Error ("A compléter"));
    }
		
    public String toString(){
	return liste.toString();
    }
}
