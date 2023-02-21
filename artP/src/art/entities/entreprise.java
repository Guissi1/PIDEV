/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.entities;

/**
 *
 * @author yessine
 */
public class entreprise {
 private int id_entr;
 private String nom_entr;
 private String adresse_entr;
 private String mail_entr;
 
 public entreprise(){}
 
 public entreprise(String nom_entr, String adresse_entr, String mail_entr){
    this.nom_entr=nom_entr;
    this.adresse_entr=adresse_entr;
    this.mail_entr=mail_entr;
    
    }

    public entreprise(int aInt, String string, String string0, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_entr() {
        return id_entr;
    }

    public String getNom_entr() {
        return nom_entr;
    }

    public String getAdresse_entr() {
        return adresse_entr;
    }

    public String getMail_entr() {
        return mail_entr;
    }

    public void setNom_entr(String nom_entr) {
        this.nom_entr = nom_entr;
    }

    public void setAdresse_entr(String adresse_entr) {
        this.adresse_entr = adresse_entr;
    }

    public void setMail_entr(String mail_entr) {
        this.mail_entr = mail_entr;
    }

    @Override
    public String toString() {
        return "entreprise{" + "id_entr=" + id_entr + ", nom_entr=" + nom_entr + ", adresse_entr=" + adresse_entr + ", mail_entr=" + mail_entr + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final entreprise other = (entreprise) obj;
        return this.id_entr == other.id_entr;
    }
 
 
 
 
}
