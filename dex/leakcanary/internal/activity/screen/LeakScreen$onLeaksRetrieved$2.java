package leakcanary.internal.activity.screen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import leakcanary.internal.Serializables;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.db.LeakTable;
import shark.HeapAnalysis;
import shark.HeapAnalysisSuccess;

/* compiled from: LeakScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"leakcanary/internal/activity/screen/LeakScreen$onLeaksRetrieved$2", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakScreen$onLeaksRetrieved$2 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ Ref.ObjectRef $lastSelectedHeapAnalysis;
    final /* synthetic */ Ref.IntRef $lastSelectedLeakTraceIndex;
    final /* synthetic */ LeakTable.LeakProjection $leak;
    final /* synthetic */ View $this_onLeaksRetrieved;
    final /* synthetic */ LeakScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LeakScreen$onLeaksRetrieved$2(LeakScreen this$0, View $receiver, LeakTable.LeakProjection $captured_local_variable$2, Ref.IntRef $captured_local_variable$3, Ref.ObjectRef $captured_local_variable$4) {
        this.this$0 = this$0;
        this.$this_onLeaksRetrieved = $receiver;
        this.$leak = $captured_local_variable$2;
        this.$lastSelectedLeakTraceIndex = $captured_local_variable$3;
        this.$lastSelectedHeapAnalysis = $captured_local_variable$4;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, final int position, long id) {
        final LeakTable.LeakTraceProjection selectedLeakTrace = this.$leak.getLeakTraces().get(position);
        final long selectedHeapAnalysisId = selectedLeakTrace.getHeapAnalysisId();
        long lastSelectedHeapAnalysisId = this.$leak.getLeakTraces().get(this.$lastSelectedLeakTraceIndex.element).getHeapAnalysisId();
        if (selectedHeapAnalysisId != lastSelectedHeapAnalysisId) {
            DbKt.executeOnDb(this.$this_onLeaksRetrieved, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeaksRetrieved$2$onItemSelected$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Db.OnDb onDb) {
                    invoke2(onDb);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Db.OnDb receiver) {
                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                    HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                    SQLiteDatabase db$iv = receiver.getDb();
                    long id$iv = selectedHeapAnalysisId;
                    HeapAnalysis heapAnalysis = null;
                    Cursor $this$use$iv$iv = db$iv.rawQuery("\n              SELECT\n              object\n              FROM heap_analysis\n              WHERE id=" + id$iv + "\n              ", null);
                    Intrinsics.checkExpressionValueIsNotNull($this$use$iv$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
                    try {
                        if ($this$use$iv$iv.moveToNext()) {
                            Serializables serializables = Serializables.INSTANCE;
                            byte[] byteArray$iv$iv = $this$use$iv$iv.getBlob(0);
                            Intrinsics.checkExpressionValueIsNotNull(byteArray$iv$iv, "cursor.getBlob(0)");
                            ByteArrayInputStream inputStream$iv$iv = new ByteArrayInputStream(byteArray$iv$iv);
                            try {
                                Object readObject = new ObjectInputStream(inputStream$iv$iv).readObject();
                                if (!(readObject instanceof HeapAnalysisSuccess)) {
                                    readObject = null;
                                }
                                HeapAnalysis analysis$iv = (HeapAnalysisSuccess) readObject;
                                if (analysis$iv == null) {
                                    HeapAnalysisTable.INSTANCE.delete(db$iv, id$iv, null);
                                }
                                heapAnalysis = analysis$iv;
                            }
                        }
                        $this$use$iv$iv.close();
                        if (heapAnalysis == null) {
                            Intrinsics.throwNpe();
                        }
                        final HeapAnalysisSuccess newSelectedHeapAnalysis = (HeapAnalysisSuccess) heapAnalysis;
                        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeaksRetrieved$2$onItemSelected$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                                invoke2(view2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Type inference failed for: r1v2, types: [T, shark.HeapAnalysisSuccess] */
                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(View receiver2) {
                                Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                LeakScreen$onLeaksRetrieved$2.this.$lastSelectedLeakTraceIndex.element = position;
                                LeakScreen$onLeaksRetrieved$2.this.$lastSelectedHeapAnalysis.element = newSelectedHeapAnalysis;
                                LeakScreen$onLeaksRetrieved$2.this.this$0.onLeakTraceSelected(receiver2, newSelectedHeapAnalysis, selectedHeapAnalysisId, selectedLeakTrace.getLeakTraceIndex());
                            }
                        });
                    } catch (Throwable e$iv$iv) {
                        try {
                            throw e$iv$iv;
                        } catch (Throwable e$iv$iv2) {
                            try {
                                $this$use$iv$iv.close();
                            } catch (Throwable th) {
                            }
                            throw e$iv$iv2;
                        }
                    }
                }
            });
            return;
        }
        this.$lastSelectedLeakTraceIndex.element = position;
        this.this$0.onLeakTraceSelected(this.$this_onLeaksRetrieved, (HeapAnalysisSuccess) this.$lastSelectedHeapAnalysis.element, selectedHeapAnalysisId, selectedLeakTrace.getLeakTraceIndex());
    }
}