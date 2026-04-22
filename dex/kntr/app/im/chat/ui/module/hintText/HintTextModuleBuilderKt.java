package kntr.app.im.chat.ui.module.hintText;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ContentColorKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import com.bapis.bilibili.app.dynamic.v2.KLinkNodeType;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderKt;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Uri;
import im.base.IMLog;
import kntr.app.im.chat.module.notifyText.HintTextModule;
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

/* compiled from: HintTextModuleBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"HintTextModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/notifyText/HintTextModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/notifyText/HintTextModule;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HintTextModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HintTextModule$lambda$2(ChatMsgFrameScope chatMsgFrameScope, HintTextModule hintTextModule, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        HintTextModule(chatMsgFrameScope, hintTextModule, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void HintTextModule(final ChatMsgFrameScope frameScope, final HintTextModule module, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(-1920198272);
        ComposerKt.sourceInformation($composer2, "C(HintTextModule)N(frameScope,module,actionHandler,modifier)67@2591L24,71@2765L9,72@2790L1919,69@2640L2069,111@4785L6,112@4805L280,110@4714L371:HintTextModuleBuilder.kt#b88t7i");
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
            final Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1920198272, $dirty2, -1, "kntr.app.im.chat.ui.module.hintText.HintTextModule (HintTextModuleBuilder.kt:66)");
            }
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
            KModuleParagraph[] kModuleParagraphArr = {new KModuleParagraph(module.getValue().getValue().getParagraph(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)};
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12();
            ComposerKt.sourceInformationMarkerStart($composer2, 1525410687, "CC(remember):HintTextModuleBuilder.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256) | (($dirty2 & 112) == 32) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                Object value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit HintTextModule$lambda$0$0;
                        HintTextModule$lambda$0$0 = HintTextModuleBuilderKt.HintTextModule$lambda$0$0(scope, frameScope, actionHandler, module, (ParagraphStateBuilderScope) obj);
                        return HintTextModule$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            } else {
                $dirty = $dirty2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ParagraphState state = ParagraphStateKt.rememberParagraphState(kModuleParagraphArr, t12, (ParagraphBuilderProvider) null, (Function1) it$iv, $composer2, 0, 4);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-340128192, true, new Function2() { // from class: kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HintTextModule$lambda$1;
                    HintTextModule$lambda$1 = HintTextModuleBuilderKt.HintTextModule$lambda$1(modifier3, state, (Composer) obj, ((Integer) obj2).intValue());
                    return HintTextModule$lambda$1;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit HintTextModule$lambda$2;
                    HintTextModule$lambda$2 = HintTextModuleBuilderKt.HintTextModule$lambda$2(ChatMsgFrameScope.this, module, actionHandler, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return HintTextModule$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HintTextModule$lambda$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, final HintTextModule $module, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit HintTextModule$lambda$0$0$0;
                HintTextModule$lambda$0$0$0 = HintTextModuleBuilderKt.HintTextModule$lambda$0$0$0($scope, $frameScope, $actionHandler, $module, (TextParagraphBuilderScope) obj);
                return HintTextModule$lambda$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HintTextModule$lambda$0$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, final HintTextModule $module, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        TextNodeClickListener clickListener$iv = new TextNodeClickListener() { // from class: kntr.app.im.chat.ui.module.hintText.HintTextModuleBuilderKt$$ExternalSyntheticLambda0
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean HintTextModule$lambda$0$0$0$0;
                HintTextModule$lambda$0$0$0$0 = HintTextModuleBuilderKt.HintTextModule$lambda$0$0$0$0($scope, $frameScope, $actionHandler, $module, (KTextNode.KLink) iText, textNodeClickInfo);
                return HintTextModule$lambda$0$0$0$0;
            }
        };
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), clickListener$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean HintTextModule$lambda$0$0$0$0(CoroutineScope $scope, ChatMsgFrameScope $frameScope, ChatActionHandler $actionHandler, HintTextModule $module, KTextNode.KLink node, TextNodeClickInfo clickInfo) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
        if (Intrinsics.areEqual(node.getValue().getLinkTypeEnum(), KLinkNodeType.RECALL_MESSAGE.INSTANCE)) {
            Uri actionUrl = Uri.Companion.parse(node.getValue().getLink());
            String queryParameter = actionUrl.getQueryParameter("key");
            Long msgKey = queryParameter != null ? StringsKt.toLongOrNull(queryParameter) : null;
            String queryParameter2 = actionUrl.getQueryParameter("seq");
            Long sequenceNum = queryParameter2 != null ? StringsKt.toLongOrNull(queryParameter2) : null;
            if (msgKey != null && sequenceNum != null) {
                BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$1($actionHandler, msgKey, sequenceNum, null), 3, (Object) null);
            } else {
                IMLog.Companion.w("HintTextModule", "invalid recall link: " + node.getValue().getLink());
            }
        } else if (Intrinsics.areEqual(node.getValue().getLinkTypeEnum(), KLinkNodeType.IM_PUSH_INFO_MORE.INSTANCE)) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$2($module, $actionHandler, null), 3, (Object) null);
        } else if (!StringsKt.isBlank(node.getValue().getLink())) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new HintTextModuleBuilderKt$HintTextModule$state$1$1$1$1$3($actionHandler, node, null), 3, (Object) null);
        }
        CardReporter.CC.reportMsgClick$default($frameScope.getCardReporter(), null, 1, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HintTextModule$lambda$1(Modifier $modifier, ParagraphState $state, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C113@4815L264:HintTextModuleBuilder.kt#b88t7i");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-340128192, $changed, -1, "kntr.app.im.chat.ui.module.hintText.HintTextModule.<anonymous> (HintTextModuleBuilder.kt:113)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            int $changed$iv = 384;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, $modifier);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1463798128, "C:HintTextModuleBuilder.kt#b88t7i");
            $composer.startReplaceGroup(739956420);
            ComposerKt.sourceInformation($composer, "*118@5016L19,118@4988L67");
            Iterable $this$forEach$iv = $state.getContents();
            boolean z2 = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                ParagraphContent it = (ParagraphContent) element$iv;
                it.Content(SizeKt.wrapContentWidth$default(ParagraphBuilderKt.padding(Modifier.Companion, it.getSpacing(), $composer, 6), (Alignment.Horizontal) null, false, 3, (Object) null), $composer, 0);
                $this$forEach$iv = $this$forEach$iv2;
                z = z;
                z2 = z2;
                $changed$iv = $changed$iv;
                verticalArrangement$iv = verticalArrangement$iv;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}