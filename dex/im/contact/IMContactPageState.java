package im.contact;

import androidx.compose.runtime.State;
import com.tencent.tauth.AuthActivity;
import im.contact.model.IMContactPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPage.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001f\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lim/contact/IMContactPageState;", "", "page", "Landroidx/compose/runtime/State;", "Lim/contact/model/IMContactPageData;", "eventHandler", "Lim/contact/IMContactPageEventHandler;", "<init>", "(Landroidx/compose/runtime/State;Lim/contact/IMContactPageEventHandler;)V", AuthActivity.ACTION_KEY, "Lim/contact/IMContactActionHandler;", "(Landroidx/compose/runtime/State;Lim/contact/IMContactActionHandler;)V", "getPage", "()Landroidx/compose/runtime/State;", "getEventHandler", "()Lim/contact/IMContactPageEventHandler;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "contact-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageState {
    public static final int $stable = 0;
    private final IMContactPageEventHandler eventHandler;
    private final State<IMContactPageData> page;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IMContactPageState copy$default(IMContactPageState iMContactPageState, State state, IMContactPageEventHandler iMContactPageEventHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = iMContactPageState.page;
        }
        if ((i2 & 2) != 0) {
            iMContactPageEventHandler = iMContactPageState.eventHandler;
        }
        return iMContactPageState.copy(state, iMContactPageEventHandler);
    }

    public final State<IMContactPageData> component1() {
        return this.page;
    }

    public final IMContactPageEventHandler component2() {
        return this.eventHandler;
    }

    public final IMContactPageState copy(State<IMContactPageData> state, IMContactPageEventHandler iMContactPageEventHandler) {
        Intrinsics.checkNotNullParameter(state, "page");
        Intrinsics.checkNotNullParameter(iMContactPageEventHandler, "eventHandler");
        return new IMContactPageState(state, iMContactPageEventHandler);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactPageState) {
            IMContactPageState iMContactPageState = (IMContactPageState) obj;
            return Intrinsics.areEqual(this.page, iMContactPageState.page) && Intrinsics.areEqual(this.eventHandler, iMContactPageState.eventHandler);
        }
        return false;
    }

    public int hashCode() {
        return (this.page.hashCode() * 31) + this.eventHandler.hashCode();
    }

    public String toString() {
        State<IMContactPageData> state = this.page;
        return "IMContactPageState(page=" + state + ", eventHandler=" + this.eventHandler + ")";
    }

    public IMContactPageState(State<IMContactPageData> state, IMContactPageEventHandler eventHandler) {
        Intrinsics.checkNotNullParameter(state, "page");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.page = state;
        this.eventHandler = eventHandler;
    }

    public final State<IMContactPageData> getPage() {
        return this.page;
    }

    public final IMContactPageEventHandler getEventHandler() {
        return this.eventHandler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IMContactPageState(State<IMContactPageData> state, IMContactActionHandler action) {
        this(state, new IMContactPageEventHandler(action));
        Intrinsics.checkNotNullParameter(state, "page");
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
    }
}