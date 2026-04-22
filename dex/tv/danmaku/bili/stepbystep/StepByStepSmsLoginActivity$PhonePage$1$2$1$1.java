package tv.danmaku.bili.stepbystep;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepSmsLoginActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class StepByStepSmsLoginActivity$PhonePage$1$2$1$1 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepSmsLoginActivity$PhonePage$1$2$1$1(Object obj) {
        super(2, obj, StepByStepSmsLoginActivity.class, "routeTo", "routeTo(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, (Bundle) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StepByStepSmsLoginActivity) this.receiver).routeTo(p0, p1);
    }
}