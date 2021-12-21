package app.service;

import app.domain.PriceList;
import app.repository.PriceListRepository;


import java.util.Map;

public class PriceListService extends PriceList {


    @Override
    public Map<String, Double> getPriceList() {
        return PriceListRepository.getPriceListFromDb();
    }
}
