package kntr.app.im.chat.ui.module.shareArticle;

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
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.app.dynamic.v2.KParaSpacing;
import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bilibili.common.paragraph.ParagraphState;
import com.bilibili.common.paragraph.ParagraphStateKt;
import com.bilibili.common.paragraph.builder.ParagraphContent;
import com.bilibili.common.paragraph.impl.constant.SortedListDrawParams;
import com.bilibili.common.paragraph.impl.constant.TextParagraphConfig;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import im.base.AddBiliImageKt;
import java.util.List;
import kntr.app.im.chat.module.ShareArticleMsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatMsgShareArticleModuleBuilder.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"ShareArticleModule", RoomRecommendViewModel.EMPTY_CURSOR, "module", "Lkntr/app/im/chat/module/ShareArticleMsgModule;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/im/chat/module/ShareArticleMsgModule;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatMsgShareArticleModuleBuilderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShareArticleModule$lambda$1(ShareArticleMsgModule shareArticleMsgModule, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShareArticleModule(shareArticleMsgModule, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ShareArticleModule(final ShareArticleMsgModule module, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(module, "module");
        Composer $composer3 = $composer.startRestartGroup(-1676445464);
        ComposerKt.sourceInformation($composer3, "C(ShareArticleModule)N(module,modifier)49@1914L2535:ChatMsgShareArticleModuleBuilder.kt#yg257p");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(module) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1676445464, $dirty, -1, "kntr.app.im.chat.ui.module.shareArticle.ShareArticleModule (ChatMsgShareArticleModuleBuilder.kt:45)");
            }
            List articleImages = module.getValue().getImages();
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            Composer $composer$iv$iv2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
            Modifier modifier4 = modifier3;
            CompositionLocalMap localMap$iv$iv = $composer$iv$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv2.startReusableNode();
            if ($composer$iv$iv2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer$iv$iv2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv$iv2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 1986012705, "C80@3045L9,80@3082L6,74@2740L393,95@3743L9,95@3780L6,89@3436L395:ChatMsgShareArticleModuleBuilder.kt#yg257p");
            if (articleImages.size() >= 3) {
                $composer$iv$iv2.startReplaceGroup(1985977333);
                ComposerKt.sourceInformation($composer$iv$iv2, "52@2050L343");
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(1));
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv$iv2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv2 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer$iv$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv$iv2.startReusableNode();
                if ($composer$iv$iv2.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv2.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer$iv$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv2);
                $composer$iv = $composer3;
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i6 = ((54 >> 6) & 112) | 6;
                RowScope $this$ShareArticleModule_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, 1748312743, "C:ChatMsgShareArticleModuleBuilder.kt#yg257p");
                $composer$iv$iv2.startReplaceGroup(-1190528804);
                ComposerKt.sourceInformation($composer$iv$iv2, "*59@2290L71");
                int i7 = 0;
                while (i7 < 3) {
                    AddBiliImageKt.AddBiliImage(((KPictureModule) articleImages.get(i7)).getUrl(), AspectRatioKt.aspectRatio$default(RowScope.-CC.weight$default($this$ShareArticleModule_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 1.0f, false, 2, (Object) null), $composer$iv$iv2, 0, 0);
                    i7++;
                    $changed$iv$iv$iv2 = $changed$iv$iv$iv2;
                    localMap$iv$iv2 = localMap$iv$iv2;
                    materialized$iv$iv2 = materialized$iv$iv2;
                    measurePolicy$iv$iv = measurePolicy$iv$iv;
                    $composer$iv$iv2 = $composer$iv$iv2;
                }
                $composer$iv$iv = $composer$iv$iv2;
                $composer$iv$iv2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                $composer$iv$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
                $composer$iv$iv2.endReplaceGroup();
            } else {
                $composer2 = $composer3;
                $composer$iv$iv = $composer$iv$iv2;
                $composer$iv = $composer3;
                if (articleImages.isEmpty()) {
                    $composer$iv$iv2.startReplaceGroup(1983945252);
                } else {
                    $composer$iv$iv2.startReplaceGroup(1986375218);
                    ComposerKt.sourceInformation($composer$iv$iv2, "63@2455L218");
                    AddBiliImageKt.AddBiliImage(((KPictureModule) articleImages.get(0)).getUrl(), AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.7777778f, false, 2, (Object) null), $composer$iv$iv2, 48, 0);
                }
                $composer$iv$iv2.endReplaceGroup();
            }
            ParagraphState titleState = ParagraphStateKt.rememberParagraphState(new KModuleParagraph[]{new KModuleParagraph(module.getValue().getTitle(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)}, (Density) null, (ThemeDayNight) null, (SortedListDrawParams) null, new TextParagraphConfig(TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv2, BiliTheme.$stable).getT14(), BiliTheme.INSTANCE.getColors($composer$iv$iv2, BiliTheme.$stable).getText1-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), 2, TextOverflow.Companion.getEllipsis-gIe3tQ8(), (DefaultConstructorMarker) null), (Function1) null, $composer$iv$iv2, TextParagraphConfig.$stable << 12, 46);
            float paddingTop = !articleImages.isEmpty() ? Dp.constructor-impl(8) : Dp.constructor-impl(12);
            ParagraphContent paragraphContent = (ParagraphContent) CollectionsKt.firstOrNull(titleState.getContents());
            if (paragraphContent == null) {
                $composer$iv$iv2.startReplaceGroup(1987199166);
                $composer$iv$iv2.endReplaceGroup();
            } else {
                $composer$iv$iv2.startReplaceGroup(202650531);
                ComposerKt.sourceInformation($composer$iv$iv2, "86@3276L101");
                paragraphContent.Content(PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), paddingTop, Dp.constructor-impl(12), Dp.constructor-impl(6)), $composer$iv$iv2, 0);
                $composer$iv$iv2.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            }
            ParagraphState paragraphState = ParagraphStateKt.rememberParagraphState(new KModuleParagraph[]{new KModuleParagraph(module.getValue().getSummary(), false, (KParaSpacing) null, 6, (DefaultConstructorMarker) null)}, (Density) null, (ThemeDayNight) null, (SortedListDrawParams) null, new TextParagraphConfig(TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv2, BiliTheme.$stable).getT13(), BiliTheme.INSTANCE.getColors($composer$iv$iv2, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (Object) null), 2, TextOverflow.Companion.getEllipsis-gIe3tQ8(), (DefaultConstructorMarker) null), (Function1) null, $composer$iv$iv2, TextParagraphConfig.$stable << 12, 46);
            $composer$iv$iv2.startReplaceGroup(202669364);
            ComposerKt.sourceInformation($composer$iv$iv2, "*99@3889L83");
            Iterable $this$forEach$iv = paragraphState.getContents();
            for (Object element$iv : $this$forEach$iv) {
                ParagraphContent it = (ParagraphContent) element$iv;
                it.Content(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(6), 2, (Object) null), $composer$iv$iv2, 0);
                titleState = titleState;
            }
            $composer$iv$iv2.endReplaceGroup();
            if (module.getValue().getStats().length() > 0) {
                $composer$iv$iv2.startReplaceGroup(1987996859);
                ComposerKt.sourceInformation($composer$iv$iv2, "110@4327L6,111@4375L9,104@4072L361");
                TextKt.Text-Nvy7gAk(module.getValue().getStats(), SizeKt.fillMaxSize$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(12), Dp.constructor-impl(8), 2, (Object) null), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer$iv$iv2, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv$iv2, BiliTheme.$stable).getT13(), $composer$iv$iv2, 0, 24576, 114680);
            } else {
                $composer$iv$iv2.startReplaceGroup(1983945252);
            }
            $composer$iv$iv2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            $composer$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.im.chat.ui.module.shareArticle.ChatMsgShareArticleModuleBuilderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShareArticleModule$lambda$1;
                    ShareArticleModule$lambda$1 = ChatMsgShareArticleModuleBuilderKt.ShareArticleModule$lambda$1(ShareArticleMsgModule.this, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShareArticleModule$lambda$1;
                }
            });
        }
    }
}