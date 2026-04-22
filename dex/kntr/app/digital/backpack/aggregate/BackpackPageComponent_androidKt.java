package kntr.app.digital.backpack.aggregate;

import kntr.app.digital.backpack.aggregate.BackpackPageComponent;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackpackPageComponent.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"backpackPageComponentFactory", "Lkntr/app/digital/backpack/aggregate/BackpackPageComponent$Factory;", "bagRouterTarget", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "backpack_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BackpackPageComponent_androidKt {
    public static final BackpackPageComponent.Factory backpackPageComponentFactory() {
        return DaggerBackpackPageComponent.Companion.factory();
    }

    public static final RouterTarget bagRouterTarget(RouterTargetContext $this$bagRouterTarget) {
        Intrinsics.checkNotNullParameter($this$bagRouterTarget, "<this>");
        return $this$bagRouterTarget.find($this$bagRouterTarget.getUri().buildUpon().appendPath("kntr").build());
    }
}