package tv.danmaku.bili.appwidget.hotlist.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotListWidgetView.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/widget/RemoteViews;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.view.HotListWidgetViewKt$createHotListWidgetView$2", f = "HotListWidgetView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HotListWidgetViewKt$createHotListWidgetView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RemoteViews>, Object> {
    final /* synthetic */ HotListCardType $cardType;
    final /* synthetic */ Context $context;
    final /* synthetic */ List<Bitmap> $coverBitmaps;
    final /* synthetic */ HotListWidgetModel $data;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotListWidgetViewKt$createHotListWidgetView$2(Context context, HotListWidgetModel hotListWidgetModel, List<Bitmap> list, HotListCardType hotListCardType, Continuation<? super HotListWidgetViewKt$createHotListWidgetView$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$data = hotListWidgetModel;
        this.$coverBitmaps = list;
        this.$cardType = hotListCardType;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotListWidgetViewKt$createHotListWidgetView$2(this.$context, this.$data, this.$coverBitmaps, this.$cardType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RemoteViews> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        RemoteViews createWidgetCard;
        List<HotListWidgetItemModel> items;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                RemoteViews $this$invokeSuspend_u24lambda_u240 = new RemoteViews(this.$context.getPackageName(), R.layout.bili_app_hot_list_widget);
                Context context = this.$context;
                HotListWidgetModel hotListWidgetModel = this.$data;
                List<Bitmap> list = this.$coverBitmaps;
                HotListCardType hotListCardType = this.$cardType;
                $this$invokeSuspend_u24lambda_u240.setViewVisibility(R.id.container_search, 0);
                $this$invokeSuspend_u24lambda_u240.setViewVisibility(R.id.exchange, 0);
                $this$invokeSuspend_u24lambda_u240.setViewVisibility(R.id.tv_tips, 8);
                $this$invokeSuspend_u24lambda_u240.removeAllViews(R.id.container_entrances);
                HotListWidgetViewKt.updateWidgetViewClick(context, false, $this$invokeSuspend_u24lambda_u240);
                for (int index = 0; index < 3; index++) {
                    if (index > 0) {
                        $this$invokeSuspend_u24lambda_u240.addView(R.id.container_entrances, new RemoteViews(context.getPackageName(), R.layout.bili_include_widget_list_card_gap));
                    }
                    int i = R.id.container_entrances;
                    Bitmap bitmap = null;
                    HotListWidgetItemModel hotListWidgetItemModel = (hotListWidgetModel == null || (items = hotListWidgetModel.getItems()) == null) ? null : (HotListWidgetItemModel) CollectionsKt.getOrNull(items, index);
                    if (list != null) {
                        bitmap = (Bitmap) CollectionsKt.getOrNull(list, index);
                    }
                    createWidgetCard = HotListWidgetViewKt.createWidgetCard(context, hotListWidgetItemModel, index, bitmap, hotListCardType);
                    $this$invokeSuspend_u24lambda_u240.addView(i, createWidgetCard);
                }
                return $this$invokeSuspend_u24lambda_u240;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}