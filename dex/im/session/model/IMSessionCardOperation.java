package im.session.model;

import com.tencent.tauth.AuthActivity;
import im.session.IMAction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionCardOperation.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lim/session/model/IMSessionCardOperation;", "", "type", "Lim/session/model/IMSessionCardOperationType;", "text", "", AuthActivity.ACTION_KEY, "Lim/session/IMAction;", "<init>", "(Lim/session/model/IMSessionCardOperationType;Ljava/lang/String;Lim/session/IMAction;)V", "getType", "()Lim/session/model/IMSessionCardOperationType;", "getText", "()Ljava/lang/String;", "getAction", "()Lim/session/IMAction;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionCardOperation {
    private final IMAction action;
    private final String text;
    private final IMSessionCardOperationType type;

    public static /* synthetic */ IMSessionCardOperation copy$default(IMSessionCardOperation iMSessionCardOperation, IMSessionCardOperationType iMSessionCardOperationType, String str, IMAction iMAction, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMSessionCardOperationType = iMSessionCardOperation.type;
        }
        if ((i2 & 2) != 0) {
            str = iMSessionCardOperation.text;
        }
        if ((i2 & 4) != 0) {
            iMAction = iMSessionCardOperation.action;
        }
        return iMSessionCardOperation.copy(iMSessionCardOperationType, str, iMAction);
    }

    public final IMSessionCardOperationType component1() {
        return this.type;
    }

    public final String component2() {
        return this.text;
    }

    public final IMAction component3() {
        return this.action;
    }

    public final IMSessionCardOperation copy(IMSessionCardOperationType iMSessionCardOperationType, String str, IMAction iMAction) {
        Intrinsics.checkNotNullParameter(iMSessionCardOperationType, "type");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(iMAction, AuthActivity.ACTION_KEY);
        return new IMSessionCardOperation(iMSessionCardOperationType, str, iMAction);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionCardOperation) {
            IMSessionCardOperation iMSessionCardOperation = (IMSessionCardOperation) obj;
            return this.type == iMSessionCardOperation.type && Intrinsics.areEqual(this.text, iMSessionCardOperation.text) && Intrinsics.areEqual(this.action, iMSessionCardOperation.action);
        }
        return false;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.text.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        IMSessionCardOperationType iMSessionCardOperationType = this.type;
        String str = this.text;
        return "IMSessionCardOperation(type=" + iMSessionCardOperationType + ", text=" + str + ", action=" + this.action + ")";
    }

    public IMSessionCardOperation(IMSessionCardOperationType type, String text, IMAction action) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        this.type = type;
        this.text = text;
        this.action = action;
    }

    public final IMSessionCardOperationType getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final IMAction getAction() {
        return this.action;
    }
}