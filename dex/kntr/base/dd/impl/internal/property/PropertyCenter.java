package kntr.base.dd.impl.internal.property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.impl.internal.common.AtomicMutableMap;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.data.CoreDataType;
import kntr.base.dd.impl.internal.data.ICoreData;
import kntr.base.dd.impl.internal.data.IDataCenter;
import kntr.base.dd.impl.internal.model.DDProp;
import kntr.base.utils.CoroutineExKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: PropertyCenter.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0007H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0016\u0010)\u001a\u00020\u001c2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u0016H\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00061"}, d2 = {"Lkntr/base/dd/impl/internal/property/PropertyCenter;", "Lkntr/base/dd/impl/internal/property/IPropertyCenter;", "observablePropList", "", "", "defaultNodes", "", "Lkntr/base/dd/IDeviceDecisionProperty$Node;", "dataCenter", "Lkntr/base/dd/impl/internal/data/IDataCenter;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Ljava/util/Set;Ljava/util/List;Lkntr/base/dd/impl/internal/data/IDataCenter;Lkotlinx/coroutines/CoroutineScope;)V", "cache", "Lkntr/base/dd/impl/internal/common/AtomicMutableMap;", "_cacheableProps", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "updateCacheLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "properties", "Lkntr/base/dd/impl/internal/property/PropertyNode;", "cacheableProps", "Lkotlinx/coroutines/flow/SharedFlow;", "getCacheableProps", "()Lkotlinx/coroutines/flow/SharedFlow;", "addPropNodes", "", "nodes", "get", "name", "extra", "getAllPropNames", "isCacheableProp", "", "prop", "onPropertyUpdated", "add", "node", "getPropertyForName", "refreshLocalProps", "names", "updatePropCacheValue", "getMockProp", "Lkntr/base/dd/impl/internal/model/DDProp;", "localProps", "getLocalProps", "()Ljava/util/List;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PropertyCenter implements IPropertyCenter {
    private final MutableSharedFlow<String> _cacheableProps;
    private final AtomicMutableMap<String, String> cache;
    private final IDataCenter dataCenter;
    private final CoroutineScope ioScope;
    private final Set<String> observablePropList;
    private final AtomicMutableMap<String, PropertyNode> properties;
    private final ReentrantLock updateCacheLock;

    public PropertyCenter(Set<String> set, List<? extends IDeviceDecisionProperty.Node> list, IDataCenter dataCenter, CoroutineScope ioScope) {
        Intrinsics.checkNotNullParameter(set, "observablePropList");
        Intrinsics.checkNotNullParameter(dataCenter, "dataCenter");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        this.observablePropList = set;
        this.dataCenter = dataCenter;
        this.ioScope = ioScope;
        this.cache = new AtomicMutableMap<>();
        this._cacheableProps = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 6, (Object) null);
        this.updateCacheLock = new ReentrantLock();
        this.properties = new AtomicMutableMap<>();
        Iterable $this$forEach$iv = getLocalProps();
        for (Object element$iv : $this$forEach$iv) {
            PropertyNode it = (PropertyNode) element$iv;
            this.properties.put(it.getName(), it);
        }
        addPropNodes(list == null ? CollectionsKt.emptyList() : list);
        BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass2(null), 3, (Object) null);
    }

    public /* synthetic */ PropertyCenter(Set set, List list, IDataCenter iDataCenter, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(set, list, iDataCenter, (i & 8) != 0 ? CoroutineExKt.createIOScope() : coroutineScope);
    }

    /* compiled from: PropertyCenter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.dd.impl.internal.property.PropertyCenter$2", f = "PropertyCenter.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.dd.impl.internal.property.PropertyCenter$2  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<Set<String>> props = PropertyCenter.this.dataCenter.getFlow().getProps();
                    final PropertyCenter propertyCenter = PropertyCenter.this;
                    this.label = 1;
                    if (props.collect(new FlowCollector() { // from class: kntr.base.dd.impl.internal.property.PropertyCenter.2.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Set) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Set<String> set, Continuation<? super Unit> continuation) {
                            PropertyCenter.this.refreshLocalProps(set);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kntr.base.dd.impl.internal.property.IPropertyCenter
    public SharedFlow<String> getCacheableProps() {
        return FlowKt.asSharedFlow(this._cacheableProps);
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty
    public void addPropNodes(List<? extends IDeviceDecisionProperty.Node> list) {
        Intrinsics.checkNotNullParameter(list, "nodes");
        List<? extends IDeviceDecisionProperty.Node> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            IDeviceDecisionProperty.Node it = (IDeviceDecisionProperty.Node) element$iv;
            add(it);
        }
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty
    public String get(String name, String extra) {
        Intrinsics.checkNotNullParameter(name, "name");
        DDProp mockProp = getMockProp(name);
        if (mockProp != null) {
            return mockProp.getDefault();
        }
        boolean isCacheable = isCacheableProp(name);
        if (isCacheable && this.cache.contains(name)) {
            return this.cache.get(name);
        }
        PropertyNode node = getPropertyForName(name);
        if (node != null) {
            String it = node.getValue(extra);
            if (isCacheable) {
                this.cache.put(name, it);
            }
            if (node.isTrackable()) {
                DDConst dDConst = DDConst.INSTANCE;
                Pair[] pairArr = new Pair[2];
                pairArr[0] = TuplesKt.to("n", name);
                pairArr[1] = TuplesKt.to("v", it == null ? "" : it);
                dDConst.trackT("public.dd.property.track", MapsKt.mapOf(pairArr));
                return it;
            }
            return it;
        }
        return null;
    }

    @Override // kntr.base.dd.impl.internal.property.IPropertyCenter
    public List<String> getAllPropNames() {
        return CollectionsKt.toList(this.properties.getKeys());
    }

    @Override // kntr.base.dd.impl.internal.property.IPropertyCenter
    public boolean isCacheableProp(String name) {
        PropertyNode it;
        if (name == null || (it = this.properties.get(name)) == null) {
            return false;
        }
        return isCacheableProp(it);
    }

    private final boolean isCacheableProp(PropertyNode prop) {
        return prop.isCacheable() || this.observablePropList.contains(prop.getName());
    }

    @Override // kntr.base.dd.IDeviceDecisionProperty
    public void onPropertyUpdated(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new PropertyCenter$onPropertyUpdated$1(this, name, null), 3, (Object) null);
    }

    private final void add(IDeviceDecisionProperty.Node node) {
        String name = node.getName();
        PropertyNode oldNode = this.properties.get(name);
        if (oldNode != null) {
            if (oldNode.updateNode(node)) {
                onPropertyUpdated(name);
                return;
            }
            return;
        }
        this.properties.put(name, new PropertyNode(null, node, 1, null));
        onPropertyUpdated(name);
    }

    private final PropertyNode getPropertyForName(String name) {
        DDProp it = this.dataCenter.dataWithType(CoreDataType.MOCK).prop(name);
        if (it != null) {
            return new PropertyNode(it, null, 2, null);
        }
        return this.properties.get(name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshLocalProps(Set<String> set) {
        ICoreData currentData = this.dataCenter.currentData();
        Set<String> $this$forEach$iv = set;
        for (Object element$iv : $this$forEach$iv) {
            String name = (String) element$iv;
            DDProp prop = currentData.prop(name);
            PropertyNode oldNode = this.properties.get(name);
            if (oldNode != null) {
                if (oldNode.updateProp(prop)) {
                    updatePropCacheValue(oldNode);
                }
            } else if (prop != null) {
                PropertyNode newNode = new PropertyNode(prop, null, 2, null);
                this.properties.put(name, newNode);
                updatePropCacheValue(newNode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePropCacheValue(PropertyNode node) {
        String newV;
        ReentrantLock $this$with$iv = this.updateCacheLock;
        $this$with$iv.lock();
        try {
            String name = node.getName();
            boolean needNotify = true;
            if (!isCacheableProp(node)) {
                this.cache.remove(name);
            } else {
                String oldV = this.cache.get(name);
                DDProp mockProp = getMockProp(name);
                if (mockProp == null || (newV = mockProp.getDefault()) == null) {
                    newV = node.getValue(null);
                }
                if (!Intrinsics.areEqual(oldV, newV)) {
                    this.cache.put(node.getName(), newV);
                    DDConst.INSTANCE.logI("DDPropertyCenter didUpdatePropCacheValue(" + name + ", " + (newV == null ? "<nil>" : newV) + "))");
                } else {
                    needNotify = false;
                }
            }
            if (needNotify) {
                BuildersKt.launch$default(this.ioScope, (CoroutineContext) null, (CoroutineStart) null, new PropertyCenter$updatePropCacheValue$1$1(this, name, null), 3, (Object) null);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }

    private final DDProp getMockProp(String name) {
        return this.dataCenter.dataWithType(CoreDataType.MOCK).prop(name);
    }

    private final List<PropertyNode> getLocalProps() {
        ICoreData currentData;
        Iterable $this$mapNotNull$iv;
        ICoreData currentData2 = this.dataCenter.currentData();
        Iterable $this$mapNotNull$iv2 = currentData2.propKeys();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv2) {
            String key = (String) element$iv$iv$iv;
            DDProp it = currentData2.prop(key);
            PropertyNode propertyNode = null;
            if (it != null) {
                currentData = currentData2;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
                propertyNode = new PropertyNode(it, null, 2, null);
            } else {
                currentData = currentData2;
                $this$mapNotNull$iv = $this$mapNotNull$iv2;
            }
            if (propertyNode != null) {
                destination$iv$iv.add(propertyNode);
            }
            currentData2 = currentData;
            $this$mapNotNull$iv2 = $this$mapNotNull$iv;
        }
        return (List) destination$iv$iv;
    }
}