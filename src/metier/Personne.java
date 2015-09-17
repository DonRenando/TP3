package metier;

import java.io.Serializable;

public class Personne implements Serializable{
    // Les attributs
    protected String nom, prenom;
    protected Integer role;

    // Les constantes
    public static final Integer ADMINISTRATEUR = 0, STATISTICIEN = 1, INFIRMIER = 2, PATIENT = 3; // Ce sont les valeurs que peut prendre l'attribut role

    // Les constructeurs et méthodes
    public Personne(String nom, String prenom, Integer role) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
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

    public String toString() {
        return nom + " " + prenom + " avec rôle " + Personne.getNamebyRole(role);
    }

    public Integer getRole() {return role;}

    public static Integer getRolebyName(String name) {
        switch (name) {
            case "ADMINISTRATEUR":
                return Personne.ADMINISTRATEUR;
            case "STATISTICIEN":
                return Personne.STATISTICIEN;
            case "INFIRMIER":
                return Personne.INFIRMIER;
            case "PATIENT":
                return Personne.PATIENT;
        }
        return null;
    }

    public static String getNamebyRole(Integer num) {
        if (num.equals(Personne.ADMINISTRATEUR))
                return "ADMINISTRATEUR";
        if (num.equals(Personne.STATISTICIEN))
                return "STATISTICIEN";
        if (num.equals(Personne.INFIRMIER))
                return "INFIRMIER";
        if (num.equals(Personne.PATIENT))
                return "PATIENT";
        return null;
    }
}
