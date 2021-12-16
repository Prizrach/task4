package app.domain;


import java.util.HashMap;
import java.util.Map;
public  class PriceList {

    private Map<String,Double> priceList;

    public Map<String, Double> getPriceList() {
        return priceList;
    }
    public void setPriceList(Map<String, Double> priceList) {
        this.priceList = priceList;
    }
}