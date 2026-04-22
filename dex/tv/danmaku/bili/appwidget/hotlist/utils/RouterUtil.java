package tv.danmaku.bili.appwidget.hotlist.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.IAppWidgetRouter;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;

/* compiled from: RouterUtil.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/utils/RouterUtil;", "Ltv/danmaku/bili/appwidget/IAppWidgetRouter;", "<init>", "()V", "isFromOppoCard", "", "()Z", "setFromOppoCard", "(Z)V", "handleOnCreate", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "handleNewIntent", "handleWidgetIntent", "handleReport", "openMain", "router", "", "ivkFrom", "Ltv/danmaku/bili/appwidget/hotlist/utils/IVKFrom;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouterUtil implements IAppWidgetRouter {
    public static final int $stable = 8;
    private boolean isFromOppoCard;

    public final boolean isFromOppoCard() {
        return this.isFromOppoCard;
    }

    public final void setFromOppoCard(boolean z) {
        this.isFromOppoCard = z;
    }

    @Override // tv.danmaku.bili.appwidget.IAppWidgetRouter
    public void handleOnCreate(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(intent, "intent");
        handleWidgetIntent(activity, intent);
    }

    @Override // tv.danmaku.bili.appwidget.IAppWidgetRouter
    public void handleNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, AudioIntentHelper.FROM_ACTIVITY);
        Intrinsics.checkNotNullParameter(intent, "intent");
        handleWidgetIntent(activity, intent);
    }

    private final void handleWidgetIntent(Activity activity, Intent intent) {
        handleReport(intent);
        String router = intent.getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER);
        String str = router;
        boolean z = false;
        if (!(str == null || StringsKt.isBlank(str))) {
            Uri uri = Uri.parse(router);
            Uri.Builder uriBuilder = uri.buildUpon();
            String queryParameter = uri.getQueryParameter("from_spmid");
            if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
                uriBuilder.appendQueryParameter("from_spmid", this.isFromOppoCard ? RouterUtilKt.OPPO_HOT_LIST_WIDGET_SPMID : "main.widgets-page.0.0");
            }
            String queryParameter2 = uri.getQueryParameter("ivk_from");
            if (queryParameter2 == null || StringsKt.isBlank(queryParameter2)) {
                z = true;
            }
            if (z) {
                uriBuilder.appendQueryParameter("ivk_from", this.isFromOppoCard ? "plug_in_card" : "widget-card");
            }
            Uri newUri = uriBuilder.build();
            BLog.i("HotListAppWidgetRouter", "open router:" + newUri);
            Intrinsics.checkNotNull(newUri);
            BLRouter.routeTo(new RouteRequest.Builder(newUri).build(), activity);
            return;
        }
        openMain(activity, router, this.isFromOppoCard ? IVKFrom.OPPO_PLUGIN : IVKFrom.WIDGET_CARD);
    }

    private final void handleReport(Intent intent) {
        HashMap params;
        String opParams = intent.getStringExtra(RouterUtilKt.OPPO_HOT_LIST_REPORT_PARAMS);
        String str = opParams;
        this.isFromOppoCard = !(str == null || StringsKt.isBlank(str));
        if (this.isFromOppoCard) {
            Object fromJson = new Gson().fromJson(opParams, HashMap.class);
            Intrinsics.checkNotNull(fromJson);
            params = (HashMap) fromJson;
        } else {
            Serializable serializableExtra = intent.getSerializableExtra(RouterUtilKt.HOT_LIST_REPORT_PARAMS);
            params = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
            if (params == null) {
                return;
            }
        }
        Object obj = params.get(RouterUtilKt.HOT_LIST_REPORT_BUSINESS);
        if (Intrinsics.areEqual(obj, RouterUtilKt.HOT_LIST_REPORT_CARD_BUSINESS)) {
            Object obj2 = params.get(RouterUtilKt.HOT_LIST_REPORT_PARAM_AVID);
            if (obj2 == null) {
                obj2 = r6;
            }
            String avid = obj2.toString();
            Object obj3 = params.get(RouterUtilKt.HOT_LIST_REPORT_PARAM_INDEX);
            String pos = (obj3 != null ? obj3 : 0).toString();
            if (this.isFromOppoCard) {
                ReportUtilKt.reportOppoCardClick(avid, pos);
                ReportUtilKt.reportWidgetClick("plug_in_card", "video", avid, "ugc", pos);
                return;
            }
            ReportUtilKt.reportCardClick(avid, pos);
            ReportUtilKt.reportWidgetClick("widget-card", "video", avid, "ugc", pos);
        } else if (Intrinsics.areEqual(obj, RouterUtilKt.HOT_LIST_REPORT_SEARCH_BUSINESS)) {
            if (this.isFromOppoCard) {
                ReportUtilKt.reportOppoSearchClick();
                ReportUtilKt.reportWidgetClick$default("plug_in_card", "search", null, null, null, 28, null);
                return;
            }
            ReportUtilKt.reportSearchClick();
            ReportUtilKt.reportWidgetClick$default("widget-card", "search", null, null, null, 28, null);
        } else if (Intrinsics.areEqual(obj, RouterUtilKt.HOT_LIST_REPORT_OTHER_BUSINESS)) {
            if (this.isFromOppoCard) {
                if (intent.getIntExtra(RouterUtilKt.HOT_LIST_CLICK_BLOCK_PICTURE, 0) == 1) {
                    ReportUtilKt.reportOppoPictureClick();
                    ReportUtilKt.reportWidgetClick$default("plug_in_card", "picture", null, null, null, 28, null);
                    return;
                }
                ReportUtilKt.reportOppoOtherClick();
                ReportUtilKt.reportWidgetClick$default("plug_in_card", "other", null, null, null, 28, null);
                return;
            }
            ReportUtilKt.reportOtherClick();
            ReportUtilKt.reportWidgetClick$default("widget-card", "other", null, null, null, 28, null);
        } else if (Intrinsics.areEqual(obj, RouterUtilKt.HOT_LIST_REPORT_BILI_BUSINESS)) {
            if (this.isFromOppoCard) {
                ReportUtilKt.reportWidgetClick$default("plug_in_card", "bilibili", null, null, null, 28, null);
            } else {
                ReportUtilKt.reportWidgetClick$default("widget-card", "bilibili", null, null, null, 28, null);
            }
        }
    }

    private final void openMain(Activity activity, String router, IVKFrom ivkFrom) {
        String str = router;
        if (str == null || StringsKt.isBlank(str)) {
            RouterUtilKt.openMain(activity, ivkFrom);
            return;
        }
        BLog.i("HotListAppWidgetRouter", "open main by BLRouter.");
        BLRouter.routeTo(new RouteRequest.Builder(RouterUtilKt.appendIvkFromIfNotExist("bilibili://root", ivkFrom)).build(), activity);
    }
}