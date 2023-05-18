package dao.Invoice;

import java.util.Map;

/**
 *
 * @author kieth
 */
public interface InvoiceDAO {

    public Map<Integer, Double> getRevenueByMonthAtNowYear();
}
