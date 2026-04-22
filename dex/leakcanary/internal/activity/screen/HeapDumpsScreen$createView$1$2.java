package leakcanary.internal.activity.screen;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.ui.SimpleListAdapter;

/* compiled from: HeapDumpsScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "menu", "Landroid/view/Menu;", "invoke"}, k = 3, mv = {1, 4, 1})
final class HeapDumpsScreen$createView$1$2 extends Lambda implements Function1<Menu, Unit> {
    final /* synthetic */ View $this_apply;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeapDumpsScreen$createView$1$2(View view) {
        super(1);
        this.$this_apply = view;
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
            menu.add(R.string.leak_canary_delete_all).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen$createView$1$2.1
                @Override // android.view.MenuItem.OnMenuItemClickListener
                public final boolean onMenuItemClick(MenuItem it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    new AlertDialog.Builder(HeapDumpsScreen$createView$1$2.this.$this_apply.getContext()).setIcon(17301543).setTitle(R.string.leak_canary_delete_all).setMessage(R.string.leak_canary_delete_all_leaks_title).setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen.createView.1.2.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface $noName_0, int $noName_1) {
                            DbKt.executeOnDb(HeapDumpsScreen$createView$1$2.this.$this_apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen.createView.1.2.1.1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Db.OnDb onDb) {
                                    invoke2(onDb);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(Db.OnDb receiver) {
                                    Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                                    HeapAnalysisTable.INSTANCE.deleteAll(receiver.getDb());
                                    receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen.createView.1.2.1.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                            invoke2(view);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(View receiver2) {
                                            Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                            ListView listView = (ListView) receiver2.findViewById(R.id.leak_canary_list);
                                            Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
                                            listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, CollectionsKt.emptyList(), new Function3<SimpleListAdapter<Object>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpsScreen.createView.1.2.1.1.1.1.1
                                                @Override // kotlin.jvm.functions.Function3
                                                public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<Object> simpleListAdapter, View view, Integer num) {
                                                    invoke(simpleListAdapter, view, num.intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(SimpleListAdapter<Object> receiver3, View $noName_12, int $noName_2) {
                                                    Intrinsics.checkParameterIsNotNull(receiver3, "$receiver");
                                                    Intrinsics.checkParameterIsNotNull($noName_12, "<anonymous parameter 0>");
                                                }
                                            }));
                                        }
                                    });
                                }
                            });
                        }
                    }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
                    return true;
                }
            });
        }
    }
}