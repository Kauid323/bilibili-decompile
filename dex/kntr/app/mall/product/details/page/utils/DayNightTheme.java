package kntr.app.mall.product.details.page.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Themes.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/app/mall/product/details/page/utils/DayNightTheme;", "", "<init>", "()V", "Light", "Dark", "Lkntr/app/mall/product/details/page/utils/DayNightTheme$Dark;", "Lkntr/app/mall/product/details/page/utils/DayNightTheme$Light;", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class DayNightTheme {
    public static final int $stable = 0;

    public /* synthetic */ DayNightTheme(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Themes.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/mall/product/details/page/utils/DayNightTheme$Light;", "Lkntr/app/mall/product/details/page/utils/DayNightTheme;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Light extends DayNightTheme {
        public static final int $stable = 0;
        public static final Light INSTANCE = new Light();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Light) {
                Light light = (Light) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 504266916;
        }

        public String toString() {
            return "Light";
        }

        private Light() {
            super(null);
        }
    }

    private DayNightTheme() {
    }

    /* compiled from: Themes.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/mall/product/details/page/utils/DayNightTheme$Dark;", "Lkntr/app/mall/product/details/page/utils/DayNightTheme;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Dark extends DayNightTheme {
        public static final int $stable = 0;
        public static final Dark INSTANCE = new Dark();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Dark) {
                Dark dark = (Dark) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1124399656;
        }

        public String toString() {
            return "Dark";
        }

        private Dark() {
            super(null);
        }
    }
}