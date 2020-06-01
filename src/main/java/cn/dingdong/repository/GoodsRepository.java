package cn.dingdong.repository;

import cn.dingdong.model.Goods;
import cn.dingdong.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Integer> {
}
