package tv.danmaku.bili.downloadeshare.report;

import com.bilibili.droid.AppsFlyerWrapper;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.sharewrapper.util.SessionManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DownloadShareReporter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J0\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J&\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005J:\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005JB\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005JN\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/downloadeshare/report/DownloadShareReporter;", "", "<init>", "()V", "TAG", "", "reportDownloadShareMenuItemClick", "", "avid", "shareChannel", FavoritesConstsKt.SPMID, "objectExtraFields", "sid", "reportDownloadShareMenuShow", "reportDownloadVideoDialogCloseClick", "videoSize", "pv", "shareOrigin", "reportDownloadVideoBegin", "reportDownloadVideoEnd", "downloadTime", "trackDownloadShare", "url", "backup", "md5", "size", "backupState", "timeCost", "errorCode", "errorDomain", AuthResultCbHelper.ARGS_MSG, "downloadsharecommon_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DownloadShareReporter {
    public static final DownloadShareReporter INSTANCE = new DownloadShareReporter();
    private static final String TAG = "DownloadShareReporter";

    private DownloadShareReporter() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void reportDownloadShareMenuItemClick(String avid, String shareChannel, String spmid, String objectExtraFields, String sid) {
        String str;
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(shareChannel, "shareChannel");
        BLog.i(TAG, "avid:" + avid + ", shareChannel:" + shareChannel);
        Map params = new HashMap();
        params.put("oid", avid);
        switch (shareChannel.hashCode()) {
            case -1738246558:
                if (shareChannel.equals("WEIXIN")) {
                    str = "1";
                    break;
                }
                str = null;
                break;
            case 2592:
                if (shareChannel.equals("QQ")) {
                    str = "3";
                    break;
                }
                str = null;
                break;
            case 77564797:
                if (shareChannel.equals("QZONE")) {
                    str = "4";
                    break;
                }
                str = null;
                break;
            case 1120828781:
                if (shareChannel.equals("WEIXIN_MONMENT")) {
                    str = "2";
                    break;
                }
                str = null;
                break;
            default:
                str = null;
                break;
        }
        params.put("share_channel", str);
        params.put(FavoritesConstsKt.SPMID, spmid == null ? "" : spmid);
        params.put("object_extra_fields", objectExtraFields == null ? "" : objectExtraFields);
        params.put("panel_type", "3");
        params.put("share_session_id", SessionManager.INSTANCE.getSessionId());
        params.put("sid", sid != null ? sid : "");
        Neurons.reportClick(false, "main.public-community.share-download-popup.0.click", params);
        Neurons.reportClick(false, "main.public-community.share.all.click", params);
        AppsFlyerWrapper.logEvent("af_share");
    }

    public static /* synthetic */ void reportDownloadShareMenuShow$default(DownloadShareReporter downloadShareReporter, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            str3 = "";
        }
        downloadShareReporter.reportDownloadShareMenuShow(str, str2, str3, str4);
    }

    public final void reportDownloadShareMenuShow(String avid, String spmid, String objectExtraFields, String sid) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Map params = new HashMap();
        params.put("oid", avid);
        params.put(FavoritesConstsKt.SPMID, spmid == null ? "" : spmid);
        params.put("object_extra_fields", objectExtraFields == null ? "" : objectExtraFields);
        params.put("panel_type", "3");
        params.put("share_session_id", SessionManager.INSTANCE.getSessionId());
        params.put("sid", sid != null ? sid : "");
        Neurons.reportExposure$default(false, "main.public-community.share-download-popup.0.show", params, (List) null, 8, (Object) null);
        Neurons.reportExposure$default(false, "main.public-community.share.all.show", params, (List) null, 8, (Object) null);
    }

    public final void reportDownloadVideoDialogCloseClick(String avid, String videoSize, String pv, String shareOrigin) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Intrinsics.checkNotNullParameter(pv, "pv");
        Intrinsics.checkNotNullParameter(shareOrigin, "shareOrigin");
        Map params = new HashMap();
        params.put("oid", avid);
        params.put("oid_size", videoSize);
        params.put("share_id", pv);
        params.put("share_origin", shareOrigin);
        Neurons.reportClick(false, "main.public-community.share-download-cancel.0.click", params);
    }

    public final void reportDownloadVideoBegin(String avid, String videoSize, String pv, String shareOrigin, String spmid, String objectExtraFields) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Intrinsics.checkNotNullParameter(pv, "pv");
        Intrinsics.checkNotNullParameter(shareOrigin, "shareOrigin");
        Map params = new HashMap();
        params.put("oid", avid);
        params.put("oid_size", videoSize);
        params.put("share_id", pv);
        params.put("share_origin", shareOrigin);
        params.put(FavoritesConstsKt.SPMID, spmid == null ? "" : spmid);
        params.put("object_extra_fields", objectExtraFields != null ? objectExtraFields : "");
        params.put("panel_type", "3");
        params.put("share_session_id", SessionManager.INSTANCE.getSessionId());
        Neurons.reportExposure$default(false, "main.public-community.share-download-begin.0.show", params, (List) null, 8, (Object) null);
    }

    public final void reportDownloadVideoEnd(String avid, String videoSize, String downloadTime, String pv, String shareOrigin, String spmid, String objectExtraFields) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        Intrinsics.checkNotNullParameter(downloadTime, "downloadTime");
        Intrinsics.checkNotNullParameter(pv, "pv");
        Intrinsics.checkNotNullParameter(shareOrigin, "shareOrigin");
        Map params = new HashMap();
        params.put("oid", avid);
        params.put("oid_size", videoSize);
        params.put("download_time", downloadTime);
        params.put("share_id", pv);
        params.put("share_origin", shareOrigin);
        params.put(FavoritesConstsKt.SPMID, spmid == null ? "" : spmid);
        params.put("object_extra_fields", objectExtraFields != null ? objectExtraFields : "");
        params.put("panel_type", "3");
        params.put("share_session_id", SessionManager.INSTANCE.getSessionId());
        Neurons.reportExposure$default(false, "main.public-community.share-download-end.0.show", params, (List) null, 8, (Object) null);
    }

    public final void trackDownloadShare(String url, String backup, String md5, String size, String backupState, String timeCost, String errorCode, String errorDomain, String msg) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(backup, "backup");
        Intrinsics.checkNotNullParameter(md5, "md5");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(backupState, "backupState");
        Intrinsics.checkNotNullParameter(timeCost, "timeCost");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(errorDomain, "errorDomain");
        Intrinsics.checkNotNullParameter(msg, AuthResultCbHelper.ARGS_MSG);
        Map params = new HashMap();
        params.put("url", url);
        params.put("backup", backup);
        params.put("md5", md5);
        params.put("size", size);
        params.put("backupState", backupState);
        params.put("timeCost", timeCost);
        params.put("errorCode", errorCode);
        params.put("errorDomain", errorDomain);
        params.put(AuthResultCbHelper.ARGS_MSG, msg);
        Neurons.trackT$default(false, "public.share.download.track", params, 0, new Function0() { // from class: tv.danmaku.bili.downloadeshare.report.DownloadShareReporter$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean trackDownloadShare$lambda$0;
                trackDownloadShare$lambda$0 = DownloadShareReporter.trackDownloadShare$lambda$0();
                return Boolean.valueOf(trackDownloadShare$lambda$0);
            }
        }, 8, (Object) null);
    }

    public static final boolean trackDownloadShare$lambda$0() {
        return true;
    }
}