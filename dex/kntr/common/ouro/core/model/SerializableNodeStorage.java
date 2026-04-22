package kntr.common.ouro.core.model;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.drawable.OuroDrawable;
import kntr.common.ouro.core.model.node.renderable.OuroLocalImage;
import kntr.common.ouro.core.model.node.renderable.OuroRemoteImage;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.SerializationUtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SerializableNodeStorage.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 32\u00020\u0001:\u000234BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\n\u0010\u000bB\u0015\b\u0010\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\n\u0010\u000eBm\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0005\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\n\u0010\u0013J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\r\"\u000e\b\u0000\u0010\u001b\u0018\u0001*\u0006\u0012\u0002\b\u00030\u001cH\u0086\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010 \u001a\u00020\u001eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u001b\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0005HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u00052\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0010HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017¨\u00065"}, d2 = {"Lkntr/common/ouro/core/model/SerializableNodeStorage;", "", "root", "", "nodes", "", "Lkntr/common/ouro/core/model/node/OuroNode;", "childrenMap", "", "parentMap", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "(Lkntr/common/ouro/core/model/NodeStorage;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRoot", "()Ljava/lang/String;", "getNodes", "()Ljava/util/Map;", "getChildrenMap", "getParentMap", "toNodeStorage", "T", "Lkntr/common/ouro/core/model/node/OuroNode$Parent;", "toByteArray", "", "fromByteArray", "byteArray", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public final class SerializableNodeStorage {
    private final Map<String, List<String>> childrenMap;
    private final Map<String, OuroNode> nodes;
    private final Map<String, String> parentMap;
    private final String root;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.SerializableNodeStorage$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = SerializableNodeStorage._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.SerializableNodeStorage$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = SerializableNodeStorage._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.SerializableNodeStorage$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = SerializableNodeStorage._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SerializableNodeStorage copy$default(SerializableNodeStorage serializableNodeStorage, String str, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = serializableNodeStorage.root;
        }
        if ((i & 2) != 0) {
            map = serializableNodeStorage.nodes;
        }
        if ((i & 4) != 0) {
            map2 = serializableNodeStorage.childrenMap;
        }
        if ((i & 8) != 0) {
            map3 = serializableNodeStorage.parentMap;
        }
        return serializableNodeStorage.copy(str, map, map2, map3);
    }

    public final String component1() {
        return this.root;
    }

    public final Map<String, OuroNode> component2() {
        return this.nodes;
    }

    public final Map<String, List<String>> component3() {
        return this.childrenMap;
    }

    public final Map<String, String> component4() {
        return this.parentMap;
    }

    public final SerializableNodeStorage copy(String str, Map<String, ? extends OuroNode> map, Map<String, ? extends List<String>> map2, Map<String, String> map3) {
        Intrinsics.checkNotNullParameter(str, "root");
        Intrinsics.checkNotNullParameter(map, "nodes");
        Intrinsics.checkNotNullParameter(map2, "childrenMap");
        Intrinsics.checkNotNullParameter(map3, "parentMap");
        return new SerializableNodeStorage(str, map, map2, map3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SerializableNodeStorage) {
            SerializableNodeStorage serializableNodeStorage = (SerializableNodeStorage) obj;
            return Intrinsics.areEqual(this.root, serializableNodeStorage.root) && Intrinsics.areEqual(this.nodes, serializableNodeStorage.nodes) && Intrinsics.areEqual(this.childrenMap, serializableNodeStorage.childrenMap) && Intrinsics.areEqual(this.parentMap, serializableNodeStorage.parentMap);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.root.hashCode() * 31) + this.nodes.hashCode()) * 31) + this.childrenMap.hashCode()) * 31) + this.parentMap.hashCode();
    }

    public String toString() {
        String str = this.root;
        Map<String, OuroNode> map = this.nodes;
        Map<String, List<String>> map2 = this.childrenMap;
        return "SerializableNodeStorage(root=" + str + ", nodes=" + map + ", childrenMap=" + map2 + ", parentMap=" + this.parentMap + ")";
    }

    public /* synthetic */ SerializableNodeStorage(int seen0, String root, Map nodes, Map childrenMap, Map parentMap, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (seen0 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 15, SerializableNodeStorage$$serializer.INSTANCE.getDescriptor());
        }
        this.root = root;
        this.nodes = nodes;
        this.childrenMap = childrenMap;
        this.parentMap = parentMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SerializableNodeStorage(String root, Map<String, ? extends OuroNode> map, Map<String, ? extends List<String>> map2, Map<String, String> map3) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(map, "nodes");
        Intrinsics.checkNotNullParameter(map2, "childrenMap");
        Intrinsics.checkNotNullParameter(map3, "parentMap");
        this.root = root;
        this.nodes = map;
        this.childrenMap = map2;
        this.parentMap = map3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(OuroNode.class), new Annotation[0]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(StringSerializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(SerializableNodeStorage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.root);
        output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.nodes);
        output.encodeSerializableElement(serialDesc, 2, lazyArr[2].getValue(), self.childrenMap);
        output.encodeSerializableElement(serialDesc, 3, lazyArr[3].getValue(), self.parentMap);
    }

    public final String getRoot() {
        return this.root;
    }

    public final Map<String, OuroNode> getNodes() {
        return this.nodes;
    }

    public final Map<String, List<String>> getChildrenMap() {
        return this.childrenMap;
    }

    public final Map<String, String> getParentMap() {
        return this.parentMap;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SerializableNodeStorage(NodeStorage<?> nodeStorage) {
        this(r0, r1, destination$iv$iv, destination$iv$iv);
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        String obj = nodeStorage.getRoot().toString();
        Map $this$flatMap$iv = nodeStorage.getChildrenMap();
        Collection destination$iv$iv = new ArrayList();
        for (Map.Entry element$iv$iv : $this$flatMap$iv.entrySet()) {
            List<OuroNode> $this$map$iv = element$iv$iv.getValue();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                OuroNode it = (OuroNode) item$iv$iv;
                destination$iv$iv2.add(TuplesKt.to(it.toString(), it));
                $this$flatMap$iv = $this$flatMap$iv;
            }
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Map plus = MapsKt.plus(MapsKt.toMap((List) destination$iv$iv), TuplesKt.to(nodeStorage.getRoot().toString(), nodeStorage.getRoot()));
        Map $this$mapKeys$iv = nodeStorage.getChildrenMap();
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeys$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it2 = (Map.Entry) element$iv$iv$iv;
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            linkedHashMap.put(it2.getKey().toString(), it$iv$iv.getValue());
        }
        Map $this$mapValues$iv = linkedHashMap;
        boolean z = false;
        Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv2 = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv2 : $this$associateByTo$iv$iv$iv2) {
            Map.Entry it$iv$iv2 = (Map.Entry) element$iv$iv$iv2;
            Object key = it$iv$iv2.getKey();
            Map.Entry entry = (Map.Entry) element$iv$iv$iv2;
            Iterable $this$map$iv2 = (Iterable) entry.getValue();
            Map $this$mapValues$iv2 = $this$mapValues$iv;
            boolean z2 = z;
            Map destination$iv$iv4 = destination$iv$iv3;
            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                OuroNode it3 = (OuroNode) item$iv$iv2;
                destination$iv$iv5.add(it3.toString());
            }
            destination$iv$iv3.put(key, (List) destination$iv$iv5);
            destination$iv$iv3 = destination$iv$iv4;
            $this$mapValues$iv = $this$mapValues$iv2;
            z = z2;
        }
        Map $this$mapKeys$iv2 = nodeStorage.getParentMap();
        Map destination$iv$iv6 = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv2.size()));
        Iterable $this$associateByTo$iv$iv$iv3 = $this$mapKeys$iv2.entrySet();
        for (Object element$iv$iv$iv3 : $this$associateByTo$iv$iv$iv3) {
            Map.Entry it4 = (Map.Entry) element$iv$iv$iv3;
            Map.Entry it$iv$iv3 = (Map.Entry) element$iv$iv$iv3;
            destination$iv$iv6.put(it4.getKey().toString(), it$iv$iv3.getValue());
        }
        Map destination$iv$iv7 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv6.size()));
        Iterable $this$associateByTo$iv$iv$iv4 = destination$iv$iv6.entrySet();
        for (Object element$iv$iv$iv4 : $this$associateByTo$iv$iv$iv4) {
            Map.Entry it$iv$iv4 = (Map.Entry) element$iv$iv$iv4;
            Map.Entry entry2 = (Map.Entry) element$iv$iv$iv4;
            destination$iv$iv7.put(it$iv$iv4.getKey(), entry2.getValue().toString());
        }
    }

    /* compiled from: SerializableNodeStorage.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u001e\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0007*\u0006\u0012\u0002\b\u00030\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¨\u0006\r"}, d2 = {"Lkntr/common/ouro/core/model/SerializableNodeStorage$Companion;", "", "<init>", "()V", "fromNodeStorage", "Lkntr/common/ouro/core/model/SerializableNodeStorage;", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "localImageState", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "transform", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SerializableNodeStorage> serializer() {
            return SerializableNodeStorage$$serializer.INSTANCE;
        }

        public final SerializableNodeStorage fromNodeStorage(NodeStorage<?> nodeStorage, OuroLocalImageState localImageState) {
            Intrinsics.checkNotNullParameter(nodeStorage, "storage");
            return new SerializableNodeStorage(transform(nodeStorage, localImageState));
        }

        private final NodeStorage<?> transform(NodeStorage<?> nodeStorage, final OuroLocalImageState localImageState) {
            return nodeStorage.mutate$core_debug(false, new Function1() { // from class: kntr.common.ouro.core.model.SerializableNodeStorage$Companion$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit transform$lambda$0;
                    transform$lambda$0 = SerializableNodeStorage.Companion.transform$lambda$0(OuroLocalImageState.this, (NodeStorageBuilder) obj);
                    return transform$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit transform$lambda$0(OuroLocalImageState $localImageState, NodeStorageBuilder $this$mutate) {
            Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
            Iterable $this$filterIsInstance$iv = OuroNodeStorageUtilsKt.getLeavesInSelection$default($this$mutate, null, 1, null);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof OuroLocalImage) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$forEach$iv = (List) destination$iv$iv;
            for (Object element$iv : $this$forEach$iv) {
                OuroLocalImage it = (OuroLocalImage) element$iv;
                UploadTaskState state = $localImageState != null ? $localImageState.getTaskState().get(it.getAsset().getIdentifier()) : null;
                if (state instanceof UploadTaskState.Success) {
                    OuroRemoteImage.Image remoteImage = new OuroRemoteImage.Image(((UploadTaskState.Success) state).getImageUrl(), ((UploadTaskState.Success) state).getImageUrl(), (int) ((UploadTaskState.Success) state).getImageWidth(), (int) ((UploadTaskState.Success) state).getImageHeight(), (String) null, ((UploadTaskState.Success) state).getAIGenMark(), 16, (DefaultConstructorMarker) null);
                    $this$mutate.replace(it, (OuroLocalImage) remoteImage);
                } else {
                    NodeStorageBuilder $this$findFirstAncestorOrNull$iv = $this$mutate;
                    OuroLocalImage node$iv = it;
                    OuroNode.Parent<?> firstAncestorOrNull = node$iv != null ? $this$findFirstAncestorOrNull$iv.firstAncestorOrNull(node$iv, new Function1<OuroNode.Parent<?>, Boolean>() { // from class: kntr.common.ouro.core.model.SerializableNodeStorage$Companion$transform$lambda$0$0$$inlined$findFirstAncestorOrNull$1
                        public final Boolean invoke(OuroNode.Parent<?> parent) {
                            Intrinsics.checkNotNullParameter(parent, "it");
                            return Boolean.valueOf(parent instanceof OuroDrawable);
                        }
                    }) : null;
                    if (!(firstAncestorOrNull instanceof OuroDrawable)) {
                        firstAncestorOrNull = null;
                    }
                    OuroDrawable drawable = (OuroDrawable) firstAncestorOrNull;
                    if (drawable != null) {
                        $this$mutate.removeFromParent(drawable);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final /* synthetic */ <T extends OuroNode.Parent<?>> NodeStorage<T> toNodeStorage() {
        boolean z = false;
        Map $this$mapKeys$iv = getParentMap();
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapKeys$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv$iv;
            OuroNode ouroNode = getNodes().get(entry.getKey());
            if (ouroNode == null) {
                throw new IllegalStateException("Node not found for key: " + entry.getKey());
            }
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv.put(ouroNode, it$iv$iv.getValue());
        }
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv2 = destination$iv$iv.entrySet();
        for (Object element$iv$iv$iv2 : $this$associateByTo$iv$iv$iv2) {
            Map.Entry it$iv$iv2 = (Map.Entry) element$iv$iv$iv2;
            Object key = it$iv$iv2.getKey();
            boolean z2 = z;
            OuroNode ouroNode2 = getNodes().get(((Map.Entry) element$iv$iv$iv2).getValue());
            OuroNode.Parent parent = ouroNode2 instanceof OuroNode.Parent ? (OuroNode.Parent) ouroNode2 : null;
            if (parent == null) {
                throw new IllegalStateException("Parent not found");
            }
            destination$iv$iv2.put(key, parent);
            z = z2;
        }
        Map $this$mapKeys$iv2 = getChildrenMap();
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity($this$mapKeys$iv2.size()));
        Iterable $this$associateByTo$iv$iv$iv3 = $this$mapKeys$iv2.entrySet();
        for (Object element$iv$iv$iv3 : $this$associateByTo$iv$iv$iv3) {
            Map.Entry entry2 = (Map.Entry) element$iv$iv$iv3;
            OuroNode ouroNode3 = getNodes().get(entry2.getKey());
            if (ouroNode3 == null) {
                throw new IllegalStateException("Node not found for key: " + entry2.getKey());
            }
            Map.Entry it$iv$iv3 = (Map.Entry) element$iv$iv$iv3;
            linkedHashMap.put(ouroNode3, it$iv$iv3.getValue());
        }
        Map $this$mapValues$iv = linkedHashMap;
        boolean z3 = false;
        Map destination$iv$iv3 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv4 = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv4 : $this$associateByTo$iv$iv$iv4) {
            Map.Entry it$iv$iv4 = (Map.Entry) element$iv$iv$iv4;
            Object key2 = it$iv$iv4.getKey();
            Iterable $this$map$iv = (Iterable) ((Map.Entry) element$iv$iv$iv4).getValue();
            Map $this$mapValues$iv2 = $this$mapValues$iv;
            boolean z4 = z3;
            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            Iterable $this$mapTo$iv$iv = $this$map$iv;
            for (Object item$iv$iv : $this$mapTo$iv$iv) {
                Iterable $this$mapTo$iv$iv2 = $this$mapTo$iv$iv;
                String childKey = (String) item$iv$iv;
                Map destination$iv$iv5 = destination$iv$iv3;
                OuroNode ouroNode4 = getNodes().get(childKey);
                if (ouroNode4 == null) {
                    throw new IllegalStateException("Node not found for key: " + childKey);
                }
                destination$iv$iv4.add(ouroNode4);
                $this$mapTo$iv$iv = $this$mapTo$iv$iv2;
                destination$iv$iv3 = destination$iv$iv5;
            }
            destination$iv$iv3.put(key2, (List) destination$iv$iv4);
            $this$mapValues$iv = $this$mapValues$iv2;
            z3 = z4;
        }
        OuroNode ouroNode5 = getNodes().get(getRoot());
        Intrinsics.reifiedOperationMarker(2, "T");
        OuroNode.Parent parent2 = (OuroNode.Parent) ouroNode5;
        if (parent2 != null) {
            return new NodeStorage<>(parent2, destination$iv$iv2, destination$iv$iv3);
        }
        throw new IllegalStateException("Root node not found or of incorrect type");
    }

    public final byte[] toByteArray() {
        BinaryFormat $this$encodeToByteArray$iv = SerializationUtilsKt.getOuroProtoBuf();
        $this$encodeToByteArray$iv.getSerializersModule();
        return $this$encodeToByteArray$iv.encodeToByteArray(Companion.serializer(), this);
    }

    public final SerializableNodeStorage fromByteArray(SerializableNodeStorage $this$fromByteArray, byte[] byteArray) {
        Intrinsics.checkNotNullParameter($this$fromByteArray, "<this>");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        BinaryFormat $this$decodeFromByteArray$iv = SerializationUtilsKt.getOuroProtoBuf();
        $this$decodeFromByteArray$iv.getSerializersModule();
        return (SerializableNodeStorage) $this$decodeFromByteArray$iv.decodeFromByteArray(Companion.serializer(), byteArray);
    }
}