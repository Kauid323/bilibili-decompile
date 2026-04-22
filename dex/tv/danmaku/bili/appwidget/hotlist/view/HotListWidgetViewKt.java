package tv.danmaku.bili.appwidget.hotlist.view;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.WidgetTransparentActivity;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.appwidget.hotlist.HotListAppWidget;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetRcmdModel;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtil;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;

/* compiled from: HotListWidgetView.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a<\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0010\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019\u001a\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\u0018\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a$\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002\u001a\"\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f\u001a<\u0010#\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002\u001aJ\u0010'\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010*\u001a\u00020\u00032&\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010,j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u0001`-H\u0002\u001a\u0018\u0010.\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010*\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"TAG", "", "CARD_COUNT", "", "HOT_LIST_APP_NORMAL_STATUS", "HOT_LIST_APP_BLOCK_STATUS", "HOT_LIST_APP_TEENAGER_STATUS", "HOT_LIST_APP_LESSONS_STATUS", "URL_SEARCH_NEW", "REQUEST_CODE_OPEN_MAIN", "REQUEST_CODE_SEARCH", "REQUEST_CODE_EXCHANGE", "REQUEST_CODE_COVER", "REQUEST_CODE_OPEN_BILI_MAIN", "createHotListWidgetView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "data", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "coverBitmaps", "", "Landroid/graphics/Bitmap;", "cardType", "Ltv/danmaku/bili/appwidget/hotlist/view/HotListCardType;", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;Ljava/util/List;Ltv/danmaku/bili/appwidget/hotlist/view/HotListCardType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showBlockWidgetView", "showTeenagerWidgetView", "showLessonsWidgetView", "showRestrictedWidgetView", "tipsId", "updateWidgetViewClick", "isRestrictedMode", "", "remoteViews", "createWidgetCard", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetItemModel;", "index", ReportUtilKt.POS_COVER, "createIntent", "Landroid/app/PendingIntent;", "url", "requestCode", "reportParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "createBroadcast", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListWidgetViewKt {
    public static final int CARD_COUNT = 3;
    public static final int HOT_LIST_APP_BLOCK_STATUS = 1;
    public static final int HOT_LIST_APP_LESSONS_STATUS = 3;
    public static final int HOT_LIST_APP_NORMAL_STATUS = 0;
    public static final int HOT_LIST_APP_TEENAGER_STATUS = 2;
    private static final int REQUEST_CODE_COVER = 3440;
    private static final int REQUEST_CODE_EXCHANGE = 3435;
    private static final int REQUEST_CODE_OPEN_BILI_MAIN = 3436;
    private static final int REQUEST_CODE_OPEN_MAIN = 3433;
    private static final int REQUEST_CODE_SEARCH = 3434;
    private static final String TAG = "HotListWidgetView";
    private static final String URL_SEARCH_NEW = "activity://main/stardust-search";

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getActivity(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    public static /* synthetic */ Object createHotListWidgetView$default(Context context, HotListWidgetModel hotListWidgetModel, List list, HotListCardType hotListCardType, Continuation continuation, int i, Object obj) {
        if ((i & 8) != 0) {
            hotListCardType = HotListCardType.MIDDLE_CARD;
        }
        return createHotListWidgetView(context, hotListWidgetModel, list, hotListCardType, continuation);
    }

    public static final Object createHotListWidgetView(Context context, HotListWidgetModel data, List<Bitmap> list, HotListCardType cardType, Continuation<? super RemoteViews> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new HotListWidgetViewKt$createHotListWidgetView$2(context, data, list, cardType, null), continuation);
    }

    public static final RemoteViews showBlockWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RemoteViews $this$showBlockWidgetView_u24lambda_u240 = new RemoteViews(context.getPackageName(), R.layout.bili_app_hot_list_widget_block);
        $this$showBlockWidgetView_u24lambda_u240.setOnClickPendingIntent(R.id.container, createIntent(context, "", REQUEST_CODE_OPEN_MAIN, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, RouterUtilKt.HOT_LIST_REPORT_OTHER_BUSINESS)})));
        return $this$showBlockWidgetView_u24lambda_u240;
    }

    private static PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(Context context, int requestCode, Intent intent, int flags) {
        PendingIntentCreateHook.setPackageIfAbsent(context, intent, flags);
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
            } catch (IllegalArgumentException e) {
                return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(33554432 | flags).intValue());
            }
        }
        return PendingIntent.getBroadcast(context, Integer.valueOf(requestCode).intValue(), intent, Integer.valueOf(flags).intValue());
    }

    public static /* synthetic */ RemoteViews showTeenagerWidgetView$default(Context context, HotListCardType hotListCardType, int i, Object obj) {
        if ((i & 2) != 0) {
            hotListCardType = HotListCardType.MIDDLE_CARD;
        }
        return showTeenagerWidgetView(context, hotListCardType);
    }

    public static final RemoteViews showTeenagerWidgetView(Context context, HotListCardType cardType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        return showRestrictedWidgetView(context, bili.resource.homepage.R.string.homepage_global_string_64, cardType);
    }

    public static /* synthetic */ RemoteViews showLessonsWidgetView$default(Context context, HotListCardType hotListCardType, int i, Object obj) {
        if ((i & 2) != 0) {
            hotListCardType = HotListCardType.MIDDLE_CARD;
        }
        return showLessonsWidgetView(context, hotListCardType);
    }

    public static final RemoteViews showLessonsWidgetView(Context context, HotListCardType cardType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        return showRestrictedWidgetView(context, bili.resource.homepage.R.string.homepage_global_string_60, cardType);
    }

    static /* synthetic */ RemoteViews showRestrictedWidgetView$default(Context context, int i, HotListCardType hotListCardType, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            hotListCardType = HotListCardType.MIDDLE_CARD;
        }
        return showRestrictedWidgetView(context, i, hotListCardType);
    }

    private static final RemoteViews showRestrictedWidgetView(Context context, int tipsId, HotListCardType cardType) {
        RemoteViews $this$showRestrictedWidgetView_u24lambda_u240 = new RemoteViews(context.getPackageName(), R.layout.bili_app_hot_list_widget);
        $this$showRestrictedWidgetView_u24lambda_u240.setViewVisibility(R.id.tv_tips, 0);
        $this$showRestrictedWidgetView_u24lambda_u240.setTextViewText(R.id.tv_tips, context.getString(tipsId));
        updateWidgetViewClick(context, true, $this$showRestrictedWidgetView_u24lambda_u240);
        $this$showRestrictedWidgetView_u24lambda_u240.setViewVisibility(R.id.container_search, 4);
        $this$showRestrictedWidgetView_u24lambda_u240.setViewVisibility(R.id.exchange, 4);
        $this$showRestrictedWidgetView_u24lambda_u240.removeAllViews(R.id.container_entrances);
        for (int index = 0; index < 3; index++) {
            if (index > 0) {
                $this$showRestrictedWidgetView_u24lambda_u240.addView(R.id.container_entrances, new RemoteViews(context.getPackageName(), R.layout.bili_include_widget_list_card_gap));
            }
            $this$showRestrictedWidgetView_u24lambda_u240.addView(R.id.container_entrances, createWidgetCard$default(context, null, 0, null, cardType, 14, null));
        }
        return $this$showRestrictedWidgetView_u24lambda_u240;
    }

    public static /* synthetic */ RemoteViews updateWidgetViewClick$default(Context context, boolean z, RemoteViews remoteViews, int i, Object obj) {
        if ((i & 4) != 0) {
            remoteViews = null;
        }
        return updateWidgetViewClick(context, z, remoteViews);
    }

    public static final RemoteViews updateWidgetViewClick(Context context, boolean isRestrictedMode, RemoteViews remoteViews) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        RemoteViews remoteViews2 = remoteViews == null ? new RemoteViews(context.getPackageName(), R.layout.bili_app_hot_list_widget) : remoteViews;
        RemoteViews $this$updateWidgetViewClick_u24lambda_u240 = remoteViews2;
        int i = R.id.container_search;
        if (isRestrictedMode) {
            str = "";
        } else {
            str = "activity://main/stardust-search";
        }
        $this$updateWidgetViewClick_u24lambda_u240.setOnClickPendingIntent(i, createIntent(context, str, REQUEST_CODE_SEARCH, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, RouterUtilKt.HOT_LIST_REPORT_SEARCH_BUSINESS)})));
        $this$updateWidgetViewClick_u24lambda_u240.setOnClickPendingIntent(R.id.container, createIntent(context, "", REQUEST_CODE_OPEN_MAIN, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, RouterUtilKt.HOT_LIST_REPORT_OTHER_BUSINESS)})));
        $this$updateWidgetViewClick_u24lambda_u240.setOnClickPendingIntent(R.id.brand, createIntent(context, "", REQUEST_CODE_OPEN_BILI_MAIN, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, RouterUtilKt.HOT_LIST_REPORT_BILI_BUSINESS)})));
        $this$updateWidgetViewClick_u24lambda_u240.setOnClickPendingIntent(R.id.exchange, createBroadcast(context, REQUEST_CODE_EXCHANGE));
        return remoteViews2;
    }

    static /* synthetic */ RemoteViews createWidgetCard$default(Context context, HotListWidgetItemModel hotListWidgetItemModel, int i, Bitmap bitmap, HotListCardType hotListCardType, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            hotListWidgetItemModel = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            bitmap = null;
        }
        if ((i2 & 16) != 0) {
            hotListCardType = HotListCardType.MIDDLE_CARD;
        }
        return createWidgetCard(context, hotListWidgetItemModel, i, bitmap, hotListCardType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RemoteViews createWidgetCard(Context context, HotListWidgetItemModel data, int index, Bitmap cover, HotListCardType cardType) {
        int iconDrawable;
        RemoteViews $this$createWidgetCard_u24lambda_u240 = new RemoteViews(context.getPackageName(), R.layout.bili_include_widget_list_card);
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.tv_title_1, ListExtentionsKt.toVisibility(cardType.getTitleLines() == 1));
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.tv_title_2, ListExtentionsKt.toVisibility(cardType.getTitleLines() == 2));
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.tv_title_3, ListExtentionsKt.toVisibility(cardType.getTitleLines() == 3));
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.fill_layout_1, ListExtentionsKt.toVisibility(!cardType.getHideFillLayout()));
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.fill_layout_2, ListExtentionsKt.toVisibility(!cardType.getHideFillLayout()));
        $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.fill_layout_3, ListExtentionsKt.toVisibility(!cardType.getHideFillLayout()));
        if (data != null) {
            $this$createWidgetCard_u24lambda_u240.setTextViewText(R.id.tv_view, data.getView());
            $this$createWidgetCard_u24lambda_u240.setTextViewText(R.id.tv_title_1, data.getTitle());
            $this$createWidgetCard_u24lambda_u240.setTextViewText(R.id.tv_title_2, data.getTitle());
            $this$createWidgetCard_u24lambda_u240.setTextViewText(R.id.tv_title_3, data.getTitle());
            $this$createWidgetCard_u24lambda_u240.setTextViewText(R.id.tv_name, data.getName());
            HotListWidgetRcmdModel rcmdReason = data.getRcmdReason();
            String content = rcmdReason != null ? rcmdReason.getContent() : null;
            if (content == null || StringsKt.isBlank(content)) {
                $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.tv_rcmd_reason, 8);
                if (!StringsKt.isBlank(data.getName())) {
                    $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.iv_up_icon, 0);
                }
            } else {
                $this$createWidgetCard_u24lambda_u240.setViewVisibility(R.id.tv_rcmd_reason, 0);
                int i = R.id.tv_rcmd_reason;
                HotListWidgetRcmdModel rcmdReason2 = data.getRcmdReason();
                $this$createWidgetCard_u24lambda_u240.setTextViewText(i, rcmdReason2 != null ? rcmdReason2.getContent() : null);
            }
            if (cover == null) {
                BLog.i(TAG, "cover is null.");
            } else {
                $this$createWidgetCard_u24lambda_u240.setImageViewBitmap(R.id.iv_cover, cover);
            }
            if (data.getViewIcon() == 33) {
                iconDrawable = com.bilibili.app.comm.baseres.R.drawable.ic_info_play_duration;
            } else {
                iconDrawable = com.bilibili.app.comm.baseres.R.drawable.ic_info_play_counts;
            }
            $this$createWidgetCard_u24lambda_u240.setImageViewResource(R.id.iv_play, iconDrawable);
            $this$createWidgetCard_u24lambda_u240.setOnClickPendingIntent(R.id.card_container, createIntent(context, data.getUri(), index + REQUEST_CODE_COVER, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, RouterUtilKt.HOT_LIST_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_PARAM_AVID, String.valueOf(data.getAvid())), TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_PARAM_INDEX, String.valueOf(index + 1))})));
        }
        return $this$createWidgetCard_u24lambda_u240;
    }

    private static final PendingIntent createIntent(Context context, String url, int requestCode, HashMap<String, String> hashMap) {
        int flags;
        if (Build.VERSION.SDK_INT >= 31) {
            flags = 201326592;
        } else {
            flags = 134217728;
        }
        BLog.i(TAG, "create pending intent " + url);
        Intent intent = new Intent(context, WidgetTransparentActivity.class);
        intent.setFlags(335544320);
        intent.putExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER, url);
        intent.putExtra(RouterUtilKt.HOT_LIST_REPORT_PARAMS, hashMap);
        intent.putExtra(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, RouterUtil.class.getName());
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(context, requestCode, intent, flags);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity, "let(...)");
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity;
    }

    private static final PendingIntent createBroadcast(Context context, int requestCode) {
        int flags;
        if (Build.VERSION.SDK_INT >= 31) {
            flags = 201326592;
        } else {
            flags = 134217728;
        }
        Intent intent = new Intent(context, HotListAppWidget.class);
        intent.setAction("tv.danmaku.bili.action.appwidget.EXCHANGE_CLICK");
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast(context, requestCode, intent, flags);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast, "getBroadcast(...)");
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getBroadcast;
    }
}