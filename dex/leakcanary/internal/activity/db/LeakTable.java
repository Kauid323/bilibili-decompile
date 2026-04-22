package leakcanary.internal.activity.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import leakcanary.internal.activity.db.LeakTable;
import shark.Leak;
import shark.LeakTrace;
import shark.LibraryLeak;

/* compiled from: LeakTable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0004J(\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\t\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lleakcanary/internal/activity/db/LeakTable;", "", "()V", "create", "", "createSignatureIndex", "drop", "deleteByHeapAnalysisId", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "heapAnalysisId", "", "insert", "leak", "Lshark/Leak;", "markAsRead", "signature", "retrieveAllLeaks", "", "Lleakcanary/internal/activity/db/LeakTable$AllLeaksProjection;", "retrieveLeakBySignature", "Lleakcanary/internal/activity/db/LeakTable$LeakProjection;", "retrieveLeakReadStatuses", "", "", "signatures", "", "AllLeaksProjection", "LeakProjection", "LeakTraceProjection", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakTable {
    public static final LeakTable INSTANCE = new LeakTable();
    public static final String create = "\n        CREATE TABLE leak\n        (\n        id INTEGER PRIMARY KEY,\n        signature TEXT UNIQUE,\n        short_description TEXT,\n        is_library_leak INTEGER,\n        is_read INTEGER\n        )";
    public static final String createSignatureIndex = "\n        CREATE INDEX leak_signature\n        on leak (signature)\n    ";
    public static final String drop = "DROP TABLE IF EXISTS leak";

    private LeakTable() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Throwable] */
    public final long insert(SQLiteDatabase db, long heapAnalysisId, Leak leak) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(leak, "leak");
        ContentValues values = new ContentValues();
        values.put("signature", leak.getSignature());
        values.put("short_description", leak.getShortDescription());
        values.put("is_library_leak", Integer.valueOf(leak instanceof LibraryLeak ? 1 : 0));
        values.put("is_read", (Integer) 0);
        db.insertWithOnConflict("leak", null, values, 4);
        Cursor $this$use$iv = db.rawQuery("SELECT id from leak WHERE signature = '" + leak.getSignature() + "' LIMIT 1", null);
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\"SELECT id f…gnature}' LIMIT 1\", null)");
        try {
            if (!$this$use$iv.moveToFirst()) {
                throw new IllegalStateException("No id found for leak with signature '" + leak.getSignature() + '\'');
            }
            long leakId = $this$use$iv.getLong(0);
            $this$use$iv.close();
            Iterable $this$forEachIndexed$iv = leak.getLeakTraces();
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                LeakTrace leakTrace = (LeakTrace) item$iv;
                int index = index$iv;
                LeakTraceTable.INSTANCE.insert(db, leakId, heapAnalysisId, index, leakTrace.getLeakingObject().getClassSimpleName());
                index$iv = index$iv2;
            }
            return leakId;
        } catch (Throwable e$iv) {
            try {
                throw e$iv;
            } catch (Throwable e$iv2) {
                try {
                    $this$use$iv.close();
                } catch (Throwable th) {
                }
                throw e$iv2;
            }
        }
    }

    public final Map<String, Boolean> retrieveLeakReadStatuses(SQLiteDatabase db, Set<String> signatures) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(signatures, "signatures");
        Cursor $this$use$iv = db.rawQuery("\n      SELECT\n      signature\n      , is_read\n      FROM leak\n      WHERE signature IN (" + CollectionsKt.joinToString$default(signatures, null, null, null, 0, null, new Function1<String, CharSequence>() { // from class: leakcanary.internal.activity.db.LeakTable$retrieveLeakReadStatuses$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return '\'' + it + '\'';
            }
        }, 31, null) + ")\n    ", null);
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\n      \"\"\"\n …\" }})\n    \"\"\", null\n    )");
        try {
            Map leakReadStatuses = new LinkedHashMap();
            while ($this$use$iv.moveToNext()) {
                boolean isRead = false;
                String signature = $this$use$iv.getString(0);
                if ($this$use$iv.getInt(1) == 1) {
                    isRead = true;
                }
                Intrinsics.checkExpressionValueIsNotNull(signature, "signature");
                leakReadStatuses.put(signature, Boolean.valueOf(isRead));
            }
            $this$use$iv.close();
            return leakReadStatuses;
        } catch (Throwable e$iv) {
            try {
                throw e$iv;
            } catch (Throwable e$iv2) {
                try {
                    $this$use$iv.close();
                } catch (Throwable th) {
                }
                throw e$iv2;
            }
        }
    }

    /* compiled from: LeakTable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lleakcanary/internal/activity/db/LeakTable$AllLeaksProjection;", "", "signature", "", "shortDescription", "createdAtTimeMillis", "", "leakTraceCount", "", "isLibraryLeak", "", "isNew", "(Ljava/lang/String;Ljava/lang/String;JIZZ)V", "getCreatedAtTimeMillis", "()J", "()Z", "getLeakTraceCount", "()I", "getShortDescription", "()Ljava/lang/String;", "getSignature", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AllLeaksProjection {
        private final long createdAtTimeMillis;
        private final boolean isLibraryLeak;
        private final boolean isNew;
        private final int leakTraceCount;
        private final String shortDescription;
        private final String signature;

        public AllLeaksProjection(String signature, String shortDescription, long createdAtTimeMillis, int leakTraceCount, boolean isLibraryLeak, boolean isNew) {
            Intrinsics.checkParameterIsNotNull(signature, "signature");
            Intrinsics.checkParameterIsNotNull(shortDescription, "shortDescription");
            this.signature = signature;
            this.shortDescription = shortDescription;
            this.createdAtTimeMillis = createdAtTimeMillis;
            this.leakTraceCount = leakTraceCount;
            this.isLibraryLeak = isLibraryLeak;
            this.isNew = isNew;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final long getCreatedAtTimeMillis() {
            return this.createdAtTimeMillis;
        }

        public final int getLeakTraceCount() {
            return this.leakTraceCount;
        }

        public final boolean isLibraryLeak() {
            return this.isLibraryLeak;
        }

        public final boolean isNew() {
            return this.isNew;
        }
    }

    public final List<AllLeaksProjection> retrieveAllLeaks(SQLiteDatabase db) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(db, "db");
        Cursor $this$use$iv = db.rawQuery("\n          SELECT\n          l.signature\n          , MIN(l.short_description)\n          , MAX(h.created_at_time_millis) as created_at_time_millis\n          , COUNT(*) as leak_trace_count\n          , MIN(l.is_library_leak) as is_library_leak\n          , MAX(l.is_read) as is_read\n          FROM leak_trace lt\n          LEFT JOIN leak l on lt.leak_id = l.id\n          LEFT JOIN heap_analysis h ON lt.heap_analysis_id = h.id\n          GROUP BY 1\n          ORDER BY leak_trace_count DESC, created_at_time_millis DESC\n          ", null);
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
        try {
            List all = new ArrayList();
            while ($this$use$iv.moveToNext()) {
                String string = $this$use$iv.getString(0);
                Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(0)");
                String string2 = $this$use$iv.getString(1);
                Intrinsics.checkExpressionValueIsNotNull(string2, "cursor.getString(1)");
                long j = $this$use$iv.getLong(2);
                int i = $this$use$iv.getInt(3);
                if ($this$use$iv.getInt(4) != 1) {
                    z = false;
                } else {
                    z = true;
                }
                AllLeaksProjection group = new AllLeaksProjection(string, string2, j, i, z, $this$use$iv.getInt(5) == 0);
                all.add(group);
            }
            $this$use$iv.close();
            return all;
        } catch (Throwable e$iv) {
            try {
                throw e$iv;
            } catch (Throwable e$iv2) {
                try {
                    $this$use$iv.close();
                } catch (Throwable th) {
                }
                throw e$iv2;
            }
        }
    }

    public final void markAsRead(SQLiteDatabase db, String signature) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        ContentValues values = new ContentValues();
        values.put("is_read", (Integer) 1);
        db.update("leak", values, "signature = ?", new String[]{signature});
    }

    /* compiled from: LeakTable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lleakcanary/internal/activity/db/LeakTable$LeakProjection;", "", "shortDescription", "", "isNew", "", "isLibraryLeak", "leakTraces", "", "Lleakcanary/internal/activity/db/LeakTable$LeakTraceProjection;", "(Ljava/lang/String;ZZLjava/util/List;)V", "()Z", "getLeakTraces", "()Ljava/util/List;", "getShortDescription", "()Ljava/lang/String;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class LeakProjection {
        private final boolean isLibraryLeak;
        private final boolean isNew;
        private final List<LeakTraceProjection> leakTraces;
        private final String shortDescription;

        public LeakProjection(String shortDescription, boolean isNew, boolean isLibraryLeak, List<LeakTraceProjection> leakTraces) {
            Intrinsics.checkParameterIsNotNull(shortDescription, "shortDescription");
            Intrinsics.checkParameterIsNotNull(leakTraces, "leakTraces");
            this.shortDescription = shortDescription;
            this.isNew = isNew;
            this.isLibraryLeak = isLibraryLeak;
            this.leakTraces = leakTraces;
        }

        public final String getShortDescription() {
            return this.shortDescription;
        }

        public final boolean isNew() {
            return this.isNew;
        }

        public final boolean isLibraryLeak() {
            return this.isLibraryLeak;
        }

        public final List<LeakTraceProjection> getLeakTraces() {
            return this.leakTraces;
        }
    }

    /* compiled from: LeakTable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/activity/db/LeakTable$LeakTraceProjection;", "", "leakTraceIndex", "", "heapAnalysisId", "", "classSimpleName", "", "createdAtTimeMillis", "(IJLjava/lang/String;J)V", "getClassSimpleName", "()Ljava/lang/String;", "getCreatedAtTimeMillis", "()J", "getHeapAnalysisId", "getLeakTraceIndex", "()I", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class LeakTraceProjection {
        private final String classSimpleName;
        private final long createdAtTimeMillis;
        private final long heapAnalysisId;
        private final int leakTraceIndex;

        public LeakTraceProjection(int leakTraceIndex, long heapAnalysisId, String classSimpleName, long createdAtTimeMillis) {
            Intrinsics.checkParameterIsNotNull(classSimpleName, "classSimpleName");
            this.leakTraceIndex = leakTraceIndex;
            this.heapAnalysisId = heapAnalysisId;
            this.classSimpleName = classSimpleName;
            this.createdAtTimeMillis = createdAtTimeMillis;
        }

        public final int getLeakTraceIndex() {
            return this.leakTraceIndex;
        }

        public final long getHeapAnalysisId() {
            return this.heapAnalysisId;
        }

        public final String getClassSimpleName() {
            return this.classSimpleName;
        }

        public final long getCreatedAtTimeMillis() {
            return this.createdAtTimeMillis;
        }
    }

    public final LeakProjection retrieveLeakBySignature(SQLiteDatabase db, String signature) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(signature, "signature");
        final Cursor $this$use$iv = db.rawQuery("\n          SELECT\n          lt.leak_trace_index\n          , lt.heap_analysis_id\n          , lt.class_simple_name\n          , h.created_at_time_millis\n          , l.short_description\n          , l.is_read\n          , l.is_library_leak\n          FROM leak_trace lt\n          LEFT JOIN leak l on lt.leak_id = l.id\n          LEFT JOIN heap_analysis h ON lt.heap_analysis_id = h.id\n          WHERE l.signature = ?\n          ORDER BY h.created_at_time_millis DESC\n          ", new String[]{signature});
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\n      \"\"\"\n … arrayOf(signature)\n    )");
        LeakProjection leakProjection = null;
        try {
            if ($this$use$iv.moveToFirst()) {
                List leakTraces = new ArrayList();
                String string = $this$use$iv.getString(4);
                Intrinsics.checkExpressionValueIsNotNull(string, "cursor.getString(4)");
                LeakProjection leakProjection2 = new LeakProjection(string, $this$use$iv.getInt(5) == 0, $this$use$iv.getInt(6) == 1, leakTraces);
                CollectionsKt.addAll(leakTraces, SequencesKt.map(SequencesKt.generateSequence($this$use$iv, new Function1<Cursor, Cursor>() { // from class: leakcanary.internal.activity.db.LeakTable$retrieveLeakBySignature$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Cursor invoke(Cursor it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        if ($this$use$iv.moveToNext()) {
                            return $this$use$iv;
                        }
                        return null;
                    }
                }), new Function1<Cursor, LeakTraceProjection>() { // from class: leakcanary.internal.activity.db.LeakTable$retrieveLeakBySignature$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final LeakTable.LeakTraceProjection invoke(Cursor it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        int i = $this$use$iv.getInt(0);
                        long j = $this$use$iv.getLong(1);
                        String string2 = $this$use$iv.getString(2);
                        Intrinsics.checkExpressionValueIsNotNull(string2, "cursor.getString(2)");
                        return new LeakTable.LeakTraceProjection(i, j, string2, $this$use$iv.getLong(3));
                    }
                }));
                leakProjection = leakProjection2;
            }
            $this$use$iv.close();
            return leakProjection;
        } catch (Throwable e$iv) {
            try {
                throw e$iv;
            } catch (Throwable e$iv2) {
                try {
                    $this$use$iv.close();
                } catch (Throwable th) {
                }
                throw e$iv2;
            }
        }
    }

    public final void deleteByHeapAnalysisId(SQLiteDatabase db, long heapAnalysisId) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        LeakTraceTable.INSTANCE.deleteByHeapAnalysisId(db, heapAnalysisId);
        db.execSQL("\n      DELETE\n      FROM leak\n      WHERE NOT EXISTS (\n      SELECT *\n      FROM leak_trace lt\n      WHERE leak.id = lt.leak_id)\n    ");
    }
}