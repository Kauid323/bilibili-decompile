package tv.danmaku.bili.services.videodownload.interceptor;

import android.content.Context;
import android.text.TextUtils;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.droid.StringFormatter;
import com.bilibili.fd_service.FreeDataManager;
import com.bilibili.lib.media.resolver.params.ResolveSegmentParams;
import com.bilibili.lib.media.resource.Segment;
import com.bilibili.moduleservice.main.DownloadSegmentService;
import com.bilibili.videodownloader.exceptions.ResolveFreeDataException;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.services.videodownload.WrapperErrorCode;
import tv.danmaku.bili.services.videodownload.utils.FreeDataMediaDownloadHelper;

/* compiled from: FreeDataSegmentServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/services/videodownload/interceptor/FreeDataSegmentServiceImpl;", "Lcom/bilibili/moduleservice/main/DownloadSegmentService;", "<init>", "()V", "transformSegmentByFreeData", "", "context", "Landroid/content/Context;", "segmentAny", "resolveSegmentParams", "videoDownloadEntry", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FreeDataSegmentServiceImpl implements DownloadSegmentService {
    public static final int $stable = 0;

    public Object transformSegmentByFreeData(Context context, Object segmentAny, Object resolveSegmentParams, Object videoDownloadEntry) {
        String substring;
        if (context == null || segmentAny == null || resolveSegmentParams == null || videoDownloadEntry == null) {
            return null;
        }
        VideoDownloadEntry entry = videoDownloadEntry instanceof VideoDownloadEntry ? (VideoDownloadEntry) videoDownloadEntry : null;
        if (entry == null) {
            return null;
        }
        int expectedNetwork = entry.mExpectedNetworkType;
        ResolveSegmentParams params = resolveSegmentParams instanceof ResolveSegmentParams ? (ResolveSegmentParams) resolveSegmentParams : null;
        if (params == null) {
            return null;
        }
        Segment segment = segmentAny instanceof Segment ? (Segment) segmentAny : null;
        if (segment == null) {
            return null;
        }
        Segment segment2 = segment;
        if (!FreeDataManager.getInstance().isFreeDataForbade(context, FreeDataManager.ForbadeType.VIDEO_DOWNLOAD)) {
            return segment2;
        }
        if ((expectedNetwork != 2 && expectedNetwork != 10010) || ConnectivityMonitor.getInstance().getNetworkWithoutCache() != 2 || TextUtils.isEmpty(segment2.mUrl)) {
            if (TextUtils.isEmpty(segment2.mUrl)) {
                substring = "none";
            } else {
                String str = segment2.mUrl;
                Intrinsics.checkNotNullExpressionValue(str, "mUrl");
                substring = str.substring(0, 30);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            }
            BLog.w("FreeDataSegmentServiceImpl", StringFormatter.format("cancel transform segment unicom url: %s", new Object[]{substring}));
            return segment2;
        } else if (FreeDataMediaDownloadHelper.isThirdFrom(params.getFrom())) {
            if (expectedNetwork == 10010) {
                throw new ResolveFreeDataException("error_unicom_unsupport_third", WrapperErrorCode.UNICON_RESOLVE_UNSUPPORT_THIRD);
            }
            return segment2;
        } else if (!FreeDataMediaDownloadHelper.isMediaSupportFreeData(context)) {
            if (expectedNetwork == 10010) {
                throw new ResolveFreeDataException("error_unicom_condition_not_mathch", WrapperErrorCode.UNICON_RESOLVE_CONDITION_NOT_MATHCED);
            }
            return segment2;
        } else {
            entry.mExpectedNetworkType = FreeDataMediaDownloadHelper.FREE_NETWORK_TYPE;
            segment2.mUrl = FreeDataMediaDownloadHelper.transformVideoUrl(context, segment2.mUrl);
            BLog.i("FreeDataSegmentServiceImpl", StringFormatter.format("transform unicom segment url success", new Object[0]));
            ArrayList backups = segment2.mBackupUrls;
            if (backups != null && !backups.isEmpty()) {
                ArrayList newBackups = new ArrayList();
                Iterator it = backups.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    String back = (String) it.next();
                    if (!TextUtils.isEmpty(back)) {
                        String processedBackupUrl = FreeDataMediaDownloadHelper.transformVideoUrl(context, back);
                        if (!TextUtils.isEmpty(processedBackupUrl)) {
                            newBackups.add(processedBackupUrl);
                        }
                    }
                }
                segment2.mBackupUrls = newBackups;
            }
            return segment2;
        }
    }
}