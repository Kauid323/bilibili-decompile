package leakcanary;

import android.app.Activity;
import android.app.Application;
import com.squareup.leakcanary.core.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import leakcanary.EventListener;
import leakcanary.internal.HandlersKt;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.activity.LeakActivity;
import leakcanary.internal.tv.TvToast;
import shark.HeapAnalysis;
import shark.HeapAnalysisFailure;
import shark.HeapAnalysisSuccess;
import shark.SharkLog;

/* compiled from: TvEventListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lleakcanary/TvEventListener;", "Lleakcanary/EventListener;", "()V", "appContext", "Landroid/app/Application;", "onEvent", "", "event", "Lleakcanary/EventListener$Event;", "printIntentInfo", "showToast", "heapAnalysis", "Lshark/HeapAnalysis;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class TvEventListener implements EventListener {
    public static final TvEventListener INSTANCE = new TvEventListener();
    private static final Application appContext = InternalLeakCanary.INSTANCE.getApplication();

    private TvEventListener() {
    }

    @Override // leakcanary.EventListener
    public void onEvent(EventListener.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event instanceof EventListener.Event.HeapAnalysisDone) {
            showToast(((EventListener.Event.HeapAnalysisDone) event).getHeapAnalysis());
            printIntentInfo();
        }
    }

    private final void showToast(final HeapAnalysis heapAnalysis) {
        HandlersKt.getMainHandler().post(new Runnable() { // from class: leakcanary.TvEventListener$showToast$1
            @Override // java.lang.Runnable
            public final void run() {
                Application application;
                String message;
                Application application2;
                Activity resumedActivity = InternalLeakCanary.INSTANCE.getResumedActivity();
                if (resumedActivity == null) {
                    return;
                }
                HeapAnalysis heapAnalysis2 = heapAnalysis;
                if (heapAnalysis2 instanceof HeapAnalysisSuccess) {
                    TvEventListener tvEventListener = TvEventListener.INSTANCE;
                    application2 = TvEventListener.appContext;
                    message = application2.getString(R.string.leak_canary_tv_analysis_success, new Object[]{Integer.valueOf(heapAnalysis.getApplicationLeaks().size()), Integer.valueOf(heapAnalysis.getLibraryLeaks().size())});
                    Intrinsics.checkExpressionValueIsNotNull(message, "appContext.getString(\n  …aryLeaks.size\n          )");
                } else if (heapAnalysis2 instanceof HeapAnalysisFailure) {
                    TvEventListener tvEventListener2 = TvEventListener.INSTANCE;
                    application = TvEventListener.appContext;
                    message = application.getString(R.string.leak_canary_tv_analysis_failure);
                    Intrinsics.checkExpressionValueIsNotNull(message, "appContext.getString(R.s…nary_tv_analysis_failure)");
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                TvToast.INSTANCE.makeText(resumedActivity, message).show();
            }
        });
    }

    private final void printIntentInfo() {
        SharkLog this_$iv = SharkLog.INSTANCE;
        SharkLog.Logger logger$iv = this_$iv.getLogger();
        if (logger$iv != null) {
            StringBuilder append = new StringBuilder().append("\n      ====================================\n      ANDROID TV LAUNCH INTENT\n      ====================================\n      Run the following adb command to display the list of leaks:\n\n      adb shell am start -n \"").append(appContext.getPackageName()).append('/');
            Package r6 = LeakActivity.class.getPackage();
            logger$iv.d(StringsKt.trimIndent(append.append(r6 != null ? r6.getName() : null).append(".LeakLauncherActivity\"\n      ====================================").toString()));
        }
    }
}