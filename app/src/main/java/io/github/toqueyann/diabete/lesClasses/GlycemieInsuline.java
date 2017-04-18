package io.github.toqueyann.diabete.lesClasses;

/**
 *<p>GlycemieInsuline est la classe qui sert à créer une règle prenant en compte :<br/>
 *<ul>
 *<li>un double concernant le taux de glycémie Inférieur</li>
 *<li>un double concernant le taux de glycémie Supérieur</li>
 *<li>un int concernant l'insuline</li>
 *</ul>
 *</p>
 *
 *@author Yann Toqué
 */

public class GlycemieInsuline {

	private double glycemieInf;
	private double glycemieSup;
	private int insuline;

    /**
     *Constructeur GlycemieInsuline
     *@param uneGlycemieInf DOUBLE
     *@param uneGlycemieSup DOUBLE
     *@param uneInsuline INT
     */
	public GlycemieInsuline(double uneGlycemieInf, double uneGlycemieSup, int uneInsuline)
	{
		this.glycemieInf = uneGlycemieInf;
		this.glycemieSup = uneGlycemieSup;
		this.insuline = uneInsuline;
	}

    /**
     *Cette fonction récupère le taux de glycémie inférieur rentrée dans le constructeur
     *@return DOUBLE le chiffre correspondant à la glycémie inférieur
     */
	public double getGlycemieInf()	{
		return this.glycemieInf;
	}

    /**
     *Cette fonction récupère le taux de glycémie  supérieur rentrée dans le constructeur
     *@return DOUBLE le chiffre correspondant à la glycémie supérieur
     */
	public double getGlycemieSup()	{
		return this.glycemieSup;
	}

    /**
     *Cette fonction récupère l'insuline rentrée dans le constructeur
     *@return INT l'insuline
     */
	public int getInsuline()	{
		return this.insuline;
	}

}
