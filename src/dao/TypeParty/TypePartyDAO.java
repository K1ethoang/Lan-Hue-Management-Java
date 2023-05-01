package dao.TypeParty;

import java.util.List;
import model.TypePartyModel;

/**
 *
 * @author kieth
 */
public interface TypePartyDAO {

    public List<TypePartyModel> getList();

    public TypePartyModel getByID(int ID);

}
