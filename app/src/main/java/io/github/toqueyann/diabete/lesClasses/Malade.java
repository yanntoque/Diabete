package io.github.toqueyann.diabete.lesClasses;

import java.io.Serializable;

public class Malade implements Serializable {
	
	private int id;
	private String nom;
	private String prenom;
	private double glycemie;

	public Malade(String unNom, String unPrenom, double uneGlycemie){
		this.nom = unNom;
		this.prenom = unPrenom;
		this.glycemie = uneGlycemie;

	}
	public int getId() {
		return this.id;
	}	
	public void setId(int unId){
		this.id = unId;
	}
	public String getNom() {
		return this.nom;
	}	
	public String getPrenom() {
		return this.prenom;
	}	
	public double getGlycemie() {
		return this.glycemie;
	}
	public String toString(){ return /* "ID " + getId() + */ " Nom : " + getNom() +  " Prenom : " + getPrenom() + "\t" + " Taux de Glycémie : " + getGlycemie();}
}
