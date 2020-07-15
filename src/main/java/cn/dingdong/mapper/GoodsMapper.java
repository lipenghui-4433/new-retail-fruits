package cn.dingdong.mapper;

import cn.dingdong.model.Goods;
import cn.dingdong.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsMapper {

    List<Goods> selFruitsParameter(Map<String, Object> map);

    int updateByPrimaryKey(Goods goods);


}
