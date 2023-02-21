/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package art.entities;

/**
 *
 * @author yessine
 */
public class equipement {
    
    private int id_equi;
    private String nom_equi;
    private String type_eq;
    
    public equipement(){
    }
    
    public equipement(String nom_equi, String type_eq){
        this.nom_equi=nom_equi;
        this.type_eq=type_eq;
        
    }

    public int getId_equi() {
        return id_equi;
    }

    public String getNom_equi() {
        return nom_equi;
    }

    public String getType_eq() {
        return type_eq;
    }

    public void setNom_equi(String nom_equi) {
        this.nom_equi = nom_equi;
    }

    public void setType_eq(String type_eq) {
        this.type_eq = type_eq;
    }

    @Override
    public String toString() {
        return "equipement{" + "id_equi=" + id_equi + ", nom_equi=" + nom_equi + ", type_eq=" + type_eq + '}';
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
        final equipement other = (equipement) obj;
        return this.id_equi == other.id_equi;
    }

    

}
