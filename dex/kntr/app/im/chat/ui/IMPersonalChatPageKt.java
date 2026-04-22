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
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.di.PrivateChatEntryPoint;
import kntr.app.im.chat.di.module.personal.PersonalChat;
import kntr.app.im.chat.stateMachine.PersonalChatStateMachine;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderProvider;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.neuron.ChatReporterKt;
import kntr.app.im.chat.ui.page.personal.PersonalChatEntryPoint;
import kntr.app.im.chat.ui.page.personal.PersonalChatPageComponent;
import kntr.app.im.chat.ui.upgrade.UpgradeAnswerDialogDisplayer;
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

/* compiled from: IMPersonalChatPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007¨\u0006\u0007"}, d2 = {"IMPersonalChatPage", "Lkntr/common/komponent/Komponent;", RoomRecommendViewModel.EMPTY_CURSOR, "userIdStr", RoomRecommendViewModel.EMPTY_CURSOR, "eventFrom", "msgNewBadge", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMPersonalChatPageKt {
    public static /* synthetic */ Komponent IMPersonalChatPage$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return IMPersonalChatPage(str, str2, str3);
    }

    public static final Komponent<Unit> IMPersonalChatPage(final String userIdStr, final String eventFrom, final String msgNewBadge) {
        Intrinsics.checkNotNullParameter(userIdStr, "userIdStr");
        return KomponentKt.Komponent(new Function1() { // from class: kntr.app.im.chat.ui.IMPersonalChatPageKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                SetContentResult IMPersonalChatPage$lambda$0;
                IMPersonalChatPage$lambda$0 = IMPersonalChatPageKt.IMPersonalChatPage$lambda$0(userIdStr, eventFrom, msgNewBadge, (KomponentScope) obj);
                return IMPersonalChatPage$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SetContentResult IMPersonalChatPage$lambda$0(String $userIdStr, String $eventFrom, String $msgNewBadge, final KomponentScope $this$Komponent) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter($this$Komponent, "$this$Komponent");
        Long longOrNull = StringsKt.toLongOrNull($userIdStr);
        long userId = longOrNull != null ? longOrNull.longValue() : 0L;
        int pageFrom = ($eventFrom == null || (intOrNull = StringsKt.toIntOrNull($eventFrom)) == null) ? 0 : intOrNull.intValue();
        final ChatReporter it = new ChatReporter(KNeuron.INSTANCE, "chat-single", null, 4, null);
        ChatReporterKt.appendParam(it, "source_event", String.valueOf(pageFrom));
        ChatReporterKt.appendParam(it, "msg_new", $msgNewBadge == null ? RoomRecommendViewModel.EMPTY_CURSOR : $msgNewBadge);
        PersonalChat id = new PersonalChat(userId);
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        final PersonalChatStateMachine viewModel = ((PrivateChatEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(PrivateChatEntryPoint.class))).privateChatComponentBuilder().bindSessionId(id).build().privateChatStateMachine();
        final ChatActionHandler actionHandler = new ChatActionHandler() { // from class: kntr.app.im.chat.ui.IMPersonalChatPageKt$IMPersonalChatPage$1$actionHandler$1
            @Override // kntr.app.im.chat.ui.ChatActionHandler
            public final Object invoke(ChatAction it2, Continuation<? super Unit> continuation) {
                Object dispatch = PersonalChatStateMachine.this.dispatch((Object) it2, (Continuation) continuation);
                return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
            }
        };
        final StateFlow pageStateFlow = FlowKt.stateIn(viewModel.getState(), $this$Komponent.getCoroutineScope(), SharingStarted.Companion.getEagerly(), new ChatPageData(id, 0L, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 131070, null));
        KomponentHostScope.-CC.launch$default((KomponentHostScope) $this$Komponent, (CoroutineContext) null, (CoroutineStart) null, new IMPersonalChatPageKt$IMPersonalChatPage$1$1(pageStateFlow, $this$Komponent, null), 3, (Object) null);
        final Object state$iv$iv = Unit.INSTANCE;
        final long j2 = userId;
        UiComposableLike content$iv$iv$iv = new UiComposableLike<S>(state$iv$iv, $this$Komponent, pageStateFlow, it, actionHandler, j2) { // from class: kntr.app.im.chat.ui.IMPersonalChatPageKt$IMPersonalChatPage$lambda$0$$inlined$setContent$1
            final /* synthetic */ ChatActionHandler $actionHandler$inlined;
            final /* synthetic */ StateFlow $pageStateFlow$inlined;
            final /* synthetic */ ChatReporter $reporter$inlined;
            final /* synthetic */ KomponentScope $this_setContent;
            final /* synthetic */ long $userId$inlined;
            private final S state;

            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$this_setContent = $this$Komponent;
                this.$pageStateFlow$inlined = pageStateFlow;
                this.$reporter$inlined = it;
                this.$actionHandler$inlined = actionHandler;
                this.$userId$inlined = j2;
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
                $composer.startReplaceGroup(1220693895);
                ComposerKt.sourceInformation($composer, "CN(modifier)*97@3498L2600,97@3488L2610:IMPersonalChatPage.kt#f7dpja");
                final StateFlow stateFlow = this.$pageStateFlow$inlined;
                final ChatReporter chatReporter = this.$reporter$inlined;
                final ChatActionHandler chatActionHandler = this.$actionHandler$inlined;
                final long j3 = this.$userId$inlined;
                BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(397446866, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.IMPersonalChatPageKt$IMPersonalChatPage$1$2$1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:40:0x01c2, code lost:
                        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:48:0x01f7, code lost:
                        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L37;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C98@3536L13,99@3585L21,101@3636L23,103@3703L16,104@3742L27,104@3770L13,104@3784L13,106@3827L61,107@3922L358,107@3901L379,119@4330L157,119@4294L193,125@4536L76,128@4639L10,129@4689L7,130@4730L30,132@4807L502,144@5365L103,148@5532L68,150@5614L474:IMPersonalChatPage.kt#f7dpja");
                        if (!$composer2.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(397446866, $changed2, -1, "kntr.app.im.chat.ui.IMPersonalChatPage.<anonymous>.<anonymous>.<anonymous> (IMPersonalChatPage.kt:98)");
                        }
                        boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer2, BiliTheme.$stable) == ThemeDayNight.Night;
                        WindowConfigKt.WindowConfig(isNight, $composer2, 0);
                        LazyListState listState = LazyListStateKt.rememberLazyListState(0, 0, $composer2, 0, 3);
                        State pageState = SnapshotStateKt.collectAsState(stateFlow, (CoroutineContext) null, $composer2, 0, 1);
                        PageConfigKt.configToast(PageConfigKt.configRoute(PageConfigKt.configPageScroll(pageState, listState, $composer2, 0), $composer2, 0), $composer2, 0);
                        PvEventTrigger pvTrigger = PvTriggerEntranceKt.rememberPvEventTrigger(chatReporter.getPvReportEvent(), $composer2, 0);
                        Unit unit = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer2, -305637192, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        boolean invalid$iv = $composer2.changed(pageState) | $composer2.changedInstance(pvTrigger) | $composer2.changed(chatReporter);
                        ChatReporter chatReporter2 = chatReporter;
                        Object it$iv = $composer2.rememberedValue();
                        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                            Object value$iv = (Function2) new IMPersonalChatPageKt$IMPersonalChatPage$1$2$1$1$1(pageState, pvTrigger, chatReporter2, null);
                            $composer2.updateRememberedValue(value$iv);
                            it$iv = value$iv;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(unit, (Function2) it$iv, $composer2, 6);
                        ChatReporter chatReporter3 = chatReporter;
                        ComposerKt.sourceInformationMarkerStart($composer2, -305624337, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        boolean invalid$iv2 = $composer2.changed(chatReporter) | $composer2.changedInstance(pvTrigger);
                        ChatReporter chatReporter4 = chatReporter;
                        Object it$iv2 = $composer2.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                            Object value$iv2 = (Function2) new IMPersonalChatPageKt$IMPersonalChatPage$1$2$1$2$1(chatReporter4, pvTrigger, null);
                            $composer2.updateRememberedValue(value$iv2);
                            it$iv2 = value$iv2;
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        EffectsKt.LaunchedEffect(pvTrigger, chatReporter3, (Function2) it$iv2, $composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -305617826, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        Object it$iv3 = $composer2.rememberedValue();
                        if (it$iv3 == Composer.Companion.getEmpty()) {
                            Object value$iv3 = new PictureLifecycleKeyHandle();
                            $composer2.updateRememberedValue(value$iv3);
                            it$iv3 = value$iv3;
                        }
                        PictureLifecycleKeyHandle pictureHandle = (PictureLifecycleKeyHandle) it$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        pictureHandle.register($composer2, 6);
                        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                        Object consume = $composer2.consume(this_$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        Density density = (Density) consume;
                        ChatPageController pageController = ChatPageControllerKt.rememberCommonPageController($composer2, 0);
                        ComposerKt.sourceInformationMarkerStart($composer2, -305608728, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        ChatActionHandler chatActionHandler2 = chatActionHandler;
                        ChatReporter chatReporter5 = chatReporter;
                        Object value$iv4 = $composer2.rememberedValue();
                        if (value$iv4 == Composer.Companion.getEmpty()) {
                            Object $this$entryPoint$iv2 = Gripper_component_holder_androidKt.getRootGripperComponent();
                            value$iv4 = ((PersonalChatEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv2, Reflection.getOrCreateKotlinClass(PersonalChatEntryPoint.class))).getPersonalChatComponentFactory().bindDensity(density).bindActionHandler(chatActionHandler2).bindReporter(chatReporter5).bindPageController(pageController).bindPictureLifecycleHandle(pictureHandle).build();
                            $composer2.updateRememberedValue(value$iv4);
                        }
                        PersonalChatPageComponent uiComponent = (PersonalChatPageComponent) value$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -305591271, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        boolean invalid$iv3 = $composer2.changed(uiComponent);
                        Object it$iv4 = $composer2.rememberedValue();
                        if (invalid$iv3) {
                        }
                        Object value$iv5 = uiComponent.chatMsgFrameBuilderProvider();
                        $composer2.updateRememberedValue(value$iv5);
                        it$iv4 = value$iv5;
                        ChatMsgFrameBuilderProvider frameBuilderProvider = (ChatMsgFrameBuilderProvider) it$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ComposerKt.sourceInformationMarkerStart($composer2, -305585962, "CC(remember):IMPersonalChatPage.kt#9igjgp");
                        boolean invalid$iv4 = $composer2.changed(uiComponent);
                        Object it$iv5 = $composer2.rememberedValue();
                        if (invalid$iv4) {
                        }
                        Object value$iv6 = uiComponent.upgradeAnswerDialogDisplayer();
                        $composer2.updateRememberedValue(value$iv6);
                        it$iv5 = value$iv6;
                        UpgradeAnswerDialogDisplayer upgradeAnswerDialogDisplayer = (UpgradeAnswerDialogDisplayer) it$iv5;
                        ComposerKt.sourceInformationMarkerEnd($composer2);
                        ChatPageKt.ChatPage((ChatPageData) pageState.getValue(), chatActionHandler, listState, frameBuilderProvider, pictureHandle, modifier, upgradeAnswerDialogDisplayer, false, "UID:" + j3, chatReporter, $composer2, 24576, 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
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