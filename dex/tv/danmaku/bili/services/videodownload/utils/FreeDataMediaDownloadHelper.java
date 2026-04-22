package tv.danmaku.bili.services.videodownload.utils;

import android.content.Context;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.tf.TfResource;
import com.bilibili.lib.tf.TfTransformResp;
import com.bilibili.lib.tf.TfTypeExt;
import com.bilibili.lib.tf.freedata.util.TfTransformKt;
import com.bilibili.videodownloader.exceptions.DownloadUsualException;
import com.bilibili.videodownloader.exceptions.ResolveFreeDataException;
import tv.danmaku.bili.OnlineParamsHelper;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;

public class FreeDataMediaDownloadHelper {
    public static final int FREE_NETWORK_TYPE = 10010;

    public static boolean isUnicomCardUser(Context context) {
        if (context == null) {
            return false;
        }
        TfTypeExt orderType = FreeDataManager.getInstance().getFreeDataCondition().getTypeExt();
        return orderType == TfTypeExt.U_CARD;
    }

    public static boolean enableUnicomUpgrade() {
        return OnlineParamsHelper.enableUnicomUpgrade();
    }

    public static boolean isMediaSupportFreeData(Context context) {
        return FreeDataManager.getInstance().checkConditionMatched(TfResource.RES_VIDEO).getIsValid();
    }

    public static boolean isDanmakuSupportFreeData(Context context) {
        return FreeDataManager.getInstance().checkConditionMatched(TfResource.RES_DANMAKU).getIsValid();
    }

    public static boolean isThirdFrom(String from) {
        return ("vupload".equals(from) || "movie".equals(from) || "bangumi".equals(from)) ? false : true;
    }

    public static String transformVideoUrl(Context context, String url) throws ResolveFreeDataException {
        TfTransformResp result = FreeDataManager.getInstance().processMediaUrl(context, url);
        if (TfTransformKt.isSuccessful(result)) {
            return result.getUrl();
        }
        throw new ResolveFreeDataException(WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_SEGMENT, result.getCodeValue(), "error_unicom_transfrom_segment_failed");
    }

    public static String transformDanmakuUrl(Context context, String url) throws DownloadUsualException {
        TfTransformResp result = FreeDataManager.getInstance().processDanmakuUrl(context, url);
        if (TfTransformKt.isSuccessful(result)) {
            return result.getUrl();
        }
        throw new DownloadUsualException(WrapperErrorCode.UNICON_RESOLVE_TRANSFORM_DANMAKU, "error_unicom_transfrom_danmaku_failed");
    }

    public static int getNetworkType(Context context) {
        int networkType = ConnectivityMonitor.getInstance().getNetworkWithoutCache();
        if (isMediaSupportFreeData(context) && networkType == 2) {
            return FREE_NETWORK_TYPE;
        }
        return networkType;
    }

    public static boolean isMobileNetWork() {
        return ConnectivityMonitor.getInstance().isMobileActive();
    }
}