package kntr.common.paragraph.input;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.AnimateStrategy;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kntr.common.paragraph.assetuploader.base.AssetUploadState;
import kntr.common.paragraph.assetuploader.base.OriginAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UploadingAssetUploadState;
import kntr.common.paragraph.assetuploader.base.UrlAssetUploadState;
import kntr.common.paragraph.input.RichTextAction;
import kntr.common.paragraph.input.content.AssetContent;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.paragraph.input.ui.generated.resources.Res;
import srcs.common.paragraph.input.ui.generated.resources.String0_commonMainKt;

/* compiled from: AssetParagraphContent.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\u001f\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u000f\u001a\u0017\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0001¢\u0006\u0002\u0010\u0011\u001a\u0011\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0001¢\u0006\u0002\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u001d*\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"AssetParagraphContent", "", "paragraphContent", "Lkntr/common/paragraph/input/content/AssetContent;", "index", "", "onAction", "Lkotlin/Function1;", "Lkntr/common/paragraph/input/RichTextAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/common/paragraph/input/content/AssetContent;ILkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ShowAsset", "asset", "Lkntr/common/photonic/Asset;", "(Lkntr/common/photonic/Asset;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Progress", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "toSize", "Landroidx/compose/ui/geometry/Size;", "Lkntr/common/photonic/Resolution;", "(Lkntr/common/photonic/Resolution;)J", "scaled", "Landroidx/compose/ui/unit/IntSize;", "factor", "Landroidx/compose/ui/layout/ScaleFactor;", "scaled-UQTWf7w", "(JJ)J", "scaledSize", "Landroidx/compose/ui/unit/DpSize;", "scaleFactor", "scaledSize-npqWwIg", "(Lkntr/common/photonic/Resolution;JLandroidx/compose/runtime/Composer;I)J", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetParagraphContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$1(AssetContent assetContent, int i, Function1 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        AssetParagraphContent(assetContent, i, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Progress$lambda$1(Modifier modifier, int i, int i2, Composer composer, int i3) {
        Progress(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShowAsset$lambda$1(Asset asset, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ShowAsset(asset, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void AssetParagraphContent(final AssetContent paragraphContent, final int index, final Function1<? super RichTextAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(paragraphContent, "paragraphContent");
        Intrinsics.checkNotNullParameter(function1, "onAction");
        Composer $composer2 = $composer.startRestartGroup(1559431072);
        ComposerKt.sourceInformation($composer2, "C(AssetParagraphContent)N(paragraphContent,index,onAction,modifier)62@2813L4365,62@2729L4449:AssetParagraphContent.kt#wwauus");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(paragraphContent) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(index) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i2 = i & 8;
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
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1559431072, $dirty2, -1, "kntr.common.paragraph.input.AssetParagraphContent (AssetParagraphContent.kt:61)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.sizeIn-qDBjuR0$default(modifier4, Dp.constructor-impl(46), Dp.constructor-impl(46), 0.0f, 0.0f, 12, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(2143077258, true, new Function3() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit AssetParagraphContent$lambda$0;
                    AssetParagraphContent$lambda$0 = AssetParagraphContentKt.AssetParagraphContent$lambda$0(AssetContent.this, function1, index, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return AssetParagraphContent$lambda$0;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AssetParagraphContent$lambda$1;
                    AssetParagraphContent$lambda$1 = AssetParagraphContentKt.AssetParagraphContent$lambda$1(AssetContent.this, index, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AssetParagraphContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$0(AssetContent $paragraphContent, final Function1 $onAction, final int $index, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        final AssetUploadState uploadState;
        String str;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C71@3232L23:AssetParagraphContent.kt#wwauus");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2143077258, $dirty2, -1, "kntr.common.paragraph.input.AssetParagraphContent.<anonymous> (AssetParagraphContent.kt:63)");
            }
            ParagraphAssetContentScale scale = new ParagraphAssetContentScale($this$BoxWithConstraints.getConstraints-msEJaDk(), null);
            AssetUploadState uploadState2 = $paragraphContent.getUploadState();
            float width$iv = Constraints.getMaxWidth-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            float height$iv = Constraints.getMinHeight-impl($this$BoxWithConstraints.getConstraints-msEJaDk());
            long v1$iv$iv = Float.floatToRawIntBits(width$iv);
            long v2$iv$iv = Float.floatToRawIntBits(height$iv);
            long constraintSize = Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
            long scaleFactor = scale.m2170computeScaleFactorH7hwNQA(toSize(uploadState2.getResolution()), constraintSize);
            long sizeDp = m2169scaledSizenpqWwIg(uploadState2.getResolution(), scaleFactor, $composer, 0);
            final Modifier contentModifier = ClipKt.clip(SizeKt.size-6HolHcs(Modifier.Companion, sizeDp), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            if (uploadState2 instanceof UrlAssetUploadState) {
                $composer.startReplaceGroup(-273644595);
                ComposerKt.sourceInformation($composer, "82@3768L296,76@3478L605");
                final Asset asset = ((UrlAssetUploadState) uploadState2).getAsset();
                String $this$asRequest$iv = ((UrlAssetUploadState) uploadState2).getResult().getImageUrl();
                ImageRequest $this$AssetParagraphContent_u24lambda_u240_u240 = new ImageRequest($this$asRequest$iv);
                $this$AssetParagraphContent_u24lambda_u240_u240.animateStrategy(AnimateStrategy.Balance.INSTANCE);
                uploadState = uploadState2;
                BiliImageKt.BiliImage($this$AssetParagraphContent_u24lambda_u240_u240.build(), contentModifier, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-168645619, true, new Function2() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        Unit AssetParagraphContent$lambda$0$1;
                        AssetParagraphContent$lambda$0$1 = AssetParagraphContentKt.AssetParagraphContent$lambda$0$1(Asset.this, contentModifier, (Composer) obj, ((Integer) obj2).intValue());
                        return AssetParagraphContent$lambda$0$1;
                    }
                }, $composer, 54), null, $composer, 12582912, 380);
                $composer.endReplaceGroup();
                str = "CC(remember):AssetParagraphContent.kt#9igjgp";
            } else {
                uploadState = uploadState2;
                if (uploadState instanceof UploadingAssetUploadState) {
                    str = "CC(remember):AssetParagraphContent.kt#9igjgp";
                } else if (uploadState instanceof OriginAssetUploadState) {
                    str = "CC(remember):AssetParagraphContent.kt#9igjgp";
                } else {
                    $composer.startReplaceGroup(-271856825);
                    ComposerKt.sourceInformation($composer, "123@5380L6,120@5216L226,128@5565L182,126@5459L990");
                    BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(SizeKt.height-3ABfNKs(Modifier.Companion, DpSize.getHeight-D9Ej5fM(sizeDp)), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                    Modifier align = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getCenter());
                    str = "CC(remember):AssetParagraphContent.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart($composer, -2086968896, str);
                    boolean invalid$iv = $composer.changedInstance(uploadState) | $composer.changed($onAction);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv = new Function0() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda5
                            public final Object invoke() {
                                Unit AssetParagraphContent$lambda$0$4$0;
                                AssetParagraphContent$lambda$0$4$0 = AssetParagraphContentKt.AssetParagraphContent$lambda$0$4$0(AssetUploadState.this, $onAction);
                                return AssetParagraphContent$lambda$0$4$0;
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                        it$iv = value$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                    Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv3;
                        $composer.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv3;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1655447996, "C137@5984L21,139@6105L6,136@5931L260,143@6249L46,144@6339L9,145@6396L6,142@6212L219:AssetParagraphContent.kt#wwauus");
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getImage_upload_failed(Res.string.INSTANCE), $composer, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11(), $composer, 0, 0, 131066);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                }
                $composer.startReplaceGroup(-272884630);
                ComposerKt.sourceInformation($composer, "97@4351L236,94@4236L370,105@4623L539");
                Asset asset2 = uploadState.getAsset();
                Intrinsics.checkNotNull(asset2);
                ComposerKt.sourceInformationMarkerStart($composer, -2087007690, str);
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda4
                        public final Object invoke(Object obj) {
                            Unit AssetParagraphContent$lambda$0$2$0;
                            AssetParagraphContent$lambda$0$2$0 = AssetParagraphContentKt.AssetParagraphContent$lambda$0$2$0((ContentDrawScope) obj);
                            return AssetParagraphContent$lambda$0$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ShowAsset(asset2, DrawModifierKt.drawWithContent(contentModifier, (Function1) it$iv2), $composer, 0, 0);
                Modifier modifier$iv2 = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getCenter());
                Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                int i4 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -858697914, "C110@4878L41,112@4977L42,113@5063L9,111@4940L204:AssetParagraphContent.kt#wwauus");
                Progress(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), $composer, 6, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getImage_uploading(Res.string.INSTANCE), $composer, 0), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT11(), $composer, 384, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            }
            if (uploadState instanceof UploadingAssetUploadState) {
                $composer.startReplaceGroup(-277053448);
            } else {
                $composer.startReplaceGroup(-270542611);
                ComposerKt.sourceInformation($composer, "152@6588L21,158@6881L99,162@7087L6,151@6543L619");
                Painter trash_delete_line_500 = BiliIconfont.INSTANCE.getTrash_delete_line_500($composer, 6);
                Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(PaddingKt.padding-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), Dp.constructor-impl(30)), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape());
                ComposerKt.sourceInformationMarkerStart($composer, -2086926867, str);
                boolean invalid$iv2 = $composer.changed($onAction) | $composer.changed($index);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda6
                        public final Object invoke() {
                            Unit AssetParagraphContent$lambda$0$6$0;
                            AssetParagraphContent$lambda$0$6$0 = AssetParagraphContentKt.AssetParagraphContent$lambda$0$6$0($onAction, $index);
                            return AssetParagraphContent$lambda$0$6$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                IconKt.Icon-ww6aTOc(trash_delete_line_500, (String) null, $this$BoxWithConstraints.align(PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv3, 15, (Object) null), Dp.constructor-impl(7)), Alignment.Companion.getBottomEnd()), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU(), $composer, Painter.$stable | 48, 0);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$0$1(Asset $asset, Modifier $contentModifier, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:AssetParagraphContent.kt#wwauus");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-168645619, $changed, -1, "kntr.common.paragraph.input.AssetParagraphContent.<anonymous>.<anonymous> (AssetParagraphContent.kt:83)");
            }
            if ($asset != null) {
                $composer.startReplaceGroup(990148092);
                ComposerKt.sourceInformation($composer, "84@3843L33");
                ShowAsset($asset, $contentModifier, $composer, 0, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(990243727);
                ComposerKt.sourceInformation($composer, "86@3998L6,86@3938L78");
                BoxKt.Box(BackgroundKt.background-bw27NRU$default($contentModifier, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), (Shape) null, 2, (Object) null), $composer, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$0$2$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        DrawScope.-CC.drawRect-n-J9OG0$default((DrawScope) $this$drawWithContent, Color.Companion.getBlack-0d7_KjU(), 0L, 0L, 0.5f, (DrawStyle) null, (ColorFilter) null, 0, (int) ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$0$4$0(AssetUploadState $uploadState, Function1 $onAction) {
        Asset it = $uploadState.getAsset();
        if (it != null) {
            $onAction.invoke(new RichTextAction.RetryAsset(it));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AssetParagraphContent$lambda$0$6$0(Function1 $onAction, int $index) {
        $onAction.invoke(new RichTextAction.RemoveAsset($index));
        return Unit.INSTANCE;
    }

    public static final void ShowAsset(final Asset asset, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        Composer $composer2 = $composer.startRestartGroup(222710425);
        ComposerKt.sourceInformation($composer2, "C(ShowAsset)N(asset,modifier)175@7324L102,176@7438L53:AssetParagraphContent.kt#wwauus");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(asset) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(222710425, $dirty2, -1, "kntr.common.paragraph.input.ShowAsset (AssetParagraphContent.kt:173)");
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(asset.getClass());
            ComposerKt.sourceInformationMarkerStart($composer2, -723642401, "CC(remember):AssetParagraphContent.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(orCreateKotlinClass);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(asset.getClass()));
                Intrinsics.checkNotNull(value$iv, "null cannot be cast to non-null type kntr.common.photonic.shower.AssetShower<kntr.common.photonic.Asset>");
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AssetShower shower = (AssetShower) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            shower.Content(asset, modifier, false, $composer2, ($dirty2 & 14) | 384 | ($dirty2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShowAsset$lambda$1;
                    ShowAsset$lambda$1 = AssetParagraphContentKt.ShowAsset$lambda$1(Asset.this, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ShowAsset$lambda$1;
                }
            });
        }
    }

    public static final void Progress(Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2 = $composer.startRestartGroup(-425632757);
        ComposerKt.sourceInformation($composer2, "C(Progress)N(modifier)182@7617L27,183@7649L161:AssetParagraphContent.kt#wwauus");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-425632757, $dirty2, -1, "kntr.common.paragraph.input.Progress (AssetParagraphContent.kt:181)");
            }
            String image = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer2, 0);
            $composer2.startReplaceGroup(-1011182449);
            ComposerKt.sourceInformation($composer2, "*185@7745L6");
            ImageRequest $this$Progress_u24lambda_u240 = new ImageRequest(image);
            $this$Progress_u24lambda_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(ColorFilter.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$Progress_u24lambda_u240.build();
            $composer2.endReplaceGroup();
            BiliImageKt.BiliImage(build, modifier3, null, null, null, null, null, null, null, $composer2, ($dirty2 << 3) & 112, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.paragraph.input.AssetParagraphContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Progress$lambda$1;
                    Progress$lambda$1 = AssetParagraphContentKt.Progress$lambda$1(modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Progress$lambda$1;
                }
            });
        }
    }

    public static final long toSize(Resolution $this$toSize) {
        Intrinsics.checkNotNullParameter($this$toSize, "<this>");
        float width$iv = $this$toSize.getWidthPx();
        float height$iv = $this$toSize.getHeightPx();
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        return Size.constructor-impl((v1$iv$iv << 32) | (4294967295L & v2$iv$iv));
    }

    /* renamed from: scaled-UQTWf7w  reason: not valid java name */
    public static final long m2168scaledUQTWf7w(long j, long j2) {
        int bits$iv$iv$iv = (int) (j >> 32);
        int bits$iv$iv$iv2 = (int) (j2 >> 32);
        int width$iv = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv) * Float.intBitsToFloat(bits$iv$iv$iv2));
        int bits$iv$iv$iv3 = (int) (j & 4294967295L);
        int bits$iv$iv$iv4 = (int) (j2 & 4294967295L);
        int height$iv = MathKt.roundToInt(Float.intBitsToFloat(bits$iv$iv$iv3) * Float.intBitsToFloat(bits$iv$iv$iv4));
        return IntSize.constructor-impl((width$iv << 32) | (4294967295L & height$iv));
    }

    /* renamed from: scaledSize-npqWwIg  reason: not valid java name */
    public static final long m2169scaledSizenpqWwIg(Resolution $this$scaledSize_u2dnpqWwIg, long j, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$scaledSize_u2dnpqWwIg, "$this$scaledSize");
        ComposerKt.sourceInformationMarkerStart($composer, 658366168, "C(scaledSize)N(scaleFactor:c#ui.layout.ScaleFactor)204@8233L7:AssetParagraphContent.kt#wwauus");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(658366168, $changed, -1, "kntr.common.paragraph.input.scaledSize (AssetParagraphContent.kt:204)");
        }
        CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        Density $this$scaledSize_npqWwIg_u24lambda_u240 = (Density) consume;
        int bits$iv$iv$iv = (int) (j >> 32);
        int bits$iv$iv$iv2 = (int) (4294967295L & j);
        long j2 = DpKt.DpSize-YgX7TsA($this$scaledSize_npqWwIg_u24lambda_u240.toDp-u2uoSUM($this$scaledSize_u2dnpqWwIg.getWidthPx() * Float.intBitsToFloat(bits$iv$iv$iv)), $this$scaledSize_npqWwIg_u24lambda_u240.toDp-u2uoSUM($this$scaledSize_u2dnpqWwIg.getHeightPx() * Float.intBitsToFloat(bits$iv$iv$iv2)));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return j2;
    }
}