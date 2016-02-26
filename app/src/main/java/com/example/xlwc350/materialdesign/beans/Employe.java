package com.example.xlwc350.materialdesign.beans;

/**
 * Created by xlwc350 on 25/02/2016.
 */
public class Employe {
    public Integer getId_employe() {
        return id_employe;
    }

    public void setId_employe(Integer id_employe) {
        this.id_employe = id_employe;
    }

    public String getNom_employe() {
        return nom_employe;
    }

    public void setNom_employe(String nom_employe) {
        this.nom_employe = nom_employe;
    }

    public Integer getSolde_conge() {
        return solde_conge;
    }

    public void setSolde_conge(Integer solde_conge) {
        this.solde_conge = solde_conge;
    }

    public String getPrenom_employe() {
        return prenom_employe;
    }

    public void setPrenom_employe(String prenom_employe) {
        this.prenom_employe = prenom_employe;
    }

    private Integer id_employe;
    private String nom_employe;
    private String prenom_employe;
    private Integer solde_conge;
}
