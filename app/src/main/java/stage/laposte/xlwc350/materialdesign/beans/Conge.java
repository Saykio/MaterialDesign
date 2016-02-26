package stage.laposte.xlwc350.materialdesign.beans;

import java.util.Date;

/**
 * Created by xlwc350 on 18/02/2016.
 */
public class Conge {
    private Integer id_conge;
    private Integer id_employe;
    private Date date_debut;
    private Date date_fin;
    private String motif;

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


    public Integer getId_employe() {
        return id_employe;
    }

    public void setId_employe(Integer id_employe) {
        this.id_employe = id_employe;
    }

    public Integer getId_conge() {
        return id_conge;
    }

    public void setId_conge(Integer id_conge) {
        this.id_conge = id_conge;
    }

    public Date getDatedebut() {
        return date_debut;
    }

    public void setDatedebut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDatefin() {
        return date_fin;
    }

    public void setDatefin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
