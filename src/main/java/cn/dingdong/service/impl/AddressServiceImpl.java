package cn.dingdong.service.impl;

import cn.dingdong.mapper.AddressMapper;
import cn.dingdong.model.Address;
import cn.dingdong.repository.AddressRepository;
import cn.dingdong.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressRepository addressRepository;

    @Autowired(required=false)
    private AddressMapper addressMapper;

    @Override
    public List<Address> list(Map<String, Object> map) {
        return addressMapper.selectByMap(map);
    }

    @Override
    public boolean addAddress(Address address) {
        try {
            addressRepository.save(address);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateAddress(Address address) {
        try {
            addressRepository.saveAndFlush(address);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteAddress(Integer id) {
        try {
            addressRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
