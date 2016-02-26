package stage.laposte.xlwc350.materialdesign.beans;

import java.util.List;

/**
 * Created by xlwc350 on 18/02/2016.
 */
public class ListEmploye {
    public List<Employe> getEmploye() {
        return employe;
    }

    public void setConge(List<Employe> employe) {
        this.employe = employe;
    }

    public Integer getSucces() {
        return succes;
    }

    public void setSucces(Integer succes) {
        this.succes = succes;
    }

    private List<Employe> employe;
    private Integer succes;


}
