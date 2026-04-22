package kntr.base.imageloader;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalLifeCycle.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lkntr/base/imageloader/GlobalLifeCycle;", "Landroidx/lifecycle/Lifecycle;", "<init>", "()V", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class GlobalLifeCycle extends Lifecycle {
    public static final int $stable = 8;

    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.CREATED;
    }

    public void addObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }
}