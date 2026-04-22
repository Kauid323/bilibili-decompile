package kntr.common.compose.launcher;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ComposeContainer.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class ComposeContainerActivity$applyKomponent$uiComposableLike$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ComposeContainerActivity$applyKomponent$uiComposableLike$1$1(Object obj) {
        super(0, obj, ComposeContainerActivity.class, "finish", "finish()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1847invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m1847invoke() {
        ((ComposeContainerActivity) this.receiver).finish();
    }
}