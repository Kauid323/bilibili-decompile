package tv.danmaku.bili.push.innerpush.model;

import android.app.Activity;
import com.bapis.bilibili.broadcast.v1.LinkType;
import com.bilibili.module.main.innerpush.BizParams;
import com.bilibili.module.main.innerpush.IPushContainer;
import com.bilibili.module.main.innerpush.IShowPushWhenPageDestroy;
import com.bilibili.module.main.innerpush.InnerPush;
import com.bilibili.module.main.innerpush.PushBizParams;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.innerpush.PushRpc;
import tv.danmaku.bili.push.innerpush.PushUpFilterType;
import tv.danmaku.bili.push.innerpush.config.InnerPushLocalStorage;
import tv.danmaku.bili.push.innerpush.reporter.InnerPushReportHelperKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: InnerPushExtension.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\u0014\u0010\u0013\u001a\u00020\u0006*\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u001a \u0010\u0013\u001a\u00020\u0006*\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u001a\n\u0010\u0018\u001a\u00020\u0004*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u001a\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0016\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f\"\u0015\u0010\u000f\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b\"\u0015\u0010\u0011\u001a\u00020\u0004*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\b\"\u000e\u0010\u001e\u001a\u00020\u0016X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"getPushBizParams", "Lcom/bilibili/module/main/innerpush/PushBizParams;", "Lcom/bilibili/module/main/innerpush/InnerPush;", "isHighLevel", "", "increaseExposeCount", "", "isImageType", "(Lcom/bilibili/module/main/innerpush/InnerPush;)Z", "durationMs", "", "getDurationMs", "(Lcom/bilibili/module/main/innerpush/InnerPush;)J", "expireMs", "getExpireMs", "liveBorderEnable", "getLiveBorderEnable", "liveMarkerEnable", "getLiveMarkerEnable", "reportDiscardPush", "reason", "Ltv/danmaku/bili/push/innerpush/PushUpFilterType;", "", "serverFilterReason", "isPushExpire", "isInBlackList", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "isInPageViewBlackList", "pvId", "TAG", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class InnerPushExtensionKt {
    private static final String TAG = "[InnerPush]InnerPush";

    public static final PushBizParams getPushBizParams(InnerPush $this$getPushBizParams) {
        Intrinsics.checkNotNullParameter($this$getPushBizParams, "<this>");
        BizParams params = $this$getPushBizParams.getBizParams();
        if (params == null) {
            return null;
        }
        return new PushBizParams(params.getType() == null ? String.valueOf(LinkType.LINK_TYPE_UNKNOWN.getNumber()) : params.getType(), params.getValue() == null ? new HashMap() : params.getValue());
    }

    public static final boolean isHighLevel(InnerPush $this$isHighLevel) {
        Intrinsics.checkNotNullParameter($this$isHighLevel, "<this>");
        return $this$isHighLevel.getLevel() == 99;
    }

    public static final void increaseExposeCount(InnerPush $this$increaseExposeCount) {
        Intrinsics.checkNotNullParameter($this$increaseExposeCount, "<this>");
        InnerPushLocalStorage.INSTANCE.increaseInnerPushShowCount($this$increaseExposeCount);
    }

    public static final boolean isImageType(InnerPush $this$isImageType) {
        Intrinsics.checkNotNullParameter($this$isImageType, "<this>");
        return $this$isImageType.getDisplayType() == 1 || $this$isImageType.getDisplayType() == 2;
    }

    public static final long getDurationMs(InnerPush $this$durationMs) {
        Intrinsics.checkNotNullParameter($this$durationMs, "<this>");
        return $this$durationMs.getDuration() * 1000;
    }

    public static final long getExpireMs(InnerPush $this$expireMs) {
        Intrinsics.checkNotNullParameter($this$expireMs, "<this>");
        return $this$expireMs.getExpire() * 1000;
    }

    public static final boolean getLiveBorderEnable(InnerPush $this$liveBorderEnable) {
        Intrinsics.checkNotNullParameter($this$liveBorderEnable, "<this>");
        return $this$liveBorderEnable.getImageFrame() == 1;
    }

    public static final boolean getLiveMarkerEnable(InnerPush $this$liveMarkerEnable) {
        Intrinsics.checkNotNullParameter($this$liveMarkerEnable, "<this>");
        return $this$liveMarkerEnable.getImageMarker() == 1;
    }

    public static final void reportDiscardPush(InnerPush $this$reportDiscardPush, PushUpFilterType reason) {
        Intrinsics.checkNotNullParameter($this$reportDiscardPush, "<this>");
        reportDiscardPush$default($this$reportDiscardPush, reason != null ? reason.getText() : null, null, 2, null);
    }

    public static /* synthetic */ void reportDiscardPush$default(InnerPush innerPush, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        reportDiscardPush(innerPush, str, str2);
    }

    public static final void reportDiscardPush(InnerPush $this$reportDiscardPush, String reason, String serverFilterReason) {
        Intrinsics.checkNotNullParameter($this$reportDiscardPush, "<this>");
        BLog.i(TAG, "reportDiscardPush, pushId = " + $this$reportDiscardPush.getTaskId() + ", discardReason = " + reason);
        PushRpc.pushUpStreamForFilter($this$reportDiscardPush.getTaskId(), reason, $this$reportDiscardPush.getJob(), $this$reportDiscardPush.getBid(), $this$reportDiscardPush.getMsgSource(), serverFilterReason, $this$reportDiscardPush.getMetaData());
        InnerPushReportHelperKt.reportDiscardReason($this$reportDiscardPush.getTaskId(), $this$reportDiscardPush.getMsgSource(), reason, serverFilterReason, $this$reportDiscardPush.getMetaData());
    }

    public static final boolean isPushExpire(InnerPush $this$isPushExpire) {
        Intrinsics.checkNotNullParameter($this$isPushExpire, "<this>");
        return System.currentTimeMillis() > getExpireMs($this$isPushExpire);
    }

    public static final boolean isInBlackList(InnerPush $this$isInBlackList, Activity activity) {
        Intrinsics.checkNotNullParameter($this$isInBlackList, "<this>");
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        IPushContainer iPushContainer = activity instanceof IPushContainer ? (IPushContainer) activity : null;
        if (iPushContainer != null) {
            List pageBlackList = $this$isInBlackList.getPageBlackList();
            if (pageBlackList == null) {
                pageBlackList = CollectionsKt.emptyList();
            }
            return iPushContainer.onInterceptPushShow(pageBlackList, getPushBizParams($this$isInBlackList));
        }
        return false;
    }

    public static final boolean isInPageViewBlackList(InnerPush $this$isInPageViewBlackList, Activity activity, String pvId) {
        Intrinsics.checkNotNullParameter($this$isInPageViewBlackList, "<this>");
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(pvId, "pvId");
        List pagePvBlackList = $this$isInPageViewBlackList.getPagePvBlackList();
        if (pagePvBlackList != null && pagePvBlackList.contains(pvId)) {
            BLog.i(TAG, "isInPageViewBlackList, hit page_view, page = " + activity.getClass().getSimpleName());
            return true;
        } else if (activity instanceof IShowPushWhenPageDestroy) {
            BLog.i(TAG, "isInPageViewBlackList, hit client define black page " + activity.getClass().getSimpleName());
            return true;
        } else {
            return false;
        }
    }
}