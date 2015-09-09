/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 * @author Jean-Christophe
 */
public class ProgrammePrincipal1 {
    public static void main(String[] args) {
        new ProgrammePrincipal1();
    }

    public ProgrammePrincipal1() {
        Utilisateur u1 = new Utilisateur("Durant", "Paul", Personne.ADMINISTRATEUR, "paul.durant", "tototo", "");
        Utilisateur u2 = new Utilisateur("Dupont", "Jean", Personne.STATISTICIEN, "jean.dupont", "tototo", "paul.durant");
        System.out.println(u1.toString());
        System.out.println(u2.toString());

    }

}
