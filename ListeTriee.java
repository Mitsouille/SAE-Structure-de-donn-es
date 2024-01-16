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
        int i = this.tete();
        int pre = i;
        boolean trouve = false;
        while(this.finliste(i) == false && trouve == false){
            String courant = this.val(i);
            if(courant.compareTo(chaine) >= 0){
                trouve = true;
            }else{
                pre = i;
                i = this.suc(i);
            }
        }
        if(i == pre){
            this.liste.adjtlis(chaine);
        }else{
            this.liste.adjlis(pre, chaine);
        }
    }
	
    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    public void suplisT(String chaine){
        int i = this.tete();
        boolean trouve = false;
        while(!finliste(i) && !trouve){
            if(chaine.equals(this.val(i))){
                trouve = true;
                this.liste.suplis(i);
            }else{
                i = this.suc(i);
            }
        }
    }





    public String toString(){
	return liste.toString();
    }
}
