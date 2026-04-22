package kntr.common.ouro.ui.utils;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.mark.OuroDrawableMark;
import kntr.common.ouro.core.model.mark.OuroFontSizeMark;
import kntr.common.ouro.core.model.mark.OuroMark;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroMarksKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawableUtils.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a?\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000f\u001a!\u0010\u0003\u001a\u00020\u0004*\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\u0013\u001a\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"ZERO_WIDTH_SPACE", "", "REPLACEMENT_CHARACTER", "displaySize", "Landroidx/compose/ui/unit/DpSize;", "Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "mainAxisLength", "", "density", "Landroidx/compose/ui/unit/Density;", "mergedMarks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroMark;", "(Lkntr/common/ouro/core/model/node/drawable/OuroDrawable;Lkntr/common/ouro/core/model/NodeStorage;ILandroidx/compose/ui/unit/Density;Lkntr/common/ouro/core/model/mark/OuroMarks;)J", "BILI_BLOCK_IMAGE_MIN_WIDTH", "BILI_BLOCK_IMAGE_MIN_HEIGHT", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize;", "(Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Size$BiliBlockImageSize;Landroidx/compose/ui/unit/Density;I)J", "padding", "Landroidx/compose/ui/Modifier;", "mark", "Lkntr/common/ouro/core/model/mark/OuroDrawableMark$Padding;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DrawableUtilsKt {
    public static final int BILI_BLOCK_IMAGE_MIN_HEIGHT = 46;
    public static final int BILI_BLOCK_IMAGE_MIN_WIDTH = 46;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final char ZERO_WIDTH_SPACE = 8203;

    public static /* synthetic */ long displaySize$default(OuroDrawable ouroDrawable, NodeStorage $this$getMergedMarks$iv, int i, Density density, OuroMarks ouroMarks, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            Intrinsics.checkNotNull(ouroDrawable, "null cannot be cast to non-null type kntr.common.ouro.core.model.node.OuroNode.Markable<kntr.common.ouro.core.model.mark.OuroMark>");
            OuroDrawable node$iv = ouroDrawable;
            ouroMarks = (OuroMarks) OuroNodeStorageUtilsKt.reduce($this$getMergedMarks$iv, node$iv, new OuroMarks(new OuroMark[0]), new Function2<OuroMarks<OuroMark>, OuroNode, OuroMarks<OuroMark>>() { // from class: kntr.common.ouro.ui.utils.DrawableUtilsKt$displaySize$default$$inlined$getMergedMarks$1
                public final OuroMarks<OuroMark> invoke(OuroMarks<OuroMark> ouroMarks2, OuroNode node) {
                    Intrinsics.checkNotNullParameter(ouroMarks2, "acc");
                    Intrinsics.checkNotNullParameter(node, "node");
                    if (node instanceof OuroNode.Markable) {
                        Iterable $this$filterInstanceOf$iv = ((OuroNode.Markable) node).getMarks();
                        Iterable $this$filterIsInstance$iv$iv = $this$filterInstanceOf$iv;
                        Collection destination$iv$iv$iv = new ArrayList();
                        for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                            if (element$iv$iv$iv instanceof OuroMark) {
                                destination$iv$iv$iv.add(element$iv$iv$iv);
                            }
                        }
                        return OuroMarksKt.mergeParent(ouroMarks2, new OuroMarks(new OuroMarks((List) destination$iv$iv$iv)));
                    }
                    return ouroMarks2;
                }
            });
        }
        return displaySize(ouroDrawable, $this$getMergedMarks$iv, i, density, ouroMarks);
    }

    public static final long displaySize(OuroDrawable<?> ouroDrawable, NodeStorage<?> nodeStorage, int mainAxisLength, Density density, OuroMarks<OuroMark> ouroMarks) {
        Intrinsics.checkNotNullParameter(ouroDrawable, "<this>");
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(ouroMarks, "mergedMarks");
        OuroMarks<M> marks = ouroDrawable.getMarks();
        Intrinsics.checkNotNull(marks, "null cannot be cast to non-null type kntr.common.ouro.core.model.mark.OuroMarks<kntr.common.ouro.core.model.mark.OuroDrawableMark>");
        OuroDrawableMark.Size it = (OuroDrawableMark.Size) marks.get(OuroDrawableMark.Size.Key.INSTANCE);
        if (it != null) {
            if (it instanceof OuroDrawableMark.Size.Specified) {
                float $this$dp$iv = ((OuroDrawableMark.Size.Specified) it).getWidth();
                float $this$dp$iv2 = Dp.constructor-impl($this$dp$iv);
                float $this$dp$iv3 = ((OuroDrawableMark.Size.Specified) it).getHeight();
                return DpKt.DpSize-YgX7TsA($this$dp$iv2, Dp.constructor-impl($this$dp$iv3));
            } else if (it instanceof OuroDrawableMark.Size.AspectRatio) {
                float width = mainAxisLength;
                return DpKt.DpSize-YgX7TsA(density.toDp-u2uoSUM(width), density.toDp-u2uoSUM(width / ((OuroDrawableMark.Size.AspectRatio) it).getAspectRatio()));
            } else if (it instanceof OuroDrawableMark.Size.FillWidth) {
                float f = density.toDp-u2uoSUM(mainAxisLength);
                float $this$dp$iv4 = ((OuroDrawableMark.Size.FillWidth) it).getHeight();
                return DpKt.DpSize-YgX7TsA(f, Dp.constructor-impl($this$dp$iv4));
            } else if (it instanceof OuroDrawableMark.Size.ScaledByFontSize) {
                OuroFontSizeMark ouroFontSizeMark = (OuroFontSizeMark) ouroMarks.get(OuroFontSizeMark.Key.INSTANCE);
                float fontSize = ouroFontSizeMark != null ? ouroFontSizeMark.getSize() : 0.0f;
                float width2 = (((OuroDrawableMark.Size.ScaledByFontSize) it).getWidthScale() * fontSize) + ((OuroDrawableMark.Size.ScaledByFontSize) it).getWidthModifier();
                float height = (((OuroDrawableMark.Size.ScaledByFontSize) it).getHeightScale() * fontSize) + ((OuroDrawableMark.Size.ScaledByFontSize) it).getHeightModifier();
                float $this$dp$iv5 = Dp.constructor-impl(width2);
                float $this$dp$iv6 = Dp.constructor-impl(height);
                return DpKt.DpSize-YgX7TsA($this$dp$iv5, $this$dp$iv6);
            } else if (!(it instanceof OuroDrawableMark.Size.BiliBlockImageSize)) {
                throw new NoWhenBranchMatchedException();
            } else {
                return displaySize((OuroDrawableMark.Size.BiliBlockImageSize) it, density, mainAxisLength);
            }
        }
        return DpSize.Companion.getZero-MYxV2XQ();
    }

    public static final long displaySize(OuroDrawableMark.Size.BiliBlockImageSize $this$displaySize, Density density, int mainAxisLength) {
        Intrinsics.checkNotNullParameter($this$displaySize, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        float minWidth = Dp.constructor-impl(46);
        float minHeight = Dp.constructor-impl(46);
        float maxWidth = density.toDp-u2uoSUM(mainAxisLength);
        float imageWidth = density.toDp-u2uoSUM($this$displaySize.getImageWidth());
        float imageHeight = density.toDp-u2uoSUM($this$displaySize.getImageHeight());
        float f = imageWidth / imageHeight;
        if (Dp.compareTo-0680j_4(imageHeight, minHeight) < 0) {
            imageHeight = minHeight;
            float other$iv = Dp.constructor-impl(imageHeight * f);
            imageWidth = other$iv;
        }
        if (Dp.compareTo-0680j_4(imageWidth, minWidth) < 0) {
            imageWidth = minWidth;
        }
        if (Dp.compareTo-0680j_4(imageWidth, maxWidth) > 0) {
            imageWidth = maxWidth;
            float other$iv2 = Dp.constructor-impl(imageWidth / f);
            imageHeight = Dp.constructor-impl(Math.max(minHeight, other$iv2));
        }
        return DpKt.DpSize-YgX7TsA(imageWidth, imageHeight);
    }

    public static final Modifier padding(Modifier $this$padding, OuroDrawableMark.Padding mark) {
        Intrinsics.checkNotNullParameter($this$padding, "<this>");
        if (mark == null) {
            return $this$padding;
        }
        float $this$dp$iv = mark.getLeft();
        float $this$dp$iv2 = Dp.constructor-impl($this$dp$iv);
        float $this$dp$iv3 = mark.getRight();
        float $this$dp$iv4 = Dp.constructor-impl($this$dp$iv3);
        float $this$dp$iv5 = mark.getTop();
        float $this$dp$iv6 = Dp.constructor-impl($this$dp$iv5);
        float $this$dp$iv7 = mark.getBottom();
        return PaddingKt.padding-qDBjuR0($this$padding, $this$dp$iv2, $this$dp$iv6, $this$dp$iv4, Dp.constructor-impl($this$dp$iv7));
    }
}