package leakcanary.internal.activity.screen;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import leakcanary.EventListener;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.Serializables;
import leakcanary.internal.activity.LeakViewsKt;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.db.DbKt;
import leakcanary.internal.activity.db.HeapAnalysisTable;
import leakcanary.internal.activity.ui.UiUtils;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;

/* compiled from: HeapAnalysisFailureScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lleakcanary/internal/activity/screen/HeapAnalysisFailureScreen;", "Lleakcanary/internal/navigation/Screen;", "analysisId", "", "(J)V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "onFailureRetrieved", "", "heapAnalysis", "Lshark/HeapAnalysisFailure;", "heapDumpFileExist", "", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class HeapAnalysisFailureScreen extends Screen {
    private final long analysisId;

    public HeapAnalysisFailureScreen(long analysisId) {
        this.analysisId = analysisId;
    }

    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_heap_analysis_failure_screen);
        ViewsKt.getActivity($this$apply).setTitle($this$apply.getResources().getString(R.string.leak_canary_loading_title));
        DbKt.executeOnDb($this$apply, new Function1<Db.OnDb, Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$createView$$inlined$apply$lambda$1
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
                id$iv = HeapAnalysisFailureScreen.this.analysisId;
                HeapAnalysis heapAnalysis = null;
                Cursor $this$use$iv$iv = db$iv.rawQuery("\n              SELECT\n              object\n              FROM heap_analysis\n              WHERE id=" + id$iv + "\n              ", null);
                Intrinsics.checkExpressionValueIsNotNull($this$use$iv$iv, "db.rawQuery(\n      \"\"\"\n …          \"\"\", null\n    )");
                try {
                    if ($this$use$iv$iv.moveToNext()) {
                        Serializables serializables = Serializables.INSTANCE;
                        byte[] byteArray$iv$iv = $this$use$iv$iv.getBlob(0);
                        Intrinsics.checkExpressionValueIsNotNull(byteArray$iv$iv, "cursor.getBlob(0)");
                        ByteArrayInputStream inputStream$iv$iv = new ByteArrayInputStream(byteArray$iv$iv);
                        try {
                            Object readObject = new ObjectInputStream(inputStream$iv$iv).readObject();
                            if (!(readObject instanceof HeapAnalysisFailure)) {
                                readObject = null;
                            }
                            HeapAnalysis analysis$iv = (HeapAnalysisFailure) readObject;
                            if (analysis$iv == null) {
                                HeapAnalysisTable.INSTANCE.delete(db$iv, id$iv, null);
                            }
                            heapAnalysis = analysis$iv;
                        }
                    }
                    $this$use$iv$iv.close();
                    final HeapAnalysisFailure heapAnalysis2 = (HeapAnalysisFailure) heapAnalysis;
                    if (heapAnalysis2 == null) {
                        receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$createView$1$1$1
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
                    final boolean heapDumpFileExist = heapAnalysis2.getHeapDumpFile().exists();
                    receiver.updateUi(new Function1<View, Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$createView$$inlined$apply$lambda$1.1
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
                            HeapAnalysisFailureScreen.this.onFailureRetrieved(receiver2, heapAnalysis2, heapDumpFileExist);
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
    public final void onFailureRetrieved(final View $this$onFailureRetrieved, final HeapAnalysisFailure heapAnalysis, boolean heapDumpFileExist) {
        String str;
        ViewsKt.getActivity($this$onFailureRetrieved).setTitle($this$onFailureRetrieved.getResources().getString(R.string.leak_canary_analysis_failed));
        StringBuilder sb = new StringBuilder();
        if (heapDumpFileExist) {
            str = "You can <a href=\"try_again\">run the analysis again</a>.<br><br>";
        } else {
            str = "";
        }
        String failureText = sb.append(str).append("\n      Please <a href=\"file_issue\">click here</a> to file a bug report.\n      The stacktrace details will be copied into the clipboard and you just need to paste into the\n      GitHub issue description.").append(heapDumpFileExist ? "\n        <br><br>To help reproduce the issue, please share the\n        <a href=\"share_hprof\">Heap Dump file</a> and upload it to the GitHub issue.\n      " : "").toString();
        Spanned fromHtml = Html.fromHtml(failureText);
        if (fromHtml == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
        }
        SpannableStringBuilder failure = (SpannableStringBuilder) fromHtml;
        UiUtils.INSTANCE.replaceUrlSpanWithAction$leakcanary_android_core_release(failure, new Function1<String, Function0<? extends Unit>>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$onFailureRetrieved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Function0<Unit> invoke(String urlSpan) {
                Intrinsics.checkParameterIsNotNull(urlSpan, "urlSpan");
                switch (urlSpan.hashCode()) {
                    case 396771169:
                        if (urlSpan.equals("share_hprof")) {
                            return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$onFailureRetrieved$1.2
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
                                    LeakViewsKt.shareHeapDump($this$onFailureRetrieved, heapAnalysis.getHeapDumpFile());
                                }
                            };
                        }
                        break;
                    case 431874012:
                        if (urlSpan.equals("try_again")) {
                            return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$onFailureRetrieved$1.3
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
                                    InternalLeakCanary internalLeakCanary = InternalLeakCanary.INSTANCE;
                                    String uuid = UUID.randomUUID().toString();
                                    Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
                                    internalLeakCanary.sendEvent(new EventListener.Event.HeapDump(uuid, heapAnalysis.getHeapDumpFile(), heapAnalysis.getDumpDurationMillis(), "Retrying heap analysis after failure."));
                                }
                            };
                        }
                        break;
                    case 2135094358:
                        if (urlSpan.equals("file_issue")) {
                            return new Function0<Unit>() { // from class: leakcanary.internal.activity.screen.HeapAnalysisFailureScreen$onFailureRetrieved$1.1
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
                                    LeakViewsKt.shareToGitHubIssue($this$onFailureRetrieved, heapAnalysis);
                                }
                            };
                        }
                        break;
                }
                return null;
            }
        });
        TextView $this$apply = (TextView) $this$onFailureRetrieved.findViewById(R.id.leak_canary_header_text);
        $this$apply.setMovementMethod(LinkMovementMethod.getInstance());
        $this$apply.setText(failure);
        View findViewById = $this$onFailureRetrieved.findViewById(R.id.leak_canary_stacktrace);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<TextView>(R…d.leak_canary_stacktrace)");
        ((TextView) findViewById).setText(heapAnalysis.getException().toString());
        ViewsKt.onCreateOptionsMenu($this$onFailureRetrieved, new HeapAnalysisFailureScreen$onFailureRetrieved$3(this, $this$onFailureRetrieved, heapAnalysis));
    }
}