package leakcanary.internal.activity;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.view.View;
import android.widget.Toast;
import com.squareup.leakcanary.core.R;
import java.io.File;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import leakcanary.internal.LeakCanaryFileProvider;
import leakcanary.internal.navigation.ViewsKt;
import shark.HeapAnalysisFailure;

/* compiled from: LeakViews.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u0014\u0010\n\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"NEW_ISSUE_URL", "", "STACKOVERFLOW_QUESTION_URL", "share", "", "Landroid/view/View;", "content", "shareHeapDump", "heapDumpFile", "Ljava/io/File;", "shareToGitHubIssue", "failure", "Lshark/HeapAnalysisFailure;", "shareToStackOverflow", "startShareIntentChooser", "uri", "Landroid/net/Uri;", "leakcanary-android-core_release"}, k = 2, mv = {1, 4, 1})
public final class LeakViewsKt {
    private static final String NEW_ISSUE_URL = "https://github.com/square/leakcanary/issues/new?labels=type%3A+bug&template=2-bug.md";
    private static final String STACKOVERFLOW_QUESTION_URL = "http://stackoverflow.com/questions/ask?guided=false&tags=leakcanary";

    public static final void share(View share, String content) {
        Intrinsics.checkParameterIsNotNull(share, "$this$share");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", content);
        ViewsKt.getActivity(share).startActivity(Intent.createChooser(intent, share.getResources().getString(R.string.leak_canary_share_with)));
    }

    public static final void shareHeapDump(final View shareHeapDump, final File heapDumpFile) {
        Intrinsics.checkParameterIsNotNull(shareHeapDump, "$this$shareHeapDump");
        Intrinsics.checkParameterIsNotNull(heapDumpFile, "heapDumpFile");
        AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.LeakViewsKt$shareHeapDump$1
            @Override // java.lang.Runnable
            public final void run() {
                heapDumpFile.setReadable(true, false);
                final Uri heapDumpUri = LeakCanaryFileProvider.Companion.getUriForFile(ViewsKt.getActivity(shareHeapDump), "com.squareup.leakcanary.fileprovider." + ViewsKt.getActivity(shareHeapDump).getPackageName(), heapDumpFile);
                ViewsKt.getActivity(shareHeapDump).runOnUiThread(new Runnable() { // from class: leakcanary.internal.activity.LeakViewsKt$shareHeapDump$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        LeakViewsKt.startShareIntentChooser(shareHeapDump, heapDumpUri);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShareIntentChooser(View $this$startShareIntentChooser, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/octet-stream");
        intent.putExtra("android.intent.extra.STREAM", uri);
        ViewsKt.getActivity($this$startShareIntentChooser).startActivity(Intent.createChooser(intent, $this$startShareIntentChooser.getResources().getString(R.string.leak_canary_share_with)));
    }

    public static final void shareToStackOverflow(final View shareToStackOverflow, final String content) {
        Intrinsics.checkParameterIsNotNull(shareToStackOverflow, "$this$shareToStackOverflow");
        Intrinsics.checkParameterIsNotNull(content, "content");
        Object systemService = shareToStackOverflow.getContext().getSystemService("clipboard");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        final ClipboardManager clipboard = (ClipboardManager) systemService;
        AsyncTask.execute(new Runnable() { // from class: leakcanary.internal.activity.LeakViewsKt$shareToStackOverflow$1
            @Override // java.lang.Runnable
            public final void run() {
                clipboard.setPrimaryClip(ClipData.newPlainText(shareToStackOverflow.getContext().getString(R.string.leak_canary_leak_clipdata_label), "```\n" + content + "```"));
            }
        });
        Toast.makeText(shareToStackOverflow.getContext(), R.string.leak_canary_leak_copied, 1).show();
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(STACKOVERFLOW_QUESTION_URL));
        try {
            ViewsKt.getActivity(shareToStackOverflow).startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(shareToStackOverflow.getContext(), R.string.leak_canary_leak_missing_browser_error, 1).show();
        }
    }

    public static final void shareToGitHubIssue(final View shareToGitHubIssue, final HeapAnalysisFailure failure) {
        Intrinsics.checkParameterIsNotNull(shareToGitHubIssue, "$this$shareToGitHubIssue");
        Intrinsics.checkParameterIsNotNull(failure, "failure");
        Object systemService = shareToGitHubIssue.getContext().getSystemService("clipboard");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        final ClipboardManager clipboard = (ClipboardManager) systemService;
        AsyncTask.execute(new Runnable() { // from class: leakcanary.internal.activity.LeakViewsKt$shareToGitHubIssue$1
            @Override // java.lang.Runnable
            public final void run() {
                clipboard.setPrimaryClip(ClipData.newPlainText(shareToGitHubIssue.getContext().getString(R.string.leak_canary_failure_clipdata_label), StringsKt.trimMargin$default("```\n          |" + failure.getException() + "\n          |Build.VERSION.SDK_INT: " + Build.VERSION.SDK_INT + "\n          |Build.MANUFACTURER: " + Build.MANUFACTURER + "\n          |LeakCanary version: 2.13\n          |Analysis duration: " + failure.getAnalysisDurationMillis() + " ms\n          |Heap dump file path: " + failure.getHeapDumpFile().getAbsolutePath() + "\n          |Heap dump timestamp: " + failure.getCreatedAtTimeMillis() + "\n          |```\n        ", null, 1, null)));
            }
        });
        Toast.makeText(shareToGitHubIssue.getContext(), R.string.leak_canary_failure_copied, 1).show();
        Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse(NEW_ISSUE_URL));
        try {
            ViewsKt.getActivity(shareToGitHubIssue).startActivity(browserIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(shareToGitHubIssue.getContext(), R.string.leak_canary_leak_missing_browser_error, 1).show();
        }
    }
}