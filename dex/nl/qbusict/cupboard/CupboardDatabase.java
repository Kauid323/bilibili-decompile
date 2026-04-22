package nl.qbusict.cupboard;

import android.content.ContentValues;
import android.database.Cursor;

public interface CupboardDatabase {
    void beginTransaction();

    int delete(String str, String str2, String[] strArr);

    void endTransaction();

    void execSQL(String str);

    boolean inTransaction();

    long insertOrThrow(String str, String str2, ContentValues contentValues);

    Cursor query(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6);

    Cursor rawQuery(String str, String[] strArr);

    long replaceOrThrow(String str, String str2, ContentValues contentValues);

    void setTransactionSuccessful();

    int update(String str, ContentValues contentValues, String str2, String[] strArr);

    void yieldIfContendedSafely();
}