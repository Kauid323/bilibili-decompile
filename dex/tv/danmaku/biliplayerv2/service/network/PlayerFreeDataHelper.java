package tv.danmaku.biliplayerv2.service.network;

import android.app.Application;
import android.net.Uri;
import com.bilibili.base.BiliContext;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resource.PlayIndex;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.lib.tf.freedata.util.TfTransformKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: PlayerFreeDataHelper.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\tJ\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Ltv/danmaku/biliplayerv2/service/network/PlayerFreeDataHelper;", "", "<init>", "()V", "TAG", "", "sFreeDataResult", "Lcom/bilibili/lib/tf/TfTransformResp;", "shouldProcessUrl", "", "supportDrmFreeData", "drmType", "Lcom/bilibili/lib/media/resource/PlayIndex$DrmType;", "processUrl", "resType", "Lcom/bilibili/fd_service/FreeDataManager$ResType;", "originUrl", "getFreeDataResultCode", "", "isUnicomCard", "isFreeCardUser", "isFreePackageUser", "checkMediaUrlProcessed", "targetUrl", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlayerFreeDataHelper {
    public static final PlayerFreeDataHelper INSTANCE = new PlayerFreeDataHelper();
    private static final String TAG = "PlayerFreeDataHelper";
    private static TfTransformResp sFreeDataResult;

    private PlayerFreeDataHelper() {
    }

    public final boolean shouldProcessUrl() {
        return FreeDataManager.getInstance().isTf();
    }

    public final boolean supportDrmFreeData(PlayIndex.DrmType drmType) {
        return false;
    }

    public final String processUrl(FreeDataManager.ResType resType, String originUrl) {
        Intrinsics.checkNotNullParameter(resType, "resType");
        Application context = BiliContext.application();
        if (context == null) {
            return null;
        }
        TfTransformResp result = FreeDataManager.getInstance().processUrl(context, resType, originUrl);
        Intrinsics.checkNotNullExpressionValue(result, "processUrl(...)");
        sFreeDataResult = result;
        if (TfTransformKt.isSuccessful(result)) {
            String url = result.getUrl();
            if (url == null || url.length() == 0) {
                return null;
            }
            return Uri.parse(result.getUrl()).buildUpon().appendQueryParameter("free_traffic", "1").build().toString();
        }
        return null;
    }

    public final int getFreeDataResultCode() {
        if (sFreeDataResult != null) {
            TfTransformResp tfTransformResp = sFreeDataResult;
            Intrinsics.checkNotNull(tfTransformResp);
            if (!TfTransformKt.isSuccessful(tfTransformResp)) {
                TfTransformResp tfTransformResp2 = sFreeDataResult;
                Intrinsics.checkNotNull(tfTransformResp2);
                return tfTransformResp2.getCodeValue();
            }
        }
        return 0;
    }

    public final boolean isUnicomCard() {
        TfTypeExt orderType = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
        return orderType == TfTypeExt.U_CARD;
    }

    public final boolean isFreeCardUser() {
        TfTypeExt orderType = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
        return orderType == TfTypeExt.U_CARD || orderType == TfTypeExt.T_CARD || orderType == TfTypeExt.C_CARD;
    }

    public final boolean isFreePackageUser() {
        TfTypeExt orderType = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
        return orderType == TfTypeExt.U_PKG || orderType == TfTypeExt.C_PKG || orderType == TfTypeExt.T_PKG;
    }

    public final boolean checkMediaUrlProcessed(String targetUrl) {
        Application context = BiliContext.application();
        if (context == null) {
            return false;
        }
        boolean urlCorrect = FreeDataManager.getInstance().checkMediaUrlCorrect(context, targetUrl);
        boolean ipCorrect = FreeDataManager.getInstance().isTf();
        PlayerLog.i(TAG, "check media url: " + urlCorrect + ", ip: " + ipCorrect);
        return urlCorrect && ipCorrect;
    }
}