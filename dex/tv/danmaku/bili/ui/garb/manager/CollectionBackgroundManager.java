package tv.danmaku.bili.ui.garb.manager;

import android.app.Application;
import android.content.Context;
import com.bilibili.base.BiliContext;
import com.bilibili.bililive.uam.view.UAMView;
import com.bilibili.commons.security.DigestUtils;
import com.bilibili.lib.okdownloader.BiliDownloader;
import com.bilibili.lib.okdownloader.DownloadListener;
import com.bilibili.lib.okdownloader.Task;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: CollectionBackgroundManager.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ \u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/CollectionBackgroundManager;", "", "<init>", "()V", "loadBg", "", "context", "Landroid/content/Context;", "uamView", "Lcom/bilibili/bililive/uam/view/UAMView;", "url", "", "downloadAndPlayBg", "onResume", "onPause", "onDestroy", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CollectionBackgroundManager {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String ONLINE_BACKGROUND_URL = "https://i0.hdslb.com/bfs/baselabs/997816703ef73c49530bd52bde984dcacadd5c13.mp4";

    /* compiled from: CollectionBackgroundManager.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/manager/CollectionBackgroundManager$Companion;", "", "<init>", "()V", "ONLINE_BACKGROUND_URL", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final void loadBg(Context context, UAMView uamView, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uamView, "uamView");
        downloadAndPlayBg(context, uamView, url == null ? ONLINE_BACKGROUND_URL : url);
    }

    private final void downloadAndPlayBg(Context context, final UAMView uamView, String url) {
        File filesDir;
        Application application = BiliContext.application();
        String finalDir = ((application == null || (filesDir = application.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + "/earn/animation";
        String suffix = (String) CollectionsKt.last(StringsKt.split$default(url, new String[]{FileUtils.HIDDEN_PREFIX}, false, 0, 6, (Object) null));
        String fileName = DigestUtils.md5(url) + FileUtils.HIDDEN_PREFIX + suffix;
        Task task = BiliDownloader.Companion.get(context).create(url, "earn.mp4").into(finalDir).fileName(fileName).rejectedWhenFileExists().retryTime(3).networkOn(3).priority(10).addListener(new DownloadListener() { // from class: tv.danmaku.bili.ui.garb.manager.CollectionBackgroundManager$downloadAndPlayBg$task$1
            public /* synthetic */ void onCancel(String str) {
                DownloadListener.-CC.$default$onCancel(this, str);
            }

            public /* synthetic */ void onCheck(String str) {
                DownloadListener.-CC.$default$onCheck(this, str);
            }

            public /* synthetic */ void onLoading(String str, long j, long j2, long j3, int i) {
                DownloadListener.-CC.$default$onLoading(this, str, j, j2, j3, i);
            }

            public /* synthetic */ void onPause(String str, long j, long j2) {
                DownloadListener.-CC.$default$onPause(this, str, j, j2);
            }

            public /* synthetic */ void onWait(String str) {
                DownloadListener.-CC.$default$onWait(this, str);
            }

            public void onStart(String taskId) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onStart(this, taskId);
            }

            public void onError(String taskId, List<Integer> list, long totalSize, long loadedSize) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onError(this, taskId, list, totalSize, loadedSize);
            }

            public void onFinish(String taskId, String dir, String name) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onFinish(this, taskId, dir, name);
                File file = new File(dir, name);
                uamView.setVisibility(0);
                UAMView uAMView = uamView;
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                uAMView.startPlay(absolutePath);
            }

            public void onRetry(String taskId, int retryTimes) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                DownloadListener.-CC.$default$onRetry(this, taskId, retryTimes);
            }
        }).build();
        task.enqueue();
    }

    public final void onResume(UAMView uamView) {
        Intrinsics.checkNotNullParameter(uamView, "uamView");
        uamView.onResume();
    }

    public final void onPause(UAMView uamView) {
        Intrinsics.checkNotNullParameter(uamView, "uamView");
        uamView.onPause();
    }

    public final void onDestroy(UAMView uamView) {
        Intrinsics.checkNotNullParameter(uamView, "uamView");
        uamView.destroy();
    }
}