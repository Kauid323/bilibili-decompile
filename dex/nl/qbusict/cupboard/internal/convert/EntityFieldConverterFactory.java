package nl.qbusict.cupboard.internal.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.convert.EntityConverter;
import nl.qbusict.cupboard.convert.FieldConverter;
import nl.qbusict.cupboard.convert.FieldConverterFactory;

public class EntityFieldConverterFactory implements FieldConverterFactory {

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class EntityFieldConverter implements FieldConverter<Object> {
        private final Class<Object> entityClass;
        private final EntityConverter<Object> mEntityConverter;

        public EntityFieldConverter(Class<Object> clz, EntityConverter<?> entityConverter) {
            this.mEntityConverter = entityConverter;
            this.entityClass = clz;
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Object fromCursorValue(Cursor cursor, int columnIndex) {
            long id = cursor.getLong(columnIndex);
            try {
                Object entity = this.entityClass.newInstance();
                this.mEntityConverter.setId(Long.valueOf(id), entity);
                return entity;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Object value, String key, ContentValues values) {
            values.put(key, this.mEntityConverter.getId(value));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }

    @Override // nl.qbusict.cupboard.convert.FieldConverterFactory
    public FieldConverter<?> create(Cupboard cupboard, Type type) {
        if ((type instanceof Class) && cupboard.isRegisteredEntity((Class) type)) {
            EntityConverter<?> converter = cupboard.getEntityConverter((Class) type);
            return new EntityFieldConverter((Class) type, converter);
        }
        return null;
    }
}