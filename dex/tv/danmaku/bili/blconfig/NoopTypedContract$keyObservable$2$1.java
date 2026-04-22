package tv.danmaku.bili.blconfig;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "debugKey", "key"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.blconfig.NoopTypedContract$keyObservable$2$1", f = "DebugConfigHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class NoopTypedContract$keyObservable$2$1 extends SuspendLambda implements Function3<String, String, Continuation<? super String>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NoopTypedContract$keyObservable$2$1(Continuation<? super NoopTypedContract$keyObservable$2$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(String str, String str2, Continuation<? super String> continuation) {
        NoopTypedContract$keyObservable$2$1 noopTypedContract$keyObservable$2$1 = new NoopTypedContract$keyObservable$2$1(continuation);
        noopTypedContract$keyObservable$2$1.L$0 = str;
        noopTypedContract$keyObservable$2$1.L$1 = str2;
        return noopTypedContract$keyObservable$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String debugKey = (String) this.L$0;
                String key = (String) this.L$1;
                return debugKey.length() > 0 ? debugKey : key;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}