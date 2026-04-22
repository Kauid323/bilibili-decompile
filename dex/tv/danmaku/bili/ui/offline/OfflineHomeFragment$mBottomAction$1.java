package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import bili.resource.homepage.R;
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
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.bili.ui.offline.VideoOfflineManager;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineHomeFragment.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"tv/danmaku/bili/ui/offline/OfflineHomeFragment$mBottomAction$1", "Ltv/danmaku/bili/ui/offline/BottomView$BottomActionCallback;", "checkAll", "", "check", "", "delete", "updateDanmaku", "internalUpdate", "netType", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineHomeFragment$mBottomAction$1 extends BottomView.BottomActionCallback {
    final /* synthetic */ OfflineHomeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineHomeFragment$mBottomAction$1(OfflineHomeFragment $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void checkAll(boolean check) {
        OfflineHomeAdapter mAdapter;
        mAdapter = this.this$0.getMAdapter();
        mAdapter.checkAll(check);
        OfflineReporter.reportHomeSelectAll();
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void delete() {
        OfflineHomeAdapter mAdapter;
        boolean containsMultiPage;
        int msgId;
        Context activity = this.this$0.getActivity();
        if (activity == null) {
            return;
        }
        mAdapter = this.this$0.getMAdapter();
        Collection checked = mAdapter.getCheckedInfo();
        containsMultiPage = this.this$0.containsMultiPage(checked);
        if (containsMultiPage) {
            msgId = R.string.homepage_global_string_246;
        } else {
            msgId = R.string.homepage_global_string_129;
        }
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(activity, com.bilibili.app.preferences.R.style.AppTheme_Dialog_Alert).setMessage(msgId).setNegativeButton(bili.resource.common.R.string.common_global_string_238, (DialogInterface.OnClickListener) null);
        int i = bili.resource.common.R.string.common_global_string_113;
        final OfflineHomeFragment offlineHomeFragment = this.this$0;
        negativeButton.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$mBottomAction$1$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                OfflineHomeFragment$mBottomAction$1.delete$lambda$0(OfflineHomeFragment.this, dialogInterface, i2);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void delete$lambda$0(OfflineHomeFragment this$0, DialogInterface dialogInterface, int i) {
        OfflineHomeAdapter mAdapter;
        HybirdOfflineManager mOfflineManager;
        OfflineHomeAdapter mAdapter2;
        ItemActionCallback.Downloaded downloaded;
        mAdapter = this$0.getMAdapter();
        Collection collections = mAdapter.getCheckedInfo();
        LogHelper.i("offline-home", "user call delete video from offline home fragment > " + OfflineUtil.INSTANCE.getOfflineInfoString(collections));
        LogHelper.i("offline-home", "user call delete video entries counts > " + collections.size());
        mOfflineManager = this$0.getMOfflineManager();
        mOfflineManager.delete(collections);
        mAdapter2 = this$0.getMAdapter();
        mAdapter2.deleteChecked();
        this$0.toggleEditMode();
        downloaded = this$0.mItemCallback;
        downloaded.onItemCountChange(-1);
        OfflineReporter.reportHomeDelete();
    }

    @Override // tv.danmaku.bili.ui.offline.BottomView.BottomActionCallback
    public void updateDanmaku() {
        Context activity = this.this$0.getActivity();
        if (activity != null && !VideoDownloadNetworkHelper.showNetWorkWarningDanmakuDialogIfNeed(activity, activity.getSupportFragmentManager(), new VideoDownloadWarningDialog.ContinueListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$mBottomAction$1$updateDanmaku$1
            public void onConfirm(int networkType) {
                OfflineHomeFragment$mBottomAction$1.this.internalUpdate(networkType);
            }

            public void onNeutral(int networkType) {
            }
        })) {
            internalUpdate(FreeDataMediaDownloadHelper.getNetworkType(activity));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalUpdate(int netType) {
        OfflineHomeAdapter mAdapter;
        HybirdOfflineManager mOfflineManager;
        mAdapter = this.this$0.getMAdapter();
        Collection<OfflineInfo> old = mAdapter.getCheckedInfo();
        int sum = 0;
        for (OfflineInfo offlineInfo : old) {
            sum += offlineInfo.danmaku;
        }
        final int oldCount = sum;
        mOfflineManager = this.this$0.getMOfflineManager();
        final OfflineHomeFragment offlineHomeFragment = this.this$0;
        mOfflineManager.updateDanmaku(old, false, netType, new VideoOfflineManager.DanmakuUpdateListener() { // from class: tv.danmaku.bili.ui.offline.OfflineHomeFragment$mBottomAction$1$internalUpdate$1
            @Override // tv.danmaku.bili.ui.offline.VideoOfflineManager.DanmakuUpdateListener
            public void onUpdateSuccess(int count) {
                if (oldCount != count) {
                    offlineHomeFragment.loadData();
                }
                String msg = offlineHomeFragment.getString(bili.resource.downloads.R.string.downloads_global_string_123, new Object[]{String.valueOf(count)});
                Intrinsics.checkNotNullExpressionValue(msg, "getString(...)");
                ToastHelper.showToastShort(offlineHomeFragment.getActivity(), msg);
            }
        });
        this.this$0.toggleEditMode();
        OfflineReporter.reportHomeUpdateDanmaku();
    }
}