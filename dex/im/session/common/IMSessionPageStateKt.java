package im.session.common;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.bilibili.lib.brouter.uri.Uri;
import im.session.IMSessionViewModel;
import im.session.IMState;
import kntr.base.router.Router;
import kntr.common.compose.list.LoadMoreListStateKt;
import kntr.common.router.RouterKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001a\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086B¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"rememberSessionPageState", "Lim/session/common/IMSessionPageState;", "viewModel", "Lim/session/IMSessionViewModel;", "(Lim/session/IMSessionViewModel;Landroidx/compose/runtime/Composer;I)Lim/session/common/IMSessionPageState;", "configListState", "", "(Lim/session/common/IMSessionPageState;Landroidx/compose/runtime/Composer;I)V", "invoke", "Lim/session/common/IMSessionRouteHandler;", "url", "", "(Lim/session/common/IMSessionRouteHandler;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageStateKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit configListState$lambda$3(IMSessionPageState iMSessionPageState, int i2, Composer composer, int i3) {
        configListState(iMSessionPageState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final IMSessionPageState rememberSessionPageState(IMSessionViewModel viewModel, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ComposerKt.sourceInformationMarkerStart($composer, -941173310, "C(rememberSessionPageState)N(viewModel)51@1953L63,55@2049L16,57@2100L71,60@2208L20,62@2255L175,62@2234L196,69@2463L7,71@2512L7,72@2550L124,72@2524L150,78@2701L97,78@2680L118,83@2827L7,84@2846L319:IMSessionPageState.kt#yqxgzx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-941173310, $changed, -1, "im.session.common.rememberSessionPageState (IMSessionPageState.kt:49)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1770552737, "CC(remember):IMSessionPageState.kt#9igjgp");
        boolean invalid$iv = $composer.changed(viewModel);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (KFunction) new IMSessionPageStateKt$rememberSessionPageState$onAction$1$1(viewModel);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Function1 onAction = (KFunction) it$iv;
        State page = SnapshotStateKt.collectAsState(viewModel.getState(), (CoroutineContext) null, $composer, 0, 1);
        ComposerKt.sourceInformationMarkerStart($composer, 1770557449, "CC(remember):IMSessionPageState.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        State state = (MutableState) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        State alert = SnapshotStateKt.collectAsState(viewModel.getAlertFlow(), (Object) null, (CoroutineContext) null, $composer, 48, 2);
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 1770562513, "CC(remember):IMSessionPageState.kt#9igjgp");
        boolean invalid$iv2 = $composer.changedInstance(viewModel);
        Object it$iv3 = $composer.rememberedValue();
        if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
            Object value$iv3 = (Function2) new IMSessionPageStateKt$rememberSessionPageState$1$1(viewModel, state, null);
            $composer.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv3, $composer, 6);
        CompositionLocal this_$iv = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Toaster toaster = (Toaster) consume;
        CompositionLocal this_$iv2 = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume2 = $composer.consume(this_$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer);
        LifecycleOwner lifecycle = (LifecycleOwner) consume2;
        ComposerKt.sourceInformationMarkerStart($composer, 1770571902, "CC(remember):IMSessionPageState.kt#9igjgp");
        boolean invalid$iv3 = $composer.changedInstance(lifecycle) | $composer.changed(onAction);
        Object it$iv4 = $composer.rememberedValue();
        if (invalid$iv3 || it$iv4 == Composer.Companion.getEmpty()) {
            Object value$iv4 = (Function2) new IMSessionPageStateKt$rememberSessionPageState$2$1(lifecycle, onAction, null);
            $composer.updateRememberedValue(value$iv4);
            it$iv4 = value$iv4;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(lifecycle, (Function2) it$iv4, $composer, 0);
        Unit unit2 = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 1770576707, "CC(remember):IMSessionPageState.kt#9igjgp");
        boolean invalid$iv4 = $composer.changedInstance(viewModel) | $composer.changedInstance(toaster);
        Object it$iv5 = $composer.rememberedValue();
        if (invalid$iv4 || it$iv5 == Composer.Companion.getEmpty()) {
            Object value$iv5 = (Function2) new IMSessionPageStateKt$rememberSessionPageState$3$1(viewModel, toaster, null);
            $composer.updateRememberedValue(value$iv5);
            it$iv5 = value$iv5;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit2, (Function2) it$iv5, $composer, 6);
        CompositionLocal this_$iv3 = RouterKt.getLocalRouter();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume3 = $composer.consume(this_$iv3);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Router route = (Router) consume3;
        ComposerKt.sourceInformationMarkerStart($composer, 1770581569, "CC(remember):IMSessionPageState.kt#9igjgp");
        Object it$iv6 = $composer.rememberedValue();
        if (it$iv6 == Composer.Companion.getEmpty()) {
            Object value$iv6 = new IMSessionPageState(viewModel.getPageType(), page, state, alert, new IMSessionRouteHandler() { // from class: im.session.common.IMSessionPageStateKt$rememberSessionPageState$4$1
                @Override // im.session.common.IMSessionRouteHandler
                public final Object invoke(Uri url, Continuation<? super Unit> continuation) {
                    route.launch(url);
                    return Unit.INSTANCE;
                }
            }, new IMSessionPageStateKt$sam$im_session_common_IMSessionActionHandler$0(onAction));
            $composer.updateRememberedValue(value$iv6);
            it$iv6 = value$iv6;
        }
        IMSessionPageState iMSessionPageState = (IMSessionPageState) it$iv6;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return iMSessionPageState;
    }

    public static final void configListState(final IMSessionPageState $this$configListState, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$configListState, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-1734544446);
        ComposerKt.sourceInformation($composer2, "C(configListState)184@5540L310,184@5512L338,196@5936L348,193@5856L428,207@6347L63,207@6314L96:IMSessionPageState.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$configListState) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1734544446, $dirty2, -1, "im.session.common.configListState (IMSessionPageState.kt:182)");
            }
            LazyListState columnState = $this$configListState.getColumnState();
            ComposerKt.sourceInformationMarkerStart($composer2, -449898600, "CC(remember):IMSessionPageState.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new IMSessionPageStateKt$configListState$1$1($this$configListState, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(columnState, (Function2) it$iv, $composer2, 0);
            Integer valueOf = Integer.valueOf(((IMState) $this$configListState.getPage().getValue()).getData().getSessions().hashCode());
            ComposerKt.sourceInformationMarkerStart($composer2, -449885890, "CC(remember):IMSessionPageState.kt#9igjgp");
            boolean invalid$iv2 = ($dirty2 & 14) == 4;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new IMSessionPageStateKt$configListState$2$1($this$configListState, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer2, 0);
            LazyListState columnState2 = $this$configListState.getColumnState();
            ComposerKt.sourceInformationMarkerStart($composer2, -449873023, "CC(remember):IMSessionPageState.kt#9igjgp");
            boolean invalid$iv3 = ($dirty2 & 14) == 4;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function1) new IMSessionPageStateKt$configListState$3$1($this$configListState, null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LoadMoreListStateKt.applyLoadMoreEffects(columnState2, 5, (Function1) null, (Function1) it$iv3, $composer2, 48, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageStateKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit configListState$lambda$3;
                    configListState$lambda$3 = IMSessionPageStateKt.configListState$lambda$3(IMSessionPageState.this, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return configListState$lambda$3;
                }
            });
        }
    }

    public static final Object invoke(IMSessionRouteHandler $this$invoke, String url, Continuation<? super Unit> continuation) {
        Object invoke = $this$invoke.invoke(Uri.Companion.parse(url), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}