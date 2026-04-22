package nl.qbusict.cupboard.convert;

import android.content.ContentValues;
import android.database.Cursor;
import nl.qbusict.cupboard.convert.EntityConverter;

public interface FieldConverter<T> {
    T fromCursorValue(Cursor cursor, int i);

    EntityConverter.ColumnType getColumnType();

    void toContentValue(T t, String str, ContentValues contentValues);
}