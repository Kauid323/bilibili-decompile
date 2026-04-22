package tv.danmaku.bili.auth.v2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/auth/v2/AuthState;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$beforeFacial$checked$1", f = "BiliAuthFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$beforeFacial$checked$1 extends SuspendLambda implements Function2<AuthState, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthFragmentV2$beforeFacial$checked$1(Continuation<? super BiliAuthFragmentV2$beforeFacial$checked$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> biliAuthFragmentV2$beforeFacial$checked$1 = new BiliAuthFragmentV2$beforeFacial$checked$1(continuation);
        biliAuthFragmentV2$beforeFacial$checked$1.L$0 = obj;
        return biliAuthFragmentV2$beforeFacial$checked$1;
    }

    public final Object invoke(AuthState authState, Continuation<? super Boolean> continuation) {
        return create(authState, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                AuthState it = (AuthState) this.L$0;
                return Boxing.boxBoolean(it.getLocalValidChecked() && it.getRemoteValidChecked());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}