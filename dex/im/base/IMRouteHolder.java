package im.base;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bilibili.blens.Lens;
import com.bilibili.lib.brouter.uri.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;

/* compiled from: IMRouteHolder.kt */
@Lens.Ignore
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÂ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÂ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lim/base/IMRouteHolder;", "", "url", "Lcom/bilibili/lib/brouter/uri/Uri;", "ts", "", "<init>", "(Lcom/bilibili/lib/brouter/uri/Uri;J)V", "getUrl$annotations", "()V", "getUrl", "()Lcom/bilibili/lib/brouter/uri/Uri;", "urlStr", "", "getUrlStr", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMRouteHolder {
    public static final Companion Companion = new Companion(null);
    private static final IMRouteHolder empty = Companion.create((Uri) null);
    private final long ts;
    private final Uri url;
    private final String urlStr;

    public /* synthetic */ IMRouteHolder(Uri uri, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, j);
    }

    private final long component2() {
        return this.ts;
    }

    private final IMRouteHolder copy(Uri uri, long j) {
        return new IMRouteHolder(uri, j);
    }

    static /* synthetic */ IMRouteHolder copy$default(IMRouteHolder iMRouteHolder, Uri uri, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uri = iMRouteHolder.url;
        }
        if ((i2 & 2) != 0) {
            j = iMRouteHolder.ts;
        }
        return iMRouteHolder.copy(uri, j);
    }

    public static /* synthetic */ void getUrl$annotations() {
    }

    public final Uri component1() {
        return this.url;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMRouteHolder) {
            IMRouteHolder iMRouteHolder = (IMRouteHolder) obj;
            return Intrinsics.areEqual(this.url, iMRouteHolder.url) && this.ts == iMRouteHolder.ts;
        }
        return false;
    }

    public int hashCode() {
        return ((this.url == null ? 0 : this.url.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.ts);
    }

    public String toString() {
        Uri uri = this.url;
        return "IMRouteHolder(url=" + uri + ", ts=" + this.ts + ")";
    }

    private IMRouteHolder(Uri url, long ts) {
        this.url = url;
        this.ts = ts;
        this.urlStr = String.valueOf(this.url);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final String getUrlStr() {
        return this.urlStr;
    }

    /* compiled from: IMRouteHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lim/base/IMRouteHolder$Companion;", "", "<init>", "()V", "empty", "Lim/base/IMRouteHolder;", "getEmpty", "()Lim/base/IMRouteHolder;", "create", "url", "Lcom/bilibili/lib/brouter/uri/Uri;", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IMRouteHolder getEmpty() {
            return IMRouteHolder.empty;
        }

        public final IMRouteHolder create(Uri url) {
            return new IMRouteHolder(url, Clock.System.INSTANCE.now().toEpochMilliseconds(), null);
        }

        public final IMRouteHolder create(String url) {
            return create(url != null ? Uri.Companion.parse(url) : null);
        }
    }
}