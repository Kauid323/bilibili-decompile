package tv.danmaku.bili.push.innerpush.v2;

import com.bilibili.module.main.innerpush.InnerPush;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppInnerPushManagerV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.innerpush.v2.AppInnerPushManagerV2$trimBizPush$1", f = "AppInnerPushManagerV2.kt", i = {}, l = {BR.msgContent}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppInnerPushManagerV2$trimBizPush$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<InnerPush, Boolean> $predicate;
    final /* synthetic */ String $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppInnerPushManagerV2$trimBizPush$1(String str, Function1<? super InnerPush, Boolean> function1, Continuation<? super AppInnerPushManagerV2$trimBizPush$1> continuation) {
        super(2, continuation);
        this.$type = str;
        this.$predicate = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppInnerPushManagerV2$trimBizPush$1(this.$type, this.$predicate, continuation);
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
                if (InnerPushCacheManagerV2.Companion.getInstance().trimBizPush(this.$type, this.$predicate, (Continuation) this) == coroutine_suspended) {
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