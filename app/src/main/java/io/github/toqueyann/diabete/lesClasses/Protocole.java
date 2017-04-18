package io.github.toqueyann.diabete.lesClasses;

import java.util.ArrayList;

/**
 *<b>Protocole est la classe qui définie un protocole</b>
 *<p>Il sert lors du calcul de la glycémie. <br/>
 *Le protocole est caractérisé par les informations suivantes :<br/>
 *<ul>
 *<li>Un numéro attribué définitvement</li>
 *<li>Un liste (arrayList) de Glycémie et Insuline</li>
 *</ul>
 *</p>
 *
 *
 *@author Yann Toqué
 */

public class Protocole {

	/**
	 *Le numéro d'un protocole n'est pas modifiable
 	 */
    private int numeroProtocole;

	/**
	 *Liste de Glycémie et Insuline
	 */
	private ArrayList<GlycemieInsuline> lesGlycemieInsuline;

	/**
	 *Constructeur de la classe Protocole
	 *<p>A la constuction du protocole la liste de glycemie Insuline est instanciée
	 *et le int est demandé en paramètre</p>
	 *@param unNumero lesGlycemieInsuline
     */
	public Protocole(int unNumero)	{
		this.numeroProtocole = unNumero;
		lesGlycemieInsuline = new ArrayList<GlycemieInsuline>();
	}


	/**
	 *
	 *@return le numero du protocle
     */
	public int getNumeroProtocole()	{
		return this.numeroProtocole;
	}

	/**
	 *Sert a insérer une nouvelle regle concernant la dose d'insuline
	 *@param uneGlycemieInsuline de type GLYCEMIEINSULINE
     */
	public void ajouter(GlycemieInsuline uneGlycemieInsuline)	{
		this.lesGlycemieInsuline.add(uneGlycemieInsuline);
	}

	/**
	 *Sert à calculer la ou les dose(s) d'insuline en fonction du parametre
     *elle retourne l'int correspondant à la dose
	 *@param uneGlycemie taux de Glycémie que l'on rentre DOUBLE
	 *@return res -> la dose d'insuline INT
     */
	public int insuline(double uneGlycemie)	{
		//A écrire
		//Renvoie le nombre d'unités d'insuline en fonction de la glycémie

		//MapProtocoles m1 = new MapProtocoles();


		int res = -1;

		for (GlycemieInsuline gi : lesGlycemieInsuline) {
			if (uneGlycemie >= gi.getGlycemieInf() && uneGlycemie < gi.getGlycemieSup() && gi.getGlycemieSup() != 0){
				res =  gi.getInsuline();
			}else if(uneGlycemie >= gi.getGlycemieInf()){
				res =  gi.getInsuline();
			}
		}

	return res;

	}
}
