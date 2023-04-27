package service.party;

import dao.Party.PartyDAO;
import dao.Party.PartyDAOImpl;
import java.util.List;
import model.PartyModel;

/**
 *
 * @author Admin
 */
public class PartyServiceImpl implements PartyService {

    private PartyDAO partyDAO = null;

    public PartyServiceImpl() {
        partyDAO = new PartyDAOImpl();
    }

    @Override
    public List<PartyModel> getList() {
        return partyDAO.getList();
    }

}
