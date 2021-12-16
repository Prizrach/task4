package app.dao;

import app.domain.Good;
import app.domain.Order;

import java.util.List;

public interface GoodDao {

    void add(Good good);

    List<Good> getAll();

    Good getBuId(int id);

    void update(Good good);

    void remove(Good good);
}
