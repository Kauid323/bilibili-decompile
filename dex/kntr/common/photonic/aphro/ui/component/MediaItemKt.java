package kntr.common.photonic.aphro.ui.component;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
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
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.following.Res;
import bili.resource.following.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.Asset;
import kntr.common.photonic.AssetEntry;
import kntr.common.photonic.MimeType;
import kntr.common.photonic.aphro.core.AssetItemState;
import kntr.common.photonic.shower.AssetShower;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: MediaItem.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aU\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000f2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\u0010\u001a!\u0010\u0011\u001a\u00020\u0001*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"MediaItem", "", "item", "Lkntr/common/photonic/aphro/core/AssetItemState;", "showCheckBox", "", "showSelectIndex", "onItemClick", "Lkotlin/Function0;", "onItemCheckBoxClick", "modifier", "Landroidx/compose/ui/Modifier;", "enable", "(Lkntr/common/photonic/aphro/core/AssetItemState;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "Thumb", "Lkntr/common/photonic/Asset;", "(Lkntr/common/photonic/Asset;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Tag", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "mimeType", "Lkntr/common/photonic/MimeType;", "selected", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Lkntr/common/photonic/MimeType;ZLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class MediaItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaItem$lambda$2(AssetItemState assetItemState, boolean z, boolean z2, Function0 function0, Function0 function02, Modifier modifier, boolean z3, int i, int i2, Composer composer, int i3) {
        MediaItem(assetItemState, z, z2, function0, function02, modifier, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Tag$lambda$2(BoxWithConstraintsScope boxWithConstraintsScope, MimeType mimeType, boolean z, int i, Composer composer, int i2) {
        Tag(boxWithConstraintsScope, mimeType, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Thumb$lambda$1(Asset asset, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Thumb(asset, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void MediaItem(final AssetItemState item, final boolean showCheckBox, final boolean showSelectIndex, final Function0<Unit> function0, final Function0<Unit> function02, Modifier modifier, boolean enable, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        Modifier modifier3;
        boolean enable2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(function0, "onItemClick");
        Intrinsics.checkNotNullParameter(function02, "onItemCheckBoxClick");
        Composer $composer2 = $composer.startRestartGroup(-1896945990);
        ComposerKt.sourceInformation($composer2, "C(MediaItem)N(item,showCheckBox,showSelectIndex,onItemClick,onItemCheckBoxClick,modifier,enable)70@2546L53,73@2607L3223,66@2406L3424:MediaItem.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(item) : $composer2.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(showCheckBox) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(showSelectIndex) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= 196608;
            modifier2 = modifier;
        } else if ((196608 & $changed) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 131072 : 65536;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
            z = enable;
        } else if ((1572864 & $changed) == 0) {
            z = enable;
            $dirty |= $composer2.changed(z) ? 1048576 : 524288;
        } else {
            z = enable;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute((599187 & $dirty2) != 599186, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            enable2 = z;
        } else {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (i3 == 0) {
                enable2 = z;
            } else {
                enable2 = true;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1896945990, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.MediaItem (MediaItem.kt:60)");
            }
            Modifier itemModifier = AspectRatioKt.aspectRatio$default(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            Modifier alpha = AlphaKt.alpha(itemModifier, enable2 ? 1.0f : 0.4f);
            ComposerKt.sourceInformationMarkerStart($composer2, -1898947729, "CC(remember):MediaItem.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 7168) == 2048;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit MediaItem$lambda$0$0;
                        MediaItem$lambda$0$0 = MediaItemKt.MediaItem$lambda$0$0(function0);
                        return MediaItem$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier4 = modifier2;
            BoxWithConstraintsKt.BoxWithConstraints(ClickableKt.clickable-oSLSa3U$default(alpha, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(-1302492764, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit MediaItem$lambda$1;
                    MediaItem$lambda$1 = MediaItemKt.MediaItem$lambda$1(showCheckBox, function02, item, showSelectIndex, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return MediaItem$lambda$1;
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
            final boolean z2 = enable2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit MediaItem$lambda$2;
                    MediaItem$lambda$2 = MediaItemKt.MediaItem$lambda$2(AssetItemState.this, showCheckBox, showSelectIndex, function0, function02, modifier5, z2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return MediaItem$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaItem$lambda$0$0(Function0 $onItemClick) {
        $onItemClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaItem$lambda$1(boolean $showCheckBox, final Function0 $onItemCheckBoxClick, final AssetItemState $item, final boolean $showSelectIndex, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C130@5075L539,148@5624L94,153@5728L96:MediaItem.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1302492764, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.MediaItem.<anonymous> (MediaItem.kt:75)");
            }
            if ($showCheckBox) {
                $composer.startReplaceGroup(-1827259141);
                ComposerKt.sourceInformation($composer, "83@2960L129,76@2669L2347");
                Modifier zIndex = ZIndexModifierKt.zIndex($this$BoxWithConstraints.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), Alignment.Companion.getTopEnd()), 3.0f);
                ComposerKt.sourceInformationMarkerStart($composer, -1860051643, "CC(remember):MediaItem.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onItemCheckBoxClick);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit MediaItem$lambda$1$0$0;
                            MediaItem$lambda$1$0$0 = MediaItemKt.MediaItem$lambda$1$0$0($onItemCheckBoxClick);
                            return MediaItem$lambda$1$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(ClipKt.clip(BorderKt.border-xT4_qwU(PaddingKt.padding-qDBjuR0(ClickableKt.clickable-oSLSa3U$default(zIndex, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(13), Dp.constructor-impl(3), Dp.constructor-impl(3), Dp.constructor-impl(13)), Dp.constructor-impl(1), Color.Companion.getWhite-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape()), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.26f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
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
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1816352128, "C95@3615L1387,91@3402L1600:MediaItem.kt#gh748z");
                AnimatedVisibilityKt.AnimatedVisibility($item.getSelected(), (Modifier) null, EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(1075768907, true, new Function3() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit MediaItem$lambda$1$1$0;
                        MediaItem$lambda$1$1$0 = MediaItemKt.MediaItem$lambda$1$1$0($showSelectIndex, $item, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return MediaItem$lambda$1$1$0;
                    }
                }, $composer, 54), $composer, 200064, 18);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            } else {
                $composer.startReplaceGroup(-1829967394);
            }
            $composer.endReplaceGroup();
            AnimatedVisibilityKt.AnimatedVisibility($item.getSelected(), ZIndexModifierKt.zIndex(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 2.0f), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableSingletons$MediaItemKt.INSTANCE.m2253getLambda$1411610164$ui_debug(), $composer, 200112, 16);
            Thumb($item.getAsset(), SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 48, 0);
            Tag($this$BoxWithConstraints, $item.getAsset().getMimeType(), $item.getSelected(), $composer, ($dirty2 & 14) | (MimeType.$stable << 3));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaItem$lambda$1$0$0(Function0 $onItemCheckBoxClick) {
        $onItemCheckBoxClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MediaItem$lambda$1$1$0(boolean $showSelectIndex, AssetItemState $item, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C100@3815L6,96@3637L1347:MediaItem.kt#gh748z");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1075768907, $changed, -1, "kntr.common.photonic.aphro.ui.component.MediaItem.<anonymous>.<anonymous>.<anonymous> (MediaItem.kt:96)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (Shape) null, 2, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 435995748, "C:MediaItem.kt#gh748z");
        if ($showSelectIndex) {
            $composer.startReplaceGroup(436005047);
            ComposerKt.sourceInformation($composer, "");
            if ($item.getSelected()) {
                $composer.startReplaceGroup(436051330);
                ComposerKt.sourceInformation($composer, "105@4048L507");
                TextKt.Text-Nvy7gAk(String.valueOf($item.getSelectIndex() + 1), ZIndexModifierKt.zIndex(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f), Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 25008, 0, 261096);
            } else {
                $composer.startReplaceGroup(432050749);
            }
            $composer.endReplaceGroup();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(436670524);
            ComposerKt.sourceInformation($composer, "118@4708L18,117@4647L289");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl((float) 17.45d)), Color.Companion.getWhite-0d7_KjU(), $composer, Painter.$stable | 3504, 0);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void Thumb(final Asset item, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Intrinsics.checkNotNullParameter(item, "item");
        Composer $composer2 = $composer.startRestartGroup(-1347921879);
        ComposerKt.sourceInformation($composer2, "C(Thumb)N(item,modifier)167@5970L121:MediaItem.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(item) ? 4 : 2;
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
                ComposerKt.traceEventStart(-1347921879, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.Thumb (MediaItem.kt:164)");
            }
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(item.getClass());
            ComposerKt.sourceInformationMarkerStart($composer2, 1727201762, "CC(remember):MediaItem.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(orCreateKotlinClass);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object showerForAssetType = AssetEntry.INSTANCE.getShower().getShowerForAssetType(Reflection.getOrCreateKotlinClass(item.getClass()));
                if (!(showerForAssetType instanceof AssetShower)) {
                    showerForAssetType = null;
                }
                Object value$iv = showerForAssetType;
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            AssetShower shower = (AssetShower) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (shower == null) {
                $composer2.startReplaceGroup(2003778108);
            } else {
                $composer2.startReplaceGroup(1727205989);
                ComposerKt.sourceInformation($composer2, "170@6104L60");
                shower.Content(item, modifier, false, $composer2, ($dirty2 & 14) | 384 | ($dirty2 & 112));
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit Thumb$lambda$1;
                    Thumb$lambda$1 = MediaItemKt.Thumb$lambda$1(Asset.this, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Thumb$lambda$1;
                }
            });
        }
    }

    public static final void Tag(final BoxWithConstraintsScope $this$Tag, final MimeType mimeType, final boolean selected, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter($this$Tag, "<this>");
        Intrinsics.checkNotNullParameter(mimeType, "mimeType");
        Composer $composer3 = $composer.startRestartGroup(1450108759);
        ComposerKt.sourceInformation($composer3, "C(Tag)N(mimeType,selected):MediaItem.kt#gh748z");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed($this$Tag) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer3.changed(mimeType) : $composer3.changedInstance(mimeType) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(selected) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450108759, $dirty2, -1, "kntr.common.photonic.aphro.ui.component.Tag (MediaItem.kt:178)");
            }
            if (Intrinsics.areEqual(mimeType, MimeType.Companion.getGIF())) {
                $composer3.startReplaceGroup(1409142518);
                ComposerKt.sourceInformation($composer3, "180@6359L824,204@7217L54,207@7352L9,211@7575L7,212@7661L7,203@7192L740");
                AnimatedVisibilityKt.AnimatedVisibility(!selected, ZIndexModifierKt.zIndex(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), 2.0f), EnterExitTransitionKt.fadeIn$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), EnterExitTransitionKt.fadeOut$default(AnimationSpecKt.tween$default(250, 0, (Easing) null, 6, (Object) null), 0.0f, 2, (Object) null), (String) null, ComposableSingletons$MediaItemKt.INSTANCE.m2254getLambda$1962986678$ui_debug(), $composer3, 200112, 16);
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getFollowing_global_string_274(Res.string.INSTANCE), $composer3, 0);
                long j = Color.Companion.getWhite-0d7_KjU();
                TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12();
                long j2 = Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$Tag_u24lambda_u240 = (Density) consume;
                float y$iv = $this$Tag_u24lambda_u240.toPx-0680j_4(Dp.constructor-impl(1));
                long v1$iv$iv = Float.floatToRawIntBits(0.0f);
                long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                long j3 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Density $this$Tag_u24lambda_u241 = (Density) consume2;
                $composer2 = $composer3;
                TextKt.Text-Nvy7gAk(stringResource, ZIndexModifierKt.zIndex(PaddingKt.padding-3ABfNKs($this$Tag.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), Dp.constructor-impl(4)), 2.0f), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(t12, 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, new Shadow(j2, j3, $this$Tag_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl(2)), (DefaultConstructorMarker) null), (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16769023, (Object) null), $composer2, 384, 0, 131064);
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(1402794059);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.photonic.aphro.ui.component.MediaItemKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit Tag$lambda$2;
                    Tag$lambda$2 = MediaItemKt.Tag$lambda$2($this$Tag, mimeType, selected, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Tag$lambda$2;
                }
            });
        }
    }
}