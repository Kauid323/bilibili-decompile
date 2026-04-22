package im.setting;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingPage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class IMSettingPageKt$SettingPage$onAction$1$1 extends FunctionReferenceImpl implements Function1<IMSettingAction, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public IMSettingPageKt$SettingPage$onAction$1$1(Object obj) {
        super(1, obj, SettingViewModel.class, "dispatch", "dispatch(Lim/setting/IMSettingAction;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((IMSettingAction) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(IMSettingAction p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SettingViewModel) this.receiver).dispatch(p0);
    }
}