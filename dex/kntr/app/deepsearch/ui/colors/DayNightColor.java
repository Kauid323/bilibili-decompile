package kntr.app.deepsearch.ui.colors;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.IBiliColors;
import com.bilibili.compose.theme.ThemeDayNight;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DSColors.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\"\b\u0016\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\b\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\rJ$\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lkntr/app/deepsearch/ui/colors/DayNightColor;", RoomRecommendViewModel.EMPTY_CURSOR, "day", "Landroidx/compose/ui/graphics/Color;", "night", "<init>", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "colorProvider", "Lkotlin/Function1;", "Lcom/bilibili/compose/theme/IBiliColors;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getDay-0d7_KjU", "()J", "J", "getNight-0d7_KjU", "value", "getValue", "(Landroidx/compose/runtime/Composer;I)J", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "copy", "copy--OWjLjI", "(JJ)Lkntr/app/deepsearch/ui/colors/DayNightColor;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DayNightColor {
    public static final int $stable = 0;
    private final long day;
    private final long night;

    public /* synthetic */ DayNightColor(long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, j3);
    }

    /* renamed from: copy--OWjLjI$default  reason: not valid java name */
    public static /* synthetic */ DayNightColor m731copyOWjLjI$default(DayNightColor dayNightColor, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = dayNightColor.day;
        }
        if ((i & 2) != 0) {
            j3 = dayNightColor.night;
        }
        return dayNightColor.m734copyOWjLjI(j2, j3);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m732component10d7_KjU() {
        return this.day;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m733component20d7_KjU() {
        return this.night;
    }

    /* renamed from: copy--OWjLjI  reason: not valid java name */
    public final DayNightColor m734copyOWjLjI(long j2, long j3) {
        return new DayNightColor(j2, j3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DayNightColor) {
            DayNightColor dayNightColor = (DayNightColor) obj;
            return Color.equals-impl0(this.day, dayNightColor.day) && Color.equals-impl0(this.night, dayNightColor.night);
        }
        return false;
    }

    public int hashCode() {
        return (Color.hashCode-impl(this.day) * 31) + Color.hashCode-impl(this.night);
    }

    public String toString() {
        String str = Color.toString-impl(this.day);
        return "DayNightColor(day=" + str + ", night=" + Color.toString-impl(this.night) + ")";
    }

    private DayNightColor(long day, long night) {
        this.day = day;
        this.night = night;
    }

    /* renamed from: getDay-0d7_KjU  reason: not valid java name */
    public final long m735getDay0d7_KjU() {
        return this.day;
    }

    /* renamed from: getNight-0d7_KjU  reason: not valid java name */
    public final long m736getNight0d7_KjU() {
        return this.night;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DayNightColor(Function1<? super IBiliColors, Color> function1) {
        this(((Color) function1.invoke(BiliColorsSourceKt.getDayColors())).unbox-impl(), ((Color) function1.invoke(BiliColorsSourceKt.getNightColors())).unbox-impl(), null);
        Intrinsics.checkNotNullParameter(function1, "colorProvider");
    }

    public final long getValue(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -730140486, "C(<get-value>)71@2882L13:DSColors.kt#mcacju");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-730140486, $changed, -1, "kntr.app.deepsearch.ui.colors.DayNightColor.<get-value> (DSColors.kt:70)");
        }
        boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
        long j2 = isNight ? this.night : this.day;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j2;
    }
}