package kntr.base.router.target;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParameterInvalidTarget.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/base/router/target/ParameterInvalidTarget;", "Lkntr/base/router/target/RouterTarget;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ParameterInvalidTarget implements RouterTarget {
    private final String message;

    public static /* synthetic */ ParameterInvalidTarget copy$default(ParameterInvalidTarget parameterInvalidTarget, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parameterInvalidTarget.message;
        }
        return parameterInvalidTarget.copy(str);
    }

    public final String component1() {
        return this.message;
    }

    public final ParameterInvalidTarget copy(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        return new ParameterInvalidTarget(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ParameterInvalidTarget) && Intrinsics.areEqual(this.message, ((ParameterInvalidTarget) obj).message);
    }

    public int hashCode() {
        return this.message.hashCode();
    }

    public String toString() {
        return "ParameterInvalidTarget(message=" + this.message + ")";
    }

    public ParameterInvalidTarget(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
    }

    public final String getMessage() {
        return this.message;
    }
}