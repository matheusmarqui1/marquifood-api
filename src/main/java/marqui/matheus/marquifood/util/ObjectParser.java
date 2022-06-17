package marqui.matheus.marquifood.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class ObjectParser {
    private Class<?> aClass;

    private ObjectParser(Class<?> aClass) {
        this.aClass = aClass;
    }

    private ObjectParser() {}

    private @NotNull ObjectMapper getMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);

        return objectMapper;
    }

    private Object getConvertedObject(Map<String, Object> objectMap) {
        return getMapper().convertValue(objectMap, aClass);
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ObjectParser to(Class<?> aClass) {
        return new ObjectParser(aClass);
    }

    public void mergeRequestBodyToGenericObject(Map<String, Object> objectMap, Object objectToUpdate) {

        Object newObject = getConvertedObject(objectMap);

        objectMap.forEach((fieldProp, valueProp) -> {
            Field field = ReflectionUtils.findField(aClass, fieldProp);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, newObject);

            ReflectionUtils.setField(field, objectToUpdate, newValue);
        });
    }

}
