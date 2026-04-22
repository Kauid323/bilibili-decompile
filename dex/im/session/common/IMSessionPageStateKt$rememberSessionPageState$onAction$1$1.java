package im.session.common;

import im.session.IMAction;
import im.session.IMSessionViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageState.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class IMSessionPageStateKt$rememberSessionPageState$onAction$1$1 extends FunctionReferenceImpl implements Function1<IMAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSessionPageStateKt$rememberSessionPageState$onAction$1$1(Object obj) {
        super(1, obj, IMSessionViewModel.class, "dispatch", "dispatch(Lim/session/IMAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IMAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IMAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((IMSessionViewModel) this.receiver).dispatch(p0);
    }
}