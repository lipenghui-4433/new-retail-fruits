package cn.dingdong.mapper;

import cn.dingdong.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void  save (User uer);
}
