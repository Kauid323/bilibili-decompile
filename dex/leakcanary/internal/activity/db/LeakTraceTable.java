package leakcanary.internal.activity.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeakTraceTable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ.\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/activity/db/LeakTraceTable;", "", "()V", "create", "", "drop", "deleteByHeapAnalysisId", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "heapAnalysisId", "", "insert", "leakId", "leakTraceIndex", "", "leakingObjectClassSimpleName", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakTraceTable {
    public static final LeakTraceTable INSTANCE = new LeakTraceTable();
    public static final String create = "\n        CREATE TABLE leak_trace\n        (\n        id INTEGER PRIMARY KEY,\n        heap_analysis_id REFERENCES heap_analysis(id),\n        leak_id REFERENCES leak(id),\n        class_simple_name TEXT,\n        leak_trace_index INTEGER\n        )";
    public static final String drop = "DROP TABLE IF EXISTS leak_trace";

    private LeakTraceTable() {
    }

    public final long insert(SQLiteDatabase db, long leakId, long heapAnalysisId, int leakTraceIndex, String leakingObjectClassSimpleName) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(leakingObjectClassSimpleName, "leakingObjectClassSimpleName");
        ContentValues values = new ContentValues();
        values.put("heap_analysis_id", Long.valueOf(heapAnalysisId));
        values.put("leak_id", Long.valueOf(leakId));
        values.put("class_simple_name", leakingObjectClassSimpleName);
        values.put("leak_trace_index", Integer.valueOf(leakTraceIndex));
        return db.insertOrThrow("leak_trace", null, values);
    }

    public final void deleteByHeapAnalysisId(SQLiteDatabase db, long heapAnalysisId) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        db.delete("leak_trace", "heap_analysis_id=" + heapAnalysisId, null);
    }
}