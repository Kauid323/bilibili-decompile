package tv.danmaku.bili.appwidget.upcard.view;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.RemoteViews;
import bili.resource.homepage.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.infra.base.aop.PendingIntentCreateHook;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.WidgetTransparentActivity;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.appwidget.upcard.data.Owner;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetMore;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;
import tv.danmaku.bili.appwidget.upcard.utils.IVKFrom;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.RouterUtil;
import tv.danmaku.bili.appwidget.upcard.utils.RouterUtilKt;

/* compiled from: UpCardWidgetView.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014\u001aF\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010 \u001a\u000e\u0010!\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u000e\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a2\u0010&\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001cH\u0086@¢\u0006\u0002\u0010'\u001a?\u0010(\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0001\u0010)\u001a\u00020\u00032\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010-\u001a4\u0010.\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00142\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u0010\u001aT\u00101\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u0001022\b\b\u0002\u00103\u001a\u00020\u00032\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00102\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u00106\u001a\u0004\u0018\u000107H\u0002\u001aJ\u00108\u001a\u0002092\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010+\u001a\u0004\u0018\u00010\u00012\u0006\u0010:\u001a\u00020\u00032&\u0010;\u001a\"\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010<j\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u0001`=H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"TAG", "", "UP_CARD_APP_NORMAL_STATUS", "", "UP_CARD_APP_BLOCK_STATUS", "UP_CARD_APP_TEENAGER_STATUS", "UP_CARD_APP_LESSONS_STATUS", "UP_CARD_APP_NO_UPDATE_STATUS", "UP_CARD_APP_UP_UPDATE_STATUS", "UP_CARD_APP_UNKNOWN_ERROR_STATUS", "REQUEST_CODE_OPEN_MAIN", "REQUEST_CODE_COVER", "LOGIN_URL", "DYNAMIC_HOME_URL", "FAVOURITE2_OGV_URL", "getUpCardType", "Ltv/danmaku/bili/appwidget/upcard/view/UpCardType;", "cardCount", "style", "large", "", "createUpCardWidgetView", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "data", "Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;", "coverBitmaps", "", "Landroid/graphics/Bitmap;", "cardType", "avatarBitmap", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;Ljava/util/List;Ltv/danmaku/bili/appwidget/upcard/view/UpCardType;Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showBlockWidgetView", "showTeenagerWidgetView", "showLessonsWidgetView", "showErrorWidgetView", "showNoUpdateWidgetView", "showUpUpdateWidgetView", "(Landroid/content/Context;Ltv/danmaku/bili/appwidget/upcard/data/UpCardWidgetData;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showRestrictedWidgetView", "tipsId", "buttonId", "url", "from", "(Landroid/content/Context;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Landroid/widget/RemoteViews;", "updateWidgetViewClick", "isRestrictedMode", "remoteViews", "createWidgetCard", "Ltv/danmaku/bili/appwidget/upcard/data/WidgetUpCard;", "index", ReportUtilKt.POS_COVER, "coverAvatar", "widgetMore", "Ltv/danmaku/bili/appwidget/upcard/data/WidgetMore;", "createIntent", "Landroid/app/PendingIntent;", "requestCode", "reportParams", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UpCardWidgetViewKt {
    private static final String DYNAMIC_HOME_URL = "bilibili://root?bottom_tab_id=dynamic&dynamic_tab_anchor=all";
    private static final String FAVOURITE2_OGV_URL = "bilibili://user_center/favourite2?default_tab_id=105";
    public static final String LOGIN_URL = "bilibili://login";
    private static final int REQUEST_CODE_COVER = 3512;
    private static final int REQUEST_CODE_OPEN_MAIN = 3511;
    private static final String TAG = "UpCardWidgetView";
    public static final int UP_CARD_APP_BLOCK_STATUS = 1;
    public static final int UP_CARD_APP_LESSONS_STATUS = 3;
    public static final int UP_CARD_APP_NORMAL_STATUS = 0;
    public static final int UP_CARD_APP_NO_UPDATE_STATUS = 4;
    public static final int UP_CARD_APP_TEENAGER_STATUS = 2;
    public static final int UP_CARD_APP_UNKNOWN_ERROR_STATUS = 6;
    public static final int UP_CARD_APP_UP_UPDATE_STATUS = 5;

    /* compiled from: UpCardWidgetView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpCardType.values().length];
            try {
                iArr[UpCardType.TWO_PIC_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UpCardType.TWO_PIC_CARD_L.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[UpCardType.ONE_PIC_CARD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[UpCardType.ONE_PIC_CARD_L.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

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

    public static final UpCardType getUpCardType(int cardCount, int style, boolean large) {
        if (style == 6) {
            return UpCardType.ONE_PIC_CARD_V2;
        }
        if (large) {
            switch (cardCount) {
                case 1:
                    return UpCardType.ONE_PIC_CARD_L;
                case 2:
                    return UpCardType.TWO_PIC_CARD_L;
                default:
                    return UpCardType.NO_LOGIN_CARD;
            }
        }
        switch (cardCount) {
            case 1:
                return UpCardType.ONE_PIC_CARD;
            case 2:
                return UpCardType.TWO_PIC_CARD;
            default:
                return UpCardType.NO_LOGIN_CARD;
        }
    }

    public static /* synthetic */ Object createUpCardWidgetView$default(Context context, UpCardWidgetData upCardWidgetData, List list, UpCardType upCardType, Bitmap bitmap, Continuation continuation, int i, Object obj) {
        Bitmap bitmap2;
        if ((i & 16) == 0) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = null;
        }
        return createUpCardWidgetView(context, upCardWidgetData, list, upCardType, bitmap2, continuation);
    }

    public static final Object createUpCardWidgetView(Context context, UpCardWidgetData data, List<Bitmap> list, UpCardType cardType, Bitmap avatarBitmap, Continuation<? super RemoteViews> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UpCardWidgetViewKt$createUpCardWidgetView$2(cardType, context, data, list, avatarBitmap, null), continuation);
    }

    public static final RemoteViews showBlockWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return showRestrictedWidgetView(context, R.string.homepage_global_string_74, Integer.valueOf(R.string.homepage_global_string_61), RouterUtilKt.appendIvkFromIfNotExist("bilibili://login", IVKFrom.UP_NO_LOGIN_WIDGET_CARD), RouterUtilKt.IVK_FORM_WIDGET_UP_NO_LOGIN);
    }

    public static final RemoteViews showTeenagerWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return showRestrictedWidgetView$default(context, R.string.homepage_global_string_46, null, RouterUtilKt.appendIvkFromIfNotExist("bilibili://root", IVKFrom.UP_TEEN_MODE_WIDGET_CARD), RouterUtilKt.IVK_FORM_WIDGET_UP_TEEN_MODE, 4, null);
    }

    public static final RemoteViews showLessonsWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return showRestrictedWidgetView$default(context, R.string.homepage_global_string_67, null, RouterUtilKt.appendIvkFromIfNotExist("bilibili://root", IVKFrom.UP_LESSON_MODE_WIDGET_CARD), RouterUtilKt.IVK_FORM_WIDGET_UP_LESSON_MODE, 4, null);
    }

    public static final RemoteViews showErrorWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RemoteViews $this$showErrorWidgetView_u24lambda_u240 = new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_app_up_card_widget_error);
        $this$showErrorWidgetView_u24lambda_u240.setOnClickPendingIntent(tv.danmaku.bili.R.id.container, createIntent(context, RouterUtilKt.appendIvkFromIfNotExist("bilibili://root", IVKFrom.UP_NO_UPDATE_WIDGET_CARD), REQUEST_CODE_OPEN_MAIN, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_ALL_BUSINESS), TuplesKt.to("ivk_from", RouterUtilKt.IVK_FORM_WIDGET_UP_NO_UPDATE)})));
        return $this$showErrorWidgetView_u24lambda_u240;
    }

    public static final RemoteViews showNoUpdateWidgetView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return showRestrictedWidgetView$default(context, R.string.homepage_global_string_20, null, RouterUtilKt.appendIvkFromIfNotExist("bilibili://root", IVKFrom.UP_NO_UPDATE_WIDGET_CARD), RouterUtilKt.IVK_FORM_WIDGET_UP_NO_UPDATE, 4, null);
    }

    public static final Object showUpUpdateWidgetView(Context context, UpCardWidgetData data, List<Bitmap> list, Continuation<? super RemoteViews> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UpCardWidgetViewKt$showUpUpdateWidgetView$2(context, data, list, null), continuation);
    }

    static /* synthetic */ RemoteViews showRestrictedWidgetView$default(Context context, int i, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        return showRestrictedWidgetView(context, i, num, str, str2);
    }

    private static final RemoteViews showRestrictedWidgetView(Context context, int tipsId, Integer buttonId, String url, String from) {
        RemoteViews $this$showRestrictedWidgetView_u24lambda_u240 = new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_app_up_card_widget_block);
        $this$showRestrictedWidgetView_u24lambda_u240.setTextViewText(tv.danmaku.bili.R.id.title, context.getString(tipsId));
        $this$showRestrictedWidgetView_u24lambda_u240.setTextViewText(tv.danmaku.bili.R.id.button, context.getString(buttonId != null ? buttonId.intValue() : R.string.homepage_global_string_36));
        $this$showRestrictedWidgetView_u24lambda_u240.setOnClickPendingIntent(tv.danmaku.bili.R.id.container, createIntent(context, url == null ? "" : url, REQUEST_CODE_OPEN_MAIN, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_ALL_BUSINESS), TuplesKt.to("ivk_from", from)})));
        return $this$showRestrictedWidgetView_u24lambda_u240;
    }

    public static /* synthetic */ RemoteViews updateWidgetViewClick$default(Context context, boolean z, RemoteViews remoteViews, UpCardWidgetData upCardWidgetData, UpCardType upCardType, int i, Object obj) {
        if ((i & 4) != 0) {
            remoteViews = null;
        }
        return updateWidgetViewClick(context, z, remoteViews, upCardWidgetData, upCardType);
    }

    public static final RemoteViews updateWidgetViewClick(Context context, boolean isRestrictedMode, RemoteViews remoteViews, UpCardWidgetData data, UpCardType cardType) {
        WidgetMore widgetMore;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        RemoteViews remoteViews2 = remoteViews == null ? new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_app_up_card_widget) : remoteViews;
        RemoteViews $this$updateWidgetViewClick_u24lambda_u240 = remoteViews2;
        int i = tv.danmaku.bili.R.id.container;
        String str = (data == null || (widgetMore = data.getWidgetMore()) == null || (str = widgetMore.getUri()) == null) ? "" : "";
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_OTHER_BUSINESS);
        pairArr[1] = TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, cardType.getPicNum() == 1 ? "true" : "false");
        $this$updateWidgetViewClick_u24lambda_u240.setOnClickPendingIntent(i, createIntent(context, str, REQUEST_CODE_OPEN_MAIN, MapsKt.hashMapOf(pairArr)));
        return remoteViews2;
    }

    static /* synthetic */ RemoteViews createWidgetCard$default(Context context, WidgetUpCard widgetUpCard, int i, Bitmap bitmap, UpCardType upCardType, Bitmap bitmap2, WidgetMore widgetMore, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            widgetUpCard = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        if ((i2 & 8) != 0) {
            bitmap = null;
        }
        if ((i2 & 16) != 0) {
            upCardType = UpCardType.ONE_PIC_CARD;
        }
        if ((i2 & 32) != 0) {
            bitmap2 = null;
        }
        if ((i2 & 64) != 0) {
            widgetMore = null;
        }
        return createWidgetCard(context, widgetUpCard, i, bitmap, upCardType, bitmap2, widgetMore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a9, code lost:
        if (r18 == null) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final RemoteViews createWidgetCard(Context context, WidgetUpCard data, int index, Bitmap cover, UpCardType cardType, Bitmap coverAvatar, WidgetMore widgetMore) {
        String name;
        String it;
        RemoteViews remoteViews;
        String face;
        String uri;
        String it2;
        String title;
        String it3;
        String name2;
        String it4;
        switch (WhenMappings.$EnumSwitchMapping$0[cardType.ordinal()]) {
            case 1:
            case 2:
                RemoteViews $this$createWidgetCard_u24lambda_u240 = new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_include_widget_up_card2);
                if (data != null) {
                    $this$createWidgetCard_u24lambda_u240.setTextViewText(tv.danmaku.bili.R.id.tv_title_1, data.getTitle());
                    if (cover != null) {
                        $this$createWidgetCard_u24lambda_u240.setImageViewBitmap(tv.danmaku.bili.R.id.iv_cover, cover);
                    } else {
                        BLog.i(TAG, "cover is null.");
                    }
                    Owner owner = data.getOwner();
                    if (owner == null || (name = owner.getName()) == null || (it = ListExtentionsKt.takeIfNotBlank(name)) == null) {
                        $this$createWidgetCard_u24lambda_u240.setViewVisibility(tv.danmaku.bili.R.id.iv_up_icon, 8);
                        $this$createWidgetCard_u24lambda_u240.setTextViewText(tv.danmaku.bili.R.id.tv_name, "");
                    } else {
                        $this$createWidgetCard_u24lambda_u240.setViewVisibility(tv.danmaku.bili.R.id.iv_up_icon, 0);
                        $this$createWidgetCard_u24lambda_u240.setTextViewText(tv.danmaku.bili.R.id.tv_name, it);
                    }
                    $this$createWidgetCard_u24lambda_u240.setOnClickPendingIntent(tv.danmaku.bili.R.id.card_container, createIntent(context, data.getUri(), index + REQUEST_CODE_COVER, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, String.valueOf(data.getAvId())), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, String.valueOf(index + 1)), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, "false")})));
                    return $this$createWidgetCard_u24lambda_u240;
                }
                return $this$createWidgetCard_u24lambda_u240;
            case 3:
            case 4:
                RemoteViews $this$createWidgetCard_u24lambda_u241 = new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_include_widget_up_card1);
                if (data == null) {
                    remoteViews = $this$createWidgetCard_u24lambda_u241;
                } else {
                    Owner owner2 = data.getOwner();
                    Unit unit = null;
                    Long mid = owner2 != null ? owner2.getMid() : null;
                    if (mid != null && mid.longValue() == 0) {
                        $this$createWidgetCard_u24lambda_u241.setImageViewResource(tv.danmaku.bili.R.id.avatar, tv.danmaku.bili.R.drawable.ic_avatar_default_round);
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.tv_name, context.getResources().getString(bili.resource.settings.R.string.settings_global_string_233));
                        remoteViews = $this$createWidgetCard_u24lambda_u241;
                    } else {
                        Owner owner3 = data.getOwner();
                        if (owner3 != null && (face = owner3.getFace()) != null && ListExtentionsKt.takeIfNotBlank(face) != null) {
                            remoteViews = $this$createWidgetCard_u24lambda_u241;
                            $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.iv_up_icon, 0);
                            if (coverAvatar == null) {
                                break;
                            } else {
                                $this$createWidgetCard_u24lambda_u241.setImageViewBitmap(tv.danmaku.bili.R.id.avatar, coverAvatar);
                                unit = Unit.INSTANCE;
                                break;
                            }
                        } else {
                            remoteViews = $this$createWidgetCard_u24lambda_u241;
                        }
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.iv_up_icon, 0);
                    }
                    Owner owner4 = data.getOwner();
                    if (owner4 != null && (name2 = owner4.getName()) != null && (it4 = ListExtentionsKt.takeIfNotBlank(name2)) != null) {
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.tv_name, it4);
                    }
                    String it5 = data.getDuration();
                    if (it5 != null) {
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.duration, it5);
                    }
                    if (widgetMore == null || (title = widgetMore.getTitle()) == null || (it3 = ListExtentionsKt.takeIfNotBlank(title)) == null) {
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.button, 8);
                    } else {
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.button, it3);
                    }
                    if (widgetMore != null && (uri = widgetMore.getUri()) != null && (it2 = ListExtentionsKt.takeIfNotBlank(uri)) != null) {
                        $this$createWidgetCard_u24lambda_u241.setOnClickPendingIntent(tv.danmaku.bili.R.id.button, createIntent(context, it2, 3515, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_MORE_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, "true")})));
                    }
                    if (cover != null) {
                        $this$createWidgetCard_u24lambda_u241.setImageViewBitmap(tv.danmaku.bili.R.id.iv_cover, cover);
                    } else {
                        BLog.i(TAG, "cover is null.");
                    }
                    if (cardType.getTitleLines() == 3) {
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.tv_title_3, 0);
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.tv_title_2, 8);
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.tv_title_3, data.getTitle());
                    } else {
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.tv_title_3, 8);
                        $this$createWidgetCard_u24lambda_u241.setViewVisibility(tv.danmaku.bili.R.id.tv_title_2, 0);
                        $this$createWidgetCard_u24lambda_u241.setTextViewText(tv.danmaku.bili.R.id.tv_title_2, data.getTitle());
                    }
                    $this$createWidgetCard_u24lambda_u241.setOnClickPendingIntent(tv.danmaku.bili.R.id.card_container, createIntent(context, data.getUri(), index + REQUEST_CODE_COVER, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, String.valueOf(data.getAvId())), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, String.valueOf(index + 1)), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, "true")})));
                }
                return remoteViews;
            default:
                return new RemoteViews(context.getPackageName(), tv.danmaku.bili.R.layout.bili_include_widget_up_card2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PendingIntent createIntent(Context context, String url, int requestCode, HashMap<String, String> hashMap) {
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
        intent.putExtra(RouterUtilKt.UP_CARD_REPORT_PARAMS, hashMap);
        intent.putExtra(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, RouterUtil.class.getName());
        PendingIntent __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity = __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity(context, requestCode, intent, flags);
        Intrinsics.checkNotNullExpressionValue(__Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity, "let(...)");
        return __Ghost$Insertion$com_bilibili_infra_base_aop_PendingIntentCreateHook_getActivity;
    }
}