package kntr.common.ouro.core.utils;

import java.util.Collection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.mark.OuroTextAlignCenterMark;
import kntr.common.ouro.core.model.mark.OuroTextAlignEndMark;
import kntr.common.ouro.core.model.mark.OuroTextIndentMark;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroStateToolbarExt.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\t\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\u0004*\u00020\u0002\u001a\u0019\u0010\u000b\u001a\u00020\u0004\"\n\b\u0000\u0010\f\u0018\u0001*\u00020\r*\u00020\u0002H\u0082\b\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0010\u001a\u00020\u0004*\u00020\u0002\u001a\f\u0010\u0011\u001a\u00020\u0004*\u00020\u0002H\u0002\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0004*\u00020\u0002¨\u0006\u0014"}, d2 = {"canIncreaseIndent", "Lkntr/common/ouro/core/utils/IncreaseIndentCheckResult;", "Lkntr/common/ouro/core/OuroState;", "canDecreaseIndent", "", "canApplyAlignment", "inQuoteBlock", "inOrderedList", "inUnorderedList", "inContainer", "isAlignCenterOrEnd", "inList", "T", "Lkntr/common/ouro/core/model/node/OuroList;", "canApplyQuoteBlock", "canApplyList", "canInsertDivider", "hasHeading", "canApplyHeading", "canInsertPic", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroStateToolbarExtKt {
    public static final IncreaseIndentCheckResult canIncreaseIndent(OuroState $this$canIncreaseIndent) {
        Intrinsics.checkNotNullParameter($this$canIncreaseIndent, "<this>");
        OuroNodeStorage $this$canIncreaseIndent_u24lambda_u240 = $this$canIncreaseIndent.getStorage();
        if (inContainer($this$canIncreaseIndent)) {
            return IncreaseIndentCheckResult.INCLUDE_UNINDENTABLE_ELEMENT;
        }
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$canIncreaseIndent_u24lambda_u240, $this$canIncreaseIndent.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            OuroNodeStorage $this$findFirstAncestorOrNull$iv = $this$canIncreaseIndent_u24lambda_u240;
            OuroParagraph node$iv = paragraph;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroStateToolbarExtKt$canIncreaseIndent$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroListItem);
                }
            }) : null;
            OuroListItem listItem = (OuroListItem) ((OuroNode.Parent) ((OuroListItem) (firstAncestorOrNull instanceof OuroListItem ? firstAncestorOrNull : null)));
            if (listItem != null) {
                int currLevel = 0;
                OuroNode curr = $this$canIncreaseIndent_u24lambda_u240.getParent(listItem);
                if (curr == null) {
                    return IncreaseIndentCheckResult.ALLOW;
                }
                while (true) {
                    OuroNode curr2 = curr;
                    if (!(curr2 instanceof OuroList)) {
                        break;
                    }
                    currLevel++;
                    OuroList $this$canIncreaseIndent_u24lambda_u240_u240_u240 = (OuroList) curr2;
                    curr = $this$canIncreaseIndent_u24lambda_u240_u240_u240.getParentList($this$canIncreaseIndent_u24lambda_u240);
                }
                Integer indexInSiblings = $this$canIncreaseIndent_u24lambda_u240.getIndexInSiblings(listItem);
                if ((indexInSiblings != null ? indexInSiblings.intValue() : 0) <= 0 || currLevel >= 3) {
                    return IncreaseIndentCheckResult.REACHED_MAX_INDENT;
                }
            } else {
                OuroTextIndentMark mark = (OuroTextIndentMark) paragraph.getParagraphMarks().get(OuroTextIndentMark.Key.INSTANCE);
                if (mark != null && (mark.getFirstLine() >= 66.0f || mark.getHanging() >= 66.0f)) {
                    return IncreaseIndentCheckResult.REACHED_MAX_INDENT;
                }
            }
        }
        return IncreaseIndentCheckResult.ALLOW;
    }

    public static final boolean canDecreaseIndent(OuroState $this$canDecreaseIndent) {
        Intrinsics.checkNotNullParameter($this$canDecreaseIndent, "<this>");
        OuroNodeStorage $this$canDecreaseIndent_u24lambda_u240 = $this$canDecreaseIndent.getStorage();
        if (inContainer($this$canDecreaseIndent)) {
            return false;
        }
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$canDecreaseIndent_u24lambda_u240, $this$canDecreaseIndent.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv;
            OuroNodeStorage $this$findFirstAncestorOrNull$iv = $this$canDecreaseIndent_u24lambda_u240;
            OuroParagraph node$iv = paragraph;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroStateToolbarExtKt$canDecreaseIndent$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroListItem);
                }
            }) : null;
            if (!(firstAncestorOrNull instanceof OuroListItem)) {
                firstAncestorOrNull = null;
            }
            OuroListItem listItem = (OuroListItem) firstAncestorOrNull;
            if (listItem == null) {
                OuroTextIndentMark mark = (OuroTextIndentMark) paragraph.getParagraphMarks().get(OuroTextIndentMark.Key.INSTANCE);
                if (mark != null) {
                    if (!(mark.getFirstLine() == 0.0f)) {
                        continue;
                    } else if (mark.getHanging() == 0.0f) {
                    }
                }
                return false;
            }
        }
        return !((Collection) paragraphs).isEmpty();
    }

    public static final boolean canApplyAlignment(OuroState $this$canApplyAlignment) {
        Intrinsics.checkNotNullParameter($this$canApplyAlignment, "<this>");
        OuroNodeStorage $this$canApplyAlignment_u24lambda_u240 = $this$canApplyAlignment.getStorage();
        if (inContainer($this$canApplyAlignment)) {
            return false;
        }
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$canApplyAlignment_u24lambda_u240, $this$canApplyAlignment.getSelection(), false, false, 6, null);
        Iterable $this$all$iv = paragraphs;
        if (($this$all$iv instanceof Collection) && ((Collection) $this$all$iv).isEmpty()) {
            return true;
        }
        for (Object element$iv : $this$all$iv) {
            OuroNode it = (OuroParagraph) element$iv;
            OuroNodeStorage $this$findFirstAncestorOrNull$iv = $this$canApplyAlignment_u24lambda_u240;
            OuroNode node$iv = it;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroStateToolbarExtKt$canApplyAlignment$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroList);
                }
            }) : null;
            if (!((firstAncestorOrNull instanceof OuroList ? firstAncestorOrNull : null) == null)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean inQuoteBlock(OuroState $this$inQuoteBlock) {
        Intrinsics.checkNotNullParameter($this$inQuoteBlock, "<this>");
        OuroNodeStorage $this$inQuoteBlock_u24lambda_u240 = $this$inQuoteBlock.getStorage();
        if (inContainer($this$inQuoteBlock)) {
            return false;
        }
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$inQuoteBlock_u24lambda_u240, $this$inQuoteBlock.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode p = (OuroParagraph) element$iv;
            OuroNodeStorage $this$findFirstAncestorOrNull$iv = $this$inQuoteBlock_u24lambda_u240;
            OuroNode node$iv = p;
            OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.utils.OuroStateToolbarExtKt$inQuoteBlock$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    return Boolean.valueOf(parent instanceof OuroQuoteBlock);
                }
            }) : null;
            OuroQuoteBlock quoteBlock = (OuroQuoteBlock) (!(firstAncestorOrNull instanceof OuroQuoteBlock) ? null : firstAncestorOrNull);
            if (quoteBlock == null) {
                return false;
            }
        }
        return true;
    }

    public static final boolean inOrderedList(OuroState $this$inOrderedList) {
        Intrinsics.checkNotNullParameter($this$inOrderedList, "<this>");
        NodeStorage $this$inList_u24lambda_u240$iv = $this$inOrderedList.getStorage();
        if (inContainer($this$inOrderedList)) {
            return false;
        }
        Iterable paragraphs$iv = OuroNodeStorageKt.getSelectedParagraphs$default($this$inList_u24lambda_u240$iv, $this$inOrderedList.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv$iv = paragraphs$iv;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            OuroParagraph p$iv = (OuroParagraph) element$iv$iv;
            OuroNode parent = $this$inList_u24lambda_u240$iv.getParent(p$iv);
            OuroListItem listItem$iv = parent instanceof OuroListItem ? (OuroListItem) parent : null;
            OuroNode.Parent<?> parent2 = listItem$iv != null ? $this$inList_u24lambda_u240$iv.getParent(listItem$iv) : null;
            OuroList list$iv = (OuroOrderedList) (parent2 instanceof OuroOrderedList ? parent2 : null);
            if (listItem$iv != null) {
                if (list$iv == null) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean inUnorderedList(OuroState $this$inUnorderedList) {
        Intrinsics.checkNotNullParameter($this$inUnorderedList, "<this>");
        NodeStorage $this$inList_u24lambda_u240$iv = $this$inUnorderedList.getStorage();
        if (inContainer($this$inUnorderedList)) {
            return false;
        }
        Iterable paragraphs$iv = OuroNodeStorageKt.getSelectedParagraphs$default($this$inList_u24lambda_u240$iv, $this$inUnorderedList.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv$iv = paragraphs$iv;
        for (Object element$iv$iv : $this$forEach$iv$iv) {
            OuroParagraph p$iv = (OuroParagraph) element$iv$iv;
            OuroNode parent = $this$inList_u24lambda_u240$iv.getParent(p$iv);
            OuroListItem listItem$iv = parent instanceof OuroListItem ? (OuroListItem) parent : null;
            OuroNode.Parent<?> parent2 = listItem$iv != null ? $this$inList_u24lambda_u240$iv.getParent(listItem$iv) : null;
            OuroList list$iv = (OuroUnorderedList) (parent2 instanceof OuroUnorderedList ? parent2 : null);
            if (listItem$iv != null) {
                if (list$iv == null) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean inContainer(OuroState $this$inContainer) {
        Intrinsics.checkNotNullParameter($this$inContainer, "<this>");
        NodeStorage $this$inContainer_u24lambda_u240 = $this$inContainer.getStorage();
        return !OuroNodeStorageKt.getSelectedContainer($this$inContainer_u24lambda_u240, $this$inContainer.getSelection()).isEmpty();
    }

    public static final boolean isAlignCenterOrEnd(OuroState $this$isAlignCenterOrEnd) {
        OuroParagraph it;
        Intrinsics.checkNotNullParameter($this$isAlignCenterOrEnd, "<this>");
        NodeStorage $this$isAlignCenterOrEnd_u24lambda_u240 = $this$isAlignCenterOrEnd.getStorage();
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$isAlignCenterOrEnd_u24lambda_u240, $this$isAlignCenterOrEnd.getSelection(), false, false, 6, null);
        Iterable $this$any$iv = paragraphs;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            OuroParagraph it2 = (OuroParagraph) element$iv;
            if (it2.getParagraphMarks().contains((Object) OuroTextAlignCenterMark.INSTANCE) || it2.getParagraphMarks().contains((Object) OuroTextAlignEndMark.INSTANCE)) {
                it = 1;
                continue;
            } else {
                it = null;
                continue;
            }
            if (it != null) {
                return true;
            }
        }
        return false;
    }

    private static final /* synthetic */ <T extends OuroList> boolean inList(OuroState $this$inList) {
        NodeStorage $this$inList_u24lambda_u240 = $this$inList.getStorage();
        if (inContainer($this$inList)) {
            return false;
        }
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$inList_u24lambda_u240, $this$inList.getSelection(), false, false, 6, null);
        Iterable $this$forEach$iv = paragraphs;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraph p = (OuroParagraph) element$iv;
            OuroNode parent = $this$inList_u24lambda_u240.getParent(p);
            OuroListItem listItem = parent instanceof OuroListItem ? (OuroListItem) parent : null;
            OuroNode.Parent<?> parent2 = listItem != null ? $this$inList_u24lambda_u240.getParent(listItem) : null;
            Intrinsics.reifiedOperationMarker(2, "T");
            OuroList list = (OuroList) parent2;
            if (listItem != null) {
                if (list == null) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean canApplyQuoteBlock(OuroState $this$canApplyQuoteBlock) {
        Intrinsics.checkNotNullParameter($this$canApplyQuoteBlock, "<this>");
        return (inOrderedList($this$canApplyQuoteBlock) || inUnorderedList($this$canApplyQuoteBlock) || inContainer($this$canApplyQuoteBlock) || hasHeading($this$canApplyQuoteBlock)) ? false : true;
    }

    public static final boolean canApplyList(OuroState $this$canApplyList) {
        Intrinsics.checkNotNullParameter($this$canApplyList, "<this>");
        return (inQuoteBlock($this$canApplyList) || inContainer($this$canApplyList) || isAlignCenterOrEnd($this$canApplyList) || hasHeading($this$canApplyList)) ? false : true;
    }

    public static final boolean canInsertDivider(OuroState $this$canInsertDivider) {
        Intrinsics.checkNotNullParameter($this$canInsertDivider, "<this>");
        return (inOrderedList($this$canInsertDivider) || inUnorderedList($this$canInsertDivider) || inQuoteBlock($this$canInsertDivider)) ? false : true;
    }

    private static final boolean hasHeading(OuroState $this$hasHeading) {
        NodeStorage $this$hasHeading_u24lambda_u240 = $this$hasHeading.getStorage();
        Iterable paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$hasHeading_u24lambda_u240, $this$hasHeading.getSelection(), false, false, 6, null);
        Iterable $this$any$iv = paragraphs;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            OuroParagraph it = (OuroParagraph) element$iv;
            if (!(it instanceof OuroText)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean canApplyHeading(OuroState $this$canApplyHeading) {
        Intrinsics.checkNotNullParameter($this$canApplyHeading, "<this>");
        return (inOrderedList($this$canApplyHeading) || inUnorderedList($this$canApplyHeading) || inQuoteBlock($this$canApplyHeading) || inContainer($this$canApplyHeading)) ? false : true;
    }

    public static final boolean canInsertPic(OuroState $this$canInsertPic) {
        Intrinsics.checkNotNullParameter($this$canInsertPic, "<this>");
        return (inOrderedList($this$canInsertPic) || inUnorderedList($this$canInsertPic) || inQuoteBlock($this$canInsertPic)) ? false : true;
    }
}