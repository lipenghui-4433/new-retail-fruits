package cn.dingdong.utils;

import cn.dingdong.model.Goods;
import cn.dingdong.model.ResultMapModel;


import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class ModelTest {
        //private static Logger logger = Logger.getLogger(PostConnectionTest.class);

        public static void main(String[] args) {
            String programFix = "cn.dingdong"; //包前缀
            Object model = new Goods();
            List<ResultMapModel> reflex2 = getAttributeByReflex(model,programFix);
            for (ResultMapModel m : reflex2) {
                System.out.println("<result column=\""+m.getColumn()+"\" property=\""+
                        m.getAttribute()+"\" jdbcType=\""+m.getColumType()+"\" />");
            }
        }
        private static List<ResultMapModel> getAttributeByReflex(Object object,String programFix) {
            Field[] fields = null;
            List<ResultMapModel> results = new ArrayList<ResultMapModel>();
            int count = 0;
            //通过反射查询其父类
            for(Class<?> clazz = object.getClass();clazz!=Object.class;clazz = clazz.getSuperclass()){
                //获取到该类下所有的属性
                fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    //对field进行拆分处理   private java.lang.String Entity.Animal.AnimalName
                    ResultMapModel result = new ResultMapModel();
                    String[] split = field.toString().split(" ");
                    for (int i = 0; i < split.length; i++) {
                        if(split[i].startsWith(programFix)){
                            String[] split2 = split[i].split("\\.");
                            String string = split2[split2.length-1];
                            //获取到最后一个项，并且把当前类下的属性值都设为同一个
                            result.setAttribute(string);
                            result.setLevel(count);
                        }
                    }
                    //获取field的类型
                    //Class<?> type = field.getType();可以直接通过自带的type方法获取属性类型
                    String[] types = split[1].split("\\.");
                    String strType = types[types.length-1]; //获取当前属性的类型
                    if("long".equals(strType)||"Integer".equals(strType)||"int".equals(strType)){
                        result.setColumType("DECIMAL");
                    }else if("String".equals(strType)){
                        result.setColumType("VARCHAR");
                    }else if("Date".equals(strType)){
                        result.setColumType("TIMESTAMP");
                    }
                    results.add(result);
                }
                count++;
            }
            List<ResultMapModel> list = getCoumnByReflex(object,results);
            return list;
        }
        private static List<ResultMapModel> getCoumnByReflex(Object object,List<ResultMapModel> model) {

            List<String> list = new ArrayList<String>();
            int count = 0;
            for(Class<?> clazz = object.getClass();clazz!=Object.class;clazz = clazz.getSuperclass()){
                Field field;
                try {
                    for(ResultMapModel mapModel : model){
                        if(mapModel!=null && count == mapModel.getLevel()){
                            field = clazz.getDeclaredField(mapModel.getAttribute());
                            //通过获取注解信息得到数据库列信息
                            Column column = field.getAnnotation(Column.class);
                            if(column == null){
                                continue;
                            }
                            String name = column.name();
                            mapModel.setColumn(name);
                        }
                    }
                    count++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return model;
        }
    }

