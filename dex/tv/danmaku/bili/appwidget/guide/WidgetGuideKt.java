package tv.danmaku.bili.appwidget.guide;

import com.bapis.bilibili.app.show.mixture.v1.GuideCard;
import com.bapis.bilibili.app.show.mixture.v1.GuideItem;
import com.bapis.bilibili.app.show.mixture.v1.KGuideCard;
import com.bapis.bilibili.app.show.mixture.v1.KGuideItem;
import com.bapis.bilibili.app.show.mixture.v1.WidgetGuideReply;
import com.bilibili.moduleservice.appwidget.GuideScene;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: WidgetGuide.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a\u000e\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"TAG", "", "suspendWidgetGuide", "Lcom/bapis/bilibili/app/show/mixture/v1/WidgetGuideReply;", "scene", "Lcom/bilibili/moduleservice/appwidget/GuideScene;", "(Lcom/bilibili/moduleservice/appwidget/GuideScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWidgetGuideFrequency", "", ReportEvent.EVENT_TYPE_SHOW, "", "convert", "Lcom/bapis/bilibili/app/show/mixture/v1/GuideItem;", "Lcom/bapis/bilibili/app/show/mixture/v1/KGuideItem;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class WidgetGuideKt {
    private static final String TAG = "WidgetGuide";

    public static final Object suspendWidgetGuide(GuideScene scene, Continuation<? super WidgetGuideReply> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new WidgetGuideKt$suspendWidgetGuide$2(scene, null), continuation);
    }

    public static final Object updateWidgetGuideFrequency(GuideScene scene, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new WidgetGuideKt$updateWidgetGuideFrequency$2(scene, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public static final boolean show(WidgetGuideReply $this$show) {
        return $this$show != null && $this$show.getCode() == 200;
    }

    public static final GuideItem convert(KGuideItem $this$convert) {
        Intrinsics.checkNotNullParameter($this$convert, "<this>");
        GuideItem.Builder guideItemBuilder = GuideItem.newBuilder();
        guideItemBuilder.setTitle($this$convert.getTitle());
        Iterable $this$forEachIndexed$iv = $this$convert.getCard();
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KGuideCard card = (KGuideCard) item$iv;
            guideItemBuilder.addCard(index, GuideCard.newBuilder().setImage(card.getImage()).setSubtitle(card.getSubtitle()).build());
            index = index$iv;
        }
        GuideItem build = guideItemBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}