package kntr.app.tribee.invite.viewmodel;

import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: TribeeInviteStateAction.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;", "", "Initiate", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction$Initiate;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeInviteStateAction {

    /* compiled from: TribeeInviteStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction$Initiate;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteStateAction;", "fromTribeeId", "", "<init>", "(J)V", "getFromTribeeId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Initiate implements TribeeInviteStateAction {
        public static final int $stable = 0;
        private final long fromTribeeId;

        public static /* synthetic */ Initiate copy$default(Initiate initiate, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = initiate.fromTribeeId;
            }
            return initiate.copy(j);
        }

        public final long component1() {
            return this.fromTribeeId;
        }

        public final Initiate copy(long j) {
            return new Initiate(j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Initiate) && this.fromTribeeId == ((Initiate) obj).fromTribeeId;
        }

        public int hashCode() {
            return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.fromTribeeId);
        }

        public String toString() {
            return "Initiate(fromTribeeId=" + this.fromTribeeId + ")";
        }

        public Initiate(long fromTribeeId) {
            this.fromTribeeId = fromTribeeId;
        }

        public final long getFromTribeeId() {
            return this.fromTribeeId;
        }
    }
}