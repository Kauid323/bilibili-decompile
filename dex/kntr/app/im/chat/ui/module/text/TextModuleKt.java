package kntr.app.im.chat.ui.module.text;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphBuilderKt;
import com.bilibili.common.paragraph.builder.ParagraphBuilderProvider;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.im.chat.module.TextMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.paragraph.ImParagraphEntryPoint;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
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

/* compiled from: TextModule.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"TextModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/TextMsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/TextMsgModule;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TextModuleKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextModule$lambda$2(ChatMsgFrameScope chatMsgFrameScope, TextMsgModule textMsgModule, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TextModule(chatMsgFrameScope, textMsgModule, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0243, code lost:
        if (r1 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TextModule(final ChatMsgFrameScope frameScope, final TextMsgModule module, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(376048596);
        ComposerKt.sourceInformation($composer2, "C(TextModule)N(frameScope,module,actionHandler,modifier)63@2703L24,65@2760L7,66@2806L7,67@2847L9,67@2884L6,88@3590L530,83@3438L682,104@4188L6,104@4202L199,104@4126L275:TextModule.kt#1u4xrv");
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
            final Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376048596, $dirty2, -1, "kntr.app.im.chat.ui.module.text.TextModule (TextModule.kt:62)");
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
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density = (Density) consume;
            CompositionLocal this_$iv2 = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ThemeDayNight dayNight = (ThemeDayNight) consume2;
            TextStyle defaultStyle = TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT16(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null);
            Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
            ParagraphBuilderProvider provider = ((ImParagraphEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(ImParagraphEntryPoint.class))).getImParagraphComponentFactory().bindSortedListDrawParams(new SortedListDrawParams(0.0f, 0.0f, 0.0f, 0.0f, 0L, 31, (DefaultConstructorMarker) null)).bindTextConfig(new TextParagraphConfig(TextStyle.copy-p1EtxEg$default(defaultStyle, 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnit.Companion.getUnspecified-XSAIIZE(), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646143, (Object) null), 0, 0, 6, (DefaultConstructorMarker) null)).bindDayNight(dayNight).bindDensity(density).build().paragraphBuilderProvider();
            KModuleParagraph[] kModuleParagraphArr = {new KModuleParagraph(module.getValue().getParagraph(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)};
            ComposerKt.sourceInformationMarkerStart($composer2, 605481158, "CC(remember):TextModule.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4) | (($dirty2 & 896) == 256);
            $dirty = $dirty2;
            Object value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.text.TextModuleKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit TextModule$lambda$0$0;
                    TextModule$lambda$0$0 = TextModuleKt.TextModule$lambda$0$0(scope, frameScope, actionHandler, (ParagraphStateBuilderScope) obj);
                    return TextModule$lambda$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final ParagraphState state = ParagraphStateKt.rememberParagraphState(kModuleParagraphArr, (TextStyle) null, provider, (Function1) value$iv, $composer2, 0, 2);
            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-1341005676, true, new Function2() { // from class: kntr.app.im.chat.ui.module.text.TextModuleKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextModule$lambda$1;
                    TextModule$lambda$1 = TextModuleKt.TextModule$lambda$1(modifier4, state, (Composer) obj, ((Integer) obj2).intValue());
                    return TextModule$lambda$1;
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        } else {
            $dirty = $dirty2;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.text.TextModuleKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextModule$lambda$2;
                    TextModule$lambda$2 = TextModuleKt.TextModule$lambda$2(ChatMsgFrameScope.this, module, actionHandler, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextModule$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextModule$lambda$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.im.chat.ui.module.text.TextModuleKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit TextModule$lambda$0$0$0;
                TextModule$lambda$0$0$0 = TextModuleKt.TextModule$lambda$0$0$0($scope, $frameScope, $actionHandler, (TextParagraphBuilderScope) obj);
                return TextModule$lambda$0$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextModule$lambda$0$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        TextNodeClickListener clickListener$iv = new TextNodeClickListener() { // from class: kntr.app.im.chat.ui.module.text.TextModuleKt$$ExternalSyntheticLambda0
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean TextModule$lambda$0$0$0$0;
                TextModule$lambda$0$0$0$0 = TextModuleKt.TextModule$lambda$0$0$0$0($scope, $frameScope, $actionHandler, (KTextNode.KLink) iText, textNodeClickInfo);
                return TextModule$lambda$0$0$0$0;
            }
        };
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), clickListener$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean TextModule$lambda$0$0$0$0(CoroutineScope $scope, ChatMsgFrameScope $frameScope, ChatActionHandler $actionHandler, KTextNode.KLink node, TextNodeClickInfo textNodeClickInfo) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(textNodeClickInfo, "<unused var>");
        if (!StringsKt.isBlank(node.getValue().getLink())) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TextModuleKt$TextModule$state$1$1$1$1$1($frameScope, $actionHandler, node, null), 3, (Object) null);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextModule$lambda$1(Modifier $modifier, ParagraphState $state, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C105@4212L183:TextModule.kt#1u4xrv");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1341005676, $changed, -1, "kntr.app.im.chat.ui.module.text.TextModule.<anonymous> (TextModule.kt:105)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            int $changed$iv = ($changed$iv$iv$iv >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1586663338, "C:TextModule.kt#1u4xrv");
            $composer.startReplaceGroup(1472838430);
            ComposerKt.sourceInformation($composer, "*107@4326L19,107@4298L73");
            Iterable $this$forEach$iv = $state.getContents();
            boolean z2 = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                ParagraphContent it = (ParagraphContent) element$iv;
                it.Content(IntrinsicKt.width(ParagraphBuilderKt.padding(Modifier.Companion, it.getSpacing(), $composer, 6), IntrinsicSize.Max), $composer, 0);
                $this$forEach$iv = $this$forEach$iv2;
                $changed$iv = $changed$iv;
                z2 = z2;
                z = z;
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