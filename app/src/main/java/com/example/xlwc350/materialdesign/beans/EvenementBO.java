package com.example.xlwc350.materialdesign.beans;

import java.util.Date;

/**
 * Created by xlwc350 on 22/01/2016.
 */
public class EvenementBO {

    private Date dateEvenement;
    private TypeEvenementBO typeEvenementBO;

    public EvenementBO(Date dateEvenement, TypeEvenementBO typeEvenementBO) {
        this.dateEvenement = dateEvenement;
        this.typeEvenementBO = typeEvenementBO;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenementBO(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public TypeEvenementBO getTypeEvenementBO() {
        return typeEvenementBO;
    }

    public void setTypeEvenementBO(TypeEvenementBO typeEvenementBO) {
        this.typeEvenementBO = typeEvenementBO;
    }
}
