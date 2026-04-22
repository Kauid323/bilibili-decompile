package leakcanary.internal.activity.screen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.leakcanary.core.R;
import java.io.Closeable;
import java.io.File;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import leakcanary.internal.navigation.ViewsKt;
import shark.CloseableHeapGraph;
import shark.HeapObject;
import shark.HprofHeapGraph;
import shark.ProguardMapping;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HprofExplorerScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lleakcanary/internal/activity/db/Io$OnIo;", "invoke", "leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$2"}, k = 3, mv = {1, 4, 1})
public final class HprofExplorerScreen$createView$$inlined$apply$lambda$1 extends Lambda implements Function1<Io.OnIo, Unit> {
    final /* synthetic */ Ref.ObjectRef $closeable;
    final /* synthetic */ ViewGroup $container$inlined;
    final /* synthetic */ HprofExplorerScreen this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HprofExplorerScreen$createView$$inlined$apply$lambda$1(Ref.ObjectRef objectRef, HprofExplorerScreen hprofExplorerScreen, ViewGroup viewGroup) {
        super(1);
        this.$closeable = objectRef;
        this.this$0 = hprofExplorerScreen;
        this.$container$inlined = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HprofExplorerScreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroid/view/View;", "invoke", "leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$2$1"}, k = 3, mv = {1, 4, 1})
    /* renamed from: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$$inlined$apply$lambda$1$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        final /* synthetic */ CloseableHeapGraph $graph;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CloseableHeapGraph closeableHeapGraph) {
            super(1);
            this.$graph = closeableHeapGraph;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: HprofExplorerScreen.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$2$1$1"}, k = 3, mv = {1, 4, 1})
        /* renamed from: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$$inlined$apply$lambda$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static final class View$OnClickListenerC00241 implements View.OnClickListener {
            final /* synthetic */ ListView $listView;
            final /* synthetic */ View $this_updateUi;
            final /* synthetic */ TextView $titleView;

            View$OnClickListenerC00241(View view, TextView textView, ListView listView) {
                this.$this_updateUi = view;
                this.$titleView = textView;
                this.$listView = listView;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: HprofExplorerScreen.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick", "leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$2$1$1$1"}, k = 3, mv = {1, 4, 1})
            /* renamed from: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$$inlined$apply$lambda$1$1$1$1  reason: invalid class name and collision with other inner class name */
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class DialogInterface$OnClickListenerC00251 implements DialogInterface.OnClickListener {
                final /* synthetic */ EditText $input;

                DialogInterface$OnClickListenerC00251(EditText editText) {
                    this.$input = editText;
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* compiled from: HprofExplorerScreen.kt */
                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Lleakcanary/internal/activity/db/Io$OnIo;", "invoke", "leakcanary/internal/activity/screen/HprofExplorerScreen$createView$1$2$1$1$1$1"}, k = 3, mv = {1, 4, 1})
                /* renamed from: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$$inlined$apply$lambda$1$1$1$1$1  reason: invalid class name and collision with other inner class name */
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class C00261 extends Lambda implements Function1<Io.OnIo, Unit> {
                    C00261() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
                        invoke2(onIo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Io.OnIo receiver) {
                        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                        final String partialClassName = DialogInterface$OnClickListenerC00251.this.$input.getText().toString();
                        final List matchingClasses = SequencesKt.toList(SequencesKt.filter(AnonymousClass1.this.$graph.getClasses(), new Function1<HeapObject.HeapClass, Boolean>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$.inlined.apply.lambda.1.1.1.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Boolean invoke(HeapObject.HeapClass heapClass) {
                                return Boolean.valueOf(invoke2(heapClass));
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final boolean invoke2(HeapObject.HeapClass it) {
                                Intrinsics.checkParameterIsNotNull(it, "it");
                                return StringsKt.contains$default((CharSequence) it.getName(), (CharSequence) partialClassName, false, 2, (Object) null);
                            }
                        }));
                        if (matchingClasses.isEmpty()) {
                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$.inlined.apply.lambda.1.1.1.1.1.2
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
                                    Toast.makeText(receiver2.getContext(), "No class matching [" + partialClassName + AbstractJsonLexerKt.END_LIST, 1).show();
                                }
                            });
                        } else {
                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$.inlined.apply.lambda.1.1.1.1.1.3
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
                                    TextView titleView = View$OnClickListenerC00241.this.$titleView;
                                    Intrinsics.checkExpressionValueIsNotNull(titleView, "titleView");
                                    titleView.setText(matchingClasses.size() + " classes matching [" + partialClassName + AbstractJsonLexerKt.END_LIST);
                                    ListView listView = View$OnClickListenerC00241.this.$listView;
                                    Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
                                    listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, matchingClasses, new Function3<SimpleListAdapter<HeapObject.HeapClass>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$.inlined.apply.lambda.1.1.1.1.1.3.1
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<HeapObject.HeapClass> simpleListAdapter, View view, Integer num) {
                                            invoke(simpleListAdapter, view, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SimpleListAdapter<HeapObject.HeapClass> receiver3, View view, int position) {
                                            Intrinsics.checkParameterIsNotNull(receiver3, "$receiver");
                                            Intrinsics.checkParameterIsNotNull(view, "view");
                                            TextView itemTitleView = (TextView) view.findViewById(R.id.leak_canary_row_text);
                                            Intrinsics.checkExpressionValueIsNotNull(itemTitleView, "itemTitleView");
                                            itemTitleView.setText(((HeapObject.HeapClass) matchingClasses.get(position)).getName());
                                        }
                                    }));
                                    View$OnClickListenerC00241.this.$listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$createView$.inlined.apply.lambda.1.1.1.1.1.3.2
                                        @Override // android.widget.AdapterView.OnItemClickListener
                                        public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                                            HeapObject.HeapClass selectedClass = (HeapObject.HeapClass) matchingClasses.get(position);
                                            HprofExplorerScreen hprofExplorerScreen = HprofExplorerScreen$createView$$inlined$apply$lambda$1.this.this$0;
                                            View view = receiver2;
                                            TextView titleView2 = View$OnClickListenerC00241.this.$titleView;
                                            Intrinsics.checkExpressionValueIsNotNull(titleView2, "titleView");
                                            ListView listView2 = View$OnClickListenerC00241.this.$listView;
                                            Intrinsics.checkExpressionValueIsNotNull(listView2, "listView");
                                            hprofExplorerScreen.showClass(view, titleView2, listView2, selectedClass);
                                        }
                                    });
                                }
                            });
                        }
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface $noName_0, int $noName_1) {
                    IoKt.executeOnIo(View$OnClickListenerC00241.this.$this_updateUi, new C00261());
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EditText input = new EditText(this.$this_updateUi.getContext());
                new AlertDialog.Builder(this.$this_updateUi.getContext()).setIcon(17301543).setTitle("Type a fully qualified class name").setView(input).setPositiveButton(17039370, new DialogInterface$OnClickListenerC00251(input)).setNegativeButton(17039360, (DialogInterface.OnClickListener) null).show();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(View receiver) {
            Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
            ViewsKt.getActivity(HprofExplorerScreen$createView$$inlined$apply$lambda$1.this.$container$inlined).setTitle(receiver.getResources().getString(R.string.leak_canary_explore_heap_dump));
            TextView titleView = (TextView) receiver.findViewById(R.id.leak_canary_explorer_title);
            View searchView = receiver.findViewById(R.id.leak_canary_search_button);
            ListView listView = (ListView) receiver.findViewById(R.id.leak_canary_explorer_list);
            Intrinsics.checkExpressionValueIsNotNull(titleView, "titleView");
            titleView.setVisibility(0);
            Intrinsics.checkExpressionValueIsNotNull(searchView, "searchView");
            searchView.setVisibility(0);
            Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
            listView.setVisibility(0);
            searchView.setOnClickListener(new View$OnClickListenerC00241(receiver, titleView, listView));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
        invoke2(onIo);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.io.Closeable] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Io.OnIo receiver) {
        File file;
        Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
        HprofHeapGraph.Companion companion = HprofHeapGraph.Companion;
        file = this.this$0.heapDumpFile;
        CloseableHeapGraph graph = HprofHeapGraph.Companion.openHeapGraph$default(companion, file, (ProguardMapping) null, (Set) null, 3, (Object) null);
        this.$closeable.element = (Closeable) graph;
        receiver.updateUi(new AnonymousClass1(graph));
    }
}