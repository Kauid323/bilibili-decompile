package im.contact.model;

import faceverify.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: IMContactPageData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lim/contact/model/ToastHolder;", "", q.KEY_RES_9_CONTENT, "", "ts", "Lkotlinx/datetime/Instant;", "<init>", "(Ljava/lang/String;Lkotlinx/datetime/Instant;)V", "getContent$annotations", "()V", "getContent", "()Ljava/lang/String;", "getTs", "()Lkotlinx/datetime/Instant;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ToastHolder {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final Instant ts;

    public ToastHolder() {
        this(null, null, 3, null);
    }

    public static /* synthetic */ ToastHolder copy$default(ToastHolder toastHolder, String str, Instant instant, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = toastHolder.content;
        }
        if ((i2 & 2) != 0) {
            instant = toastHolder.ts;
        }
        return toastHolder.copy(str, instant);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public final String component1() {
        return this.content;
    }

    public final Instant component2() {
        return this.ts;
    }

    public final ToastHolder copy(String str, Instant instant) {
        Intrinsics.checkNotNullParameter(str, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(instant, "ts");
        return new ToastHolder(str, instant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ToastHolder) {
            ToastHolder toastHolder = (ToastHolder) obj;
            return Intrinsics.areEqual(this.content, toastHolder.content) && Intrinsics.areEqual(this.ts, toastHolder.ts);
        }
        return false;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + this.ts.hashCode();
    }

    public String toString() {
        String str = this.content;
        return "ToastHolder(content=" + str + ", ts=" + this.ts + ")";
    }

    public ToastHolder(String content, Instant ts) {
        Intrinsics.checkNotNullParameter(content, q.KEY_RES_9_CONTENT);
        Intrinsics.checkNotNullParameter(ts, "ts");
        this.content = content;
        this.ts = ts;
    }

    public /* synthetic */ ToastHolder(String str, Instant instant, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? Clock.System.INSTANCE.now() : instant);
    }

    public final String getContent() {
        return this.content;
    }

    public final Instant getTs() {
        return this.ts;
    }

    /* compiled from: IMContactPageData.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lim/contact/model/ToastHolder$Companion;", "", "<init>", "()V", "from", "Lim/contact/model/ToastHolder;", "throwable", "", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToastHolder from(Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            String message = throwable.getMessage();
            if (message == null) {
                message = "Unknown error";
            }
            return new ToastHolder(message, null, 2, null);
        }
    }
}