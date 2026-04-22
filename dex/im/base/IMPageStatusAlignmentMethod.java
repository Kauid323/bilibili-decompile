package im.base;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.yalantis.ucrop.view.CropImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMPageStatus.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0007\bJ\r\u0010\u0002\u001a\u00020\u0003H'¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0006H&\u0082\u0001\u0002\t\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lim/base/IMPageStatusAlignmentMethod;", "", "getAlignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment;", "applyModifier", "Landroidx/compose/ui/Modifier;", "TopWithPadding", "CenterWithMinimumPadding", "Lim/base/IMPageStatusAlignmentMethod$CenterWithMinimumPadding;", "Lim/base/IMPageStatusAlignmentMethod$TopWithPadding;", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IMPageStatusAlignmentMethod {
    Modifier applyModifier(Modifier modifier);

    Alignment getAlignment(Composer composer, int i2);

    /* compiled from: IMPageStatus.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lim/base/IMPageStatusAlignmentMethod$TopWithPadding;", "Lim/base/IMPageStatusAlignmentMethod;", "paddingTop", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getPaddingTop-D9Ej5fM", "()F", "F", "getAlignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment;", "applyModifier", "Landroidx/compose/ui/Modifier;", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Lim/base/IMPageStatusAlignmentMethod$TopWithPadding;", "equals", "", "other", "", "hashCode", "", "toString", "", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class TopWithPadding implements IMPageStatusAlignmentMethod {
        public static final int $stable = 0;
        private final float paddingTop;

        public /* synthetic */ TopWithPadding(float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f2);
        }

        /* renamed from: copy-0680j_4$default  reason: not valid java name */
        public static /* synthetic */ TopWithPadding m3075copy0680j_4$default(TopWithPadding topWithPadding, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = topWithPadding.paddingTop;
            }
            return topWithPadding.m3077copy0680j_4(f2);
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m3076component1D9Ej5fM() {
            return this.paddingTop;
        }

        /* renamed from: copy-0680j_4  reason: not valid java name */
        public final TopWithPadding m3077copy0680j_4(float f2) {
            return new TopWithPadding(f2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TopWithPadding) && Dp.equals-impl0(this.paddingTop, ((TopWithPadding) obj).paddingTop);
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.paddingTop);
        }

        public String toString() {
            return "TopWithPadding(paddingTop=" + Dp.toString-impl(this.paddingTop) + ")";
        }

        private TopWithPadding(float paddingTop) {
            this.paddingTop = paddingTop;
        }

        /* renamed from: getPaddingTop-D9Ej5fM  reason: not valid java name */
        public final float m3078getPaddingTopD9Ej5fM() {
            return this.paddingTop;
        }

        @Override // im.base.IMPageStatusAlignmentMethod
        public Alignment getAlignment(Composer $composer, int $changed) {
            $composer.startReplaceGroup(1771620471);
            ComposerKt.sourceInformation($composer, "C(getAlignment):IMPageStatus.kt#uu6lp7");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1771620471, $changed, -1, "im.base.IMPageStatusAlignmentMethod.TopWithPadding.getAlignment (IMPageStatus.kt:94)");
            }
            Alignment topCenter = Alignment.Companion.getTopCenter();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return topCenter;
        }

        @Override // im.base.IMPageStatusAlignmentMethod
        public Modifier applyModifier(Modifier $this$applyModifier) {
            Intrinsics.checkNotNullParameter($this$applyModifier, "<this>");
            return PaddingKt.padding-qDBjuR0$default($this$applyModifier, (float) CropImageView.DEFAULT_ASPECT_RATIO, this.paddingTop, (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null);
        }
    }

    /* compiled from: IMPageStatus.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\t\u001a\u00020\nH\u0017¢\u0006\u0002\u0010\u000bJ\f\u0010\f\u001a\u00020\r*\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lim/base/IMPageStatusAlignmentMethod$CenterWithMinimumPadding;", "Lim/base/IMPageStatusAlignmentMethod;", "minimumPadding", "Landroidx/compose/ui/unit/Dp;", "<init>", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinimumPadding-D9Ej5fM", "()F", "F", "getAlignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Alignment;", "applyModifier", "Landroidx/compose/ui/Modifier;", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Lim/base/IMPageStatusAlignmentMethod$CenterWithMinimumPadding;", "equals", "", "other", "", "hashCode", "", "toString", "", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class CenterWithMinimumPadding implements IMPageStatusAlignmentMethod {
        public static final int $stable = 0;
        private final float minimumPadding;

        public /* synthetic */ CenterWithMinimumPadding(float f2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f2);
        }

        /* renamed from: copy-0680j_4$default  reason: not valid java name */
        public static /* synthetic */ CenterWithMinimumPadding m3071copy0680j_4$default(CenterWithMinimumPadding centerWithMinimumPadding, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = centerWithMinimumPadding.minimumPadding;
            }
            return centerWithMinimumPadding.m3073copy0680j_4(f2);
        }

        /* renamed from: component1-D9Ej5fM  reason: not valid java name */
        public final float m3072component1D9Ej5fM() {
            return this.minimumPadding;
        }

        /* renamed from: copy-0680j_4  reason: not valid java name */
        public final CenterWithMinimumPadding m3073copy0680j_4(float f2) {
            return new CenterWithMinimumPadding(f2, null);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CenterWithMinimumPadding) && Dp.equals-impl0(this.minimumPadding, ((CenterWithMinimumPadding) obj).minimumPadding);
        }

        public int hashCode() {
            return Dp.hashCode-impl(this.minimumPadding);
        }

        public String toString() {
            return "CenterWithMinimumPadding(minimumPadding=" + Dp.toString-impl(this.minimumPadding) + ")";
        }

        private CenterWithMinimumPadding(float minimumPadding) {
            this.minimumPadding = minimumPadding;
        }

        /* renamed from: getMinimumPadding-D9Ej5fM  reason: not valid java name */
        public final float m3074getMinimumPaddingD9Ej5fM() {
            return this.minimumPadding;
        }

        @Override // im.base.IMPageStatusAlignmentMethod
        public Alignment getAlignment(Composer $composer, int $changed) {
            $composer.startReplaceGroup(-240836657);
            ComposerKt.sourceInformation($composer, "C(getAlignment)103@2837L41:IMPageStatus.kt#uu6lp7");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-240836657, $changed, -1, "im.base.IMPageStatusAlignmentMethod.CenterWithMinimumPadding.getAlignment (IMPageStatus.kt:103)");
            }
            Alignment m3060rememberIMStatusAlignmentkHDZbjc = AlignmentKt.m3060rememberIMStatusAlignmentkHDZbjc(this.minimumPadding, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return m3060rememberIMStatusAlignmentkHDZbjc;
        }

        @Override // im.base.IMPageStatusAlignmentMethod
        public Modifier applyModifier(Modifier $this$applyModifier) {
            Intrinsics.checkNotNullParameter($this$applyModifier, "<this>");
            return $this$applyModifier;
        }
    }
}