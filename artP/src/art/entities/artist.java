/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.entities;

import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author yessine
 */
public class artist {
    private int id_Ar;
    private String nom_Ar;
    private String prenom_Ar;
    private Date date_nesAr;
    private String detail_Ar;
    private Image image;
    public artist(){
    }
    public artist(String nom_Ar, String prenom_Ar, Date date_nesAr, String detail_Ar){
    this.nom_Ar=nom_Ar;
    this.prenom_Ar=prenom_Ar;
    this.date_nesAr=date_nesAr;
    this.detail_Ar=detail_Ar;
    
        }

    public int getId_Ar() {
        return id_Ar;
    }

    public String getNom_Ar() {
        return nom_Ar;
    }

    public String getPrenom_Ar() {
        return prenom_Ar;
    }

    public Date getDate_nesAr() {
        return date_nesAr;
    }

    public String getDetail_Ar() {
        return detail_Ar;
    }

    

    public void setNom_Ar(String nom_Ar) {
        this.nom_Ar = nom_Ar;
    }

    public void setPrenom_Ar(String prenom_Ar) {
        this.prenom_Ar = prenom_Ar;
    }

    public void setDate_nesAr(Date date_nesAr) {
        this.date_nesAr = date_nesAr;
    }

    public void setDetail_Ar(String detail_Ar) {
        this.detail_Ar = detail_Ar;
    }


@Override
    public String toString() {
        return "artist{" + "id_Ar=" + id_Ar + ", nom_Ar=" + nom_Ar + ", prenom_Ar=" + prenom_Ar + ", date_nesAr=" + date_nesAr + ", detail_Ar=" + detail_Ar + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final artist other = (artist) obj;
        return this.id_Ar == other.id_Ar;
    }
    
    


}