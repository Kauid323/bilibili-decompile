package leakcanary.internal.activity.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import leakcanary.internal.Serializables;
import leakcanary.internal.SerializablesKt;
import shark.ApplicationLeak;
import shark.HeapAnalysis;
import shark.HeapAnalysisSuccess;
import shark.LeakTrace;
import shark.LeakTraceObject;
import shark.LeakTraceReference;
import shark.LibraryLeak;
import shark.ReferencePattern;
import shark.SharkLog;

/* compiled from: LeaksDbHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¨\u0006\u0013"}, d2 = {"Lleakcanary/internal/activity/db/LeaksDbHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onDowngrade", "oldVersion", "", "newVersion", "onUpgrade", "recreateDb", "fixNullReferenceOwningClassName", "", "Lshark/LeakTrace;", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeaksDbHelper extends SQLiteOpenHelper {
    public static final Companion Companion = new Companion(null);
    public static final String DATABASE_NAME = "leaks.db";
    public static final int VERSION = 25;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LeaksDbHelper(Context context) {
        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 25);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        db.execSQL(HeapAnalysisTable.create);
        db.execSQL(LeakTable.create);
        db.execSQL(LeakTable.createSignatureIndex);
        db.execSQL(LeakTraceTable.create);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        if (oldVersion < 23) {
            recreateDb(db);
            return;
        }
        if (oldVersion < 24) {
            db.execSQL("ALTER TABLE heap_analysis ADD COLUMN dump_duration_millis INTEGER DEFAULT -1");
        }
        if (oldVersion < 25) {
            final Cursor $this$use$iv = db.rawQuery("SELECT id, object FROM heap_analysis", null);
            Intrinsics.checkExpressionValueIsNotNull($this$use$iv, "db.rawQuery(\"SELECT id, …ROM heap_analysis\", null)");
            try {
                try {
                    List list = SequencesKt.toList(SequencesKt.map(SequencesKt.filter(SequencesKt.generateSequence(new Function0<Pair<? extends Long, ? extends HeapAnalysis>>() { // from class: leakcanary.internal.activity.db.LeaksDbHelper$onUpgrade$idToAnalysis$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Pair<? extends Long, ? extends HeapAnalysis> invoke() {
                            HeapAnalysis heapAnalysis = null;
                            if ($this$use$iv.moveToNext()) {
                                long id = $this$use$iv.getLong(0);
                                Serializables serializables = Serializables.INSTANCE;
                                byte[] byteArray$iv = $this$use$iv.getBlob(1);
                                Intrinsics.checkExpressionValueIsNotNull(byteArray$iv, "cursor.getBlob(1)");
                                ByteArrayInputStream inputStream$iv = new ByteArrayInputStream(byteArray$iv);
                                try {
                                    Object readObject = new ObjectInputStream(inputStream$iv).readObject();
                                    if (!(readObject instanceof HeapAnalysis)) {
                                        readObject = null;
                                    }
                                    heapAnalysis = (HeapAnalysis) readObject;
                                } catch (Throwable ignored$iv) {
                                    SharkLog this_$iv$iv = SharkLog.INSTANCE;
                                    SharkLog.Logger logger$iv$iv = this_$iv$iv.getLogger();
                                    if (logger$iv$iv != null) {
                                        logger$iv$iv.d(ignored$iv, "Could not deserialize bytes, ignoring");
                                    }
                                }
                                HeapAnalysis analysis = heapAnalysis;
                                return TuplesKt.to(Long.valueOf(id), analysis);
                            }
                            return null;
                        }
                    }), new Function1<Pair<? extends Long, ? extends HeapAnalysis>, Boolean>() { // from class: leakcanary.internal.activity.db.LeaksDbHelper$onUpgrade$idToAnalysis$1$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends Long, ? extends HeapAnalysis> pair) {
                            return Boolean.valueOf(invoke2((Pair<Long, ? extends HeapAnalysis>) pair));
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final boolean invoke2(Pair<Long, ? extends HeapAnalysis> it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            return it.getSecond() instanceof HeapAnalysisSuccess;
                        }
                    }), new Function1<Pair<? extends Long, ? extends HeapAnalysis>, Pair<? extends Long, ? extends HeapAnalysisSuccess>>() { // from class: leakcanary.internal.activity.db.LeaksDbHelper$onUpgrade$$inlined$use$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Pair<? extends Long, ? extends HeapAnalysisSuccess> invoke(Pair<? extends Long, ? extends HeapAnalysis> pair) {
                            return invoke2((Pair<Long, ? extends HeapAnalysis>) pair);
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final Pair<Long, HeapAnalysisSuccess> invoke2(Pair<Long, ? extends HeapAnalysis> pair) {
                            List emptyList;
                            List fixNullReferenceOwningClassName;
                            List fixNullReferenceOwningClassName2;
                            Intrinsics.checkParameterIsNotNull(pair, "pair");
                            Object second = pair.getSecond();
                            if (second == null) {
                                throw new TypeCastException("null cannot be cast to non-null type shark.HeapAnalysisSuccess");
                            }
                            HeapAnalysisSuccess analysis = (HeapAnalysisSuccess) second;
                            try {
                                emptyList = analysis.getUnreachableObjects();
                            } catch (NullPointerException e) {
                                emptyList = CollectionsKt.emptyList();
                            }
                            List unreachableObjects = emptyList != null ? emptyList : CollectionsKt.emptyList();
                            Object first = pair.getFirst();
                            Iterable $this$map$iv = analysis.getApplicationLeaks();
                            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                            for (Object item$iv$iv : $this$map$iv) {
                                ApplicationLeak leak = (ApplicationLeak) item$iv$iv;
                                fixNullReferenceOwningClassName2 = LeaksDbHelper.this.fixNullReferenceOwningClassName(leak.getLeakTraces());
                                destination$iv$iv.add(leak.copy(fixNullReferenceOwningClassName2));
                            }
                            ArrayList arrayList = (List) destination$iv$iv;
                            Iterable $this$map$iv2 = analysis.getLibraryLeaks();
                            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                            for (Object item$iv$iv2 : $this$map$iv2) {
                                LibraryLeak leak2 = (LibraryLeak) item$iv$iv2;
                                fixNullReferenceOwningClassName = LeaksDbHelper.this.fixNullReferenceOwningClassName(leak2.getLeakTraces());
                                destination$iv$iv2.add(LibraryLeak.copy$default(leak2, fixNullReferenceOwningClassName, (ReferencePattern) null, (String) null, 6, (Object) null));
                            }
                            return TuplesKt.to(first, HeapAnalysisSuccess.copy$default(analysis, (File) null, 0L, 0L, 0L, (Map) null, arrayList, (List) destination$iv$iv2, unreachableObjects, 31, (Object) null));
                        }
                    }));
                    $this$use$iv.close();
                    List idToAnalysis = list;
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
                            SQLiteDatabase $this$inTransaction = db;
                            boolean z2 = false;
                            List $this$forEach$iv = idToAnalysis;
                            for (Object element$iv : $this$forEach$iv) {
                                Pair $dstr$id$heapAnalysis = (Pair) element$iv;
                                long id = ((Number) $dstr$id$heapAnalysis.component1()).longValue();
                                ContentValues values = new ContentValues();
                                values.put("object", SerializablesKt.toByteArray((HeapAnalysisSuccess) $dstr$id$heapAnalysis.component2()));
                                db.update("heap_analysis", values, "id=" + id, null);
                                $this$inTransaction = $this$inTransaction;
                                z2 = z2;
                                $this$forEach$iv = $this$forEach$iv;
                            }
                            Unit unit = Unit.INSTANCE;
                            db.setTransactionSuccessful();
                            return;
                        } finally {
                            db.endTransaction();
                            CursorsKt.inTransaction.set(Boolean.valueOf(false));
                        }
                    }
                    SQLiteDatabase $this$inTransaction2 = db;
                    for (Object element$iv2 : idToAnalysis) {
                        Pair $dstr$id$heapAnalysis2 = (Pair) element$iv2;
                        long id2 = ((Number) $dstr$id$heapAnalysis2.component1()).longValue();
                        ContentValues values2 = new ContentValues();
                        values2.put("object", SerializablesKt.toByteArray((HeapAnalysisSuccess) $dstr$id$heapAnalysis2.component2()));
                        db.update("heap_analysis", values2, "id=" + id2, null);
                        idToAnalysis = idToAnalysis;
                        $this$inTransaction2 = $this$inTransaction2;
                    }
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
            } catch (Throwable th3) {
                e$iv = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<LeakTrace> fixNullReferenceOwningClassName(List<LeakTrace> list) {
        String owningClassName;
        LeakTraceReference leakTraceReference;
        List<LeakTrace> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LeakTrace leakTrace = (LeakTrace) item$iv$iv;
            Iterable $this$map$iv2 = leakTrace.getReferencePath();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                LeakTraceReference reference = (LeakTraceReference) item$iv$iv2;
                try {
                    owningClassName = reference.getOwningClassName();
                } catch (NullPointerException e) {
                    owningClassName = null;
                }
                if (owningClassName != null) {
                    leakTraceReference = reference;
                } else {
                    leakTraceReference = LeakTraceReference.copy$default(reference, (LeakTraceObject) null, (LeakTraceReference.ReferenceType) null, reference.getOriginObject().getClassSimpleName(), (String) null, 11, (Object) null);
                }
                destination$iv$iv2.add(leakTraceReference);
            }
            destination$iv$iv.add(LeakTrace.copy$default(leakTrace, (LeakTrace.GcRootType) null, (List) destination$iv$iv2, (LeakTraceObject) null, 5, (Object) null));
        }
        return (List) destination$iv$iv;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Intrinsics.checkParameterIsNotNull(db, "db");
        recreateDb(db);
    }

    private final void recreateDb(SQLiteDatabase db) {
        db.execSQL(HeapAnalysisTable.drop);
        db.execSQL(LeakTable.drop);
        db.execSQL(LeakTraceTable.drop);
        onCreate(db);
    }

    /* compiled from: LeaksDbHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/activity/db/LeaksDbHelper$Companion;", "", "()V", "DATABASE_NAME", "", "VERSION", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}