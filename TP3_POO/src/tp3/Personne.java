package tp3;

public class Personne {
 private String nom;
 private String prenom;
 private String adress;
 
public Personne(String nom, String prenom, String adress) {
	
	this.nom = nom;
	this.prenom = prenom;
	this.adress = adress;
}


public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}

@Override
public String toString() {
	return " est identifié par :( " + nom + ", et  " + prenom + ", et  " + adress + " )";
}
 
}
