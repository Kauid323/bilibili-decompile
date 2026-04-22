package nl.qbusict.cupboard.internal.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import nl.qbusict.cupboard.Cupboard;
import nl.qbusict.cupboard.convert.EntityConverter;
import nl.qbusict.cupboard.convert.FieldConverter;
import nl.qbusict.cupboard.convert.FieldConverterFactory;

public class DefaultFieldConverterFactory implements FieldConverterFactory {
    private static HashMap<Type, FieldConverter<?>> sTypeConverters = new HashMap<>(25);

    static {
        sTypeConverters.put(BigDecimal.class, new BigDecimalConverter());
        sTypeConverters.put(BigInteger.class, new BigIntegerConverter());
        sTypeConverters.put(String.class, new StringConverter());
        sTypeConverters.put(Integer.TYPE, new IntegerConverter());
        sTypeConverters.put(Integer.class, new IntegerConverter());
        sTypeConverters.put(Float.TYPE, new FloatConverter());
        sTypeConverters.put(Float.class, new FloatConverter());
        sTypeConverters.put(Short.TYPE, new ShortConverter());
        sTypeConverters.put(Short.class, new ShortConverter());
        sTypeConverters.put(Double.TYPE, new DoubleConverter());
        sTypeConverters.put(Double.class, new DoubleConverter());
        sTypeConverters.put(Long.TYPE, new LongConverter());
        sTypeConverters.put(Long.class, new LongConverter());
        sTypeConverters.put(Byte.TYPE, new ByteConverter());
        sTypeConverters.put(Byte.class, new ByteConverter());
        sTypeConverters.put(byte[].class, new ByteArrayConverter());
        sTypeConverters.put(Boolean.TYPE, new BooleanConverter());
        sTypeConverters.put(Boolean.class, new BooleanConverter());
        sTypeConverters.put(Date.class, new DateConverter());
    }

    @Override // nl.qbusict.cupboard.convert.FieldConverterFactory
    public FieldConverter<?> create(Cupboard cupboard, Type type) {
        if (!(type instanceof Class)) {
            return null;
        }
        return sTypeConverters.get(type);
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class BigDecimalConverter implements FieldConverter<BigDecimal> {
        private BigDecimalConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public BigDecimal fromCursorValue(Cursor cursor, int columnIndex) {
            return new BigDecimal(cursor.getString(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(BigDecimal value, String key, ContentValues values) {
            values.put(key, value.toPlainString());
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.TEXT;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class BigIntegerConverter implements FieldConverter<BigInteger> {
        private BigIntegerConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public BigInteger fromCursorValue(Cursor cursor, int columnIndex) {
            return new BigInteger(cursor.getString(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(BigInteger value, String key, ContentValues values) {
            values.put(key, value.toString());
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.TEXT;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class StringConverter implements FieldConverter<String> {
        private StringConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public String fromCursorValue(Cursor cursor, int columnIndex) {
            return cursor.getString(columnIndex);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(String value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.TEXT;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class IntegerConverter implements FieldConverter<Integer> {
        private IntegerConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Integer fromCursorValue(Cursor cursor, int columnIndex) {
            return Integer.valueOf(cursor.getInt(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Integer value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class FloatConverter implements FieldConverter<Float> {
        private FloatConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Float fromCursorValue(Cursor cursor, int columnIndex) {
            return Float.valueOf(cursor.getFloat(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Float value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.REAL;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class ShortConverter implements FieldConverter<Short> {
        private ShortConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Short fromCursorValue(Cursor cursor, int columnIndex) {
            return Short.valueOf(cursor.getShort(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Short value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.REAL;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class DoubleConverter implements FieldConverter<Double> {
        private DoubleConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Double fromCursorValue(Cursor cursor, int columnIndex) {
            return Double.valueOf(cursor.getDouble(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Double value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.REAL;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class LongConverter implements FieldConverter<Long> {
        private LongConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Long fromCursorValue(Cursor cursor, int columnIndex) {
            return Long.valueOf(cursor.getLong(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Long value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class ByteConverter implements FieldConverter<Byte> {
        private ByteConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Byte fromCursorValue(Cursor cursor, int columnIndex) {
            return Byte.valueOf((byte) cursor.getInt(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Byte value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class ByteArrayConverter implements FieldConverter<byte[]> {
        private ByteArrayConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public byte[] fromCursorValue(Cursor cursor, int columnIndex) {
            return cursor.getBlob(columnIndex);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(byte[] value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.BLOB;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class BooleanConverter implements FieldConverter<Boolean> {
        private BooleanConverter() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Boolean fromCursorValue(Cursor cursor, int columnIndex) {
            try {
                boolean z = true;
                if (cursor.getInt(columnIndex) != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            } catch (NumberFormatException e) {
                return Boolean.valueOf("true".equals(cursor.getString(columnIndex)));
            }
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Boolean value, String key, ContentValues values) {
            values.put(key, value);
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    private static class DateConverter implements FieldConverter<Date> {
        private DateConverter() {
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public Date fromCursorValue(Cursor cursor, int columnIndex) {
            return new Date(cursor.getLong(columnIndex));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public void toContentValue(Date value, String key, ContentValues values) {
            values.put(key, Long.valueOf(value.getTime()));
        }

        @Override // nl.qbusict.cupboard.convert.FieldConverter
        public EntityConverter.ColumnType getColumnType() {
            return EntityConverter.ColumnType.INTEGER;
        }
    }
}