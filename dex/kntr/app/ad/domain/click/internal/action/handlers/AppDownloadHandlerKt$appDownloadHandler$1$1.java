package kntr.app.ad.domain.click.internal.action.handlers;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.DownloadResult;
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
/* compiled from: AppDownloadHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppDownload;", "next", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.AppDownloadHandlerKt$appDownloadHandler$1$1", f = "AppDownloadHandler.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {AdditionVote2.TIPS_FIELD_NUMBER, AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER, 23}, m = "invokeSuspend", n = {"param", "next", "param", "next", "result", "param", "next"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
public final class AppDownloadHandlerKt$appDownloadHandler$1$1 extends SuspendLambda implements Function3<ActionParam.AppDownload, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ClickContext $context;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppDownloadHandlerKt$appDownloadHandler$1$1(ClickContext clickContext, Continuation<? super AppDownloadHandlerKt$appDownloadHandler$1$1> continuation) {
        super(3, continuation);
        this.$context = clickContext;
    }

    public final Object invoke(ActionParam.AppDownload appDownload, Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        AppDownloadHandlerKt$appDownloadHandler$1$1 appDownloadHandlerKt$appDownloadHandler$1$1 = new AppDownloadHandlerKt$appDownloadHandler$1$1(this.$context, continuation);
        appDownloadHandlerKt$appDownloadHandler$1$1.L$0 = appDownload;
        appDownloadHandlerKt$appDownloadHandler$1$1.L$1 = function1;
        return appDownloadHandlerKt$appDownloadHandler$1$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object invoke;
        Object appDownload;
        Object invoke2;
        ActionParam.AppDownload param = (ActionParam.AppDownload) this.L$0;
        Function1 next = (Function1) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!param.getEnableDownload()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 3;
                    invoke = next.invoke(this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = ((Boolean) invoke).booleanValue();
                    return Boxing.boxBoolean(z);
                }
                this.L$0 = param;
                this.L$1 = next;
                this.label = 1;
                appDownload = AppDownloadHandlerKt.appDownload(this.$context, param, (Continuation) this);
                if (appDownload == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                appDownload = $result;
                break;
            case 2:
                DownloadResult downloadResult = (DownloadResult) this.L$2;
                ResultKt.throwOnFailure($result);
                invoke2 = $result;
                z = ((Boolean) invoke2).booleanValue();
                return Boxing.boxBoolean(z);
            case 3:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                z = ((Boolean) invoke).booleanValue();
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        DownloadResult result = (DownloadResult) appDownload;
        this.$context.dispatchActionResult(this.$context, new ActionResult.AppDownload(param, result));
        if (!Intrinsics.areEqual(result, DownloadResult.Success.INSTANCE)) {
            this.L$0 = SpillingKt.nullOutSpilledVariable(param);
            this.L$1 = SpillingKt.nullOutSpilledVariable(next);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.label = 2;
            invoke2 = next.invoke(this);
            if (invoke2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = ((Boolean) invoke2).booleanValue();
        }
        return Boxing.boxBoolean(z);
    }
}