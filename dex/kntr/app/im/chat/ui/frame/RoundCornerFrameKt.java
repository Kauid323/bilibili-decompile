package kntr.app.im.chat.ui.frame;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.ui.graphics.Shape;
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
import kntr.app.im.chat.frame.rounded.RoundedCornerFrame;
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

/* compiled from: RoundCornerFrame.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"RoundCornerFrame", RoomRecommendViewModel.EMPTY_CURSOR, "message", "Lkntr/app/im/chat/core/model/EntityMessage;", "roundCorner", "Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "chatMsgModuleBuilderProvider", "Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;", "modifier", "Landroidx/compose/ui/Modifier;", "reporter", "Lkntr/app/im/chat/ui/neuron/ChatReporter;", "(Lkntr/app/im/chat/core/model/EntityMessage;Lkntr/app/im/chat/frame/rounded/RoundedCornerFrame;Lkntr/app/im/chat/ui/ChatActionHandler;Lkntr/app/im/chat/ui/builder/ChatMsgModuleBuilderProvider;Landroidx/compose/ui/Modifier;Lkntr/app/im/chat/ui/neuron/ChatReporter;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class RoundCornerFrameKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundCornerFrame$lambda$2(EntityMessage entityMessage, RoundedCornerFrame roundedCornerFrame, ChatActionHandler chatActionHandler, ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, Modifier modifier, ChatReporter chatReporter, int i, int i2, Composer composer, int i3) {
        RoundCornerFrame(entityMessage, roundedCornerFrame, chatActionHandler, chatMsgModuleBuilderProvider, modifier, chatReporter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0428, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RoundCornerFrame(final EntityMessage message, final RoundedCornerFrame roundCorner, final ChatActionHandler actionHandler, final ChatMsgModuleBuilderProvider chatMsgModuleBuilderProvider, Modifier modifier, ChatReporter reporter, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        ChatReporter reporter2;
        Modifier modifier3;
        ChatReporter reporter3;
        int $dirty;
        String str;
        float maxWidth;
        final PopupState popupState;
        ChatReporter reporter4;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv2;
        Composer $composer$iv$iv;
        Composer $composer$iv3;
        ChatReporter reporter5;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(roundCorner, "roundCorner");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Intrinsics.checkNotNullParameter(chatMsgModuleBuilderProvider, "chatMsgModuleBuilderProvider");
        Composer $composer3 = $composer.startRestartGroup(-922305433);
        ComposerKt.sourceInformation($composer3, "C(RoundCornerFrame)N(message,roundCorner,actionHandler,chatMsgModuleBuilderProvider,modifier,reporter)119@4941L24,120@4987L37,129@5322L855,125@5179L4088:RoundCornerFrame.kt#wmjton");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(message) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(roundCorner) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(actionHandler) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(chatMsgModuleBuilderProvider) ? 2048 : 1024;
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
                ComposerKt.traceEventStart(-922305433, $dirty2, -1, "kntr.app.im.chat.ui.frame.RoundCornerFrame (RoundCornerFrame.kt:118)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PopupState popupState2 = PopupBubbleMenuKt.rememberPopupState(false, $composer3, 6, 0);
            float f = Dp.constructor-impl(400);
            Modifier modifier5 = PaddingKt.padding-VpY3zN4(modifier4, Dp.constructor-impl(16), Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer3, -1572236130, "CC(remember):RoundCornerFrame.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer3.changed(popupState2) | $composer3.changedInstance(scope) | (($dirty2 & 896) == 256) | ((458752 & $dirty2) == 131072) | (($dirty2 & 14) == 4);
            Object value$iv = $composer3.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                str = "CC(remember):RoundCornerFrame.kt#9igjgp";
                modifier3 = modifier4;
                maxWidth = f;
                popupState = popupState2;
                reporter4 = reporter2;
                value$iv = new RoundCornerFrameKt$RoundCornerFrame$1$1(roundCorner, popupState2, scope, actionHandler, reporter2, message);
                $composer3.updateRememberedValue(value$iv);
            } else {
                str = "CC(remember):RoundCornerFrame.kt#9igjgp";
                $dirty = $dirty2;
                maxWidth = f;
                popupState = popupState2;
                reporter4 = reporter2;
                modifier3 = modifier4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(modifier5, (Object) null, (PointerInputEventHandler) value$iv);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$RoundCornerFrame_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 602829806, "C155@6403L6,151@6233L3028:RoundCornerFrame.kt#wmjton");
            Modifier modifier$iv2 = $this$RoundCornerFrame_u24lambda_u241.align(BackgroundKt.background-bw27NRU$default(ClipKt.clip(Modifier.Companion, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(10))), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), Alignment.Companion.getTopCenter());
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(0));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -361422063, "C162@6713L32,163@6761L1358,160@6620L1499,199@8166L283,208@8538L9,209@8567L684,207@8462L789:RoundCornerFrame.kt#wmjton");
            ComposerKt.sourceInformationMarkerStart($composer3, -1812773717, str);
            boolean invalid$iv2 = $composer3.changed(popupState);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit RoundCornerFrame$lambda$1$0$0$0;
                    RoundCornerFrame$lambda$1$0$0$0 = RoundCornerFrameKt.RoundCornerFrame$lambda$1$0$0$0(PopupState.this);
                    return RoundCornerFrame$lambda$1$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            Function0 function0 = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1812770855, str);
            boolean invalid$iv3 = (($dirty & 112) == 32) | $composer3.changedInstance(scope) | (($dirty & 14) == 4) | (($dirty & 896) == 256) | $composer3.changed(popupState);
            Object value$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || value$iv3 == Composer.Companion.getEmpty()) {
                $composer2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer$iv$iv$iv2 = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv3 = $composer3;
                final PopupState popupState3 = popupState;
                value$iv3 = new Function1() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit RoundCornerFrame$lambda$1$0$1$0;
                        RoundCornerFrame$lambda$1$0$1$0 = RoundCornerFrameKt.RoundCornerFrame$lambda$1$0$1$0(RoundedCornerFrame.this, scope, message, actionHandler, popupState3, (LazyListScope) obj);
                        return RoundCornerFrame$lambda$1$0$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                $composer$iv$iv$iv = $composer3;
                $composer$iv$iv$iv2 = $composer3;
                $composer$iv = $composer3;
                $composer2 = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv3 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            PopupBubbleMenuKt.m1977PopupBubbleMenugNPyAyM(popupState, function0, null, null, 0.0f, null, null, null, (Function1) value$iv3, $composer$iv$iv$iv2, 0, 252);
            Composer $composer4 = $composer$iv$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer4, -1812726970, str);
            Object it$iv2 = $composer4.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                reporter5 = reporter4;
                Object value$iv4 = ChatMsgFrameBuilderKt.m1725ChatMsgFrameScopekHDZbjc(maxWidth, "msg", message, reporter5);
                $composer4.updateRememberedValue(value$iv4);
                it$iv2 = value$iv4;
            } else {
                reporter5 = reporter4;
            }
            final ChatMsgFrameScope frameScope = (ChatMsgFrameScope) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final float f2 = maxWidth;
            reporter3 = reporter5;
            CompositionLocalKt.CompositionLocalProvider(TextKt.getLocalTextStyle().provides(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13()), ComposableLambdaKt.rememberComposableLambda(-91653845, true, new Function2() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoundCornerFrame$lambda$1$0$3;
                    RoundCornerFrame$lambda$1$0$3 = RoundCornerFrameKt.RoundCornerFrame$lambda$1$0$3(ChatMsgFrameScope.this, roundCorner, message, f2, chatMsgModuleBuilderProvider, (Composer) obj, ((Integer) obj2).intValue());
                    return RoundCornerFrame$lambda$1$0$3;
                }
            }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            reporter3 = reporter2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final ChatReporter chatReporter = reporter3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit RoundCornerFrame$lambda$2;
                    RoundCornerFrame$lambda$2 = RoundCornerFrameKt.RoundCornerFrame$lambda$2(EntityMessage.this, roundCorner, actionHandler, chatMsgModuleBuilderProvider, modifier6, chatReporter, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RoundCornerFrame$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundCornerFrame$lambda$1$0$0$0(PopupState $popupState) {
        $popupState.setVisible(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RoundCornerFrame$lambda$1$0$1$0(final RoundedCornerFrame $roundCorner, final CoroutineScope $scope, final EntityMessage $message, final ChatActionHandler $actionHandler, final PopupState $popupState, LazyListScope $this$PopupBubbleMenu) {
        Intrinsics.checkNotNullParameter($this$PopupBubbleMenu, "$this$PopupBubbleMenu");
        final List items$iv = $roundCorner.getValue().getMenuItems();
        $this$PopupBubbleMenu.items(items$iv.size(), (Function1) null, new Function1<Integer, Object>() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$lambda$1$0$1$0$$inlined$itemsIndexed$default$2
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke(((Number) p1).intValue());
            }

            public final Object invoke(int index) {
                items$iv.get(index);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$lambda$1$0$1$0$$inlined$itemsIndexed$default$3
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
                $composer.startReplaceGroup(756521967);
                ComposerKt.sourceInformation($composer, "CN(index,item)*168@6960L415,178@7408L351,167@6905L1044:RoundCornerFrame.kt#wmjton");
                ComposerKt.sourceInformationMarkerStart($composer, 1825520245, "CC(remember):RoundCornerFrame.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance(item) | $composer.changed($message) | $composer.changed($actionHandler) | $composer.changed($popupState);
                Object value$iv = $composer.rememberedValue();
                if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                    final CoroutineScope coroutineScope = $scope;
                    final EntityMessage entityMessage = $message;
                    final ChatActionHandler chatActionHandler = $actionHandler;
                    final PopupState popupState = $popupState;
                    $composer2 = $composer;
                    value$iv = new Function0<Unit>() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$2$1$2$1$1$1$1

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* compiled from: RoundCornerFrame.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$2$1$2$1$1$1$1$1", f = "RoundCornerFrame.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {}, v = 1)
                        /* renamed from: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$2$1$2$1$1$1$1$1  reason: invalid class name */
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
                            m1757invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: collision with other method in class */
                        public final void m1757invoke() {
                            BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(item, entityMessage, chatActionHandler, popupState, null), 3, (Object) null);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    $composer2 = $composer;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Composer $composer3 = $composer2;
                PopupBubbleMenuKt.PopupBubbleMenuItem((Function0) value$iv, ComposableLambdaKt.rememberComposableLambda(-1373591724, true, new Function2<Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.frame.RoundCornerFrameKt$RoundCornerFrame$2$1$2$1$1$2
                    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                        invoke((Composer) p1, ((Number) p2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C182@7573L9,183@7651L6,179@7438L295:RoundCornerFrame.kt#wmjton");
                        if (!$composer4.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1373591724, $changed2, -1, "kntr.app.im.chat.ui.frame.RoundCornerFrame.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RoundCornerFrame.kt:179)");
                        }
                        TextKt.Text-Nvy7gAk(item.getName(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), $composer4, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), null, false, PaddingKt.PaddingValues-YgX7TsA$default(Dp.constructor-impl(16), 0.0f, 2, (Object) null), null, null, $composer3, 24624, 108);
                if (it != CollectionsKt.getLastIndex($roundCorner.getValue().getMenuItems())) {
                    $composer3.startReplaceGroup(757595403);
                    ComposerKt.sourceInformation($composer3, "193@8048L17");
                    DividerKt.VerticalDivider-9IZ8Weo((Modifier) null, 0.0f, 0L, $composer3, 0, 7);
                } else {
                    $composer3.startReplaceGroup(749634572);
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
    public static final Unit RoundCornerFrame$lambda$1$0$3(ChatMsgFrameScope $frameScope, RoundedCornerFrame $roundCorner, EntityMessage $message, float $maxWidth, ChatMsgModuleBuilderProvider $chatMsgModuleBuilderProvider, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:RoundCornerFrame.kt#wmjton");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-91653845, $changed, -1, "kntr.app.im.chat.ui.frame.RoundCornerFrame.<anonymous>.<anonymous>.<anonymous> (RoundCornerFrame.kt:210)");
            }
            $composer.startReplaceGroup(2114971551);
            ComposerKt.sourceInformation($composer, "*216@8902L295");
            for (MsgModule msgModule : $roundCorner.getModules()) {
                ChatMsgModuleContent.ComposeDefaultImpls.Content$default(msgModule, $message, SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, 0.0f, $maxWidth, 1, (Object) null), $chatMsgModuleBuilderProvider.get(Reflection.getOrCreateKotlinClass(msgModule.getClass())).buildMsgModule(), $frameScope, $composer, 384, 0);
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