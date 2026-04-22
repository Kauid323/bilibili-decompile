package kntr.app.im.chat.ui;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import com.bapis.bilibili.app.im.v1.KAssistantType;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.di.AssistantChatEntryPoint;
import kntr.app.im.chat.di.module.assistant.Assistant;
import kntr.app.im.chat.stateMachine.AssistantChatStateMachine;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.neuron.ChatReporterKt;
import kntr.app.im.chat.ui.page.assistant.AssistantEntryPoint;
import kntr.app.im.chat.ui.utils.ChatPageController;
import kntr.app.im.chat.ui.utils.ChatPageControllerKt;
import kntr.app.im.chat.ui.utils.PictureLifecycleKeyHandle;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.neuron.KNeuron;
import kntr.common.komponent.HostConfiguration;
import kntr.common.komponent.Komponent;
import kntr.common.komponent.KomponentHostScope;
import kntr.common.komponent.KomponentKt;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.SetContentResult;
import kntr.common.komponent.UiComposableLike;
import kntr.common.pv.PvEventTrigger;
import kntr.common.pv.compose.PvTriggerEntranceKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: IMAssistantChatPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\b"}, d2 = {"IMAssistantChatPage", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "assistantTypeStr", RoomRecommendViewModel.EMPTY_CURSOR, "assistantIdStr", "eventFrom", "msgNewBadge", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMAssistantChatPageKt {
    public static /* synthetic */ Komponent IMAssistantChatPage$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return IMAssistantChatPage(str, str2, str3, str4);
    }

    public static final Komponent<Unit> IMAssistantChatPage(final String assistantTypeStr, final String assistantIdStr, final String eventFrom, final String msgNewBadge) {
        Intrinsics.checkNotNullParameter(assistantTypeStr, "assistantTypeStr");
        Intrinsics.checkNotNullParameter(assistantIdStr, "assistantIdStr");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult IMAssistantChatPage$lambda$0;
                IMAssistantChatPage$lambda$0 = IMAssistantChatPageKt.IMAssistantChatPage$lambda$0(assistantTypeStr, assistantIdStr, eventFrom, msgNewBadge, (KomponentScope) obj);
                return IMAssistantChatPage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult IMAssistantChatPage$lambda$0(String $assistantTypeStr, String $assistantIdStr, String $eventFrom, String $msgNewBadge, final KomponentScope $this$Komponent) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        Integer intOrNull2 = StringsKt.toIntOrNull($assistantTypeStr);
        int assistantType = intOrNull2 != null ? intOrNull2.intValue() : -1;
        Long longOrNull = StringsKt.toLongOrNull($assistantIdStr);
        long assistantId = longOrNull != null ? longOrNull.longValue() : 0L;
        Assistant sessionId = new Assistant(KAssistantType.Companion.fromValue(assistantType), assistantId);
        int pageFrom = ($eventFrom == null || (intOrNull = StringsKt.toIntOrNull($eventFrom)) == null) ? 0 : intOrNull.intValue();
        final ChatReporter it = new ChatReporter(KNeuron.INSTANCE, "chat-single", null, 4, null);
        ChatReporterKt.appendParam(it, "source_event", String.valueOf(pageFrom));
        ChatReporterKt.appendParam(it, "msg_new", $msgNewBadge == null ? RoomRecommendViewModel.EMPTY_CURSOR : $msgNewBadge);
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        final AssistantChatStateMachine viewModel = ((AssistantChatEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AssistantChatEntryPoint.class))).assistantChatComponentBuilder().bindSessionId(sessionId).build().assistantChatStateMachine();
        final StateFlow pageStateFlow = FlowKt.stateIn(viewModel.getState(), $this$Komponent.getCoroutineScope(), SharingStarted.Companion.getEagerly(), new ChatPageData(sessionId, 0L, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 131070, null));
        KomponentHostScope.-CC.launch$default((KomponentHostScope) $this$Komponent, (CoroutineContext) null, (CoroutineStart) null, new IMAssistantChatPageKt$IMAssistantChatPage$1$1(pageStateFlow, $this$Komponent, null), 3, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, pageStateFlow, it, viewModel) { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$lambda$0$$inlined$setContent$1
            final /* synthetic */ StateFlow $pageStateFlow$inlined;
            final /* synthetic */ ChatReporter $reporter$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ AssistantChatStateMachine $viewModel$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$pageStateFlow$inlined = pageStateFlow;
                this.$reporter$inlined = it;
                this.$viewModel$inlined = viewModel;
                this.state = state$iv$iv;
            }

            public void invoke(final Modifier modifier, Composer $composer, int $changed) {
                Intrinsics.checkNotNullParameter(modifier, "modifier");
                $composer.startReplaceGroup(1906618612);
                ComposerKt.sourceInformation($composer, "C(invoke)N(modifier)87@2987L17:Komponent.kt#vxw63z");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1906618612, $changed, -1, "kntr.common.komponent.setContent.<no name provided>.invoke (Komponent.kt:86)");
                }
                int i = $changed & 14;
                $composer.startReplaceGroup(-115612201);
                ComposerKt.sourceInformation($composer, "CN(modifier)*86@3320L2835,86@3310L2845:IMAssistantChatPage.kt#f7dpja");
                final StateFlow stateFlow = this.$pageStateFlow$inlined;
                final ChatReporter chatReporter = this.$reporter$inlined;
                final AssistantChatStateMachine assistantChatStateMachine = this.$viewModel$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1551013561, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:33:0x012c, code lost:
                        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L26;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:41:0x0183, code lost:
                        if (r6 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L31;
                     */
                    /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
                    /* JADX WARN: Removed duplicated region for block: B:36:0x0130  */
                    /* JADX WARN: Removed duplicated region for block: B:40:0x017b  */
                    /* JADX WARN: Removed duplicated region for block: B:44:0x0187  */
                    /* JADX WARN: Removed duplicated region for block: B:48:0x01bd  */
                    /* JADX WARN: Removed duplicated region for block: B:52:0x01f2  */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0233  */
                    /* JADX WARN: Removed duplicated region for block: B:56:0x0287  */
                    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(Composer $composer2, int $changed2) {
                        boolean invalid$iv;
                        boolean invalid$iv2;
                        Object it$iv;
                        Object it$iv2;
                        ComposerKt.sourceInformation($composer2, "C87@3358L13,88@3407L21,90@3472L16,91@3528L7,92@3569L30,93@3628L23,94@3680L61,96@3790L148,102@3978L367,102@3952L393,113@4394L157,113@4358L193,119@4575L27,119@4603L13,119@4617L13,121@4665L308,121@4644L329,133@5023L76,136@5126L10,138@5192L555,150@5760L385:IMAssistantChatPage.kt#f7dpja");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1551013561, $changed2, -1, "kntr.app.im.chat.ui.IMAssistantChatPage.<anonymous>.<anonymous>.<anonymous> (IMAssistantChatPage.kt:87)");
                        }
                        boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night;
                        WindowConfigKt.WindowConfig(isNight, $composer2, 0);
                        State pageState = SnapshotStateKt.collectAsState(stateFlow, (CoroutineContext) null, $composer2, 0, 1);
                        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = $composer2.consume(this_$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density density = (Density) consume;
                        ChatPageController pageController = ChatPageControllerKt.rememberCommonPageController($composer2, 0);
                        LazyListState listState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                        PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(chatReporter.getPvReportEvent(), $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -170365221, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        boolean invalid$iv3 = $composer2.changed(assistantChatStateMachine);
                        final AssistantChatStateMachine assistantChatStateMachine2 = assistantChatStateMachine;
                        Object it$iv3 = $composer2.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv = (ChatActionHandler) new ChatActionHandler() { // from class: kntr.app.im.chat.ui.IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$actionHandler$1$1
                                @Override // kntr.app.im.chat.ui.ChatActionHandler
                                public final Object invoke(ChatAction it2, Continuation<? super Unit> continuation) {
                                    Object dispatch = AssistantChatStateMachine.this.dispatch((Object) it2, (Continuation) continuation);
                                    return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
                                }
                            };
                            $composer2.updateRememberedValue(value$iv);
                            it$iv3 = value$iv;
                        }
                        ChatActionHandler actionHandler = (ChatActionHandler) it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -170358986, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        boolean invalid$iv4 = $composer2.changed(pageState) | $composer2.changed(chatReporter) | $composer2.changedInstance(pvTrigger);
                        ChatReporter chatReporter2 = chatReporter;
                        Object it$iv4 = $composer2.rememberedValue();
                        if (!invalid$iv4 && it$iv4 != Composer.Companion.getEmpty()) {
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(pvTrigger, (Function2) it$iv4, $composer2, 0);
                            ChatReporter chatReporter3 = chatReporter;
                            ComposerKt.sourceInformationMarkerStart($composer2, -170345884, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                            invalid$iv = $composer2.changed(chatReporter) | $composer2.changedInstance(pvTrigger);
                            ChatReporter chatReporter4 = chatReporter;
                            Object it$iv5 = $composer2.rememberedValue();
                            if (invalid$iv) {
                            }
                            Object value$iv2 = (Function2) new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1(chatReporter4, pvTrigger, null);
                            $composer2.updateRememberedValue(value$iv2);
                            it$iv5 = value$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(pvTrigger, chatReporter3, (Function2) it$iv5, $composer2, 0);
                            PageConfigKt.configToast(PageConfigKt.configRoute(PageConfigKt.configPageScroll(pageState, listState, $composer2, 0), $composer2, 0), $composer2, 0);
                            Unit unit = Unit.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer2, -170337061, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                            invalid$iv2 = $composer2.changed(pageState) | $composer2.changed(chatReporter);
                            ChatReporter chatReporter5 = chatReporter;
                            Object it$iv6 = $composer2.rememberedValue();
                            if (invalid$iv2) {
                            }
                            Object value$iv3 = (Function2) new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1(pageState, chatReporter5, null);
                            $composer2.updateRememberedValue(value$iv3);
                            it$iv6 = value$iv3;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            EffectsKt.LaunchedEffect(unit, (Function2) it$iv6, $composer2, 6);
                            ComposerKt.sourceInformationMarkerStart($composer2, -170325837, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                            it$iv = $composer2.rememberedValue();
                            if (it$iv == Composer.Companion.getEmpty()) {
                                Object value$iv4 = new PictureLifecycleKeyHandle();
                                $composer2.updateRememberedValue(value$iv4);
                                it$iv = value$iv4;
                            }
                            PictureLifecycleKeyHandle pictureHandle = (PictureLifecycleKeyHandle) it$iv;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            pictureHandle.register($composer2, 6);
                            ComposerKt.sourceInformationMarkerStart($composer2, -170319950, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                            ChatReporter chatReporter6 = chatReporter;
                            it$iv2 = $composer2.rememberedValue();
                            if (it$iv2 != Composer.Companion.getEmpty()) {
                                Object $this$entryPoint$iv2 = Gripper_component_holder_androidKt.getRootGripperComponent();
                                Object value$iv5 = ((AssistantEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv2, Reflection.getOrCreateKotlinClass(AssistantEntryPoint.class))).getAssistantChatComponentFactory().bindDensity(density).bindReporter(chatReporter6).bindActionHandler(actionHandler).bindPageController(pageController).bindPictureLifecycleHandle(pictureHandle).build().chatMsgFrameBuilderProvider();
                                $composer2.updateRememberedValue(value$iv5);
                                it$iv2 = value$iv5;
                            }
                            ChatMsgFrameBuilderProvider frameBuilderProvider = (ChatMsgFrameBuilderProvider) it$iv2;
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ChatPageKt.ChatPage((ChatPageData) pageState.getValue(), actionHandler, listState, frameBuilderProvider, pictureHandle, modifier, null, false, null, chatReporter, $composer2, 12610560, 320);
                            if (!ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        Object value$iv6 = (Function2) new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$1$1(pageState, chatReporter2, pvTrigger, null);
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv4 = value$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(pvTrigger, (Function2) it$iv4, $composer2, 0);
                        ChatReporter chatReporter32 = chatReporter;
                        ComposerKt.sourceInformationMarkerStart($composer2, -170345884, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        invalid$iv = $composer2.changed(chatReporter) | $composer2.changedInstance(pvTrigger);
                        ChatReporter chatReporter42 = chatReporter;
                        Object it$iv52 = $composer2.rememberedValue();
                        if (invalid$iv) {
                        }
                        Object value$iv22 = (Function2) new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$2$1(chatReporter42, pvTrigger, null);
                        $composer2.updateRememberedValue(value$iv22);
                        it$iv52 = value$iv22;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(pvTrigger, chatReporter32, (Function2) it$iv52, $composer2, 0);
                        PageConfigKt.configToast(PageConfigKt.configRoute(PageConfigKt.configPageScroll(pageState, listState, $composer2, 0), $composer2, 0), $composer2, 0);
                        Unit unit2 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -170337061, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        invalid$iv2 = $composer2.changed(pageState) | $composer2.changed(chatReporter);
                        ChatReporter chatReporter52 = chatReporter;
                        Object it$iv62 = $composer2.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv32 = (Function2) new IMAssistantChatPageKt$IMAssistantChatPage$1$2$1$3$1(pageState, chatReporter52, null);
                        $composer2.updateRememberedValue(value$iv32);
                        it$iv62 = value$iv32;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit2, (Function2) it$iv62, $composer2, 6);
                        ComposerKt.sourceInformationMarkerStart($composer2, -170325837, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        it$iv = $composer2.rememberedValue();
                        if (it$iv == Composer.Companion.getEmpty()) {
                        }
                        PictureLifecycleKeyHandle pictureHandle2 = (PictureLifecycleKeyHandle) it$iv;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        pictureHandle2.register($composer2, 6);
                        ComposerKt.sourceInformationMarkerStart($composer2, -170319950, "CC(remember):IMAssistantChatPage.kt#9igjgp");
                        ChatReporter chatReporter62 = chatReporter;
                        it$iv2 = $composer2.rememberedValue();
                        if (it$iv2 != Composer.Companion.getEmpty()) {
                        }
                        ChatMsgFrameBuilderProvider frameBuilderProvider2 = (ChatMsgFrameBuilderProvider) it$iv2;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ChatPageKt.ChatPage((ChatPageData) pageState.getValue(), actionHandler, listState, frameBuilderProvider2, pictureHandle2, modifier, null, false, null, chatReporter, $composer2, 12610560, 320);
                        if (!ComposerKt.isTraceInProgress()) {
                        }
                    }
                }, $composer, 54), $composer, 384, 3);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceGroup();
            }

            public Object getContentType() {
                return Reflection.getOrCreateKotlinClass(getClass());
            }

            public Object getKey() {
                return this.$this_setContent.getKey();
            }

            public S getState() {
                return this.state;
            }

            public HostConfiguration getPreferredHostConfiguration() {
                return this.$this_setContent.getPreferredHostConfiguration();
            }
        };
        return $this$Komponent.__setContent(content$iv$iv$iv);
    }
}