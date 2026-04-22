package kntr.base.dd.preview;

import androidx.compose.runtime.MutableState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.KDeviceDecision;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DDDebuggerPreview.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$1$1$1$1$1", f = "DDDebuggerPreview.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: kntr.base.dd.preview.ComposableSingletons$DDDebuggerPreviewKt$lambda$-18439082$1$1$1$1$1$1  reason: invalid class name */
public final class ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Pair<String, String>> $tipsMsg$delegate;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$1$1$1$1$1(Toaster toaster, MutableState<Pair<String, String>> mutableState, Continuation<? super ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.$toaster = toaster;
        this.$tipsMsg$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$DDDebuggerPreviewKt$lambda$18439082$1$1$1$1$1$1(this.$toaster, this.$tipsMsg$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object updateToLatest$default;
        String errMsg;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Toaster.CC.showToast$default(this.$toaster, "更新中....", null, 2, null);
                this.label = 1;
                updateToLatest$default = IDeviceDecisionUpdater.CC.updateToLatest$default(KDeviceDecision.INSTANCE.getUpdater(), "dd-debugger", null, (Continuation) this, 2, null);
                if (updateToLatest$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                updateToLatest$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        errMsg = DDDebuggerPreviewKt.errorMessage((IDeviceDecisionUpdater.Result) updateToLatest$default);
        if (errMsg == null) {
            Toaster.CC.showToast$default(this.$toaster, "更新成功！", null, 2, null);
        } else {
            this.$tipsMsg$delegate.setValue(TuplesKt.to("更新失败", errMsg));
        }
        return Unit.INSTANCE;
    }
}