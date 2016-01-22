package com.example.xlwc350.materialdesign.services;

import com.example.xlwc350.materialdesign.beans.TypeEvenementBO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xlwc350 on 22/01/2016.
 */
public class TypeEvenementDAO {

    public List<TypeEvenementBO> getTypeEvenementBOs(){
        List<TypeEvenementBO> typeEvenementBOList = new ArrayList();
        typeEvenementBOList.add(new TypeEvenementBO(TypeEvenementBO.TYPE_ENTREE));
        typeEvenementBOList.add(new TypeEvenementBO(TypeEvenementBO.TYPE_SORTIE));
        return typeEvenementBOList;
    }

    public TypeEvenementBO getTypeEvenementBOById(int id){
        return new TypeEvenementBO(id);
    }
}
