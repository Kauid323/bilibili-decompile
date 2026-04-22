package nl.qbusict.cupboard.internal.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.convert.EntityConverter;
import nl.qbusict.cupboard.convert.FieldConverter;
import nl.qbusict.cupboard.convert.FieldConverterFactory;

public class EnumFieldConverterFactory implements FieldConverterFactory {

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class EnumConverter<E extends Enum> implements FieldConverter<E> {
        private final Class<E> mEnumClass;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public /* bridge */ /* synthetic */ void toContentValue(Object obj, String str, ContentValues contentValues) {
            toContentValue((EnumConverter<E>) ((Enum) obj), str, contentValues);
        }

        public EnumConverter(Class<E> enumClass) {
            this.mEnumClass = enumClass;
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public E fromCursorValue(Cursor cursor, int columnIndex) {
            return (E) Enum.valueOf(this.mEnumClass, cursor.getString(columnIndex));
        }

        public void toContentValue(E value, String key, ContentValues values) {
            values.put(key, value.toString());
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.TEXT;
        }
    }

    @Override // nl.qbusict.cupboard.convert.FieldConverterFactory
    public FieldConverter<?> create(Cupboard cupboard, Type type) {
        if ((type instanceof ParameterizedType) && ((ParameterizedType) type).getRawType() == Enum.class) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        if (type instanceof Class) {
            Class<?> clz = (Class) type;
            if (clz.isEnum()) {
                return new EnumConverter(clz);
            }
            return null;
        }
        return null;
    }
}