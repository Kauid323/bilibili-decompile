package kntr.common.ouro.core.reducer;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.action.OuroToggleOrderedListAction;
import kntr.common.ouro.core.action.OuroToggleQuoteAction;
import kntr.common.ouro.core.action.OuroToggleUnorderedListAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorageKt;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kntr.common.ouro.core.utils.FlowReduxUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.OuroStateToolbarExtKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: OuroHierarchyActionReducer.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002\u001a$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002\u001aQ\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\"\n\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00152\u000e\b\u0004\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00172\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0082\b¨\u0006\u0018"}, d2 = {"onHierarchyAction", "", "Lcom/freeletics/flowredux/dsl/InStateBuilderBlock;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "handleToggleQuoteAction", "Lcom/freeletics/flowredux/dsl/ChangedState;", "action", "Lkntr/common/ouro/core/action/OuroToggleQuoteAction;", "state", "Lcom/freeletics/flowredux/dsl/State;", "handleToggleOrderedListAction", "Lkntr/common/ouro/core/action/OuroToggleOrderedListAction;", "handleToggleUnorderedListAction", "Lkntr/common/ouro/core/action/OuroToggleUnorderedListAction;", "handleToggleList", "L", "Lkntr/common/ouro/core/model/node/OuroList;", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "listFactory", "Lkotlin/Function0;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroHierarchyActionReducerKt {
    public static final void onHierarchyAction(InStateBuilderBlock<OuroState, OuroState, OuroAction> inStateBuilderBlock) {
        Intrinsics.checkNotNullParameter(inStateBuilderBlock, "<this>");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv = OuroHierarchyActionReducerKt$onHierarchyAction$1.INSTANCE;
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroToggleQuoteAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv2 = OuroHierarchyActionReducerKt$onHierarchyAction$2.INSTANCE;
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroToggleOrderedListAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock $this$iv3 = (BaseBuilderBlock) inStateBuilderBlock;
        Function3 handler$iv3 = OuroHierarchyActionReducerKt$onHierarchyAction$3.INSTANCE;
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv3.on(Reflection.getOrCreateKotlinClass(OuroToggleUnorderedListAction.class), executionPolicy$iv3, handler$iv3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleToggleQuoteAction(final OuroToggleQuoteAction action, final State<OuroState> state) {
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                OuroState handleToggleQuoteAction$lambda$0;
                handleToggleQuoteAction$lambda$0 = OuroHierarchyActionReducerKt.handleToggleQuoteAction$lambda$0(OuroToggleQuoteAction.this, state, (OuroState) obj);
                return handleToggleQuoteAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleToggleQuoteAction$lambda$0(OuroToggleQuoteAction $action, State $state, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroSelection selection = $action.getSelection();
        if (selection == null) {
            selection = ((OuroState) $state.getSnapshot()).getSelection();
        }
        OuroSelection selection2 = selection;
        final List paragraphs = OuroNodeStorageKt.getSelectedParagraphs$default($this$mutate.getStorage(), selection2, false, false, 6, null);
        NodeStorage newStorage = NodeStorage.mutate$core_debug$default($this$mutate.getStorage(), false, new Function1() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit handleToggleQuoteAction$lambda$0$0;
                handleToggleQuoteAction$lambda$0$0 = OuroHierarchyActionReducerKt.handleToggleQuoteAction$lambda$0$0(paragraphs, (NodeStorageBuilder) obj);
                return handleToggleQuoteAction$lambda$0$0;
            }
        }, 1, null);
        return OuroState.copy$default($this$mutate, newStorage, null, null, null, null, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleToggleQuoteAction$lambda$0$0(List $paragraphs, NodeStorageBuilder $this$mutate) {
        boolean allInSameQuote;
        OuroNode firstElement;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        List $this$mapNotNull$iv = $paragraphs;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            OuroParagraph paragraph = (OuroParagraph) element$iv$iv$iv;
            OuroNode.Parent<?> parent = $this$mutate.getParent(paragraph);
            OuroQuoteBlock ouroQuoteBlock = parent instanceof OuroQuoteBlock ? (OuroQuoteBlock) parent : null;
            if (ouroQuoteBlock != null) {
                destination$iv$iv.add(ouroQuoteBlock);
            }
        }
        List quoteBlocks = (List) destination$iv$iv;
        if (quoteBlocks.isEmpty()) {
            allInSameQuote = false;
        } else if (quoteBlocks.size() != $paragraphs.size()) {
            allInSameQuote = false;
        } else {
            List $this$all$iv = quoteBlocks;
            if (!($this$all$iv instanceof Collection) || !$this$all$iv.isEmpty()) {
                Iterator it = $this$all$iv.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        allInSameQuote = true;
                        break;
                    }
                    Object element$iv = it.next();
                    OuroQuoteBlock it2 = (OuroQuoteBlock) element$iv;
                    if (!Intrinsics.areEqual(it2, CollectionsKt.first(quoteBlocks))) {
                        allInSameQuote = false;
                        break;
                    }
                }
            } else {
                allInSameQuote = true;
            }
        }
        if (!allInSameQuote) {
            OuroParagraph firstPara = (OuroParagraph) CollectionsKt.first($paragraphs);
            List<OuroNode> children = $this$mutate.getChildren(firstPara);
            if (children != null && (firstElement = (OuroNode) CollectionsKt.first(children)) != null) {
                List $this$indexOfFirst$iv = $this$mutate.getAllSelectables();
                int index$iv = 0;
                Iterator<OuroNode.Selectable> it3 = $this$indexOfFirst$iv.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        index$iv = -1;
                        break;
                    }
                    Object item$iv = it3.next();
                    OuroNode.Selectable it4 = (OuroNode.Selectable) item$iv;
                    if (Intrinsics.areEqual(it4, firstElement)) {
                        break;
                    }
                    index$iv++;
                }
                int beforeElementIdx = index$iv;
                OuroNode.Selectable beforeElement = beforeElementIdx > 0 ? $this$mutate.getAllSelectables().get(beforeElementIdx - 1) : null;
                OuroQuoteBlock newQuote = new OuroQuoteBlock((OuroMarks) null, 1, (DefaultConstructorMarker) null);
                List $this$mapNotNull$iv2 = $paragraphs;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
                    OuroParagraph paragraph2 = (OuroParagraph) element$iv$iv$iv2;
                    OuroNode.Parent<?> parent2 = $this$mutate.getParent(paragraph2);
                    List quoteBlocks2 = quoteBlocks;
                    OuroQuoteBlock ouroQuoteBlock2 = parent2 instanceof OuroQuoteBlock ? (OuroQuoteBlock) parent2 : null;
                    if (ouroQuoteBlock2 != null) {
                        destination$iv$iv2.add(ouroQuoteBlock2);
                    }
                    quoteBlocks = quoteBlocks2;
                }
                Iterable quotes = (List) destination$iv$iv2;
                List $this$forEach$iv = $paragraphs;
                for (Object element$iv2 : $this$forEach$iv) {
                    OuroParagraph p = (OuroParagraph) element$iv2;
                    $this$mutate.removeFromParent(p);
                    $this$mutate.add(newQuote, p);
                }
                Iterable $this$forEach$iv2 = quotes;
                for (Object element$iv3 : $this$forEach$iv2) {
                    OuroQuoteBlock q = (OuroQuoteBlock) element$iv3;
                    if (OuroNodeStorageUtilsKt.isEmpty($this$mutate, q)) {
                        $this$mutate.removeFromParent(q);
                    }
                }
                if (beforeElement == null) {
                    $this$mutate.add((OuroNode.Parent) $this$mutate.getRoot(), 0, (OuroNode) newQuote);
                } else {
                    OuroNodeStorageUtilsKt.insertAfter($this$mutate, newQuote, beforeElement);
                }
            }
            return Unit.INSTANCE;
        }
        OuroQuoteBlock quoteBlock = (OuroQuoteBlock) CollectionsKt.first(quoteBlocks);
        OuroNode.Parent quoteParent = $this$mutate.getParent(quoteBlock);
        Integer indexInSiblings = $this$mutate.getIndexInSiblings(quoteBlock);
        int quoteBlockIdx = indexInSiblings != null ? indexInSiblings.intValue() : 0;
        Integer indexInSiblings2 = $this$mutate.getIndexInSiblings((OuroNode) CollectionsKt.first($paragraphs));
        int firstParaIdx = indexInSiblings2 != null ? indexInSiblings2.intValue() : 0;
        Integer indexInSiblings3 = $this$mutate.getIndexInSiblings((OuroNode) CollectionsKt.last($paragraphs));
        int lastParaIdx = indexInSiblings3 != null ? indexInSiblings3.intValue() : 0;
        List<OuroNode> siblings = $this$mutate.getSiblings((OuroNode) CollectionsKt.first($paragraphs));
        int siblingsSize = siblings != null ? siblings.size() : 0;
        List $this$forEach$iv3 = $paragraphs;
        for (Object element$iv4 : $this$forEach$iv3) {
            $this$mutate.removeFromParent((OuroParagraph) element$iv4);
        }
        if (firstParaIdx == 0) {
            if (quoteParent != null) {
                $this$mutate.add(quoteParent, quoteBlockIdx, $paragraphs);
            }
        } else if (lastParaIdx != siblingsSize - 1) {
            Pair divided = quoteBlock.tryDivide();
            OuroQuoteBlock first = (OuroQuoteBlock) divided.component1();
            OuroQuoteBlock second = (OuroQuoteBlock) divided.component2();
            List children2 = $this$mutate.removeAllChildren(quoteBlock);
            if ((children2 != null && (children2.isEmpty() ^ true)) && children2.size() > firstParaIdx) {
                $this$mutate.add(first, children2.subList(0, firstParaIdx));
                $this$mutate.add(second, children2.subList(firstParaIdx, children2.size()));
            }
            $this$mutate.replace((NodeStorageBuilder) quoteBlock, (Collection<? extends NodeStorageBuilder>) CollectionsKt.listOf(new OuroQuoteBlock[]{first, second}));
            OuroNode.Parent<?> parent3 = $this$mutate.getParent(first);
            if (parent3 != null) {
                $this$mutate.add(parent3, quoteBlockIdx + 1, $paragraphs);
            }
        } else if (quoteParent != null) {
            $this$mutate.add(quoteParent, quoteBlockIdx + 1, $paragraphs);
        }
        List<OuroNode> children3 = $this$mutate.getChildren(quoteBlock);
        if (children3 == null || children3.isEmpty()) {
            $this$mutate.removeFromParent(quoteBlock);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleToggleOrderedListAction(OuroToggleOrderedListAction action, final State<OuroState> state) {
        final OuroSelection selection$iv = action.getSelection();
        CompletableDeferred deferred$iv = action.getDeferred();
        return FlowReduxUtilsKt.mutate(state, deferred$iv, new Function1<OuroState, OuroState>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleOrderedListAction$$inlined$handleToggleList$1
            public final OuroState invoke(OuroState $this$mutate) {
                Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
                if (OuroStateToolbarExtKt.canApplyList($this$mutate)) {
                    final OuroSelection selection = OuroSelection.this;
                    if (selection == null) {
                        selection = ((OuroState) state.getSnapshot()).getSelection();
                    }
                    NodeStorage newStorage = NodeStorage.mutate$core_debug$default($this$mutate.getStorage(), false, new Function1<NodeStorageBuilder<OuroDocument>, Unit>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleOrderedListAction$$inlined$handleToggleList$1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((NodeStorageBuilder) p1);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:150:0x03f4, code lost:
                            r11 = r33.getParent(r6);
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:151:0x03fb, code lost:
                            if (r11 == null) goto L180;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:152:0x03fd, code lost:
                            r33.add(r11, r2, r1);
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(final NodeStorageBuilder<OuroDocument> $this$collectNodeInParentWithDFS$iv) {
                            Iterable $this$forEach$iv;
                            List paragraphs;
                            List paragraphsInUnorderedList;
                            Iterable $this$forEachIndexed$iv;
                            boolean z;
                            Iterable reversed;
                            Intrinsics.checkNotNullParameter($this$collectNodeInParentWithDFS$iv, "$this$mutate");
                            List paragraphs2 = OuroNodeStorageKt.getSelectedParagraphs$default($this$collectNodeInParentWithDFS$iv, OuroSelection.this, false, false, 6, null);
                            if (paragraphs2.isEmpty()) {
                                return;
                            }
                            List<OuroParagraph> $this$mapNotNull$iv = paragraphs2;
                            Collection destination$iv$iv = new ArrayList();
                            for (OuroParagraph it : $this$mapNotNull$iv) {
                                OuroNode.Parent<?> parent = $this$collectNodeInParentWithDFS$iv.getParent(it);
                                OuroListItem ouroListItem = parent instanceof OuroListItem ? (OuroListItem) parent : null;
                                if (ouroListItem != null) {
                                    destination$iv$iv.add(ouroListItem);
                                }
                            }
                            List listItems = (List) destination$iv$iv;
                            List $this$filter$iv = paragraphs2;
                            Collection destination$iv$iv2 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                OuroNode.Parent<?> parent2 = $this$collectNodeInParentWithDFS$iv.getParent((OuroParagraph) element$iv$iv);
                                if ((parent2 != null ? $this$collectNodeInParentWithDFS$iv.getParent(parent2) : null) instanceof OuroOrderedList) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            List list = (List) destination$iv$iv2;
                            if (list.size() != paragraphs2.size()) {
                                List $this$forEach$iv2 = paragraphs2;
                                for (Object element$iv : $this$forEach$iv2) {
                                    OuroNode p = (OuroParagraph) element$iv;
                                    NodeStorageBuilder<OuroDocument> $this$findFirstAncestorOrNull$iv = $this$collectNodeInParentWithDFS$iv;
                                    OuroNode node$iv = p;
                                    OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, OuroHierarchyActionReducerKt$handleToggleList$1$newStorage$1$invoke$lambda$3$$inlined$findFirstAncestorOrNull$1.INSTANCE) : null;
                                    if (!(firstAncestorOrNull instanceof OuroList)) {
                                        firstAncestorOrNull = null;
                                    }
                                    OuroList $this$invoke_u24lambda_u243_u240 = (OuroList) firstAncestorOrNull;
                                    boolean z2 = false;
                                    if ($this$invoke_u24lambda_u243_u240 != null) {
                                        if (OuroOrderedList.class == OuroUnorderedList.class) {
                                            $this$invoke_u24lambda_u243_u240.toUnorderedList($this$collectNodeInParentWithDFS$iv, false);
                                        } else {
                                            $this$invoke_u24lambda_u243_u240.toOrderedList($this$collectNodeInParentWithDFS$iv, false);
                                        }
                                        $this$forEach$iv = $this$forEach$iv2;
                                        paragraphs = paragraphs2;
                                    } else {
                                        Function1 listItem = new Function1<OuroParagraph, OuroListItem>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleOrderedListAction$.inlined.handleToggleList.1.1.1
                                            public final OuroListItem invoke(OuroParagraph p2) {
                                                Intrinsics.checkNotNullParameter(p2, "p");
                                                OuroListItem item = new OuroListItem((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                                                NodeStorageBuilder.this.removeFromParent(p2);
                                                NodeStorageBuilder.this.add(item, p2);
                                                return item;
                                            }
                                        };
                                        OuroNode siblingPrev = $this$collectNodeInParentWithDFS$iv.getSiblingPrev(p);
                                        OuroNode siblingNext = $this$collectNodeInParentWithDFS$iv.getSiblingNext(p);
                                        OuroList it2 = (OuroOrderedList) (!(siblingPrev instanceof OuroOrderedList) ? null : siblingPrev);
                                        if (it2 != null) {
                                            $this$collectNodeInParentWithDFS$iv.add(it2, (OuroNode) listItem.invoke(p));
                                            if (((OuroOrderedList) (!(siblingNext instanceof OuroOrderedList) ? null : siblingNext)) != null) {
                                                Iterable $this$forEach$iv3 = $this$collectNodeInParentWithDFS$iv.getChildrenOrNull((OuroNode.Parent) siblingNext);
                                                if ($this$forEach$iv3 != null) {
                                                    for (Object element$iv2 : $this$forEach$iv3) {
                                                        OuroListItem child = (OuroListItem) element$iv2;
                                                        $this$collectNodeInParentWithDFS$iv.removeFromParent(child);
                                                        $this$collectNodeInParentWithDFS$iv.add((OuroNode.Parent) siblingPrev, child);
                                                        $this$forEach$iv2 = $this$forEach$iv2;
                                                        paragraphs2 = paragraphs2;
                                                    }
                                                    $this$forEach$iv = $this$forEach$iv2;
                                                    paragraphs = paragraphs2;
                                                } else {
                                                    $this$forEach$iv = $this$forEach$iv2;
                                                    paragraphs = paragraphs2;
                                                }
                                                $this$collectNodeInParentWithDFS$iv.removeFromParent(siblingNext);
                                            } else {
                                                $this$forEach$iv = $this$forEach$iv2;
                                                paragraphs = paragraphs2;
                                            }
                                        } else {
                                            $this$forEach$iv = $this$forEach$iv2;
                                            paragraphs = paragraphs2;
                                            OuroList it3 = (OuroOrderedList) (!(siblingNext instanceof OuroOrderedList) ? null : siblingNext);
                                            if (it3 != null) {
                                                $this$collectNodeInParentWithDFS$iv.add(it3, 0, (OuroNode) listItem.invoke(p));
                                            } else {
                                                OuroList newList = new OuroOrderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                                                Integer indexInSiblings = $this$collectNodeInParentWithDFS$iv.getIndexInSiblings(p);
                                                int indexInSiblings2 = indexInSiblings != null ? indexInSiblings.intValue() : 0;
                                                OuroNode.Parent<?> parent3 = $this$collectNodeInParentWithDFS$iv.getParent(p);
                                                if (parent3 != null && parent3.isValidParentOf(newList)) {
                                                    z2 = true;
                                                }
                                                $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), newList);
                                                $this$collectNodeInParentWithDFS$iv.add(newList, (OuroNode) listItem.invoke(p));
                                            }
                                        }
                                    }
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    paragraphs2 = paragraphs;
                                }
                                return;
                            }
                            Iterable $this$forEachIndexed$iv2 = CollectionsKt.reversed(listItems);
                            boolean z3 = false;
                            int index = 0;
                            for (Object item$iv : $this$forEachIndexed$iv2) {
                                int index$iv = index + 1;
                                if (index < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                OuroNode item = (OuroListItem) item$iv;
                                NodeStorageBuilder<OuroDocument> $this$findLastAncestorOrNull$iv = $this$collectNodeInParentWithDFS$iv;
                                OuroNode.Parent current$iv = $this$findLastAncestorOrNull$iv.getParent(item);
                                OuroNode.Parent ancestor$iv = null;
                                OuroNode.Parent current$iv2 = current$iv;
                                while (current$iv2 != null) {
                                    List listItems2 = listItems;
                                    if (current$iv2 instanceof OuroList) {
                                        ancestor$iv = current$iv2;
                                    }
                                    current$iv2 = $this$findLastAncestorOrNull$iv.getParent(current$iv2);
                                    listItems = listItems2;
                                }
                                List listItems3 = listItems;
                                OuroList rootList = (OuroList) ancestor$iv;
                                if (rootList == null) {
                                    throw new IllegalStateException("OuroListItem must have a parent OuroList");
                                }
                                Integer indexInSiblings3 = $this$collectNodeInParentWithDFS$iv.getIndexInSiblings(rootList);
                                if (indexInSiblings3 == null) {
                                    throw new IllegalStateException("Root list item should have index in siblings");
                                }
                                int rootListIndexInSiblings = indexInSiblings3.intValue();
                                if (index == 0) {
                                    OuroList parent$iv = rootList;
                                    paragraphsInUnorderedList = list;
                                    List nodeList$iv = new ArrayList();
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    OuroNodeStorageUtilsKt.collectNodes($this$collectNodeInParentWithDFS$iv, parent$iv, nodeList$iv);
                                    List $this$filterIsInstance$iv$iv = nodeList$iv;
                                    Collection destination$iv$iv$iv = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                                        Iterable $this$filterIsInstance$iv$iv2 = $this$filterIsInstance$iv$iv;
                                        boolean z4 = z3;
                                        if (element$iv$iv$iv instanceof OuroListItem) {
                                            destination$iv$iv$iv.add(element$iv$iv$iv);
                                        }
                                        $this$filterIsInstance$iv$iv = $this$filterIsInstance$iv$iv2;
                                        z3 = z4;
                                    }
                                    z = z3;
                                    List list2 = (List) destination$iv$iv$iv;
                                    List $this$indexOfFirst$iv = list2;
                                    int index$iv2 = 0;
                                    Iterator it4 = $this$indexOfFirst$iv.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            index$iv2 = -1;
                                            break;
                                        }
                                        Object item$iv2 = it4.next();
                                        List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                                        if (Intrinsics.areEqual((OuroListItem) item$iv2, item)) {
                                            break;
                                        }
                                        index$iv2++;
                                        $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                                    }
                                    int itemIndex = index$iv2;
                                    if (itemIndex < list2.size() - 1) {
                                        OuroList newList2 = rootList.copy();
                                        List listItemsToMove = CollectionsKt.toList(list2.subList(itemIndex + 1, list2.size()));
                                        int index2 = 0;
                                        while (index2 < listItemsToMove.size()) {
                                            OuroNode.Parent listItem2 = (OuroListItem) listItemsToMove.get(index2);
                                            OuroList rootList2 = rootList;
                                            NodeStorageBuilder<OuroDocument> $this$collectNodeInParentWithDFS$iv2 = $this$collectNodeInParentWithDFS$iv;
                                            OuroNode.Parent parent$iv2 = listItem2;
                                            ArrayList arrayList = list2;
                                            List nodeList$iv2 = new ArrayList();
                                            int itemIndex2 = itemIndex;
                                            OuroNodeStorageUtilsKt.collectNodes($this$collectNodeInParentWithDFS$iv2, parent$iv2, nodeList$iv2);
                                            Collection destination$iv$iv$iv2 = new ArrayList();
                                            for (Object element$iv$iv$iv2 : nodeList$iv2) {
                                                OuroNodeStorage $this$collectNodeInParentWithDFS$iv3 = $this$collectNodeInParentWithDFS$iv2;
                                                List nodeList$iv3 = nodeList$iv2;
                                                if (element$iv$iv$iv2 instanceof OuroListItem) {
                                                    destination$iv$iv$iv2.add(element$iv$iv$iv2);
                                                }
                                                $this$collectNodeInParentWithDFS$iv2 = $this$collectNodeInParentWithDFS$iv3;
                                                nodeList$iv2 = nodeList$iv3;
                                            }
                                            int subtreeListItemCount = ((List) destination$iv$iv$iv2).size();
                                            $this$collectNodeInParentWithDFS$iv.removeFromParent(listItem2);
                                            $this$collectNodeInParentWithDFS$iv.add(newList2, listItem2);
                                            index2 += subtreeListItemCount;
                                            rootList = rootList2;
                                            itemIndex = itemIndex2;
                                            list2 = arrayList;
                                        }
                                        $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), rootListIndexInSiblings + 1, newList2);
                                    }
                                } else {
                                    paragraphsInUnorderedList = list;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    z = z3;
                                }
                                List<OuroNode> children = $this$collectNodeInParentWithDFS$iv.getChildren((OuroNode.Parent) item);
                                if (children != null && (reversed = CollectionsKt.reversed(children)) != null) {
                                    Iterable $this$forEach$iv4 = reversed;
                                    for (Object element$iv3 : $this$forEach$iv4) {
                                        OuroNode it5 = (OuroNode) element$iv3;
                                        $this$collectNodeInParentWithDFS$iv.removeFromParent(it5);
                                        $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), rootListIndexInSiblings + 1, it5);
                                        $this$forEach$iv4 = $this$forEach$iv4;
                                    }
                                }
                                index = index$iv;
                                listItems = listItems3;
                                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                list = paragraphsInUnorderedList;
                                z3 = z;
                            }
                        }
                    }, 1, null);
                    return OuroState.copy$default($this$mutate, newStorage, null, null, null, null, 30, null);
                }
                return $this$mutate;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState<OuroState> handleToggleUnorderedListAction(OuroToggleUnorderedListAction action, final State<OuroState> state) {
        final OuroSelection selection$iv = action.getSelection();
        CompletableDeferred deferred$iv = action.getDeferred();
        return FlowReduxUtilsKt.mutate(state, deferred$iv, new Function1<OuroState, OuroState>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleUnorderedListAction$$inlined$handleToggleList$1
            public final OuroState invoke(OuroState $this$mutate) {
                Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
                if (OuroStateToolbarExtKt.canApplyList($this$mutate)) {
                    final OuroSelection selection = OuroSelection.this;
                    if (selection == null) {
                        selection = ((OuroState) state.getSnapshot()).getSelection();
                    }
                    NodeStorage newStorage = NodeStorage.mutate$core_debug$default($this$mutate.getStorage(), false, new Function1<NodeStorageBuilder<OuroDocument>, Unit>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleUnorderedListAction$$inlined$handleToggleList$1.1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            invoke((NodeStorageBuilder) p1);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:150:0x03f4, code lost:
                            r11 = r33.getParent(r6);
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:151:0x03fb, code lost:
                            if (r11 == null) goto L180;
                         */
                        /* JADX WARN: Code restructure failed: missing block: B:152:0x03fd, code lost:
                            r33.add(r11, r2, r1);
                         */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final void invoke(final NodeStorageBuilder<OuroDocument> $this$collectNodeInParentWithDFS$iv) {
                            Iterable $this$forEach$iv;
                            List paragraphs;
                            List paragraphsInUnorderedList;
                            Iterable $this$forEachIndexed$iv;
                            boolean z;
                            Iterable reversed;
                            Intrinsics.checkNotNullParameter($this$collectNodeInParentWithDFS$iv, "$this$mutate");
                            List paragraphs2 = OuroNodeStorageKt.getSelectedParagraphs$default($this$collectNodeInParentWithDFS$iv, OuroSelection.this, false, false, 6, null);
                            if (paragraphs2.isEmpty()) {
                                return;
                            }
                            List<OuroParagraph> $this$mapNotNull$iv = paragraphs2;
                            Collection destination$iv$iv = new ArrayList();
                            for (OuroParagraph it : $this$mapNotNull$iv) {
                                OuroNode.Parent<?> parent = $this$collectNodeInParentWithDFS$iv.getParent(it);
                                OuroListItem ouroListItem = parent instanceof OuroListItem ? (OuroListItem) parent : null;
                                if (ouroListItem != null) {
                                    destination$iv$iv.add(ouroListItem);
                                }
                            }
                            List listItems = (List) destination$iv$iv;
                            List $this$filter$iv = paragraphs2;
                            Collection destination$iv$iv2 = new ArrayList();
                            for (Object element$iv$iv : $this$filter$iv) {
                                OuroNode.Parent<?> parent2 = $this$collectNodeInParentWithDFS$iv.getParent((OuroParagraph) element$iv$iv);
                                if ((parent2 != null ? $this$collectNodeInParentWithDFS$iv.getParent(parent2) : null) instanceof OuroUnorderedList) {
                                    destination$iv$iv2.add(element$iv$iv);
                                }
                            }
                            List list = (List) destination$iv$iv2;
                            if (list.size() != paragraphs2.size()) {
                                List $this$forEach$iv2 = paragraphs2;
                                for (Object element$iv : $this$forEach$iv2) {
                                    OuroNode p = (OuroParagraph) element$iv;
                                    NodeStorageBuilder<OuroDocument> $this$findFirstAncestorOrNull$iv = $this$collectNodeInParentWithDFS$iv;
                                    OuroNode node$iv = p;
                                    OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, OuroHierarchyActionReducerKt$handleToggleList$1$newStorage$1$invoke$lambda$3$$inlined$findFirstAncestorOrNull$1.INSTANCE) : null;
                                    if (!(firstAncestorOrNull instanceof OuroList)) {
                                        firstAncestorOrNull = null;
                                    }
                                    OuroList $this$invoke_u24lambda_u243_u240 = (OuroList) firstAncestorOrNull;
                                    boolean z2 = false;
                                    if ($this$invoke_u24lambda_u243_u240 != null) {
                                        if (OuroUnorderedList.class == OuroUnorderedList.class) {
                                            $this$invoke_u24lambda_u243_u240.toUnorderedList($this$collectNodeInParentWithDFS$iv, false);
                                        } else {
                                            $this$invoke_u24lambda_u243_u240.toOrderedList($this$collectNodeInParentWithDFS$iv, false);
                                        }
                                        $this$forEach$iv = $this$forEach$iv2;
                                        paragraphs = paragraphs2;
                                    } else {
                                        Function1 listItem = new Function1<OuroParagraph, OuroListItem>() { // from class: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleUnorderedListAction$.inlined.handleToggleList.1.1.1
                                            public final OuroListItem invoke(OuroParagraph p2) {
                                                Intrinsics.checkNotNullParameter(p2, "p");
                                                OuroListItem item = new OuroListItem((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                                                NodeStorageBuilder.this.removeFromParent(p2);
                                                NodeStorageBuilder.this.add(item, p2);
                                                return item;
                                            }
                                        };
                                        OuroNode siblingPrev = $this$collectNodeInParentWithDFS$iv.getSiblingPrev(p);
                                        OuroNode siblingNext = $this$collectNodeInParentWithDFS$iv.getSiblingNext(p);
                                        OuroList it2 = (OuroUnorderedList) (!(siblingPrev instanceof OuroUnorderedList) ? null : siblingPrev);
                                        if (it2 != null) {
                                            $this$collectNodeInParentWithDFS$iv.add(it2, (OuroNode) listItem.invoke(p));
                                            if (((OuroUnorderedList) (!(siblingNext instanceof OuroUnorderedList) ? null : siblingNext)) != null) {
                                                Iterable $this$forEach$iv3 = $this$collectNodeInParentWithDFS$iv.getChildrenOrNull((OuroNode.Parent) siblingNext);
                                                if ($this$forEach$iv3 != null) {
                                                    for (Object element$iv2 : $this$forEach$iv3) {
                                                        OuroListItem child = (OuroListItem) element$iv2;
                                                        $this$collectNodeInParentWithDFS$iv.removeFromParent(child);
                                                        $this$collectNodeInParentWithDFS$iv.add((OuroNode.Parent) siblingPrev, child);
                                                        $this$forEach$iv2 = $this$forEach$iv2;
                                                        paragraphs2 = paragraphs2;
                                                    }
                                                    $this$forEach$iv = $this$forEach$iv2;
                                                    paragraphs = paragraphs2;
                                                } else {
                                                    $this$forEach$iv = $this$forEach$iv2;
                                                    paragraphs = paragraphs2;
                                                }
                                                $this$collectNodeInParentWithDFS$iv.removeFromParent(siblingNext);
                                            } else {
                                                $this$forEach$iv = $this$forEach$iv2;
                                                paragraphs = paragraphs2;
                                            }
                                        } else {
                                            $this$forEach$iv = $this$forEach$iv2;
                                            paragraphs = paragraphs2;
                                            OuroList it3 = (OuroUnorderedList) (!(siblingNext instanceof OuroUnorderedList) ? null : siblingNext);
                                            if (it3 != null) {
                                                $this$collectNodeInParentWithDFS$iv.add(it3, 0, (OuroNode) listItem.invoke(p));
                                            } else {
                                                OuroList newList = new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
                                                Integer indexInSiblings = $this$collectNodeInParentWithDFS$iv.getIndexInSiblings(p);
                                                int indexInSiblings2 = indexInSiblings != null ? indexInSiblings.intValue() : 0;
                                                OuroNode.Parent<?> parent3 = $this$collectNodeInParentWithDFS$iv.getParent(p);
                                                if (parent3 != null && parent3.isValidParentOf(newList)) {
                                                    z2 = true;
                                                }
                                                $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), newList);
                                                $this$collectNodeInParentWithDFS$iv.add(newList, (OuroNode) listItem.invoke(p));
                                            }
                                        }
                                    }
                                    $this$forEach$iv2 = $this$forEach$iv;
                                    paragraphs2 = paragraphs;
                                }
                                return;
                            }
                            Iterable $this$forEachIndexed$iv2 = CollectionsKt.reversed(listItems);
                            boolean z3 = false;
                            int index = 0;
                            for (Object item$iv : $this$forEachIndexed$iv2) {
                                int index$iv = index + 1;
                                if (index < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                OuroNode item = (OuroListItem) item$iv;
                                NodeStorageBuilder<OuroDocument> $this$findLastAncestorOrNull$iv = $this$collectNodeInParentWithDFS$iv;
                                OuroNode.Parent current$iv = $this$findLastAncestorOrNull$iv.getParent(item);
                                OuroNode.Parent ancestor$iv = null;
                                OuroNode.Parent current$iv2 = current$iv;
                                while (current$iv2 != null) {
                                    List listItems2 = listItems;
                                    if (current$iv2 instanceof OuroList) {
                                        ancestor$iv = current$iv2;
                                    }
                                    current$iv2 = $this$findLastAncestorOrNull$iv.getParent(current$iv2);
                                    listItems = listItems2;
                                }
                                List listItems3 = listItems;
                                OuroList rootList = (OuroList) ancestor$iv;
                                if (rootList == null) {
                                    throw new IllegalStateException("OuroListItem must have a parent OuroList");
                                }
                                Integer indexInSiblings3 = $this$collectNodeInParentWithDFS$iv.getIndexInSiblings(rootList);
                                if (indexInSiblings3 == null) {
                                    throw new IllegalStateException("Root list item should have index in siblings");
                                }
                                int rootListIndexInSiblings = indexInSiblings3.intValue();
                                if (index == 0) {
                                    OuroList parent$iv = rootList;
                                    paragraphsInUnorderedList = list;
                                    List nodeList$iv = new ArrayList();
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    OuroNodeStorageUtilsKt.collectNodes($this$collectNodeInParentWithDFS$iv, parent$iv, nodeList$iv);
                                    List $this$filterIsInstance$iv$iv = nodeList$iv;
                                    Collection destination$iv$iv$iv = new ArrayList();
                                    for (Object element$iv$iv$iv : $this$filterIsInstance$iv$iv) {
                                        Iterable $this$filterIsInstance$iv$iv2 = $this$filterIsInstance$iv$iv;
                                        boolean z4 = z3;
                                        if (element$iv$iv$iv instanceof OuroListItem) {
                                            destination$iv$iv$iv.add(element$iv$iv$iv);
                                        }
                                        $this$filterIsInstance$iv$iv = $this$filterIsInstance$iv$iv2;
                                        z3 = z4;
                                    }
                                    z = z3;
                                    List list2 = (List) destination$iv$iv$iv;
                                    List $this$indexOfFirst$iv = list2;
                                    int index$iv2 = 0;
                                    Iterator it4 = $this$indexOfFirst$iv.iterator();
                                    while (true) {
                                        if (!it4.hasNext()) {
                                            index$iv2 = -1;
                                            break;
                                        }
                                        Object item$iv2 = it4.next();
                                        List $this$indexOfFirst$iv2 = $this$indexOfFirst$iv;
                                        if (Intrinsics.areEqual((OuroListItem) item$iv2, item)) {
                                            break;
                                        }
                                        index$iv2++;
                                        $this$indexOfFirst$iv = $this$indexOfFirst$iv2;
                                    }
                                    int itemIndex = index$iv2;
                                    if (itemIndex < list2.size() - 1) {
                                        OuroList newList2 = rootList.copy();
                                        List listItemsToMove = CollectionsKt.toList(list2.subList(itemIndex + 1, list2.size()));
                                        int index2 = 0;
                                        while (index2 < listItemsToMove.size()) {
                                            OuroNode.Parent listItem2 = (OuroListItem) listItemsToMove.get(index2);
                                            OuroList rootList2 = rootList;
                                            NodeStorageBuilder<OuroDocument> $this$collectNodeInParentWithDFS$iv2 = $this$collectNodeInParentWithDFS$iv;
                                            OuroNode.Parent parent$iv2 = listItem2;
                                            ArrayList arrayList = list2;
                                            List nodeList$iv2 = new ArrayList();
                                            int itemIndex2 = itemIndex;
                                            OuroNodeStorageUtilsKt.collectNodes($this$collectNodeInParentWithDFS$iv2, parent$iv2, nodeList$iv2);
                                            Collection destination$iv$iv$iv2 = new ArrayList();
                                            for (Object element$iv$iv$iv2 : nodeList$iv2) {
                                                OuroNodeStorage $this$collectNodeInParentWithDFS$iv3 = $this$collectNodeInParentWithDFS$iv2;
                                                List nodeList$iv3 = nodeList$iv2;
                                                if (element$iv$iv$iv2 instanceof OuroListItem) {
                                                    destination$iv$iv$iv2.add(element$iv$iv$iv2);
                                                }
                                                $this$collectNodeInParentWithDFS$iv2 = $this$collectNodeInParentWithDFS$iv3;
                                                nodeList$iv2 = nodeList$iv3;
                                            }
                                            int subtreeListItemCount = ((List) destination$iv$iv$iv2).size();
                                            $this$collectNodeInParentWithDFS$iv.removeFromParent(listItem2);
                                            $this$collectNodeInParentWithDFS$iv.add(newList2, listItem2);
                                            index2 += subtreeListItemCount;
                                            rootList = rootList2;
                                            itemIndex = itemIndex2;
                                            list2 = arrayList;
                                        }
                                        $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), rootListIndexInSiblings + 1, newList2);
                                    }
                                } else {
                                    paragraphsInUnorderedList = list;
                                    $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                                    z = z3;
                                }
                                List<OuroNode> children = $this$collectNodeInParentWithDFS$iv.getChildren((OuroNode.Parent) item);
                                if (children != null && (reversed = CollectionsKt.reversed(children)) != null) {
                                    Iterable $this$forEach$iv4 = reversed;
                                    for (Object element$iv3 : $this$forEach$iv4) {
                                        OuroNode it5 = (OuroNode) element$iv3;
                                        $this$collectNodeInParentWithDFS$iv.removeFromParent(it5);
                                        $this$collectNodeInParentWithDFS$iv.add($this$collectNodeInParentWithDFS$iv.getRoot(), rootListIndexInSiblings + 1, it5);
                                        $this$forEach$iv4 = $this$forEach$iv4;
                                    }
                                }
                                index = index$iv;
                                listItems = listItems3;
                                $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                                list = paragraphsInUnorderedList;
                                z3 = z;
                            }
                        }
                    }, 1, null);
                    return OuroState.copy$default($this$mutate, newStorage, null, null, null, null, 30, null);
                }
                return $this$mutate;
            }
        });
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MarkMethodsForInline
        java.lang.IndexOutOfBoundsException: Index: 0
        	at java.util.Collections$EmptyList.get(Collections.java:4456)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    private static final /* synthetic */ <L extends kntr.common.ouro.core.model.node.OuroList> com.freeletics.flowredux.dsl.ChangedState<kntr.common.ouro.core.OuroState> handleToggleList(final kntr.common.ouro.core.model.OuroSelection r2, kotlinx.coroutines.CompletableDeferred<kntr.common.ouro.core.OuroState> r3, final kotlin.jvm.functions.Function0<? extends L> r4, final com.freeletics.flowredux.dsl.State<kntr.common.ouro.core.OuroState> r5) {
        /*
            r0 = 0
            kotlin.jvm.internal.Intrinsics.needClassReification()
            kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleList$1 r1 = new kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt$handleToggleList$1
            r1.<init>()
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            com.freeletics.flowredux.dsl.ChangedState r1 = kntr.common.ouro.core.utils.FlowReduxUtilsKt.mutate(r5, r3, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.common.ouro.core.reducer.OuroHierarchyActionReducerKt.handleToggleList(kntr.common.ouro.core.model.OuroSelection, kotlinx.coroutines.CompletableDeferred, kotlin.jvm.functions.Function0, com.freeletics.flowredux.dsl.State):com.freeletics.flowredux.dsl.ChangedState");
    }
}