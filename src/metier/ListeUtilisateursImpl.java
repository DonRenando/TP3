/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jean-Christophe
 */
public class ListeUtilisateursImpl  extends AbstractTableModel implements ListeUtilisateurs{
    // Attributs
    List<Utilisateur> liste;

    // Le constructeur et les méthodes

    public ListeUtilisateursImpl() {
        liste = new ArrayList<Utilisateur>();
    }


    @Override
    public void ajouterUtilisateur(Utilisateur u) {
        liste.add(u);
    }

    @Override
    public Utilisateur obtenirUtilisateur(int numeroLigne) {
        return liste.get(numeroLigne);
    }

    @Override
    public void supprimerUtilisateur(int numeroLigne) {
        liste.remove(numeroLigne);
    }

    @Override
    public int obtenirNumeroLigneUtilisateur(String login) {
        for (int i = 0; i < liste.size(); i++)
            if (liste.get(i).getLogin().equals(login))
                return i;

        return -1; // Bredouille
    }

    @Override
    public void modifierUtilisateur(int numeroLigne, Utilisateur u) {
        liste.set(numeroLigne, u);
    }

    @Override
    public boolean verifierIdentite(String login, String password) {
        int ligne = obtenirNumeroLigneUtilisateur(login);

        if (ligne >= 0)
            return liste.get(ligne).checkPassword(password);
        else return false;
    }

    @Override
    public int nbUtilisateurs() {
        return liste.size();
    }

    @Override
    public void sauverListe(File f) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(f, false); //  false impose de réécrire tout le fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(liste);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void chargerListe(File f) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            liste = (List<Utilisateur>) (ois.readObject());
            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ListeUtilisateursImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Utilisateur> getUtilisateurs() {
        return liste;
    }

    @Override
    public int getRowCount() {
        return nbUtilisateurs();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:
                return "Identifiant";
            case 1 :
                return "Nom";

            case 2 :
                return "Role";
        }
        return null;
    }

    @Override
    public Object getValueAt(int lig, int col) {

        switch (col){
            case 0:
                return obtenirUtilisateur(lig).getLogin();
            case 1 :
                return obtenirUtilisateur(lig).getNom();

            case 2 :
                return obtenirUtilisateur(lig).getRole();
        }
        return null;
    }

}
