package dao.Invoice;

import java.util.List;
import java.util.Map;
import model.InvoiceModel;
/**
 *
 * @author kieth
 */
public interface InvoiceDAO {

    public List<InvoiceModel> getList();
    
    public InvoiceModel getByID(int id);
    
    public Map<Integer, Double> getRevenueByMonthAtNowYear();
    
    public boolean insert(InvoiceModel invoice);

    public boolean update(InvoiceModel invoice);
}
