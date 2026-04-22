package im.base.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionId.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u0005J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0000H\u0016¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lim/base/model/SessionId;", "", "checkSameId", "", "other", "Unknown", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SessionId {
    boolean checkSameId(SessionId sessionId);

    /* compiled from: SessionId.kt */
    /* renamed from: im.base.model.SessionId$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$checkSameId(SessionId _this, SessionId other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Intrinsics.areEqual(_this, other);
        }
    }

    /* compiled from: SessionId.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/base/model/SessionId$Unknown;", "Lim/base/model/SessionId;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Unknown implements SessionId {
        public static final Unknown INSTANCE = new Unknown();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Unknown) {
                Unknown unknown = (Unknown) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1930709589;
        }

        public String toString() {
            return "Unknown";
        }

        private Unknown() {
        }

        @Override // im.base.model.SessionId
        public /* bridge */ boolean checkSameId(SessionId other) {
            return CC.$default$checkSameId(this, other);
        }
    }

    /* compiled from: SessionId.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean checkSameId(SessionId $this, SessionId other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.$default$checkSameId($this, other);
        }
    }
}