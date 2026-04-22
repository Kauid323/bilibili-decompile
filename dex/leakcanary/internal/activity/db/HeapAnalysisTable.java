package leakcanary.internal.activity.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.LeakDirectoryProvider;
import leakcanary.internal.Serializables;
import leakcanary.internal.SerializablesKt;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.Leak;
import shark.SharkLog;

/* compiled from: HeapAnalysisTable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\tH\u0002J\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\bJ,\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lleakcanary/internal/activity/db/HeapAnalysisTable;", "", "()V", "create", "", "drop", "updateListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "delete", "db", "Landroid/database/sqlite/SQLiteDatabase;", "heapAnalysisId", "", "heapDumpFile", "Ljava/io/File;", "deleteAll", "insert", "heapAnalysis", "Lshark/HeapAnalysis;", "notifyUpdateOnMainThread", "onUpdate", "block", "retrieve", "T", "id", "(Landroid/database/sqlite/SQLiteDatabase;J)Lshark/HeapAnalysis;", "retrieveAll", "", "Lleakcanary/internal/activity/db/HeapAnalysisTable$Projection;", "Projection", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalysisTable {
    public static final String create = "CREATE TABLE heap_analysis\n        (\n        id INTEGER PRIMARY KEY AUTOINCREMENT,\n        created_at_time_millis INTEGER,\n        dump_duration_millis INTEGER DEFAULT -1,\n        leak_count INTEGER DEFAULT 0,\n        exception_summary TEXT DEFAULT NULL,\n        object BLOB\n        )";
    public static final String drop = "DROP TABLE IF EXISTS heap_analysis";
    public static final HeapAnalysisTable INSTANCE = new HeapAnalysisTable();
    private static final CopyOnWriteArrayList<Function0<Unit>> updateListeners = new CopyOnWriteArrayList<>();

    private HeapAnalysisTable() {
    }

    public final Function0<Unit> onUpdate(final Function0<Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        updateListeners.add(block);
        return new Function0<Unit>() { // from class: leakcanary.internal.activity.db.HeapAnalysisTable$onUpdate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                copyOnWriteArrayList = HeapAnalysisTable.updateListeners;
                copyOnWriteArrayList.remove(Function0.this);
            }
        };
    }

    public final long insert(SQLiteDatabase db, HeapAnalysis heapAnalysis) {
        long heapAnalysisId;
        Intrinsics.checkParameterIsNotNull(db, "db");
        Intrinsics.checkParameterIsNotNull(heapAnalysis, "heapAnalysis");
        ContentValues values = new ContentValues();
        values.put("created_at_time_millis", Long.valueOf(heapAnalysis.getCreatedAtTimeMillis()));
        values.put("dump_duration_millis", Long.valueOf(heapAnalysis.getDumpDurationMillis()));
        values.put("object", SerializablesKt.toByteArray((Serializable) heapAnalysis));
        if (heapAnalysis instanceof HeapAnalysisSuccess) {
            int leakCount = ((HeapAnalysisSuccess) heapAnalysis).getApplicationLeaks().size() + ((HeapAnalysisSuccess) heapAnalysis).getLibraryLeaks().size();
            values.put("leak_count", Integer.valueOf(leakCount));
        } else if (heapAnalysis instanceof HeapAnalysisFailure) {
            Throwable cause = ((HeapAnalysisFailure) heapAnalysis).getException().getCause();
            if (cause == null) {
                Intrinsics.throwNpe();
            }
            String exceptionSummary = cause.getClass().getSimpleName() + ' ' + cause.getMessage();
            values.put("exception_summary", exceptionSummary);
        }
        ThreadLocal threadLocal = CursorsKt.inTransaction;
        boolean z = threadLocal.get();
        if (z == null) {
            z = false;
            threadLocal.set(false);
        }
        if (((Boolean) z).booleanValue()) {
            heapAnalysisId = db.insertOrThrow("heap_analysis", null, values);
            if (heapAnalysis instanceof HeapAnalysisSuccess) {
                Sequence $this$forEach$iv = ((HeapAnalysisSuccess) heapAnalysis).getAllLeaks();
                for (Object element$iv : $this$forEach$iv) {
                    Leak leakingInstance = (Leak) element$iv;
                    LeakTable.INSTANCE.insert(db, heapAnalysisId, leakingInstance);
                }
            }
        } else {
            try {
                CursorsKt.inTransaction.set(true);
                db.beginTransaction();
                long heapAnalysisId2 = db.insertOrThrow("heap_analysis", null, values);
                if (heapAnalysis instanceof HeapAnalysisSuccess) {
                    Sequence $this$forEach$iv2 = ((HeapAnalysisSuccess) heapAnalysis).getAllLeaks();
                    for (Object element$iv2 : $this$forEach$iv2) {
                        Leak leakingInstance2 = (Leak) element$iv2;
                        LeakTable.INSTANCE.insert(db, heapAnalysisId2, leakingInstance2);
                    }
                }
                heapAnalysisId = heapAnalysisId2;
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
                CursorsKt.inTransaction.set(Boolean.valueOf(false));
            }
        }
        INSTANCE.notifyUpdateOnMainThread();
        return heapAnalysisId;
    }

    private final void notifyUpdateOnMainThread() {
        HandlersKt.checkNotMainThread();
        HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.internal.activity.db.HeapAnalysisTable$notifyUpdateOnMainThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterable iterable;
                HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                iterable = HeapAnalysisTable.updateListeners;
                Iterable $this$forEach$iv = iterable;
                for (Object element$iv : $this$forEach$iv) {
                    Function0 it = (Function0) element$iv;
                    it.invoke();
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [shark.HeapAnalysis] */
    public final /* synthetic */ <T extends HeapAnalysis> T retrieve(SQLiteDatabase db, long id) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        T t = null;
        Cursor $this$use$iv = db.rawQuery("\n              SELECT\n              object\n              FROM heap_analysis\n              WHERE id=" + id + "\n              ", null);
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
        try {
            if ($this$use$iv.moveToNext()) {
                Serializables serializables = Serializables.INSTANCE;
                byte[] byteArray$iv = $this$use$iv.getBlob(0);
                Intrinsics.checkExpressionValueIsNotNull(byteArray$iv, "cursor.getBlob(0)");
                ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(byteArray$iv);
                try {
                    Object readObject = new ObjectInputStream(inputStream$iv).readObject();
                    Intrinsics.reifiedOperationMarker(2, "T");
                    Object obj = readObject;
                    ?? r0 = (HeapAnalysis) readObject;
                    if (r0 == 0) {
                        INSTANCE.delete(db, id, null);
                    }
                    t = r0;
                }
            }
            InlineMarker.finallyStart(1);
            $this$use$iv.close();
            InlineMarker.finallyEnd(1);
            return t;
        } catch (Throwable e$iv) {
            try {
                throw e$iv;
            } catch (Throwable e$iv2) {
                InlineMarker.finallyStart(1);
                try {
                    $this$use$iv.close();
                } catch (Throwable th) {
                }
                InlineMarker.finallyEnd(1);
                throw e$iv2;
            }
        }
    }

    public final List<Projection> retrieveAll(SQLiteDatabase db) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        Cursor $this$use$iv = db.rawQuery("\n          SELECT\n          id\n          , created_at_time_millis\n          , leak_count\n          , exception_summary\n          FROM heap_analysis\n          ORDER BY created_at_time_millis DESC\n          ", null);
        Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
        try {
            List all = new ArrayList();
            while ($this$use$iv.moveToNext()) {
                Projection summary = new Projection($this$use$iv.getLong(0), $this$use$iv.getLong(1), $this$use$iv.getInt(2), $this$use$iv.getString(3));
                all.add(summary);
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

    public final void delete(SQLiteDatabase db, long heapAnalysisId, final File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        if (heapDumpFile != null) {
            AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.db.HeapAnalysisTable$delete$1
                @Override // java.lang.Runnable
                public final void run() {
                    String path = heapDumpFile.getAbsolutePath();
                    boolean heapDumpDeleted = heapDumpFile.delete();
                    if (heapDumpDeleted) {
                        LeakDirectoryProvider.Companion.getFilesDeletedRemoveLeak().add(path);
                        return;
                    }
                    SharkLog this_$iv = SharkLog.INSTANCE;
                    SharkLog.Logger logger$iv = this_$iv.getLogger();
                    if (logger$iv != null) {
                        logger$iv.d("Could not delete heap dump file " + heapDumpFile.getPath());
                    }
                }
            });
        }
        ThreadLocal threadLocal = CursorsKt.inTransaction;
        boolean z = threadLocal.get();
        if (z == null) {
            z = false;
            threadLocal.set(false);
        }
        if (!((Boolean) z).booleanValue()) {
            try {
                CursorsKt.inTransaction.set(true);
                db.beginTransaction();
                db.delete("heap_analysis", "id=" + heapAnalysisId, null);
                LeakTable.INSTANCE.deleteByHeapAnalysisId(db, heapAnalysisId);
                Unit unit = Unit.INSTANCE;
                db.setTransactionSuccessful();
            } finally {
                db.endTransaction();
                CursorsKt.inTransaction.set(false);
            }
        } else {
            db.delete("heap_analysis", "id=" + heapAnalysisId, null);
            LeakTable.INSTANCE.deleteByHeapAnalysisId(db, heapAnalysisId);
        }
        notifyUpdateOnMainThread();
    }

    public final void deleteAll(SQLiteDatabase db) {
        List all;
        Intrinsics.checkParameterIsNotNull(db, "db");
        boolean z = false;
        ThreadLocal threadLocal = CursorsKt.inTransaction;
        Object obj = threadLocal.get();
        int i = 0;
        if (obj == null) {
            threadLocal.set(false);
            obj = false;
        }
        int i2 = 1;
        if (((Boolean) obj).booleanValue()) {
            SQLiteDatabase $this$inTransaction = db;
            Cursor $this$use$iv = $this$inTransaction.rawQuery("\n              SELECT\n              id,\n              object\n              FROM heap_analysis\n              ", null);
            Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "rawQuery(\n        \"\"\"\n  …        \"\"\", null\n      )");
            Cursor cursor = $this$use$iv;
            try {
                List all2 = new ArrayList();
                while (cursor.moveToNext()) {
                    Cursor cursor2 = cursor;
                    try {
                        long id = cursor2.getLong(i);
                        Serializables serializables = Serializables.INSTANCE;
                        byte[] byteArray$iv = cursor2.getBlob(i2);
                        Intrinsics.checkExpressionValueIsNotNull(byteArray$iv, "cursor.getBlob(1)");
                        ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(byteArray$iv);
                        Object readObject = new ObjectInputStream(inputStream$iv).readObject();
                        if (!(readObject instanceof HeapAnalysis)) {
                            readObject = null;
                        }
                        HeapAnalysis analysis = (HeapAnalysis) readObject;
                        boolean z2 = z;
                        if (analysis != null) {
                            try {
                                all = all2;
                                all.add(TuplesKt.to(Long.valueOf(id), analysis));
                            }
                        } else {
                            all = all2;
                        }
                        all2 = all;
                        cursor = cursor2;
                        z = z2;
                        i = 0;
                        i2 = 1;
                    } catch (Throwable th) {
                        e$iv = th;
                        try {
                            throw e$iv;
                        } catch (Throwable e$iv) {
                            try {
                                $this$use$iv.close();
                            } catch (Throwable th2) {
                            }
                            throw e$iv;
                        }
                    }
                }
                final List all3 = all2;
                try {
                    List $this$forEach$iv = all3;
                    boolean z3 = false;
                    Iterator it = $this$forEach$iv.iterator();
                    while (it.hasNext()) {
                        Object element$iv = it.next();
                        Pair $dstr$id$_u24__u24 = (Pair) element$iv;
                        long id2 = ((Number) $dstr$id$_u24__u24.component1()).longValue();
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        boolean z4 = z3;
                        Iterator it2 = it;
                        SQLiteDatabase $this$inTransaction2 = $this$inTransaction;
                        try {
                            db.delete("heap_analysis", "id=" + id2, null);
                            LeakTable.INSTANCE.deleteByHeapAnalysisId(db, id2);
                            $this$forEach$iv = $this$forEach$iv2;
                            z3 = z4;
                            it = it2;
                            $this$inTransaction = $this$inTransaction2;
                        } catch (Throwable th3) {
                            e$iv = th3;
                            throw e$iv;
                        }
                    }
                    AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.db.HeapAnalysisTable$deleteAll$1$1$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Iterable $this$forEach$iv3 = all3;
                            for (Object element$iv2 : $this$forEach$iv3) {
                                Pair $dstr$_u24__u24$analysis = (Pair) element$iv2;
                                HeapAnalysis analysis2 = (HeapAnalysis) $dstr$_u24__u24$analysis.component2();
                                analysis2.getHeapDumpFile().delete();
                            }
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                    $this$use$iv.close();
                } catch (Throwable th4) {
                    e$iv = th4;
                }
            } catch (Throwable th5) {
                e$iv = th5;
            }
        } else {
            try {
                CursorsKt.inTransaction.set(true);
                db.beginTransaction();
                SQLiteDatabase $this$inTransaction3 = db;
                boolean z5 = false;
                Cursor $this$use$iv2 = $this$inTransaction3.rawQuery("\n              SELECT\n              id,\n              object\n              FROM heap_analysis\n              ", null);
                Intrinsics.checkExpressionValueIsNotNull($this$use$iv2, "rawQuery(\n        \"\"\"\n  …        \"\"\", null\n      )");
                Throwable th6 = null;
                try {
                    final List all4 = new ArrayList();
                    while ($this$use$iv2.moveToNext()) {
                        SQLiteDatabase $this$inTransaction4 = $this$inTransaction3;
                        try {
                            long id3 = $this$use$iv2.getLong(0);
                            Serializables serializables2 = Serializables.INSTANCE;
                            boolean z6 = z5;
                            try {
                                byte[] byteArray$iv2 = $this$use$iv2.getBlob(1);
                                Intrinsics.checkExpressionValueIsNotNull(byteArray$iv2, "cursor.getBlob(1)");
                                ByteArrayInputStream inputStream$iv2 = new ByteArrayInputStream(byteArray$iv2);
                                Object readObject2 = new ObjectInputStream(inputStream$iv2).readObject();
                                if (!(readObject2 instanceof HeapAnalysis)) {
                                    readObject2 = null;
                                }
                                HeapAnalysis analysis2 = (HeapAnalysis) readObject2;
                                if (analysis2 != null) {
                                    all4.add(TuplesKt.to(Long.valueOf(id3), analysis2));
                                }
                                $this$inTransaction3 = $this$inTransaction4;
                                z5 = z6;
                            } catch (Throwable th7) {
                                e$iv = th7;
                                throw e$iv;
                            }
                        } catch (Throwable th8) {
                            e$iv = th8;
                            throw e$iv;
                        }
                    }
                    List $this$forEach$iv3 = all4;
                    boolean z7 = false;
                    for (Iterator it3 = $this$forEach$iv3.iterator(); it3.hasNext(); it3 = it3) {
                        Object element$iv2 = it3.next();
                        Pair $dstr$id$_u24__u242 = (Pair) element$iv2;
                        long id4 = ((Number) $dstr$id$_u24__u242.component1()).longValue();
                        db.delete("heap_analysis", "id=" + id4, null);
                        LeakTable.INSTANCE.deleteByHeapAnalysisId(db, id4);
                        $this$forEach$iv3 = $this$forEach$iv3;
                        z7 = z7;
                    }
                    AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.db.HeapAnalysisTable$deleteAll$1$1$2
                        @Override // java.lang.Runnable
                        public final void run() {
                            Iterable $this$forEach$iv32 = all4;
                            for (Object element$iv22 : $this$forEach$iv32) {
                                Pair $dstr$_u24__u24$analysis = (Pair) element$iv22;
                                HeapAnalysis analysis22 = (HeapAnalysis) $dstr$_u24__u24$analysis.component2();
                                analysis22.getHeapDumpFile().delete();
                            }
                        }
                    });
                    Unit unit2 = Unit.INSTANCE;
                    $this$use$iv2.close();
                    Unit unit3 = Unit.INSTANCE;
                    db.setTransactionSuccessful();
                } catch (Throwable th9) {
                    e$iv = th9;
                }
            } finally {
                db.endTransaction();
                CursorsKt.inTransaction.set(false);
            }
        }
        notifyUpdateOnMainThread();
    }

    /* compiled from: HeapAnalysisTable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/activity/db/HeapAnalysisTable$Projection;", "", "id", "", "createdAtTimeMillis", "leakCount", "", "exceptionSummary", "", "(JJILjava/lang/String;)V", "getCreatedAtTimeMillis", "()J", "getExceptionSummary", "()Ljava/lang/String;", "getId", "getLeakCount", "()I", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Projection {
        private final long createdAtTimeMillis;
        private final String exceptionSummary;
        private final long id;
        private final int leakCount;

        public Projection(long id, long createdAtTimeMillis, int leakCount, String exceptionSummary) {
            this.id = id;
            this.createdAtTimeMillis = createdAtTimeMillis;
            this.leakCount = leakCount;
            this.exceptionSummary = exceptionSummary;
        }

        public final long getId() {
            return this.id;
        }

        public final long getCreatedAtTimeMillis() {
            return this.createdAtTimeMillis;
        }

        public final int getLeakCount() {
            return this.leakCount;
        }

        public final String getExceptionSummary() {
            return this.exceptionSummary;
        }
    }
}