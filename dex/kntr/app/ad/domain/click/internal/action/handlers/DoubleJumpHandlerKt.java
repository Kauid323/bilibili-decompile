package kntr.app.ad.domain.click.internal.action.handlers;

import java.util.List;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.interop.SchemeDoubleJump_androidKt;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DoubleJumpHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0000\u001aP\u0012\u0004\u0012\u00020\u0002\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0004`\b0\u0001H\u0000\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"schemeDoubleJumpHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "schemeDoubleJump", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "context", "param", "(Lkntr/app/ad/domain/click/internal/ClickContext;Lkntr/app/ad/domain/click/internal/action/ActionParam$SchemeDoubleJump;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DoubleJumpHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 schemeDoubleJumpHandler$lambda$0(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new DoubleJumpHandlerKt$schemeDoubleJumpHandler$1$1(context, null);
    }

    public static final Function1<ClickContext, Function3<ActionParam.SchemeDoubleJump, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> schemeDoubleJumpHandler() {
        return new Function1() { // from class: kntr.app.ad.domain.click.internal.action.handlers.DoubleJumpHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function3 schemeDoubleJumpHandler$lambda$0;
                schemeDoubleJumpHandler$lambda$0 = DoubleJumpHandlerKt.schemeDoubleJumpHandler$lambda$0((ClickContext) obj);
                return schemeDoubleJumpHandler$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object schemeDoubleJump(ClickContext context, ActionParam.SchemeDoubleJump param, Continuation<? super EasyResult> continuation) {
        DoubleJumpHandlerKt$schemeDoubleJump$1 doubleJumpHandlerKt$schemeDoubleJump$1;
        Object schemeDoubleJump;
        if (continuation instanceof DoubleJumpHandlerKt$schemeDoubleJump$1) {
            doubleJumpHandlerKt$schemeDoubleJump$1 = (DoubleJumpHandlerKt$schemeDoubleJump$1) continuation;
            if ((doubleJumpHandlerKt$schemeDoubleJump$1.label & Integer.MIN_VALUE) != 0) {
                doubleJumpHandlerKt$schemeDoubleJump$1.label -= Integer.MIN_VALUE;
                Object $result = doubleJumpHandlerKt$schemeDoubleJump$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (doubleJumpHandlerKt$schemeDoubleJump$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String callUpUrl = param.getCallUpUrl();
                        boolean z = false;
                        if (!(callUpUrl == null || StringsKt.isBlank(callUpUrl)) && UtilsKt.isSchemeString(param.getCallUpUrl())) {
                            String jumpUrl = param.getJumpUrl();
                            if (jumpUrl == null || StringsKt.isBlank(jumpUrl)) {
                                z = true;
                            }
                            if (!z && UtilsKt.isH5(param.getJumpUrl()) && param.getUseAdWeb()) {
                                String callUpUrl2 = param.getCallUpUrl();
                                String jumpUrl2 = param.getJumpUrl();
                                List<String> openWhiteList = param.getOpenWhiteList();
                                doubleJumpHandlerKt$schemeDoubleJump$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                                doubleJumpHandlerKt$schemeDoubleJump$1.L$1 = SpillingKt.nullOutSpilledVariable(param);
                                doubleJumpHandlerKt$schemeDoubleJump$1.label = 1;
                                schemeDoubleJump = SchemeDoubleJump_androidKt.schemeDoubleJump(context, callUpUrl2, jumpUrl2, openWhiteList, doubleJumpHandlerKt$schemeDoubleJump$1);
                                if (schemeDoubleJump == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                        return new EasyResult.Failure(new FailureReason.InputError("双跳校验失败"));
                    case 1:
                        ActionParam.SchemeDoubleJump schemeDoubleJump2 = (ActionParam.SchemeDoubleJump) doubleJumpHandlerKt$schemeDoubleJump$1.L$1;
                        ClickContext clickContext = (ClickContext) doubleJumpHandlerKt$schemeDoubleJump$1.L$0;
                        ResultKt.throwOnFailure($result);
                        schemeDoubleJump = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) schemeDoubleJump).booleanValue()) {
                    return EasyResult.Success.INSTANCE;
                }
                return new EasyResult.Failure(new FailureReason.InternalError(null, 1, null));
            }
        }
        doubleJumpHandlerKt$schemeDoubleJump$1 = new DoubleJumpHandlerKt$schemeDoubleJump$1(continuation);
        Object $result2 = doubleJumpHandlerKt$schemeDoubleJump$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (doubleJumpHandlerKt$schemeDoubleJump$1.label) {
        }
        if (!((Boolean) schemeDoubleJump).booleanValue()) {
        }
    }
}