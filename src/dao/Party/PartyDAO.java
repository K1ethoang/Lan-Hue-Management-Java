package dao.Party;

import java.util.List;
import model.PartyModel;

public interface PartyDAO {

    public List<PartyModel> getList();

    public int getNextID();

    public boolean insert(PartyModel party);

    public boolean delete(int id);
}
