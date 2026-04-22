package im.session.common;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lim/session/common/IMSessionEventHandler;", "", "routeHandler", "Lim/session/common/IMSessionRouteHandler;", "cardLongClickHandler", "Lim/session/common/IMSessionCardLongClickHandler;", "actionHandler", "Lim/session/common/IMSessionActionHandler;", "<init>", "(Lim/session/common/IMSessionRouteHandler;Lim/session/common/IMSessionCardLongClickHandler;Lim/session/common/IMSessionActionHandler;)V", "getRouteHandler", "()Lim/session/common/IMSessionRouteHandler;", "getCardLongClickHandler", "()Lim/session/common/IMSessionCardLongClickHandler;", "getActionHandler", "()Lim/session/common/IMSessionActionHandler;", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionEventHandler {
    public static final int $stable = 0;
    private final IMSessionActionHandler actionHandler;
    private final IMSessionCardLongClickHandler cardLongClickHandler;
    private final IMSessionRouteHandler routeHandler;

    public IMSessionEventHandler(IMSessionRouteHandler routeHandler, IMSessionCardLongClickHandler cardLongClickHandler, IMSessionActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(routeHandler, "routeHandler");
        Intrinsics.checkNotNullParameter(cardLongClickHandler, "cardLongClickHandler");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.routeHandler = routeHandler;
        this.cardLongClickHandler = cardLongClickHandler;
        this.actionHandler = actionHandler;
    }

    public final IMSessionRouteHandler getRouteHandler() {
        return this.routeHandler;
    }

    public final IMSessionCardLongClickHandler getCardLongClickHandler() {
        return this.cardLongClickHandler;
    }

    public final IMSessionActionHandler getActionHandler() {
        return this.actionHandler;
    }
}