package tv.danmaku.bili.appwidget.upcard.utils;

import com.bilibili.lib.neuron.api.Neurons;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: ReportUtil.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a>\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u001a\b\u0010$\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"reportCardClick", "", "avid", "", "index", "TYPE_WIDGET_CARD", "TYPE_UP_CARD_DOUBLE", "TYPE_WIDGET", "TYPE_UP_CARD_SINGLE", "POS_BILI", "POS_MY_INFO", "POS_HISTORY", "POS_FAV", "POS_TREND", "POS_DYNAMIC", "POS_DOWNLOAD", "POS_WATCH_LATER", "POS_VIDEO", "POS_CHANGE", "POS_SEARCH", "POS_OTHER", "POS_MORE_FOLLOW", "POS_PICTURE", "POS_OGV_UPDATE", "POS_TITLE", "POS_COVER", "POS_FOLLOW_UPDATE", "POS_UPDATE", "CONTENT_TYPE_UGC", "CONTENT_TYPE_OGV", "reportWidgetClick", "type", "position", "contentId", "contentType", FavoritesConstsKt.POS, "reportCnyTaskConsumed", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ReportUtilKt {
    public static final String CONTENT_TYPE_OGV = "ogv";
    public static final String CONTENT_TYPE_UGC = "ugc";
    public static final String POS_BILI = "bilibili";
    public static final String POS_CHANGE = "change";
    public static final String POS_COVER = "cover";
    public static final String POS_DOWNLOAD = "download";
    public static final String POS_DYNAMIC = "dynamic";
    public static final String POS_FAV = "fav";
    public static final String POS_FOLLOW_UPDATE = "follow_update";
    public static final String POS_HISTORY = "history";
    public static final String POS_MORE_FOLLOW = "morefollow";
    public static final String POS_MY_INFO = "myinfo";
    public static final String POS_OGV_UPDATE = "ogv_update";
    public static final String POS_OTHER = "other";
    public static final String POS_PICTURE = "picture";
    public static final String POS_SEARCH = "search";
    public static final String POS_TITLE = "title";
    public static final String POS_TREND = "trend";
    public static final String POS_UPDATE = "update";
    public static final String POS_VIDEO = "video";
    public static final String POS_WATCH_LATER = "watchlater";
    public static final String TYPE_UP_CARD_DOUBLE = "widget-follow-double";
    public static final String TYPE_UP_CARD_SINGLE = "widget-follow-single";
    public static final String TYPE_WIDGET = "widget";
    public static final String TYPE_WIDGET_CARD = "widget-follow-single";

    public static final void reportCardClick(String avid, String index) {
        Intrinsics.checkNotNullParameter(avid, "avid");
        Intrinsics.checkNotNullParameter(index, "index");
        Neurons.reportClick(false, "main.widgets.video.new.click", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("avid", avid), TuplesKt.to(FavoritesConstsKt.POS, index)}));
    }

    public static /* synthetic */ void reportWidgetClick$default(String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        reportWidgetClick(str, str2, str3, str4, str5);
    }

    public static final void reportWidgetClick(String type, String position, String contentId, String contentType, String pos) {
        Intrinsics.checkNotNullParameter(type, "type");
        Map extra = new LinkedHashMap();
        extra.put("type", type);
        if (position != null) {
            extra.put("position", position);
        }
        if (contentId != null) {
            extra.put("content_id", contentId);
        }
        if (contentType != null) {
            extra.put("content_type", contentType);
        }
        if (pos != null) {
            extra.put(FavoritesConstsKt.POS, pos);
        }
        Neurons.reportClick(false, "main.widgets.0.0.click", extra);
        reportCnyTaskConsumed();
    }

    private static final void reportCnyTaskConsumed() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(EmptyCoroutineContext.INSTANCE.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null))), Dispatchers.getIO(), (CoroutineStart) null, new ReportUtilKt$reportCnyTaskConsumed$1(null), 2, (Object) null);
    }
}