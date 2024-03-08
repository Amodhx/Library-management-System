package lk.ijse.librarymanagementsystem.dao;

import lk.ijse.librarymanagementsystem.entity.Branches;

public interface ShopDAO extends CrudDAO<Branches> {
     boolean deleteShop(int id);
}
