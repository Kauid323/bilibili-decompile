package kntr.app.ad.domain.click.internal.action.handlers;

import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.action.results.FailureReason;
import kntr.app.ad.domain.click.internal.util.UtilsKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HookHandler.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aV\u0010\u0000\u001aP\u0012\u0004\u0012\u00020\u0002\u0012F\u0012D\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0004`\b0\u0001H\u0000\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002¨\u0006\r"}, d2 = {"hookHandler", "Lkotlin/Function1;", "Lkntr/app/ad/domain/click/internal/ClickContext;", "Lkotlin/Function3;", "Lkntr/app/ad/domain/click/internal/action/ActionParam$Url;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/ad/domain/click/internal/action/ActionHandler;", "hook", "Lkntr/app/ad/domain/click/internal/action/results/EasyResult;", "context", "param", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HookHandlerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 hookHandler$lambda$0(ClickContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new HookHandlerKt$hookHandler$1$1(context, null);
    }

    public static final Function1<ClickContext, Function3<ActionParam.Url, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object>> hookHandler() {
        return new Function1() { // from class: kntr.app.ad.domain.click.internal.action.handlers.HookHandlerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Function3 hookHandler$lambda$0;
                hookHandler$lambda$0 = HookHandlerKt.hookHandler$lambda$0((ClickContext) obj);
                return hookHandler$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EasyResult hook(ClickContext context, ActionParam.Url param) {
        String url = param.getUrl();
        if (!(url == null || StringsKt.isBlank(url)) && !UtilsKt.isSchemeString(param.getUrl())) {
            if (context.getService().hook(param.getUrl())) {
                context.getStage().info("hook成功");
                return EasyResult.Success.INSTANCE;
            }
            return new EasyResult.Failure(new FailureReason.InternalError("没有钩子或者钩子处理失败"));
        }
        return new EasyResult.Failure(new FailureReason.InputError("不是有效的链接"));
    }
}