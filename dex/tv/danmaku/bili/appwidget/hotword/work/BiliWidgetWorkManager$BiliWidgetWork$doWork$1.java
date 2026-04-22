package tv.danmaku.bili.appwidget.hotword.work;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.appwidget.hotword.HotWordAppWidgetUpdater;
import tv.danmaku.bili.appwidget.hotword.work.BiliWidgetWorkManager;

/* compiled from: BiliWidgetWork.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.hotword.work.BiliWidgetWorkManager$BiliWidgetWork$doWork$1", f = "BiliWidgetWork.kt", i = {}, l = {BR.chatPlayerInputHint}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliWidgetWorkManager$BiliWidgetWork$doWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int[] $appWidgetIds;
    final /* synthetic */ CountDownLatch $lock;
    final /* synthetic */ AppWidgetManager $widgetManager;
    int label;
    final /* synthetic */ BiliWidgetWorkManager.BiliWidgetWork this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiliWidgetWorkManager$BiliWidgetWork$doWork$1(BiliWidgetWorkManager.BiliWidgetWork biliWidgetWork, AppWidgetManager appWidgetManager, int[] iArr, CountDownLatch countDownLatch, Continuation<? super BiliWidgetWorkManager$BiliWidgetWork$doWork$1> continuation) {
        super(2, continuation);
        this.this$0 = biliWidgetWork;
        this.$widgetManager = appWidgetManager;
        this.$appWidgetIds = iArr;
        this.$lock = countDownLatch;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliWidgetWorkManager$BiliWidgetWork$doWork$1(this.this$0, this.$widgetManager, this.$appWidgetIds, this.$lock, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HotWordAppWidgetUpdater hotWordAppWidgetUpdater = HotWordAppWidgetUpdater.INSTANCE;
                Context context = this.this$0.getContext();
                AppWidgetManager appWidgetManager = this.$widgetManager;
                Intrinsics.checkNotNull(appWidgetManager);
                this.label = 1;
                if (HotWordAppWidgetUpdater.updateAppWidgetInternal$default(hotWordAppWidgetUpdater, context, appWidgetManager, this.$appWidgetIds, false, (Continuation) this, 8, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lock.countDown();
        return Unit.INSTANCE;
    }
}