package kntr.app.upper.entrance.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UpperNumberFormat.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007\u0082\u0001\u0003\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkntr/app/upper/entrance/utils/UnitSuffix;", "", "<init>", "()V", "thousands", "", "getThousands", "()Ljava/lang/String;", "tenThousands", "getTenThousands", "millions", "getMillions", "hundredMillions", "getHundredMillions", "billions", "getBillions", "ZhUnit", "ZhTraditionUnit", "EnUnit", "Lkntr/app/upper/entrance/utils/UnitSuffix$EnUnit;", "Lkntr/app/upper/entrance/utils/UnitSuffix$ZhTraditionUnit;", "Lkntr/app/upper/entrance/utils/UnitSuffix$ZhUnit;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
abstract class UnitSuffix {
    private final String billions;
    private final String hundredMillions;
    private final String millions;
    private final String tenThousands;
    private final String thousands;

    public /* synthetic */ UnitSuffix(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private UnitSuffix() {
        this.thousands = "";
        this.tenThousands = "";
        this.millions = "";
        this.hundredMillions = "";
        this.billions = "";
    }

    public String getThousands() {
        return this.thousands;
    }

    public String getTenThousands() {
        return this.tenThousands;
    }

    public String getMillions() {
        return this.millions;
    }

    public String getHundredMillions() {
        return this.hundredMillions;
    }

    public String getBillions() {
        return this.billions;
    }

    /* compiled from: UpperNumberFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/upper/entrance/utils/UnitSuffix$ZhUnit;", "Lkntr/app/upper/entrance/utils/UnitSuffix;", "<init>", "()V", "tenThousands", "", "getTenThousands", "()Ljava/lang/String;", "hundredMillions", "getHundredMillions", "equals", "", "other", "", "hashCode", "", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ZhUnit extends UnitSuffix {
        public static final ZhUnit INSTANCE = new ZhUnit();
        private static final String tenThousands = "万";
        private static final String hundredMillions = "亿";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ZhUnit) {
                ZhUnit zhUnit = (ZhUnit) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1247246884;
        }

        public String toString() {
            return "ZhUnit";
        }

        private ZhUnit() {
            super(null);
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getTenThousands() {
            return tenThousands;
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getHundredMillions() {
            return hundredMillions;
        }
    }

    /* compiled from: UpperNumberFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/upper/entrance/utils/UnitSuffix$ZhTraditionUnit;", "Lkntr/app/upper/entrance/utils/UnitSuffix;", "<init>", "()V", "tenThousands", "", "getTenThousands", "()Ljava/lang/String;", "hundredMillions", "getHundredMillions", "equals", "", "other", "", "hashCode", "", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ZhTraditionUnit extends UnitSuffix {
        public static final ZhTraditionUnit INSTANCE = new ZhTraditionUnit();
        private static final String tenThousands = "萬";
        private static final String hundredMillions = "億";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ZhTraditionUnit) {
                ZhTraditionUnit zhTraditionUnit = (ZhTraditionUnit) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -622217528;
        }

        public String toString() {
            return "ZhTraditionUnit";
        }

        private ZhTraditionUnit() {
            super(null);
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getTenThousands() {
            return tenThousands;
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getHundredMillions() {
            return hundredMillions;
        }
    }

    /* compiled from: UpperNumberFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lkntr/app/upper/entrance/utils/UnitSuffix$EnUnit;", "Lkntr/app/upper/entrance/utils/UnitSuffix;", "<init>", "()V", "thousands", "", "getThousands", "()Ljava/lang/String;", "millions", "getMillions", "billions", "getBillions", "equals", "", "other", "", "hashCode", "", "toString", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EnUnit extends UnitSuffix {
        public static final EnUnit INSTANCE = new EnUnit();
        private static final String thousands = "K";
        private static final String millions = "M";
        private static final String billions = "B";

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EnUnit) {
                EnUnit enUnit = (EnUnit) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1842917929;
        }

        public String toString() {
            return "EnUnit";
        }

        private EnUnit() {
            super(null);
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getThousands() {
            return thousands;
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getMillions() {
            return millions;
        }

        @Override // kntr.app.upper.entrance.utils.UnitSuffix
        public String getBillions() {
            return billions;
        }
    }
}