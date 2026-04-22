package leakcanary.internal.activity.screen;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import leakcanary.internal.activity.db.Io;
import leakcanary.internal.activity.db.IoKt;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;
import org.apache.commons.io.FilenameUtils;
import shark.HeapField;
import shark.HeapObject;
import shark.HeapValue;
import shark.HprofRecord;
import shark.ValueHolder;

/* compiled from: HprofExplorerScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\n*\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002J\f\u0010\u000f\u001a\u00020\r*\u00020\u0010H\u0002J$\u0010\u0011\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J$\u0010\u0018\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001fH\u0002J$\u0010 \u001a\u00020\u0012*\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lleakcanary/internal/activity/screen/HprofExplorerScreen;", "Lleakcanary/internal/navigation/Screen;", "heapDumpFile", "Ljava/io/File;", "(Ljava/io/File;)V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "fieldsAsString", "", "Lkotlin/Pair;", "Lshark/HeapField;", "", "Lkotlin/sequences/Sequence;", "heapValueAsString", "Lshark/HeapValue;", "onHeapValueClicked", "", "titleView", "Landroid/widget/TextView;", "listView", "Landroid/widget/ListView;", "heapValue", "showClass", "selectedClass", "Lshark/HeapObject$HeapClass;", "showInstance", "instance", "Lshark/HeapObject$HeapInstance;", "showObjectArray", "Lshark/HeapObject$HeapObjectArray;", "showPrimitiveArray", "Lshark/HeapObject$HeapPrimitiveArray;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HprofExplorerScreen extends Screen {
    private final File heapDumpFile;

    public HprofExplorerScreen(File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        this.heapDumpFile = heapDumpFile;
    }

    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_hprof_explorer);
        ViewsKt.getActivity(container).setTitle($this$apply.getResources().getString(R.string.leak_canary_loading_title));
        Ref.ObjectRef closeable = new Ref.ObjectRef();
        closeable.element = null;
        $this$apply.addOnAttachStateChangeListener(new HprofExplorerScreen$createView$1$1(closeable));
        IoKt.executeOnIo($this$apply, new HprofExplorerScreen$createView$$inlined$apply$lambda$1(closeable, this, container));
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showClass(View $this$showClass, TextView titleView, ListView listView, HeapObject.HeapClass selectedClass) {
        IoKt.executeOnIo($this$showClass, new HprofExplorerScreen$showClass$1(this, selectedClass, titleView, listView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInstance(View $this$showInstance, TextView titleView, ListView listView, HeapObject.HeapInstance instance) {
        IoKt.executeOnIo($this$showInstance, new HprofExplorerScreen$showInstance$1(this, instance, titleView, listView));
    }

    private final void showObjectArray(View $this$showObjectArray, TextView titleView, ListView listView, HeapObject.HeapObjectArray instance) {
        IoKt.executeOnIo($this$showObjectArray, new HprofExplorerScreen$showObjectArray$1(this, instance, titleView, listView));
    }

    private final void showPrimitiveArray(View $this$showPrimitiveArray, final TextView titleView, final ListView listView, final HeapObject.HeapPrimitiveArray instance) {
        IoKt.executeOnIo($this$showPrimitiveArray, new Function1<Io.OnIo, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$showPrimitiveArray$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Io.OnIo onIo) {
                invoke2(onIo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Io.OnIo receiver) {
                Pair pair;
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump readRecord = instance.readRecord();
                int i = 0;
                if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump) {
                    boolean[] $this$map$iv = readRecord.getArray();
                    Collection destination$iv$iv = new ArrayList($this$map$iv.length);
                    int length = $this$map$iv.length;
                    while (i < length) {
                        boolean item$iv$iv = $this$map$iv[i];
                        destination$iv$iv.add(String.valueOf(item$iv$iv));
                        i++;
                    }
                    pair = TuplesKt.to("boolean", (List) destination$iv$iv);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) {
                    char[] $this$map$iv2 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump) readRecord).getArray();
                    Collection destination$iv$iv2 = new ArrayList($this$map$iv2.length);
                    int length2 = $this$map$iv2.length;
                    while (i < length2) {
                        char item$iv$iv2 = $this$map$iv2[i];
                        destination$iv$iv2.add(new StringBuilder().append('\'').append(item$iv$iv2).append('\'').toString());
                        i++;
                    }
                    pair = TuplesKt.to("char", (List) destination$iv$iv2);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) {
                    float[] $this$map$iv3 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump) readRecord).getArray();
                    Collection destination$iv$iv3 = new ArrayList($this$map$iv3.length);
                    int length3 = $this$map$iv3.length;
                    while (i < length3) {
                        float item$iv$iv3 = $this$map$iv3[i];
                        destination$iv$iv3.add(String.valueOf(item$iv$iv3));
                        i++;
                    }
                    pair = TuplesKt.to("float", (List) destination$iv$iv3);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) {
                    double[] $this$map$iv4 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump) readRecord).getArray();
                    Collection destination$iv$iv4 = new ArrayList($this$map$iv4.length);
                    int length4 = $this$map$iv4.length;
                    while (i < length4) {
                        double item$iv$iv4 = $this$map$iv4[i];
                        destination$iv$iv4.add(String.valueOf(item$iv$iv4));
                        i++;
                    }
                    pair = TuplesKt.to("double", (List) destination$iv$iv4);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) {
                    byte[] $this$map$iv5 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump) readRecord).getArray();
                    Collection destination$iv$iv5 = new ArrayList($this$map$iv5.length);
                    int length5 = $this$map$iv5.length;
                    while (i < length5) {
                        byte item$iv$iv5 = $this$map$iv5[i];
                        destination$iv$iv5.add(String.valueOf((int) item$iv$iv5));
                        i++;
                    }
                    pair = TuplesKt.to("byte", (List) destination$iv$iv5);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) {
                    short[] $this$map$iv6 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump) readRecord).getArray();
                    Collection destination$iv$iv6 = new ArrayList($this$map$iv6.length);
                    int length6 = $this$map$iv6.length;
                    while (i < length6) {
                        short item$iv$iv6 = $this$map$iv6[i];
                        destination$iv$iv6.add(String.valueOf((int) item$iv$iv6));
                        i++;
                    }
                    pair = TuplesKt.to("short", (List) destination$iv$iv6);
                } else if (readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) {
                    int[] $this$map$iv7 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump) readRecord).getArray();
                    Collection destination$iv$iv7 = new ArrayList($this$map$iv7.length);
                    int length7 = $this$map$iv7.length;
                    while (i < length7) {
                        int item$iv$iv7 = $this$map$iv7[i];
                        destination$iv$iv7.add(String.valueOf(item$iv$iv7));
                        i++;
                    }
                    pair = TuplesKt.to("int", (List) destination$iv$iv7);
                } else if (!(readRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    long[] $this$map$iv8 = ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump) readRecord).getArray();
                    Collection destination$iv$iv8 = new ArrayList($this$map$iv8.length);
                    int length8 = $this$map$iv8.length;
                    while (i < length8) {
                        long item$iv$iv8 = $this$map$iv8[i];
                        destination$iv$iv8.add(String.valueOf(item$iv$iv8));
                        i++;
                    }
                    pair = TuplesKt.to("long", (List) destination$iv$iv8);
                }
                final String type = (String) pair.component1();
                final List values = (List) pair.component2();
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$showPrimitiveArray$1.9
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
                        titleView.setText("Array " + type + AbstractJsonLexerKt.BEGIN_LIST + values.size() + AbstractJsonLexerKt.END_LIST);
                        listView.setAdapter((ListAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, values, new Function3<SimpleListAdapter<String>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showPrimitiveArray.1.9.1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<String> simpleListAdapter, View view, Integer num) {
                                invoke(simpleListAdapter, view, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SimpleListAdapter<String> receiver3, View view, int position) {
                                Intrinsics.checkParameterIsNotNull(receiver3, "$receiver");
                                Intrinsics.checkParameterIsNotNull(view, "view");
                                TextView itemTitleView = (TextView) view.findViewById(R.id.leak_canary_row_text);
                                Intrinsics.checkExpressionValueIsNotNull(itemTitleView, "itemTitleView");
                                itemTitleView.setText(type + ' ' + ((String) values.get(position)));
                            }
                        }));
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen.showPrimitiveArray.1.9.2
                            @Override // android.widget.AdapterView.OnItemClickListener
                            public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int $noName_2, long $noName_3) {
                            }
                        });
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onHeapValueClicked(View $this$onHeapValueClicked, TextView titleView, ListView listView, HeapValue heapValue) {
        if (heapValue.isNonNullReference()) {
            HeapObject objectRecord = heapValue.getAsObject();
            if (objectRecord == null) {
                Intrinsics.throwNpe();
            }
            if (objectRecord instanceof HeapObject.HeapInstance) {
                showInstance($this$onHeapValueClicked, titleView, listView, (HeapObject.HeapInstance) objectRecord);
            } else if (objectRecord instanceof HeapObject.HeapClass) {
                showClass($this$onHeapValueClicked, titleView, listView, (HeapObject.HeapClass) objectRecord);
            } else if (objectRecord instanceof HeapObject.HeapObjectArray) {
                showObjectArray($this$onHeapValueClicked, titleView, listView, (HeapObject.HeapObjectArray) objectRecord);
            } else if (objectRecord instanceof HeapObject.HeapPrimitiveArray) {
                showPrimitiveArray($this$onHeapValueClicked, titleView, listView, (HeapObject.HeapPrimitiveArray) objectRecord);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Pair<HeapField, String>> fieldsAsString(Sequence<HeapField> sequence) {
        return SequencesKt.toList(SequencesKt.map(sequence, new Function1<HeapField, Pair<? extends HeapField, ? extends String>>() { // from class: leakcanary.internal.activity.screen.HprofExplorerScreen$fieldsAsString$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Pair<HeapField, String> invoke(HeapField field) {
                String heapValueAsString;
                Intrinsics.checkParameterIsNotNull(field, "field");
                StringBuilder append = new StringBuilder().append(field.getDeclaringClass().getSimpleName()).append(FilenameUtils.EXTENSION_SEPARATOR).append(field.getName()).append(" = ");
                heapValueAsString = HprofExplorerScreen.this.heapValueAsString(field.getValue());
                return TuplesKt.to(field, append.append(heapValueAsString).toString());
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String heapValueAsString(HeapValue $this$heapValueAsString) {
        ValueHolder.ReferenceHolder holder = $this$heapValueAsString.getHolder();
        if (holder instanceof ValueHolder.ReferenceHolder) {
            if ($this$heapValueAsString.isNullReference()) {
                return AbstractJsonLexerKt.NULL;
            }
            HeapObject.HeapInstance asObject = $this$heapValueAsString.getAsObject();
            if (asObject == null) {
                Intrinsics.throwNpe();
            }
            if (asObject instanceof HeapObject.HeapInstance) {
                if (asObject.instanceOf("java.lang.String")) {
                    StringBuilder append = new StringBuilder().append(asObject.getInstanceClassName()).append('@').append(holder.getValue()).append(" \"");
                    String readAsJavaString = asObject.readAsJavaString();
                    if (readAsJavaString == null) {
                        Intrinsics.throwNpe();
                    }
                    return append.append(readAsJavaString).append('\"').toString();
                }
                return asObject.getInstanceClassName() + '@' + holder.getValue();
            } else if (asObject instanceof HeapObject.HeapClass) {
                return "Class " + ((HeapObject.HeapClass) asObject).getName();
            } else {
                if (asObject instanceof HeapObject.HeapObjectArray) {
                    return ((HeapObject.HeapObjectArray) asObject).getArrayClassName();
                }
                if (asObject instanceof HeapObject.HeapPrimitiveArray) {
                    return ((HeapObject.HeapPrimitiveArray) asObject).getArrayClassName();
                }
                throw new NoWhenBranchMatchedException();
            }
        } else if (holder instanceof ValueHolder.BooleanHolder) {
            return "boolean " + ((ValueHolder.BooleanHolder) holder).getValue();
        } else {
            if (holder instanceof ValueHolder.CharHolder) {
                return "char " + ((ValueHolder.CharHolder) holder).getValue();
            }
            if (holder instanceof ValueHolder.FloatHolder) {
                return "float " + ((ValueHolder.FloatHolder) holder).getValue();
            }
            if (holder instanceof ValueHolder.DoubleHolder) {
                return "double " + ((ValueHolder.DoubleHolder) holder).getValue();
            }
            if (holder instanceof ValueHolder.ByteHolder) {
                return "byte " + ((int) ((ValueHolder.ByteHolder) holder).getValue());
            }
            if (holder instanceof ValueHolder.ShortHolder) {
                return "short " + ((int) ((ValueHolder.ShortHolder) holder).getValue());
            }
            if (holder instanceof ValueHolder.IntHolder) {
                return "int " + ((ValueHolder.IntHolder) holder).getValue();
            }
            if (holder instanceof ValueHolder.LongHolder) {
                return "long " + ((ValueHolder.LongHolder) holder).getValue();
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}