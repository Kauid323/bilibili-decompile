package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Job.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
public /* synthetic */ class JobKt__JobKt$invokeOnCompletion$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public JobKt__JobKt$invokeOnCompletion$1(Object obj) {
        super(1, obj, InternalCompletionHandler.class, "invoke", "invoke(Ljava/lang/Throwable;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable p0) {
        ((InternalCompletionHandler) this.receiver).invoke(p0);
    }
}