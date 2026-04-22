package tv.danmaku.bili.appwidget.guide.utils;

import android.content.Context;
import com.bapis.bilibili.app.show.mixture.v1.GuideStyleVersion;
import com.bapis.bilibili.app.show.mixture.v1.GuideType;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidget;
import tv.danmaku.bili.appwidget.upcard.UpCardAppWidget;
import tv.danmaku.bili.appwidget.utils.WidgetUtilsKt;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: AutoAddWidgetSceneExt.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0007\u001a\u00020\u0001*\u00020\bH\u0000\u001a\f\u0010\t\u001a\u00020\u0005*\u00020\bH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\bH\u0000\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\bH\u0000\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\bH\u0000\u001a\f\u0010\u000e\u001a\u00020\u000b*\u00020\bH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\bH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\bH\u0000\u001a\u0014\u0010\u0013\u001a\u00020\u000b*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017*\u00020\bH\u0000\u001a\f\u0010\u0018\u001a\u00020\u0001*\u00020\bH\u0000\u001a\f\u0010\u0019\u001a\u00020\u000b*\u00020\bH\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0000\u001a\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0000\u001a\f\u0010 \u001a\u00020\u001e*\u00020\bH\u0000\u001a\b\u0010!\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"SPMID_DYNAMIC_DETAIL", "", "SPMID_PLAYER_VIDEO_DETAIL", "SPMID_AUTHOR_SPACE_DETAIL", "OFFSET_60", "", "OFFSET_8", FavoritesConstsKt.SPMID, "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "offset", "outsideTouchable", "", "contentId", "type", "autoDismiss", "guideType", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideType;", "guideStyleVersion", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideStyleVersion;", "widgetAdded", "context", "Landroid/content/Context;", "component", "Ljava/lang/Class;", "action", "skipUpdate", "reportClick", "", "choice", "aid", "", "Lcom/bilibili/moduleservice/appwidget/GuideScene$PlayerVideoDetail;", "displayDurationMs", "videoDetailOutsideTouchable", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoAddWidgetSceneExtKt {
    private static final int OFFSET_60 = 60;
    private static final int OFFSET_8 = 8;
    private static final String SPMID_AUTHOR_SPACE_DETAIL = "main.space-contribution.0.0.pv";
    private static final String SPMID_DYNAMIC_DETAIL = "dt.dt.0.0.pv";
    private static final String SPMID_PLAYER_VIDEO_DETAIL = "united.player-video-detail.0.0.pv";

    public static final String spmid(GuideScene $this$spmid) {
        Intrinsics.checkNotNullParameter($this$spmid, "<this>");
        if ($this$spmid instanceof GuideScene.DynamicHome) {
            return SPMID_DYNAMIC_DETAIL;
        }
        if ($this$spmid instanceof GuideScene.PlayerVideoDetail) {
            return SPMID_PLAYER_VIDEO_DETAIL;
        }
        if ($this$spmid instanceof GuideScene.AuthorSpace) {
            String spmid = ((GuideScene.AuthorSpace) $this$spmid).getSpmid();
            return spmid == null ? SPMID_AUTHOR_SPACE_DETAIL : spmid;
        } else if ($this$spmid instanceof GuideScene.Function) {
            return ((GuideScene.Function) $this$spmid).getSpmid();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final int offset(GuideScene $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "<this>");
        if ($this$offset instanceof GuideScene.DynamicHome) {
            return 60;
        }
        if (!($this$offset instanceof GuideScene.PlayerVideoDetail) && ($this$offset instanceof GuideScene.AuthorSpace)) {
            return 8;
        }
        return 8;
    }

    public static final boolean outsideTouchable(GuideScene $this$outsideTouchable) {
        Intrinsics.checkNotNullParameter($this$outsideTouchable, "<this>");
        if ($this$outsideTouchable instanceof GuideScene.DynamicHome) {
            return false;
        }
        return $this$outsideTouchable instanceof GuideScene.PlayerVideoDetail ? videoDetailOutsideTouchable() : !($this$outsideTouchable instanceof GuideScene.AuthorSpace);
    }

    public static final String contentId(GuideScene $this$contentId) {
        Intrinsics.checkNotNullParameter($this$contentId, "<this>");
        if (!($this$contentId instanceof GuideScene.DynamicHome) && ($this$contentId instanceof GuideScene.PlayerVideoDetail)) {
            return ((GuideScene.PlayerVideoDetail) $this$contentId).getAvid();
        }
        return null;
    }

    public static final String type(GuideScene $this$type) {
        Intrinsics.checkNotNullParameter($this$type, "<this>");
        return (($this$type instanceof GuideScene.DynamicHome) || ($this$type instanceof GuideScene.PlayerVideoDetail) || ($this$type instanceof GuideScene.AuthorSpace)) ? "follow" : "function";
    }

    public static final boolean autoDismiss(GuideScene $this$autoDismiss) {
        Intrinsics.checkNotNullParameter($this$autoDismiss, "<this>");
        return ($this$autoDismiss instanceof GuideScene.DynamicHome) || ($this$autoDismiss instanceof GuideScene.PlayerVideoDetail) || ($this$autoDismiss instanceof GuideScene.AuthorSpace);
    }

    public static final GuideType guideType(GuideScene $this$guideType) {
        Intrinsics.checkNotNullParameter($this$guideType, "<this>");
        if (!($this$guideType instanceof GuideScene.DynamicHome) && !($this$guideType instanceof GuideScene.PlayerVideoDetail) && !($this$guideType instanceof GuideScene.AuthorSpace)) {
            return GuideType.GUIDE_TYPE_FUNC;
        }
        return GuideType.GUIDE_TYPE_DEFAULT;
    }

    public static final GuideStyleVersion guideStyleVersion(GuideScene $this$guideStyleVersion) {
        Intrinsics.checkNotNullParameter($this$guideStyleVersion, "<this>");
        return $this$guideStyleVersion instanceof GuideScene.Function ? GuideStyleVersion.GUIDE_STYLE_FUNC_NEW : GuideStyleVersion.GUIDE_STYLE_DEFAULT;
    }

    public static final boolean widgetAdded(GuideScene $this$widgetAdded, Context context) {
        Intrinsics.checkNotNullParameter($this$widgetAdded, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!($this$widgetAdded instanceof GuideScene.DynamicHome) && !($this$widgetAdded instanceof GuideScene.PlayerVideoDetail) && !($this$widgetAdded instanceof GuideScene.AuthorSpace)) {
            return WidgetUtilsKt.isWidgetAdded(context, HotWordAppWidget.class);
        }
        return WidgetUtilsKt.isWidgetAdded(context, UpCardAppWidget.class);
    }

    public static final Class<?> component(GuideScene $this$component) {
        Intrinsics.checkNotNullParameter($this$component, "<this>");
        return (($this$component instanceof GuideScene.DynamicHome) || ($this$component instanceof GuideScene.PlayerVideoDetail) || ($this$component instanceof GuideScene.AuthorSpace)) ? UpCardAppWidget.class : HotWordAppWidget.class;
    }

    public static final String action(GuideScene $this$action) {
        Intrinsics.checkNotNullParameter($this$action, "<this>");
        if (!($this$action instanceof GuideScene.DynamicHome) && !($this$action instanceof GuideScene.PlayerVideoDetail) && !($this$action instanceof GuideScene.AuthorSpace) && !($this$action instanceof GuideScene.Function)) {
            throw new NoWhenBranchMatchedException();
        }
        return "tv.danmaku.bili.action.appwidget.AUTO_ADD_WIDGET";
    }

    public static final boolean skipUpdate(GuideScene $this$skipUpdate) {
        Intrinsics.checkNotNullParameter($this$skipUpdate, "<this>");
        return $this$skipUpdate instanceof GuideScene.Function;
    }

    public static final void reportClick(GuideScene $this$reportClick, int choice) {
        Intrinsics.checkNotNullParameter($this$reportClick, "<this>");
        if (($this$reportClick instanceof GuideScene.DynamicHome) || ($this$reportClick instanceof GuideScene.PlayerVideoDetail) || ($this$reportClick instanceof GuideScene.AuthorSpace)) {
            ReportHelperKt.reportGuideBannerClick(spmid($this$reportClick), type($this$reportClick), contentId($this$reportClick), choice);
        } else {
            ReportHelperKt.reportGuidePopClick(spmid($this$reportClick), choice);
        }
    }

    public static final long aid(GuideScene.PlayerVideoDetail $this$aid) {
        Intrinsics.checkNotNullParameter($this$aid, "<this>");
        try {
            Long longOrNull = StringsKt.toLongOrNull($this$aid.getAvid());
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 0L;
        } catch (Exception e) {
            return 0L;
        }
    }

    public static final long displayDurationMs(GuideScene $this$displayDurationMs) {
        String dd;
        Long longOrNull;
        Intrinsics.checkNotNullParameter($this$displayDurationMs, "<this>");
        if (!($this$displayDurationMs instanceof GuideScene.PlayerVideoDetail) || (dd = DeviceDecision.INSTANCE.dd("dd.auto_add_widget_guide_video_detail_duration", "10000")) == null || (longOrNull = StringsKt.toLongOrNull(dd)) == null) {
            return 10000L;
        }
        return longOrNull.longValue();
    }

    private static final boolean videoDetailOutsideTouchable() {
        String dd = DeviceDecision.INSTANCE.dd("dd.widget_guide_video_detail_outside_touchable", "false");
        if (dd != null) {
            return Boolean.parseBoolean(dd);
        }
        return false;
    }
}