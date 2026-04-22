package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
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
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.LabelObject;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.mall.product.details.page.utils.HelperKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LabelComponent.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aW\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a7\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0019\u001a1\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a7\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\u0010\u0019\u001aA\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"LabelRowComponent", "", "models", "", "Lkntr/app/mall/product/details/page/api/model/LabelObject;", "scale", "", "itemHeight", "Landroidx/compose/ui/unit/Dp;", "spacing", "modifier", "Landroidx/compose/ui/Modifier;", "onClick", "Lkotlin/Function1;", "LabelRowComponent-1yyLQnY", "(Ljava/util/List;FFFLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LabelComponent", "model", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "LabelComponent-TN_CM5M", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;FFLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TextComponent", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/text/TextStyle;Lkntr/app/mall/product/details/page/api/model/LabelObject;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ImageComponent", "ImageComponent-942rkJo", "(Lkntr/app/mall/product/details/page/api/model/LabelObject;FFLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TextWithBackgroundComponent", "ImageWithTextComponent", "isLeftIcon", "", "(Landroidx/compose/ui/text/TextStyle;Lkntr/app/mall/product/details/page/api/model/LabelObject;Landroidx/compose/foundation/layout/PaddingValues;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LabelComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageComponent_942rkJo$lambda$0(LabelObject labelObject, float f, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m490ImageComponent942rkJo(labelObject, f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageComponent_942rkJo$lambda$1(LabelObject labelObject, float f, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m490ImageComponent942rkJo(labelObject, f, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ImageWithTextComponent$lambda$1(TextStyle textStyle, LabelObject labelObject, PaddingValues paddingValues, float f, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        ImageWithTextComponent(textStyle, labelObject, paddingValues, f, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelComponent_TN_CM5M$lambda$0(LabelObject labelObject, float f, float f2, TextStyle textStyle, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m491LabelComponentTN_CM5M(labelObject, f, f2, textStyle, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelRowComponent_1yyLQnY$lambda$1(List list, float f, float f2, float f3, Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        m492LabelRowComponent1yyLQnY(list, f, f2, f3, modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextComponent$lambda$1(TextStyle textStyle, LabelObject labelObject, float f, PaddingValues paddingValues, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TextComponent(textStyle, labelObject, f, paddingValues, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextWithBackgroundComponent$lambda$1(TextStyle textStyle, LabelObject labelObject, float f, PaddingValues paddingValues, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TextWithBackgroundComponent(textStyle, labelObject, f, paddingValues, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: LabelRowComponent-1yyLQnY  reason: not valid java name */
    public static final void m492LabelRowComponent1yyLQnY(final List<LabelObject> list, final float scale, final float f, final float f2, Modifier modifier, Function1<? super LabelObject, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        final Function1 onClick;
        Modifier modifier3;
        Function1 onClick2;
        Function0 value$iv;
        Intrinsics.checkNotNullParameter(list, "models");
        Composer $composer2 = $composer.startRestartGroup(1483543850);
        ComposerKt.sourceInformation($composer2, "C(LabelRowComponent)N(models,scale,itemHeight:c#ui.unit.Dp,spacing:c#ui.unit.Dp,modifier,onClick)48@1886L21,44@1775L983:LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(scale) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            onClick = function1;
        } else if ((196608 & $changed) == 0) {
            onClick = function1;
            $dirty |= $composer2.changedInstance(onClick) ? 131072 : 65536;
        } else {
            onClick = function1;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                onClick = null;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1483543850, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.LabelRowComponent (LabelComponent.kt:43)");
            }
            Modifier modifier$iv = ScrollKt.horizontalScroll$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(f2);
            Alignment.Vertical verticalAlignment$iv = centerVertically;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            Composer $composer3 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer3, -1528449638, "C:LabelComponent.kt#o90vz8");
            $composer3.startReplaceGroup(89242722);
            ComposerKt.sourceInformation($composer3, "*67@2608L78,55@2157L585");
            List<LabelObject> $this$forEachIndexed$iv = list;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final LabelObject model = (LabelObject) item$iv;
                TextStyle scaled = ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(17), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646137, (DefaultConstructorMarker) null), scale);
                Modifier modifier5 = SizeKt.height-3ABfNKs(Modifier.Companion, f);
                Composer $composer$iv2 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer3, -701456416, "CC(remember):LabelComponent.kt#9igjgp");
                boolean invalid$iv = ((458752 & $dirty2) == 131072) | $composer2.changed(model);
                Composer $this$cache$iv = $composer3;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                    value$iv = it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Composer $composer4 = $composer3;
                    m491LabelComponentTN_CM5M(model, scale, f, scaled, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), $composer4, ($dirty2 & 112) | ($dirty2 & 896), 0);
                    localMap$iv$iv = localMap$iv$iv;
                    index$iv = index$iv2;
                    verticalAlignment$iv = verticalAlignment$iv;
                    onClick = onClick;
                    $composer3 = $composer4;
                    $composer$iv = $composer$iv2;
                    modifier4 = modifier4;
                }
                value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit LabelRowComponent_1yyLQnY$lambda$0$0$0$0;
                        LabelRowComponent_1yyLQnY$lambda$0$0$0$0 = LabelComponentKt.LabelRowComponent_1yyLQnY$lambda$0$0$0$0(onClick, model);
                        return LabelRowComponent_1yyLQnY$lambda$0$0$0$0;
                    }
                };
                $this$cache$iv.updateRememberedValue(value$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Composer $composer42 = $composer3;
                m491LabelComponentTN_CM5M(model, scale, f, scaled, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), $composer42, ($dirty2 & 112) | ($dirty2 & 896), 0);
                localMap$iv$iv = localMap$iv$iv;
                index$iv = index$iv2;
                verticalAlignment$iv = verticalAlignment$iv;
                onClick = onClick;
                $composer3 = $composer42;
                $composer$iv = $composer$iv2;
                modifier4 = modifier4;
            }
            Composer $composer5 = $composer3;
            onClick2 = onClick;
            modifier3 = modifier4;
            $composer5.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onClick2 = onClick;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function12 = onClick2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit LabelRowComponent_1yyLQnY$lambda$1;
                    LabelRowComponent_1yyLQnY$lambda$1 = LabelComponentKt.LabelRowComponent_1yyLQnY$lambda$1(list, scale, f, f2, modifier6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LabelRowComponent_1yyLQnY$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit LabelRowComponent_1yyLQnY$lambda$0$0$0$0(Function1 $onClick, LabelObject $model) {
        if ($onClick != null) {
            $onClick.invoke($model);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: LabelComponent-TN_CM5M  reason: not valid java name */
    public static final void m491LabelComponentTN_CM5M(final LabelObject model, final float scale, final float f, final TextStyle textStyle, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Composer $composer2 = $composer.startRestartGroup(-1132557624);
        ComposerKt.sourceInformation($composer2, "C(LabelComponent)N(model,scale,itemHeight:c#ui.unit.Dp,textStyle,modifier):LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(model) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(scale) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(f) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(textStyle) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1132557624, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.LabelComponent (LabelComponent.kt:83)");
            }
            Integer tagType = model.getTagType();
            int type = tagType != null ? tagType.intValue() : 1;
            switch (type) {
                case 1:
                    $composer2.startReplaceGroup(1239154219);
                    ComposerKt.sourceInformation($composer2, "89@3031L239");
                    TextComponent(textStyle, model, scale, PaddingKt.PaddingValues-YgX7TsA$default(ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 2, (Object) null), modifier3, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | ($dirty2 & 57344), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 2:
                    $composer2.startReplaceGroup(1239415456);
                    ComposerKt.sourceInformation($composer2, "100@3334L169");
                    m490ImageComponent942rkJo(model, scale, f, modifier3, $composer2, ($dirty2 & 14) | ($dirty2 & 112) | ($dirty2 & 896) | (($dirty2 >> 3) & 7168), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 3:
                    $composer2.startReplaceGroup(1239683389);
                    ComposerKt.sourceInformation($composer2, "110@3564L253");
                    TextWithBackgroundComponent(textStyle, model, scale, PaddingKt.PaddingValues-YgX7TsA$default(ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 2, (Object) null), modifier3, $composer2, (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896) | ($dirty2 & 57344), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 4:
                    $composer2.startReplaceGroup(1240002534);
                    ComposerKt.sourceInformation($composer2, "121@3885L276");
                    ImageWithTextComponent(textStyle, model, PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 11, (Object) null), scale, modifier3, true, $composer2, 196608 | (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 6) & 7168) | ($dirty2 & 57344), 0);
                    $composer2.endReplaceGroup();
                    break;
                case 5:
                    $composer2.startReplaceGroup(1240345022);
                    ComposerKt.sourceInformation($composer2, "133@4230L284");
                    ImageWithTextComponent(textStyle, model, PaddingKt.PaddingValues-YgX7TsA$default(ProvideUiScaleKt.dpScaled(6, scale), 0.0f, 2, (Object) null), scale, modifier3, false, $composer2, 196608 | (($dirty2 >> 9) & 14) | (($dirty2 << 3) & 112) | (($dirty2 << 6) & 7168) | ($dirty2 & 57344), 0);
                    $composer2.endReplaceGroup();
                    break;
                default:
                    $composer2.startReplaceGroup(1236139066);
                    $composer2.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit LabelComponent_TN_CM5M$lambda$0;
                    LabelComponent_TN_CM5M$lambda$0 = LabelComponentKt.LabelComponent_TN_CM5M$lambda$0(LabelObject.this, scale, f, textStyle, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return LabelComponent_TN_CM5M$lambda$0;
                }
            });
        }
    }

    public static final void TextComponent(final TextStyle textStyle, final LabelObject model, final float scale, final PaddingValues padding, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Composer $composer3 = $composer.startRestartGroup(-2122402522);
        ComposerKt.sourceInformation($composer3, "C(TextComponent)N(textStyle,model,scale,padding,modifier)155@4777L15,161@4902L16,162@4970L16,157@4798L548:LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(model) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(padding) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2122402522, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.TextComponent (LabelComponent.kt:153)");
            }
            String text = model.getTitle();
            if (text == null) {
                text = "";
            }
            Color color = model.m306getTitleColor6MYuD4A$product_details_page_debug($composer3, ($dirty2 >> 3) & 14);
            float dpScaled = ProvideUiScaleKt.dpScaled(model.getBorderWidth$product_details_page_debug($composer3, ($dirty2 >> 3) & 14), scale);
            Color m305getBorderColor6MYuD4A$product_details_page_debug = model.m305getBorderColor6MYuD4A$product_details_page_debug($composer3, ($dirty2 >> 3) & 14);
            long j = m305getBorderColor6MYuD4A$product_details_page_debug != null ? m305getBorderColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
            Integer cornerRadius = model.getCornerRadius();
            Modifier modifier$iv = PaddingKt.padding(BorderKt.border-xT4_qwU(modifier4, dpScaled, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius != null ? cornerRadius.intValue() : 4, scale))), padding);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 656843624, "C167@5197L143:LabelComponent.kt#o90vz8");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, color != null ? color.unbox-impl() : textStyle.getColor-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer3, 0, (($dirty2 << 21) & 29360128) | 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextComponent$lambda$1;
                    TextComponent$lambda$1 = LabelComponentKt.TextComponent$lambda$1(textStyle, model, scale, padding, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextComponent$lambda$1;
                }
            });
        }
    }

    /* renamed from: ImageComponent-942rkJo  reason: not valid java name */
    public static final void m490ImageComponent942rkJo(final LabelObject model, final float scale, final float f, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        double d;
        Intrinsics.checkNotNullParameter(model, "model");
        Composer $composer3 = $composer.startRestartGroup(323537911);
        ComposerKt.sourceInformation($composer3, "C(ImageComponent)N(model,scale,itemHeight:c#ui.unit.Dp,modifier)184@5528L10,199@5918L187:LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(model) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(scale) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(f) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if ($composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323537911, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ImageComponent (LabelComponent.kt:183)");
            }
            String imgUrl = model.getBgImg$product_details_page_debug($composer3, $dirty2 & 14);
            Double backImgWidth = model.getBackImgWidth();
            double originalWidth = backImgWidth != null ? backImgWidth.doubleValue() : 0.0d;
            Double backImgHeight = model.getBackImgHeight();
            double originalHeight = backImgHeight != null ? backImgHeight.doubleValue() : 0.0d;
            if (originalHeight > 0.0d) {
                d = (f / originalHeight) * originalWidth;
            } else {
                d = scale * originalWidth;
            }
            double imgWidth = d;
            String str = imgUrl;
            if (str == null || str.length() == 0) {
                z = true;
            }
            if (!z) {
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(imgUrl);
                Modifier modifier5 = modifier4;
                $composer2 = $composer3;
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(modifier4, Dp.constructor-impl((float) imgWidth)), f), null, null, null, null, null, null, null, $composer2, 0, 508);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier6 = modifier4;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit ImageComponent_942rkJo$lambda$0;
                            ImageComponent_942rkJo$lambda$0 = LabelComponentKt.ImageComponent_942rkJo$lambda$0(LabelObject.this, scale, f, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return ImageComponent_942rkJo$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageComponent_942rkJo$lambda$1;
                    ImageComponent_942rkJo$lambda$1 = LabelComponentKt.ImageComponent_942rkJo$lambda$1(LabelObject.this, scale, f, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageComponent_942rkJo$lambda$1;
                }
            });
        }
    }

    public static final void TextWithBackgroundComponent(final TextStyle textStyle, final LabelObject model, final float scale, final PaddingValues padding, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Composer $composer3 = $composer.startRestartGroup(694967858);
        ComposerKt.sourceInformation($composer3, "C(TextWithBackgroundComponent)N(textStyle,model,scale,padding,modifier)218@6367L15,219@6415L12,229@6830L16,230@6898L16,220@6453L821:LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(model) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(scale) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(padding) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(694967858, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.TextWithBackgroundComponent (LabelComponent.kt:216)");
            }
            String text = model.getTitle();
            if (text == null) {
                text = "";
            }
            Color color = model.m306getTitleColor6MYuD4A$product_details_page_debug($composer3, ($dirty2 >> 3) & 14);
            Color m304getBgColor6MYuD4A$product_details_page_debug = model.m304getBgColor6MYuD4A$product_details_page_debug($composer3, ($dirty2 >> 3) & 14);
            long backgroundColor = m304getBgColor6MYuD4A$product_details_page_debug != null ? m304getBgColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
            Integer cornerRadius = model.getCornerRadius();
            Modifier clip = ClipKt.clip(modifier4, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius != null ? cornerRadius.intValue() : 4, scale)));
            Integer cornerRadius2 = model.getCornerRadius();
            Modifier modifier5 = BackgroundKt.background-bw27NRU(clip, backgroundColor, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius2 != null ? cornerRadius2.intValue() : 4, scale)));
            float dpScaled = ProvideUiScaleKt.dpScaled(model.getBorderWidth$product_details_page_debug($composer3, ($dirty2 >> 3) & 14), scale);
            Color m305getBorderColor6MYuD4A$product_details_page_debug = model.m305getBorderColor6MYuD4A$product_details_page_debug($composer3, ($dirty2 >> 3) & 14);
            long j = m305getBorderColor6MYuD4A$product_details_page_debug != null ? m305getBorderColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
            Integer cornerRadius3 = model.getCornerRadius();
            Modifier modifier$iv = PaddingKt.padding(BorderKt.border-xT4_qwU(modifier5, dpScaled, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius3 != null ? cornerRadius3.intValue() : 4, scale))), padding);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 455762268, "C235@7125L143:LabelComponent.kt#o90vz8");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, color != null ? color.unbox-impl() : textStyle.getColor-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer3, 0, (($dirty2 << 21) & 29360128) | 24576, 114682);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextWithBackgroundComponent$lambda$1;
                    TextWithBackgroundComponent$lambda$1 = LabelComponentKt.TextWithBackgroundComponent$lambda$1(textStyle, model, scale, padding, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextWithBackgroundComponent$lambda$1;
                }
            });
        }
    }

    public static final void ImageWithTextComponent(final TextStyle textStyle, final LabelObject model, final PaddingValues padding, final float scale, Modifier modifier, boolean isLeftIcon, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Composer $composer2;
        Modifier modifier3;
        boolean isLeftIcon2;
        Modifier modifier4;
        String bgImg$product_details_page_debug;
        Double backImgWidth;
        Double backImgHeight;
        Composer $composer$iv;
        char c;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(padding, "padding");
        Composer $composer4 = $composer.startRestartGroup(588792933);
        ComposerKt.sourceInformation($composer4, "C(ImageWithTextComponent)N(textStyle,model,padding,scale,modifier,isLeftIcon)267@8131L13,271@8324L16,272@8392L16,259@7829L1741:LabelComponent.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(textStyle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(model) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(padding) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            z = isLeftIcon;
        } else if ((196608 & $changed) == 0) {
            z = isLeftIcon;
            $dirty |= $composer4.changed(z) ? 131072 : 65536;
        } else {
            z = isLeftIcon;
        }
        int $dirty2 = $dirty;
        boolean z2 = true;
        if ($composer4.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                isLeftIcon2 = z;
            } else {
                isLeftIcon2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(588792933, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.ImageWithTextComponent (LabelComponent.kt:253)");
            }
            if (isLeftIcon2) {
                $composer4.startReplaceGroup(-1105666097);
                ComposerKt.sourceInformation($composer4, "254@7577L10");
                bgImg$product_details_page_debug = model.getBgImg$product_details_page_debug($composer4, ($dirty2 >> 3) & 14);
            } else {
                $composer4.startReplaceGroup(-1105667018);
                ComposerKt.sourceInformation($composer4, "254@7548L17");
                bgImg$product_details_page_debug = model.getRightIconImg$product_details_page_debug($composer4, ($dirty2 >> 3) & 14);
            }
            $composer4.endReplaceGroup();
            String img = bgImg$product_details_page_debug;
            double imgHeight = 0.0d;
            double imgWidth = (isLeftIcon2 ? (backImgWidth = model.getBackImgWidth()) == null : (backImgWidth = model.getRightIconImgWidth()) == null) ? 0.0d : backImgWidth.doubleValue();
            if (isLeftIcon2 ? (backImgHeight = model.getBackImgHeight()) != null : (backImgHeight = model.getRightIconImgHeight()) != null) {
                imgHeight = backImgHeight.doubleValue();
            }
            String title = model.getTitle();
            if (title == null) {
                title = "";
            }
            double imgHeight2 = imgHeight;
            String text = title;
            Integer cornerRadius = model.getCornerRadius();
            Modifier clip = ClipKt.clip(modifier4, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius != null ? cornerRadius.intValue() : 4, scale)));
            Brush brush = Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, model.getBgColors$product_details_page_debug($composer4, ($dirty2 >> 3) & 14), 0.0f, 0.0f, 0, 14, (Object) null);
            Integer cornerRadius2 = model.getCornerRadius();
            Modifier background$default = BackgroundKt.background$default(clip, brush, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius2 != null ? cornerRadius2.intValue() : 4, scale)), 0.0f, 4, (Object) null);
            float dpScaled = ProvideUiScaleKt.dpScaled(model.getBorderWidth$product_details_page_debug($composer4, ($dirty2 >> 3) & 14), scale);
            Color m305getBorderColor6MYuD4A$product_details_page_debug = model.m305getBorderColor6MYuD4A$product_details_page_debug($composer4, ($dirty2 >> 3) & 14);
            long j = m305getBorderColor6MYuD4A$product_details_page_debug != null ? m305getBorderColor6MYuD4A$product_details_page_debug.unbox-impl() : Color.Companion.getTransparent-0d7_KjU();
            Integer cornerRadius3 = model.getCornerRadius();
            Modifier modifier$iv = PaddingKt.padding(BorderKt.border-xT4_qwU(background$default, dpScaled, j, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(ProvideUiScaleKt.dpScaled(cornerRadius3 != null ? cornerRadius3.intValue() : 4, scale))), padding);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 980377020, "C290@9105L15,287@9017L159:LabelComponent.kt#o90vz8");
            String str = img;
            if ((str == null || str.length() == 0) || !isLeftIcon2) {
                $composer$iv = $composer4;
                c = 2;
                $composer4.startReplaceGroup(971786113);
                $composer4.endReplaceGroup();
            } else {
                $composer4.startReplaceGroup(980398223);
                ComposerKt.sourceInformation($composer4, "278@8684L260,285@8957L41");
                String $this$asRequest_u24default$iv = HelperKt.customizedImageUrl(img);
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(imgWidth, scale)), ProvideUiScaleKt.dpScaled(imgHeight2, scale)), null, null, null, null, null, null, null, $composer4, 0, 508);
                $composer$iv = $composer4;
                c = 2;
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale)), $composer4, 0);
                $composer4.endReplaceGroup();
            }
            Color m306getTitleColor6MYuD4A$product_details_page_debug = model.m306getTitleColor6MYuD4A$product_details_page_debug($composer4, ($dirty2 >> 3) & 14);
            modifier3 = modifier5;
            $composer2 = $composer4;
            Composer $composer$iv2 = $composer$iv;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, m306getTitleColor6MYuD4A$product_details_page_debug != null ? m306getTitleColor6MYuD4A$product_details_page_debug.unbox-impl() : textStyle.getColor-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, textStyle, $composer4, 0, (($dirty2 << 21) & 29360128) | 24576, 114682);
            String str2 = img;
            if (str2 != null && str2.length() != 0) {
                z2 = false;
            }
            if (z2 || isLeftIcon2) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(971786113);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(980949775);
                ComposerKt.sourceInformation($composer3, "294@9240L41,295@9294L260");
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(2, scale)), $composer3, 0);
                String $this$asRequest_u24default$iv2 = HelperKt.customizedImageUrl(img);
                BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv2).build(), SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, ProvideUiScaleKt.dpScaled(imgWidth, scale)), ProvideUiScaleKt.dpScaled(imgHeight2, scale)), null, null, null, null, null, null, null, $composer3, 0, 508);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            isLeftIcon2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final boolean z3 = isLeftIcon2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.LabelComponentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ImageWithTextComponent$lambda$1;
                    ImageWithTextComponent$lambda$1 = LabelComponentKt.ImageWithTextComponent$lambda$1(textStyle, model, padding, scale, modifier6, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return ImageWithTextComponent$lambda$1;
                }
            });
        }
    }
}