package stage.laposte.xlwc350.materialdesign.beans;

/**
 * Created by xlwc350 on 22/01/2016.
 */
public class TypeEvenementBO {

    public final static int TYPE_ENTREE = 1;
    public final static int TYPE_SORTIE = -1;

    private final static String LIBELLE_ENTREE = "Entree";
    private final static String LIBELLE_SORTIE = "Sortie";
    private final static String LIBELLE_INCONNU = "Inconnu";

    private int id;
    private String libelle;

    public TypeEvenementBO(final int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }
/*
    public void setId(int id) {
        this.id = id;
    }
*/
    public String getLibelle() {
        if(this.id==TYPE_ENTREE){
            return LIBELLE_ENTREE;
        }else if(this.id==TYPE_SORTIE){
            return LIBELLE_SORTIE;
        }else{
            return LIBELLE_INCONNU;
        }
    }
/*
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    */
}
