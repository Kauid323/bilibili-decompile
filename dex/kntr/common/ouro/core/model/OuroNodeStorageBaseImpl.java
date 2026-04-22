package kntr.common.ouro.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeUtilsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u00013B\u0011\b\u0004\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u001fH\u0004J\b\u0010&\u001a\u00020\u001fH\u0004J\b\u0010'\u001a\u00020(H\u0004J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\rH\u0002J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\r0,H\u0096\u0002J4\u0010-\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\r2\u001a\u0010.\u001a\u0016\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020(0/H\u0016J\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00122\u0006\u0010*\u001a\u00020\rJ\u0010\u00102\u001a\u00020(2\u0006\u0010*\u001a\u00020\rH\u0004R\u0016\u0010\u0005\u001a\u00028\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR*\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\fj\u0002`\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00120\fj\u0002`\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R$\u0010\u0015\u001a\u000e\u0012\u0002\b\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003*\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0012*\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0001\u000245¨\u00066"}, d2 = {"Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl;", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "root", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)V", "getRoot", "()Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "parentMap", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/OuroParentMap;", "getParentMap", "()Ljava/util/Map;", "childrenMap", "", "Lkntr/common/ouro/core/model/OuroChildrenMap;", "getChildrenMap", "parent", "getParent", "(Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "children", "getChildren", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)Ljava/util/List;", "siblings", "getSiblings", "(Lkntr/common/ouro/core/model/node/OuroNode;)Ljava/util/List;", "indexInSiblings", "", "getIndexInSiblings", "(Lkntr/common/ouro/core/model/node/OuroNode;)Ljava/lang/Integer;", "unuploadedPictureCount", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "calcTextCount", "calcPictureCount", "calcHasContent", "", "textCount", "node", "iterator", "", "firstAncestorOrNull", "predicate", "Lkotlin/Function1;", "calcAllSelectables", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "contains", "OuroNodeIterator", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class OuroNodeStorageBaseImpl<T extends OuroNode.Parent<?>> implements OuroNodeStorage<T> {
    private final T root;

    public /* synthetic */ OuroNodeStorageBaseImpl(OuroNode.Parent parent, DefaultConstructorMarker defaultConstructorMarker) {
        this(parent);
    }

    public abstract Map<OuroNode, List<OuroNode>> getChildrenMap();

    public abstract Map<OuroNode, OuroNode.Parent<?>> getParentMap();

    private OuroNodeStorageBaseImpl(T t) {
        this.root = t;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ <C extends OuroNode> List<C> getChildrenOrNull(OuroNode.Parent<C> parent) {
        return OuroNodeStorage.CC.$default$getChildrenOrNull(this, parent);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ OuroNode getSiblingNext(OuroNode $this$siblingNext) {
        return OuroNodeStorage.CC.$default$getSiblingNext(this, $this$siblingNext);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ OuroNode getSiblingPrev(OuroNode $this$siblingPrev) {
        return OuroNodeStorage.CC.$default$getSiblingPrev(this, $this$siblingPrev);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ boolean isSiblingFirst(OuroNode $this$isSiblingFirst) {
        return OuroNodeStorage.CC.$default$isSiblingFirst(this, $this$isSiblingFirst);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ boolean isSiblingLast(OuroNode $this$isSiblingLast) {
        return OuroNodeStorage.CC.$default$isSiblingLast(this, $this$isSiblingLast);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ boolean isSiblingOf(OuroNode $this$isSiblingOf, OuroNode other) {
        return OuroNodeStorage.CC.$default$isSiblingOf(this, $this$isSiblingOf, other);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public T getRoot() {
        return this.root;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public OuroNode.Parent<?> getParent(OuroNode $this$parent) {
        Intrinsics.checkNotNullParameter($this$parent, "<this>");
        return getParentMap().get($this$parent);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public List<OuroNode> getChildren(OuroNode.Parent<?> parent) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        return getChildrenMap().get(parent);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public List<OuroNode> getSiblings(OuroNode $this$siblings) {
        Intrinsics.checkNotNullParameter($this$siblings, "<this>");
        OuroNode.Parent it = getParentMap().get($this$siblings);
        if (it != null) {
            return getChildrenMap().get(it);
        }
        return null;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public Integer getIndexInSiblings(OuroNode $this$indexInSiblings) {
        Intrinsics.checkNotNullParameter($this$indexInSiblings, "<this>");
        List<OuroNode> siblings = getSiblings($this$indexInSiblings);
        if (siblings != null) {
            Integer valueOf = Integer.valueOf(siblings.indexOf($this$indexInSiblings));
            int it = valueOf.intValue();
            if (it >= 0) {
                return valueOf;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
        if (r0.isSuccess() == true) goto L39;
     */
    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int unuploadedPictureCount(OuroLocalImageState localImageState) {
        int i;
        Intrinsics.checkNotNullParameter(localImageState, "localImageState");
        Iterable $this$filterIsInstance$iv = getAllSelectables();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof OuroBoxContainer) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$fold$iv = (List) destination$iv$iv;
        Object element$iv$iv2 = null;
        int accumulator$iv = 0;
        for (Object element$iv : $this$fold$iv) {
            OuroBoxContainer node = (OuroBoxContainer) element$iv;
            int acc = accumulator$iv;
            Iterable $this$filterIsInstance$iv2 = OuroNodeStorageUtilsKt.getLeavesOfNode(this, node);
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv3 : $this$filterIsInstance$iv2) {
                Object initial$iv = element$iv$iv2;
                if (element$iv$iv3 instanceof OuroLocalImage) {
                    destination$iv$iv2.add(element$iv$iv3);
                }
                element$iv$iv2 = initial$iv;
            }
            Object initial$iv2 = element$iv$iv2;
            Iterable $this$count$iv = (List) destination$iv$iv2;
            if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
                i = 0;
            } else {
                int count$iv = 0;
                for (Object element$iv2 : $this$count$iv) {
                    OuroLocalImage it = (OuroLocalImage) element$iv2;
                    Iterable $this$count$iv2 = $this$count$iv;
                    UploadTaskState uploadTaskState = localImageState.getTaskState().get(it.getAsset().getIdentifier());
                    boolean z = uploadTaskState != null;
                    if (z) {
                        $this$count$iv = $this$count$iv2;
                    } else {
                        count$iv++;
                        if (count$iv < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                        $this$count$iv = $this$count$iv2;
                    }
                }
                i = count$iv;
            }
            accumulator$iv = i + acc;
            element$iv$iv2 = initial$iv2;
        }
        return accumulator$iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcTextCount() {
        OuroNodeStorageBaseImpl<T> ouroNodeStorageBaseImpl;
        List it = getAllSelectables();
        if (CollectionsKt.lastOrNull(this) instanceof OuroTextElement.HardBreak) {
            ouroNodeStorageBaseImpl = CollectionsKt.dropLast(it, 1);
        } else {
            ouroNodeStorageBaseImpl = this;
        }
        Iterable $this$fold$iv = ouroNodeStorageBaseImpl;
        int accumulator$iv = 0;
        for (Object element$iv : $this$fold$iv) {
            OuroNode node = (OuroNode) element$iv;
            int acc = accumulator$iv;
            accumulator$iv = acc + textCount(node);
        }
        return accumulator$iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcPictureCount() {
        Iterable $this$fold$iv;
        int initial$iv;
        int i;
        Iterable $this$fold$iv2 = getAllSelectables();
        int initial$iv2 = 0;
        int accumulator$iv = 0;
        for (Object element$iv : $this$fold$iv2) {
            OuroNode.Selectable node = (OuroNode.Selectable) element$iv;
            int acc = accumulator$iv;
            if (!(node instanceof OuroBoxContainer)) {
                $this$fold$iv = $this$fold$iv2;
                initial$iv = initial$iv2;
                i = 0;
            } else {
                Iterable $this$filter$iv = OuroNodeStorageUtilsKt.getLeavesOfNode(this, node);
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Iterable $this$fold$iv3 = $this$fold$iv2;
                    OuroNode it = (OuroNode) element$iv$iv;
                    int initial$iv3 = initial$iv2;
                    if ((it instanceof OuroLocalImage) || (it instanceof OuroRemoteImage)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    $this$fold$iv2 = $this$fold$iv3;
                    initial$iv2 = initial$iv3;
                }
                $this$fold$iv = $this$fold$iv2;
                initial$iv = initial$iv2;
                i = ((List) destination$iv$iv).size();
            }
            accumulator$iv = i + acc;
            $this$fold$iv2 = $this$fold$iv;
            initial$iv2 = initial$iv;
        }
        return accumulator$iv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean calcHasContent() {
        boolean inList;
        boolean inQuote;
        OuroNode single = (OuroNode.Selectable) CollectionsKt.singleOrNull(getAllSelectables());
        if (single == null) {
            return true;
        }
        OuroNodeStorageBaseImpl<T> $this$findFirstAncestorOrNull$iv = this;
        OuroNode node$iv = single;
        OuroNode.Parent<?> firstAncestorOrNull = $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageBaseImpl$calcHasContent$$inlined$findFirstAncestorOrNull$1
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroList);
            }
        });
        if (!(firstAncestorOrNull instanceof OuroList)) {
            firstAncestorOrNull = null;
        }
        if (((OuroList) firstAncestorOrNull) != null) {
            inList = true;
        } else {
            inList = false;
        }
        OuroNodeStorageBaseImpl<T> $this$findFirstAncestorOrNull$iv2 = this;
        OuroNode node$iv2 = single;
        OuroNode.Parent<?> firstAncestorOrNull2 = $this$findFirstAncestorOrNull$iv2.firstAncestorOrNull(node$iv2, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.OuroNodeStorageBaseImpl$calcHasContent$$inlined$findFirstAncestorOrNull$2
            public final Boolean invoke(OuroNode.Parent<?> parent) {
                Intrinsics.checkNotNullParameter(parent, "it");
                return Boolean.valueOf(parent instanceof OuroQuoteBlock);
            }
        });
        if ((firstAncestorOrNull2 instanceof OuroQuoteBlock ? firstAncestorOrNull2 : null) != null) {
            inQuote = true;
        } else {
            inQuote = false;
        }
        if (inList || inQuote) {
            return true;
        }
        return false;
    }

    private final int textCount(OuroNode node) {
        Iterable children;
        if (node instanceof OuroTextElement) {
            return ((OuroTextElement) node).getMeta().length();
        }
        if (node instanceof OuroInlineContent) {
            return 1;
        }
        if (!(node instanceof OuroBoxContainer) && (node instanceof OuroLink) && (children = getChildren((OuroNode.Parent) node)) != null) {
            Iterable $this$fold$iv = children;
            int accumulator$iv = 0;
            for (Object element$iv : $this$fold$iv) {
                OuroNode child = (OuroNode) element$iv;
                int acc = accumulator$iv;
                accumulator$iv = acc + textCount(child);
            }
            return accumulator$iv;
        }
        return 0;
    }

    @Override // java.lang.Iterable
    public Iterator<OuroNode> iterator() {
        return new OuroNodeIterator();
    }

    /* compiled from: OuroNodeStorage.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl$OuroNodeIterator;", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl;)V", "nodeStack", "", "hasNext", "", "next", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    private final class OuroNodeIterator implements Iterator<OuroNode>, KMappedMarker {
        private final List<OuroNode> nodeStack = new ArrayList();

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public OuroNodeIterator() {
            this.nodeStack.add(OuroNodeStorageBaseImpl.this.getRoot());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.nodeStack.isEmpty();
        }

        @Override // java.util.Iterator
        public OuroNode next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree");
            }
            OuroNode currentNode = this.nodeStack.remove(this.nodeStack.size() - 1);
            List children = OuroNodeStorageBaseImpl.this.getChildrenMap().get(currentNode);
            if (children == null) {
                children = CollectionsKt.emptyList();
            }
            int i = children.size();
            while (true) {
                i--;
                if (-1 < i) {
                    this.nodeStack.add(children.get(i));
                } else {
                    return currentNode;
                }
            }
        }
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public OuroNode.Parent<?> firstAncestorOrNull(OuroNode $this$firstAncestorOrNull, Function1<? super OuroNode.Parent<?>, Boolean> function1) {
        Intrinsics.checkNotNullParameter($this$firstAncestorOrNull, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        OuroNode.Parent current = getParent($this$firstAncestorOrNull);
        while (current != null) {
            if (((Boolean) function1.invoke(current)).booleanValue()) {
                return current;
            }
            current = getParent(current);
        }
        return null;
    }

    public final List<OuroNode.Selectable> calcAllSelectables(OuroNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        if (OuroNodeUtilsKt.isSelectable(node)) {
            return CollectionsKt.listOf(node);
        }
        if (!(node instanceof OuroNode.Parent)) {
            return CollectionsKt.emptyList();
        }
        Iterable iterable = (List) getChildrenMap().get(node);
        if (iterable != null) {
            Iterable $this$flatMap$iv = iterable;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                OuroNode p0 = (OuroNode) element$iv$iv;
                Iterable list$iv$iv = calcAllSelectables(p0);
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            return (List) destination$iv$iv;
        }
        return CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean contains(OuroNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        OuroNode current = node;
        while (current != null) {
            if (Intrinsics.areEqual(current, getRoot())) {
                return true;
            }
            current = getParent(current);
        }
        return false;
    }
}