package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.ShopDAOImpl;
import lk.ijse.librarymanagementsystem.dto.ShopDTO;
import lk.ijse.librarymanagementsystem.entity.Branches;

import java.util.ArrayList;
import java.util.List;

public class ShopService {

    ShopDAOImpl shopDAO = new ShopDAOImpl();
    public ArrayList<ShopDTO> getAllShops(){
        List<Branches> allShops = shopDAO.getAllShops();
        ArrayList<ShopDTO> arrayList = new ArrayList<>();
        for (Branches b : allShops){
            arrayList.add(new ShopDTO(b.getId(),b.getName(),b.getCity(),b.getAddress(),b.getPostalCode()));
        }
        return arrayList;
    }
    public boolean saveShop(ShopDTO shopDTO){
        return shopDAO.saveShop(new Branches(shopDTO.getId(), shopDTO.getName(), shopDTO.getCity(), shopDTO.getAddress(), shopDTO.getPostalCode()));
    }
}
