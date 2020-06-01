package cn.dingdong.repository;

import cn.dingdong.model.Address;
import cn.dingdong.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
