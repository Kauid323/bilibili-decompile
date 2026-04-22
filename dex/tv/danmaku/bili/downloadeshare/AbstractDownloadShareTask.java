package tv.danmaku.bili.downloadeshare;

import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.reporter.tech.SplashCustomReporterKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadShareTaskManager.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/downloadeshare/AbstractDownloadShareTask;", "Ltv/danmaku/bili/downloadeshare/IDownloadShareTask;", "<init>", "()V", "mNextTask", "mIsActive", "", "attach", "nextTask", "getNext", "start", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "context", "Ltv/danmaku/bili/downloadeshare/DownloadShareContext;", "toNext", "isActive", SplashCustomReporterKt.STATE_CANCEL, "run", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public abstract class AbstractDownloadShareTask implements IDownloadShareTask {
    private boolean mIsActive;
    private IDownloadShareTask mNextTask;

    public abstract void run(FragmentActivity fragmentActivity, DownloadShareContext downloadShareContext);

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public IDownloadShareTask attach(IDownloadShareTask nextTask) {
        this.mNextTask = nextTask;
        return this.mNextTask;
    }

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public IDownloadShareTask getNext() {
        return this.mNextTask;
    }

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void start(FragmentActivity activity, DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsActive = true;
        run(activity, context);
        this.mIsActive = false;
    }

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void toNext(FragmentActivity activity, DownloadShareContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IDownloadShareTask iDownloadShareTask = this.mNextTask;
        if (iDownloadShareTask != null) {
            iDownloadShareTask.start(activity, context);
        }
    }

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public boolean isActive() {
        return this.mIsActive;
    }

    @Override // tv.danmaku.bili.downloadeshare.IDownloadShareTask
    public void cancel() {
        this.mIsActive = false;
        this.mNextTask = null;
    }
}