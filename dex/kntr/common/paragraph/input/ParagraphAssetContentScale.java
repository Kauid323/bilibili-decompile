package kntr.common.paragraph.input;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.unit.Constraints;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: AssetParagraphContent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lkntr/common/paragraph/input/ParagraphAssetContentScale;", "Landroidx/compose/ui/layout/ContentScale;", "constraint", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraint-msEJaDk", "()J", "J", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ParagraphAssetContentScale implements ContentScale {
    public static final int $stable = 0;
    private final long constraint;

    public /* synthetic */ ParagraphAssetContentScale(long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(j);
    }

    private ParagraphAssetContentScale(long constraint) {
        this.constraint = constraint;
    }

    /* renamed from: getConstraint-msEJaDk  reason: not valid java name */
    public final long m2171getConstraintmsEJaDk() {
        return this.constraint;
    }

    /* renamed from: computeScaleFactor-H7hwNQA  reason: not valid java name */
    public long m2170computeScaleFactorH7hwNQA(long j, long j2) {
        float width$iv = Constraints.getMinWidth-impl(this.constraint);
        float height$iv = Constraints.getMinHeight-impl(this.constraint);
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        long minSize = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        long crop = ContentScale.Companion.getCrop().computeScaleFactor-H7hwNQA(j, minSize);
        int bits$iv$iv$iv = (int) (crop >> 32);
        if (Float.intBitsToFloat(bits$iv$iv$iv) >= 1.0f) {
            return crop;
        }
        float width$iv2 = Constraints.getMaxWidth-impl(this.constraint);
        float height$iv2 = Constraints.getMaxHeight-impl(this.constraint);
        long v1$iv$iv2 = Float.floatToRawIntBits(width$iv2);
        long minSize2 = Float.floatToRawIntBits(height$iv2);
        long v2$iv$iv2 = (v1$iv$iv2 << 32) | (minSize2 & 4294967295L);
        long maxWidthSize = Size.constructor-impl(v2$iv$iv2);
        long fitWidth = ContentScale.Companion.getInside().computeScaleFactor-H7hwNQA(j, maxWidthSize);
        int bits$iv$iv$iv2 = (int) (crop >> 32);
        int bits$iv$iv$iv3 = (int) (fitWidth >> 32);
        float scale = RangesKt.coerceAtLeast(Float.intBitsToFloat(bits$iv$iv$iv2), Float.intBitsToFloat(bits$iv$iv$iv3));
        long v1$iv$iv3 = Float.floatToRawIntBits(scale);
        long v2$iv$iv3 = Float.floatToRawIntBits(scale);
        return ScaleFactor.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv3 & 4294967295L));
    }
}