package kntr.base.account;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountEvent.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lkntr/base/account/AccountEvent;", "", "LoginFromOtherSystem", "Lkntr/base/account/AccountEvent$LoginFromOtherSystem;", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface AccountEvent {

    /* compiled from: AccountEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkntr/base/account/AccountEvent$LoginFromOtherSystem;", "Lkntr/base/account/AccountEvent;", "event", "<init>", "(Lkntr/base/account/AccountEvent;)V", "getEvent", "()Lkntr/base/account/AccountEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    private static final class LoginFromOtherSystem implements AccountEvent {
        private final AccountEvent event;

        public static /* synthetic */ LoginFromOtherSystem copy$default(LoginFromOtherSystem loginFromOtherSystem, AccountEvent accountEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                accountEvent = loginFromOtherSystem.event;
            }
            return loginFromOtherSystem.copy(accountEvent);
        }

        public final AccountEvent component1() {
            return this.event;
        }

        public final LoginFromOtherSystem copy(AccountEvent accountEvent) {
            Intrinsics.checkNotNullParameter(accountEvent, "event");
            return new LoginFromOtherSystem(accountEvent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoginFromOtherSystem) && Intrinsics.areEqual(this.event, ((LoginFromOtherSystem) obj).event);
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        public String toString() {
            return "LoginFromOtherSystem(event=" + this.event + ")";
        }

        public LoginFromOtherSystem(AccountEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public final AccountEvent getEvent() {
            return this.event;
        }
    }
}