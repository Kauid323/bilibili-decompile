package tv.danmaku.bili.appwidget.upcard.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/appwidget/upcard/utils/RouterUtil;", "Ltv/danmaku/bili/appwidget/IAppWidgetRouter;", "<init>", "()V", "isFromSingleCard", "", "()Z", "setFromSingleCard", "(Z)V", "isFromSingleCardV2", "setFromSingleCardV2", "handleOnCreate", "", AudioIntentHelper.FROM_ACTIVITY, "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "handleNewIntent", "handleWidgetIntent", "handleReport", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RouterUtil implements IAppWidgetRouter {
    public static final int $stable = 8;
    private boolean isFromSingleCard;
    private boolean isFromSingleCardV2;

    public final boolean isFromSingleCard() {
        return this.isFromSingleCard;
    }

    public final void setFromSingleCard(boolean z) {
        this.isFromSingleCard = z;
    }

    public final boolean isFromSingleCardV2() {
        return this.isFromSingleCardV2;
    }

    public final void setFromSingleCardV2(boolean z) {
        this.isFromSingleCardV2 = z;
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
        IVKFrom ivkFrom;
        String str;
        handleReport(intent);
        String router = intent.getStringExtra(WidgetTransparentActivityKt.APP_WIDGET_ROUTER);
        String str2 = router;
        boolean z = false;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            Uri uri = Uri.parse(router);
            Uri.Builder uriBuilder = uri.buildUpon();
            String queryParameter = uri.getQueryParameter("from_spmid");
            if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
                uriBuilder.appendQueryParameter("from_spmid", "main.widgets-page.0.0");
            }
            String queryParameter2 = uri.getQueryParameter("ivk_from");
            if (queryParameter2 == null || StringsKt.isBlank(queryParameter2)) {
                z = true;
            }
            if (z) {
                if (this.isFromSingleCard) {
                    str = "widget-follow-single";
                } else if (this.isFromSingleCardV2) {
                    str = RouterUtilKt.IVK_FROM_WIDGET_UP_SINGLE_V2;
                } else {
                    str = "widget-follow-double";
                }
                uriBuilder.appendQueryParameter("ivk_from", str);
            }
            Uri newUri = uriBuilder.build();
            BLog.i("UpCardAppWidgetRouter", "open router:" + newUri);
            Intrinsics.checkNotNull(newUri);
            BLRouter.routeTo(new RouteRequest.Builder(newUri).build(), activity);
            return;
        }
        if (this.isFromSingleCard) {
            ivkFrom = IVKFrom.UP_SINGLE_PLUGIN;
        } else if (this.isFromSingleCardV2) {
            ivkFrom = IVKFrom.UP_SINGLE_PLUGIN_V2;
        } else {
            ivkFrom = IVKFrom.UP_DOUBLE_WIDGET_CARD;
        }
        RouterUtilKt.openMain(activity, ivkFrom);
    }

    private final void handleReport(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra(RouterUtilKt.UP_CARD_REPORT_PARAMS);
        HashMap params = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
        if (params == null) {
            return;
        }
        this.isFromSingleCard = Intrinsics.areEqual(params.get(RouterUtilKt.UP_CARD_SINGLE), "true");
        this.isFromSingleCardV2 = Intrinsics.areEqual(params.get(RouterUtilKt.UP_CARD_SINGLE_V2), "true");
        String str = (String) params.get(RouterUtilKt.UP_CARD_REPORT_BUSINESS);
        if (str != null) {
            switch (str.hashCode()) {
                case -2001740113:
                    if (str.equals(RouterUtilKt.UP_CARD_REPORT_OTHER_BUSINESS)) {
                        if (this.isFromSingleCard) {
                            ReportUtilKt.reportWidgetClick$default("widget-follow-single", "other", null, null, null, 28, null);
                            return;
                        } else {
                            ReportUtilKt.reportWidgetClick$default("widget-follow-double", "other", null, null, null, 28, null);
                            return;
                        }
                    }
                    return;
                case -1828677265:
                    if (str.equals(RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS)) {
                        String position = (String) params.get(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION);
                        if (position == null) {
                            position = "video";
                        }
                        String type = (String) params.get(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE);
                        if (type == null) {
                            type = "ugc";
                        }
                        Object obj = (String) params.get(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID);
                        if (obj == null) {
                            obj = 0;
                        }
                        String avid = obj.toString();
                        Object obj2 = (String) params.get(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX);
                        if (obj2 == null) {
                            obj2 = 0;
                        }
                        String pos = obj2.toString();
                        if (this.isFromSingleCard) {
                            ReportUtilKt.reportWidgetClick("widget-follow-single", position, avid, type, pos);
                            return;
                        } else if (this.isFromSingleCardV2) {
                            ReportUtilKt.reportWidgetClick(RouterUtilKt.IVK_FROM_WIDGET_UP_SINGLE_V2, position, avid, type, pos);
                            return;
                        } else {
                            ReportUtilKt.reportWidgetClick("widget-follow-double", position, avid, type, pos);
                            return;
                        }
                    }
                    return;
                case 242310974:
                    if (str.equals(RouterUtilKt.UP_CARD_REPORT_ALL_BUSINESS)) {
                        String from = String.valueOf(params.get("ivk_from"));
                        String position2 = (String) params.get(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION);
                        if (position2 == null) {
                            position2 = "other";
                        }
                        ReportUtilKt.reportWidgetClick$default(from, position2, null, null, null, 28, null);
                        return;
                    }
                    return;
                case 1142904522:
                    if (str.equals(RouterUtilKt.UP_CARD_REPORT_MORE_BUSINESS)) {
                        if (this.isFromSingleCard) {
                            ReportUtilKt.reportWidgetClick$default("widget-follow-single", ReportUtilKt.POS_MORE_FOLLOW, null, null, null, 28, null);
                            return;
                        } else {
                            ReportUtilKt.reportWidgetClick$default("widget-follow-double", ReportUtilKt.POS_MORE_FOLLOW, null, null, null, 28, null);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }
}