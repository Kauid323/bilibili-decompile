package tv.danmaku.bili.inner;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.state.IFullscreenAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: InnerLoginFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class InnerLoginFragment$onCreateView$1$1$1$3$1$1 extends FunctionReferenceImpl implements Function1<IFullscreenAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InnerLoginFragment$onCreateView$1$1$1$3$1$1(Object obj) {
        super(1, obj, InnerLoginViewModel.class, "dispatchAction", "dispatchAction(Ltv/danmaku/bili/fullscreen/state/IFullscreenAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IFullscreenAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IFullscreenAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((InnerLoginViewModel) this.receiver).dispatchAction(p0);
    }
}