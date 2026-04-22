package kntr.common.ouro.core.plugin.remoteImage;

import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.OuroState;
import kntr.common.ouro.core.action.OuroAction;
import kntr.common.ouro.core.plugin.OuroPlugin;
import kntr.common.ouro.core.plugin.remoteImage.OuroRemoteImageAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: OuroRemoteImagePlugin.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R]\u0010\b\u001aE\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012 \u0012\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t\u0012\u0004\u0012\u00020\u000e0\tj\u0002`\u0011¢\u0006\u0002\b\u00108VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImagePlugin;", "Lkntr/common/ouro/core/plugin/OuroPlugin;", "Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageState;", "<init>", "()V", "initState", "getInitState", "()Lkntr/common/ouro/core/plugin/remoteImage/OuroRemoteImageState;", "spec", "Lkotlin/Function2;", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lkntr/common/ouro/core/OuroState;", "Lkntr/common/ouro/core/action/OuroAction;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/plugin/OuroPluginSpec;", "getSpec$annotations", "getSpec", "()Lkotlin/jvm/functions/Function2;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroRemoteImagePlugin implements OuroPlugin<OuroRemoteImageState> {
    public static final OuroRemoteImagePlugin INSTANCE = new OuroRemoteImagePlugin();

    public static /* synthetic */ void getSpec$annotations() {
    }

    private OuroRemoteImagePlugin() {
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public OuroRemoteImageState getInitState() {
        return OuroRemoteImageState.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0(FlowReduxStoreBuilder flowReduxStoreBuilder, Function2 it) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1 block$iv = new Function1() { // from class: kntr.common.ouro.core.plugin.remoteImage.OuroRemoteImagePlugin$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit _get_spec_$lambda$0$0;
                _get_spec_$lambda$0$0 = OuroRemoteImagePlugin._get_spec_$lambda$0$0((InStateBuilderBlock) obj);
                return _get_spec_$lambda$0$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(OuroState.class), block$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _get_spec_$lambda$0$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new OuroRemoteImagePlugin$spec$1$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.on(Reflection.getOrCreateKotlinClass(OuroRemoteImageAction.InsertInlineImage.class), executionPolicy$iv, handler$iv);
        BaseBuilderBlock $this$iv2 = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv2 = new OuroRemoteImagePlugin$spec$1$1$2(null);
        ExecutionPolicy executionPolicy$iv2 = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv2.on(Reflection.getOrCreateKotlinClass(OuroRemoteImageAction.InsertBlockImage.class), executionPolicy$iv2, handler$iv2);
        return Unit.INSTANCE;
    }

    @Override // kntr.common.ouro.core.plugin.OuroPlugin
    public Function2<FlowReduxStoreBuilder<OuroState, OuroAction>, Function2<? super OuroAction, ? super Continuation<? super Unit>, ? extends Object>, Unit> getSpec() {
        return new Function2() { // from class: kntr.common.ouro.core.plugin.remoteImage.OuroRemoteImagePlugin$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2) {
                Unit _get_spec_$lambda$0;
                _get_spec_$lambda$0 = OuroRemoteImagePlugin._get_spec_$lambda$0((FlowReduxStoreBuilder) obj, (Function2) obj2);
                return _get_spec_$lambda$0;
            }
        };
    }
}