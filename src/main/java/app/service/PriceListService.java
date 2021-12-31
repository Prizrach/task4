package app.service;

import app.domain.Good;
import app.repository.GoodRepository;

import java.util.List;

public class PriceListService {

    public static List<Good> getPriceList() {
        return GoodRepository.getAll();
    }

}
