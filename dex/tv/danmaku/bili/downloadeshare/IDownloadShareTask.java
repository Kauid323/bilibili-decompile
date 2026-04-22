package tv.danmaku.bili.downloadeshare;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadShareTaskManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0000H&J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u0000H&J\u001a\u0010\u000b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/downloadeshare/IDownloadShareTask;", "", "attach", "nextTask", "toNext", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "getNext", "start", "isActive", "", SplashCustomReporterKt.STATE_CANCEL, "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface IDownloadShareTask {
    IDownloadShareTask attach(IDownloadShareTask iDownloadShareTask);

    void cancel();

    IDownloadShareTask getNext();

    boolean isActive();

    void start(FragmentActivity fragmentActivity, DownloadShareContext downloadShareContext);

    void toNext(FragmentActivity fragmentActivity, DownloadShareContext downloadShareContext);
}