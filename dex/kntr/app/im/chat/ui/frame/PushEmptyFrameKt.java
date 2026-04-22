package kntr.app.im.chat.ui.frame;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.im.v1.KMsgMenuItem;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.im.chat.frame.push.PushEmptyFrame;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameBuilderKt;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.builder.ChatMsgModuleBuilderProvider;
import kntr.app.im.chat.ui.builder.ChatMsgModuleContent;
import kntr.app.im.chat.ui.neuron.ChatReporter;
import kntr.app.im.chat.ui.utils.MenuItemHandlerKt;
import kntr.app.im.chat.ui.widget.PopupBubbleMenuKt;
import kntr.app.im.chat.ui.widget.PopupState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: PushEmptyFrame.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"PushEmptyFrame", RoomRecommendViewModel.EMPTY_CURSOR, "empty", "Lkntr/app/im/chat/frame/push/PushEmptyFrame;", "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "(Lkntr/app/im/chat/frame/push/PushEmptyFrame;Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PushEmptyFrameKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushEmptyFrame$lambda$2(PushEmptyFrame pushEmptyFrame, EntityMessage entityMessage, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, ChatActionHandler chatActionHandler, Modifier modifier, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        PushEmptyFrame(pushEmptyFrame, entityMessage, chatMsgModuleBuilderProvider, chatActionHandler, modifier, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x047d  */
    /* JADX WARN: Type inference failed for: r3v25 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void PushEmptyFrame(final PushEmptyFrame empty, final EntityMessage message, final ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, final ChatActionHandler actionHandler, Modifier modifier, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatReporter reporter2;
        Modifier modifier3;
        ChatReporter reporter3;
        int $dirty;
        String str;
        Object obj;
        PopupState popupState;
        float maxWidth;
        ChatReporter reporter4;
        CompositionLocalMap localMap$iv$iv;
        boolean invalid$iv;
        Object value$iv;
        final PopupState popupState2;
        String str2;
        Composer $composer2;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Object it$iv;
        float maxWidth2;
        Intrinsics.checkNotNullParameter(empty, "empty");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer3 = $composer.startRestartGroup(1389024712);
        ComposerKt.sourceInformation($composer3, "C(PushEmptyFrame)N(empty,message,chatMsgModuleBuilderProvider,actionHandler,modifier,reporter)114@4669L24,115@4715L37,122@5017L903,116@4782L3508:PushEmptyFrame.kt#wmjton");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(empty) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(message) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(chatMsgModuleBuilderProvider) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(actionHandler) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty2 |= 196608;
            reporter2 = reporter;
        } else if ((196608 & $changed) == 0) {
            reporter2 = reporter;
            $dirty2 |= $composer3.changed(reporter2) ? 131072 : 65536;
        } else {
            reporter2 = reporter;
        }
        if ($composer3.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                reporter2 = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1389024712, $dirty2, -1, "kntr.app.im.chat.ui.frame.PushEmptyFrame (PushEmptyFrame.kt:112)");
            }
            float f = Dp.constructor-impl(400);
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer3.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PopupState popupState3 = PopupBubbleMenuKt.rememberPopupState(false, $composer3, 6, 0);
            Modifier clip = ClipKt.clip(PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(16), Dp.constructor-impl(8)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
            ComposerKt.sourceInformationMarkerStart($composer3, -882059377, "CC(remember):PushEmptyFrame.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | $composer3.changed(popupState3) | $composer3.changedInstance(scope) | (($dirty2 & 7168) == 2048) | ((458752 & $dirty2) == 131072) | (($dirty2 & 112) == 32);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                modifier3 = modifier4;
                str = "CC(remember):PushEmptyFrame.kt#9igjgp";
                obj = null;
                popupState = popupState3;
                maxWidth = f;
                reporter4 = reporter2;
                value$iv2 = new PushEmptyFrameKt$PushEmptyFrame$1$1(empty, popupState3, scope, actionHandler, reporter2, message);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                $dirty = $dirty2;
                popupState = popupState3;
                maxWidth = f;
                reporter4 = reporter2;
                modifier3 = modifier4;
                str = "CC(remember):PushEmptyFrame.kt#9igjgp";
                obj = null;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(clip, obj, (PointerInputEventHandler) value$iv2);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -602632313, "C146@6023L32,147@6067L1214,144@5938L1343,182@7319L255,191@7655L9,192@7680L604,190@7583L701:PushEmptyFrame.kt#wmjton");
            String str3 = str;
            ComposerKt.sourceInformationMarkerStart($composer3, 119107986, str3);
            final PopupState popupState4 = popupState;
            boolean invalid$iv3 = $composer3.changed(popupState4);
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv3) {
                localMap$iv$iv = localMap$iv$iv2;
            } else {
                localMap$iv$iv = localMap$iv$iv2;
                if (value$iv3 != Composer.Companion.getEmpty()) {
                    Function0 function0 = value$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, 119110576, str3);
                    invalid$iv = (($dirty & 112) != 32) | (($dirty & 14) != 4) | $composer3.changedInstance(scope) | (($dirty & 7168) != 2048) | $composer3.changed(popupState4);
                    value$iv = $composer3.rememberedValue();
                    if (!invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                        popupState2 = popupState4;
                        str2 = str3;
                        $composer2 = $composer3;
                        $composer$iv$iv = $composer3;
                        $composer$iv = $composer3;
                        value$iv = new Function1() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj2) {
                                Unit PushEmptyFrame$lambda$1$1$0;
                                PushEmptyFrame$lambda$1$1$0 = PushEmptyFrameKt.PushEmptyFrame$lambda$1$1$0(PushEmptyFrame.this, scope, message, actionHandler, popupState2, (LazyListScope) obj2);
                                return PushEmptyFrame$lambda$1$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv);
                    } else {
                        popupState2 = popupState4;
                        $composer2 = $composer3;
                        $composer$iv$iv = $composer3;
                        $composer$iv = $composer3;
                        str2 = str3;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState2, function0, null, null, 0.0f, null, null, null, (Function1) value$iv, $composer2, 0, 252);
                    Composer $composer4 = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer4, 119149681, str2);
                    it$iv = $composer4.rememberedValue();
                    if (it$iv != Composer.Companion.getEmpty()) {
                        maxWidth2 = maxWidth;
                        reporter3 = reporter4;
                        Object value$iv4 = ChatMsgFrameBuilderKt.m1725ChatMsgFrameScopekHDZbjc(maxWidth2, "msg", message, reporter3);
                        $composer4.updateRememberedValue(value$iv4);
                        it$iv = value$iv4;
                    } else {
                        maxWidth2 = maxWidth;
                        reporter3 = reporter4;
                    }
                    final ChatMsgFrameScope frameScope = (ChatMsgFrameScope) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    final float f2 = maxWidth2;
                    CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12()), ComposableLambdaKt.rememberComposableLambda(-1919351470, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit PushEmptyFrame$lambda$1$3;
                            PushEmptyFrame$lambda$1$3 = PushEmptyFrameKt.PushEmptyFrame$lambda$1$3(ChatMsgFrameScope.this, empty, message, f2, chatMsgModuleBuilderProvider, (Composer) obj2, ((Integer) obj3).intValue());
                            return PushEmptyFrame$lambda$1$3;
                        }
                    }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit PushEmptyFrame$lambda$1$0$0;
                    PushEmptyFrame$lambda$1$0$0 = PushEmptyFrameKt.PushEmptyFrame$lambda$1$0$0(PopupState.this);
                    return PushEmptyFrame$lambda$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            Function0 function02 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 119110576, str3);
            invalid$iv = (($dirty & 112) != 32) | (($dirty & 14) != 4) | $composer3.changedInstance(scope) | (($dirty & 7168) != 2048) | $composer3.changed(popupState4);
            value$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            popupState2 = popupState4;
            str2 = str3;
            $composer2 = $composer3;
            $composer$iv$iv = $composer3;
            $composer$iv = $composer3;
            value$iv = new Function1() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2) {
                    Unit PushEmptyFrame$lambda$1$1$0;
                    PushEmptyFrame$lambda$1$1$0 = PushEmptyFrameKt.PushEmptyFrame$lambda$1$1$0(PushEmptyFrame.this, scope, message, actionHandler, popupState2, (LazyListScope) obj2);
                    return PushEmptyFrame$lambda$1$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState2, function02, null, null, 0.0f, null, null, null, (Function1) value$iv, $composer2, 0, 252);
            Composer $composer42 = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer42, 119149681, str2);
            it$iv = $composer42.rememberedValue();
            if (it$iv != Composer.Companion.getEmpty()) {
            }
            final ChatMsgFrameScope frameScope2 = (ChatMsgFrameScope) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer42);
            final float f22 = maxWidth2;
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(BiliTheme.INSTANCE.getTextStyle($composer42, BiliTheme.$stable).getT12()), ComposableLambdaKt.rememberComposableLambda(-1919351470, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PushEmptyFrame$lambda$1$3;
                    PushEmptyFrame$lambda$1$3 = PushEmptyFrameKt.PushEmptyFrame$lambda$1$3(ChatMsgFrameScope.this, empty, message, f22, chatMsgModuleBuilderProvider, (Composer) obj2, ((Integer) obj3).intValue());
                    return PushEmptyFrame$lambda$1$3;
                }
            }, $composer42, 54), $composer42, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer42);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            reporter3 = reporter2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final ChatReporter chatReporter = reporter3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PushEmptyFrame$lambda$2;
                    PushEmptyFrame$lambda$2 = PushEmptyFrameKt.PushEmptyFrame$lambda$2(PushEmptyFrame.this, message, chatMsgModuleBuilderProvider, actionHandler, modifier5, chatReporter, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                    return PushEmptyFrame$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushEmptyFrame$lambda$1$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushEmptyFrame$lambda$1$1$0(final PushEmptyFrame $empty, final CoroutineScope $scope, final EntityMessage $message, final ChatActionHandler $actionHandler, final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        final List items$iv = $empty.getValue().getMenuItems();
        $this$PopupBubbleMenu.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$lambda$1$1$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$lambda$1$1$0$$inlined$itemsIndexed$default$3
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                Composer $composer2;
                ComposerKt.sourceInformation($composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                int $dirty = $changed;
                if (($changed & 6) == 0) {
                    $dirty |= $composer.changed($this$items) ? 4 : 2;
                }
                if (($changed & 48) == 0) {
                    $dirty |= $composer.changed(it) ? 32 : 16;
                }
                if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                    $composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                int i = ($dirty & 14) | ($dirty & 112);
                final KMsgMenuItem item = (KMsgMenuItem) items$iv.get(it);
                $composer.startReplaceGroup(-375683366);
                ComposerKt.sourceInformation($composer, "CN(index,item)*152@6240L379,162@6648L319,151@6189L948:PushEmptyFrame.kt#wmjton");
                ComposerKt.sourceInformationMarkerStart($composer, -704854536, "CC(remember):PushEmptyFrame.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance(item) | $composer.changed($message) | $composer.changed($actionHandler) | $composer.changed($popupState);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope = $scope;
                    final EntityMessage entityMessage = $message;
                    final ChatActionHandler chatActionHandler = $actionHandler;
                    final PopupState popupState = $popupState;
                    $composer2 = $composer;
                    value$iv = new Function0<Unit>() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$2$2$1$1$1$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: PushEmptyFrame.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$2$2$1$1$1$1$1", f = "PushEmptyFrame.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$2$2$1$1$1$1$1  reason: invalid class name */
                        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ ChatActionHandler $actionHandler;
                            final /* synthetic */ KMsgMenuItem $item;
                            final /* synthetic */ EntityMessage $message;
                            final /* synthetic */ PopupState $popupState;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            AnonymousClass1(KMsgMenuItem kMsgMenuItem, EntityMessage entityMessage, ChatActionHandler chatActionHandler, PopupState popupState, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$item = kMsgMenuItem;
                                this.$message = entityMessage;
                                this.$actionHandler = chatActionHandler;
                                this.$popupState = popupState;
                            }

                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$item, this.$message, this.$actionHandler, this.$popupState, continuation);
                            }

                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                            }

                            public final Object invokeSuspend(Object $result) {
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch (this.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        this.label = 1;
                                        if (MenuItemHandlerKt.menuItemClicked(this.$item, this.$message, this.$actionHandler, (Continuation) this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        break;
                                    case 1:
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                this.$popupState.setVisible(false);
                                return Unit.INSTANCE;
                            }
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1751invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1751invoke() {
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(item, entityMessage, chatActionHandler, popupState, null), 3, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    $composer2 = $composer;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Composer $composer3 = $composer2;
                PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) value$iv, ComposableLambdaKt.rememberComposableLambda(-1181017029, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.PushEmptyFrameKt$PushEmptyFrame$2$2$1$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C166@6797L9,167@6871L6,163@6674L271:PushEmptyFrame.kt#wmjton");
                        if (!$composer4.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1181017029, $changed2, -1, "kntr.app.im.chat.ui.frame.PushEmptyFrame.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PushEmptyFrame.kt:163)");
                        }
                        TextKt.Text-Nvy7gAk(item.getName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer4, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(16), 0.0f, 2, (Object) null), null, null, $composer3, 24624, 108);
                if (it != CollectionsKt.getLastIndex($empty.getValue().getMenuItems())) {
                    $composer3.startReplaceGroup(-374711796);
                    ComposerKt.sourceInformation($composer3, "177@7222L17");
                    DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer3, 0, 7);
                } else {
                    $composer3.startReplaceGroup(-381856955);
                }
                $composer3.endReplaceGroup();
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushEmptyFrame$lambda$1$3(ChatMsgFrameScope $frameScope, PushEmptyFrame $empty, EntityMessage $message, float $maxWidth, ChatMsgModuleBuilderProvider $chatMsgModuleBuilderProvider, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:PushEmptyFrame.kt#wmjton");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1919351470, $changed, -1, "kntr.app.im.chat.ui.frame.PushEmptyFrame.<anonymous>.<anonymous> (PushEmptyFrame.kt:193)");
            }
            $composer.startReplaceGroup(-1955789750);
            ComposerKt.sourceInformation($composer, "*200@8046L196");
            for (MsgModule msgModule : $empty.getModules()) {
                ChatMsgModuleContent.ComposeDefaultImpls.Content$default(msgModule, $message, SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, $maxWidth, 0.0f, 2, (Object) null), $chatMsgModuleBuilderProvider.get(Reflection.getOrCreateKotlinClass(msgModule.getClass())).buildMsgModule(), $frameScope, $composer, 384, 0);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}