package model;

/**
 *
 * @author kieth
 */
public class TypePartyModel {

    private int ID;
    private String name;

    public TypePartyModel() {
        super();
    }

    public TypePartyModel(int id, String name) {
        this.ID = id;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
