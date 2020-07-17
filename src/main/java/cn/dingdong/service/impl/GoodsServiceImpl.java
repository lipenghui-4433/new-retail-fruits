package cn.dingdong.service.impl;

import cn.dingdong.mapper.GoodsMapper;
import cn.dingdong.model.Goods;
import cn.dingdong.repository.GoodsRepository;
import cn.dingdong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired(required=false)
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsRepository goodsRepository;


    @Override
    public List<Goods> list(Map<String, Object> map) {
        return goodsMapper.selectByMap(map);
    }

    @Override
    public boolean addProduct(Goods goods) {
        try {
            goodsRepository.save(goods);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Goods goods) {
        try {
            int i = goodsMapper.updateById(goods);
            return i==1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProduct(String id) {
        try {
            goodsRepository.deleteById(Integer.valueOf(id));
            return true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }

    }
}
