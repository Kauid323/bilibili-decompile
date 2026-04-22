package tv.danmaku.bili.appwidget.upcard.view;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.RouterUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardWidgetView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/widget/RemoteViews;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.view.UpCardWidgetViewKt$createUpCardWidgetView$2", f = "UpCardWidgetView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpCardWidgetViewKt$createUpCardWidgetView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViews>, Object> {
    final /* synthetic */ Bitmap $avatarBitmap;
    final /* synthetic */ UpCardType $cardType;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Bitmap> $coverBitmaps;
    final /* synthetic */ UpCardWidgetData $data;
    int label;

    /* compiled from: UpCardWidgetView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UpCardType.values().length];
            try {
                iArr[UpCardType.NO_LOGIN_CARD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[UpCardType.NO_UPDATE_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpCardWidgetViewKt$createUpCardWidgetView$2(UpCardType upCardType, Context context, UpCardWidgetData upCardWidgetData, List<Bitmap> list, Bitmap bitmap, Continuation<? super UpCardWidgetViewKt$createUpCardWidgetView$2> continuation) {
        super(2, continuation);
        this.$cardType = upCardType;
        this.$context = context;
        this.$data = upCardWidgetData;
        this.$coverBitmaps = list;
        this.$avatarBitmap = bitmap;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpCardWidgetViewKt$createUpCardWidgetView$2(this.$cardType, this.$context, this.$data, this.$coverBitmaps, this.$avatarBitmap, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RemoteViews> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PendingIntent createIntent;
        PendingIntent createIntent2;
        PendingIntent createIntent3;
        RemoteViews createWidgetCard;
        List<WidgetUpCard> widgetUpCards;
        String dynUnreadCnt;
        String it;
        PendingIntent createIntent4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                switch (WhenMappings.$EnumSwitchMapping$0[this.$cardType.ordinal()]) {
                    case 1:
                        RemoteViews $this$invokeSuspend_u24lambda_u240 = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_up_card_widget_block);
                        Context context = this.$context;
                        $this$invokeSuspend_u24lambda_u240.setTextViewText(R.id.title, context.getString(bili.resource.homepage.R.string.homepage_global_string_74));
                        $this$invokeSuspend_u24lambda_u240.setTextViewText(R.id.button, context.getString(bili.resource.homepage.R.string.homepage_global_string_61));
                        int i = R.id.button;
                        createIntent = UpCardWidgetViewKt.createIntent(context, "", 3511, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_OTHER_BUSINESS)}));
                        $this$invokeSuspend_u24lambda_u240.setOnClickPendingIntent(i, createIntent);
                        return $this$invokeSuspend_u24lambda_u240;
                    case 2:
                        RemoteViews $this$invokeSuspend_u24lambda_u241 = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_up_card_widget_block);
                        Context context2 = this.$context;
                        $this$invokeSuspend_u24lambda_u241.setTextViewText(R.id.title, context2.getString(bili.resource.homepage.R.string.homepage_global_string_20));
                        $this$invokeSuspend_u24lambda_u241.setTextViewText(R.id.button, context2.getString(bili.resource.homepage.R.string.homepage_global_string_36));
                        int i2 = R.id.button;
                        createIntent2 = UpCardWidgetViewKt.createIntent(context2, "", 3511, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_OTHER_BUSINESS)}));
                        $this$invokeSuspend_u24lambda_u241.setOnClickPendingIntent(i2, createIntent2);
                        return $this$invokeSuspend_u24lambda_u241;
                    default:
                        RemoteViews remoteViews = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_up_card_widget);
                        Context context3 = this.$context;
                        UpCardWidgetData upCardWidgetData = this.$data;
                        UpCardType upCardType = this.$cardType;
                        List<Bitmap> list = this.$coverBitmaps;
                        Bitmap bitmap = this.$avatarBitmap;
                        RemoteViews $this$invokeSuspend_u24lambda_u242 = remoteViews;
                        BLog.i("UpCardWidgetView", "createUpCardWidgetView");
                        $this$invokeSuspend_u24lambda_u242.removeAllViews(R.id.container_entrances);
                        UpCardWidgetViewKt.updateWidgetViewClick(context3, false, $this$invokeSuspend_u24lambda_u242, upCardWidgetData, upCardType);
                        $this$invokeSuspend_u24lambda_u242.setTextViewText(R.id.multi_card_title, upCardWidgetData != null ? upCardWidgetData.getTitle() : null);
                        int i3 = R.id.multi_card_title;
                        createIntent3 = UpCardWidgetViewKt.createIntent(context3, "bilibili://root?bottom_tab_id=dynamic&dynamic_tab_anchor=all", 3518, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_ALL_BUSINESS), TuplesKt.to("ivk_from", "widget-follow-double"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, ReportUtilKt.POS_FOLLOW_UPDATE), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, "false")}));
                        $this$invokeSuspend_u24lambda_u242.setOnClickPendingIntent(i3, createIntent3);
                        if (upCardWidgetData != null && (dynUnreadCnt = upCardWidgetData.getDynUnreadCnt()) != null && (it = ListExtentionsKt.takeIfNotEmpty(dynUnreadCnt)) != null) {
                            $this$invokeSuspend_u24lambda_u242.setTextViewText(R.id.multi_card_update_title, it);
                            $this$invokeSuspend_u24lambda_u242.setViewVisibility(R.id.multi_card_update_title, 0);
                            $this$invokeSuspend_u24lambda_u242.setViewVisibility(R.id.multi_card_red_dot, 0);
                            int i4 = R.id.multi_card_update_title;
                            createIntent4 = UpCardWidgetViewKt.createIntent(context3, "bilibili://root?bottom_tab_id=dynamic&dynamic_tab_anchor=all", 3519, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_ALL_BUSINESS), TuplesKt.to("ivk_from", "widget-follow-double"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, ReportUtilKt.POS_UPDATE), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE, "false")}));
                            $this$invokeSuspend_u24lambda_u242.setOnClickPendingIntent(i4, createIntent4);
                        } else {
                            $this$invokeSuspend_u24lambda_u242.setViewVisibility(R.id.multi_card_update_title, 8);
                            $this$invokeSuspend_u24lambda_u242.setViewVisibility(R.id.multi_card_red_dot, 8);
                        }
                        $this$invokeSuspend_u24lambda_u242.setImageViewResource(R.id.multi_card_more, R.drawable.ic_arrow_forward_right);
                        int index = 0;
                        int picNum = upCardType.getPicNum();
                        while (index < picNum) {
                            if (index > 0) {
                                $this$invokeSuspend_u24lambda_u242.addView(R.id.container_entrances, new RemoteViews(context3.getPackageName(), R.layout.bili_include_widget_up_card_gap));
                            }
                            int i5 = R.id.container_entrances;
                            RemoteViews $this$invokeSuspend_u24lambda_u2422 = $this$invokeSuspend_u24lambda_u242;
                            createWidgetCard = UpCardWidgetViewKt.createWidgetCard(context3, (upCardWidgetData == null || (widgetUpCards = upCardWidgetData.getWidgetUpCards()) == null) ? null : (WidgetUpCard) CollectionsKt.getOrNull(widgetUpCards, index), index, list != null ? (Bitmap) CollectionsKt.getOrNull(list, index) : null, upCardType, bitmap, upCardWidgetData != null ? upCardWidgetData.getWidgetMore() : null);
                            $this$invokeSuspend_u24lambda_u2422.addView(i5, createWidgetCard);
                            index++;
                            $this$invokeSuspend_u24lambda_u242 = $this$invokeSuspend_u24lambda_u2422;
                            list = list;
                        }
                        return remoteViews;
                }
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}