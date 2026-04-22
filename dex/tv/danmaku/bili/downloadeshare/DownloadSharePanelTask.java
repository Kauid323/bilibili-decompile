package tv.danmaku.bili.downloadeshare;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.panel.DefaultDownloadSharePanel;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadSharePanelTask.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadSharePanelTask;", "Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "<init>", "()V", "downloadedSharePanel", "Ltv/danmaku/bili/downloadeshare/panel/DefaultDownloadSharePanel;", "run", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "isActive", "", SplashCustomReporterKt.STATE_CANCEL, "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadSharePanelTask extends AbstractDownloadShareTask {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "Download_Share_DownloadSharePanelTask";
    private DefaultDownloadSharePanel downloadedSharePanel;

    /* compiled from: DownloadSharePanelTask.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadSharePanelTask$Companion;", "", "<init>", "()V", "TAG", "", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask
    public void run(FragmentActivity activity, DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BLog.i(TAG, "Run.");
        if (activity == null) {
            return;
        }
        if (this.downloadedSharePanel == null) {
            this.downloadedSharePanel = new DefaultDownloadSharePanel((Context) activity, context);
        }
        DefaultDownloadSharePanel defaultDownloadSharePanel = this.downloadedSharePanel;
        if (defaultDownloadSharePanel != null) {
            defaultDownloadSharePanel.show();
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public boolean isActive() {
        if (super.isActive()) {
            return true;
        }
        DefaultDownloadSharePanel defaultDownloadSharePanel = this.downloadedSharePanel;
        return defaultDownloadSharePanel != null && defaultDownloadSharePanel.isShowing();
    }

    @Override // tv.danmaku.bili.downloadeshare.AbstractDownloadShareTask, tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void cancel() {
        DefaultDownloadSharePanel defaultDownloadSharePanel;
        BLog.i(TAG, "Cancel.");
        super.cancel();
        DefaultDownloadSharePanel defaultDownloadSharePanel2 = this.downloadedSharePanel;
        boolean z = false;
        if (defaultDownloadSharePanel2 != null && defaultDownloadSharePanel2.isShowing()) {
            z = true;
        }
        if (z && (defaultDownloadSharePanel = this.downloadedSharePanel) != null) {
            defaultDownloadSharePanel.dismiss();
        }
        this.downloadedSharePanel = null;
    }
}