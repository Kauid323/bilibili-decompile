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

/* compiled from: OfflineSearchActivity.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"tv/danmaku/bili/ui/offline/OfflineSearchActivity$mBottomAction$1", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "checkAll", "", "check", "", "delete", "updateDanmaku", "internalUpdate", "netType", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSearchActivity$mBottomAction$1 extends BottomView.BottomActionCallback {
    final /* synthetic */ OfflineSearchActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSearchActivity$mBottomAction$1(OfflineSearchActivity $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void checkAll(boolean check) {
        OfflineSearchAdapter offlineSearchAdapter;
        offlineSearchAdapter = this.this$0.mAdapter;
        if (offlineSearchAdapter != null) {
            offlineSearchAdapter.checkAll(check);
        }
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void delete() {
        AlertDialog.Builder negativeButton = new AlertDialog.Builder((Context) this.this$0, R.style.AppTheme_Dialog_Alert).setMessage(bili.resource.homepage.R.string.homepage_global_string_129).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null);
        int i = bili.resource.common.R.string.common_global_string_113;
        final OfflineSearchActivity offlineSearchActivity = this.this$0;
        negativeButton.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$mBottomAction$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                OfflineSearchActivity$mBottomAction$1.delete$lambda$0(OfflineSearchActivity.this, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$0(OfflineSearchActivity this$0, DialogInterface dialog, int which) {
        OfflineSearchAdapter offlineSearchAdapter;
        Collection collections;
        HybirdOfflineManager hybirdOfflineManager;
        OfflineSearchAdapter offlineSearchAdapter2;
        offlineSearchAdapter = this$0.mAdapter;
        if (offlineSearchAdapter == null || (collections = offlineSearchAdapter.getCheckedInfo()) == null) {
            return;
        }
        LogHelper.i("OfflineSearchActivity", "user call delete video from offline search activity > " + OfflineUtil.INSTANCE.getOfflineInfoString(collections));
        hybirdOfflineManager = this$0.mOfflineManager;
        if (hybirdOfflineManager != null) {
            hybirdOfflineManager.delete(collections);
        }
        offlineSearchAdapter2 = this$0.mAdapter;
        if (offlineSearchAdapter2 != null) {
            offlineSearchAdapter2.removeChecked(false);
        }
        this$0.toggleEditMode();
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void updateDanmaku() {
        if (!VideoDownloadNetworkHelper.showNetWorkWarningDanmakuDialogIfNeed((Context) this.this$0, this.this$0.getSupportFragmentManager(), new VideoDownloadWarningDialog.ContinueListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$mBottomAction$1$updateDanmaku$1
            public void onConfirm(int networkType) {
                OfflineSearchActivity$mBottomAction$1.this.internalUpdate(networkType);
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
        HybirdOfflineManager hybirdOfflineManager;
        OfflineSearchAdapter offlineSearchAdapter;
        hybirdOfflineManager = this.this$0.mOfflineManager;
        if (hybirdOfflineManager != null) {
            offlineSearchAdapter = this.this$0.mAdapter;
            Collection<OfflineInfo> checkedInfo = offlineSearchAdapter != null ? offlineSearchAdapter.getCheckedInfo() : null;
            final OfflineSearchActivity offlineSearchActivity = this.this$0;
            hybirdOfflineManager.updateDanmaku(checkedInfo, true, netType, new VideoOfflineManager.DanmakuUpdateListener() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$mBottomAction$1$internalUpdate$1
                @Override // tv.danmaku.bili.ui.offline.VideoOfflineManager.DanmakuUpdateListener
                public void onUpdateSuccess(int count) {
                    String msg = OfflineSearchActivity.this.getString(bili.resource.downloads.R.string.downloads_global_string_123, new Object[]{String.valueOf(count)});
                    Intrinsics.checkNotNullExpressionValue(msg, "getString(...)");
                    ToastHelper.showToastShort((Context) OfflineSearchActivity.this, msg);
                }
            });
        }
        this.this$0.toggleEditMode();
    }
}