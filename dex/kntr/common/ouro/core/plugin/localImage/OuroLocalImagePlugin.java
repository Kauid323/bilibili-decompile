package kntr.common.ouro.core.plugin.localImage;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import com.freeletics.mad.statemachine.StateMachine;
import java.util.Map;
import java.util.NoSuchElementException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageAction;
import kntr.common.ouro.core.plugin.localImage.UploadImageChildAction;
import kntr.common.paragraph.assetuploader.AssetUploader;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: OuroLocalImagePlugin.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\u00020\u000fH\u0002J\u0014\u0010\u001b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u0002H\u0002J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0 2\u0006\u0010!\u001a\u00020\"H\u0002J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR]\u0010\f\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00130\r\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u0015¢\u0006\u0002\b\u00148VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006+"}, d2 = {"Lkntr/common/ouro/core/plugin/localImage/OuroLocalImagePlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "uploader", "Lkntr/common/paragraph/assetuploader/AssetUploader;", "<init>", "(Lkntr/common/paragraph/assetuploader/AssetUploader;)V", "getUploader", "()Lkntr/common/paragraph/assetuploader/AssetUploader;", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/localImage/OuroLocalImageState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "()V", "getSpec", "()Lkotlin/jvm/functions/Function2;", "currentState", "copy", "newState", "childStateMapper", "Lcom/freeletics/flowredux/dsl/ChangedState;", "parentState", "Lcom/freeletics/flowredux/dsl/State;", "childState", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "component1", "equals", "", "other", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroLocalImagePlugin implements OuroPlugin<OuroLocalImageState> {
    private final AssetUploader uploader;

    public static /* synthetic */ OuroLocalImagePlugin copy$default(OuroLocalImagePlugin ouroLocalImagePlugin, AssetUploader assetUploader, int i, Object obj) {
        if ((i & 1) != 0) {
            assetUploader = ouroLocalImagePlugin.uploader;
        }
        return ouroLocalImagePlugin.copy(assetUploader);
    }

    public static /* synthetic */ void getSpec$annotations() {
    }

    public final AssetUploader component1() {
        return this.uploader;
    }

    public final OuroLocalImagePlugin copy(AssetUploader assetUploader) {
        Intrinsics.checkNotNullParameter(assetUploader, "uploader");
        return new OuroLocalImagePlugin(assetUploader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OuroLocalImagePlugin) && Intrinsics.areEqual(this.uploader, ((OuroLocalImagePlugin) obj).uploader);
    }

    public int hashCode() {
        return this.uploader.hashCode();
    }

    public String toString() {
        return "OuroLocalImagePlugin(uploader=" + this.uploader + ")";
    }

    public OuroLocalImagePlugin(AssetUploader uploader) {
        Intrinsics.checkNotNullParameter(uploader, "uploader");
        this.uploader = uploader;
    }

    public final AssetUploader getUploader() {
        return this.uploader;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroLocalImageState getInitState() {
        return new OuroLocalImageState(null, 1, null);
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroLocalImagePlugin._get_spec_$lambda$0(OuroLocalImagePlugin.this, (FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(final OuroLocalImagePlugin this$0, FlowReduxStoreBuilder flowReduxStoreBuilder, final Function2 dispatch) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(dispatch, "dispatch");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroLocalImagePlugin._get_spec_$lambda$0$0(OuroLocalImagePlugin.this, dispatch, (InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(final OuroLocalImagePlugin this$0, Function2 $dispatch, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OuroLocalImagePlugin$spec$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroLocalImageAction.InsertBlockImage.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OuroLocalImagePlugin$spec$1$1$2(this$0, $dispatch, null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.onActionEffect(Reflection.getOrCreateKotlinClass(OuroLocalImageAction.InsertBlockImage.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) $this$inState;
        Function2 stateMachineFactory$iv = new Function2() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                StateMachine _get_spec_$lambda$0$0$0;
                _get_spec_$lambda$0$0$0 = OuroLocalImagePlugin._get_spec_$lambda$0$0$0(OuroLocalImagePlugin.this, (OuroLocalImageAction.StartUploadImage) obj, (OuroState) obj2);
                return _get_spec_$lambda$0$0$0;
            }
        };
        Function1 actionMapper$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                UploadImageChildAction _get_spec_$lambda$0$0$1;
                _get_spec_$lambda$0$0$1 = OuroLocalImagePlugin._get_spec_$lambda$0$0$1((OuroAction) obj);
                return _get_spec_$lambda$0$0$1;
            }
        };
        Function2 stateMapper$iv = new Function2() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                ChangedState _get_spec_$lambda$0$0$2;
                _get_spec_$lambda$0$0$2 = OuroLocalImagePlugin._get_spec_$lambda$0$0$2(OuroLocalImagePlugin.this, (State) obj, (UploadTaskState) obj2);
                return _get_spec_$lambda$0$0$2;
            }
        };
        this_$iv.onActionStartStateMachine(Reflection.getOrCreateKotlinClass(OuroLocalImageAction.StartUploadImage.class), stateMachineFactory$iv, actionMapper$iv, stateMapper$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateMachine _get_spec_$lambda$0$0$0(OuroLocalImagePlugin this$0, OuroLocalImageAction.StartUploadImage action, OuroState state) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Asset asset = action.getAsset();
        boolean useOriginalImage = action.getUseOriginalImage();
        AssetUploader assetUploader = this$0.uploader;
        OuroLocalImageState currentState = this$0.currentState(state);
        return new UploadImageChildStateMachine(asset, useOriginalImage, assetUploader, currentState != null ? currentState.getTaskState().get(action.getAsset().getIdentifier()) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChangedState _get_spec_$lambda$0$0$2(OuroLocalImagePlugin this$0, State parentState, UploadTaskState childState) {
        Intrinsics.checkNotNullParameter(parentState, "parentState");
        Intrinsics.checkNotNullParameter(childState, "childState");
        return this$0.childStateMapper(parentState, childState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UploadImageChildAction _get_spec_$lambda$0$0$1(OuroAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action instanceof OuroLocalImageAction.RetryUploadImage ? new UploadImageChildAction.Retry(((OuroLocalImageAction.RetryUploadImage) action).getIdentifier()) : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OuroLocalImageState currentState(OuroState $this$currentState) {
        KClass key$iv = Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class);
        OuroPluginState ouroPluginState = $this$currentState.getPluginStates().get(key$iv);
        if (!(ouroPluginState instanceof OuroLocalImageState)) {
            ouroPluginState = null;
        }
        OuroLocalImageState ouroLocalImageState = (OuroLocalImageState) ouroPluginState;
        if (ouroLocalImageState != null) {
            return ouroLocalImageState;
        }
        throw new NoSuchElementException("No plugin state for " + key$iv);
    }

    private final OuroState copy(OuroState $this$copy, OuroLocalImageState newState) {
        KClass forKey$iv = Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class);
        Map newPluginStates$iv = MapsKt.toMutableMap($this$copy.getPluginStates());
        newPluginStates$iv.put(forKey$iv, newState);
        return OuroState.copy$default($this$copy, null, null, null, null, MapsKt.toMap(newPluginStates$iv), 15, null);
    }

    private final ChangedState<OuroState> childStateMapper(State<OuroState> state, final UploadTaskState childState) {
        return state.mutate(new Function1() { // from class: kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                OuroState childStateMapper$lambda$0;
                childStateMapper$lambda$0 = OuroLocalImagePlugin.childStateMapper$lambda$0(OuroLocalImagePlugin.this, childState, (OuroState) obj);
                return childStateMapper$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState childStateMapper$lambda$0(OuroLocalImagePlugin this$0, UploadTaskState $childState, OuroState $this$mutate) {
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroLocalImageState currentState = this$0.currentState($this$mutate);
        if (currentState == null) {
            return $this$mutate;
        }
        Map taskState = MapsKt.toMutableMap(currentState.getTaskState());
        taskState.put($childState.getIdentifier(), $childState);
        return this$0.copy($this$mutate, currentState.copy(MapsKt.toMap(taskState)));
    }
}