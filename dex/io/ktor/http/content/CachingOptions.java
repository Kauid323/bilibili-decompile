package io.ktor.http.content;

import io.ktor.http.CacheControl;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CachingOptions.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ(\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\tR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u000b¨\u0006\u001c"}, d2 = {"Lio/ktor/http/content/CachingOptions;", "", "Lio/ktor/http/CacheControl;", "cacheControl", "Lio/ktor/util/date/GMTDate;", "expires", "<init>", "(Lio/ktor/http/CacheControl;Lio/ktor/util/date/GMTDate;)V", "component1", "()Lio/ktor/http/CacheControl;", "component2", "()Lio/ktor/util/date/GMTDate;", "copy", "(Lio/ktor/http/CacheControl;Lio/ktor/util/date/GMTDate;)Lio/ktor/http/content/CachingOptions;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lio/ktor/http/CacheControl;", "getCacheControl", "Lio/ktor/util/date/GMTDate;", "getExpires", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CachingOptions {
    private final CacheControl cacheControl;
    private final GMTDate expires;

    public CachingOptions() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ CachingOptions copy$default(CachingOptions cachingOptions, CacheControl cacheControl, GMTDate gMTDate, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cacheControl = cachingOptions.cacheControl;
        }
        if ((i2 & 2) != 0) {
            gMTDate = cachingOptions.expires;
        }
        return cachingOptions.copy(cacheControl, gMTDate);
    }

    public final CacheControl component1() {
        return this.cacheControl;
    }

    public final GMTDate component2() {
        return this.expires;
    }

    public final CachingOptions copy(CacheControl cacheControl, GMTDate gMTDate) {
        return new CachingOptions(cacheControl, gMTDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachingOptions) {
            CachingOptions cachingOptions = (CachingOptions) obj;
            return Intrinsics.areEqual(this.cacheControl, cachingOptions.cacheControl) && Intrinsics.areEqual(this.expires, cachingOptions.expires);
        }
        return false;
    }

    public int hashCode() {
        return ((this.cacheControl == null ? 0 : this.cacheControl.hashCode()) * 31) + (this.expires != null ? this.expires.hashCode() : 0);
    }

    public String toString() {
        return "CachingOptions(cacheControl=" + this.cacheControl + ", expires=" + this.expires + ')';
    }

    public CachingOptions(CacheControl cacheControl, GMTDate expires) {
        this.cacheControl = cacheControl;
        this.expires = expires;
    }

    public /* synthetic */ CachingOptions(CacheControl cacheControl, GMTDate gMTDate, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : cacheControl, (i2 & 2) != 0 ? null : gMTDate);
    }

    public final CacheControl getCacheControl() {
        return this.cacheControl;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }
}