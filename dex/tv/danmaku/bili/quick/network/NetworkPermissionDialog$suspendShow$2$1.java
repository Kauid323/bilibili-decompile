package tv.danmaku.bili.quick.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: NetworkPermissionDialog.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
final /* synthetic */ class NetworkPermissionDialog$suspendShow$2$1 extends FunctionReferenceImpl implements Function1<NetworkDialogResult, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NetworkPermissionDialog$suspendShow$2$1(Object obj) {
        super(1, obj, ContinuationKt.class, "resume", "resume(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)V", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((NetworkDialogResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(NetworkDialogResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Result.Companion companion = Result.Companion;
        ((Continuation) this.receiver).resumeWith(Result.constructor-impl(p0));
    }
}