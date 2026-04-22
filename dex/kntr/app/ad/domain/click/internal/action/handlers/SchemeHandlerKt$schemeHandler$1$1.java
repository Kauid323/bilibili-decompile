package kntr.app.ad.domain.click.internal.action.handlers;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.interop.AdWeb_androidKt;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
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
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SchemeHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Scheme;", "next", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.SchemeHandlerKt$schemeHandler$1$1", f = "SchemeHandler.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {AdditionVote2.CHOICE_CNT_FIELD_NUMBER, 27, 39}, m = "invokeSuspend", n = {"param", "next", "result", "param", "next", "callResult", "result", "param", "next", "callResult", "result"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class SchemeHandlerKt$schemeHandler$1$1 extends SuspendLambda implements Function3<ActionParam.Scheme, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ClickContext $context;
    int I$0;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SchemeHandlerKt$schemeHandler$1$1(ClickContext clickContext, Continuation<? super SchemeHandlerKt$schemeHandler$1$1> continuation) {
        super(3, continuation);
        this.$context = clickContext;
    }

    public final Object invoke(ActionParam.Scheme scheme, Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        SchemeHandlerKt$schemeHandler$1$1 schemeHandlerKt$schemeHandler$1$1 = new SchemeHandlerKt$schemeHandler$1$1(this.$context, continuation);
        schemeHandlerKt$schemeHandler$1$1.L$0 = scheme;
        schemeHandlerKt$schemeHandler$1$1.L$1 = function1;
        return schemeHandlerKt$schemeHandler$1$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v24, types: [kntr.app.ad.domain.click.internal.ClickContext] */
    public final Object invokeSuspend(Object $result) {
        ?? r3;
        Object openScheme;
        CallUpResult callResult;
        Object openAdWeb;
        Object invoke;
        int i;
        CallUpResult callResult2;
        ActionParam.Scheme param = (ActionParam.Scheme) this.L$0;
        Function1 next = (Function1) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                r3 = 0;
                this.L$0 = param;
                this.L$1 = next;
                this.I$0 = 0;
                this.label = 1;
                openScheme = SchemeHandlerKt.openScheme(this.$context, param, (Continuation) this);
                if (openScheme == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                int i2 = this.I$0;
                ResultKt.throwOnFailure($result);
                openScheme = $result;
                r3 = i2;
                break;
            case 2:
                int i3 = this.I$0;
                callResult = (CallUpResult) this.L$2;
                ResultKt.throwOnFailure($result);
                openAdWeb = $result;
                r3 = ((Boolean) openAdWeb).booleanValue();
                this.$context.setHasDialogCancelJump(r3);
                this.$context.dispatchActionResult(this.$context, new ActionResult.Scheme(param, callResult));
                if (!Intrinsics.areEqual(callResult, CallUpResult.Success.INSTANCE) || r3 != 0) {
                    this.$context.setHasJumped(true);
                    this.$context.setHasJumpedToThirdApp(true);
                    return Boxing.boxBoolean(z);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                this.L$2 = SpillingKt.nullOutSpilledVariable(callResult);
                this.I$0 = r3;
                this.label = 3;
                invoke = next.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = r3;
                callResult2 = callResult;
                z = ((Boolean) invoke).booleanValue();
                return Boxing.boxBoolean(z);
            case 3:
                i = this.I$0;
                callResult2 = (CallUpResult) this.L$2;
                ResultKt.throwOnFailure($result);
                invoke = $result;
                z = ((Boolean) invoke).booleanValue();
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        callResult = (CallUpResult) openScheme;
        if (param.getUseAdWeb() && (callResult instanceof CallUpResult.Failure) && Intrinsics.areEqual(((CallUpResult.Failure) callResult).getReason(), CallUpFailureReason.UserCancelled.INSTANCE) && param.getEnableCallUpCancelToJumpUrl()) {
            String cancelUrl = param.getCancelUrl();
            if (!(cancelUrl == null || StringsKt.isBlank(cancelUrl)) && UtilsKt.isH5(param.getCancelUrl())) {
                this.L$0 = param;
                this.L$1 = next;
                this.L$2 = callResult;
                this.I$0 = r3 == true ? 1 : 0;
                this.label = 2;
                openAdWeb = AdWeb_androidKt.openAdWeb(this.$context, param.getCancelUrl(), (Continuation) this);
                if (openAdWeb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r3 = ((Boolean) openAdWeb).booleanValue();
                this.$context.setHasDialogCancelJump(r3);
            }
        }
        this.$context.dispatchActionResult(this.$context, new ActionResult.Scheme(param, callResult));
        if (!Intrinsics.areEqual(callResult, CallUpResult.Success.INSTANCE)) {
        }
        this.$context.setHasJumped(true);
        this.$context.setHasJumpedToThirdApp(true);
        return Boxing.boxBoolean(z);
    }
}