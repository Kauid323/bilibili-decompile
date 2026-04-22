package kntr.common.ouro.ui.span;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroDrawableSpan.kt */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\n\n\u0002\u0010\u0007\u0012\u0004\b\u0006\u0010\u0003R\u0014\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lkntr/common/ouro/ui/span/MockLifecycle;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "_lifecycleOwner", "kntr/common/ouro/ui/span/MockLifecycle$_lifecycleOwner$1", "get_lifecycleOwner$annotations", "Lkntr/common/ouro/ui/span/MockLifecycle$_lifecycleOwner$1;", "_lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "get_lifecycle$annotations", "value", "Landroidx/lifecycle/Lifecycle$State;", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MockLifecycle extends Lifecycle {
    public static final int $stable = 8;
    private final MockLifecycle$_lifecycleOwner$1 _lifecycleOwner = new LifecycleOwner() { // from class: kntr.common.ouro.ui.span.MockLifecycle$_lifecycleOwner$1
        public Lifecycle getLifecycle() {
            Lifecycle lifecycle;
            lifecycle = MockLifecycle.this._lifecycle;
            return lifecycle;
        }
    };
    private final LifecycleRegistry _lifecycle = new LifecycleRegistry(this._lifecycleOwner);

    private static /* synthetic */ void get_lifecycle$annotations() {
    }

    private static /* synthetic */ void get_lifecycleOwner$annotations() {
    }

    public Lifecycle.State getCurrentState() {
        return this._lifecycle.getCurrentState();
    }

    public void setCurrentState(Lifecycle.State value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._lifecycle.setCurrentState(value);
    }

    public void addObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this._lifecycle.addObserver(observer);
    }

    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this._lifecycle.removeObserver(observer);
    }
}