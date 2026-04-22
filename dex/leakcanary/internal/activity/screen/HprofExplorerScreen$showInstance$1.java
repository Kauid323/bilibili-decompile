package leakcanary.internal.activity.screen;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import shark.HeapField;
import shark.HeapObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HprofExplorerScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lleakcanary/internal/activity/db/Io$OnIo;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class HprofExplorerScreen$showInstance$1 extends Lambda implements Function1<Io.OnIo, Unit> {
    final /* synthetic */ HeapObject.HeapInstance $instance;
    final /* synthetic */ ListView $listView;
    final /* synthetic */ TextView $titleView;
    final /* synthetic */ HprofExplorerScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HprofExplorerScreen$showInstance$1(HprofExplorerScreen hprofExplorerScreen, HeapObject.HeapInstance heapInstance, TextView textView, ListView listView) {
        super(1);
        this.this$0 = hprofExplorerScreen;
        this.$instance = heapInstance;
        this.$titleView = textView;
        this.$listView = listView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
        invoke2(onIo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Io.OnIo receiver) {
        final List fields;
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        fields = this.this$0.fieldsAsString(this.$instance.readFields());
        final String className = this.$instance.getInstanceClassName();
        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$showInstance$1.1
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
            public final void invoke2(final View receiver2) {
                Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                HprofExplorerScreen$showInstance$1.this.$titleView.setText("Instance @" + HprofExplorerScreen$showInstance$1.this.$instance.getObjectId() + " of class " + className);
                HprofExplorerScreen$showInstance$1.this.$listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, fields, new Function3<SimpleListAdapter<Pair<? extends HeapField, ? extends String>>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showInstance.1.1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<Pair<? extends HeapField, ? extends String>> simpleListAdapter, View view, Integer num) {
                        invoke((SimpleListAdapter<Pair<HeapField, String>>) simpleListAdapter, view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SimpleListAdapter<Pair<HeapField, String>> receiver3, View view, int position) {
                        Intrinsics.checkParameterIsNotNull(receiver3, "$receiver");
                        Intrinsics.checkParameterIsNotNull(view, "view");
                        TextView itemTitleView = (TextView) view.findViewById(R.id.leak_canary_row_text);
                        Intrinsics.checkExpressionValueIsNotNull(itemTitleView, "itemTitleView");
                        itemTitleView.setText((CharSequence) ((Pair) fields.get(position)).getSecond());
                    }
                }));
                HprofExplorerScreen$showInstance$1.this.$listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showInstance.1.1.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                        HeapField field = (HeapField) ((Pair) fields.get(position)).getFirst();
                        HprofExplorerScreen$showInstance$1.this.this$0.onHeapValueClicked(receiver2, HprofExplorerScreen$showInstance$1.this.$titleView, HprofExplorerScreen$showInstance$1.this.$listView, field.getValue());
                    }
                });
            }
        });
    }
}