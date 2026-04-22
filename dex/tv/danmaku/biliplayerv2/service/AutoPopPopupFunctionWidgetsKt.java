package tv.danmaku.biliplayerv2.service;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import java.util.HashMap;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: AutoPopPopupFunctionWidgets.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"autoPopPopupFunctionWidgets", "", "Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "(Ltv/danmaku/biliplayerv2/service/AbsFunctionWidgetService;Landroidx/activity/OnBackPressedDispatcher;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "biliplayerv2_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class AutoPopPopupFunctionWidgetsKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object autoPopPopupFunctionWidgets(final AbsFunctionWidgetService $this$autoPopPopupFunctionWidgets, final OnBackPressedDispatcher onBackPressedDispatcher, Continuation<? super Unit> continuation) {
        AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1 autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1;
        AbsFunctionWidgetService $this$autoPopPopupFunctionWidgets2;
        OnWidgetStateChangeListener onWidgetStateChangeListener;
        if (continuation instanceof AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1) {
            autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1 = (AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1) continuation;
            if ((autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.label & Integer.MIN_VALUE) != 0) {
                autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.label -= Integer.MIN_VALUE;
                Object $result = autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        OnWidgetStateChangeListener onWidgetStateChangeListener2 = new OnWidgetStateChangeListener() { // from class: tv.danmaku.biliplayerv2.service.AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$listener$1
                            private final HashMap<FunctionWidgetToken, OnBackPressedCallback> callbacks = new HashMap<>();

                            @Override // tv.danmaku.biliplayerv2.service.OnWidgetStateChangeListener
                            public void onWidgetShow(final FunctionWidgetToken token) {
                                Intrinsics.checkNotNullParameter(token, "token");
                                if (token.getFunctionType() <= 1) {
                                    return;
                                }
                                final AbsFunctionWidgetService absFunctionWidgetService = $this$autoPopPopupFunctionWidgets;
                                OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: tv.danmaku.biliplayerv2.service.AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$listener$1$onWidgetShow$callback$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(true);
                                    }

                                    public void handleOnBackPressed() {
                                        AbsFunctionWidgetService.this.hideWidget(token);
                                    }
                                };
                                onBackPressedDispatcher.addCallback(onBackPressedCallback);
                                this.callbacks.put(token, onBackPressedCallback);
                            }

                            @Override // tv.danmaku.biliplayerv2.service.OnWidgetStateChangeListener
                            public void onWidgetDismiss(FunctionWidgetToken token) {
                                Intrinsics.checkNotNullParameter(token, "token");
                                OnBackPressedCallback remove = this.callbacks.remove(token);
                                if (remove != null) {
                                    remove.remove();
                                }
                            }
                        };
                        $this$autoPopPopupFunctionWidgets.addOnWidgetStateChangeListener(onWidgetStateChangeListener2);
                        try {
                            autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.L$0 = $this$autoPopPopupFunctionWidgets;
                            autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.L$1 = onWidgetStateChangeListener2;
                            autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.label = 1;
                            if (DelayKt.awaitCancellation(autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $this$autoPopPopupFunctionWidgets2 = $this$autoPopPopupFunctionWidgets;
                            onWidgetStateChangeListener = onWidgetStateChangeListener2;
                            throw new KotlinNothingValueException();
                        } catch (Throwable th) {
                            th = th;
                            $this$autoPopPopupFunctionWidgets2 = $this$autoPopPopupFunctionWidgets;
                            onWidgetStateChangeListener = onWidgetStateChangeListener2;
                            $this$autoPopPopupFunctionWidgets2.removeOnWidgetStateChangeListener(onWidgetStateChangeListener);
                            throw th;
                        }
                    case 1:
                        onWidgetStateChangeListener = (AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$listener$1) autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.L$1;
                        $this$autoPopPopupFunctionWidgets2 = (AbsFunctionWidgetService) autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            throw new KotlinNothingValueException();
                        } catch (Throwable th2) {
                            th = th2;
                            $this$autoPopPopupFunctionWidgets2.removeOnWidgetStateChangeListener(onWidgetStateChangeListener);
                            throw th;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1 = new AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1(continuation);
        Object $result2 = autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (autoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1.label) {
        }
    }
}