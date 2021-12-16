package app.dao;

import java.util.Map;

public interface PriceListDao {

    Map<String,Double> getPriceListFromDb();
}
