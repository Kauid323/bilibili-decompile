package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NumberFormat.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000 \u00162\u00020\u0001:\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\n\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f ¨\u0006!"}, d2 = {"Lkntr/base/localization/Units;", "", "exponent", "", "<init>", "(I)V", "getExponent", "()I", "value", "", "getValue", "()J", "Ones", "Tens", "Hundreds", "Thousands", "TenThousands", "HundredThousands", "Millions", "TenMillions", "HundredMillions", "Billions", "Companion", "Lkntr/base/localization/Units$Billions;", "Lkntr/base/localization/Units$HundredMillions;", "Lkntr/base/localization/Units$HundredThousands;", "Lkntr/base/localization/Units$Hundreds;", "Lkntr/base/localization/Units$Millions;", "Lkntr/base/localization/Units$Ones;", "Lkntr/base/localization/Units$TenMillions;", "Lkntr/base/localization/Units$TenThousands;", "Lkntr/base/localization/Units$Tens;", "Lkntr/base/localization/Units$Thousands;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class Units {
    public static final Companion Companion = new Companion(null);
    private final int exponent;
    private final long value;

    public /* synthetic */ Units(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    private Units(int exponent) {
        this.exponent = exponent;
        this.value = (long) Math.pow(10.0d, this.exponent);
    }

    public final int getExponent() {
        return this.exponent;
    }

    public final long getValue() {
        return this.value;
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Ones;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Ones extends Units {
        public static final int $stable = 0;
        public static final Ones INSTANCE = new Ones();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ones) {
                Ones ones = (Ones) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 262790193;
        }

        public String toString() {
            return "Ones";
        }

        private Ones() {
            super(0, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Tens;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Tens extends Units {
        public static final int $stable = 0;
        public static final Tens INSTANCE = new Tens();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Tens) {
                Tens tens = (Tens) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 262930778;
        }

        public String toString() {
            return "Tens";
        }

        private Tens() {
            super(1, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Hundreds;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Hundreds extends Units {
        public static final int $stable = 0;
        public static final Hundreds INSTANCE = new Hundreds();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Hundreds) {
                Hundreds hundreds = (Hundreds) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -605071511;
        }

        public String toString() {
            return "Hundreds";
        }

        private Hundreds() {
            super(2, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Thousands;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Thousands extends Units {
        public static final int $stable = 0;
        public static final Thousands INSTANCE = new Thousands();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Thousands) {
                Thousands thousands = (Thousands) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1598649743;
        }

        public String toString() {
            return "Thousands";
        }

        private Thousands() {
            super(3, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$TenThousands;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TenThousands extends Units {
        public static final int $stable = 0;
        public static final TenThousands INSTANCE = new TenThousands();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TenThousands) {
                TenThousands tenThousands = (TenThousands) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 89641756;
        }

        public String toString() {
            return "TenThousands";
        }

        private TenThousands() {
            super(4, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$HundredThousands;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HundredThousands extends Units {
        public static final int $stable = 0;
        public static final HundredThousands INSTANCE = new HundredThousands();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HundredThousands) {
                HundredThousands hundredThousands = (HundredThousands) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1947751893;
        }

        public String toString() {
            return "HundredThousands";
        }

        private HundredThousands() {
            super(5, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Millions;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Millions extends Units {
        public static final int $stable = 0;
        public static final Millions INSTANCE = new Millions();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Millions) {
                Millions millions = (Millions) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1703774955;
        }

        public String toString() {
            return "Millions";
        }

        private Millions() {
            super(6, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$TenMillions;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class TenMillions extends Units {
        public static final int $stable = 0;
        public static final TenMillions INSTANCE = new TenMillions();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof TenMillions) {
                TenMillions tenMillions = (TenMillions) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1566900000;
        }

        public String toString() {
            return "TenMillions";
        }

        private TenMillions() {
            super(7, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$HundredMillions;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class HundredMillions extends Units {
        public static final int $stable = 0;
        public static final HundredMillions INSTANCE = new HundredMillions();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HundredMillions) {
                HundredMillions hundredMillions = (HundredMillions) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -801338383;
        }

        public String toString() {
            return "HundredMillions";
        }

        private HundredMillions() {
            super(8, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/localization/Units$Billions;", "Lkntr/base/localization/Units;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Billions extends Units {
        public static final int $stable = 0;
        public static final Billions INSTANCE = new Billions();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Billions) {
                Billions billions = (Billions) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -287269546;
        }

        public String toString() {
            return "Billions";
        }

        private Billions() {
            super(9, null);
        }
    }

    /* compiled from: NumberFormat.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lkntr/base/localization/Units$Companion;", "", "<init>", "()V", "fromValue", "Lkntr/base/localization/Units;", "value", "", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Units fromValue(long value) {
            return value >= 1000000000 ? Billions.INSTANCE : value >= 100000000 ? HundredMillions.INSTANCE : value >= 10000000 ? TenMillions.INSTANCE : value >= 1000000 ? Millions.INSTANCE : value >= 100000 ? HundredThousands.INSTANCE : value >= 10000 ? TenThousands.INSTANCE : value >= 1000 ? Thousands.INSTANCE : value >= 100 ? Hundreds.INSTANCE : value >= 10 ? Tens.INSTANCE : Ones.INSTANCE;
        }
    }
}