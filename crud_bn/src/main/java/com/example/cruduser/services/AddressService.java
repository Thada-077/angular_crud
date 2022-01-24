package com.example.cruduser.services;

import com.example.cruduser.model.*;
import com.example.cruduser.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AddressTypeRepo addressTypeRepo;
    @Autowired
    private DistrictRepo districtRepo;
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private SubdistrictRepo subdistrictRepo;
    @Autowired
    private CrudRepo crudRepo;

    public List<ThProvince> getAllProvince(){return this.provinceRepo.findAll();}

    public List<ThDistrict> getAllDistrict(){return this.districtRepo.findAll();}

    public List<ThSubdistrict> getAllSubDistrict(){return this.subdistrictRepo.findAll();}

    public List<ThDistrict> getDistrict(Long provinceId) {
        return this.districtRepo.findByProvinceId(provinceId);
    }

    public List<ThSubdistrict> getSubDistrict(Long districtId) {
        return this.subdistrictRepo.findByDistrictId(districtId);
    }
    // Address
    public List<Address> findAddressAll() {
        return addressRepo.findAll();
    }

    public Address findAddressById(long id) {
        return addressRepo.findById(id);
    }

    public ThProvince getProvinceById(long id) {
        return provinceRepo.findById(id);
    }

    public ThDistrict getDistrictById(long id) {
        return districtRepo.findById(id);
    }
    public ThSubdistrict getSubdistrctById(long id) {
        return subdistrictRepo.findById(id);
    }

    // Entity to Model
    public List<AddressModel> findAddressModelAll() {
        List<AddressModel> AddressModelList = new ArrayList<AddressModel>();
        for (Address address : findAddressAll()) {

            AddressModel AddressModel = new AddressModel();

            AddressModel.setId(address.getId());
            AddressModel.setAddressNo(address.getAddressNo());
            AddressModel.setAddressTypeId(address.getAddressType().getId());
            AddressModel.setProvinceId(address.getProvinceId().getId());
            AddressModel.setDistrictId(address.getDistrictId().getId());
            AddressModel.setSubDistrictId(address.getSubDistrictId().getId());
            AddressModel.setFullAddress(address.getFullAddress());
            //AddressModel.setUserId(address.getUserId().getId());
            AddressModelList.add(AddressModel);
        }
        return AddressModelList;
    }

    // Entity to Model
    public AddressModel findAddressModelById(long id) {

        Address address = findAddressById(id);

        AddressModel AddressModel = new AddressModel();

        AddressModel.setId(address.getId());
        AddressModel.setAddressNo(address.getAddressNo());
        AddressModel.setAddressTypeId(address.getAddressType().getId());
        AddressModel.setProvinceId(address.getProvinceId().getId());
        AddressModel.setDistrictId(address.getDistrictId().getId());
        AddressModel.setSubDistrictId(address.getSubDistrictId().getId());
        //AddressModel.setUserId(address.getUserId().getId());
        AddressModel.setFullAddress(address.getFullAddress());


        return AddressModel;
    }

    // Model to Entity
    public Boolean InsertAddress(AddressModel AddressModel) {
        if (AddressModel != null) {
            Address AddressTb = new Address();

            AddressType addressTypeTb = addressTypeRepo.getById(AddressModel.getAddressTypeId());
            ThProvince provinceTb = provinceRepo.getById(AddressModel.getProvinceId());
            ThDistrict districtTb = districtRepo.getById(AddressModel.getDistrictId());
            ThSubdistrict subdistrictTb = subdistrictRepo.getById(AddressModel.getSubDistrictId());
            //User userTb = userRepository.getById(AddressModel.getUserId());


            AddressTb.setAddressNo(AddressModel.getAddressNo());

            AddressTb.setAddressType(addressTypeTb);
            AddressTb.setProvinceId(provinceTb);
            AddressTb.setDistrictId(districtTb);
            AddressTb.setSubDistrictId(subdistrictTb);
            //AddressTb.setUserId(userTb);

            addressRepo.save(AddressTb);

            return true;
        }
        return false;

    }

    // Model to Entity
    public Boolean UpdateAddress(AddressModel AddressModel) {

        try {
            Address AddressTb = findAddressById(AddressModel.getId());
            if (AddressTb != null) {
                if (!ObjectUtils.isEmpty(AddressModel.getAddressNo())) {
                    AddressTb.setAddressNo(AddressModel.getAddressNo());
                }

                if (!ObjectUtils.isEmpty(AddressModel.getAddressTypeId())) {
                    AddressType addressTypeTb = addressTypeRepo.getById(AddressModel.getAddressTypeId());
                    AddressTb.setAddressType(addressTypeTb);
                }

                if (!ObjectUtils.isEmpty(AddressModel.getProvinceId())) {
                    ThProvince provinceTb = provinceRepo.getById(AddressModel.getProvinceId());
                    AddressTb.setProvinceId(provinceTb);
                }

                if (!ObjectUtils.isEmpty(AddressModel.getDistrictId())) {
                    ThDistrict districtTb = districtRepo.getById(AddressModel.getDistrictId());
                    AddressTb.setDistrictId(districtTb);
                }

                if (!ObjectUtils.isEmpty(AddressModel.getSubDistrictId())) {
                    ThSubdistrict subdistrictTb = subdistrictRepo.getById(AddressModel.getSubDistrictId());
                    AddressTb.setSubDistrictId(subdistrictTb);
                }
                if (!ObjectUtils.isEmpty(AddressModel.getUserId())) {
                    User userTb = crudRepo.getById( AddressModel.getUserId());
                    //AddressTb.setUserId(userTb);
                }
                addressRepo.save(AddressTb);
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println("On Error: " + e);
            return false;
        }

    }

    public String deleteAddressById(long id) {
        try {
            addressRepo.deleteById(id);
            return "Address Deleted Successfully";
        } catch (Exception e) {
            return e + "";
        }
    }

    //public List<ThDistrict> getDistrict(Short provinceId){
        //return this.districtRepo.findByProvinceIdId(provinceId);
   //}

//    public List<ThSubdistrict> getSubdistrict(Short districtId){return this.subdistrictRepo.findByDistrictIdId(districtId);}
}
