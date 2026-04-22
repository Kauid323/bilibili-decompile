package im.session.service;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;

/* compiled from: IMSessionCacheService.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lim/session/service/IMSessionCacheKey;", "", "userID", "", "<init>", "(J)V", "getUserID", "()J", "prefix", "", "keyString", "getKeyString", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class IMSessionCacheKey {
    private final String prefix = "session_list";
    private final long userID;

    public static /* synthetic */ IMSessionCacheKey copy$default(IMSessionCacheKey iMSessionCacheKey, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = iMSessionCacheKey.userID;
        }
        return iMSessionCacheKey.copy(j);
    }

    public final long component1() {
        return this.userID;
    }

    public final IMSessionCacheKey copy(long j) {
        return new IMSessionCacheKey(j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMSessionCacheKey) && this.userID == ((IMSessionCacheKey) obj).userID;
    }

    public int hashCode() {
        return ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.userID);
    }

    public String toString() {
        return "IMSessionCacheKey(userID=" + this.userID + ")";
    }

    public IMSessionCacheKey(long userID) {
        this.userID = userID;
    }

    public final long getUserID() {
        return this.userID;
    }

    public final String getKeyString() {
        String str = this.prefix;
        return str + "." + this.userID;
    }
}