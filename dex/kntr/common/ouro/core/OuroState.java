package kntr.common.ouro.core;

import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroSelectionKt;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.OuroTextRangeKt;
import kntr.common.ouro.core.model.node.OuroDocument;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.datetime.Clock;
import kotlinx.datetime.Instant;

/* compiled from: OuroState.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00124\u0010\b\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0011¢\u0006\u0002\b\u0010\u0012 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\u0004\b\u0017\u0010\u0018B_\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00124\u0010\b\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0011¢\u0006\u0002\b\u0010¢\u0006\u0004\b\u0017\u0010\u0019J8\u0010#\u001a\u00020\u0000\"\n\b\u0000\u0010$\u0018\u0001*\u00020\u00162\u0006\u0010%\u001a\u0002H$2\u0014\u0010&\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0\u00150\u0014H\u0086\b¢\u0006\u0002\u0010'J0\u0010%\u001a\u0002H$\"\n\b\u0000\u0010$\u0018\u0001*\u00020\u00162\u0014\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0\u00150\u0014H\u0086\b¢\u0006\u0002\u0010)J2\u0010*\u001a\u0004\u0018\u0001H$\"\n\b\u0000\u0010$\u0018\u0001*\u00020\u00162\u0014\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H$0\u00150\u0014H\u0086\b¢\u0006\u0002\u0010)J\u000e\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003J7\u0010;\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0011¢\u0006\u0002\b\u0010HÆ\u0003J!\u0010<\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013HÆ\u0003J\u0089\u0001\u0010#\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000626\b\u0002\u0010\b\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0011¢\u0006\u0002\b\u00102 \b\u0002\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u000fHÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR?\u0010\b\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\tj\u0002`\u0011¢\u0006\u0002\b\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R)\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010+\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001b\u0010.\u001a\u00020/8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0011\u00104\u001a\u000205¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006C"}, d2 = {"Lkntr/common/ouro/core/OuroState;", "", "storage", "Lkntr/common/ouro/core/model/NodeStorage;", "Lkntr/common/ouro/core/model/node/OuroDocument;", "textRange", "Lkntr/common/ouro/core/model/OuroTextRange;", "compositionRange", "displayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "pluginStates", "", "Lkotlin/reflect/KClass;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/OuroPluginState;", "<init>", "(Lkntr/common/ouro/core/model/NodeStorage;Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlin/jvm/functions/Function2;Ljava/util/Map;)V", "(Lkntr/common/ouro/core/model/NodeStorage;Lkntr/common/ouro/core/model/OuroTextRange;Lkntr/common/ouro/core/model/OuroTextRange;Lkotlin/jvm/functions/Function2;)V", "getStorage", "()Lkntr/common/ouro/core/model/NodeStorage;", "getTextRange", "()Lkntr/common/ouro/core/model/OuroTextRange;", "getCompositionRange", "getDisplayLengthTransform", "()Lkotlin/jvm/functions/Function2;", "getPluginStates", "()Ljava/util/Map;", "copy", "STATE", "pluginState", "forKey", "(Lkntr/common/ouro/core/plugin/OuroPluginState;Lkotlin/reflect/KClass;)Lkntr/common/ouro/core/OuroState;", "key", "(Lkotlin/reflect/KClass;)Lkntr/common/ouro/core/plugin/OuroPluginState;", "pluginStateOrNull", "storageHash", "getStorageHash", "()I", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "getSelection", "()Lkntr/common/ouro/core/model/OuroSelection;", "selection$delegate", "Lkotlin/Lazy;", "timestamp", "Lkotlinx/datetime/Instant;", "getTimestamp", "()Lkotlinx/datetime/Instant;", "component1", "component2", "component3", "component4", "component5", "equals", "", "other", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroState {
    private final OuroTextRange compositionRange;
    private final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> displayLengthTransform;
    private final Map<KClass<? extends OuroPlugin<?>>, OuroPluginState> pluginStates;
    private final Lazy selection$delegate;
    private final NodeStorage<OuroDocument> storage;
    private final OuroTextRange textRange;
    private final Instant timestamp;

    public static /* synthetic */ OuroState copy$default(OuroState ouroState, NodeStorage nodeStorage, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, Function2 function2, Map map, int i, Object obj) {
        NodeStorage<OuroDocument> nodeStorage2 = nodeStorage;
        if ((i & 1) != 0) {
            nodeStorage2 = ouroState.storage;
        }
        if ((i & 2) != 0) {
            ouroTextRange = ouroState.textRange;
        }
        OuroTextRange ouroTextRange3 = ouroTextRange;
        if ((i & 4) != 0) {
            ouroTextRange2 = ouroState.compositionRange;
        }
        OuroTextRange ouroTextRange4 = ouroTextRange2;
        Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> function22 = function2;
        if ((i & 8) != 0) {
            function22 = ouroState.displayLengthTransform;
        }
        Function2 function23 = function22;
        Map<KClass<? extends OuroPlugin<?>>, OuroPluginState> map2 = map;
        if ((i & 16) != 0) {
            map2 = ouroState.pluginStates;
        }
        return ouroState.copy(nodeStorage2, ouroTextRange3, ouroTextRange4, function23, map2);
    }

    public final NodeStorage<OuroDocument> component1() {
        return this.storage;
    }

    public final OuroTextRange component2() {
        return this.textRange;
    }

    public final OuroTextRange component3() {
        return this.compositionRange;
    }

    public final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> component4() {
        return this.displayLengthTransform;
    }

    public final Map<KClass<? extends OuroPlugin<?>>, OuroPluginState> component5() {
        return this.pluginStates;
    }

    public final OuroState copy(NodeStorage<OuroDocument> nodeStorage, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2, Map<KClass<? extends OuroPlugin<?>>, ? extends OuroPluginState> map) {
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        Intrinsics.checkNotNullParameter(ouroTextRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        Intrinsics.checkNotNullParameter(map, "pluginStates");
        return new OuroState(nodeStorage, ouroTextRange, ouroTextRange2, function2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroState) {
            OuroState ouroState = (OuroState) obj;
            return Intrinsics.areEqual(this.storage, ouroState.storage) && Intrinsics.areEqual(this.textRange, ouroState.textRange) && Intrinsics.areEqual(this.compositionRange, ouroState.compositionRange) && Intrinsics.areEqual(this.displayLengthTransform, ouroState.displayLengthTransform) && Intrinsics.areEqual(this.pluginStates, ouroState.pluginStates);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.storage.hashCode() * 31) + this.textRange.hashCode()) * 31) + (this.compositionRange == null ? 0 : this.compositionRange.hashCode())) * 31) + this.displayLengthTransform.hashCode()) * 31) + this.pluginStates.hashCode();
    }

    public String toString() {
        NodeStorage<OuroDocument> nodeStorage = this.storage;
        OuroTextRange ouroTextRange = this.textRange;
        OuroTextRange ouroTextRange2 = this.compositionRange;
        Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> function2 = this.displayLengthTransform;
        return "OuroState(storage=" + nodeStorage + ", textRange=" + ouroTextRange + ", compositionRange=" + ouroTextRange2 + ", displayLengthTransform=" + function2 + ", pluginStates=" + this.pluginStates + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroState(NodeStorage<OuroDocument> nodeStorage, OuroTextRange textRange, OuroTextRange compositionRange, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2, Map<KClass<? extends OuroPlugin<?>>, ? extends OuroPluginState> map) {
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        Intrinsics.checkNotNullParameter(map, "pluginStates");
        this.storage = nodeStorage;
        this.textRange = textRange;
        this.compositionRange = compositionRange;
        this.displayLengthTransform = function2;
        this.pluginStates = map;
        this.selection$delegate = LazyKt.lazy(new Function0() { // from class: kntr.common.ouro.core.OuroState$$ExternalSyntheticLambda0
            public final Object invoke() {
                OuroSelection selection_delegate$lambda$0;
                selection_delegate$lambda$0 = OuroState.selection_delegate$lambda$0(OuroState.this);
                return selection_delegate$lambda$0;
            }
        });
        this.timestamp = Clock.System.INSTANCE.now();
    }

    public /* synthetic */ OuroState(NodeStorage nodeStorage, OuroTextRange ouroTextRange, OuroTextRange ouroTextRange2, Function2 function2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nodeStorage, (i & 2) != 0 ? new OuroTextRange(0, 0) : ouroTextRange, (i & 4) != 0 ? null : ouroTextRange2, function2, (i & 16) != 0 ? MapsKt.emptyMap() : map);
    }

    public final NodeStorage<OuroDocument> getStorage() {
        return this.storage;
    }

    public final OuroTextRange getTextRange() {
        return this.textRange;
    }

    public final OuroTextRange getCompositionRange() {
        return this.compositionRange;
    }

    public final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> getDisplayLengthTransform() {
        return this.displayLengthTransform;
    }

    public final Map<KClass<? extends OuroPlugin<?>>, OuroPluginState> getPluginStates() {
        return this.pluginStates;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroState(NodeStorage<OuroDocument> nodeStorage, OuroTextRange textRange, OuroTextRange compositionRange, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        this(nodeStorage, textRange, compositionRange, function2, MapsKt.emptyMap());
        Intrinsics.checkNotNullParameter(nodeStorage, "storage");
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
    }

    public final /* synthetic */ <STATE extends OuroPluginState> OuroState copy(STATE state, KClass<? extends OuroPlugin<STATE>> kClass) {
        Intrinsics.checkNotNullParameter(state, "pluginState");
        Intrinsics.checkNotNullParameter(kClass, "forKey");
        Map newPluginStates = MapsKt.toMutableMap(getPluginStates());
        newPluginStates.put(kClass, state);
        return copy$default(this, null, null, null, null, MapsKt.toMap(newPluginStates), 15, null);
    }

    public final /* synthetic */ <STATE extends OuroPluginState> STATE pluginState(KClass<? extends OuroPlugin<STATE>> kClass) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(kClass, "key");
        OuroPluginState ouroPluginState = getPluginStates().get(kClass);
        Intrinsics.reifiedOperationMarker(2, "STATE");
        STATE state = (STATE) ouroPluginState;
        if (state != null) {
            return state;
        }
        throw new NoSuchElementException("No plugin state for " + kClass);
    }

    public final /* synthetic */ <STATE extends OuroPluginState> STATE pluginStateOrNull(KClass<? extends OuroPlugin<STATE>> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        OuroPluginState ouroPluginState = getPluginStates().get(kClass);
        Intrinsics.reifiedOperationMarker(2, "STATE");
        return (STATE) ouroPluginState;
    }

    public final int getStorageHash() {
        return this.storage.hashCode();
    }

    public final OuroSelection getSelection() {
        return (OuroSelection) this.selection$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroSelection selection_delegate$lambda$0(OuroState this$0) {
        return OuroSelectionKt.getSelection(this$0.storage, this$0.textRange, this$0.displayLengthTransform);
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public final OuroSelection getSelection(OuroTextRange textRange) {
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        return OuroSelectionKt.getSelection(this.storage, textRange, this.displayLengthTransform);
    }

    public final OuroTextRange getTextRange(OuroSelection selection) {
        Intrinsics.checkNotNullParameter(selection, "selection");
        return OuroTextRangeKt.getTextRange(this.storage, selection, this.displayLengthTransform);
    }
}