package im.setting;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSettingPage.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lim/setting/IMSettingEventHandler;", "", "routeHandler", "Lim/setting/IMSettingRouteHandler;", "actionHandler", "Lim/setting/IMSettingActionHandler;", "<init>", "(Lim/setting/IMSettingRouteHandler;Lim/setting/IMSettingActionHandler;)V", "getRouteHandler", "()Lim/setting/IMSettingRouteHandler;", "getActionHandler", "()Lim/setting/IMSettingActionHandler;", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingEventHandler {
    public static final int $stable = 0;
    private final IMSettingActionHandler actionHandler;
    private final IMSettingRouteHandler routeHandler;

    public IMSettingEventHandler(IMSettingRouteHandler routeHandler, IMSettingActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(routeHandler, "routeHandler");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.routeHandler = routeHandler;
        this.actionHandler = actionHandler;
    }

    public final IMSettingRouteHandler getRouteHandler() {
        return this.routeHandler;
    }

    public final IMSettingActionHandler getActionHandler() {
        return this.actionHandler;
    }
}