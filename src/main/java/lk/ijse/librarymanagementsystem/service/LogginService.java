package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dao.AdminDAOImpl;
import lk.ijse.librarymanagementsystem.dao.UserDAOImpl;
import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LogginService {

    UserDAOImpl userDAO = new UserDAOImpl();
    AdminDAOImpl adminDAO = new AdminDAOImpl();

    public ArrayList<UserDTO> getAllUsers(){
        ArrayList<UserDTO> arrayList = new ArrayList<>();
        for (User u : userDAO.getAllUser()){
            arrayList.add(new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail()));
        }
        return arrayList;
    }
    public ArrayList<AdminDTO> getAllAdmins(){
        ArrayList<AdminDTO> arrayList = new ArrayList<>();
        for (Admin a : adminDAO.getAllAdmin()){
            arrayList.add(new AdminDTO(a.getId(),a.getUsername(),a.getPassword(),a.getEmail()));
        }
        return arrayList;
    }
}
