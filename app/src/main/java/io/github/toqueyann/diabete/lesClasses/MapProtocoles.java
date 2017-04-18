package io.github.toqueyann.diabete.lesClasses;


import java.util.HashMap;


/**
 *<p>MapProtocole permet de regrouper les règles de GlycémieInsuline en fonction du protcole :<br/>
 *<ul>
 *<li>une HashMap de protocole</li>
 *</ul>
 *</p>
 *
 *@author Yann Toqué
 */


public class MapProtocoles {
	private HashMap<Integer, Protocole> lesProtocoles;

	/**
	 *Constructeur de la classe MapProtocole
	 *sert à instancier une hashmap
	 */
	public MapProtocoles()	{
		this.lesProtocoles = new HashMap<Integer, Protocole>();
	}

	/**
	 *Cette fonction permet de charger les règles découlant du protocole spécifique
	 *on l'utilise notamment dans la mainactivity
	 */
	public void initialiser()	{
		Protocole leProtocole = new Protocole(1);
		GlycemieInsuline uneGlycemieInsuline;
		uneGlycemieInsuline = new GlycemieInsuline(1.0, 1.5, 0);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(1.5, 2.0, 5);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(2.0, 2.5, 10);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(2.5, 0, 15);
		leProtocole.ajouter(uneGlycemieInsuline);
		this.lesProtocoles.put(leProtocole.getNumeroProtocole(), leProtocole);
		leProtocole = new Protocole(2);
		uneGlycemieInsuline = new GlycemieInsuline(1.0, 1.2, 0);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(1.2, 1.5, 4);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(1.5, 1.8, 8);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(1.8, 2.1, 12);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(2.1, 2.4, 16);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(2.4, 2.7, 20);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(2.7, 3.0, 24);
		leProtocole.ajouter(uneGlycemieInsuline);
		uneGlycemieInsuline = new GlycemieInsuline(3.0, 0, 30);
		leProtocole.ajouter(uneGlycemieInsuline);
		this.lesProtocoles.put(leProtocole.getNumeroProtocole(), leProtocole);		
	}

	/**
	 *Permet d'obtenir le numéro du protocole de la MapProtocole
	 *@param unNumero INT
	 *@return Protocole
     */
	public Protocole getProtocole(int unNumero)	{
		
		return this.lesProtocoles.get(unNumero);
	}

}
