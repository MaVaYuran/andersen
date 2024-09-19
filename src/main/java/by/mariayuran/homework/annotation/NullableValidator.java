package by.mariayuran.homework.annotation;

import java.lang.reflect.Field;

public class NullableValidator {
    public static void checkForNull(Object object) {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(NullableWarning.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(object) == null) {
                        System.out.println("Variable " + field.getName() + " is null in " + clazz.getSimpleName() + "!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
