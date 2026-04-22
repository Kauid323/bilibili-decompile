package tv.danmaku.bili.stepbystep;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepBottomSheetLoginActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$4$1 extends FunctionReferenceImpl implements Function2<String, Bundle, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$4$1(Object obj) {
        super(2, obj, StepByStepBottomSheetLoginActivity.class, "routeTo", "routeTo(Ljava/lang/String;Landroid/os/Bundle;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, (Bundle) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StepByStepBottomSheetLoginActivity) this.receiver).routeTo(p0, p1);
    }
}