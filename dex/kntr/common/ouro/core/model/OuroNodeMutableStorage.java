package kntr.common.ouro.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004J)\u0010\u0005\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\t\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J1\u0010\u0005\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u000eJ,\u0010\u000b\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016J%\u0010\u000f\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0096\u0002J*\u0010\u0011\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013H&J*\u0010\u000b\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J2\u0010\u0011\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013H&J2\u0010\u000b\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J+\u0010\u000f\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096\u0002J2\u0010\u0005\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00150\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H&J:\u0010\u0005\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00150\u00022\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H&J/\u0010\u000b\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00152\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0002\u0010\u0016J7\u0010\u000b\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00152\u0006\u0010\f\u001a\u00020\r2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0002\u0010\u0017J1\u0010\u000f\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00150\u00022\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0096\u0002J8\u0010\u0018\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00150\u00022\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00040\u0013H&J@\u0010\u0018\u001a\u00020\u0006\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00150\u00022\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00150\u00040\u0013H&J)\u0010\u0019\u001a\u00020\u001a\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\t\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\u00020\u001a\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016J%\u0010\u001d\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0096\u0002J*\u0010\u001e\u001a\u00020\u001a\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013H&J*\u0010\u001f\u001a\u00020\u001a\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016J+\u0010\u001d\u001a\u00020\u0006\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0096\u0002J$\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010!\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u0002H&J+\u0010\"\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0001\u0010\u0007*\u00020\b*\b\u0012\u0004\u0012\u0002H\u00070\u00022\u0006\u0010\f\u001a\u00020\rH&¢\u0006\u0002\u0010#J\f\u0010$\u001a\u00020\u001a*\u00020\bH&J\u0011\u0010\u001d\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\bH\u0096\u0002J#\u0010&\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\u0006\u0010\u0010\u001a\u0002H\u0015H&¢\u0006\u0002\u0010'J)\u0010&\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0013H&¢\u0006\u0002\u0010(J1\u0010&\u001a\u00020\u001a\"\u0010\b\u0001\u0010\u0015*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00152\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00150\u0004H&¢\u0006\u0002\u0010)J#\u0010*\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\u0006\u0010+\u001a\u00020\bH\u0016¢\u0006\u0002\u0010'J'\u0010*\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\n\u0010,\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016¢\u0006\u0002\u0010-J)\u0010*\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016¢\u0006\u0002\u0010(J#\u0010/\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\u0006\u0010+\u001a\u00020\bH\u0016¢\u0006\u0002\u0010'J)\u0010/\u001a\u00020\u001a\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u00152\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0013H\u0016¢\u0006\u0002\u0010(J\u001d\u00100\u001a\u0004\u0018\u00010\b\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u0015H\u0016¢\u0006\u0002\u00101J\u001d\u00102\u001a\u0004\u0018\u00010\b\"\b\b\u0001\u0010\u0015*\u00020\b*\u0002H\u0015H\u0016¢\u0006\u0002\u00101J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00028\u0000042\b\b\u0002\u00105\u001a\u00020\u001aH&\u0082\u0001\u00016¨\u00067À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "R", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "addChild", "", "C", "Lkntr/common/ouro/core/model/node/OuroNode;", "child", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)V", "add", "index", "", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;ILkntr/common/ouro/core/model/node/OuroNode;)V", "plusAssign", "other", "addChildren", "children", "", "others", "T", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/OuroNodeStorage;)V", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;ILkntr/common/ouro/core/model/OuroNodeStorage;)V", "addAll", "removeChild", "", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)Z", "remove", "minusAssign", "removeChildren", "removeAll", "removeAllChildren", "", "removeChildAt", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;I)Lkntr/common/ouro/core/model/node/OuroNode;", "removeFromParent", "node", "replace", "(Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/node/OuroNode;)Z", "(Lkntr/common/ouro/core/model/node/OuroNode;Ljava/util/Collection;)Z", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/OuroNodeStorage;)Z", "addSiblingNext", "sibling", "storage", "(Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/OuroNodeStorage;)Z", "siblings", "addSiblingPrev", "removeSiblingNext", "(Lkntr/common/ouro/core/model/node/OuroNode;)Lkntr/common/ouro/core/model/node/OuroNode;", "removeSiblingPrev", "build", "Lkntr/common/ouro/core/model/NodeStorage;", "validate", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroNodeMutableStorage<R extends OuroNode.Parent<?>> extends OuroNodeStorage<R> {
    <C extends OuroNode> void add(OuroNode.Parent<C> parent, int i, Collection<? extends OuroNode> collection);

    <T extends OuroNode.Parent<?>> void add(T t, int i, OuroNodeStorage<?> ouroNodeStorage);

    <C extends OuroNode> void add(OuroNode.Parent<C> parent, int i, OuroNode ouroNode);

    <C extends OuroNode> void add(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection);

    <T extends OuroNode.Parent<?>> void add(T t, OuroNodeStorage<?> ouroNodeStorage);

    <C extends OuroNode> void add(OuroNode.Parent<C> parent, OuroNode ouroNode);

    <T extends OuroNode.Parent<?>> void addAll(OuroNode.Parent<T> parent, int i, Collection<? extends OuroNodeStorage<T>> collection);

    <T extends OuroNode.Parent<?>> void addAll(OuroNode.Parent<T> parent, Collection<? extends OuroNodeStorage<T>> collection);

    <T extends OuroNode.Parent<?>> void addChild(OuroNode.Parent<T> parent, int i, OuroNodeStorage<T> ouroNodeStorage);

    <C extends OuroNode> void addChild(OuroNode.Parent<C> parent, int i, C c);

    <T extends OuroNode.Parent<?>> void addChild(OuroNode.Parent<T> parent, OuroNodeStorage<T> ouroNodeStorage);

    <C extends OuroNode> void addChild(OuroNode.Parent<C> parent, C c);

    <C extends OuroNode> void addChildren(OuroNode.Parent<C> parent, int i, Collection<? extends C> collection);

    <C extends OuroNode> void addChildren(OuroNode.Parent<C> parent, Collection<? extends C> collection);

    <T extends OuroNode> boolean addSiblingNext(T t, Collection<? extends OuroNode> collection);

    <T extends OuroNode> boolean addSiblingNext(T t, OuroNodeStorage<?> ouroNodeStorage);

    <T extends OuroNode> boolean addSiblingNext(T t, OuroNode ouroNode);

    <T extends OuroNode> boolean addSiblingPrev(T t, Collection<? extends OuroNode> collection);

    <T extends OuroNode> boolean addSiblingPrev(T t, OuroNode ouroNode);

    NodeStorage<R> build(boolean z);

    <C extends OuroNode> void minusAssign(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection);

    <C extends OuroNode> void minusAssign(OuroNode.Parent<C> parent, OuroNode ouroNode);

    void minusAssign(OuroNode ouroNode);

    <C extends OuroNode> void plusAssign(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection);

    <T extends OuroNode.Parent<?>> void plusAssign(OuroNode.Parent<T> parent, OuroNodeStorage<?> ouroNodeStorage);

    <C extends OuroNode> void plusAssign(OuroNode.Parent<C> parent, OuroNode ouroNode);

    <C extends OuroNode> boolean remove(OuroNode.Parent<C> parent, OuroNode ouroNode);

    <C extends OuroNode> boolean removeAll(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection);

    <C extends OuroNode> List<C> removeAllChildren(OuroNode.Parent<C> parent);

    <C extends OuroNode> boolean removeChild(OuroNode.Parent<C> parent, C c);

    <C extends OuroNode> C removeChildAt(OuroNode.Parent<C> parent, int i);

    <C extends OuroNode> boolean removeChildren(OuroNode.Parent<C> parent, Collection<? extends C> collection);

    boolean removeFromParent(OuroNode ouroNode);

    <T extends OuroNode> OuroNode removeSiblingNext(T t);

    <T extends OuroNode> OuroNode removeSiblingPrev(T t);

    <T extends OuroNode.Parent<?>> boolean replace(T t, OuroNodeStorage<T> ouroNodeStorage);

    <T extends OuroNode> boolean replace(T t, Collection<? extends T> collection);

    <T extends OuroNode> boolean replace(T t, T t2);

    /* compiled from: OuroNodeStorage.kt */
    /* renamed from: kntr.common.ouro.core.model.OuroNodeMutableStorage$-CC */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static void $default$add(OuroNodeMutableStorage _this, OuroNode.Parent $this$add, OuroNode child) {
            Intrinsics.checkNotNullParameter($this$add, "<this>");
            Intrinsics.checkNotNullParameter(child, "child");
            _this.addChild((OuroNode.Parent<OuroNode.Parent>) $this$add, (OuroNode.Parent) $this$add.castChild(child));
        }

        public static void $default$add(OuroNodeMutableStorage _this, OuroNode.Parent $this$add, int index, OuroNode child) {
            Intrinsics.checkNotNullParameter($this$add, "<this>");
            Intrinsics.checkNotNullParameter(child, "child");
            _this.addChild((OuroNode.Parent<int>) $this$add, index, (int) $this$add.castChild(child));
        }

        public static void $default$plusAssign(OuroNodeMutableStorage _this, OuroNode.Parent $this$plusAssign, OuroNode other) {
            Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            _this.add($this$plusAssign, other);
        }

        public static void $default$add(OuroNodeMutableStorage _this, OuroNode.Parent $this$add, Collection other) {
            Intrinsics.checkNotNullParameter($this$add, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            Collection $this$map$iv = other;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv.add($this$add.castChild(it));
            }
            _this.addChildren($this$add, (List) destination$iv$iv);
        }

        public static void $default$add(OuroNodeMutableStorage _this, OuroNode.Parent $this$add, int index, Collection others) {
            Intrinsics.checkNotNullParameter($this$add, "<this>");
            Intrinsics.checkNotNullParameter(others, "others");
            Collection $this$map$iv = others;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv.add($this$add.castChild(it));
            }
            _this.addChildren($this$add, index, (List) destination$iv$iv);
        }

        public static void $default$plusAssign(OuroNodeMutableStorage _this, OuroNode.Parent $this$plusAssign, Collection others) {
            Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
            Intrinsics.checkNotNullParameter(others, "others");
            _this.add($this$plusAssign, others);
        }

        public static void $default$plusAssign(OuroNodeMutableStorage _this, OuroNode.Parent $this$plusAssign, OuroNodeStorage other) {
            Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            _this.add((OuroNodeMutableStorage) $this$plusAssign, (OuroNodeStorage<?>) other);
        }

        public static boolean $default$remove(OuroNodeMutableStorage _this, OuroNode.Parent $this$remove, OuroNode other) {
            Intrinsics.checkNotNullParameter($this$remove, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            return _this.removeChild($this$remove, $this$remove.castChild(other));
        }

        public static void $default$minusAssign(OuroNodeMutableStorage _this, OuroNode.Parent $this$minusAssign, OuroNode other) {
            Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
            Intrinsics.checkNotNullParameter(other, "other");
            _this.remove($this$minusAssign, other);
        }

        public static boolean $default$removeAll(OuroNodeMutableStorage _this, OuroNode.Parent $this$removeAll, Collection others) {
            Intrinsics.checkNotNullParameter($this$removeAll, "<this>");
            Intrinsics.checkNotNullParameter(others, "others");
            Collection $this$map$iv = others;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv.add($this$removeAll.castChild(it));
            }
            return _this.removeChildren($this$removeAll, (List) destination$iv$iv);
        }

        public static void $default$minusAssign(OuroNodeMutableStorage _this, OuroNode.Parent $this$minusAssign, Collection others) {
            Intrinsics.checkNotNullParameter($this$minusAssign, "<this>");
            Intrinsics.checkNotNullParameter(others, "others");
            _this.removeAll($this$minusAssign, others);
        }

        public static void $default$minusAssign(OuroNodeMutableStorage _this, OuroNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            _this.removeFromParent(node);
        }

        public static boolean $default$addSiblingNext(OuroNodeMutableStorage _this, OuroNode $this$addSiblingNext, OuroNode sibling) {
            Integer indexInSiblings;
            Intrinsics.checkNotNullParameter($this$addSiblingNext, "<this>");
            Intrinsics.checkNotNullParameter(sibling, "sibling");
            OuroNode.Parent parent = _this.getParent($this$addSiblingNext);
            if (parent == null || (indexInSiblings = _this.getIndexInSiblings($this$addSiblingNext)) == null) {
                return false;
            }
            int indexInSiblings2 = indexInSiblings.intValue();
            _this.add(parent, indexInSiblings2 + 1, sibling);
            return true;
        }

        public static boolean $default$addSiblingNext(OuroNodeMutableStorage _this, OuroNode $this$addSiblingNext, OuroNodeStorage storage) {
            Integer indexInSiblings;
            Intrinsics.checkNotNullParameter($this$addSiblingNext, "<this>");
            Intrinsics.checkNotNullParameter(storage, "storage");
            OuroNode.Parent parent = _this.getParent($this$addSiblingNext);
            if (parent == null || (indexInSiblings = _this.getIndexInSiblings($this$addSiblingNext)) == null) {
                return false;
            }
            int indexInSiblings2 = indexInSiblings.intValue();
            _this.add((OuroNodeMutableStorage) parent, indexInSiblings2 + 1, (OuroNodeStorage<?>) storage);
            return true;
        }

        public static boolean $default$addSiblingNext(OuroNodeMutableStorage _this, OuroNode $this$addSiblingNext, Collection siblings) {
            Integer indexInSiblings;
            Intrinsics.checkNotNullParameter($this$addSiblingNext, "<this>");
            Intrinsics.checkNotNullParameter(siblings, "siblings");
            OuroNode.Parent parent = _this.getParent($this$addSiblingNext);
            if (parent == null || (indexInSiblings = _this.getIndexInSiblings($this$addSiblingNext)) == null) {
                return false;
            }
            int indexInSiblings2 = indexInSiblings.intValue();
            _this.add(parent, indexInSiblings2 + 1, siblings);
            return true;
        }

        public static boolean $default$addSiblingPrev(OuroNodeMutableStorage _this, OuroNode $this$addSiblingPrev, OuroNode sibling) {
            Integer indexInSiblings;
            Intrinsics.checkNotNullParameter($this$addSiblingPrev, "<this>");
            Intrinsics.checkNotNullParameter(sibling, "sibling");
            OuroNode.Parent parent = _this.getParent($this$addSiblingPrev);
            if (parent == null || (indexInSiblings = _this.getIndexInSiblings($this$addSiblingPrev)) == null) {
                return false;
            }
            int indexInSiblings2 = indexInSiblings.intValue();
            _this.add(parent, indexInSiblings2, sibling);
            return true;
        }

        public static boolean $default$addSiblingPrev(OuroNodeMutableStorage _this, OuroNode $this$addSiblingPrev, Collection siblings) {
            Integer indexInSiblings;
            Intrinsics.checkNotNullParameter($this$addSiblingPrev, "<this>");
            Intrinsics.checkNotNullParameter(siblings, "siblings");
            OuroNode.Parent parent = _this.getParent($this$addSiblingPrev);
            if (parent == null || (indexInSiblings = _this.getIndexInSiblings($this$addSiblingPrev)) == null) {
                return false;
            }
            int indexInSiblings2 = indexInSiblings.intValue();
            _this.add(parent, indexInSiblings2, siblings);
            return true;
        }

        public static OuroNode $default$removeSiblingNext(OuroNodeMutableStorage _this, OuroNode $this$removeSiblingNext) {
            OuroNode siblingNext;
            Intrinsics.checkNotNullParameter($this$removeSiblingNext, "<this>");
            OuroNode.Parent parent = _this.getParent($this$removeSiblingNext);
            if (parent == null || (siblingNext = _this.getSiblingNext($this$removeSiblingNext)) == null || !_this.remove(parent, siblingNext)) {
                return null;
            }
            return siblingNext;
        }

        public static OuroNode $default$removeSiblingPrev(OuroNodeMutableStorage _this, OuroNode $this$removeSiblingPrev) {
            OuroNode siblingNext;
            Intrinsics.checkNotNullParameter($this$removeSiblingPrev, "<this>");
            OuroNode.Parent parent = _this.getParent($this$removeSiblingPrev);
            if (parent == null || (siblingNext = _this.getSiblingPrev($this$removeSiblingPrev)) == null || !_this.remove(parent, siblingNext)) {
                return null;
            }
            return siblingNext;
        }

        public static /* synthetic */ NodeStorage build$default(OuroNodeMutableStorage ouroNodeMutableStorage, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = true;
                }
                return ouroNodeMutableStorage.build(z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: build");
        }
    }

    /* compiled from: OuroNodeStorage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> List<C> getChildrenOrNull(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            return OuroNodeStorage.CC.$default$getChildrenOrNull(ouroNodeMutableStorage, parent);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> OuroNode getSiblingNext(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return OuroNodeStorage.CC.$default$getSiblingNext(ouroNodeMutableStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> OuroNode getSiblingPrev(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return OuroNodeStorage.CC.$default$getSiblingPrev(ouroNodeMutableStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingFirst(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return OuroNodeStorage.CC.$default$isSiblingFirst(ouroNodeMutableStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingLast(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode $receiver) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            return OuroNodeStorage.CC.$default$isSiblingLast(ouroNodeMutableStorage, $receiver);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> boolean isSiblingOf(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode $receiver, OuroNode other) {
            Intrinsics.checkNotNullParameter($receiver, "$receiver");
            Intrinsics.checkNotNullParameter(other, "other");
            return OuroNodeStorage.CC.$default$isSiblingOf(ouroNodeMutableStorage, $receiver, other);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void add(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, OuroNode child) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(child, "child");
            CC.$default$add(ouroNodeMutableStorage, parent, child);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void add(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, int index, OuroNode child) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(child, "child");
            CC.$default$add(ouroNodeMutableStorage, parent, index, child);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void plusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, OuroNode other) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(other, "other");
            CC.$default$plusAssign(ouroNodeMutableStorage, parent, other);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void add(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "other");
            CC.$default$add(ouroNodeMutableStorage, parent, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void add(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, int index, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "others");
            CC.$default$add(ouroNodeMutableStorage, parent, index, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void plusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "others");
            CC.$default$plusAssign(ouroNodeMutableStorage, parent, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode.Parent<?>> void plusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<T> parent, OuroNodeStorage<?> ouroNodeStorage) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
            CC.$default$plusAssign(ouroNodeMutableStorage, parent, ouroNodeStorage);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> boolean remove(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, OuroNode other) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(other, "other");
            return CC.$default$remove(ouroNodeMutableStorage, parent, other);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void minusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, OuroNode other) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(other, "other");
            CC.$default$minusAssign(ouroNodeMutableStorage, parent, other);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> boolean removeAll(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "others");
            return CC.$default$removeAll(ouroNodeMutableStorage, parent, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, C extends OuroNode> void minusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(parent, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "others");
            CC.$default$minusAssign(ouroNodeMutableStorage, parent, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>> void minusAssign(OuroNodeMutableStorage<R> ouroNodeMutableStorage, OuroNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            CC.$default$minusAssign(ouroNodeMutableStorage, node);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> boolean addSiblingNext(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t, OuroNode sibling) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            Intrinsics.checkNotNullParameter(sibling, "sibling");
            return CC.$default$addSiblingNext(ouroNodeMutableStorage, t, sibling);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> boolean addSiblingNext(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t, OuroNodeStorage<?> ouroNodeStorage) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            Intrinsics.checkNotNullParameter(ouroNodeStorage, "storage");
            return CC.$default$addSiblingNext(ouroNodeMutableStorage, t, ouroNodeStorage);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> boolean addSiblingNext(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "siblings");
            return CC.$default$addSiblingNext(ouroNodeMutableStorage, t, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> boolean addSiblingPrev(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t, OuroNode sibling) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            Intrinsics.checkNotNullParameter(sibling, "sibling");
            return CC.$default$addSiblingPrev(ouroNodeMutableStorage, t, sibling);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> boolean addSiblingPrev(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t, Collection<? extends OuroNode> collection) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            Intrinsics.checkNotNullParameter(collection, "siblings");
            return CC.$default$addSiblingPrev(ouroNodeMutableStorage, t, collection);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> OuroNode removeSiblingNext(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            return CC.$default$removeSiblingNext(ouroNodeMutableStorage, t);
        }

        @Deprecated
        public static <R extends OuroNode.Parent<?>, T extends OuroNode> OuroNode removeSiblingPrev(OuroNodeMutableStorage<R> ouroNodeMutableStorage, T t) {
            Intrinsics.checkNotNullParameter(t, "$receiver");
            return CC.$default$removeSiblingPrev(ouroNodeMutableStorage, t);
        }
    }
}