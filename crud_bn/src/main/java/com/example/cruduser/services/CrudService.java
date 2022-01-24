package com.example.cruduser.services;

import com.example.cruduser.model.*;
import com.example.cruduser.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CrudService {
    @Autowired
    private CrudRepo crudRepo;
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AddressTypeRepo addressTypeRepo;
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private SubdistrictRepo subdistrictRepo;


    public List<User> fetchUserList(){
        return crudRepo.findAll();
    }

    public User findUserById(long id) {
        return crudRepo.findById(id).get();
    }

    public List<UserModel> findUserModelAll() {
        List<UserModel> userModelList = new ArrayList<UserModel>();
        for (User userTb : fetchUserList()) {

            UserModel userModel = new UserModel();
            List<AddressModel> addressModelList = new ArrayList<AddressModel>();

            userModel.setId(userTb.getId());
            userModel.setTitle(userTb.getTitle());
            userModel.setFname(userTb.getFname());
            userModel.setLname(userTb.getLname());

            for (Address addressTb : userTb.getAddress()) {
                AddressModel addressModel = new AddressModel();
                addressModel.setId(addressTb.getId());
                addressModel.setAddressNo(addressTb.getAddressNo());
                addressModel.setAddressTypeId(addressTb.getAddressType().getId());
                addressModel.setProvinceId(addressTb.getProvinceId().getId());
                addressModel.setDistrictId(addressTb.getDistrictId().getId());
                addressModel.setSubDistrictId(addressTb.getSubDistrictId().getId());
                addressModel.setUserId(addressTb.getUserId().getId());
                addressModel.setFullAddress(addressTb.getFullAddress());

                addressModelList.add(addressModel);
            }

            userModel.setAddressModelList(addressModelList);
            userModelList.add(userModel);
        }
        return userModelList;
    }

    public UserModel findUserModelById(long id) {

        User userTb = findUserById(id);
        UserModel userModel = new UserModel();
        List<AddressModel> addressModelList = new ArrayList<AddressModel>();

        userModel.setId(userTb.getId());
        userModel.setTitle(userTb.getTitle());
        userModel.setFname(userTb.getFname());
        userModel.setLname(userTb.getLname());

        for (Address addressTb : userTb.getAddress()) {
            AddressModel addressModel = new AddressModel();

            addressModel.setId(addressTb.getId());
            addressModel.setAddressNo(addressTb.getAddressNo());
            addressModel.setAddressTypeId(addressTb.getAddressType().getId());
            addressModel.setProvinceId(addressTb.getProvinceId().getId());
            addressModel.setDistrictId(addressTb.getDistrictId().getId());
            addressModel.setSubDistrictId(addressTb.getSubDistrictId().getId());
            addressModel.setUserId(addressTb.getUserId().getId());
            addressModel.setFullAddress(addressTb.getFullAddress());

            addressModelList.add(addressModel);
            userModel.setAddressModelList(addressModelList);
        }
        return userModel;
    }

    public Boolean AddUser(UserModel userModel) {
        if (userModel != null) {
            User userTb = new User();
            List<Address> addressList = new ArrayList<Address>();

            userTb.setTitle(userModel.getTitle());
            userTb.setFname(userModel.getFname());
            userTb.setLname(userModel.getLname());
            //userTb = userRepository.save(userTb);

            for (AddressModel addressModel : userModel.getAddressModelList()) {
                Address addressTb = new Address();

                AddressType addressTypeTb = addressTypeRepo.getById(addressModel.getAddressTypeId());
                ThProvince provinceTb = provinceRepo.getById(addressModel.getProvinceId());
                ThDistrict districtTb = districtRepo.getById(addressModel.getDistrictId());
                ThSubdistrict subdistrictTb = subdistrictRepo.getById(addressModel.getSubDistrictId());

                addressTb.setAddressNo(addressModel.getAddressNo());

                addressTb.setAddressType(addressTypeTb);
                addressTb.setProvinceId(provinceTb);
                addressTb.setDistrictId(districtTb);
                addressTb.setSubDistrictId(subdistrictTb);

                //addressTb.setId();
                addressTb.setUserId(userTb);
                addressList.add(addressTb);
            }
            userTb.setAddress(addressList);
            System.out.println(userTb.getAddress());
            System.out.println(userTb);
            crudRepo.save(userTb);

            return true;
        }
        return false;

    }

    public Boolean UpdateUser(UserModel userModel) {

        try {
            User userTb = findUserById(userModel.getId());
            if (userTb != null) {
                if (!ObjectUtils.isEmpty(userModel.getTitle())) {
                    userTb.setTitle(userModel.getTitle());
                }

                if (!ObjectUtils.isEmpty(userModel.getFname())) {
                    userTb.setFname(userModel.getFname());
                }

                if (!ObjectUtils.isEmpty(userModel.getLname())) {
                    userTb.setLname(userModel.getLname());
                }

                if (!ObjectUtils.isEmpty(userModel.getAddressModelList())) {

                    List<Address> addressList = new ArrayList<Address>();

                    for (AddressModel addressModel : userModel.getAddressModelList()) {
                        Address addressTb = null;
                        if(addressModel.getId() == null) {
                            addressTb = new Address();
                        }else if(addressModel.getId() != null) {
                            addressTb = addressRepo.getById(addressModel.getId());
                        }


                        AddressType addressTypeTb = addressTypeRepo.getById(addressModel.getAddressTypeId());
                        ThProvince provinceTb = provinceRepo.getById(addressModel.getProvinceId());
                        ThDistrict districtTb = districtRepo.getById(addressModel.getDistrictId());
                        ThSubdistrict subdistrictTb = subdistrictRepo.getById(addressModel.getSubDistrictId());

                        addressTb.setAddressNo(addressModel.getAddressNo());

                        addressTb.setAddressType(addressTypeTb);
                        addressTb.setProvinceId(provinceTb);
                        addressTb.setDistrictId(districtTb);
                        addressTb.setSubDistrictId(subdistrictTb);
                        addressTb.setUserId(userTb);
                        addressList.add(addressTb);
                    }
                    userTb.setAddress(addressList);
                }
                crudRepo.save(userTb);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("On Error: " + e);
            return false;
        }

    }

    public String deleteUserById(long id) {
        try {
            crudRepo.deleteById(id);
            return "delete Successfully";
        } catch (Exception e) {
            return e + "";
        }
    }




//    public User saveUserToDB(User user){
//        return repo.save(user);
//    }
//
//    public Optional<User> fetchUserById(int id){
//        return repo.findById(id);
//    }
//
//    public String updateUserInRepository(User user) {
//        try {
//            userToUpdate = repo.getOne(user.getId());
//            userToUpdate.setTitle(user.getTitle());
//            userToUpdate.setFname(user.getFname());
//            userToUpdate.setLname(user.getLname());
//            userToUpdate.setAddress(user.getAddress());
//            repo.save(userToUpdate);
//            return "Product Updated";
//        }catch (Exception e){
//            return "There is no product registered under the ID: "+user.getId()+"\nMake sure you you send a valid product!";
//        }
//    }
//
//    public String deleteUserById(int id){
//        String result;
//        try {
//            repo.deleteById(id);
//            result = "delete Successfully";
//        } catch (Exception e){
//            result = "delete fail";
//        }
//        return result;
//    }
}
