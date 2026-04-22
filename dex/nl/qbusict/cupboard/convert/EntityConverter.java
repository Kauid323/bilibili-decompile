package nl.qbusict.cupboard.convert;

import android.content.ContentValues;
import android.database.Cursor;
import java.util.List;
import nl.qbusict.cupboard.annotation.Index;

public interface EntityConverter<T> {

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public enum ColumnType {
        TEXT,
        INTEGER,
        REAL,
        BLOB,
        JOIN
    }

    T fromCursor(Cursor cursor);

    List<Column> getColumns();

    Long getId(T t);

    String getTable();

    void setId(Long l, T t);

    void toValues(T t, ContentValues contentValues);

    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static class Column {
        public final Index index;
        public final String name;
        public final ColumnType type;

        public Column(String name, ColumnType type) {
            this(name, type, null);
        }

        public Column(String name, ColumnType type, Index index) {
            this.name = name;
            this.type = type;
            this.index = index;
        }

        public int hashCode() {
            return this.name.hashCode() * 37;
        }

        public boolean equals(Object o) {
            if (o instanceof Column) {
                Column c = (Column) o;
                return c.name.equals(this.name) && c.type == this.type;
            } else if (o instanceof String) {
                return this.name.equals(o);
            } else {
                return super.equals(o);
            }
        }
    }
}