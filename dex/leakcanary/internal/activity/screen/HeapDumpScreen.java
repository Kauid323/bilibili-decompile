package leakcanary.internal.activity.screen;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import leakcanary.internal.Serializables;
import leakcanary.internal.activity.LeakViewsKt;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.db.LeakTable;
import leakcanary.internal.activity.ui.TimeFormatter;
import leakcanary.internal.activity.ui.UiUtils;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;
import org.webrtc.H265Utils;
import shark.HeapAnalysis;
import shark.HeapAnalysisSuccess;
import shark.Leak;
import shark.LibraryLeak;
import shark.SharkLog;

/* compiled from: HeapDumpScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J.\u0010\t\u001a\u00020\u0006*\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J0\u0010\u0010\u001a\u00020\u0011*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lleakcanary/internal/activity/screen/HeapDumpScreen;", "Lleakcanary/internal/navigation/Screen;", "analysisId", "", "(J)V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "bindMetadataRow", "convertView", "parent", "heapDumpFileExist", "", "heapAnalysis", "Lshark/HeapAnalysisSuccess;", "onSuccessRetrieved", "", "leakReadStatus", "", "", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapDumpScreen extends Screen {
    public static final Companion Companion = new Companion(null);
    public static final int LEAK_ROW = 2;
    public static final int LEAK_TITLE = 1;
    public static final int METADATA = 0;
    private final long analysisId;

    public HeapDumpScreen(long analysisId) {
        this.analysisId = analysisId;
    }

    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_list);
        ViewsKt.getActivity($this$apply).setTitle($this$apply.getResources().getString(R.string.leak_canary_loading_title));
        DbKt.executeOnDb($this$apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$createView$$inlined$apply$lambda$1
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
                long id$iv;
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                SQLiteDatabase db$iv = receiver.getDb();
                id$iv = HeapDumpScreen.this.analysisId;
                HeapAnalysis heapAnalysis = null;
                Cursor $this$use$iv$iv = db$iv.rawQuery("\n              SELECT\n              object\n              FROM heap_analysis\n              WHERE id=" + id$iv + "\n              ", null);
                Intrinsics.checkExpressionValueIsNotNull($this$use$iv$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
                try {
                    if ($this$use$iv$iv.moveToNext()) {
                        Serializables serializables = Serializables.INSTANCE;
                        byte[] byteArray$iv$iv = $this$use$iv$iv.getBlob(0);
                        Intrinsics.checkExpressionValueIsNotNull(byteArray$iv$iv, "cursor.getBlob(0)");
                        ByteArrayInputStream inputStream$iv$iv = new ByteArrayInputStream(byteArray$iv$iv);
                        Object readObject = new ObjectInputStream(inputStream$iv$iv).readObject();
                        if (!(readObject instanceof HeapAnalysisSuccess)) {
                            readObject = null;
                        }
                        try {
                            HeapAnalysis analysis$iv = (HeapAnalysisSuccess) readObject;
                            if (analysis$iv == null) {
                                HeapAnalysisTable.INSTANCE.delete(db$iv, id$iv, null);
                            }
                            heapAnalysis = analysis$iv;
                        }
                    }
                    $this$use$iv$iv.close();
                    final HeapAnalysisSuccess heapAnalysis2 = (HeapAnalysisSuccess) heapAnalysis;
                    if (heapAnalysis2 == null) {
                        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$createView$1$1$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(View receiver2) {
                                Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                ViewsKt.getActivity(receiver2).setTitle(receiver2.getResources().getString(R.string.leak_canary_analysis_deleted_title));
                            }
                        });
                        return;
                    }
                    Set signatures = SequencesKt.toSet(SequencesKt.map(heapAnalysis2.getAllLeaks(), new Function1<Leak, String>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$createView$1$1$signatures$1
                        @Override // kotlin.jvm.functions.Function1
                        public final String invoke(Leak it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            return it.getSignature();
                        }
                    }));
                    final Map leakReadStatus = LeakTable.INSTANCE.retrieveLeakReadStatuses(receiver.getDb(), signatures);
                    final boolean heapDumpFileExist = heapAnalysis2.getHeapDumpFile().exists();
                    receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$createView$$inlined$apply$lambda$1.1
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
                            HeapDumpScreen.this.onSuccessRetrieved(receiver2, heapAnalysis2, leakReadStatus, heapDumpFileExist);
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
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSuccessRetrieved(final View $this$onSuccessRetrieved, final HeapAnalysisSuccess heapAnalysis, final Map<String, Boolean> map, final boolean heapDumpFileExist) {
        Activity activity = ViewsKt.getActivity($this$onSuccessRetrieved);
        TimeFormatter timeFormatter = TimeFormatter.INSTANCE;
        Context context = $this$onSuccessRetrieved.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        activity.setTitle(timeFormatter.formatTimestamp(context, heapAnalysis.getCreatedAtTimeMillis()));
        ViewsKt.onCreateOptionsMenu($this$onSuccessRetrieved, new HeapDumpScreen$onSuccessRetrieved$1(this, $this$onSuccessRetrieved, heapAnalysis, heapDumpFileExist));
        ListView listView = (ListView) $this$onSuccessRetrieved.findViewById(R.id.leak_canary_list);
        Sequence $this$sortedByDescending$iv = heapAnalysis.getAllLeaks();
        final List leaks = SequencesKt.toList(SequencesKt.sortedWith($this$sortedByDescending$iv, new Comparator<T>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$onSuccessRetrieved$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Leak it = (Leak) t2;
                Leak it2 = (Leak) t;
                return ComparisonsKt.compareValues(Integer.valueOf(it.getLeakTraces().size()), Integer.valueOf(it2.getLeakTraces().size()));
            }
        }));
        Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
        listView.setAdapter((ListAdapter) new BaseAdapter() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$onSuccessRetrieved$2
            @Override // android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                View bindMetadataRow;
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                switch (getItemViewType(position)) {
                    case 0:
                        bindMetadataRow = HeapDumpScreen.this.bindMetadataRow($this$onSuccessRetrieved, convertView, parent, heapDumpFileExist, heapAnalysis);
                        return bindMetadataRow;
                    case 1:
                        View view = convertView != null ? convertView : ViewsKt.inflate(parent, R.layout.leak_canary_heap_dump_leak_title);
                        TextView leaksTextView = (TextView) view.findViewById(R.id.leak_canary_heap_dump_leaks);
                        Intrinsics.checkExpressionValueIsNotNull(leaksTextView, "leaksTextView");
                        leaksTextView.setText($this$onSuccessRetrieved.getResources().getQuantityString(R.plurals.leak_canary_distinct_leaks, leaks.size(), Integer.valueOf(leaks.size())));
                        return view;
                    case 2:
                        View view2 = convertView != null ? convertView : ViewsKt.inflate(parent, R.layout.leak_canary_leak_row);
                        TextView countView = (TextView) view2.findViewById(R.id.leak_canary_count_text);
                        TextView descriptionView = (TextView) view2.findViewById(R.id.leak_canary_leak_text);
                        TextView timeView = (TextView) view2.findViewById(R.id.leak_canary_time_text);
                        TextView newChipView = (TextView) view2.findViewById(R.id.leak_canary_chip_new);
                        TextView libraryLeakChipView = (TextView) view2.findViewById(R.id.leak_canary_chip_library_leak);
                        Leak leak = (Leak) leaks.get(position - 2);
                        boolean isNew = true ^ ((Boolean) MapsKt.getValue(map, leak.getSignature())).booleanValue();
                        Intrinsics.checkExpressionValueIsNotNull(countView, "countView");
                        countView.setEnabled(isNew);
                        countView.setText(String.valueOf(leak.getLeakTraces().size()));
                        Intrinsics.checkExpressionValueIsNotNull(newChipView, "newChipView");
                        newChipView.setVisibility(isNew ? 0 : 8);
                        Intrinsics.checkExpressionValueIsNotNull(libraryLeakChipView, "libraryLeakChipView");
                        libraryLeakChipView.setVisibility(leak instanceof LibraryLeak ? 0 : 8);
                        Intrinsics.checkExpressionValueIsNotNull(descriptionView, "descriptionView");
                        descriptionView.setText(leak.getShortDescription());
                        TimeFormatter timeFormatter2 = TimeFormatter.INSTANCE;
                        Context context2 = view2.getContext();
                        Intrinsics.checkExpressionValueIsNotNull(context2, "view.context");
                        String formattedDate = timeFormatter2.formatTimestamp(context2, heapAnalysis.getCreatedAtTimeMillis());
                        Intrinsics.checkExpressionValueIsNotNull(timeView, "timeView");
                        timeView.setText(formattedDate);
                        return view2;
                    default:
                        throw new IllegalStateException("Unexpected type " + getItemViewType(position));
                }
            }

            @Override // android.widget.Adapter
            public HeapDumpScreen$onSuccessRetrieved$2 getItem(int position) {
                return this;
            }

            @Override // android.widget.Adapter
            public long getItemId(int position) {
                return position;
            }

            @Override // android.widget.Adapter
            public int getCount() {
                return leaks.size() + 2;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public int getItemViewType(int position) {
                switch (position) {
                    case 0:
                        return 0;
                    case 1:
                        return 1;
                    default:
                        return 2;
                }
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public int getViewTypeCount() {
                return 3;
            }

            @Override // android.widget.BaseAdapter, android.widget.ListAdapter
            public boolean isEnabled(int position) {
                return getItemViewType(position) == 2;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$onSuccessRetrieved$3
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View $noName_1, int position, long $noName_3) {
                long j;
                if (position > 1) {
                    View view = $this$onSuccessRetrieved;
                    String signature = ((Leak) leaks.get(position - 2)).getSignature();
                    j = HeapDumpScreen.this.analysisId;
                    ViewsKt.goTo(view, new LeakScreen(signature, Long.valueOf(j)));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View bindMetadataRow(final View $this$bindMetadataRow, View convertView, ViewGroup parent, boolean heapDumpFileExist, final HeapAnalysisSuccess heapAnalysis) {
        String dumpDurationMillis;
        View view = convertView != null ? convertView : ViewsKt.inflate(parent, R.layout.leak_canary_leak_header);
        TextView textView = (TextView) view.findViewById(R.id.leak_canary_header_text);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textView");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        String explore = heapDumpFileExist ? "Explore <a href=\"explore_hprof\">Heap Dump</a><br><br>" : "";
        String shareFile = heapDumpFileExist ? "Share <a href=\"share_hprof\">Heap Dump file</a><br><br>" : "";
        if (heapAnalysis.getDumpDurationMillis() != -1) {
            dumpDurationMillis = heapAnalysis.getDumpDurationMillis() + " ms";
        } else {
            dumpDurationMillis = "Unknown";
        }
        Map $this$map$iv = MapsKt.plus(heapAnalysis.getMetadata(), MapsKt.mapOf(TuplesKt.to("Analysis duration", heapAnalysis.getAnalysisDurationMillis() + " ms"), TuplesKt.to("Heap dump file path", heapAnalysis.getHeapDumpFile().getAbsolutePath()), TuplesKt.to("Heap dump timestamp", String.valueOf(heapAnalysis.getCreatedAtTimeMillis())), TuplesKt.to("Heap dump duration", dumpDurationMillis)));
        Collection destination$iv$iv = new ArrayList($this$map$iv.size());
        for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
            destination$iv$iv.add("<b>" + ((String) item$iv$iv.getKey()) + ":</b> " + ((String) item$iv$iv.getValue()));
            dumpDurationMillis = dumpDurationMillis;
        }
        final String metadata = CollectionsKt.joinToString$default((List) destination$iv$iv, "<br>", null, null, 0, null, null, 62, null);
        String titleText = explore + "Share <a href=\"share\">Heap Dump analysis</a><br><br>Print analysis <a href=\"print\">to Logcat</a> (tag: LeakCanary)<br><br>" + shareFile + "See <a href=\"metadata\">Metadata</a>";
        Spanned fromHtml = Html.fromHtml(titleText);
        if (fromHtml != null) {
            SpannableStringBuilder title = (SpannableStringBuilder) fromHtml;
            UiUtils.INSTANCE.replaceUrlSpanWithAction$leakcanary_android_core_release(title, new Function1<String, Function0<? extends Unit>>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Function0<Unit> invoke(String urlSpan) {
                    Intrinsics.checkParameterIsNotNull(urlSpan, "urlSpan");
                    switch (urlSpan.hashCode()) {
                        case -450004177:
                            if (urlSpan.equals("metadata")) {
                                return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1.5
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
                                        new AlertDialog.Builder($this$bindMetadataRow.getContext()).setIcon(17301659).setTitle("Metadata").setMessage(Html.fromHtml(metadata)).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).show();
                                    }
                                };
                            }
                            break;
                        case -86830315:
                            if (urlSpan.equals("explore_hprof")) {
                                return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1.1
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
                                        ViewsKt.goTo($this$bindMetadataRow, new HprofExplorerScreen(heapAnalysis.getHeapDumpFile()));
                                    }
                                };
                            }
                            break;
                        case 106934957:
                            if (urlSpan.equals("print")) {
                                return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1.3
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
                                        SharkLog this_$iv = SharkLog.INSTANCE;
                                        SharkLog.Logger logger$iv = this_$iv.getLogger();
                                        if (logger$iv != null) {
                                            logger$iv.d("\u200b\n" + LeakTraceWrapper.INSTANCE.wrap(heapAnalysis.toString(), H265Utils.kLevel4));
                                        }
                                    }
                                };
                            }
                            break;
                        case 109400031:
                            if (urlSpan.equals("share")) {
                                return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1.2
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
                                        LeakViewsKt.share($this$bindMetadataRow, LeakTraceWrapper.INSTANCE.wrap(heapAnalysis.toString(), 80));
                                    }
                                };
                            }
                            break;
                        case 396771169:
                            if (urlSpan.equals("share_hprof")) {
                                return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapDumpScreen$bindMetadataRow$1.4
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
                                        LeakViewsKt.shareHeapDump($this$bindMetadataRow, heapAnalysis.getHeapDumpFile());
                                    }
                                };
                            }
                            break;
                    }
                    return null;
                }
            });
            textView.setText(title);
            return view;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
    }

    /* compiled from: HeapDumpScreen.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lleakcanary/internal/activity/screen/HeapDumpScreen$Companion;", "", "()V", "LEAK_ROW", "", "LEAK_TITLE", "METADATA", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}