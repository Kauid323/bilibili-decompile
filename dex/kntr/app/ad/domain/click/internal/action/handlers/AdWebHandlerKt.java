package kntr.app.ad.domain.click.internal.action.handlers;

import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.interop.AdWeb_androidKt;
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

/* compiled from: AdWebHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0000\u001aP\u0012\u0004\u0012\u00020\u0002\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0004`\b0\u0001H\u0000\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"adWebHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "openAdWeb", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "context", "param", "(Lkntr/app/ad/domain/click/internal/ClickContext;Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdWebHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 adWebHandler$lambda$0(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AdWebHandlerKt$adWebHandler$1$1(context, null);
    }

    public static final Function1<ClickContext, Function3<ActionParam.Url, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> adWebHandler() {
        return new Function1() { // from class: kntr.app.ad.domain.click.internal.action.handlers.AdWebHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function3 adWebHandler$lambda$0;
                adWebHandler$lambda$0 = AdWebHandlerKt.adWebHandler$lambda$0((ClickContext) obj);
                return adWebHandler$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object openAdWeb(ClickContext context, ActionParam.Url param, Continuation<? super EasyResult> continuation) {
        AdWebHandlerKt$openAdWeb$1 adWebHandlerKt$openAdWeb$1;
        Object openAdWeb;
        if (continuation instanceof AdWebHandlerKt$openAdWeb$1) {
            adWebHandlerKt$openAdWeb$1 = (AdWebHandlerKt$openAdWeb$1) continuation;
            if ((adWebHandlerKt$openAdWeb$1.label & Integer.MIN_VALUE) != 0) {
                adWebHandlerKt$openAdWeb$1.label -= Integer.MIN_VALUE;
                Object $result = adWebHandlerKt$openAdWeb$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (adWebHandlerKt$openAdWeb$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        String url = param.getUrl();
                        boolean z = false;
                        if (url != null && UtilsKt.isH5(url)) {
                            z = true;
                        }
                        if (z) {
                            IClickContext.CC.reportUi$default(context, ActionUiEvent.HTTP_JUMP_URL, null, 2, null);
                            context.getStage().info("即将打开广告Web...");
                            String url2 = param.getUrl();
                            adWebHandlerKt$openAdWeb$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                            adWebHandlerKt$openAdWeb$1.L$1 = SpillingKt.nullOutSpilledVariable(param);
                            adWebHandlerKt$openAdWeb$1.label = 1;
                            openAdWeb = AdWeb_androidKt.openAdWeb(context, url2, adWebHandlerKt$openAdWeb$1);
                            if (openAdWeb == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            return new EasyResult.Failure(new FailureReason.InputError("不是有效的h5"));
                        }
                        break;
                    case 1:
                        ActionParam.Url url3 = (ActionParam.Url) adWebHandlerKt$openAdWeb$1.L$1;
                        ClickContext clickContext = (ClickContext) adWebHandlerKt$openAdWeb$1.L$0;
                        ResultKt.throwOnFailure($result);
                        openAdWeb = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                if (!((Boolean) openAdWeb).booleanValue()) {
                    return EasyResult.Success.INSTANCE;
                }
                return new EasyResult.Failure(new FailureReason.InternalError(null, 1, null));
            }
        }
        adWebHandlerKt$openAdWeb$1 = new AdWebHandlerKt$openAdWeb$1(continuation);
        Object $result2 = adWebHandlerKt$openAdWeb$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (adWebHandlerKt$openAdWeb$1.label) {
        }
        if (!((Boolean) openAdWeb).booleanValue()) {
        }
    }
}