package io.ktor.http.content;

import io.ktor.http.DateUtilsKt;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.util.date.DateKt;
import io.ktor.util.date.GMTDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Versions.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b*\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u001aR\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&¨\u0006)"}, d2 = {"Lio/ktor/http/content/LastModifiedVersion;", "Lio/ktor/http/content/Version;", "Lio/ktor/util/date/GMTDate;", "lastModified", "<init>", "(Lio/ktor/util/date/GMTDate;)V", "Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/VersionCheckResult;", "check", "(Lio/ktor/http/Headers;)Lio/ktor/http/content/VersionCheckResult;", "", "dates", "", "ifModifiedSince", "(Ljava/util/List;)Z", "ifUnmodifiedSince", "Lio/ktor/http/HeadersBuilder;", "builder", "", "appendHeadersTo", "(Lio/ktor/http/HeadersBuilder;)V", "", "parseDates", "(Ljava/util/List;)Ljava/util/List;", "component1", "()Lio/ktor/util/date/GMTDate;", "copy", "(Lio/ktor/util/date/GMTDate;)Lio/ktor/http/content/LastModifiedVersion;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Lio/ktor/util/date/GMTDate;", "getLastModified", "truncatedModificationDate", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LastModifiedVersion implements Version {
    private final GMTDate lastModified;
    private final GMTDate truncatedModificationDate;

    public static /* synthetic */ LastModifiedVersion copy$default(LastModifiedVersion lastModifiedVersion, GMTDate gMTDate, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gMTDate = lastModifiedVersion.lastModified;
        }
        return lastModifiedVersion.copy(gMTDate);
    }

    public final GMTDate component1() {
        return this.lastModified;
    }

    public final LastModifiedVersion copy(GMTDate gMTDate) {
        Intrinsics.checkNotNullParameter(gMTDate, "lastModified");
        return new LastModifiedVersion(gMTDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LastModifiedVersion) && Intrinsics.areEqual(this.lastModified, ((LastModifiedVersion) obj).lastModified);
    }

    public int hashCode() {
        return this.lastModified.hashCode();
    }

    public String toString() {
        return "LastModifiedVersion(lastModified=" + this.lastModified + ')';
    }

    public LastModifiedVersion(GMTDate lastModified) {
        Intrinsics.checkNotNullParameter(lastModified, "lastModified");
        this.lastModified = lastModified;
        this.truncatedModificationDate = DateKt.truncateToSeconds(this.lastModified);
    }

    public final GMTDate getLastModified() {
        return this.lastModified;
    }

    @Override // io.ktor.http.content.Version
    public VersionCheckResult check(Headers requestHeaders) {
        Intrinsics.checkNotNullParameter(requestHeaders, "requestHeaders");
        List all = requestHeaders.getAll(HttpHeaders.INSTANCE.getIfModifiedSince());
        List modifiedSince = all != null ? parseDates(all) : null;
        if (modifiedSince != null && !ifModifiedSince(modifiedSince)) {
            return VersionCheckResult.NOT_MODIFIED;
        }
        List all2 = requestHeaders.getAll(HttpHeaders.INSTANCE.getIfUnmodifiedSince());
        List unmodifiedSince = all2 != null ? parseDates(all2) : null;
        if (unmodifiedSince != null && !ifUnmodifiedSince(unmodifiedSince)) {
            return VersionCheckResult.PRECONDITION_FAILED;
        }
        return VersionCheckResult.OK;
    }

    public final boolean ifModifiedSince(List<GMTDate> list) {
        GMTDate it;
        Intrinsics.checkNotNullParameter(list, "dates");
        List<GMTDate> $this$any$iv = list;
        if (($this$any$iv instanceof Collection) && $this$any$iv.isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            GMTDate it2 = (GMTDate) element$iv;
            if (this.truncatedModificationDate.compareTo(it2) > 0) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean ifUnmodifiedSince(List<GMTDate> list) {
        GMTDate it;
        Intrinsics.checkNotNullParameter(list, "dates");
        List<GMTDate> $this$all$iv = list;
        if (($this$all$iv instanceof Collection) && $this$all$iv.isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            GMTDate it2 = (GMTDate) element$iv;
            if (this.truncatedModificationDate.compareTo(it2) <= 0) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it == null) {
                return false;
            }
        }
        return true;
    }

    @Override // io.ktor.http.content.Version
    public void appendHeadersTo(HeadersBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.set(HttpHeaders.INSTANCE.getLastModified(), DateUtilsKt.toHttpDate(this.lastModified));
    }

    private final List<GMTDate> parseDates(List<String> list) {
        List<String> $this$filter$iv = list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!StringsKt.isBlank((String) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        Iterator it = $this$mapNotNull$iv.iterator();
        while (true) {
            GMTDate gMTDate = null;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv$iv = it.next();
            try {
                gMTDate = DateUtilsKt.fromHttpToGmtDate((String) element$iv$iv$iv);
            } catch (Throwable th) {
            }
            if (gMTDate != null) {
                destination$iv$iv2.add(gMTDate);
            }
        }
        List it2 = (List) destination$iv$iv2;
        if (it2.isEmpty()) {
            return null;
        }
        return it2;
    }
}