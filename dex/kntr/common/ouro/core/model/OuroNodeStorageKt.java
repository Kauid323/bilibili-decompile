package kntr.common.ouro.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0006\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007\u001a\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a,\u0010\u000b\u001a\u00020\f*\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u001a6\u0010\u0012\u001a\u0004\u0018\u0001H\u0013\"\u0012\b\u0000\u0010\u0013\u0018\u0001*\n\u0012\u0002\b\u00030\u0014j\u0002`\u0015*\u0006\u0012\u0002\b\u00030\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086\b¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0004\u0018\u0001H\u0013\"\u0012\b\u0000\u0010\u0013\u0018\u0001*\n\u0012\u0002\b\u00030\u0014j\u0002`\u0015*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0086\b¢\u0006\u0002\u0010\u0016\u001aG\u0010\u001f\u001a\u00020\f\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\u0006\u0010\"\u001a\u0002H H\u0002¢\u0006\u0002\u0010#\u001aO\u0010\u001f\u001a\u00020\f\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\u0006\u0010\"\u001a\u0002H 2\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010&\u001aH\u0010'\u001a\u00020\f\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H 0)H\u0002\u001aP\u0010'\u001a\u00020\f\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H 0)2\u0006\u0010$\u001a\u00020%H\u0002\u001aG\u0010*\u001a\u00020\u0007\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\u0006\u0010\"\u001a\u0002H H\u0002¢\u0006\u0002\u0010+\u001aI\u0010,\u001a\u0004\u0018\u0001H \"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\u0006\u0010$\u001a\u00020%H\u0002¢\u0006\u0002\u0010-\u001aH\u0010.\u001a\u00020\u0007\"\b\b\u0000\u0010 *\u00020\u000e*\u0018\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001bj\u0002`!2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H 0\u00142\f\u0010(\u001a\b\u0012\u0004\u0012\u0002H 0)H\u0002*,\b\u0002\u0010\u0018\"\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002`\u00150\u00192\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0002\b\u00030\u0014j\u0002`\u00150\u0019*,\b\u0002\u0010\u001a\"\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u0002`\u00150\u001b2\u0016\u0012\u0004\u0012\u00020\u000e\u0012\f\u0012\n\u0012\u0002\b\u00030\u0014j\u0002`\u00150\u001b*0\b\u0002\u0010\u001c\"\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00010\u00192\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00010\u0019*0\b\u0002\u0010\u001d\"\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001b2\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001e0\u001b¨\u0006/"}, d2 = {"getSelectedParagraphs", "", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "ignoreBefore", "", "ignoreAfter", "getSelectedContainer", "Lkntr/common/ouro/core/model/node/drawable/OuroBoxContainer;", "printTree", "", "node", "Lkntr/common/ouro/core/model/node/OuroNode;", "indent", "", "isLast", "findFirstAncestorOrNull", "P", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "(Lkntr/common/ouro/core/model/OuroNodeStorage;Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "findLastAncestorOrNull", "OuroParentMap", "", "OuroParentMutableMap", "", "OuroChildrenMap", "OuroChildrenMutableMap", "", "addChild", "C", "Lkntr/common/ouro/core/model/OuroChildrenMutableMap;", "child", "(Ljava/util/Map;Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)V", "index", "", "(Ljava/util/Map;Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;I)V", "addChildren", "children", "", "removeChild", "(Ljava/util/Map;Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)Z", "removeChildAt", "(Ljava/util/Map;Lkntr/common/ouro/core/model/node/OuroNode$Parent;I)Lkntr/common/ouro/core/model/node/OuroNode;", "removeChildren", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroNodeStorageKt {
    public static final /* synthetic */ void access$addChild(Map $receiver, OuroNode.Parent node, OuroNode child) {
        addChild($receiver, node, child);
    }

    public static final /* synthetic */ void access$addChild(Map $receiver, OuroNode.Parent node, OuroNode child, int index) {
        addChild($receiver, node, child, index);
    }

    public static final /* synthetic */ void access$addChildren(Map $receiver, OuroNode.Parent node, Collection children) {
        addChildren($receiver, node, children);
    }

    public static final /* synthetic */ void access$addChildren(Map $receiver, OuroNode.Parent node, Collection children, int index) {
        addChildren($receiver, node, children, index);
    }

    public static final /* synthetic */ boolean access$removeChild(Map $receiver, OuroNode.Parent node, OuroNode child) {
        return removeChild($receiver, node, child);
    }

    public static final /* synthetic */ boolean access$removeChildren(Map $receiver, OuroNode.Parent node, Collection children) {
        return removeChildren($receiver, node, children);
    }

    public static /* synthetic */ List getSelectedParagraphs$default(OuroNodeStorage ouroNodeStorage, OuroSelection ouroSelection, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return getSelectedParagraphs(ouroNodeStorage, ouroSelection, z, z2);
    }

    public static final List<OuroParagraph> getSelectedParagraphs(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection, boolean ignoreBefore, boolean ignoreAfter) {
        Iterable $this$mapNotNull$iv;
        OuroNodeStorage<?> ouroNodeStorage2;
        OuroNode.Parent<?> parent;
        OuroParagraph ouroParagraph;
        OuroNode ouroNode;
        OuroParagraph beforeParagraph;
        OuroNode ouroNode2;
        OuroParagraph ouroParagraph2;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!selection.isCollapsed()) {
            Iterable $this$mapNotNull$iv2 = OuroNodeStorageUtilsKt.getSelectables(ouroNodeStorage, selection);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
                OuroNode it = (OuroNode.Selectable) element$iv$iv$iv;
                OuroNode node$iv = it;
                if (node$iv != null) {
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    ouroNodeStorage2 = ouroNodeStorage;
                    parent = ouroNodeStorage2.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$getSelectedParagraphs$lambda$2$$inlined$findFirstAncestorOrNull$1
                        public final Boolean invoke(OuroNode.Parent<?> parent2) {
                            Intrinsics.checkNotNullParameter(parent2, "it");
                            return Boolean.valueOf(parent2 instanceof OuroParagraph);
                        }
                    });
                } else {
                    $this$mapNotNull$iv = $this$mapNotNull$iv2;
                    ouroNodeStorage2 = ouroNodeStorage;
                    parent = null;
                }
                if (!(parent instanceof OuroParagraph)) {
                    parent = null;
                }
                OuroParagraph ouroParagraph3 = (OuroParagraph) parent;
                if (ouroParagraph3 != null) {
                    destination$iv$iv.add(ouroParagraph3);
                }
                $this$mapNotNull$iv2 = $this$mapNotNull$iv;
            }
            return CollectionsKt.toList(CollectionsKt.toSet((List) destination$iv$iv));
        }
        OuroNode selectableOrNull = OuroNodeStorageUtilsKt.getSelectableOrNull(ouroNodeStorage, selection.getAnchor());
        if (selectableOrNull != null) {
            OuroNode p0 = selectableOrNull;
            OuroNode.Parent<?> firstAncestorOrNull = ouroNodeStorage.firstAncestorOrNull(p0, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$getSelectedParagraphs$stub_for_inlining$$inlined$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent2) {
                    Intrinsics.checkNotNullParameter(parent2, "it");
                    return Boolean.valueOf(parent2 instanceof OuroParagraph);
                }
            });
            if (!(firstAncestorOrNull instanceof OuroParagraph)) {
                firstAncestorOrNull = null;
            }
            ouroParagraph = (OuroParagraph) firstAncestorOrNull;
        } else {
            ouroParagraph = null;
        }
        OuroParagraph selectedParagraph = ouroParagraph;
        if (selectedParagraph != null) {
            return CollectionsKt.listOf(selectedParagraph);
        }
        if (!ignoreAfter) {
            OuroPoint point$iv = selection.getAnchor();
            int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
            if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
                Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
                if (!(orNull instanceof OuroNode.Selectable)) {
                    orNull = null;
                }
                ouroNode2 = (OuroNode.Selectable) orNull;
            } else {
                ouroNode2 = null;
            }
            if (ouroNode2 != null) {
                OuroNode p02 = ouroNode2;
                OuroNode.Parent<?> firstAncestorOrNull2 = ouroNodeStorage.firstAncestorOrNull(p02, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$getSelectedParagraphs$stub_for_inlining$0$$inlined$findFirstAncestorOrNull$1
                    public final Boolean invoke(OuroNode.Parent<?> parent2) {
                        Intrinsics.checkNotNullParameter(parent2, "it");
                        return Boolean.valueOf(parent2 instanceof OuroParagraph);
                    }
                });
                if (!(firstAncestorOrNull2 instanceof OuroParagraph)) {
                    firstAncestorOrNull2 = null;
                }
                ouroParagraph2 = (OuroParagraph) firstAncestorOrNull2;
            } else {
                ouroParagraph2 = null;
            }
            OuroParagraph afterParagraph = ouroParagraph2;
            if (afterParagraph != null) {
                return CollectionsKt.listOf(afterParagraph);
            }
        }
        if (!ignoreBefore) {
            int prevIndex$iv = selection.getAnchor().getIndex() - 1;
            if (prevIndex$iv >= 0) {
                Object orNull2 = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), prevIndex$iv);
                if (!(orNull2 instanceof OuroNode.Selectable)) {
                    orNull2 = null;
                }
                ouroNode = (OuroNode.Selectable) orNull2;
            } else {
                ouroNode = null;
            }
            if (ouroNode != null) {
                OuroNode p03 = ouroNode;
                OuroNode.Parent<?> firstAncestorOrNull3 = ouroNodeStorage.firstAncestorOrNull(p03, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$getSelectedParagraphs$stub_for_inlining$1$$inlined$findFirstAncestorOrNull$1
                    public final Boolean invoke(OuroNode.Parent<?> parent2) {
                        Intrinsics.checkNotNullParameter(parent2, "it");
                        return Boolean.valueOf(parent2 instanceof OuroParagraph);
                    }
                });
                beforeParagraph = (OuroParagraph) (!(firstAncestorOrNull3 instanceof OuroParagraph) ? null : firstAncestorOrNull3);
            } else {
                beforeParagraph = null;
            }
            if (beforeParagraph != null) {
                return CollectionsKt.listOf(beforeParagraph);
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final List<OuroBoxContainer> getSelectedContainer(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection) {
        OuroNode.Selectable selectable;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        if (!selection.isCollapsed()) {
            Iterable $this$mapNotNull$iv = OuroNodeStorageUtilsKt.getSelectables(ouroNodeStorage, selection);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
                OuroNode.Selectable it = (OuroNode.Selectable) element$iv$iv$iv;
                OuroBoxContainer ouroBoxContainer = it instanceof OuroBoxContainer ? (OuroBoxContainer) it : null;
                if (ouroBoxContainer != null) {
                    destination$iv$iv.add(ouroBoxContainer);
                }
            }
            return (List) destination$iv$iv;
        }
        OuroNode.Selectable selectableOrNull = OuroNodeStorageUtilsKt.getSelectableOrNull(ouroNodeStorage, selection.getAnchor());
        OuroBoxContainer selectedContainer = selectableOrNull instanceof OuroBoxContainer ? (OuroBoxContainer) selectableOrNull : null;
        if (selectedContainer != null) {
            return CollectionsKt.listOf(selectedContainer);
        }
        OuroPoint point$iv = selection.getAnchor();
        int nextIndex$iv = point$iv.isInside() ? point$iv.getIndex() + 1 : point$iv.getIndex();
        if (nextIndex$iv < ouroNodeStorage.getAllSelectables().size()) {
            Object orNull = CollectionsKt.getOrNull(ouroNodeStorage.getAllSelectables(), nextIndex$iv);
            if (!(orNull instanceof OuroNode.Selectable)) {
                orNull = null;
            }
            selectable = (OuroNode.Selectable) orNull;
        } else {
            selectable = null;
        }
        OuroBoxContainer afterContainer = selectable instanceof OuroBoxContainer ? (OuroBoxContainer) selectable : null;
        return afterContainer != null ? CollectionsKt.listOf(afterContainer) : CollectionsKt.emptyList();
    }

    public static /* synthetic */ void printTree$default(OuroNodeStorage ouroNodeStorage, OuroNode ouroNode, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            ouroNode = ouroNodeStorage.getRoot();
        }
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        printTree(ouroNodeStorage, ouroNode, str, z);
    }

    public static final void printTree(OuroNodeStorage<?> ouroNodeStorage, OuroNode node, String indent, boolean isLast) {
        List children;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(indent, "indent");
        System.out.println((Object) ("OuroTree " + indent + (isLast ? "└─" : "├─") + " [" + CollectionsKt.indexOf(ouroNodeStorage.getAllSelectables(), node) + "] " + node));
        if (node instanceof OuroNode.Parent) {
            children = ouroNodeStorage.getChildren((OuroNode.Parent) node);
            if (children == null) {
                children = CollectionsKt.emptyList();
            }
        } else {
            children = CollectionsKt.emptyList();
        }
        String nextIndent = indent + (isLast ? "   " : "│  ");
        Iterable $this$forEachIndexed$iv = children;
        int idx = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = idx + 1;
            if (idx < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            OuroNode child = (OuroNode) item$iv;
            printTree(ouroNodeStorage, child, nextIndent, idx == CollectionsKt.getLastIndex(children));
            idx = index$iv;
        }
    }

    public static final /* synthetic */ <P extends OuroNode.Parent<?>> P findFirstAncestorOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroNode node) {
        P p;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        if (node != null) {
            Intrinsics.needClassReification();
            p = (P) ouroNodeStorage.firstAncestorOrNull(node, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$findFirstAncestorOrNull$1
                public final Boolean invoke(OuroNode.Parent<?> parent) {
                    Intrinsics.checkNotNullParameter(parent, "it");
                    Intrinsics.reifiedOperationMarker(3, "P");
                    return Boolean.valueOf(parent instanceof OuroNode.Parent);
                }
            });
        } else {
            p = null;
        }
        Intrinsics.reifiedOperationMarker(2, "P");
        P p2 = p;
        return p;
    }

    public static final /* synthetic */ <P extends OuroNode.Parent<?>> P findLastAncestorOrNull(OuroNodeStorage<?> ouroNodeStorage, OuroNode node) {
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(node, "node");
        OuroNode.Parent current = ouroNodeStorage.getParent(node);
        OuroNode.Parent ancestor = (P) null;
        while (current != null) {
            Intrinsics.reifiedOperationMarker(3, "P");
            if (current instanceof OuroNode.Parent) {
                OuroNode.Parent ancestor2 = current;
                ancestor = (P) ancestor2;
            }
            current = ouroNodeStorage.getParent(current);
        }
        return (P) ancestor;
    }

    public static final <C extends OuroNode> void addChild(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, C c) {
        ArrayList arrayList;
        List<OuroNode> list = map.get(parent);
        if (list == null) {
            arrayList = new ArrayList();
            map.put(parent, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.add(c);
    }

    public static final <C extends OuroNode> void addChild(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, C c, int index) {
        ArrayList arrayList;
        List<OuroNode> list = map.get(parent);
        if (list == null) {
            arrayList = new ArrayList();
            map.put(parent, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.add(index, c);
    }

    public static final <C extends OuroNode> void addChildren(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, Collection<? extends C> collection) {
        ArrayList arrayList;
        List<OuroNode> list = map.get(parent);
        if (list == null) {
            arrayList = new ArrayList();
            map.put(parent, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.addAll(collection);
    }

    public static final <C extends OuroNode> void addChildren(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, Collection<? extends C> collection, int index) {
        ArrayList arrayList;
        List<OuroNode> list = map.get(parent);
        if (list == null) {
            arrayList = new ArrayList();
            map.put(parent, arrayList);
        } else {
            arrayList = list;
        }
        arrayList.addAll(index, collection);
    }

    public static final <C extends OuroNode> boolean removeChild(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, final C c) {
        List<OuroNode> list = map.get(parent);
        if (list != null) {
            return CollectionsKt.removeAll(list, new Function1() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    boolean removeChild$lambda$0;
                    removeChild$lambda$0 = OuroNodeStorageKt.removeChild$lambda$0(OuroNode.this, (OuroNode) obj);
                    return Boolean.valueOf(removeChild$lambda$0);
                }
            });
        }
        return false;
    }

    public static final boolean removeChild$lambda$0(OuroNode $child, OuroNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, $child);
    }

    private static final <C extends OuroNode> C removeChildAt(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, int index) {
        OuroNode it;
        List it2 = map.get(parent);
        if (it2 != null) {
            if (!(index >= 0 && it2.size() > index)) {
                it2 = null;
            }
            if (it2 == null || (it = it2.remove(index)) == null) {
                return null;
            }
            return parent.castChild(it);
        }
        return null;
    }

    public static final <C extends OuroNode> boolean removeChildren(Map<OuroNode, List<OuroNode>> map, OuroNode.Parent<C> parent, Collection<? extends C> collection) {
        final Set set = CollectionsKt.toSet(collection);
        List<OuroNode> list = map.get(parent);
        if (list != null) {
            return CollectionsKt.removeAll(list, new Function1() { // from class: kntr.common.ouro.core.model.OuroNodeStorageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    boolean removeChildren$lambda$0;
                    removeChildren$lambda$0 = OuroNodeStorageKt.removeChildren$lambda$0(set, (OuroNode) obj);
                    return Boolean.valueOf(removeChildren$lambda$0);
                }
            });
        }
        return false;
    }

    public static final boolean removeChildren$lambda$0(Set $set, OuroNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return CollectionsKt.contains($set, it);
    }
}