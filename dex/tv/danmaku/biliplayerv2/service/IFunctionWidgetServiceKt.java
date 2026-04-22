package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.biliplayerv2.service.FunctionWidgetToken;
import tv.danmaku.biliplayerv2.widget.AbsFunctionWidget;
import tv.danmaku.biliplayerv2.widget.IFunctionContainer;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidgetService.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"retainFunctionWidget", "", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "widget", "Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;", "layoutParams", "Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;", "tokenProcessor", "Lkotlin/Function1;", "Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;", "(Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;Ltv/danmaku/biliplayerv2/widget/AbsFunctionWidget;Ltv/danmaku/biliplayerv2/widget/IFunctionContainer$LayoutParams;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDismiss", "token", "(Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;Ltv/danmaku/biliplayerv2/service/FunctionWidgetToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IFunctionWidgetServiceKt {
    public static /* synthetic */ Object retainFunctionWidget$default(AbsFunctionWidgetService absFunctionWidgetService, AbsFunctionWidget absFunctionWidget, IFunctionContainer.LayoutParams layoutParams, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            layoutParams = AbsFunctionWidgetService.Companion.getEmptyLayoutParams();
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return retainFunctionWidget(absFunctionWidgetService, absFunctionWidget, layoutParams, function1, continuation);
    }

    public static final Object retainFunctionWidget(AbsFunctionWidgetService $this$retainFunctionWidget, AbsFunctionWidget widget, IFunctionContainer.LayoutParams layoutParams, Function1<? super FunctionWidgetToken, Unit> function1, Continuation<? super Unit> continuation) {
        FunctionWidgetToken token = $this$retainFunctionWidget.showWidget(widget, layoutParams);
        if (token == null) {
            return Unit.INSTANCE;
        }
        if (function1 != null) {
            function1.invoke(token);
        }
        Object awaitDismiss = awaitDismiss($this$retainFunctionWidget, token, continuation);
        return awaitDismiss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitDismiss : Unit.INSTANCE;
    }

    public static final Object awaitDismiss(final AbsFunctionWidgetService $this$awaitDismiss, final FunctionWidgetToken token, Continuation<? super Unit> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cont = cancellableContinuationImpl;
        token.setWidgetChangedListener(new FunctionWidgetToken.WidgetChangedListener() { // from class: tv.danmaku.biliplayerv2.service.IFunctionWidgetServiceKt$awaitDismiss$2$1
            @Override // tv.danmaku.biliplayerv2.service.FunctionWidgetToken.WidgetChangedListener
            public /* synthetic */ void onRemoved() {
                FunctionWidgetToken.WidgetChangedListener.CC.$default$onRemoved(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.FunctionWidgetToken.WidgetChangedListener
            public /* synthetic */ void onShow() {
                FunctionWidgetToken.WidgetChangedListener.CC.$default$onShow(this);
            }

            @Override // tv.danmaku.biliplayerv2.service.FunctionWidgetToken.WidgetChangedListener
            public void onDismiss() {
                if (cont.isActive()) {
                    Result.Companion companion = Result.Companion;
                    cont.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                }
            }
        });
        cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: tv.danmaku.biliplayerv2.service.IFunctionWidgetServiceKt$awaitDismiss$2$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((Throwable) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable it) {
                FunctionWidgetToken.this.setWidgetChangedListener(null);
                $this$awaitDismiss.hideWidget(FunctionWidgetToken.this);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }
}