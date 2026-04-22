package tv.danmaku.bili.ui.favorites.state;

import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: FavoritesState.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "", "Gone", "CleanInvalid", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState$CleanInvalid;", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState$Gone;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public interface FavPageFooterState {

    /* compiled from: FavoritesState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState$Gone;", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Gone implements FavPageFooterState {
        public static final int $stable = 0;
        public static final Gone INSTANCE = new Gone();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Gone) {
                Gone gone = (Gone) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1961213202;
        }

        public String toString() {
            return "Gone";
        }

        private Gone() {
        }
    }

    /* compiled from: FavoritesState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState$CleanInvalid;", "Ltv/danmaku/bili/ui/favorites/state/FavPageFooterState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class CleanInvalid implements FavPageFooterState {
        public static final int $stable = 0;
        public static final CleanInvalid INSTANCE = new CleanInvalid();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof CleanInvalid) {
                CleanInvalid cleanInvalid = (CleanInvalid) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1750530273;
        }

        public String toString() {
            return "CleanInvalid";
        }

        private CleanInvalid() {
        }
    }
}