package nl.qbusict.cupboard.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.annotation.Column;
import nl.qbusict.cupboard.annotation.Ignore;
import nl.qbusict.cupboard.annotation.Index;
import nl.qbusict.cupboard.convert.EntityConverter;

public class ReflectiveEntityConverter<T> implements EntityConverter<T> {
    private final List<EntityConverter.Column> mColumns;
    protected final Cupboard mCupboard;
    protected final Class<T> mEntityClass;
    private Property mIdProperty;
    private final Property[] mProperties;
    private final boolean mUseAnnotations;

    public ReflectiveEntityConverter(Cupboard cupboard, Class<T> entityClass) {
        this(cupboard, entityClass, Collections.emptyList(), Collections.emptyList());
    }

    public ReflectiveEntityConverter(Cupboard cupboard, Class<T> entityClass, Collection<String> ignoredFieldsNames) {
        this(cupboard, entityClass, ignoredFieldsNames, Collections.emptyList());
    }

    public ReflectiveEntityConverter(Cupboard cupboard, Class<T> entityClass, Collection<String> ignoredFieldNames, Collection<EntityConverter.Column> additionalColumns) {
        this.mCupboard = cupboard;
        this.mUseAnnotations = cupboard.isUseAnnotations();
        Field[] fields = getAllFields(entityClass);
        ArrayList<EntityConverter.Column> columns = new ArrayList<>(fields.length);
        this.mEntityClass = entityClass;
        List<Property> properties = new ArrayList<>();
        for (Field field : fields) {
            if (!ignoredFieldNames.contains(field.getName()) && !isIgnored(field)) {
                Type type = field.getGenericType();
                FieldConverter<?> converter = getFieldConverter(field);
                if (converter == null) {
                    throw new IllegalArgumentException("Do not know how to convert field " + field.getName() + " in entity " + entityClass.getName() + " of type " + type);
                }
                if (converter.getColumnType() != null) {
                    Property prop = new Property();
                    prop.field = field;
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    prop.name = getColumn(field);
                    prop.type = field.getType();
                    prop.fieldConverter = converter;
                    prop.columnType = isReadOnlyColumn(field) ? EntityConverter.ColumnType.JOIN : converter.getColumnType();
                    properties.add(prop);
                    if ("_id".equals(prop.name)) {
                        this.mIdProperty = prop;
                    }
                    columns.add(new EntityConverter.Column(prop.name, prop.columnType, getIndexes(field)));
                }
            }
        }
        columns.addAll(additionalColumns);
        this.mColumns = Collections.unmodifiableList(columns);
        this.mProperties = (Property[]) properties.toArray(new Property[properties.size()]);
    }

    private static String getTable(Class<?> clz) {
        return clz.getSimpleName();
    }

    protected FieldConverter<?> getFieldConverter(Field field) {
        return this.mCupboard.getFieldConverter(field.getGenericType());
    }

    private Field[] getAllFields(Class<?> clz) {
        if (clz.getSuperclass() == null) {
            return clz.getDeclaredFields();
        }
        List<Field> fields = new ArrayList<>(256);
        Class<?> c = clz;
        do {
            Field[] f = c.getDeclaredFields();
            fields.addAll(Arrays.asList(f));
            c = c.getSuperclass();
        } while (c != null);
        Field[] result = new Field[fields.size()];
        return (Field[]) fields.toArray(result);
    }

    protected boolean isIgnored(Field field) {
        int modifiers = field.getModifiers();
        boolean ignored = false;
        boolean ignored2 = Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers) || Modifier.isTransient(modifiers);
        if (this.mUseAnnotations) {
            if (ignored2 || field.getAnnotation(Ignore.class) != null) {
                ignored = true;
            }
            return ignored;
        }
        return ignored2;
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public T fromCursor(Cursor cursor) {
        try {
            T result = this.mEntityClass.newInstance();
            int cols = cursor.getColumnCount();
            for (int index = 0; index < this.mProperties.length && index < cols; index++) {
                Property prop = this.mProperties[index];
                Class<?> type = prop.type;
                if (cursor.isNull(index)) {
                    if (!type.isPrimitive()) {
                        prop.field.set(result, null);
                    }
                } else {
                    prop.field.set(result, prop.fieldConverter.fromCursorValue(cursor, index));
                }
            }
            return result;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public void toValues(T object, ContentValues values) {
        Property[] propertyArr;
        for (Property prop : this.mProperties) {
            if (prop.columnType != EntityConverter.ColumnType.JOIN) {
                try {
                    Object value = prop.field.get(object);
                    if (value == null) {
                        if (!prop.name.equals("_id")) {
                            values.putNull(prop.name);
                        }
                    } else {
                        prop.fieldConverter.toContentValue(value, prop.name, values);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public List<EntityConverter.Column> getColumns() {
        return this.mColumns;
    }

    protected boolean isReadOnlyColumn(Field field) {
        return false;
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public void setId(Long id, T instance) {
        if (this.mIdProperty != null) {
            try {
                this.mIdProperty.field.set(instance, id);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public Long getId(T instance) {
        if (this.mIdProperty != null) {
            try {
                return (Long) this.mIdProperty.field.get(instance);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (IllegalArgumentException e2) {
                throw new RuntimeException(e2);
            }
        }
        return null;
    }

    protected String getColumn(Field field) {
        Column column;
        if (this.mUseAnnotations && (column = (Column) field.getAnnotation(Column.class)) != null) {
            return column.value();
        }
        return field.getName();
    }

    protected Index getIndexes(Field field) {
        Index index;
        if (this.mUseAnnotations && (index = (Index) field.getAnnotation(Index.class)) != null) {
            return index;
        }
        return null;
    }

    @Override // nl.qbusict.cupboard.convert.EntityConverter
    public String getTable() {
        return getTable(this.mEntityClass);
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class Property {
        EntityConverter.ColumnType columnType;
        Field field;
        FieldConverter<Object> fieldConverter;
        String name;
        Class<?> type;

        private Property() {
        }
    }
}