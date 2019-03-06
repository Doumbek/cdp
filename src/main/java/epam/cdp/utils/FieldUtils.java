package epam.cdp.utils;

import static org.apache.commons.lang3.reflect.FieldUtils.getAllFieldsList;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FieldUtils {

    private FieldUtils() {
    }

    public static <T> List<T> readField(final Object target, final Class<T> type) {
        final List<Field> scenariosFields = getAllFieldsList(target.getClass());
        return scenariosFields.stream()
            .map(field -> readField(target, field.getName(), type))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }

    public static <T> T readField(final Object target, final String fieldName, final Class<T> type) {
        T result = null;
        try {
            final Object fieldValue = org.apache.commons.lang3.reflect.FieldUtils.readField(target, fieldName, true);
            if (type.isInstance(fieldValue)) {
                result = type.cast(fieldValue);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
