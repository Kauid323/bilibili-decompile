package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: BiliImageOptions.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lkntr/base/imageloader/AnimateStrategy;", "", "<init>", "()V", "NoCache", "Balance", "Always", "Lkntr/base/imageloader/AnimateStrategy$Always;", "Lkntr/base/imageloader/AnimateStrategy$Balance;", "Lkntr/base/imageloader/AnimateStrategy$NoCache;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class AnimateStrategy {
    public static final int $stable = 0;

    public /* synthetic */ AnimateStrategy(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: BiliImageOptions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimateStrategy$NoCache;", "Lkntr/base/imageloader/AnimateStrategy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NoCache extends AnimateStrategy {
        public static final int $stable = 0;
        public static final NoCache INSTANCE = new NoCache();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NoCache) {
                NoCache noCache = (NoCache) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1961141673;
        }

        public String toString() {
            return "NoCache";
        }

        private NoCache() {
            super(null);
        }
    }

    private AnimateStrategy() {
    }

    /* compiled from: BiliImageOptions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimateStrategy$Balance;", "Lkntr/base/imageloader/AnimateStrategy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Balance extends AnimateStrategy {
        public static final int $stable = 0;
        public static final Balance INSTANCE = new Balance();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Balance) {
                Balance balance = (Balance) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -89217294;
        }

        public String toString() {
            return "Balance";
        }

        private Balance() {
            super(null);
        }
    }

    /* compiled from: BiliImageOptions.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/imageloader/AnimateStrategy$Always;", "Lkntr/base/imageloader/AnimateStrategy;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Always extends AnimateStrategy {
        public static final int $stable = 0;
        public static final Always INSTANCE = new Always();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Always) {
                Always always = (Always) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -575209671;
        }

        public String toString() {
            return "Always";
        }

        private Always() {
            super(null);
        }
    }
}