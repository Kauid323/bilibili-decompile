package tv.danmaku.bili.stepbystep;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StepByStepBottomSheetLoginActivity.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$3$1 extends FunctionReferenceImpl implements Function1<IStepByStepLoginAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StepByStepBottomSheetLoginActivity$onCreate$1$1$4$1$3$1(Object obj) {
        super(1, obj, StepByStepBottomSheetLoginActivity.class, "dispatch", "dispatch(Ltv/danmaku/bili/stepbystep/IStepByStepLoginAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IStepByStepLoginAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IStepByStepLoginAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((StepByStepBottomSheetLoginActivity) this.receiver).dispatch(p0);
    }
}