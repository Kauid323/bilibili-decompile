package kntr.app.im.chat.ui.module.shareDynamicForward;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KParagraph;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.common.paragraph.impl.text.TextParagraphContent;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.im.chat.module.ShareDynamicForwardMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ChatMsgShareDynamicForwardModuleBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ShareDynamicForwardModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/ShareDynamicForwardMsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/ShareDynamicForwardMsgModule;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgShareDynamicForwardModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareDynamicForwardModule$lambda$2(ChatMsgFrameScope chatMsgFrameScope, ShareDynamicForwardMsgModule shareDynamicForwardMsgModule, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShareDynamicForwardModule(chatMsgFrameScope, shareDynamicForwardMsgModule, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShareDynamicForwardModule(final ChatMsgFrameScope frameScope, final ShareDynamicForwardMsgModule module, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Modifier materialized$iv$iv;
        ParagraphState state;
        boolean z;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(-1165823382);
        ComposerKt.sourceInformation($composer2, "C(ShareDynamicForwardModule)N(frameScope,module,actionHandler,modifier)58@2555L24,63@2711L9,63@2748L6,64@2773L526,61@2605L694,79@3304L394:ChatMsgShareDynamicForwardModuleBuilder.kt#ntb87d");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(frameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changed(actionHandler) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1165823382, $dirty2, -1, "kntr.app.im.chat.ui.module.shareDynamicForward.ShareDynamicForwardModule (ChatMsgShareDynamicForwardModuleBuilder.kt:56)");
            }
            KParagraph paragraph = module.getValue().getParagraph();
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            KModuleParagraph[] kModuleParagraphArr = {new KModuleParagraph(paragraph, false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)};
            TextStyle textStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 630208344, "CC(remember):ChatMsgShareDynamicForwardModuleBuilder.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilderKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit ShareDynamicForwardModule$lambda$0$0;
                        ShareDynamicForwardModule$lambda$0$0 = ChatMsgShareDynamicForwardModuleBuilderKt.ShareDynamicForwardModule$lambda$0$0(scope, frameScope, actionHandler, (ParagraphStateBuilderScope) obj);
                        return ShareDynamicForwardModule$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ParagraphState state2 = ParagraphStateKt.rememberParagraphState(kModuleParagraphArr, textStyle, (ParagraphBuilderProvider) null, (Function1) it$iv, $composer2, 0, 4);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            $dirty = $dirty2;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -2069087244, "C:ChatMsgShareDynamicForwardModuleBuilder.kt#ntb87d");
            $composer2.startReplaceGroup(903087040);
            ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
            Iterable $this$forEach$iv = state2.getContents();
            boolean z3 = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                TextParagraphContent textParagraphContent = (ParagraphContent) element$iv;
                boolean z4 = z3;
                if (textParagraphContent instanceof TextParagraphContent) {
                    $composer2.startReplaceGroup(1693486210);
                    ComposerKt.sourceInformation($composer2, "82@3459L209");
                    materialized$iv$iv = materialized$iv$iv2;
                    state = state2;
                    z = z2;
                    textParagraphContent.Content(SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(8)), 0.0f, 1, (Object) null), $composer2, 0);
                } else {
                    materialized$iv$iv = materialized$iv$iv2;
                    state = state2;
                    z = z2;
                    $composer2.startReplaceGroup(1690069080);
                }
                $composer2.endReplaceGroup();
                z2 = z;
                $this$forEach$iv = $this$forEach$iv2;
                z3 = z4;
                materialized$iv$iv2 = materialized$iv$iv;
                state2 = state;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareDynamicForwardModule$lambda$2;
                    ShareDynamicForwardModule$lambda$2 = ChatMsgShareDynamicForwardModuleBuilderKt.ShareDynamicForwardModule$lambda$2(ChatMsgFrameScope.this, module, actionHandler, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareDynamicForwardModule$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareDynamicForwardModule$lambda$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilderKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit ShareDynamicForwardModule$lambda$0$0$0;
                ShareDynamicForwardModule$lambda$0$0$0 = ChatMsgShareDynamicForwardModuleBuilderKt.ShareDynamicForwardModule$lambda$0$0$0($scope, $frameScope, $actionHandler, (TextParagraphBuilderScope) obj);
                return ShareDynamicForwardModule$lambda$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareDynamicForwardModule$lambda$0$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        TextNodeClickListener clickListener$iv = new TextNodeClickListener() { // from class: kntr.app.im.chat.ui.module.shareDynamicForward.ChatMsgShareDynamicForwardModuleBuilderKt$$ExternalSyntheticLambda3
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean ShareDynamicForwardModule$lambda$0$0$0$0;
                ShareDynamicForwardModule$lambda$0$0$0$0 = ChatMsgShareDynamicForwardModuleBuilderKt.ShareDynamicForwardModule$lambda$0$0$0$0($scope, $frameScope, $actionHandler, (KTextNode.KLink) iText, textNodeClickInfo);
                return ShareDynamicForwardModule$lambda$0$0$0$0;
            }
        };
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), clickListener$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ShareDynamicForwardModule$lambda$0$0$0$0(CoroutineScope $scope, ChatMsgFrameScope $frameScope, ChatActionHandler $actionHandler, KTextNode.KLink node, TextNodeClickInfo textNodeClickInfo) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(textNodeClickInfo, "<unused var>");
        if (!StringsKt.isBlank(node.getValue().getLink())) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatMsgShareDynamicForwardModuleBuilderKt$ShareDynamicForwardModule$state$1$1$1$1$1($actionHandler, node, null), 3, (Object) null);
            CardReporter.CC.reportMsgClick$default($frameScope.getCardReporter(), null, 1, null);
            return true;
        }
        return false;
    }
}