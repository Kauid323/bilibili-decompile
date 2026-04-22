package nl.qbusict.cupboard;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.Arrays;
import java.util.List;
import nl.qbusict.cupboard.convert.EntityConverter;

/* JADX INFO: Access modifiers changed from: package-private */
public class PreferredColumnOrderCursorWrapper extends CursorWrapper {
    private final int[] mColumnMap;
    private String[] mColumns;

    public PreferredColumnOrderCursorWrapper(Cursor cursor, String[] columns) {
        super(cursor);
        this.mColumns = columns;
        this.mColumnMap = new int[columns.length];
        Arrays.fill(this.mColumnMap, -1);
        this.mColumns = remapColumns(cursor.getColumnNames(), columns);
    }

    public PreferredColumnOrderCursorWrapper(Cursor cursor, List<EntityConverter.Column> columns) {
        this(cursor, toColumNames(columns));
    }

    private static String[] toColumNames(List<EntityConverter.Column> columns) {
        String[] cols = new String[columns.size()];
        for (int i = cols.length - 1; i >= 0; i--) {
            cols[i] = columns.get(i).name;
        }
        return cols;
    }

    private String[] remapColumns(String[] cursorColumns, String[] columns) {
        int last = 0;
        for (int i = 0; i < columns.length; i++) {
            int index = super.getColumnIndex(columns[i]);
            this.mColumnMap[i] = index;
            if (index != -1) {
                last = i;
            }
        }
        int i2 = last + 1;
        if (i2 < columns.length) {
            String[] newCols = new String[last + 1];
            System.arraycopy(columns, 0, newCols, 0, last + 1);
            return newCols;
        }
        return columns;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public short getShort(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return (short) 0;
        }
        return super.getShort(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public byte[] getBlob(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return null;
        }
        return super.getBlob(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public double getDouble(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return 0.0d;
        }
        return super.getDouble(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public float getFloat(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return 0.0f;
        }
        return super.getFloat(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getInt(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return 0;
        }
        return super.getInt(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public long getLong(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return 0L;
        }
        return super.getLong(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return null;
        }
        return super.getString(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public boolean isNull(int columnIndex) {
        int index = this.mColumnMap[columnIndex];
        if (index == -1) {
            return true;
        }
        return super.isNull(index);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnCount() {
        return this.mColumns.length;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String columnName) {
        throw new RuntimeException("Don't use getColumnIndex(), but use the indices supplied in the constructor.\nFor use in an EntityConverter, the columns and indices are always in the same order as returned from EntityConverter.getColumns()");
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndexOrThrow(String columnName) throws IllegalArgumentException {
        throw new RuntimeException("Don't use getColumnIndex(), but use the indices supplied in the constructor.\nFor use in an EntityConverter, the columns and indices are always in the same order as returned from EntityConverter.getColumns()");
    }
}