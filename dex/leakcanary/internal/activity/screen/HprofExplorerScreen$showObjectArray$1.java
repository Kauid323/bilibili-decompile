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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import shark.HeapObject;
import shark.HeapValue;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HprofExplorerScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lleakcanary/internal/activity/db/Io$OnIo;", "invoke"}, k = 3, mv = {1, 4, 1})
public final class HprofExplorerScreen$showObjectArray$1 extends Lambda implements Function1<Io.OnIo, Unit> {
    final /* synthetic */ HeapObject.HeapObjectArray $instance;
    final /* synthetic */ ListView $listView;
    final /* synthetic */ TextView $titleView;
    final /* synthetic */ HprofExplorerScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HprofExplorerScreen$showObjectArray$1(HprofExplorerScreen hprofExplorerScreen, HeapObject.HeapObjectArray heapObjectArray, TextView textView, ListView listView) {
        super(1);
        this.this$0 = hprofExplorerScreen;
        this.$instance = heapObjectArray;
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
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        final List elements = SequencesKt.toList(SequencesKt.mapIndexed(this.$instance.readElements(), new Function2<Integer, HeapValue, Pair<? extends HeapValue, ? extends String>>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$showObjectArray$1$elements$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Pair<? extends HeapValue, ? extends String> invoke(Integer num, HeapValue heapValue) {
                return invoke(num.intValue(), heapValue);
            }

            public final Pair<HeapValue, String> invoke(int index, HeapValue element) {
                String heapValueAsString;
                Intrinsics.checkParameterIsNotNull(element, "element");
                StringBuilder append = new StringBuilder().append(AbstractJsonLexerKt.BEGIN_LIST).append(index).append("] = ");
                heapValueAsString = HprofExplorerScreen$showObjectArray$1.this.this$0.heapValueAsString(element);
                return TuplesKt.to(element, append.append(heapValueAsString).toString());
            }
        }));
        String arrayClassName = this.$instance.getArrayClassName();
        int length = arrayClassName.length() - 2;
        if (arrayClassName == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        final String className = arrayClassName.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(className, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$showObjectArray$1.1
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
                HprofExplorerScreen$showObjectArray$1.this.$titleView.setText("Array " + className + AbstractJsonLexerKt.BEGIN_LIST + elements.size() + AbstractJsonLexerKt.END_LIST);
                HprofExplorerScreen$showObjectArray$1.this.$listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, elements, new Function3<SimpleListAdapter<Pair<? extends HeapValue, ? extends String>>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showObjectArray.1.1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<Pair<? extends HeapValue, ? extends String>> simpleListAdapter, View view, Integer num) {
                        invoke((SimpleListAdapter<Pair<HeapValue, String>>) simpleListAdapter, view, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(SimpleListAdapter<Pair<HeapValue, String>> receiver3, View view, int position) {
                        Intrinsics.checkParameterIsNotNull(receiver3, "$receiver");
                        Intrinsics.checkParameterIsNotNull(view, "view");
                        TextView itemTitleView = (TextView) view.findViewById(R.id.leak_canary_row_text);
                        Intrinsics.checkExpressionValueIsNotNull(itemTitleView, "itemTitleView");
                        itemTitleView.setText((CharSequence) ((Pair) elements.get(position)).getSecond());
                    }
                }));
                HprofExplorerScreen$showObjectArray$1.this.$listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showObjectArray.1.1.2
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                        HeapValue element = (HeapValue) ((Pair) elements.get(position)).getFirst();
                        HprofExplorerScreen$showObjectArray$1.this.this$0.onHeapValueClicked(receiver2, HprofExplorerScreen$showObjectArray$1.this.$titleView, HprofExplorerScreen$showObjectArray$1.this.$listView, element);
                    }
                });
            }
        });
    }
}