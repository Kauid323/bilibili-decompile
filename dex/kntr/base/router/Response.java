package kntr.base.router;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.target.RouterTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Router.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/router/Response;", "", "NotIntercepted", "ContextMissing", "Done", "Lkntr/base/router/Response$ContextMissing;", "Lkntr/base/router/Response$Done;", "Lkntr/base/router/Response$NotIntercepted;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface Response {

    /* compiled from: Router.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/router/Response$NotIntercepted;", "Lkntr/base/router/Response;", "target", "Lkntr/base/router/target/RouterTarget;", "<init>", "(Lkntr/base/router/target/RouterTarget;)V", "getTarget", "()Lkntr/base/router/target/RouterTarget;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NotIntercepted implements Response {
        private final RouterTarget target;

        public static /* synthetic */ NotIntercepted copy$default(NotIntercepted notIntercepted, RouterTarget routerTarget, int i, Object obj) {
            if ((i & 1) != 0) {
                routerTarget = notIntercepted.target;
            }
            return notIntercepted.copy(routerTarget);
        }

        public final RouterTarget component1() {
            return this.target;
        }

        public final NotIntercepted copy(RouterTarget routerTarget) {
            Intrinsics.checkNotNullParameter(routerTarget, "target");
            return new NotIntercepted(routerTarget);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NotIntercepted) && Intrinsics.areEqual(this.target, ((NotIntercepted) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "NotIntercepted(target=" + this.target + ")";
        }

        public NotIntercepted(RouterTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            this.target = target;
        }

        public final RouterTarget getTarget() {
            return this.target;
        }
    }

    /* compiled from: Router.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/router/Response$ContextMissing;", "Lkntr/base/router/Response;", "target", "Lkntr/base/router/target/RouterTarget;", "<init>", "(Lkntr/base/router/target/RouterTarget;)V", "getTarget", "()Lkntr/base/router/target/RouterTarget;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ContextMissing implements Response {
        private final RouterTarget target;

        public static /* synthetic */ ContextMissing copy$default(ContextMissing contextMissing, RouterTarget routerTarget, int i, Object obj) {
            if ((i & 1) != 0) {
                routerTarget = contextMissing.target;
            }
            return contextMissing.copy(routerTarget);
        }

        public final RouterTarget component1() {
            return this.target;
        }

        public final ContextMissing copy(RouterTarget routerTarget) {
            Intrinsics.checkNotNullParameter(routerTarget, "target");
            return new ContextMissing(routerTarget);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContextMissing) && Intrinsics.areEqual(this.target, ((ContextMissing) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "ContextMissing(target=" + this.target + ")";
        }

        public ContextMissing(RouterTarget target) {
            Intrinsics.checkNotNullParameter(target, "target");
            this.target = target;
        }

        public final RouterTarget getTarget() {
            return this.target;
        }
    }

    /* compiled from: Router.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/router/Response$Done;", "Lkntr/base/router/Response;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Done implements Response {
        public static final Done INSTANCE = new Done();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Done) {
                Done done = (Done) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1552669286;
        }

        public String toString() {
            return "Done";
        }

        private Done() {
        }
    }
}