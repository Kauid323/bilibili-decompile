package tv.danmaku.bili.appwidget.hotlist.model;

import android.content.Context;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.base.BiliContext;
import com.bilibili.base.BiliContextKt;
import com.bilibili.base.util.DelayTaskController;
import com.google.gson.Gson;
import com.oplus.cardwidget.domain.pack.BaseDataPack;
import com.oplus.smartenginehelper.dsl.DSLCoder;
import com.oplus.smartenginehelper.entity.ClickEntity;
import com.oplus.smartenginehelper.entity.ContentProviderClickEntity;
import com.oplus.smartenginehelper.entity.StartActivityClickEntity;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.WidgetTransparentActivityKt;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtil;
import tv.danmaku.bili.appwidget.hotlist.utils.RouterUtilKt;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.quick.core.LoginSceneProcessor;

/* compiled from: HotListDataPacker.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J4\u0010\u000f\u001a\u00020\r2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/model/HotListDataPacker;", "Lcom/oplus/cardwidget/domain/pack/BaseDataPack;", "cardData", "Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;", "<init>", "(Ltv/danmaku/bili/appwidget/hotlist/model/HotListWidgetModel;)V", "onPack", "", "coder", "Lcom/oplus/smartenginehelper/dsl/DSLCoder;", "clickToHome", "", "id", "", "reportBusiness", "getReportParams", "params", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", LoginSceneProcessor.BIZ_KEY, "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HotListDataPacker extends BaseDataPack {
    public static final int CARD_COUNT = 3;
    public static final String METHOD_REFRESH = "refresh";
    public static final String URI_CLICK_HANDLER_CONTENT_PROVIDER = "content://tv.danmaku.bili.appwidget.hotlist.OpHotListHandlerProvider";
    public static final String URL_SEARCH_NEW = "activity://main/stardust-search";
    public static final String WIDGET_ACTIVITY_ACTION = "tv.danmaku.bili.WidgetTransparentActivity.action";
    private final HotListWidgetModel cardData;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public HotListDataPacker(HotListWidgetModel cardData) {
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        this.cardData = cardData;
    }

    public boolean onPack(DSLCoder coder) {
        String str;
        HotListWidgetItemModel hotListWidgetItemModel;
        HotListWidgetRcmdModel rcmdReason;
        HotListWidgetItemModel hotListWidgetItemModel2;
        String valueOf;
        HotListWidgetItemModel hotListWidgetItemModel3;
        HotListWidgetItemModel hotListWidgetItemModel4;
        HotListWidgetItemModel hotListWidgetItemModel5;
        HotListWidgetItemModel hotListWidgetItemModel6;
        HotListWidgetItemModel hotListWidgetItemModel7;
        HotListWidgetItemModel hotListWidgetItemModel8;
        HotListWidgetItemModel hotListWidgetItemModel9;
        HotListWidgetRcmdModel rcmdReason2;
        Intrinsics.checkNotNullParameter(coder, "coder");
        int index = 0;
        while (true) {
            str = "";
            if (index >= 3) {
                break;
            }
            int viewIndex = index + 1;
            List<HotListWidgetItemModel> items = this.cardData.getItems();
            String content = (items == null || (hotListWidgetItemModel9 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items, index)) == null || (rcmdReason2 = hotListWidgetItemModel9.getRcmdReason()) == null) ? null : rcmdReason2.getContent();
            if (content == null || StringsKt.isBlank(content)) {
                coder.setVisibility("tv_rcmd_reason_" + viewIndex, 8);
                coder.setVisibility("tv_icon_" + viewIndex, 0);
            } else {
                coder.setVisibility("tv_rcmd_reason_" + viewIndex, 0);
                coder.setVisibility("tv_icon_" + viewIndex, 8);
                String str2 = "tv_rcmd_reason_" + viewIndex;
                List<HotListWidgetItemModel> items2 = this.cardData.getItems();
                coder.setTextViewText(str2, (items2 == null || (hotListWidgetItemModel = (HotListWidgetItemModel) CollectionsKt.getOrNull(items2, index)) == null || (rcmdReason = hotListWidgetItemModel.getRcmdReason()) == null || (r14 = rcmdReason.getContent()) == null) ? "" : "");
            }
            List<HotListWidgetItemModel> items3 = this.cardData.getItems();
            if (items3 == null || items3.isEmpty()) {
                coder.setVisibility("tv_icon_" + viewIndex, 8);
            }
            String str3 = "tv_title_" + viewIndex;
            List<HotListWidgetItemModel> items4 = this.cardData.getItems();
            coder.setTextViewText(str3, (items4 == null || (hotListWidgetItemModel8 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items4, index)) == null || (r14 = hotListWidgetItemModel8.getTitle()) == null) ? "" : "");
            String str4 = "tv_up_" + viewIndex;
            List<HotListWidgetItemModel> items5 = this.cardData.getItems();
            coder.setTextViewText(str4, (items5 == null || (hotListWidgetItemModel7 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items5, index)) == null || (r14 = hotListWidgetItemModel7.getName()) == null) ? "" : "");
            String str5 = "tv_play_num_" + viewIndex;
            List<HotListWidgetItemModel> items6 = this.cardData.getItems();
            coder.setTextViewText(str5, (items6 == null || (hotListWidgetItemModel6 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items6, index)) == null || (r14 = hotListWidgetItemModel6.getView()) == null) ? "" : "");
            String str6 = ReportUtilKt.POS_COVER + viewIndex;
            List<HotListWidgetItemModel> items7 = this.cardData.getItems();
            coder.setImageViewResource(str6, String.valueOf((items7 == null || (hotListWidgetItemModel5 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items7, index)) == null) ? null : hotListWidgetItemModel5.getCoverFileUri()));
            List<HotListWidgetItemModel> items8 = this.cardData.getItems();
            int playIcon = items8 != null && (hotListWidgetItemModel4 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items8, index)) != null && hotListWidgetItemModel4.getViewIcon() == 33 ? R.drawable.ic_info_play_duration : R.drawable.ic_info_play_counts;
            coder.setImageViewResource("cover_play_icon_" + viewIndex, playIcon);
            ClickEntity startActivityClickEntity = new StartActivityClickEntity();
            startActivityClickEntity.setPackageName(BiliContextKt.getPackageName(BiliContext.INSTANCE));
            startActivityClickEntity.addFlag(335544320);
            startActivityClickEntity.setAction(WIDGET_ACTIVITY_ACTION);
            String name = RouterUtil.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            startActivityClickEntity.setParams(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, name);
            List<HotListWidgetItemModel> items9 = this.cardData.getItems();
            startActivityClickEntity.setParams(WidgetTransparentActivityKt.APP_WIDGET_ROUTER, (items9 == null || (hotListWidgetItemModel3 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items9, index)) == null || (r6 = hotListWidgetItemModel3.getUri()) == null) ? "" : "");
            Pair[] pairArr = new Pair[2];
            List<HotListWidgetItemModel> items10 = this.cardData.getItems();
            if (items10 != null && (hotListWidgetItemModel2 = (HotListWidgetItemModel) CollectionsKt.getOrNull(items10, index)) != null && (valueOf = String.valueOf(hotListWidgetItemModel2.getAvid())) != null) {
                str = valueOf;
            }
            pairArr[0] = TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_PARAM_AVID, str);
            pairArr[1] = TuplesKt.to(RouterUtilKt.HOT_LIST_REPORT_PARAM_INDEX, String.valueOf(index + 1));
            startActivityClickEntity.setParams(RouterUtilKt.OPPO_HOT_LIST_REPORT_PARAMS, getReportParams(MapsKt.hashMapOf(pairArr), RouterUtilKt.HOT_LIST_REPORT_CARD_BUSINESS));
            coder.setOnClick("video" + viewIndex, new ClickEntity[]{startActivityClickEntity});
            List<HotListWidgetItemModel> items11 = this.cardData.getItems();
            if (items11 == null || items11.isEmpty()) {
                coder.setVisibility("cover_play_icon_" + viewIndex, 8);
                coder.setVisibility("cover_gradient_" + viewIndex, 8);
                coder.setVisibility("tv_up_icon_" + viewIndex, 8);
            } else {
                coder.setVisibility("cover_play_icon_" + viewIndex, 0);
                coder.setVisibility("cover_gradient_" + viewIndex, 0);
                coder.setVisibility("tv_up_icon_" + viewIndex, 0);
            }
            index++;
        }
        List<HotListWidgetItemModel> items12 = this.cardData.getItems();
        coder.setVisibility("tv_no_content", ListExtentionsKt.toVisibility(items12 == null || items12.isEmpty()));
        Context application = BiliContext.application();
        Context context = application instanceof Context ? application : null;
        if (context != null) {
            Context context2 = context;
            if (SpUtilKt.isRestrictedTeenagerMode(context2)) {
                str = context2.getString(bili.resource.homepage.R.string.homepage_global_string_64);
            } else if (SpUtilKt.isRestrictedLessonMode(context2)) {
                str = context2.getString(bili.resource.homepage.R.string.homepage_global_string_60);
            }
            Intrinsics.checkNotNull(str);
            String restrictedText = str;
            coder.setTextViewText("tv_restricted_text", restrictedText);
        }
        clickToHome(coder, "container", RouterUtilKt.HOT_LIST_REPORT_OTHER_BUSINESS);
        clickToHome(coder, "brand", RouterUtilKt.HOT_LIST_REPORT_BILI_BUSINESS);
        ClickEntity startActivityClickEntity2 = new StartActivityClickEntity();
        startActivityClickEntity2.setPackageName(BiliContextKt.getPackageName(BiliContext.INSTANCE));
        startActivityClickEntity2.addFlag(335544320);
        startActivityClickEntity2.setAction(WIDGET_ACTIVITY_ACTION);
        String name2 = RouterUtil.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        startActivityClickEntity2.setParams(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, name2);
        startActivityClickEntity2.setParams(WidgetTransparentActivityKt.APP_WIDGET_ROUTER, URL_SEARCH_NEW);
        startActivityClickEntity2.setParams(RouterUtilKt.OPPO_HOT_LIST_REPORT_PARAMS, getReportParams(new HashMap<>(), RouterUtilKt.HOT_LIST_REPORT_SEARCH_BUSINESS));
        coder.setOnClick("search_input_container", new ClickEntity[]{startActivityClickEntity2});
        ClickEntity contentProviderClickEntity = new ContentProviderClickEntity();
        contentProviderClickEntity.setUri(URI_CLICK_HANDLER_CONTENT_PROVIDER);
        contentProviderClickEntity.setMethod(METHOD_REFRESH);
        coder.setOnClick("exchange", new ClickEntity[]{contentProviderClickEntity});
        return true;
    }

    private final void clickToHome(DSLCoder coder, String id, String reportBusiness) {
        ClickEntity startActivityClickEntity = new StartActivityClickEntity();
        startActivityClickEntity.setPackageName(BiliContextKt.getPackageName(BiliContext.INSTANCE));
        startActivityClickEntity.addFlag(268435456);
        startActivityClickEntity.setAction(WIDGET_ACTIVITY_ACTION);
        String name = RouterUtil.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        startActivityClickEntity.setParams(WidgetTransparentActivityKt.APP_WIDGET_BUSINESS_CLASS_NAME, name);
        startActivityClickEntity.setParams(RouterUtilKt.OPPO_HOT_LIST_REPORT_PARAMS, getReportParams(new HashMap<>(), reportBusiness));
        if (DelayTaskController.shouldBlock()) {
            startActivityClickEntity.setParams(RouterUtilKt.HOT_LIST_CLICK_BLOCK_PICTURE, "1");
        }
        coder.setOnClick(id, new ClickEntity[]{startActivityClickEntity});
    }

    private final String getReportParams(HashMap<String, String> hashMap, String business) {
        hashMap.put(RouterUtilKt.HOT_LIST_REPORT_BUSINESS, business);
        String json = new Gson().toJson(hashMap);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    /* compiled from: HotListDataPacker.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/appwidget/hotlist/model/HotListDataPacker$Companion;", "", "<init>", "()V", "CARD_COUNT", "", "URL_SEARCH_NEW", "", "URI_CLICK_HANDLER_CONTENT_PROVIDER", "METHOD_REFRESH", "WIDGET_ACTIVITY_ACTION", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}