package im.contact;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lim/contact/IMContactPageEventHandler;", "", "actionHandler", "Lim/contact/IMContactActionHandler;", "<init>", "(Lim/contact/IMContactActionHandler;)V", "getActionHandler", "()Lim/contact/IMContactActionHandler;", "contact-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageEventHandler {
    public static final int $stable = 0;
    private final IMContactActionHandler actionHandler;

    public IMContactPageEventHandler(IMContactActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.actionHandler = actionHandler;
    }

    public final IMContactActionHandler getActionHandler() {
        return this.actionHandler;
    }
}