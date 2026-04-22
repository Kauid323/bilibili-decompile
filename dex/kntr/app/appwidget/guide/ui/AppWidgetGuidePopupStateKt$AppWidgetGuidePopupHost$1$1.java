package kntr.app.appwidget.guide.ui;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppWidgetGuidePopupState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.appwidget.guide.ui.AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1", f = "AppWidgetGuidePopupState.kt", i = {0, 0}, l = {29}, m = "invokeSuspend", n = {"it", "$i$a$-let-AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1$1"}, s = {"L$0", "I$0"}, v = 1)
public final class AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PopupData $currentPopupData;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1(PopupData popupData, Continuation<? super AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1> continuation) {
        super(2, continuation);
        this.$currentPopupData = popupData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppWidgetGuidePopupStateKt$AppWidgetGuidePopupHost$1$1(this.$currentPopupData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PopupData it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                it = this.$currentPopupData;
                if (it != null) {
                    long durationms = it.getDurationms();
                    this.L$0 = it;
                    this.I$0 = 0;
                    this.label = 1;
                    if (DelayKt.delay(durationms, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    it.dismiss(true);
                    break;
                }
                break;
            case 1:
                int i = this.I$0;
                it = (PopupData) this.L$0;
                ResultKt.throwOnFailure($result);
                it.dismiss(true);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}