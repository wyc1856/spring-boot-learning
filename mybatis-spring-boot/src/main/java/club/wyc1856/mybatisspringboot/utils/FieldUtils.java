package club.wyc1856.mybatisspringboot.utils;

import java.lang.reflect.Field;

/**
 * todo
 *
 * @author wyc1856
 * @date 2020/9/4
 **/
public class FieldUtils {

    public static Object readField(Field targetField, Object obj, boolean access) throws IllegalAccessException{
        targetField.setAccessible(access);
        return targetField.get(obj);
    }

    public static Field getDeclaredField(Class<?> targetClass, String fieldName, boolean access){
        try {
            return targetClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    public static void writeField(Field targetField, Object obj, Object value) throws IllegalAccessException{
        targetField.setAccessible(true);
        targetField.set(obj, value);
    }


}
