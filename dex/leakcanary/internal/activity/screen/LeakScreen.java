package leakcanary.internal.activity.screen;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import leakcanary.internal.DisplayLeakAdapter;
import leakcanary.internal.Serializables;
import leakcanary.internal.SquigglySpan;
import leakcanary.internal.activity.LeakViewsKt;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.db.LeakTable;
import leakcanary.internal.activity.ui.SimpleListAdapter;
import leakcanary.internal.activity.ui.TimeFormatter;
import leakcanary.internal.activity.ui.UiUtils;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;
import org.apache.commons.io.IOUtils;
import org.webrtc.H265Utils;
import shark.HeapAnalysis;
import shark.HeapAnalysisSuccess;
import shark.Leak;
import shark.LeakTrace;
import shark.LibraryLeak;
import shark.SharkLog;

/* compiled from: LeakScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u0017\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u00020\t*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006 "}, d2 = {"Lleakcanary/internal/activity/screen/LeakScreen;", "Lleakcanary/internal/navigation/Screen;", "leakSignature", "", "selectedHeapAnalysisId", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "Ljava/lang/Long;", "bindSimpleRow", "", "view", "Landroid/view/View;", "leakTrace", "Lleakcanary/internal/activity/db/LeakTable$LeakTraceProjection;", "createView", "container", "Landroid/view/ViewGroup;", "leakToString", "Lshark/LeakTrace;", "analysis", "Lshark/HeapAnalysisSuccess;", "parseLinks", "str", "onLeakTraceSelected", "heapAnalysisId", "leakTraceIndex", "", "onLeaksRetrieved", "leak", "Lleakcanary/internal/activity/db/LeakTable$LeakProjection;", "selectedLeakTraceIndex", "selectedHeapAnalysis", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakScreen extends Screen {
    private final String leakSignature;
    private final Long selectedHeapAnalysisId;

    public LeakScreen(String leakSignature, Long selectedHeapAnalysisId) {
        Intrinsics.checkParameterIsNotNull(leakSignature, "leakSignature");
        this.leakSignature = leakSignature;
        this.selectedHeapAnalysisId = selectedHeapAnalysisId;
    }

    public /* synthetic */ LeakScreen(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l);
    }

    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_leak_screen);
        ViewsKt.getActivity($this$apply).setTitle($this$apply.getResources().getString(R.string.leak_canary_loading_title));
        DbKt.executeOnDb($this$apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$createView$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Db.OnDb onDb) {
                invoke2(onDb);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:47:0x0112 A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #3 {all -> 0x011a, blocks: (B:45:0x010d, B:47:0x0112, B:40:0x00ee, B:42:0x00f8), top: B:77:0x00ee }] */
            /* JADX WARN: Removed duplicated region for block: B:54:0x012a  */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Db.OnDb receiver) {
                String str;
                Long l;
                int index$iv;
                Long l2;
                String str2;
                HeapAnalysisSuccess heapAnalysisSuccess;
                HeapAnalysis analysis$iv;
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                LeakTable leakTable = LeakTable.INSTANCE;
                SQLiteDatabase db = receiver.getDb();
                str = LeakScreen.this.leakSignature;
                final LeakTable.LeakProjection leak = leakTable.retrieveLeakBySignature(db, str);
                if (leak != null) {
                    l = LeakScreen.this.selectedHeapAnalysisId;
                    if (l != null) {
                        List $this$indexOfFirst$iv = leak.getLeakTraces();
                        index$iv = 0;
                        Iterator<LeakTable.LeakTraceProjection> it = $this$indexOfFirst$iv.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Object item$iv = it.next();
                                LeakTable.LeakTraceProjection it2 = (LeakTable.LeakTraceProjection) item$iv;
                                long heapAnalysisId = it2.getHeapAnalysisId();
                                l2 = LeakScreen.this.selectedHeapAnalysisId;
                                if (l2 != null && heapAnalysisId == l2.longValue()) {
                                    break;
                                }
                                index$iv++;
                            } else {
                                index$iv = -1;
                                break;
                            }
                        }
                    } else {
                        index$iv = 0;
                    }
                    final int selectedLeakIndex = index$iv;
                    if (selectedLeakIndex != -1) {
                        long heapAnalysisId2 = leak.getLeakTraces().get(selectedLeakIndex).getHeapAnalysisId();
                        HeapAnalysisTable heapAnalysisTable = HeapAnalysisTable.INSTANCE;
                        SQLiteDatabase db$iv = receiver.getDb();
                        HeapAnalysis heapAnalysis = null;
                        Cursor $this$use$iv$iv = db$iv.rawQuery("\n              SELECT\n              object\n              FROM heap_analysis\n              WHERE id=" + heapAnalysisId2 + "\n              ", null);
                        Intrinsics.checkExpressionValueIsNotNull($this$use$iv$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
                        try {
                            if ($this$use$iv$iv.moveToNext()) {
                                Serializables serializables = Serializables.INSTANCE;
                                byte[] byteArray$iv$iv = $this$use$iv$iv.getBlob(0);
                                Intrinsics.checkExpressionValueIsNotNull(byteArray$iv$iv, "cursor.getBlob(0)");
                                ByteArrayInputStream inputStream$iv$iv = new ByteArrayInputStream(byteArray$iv$iv);
                                try {
                                    try {
                                        Object readObject = new ObjectInputStream(inputStream$iv$iv).readObject();
                                        if (!(readObject instanceof HeapAnalysisSuccess)) {
                                            readObject = null;
                                        }
                                        heapAnalysisSuccess = (HeapAnalysisSuccess) readObject;
                                    } catch (Throwable th) {
                                        ignored$iv$iv = th;
                                        try {
                                            SharkLog this_$iv$iv$iv = SharkLog.INSTANCE;
                                            SharkLog.Logger logger$iv$iv$iv = this_$iv$iv$iv.getLogger();
                                            if (logger$iv$iv$iv != null) {
                                                logger$iv$iv$iv.d(ignored$iv$iv, "Could not deserialize bytes, ignoring");
                                            }
                                            heapAnalysisSuccess = null;
                                            analysis$iv = (HeapAnalysis) heapAnalysisSuccess;
                                            if (analysis$iv == null) {
                                            }
                                            heapAnalysis = analysis$iv;
                                            $this$use$iv$iv.close();
                                            if (heapAnalysis == null) {
                                            }
                                            final HeapAnalysisSuccess selectedHeapAnalysis = (HeapAnalysisSuccess) heapAnalysis;
                                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$createView$$inlined$apply$lambda$1.1
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
                                                    LeakScreen.this.onLeaksRetrieved(receiver2, leak, selectedLeakIndex, selectedHeapAnalysis);
                                                }
                                            });
                                            LeakTable leakTable2 = LeakTable.INSTANCE;
                                            SQLiteDatabase db2 = receiver.getDb();
                                            str2 = LeakScreen.this.leakSignature;
                                            leakTable2.markAsRead(db2, str2);
                                            return;
                                        } catch (Throwable th2) {
                                            e$iv$iv = th2;
                                            try {
                                                throw e$iv$iv;
                                            } catch (Throwable e$iv$iv) {
                                                try {
                                                    $this$use$iv$iv.close();
                                                } catch (Throwable th3) {
                                                }
                                                throw e$iv$iv;
                                            }
                                        }
                                    }
                                } catch (Throwable th4) {
                                    ignored$iv$iv = th4;
                                }
                                analysis$iv = (HeapAnalysis) heapAnalysisSuccess;
                                if (analysis$iv == null) {
                                    HeapAnalysisTable.INSTANCE.delete(db$iv, heapAnalysisId2, null);
                                }
                                heapAnalysis = analysis$iv;
                            }
                            $this$use$iv$iv.close();
                            if (heapAnalysis == null) {
                                Intrinsics.throwNpe();
                            }
                            final HeapAnalysisSuccess selectedHeapAnalysis2 = (HeapAnalysisSuccess) heapAnalysis;
                            receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$createView$$inlined$apply$lambda$1.1
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
                                    LeakScreen.this.onLeaksRetrieved(receiver2, leak, selectedLeakIndex, selectedHeapAnalysis2);
                                }
                            });
                        } catch (Throwable th5) {
                            e$iv$iv = th5;
                        }
                    } else {
                        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$createView$1$1$3
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                                invoke2(view);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(View receiver2) {
                                Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                                ViewsKt.getActivity(receiver2).setTitle("Selected heap analysis deleted");
                            }
                        });
                    }
                    LeakTable leakTable22 = LeakTable.INSTANCE;
                    SQLiteDatabase db22 = receiver.getDb();
                    str2 = LeakScreen.this.leakSignature;
                    leakTable22.markAsRead(db22, str2);
                    return;
                }
                receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$createView$1$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(View receiver2) {
                        Intrinsics.checkParameterIsNotNull(receiver2, "$receiver");
                        ViewsKt.getActivity(receiver2).setTitle(receiver2.getResources().getString(R.string.leak_canary_leak_not_found));
                    }
                });
            }
        });
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void onLeaksRetrieved(View $this$onLeaksRetrieved, final LeakTable.LeakProjection leak, int selectedLeakTraceIndex, HeapAnalysisSuccess selectedHeapAnalysis) {
        boolean isLibraryLeak = leak.isLibraryLeak();
        boolean isNew = leak.isNew();
        TextView newChipView = (TextView) $this$onLeaksRetrieved.findViewById(R.id.leak_canary_chip_new);
        TextView libraryLeakChipView = (TextView) $this$onLeaksRetrieved.findViewById(R.id.leak_canary_chip_library_leak);
        Intrinsics.checkExpressionValueIsNotNull(newChipView, "newChipView");
        newChipView.setVisibility(isNew ? 0 : 8);
        Intrinsics.checkExpressionValueIsNotNull(libraryLeakChipView, "libraryLeakChipView");
        libraryLeakChipView.setVisibility(isLibraryLeak ? 0 : 8);
        Activity activity = ViewsKt.getActivity($this$onLeaksRetrieved);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format($this$onLeaksRetrieved.getResources().getQuantityText(R.plurals.leak_canary_group_screen_title, leak.getLeakTraces().size()).toString(), Arrays.copyOf(new Object[]{Integer.valueOf(leak.getLeakTraces().size()), leak.getShortDescription()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        activity.setTitle(format);
        View singleLeakTraceRow = $this$onLeaksRetrieved.findViewById(R.id.leak_canary_single_leak_trace_row);
        Spinner spinner = (Spinner) $this$onLeaksRetrieved.findViewById(R.id.leak_canary_spinner);
        if (leak.getLeakTraces().size() == 1) {
            Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
            spinner.setVisibility(8);
            LeakTable.LeakTraceProjection leakTrace = (LeakTable.LeakTraceProjection) CollectionsKt.first((List<? extends Object>) leak.getLeakTraces());
            Intrinsics.checkExpressionValueIsNotNull(singleLeakTraceRow, "singleLeakTraceRow");
            bindSimpleRow(singleLeakTraceRow, leakTrace);
            onLeakTraceSelected($this$onLeaksRetrieved, selectedHeapAnalysis, leakTrace.getHeapAnalysisId(), leakTrace.getLeakTraceIndex());
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(singleLeakTraceRow, "singleLeakTraceRow");
        singleLeakTraceRow.setVisibility(8);
        Intrinsics.checkExpressionValueIsNotNull(spinner, "spinner");
        spinner.setAdapter((SpinnerAdapter) new SimpleListAdapter(R.layout.leak_canary_simple_row, leak.getLeakTraces(), new Function3<SimpleListAdapter<LeakTable.LeakTraceProjection>, View, Integer, Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeaksRetrieved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SimpleListAdapter<LeakTable.LeakTraceProjection> simpleListAdapter, View view, Integer num) {
                invoke(simpleListAdapter, view, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SimpleListAdapter<LeakTable.LeakTraceProjection> receiver, View view, int position) {
                Intrinsics.checkParameterIsNotNull(receiver, "$receiver");
                Intrinsics.checkParameterIsNotNull(view, "view");
                LeakScreen.this.bindSimpleRow(view, leak.getLeakTraces().get(position));
            }
        }));
        Ref.IntRef lastSelectedLeakTraceIndex = new Ref.IntRef();
        lastSelectedLeakTraceIndex.element = selectedLeakTraceIndex;
        Ref.ObjectRef lastSelectedHeapAnalysis = new Ref.ObjectRef();
        lastSelectedHeapAnalysis.element = selectedHeapAnalysis;
        spinner.setOnItemSelectedListener(new LeakScreen$onLeaksRetrieved$2(this, $this$onLeaksRetrieved, leak, lastSelectedLeakTraceIndex, lastSelectedHeapAnalysis));
        spinner.setSelection(selectedLeakTraceIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindSimpleRow(View view, LeakTable.LeakTraceProjection leakTrace) {
        TextView titleView = (TextView) view.findViewById(R.id.leak_canary_row_text);
        TextView timeView = (TextView) view.findViewById(R.id.leak_canary_row_small_text);
        Intrinsics.checkExpressionValueIsNotNull(titleView, "titleView");
        titleView.setText(view.getResources().getString(R.string.leak_canary_class_has_leaked, leakTrace.getClassSimpleName()));
        Intrinsics.checkExpressionValueIsNotNull(timeView, "timeView");
        TimeFormatter timeFormatter = TimeFormatter.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "view.context");
        timeView.setText(timeFormatter.formatTimestamp(context, leakTrace.getCreatedAtTimeMillis()));
    }

    private final String parseLinks(String str) {
        String str2;
        List<String> words = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        String parsedString = "";
        for (String word : words) {
            StringBuilder append = new StringBuilder().append(parsedString);
            if (Patterns.WEB_URL.matcher(word).matches()) {
                str2 = "<a href=\"" + word + "\">" + word + "</a>";
            } else {
                str2 = word;
            }
            parsedString = append.append(str2).toString();
            if (words.indexOf(word) != words.size() - 1) {
                parsedString = parsedString + " ";
            }
        }
        return parsedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLeakTraceSelected(final View $this$onLeakTraceSelected, final HeapAnalysisSuccess analysis, final long heapAnalysisId, int leakTraceIndex) {
        LeakScreen leakScreen = this;
        Sequence $this$first$iv = analysis.getAllLeaks();
        for (Object element$iv : $this$first$iv) {
            Leak it = (Leak) element$iv;
            if (Intrinsics.areEqual(it.getSignature(), leakScreen.leakSignature)) {
                LibraryLeak libraryLeak = (Leak) element$iv;
                final LeakTrace leakTrace = (LeakTrace) libraryLeak.getLeakTraces().get(leakTraceIndex);
                ListView listView = (ListView) $this$onLeakTraceSelected.findViewById(R.id.leak_canary_list);
                Intrinsics.checkExpressionValueIsNotNull(listView, "listView");
                listView.setAlpha(0.0f);
                listView.animate().alpha(1.0f);
                String titleText = "Open <a href=\"open_analysis\">Heap Dump</a><br><br>\nShare leak trace <a href=\"share\">as text</a> or on <a href=\"share_stack_overflow\">Stack Overflow</a><br><br>\nPrint leak trace <a href=\"print\">to Logcat</a> (tag: LeakCanary)<br><br>\nShare <a href=\"share_hprof\">Heap Dump file</a><br><br>\nReferences <b><u>underlined</u></b> are the likely causes of the leak.\nLearn more at <a href=\"https://squ.re/leaks\">https://squ.re/leaks</a>" + (libraryLeak instanceof LibraryLeak ? "<br><br>A <font color='#FFCC32'>Library Leak</font> is a leak caused by a known bug in 3rd party code that you do not have control over. (<a href=\"https://square.github.io/leakcanary/fundamentals-how-leakcanary-works/#4-categorizing-leaks\">Learn More</a>)<br><br><b>Leak pattern</b>: " + libraryLeak.getPattern() + "<br><br><b>Description</b>: " + leakScreen.parseLinks(libraryLeak.getDescription()) : "");
                Spanned fromHtml = Html.fromHtml(titleText);
                if (fromHtml == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
                }
                SpannableStringBuilder title = (SpannableStringBuilder) fromHtml;
                SquigglySpan.Companion companion = SquigglySpan.Companion;
                Context context = $this$onLeakTraceSelected.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                companion.replaceUnderlineSpans(title, context);
                UiUtils.INSTANCE.replaceUrlSpanWithAction$leakcanary_android_core_release(title, new Function1<String, Function0<? extends Unit>>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Function0<Unit> invoke(String urlSpan) {
                        Intrinsics.checkParameterIsNotNull(urlSpan, "urlSpan");
                        switch (urlSpan.hashCode()) {
                            case -1590034375:
                                if (urlSpan.equals("share_stack_overflow")) {
                                    return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1.2
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
                                            String leakToString;
                                            View view = $this$onLeakTraceSelected;
                                            LeakTraceWrapper leakTraceWrapper = LeakTraceWrapper.INSTANCE;
                                            leakToString = LeakScreen.this.leakToString(leakTrace, analysis);
                                            LeakViewsKt.shareToStackOverflow(view, leakTraceWrapper.wrap(leakToString, 80));
                                        }
                                    };
                                }
                                break;
                            case 106934957:
                                if (urlSpan.equals("print")) {
                                    return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1.3
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
                                            String leakToString;
                                            SharkLog this_$iv = SharkLog.INSTANCE;
                                            SharkLog.Logger logger$iv = this_$iv.getLogger();
                                            if (logger$iv != null) {
                                                StringBuilder append = new StringBuilder().append("\u200b\n");
                                                LeakTraceWrapper leakTraceWrapper = LeakTraceWrapper.INSTANCE;
                                                leakToString = LeakScreen.this.leakToString(leakTrace, analysis);
                                                logger$iv.d(append.append(leakTraceWrapper.wrap(leakToString, H265Utils.kLevel4)).toString());
                                            }
                                        }
                                    };
                                }
                                break;
                            case 109400031:
                                if (urlSpan.equals("share")) {
                                    return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1.1
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
                                            String leakToString;
                                            View view = $this$onLeakTraceSelected;
                                            LeakTraceWrapper leakTraceWrapper = LeakTraceWrapper.INSTANCE;
                                            leakToString = LeakScreen.this.leakToString(leakTrace, analysis);
                                            LeakViewsKt.share(view, leakTraceWrapper.wrap(leakToString, 80));
                                        }
                                    };
                                }
                                break;
                            case 396771169:
                                if (urlSpan.equals("share_hprof")) {
                                    return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1.5
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
                                            LeakViewsKt.shareHeapDump($this$onLeakTraceSelected, analysis.getHeapDumpFile());
                                        }
                                    };
                                }
                                break;
                            case 1185329457:
                                if (urlSpan.equals("open_analysis")) {
                                    return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.LeakScreen$onLeakTraceSelected$1.4
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
                                            ViewsKt.goTo($this$onLeakTraceSelected, new HeapDumpScreen(heapAnalysisId));
                                        }
                                    };
                                }
                                break;
                        }
                        return null;
                    }
                });
                Context context2 = $this$onLeakTraceSelected.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                DisplayLeakAdapter adapter = new DisplayLeakAdapter(context2, leakTrace, title);
                listView.setAdapter((ListAdapter) adapter);
                return;
            }
            leakScreen = this;
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String leakToString(LeakTrace leakTrace, HeapAnalysisSuccess analysis) {
        String str;
        StringBuilder append = new StringBuilder().append(leakTrace).append("\n\nMETADATA\n\n");
        if (!analysis.getMetadata().isEmpty()) {
            Map $this$map$iv = analysis.getMetadata();
            Collection destination$iv$iv = new ArrayList($this$map$iv.size());
            for (Map.Entry item$iv$iv : $this$map$iv.entrySet()) {
                destination$iv$iv.add(((String) item$iv$iv.getKey()) + ": " + ((String) item$iv$iv.getValue()));
            }
            str = CollectionsKt.joinToString$default((List) destination$iv$iv, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, null, 62, null);
        } else {
            str = "";
        }
        return append.append(str).append("\nAnalysis duration: ").append(analysis.getAnalysisDurationMillis()).append(" ms").toString();
    }
}