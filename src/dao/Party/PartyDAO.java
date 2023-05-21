package dao.Party;

import java.util.List;
import model.PartyModel;

public interface PartyDAO {

    public List<PartyModel> getList();

    public PartyModel getByID(int id);

    public boolean insert(PartyModel party);

    public boolean update(PartyModel party);

    public void updateHappenStatus();

    public boolean delete(int id);
}
