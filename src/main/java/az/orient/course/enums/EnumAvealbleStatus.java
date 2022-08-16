package az.orient.course.enums;

import org.aspectj.weaver.EnumAnnotationValue;

import java.util.HashMap;
import java.util.Map;

public enum EnumAvealbleStatus {

    ACTIVE(1),
    DEACTIVE(0);


   private int value;

   private  static  final Map<Integer,EnumAvealbleStatus> VALUES=new HashMap<>();


    EnumAvealbleStatus(int value) {



        this.value = value;
    }
    static {
        for(EnumAvealbleStatus type:VALUES.values() ){

             VALUES.put(type.value, type);

        }
    }
    public Integer getValue(){
       return  value;
    }

    public static EnumAvealbleStatus getEnum(Integer value){

        if(value==null){
            return null;
        }
        return VALUES.get(value.intValue());

    }


}
