package cn.dingdong.service;

import cn.dingdong.model.Address;

import java.util.List;
import java.util.Map;

public interface AddressService {

    public List<Address> list(Map<String,Object> map);

    public boolean addAddress(Address address);

    public boolean updateAddress(Address address);

    public boolean deleteAddress(Integer id);

}
