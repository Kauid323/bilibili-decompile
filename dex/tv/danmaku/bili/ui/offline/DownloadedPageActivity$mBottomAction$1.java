package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.bilibili.app.preferences.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.offline.OfflineInfo;
import com.bilibili.videodownloader.ui.VideoDownloadWarningDialog;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNetworkHelper;
import tv.danmaku.bili.ui.offline.BottomView;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DownloadedPageActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"tv/danmaku/bili/ui/offline/DownloadedPageActivity$mBottomAction$1", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "checkAll", "", "check", "", "delete", "updateDanmaku", "internalUpdate", "netType", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DownloadedPageActivity$mBottomAction$1 extends BottomView.BottomActionCallback {
    final /* synthetic */ DownloadedPageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DownloadedPageActivity$mBottomAction$1(DownloadedPageActivity $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void checkAll(boolean check) {
        DownloadedPageAdapter downloadedPageAdapter;
        downloadedPageAdapter = this.this$0.mAdapter;
        if (downloadedPageAdapter != null) {
            downloadedPageAdapter.checkAll(check);
        }
        OfflineReporter.reportDownloadedPageSelectAll();
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void delete() {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder((Context) this.this$0, R.style.AppTheme_Dialog_Alert).setMessage(bili.resource.homepage.R.string.homepage_global_string_129).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null);
        int i = bili.resource.common.R.string.common_global_string_113;
        final DownloadedPageActivity downloadedPageActivity = this.this$0;
        negativeButton.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$mBottomAction$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                DownloadedPageActivity$mBottomAction$1.delete$lambda$0(DownloadedPageActivity.this, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$0(DownloadedPageActivity this$0, DialogInterface dialogInterface, int i) {
        DownloadedPageAdapter downloadedPageAdapter;
        Collection collections;
        VideoOfflineManager videoOfflineManager;
        DownloadedPageAdapter downloadedPageAdapter2;
        downloadedPageAdapter = this$0.mAdapter;
        if (downloadedPageAdapter == null || (collections = downloadedPageAdapter.getCheckedInfo()) == null) {
            return;
        }
        LogHelper.i("offline-DownloadedPage", "user call delete video from downloaded page activity > " + OfflineUtil.INSTANCE.getOfflineInfoString(collections));
        LogHelper.i("offline-DownloadedPage", "user call delete video entries counts > " + collections.size());
        videoOfflineManager = this$0.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            videoOfflineManager.delete(collections);
        }
        downloadedPageAdapter2 = this$0.mAdapter;
        if (downloadedPageAdapter2 != null) {
            downloadedPageAdapter2.removeChecked(false);
        }
        this$0.toggleEditMode();
        OfflineReporter.reportDownloadedPageDelete();
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void updateDanmaku() {
        if (!VideoDownloadNetworkHelper.showNetWorkWarningDanmakuDialogIfNeed((Context) this.this$0, this.this$0.getSupportFragmentManager(), new VideoDownloadWarningDialog.ContinueListener() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$mBottomAction$1$updateDanmaku$1
            public void onConfirm(int networkType) {
                DownloadedPageActivity$mBottomAction$1.this.internalUpdate(networkType);
            }

            public void onNeutral(int networkType) {
            }
        })) {
            int netType = FreeDataMediaDownloadHelper.getNetworkType((Context) this.this$0);
            internalUpdate(netType);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalUpdate(int netType) {
        DownloadedPageAdapter apdater;
        VideoOfflineManager videoOfflineManager;
        apdater = this.this$0.mAdapter;
        if (apdater == null) {
            return;
        }
        videoOfflineManager = this.this$0.mVideoOfflineManager;
        if (videoOfflineManager != null) {
            Collection<OfflineInfo> checkedInfo = apdater.getCheckedInfo();
            Intrinsics.checkNotNullExpressionValue(checkedInfo, "getCheckedInfo(...)");
            final DownloadedPageActivity downloadedPageActivity = this.this$0;
            videoOfflineManager.updateDanmaku(checkedInfo, true, netType, new VideoOfflineManager.DanmakuUpdateListener() { // from class: tv.danmaku.bili.ui.offline.DownloadedPageActivity$mBottomAction$1$internalUpdate$1
                @Override // tv.danmaku.bili.ui.offline.VideoOfflineManager.DanmakuUpdateListener
                public void onUpdateSuccess(int count) {
                    String msg = DownloadedPageActivity.this.getString(bili.resource.downloads.R.string.downloads_global_string_123, new Object[]{String.valueOf(count)});
                    Intrinsics.checkNotNullExpressionValue(msg, "getString(...)");
                    ToastHelper.showToastShort((Context) DownloadedPageActivity.this, msg);
                }
            });
        }
        this.this$0.toggleEditMode();
        OfflineReporter.reportDownloadedPageUpdateDanmaku();
    }
}