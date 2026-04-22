package leakcanary.internal.activity.screen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.LeakCanary;
import leakcanary.internal.activity.LeakActivity;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import leakcanary.internal.activity.ui.TimeFormatter;
import leakcanary.internal.navigation.NavigatingActivity;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: HeapDumpsScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\f"}, d2 = {"Lleakcanary/internal/activity/screen/HeapDumpsScreen;", "Lleakcanary/internal/navigation/Screen;", "()V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "onAnalysesRetrieved", "", "projections", "", "Lleakcanary/internal/activity/db/HeapAnalysisTable$Projection;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapDumpsScreen extends Screen {
    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        final View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_heap_dumps_screen);
        final Function0 unsubscribeRefresh = HeapAnalysisTable.INSTANCE.onUpdate(new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$1$unsubscribeRefresh$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ((NavigatingActivity) ViewsKt.activity($this$apply)).refreshCurrentScreen();
            }
        });
        ViewsKt.onScreenExiting($this$apply, new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$1$1
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
                Function0.this.invoke();
            }
        });
        ViewsKt.onCreateOptionsMenu($this$apply, new HeapDumpsScreen$createView$1$2($this$apply));
        $this$apply.findViewById(R.id.leak_canary_import_heap_dump).setOnClickListener(new View.OnClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$1$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                ((LeakActivity) ViewsKt.activity($this$apply)).requestImportHprof();
            }
        });
        $this$apply.findViewById(R.id.leak_canary_dump_heap_now).setOnClickListener(new View.OnClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$1$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                LeakCanary.INSTANCE.dumpHeap();
            }
        });
        DbKt.executeOnDb($this$apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                final List projections = HeapAnalysisTable.INSTANCE.retrieveAll(receiver.getDb());
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$$inlined$apply$lambda$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View receiver2) {
                        Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                        HeapDumpsScreen.this.onAnalysesRetrieved(receiver2, projections);
                    }
                });
            }
        });
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAnalysesRetrieved(final View $this$onAnalysesRetrieved, final List<HeapAnalysisTable.Projection> list) {
        ViewsKt.getActivity($this$onAnalysesRetrieved).setTitle($this$onAnalysesRetrieved.getResources().getQuantityString(R.plurals.leak_canary_heap_analysis_list_screen_title, list.size(), Integer.valueOf(list.size())));
        ListView listView = (ListView) $this$onAnalysesRetrieved.findViewById(R.id.leak_canary_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$onAnalysesRetrieved$1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                HeapDumpScreen analysisScreen;
                HeapAnalysisTable.Projection projection = (HeapAnalysisTable.Projection) list.get(position);
                if (projection.getExceptionSummary() != null) {
                    analysisScreen = new HeapAnalysisFailureScreen(projection.getId());
                } else {
                    analysisScreen = new HeapDumpScreen(projection.getId());
                }
                ViewsKt.goTo($this$onAnalysesRetrieved, analysisScreen);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
        listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_leak_row, list, new Function3<SimpleListAdapter<HeapAnalysisTable.Projection>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$onAnalysesRetrieved$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<HeapAnalysisTable.Projection> simpleListAdapter, View view, Integer num) {
                invoke(simpleListAdapter, view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SimpleListAdapter<HeapAnalysisTable.Projection> receiver, View view, int position) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                Intrinsics.checkParameterIsNotNull(view, "view");
                TextView goneView = (TextView) view.findViewById(R.id.leak_canary_count_text);
                Intrinsics.checkExpressionValueIsNotNull(goneView, "goneView");
                goneView.setVisibility(8);
                TextView timeView = (TextView) view.findViewById(R.id.leak_canary_leak_text);
                TextView countView = (TextView) view.findViewById(R.id.leak_canary_time_text);
                HeapAnalysisTable.Projection projection = receiver.getItem(position);
                Intrinsics.checkExpressionValueIsNotNull(countView, "countView");
                countView.setEnabled(false);
                Intrinsics.checkExpressionValueIsNotNull(timeView, "timeView");
                TimeFormatter timeFormatter = TimeFormatter.INSTANCE;
                Context context = view.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
                timeView.setText(timeFormatter.formatTimestamp(context, projection.getCreatedAtTimeMillis()));
                String exceptionSummary = projection.getExceptionSummary();
                if (exceptionSummary == null) {
                    exceptionSummary = $this$onAnalysesRetrieved.getResources().getQuantityString(R.plurals.leak_canary_distinct_leaks, projection.getLeakCount(), Integer.valueOf(projection.getLeakCount()));
                    Intrinsics.checkExpressionValueIsNotNull(exceptionSummary, "resources.getQuantityStr…ction.leakCount\n        )");
                }
                String count = exceptionSummary;
                countView.setText(count);
            }
        }));
    }
}