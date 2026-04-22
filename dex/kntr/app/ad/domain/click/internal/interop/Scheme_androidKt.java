package kntr.app.ad.domain.click.internal.interop;

import android.content.Intent;
import android.net.Uri;
import kntr.app.ad.domain.click.ClickFrom;
import kntr.app.ad.domain.click.IClickContext;
import kntr.app.ad.domain.click.internal.ActionUiEvent;
import kntr.app.ad.domain.click.internal.ActionUiExtra;
import kntr.app.ad.domain.click.internal.ClickContext;
import kntr.app.ad.domain.click.internal.action.results.CallUpFailureReason;
import kntr.app.ad.domain.click.internal.action.results.CallUpResult;
import kntr.app.ad.domain.click.internal.callup.CallUpCallback;
import kntr.app.ad.domain.click.internal.callup.CallUpCallbacks;
import kntr.app.ad.domain.click.internal.callup.CallUpProxyActivity;
import kntr.app.ad.domain.click.internal.util.DeepLinkUtil;
import kntr.app.ad.protocol.report.IReportExtraHandler;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scheme.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080@¢\u0006\u0002\u0010\u0006\u001a\u001e\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"openScheme", "Lkntr/app/ad/domain/click/internal/action/results/CallUpResult;", "context", "Lkntr/app/ad/domain/click/internal/ClickContext;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkntr/app/ad/domain/click/internal/ClickContext;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launchWithProxy", "targetIntent", "Landroid/content/Intent;", "(Lkntr/app/ad/domain/click/internal/ClickContext;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "click_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Scheme_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object openScheme(ClickContext context, String url, Continuation<? super CallUpResult> continuation) {
        Scheme_androidKt$openScheme$1 scheme_androidKt$openScheme$1;
        try {
            if (continuation instanceof Scheme_androidKt$openScheme$1) {
                scheme_androidKt$openScheme$1 = (Scheme_androidKt$openScheme$1) continuation;
                if ((scheme_androidKt$openScheme$1.label & Integer.MIN_VALUE) != 0) {
                    scheme_androidKt$openScheme$1.label -= Integer.MIN_VALUE;
                    Object $result = scheme_androidKt$openScheme$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (scheme_androidKt$openScheme$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
                            intent.addFlags(268435456);
                            if (!DeepLinkUtil.INSTANCE.canHandleIntent(context.getService().getPlatformContext(), intent)) {
                                return new CallUpResult.Failure(CallUpFailureReason.NotInstalled.INSTANCE);
                            }
                            IClickContext.CC.reportUi$default(context, ActionUiEvent.ROUTE_AD_CALLUP, null, 2, null);
                            scheme_androidKt$openScheme$1.L$0 = SpillingKt.nullOutSpilledVariable(context);
                            scheme_androidKt$openScheme$1.L$1 = SpillingKt.nullOutSpilledVariable(url);
                            scheme_androidKt$openScheme$1.L$2 = SpillingKt.nullOutSpilledVariable(intent);
                            scheme_androidKt$openScheme$1.label = 1;
                            Object launchWithProxy = launchWithProxy(context, intent, scheme_androidKt$openScheme$1);
                            if (launchWithProxy == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return launchWithProxy;
                        case 1:
                            Intent intent2 = (Intent) scheme_androidKt$openScheme$1.L$2;
                            String str = (String) scheme_androidKt$openScheme$1.L$1;
                            ClickContext clickContext = (ClickContext) scheme_androidKt$openScheme$1.L$0;
                            ResultKt.throwOnFailure($result);
                            return $result;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (scheme_androidKt$openScheme$1.label) {
            }
        } catch (Exception e) {
            return new CallUpResult.Failure(new CallUpFailureReason.InternalError(e.getLocalizedMessage()));
        }
        scheme_androidKt$openScheme$1 = new Scheme_androidKt$openScheme$1(continuation);
        Object $result2 = scheme_androidKt$openScheme$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object launchWithProxy(final ClickContext context, Intent targetIntent, Continuation<? super CallUpResult> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation cont = safeContinuation;
        String callbackId = CallUpCallbacks.INSTANCE.registerCallback(new CallUpCallback() { // from class: kntr.app.ad.domain.click.internal.interop.Scheme_androidKt$launchWithProxy$2$callbackId$1
            @Override // kntr.app.ad.domain.click.internal.callup.CallUpCallback
            public void onShowSystemAlert() {
                ActionUiEvent actionUiEvent;
                ClickContext clickContext = ClickContext.this;
                if (ClickContext.this.getService().getFrom() == ClickFrom.Native) {
                    actionUiEvent = ActionUiEvent.CALLUP_SUC_NA_POPUP_SHOW_AGREE;
                } else {
                    actionUiEvent = ActionUiEvent.CALLUP_SUC_H5_POPUP_SHOW_AGREE;
                }
                IClickContext.CC.reportUi$default(clickContext, actionUiEvent, null, 2, null);
            }

            @Override // kntr.app.ad.domain.click.internal.callup.CallUpCallback
            public void onResult(CallUpResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Continuation<CallUpResult> continuation2 = cont;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(result));
            }

            @Override // kntr.app.ad.domain.click.internal.callup.CallUpCallback
            public void onStayDuration(final long duration) {
                ActionUiEvent actionUiEvent;
                ClickContext clickContext = ClickContext.this;
                if (ClickContext.this.getService().getFrom() == ClickFrom.Native) {
                    actionUiEvent = ActionUiEvent.NA_CALLUP_APP_STAY_TIME;
                } else {
                    actionUiEvent = ActionUiEvent.H5_CALLUP_APP_STAY_TIME;
                }
                clickContext.reportUi(actionUiEvent, new Function1<IReportExtraHandler, Unit>() { // from class: kntr.app.ad.domain.click.internal.interop.Scheme_androidKt$launchWithProxy$2$callbackId$1$onStayDuration$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        invoke((IReportExtraHandler) p1);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(IReportExtraHandler $this$reportUi) {
                        Intrinsics.checkNotNullParameter($this$reportUi, "$this$reportUi");
                        TuplesKt.to(ActionUiExtra.SHOW_TIME, Long.valueOf(duration));
                    }
                });
            }
        });
        Intent proxyIntent = CallUpProxyActivity.Companion.createLaunchIntent(context.getService().getPlatformContext(), targetIntent, callbackId);
        context.getService().getPlatformContext().startActivity(proxyIntent);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}