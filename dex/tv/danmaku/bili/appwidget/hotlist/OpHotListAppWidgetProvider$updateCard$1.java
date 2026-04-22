package tv.danmaku.bili.appwidget.hotlist;

import android.content.Context;
import com.oplus.cardwidget.domain.action.CardWidgetAction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotlist.model.HotListDataPacker;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetItemModel;
import tv.danmaku.bili.appwidget.hotlist.model.HotListWidgetModel;
import tv.danmaku.bili.appwidget.hotlist.moss.HotListMossKt;
import tv.danmaku.bili.appwidget.hotlist.utils.ReportUtilKt;
import tv.danmaku.bili.appwidget.hotlist.utils.SpUtilKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OpHotListAppWidgetProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotlist.OpHotListAppWidgetProvider$updateCard$1", f = "OpHotListAppWidgetProvider.kt", i = {0}, l = {BR.coverHorizontal}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
public final class OpHotListAppWidgetProvider$updateCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OpHotListAppWidgetProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpHotListAppWidgetProvider$updateCard$1(OpHotListAppWidgetProvider opHotListAppWidgetProvider, Context context, Continuation<? super OpHotListAppWidgetProvider$updateCard$1> continuation) {
        super(2, continuation);
        this.this$0 = opHotListAppWidgetProvider;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> opHotListAppWidgetProvider$updateCard$1 = new OpHotListAppWidgetProvider$updateCard$1(this.this$0, this.$context, continuation);
        opHotListAppWidgetProvider$updateCard$1.L$0 = obj;
        return opHotListAppWidgetProvider$updateCard$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z;
        CoroutineScope $this$launch;
        Object $result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                CoroutineScope $this$launch2 = (CoroutineScope) this.L$0;
                z = this.this$0.updateFromRefresh;
                if (z) {
                    ReportUtilKt.reportOppoExchangeClick();
                    ReportUtilKt.reportWidgetClick$default("plug_in_card", "change", null, null, null, 28, null);
                    this.this$0.updateFromRefresh = false;
                }
                SpUtilKt.incrementOppoHotListPageNo(this.$context);
                this.L$0 = $this$launch2;
                this.label = 1;
                Object oppoHostListData = HotListMossKt.getOppoHostListData(this.$context, (Continuation) this);
                if (oppoHostListData == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $this$launch = $this$launch2;
                $result = oppoHostListData;
                break;
            case 1:
                $result = obj;
                ResultKt.throwOnFailure($result);
                $this$launch = (CoroutineScope) this.L$0;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HotListWidgetModel cardData = (HotListWidgetModel) $result;
        this.this$0.isGripperComplete = true;
        OpHotListAppWidgetProvider.switchLayout$default(this.this$0, this.$context, null, 2, null);
        Iterable $this$forEach$iv = this.this$0.getShowedCardList();
        Context context = this.$context;
        for (Object element$iv : $this$forEach$iv) {
            String widgetCode = (String) element$iv;
            CardWidgetAction.INSTANCE.postUpdateCommand(context, new HotListDataPacker(cardData), widgetCode);
        }
        Iterable items = cardData.getItems();
        if (items != null) {
            Iterable $this$forEachIndexed$iv = items;
            Context context2 = this.$context;
            OpHotListAppWidgetProvider opHotListAppWidgetProvider = this.this$0;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                HotListWidgetItemModel hotListWidgetItemModel = (HotListWidgetItemModel) item$iv;
                BuildersKt.launch$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new OpHotListAppWidgetProvider$updateCard$1$2$1(context2, hotListWidgetItemModel, index$iv, opHotListAppWidgetProvider, cardData, null), 3, (Object) null);
                context2 = context2;
                opHotListAppWidgetProvider = opHotListAppWidgetProvider;
                index$iv = index$iv2;
            }
        }
        return Unit.INSTANCE;
    }
}