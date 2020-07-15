package cn.dingdong.service;

import cn.dingdong.model.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    public List<Goods> list(Map<String,Object> map);

    public boolean addProduct(Goods goods);

    public boolean updateProduct(Goods goods);

    public boolean deleteProduct(String id);


}
