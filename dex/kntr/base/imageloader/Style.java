package kntr.base.imageloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BfsProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u000f"}, d2 = {"Lkntr/base/imageloader/Style;", "", "name", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getName", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Companion", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@JvmInline
public final class Style {
    public static final Companion Companion = new Companion(null);
    private static final String UNSET = m1584constructorimpl(null);
    private final String name;

    /* renamed from: box-impl */
    public static final /* synthetic */ Style m1583boximpl(String str) {
        return new Style(str);
    }

    /* renamed from: constructor-impl */
    public static String m1584constructorimpl(String str) {
        return str;
    }

    /* renamed from: equals-impl */
    public static boolean m1585equalsimpl(String str, Object obj) {
        return (obj instanceof Style) && Intrinsics.areEqual(str, ((Style) obj).m1589unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1586equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual(str, str2);
    }

    /* renamed from: hashCode-impl */
    public static int m1587hashCodeimpl(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m1588toStringimpl(String str) {
        return "Style(name=" + str + ")";
    }

    public boolean equals(Object obj) {
        return m1585equalsimpl(this.name, obj);
    }

    public int hashCode() {
        return m1587hashCodeimpl(this.name);
    }

    public String toString() {
        return m1588toStringimpl(this.name);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ String m1589unboximpl() {
        return this.name;
    }

    private /* synthetic */ Style(String name) {
        this.name = name;
    }

    public final String getName() {
        return this.name;
    }

    /* compiled from: BfsProtocol.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lkntr/base/imageloader/Style$Companion;", "", "<init>", "()V", "UNSET", "Lkntr/base/imageloader/Style;", "getUNSET-VN9BJCI", "()Ljava/lang/String;", "Ljava/lang/String;", "imageloader_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getUNSET-VN9BJCI */
        public final String m1590getUNSETVN9BJCI() {
            return Style.UNSET;
        }
    }
}