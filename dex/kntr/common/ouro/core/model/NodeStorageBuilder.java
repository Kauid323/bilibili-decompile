package kntr.common.ouro.core.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kntr.common.ouro.core.model.node.OuroParagraph;
import kntr.common.ouro.core.model.node.OuroParagraphChild;
import kntr.common.ouro.core.model.node.OuroQuoteBlock;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeUtilsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00010\u0005BQ\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\bj\u0002`\n\u0012\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\bj\u0002`\r¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010#\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010$\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\u0006\u0010%\u001a\u0002H\u0001H\u0016¢\u0006\u0002\u0010&J)\u0010'\u001a\u00020(\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\u0006\u0010*\u001a\u0002H)H\u0016¢\u0006\u0002\u0010+J1\u0010'\u001a\u00020(\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010*\u001a\u0002H)H\u0016¢\u0006\u0002\u0010-J2\u0010'\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00022\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00010/H\u0016J:\u0010'\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010,\u001a\u00020\u001a2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00010/H\u0016J/\u00100\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00012\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0016¢\u0006\u0002\u00101J7\u00100\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010,\u001a\u00020\u001a2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030/H\u0016¢\u0006\u0002\u00102J*\u00103\u001a\u00020(\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\f\u00104\u001a\b\u0012\u0004\u0012\u0002H)05H\u0016J2\u00103\u001a\u00020(\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\u0006\u0010,\u001a\u00020\u001a2\f\u00104\u001a\b\u0012\u0004\u0012\u0002H)05H\u0016J8\u00106\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010/05H\u0016J@\u00106\u001a\u00020(\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010,\u001a\u00020\u001a2\u0012\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010/05H\u0016J)\u00108\u001a\u00020 \"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\u0006\u0010*\u001a\u0002H)H\u0016¢\u0006\u0002\u00109J*\u0010:\u001a\u00020 \"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\f\u00104\u001a\b\u0012\u0004\u0012\u0002H)05H\u0016J$\u0010;\u001a\n\u0012\u0004\u0012\u0002H)\u0018\u00010\u0014\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u0002H\u0016J+\u0010<\u001a\u0004\u0018\u0001H)\"\b\b\u0001\u0010)*\u00020\t*\b\u0012\u0004\u0012\u0002H)0\u00022\u0006\u0010,\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010=J\f\u0010>\u001a\u00020 *\u00020\tH\u0016J#\u0010?\u001a\u00020 \"\b\b\u0001\u0010\u0001*\u00020\t*\u0002H\u00012\u0006\u0010.\u001a\u0002H\u0001H\u0016¢\u0006\u0002\u0010@J)\u0010?\u001a\u00020 \"\b\b\u0001\u0010\u0001*\u00020\t*\u0002H\u00012\f\u00107\u001a\b\u0012\u0004\u0012\u0002H\u000105H\u0016¢\u0006\u0002\u0010AJ1\u0010?\u001a\u00020 \"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003*\u0002H\u00012\f\u0010.\u001a\b\u0012\u0004\u0012\u0002H\u00010/H\u0016¢\u0006\u0002\u0010BJ\u0014\u0010C\u001a\u00020(2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030/H\u0002J\u001a\u0010E\u001a\u00020(2\u0010\b\u0002\u0010F\u001a\n\u0012\u0002\b\u00030\u0002j\u0002`\u0003H\u0002J\b\u0010G\u001a\u00020(H\u0002J\f\u0010G\u001a\u00020(*\u00020HH\u0002J+\u0010G\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u0014\"\b\b\u0001\u0010\u0001*\u00020I*\u0002H\u00012\u0006\u0010J\u001a\u00020 H\u0002¢\u0006\u0002\u0010KJ\f\u0010G\u001a\u00020(*\u00020LH\u0002J\f\u0010G\u001a\u00020(*\u00020MH\u0002J\f\u0010G\u001a\u00020(*\u00020NH\u0002J\u0016\u0010O\u001a\b\u0012\u0004\u0012\u00028\u00000$2\u0006\u0010G\u001a\u00020 H\u0016R,\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\bj\u0002`\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\bj\u0002`\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006P"}, d2 = {"Lkntr/common/ouro/core/model/NodeStorageBuilder;", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl;", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "root", "parentMap", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/OuroParentMutableMap;", "childrenMap", "", "Lkntr/common/ouro/core/model/OuroChildrenMutableMap;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Ljava/util/Map;Ljava/util/Map;)V", "getParentMap", "()Ljava/util/Map;", "getChildrenMap", "allSelectables", "", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "getAllSelectables", "()Ljava/util/List;", "_allSelectables", "pictureCount", "", "getPictureCount", "()I", "textCount", "getTextCount", "hasContent", "", "getHasContent", "()Z", "subStorage", "Lkntr/common/ouro/core/model/NodeStorage;", "node", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)Lkntr/common/ouro/core/model/NodeStorage;", "addChild", "", "C", "child", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)V", "index", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;ILkntr/common/ouro/core/model/node/OuroNode;)V", "other", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "add", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/OuroNodeStorage;)V", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;ILkntr/common/ouro/core/model/OuroNodeStorage;)V", "addChildren", "children", "", "addAll", "others", "removeChild", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/node/OuroNode;)Z", "removeChildren", "removeAllChildren", "removeChildAt", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;I)Lkntr/common/ouro/core/model/node/OuroNode;", "removeFromParent", "replace", "(Lkntr/common/ouro/core/model/node/OuroNode;Lkntr/common/ouro/core/model/node/OuroNode;)Z", "(Lkntr/common/ouro/core/model/node/OuroNode;Ljava/util/Collection;)Z", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Lkntr/common/ouro/core/model/OuroNodeStorage;)Z", "addSubStorage", "sub", "mergeOrAbsorb", "parent", "validate", "Lkntr/common/ouro/core/model/node/OuroDocument;", "Lkntr/common/ouro/core/model/node/OuroParagraph;", "isLast", "(Lkntr/common/ouro/core/model/node/OuroParagraph;Z)Ljava/util/List;", "Lkntr/common/ouro/core/model/node/OuroListItem;", "Lkntr/common/ouro/core/model/node/OuroQuoteBlock;", "Lkntr/common/ouro/core/model/node/OuroList;", "build", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NodeStorageBuilder<T extends OuroNode.Parent<?>> extends OuroNodeStorageBaseImpl<T> implements OuroNodeMutableStorage<T> {
    private List<? extends OuroNode.Selectable> _allSelectables;
    private final Map<OuroNode, List<OuroNode>> childrenMap;
    private final Map<OuroNode, OuroNode.Parent<?>> parentMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NodeStorageBuilder(T t, Map<OuroNode, OuroNode.Parent<?>> map, Map<OuroNode, List<OuroNode>> map2) {
        super(t, null);
        Intrinsics.checkNotNullParameter(t, "root");
        Intrinsics.checkNotNullParameter(map, "parentMap");
        Intrinsics.checkNotNullParameter(map2, "childrenMap");
        this.parentMap = map;
        this.childrenMap = map2;
    }

    public /* synthetic */ NodeStorageBuilder(OuroNode.Parent parent, LinkedHashMap linkedHashMap, LinkedHashMap linkedHashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parent, (i & 2) != 0 ? new LinkedHashMap() : linkedHashMap, (i & 4) != 0 ? new LinkedHashMap() : linkedHashMap2);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void add(OuroNode.Parent<C> parent, int index, Collection<? extends OuroNode> collection) {
        OuroNodeMutableStorage.CC.$default$add(this, parent, index, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void add(OuroNode.Parent<C> parent, int index, OuroNode child) {
        OuroNodeMutableStorage.CC.$default$add(this, parent, index, child);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void add(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
        OuroNodeMutableStorage.CC.$default$add(this, parent, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void add(OuroNode.Parent<C> parent, OuroNode child) {
        OuroNodeMutableStorage.CC.$default$add(this, parent, child);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> boolean addSiblingNext(T t, Collection<? extends OuroNode> collection) {
        return OuroNodeMutableStorage.CC.$default$addSiblingNext(this, t, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> boolean addSiblingNext(T t, OuroNodeStorage<?> ouroNodeStorage) {
        return OuroNodeMutableStorage.CC.$default$addSiblingNext(this, t, ouroNodeStorage);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> boolean addSiblingNext(T t, OuroNode sibling) {
        return OuroNodeMutableStorage.CC.$default$addSiblingNext(this, t, sibling);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> boolean addSiblingPrev(T t, Collection<? extends OuroNode> collection) {
        return OuroNodeMutableStorage.CC.$default$addSiblingPrev(this, t, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> boolean addSiblingPrev(T t, OuroNode sibling) {
        return OuroNodeMutableStorage.CC.$default$addSiblingPrev(this, t, sibling);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void minusAssign(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
        OuroNodeMutableStorage.CC.$default$minusAssign(this, parent, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void minusAssign(OuroNode.Parent<C> parent, OuroNode other) {
        OuroNodeMutableStorage.CC.$default$minusAssign(this, parent, other);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ void minusAssign(OuroNode node) {
        OuroNodeMutableStorage.CC.$default$minusAssign(this, node);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void plusAssign(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
        OuroNodeMutableStorage.CC.$default$plusAssign(this, parent, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode.Parent<?>> void plusAssign(OuroNode.Parent<T> parent, OuroNodeStorage<?> ouroNodeStorage) {
        OuroNodeMutableStorage.CC.$default$plusAssign(this, parent, ouroNodeStorage);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> void plusAssign(OuroNode.Parent<C> parent, OuroNode other) {
        OuroNodeMutableStorage.CC.$default$plusAssign(this, parent, other);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> boolean remove(OuroNode.Parent<C> parent, OuroNode other) {
        return OuroNodeMutableStorage.CC.$default$remove(this, parent, other);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <C extends OuroNode> boolean removeAll(OuroNode.Parent<C> parent, Collection<? extends OuroNode> collection) {
        return OuroNodeMutableStorage.CC.$default$removeAll(this, parent, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> OuroNode removeSiblingNext(T t) {
        return OuroNodeMutableStorage.CC.$default$removeSiblingNext(this, t);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public /* bridge */ <T extends OuroNode> OuroNode removeSiblingPrev(T t) {
        return OuroNodeMutableStorage.CC.$default$removeSiblingPrev(this, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ /* synthetic */ OuroNodeStorage subStorage(OuroNode.Parent node) {
        return subStorage((NodeStorageBuilder<T>) node);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorageBaseImpl
    public Map<OuroNode, OuroNode.Parent<?>> getParentMap() {
        return this.parentMap;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorageBaseImpl
    public Map<OuroNode, List<OuroNode>> getChildrenMap() {
        return this.childrenMap;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public List<OuroNode.Selectable> getAllSelectables() {
        List list = this._allSelectables;
        if (list == null) {
            List it = calcAllSelectables(getRoot());
            this._allSelectables = it;
            return it;
        }
        return list;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public int getPictureCount() {
        return calcPictureCount();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public int getTextCount() {
        return calcTextCount();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public boolean getHasContent() {
        return calcHasContent();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public <T extends OuroNode.Parent<?>> NodeStorage<T> subStorage(T t) {
        Intrinsics.checkNotNullParameter(t, "node");
        if (contains(t)) {
            Map mutableMap = MapsKt.toMutableMap(getParentMap());
            Map $this$mapValues$iv = getChildrenMap();
            Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Map.Entry it = (Map.Entry) element$iv$iv$iv;
                destination$iv$iv.put(it$iv$iv.getKey(), CollectionsKt.toMutableList((Collection) it.getValue()));
            }
            return OuroNodeMutableStorage.CC.build$default(new NodeStorageBuilder(t, mutableMap, MapsKt.toMutableMap(destination$iv$iv)), false, 1, null);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> void addChild(OuroNode.Parent<C> parent, C c) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(c, "child");
        getParentMap().put(c, parent);
        OuroNodeStorageKt.access$addChild(getChildrenMap(), parent, c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> void addChild(OuroNode.Parent<C> parent, int index, C c) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(c, "child");
        getParentMap().put(c, parent);
        OuroNodeStorageKt.access$addChild(getChildrenMap(), parent, c, index);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void addChild(OuroNode.Parent<T> parent, OuroNodeStorage<T> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
        addChild((OuroNode.Parent<OuroNode.Parent<T>>) parent, (OuroNode.Parent<T>) ouroNodeStorage.getRoot());
        addSubStorage(ouroNodeStorage);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void addChild(OuroNode.Parent<T> parent, int index, OuroNodeStorage<T> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
        addChild((OuroNode.Parent<int>) parent, index, (int) ouroNodeStorage.getRoot());
        addSubStorage(ouroNodeStorage);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void add(T t, OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
        add(t, (OuroNode) ouroNodeStorage.getRoot());
        addSubStorage(ouroNodeStorage);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void add(T t, int index, OuroNodeStorage<?> ouroNodeStorage) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
        add(t, index, (OuroNode) ouroNodeStorage.getRoot());
        addSubStorage(ouroNodeStorage);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> void addChildren(OuroNode.Parent<C> parent, Collection<? extends C> collection) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(collection, "children");
        Collection<? extends C> $this$forEach$iv = collection;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode child = (OuroNode) element$iv;
            getParentMap().put(child, parent);
        }
        OuroNodeStorageKt.access$addChildren(getChildrenMap(), parent, collection);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> void addChildren(OuroNode.Parent<C> parent, int index, Collection<? extends C> collection) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(collection, "children");
        Collection<? extends C> $this$forEach$iv = collection;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode child = (OuroNode) element$iv;
            getParentMap().put(child, parent);
        }
        OuroNodeStorageKt.access$addChildren(getChildrenMap(), parent, collection, index);
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void addAll(OuroNode.Parent<T> parent, Collection<? extends OuroNodeStorage<T>> collection) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(collection, "others");
        Collection<? extends OuroNodeStorage<T>> $this$forEach$iv = collection;
        for (Object element$iv : $this$forEach$iv) {
            OuroNodeStorage it = (OuroNodeStorage) element$iv;
            add((NodeStorageBuilder<T>) parent, (OuroNodeStorage<?>) it);
        }
        this._allSelectables = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> void addAll(OuroNode.Parent<T> parent, int index, Collection<? extends OuroNodeStorage<T>> collection) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(collection, "others");
        Collection<? extends OuroNodeStorage<T>> $this$forEachIndexed$iv = collection;
        int idx = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = idx + 1;
            if (idx < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            OuroNodeStorage storage = (OuroNodeStorage) item$iv;
            add((NodeStorageBuilder<T>) parent, idx + index, (OuroNodeStorage<?>) storage);
            idx = index$iv;
        }
        this._allSelectables = null;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> boolean removeChild(OuroNode.Parent<C> parent, C c) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(c, "child");
        this._allSelectables = null;
        if (getParentMap().remove(c) == null) {
            return false;
        }
        return OuroNodeStorageKt.access$removeChild(getChildrenMap(), parent, c);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> boolean removeChildren(OuroNode.Parent<C> parent, Collection<? extends C> collection) {
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Intrinsics.checkNotNullParameter(collection, "children");
        Collection<? extends C> $this$forEach$iv = collection;
        for (Object element$iv : $this$forEach$iv) {
            OuroNode it = (OuroNode) element$iv;
            getParentMap().remove(it);
        }
        this._allSelectables = null;
        return OuroNodeStorageKt.access$removeChildren(getChildrenMap(), parent, collection);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> List<C> removeAllChildren(OuroNode.Parent<C> parent) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(parent, "<this>");
        Iterable iterable = (List) getChildrenMap().remove(parent);
        if (iterable != null) {
            Iterable $this$map$iv = iterable;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv.add(parent.castChild(it));
            }
            arrayList = (List) destination$iv$iv;
            ArrayList $this$forEach$iv = arrayList;
            for (Object element$iv : $this$forEach$iv) {
                OuroNode it2 = (OuroNode) element$iv;
                getParentMap().remove(it2);
            }
        } else {
            arrayList = null;
        }
        this._allSelectables = null;
        return arrayList;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <C extends OuroNode> C removeChildAt(OuroNode.Parent<C> parent, int index) {
        OuroNode it;
        C castChild;
        Intrinsics.checkNotNullParameter(parent, "<this>");
        this._allSelectables = null;
        List<OuroNode> children = getChildren(parent);
        if (children == null || (it = (OuroNode) CollectionsKt.getOrNull(children, index)) == null || (castChild = parent.castChild(it)) == null || !removeChild(parent, castChild)) {
            return null;
        }
        return castChild;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public boolean removeFromParent(final OuroNode $this$removeFromParent) {
        List<OuroNode> list;
        Intrinsics.checkNotNullParameter($this$removeFromParent, "<this>");
        this._allSelectables = null;
        OuroNode.Parent parent = getParentMap().remove($this$removeFromParent);
        if (parent == null || (list = getChildrenMap().get(parent)) == null) {
            return false;
        }
        return CollectionsKt.removeAll(list, new Function1() { // from class: kntr.common.ouro.core.model.NodeStorageBuilder$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean removeFromParent$lambda$0;
                removeFromParent$lambda$0 = NodeStorageBuilder.removeFromParent$lambda$0(OuroNode.this, (OuroNode) obj);
                return Boolean.valueOf(removeFromParent$lambda$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean removeFromParent$lambda$0(OuroNode $this_removeFromParent, OuroNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.areEqual(it, $this_removeFromParent);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode> boolean replace(T t, T t2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(t2, "other");
        this._allSelectables = null;
        Integer indexInSiblings = getIndexInSiblings(t);
        if (indexInSiblings != null) {
            int indexInParent = indexInSiblings.intValue();
            OuroNode.Parent parent = getParentMap().get(t);
            if (parent != null && remove(parent, t)) {
                getParentMap().remove(t);
                add(parent, indexInParent, t2);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode> boolean replace(T t, Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(collection, "others");
        this._allSelectables = null;
        Integer indexInSiblings = getIndexInSiblings(t);
        if (indexInSiblings != null) {
            int indexInParent = indexInSiblings.intValue();
            OuroNode.Parent parent = getParentMap().get(t);
            if (parent != null && remove(parent, t)) {
                getParentMap().remove(t);
                add(parent, indexInParent, collection);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public <T extends OuroNode.Parent<?>> boolean replace(T t, OuroNodeStorage<T> ouroNodeStorage) {
        List siblings;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "other");
        this._allSelectables = null;
        Integer indexInSiblings = getIndexInSiblings(t);
        if (indexInSiblings != null) {
            int indexInParent = indexInSiblings.intValue();
            OuroNode.Parent parent = getParentMap().get(t);
            if (parent == null || (siblings = getChildrenMap().get(parent)) == null) {
                return false;
            }
            getParentMap().remove(t);
            getParentMap().put(ouroNodeStorage.getRoot(), parent);
            siblings.set(indexInParent, ouroNodeStorage.getRoot());
            addSubStorage(ouroNodeStorage);
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.Object] */
    private final void addSubStorage(OuroNodeStorage<?> ouroNodeStorage) {
        this._allSelectables = null;
        if (!(ouroNodeStorage instanceof OuroNodeStorageBaseImpl)) {
            throw new IllegalArgumentException("Subtree must be an instance of OuroNodeStorageBaseImpl, but was: " + Reflection.getOrCreateKotlinClass(ouroNodeStorage.getClass()).getSimpleName());
        }
        getParentMap().putAll(((OuroNodeStorageBaseImpl) ouroNodeStorage).getParentMap());
        Map $this$forEach$iv = ((OuroNodeStorageBaseImpl) ouroNodeStorage).getChildrenMap();
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            OuroNode key = element$iv.getKey();
            List<OuroNode> value = element$iv.getValue();
            Map<OuroNode, List<OuroNode>> childrenMap = getChildrenMap();
            Pair pair = TuplesKt.to(key, CollectionsKt.toMutableList(value));
            childrenMap.put(pair.getFirst(), pair.getSecond());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void mergeOrAbsorb$default(NodeStorageBuilder nodeStorageBuilder, OuroNode.Parent parent, int i, Object obj) {
        if ((i & 1) != 0) {
            parent = nodeStorageBuilder.getRoot();
        }
        nodeStorageBuilder.mergeOrAbsorb(parent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void mergeOrAbsorb(OuroNode.Parent<?> parent) {
        List list;
        List list2;
        List list3;
        this._allSelectables = null;
        Iterable children = getChildrenOrNull(parent);
        if (children != null) {
            if (((Collection) children).isEmpty()) {
                children = null;
            }
            if (children == null) {
                return;
            }
            Object currentMergeable = null;
            Object currentAbsorbable = null;
            Iterable $this$forEach$iv = children;
            for (Object element$iv : $this$forEach$iv) {
                OuroNode it = (OuroNode) element$iv;
                if (!OuroNodeUtilsKt.isMergeable(it) && !OuroNodeUtilsKt.isAbsorbable(it)) {
                    currentMergeable = null;
                    currentAbsorbable = null;
                } else if (OuroNodeUtilsKt.isMergeable(it)) {
                    currentAbsorbable = null;
                    if (currentMergeable == null) {
                        currentMergeable = it;
                    } else {
                        OuroNode.Mergeable $this$mergeOrAbsorb_u24lambda_u241_u240 = (OuroNode.Mergeable) currentMergeable;
                        OuroNode merged = $this$mergeOrAbsorb_u24lambda_u241_u240.tryMergeWith(this, it);
                        if (merged == null) {
                            currentMergeable = it;
                        } else {
                            List mergedChildren = new ArrayList();
                            OuroNode.Parent parent2 = currentMergeable instanceof OuroNode.Parent ? (OuroNode.Parent) currentMergeable : null;
                            if (parent2 != null && (list2 = removeAllChildren(parent2)) != null) {
                                mergedChildren.addAll(list2);
                            }
                            OuroNode.Parent parent3 = it instanceof OuroNode.Parent ? (OuroNode.Parent) it : null;
                            if (parent3 != null && (list = removeAllChildren(parent3)) != null) {
                                mergedChildren.addAll(list);
                            }
                            if (OuroNodeUtilsKt.isOuroParent(merged)) {
                                add((OuroNode.Parent) merged, mergedChildren);
                            }
                            replace((OuroNode) currentMergeable, merged);
                            removeFromParent(it);
                            currentMergeable = OuroNodeUtilsKt.isMergeable(merged) ? (OuroNode.Mergeable) merged : null;
                        }
                    }
                } else if (OuroNodeUtilsKt.isAbsorbable(it)) {
                    currentMergeable = null;
                    if (currentAbsorbable == null) {
                        currentAbsorbable = it;
                    } else {
                        OuroNode.Absorbable $this$mergeOrAbsorb_u24lambda_u241_u243 = (OuroNode.Absorbable) currentAbsorbable;
                        if ($this$mergeOrAbsorb_u24lambda_u241_u243.tryAbsorb(this, it)) {
                            if (OuroNodeUtilsKt.isOuroParent(it) && (list3 = removeAllChildren((OuroNode.Parent) it)) != null) {
                                OuroNode.Parent parent4 = currentAbsorbable instanceof OuroNode.Parent ? (OuroNode.Parent) currentAbsorbable : null;
                                if (parent4 != null) {
                                    add(parent4, list3);
                                }
                            }
                            removeFromParent(it);
                        } else {
                            currentAbsorbable = it;
                        }
                    }
                }
            }
            Iterable it2 = getChildrenOrNull(parent);
            if (it2 != null) {
                Iterable iterable = ((Collection) it2).isEmpty() ? null : it2;
                if (iterable != null) {
                    Iterable $this$forEach$iv2 = iterable;
                    for (Object element$iv2 : $this$forEach$iv2) {
                        OuroNode it3 = (OuroNode) element$iv2;
                        if (OuroNodeUtilsKt.isOuroParent(it3)) {
                            mergeOrAbsorb((OuroNode.Parent) it3);
                        }
                    }
                }
            }
        }
    }

    private final void validate() {
        Iterable iterable;
        List it;
        NodeStorageBuilder<T> nodeStorageBuilder = this;
        Set checked = new LinkedHashSet();
        Collection arrayDeque = new ArrayDeque(getParentMap().size());
        arrayDeque.add(getRoot());
        OuroParagraph lastParagraph = validate$findLastParagraph(this);
        while (!arrayDeque.isEmpty()) {
            OuroNode current = (OuroNode) arrayDeque.remove(0);
            if (checked.contains(current)) {
                throw new IllegalArgumentException("OuroNodeStorage contains a cycle: " + current + " already checked.");
            }
            T root = getRoot();
            if ((root instanceof OuroDocument ? (OuroDocument) root : null) == null) {
                iterable = null;
            } else if (current instanceof OuroDocument) {
                nodeStorageBuilder.validate((OuroDocument) current);
                iterable = null;
            } else if (current instanceof OuroParagraph) {
                iterable = nodeStorageBuilder.validate((OuroParagraph) current, Intrinsics.areEqual(current, lastParagraph));
            } else if (current instanceof OuroListItem) {
                nodeStorageBuilder.validate((OuroListItem) current);
                iterable = null;
            } else if (current instanceof OuroQuoteBlock) {
                nodeStorageBuilder.validate((OuroQuoteBlock) current);
                iterable = null;
            } else if (current instanceof OuroList) {
                nodeStorageBuilder.validate((OuroList) current);
                iterable = null;
            } else {
                iterable = null;
            }
            Iterable changed = iterable;
            if (changed == null) {
                if ((current instanceof OuroNode.Parent) && (it = nodeStorageBuilder.getChildrenOrNull((OuroNode.Parent) current)) != null) {
                    List list = !it.isEmpty() ? it : null;
                    if (list != null) {
                        List it2 = list;
                        arrayDeque.addAll(it2);
                    }
                }
                checked.add(current);
            } else {
                Iterable $this$fold$iv = changed;
                List arrayList = new ArrayList();
                for (Object element$iv : $this$fold$iv) {
                    OuroParagraph item = (OuroParagraph) element$iv;
                    List acc = arrayList;
                    List it3 = nodeStorageBuilder.getChildrenOrNull(item);
                    if (it3 != null) {
                        if (it3.isEmpty()) {
                            it3 = null;
                        }
                        if (it3 != null) {
                            acc.addAll(it3);
                        }
                    }
                    arrayList = acc;
                    nodeStorageBuilder = this;
                }
                List children = arrayList;
                arrayDeque.addAll(children);
                checked.addAll((Collection) changed);
                nodeStorageBuilder = this;
            }
        }
        Iterable $this$forEach$iv = SetsKt.minus(getParentMap().keySet(), checked);
        for (Object element$iv2 : $this$forEach$iv) {
            OuroNode it4 = (OuroNode) element$iv2;
            getParentMap().remove(it4);
        }
        getParentMap().remove(getRoot());
        Iterable $this$forEach$iv2 = SetsKt.minus(getChildrenMap().keySet(), checked);
        for (Object element$iv3 : $this$forEach$iv2) {
            OuroNode it5 = (OuroNode) element$iv3;
            getChildrenMap().remove(it5);
        }
    }

    private static final <T extends OuroNode.Parent<?>> OuroParagraph validate$findLastParagraph(NodeStorageBuilder<T> nodeStorageBuilder) {
        OuroNode.Parent current = nodeStorageBuilder.getRoot();
        while (true) {
            OuroNode.Parent parent = null;
            if (current == null) {
                return null;
            }
            List<OuroNode> list = nodeStorageBuilder.getChildrenMap().get(current);
            OuroNode last = list != null ? (OuroNode) CollectionsKt.lastOrNull(list) : null;
            if (last instanceof OuroParagraph) {
                return (OuroParagraph) last;
            }
            if (last instanceof OuroNode.Parent) {
                parent = (OuroNode.Parent) last;
            }
            current = parent;
        }
    }

    private final void validate(OuroDocument $this$validate) {
        List<OuroNode> children = getChildren($this$validate);
        if (children == null || children.isEmpty()) {
            OuroText emptyParagraph = new OuroText(null, 1, null);
            addChild((OuroNode.Parent<OuroText>) emptyParagraph, (OuroText) new OuroTextElement.HardBreak(null, 1, null));
            addChild((OuroNode.Parent<OuroDocument>) $this$validate, (OuroDocument) emptyParagraph);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v13 */
    private final <T extends OuroParagraph> List<OuroParagraph> validate(T t, boolean isLast) {
        int hardBreakCount;
        List children;
        boolean needsExpansion;
        Iterable $this$forEachIndexed$iv;
        List children2 = getChildrenOrNull(t);
        List list = children2;
        ?? r4 = 0;
        if (list == null || list.isEmpty()) {
            removeFromParent(t);
            return CollectionsKt.emptyList();
        }
        List expandedChildren = new ArrayList();
        boolean needsExpansion2 = false;
        List $this$forEach$iv = children2;
        for (Object element$iv : $this$forEach$iv) {
            OuroParagraphChild child = (OuroParagraphChild) element$iv;
            if (child instanceof OuroTextElement.Plain) {
                String content = ((OuroTextElement.Plain) child).getMeta();
                children = children2;
                if (StringsKt.contains$default(content, '\n', (boolean) r4, 2, (Object) null)) {
                    boolean needsExpansion3 = true;
                    char[] cArr = new char[1];
                    cArr[r4] = '\n';
                    List lines = StringsKt.split$default(content, cArr, false, 0, 6, (Object) null);
                    List $this$forEachIndexed$iv2 = lines;
                    int index = 0;
                    for (Object item$iv : $this$forEachIndexed$iv2) {
                        int index$iv = index + 1;
                        if (index < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        String line = (String) item$iv;
                        if (!(line.length() > 0)) {
                            needsExpansion = needsExpansion3;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                        } else {
                            needsExpansion = needsExpansion3;
                            $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                            expandedChildren.add(new OuroTextElement.Plain(line, ((OuroTextElement.Plain) child).getMarks()));
                        }
                        if (index < lines.size() - 1) {
                            expandedChildren.add(new OuroTextElement.HardBreak(((OuroTextElement.Plain) child).getMarks()));
                        }
                        index = index$iv;
                        needsExpansion3 = needsExpansion;
                        $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                    }
                    needsExpansion2 = needsExpansion3;
                } else {
                    expandedChildren.add(child);
                }
            } else {
                children = children2;
                expandedChildren.add(child);
            }
            children2 = children;
            r4 = 0;
        }
        List finalChildren = needsExpansion2 ? expandedChildren : children2;
        Iterable $this$count$iv = finalChildren;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            hardBreakCount = 0;
        } else {
            int count$iv = 0;
            for (Object element$iv2 : $this$count$iv) {
                if ((((OuroParagraphChild) element$iv2) instanceof OuroTextElement.HardBreak) && (count$iv = count$iv + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
            hardBreakCount = count$iv;
        }
        if ((CollectionsKt.last(finalChildren) instanceof OuroTextElement.HardBreak) && hardBreakCount == 1) {
            if (needsExpansion2) {
                removeAllChildren(t);
                addChildren(t, finalChildren);
            }
            return null;
        } else if (!(CollectionsKt.last(finalChildren) instanceof OuroTextElement.HardBreak) && hardBreakCount == 0 && !isLast) {
            if (needsExpansion2) {
                removeAllChildren(t);
                addChildren(t, finalChildren);
            }
            addChild((OuroNode.Parent<T>) t, (T) new OuroTextElement.HardBreak(null, 1, null));
            return null;
        } else {
            List childrenGroup = new ArrayList();
            List tmp = new ArrayList();
            Iterable $this$forEach$iv2 = finalChildren;
            for (Object element$iv3 : $this$forEach$iv2) {
                OuroParagraphChild it = (OuroParagraphChild) element$iv3;
                tmp.add(it);
                if (it instanceof OuroTextElement.HardBreak) {
                    childrenGroup.add(CollectionsKt.toList(tmp));
                    tmp.clear();
                }
            }
            if (!tmp.isEmpty()) {
                tmp.add(new OuroTextElement.HardBreak(null, 1, null));
                childrenGroup.add(CollectionsKt.toList(tmp));
                tmp.clear();
            }
            List $this$map$iv = childrenGroup;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                List group = (List) item$iv$iv;
                List finalChildren2 = finalChildren;
                OuroParagraph $this$validate_u24lambda_u2410_u240 = t.copyWithMarks(t.getParagraphMarks());
                addChildren($this$validate_u24lambda_u2410_u240, group);
                destination$iv$iv.add($this$validate_u24lambda_u2410_u240);
                finalChildren = finalChildren2;
                expandedChildren = expandedChildren;
                hardBreakCount = hardBreakCount;
            }
            List changed = (List) destination$iv$iv;
            replace((NodeStorageBuilder<T>) t, (Collection<? extends NodeStorageBuilder<T>>) changed);
            return changed;
        }
    }

    private final void validate(OuroListItem $this$validate) {
        if (OuroNodeStorageUtilsKt.isEmpty(this, $this$validate)) {
            removeFromParent($this$validate);
        }
    }

    private final void validate(OuroQuoteBlock $this$validate) {
        if (OuroNodeStorageUtilsKt.isEmpty(this, $this$validate)) {
            removeFromParent($this$validate);
        }
    }

    private final void validate(OuroList $this$validate) {
        if (OuroNodeStorageUtilsKt.isEmpty(this, $this$validate)) {
            removeFromParent($this$validate);
        }
    }

    @Override // kntr.common.ouro.core.model.OuroNodeMutableStorage
    public NodeStorage<T> build(boolean validate) {
        if (validate) {
            mergeOrAbsorb$default(this, null, 1, null);
            validate();
        }
        T root = getRoot();
        Map map = MapsKt.toMap(getParentMap());
        Map $this$mapValues$iv = getChildrenMap();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv.put(it$iv$iv.getKey(), CollectionsKt.toList((Iterable) it.getValue()));
        }
        NodeStorage res = new NodeStorage(root, map, destination$iv$iv);
        return res;
    }
}