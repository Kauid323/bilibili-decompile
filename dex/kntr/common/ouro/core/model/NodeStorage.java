package kntr.common.ouro.core.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroNode.Parent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeStorage.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 2*\u0010\b\u0000\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u00012BQ\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\u0007j\u0002`\t\u0012\u001e\b\u0002\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u0007j\u0002`\f¢\u0006\u0004\b\r\u0010\u000eJ<\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010(\u001a\u00020!2\u001d\u0010)\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000+\u0012\u0004\u0012\u00020,0*¢\u0006\u0002\b-H\u0000¢\u0006\u0002\b.J/\u0010/\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0000\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0002\b\u00030\u0002j\u0002`\u00032\u0006\u00100\u001a\u0002H\u0001H\u0016¢\u0006\u0002\u00101R,\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0002\b\u00030\u0002j\u0002`\u00030\u0007j\u0002`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b0\u0007j\u0002`\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b\u001e\u0010\u001bR\u001b\u0010 \u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0017\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000&X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lkntr/common/ouro/core/model/NodeStorage;", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "Lkntr/common/ouro/core/model/node/OuroParent;", "Lkntr/common/ouro/core/model/OuroNodeStorageBaseImpl;", "root", "parentMap", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "Lkntr/common/ouro/core/model/OuroParentMap;", "childrenMap", "", "Lkntr/common/ouro/core/model/OuroChildrenMap;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;Ljava/util/Map;Ljava/util/Map;)V", "getParentMap", "()Ljava/util/Map;", "getChildrenMap", "allSelectables", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "getAllSelectables", "()Ljava/util/List;", "allSelectables$delegate", "Lkotlin/Lazy;", "textCount", "", "getTextCount", "()I", "textCount$delegate", "pictureCount", "getPictureCount", "pictureCount$delegate", "hasContent", "", "getHasContent", "()Z", "hasContent$delegate", "substoragesSnapshot", "", "mutate", "validate", "fn", "Lkotlin/Function1;", "Lkntr/common/ouro/core/model/NodeStorageBuilder;", "", "Lkotlin/ExtensionFunctionType;", "mutate$core_debug", "subStorage", "node", "(Lkntr/common/ouro/core/model/node/OuroNode$Parent;)Lkntr/common/ouro/core/model/NodeStorage;", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NodeStorage<T extends OuroNode.Parent<?>> extends OuroNodeStorageBaseImpl<T> {
    public static final Companion Companion = new Companion(null);
    private final Lazy allSelectables$delegate;
    private final Map<OuroNode, List<OuroNode>> childrenMap;
    private final Lazy hasContent$delegate;
    private final Map<OuroNode, OuroNode.Parent<?>> parentMap;
    private final Lazy pictureCount$delegate;
    private final Map<OuroNode, NodeStorage<?>> substoragesSnapshot;
    private final Lazy textCount$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NodeStorage(final T t, Map<OuroNode, ? extends OuroNode.Parent<?>> map, Map<OuroNode, ? extends List<? extends OuroNode>> map2) {
        super(t, null);
        Intrinsics.checkNotNullParameter(t, "root");
        Intrinsics.checkNotNullParameter(map, "parentMap");
        Intrinsics.checkNotNullParameter(map2, "childrenMap");
        this.parentMap = map;
        this.childrenMap = map2;
        this.allSelectables$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.NodeStorage$$ExternalSyntheticLambda0
            public final Object invoke() {
                List allSelectables_delegate$lambda$0;
                allSelectables_delegate$lambda$0 = NodeStorage.allSelectables_delegate$lambda$0(NodeStorage.this, t);
                return allSelectables_delegate$lambda$0;
            }
        });
        this.textCount$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.NodeStorage$$ExternalSyntheticLambda1
            public final Object invoke() {
                int calcTextCount;
                calcTextCount = NodeStorage.this.calcTextCount();
                return Integer.valueOf(calcTextCount);
            }
        });
        this.pictureCount$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.NodeStorage$$ExternalSyntheticLambda2
            public final Object invoke() {
                int calcPictureCount;
                calcPictureCount = NodeStorage.this.calcPictureCount();
                return Integer.valueOf(calcPictureCount);
            }
        });
        this.hasContent$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.model.NodeStorage$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean calcHasContent;
                calcHasContent = NodeStorage.this.calcHasContent();
                return Boolean.valueOf(calcHasContent);
            }
        });
        this.substoragesSnapshot = new LinkedHashMap();
    }

    public /* synthetic */ NodeStorage(OuroNode.Parent parent, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(parent, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? MapsKt.emptyMap() : map2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public /* bridge */ /* synthetic */ OuroNodeStorage subStorage(OuroNode.Parent node) {
        return subStorage((NodeStorage<T>) node);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorageBaseImpl
    public Map<OuroNode, OuroNode.Parent<?>> getParentMap() {
        return this.parentMap;
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorageBaseImpl
    public Map<OuroNode, List<OuroNode>> getChildrenMap() {
        return this.childrenMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List allSelectables_delegate$lambda$0(NodeStorage this$0, OuroNode.Parent $root) {
        return this$0.calcAllSelectables($root);
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public List<OuroNode.Selectable> getAllSelectables() {
        return (List) this.allSelectables$delegate.getValue();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public int getTextCount() {
        return ((Number) this.textCount$delegate.getValue()).intValue();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public int getPictureCount() {
        return ((Number) this.pictureCount$delegate.getValue()).intValue();
    }

    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public boolean getHasContent() {
        return ((Boolean) this.hasContent$delegate.getValue()).booleanValue();
    }

    /* compiled from: OuroNodeStorage.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkntr/common/ouro/core/model/NodeStorage$Companion;", "", "<init>", "()V", "empty", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "getEmpty", "()Lkntr/common/ouro/core/model/NodeStorage;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NodeStorage<OuroDocument> getEmpty() {
            return new NodeStorage<>(new OuroDocument((OuroMarks) null, 1, (DefaultConstructorMarker) null), null, null, 6, null);
        }
    }

    public static /* synthetic */ NodeStorage mutate$core_debug$default(NodeStorage nodeStorage, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return nodeStorage.mutate$core_debug(z, function1);
    }

    public final NodeStorage<T> mutate$core_debug(boolean validate, Function1<? super NodeStorageBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "fn");
        T root = getRoot();
        Map mutableMap = MapsKt.toMutableMap(getParentMap());
        Map $this$mapValues$iv = getChildrenMap();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv.put(it$iv$iv.getKey(), CollectionsKt.toMutableList((Collection) it.getValue()));
        }
        NodeStorageBuilder $this$mutate_u24lambda_u241 = new NodeStorageBuilder(root, mutableMap, MapsKt.toMutableMap(destination$iv$iv));
        function1.invoke($this$mutate_u24lambda_u241);
        return $this$mutate_u24lambda_u241.build(validate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kntr.common.ouro.core.model.OuroNodeStorage
    public <T extends OuroNode.Parent<?>> NodeStorage<T> subStorage(T t) {
        Object obj;
        Intrinsics.checkNotNullParameter(t, "node");
        if (!contains(t)) {
            return null;
        }
        Map $this$getOrPut$iv = this.substoragesSnapshot;
        Object value$iv = $this$getOrPut$iv.get(t);
        if (value$iv == null) {
            Map newParentMap = new LinkedHashMap();
            Map newChildrenMap = new LinkedHashMap();
            Collection arrayDeque = new ArrayDeque();
            arrayDeque.add(t);
            while (!arrayDeque.isEmpty()) {
                OuroNode.Parent current = (OuroNode.Parent) arrayDeque.removeFirst();
                List children = getChildrenMap().get(current);
                if (children == null) {
                    children = CollectionsKt.emptyList();
                }
                newChildrenMap.put(current, children);
                for (OuroNode child : children) {
                    newParentMap.put(child, current);
                    if (child instanceof OuroNode.Parent) {
                        arrayDeque.add(child);
                    }
                }
            }
            NodeStorage<?> nodeStorage = new NodeStorage<>(t, MapsKt.toMap(newParentMap), MapsKt.toMap(newChildrenMap));
            $this$getOrPut$iv.put(t, nodeStorage);
            obj = nodeStorage;
        } else {
            obj = value$iv;
        }
        return (NodeStorage) obj;
    }
}