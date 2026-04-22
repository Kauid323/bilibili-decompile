package kntr.app.ad.domain.click.internal.action.handlers;

import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.interop.ULink_androidKt;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ULinkHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aV\u0010\u0000\u001aP\u0012\u0004\u0012\u00020\u0002\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0004`\b0\u0001H\u0000\u001a\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"uLinkHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "openULink", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "context", "param", "(Lkntr/app/ad/domain/click/internal/ClickContext;Lkntr/app/ad/domain/click/internal/action/ActionParam$ULink;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ULinkHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 uLinkHandler$lambda$0(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ULinkHandlerKt$uLinkHandler$1$1(context, null);
    }

    public static final Function1<ClickContext, Function3<ActionParam.ULink, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> uLinkHandler() {
        return new Function1() { // from class: kntr.app.ad.domain.click.internal.action.handlers.ULinkHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function3 uLinkHandler$lambda$0;
                uLinkHandler$lambda$0 = ULinkHandlerKt.uLinkHandler$lambda$0((ClickContext) obj);
                return uLinkHandler$lambda$0;
            }
        };
    }

    public static final Object openULink(ClickContext context, ActionParam.ULink param, Continuation<? super CallUpResult> continuation) {
        String callUpUrl = param.getCallUpUrl();
        boolean z = true;
        if (callUpUrl != null && UtilsKt.isH5(callUpUrl)) {
            String universalApp = param.getUniversalApp();
            if (universalApp == null || !UtilsKt.isSchemeString(universalApp)) {
                z = false;
            }
            if (z) {
                context.getStage().info("即将唤起ULK...");
                if (!UtilsKt.isInOpenWhiteList(param.getUniversalApp(), param.getOpenWhiteList())) {
                    return new CallUpResult.Failure(CallUpFailureReason.AuthFailed.INSTANCE);
                }
                return ULink_androidKt.openULink(context, param.getCallUpUrl(), continuation);
            }
        }
        return new CallUpResult.Failure(new CallUpFailureReason.InputError("不是有效的链接"));
    }
}