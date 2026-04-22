package kntr.common.trio.p000switch;

import androidx.compose.ui.graphics.Color;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleSwitch.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÃ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u00128\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\f\u00128\b\u0002\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\"\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b#\u0010\u0016J\u0010\u0010$\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b%\u0010\u0016J\u0010\u0010&\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b'\u0010\u0016J\u0010\u0010(\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b)\u0010\u0016J\u0010\u0010*\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b+\u0010\u0016J\u0010\u0010,\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b-\u0010\u0016J\u0010\u0010.\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b/\u0010\u0016J\u0010\u00100\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b1\u0010\u0016J9\u00102\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J9\u00103\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003JÔ\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000328\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\f28\b\u0002\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\fHÆ\u0001¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020<HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001e\u0010\u0016RA\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 RA\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00030\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 ¨\u0006="}, d2 = {"Lkntr/common/trio/switch/SimpleSwitchColors;", "", "backgroundEnabledOn", "Landroidx/compose/ui/graphics/Color;", "backgroundEnabledOff", "backgroundDisabledOn", "backgroundDisabledOff", "foregroundEnabledOn", "foregroundEnabledOff", "foregroundDisabledOn", "foregroundDisabledOff", "backgroundColorTarget", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "enabled", "checked", "foregroundColorTarget", "<init>", "(JJJJJJJJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBackgroundEnabledOn-0d7_KjU", "()J", "J", "getBackgroundEnabledOff-0d7_KjU", "getBackgroundDisabledOn-0d7_KjU", "getBackgroundDisabledOff-0d7_KjU", "getForegroundEnabledOn-0d7_KjU", "getForegroundEnabledOff-0d7_KjU", "getForegroundDisabledOn-0d7_KjU", "getForegroundDisabledOff-0d7_KjU", "getBackgroundColorTarget", "()Lkotlin/jvm/functions/Function2;", "getForegroundColorTarget", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", "component9", "component10", "copy", "copy-hxWaLQE", "(JJJJJJJJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkntr/common/trio/switch/SimpleSwitchColors;", "equals", "other", "hashCode", "", "toString", "", "trio_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
/* renamed from: kntr.common.trio.switch.SimpleSwitchColors  reason: invalid package */
public final class SimpleSwitchColors {
    public static final int $stable = 0;
    private final Function2<Boolean, Boolean, Color> backgroundColorTarget;
    private final long backgroundDisabledOff;
    private final long backgroundDisabledOn;
    private final long backgroundEnabledOff;
    private final long backgroundEnabledOn;
    private final Function2<Boolean, Boolean, Color> foregroundColorTarget;
    private final long foregroundDisabledOff;
    private final long foregroundDisabledOn;
    private final long foregroundEnabledOff;
    private final long foregroundEnabledOn;

    public /* synthetic */ SimpleSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Function2 function2, Function2 function22, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, function2, function22);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m2422component10d7_KjU() {
        return this.backgroundEnabledOn;
    }

    public final Function2<Boolean, Boolean, Color> component10() {
        return this.foregroundColorTarget;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m2423component20d7_KjU() {
        return this.backgroundEnabledOff;
    }

    /* renamed from: component3-0d7_KjU  reason: not valid java name */
    public final long m2424component30d7_KjU() {
        return this.backgroundDisabledOn;
    }

    /* renamed from: component4-0d7_KjU  reason: not valid java name */
    public final long m2425component40d7_KjU() {
        return this.backgroundDisabledOff;
    }

    /* renamed from: component5-0d7_KjU  reason: not valid java name */
    public final long m2426component50d7_KjU() {
        return this.foregroundEnabledOn;
    }

    /* renamed from: component6-0d7_KjU  reason: not valid java name */
    public final long m2427component60d7_KjU() {
        return this.foregroundEnabledOff;
    }

    /* renamed from: component7-0d7_KjU  reason: not valid java name */
    public final long m2428component70d7_KjU() {
        return this.foregroundDisabledOn;
    }

    /* renamed from: component8-0d7_KjU  reason: not valid java name */
    public final long m2429component80d7_KjU() {
        return this.foregroundDisabledOff;
    }

    public final Function2<Boolean, Boolean, Color> component9() {
        return this.backgroundColorTarget;
    }

    /* renamed from: copy-hxWaLQE  reason: not valid java name */
    public final SimpleSwitchColors m2430copyhxWaLQE(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, Function2<? super Boolean, ? super Boolean, Color> function2, Function2<? super Boolean, ? super Boolean, Color> function22) {
        Intrinsics.checkNotNullParameter(function2, "backgroundColorTarget");
        Intrinsics.checkNotNullParameter(function22, "foregroundColorTarget");
        return new SimpleSwitchColors(j, j2, j3, j4, j5, j6, j7, j8, function2, function22, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SimpleSwitchColors) {
            SimpleSwitchColors simpleSwitchColors = (SimpleSwitchColors) obj;
            return Color.equals-impl0(this.backgroundEnabledOn, simpleSwitchColors.backgroundEnabledOn) && Color.equals-impl0(this.backgroundEnabledOff, simpleSwitchColors.backgroundEnabledOff) && Color.equals-impl0(this.backgroundDisabledOn, simpleSwitchColors.backgroundDisabledOn) && Color.equals-impl0(this.backgroundDisabledOff, simpleSwitchColors.backgroundDisabledOff) && Color.equals-impl0(this.foregroundEnabledOn, simpleSwitchColors.foregroundEnabledOn) && Color.equals-impl0(this.foregroundEnabledOff, simpleSwitchColors.foregroundEnabledOff) && Color.equals-impl0(this.foregroundDisabledOn, simpleSwitchColors.foregroundDisabledOn) && Color.equals-impl0(this.foregroundDisabledOff, simpleSwitchColors.foregroundDisabledOff) && Intrinsics.areEqual(this.backgroundColorTarget, simpleSwitchColors.backgroundColorTarget) && Intrinsics.areEqual(this.foregroundColorTarget, simpleSwitchColors.foregroundColorTarget);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((Color.hashCode-impl(this.backgroundEnabledOn) * 31) + Color.hashCode-impl(this.backgroundEnabledOff)) * 31) + Color.hashCode-impl(this.backgroundDisabledOn)) * 31) + Color.hashCode-impl(this.backgroundDisabledOff)) * 31) + Color.hashCode-impl(this.foregroundEnabledOn)) * 31) + Color.hashCode-impl(this.foregroundEnabledOff)) * 31) + Color.hashCode-impl(this.foregroundDisabledOn)) * 31) + Color.hashCode-impl(this.foregroundDisabledOff)) * 31) + this.backgroundColorTarget.hashCode()) * 31) + this.foregroundColorTarget.hashCode();
    }

    public String toString() {
        String str = Color.toString-impl(this.backgroundEnabledOn);
        String str2 = Color.toString-impl(this.backgroundEnabledOff);
        String str3 = Color.toString-impl(this.backgroundDisabledOn);
        String str4 = Color.toString-impl(this.backgroundDisabledOff);
        String str5 = Color.toString-impl(this.foregroundEnabledOn);
        String str6 = Color.toString-impl(this.foregroundEnabledOff);
        String str7 = Color.toString-impl(this.foregroundDisabledOn);
        String str8 = Color.toString-impl(this.foregroundDisabledOff);
        Function2<Boolean, Boolean, Color> function2 = this.backgroundColorTarget;
        return "SimpleSwitchColors(backgroundEnabledOn=" + str + ", backgroundEnabledOff=" + str2 + ", backgroundDisabledOn=" + str3 + ", backgroundDisabledOff=" + str4 + ", foregroundEnabledOn=" + str5 + ", foregroundEnabledOff=" + str6 + ", foregroundDisabledOn=" + str7 + ", foregroundDisabledOff=" + str8 + ", backgroundColorTarget=" + function2 + ", foregroundColorTarget=" + this.foregroundColorTarget + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SimpleSwitchColors(long backgroundEnabledOn, long backgroundEnabledOff, long backgroundDisabledOn, long backgroundDisabledOff, long foregroundEnabledOn, long foregroundEnabledOff, long foregroundDisabledOn, long foregroundDisabledOff, Function2<? super Boolean, ? super Boolean, Color> function2, Function2<? super Boolean, ? super Boolean, Color> function22) {
        Intrinsics.checkNotNullParameter(function2, "backgroundColorTarget");
        Intrinsics.checkNotNullParameter(function22, "foregroundColorTarget");
        this.backgroundEnabledOn = backgroundEnabledOn;
        this.backgroundEnabledOff = backgroundEnabledOff;
        this.backgroundDisabledOn = backgroundDisabledOn;
        this.backgroundDisabledOff = backgroundDisabledOff;
        this.foregroundEnabledOn = foregroundEnabledOn;
        this.foregroundEnabledOff = foregroundEnabledOff;
        this.foregroundDisabledOn = foregroundDisabledOn;
        this.foregroundDisabledOff = foregroundDisabledOff;
        this.backgroundColorTarget = function2;
        this.foregroundColorTarget = function22;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SimpleSwitchColors(final long j, final long j2, long j3, long j4, final long j5, final long j6, long j7, long j8, Function2 function2, Function2 function22, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, r11, r13, j5, j6, r15, r17, r19, r20, null);
        Function2<Boolean, Boolean, Color> function23;
        Function2<Boolean, Boolean, Color> function24;
        long j9 = (i & 4) != 0 ? j2 : j3;
        long j10 = (i & 8) != 0 ? j2 : j4;
        long j11 = (i & 64) != 0 ? j6 : j7;
        long j12 = (i & 128) != 0 ? j6 : j8;
        if ((i & 256) != 0) {
            final long j13 = j9;
            final long j14 = j10;
            function23 = new Function2<Boolean, Boolean, Color>() { // from class: kntr.common.trio.switch.SimpleSwitchColors.1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return Color.box-impl(m2439invokeWaAFU9c(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue()));
                }

                /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                public final long m2439invokeWaAFU9c(boolean enabled, boolean checked) {
                    if (enabled && checked) {
                        return j;
                    }
                    if (enabled && !checked) {
                        return j2;
                    }
                    if (!enabled && checked) {
                        return j13;
                    }
                    return j14;
                }
            };
        } else {
            function23 = function2;
        }
        if ((i & 512) != 0) {
            final long j15 = j11;
            final long j16 = j12;
            function24 = new Function2<Boolean, Boolean, Color>() { // from class: kntr.common.trio.switch.SimpleSwitchColors.2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    return Color.box-impl(m2440invokeWaAFU9c(((Boolean) p1).booleanValue(), ((Boolean) p2).booleanValue()));
                }

                /* renamed from: invoke-WaAFU9c  reason: not valid java name */
                public final long m2440invokeWaAFU9c(boolean enabled, boolean checked) {
                    if (enabled && checked) {
                        return j5;
                    }
                    if (enabled && !checked) {
                        return j6;
                    }
                    if (!enabled && checked) {
                        return j15;
                    }
                    return j16;
                }
            };
        } else {
            function24 = function22;
        }
    }

    /* renamed from: getBackgroundEnabledOn-0d7_KjU  reason: not valid java name */
    public final long m2434getBackgroundEnabledOn0d7_KjU() {
        return this.backgroundEnabledOn;
    }

    /* renamed from: getBackgroundEnabledOff-0d7_KjU  reason: not valid java name */
    public final long m2433getBackgroundEnabledOff0d7_KjU() {
        return this.backgroundEnabledOff;
    }

    /* renamed from: getBackgroundDisabledOn-0d7_KjU  reason: not valid java name */
    public final long m2432getBackgroundDisabledOn0d7_KjU() {
        return this.backgroundDisabledOn;
    }

    /* renamed from: getBackgroundDisabledOff-0d7_KjU  reason: not valid java name */
    public final long m2431getBackgroundDisabledOff0d7_KjU() {
        return this.backgroundDisabledOff;
    }

    /* renamed from: getForegroundEnabledOn-0d7_KjU  reason: not valid java name */
    public final long m2438getForegroundEnabledOn0d7_KjU() {
        return this.foregroundEnabledOn;
    }

    /* renamed from: getForegroundEnabledOff-0d7_KjU  reason: not valid java name */
    public final long m2437getForegroundEnabledOff0d7_KjU() {
        return this.foregroundEnabledOff;
    }

    /* renamed from: getForegroundDisabledOn-0d7_KjU  reason: not valid java name */
    public final long m2436getForegroundDisabledOn0d7_KjU() {
        return this.foregroundDisabledOn;
    }

    /* renamed from: getForegroundDisabledOff-0d7_KjU  reason: not valid java name */
    public final long m2435getForegroundDisabledOff0d7_KjU() {
        return this.foregroundDisabledOff;
    }

    public final Function2<Boolean, Boolean, Color> getBackgroundColorTarget() {
        return this.backgroundColorTarget;
    }

    public final Function2<Boolean, Boolean, Color> getForegroundColorTarget() {
        return this.foregroundColorTarget;
    }
}