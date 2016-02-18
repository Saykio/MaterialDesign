package com.example.xlwc350.materialdesign.beans;

import java.util.Date;
import java.util.List;

/**
 * Created by xlwc350 on 16/02/2016.
 */
public class ListConge {
    public List<Conge> getConge() {
        return conge;
    }

    public void setConge(List<Conge> conge) {
        this.conge = conge;
    }

    public Integer getSucces() {
        return succes;
    }

    public void setSucces(Integer succes) {
        this.succes = succes;
    }

    private List<Conge> conge;
    private Integer succes;
}



