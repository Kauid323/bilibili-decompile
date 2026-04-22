package im.session.home;

import kntr.common.pv.PvState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionHomePage.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkntr/common/pv/PvState;", "pvState", "isSelected", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.home.IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1", f = "IMSessionHomePage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1 extends SuspendLambda implements Function3<PvState, Boolean, Continuation<? super PvState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1(Continuation<? super IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1> continuation) {
        super(3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((PvState) obj, ((Boolean) obj2).booleanValue(), (Continuation) obj3);
    }

    public final Object invoke(PvState pvState, boolean z, Continuation<? super PvState> continuation) {
        IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1 iMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1 = new IMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1(continuation);
        iMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1.L$0 = pvState;
        iMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1.Z$0 = z;
        return iMSessionHomePageKt$rememberTabStatePvEventTrigger$1$combinedStateFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PvState pvState = (PvState) this.L$0;
        boolean isSelected = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return (pvState == PvState.Visible && isSelected) ? PvState.Visible : PvState.Invisible;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}