package tv.danmaku.bili.appwidget.hotword;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HotWordAppWidgetUpdater.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater$updateAppWidget$1", f = "HotWordAppWidgetUpdater.kt", i = {}, l = {BR.buttonVisible}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class HotWordAppWidgetUpdater$updateAppWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ AppWidgetManager $appWidgetManager;
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotWordAppWidgetUpdater$updateAppWidget$1(Context context, AppWidgetManager appWidgetManager, int[] iArr, Continuation<? super HotWordAppWidgetUpdater$updateAppWidget$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$appWidgetManager = appWidgetManager;
        this.$appWidgetIds = iArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HotWordAppWidgetUpdater$updateAppWidget$1(this.$context, this.$appWidgetManager, this.$appWidgetIds, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (HotWordAppWidgetUpdater.updateAppWidgetInternal$default(HotWordAppWidgetUpdater.INSTANCE, this.$context, this.$appWidgetManager, this.$appWidgetIds, false, (Continuation) this, 8, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}