package dao.HappenStatus;

import model.HappenStatusModel;

public interface HappenStatusDAO {

    public HappenStatusModel getByID(int ID);

    public HappenStatusModel getByCodeStatus(int code);
}
