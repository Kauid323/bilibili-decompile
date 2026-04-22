package im.session;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMState.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/session/RequestStatus;", "", "Idle", "Loading", "Error", "Lim/session/RequestStatus$Error;", "Lim/session/RequestStatus$Idle;", "Lim/session/RequestStatus$Loading;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RequestStatus {

    /* compiled from: IMState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/session/RequestStatus$Idle;", "Lim/session/RequestStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Idle implements RequestStatus {
        public static final Idle INSTANCE = new Idle();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Idle) {
                Idle idle = (Idle) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1055055901;
        }

        public String toString() {
            return "Idle";
        }

        private Idle() {
        }
    }

    /* compiled from: IMState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lim/session/RequestStatus$Loading;", "Lim/session/RequestStatus;", "refreshList", "", "refreshQuickLink", "<init>", "(ZZ)V", "getRefreshList", "()Z", "getRefreshQuickLink", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Loading implements RequestStatus {
        private final boolean refreshList;
        private final boolean refreshQuickLink;

        public Loading() {
            this(false, false, 3, null);
        }

        public static /* synthetic */ Loading copy$default(Loading loading, boolean z, boolean z2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = loading.refreshList;
            }
            if ((i2 & 2) != 0) {
                z2 = loading.refreshQuickLink;
            }
            return loading.copy(z, z2);
        }

        public final boolean component1() {
            return this.refreshList;
        }

        public final boolean component2() {
            return this.refreshQuickLink;
        }

        public final Loading copy(boolean z, boolean z2) {
            return new Loading(z, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Loading) {
                Loading loading = (Loading) obj;
                return this.refreshList == loading.refreshList && this.refreshQuickLink == loading.refreshQuickLink;
            }
            return false;
        }

        public int hashCode() {
            return (BottomSheetItemData$.ExternalSyntheticBackport0.m(this.refreshList) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.refreshQuickLink);
        }

        public String toString() {
            boolean z = this.refreshList;
            return "Loading(refreshList=" + z + ", refreshQuickLink=" + this.refreshQuickLink + ")";
        }

        public Loading(boolean refreshList, boolean refreshQuickLink) {
            this.refreshList = refreshList;
            this.refreshQuickLink = refreshQuickLink;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Loading(boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i2 & 2) != 0 ? z : z2);
            z = (i2 & 1) != 0 ? true : z;
        }

        public final boolean getRefreshList() {
            return this.refreshList;
        }

        public final boolean getRefreshQuickLink() {
            return this.refreshQuickLink;
        }
    }

    /* compiled from: IMState.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lim/session/RequestStatus$Error;", "Lim/session/RequestStatus;", "error", "", "<init>", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Error implements RequestStatus {
        private final String error;

        public static /* synthetic */ Error copy$default(Error error, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = error.error;
            }
            return error.copy(str);
        }

        public final String component1() {
            return this.error;
        }

        public final Error copy(String str) {
            return new Error(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error);
        }

        public int hashCode() {
            if (this.error == null) {
                return 0;
            }
            return this.error.hashCode();
        }

        public String toString() {
            return "Error(error=" + this.error + ")";
        }

        public Error(String error) {
            this.error = error;
        }

        public final String getError() {
            return this.error;
        }
    }
}