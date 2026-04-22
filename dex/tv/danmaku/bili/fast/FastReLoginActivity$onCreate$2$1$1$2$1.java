package tv.danmaku.bili.fast;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FastReLoginActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class FastReLoginActivity$onCreate$2$1$1$2$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FastReLoginActivity$onCreate$2$1$1$2$1(Object obj) {
        super(1, obj, FastReLoginActivity.class, "clickLogin", "clickLogin(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean p0) {
        ((FastReLoginActivity) this.receiver).clickLogin(p0);
    }
}