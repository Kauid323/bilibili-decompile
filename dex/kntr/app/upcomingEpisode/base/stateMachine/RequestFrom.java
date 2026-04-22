package kntr.app.upcomingEpisode.base.stateMachine;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: UpcomingEpisodeData.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "", "Default", "Manual", "Auto", "Initial", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Auto;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Default;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Initial;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Manual;", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface RequestFrom {

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Default;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Default implements RequestFrom {
        public static final int $stable = 0;
        public static final Default INSTANCE = new Default();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Default) {
                Default r1 = (Default) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1205145112;
        }

        public String toString() {
            return "Default";
        }

        private Default() {
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Manual;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Manual implements RequestFrom {
        public static final int $stable = 0;
        public static final Manual INSTANCE = new Manual();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Manual) {
                Manual manual = (Manual) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 769538879;
        }

        public String toString() {
            return "Manual";
        }

        private Manual() {
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Auto;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Auto implements RequestFrom {
        public static final int $stable = 0;
        public static final Auto INSTANCE = new Auto();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Auto) {
                Auto auto = (Auto) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 335657832;
        }

        public String toString() {
            return "Auto";
        }

        private Auto() {
        }
    }

    /* compiled from: UpcomingEpisodeData.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom$Initial;", "Lkntr/app/upcomingEpisode/base/stateMachine/RequestFrom;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "main_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Initial implements RequestFrom {
        public static final int $stable = 0;
        public static final Initial INSTANCE = new Initial();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initial) {
                Initial initial = (Initial) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -801606933;
        }

        public String toString() {
            return "Initial";
        }

        private Initial() {
        }
    }
}