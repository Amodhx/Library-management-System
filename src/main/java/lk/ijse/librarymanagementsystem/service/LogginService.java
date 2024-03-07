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
    public User getUserById(int id){
        return userDAO.getUserByID(id);
    }

    public ArrayList<UserDTO> getAllUsers(){
        ArrayList<UserDTO> arrayList = new ArrayList<>();
        List<User> allUser = userDAO.getAllUser();
        for (User u : allUser){
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
    public boolean saveAdmin(AdminDTO adminDTO){
        return adminDAO.saveAdmin(new Admin(adminDTO.getId(),adminDTO.getUsername(),adminDTO.getPassword(),adminDTO.getEmail()));
    }
    public boolean saveUser(UserDTO userDTO){
        return userDAO.saveUser(new User(userDTO.getId(),userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmail(),new ArrayList<>()));
    }
    public boolean updateAdmin(AdminDTO adminDTO){
        return adminDAO.updateAdmin(new Admin(adminDTO.getId(),adminDTO.getUsername(),adminDTO.getPassword(),adminDTO.getEmail()));
    }
    public boolean updateUser(UserDTO userDTO){
        return userDAO.updateUser(new User(userDTO.getId(),userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(),new ArrayList<>()));

    }
}
