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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.data.UpCardWidgetData;
import tv.danmaku.bili.appwidget.upcard.data.WidgetUpCard;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.upcard.utils.RouterUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UpCardWidgetView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/widget/RemoteViews;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.view.UpCardWidgetViewKt$showUpUpdateWidgetView$2", f = "UpCardWidgetView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UpCardWidgetViewKt$showUpUpdateWidgetView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViews>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Bitmap> $coverBitmaps;
    final /* synthetic */ UpCardWidgetData $data;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UpCardWidgetViewKt$showUpUpdateWidgetView$2(Context context, UpCardWidgetData upCardWidgetData, List<Bitmap> list, Continuation<? super UpCardWidgetViewKt$showUpUpdateWidgetView$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$data = upCardWidgetData;
        this.$coverBitmaps = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UpCardWidgetViewKt$showUpUpdateWidgetView$2(this.$context, this.$data, this.$coverBitmaps, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RemoteViews> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        UpCardWidgetData upCardWidgetData;
        RemoteViews $this$invokeSuspend_u24lambda_u240;
        String str;
        PendingIntent createIntent;
        List<WidgetUpCard> widgetUpCards;
        WidgetUpCard widgetUpCard;
        Long avId;
        String valueOf;
        List<Bitmap> list;
        WidgetUpCard widgetUpCard2;
        PendingIntent createIntent2;
        PendingIntent createIntent3;
        PendingIntent createIntent4;
        Bitmap bitmap;
        String desc;
        String origin;
        String type;
        String type2;
        PendingIntent createIntent5;
        WidgetUpCard widgetUpCard3;
        Long avId2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                RemoteViews $this$invokeSuspend_u24lambda_u2402 = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_up_card_update_v2);
                UpCardWidgetData it = this.$data;
                Context context = this.$context;
                List<Bitmap> list2 = this.$coverBitmaps;
                if (it == null) {
                    upCardWidgetData = it;
                    $this$invokeSuspend_u24lambda_u240 = $this$invokeSuspend_u24lambda_u2402;
                    str = "";
                } else {
                    String title = it.getTitle();
                    if (title != null && (type2 = ListExtentionsKt.takeIfNotBlank(title)) != null) {
                        str = "";
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_top_title, 0);
                        $this$invokeSuspend_u24lambda_u2402.setTextViewText(R.id.left_top_title, type2);
                        int i = R.id.left_top_title;
                        upCardWidgetData = it;
                        Pair[] pairArr = new Pair[6];
                        list = list2;
                        pairArr[0] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS);
                        List<WidgetUpCard> widgetUpCards2 = it.getWidgetUpCards();
                        pairArr[1] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, (widgetUpCards2 == null || (widgetUpCard3 = (WidgetUpCard) CollectionsKt.getOrNull(widgetUpCards2, 0)) == null || (avId2 = widgetUpCard3.getAvId()) == null || (r5 = String.valueOf(avId2.longValue())) == null) ? "0" : "0");
                        pairArr[2] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, "1");
                        pairArr[3] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, ReportUtilKt.POS_OGV_UPDATE);
                        pairArr[4] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE, ReportUtilKt.CONTENT_TYPE_OGV);
                        pairArr[5] = TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE_V2, "true");
                        createIntent5 = UpCardWidgetViewKt.createIntent(context, "bilibili://user_center/favourite2?default_tab_id=105", 3517, MapsKt.hashMapOf(pairArr));
                        $this$invokeSuspend_u24lambda_u2402.setOnClickPendingIntent(i, createIntent5);
                    } else {
                        upCardWidgetData = it;
                        list = list2;
                        str = "";
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_top_title, 8);
                    }
                    String desc2 = it.getDesc();
                    if (desc2 != null && (type = ListExtentionsKt.takeIfNotBlank(desc2)) != null) {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_center_update_progress, 0);
                        $this$invokeSuspend_u24lambda_u2402.setTextViewText(R.id.left_center_update_progress, type);
                    } else {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_center_update_progress, 8);
                    }
                    String content = it.getContent();
                    if (content != null && (origin = ListExtentionsKt.takeIfNotBlank(content)) != null) {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_center_title, 0);
                        $this$invokeSuspend_u24lambda_u2402.setTextViewText(R.id.left_center_title, origin);
                    } else {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.left_center_title, 8);
                    }
                    String onlineViewersCnt = it.getOnlineViewersCnt();
                    if (onlineViewersCnt != null && (desc = ListExtentionsKt.takeIfNotBlank(onlineViewersCnt)) != null) {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.online_person_container, 0);
                        $this$invokeSuspend_u24lambda_u2402.setTextViewText(R.id.left_center_online_person, desc);
                        $this$invokeSuspend_u24lambda_u2402.setImageViewResource(R.id.iv_person, R.drawable.ic_person_online_number_line);
                    } else {
                        $this$invokeSuspend_u24lambda_u2402.setViewVisibility(R.id.online_person_container, 8);
                    }
                    List<WidgetUpCard> widgetUpCards3 = it.getWidgetUpCards();
                    if (widgetUpCards3 == null || (widgetUpCard2 = (WidgetUpCard) CollectionsKt.getOrNull(widgetUpCards3, 0)) == null) {
                        $this$invokeSuspend_u24lambda_u240 = $this$invokeSuspend_u24lambda_u2402;
                    } else {
                        String uri = widgetUpCard2.getUri();
                        if (uri == null) {
                            uri = str;
                        }
                        int i2 = R.id.left_center_title;
                        Integer boxInt = Boxing.boxInt(3518);
                        boxInt.intValue();
                        if (StringsKt.isBlank(uri)) {
                            boxInt = null;
                        }
                        createIntent2 = UpCardWidgetViewKt.createIntent(context, uri, boxInt != null ? boxInt.intValue() : 3511, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, String.valueOf(widgetUpCard2.getAvId())), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, "1"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, ReportUtilKt.POS_TITLE), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE, ReportUtilKt.CONTENT_TYPE_OGV), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE_V2, "true")}));
                        $this$invokeSuspend_u24lambda_u2402.setOnClickPendingIntent(i2, createIntent2);
                        int i3 = R.id.iv_cover;
                        Integer boxInt2 = Boxing.boxInt(3519);
                        boxInt2.intValue();
                        if (StringsKt.isBlank(uri)) {
                            boxInt2 = null;
                        }
                        createIntent3 = UpCardWidgetViewKt.createIntent(context, uri, boxInt2 != null ? boxInt2.intValue() : 3511, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, String.valueOf(widgetUpCard2.getAvId())), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, "1"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, ReportUtilKt.POS_COVER), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE, ReportUtilKt.CONTENT_TYPE_OGV), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE_V2, "true")}));
                        $this$invokeSuspend_u24lambda_u2402.setOnClickPendingIntent(i3, createIntent3);
                        int i4 = R.id.container;
                        Integer boxInt3 = Boxing.boxInt(3520);
                        boxInt3.intValue();
                        Integer num = !StringsKt.isBlank(uri) ? boxInt3 : null;
                        createIntent4 = UpCardWidgetViewKt.createIntent(context, uri, num != null ? num.intValue() : 3511, MapsKt.hashMapOf(new Pair[]{TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, String.valueOf(widgetUpCard2.getAvId())), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, "1"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, "other"), TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE, ReportUtilKt.CONTENT_TYPE_OGV), TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE_V2, "true")}));
                        $this$invokeSuspend_u24lambda_u240 = $this$invokeSuspend_u24lambda_u2402;
                        $this$invokeSuspend_u24lambda_u240.setOnClickPendingIntent(i4, createIntent4);
                        if (list != null && (bitmap = (Bitmap) CollectionsKt.getOrNull(list, 0)) != null) {
                            $this$invokeSuspend_u24lambda_u240.setImageViewBitmap(R.id.iv_cover, bitmap);
                        }
                    }
                }
                int i5 = R.id.brand;
                Pair[] pairArr2 = new Pair[6];
                pairArr2[0] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_BUSINESS, RouterUtilKt.UP_CARD_REPORT_CARD_BUSINESS);
                pairArr2[1] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_AVID, (upCardWidgetData == null || (widgetUpCards = upCardWidgetData.getWidgetUpCards()) == null || (widgetUpCard = (WidgetUpCard) CollectionsKt.getOrNull(widgetUpCards, 0)) == null || (avId = widgetUpCard.getAvId()) == null || (valueOf = String.valueOf(avId.longValue())) == null) ? "0" : valueOf);
                pairArr2[2] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_INDEX, "1");
                pairArr2[3] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_POSITION, "bilibili");
                pairArr2[4] = TuplesKt.to(RouterUtilKt.UP_CARD_REPORT_PARAM_TYPE, ReportUtilKt.CONTENT_TYPE_OGV);
                pairArr2[5] = TuplesKt.to(RouterUtilKt.UP_CARD_SINGLE_V2, "true");
                createIntent = UpCardWidgetViewKt.createIntent(context, str, 3511, MapsKt.hashMapOf(pairArr2));
                $this$invokeSuspend_u24lambda_u240.setOnClickPendingIntent(i5, createIntent);
                return $this$invokeSuspend_u24lambda_u2402;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}