package leakcanary.internal.activity.screen;

import android.app.ActivityManager;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.navigation.ViewsKt;
import shark.HeapAnalysisFailure;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HeapAnalysisFailureScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "menu", "Landroid/view/Menu;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class HeapAnalysisFailureScreen$onFailureRetrieved$3 extends Lambda implements Function1<Menu, Unit> {
    final /* synthetic */ HeapAnalysisFailure $heapAnalysis;
    final /* synthetic */ View $this_onFailureRetrieved;
    final /* synthetic */ HeapAnalysisFailureScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeapAnalysisFailureScreen$onFailureRetrieved$3(HeapAnalysisFailureScreen heapAnalysisFailureScreen, View view, HeapAnalysisFailure heapAnalysisFailure) {
        super(1);
        this.this$0 = heapAnalysisFailureScreen;
        this.$this_onFailureRetrieved = view;
        this.$heapAnalysis = heapAnalysisFailure;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Menu menu) {
        invoke2(menu);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Menu menu) {
        Intrinsics.checkParameterIsNotNull(menu, "menu");
        if (!ActivityManager.isUserAMonkey()) {
            menu.add(R.string.leak_canary_delete).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$onFailureRetrieved$3.1
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    DbKt.executeOnDb(HeapAnalysisFailureScreen$onFailureRetrieved$3.this.$this_onFailureRetrieved, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen.onFailureRetrieved.3.1.1
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
                            long j;
                            Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                            HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                            SQLiteDatabase db = receiver.getDb();
                            j = HeapAnalysisFailureScreen$onFailureRetrieved$3.this.this$0.analysisId;
                            heapAnalysisTable.delete(db, j, HeapAnalysisFailureScreen$onFailureRetrieved$3.this.$heapAnalysis.getHeapDumpFile());
                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen.onFailureRetrieved.3.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                    invoke2(view);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(View receiver2) {
                                    Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                    ViewsKt.goBack(receiver2);
                                }
                            });
                        }
                    });
                    return true;
                }
            });
        }
    }
}