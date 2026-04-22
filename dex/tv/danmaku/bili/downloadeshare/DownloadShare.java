package tv.danmaku.bili.downloadeshare;

import android.app.Application;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import bili.resource.share.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.downloadshare.DownloadHelper;
import com.bilibili.lib.sharewrapper.Bshare.PVActionManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: DownloadShare.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShare;", "", "<init>", "()V", "manager", "Ltv/danmaku/bili/downloadeshare/DownloadShareTaskManager;", "startDownloadShare", "", AudioIntentHelper.FROM_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "parameter", "Ltv/danmaku/bili/downloadeshare/DownloadShareParameter;", "panelType", "", "stopDownloadShare", "tryHidePanel", "isActive", "", "Companion", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShare {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "Download_Share_DownloadShare";
    private DownloadShareTaskManager manager;

    public /* synthetic */ DownloadShare(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void startDownloadShare(FragmentActivity fragmentActivity, DownloadShareParameter downloadShareParameter) {
        Intrinsics.checkNotNullParameter(downloadShareParameter, "parameter");
        startDownloadShare$default(this, fragmentActivity, downloadShareParameter, 0, 4, null);
    }

    private DownloadShare() {
    }

    /* compiled from: DownloadShare.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/downloadeshare/DownloadShare$Companion;", "", "<init>", "()V", "TAG", "", "with", "Ltv/danmaku/bili/downloadeshare/DownloadShare;", "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DownloadShare with() {
            return new DownloadShare(null);
        }
    }

    @JvmStatic
    public static final DownloadShare with() {
        return Companion.with();
    }

    public static /* synthetic */ void startDownloadShare$default(DownloadShare downloadShare, FragmentActivity fragmentActivity, DownloadShareParameter downloadShareParameter, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        downloadShare.startDownloadShare(fragmentActivity, downloadShareParameter, i);
    }

    public final void startDownloadShare(FragmentActivity activity, DownloadShareParameter parameter, int panelType) {
        DownloadShareTaskManager downloadShareTaskManager;
        Intrinsics.checkNotNullParameter(parameter, "parameter");
        if (DownloadHelper.INSTANCE.isDownloadTaskRunning()) {
            Application application = BiliContext.application();
            String msg = application != null ? application.getString(R.string.share_global_string_24) : null;
            ToastHelper.showToast((Context) activity, msg, 0, 17);
            BLog.i(TAG, ": Wait for the last video to be finished.");
            return;
        }
        if (parameter.getAvid() > 0 && parameter.getCid() > 0) {
            String spmid = parameter.getSpmid();
            if (!(spmid == null || StringsKt.isBlank(spmid))) {
                if (isActive() && (downloadShareTaskManager = this.manager) != null) {
                    downloadShareTaskManager.stopDownloadShare();
                }
                if (this.manager == null) {
                    this.manager = new DownloadShareTaskManager();
                }
                PVActionManager.INSTANCE.createActionId();
                DownloadShareTaskManager downloadShareTaskManager2 = this.manager;
                if (downloadShareTaskManager2 != null) {
                    downloadShareTaskManager2.startDownloadShare(activity, parameter, panelType);
                    return;
                }
                return;
            }
        }
        Application application2 = BiliContext.application();
        String msg2 = application2 != null ? application2.getString(R.string.share_global_string_50) : null;
        ToastHelper.showToast((Context) activity, msg2, 0, 17);
        BLog.i(TAG, ": Avid, Cid or Spmid, At least one of them is illegal");
    }

    public final void stopDownloadShare() {
        BLog.i(TAG, ": Stop Download-Share");
        DownloadShareTaskManager downloadShareTaskManager = this.manager;
        if (downloadShareTaskManager != null) {
            downloadShareTaskManager.stopDownloadShare();
        }
        this.manager = null;
    }

    public final void tryHidePanel() {
        BLog.i(TAG, ": Try hide panel");
        DownloadShareTaskManager downloadShareTaskManager = this.manager;
        if (downloadShareTaskManager != null) {
            downloadShareTaskManager.tryHidePanel();
        }
    }

    public final boolean isActive() {
        DownloadShareTaskManager downloadShareTaskManager = this.manager;
        return downloadShareTaskManager != null && downloadShareTaskManager.isActive();
    }
}