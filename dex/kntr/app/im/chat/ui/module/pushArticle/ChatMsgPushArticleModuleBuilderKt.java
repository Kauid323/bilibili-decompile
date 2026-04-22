package kntr.app.im.chat.ui.module.pushArticle;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.dynamic.v2.KTextNode;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.action.ParagraphStateBuilderScope;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.common.paragraph.impl.text.TextNodeClickInfo;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListener;
import com.bilibili.common.paragraph.impl.text.TextNodeClickListenerKt;
import com.bilibili.common.paragraph.impl.text.TextParagraphBuilderScope;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import im.base.AddBiliImageKt;
import java.util.List;
import kntr.app.im.chat.module.PushArticleMsgModule;
import kntr.app.im.chat.ui.ChatActionHandler;
import kntr.app.im.chat.ui.builder.ChatMsgFrameScope;
import kntr.app.im.chat.ui.neuron.CardReporter;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

/* compiled from: ChatMsgPushArticleModuleBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0001R\u00020\u0002j\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"PushArticleModule", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;", "frameScope", "module", "Lkntr/app/im/chat/module/PushArticleMsgModule;", "actionHandler", "Lkntr/app/im/chat/ui/ChatActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/ui/builder/ChatMsgFrameScope;Lkntr/app/im/chat/module/PushArticleMsgModule;Lkntr/app/im/chat/ui/ChatActionHandler;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgPushArticleModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushArticleModule$lambda$1(ChatMsgFrameScope chatMsgFrameScope, PushArticleMsgModule pushArticleMsgModule, ChatActionHandler chatActionHandler, Modifier modifier, int i, int i2, Composer composer, int i3) {
        PushArticleModule(chatMsgFrameScope, pushArticleMsgModule, chatActionHandler, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PushArticleModule(final ChatMsgFrameScope frameScope, final PushArticleMsgModule module, final ChatActionHandler actionHandler, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Object value$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(frameScope, "frameScope");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        Composer $composer2 = $composer.startRestartGroup(-1755419962);
        ComposerKt.sourceInformation($composer2, "C(PushArticleModule)N(frameScope,module,actionHandler,modifier)60@2473L24,62@2503L2805:ChatMsgPushArticleModuleBuilder.kt#imqivm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(frameScope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(module) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(actionHandler) ? 256 : 128;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1755419962, $dirty2, -1, "kntr.app.im.chat.ui.module.pushArticle.PushArticleModule (ChatMsgPushArticleModuleBuilder.kt:56)");
            }
            List articleImages = module.getValue().getCoverImg();
            boolean ifHasImage = !articleImages.isEmpty();
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            int $changed$iv = ($dirty2 >> 9) & 14;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            Modifier modifier5 = modifier4;
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -127319719, "C97@3775L9,97@3811L6,91@3470L392,112@4472L9,112@4509L6,114@4561L590,106@4165L986:ChatMsgPushArticleModuleBuilder.kt#imqivm");
            if (ifHasImage) {
                $composer2.startReplaceGroup(-127362314);
                ComposerKt.sourceInformation($composer2, RoomRecommendViewModel.EMPTY_CURSOR);
                if (articleImages.size() < 3) {
                    $composer2.startReplaceGroup(-127337762);
                    ComposerKt.sourceInformation($composer2, "67@2676L232");
                    AddBiliImageKt.AddBiliImage(((KPictureModule) articleImages.get(0)).getUrl(), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.7777778f, false, 2, (Object) null), $composer2, 48, 0);
                    $composer2.endReplaceGroup();
                    $composer$iv = $composer2;
                    $composer$iv$iv$iv = $composer2;
                } else {
                    $composer2.startReplaceGroup(-127062792);
                    ComposerKt.sourceInformation($composer2, "75@2946L462");
                    Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(1));
                    int $changed$iv2 = '6';
                    ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                    int $changed$iv$iv2 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                    $composer$iv$iv$iv = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer2.startReusableNode();
                    if ($composer2.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer2.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv4;
                        $composer2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
                    $composer$iv = $composer2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i6 = ((54 >> 6) & 112) | 6;
                    RowScope $this$PushArticleModule_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer2, -767081622, "C:ChatMsgPushArticleModuleBuilder.kt#imqivm");
                    $composer2.startReplaceGroup(1637824099);
                    ComposerKt.sourceInformation($composer2, "*82@3228L140");
                    Iterable $this$forEach$iv = CollectionsKt.take(articleImages, 3);
                    boolean z = false;
                    for (Object element$iv : $this$forEach$iv) {
                        KPictureModule it = (KPictureModule) element$iv;
                        AddBiliImageKt.AddBiliImage(it.getUrl(), AspectRatioKt.aspectRatio$default(RowScope.-CC.weight$default($this$PushArticleModule_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 1.0f, false, 2, (Object) null), $composer2, 0, 0);
                        z = z;
                        $changed$iv2 = $changed$iv2;
                        $changed$iv$iv$iv2 = $changed$iv$iv$iv2;
                        materialized$iv$iv2 = materialized$iv$iv2;
                        $this$forEach$iv = $this$forEach$iv;
                        $this$PushArticleModule_u24lambda_u240_u240 = $this$PushArticleModule_u24lambda_u240_u240;
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                }
            } else {
                $composer$iv = $composer2;
                $composer$iv$iv$iv = $composer2;
                $composer2.startReplaceGroup(-129983674);
            }
            $composer2.endReplaceGroup();
            ParagraphState titleState = ParagraphStateKt.rememberParagraphState(new KModuleParagraph[]{new KModuleParagraph(module.getValue().getTitle(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)}, (Density) null, (ThemeDayNight) null, (SortedListDrawParams) null, new TextParagraphConfig(TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getH2(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), 2, TextOverflow.Companion.getEllipsis-gIe3tQ8(), (DefaultConstructorMarker) null), (Function1) null, $composer2, TextParagraphConfig.$stable << 12, 46);
            float paddingTop = !articleImages.isEmpty() ? Dp.constructor-impl(8) : Dp.constructor-impl(12);
            ParagraphContent paragraphContent = (ParagraphContent) CollectionsKt.firstOrNull(titleState.getContents());
            if (paragraphContent == null) {
                $composer2.startReplaceGroup(-126006592);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1935597921);
                ComposerKt.sourceInformation($composer2, "103@4005L101");
                paragraphContent.Content(PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), paddingTop, Dp.constructor-impl(12), Dp.constructor-impl(6)), $composer2, 0);
                $composer2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            KModuleParagraph[] kModuleParagraphArr = {new KModuleParagraph(module.getValue().getSummary(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)};
            TextParagraphConfig textParagraphConfig = new TextParagraphConfig(TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13(), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), 2, TextOverflow.Companion.getEllipsis-gIe3tQ8(), (DefaultConstructorMarker) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1935616202, "CC(remember):ChatMsgPushArticleModuleBuilder.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 896) == 256) | (($dirty2 & 14) == 4);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                value$iv = new Function1() { // from class: kntr.app.im.chat.ui.module.pushArticle.ChatMsgPushArticleModuleBuilderKt$$ExternalSyntheticLambda2
                    public final Object invoke(Object obj) {
                        Unit PushArticleModule$lambda$0$1$0;
                        PushArticleModule$lambda$0$1$0 = ChatMsgPushArticleModuleBuilderKt.PushArticleModule$lambda$0$1$0(scope, frameScope, actionHandler, (ParagraphStateBuilderScope) obj);
                        return PushArticleModule$lambda$0$1$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ParagraphState paragraphState = ParagraphStateKt.rememberParagraphState(kModuleParagraphArr, (Density) null, (ThemeDayNight) null, (SortedListDrawParams) null, textParagraphConfig, (Function1) value$iv, $composer2, TextParagraphConfig.$stable << 12, 14);
            $composer2.startReplaceGroup(1935635666);
            ComposerKt.sourceInformation($composer2, "*130@5209L83");
            for (Object element$iv2 : paragraphState.getContents()) {
                ParagraphContent it2 = (ParagraphContent) element$iv2;
                it2.Content(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(6), 2, (Object) null), $composer2, 0);
                articleImages = articleImages;
                titleState = titleState;
                paddingTop = paddingTop;
                scope = scope;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.pushArticle.ChatMsgPushArticleModuleBuilderKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit PushArticleModule$lambda$1;
                    PushArticleModule$lambda$1 = ChatMsgPushArticleModuleBuilderKt.PushArticleModule$lambda$1(ChatMsgFrameScope.this, module, actionHandler, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PushArticleModule$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushArticleModule$lambda$0$1$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, ParagraphStateBuilderScope $this$rememberParagraphState) {
        Intrinsics.checkNotNullParameter($this$rememberParagraphState, "$this$rememberParagraphState");
        TextNodeClickListenerKt.registerTextParagraphClickListener($this$rememberParagraphState, new Function1() { // from class: kntr.app.im.chat.ui.module.pushArticle.ChatMsgPushArticleModuleBuilderKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit PushArticleModule$lambda$0$1$0$0;
                PushArticleModule$lambda$0$1$0$0 = ChatMsgPushArticleModuleBuilderKt.PushArticleModule$lambda$0$1$0$0($scope, $frameScope, $actionHandler, (TextParagraphBuilderScope) obj);
                return PushArticleModule$lambda$0$1$0$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PushArticleModule$lambda$0$1$0$0(final CoroutineScope $scope, final ChatMsgFrameScope $frameScope, final ChatActionHandler $actionHandler, TextParagraphBuilderScope $this$registerTextParagraphClickListener) {
        Intrinsics.checkNotNullParameter($this$registerTextParagraphClickListener, "$this$registerTextParagraphClickListener");
        TextNodeClickListener clickListener$iv = new TextNodeClickListener() { // from class: kntr.app.im.chat.ui.module.pushArticle.ChatMsgPushArticleModuleBuilderKt$$ExternalSyntheticLambda1
            public final boolean invoke(KTextNode.IText iText, TextNodeClickInfo textNodeClickInfo) {
                boolean PushArticleModule$lambda$0$1$0$0$0;
                PushArticleModule$lambda$0$1$0$0$0 = ChatMsgPushArticleModuleBuilderKt.PushArticleModule$lambda$0$1$0$0$0($scope, $frameScope, $actionHandler, (KTextNode.KLink) iText, textNodeClickInfo);
                return PushArticleModule$lambda$0$1$0$0$0;
            }
        };
        $this$registerTextParagraphClickListener.registerNode(Reflection.getOrCreateKotlinClass(KTextNode.KLink.class), clickListener$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PushArticleModule$lambda$0$1$0$0$0(CoroutineScope $scope, ChatMsgFrameScope $frameScope, ChatActionHandler $actionHandler, KTextNode.KLink node, TextNodeClickInfo clickInfo) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(clickInfo, "clickInfo");
        if (!StringsKt.isBlank(node.getValue().getLink())) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new ChatMsgPushArticleModuleBuilderKt$PushArticleModule$1$paragraphState$1$1$1$1$1($actionHandler, node, null), 3, (Object) null);
            CardReporter.CC.reportMsgClick$default($frameScope.getCardReporter(), null, 1, null);
            return true;
        }
        return false;
    }
}