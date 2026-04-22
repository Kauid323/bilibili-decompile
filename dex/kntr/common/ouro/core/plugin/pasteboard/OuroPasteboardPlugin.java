package kntr.common.ouro.core.plugin.pasteboard;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.freeletics.flowredux.dsl.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.model.NodeStorage;
import kntr.common.ouro.core.model.NodeStorageBuilder;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.OuroTextRange;
import kntr.common.ouro.core.model.SerializableNodeStorage;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.pasteboard.Pasteboard;
import kntr.common.ouro.core.pasteboard.PasteboardData;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.OuroPluginState;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImagePlugin;
import kntr.common.ouro.core.plugin.localImage.OuroLocalImageState;
import kntr.common.ouro.core.reducer.OuroEditActionReducerKt;
import kntr.common.ouro.core.utils.FlowReduxUtilsKt;
import kntr.common.ouro.core.utils.OuroNodeStorageUtilsKt;
import kntr.common.ouro.core.utils.SerializationUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.BinaryFormat;

/* compiled from: OuroPasteboardPlugin.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rH\u0002J$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001d2\u0006\u0010\u0019\u001a\u00020\u001e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR]\u0010\n\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000b\u0012\u0004\u0012\u00020\u00100\u000bj\u0002`\u0013¢\u0006\u0002\b\u00128VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006#"}, d2 = {"Lkntr/common/ouro/core/plugin/pasteboard/OuroPasteboardPlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/pasteboard/OuroLinkParsingState;", "linkParseService", "Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;", "<init>", "(Lkntr/common/ouro/core/plugin/pasteboard/LinkParseService;)V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/pasteboard/OuroLinkParsingState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "()V", "getSpec", "()Lkotlin/jvm/functions/Function2;", "handleCopyAction", "action", "Lkntr/common/ouro/core/plugin/pasteboard/OuroCopyAction;", "state", "handleCutAction", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/common/ouro/core/plugin/pasteboard/OuroCutAction;", "Lcom/freeletics/flowredux/dsl/State;", "handleCopyImpl", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroPasteboardPlugin implements OuroPlugin<OuroLinkParsingState> {
    private final LinkParseService linkParseService;

    public static /* synthetic */ void getSpec$annotations() {
    }

    public OuroPasteboardPlugin(LinkParseService linkParseService) {
        Intrinsics.checkNotNullParameter(linkParseService, "linkParseService");
        this.linkParseService = linkParseService;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroLinkParsingState getInitState() {
        return new OuroLinkParsingState(null, 1, null);
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$$ExternalSyntheticLambda2
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroPasteboardPlugin._get_spec_$lambda$0(OuroPasteboardPlugin.this, (FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(final OuroPasteboardPlugin this$0, FlowReduxStoreBuilder flowReduxStoreBuilder, final Function2 dispatch) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(dispatch, "dispatch");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroPasteboardPlugin._get_spec_$lambda$0$0(OuroPasteboardPlugin.this, dispatch, (InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(OuroPasteboardPlugin this$0, Function2 $dispatch, InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock this_$iv = (BaseBuilderBlock) $this$inState;
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.ORDERED;
        Function3 handler$iv = new OuroPasteboardPlugin$spec$1$1$1(this$0, null);
        this_$iv.onActionEffect(Reflection.getOrCreateKotlinClass(OuroCopyAction.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock this_$iv2 = (BaseBuilderBlock) $this$inState;
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.ORDERED;
        Function3 handler$iv2 = new OuroPasteboardPlugin$spec$1$1$2(this$0, null);
        this_$iv2.on(Reflection.getOrCreateKotlinClass(OuroCutAction.class), executionPolicy$iv2, handler$iv2);
        BaseBuilderBlock this_$iv3 = (BaseBuilderBlock) $this$inState;
        ExecutionPolicy executionPolicy$iv3 = ExecutionPolicy.ORDERED;
        Function3 handler$iv3 = new OuroPasteboardPlugin$spec$1$1$3(this$0, $dispatch, null);
        this_$iv3.on(Reflection.getOrCreateKotlinClass(OuroPasteAction.class), executionPolicy$iv3, handler$iv3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCopyAction(OuroCopyAction action, OuroState state) {
        OuroSelection selection;
        OuroTextRange it = action.getRange();
        if (it == null || (selection = state.getSelection(it)) == null) {
            selection = state.getSelection();
        }
        handleCopyImpl(state, selection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChangedState<OuroState> handleCutAction(final OuroCutAction action, State<OuroState> state) {
        return FlowReduxUtilsKt.mutate(state, action.getDeferred(), new Function1() { // from class: kntr.common.ouro.core.plugin.pasteboard.OuroPasteboardPlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                OuroState handleCutAction$lambda$0;
                handleCutAction$lambda$0 = OuroPasteboardPlugin.handleCutAction$lambda$0(OuroPasteboardPlugin.this, action, (OuroState) obj);
                return handleCutAction$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OuroState handleCutAction$lambda$0(OuroPasteboardPlugin this$0, OuroCutAction $action, OuroState $this$mutate) {
        OuroSelection selection;
        Intrinsics.checkNotNullParameter($this$mutate, "$this$mutate");
        OuroTextRange it = $action.getRange();
        if (it == null || (selection = $this$mutate.getSelection(it)) == null) {
            selection = $this$mutate.getSelection();
        }
        this$0.handleCopyImpl($this$mutate, selection);
        OuroTextRange range = $action.getRange();
        if (range == null) {
            range = $this$mutate.getTextRange();
        }
        return OuroEditActionReducerKt.handleDeleteImpl($this$mutate, range, null);
    }

    private final void handleCopyImpl(OuroState state, OuroSelection selection) {
        NodeStorage storage = state.getStorage();
        NodeStorageBuilder it = OuroNodeStorageUtilsKt.subdocument(storage, selection);
        if (it != null) {
            OuroNodeStorageUtilsKt.deleteSingleStructurePath(it);
            NodeStorage subdocument = it.build(false);
            Iterable $this$filterIsInstance$iv = OuroNodeStorageUtilsKt.getLeavesInSelection$default(subdocument, null, 1, null);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof OuroNode.Copyable) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable $this$fold$iv = (List) destination$iv$iv;
            String str = "";
            for (Object element$iv : $this$fold$iv) {
                OuroNode.Copyable copyable = (OuroNode.Copyable) element$iv;
                String acc = str;
                str = acc + copyable.getCopyText();
            }
            String text = str;
            try {
                SerializableNodeStorage.Companion companion = SerializableNodeStorage.Companion;
                KClass key$iv = Reflection.getOrCreateKotlinClass(OuroLocalImagePlugin.class);
                OuroPluginState ouroPluginState = state.getPluginStates().get(key$iv);
                SerializableNodeStorage serializable = companion.fromNodeStorage(subdocument, (OuroLocalImageState) (!(ouroPluginState instanceof OuroLocalImageState) ? null : ouroPluginState));
                BinaryFormat $this$encodeToByteArray$iv = SerializationUtilsKt.getOuroProtoBuf();
                $this$encodeToByteArray$iv.getSerializersModule();
                byte[] bytes = $this$encodeToByteArray$iv.encodeToByteArray(SerializableNodeStorage.Companion.serializer(), serializable);
                Pasteboard.INSTANCE.setData(new PasteboardData(text, bytes));
            } catch (Exception e) {
                KLog_androidKt.getKLog().w("OuroPasteboardPlugin", "copy to pasteboard failed: " + e);
            }
        }
    }
}