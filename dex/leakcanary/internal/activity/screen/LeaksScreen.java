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
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.db.LeakTable;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import leakcanary.internal.activity.ui.TimeFormatter;
import leakcanary.internal.navigation.NavigatingActivity;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: LeaksScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b*\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002¨\u0006\f"}, d2 = {"Lleakcanary/internal/activity/screen/LeaksScreen;", "Lleakcanary/internal/navigation/Screen;", "()V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "onGroupsRetrieved", "", "projections", "", "Lleakcanary/internal/activity/db/LeakTable$AllLeaksProjection;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeaksScreen extends Screen {
    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        final View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_list);
        final Function0 unsubscribeRefresh = HeapAnalysisTable.INSTANCE.onUpdate(new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeaksScreen$createView$1$unsubscribeRefresh$1
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
        ViewsKt.onScreenExiting($this$apply, new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeaksScreen$createView$1$1
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
        DbKt.executeOnDb($this$apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.LeaksScreen$createView$$inlined$apply$lambda$1
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
                final List projections = LeakTable.INSTANCE.retrieveAllLeaks(receiver.getDb());
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeaksScreen$createView$$inlined$apply$lambda$1.1
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
                        LeaksScreen.this.onGroupsRetrieved(receiver2, projections);
                    }
                });
            }
        });
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGroupsRetrieved(final View $this$onGroupsRetrieved, final List<LeakTable.AllLeaksProjection> list) {
        ViewsKt.getActivity($this$onGroupsRetrieved).setTitle($this$onGroupsRetrieved.getResources().getQuantityString(R.plurals.leak_canary_distinct_leaks, list.size(), Integer.valueOf(list.size())));
        ListView listView = (ListView) $this$onGroupsRetrieved.findViewById(R.id.leak_canary_list);
        Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
        listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_leak_row, list, new Function3<SimpleListAdapter<LeakTable.AllLeaksProjection>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.LeaksScreen$onGroupsRetrieved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<LeakTable.AllLeaksProjection> simpleListAdapter, View view, Integer num) {
                invoke(simpleListAdapter, view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SimpleListAdapter<LeakTable.AllLeaksProjection> receiver, View view, int position) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                Intrinsics.checkParameterIsNotNull(view, "view");
                TextView countView = (TextView) view.findViewById(R.id.leak_canary_count_text);
                TextView descriptionView = (TextView) view.findViewById(R.id.leak_canary_leak_text);
                TextView timeView = (TextView) view.findViewById(R.id.leak_canary_time_text);
                TextView newChipView = (TextView) view.findViewById(R.id.leak_canary_chip_new);
                TextView libraryLeakChipView = (TextView) view.findViewById(R.id.leak_canary_chip_library_leak);
                LeakTable.AllLeaksProjection projection = (LeakTable.AllLeaksProjection) list.get(position);
                Intrinsics.checkExpressionValueIsNotNull(countView, "countView");
                countView.setEnabled(projection.isNew());
                Intrinsics.checkExpressionValueIsNotNull(newChipView, "newChipView");
                newChipView.setVisibility(projection.isNew() ? 0 : 8);
                Intrinsics.checkExpressionValueIsNotNull(libraryLeakChipView, "libraryLeakChipView");
                libraryLeakChipView.setVisibility(projection.isLibraryLeak() ? 0 : 8);
                countView.setText(String.valueOf(projection.getLeakTraceCount()));
                Intrinsics.checkExpressionValueIsNotNull(descriptionView, "descriptionView");
                descriptionView.setText(projection.getShortDescription());
                TimeFormatter timeFormatter = TimeFormatter.INSTANCE;
                Context context = view.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
                String formattedDate = timeFormatter.formatTimestamp(context, projection.getCreatedAtTimeMillis());
                Intrinsics.checkExpressionValueIsNotNull(timeView, "timeView");
                timeView.setText($this$onGroupsRetrieved.getResources().getString(R.string.leak_canary_group_list_time_label, formattedDate));
            }
        }));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.LeaksScreen$onGroupsRetrieved$2
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                ViewsKt.goTo($this$onGroupsRetrieved, new LeakScreen(((LeakTable.AllLeaksProjection) list.get(position)).getSignature(), null, 2, null));
            }
        });
    }
}