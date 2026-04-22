package kntr.common.ouro.core.plugin.localImage;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UploadImageChildStateMachine.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction;", "", "Retry", "Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction$Retry;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UploadImageChildAction {

    /* compiled from: UploadImageChildStateMachine.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction$Retry;", "Lkntr/common/ouro/core/plugin/localImage/UploadImageChildAction;", "identifier", "", "<init>", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Retry implements UploadImageChildAction {
        private final String identifier;

        public static /* synthetic */ Retry copy$default(Retry retry, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = retry.identifier;
            }
            return retry.copy(str);
        }

        public final String component1() {
            return this.identifier;
        }

        public final Retry copy(String str) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            return new Retry(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Retry) && Intrinsics.areEqual(this.identifier, ((Retry) obj).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        public String toString() {
            return "Retry(identifier=" + this.identifier + ")";
        }

        public Retry(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        public final String getIdentifier() {
            return this.identifier;
        }
    }
}