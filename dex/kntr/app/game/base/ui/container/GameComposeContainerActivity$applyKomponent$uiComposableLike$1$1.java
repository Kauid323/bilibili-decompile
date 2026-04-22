package kntr.app.game.base.ui.container;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameComposeContainer.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class GameComposeContainerActivity$applyKomponent$uiComposableLike$1$1 extends FunctionReferenceImpl implements Function0<Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GameComposeContainerActivity$applyKomponent$uiComposableLike$1$1(Object obj) {
        super(0, obj, GameComposeContainerActivity.class, "finish", "finish()V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1073invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: collision with other method in class */
    public final void m1073invoke() {
        ((GameComposeContainerActivity) this.receiver).finish();
    }
}