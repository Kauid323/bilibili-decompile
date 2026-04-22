package kntr.app.deepsearch.stub;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.base.util.ContextUtilKt;
import java.lang.ref.WeakReference;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: PageStub.android.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0015\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\u0010\f\u001a \u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u0010\"\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"PushHistoryPageStub", RoomRecommendViewModel.EMPTY_CURSOR, "(Landroidx/compose/runtime/Composer;I)V", "checkDetailPageStub", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "detailPageStub", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkntr/app/deepsearch/stub/PageStub;", "historyPageStub", "PushDetailPageStub", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "observeSession", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lkotlin/Function1;", "common-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PageStub_androidKt {
    private static final MutableStateFlow<PageStub> detailPageStub = StateFlowKt.MutableStateFlow((Object) null);
    private static final MutableStateFlow<PageStub> historyPageStub = StateFlowKt.MutableStateFlow((Object) null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushDetailPageStub$lambda$3(String str, int i, Composer composer, int i2) {
        PushDetailPageStub(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushHistoryPageStub$lambda$2(int i, Composer composer, int i2) {
        PushHistoryPageStub(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PushHistoryPageStub(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-2004392121);
        ComposerKt.sourceInformation($composer2, "C(PushHistoryPageStub)20@741L7,23@833L236,23@812L257,34@1098L169,34@1075L192:PageStub.android.kt#m2lwsy");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2004392121, $changed, -1, "kntr.app.deepsearch.stub.PushHistoryPageStub (PageStub.android.kt:19)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            Activity current = ContextUtilKt.findActivityOrNull(context);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2075474317, "CC(remember):PageStub.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(current);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new PageStub_androidKt$PushHistoryPageStub$1$1(current, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2075465904, "CC(remember):PageStub.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(context);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        DisposableEffectResult PushHistoryPageStub$lambda$1$0;
                        PushHistoryPageStub$lambda$1$0 = PageStub_androidKt.PushHistoryPageStub$lambda$1$0(context, (DisposableEffectScope) obj);
                        return PushHistoryPageStub$lambda$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv2, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushHistoryPageStub$lambda$2;
                    PushHistoryPageStub$lambda$2 = PageStub_androidKt.PushHistoryPageStub$lambda$2($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PushHistoryPageStub$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PushHistoryPageStub$lambda$1$0(final Context $context, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$PushHistoryPageStub$lambda$1$0$$inlined$onDispose$1
            public void dispose() {
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                WeakReference<Activity> activityRef;
                mutableStateFlow = PageStub_androidKt.historyPageStub;
                PageStub pageStub = (PageStub) mutableStateFlow.getValue();
                if (((pageStub == null || (activityRef = pageStub.getActivityRef()) == null) ? null : activityRef.get()) == $context) {
                    mutableStateFlow2 = PageStub_androidKt.historyPageStub;
                    mutableStateFlow2.setValue((Object) null);
                }
            }
        };
    }

    public static final boolean checkDetailPageStub(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        PageStub pageStub = (PageStub) detailPageStub.getValue();
        return Intrinsics.areEqual(pageStub != null ? pageStub.getSessionId() : null, sessionId);
    }

    public static final void PushDetailPageStub(final String sessionId, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Composer $composer2 = $composer.startRestartGroup(-288952317);
        ComposerKt.sourceInformation($composer2, "C(PushDetailPageStub)N(sessionId)55@1706L7,58@1798L242,58@1777L263,69@2072L217,69@2046L243,80@2318L167,80@2295L190:PageStub.android.kt#m2lwsy");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(sessionId) ? 4 : 2;
        }
        if (!$composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-288952317, $dirty, -1, "kntr.app.deepsearch.stub.PushDetailPageStub (PageStub.android.kt:54)");
            }
            CompositionLocal this_$iv = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            Activity current = ContextUtilKt.findActivityOrNull(context);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1489703477, "CC(remember):PageStub.android.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(current) | (($dirty & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new PageStub_androidKt$PushDetailPageStub$1$1(current, sessionId, null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
            ComposerKt.sourceInformationMarkerStart($composer2, 1489712220, "CC(remember):PageStub.android.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(current) | (($dirty & 14) == 4);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new PageStub_androidKt$PushDetailPageStub$2$1(current, sessionId, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(sessionId, (Function2) it$iv2, $composer2, $dirty & 14);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1489720042, "CC(remember):PageStub.android.kt#9igjgp");
            boolean invalid$iv3 = $composer2.changedInstance(context);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        DisposableEffectResult PushDetailPageStub$lambda$2$0;
                        PushDetailPageStub$lambda$2$0 = PageStub_androidKt.PushDetailPageStub$lambda$2$0(context, (DisposableEffectScope) obj);
                        return PushDetailPageStub$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.DisposableEffect(unit2, (Function1) it$iv3, $composer2, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushDetailPageStub$lambda$3;
                    PushDetailPageStub$lambda$3 = PageStub_androidKt.PushDetailPageStub$lambda$3(sessionId, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return PushDetailPageStub$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult PushDetailPageStub$lambda$2$0(final Context $context, DisposableEffectScope $this$DisposableEffect) {
        Intrinsics.checkNotNullParameter($this$DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: kntr.app.deepsearch.stub.PageStub_androidKt$PushDetailPageStub$lambda$2$0$$inlined$onDispose$1
            public void dispose() {
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                WeakReference<Activity> activityRef;
                mutableStateFlow = PageStub_androidKt.detailPageStub;
                PageStub pageStub = (PageStub) mutableStateFlow.getValue();
                if (((pageStub == null || (activityRef = pageStub.getActivityRef()) == null) ? null : activityRef.get()) == $context) {
                    mutableStateFlow2 = PageStub_androidKt.detailPageStub;
                    mutableStateFlow2.setValue((Object) null);
                }
            }
        };
    }

    public static final void observeSession(LifecycleOwner $this$observeSession, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$observeSession, "<this>");
        Intrinsics.checkNotNullParameter(function1, "observer");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope($this$observeSession), (CoroutineContext) null, (CoroutineStart) null, new PageStub_androidKt$observeSession$1(function1, null), 3, (Object) null);
    }
}