package tv.danmaku.bili.downloadeshare.panel;

import android.app.AlertDialog;
import android.content.Context;
import com.bilibili.lib.downloadshare.api.DownloadShareInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.downloadeshare.DownloadShareParameter;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: DownloadVideoPanel.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel;", "Landroid/app/AlertDialog;", "context", "Landroid/content/Context;", "themeResId", "", "<init>", "(Landroid/content/Context;I)V", ReportEvent.EVENT_TYPE_SHOW, "", "downloadInfo", "Lcom/bilibili/lib/downloadshare/api/DownloadShareInfo;", "param", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "listener", "Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel$DownloadStateChangeListener;", "setProgress", "progress", "DownloadStateChangeListener", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class DownloadVideoPanel extends AlertDialog {

    /* compiled from: DownloadVideoPanel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/downloadeshare/panel/DownloadVideoPanel$DownloadStateChangeListener;", "", "onSilentDownload", "", "onDownloadCanceled", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface DownloadStateChangeListener {
        void onDownloadCanceled();

        void onSilentDownload();
    }

    public abstract void setProgress(int i);

    public abstract void show(DownloadShareInfo downloadShareInfo, DownloadShareParameter downloadShareParameter, DownloadStateChangeListener downloadStateChangeListener);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadVideoPanel(Context context, int themeResId) {
        super(context, themeResId);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}