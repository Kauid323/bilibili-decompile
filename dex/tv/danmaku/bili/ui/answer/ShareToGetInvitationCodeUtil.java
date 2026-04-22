package tv.danmaku.bili.ui.answer;

import android.app.Activity;
import android.os.Bundle;
import bili.resource.share.R;
import com.bilibili.app.comm.supermenu.core.IMenuPanel;
import com.bilibili.app.comm.supermenu.share.v2.ShareCallback;
import com.bilibili.app.comm.supermenu.share.v2.SharePanelShowCallback;
import com.bilibili.app.comm.supermenu.share.v2.SharePanelWrapper;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.sharewrapper.online.ShareOnlineParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: ShareToGetInvitationCodeUtil.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J.\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/answer/ShareToGetInvitationCodeUtil;", "", "<init>", "()V", "TAG", "", "SHARE_ID", "SPMID", "share", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "fromSpmid", "shareWithPanel", "menuPanel", "Lcom/bilibili/app/comm/supermenu/core/IMenuPanel;", "sharePanelShowCallback", "Lcom/bilibili/app/comm/supermenu/share/v2/SharePanelShowCallback;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ShareToGetInvitationCodeUtil {
    public static final int $stable = 0;
    public static final ShareToGetInvitationCodeUtil INSTANCE = new ShareToGetInvitationCodeUtil();
    private static final String SHARE_ID = "community.public-community.answer-in.all.click";
    private static final String SPMID = "community.public-community.answer-in.all";
    private static final String TAG = "ShareToGetInvitationCodeUtil";

    private ShareToGetInvitationCodeUtil() {
    }

    public final void share(Activity activity, String fromSpmid) {
        boolean portrait;
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        if (activity.isDestroyed() || activity.isFinishing()) {
            BLog.i(TAG, "activity is destroyed or finishing");
            return;
        }
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
            case 3:
                portrait = false;
                break;
            case 2:
            default:
                portrait = true;
                break;
        }
        BLog.i(TAG, "show share fromSpmid: " + fromSpmid + " portrait: " + portrait);
        if (portrait) {
            shareWithPanel$default(this, activity, fromSpmid, null, null, 8, null);
        } else {
            new AnswerLandscapeShareDialog(activity, fromSpmid).show();
        }
    }

    public static /* synthetic */ void shareWithPanel$default(ShareToGetInvitationCodeUtil shareToGetInvitationCodeUtil, Activity activity, String str, IMenuPanel iMenuPanel, SharePanelShowCallback sharePanelShowCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            iMenuPanel = null;
        }
        if ((i & 8) != 0) {
            sharePanelShowCallback = null;
        }
        shareToGetInvitationCodeUtil.shareWithPanel(activity, str, iMenuPanel, sharePanelShowCallback);
    }

    public final void shareWithPanel(Activity activity, String fromSpmid, IMenuPanel menuPanel, SharePanelShowCallback sharePanelShowCallback) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        SharePanelWrapper.SharePanelWrapperBuilder with = SharePanelWrapper.Companion.with(activity);
        ShareOnlineParams build = ShareOnlineParams.builder().oid(String.valueOf(BiliAccounts.get(BiliContext.application()).mid())).shareId(SHARE_ID).shareMode(3).spmId(SPMID).fromSpmId(fromSpmid).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        SharePanelWrapper.SharePanelWrapperBuilder sharePanel = with.shareOnlineParams(build).shareCallback(new ShareCallback() { // from class: tv.danmaku.bili.ui.answer.ShareToGetInvitationCodeUtil$shareWithPanel$sharePanel$1
            public /* synthetic */ void isFirstShare(Boolean bool) {
                ShareCallback.-CC.$default$isFirstShare(this, bool);
            }

            public /* synthetic */ boolean onShareSuccess(String str, String str2, Bundle bundle) {
                return ShareCallback.-CC.$default$onShareSuccess(this, str, str2, bundle);
            }

            public boolean onShareSuccess(String target, String msg) {
                ToastHelper.showToastShort(BiliContext.application(), R.string.share_global_string_49);
                return true;
            }

            public boolean onShareCancel(String target, int code) {
                return false;
            }

            public boolean onShareFail(String target, int code, String msg) {
                ToastHelper.showToastShort(BiliContext.application(), msg);
                return true;
            }
        });
        if (menuPanel != null) {
            sharePanel.attach(menuPanel);
        }
        if (sharePanelShowCallback != null) {
            sharePanel.setShareShowCallback(sharePanelShowCallback);
        }
        sharePanel.show();
    }
}