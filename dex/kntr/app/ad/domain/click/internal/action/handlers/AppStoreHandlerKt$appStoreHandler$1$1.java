package kntr.app.ad.domain.click.internal.action.handlers;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.ad.domain.click.internal.ActionUiExtra;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.ActionParam;
import kntr.app.ad.domain.click.internal.action.ActionResult;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.action.results.EasyResult;
import kntr.app.ad.domain.click.internal.interop.AppStore_androidKt;
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
/* compiled from: AppStoreHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "param", "Lkntr/app/ad/domain/click/internal/action/ActionParam$AppStore;", "next", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.handlers.AppStoreHandlerKt$appStoreHandler$1$1", f = "AppStoreHandler.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4}, l = {AdditionVote2.CHOICE_CNT_FIELD_NUMBER, 32, 39, 55, 59}, m = "invokeSuspend", n = {"param", "next", "param", "next", "result", "param", "next", "intermediates", "param", "next", "intermediates", "result", "param", "next"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"}, v = 1)
public final class AppStoreHandlerKt$appStoreHandler$1$1 extends SuspendLambda implements Function3<ActionParam.AppStore, Function1<? super Continuation<? super Boolean>, ? extends Object>, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ClickContext $context;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppStoreHandlerKt$appStoreHandler$1$1(ClickContext clickContext, Continuation<? super AppStoreHandlerKt$appStoreHandler$1$1> continuation) {
        super(3, continuation);
        this.$context = clickContext;
    }

    public final Object invoke(ActionParam.AppStore appStore, Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        AppStoreHandlerKt$appStoreHandler$1$1 appStoreHandlerKt$appStoreHandler$1$1 = new AppStoreHandlerKt$appStoreHandler$1$1(this.$context, continuation);
        appStoreHandlerKt$appStoreHandler$1$1.L$0 = appStore;
        appStoreHandlerKt$appStoreHandler$1$1.L$1 = function1;
        return appStoreHandlerKt$appStoreHandler$1$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object invoke;
        LinkedHashMap intermediates;
        Object openAppScore;
        Object callUpAppStore;
        CallUpResult result;
        Object invoke2;
        EasyResult result2;
        Object invoke3;
        ActionParam.AppStore param = (ActionParam.AppStore) this.L$0;
        Function1 next = (Function1) this.L$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (!param.getEnableAppStore()) {
                    this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                    this.label = 5;
                    invoke = next.invoke(this);
                    if (invoke == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = ((Boolean) invoke).booleanValue();
                    return Boxing.boxBoolean(z);
                }
                String url = param.getUrl();
                if (!(url == null || StringsKt.isBlank(url)) && param.getAppStorePriority() == 1) {
                    this.L$0 = param;
                    this.L$1 = next;
                    this.label = 1;
                    callUpAppStore = AppStore_androidKt.callUpAppStore(this.$context, param.getUrl(), param.getDownloadWhiteList(), (Continuation) this);
                    if (callUpAppStore == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    result = (CallUpResult) callUpAppStore;
                    this.$context.dispatchActionResult(this.$context, new ActionResult.AppStoreCallUp(param, result));
                    if (!(result instanceof CallUpResult.Success)) {
                        this.$context.setHasJumped(true);
                        return Boxing.boxBoolean(z);
                    }
                    this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                    this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                    this.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    this.label = 2;
                    invoke2 = next.invoke(this);
                    if (invoke2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = ((Boolean) invoke2).booleanValue();
                    return Boxing.boxBoolean(z);
                }
                intermediates = new LinkedHashMap();
                intermediates.put(ActionUiExtra.URL.getValue(), param.getUrl());
                this.L$0 = param;
                this.L$1 = next;
                this.L$2 = intermediates;
                this.label = 3;
                openAppScore = AppStore_androidKt.openAppScore(this.$context, param.getUrl(), param.getDownloadWhiteList(), param.getStoreLink(), param.isFirstJump(), intermediates, (Continuation) this);
                if (openAppScore == coroutine_suspended) {
                    return coroutine_suspended;
                }
                result2 = (EasyResult) openAppScore;
                this.$context.dispatchActionResult(this.$context, new ActionResult.AppStoreOpen(param, result2, intermediates));
                if (!Intrinsics.areEqual(result2, EasyResult.Success.INSTANCE)) {
                    this.$context.setHasJumped(true);
                    return Boxing.boxBoolean(z);
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(param);
                this.L$1 = SpillingKt.nullOutSpilledVariable(next);
                this.L$2 = SpillingKt.nullOutSpilledVariable(intermediates);
                this.L$3 = SpillingKt.nullOutSpilledVariable(result2);
                this.label = 4;
                invoke3 = next.invoke(this);
                if (invoke3 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = ((Boolean) invoke3).booleanValue();
                return Boxing.boxBoolean(z);
            case 1:
                ResultKt.throwOnFailure($result);
                callUpAppStore = $result;
                result = (CallUpResult) callUpAppStore;
                this.$context.dispatchActionResult(this.$context, new ActionResult.AppStoreCallUp(param, result));
                if (!(result instanceof CallUpResult.Success)) {
                }
                break;
            case 2:
                CallUpResult callUpResult = (CallUpResult) this.L$2;
                ResultKt.throwOnFailure($result);
                invoke2 = $result;
                z = ((Boolean) invoke2).booleanValue();
                return Boxing.boxBoolean(z);
            case 3:
                intermediates = (Map) this.L$2;
                ResultKt.throwOnFailure($result);
                openAppScore = $result;
                result2 = (EasyResult) openAppScore;
                this.$context.dispatchActionResult(this.$context, new ActionResult.AppStoreOpen(param, result2, intermediates));
                if (!Intrinsics.areEqual(result2, EasyResult.Success.INSTANCE)) {
                }
                break;
            case 4:
                EasyResult easyResult = (EasyResult) this.L$3;
                Map map = (Map) this.L$2;
                ResultKt.throwOnFailure($result);
                invoke3 = $result;
                z = ((Boolean) invoke3).booleanValue();
                return Boxing.boxBoolean(z);
            case 5:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                z = ((Boolean) invoke).booleanValue();
                return Boxing.boxBoolean(z);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}