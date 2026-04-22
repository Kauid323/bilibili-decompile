package tv.danmaku.bili.change;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AccountSwitchFragment.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final /* synthetic */ class AccountSwitchFragment$onCreateView$1$1$1$2$1 extends FunctionReferenceImpl implements Function1<ISwitchAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountSwitchFragment$onCreateView$1$1$1$2$1(Object obj) {
        super(1, obj, AccountSwitchViewModel.class, "handleAction", "handleAction(Ltv/danmaku/bili/change/ISwitchAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((ISwitchAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(ISwitchAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((AccountSwitchViewModel) this.receiver).handleAction(p0);
    }
}