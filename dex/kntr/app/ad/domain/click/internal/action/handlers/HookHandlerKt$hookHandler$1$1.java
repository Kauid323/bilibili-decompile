package kntr.app.ad.domain.click.internal.action.handlers;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HookHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "next", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.HookHandlerKt$hookHandler$1$1", f = "HookHandler.kt", i = {0, 0, 0}, l = {AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER}, m = "invokeSuspend", n = {"param", "next", "result"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class HookHandlerKt$hookHandler$1$1 extends SuspendLambda implements Function3<ActionParam.Url, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ClickContext $context;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HookHandlerKt$hookHandler$1$1(ClickContext clickContext, Continuation<? super HookHandlerKt$hookHandler$1$1> continuation) {
        super(3, continuation);
        this.$context = clickContext;
    }

    public final Object invoke(ActionParam.Url url, Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        HookHandlerKt$hookHandler$1$1 hookHandlerKt$hookHandler$1$1 = new HookHandlerKt$hookHandler$1$1(this.$context, continuation);
        hookHandlerKt$hookHandler$1$1.L$0 = url;
        hookHandlerKt$hookHandler$1$1.L$1 = function1;
        return hookHandlerKt$hookHandler$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        EasyResult result;
        boolean z;
        Object invoke;
        EasyResult result2;
        ActionParam.Url param = (ActionParam.Url) this.L$0;
        Function1 next = (Function1) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                result = HookHandlerKt.hook(this.$context, param);
                this.$context.dispatchActionResult(this.$context, new ActionResult.Hook(param, result));
                z = true;
                if (!Intrinsics.areEqual(result, EasyResult.Success.INSTANCE)) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    this.label = 1;
                    invoke = next.invoke(this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result2 = result;
                    z = ((Boolean) invoke).booleanValue();
                    break;
                }
                break;
            case 1:
                result2 = (EasyResult) this.L$2;
                ResultKt.throwOnFailure($result);
                invoke = $result;
                z = ((Boolean) invoke).booleanValue();
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(z);
    }
}