package cn.dingdong.mapper;

import cn.dingdong.model.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AddressMapper {

    public List<Address> list(Map<String,Object> map);

}
