package io.ktor.http;

import BottomSheetItemData$;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CacheControl.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u00002\u00020\u0001:\u0004\t\n\u000b\fB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lio/ktor/http/CacheControl;", "", "Lio/ktor/http/CacheControl$Visibility;", "visibility", "<init>", "(Lio/ktor/http/CacheControl$Visibility;)V", "Lio/ktor/http/CacheControl$Visibility;", "getVisibility", "()Lio/ktor/http/CacheControl$Visibility;", "Visibility", "NoCache", "NoStore", "MaxAge", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CacheControl {
    private final Visibility visibility;

    public CacheControl(Visibility visibility) {
        this.visibility = visibility;
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    /* compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/ktor/http/CacheControl$Visibility;", "", "", "headerValue", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Ljava/lang/String;", "getHeaderValue$ktor_http", "()Ljava/lang/String;", "Public", "Private", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public enum Visibility {
        Public(io.ktor.client.utils.CacheControl.PUBLIC),
        Private(io.ktor.client.utils.CacheControl.PRIVATE);
        
        private final String headerValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Visibility(String headerValue) {
            this.headerValue = headerValue;
        }

        public final String getHeaderValue$ktor_http() {
            return this.headerValue;
        }

        public static EnumEntries<Visibility> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/CacheControl$NoCache;", "Lio/ktor/http/CacheControl;", "Lio/ktor/http/CacheControl$Visibility;", "visibility", "<init>", "(Lio/ktor/http/CacheControl$Visibility;)V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NoCache extends CacheControl {
        public NoCache(Visibility visibility) {
            super(visibility);
        }

        public String toString() {
            if (getVisibility() == null) {
                return io.ktor.client.utils.CacheControl.NO_CACHE;
            }
            return "no-cache, " + getVisibility().getHeaderValue$ktor_http();
        }

        public boolean equals(Object other) {
            return (other instanceof NoCache) && getVisibility() == ((NoCache) other).getVisibility();
        }

        public int hashCode() {
            Visibility visibility = getVisibility();
            if (visibility != null) {
                return visibility.hashCode();
            }
            return 0;
        }
    }

    /* compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/http/CacheControl$NoStore;", "Lio/ktor/http/CacheControl;", "Lio/ktor/http/CacheControl$Visibility;", "visibility", "<init>", "(Lio/ktor/http/CacheControl$Visibility;)V", "", "toString", "()Ljava/lang/String;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class NoStore extends CacheControl {
        public NoStore(Visibility visibility) {
            super(visibility);
        }

        public String toString() {
            if (getVisibility() == null) {
                return io.ktor.client.utils.CacheControl.NO_STORE;
            }
            return "no-store, " + getVisibility().getHeaderValue$ktor_http();
        }

        public boolean equals(Object other) {
            return (other instanceof NoStore) && ((NoStore) other).getVisibility() == getVisibility();
        }

        public int hashCode() {
            Visibility visibility = getVisibility();
            if (visibility != null) {
                return visibility.hashCode();
            }
            return 0;
        }
    }

    /* compiled from: CacheControl.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001d\u0010\u001c¨\u0006\u001e"}, d2 = {"Lio/ktor/http/CacheControl$MaxAge;", "Lio/ktor/http/CacheControl;", "", "maxAgeSeconds", "proxyMaxAgeSeconds", "", "mustRevalidate", "proxyRevalidate", "Lio/ktor/http/CacheControl$Visibility;", "visibility", "<init>", "(ILjava/lang/Integer;ZZLio/ktor/http/CacheControl$Visibility;)V", "", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "I", "getMaxAgeSeconds", "Ljava/lang/Integer;", "getProxyMaxAgeSeconds", "()Ljava/lang/Integer;", "Z", "getMustRevalidate", "()Z", "getProxyRevalidate", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class MaxAge extends CacheControl {
        private final int maxAgeSeconds;
        private final boolean mustRevalidate;
        private final Integer proxyMaxAgeSeconds;
        private final boolean proxyRevalidate;

        public /* synthetic */ MaxAge(int i2, Integer num, boolean z, boolean z2, Visibility visibility, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? null : visibility);
        }

        public final int getMaxAgeSeconds() {
            return this.maxAgeSeconds;
        }

        public final Integer getProxyMaxAgeSeconds() {
            return this.proxyMaxAgeSeconds;
        }

        public final boolean getMustRevalidate() {
            return this.mustRevalidate;
        }

        public final boolean getProxyRevalidate() {
            return this.proxyRevalidate;
        }

        public MaxAge(int maxAgeSeconds, Integer proxyMaxAgeSeconds, boolean mustRevalidate, boolean proxyRevalidate, Visibility visibility) {
            super(visibility);
            this.maxAgeSeconds = maxAgeSeconds;
            this.proxyMaxAgeSeconds = proxyMaxAgeSeconds;
            this.mustRevalidate = mustRevalidate;
            this.proxyRevalidate = proxyRevalidate;
        }

        public String toString() {
            ArrayList parts = new ArrayList(5);
            parts.add("max-age=" + this.maxAgeSeconds);
            if (this.proxyMaxAgeSeconds != null) {
                parts.add("s-maxage=" + this.proxyMaxAgeSeconds);
            }
            if (this.mustRevalidate) {
                parts.add(io.ktor.client.utils.CacheControl.MUST_REVALIDATE);
            }
            if (this.proxyRevalidate) {
                parts.add(io.ktor.client.utils.CacheControl.PROXY_REVALIDATE);
            }
            if (getVisibility() != null) {
                parts.add(getVisibility().getHeaderValue$ktor_http());
            }
            return CollectionsKt.joinToString$default(parts, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        public boolean equals(Object other) {
            return other == this || ((other instanceof MaxAge) && ((MaxAge) other).maxAgeSeconds == this.maxAgeSeconds && Intrinsics.areEqual(((MaxAge) other).proxyMaxAgeSeconds, this.proxyMaxAgeSeconds) && ((MaxAge) other).mustRevalidate == this.mustRevalidate && ((MaxAge) other).proxyRevalidate == this.proxyRevalidate && ((MaxAge) other).getVisibility() == getVisibility());
        }

        public int hashCode() {
            int result = this.maxAgeSeconds;
            int i2 = result * 31;
            Integer num = this.proxyMaxAgeSeconds;
            int result2 = i2 + (num != null ? num.intValue() : 0);
            int result3 = ((((result2 * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.mustRevalidate)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.proxyRevalidate)) * 31;
            Visibility visibility = getVisibility();
            return result3 + (visibility != null ? visibility.hashCode() : 0);
        }
    }
}