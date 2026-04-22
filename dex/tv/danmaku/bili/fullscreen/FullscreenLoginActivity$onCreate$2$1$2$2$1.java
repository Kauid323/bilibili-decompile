package tv.danmaku.bili.fullscreen;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FullscreenLoginActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class FullscreenLoginActivity$onCreate$2$1$2$2$1 extends FunctionReferenceImpl implements Function1<String, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public FullscreenLoginActivity$onCreate$2$1$2$2$1(Object obj) {
        super(1, obj, FullscreenLoginActivity.class, "routeTo", "routeTo(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((String) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(String p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((FullscreenLoginActivity) this.receiver).routeTo(p0);
    }
}