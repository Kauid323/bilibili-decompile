package tv.danmaku.bili.push.innerpush.v2;

import com.bilibili.pvtracker.PageViewTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.core.test.FdDebugActivity;

/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$onActivityResumed$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {831, 836}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AppInnerPushManagerV2$onActivityResumed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AppInnerPushManagerV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$onActivityResumed$1(AppInnerPushManagerV2 appInnerPushManagerV2, Continuation<? super AppInnerPushManagerV2$onActivityResumed$1> continuation) {
        super(2, continuation);
        this.this$0 = appInnerPushManagerV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$onActivityResumed$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                this.this$0.tryShowInnerPush();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String pv = PageViewTracker.getInstance().getCurrentPageViewId();
        String str = pv;
        if (str != null && !StringsKt.isBlank(str)) {
            z = false;
        }
        if (!z) {
            this.this$0.tryShowInnerPush();
            return Unit.INSTANCE;
        }
        BLog.i("[InnerPush]AppInnerPushManagerV2", "onActivityResumed currentPageViewId is null, and register");
        this.label = 2;
        if (DelayKt.delay((long) FdDebugActivity.UPDATE_DELAY_TIME, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.tryShowInnerPush();
        return Unit.INSTANCE;
    }
}