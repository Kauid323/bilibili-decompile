package kntr.app.im.chat.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: PageConfig.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0007\u001aq\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n2F\u0010\r\u001aB\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u000eH\u0002¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"configPageScroll", "Landroidx/compose/runtime/State;", "Lkntr/app/im/chat/core/model/ChatPageData;", "listState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/runtime/State;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "configToast", "(Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "configRoute", "comparing", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "operator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "last", "next", "Lkotlin/coroutines/Continuation;", RoomRecommendViewModel.EMPTY_CURSOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PageConfigKt {
    public static final State<ChatPageData> configPageScroll(State<ChatPageData> state, LazyListState listState, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        Intrinsics.checkNotNullParameter(listState, "listState");
        ComposerKt.sourceInformationMarkerStart($composer, 1681764594, "C(configPageScroll)N(listState)25@1015L809,25@994L830:PageConfig.kt#f7dpja");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1681764594, $changed, -1, "kntr.app.im.chat.ui.configPageScroll (PageConfig.kt:24)");
        }
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 1268076027, "CC(remember):PageConfig.kt#9igjgp");
        boolean invalid$iv = ((($changed & 112) ^ 48) > 32 && $composer.changed(listState)) || ($changed & 48) == 32;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new PageConfigKt$configPageScroll$1$1(listState, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    public static final State<ChatPageData> configToast(State<ChatPageData> state, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1231584772, "C(configToast)50@1957L7,51@1990L164,51@1969L185:PageConfig.kt#f7dpja");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1231584772, $changed, -1, "kntr.app.im.chat.ui.configToast (PageConfig.kt:49)");
        }
        CompositionLocal this_$iv = ToasterKt.getLocalToaster();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Toaster toaster = (Toaster) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, -1858003640, "CC(remember):PageConfig.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(state)) || ($changed & 6) == 4) | $composer.changedInstance(toaster);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new PageConfigKt$configToast$1$1(state, toaster, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    public static final State<ChatPageData> configRoute(State<ChatPageData> state, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 940019110, "C(configRoute)61@2285L7,62@2318L133,62@2297L154:PageConfig.kt#f7dpja");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(940019110, $changed, -1, "kntr.app.im.chat.ui.configRoute (PageConfig.kt:60)");
        }
        CompositionLocal this_$iv = RouterKt.getLocalRouter();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Router router = (Router) consume;
        Unit unit = Unit.INSTANCE;
        ComposerKt.sourceInformationMarkerStart($composer, 1415236619, "CC(remember):PageConfig.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(state)) || ($changed & 6) == 4) | $composer.changedInstance(router);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = (Function2) new PageConfigKt$configRoute$1$1(state, router, null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, R> Flow<R> comparing(Flow<? extends T> flow, Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Ref.ObjectRef last = new Ref.ObjectRef();
        return FlowKt.channelFlow(new PageConfigKt$comparing$1(flow, last, function3, null));
    }
}