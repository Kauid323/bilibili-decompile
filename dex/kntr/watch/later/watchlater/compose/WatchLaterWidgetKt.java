package kntr.watch.later.watchlater.compose;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.CommonRes;
import bili.resource.common.String0_commonMainKt;
import bili.resource.favorites.FavoritesRes;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.watch.later.watchlater.utils.IconResEnumKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: WatchLaterWidget.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0099\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001aI\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u000e2\b\b\u0002\u0010\u001f\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u000eH\u0001¢\u0006\u0004\b!\u0010\"\u001a7\u0010#\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\u00132\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u0018H\u0001¢\u0006\u0002\u0010'\u001am\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u00100\u001aC\u00101\u001a\u00020\u0001*\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u00020\t2\u001c\u00106\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000108\u0012\u0006\u0012\u0004\u0018\u00010407H\u0001¢\u0006\u0002\u00109¨\u0006:"}, d2 = {"IconText", "", "text", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "iconType", "", "leftPadding", "Landroidx/compose/ui/unit/Dp;", "iconSize", "textColor", "Landroidx/compose/ui/graphics/Color;", "iconTint", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "isFlipped", "", "clickable", "alpha", "", "onClick", "Lkotlin/Function0;", "IconText-H8uBujs", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/painter/Painter;IFFJJLandroidx/compose/ui/text/TextStyle;ZZFLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "WatchLaterCheckBox", "checked", "checkedColor", "unCheckedColor", "checkedIcon", "checkedIconTint", "WatchLaterCheckBox-X34t5lA", "(ZLandroidx/compose/ui/Modifier;JJLandroidx/compose/ui/graphics/painter/Painter;JLandroidx/compose/runtime/Composer;II)V", "PageLoadingView", "paintResource", "showRetry", "onRetryClick", "(Ljava/lang/String;Landroidx/compose/ui/graphics/painter/Painter;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "FooterBatchEditView", "checkedAll", "checkedCount", "onCheckAllClick", "onCancelAllClick", "onDeleteClick", "onClickCopyTo", "onClickMoveTo", "(ZILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "OnBottomReached", "Landroidx/compose/foundation/lazy/LazyListState;", "key", "", "buffer", "loadMore", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterWidgetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FooterBatchEditView$lambda$1(boolean z, int i, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        FooterBatchEditView(z, i, function0, function02, function03, function04, function05, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$4(String str, Modifier modifier, Painter painter, int i, float f, float f2, long j, long j2, TextStyle textStyle, boolean z, boolean z2, float f3, Function0 function0, int i2, int i3, int i4, Composer composer, int i5) {
        m2598IconTextH8uBujs(str, modifier, painter, i, f, f2, j, j2, textStyle, z, z2, f3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnBottomReached$lambda$3(LazyListState lazyListState, Object obj, int i, Function1 function1, int i2, int i3, Composer composer, int i4) {
        OnBottomReached(lazyListState, obj, i, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageLoadingView$lambda$2(String str, Painter painter, boolean z, Function0 function0, int i, int i2, Composer composer, int i3) {
        PageLoadingView(str, painter, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$1(boolean z, Modifier modifier, long j, long j2, Painter painter, long j3, int i, int i2, Composer composer, int i3) {
        m2599WatchLaterCheckBoxX34t5lA(z, modifier, j, j2, painter, j3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:233:0x03fb, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:254:0x056b, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L114;
     */
    /* renamed from: IconText-H8uBujs  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2598IconTextH8uBujs(final String text, Modifier modifier, Painter icon, int iconType, float f, float f2, long j, long j2, TextStyle textStyle, boolean isFlipped, boolean clickable, float alpha, Function0<Unit> function0, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Painter icon2;
        int iconType2;
        float f3;
        float f4;
        long j3;
        long j4;
        TextStyle textStyle2;
        boolean isFlipped2;
        boolean clickable2;
        float alpha2;
        Function0 onClick;
        Modifier modifier3;
        Painter icon3;
        int iconType3;
        float f5;
        float f6;
        long j5;
        Modifier modifier4;
        int iconType4;
        Painter icon4;
        long j6;
        long j7;
        TextStyle textStyle3;
        final boolean isFlipped3;
        boolean clickable3;
        float alpha3;
        float f7;
        final Function0 onClick2;
        final float alpha4;
        int $dirty;
        int iconType5;
        Painter painter;
        int iconType6;
        Modifier modifier5;
        Function0 factory$iv$iv$iv;
        float f8;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer $composer3 = $composer.startRestartGroup(-2005076094);
        ComposerKt.sourceInformation($composer3, "C(IconText)N(text,modifier,icon,iconType,leftPadding:c#ui.unit.Dp,iconSize:c#ui.unit.Dp,textColor:c#ui.graphics.Color,iconTint:c#ui.graphics.Color,textStyle,isFlipped,clickable,alpha,onClick)88@3679L50,73@3173L1272:WatchLaterWidget.kt#b3vx81");
        int $dirty2 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(text) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= ($changed & 512) == 0 ? $composer3.changed(icon) : $composer3.changedInstance(icon) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty2 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changed(iconType) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty2 |= $composer3.changed(f) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changed(f2) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changed(j) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            if ((i & 128) == 0 && $composer3.changed(j2)) {
                i3 = 8388608;
                $dirty2 |= i3;
            }
            i3 = 4194304;
            $dirty2 |= i3;
        }
        if ((100663296 & $changed) == 0) {
            if ((i & 256) == 0 && $composer3.changed(textStyle)) {
                i2 = 67108864;
                $dirty2 |= i2;
            }
            i2 = 33554432;
            $dirty2 |= i2;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty2 |= 805306368;
        } else if ((805306368 & $changed) == 0) {
            $dirty2 |= $composer3.changed(isFlipped) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changed(clickable) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer3.changed(alpha) ? 32 : 16;
        }
        int i13 = i & 4096;
        if (i13 != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 384) == 0) {
            $dirty1 |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if ($composer3.shouldExecute((($dirty2 & 306783379) == 306783378 && ($dirty1 & 147) == 146) ? false : true, $dirty2 & 1)) {
            $composer3.startDefaults();
            ComposerKt.sourceInformation($composer3, "65@2913L7,66@2964L7");
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 128) != 0) {
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    modifier2 = modifier;
                    icon2 = icon;
                    iconType5 = iconType;
                    f3 = f;
                    f7 = f2;
                    j3 = j;
                    j4 = j2;
                    textStyle2 = textStyle;
                    clickable2 = clickable;
                    alpha4 = alpha;
                    onClick2 = function0;
                    $dirty = (-234881025) & $dirty2;
                    isFlipped3 = isFlipped;
                } else {
                    modifier2 = modifier;
                    icon2 = icon;
                    iconType5 = iconType;
                    f3 = f;
                    f7 = f2;
                    j3 = j;
                    j4 = j2;
                    textStyle2 = textStyle;
                    isFlipped3 = isFlipped;
                    clickable2 = clickable;
                    alpha4 = alpha;
                    onClick2 = function0;
                    $dirty = $dirty2;
                }
            } else {
                if (i4 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i5 == 0) {
                    icon3 = icon;
                } else {
                    icon3 = null;
                }
                if (i6 == 0) {
                    iconType3 = iconType;
                } else {
                    iconType3 = 0;
                }
                if (i7 == 0) {
                    f5 = f;
                } else {
                    f5 = Dp.constructor-impl(4);
                }
                if (i8 == 0) {
                    f6 = f2;
                } else {
                    f6 = Dp.constructor-impl(16);
                }
                if (i9 != 0) {
                    j5 = Color.Companion.getUnspecified-0d7_KjU();
                } else {
                    j5 = j;
                }
                float f9 = f6;
                if ((i & 128) == 0) {
                    modifier4 = modifier3;
                    iconType4 = iconType3;
                    icon4 = icon3;
                    j6 = j2;
                } else {
                    CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
                    modifier4 = modifier3;
                    iconType4 = iconType3;
                    icon4 = icon3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    j6 = ((Color) consume).unbox-impl();
                    $dirty2 &= -29360129;
                }
                if ((i & 256) != 0) {
                    CompositionLocal this_$iv2 = TextKt.getLocalTextStyle();
                    j7 = j6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer3.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    textStyle3 = (TextStyle) consume2;
                    $dirty2 &= -234881025;
                } else {
                    j7 = j6;
                    textStyle3 = textStyle;
                }
                if (i10 != 0) {
                    isFlipped3 = false;
                } else {
                    isFlipped3 = isFlipped;
                }
                if (i11 == 0) {
                    clickable3 = clickable;
                } else {
                    clickable3 = false;
                }
                if (i12 == 0) {
                    alpha3 = alpha;
                } else {
                    alpha3 = 1.0f;
                }
                if (i13 == 0) {
                    j4 = j7;
                    clickable2 = clickable3;
                    textStyle2 = textStyle3;
                    f3 = f5;
                    j3 = j5;
                    modifier2 = modifier4;
                    icon2 = icon4;
                    f7 = f9;
                    onClick2 = function0;
                    alpha4 = alpha3;
                    $dirty = $dirty2;
                    iconType5 = iconType4;
                } else {
                    j4 = j7;
                    clickable2 = clickable3;
                    textStyle2 = textStyle3;
                    f3 = f5;
                    j3 = j5;
                    modifier2 = modifier4;
                    icon2 = icon4;
                    f7 = f9;
                    alpha4 = alpha3;
                    $dirty = $dirty2;
                    onClick2 = null;
                    iconType5 = iconType4;
                }
            }
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2005076094, $dirty, $dirty1, "kntr.watch.later.watchlater.compose.IconText (WatchLaterWidget.kt:71)");
            }
            if (iconType5 > 0) {
                $composer3.startReplaceGroup(1562205721);
                ComposerKt.sourceInformation($composer3, "72@3135L23");
                painter = IconResEnumKt.getIconByType(iconType5, $composer3, ($dirty >> 9) & 14);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1562206630);
                $composer3.endReplaceGroup();
                painter = icon2;
            }
            Painter iconRes = painter;
            if (clickable2) {
                $composer3.startReplaceGroup(1183882735);
                ComposerKt.sourceInformation($composer3, "81@3456L99,78@3318L21");
                ComposerKt.sourceInformationMarkerStart($composer3, 1562216069, "CC(remember):WatchLaterWidget.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                iconType6 = iconType5;
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 1562211575, "CC(remember):WatchLaterWidget.kt#9igjgp");
                boolean invalid$iv = ($dirty1 & 896) == 256;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda8
                        public final Object invoke() {
                            Unit IconText_H8uBujs$lambda$1$0;
                            IconText_H8uBujs$lambda$1$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$1$0(onClick2);
                            return IconText_H8uBujs$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                modifier5 = ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null);
                $composer3.endReplaceGroup();
            } else {
                iconType6 = iconType5;
                $composer3.startReplaceGroup(1184201136);
                $composer3.endReplaceGroup();
                modifier5 = modifier2;
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 1562223156, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv2 = ($dirty1 & 112) == 32;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    Unit IconText_H8uBujs$lambda$2$0;
                    IconText_H8uBujs$lambda$2$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$2$0(alpha4, (GraphicsLayerScope) obj);
                    return IconText_H8uBujs$lambda$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = GraphicsLayerModifierKt.graphicsLayer(modifier5, (Function1) it$iv3);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i15 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 11010921, "C107@4265L174:WatchLaterWidget.kt#b3vx81");
            if (iconRes != null) {
                $composer3.startReplaceGroup(11038572);
                ComposerKt.sourceInformation($composer3, "102@4140L91,94@3838L408");
                Modifier modifier6 = SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, f3, 0.0f, 11, (Object) null), f7);
                ComposerKt.sourceInformationMarkerStart($composer3, -969465895, "CC(remember):WatchLaterWidget.kt#9igjgp");
                boolean invalid$iv3 = (1879048192 & $dirty) == 536870912;
                f8 = f7;
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv4 = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda10
                    public final Object invoke(Object obj) {
                        Unit IconText_H8uBujs$lambda$3$0$0;
                        IconText_H8uBujs$lambda$3$0$0 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$3$0$0(isFlipped3, (GraphicsLayerScope) obj);
                        return IconText_H8uBujs$lambda$3$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(iconRes, "", GraphicsLayerModifierKt.graphicsLayer(modifier6, (Function1) it$iv4), j4, $composer3, Painter.$stable | 48 | (($dirty >> 12) & 7168), 0);
            } else {
                f8 = f7;
                $composer3.startReplaceGroup(7217636);
            }
            $composer3.endReplaceGroup();
            onClick = onClick2;
            alpha2 = alpha4;
            $composer2 = $composer3;
            isFlipped2 = isFlipped3;
            iconType2 = iconType6;
            f4 = f8;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, textStyle2, $composer3, ($dirty & 14) | (($dirty >> 12) & 896), (29360128 & ($dirty >> 3)) | 24960, 110586);
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
            modifier2 = modifier;
            icon2 = icon;
            iconType2 = iconType;
            f3 = f;
            f4 = f2;
            j3 = j;
            j4 = j2;
            textStyle2 = textStyle;
            isFlipped2 = isFlipped;
            clickable2 = clickable;
            alpha2 = alpha;
            onClick = function0;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            final Painter painter2 = icon2;
            final int i16 = iconType2;
            final float f10 = f3;
            final float f11 = f4;
            final long j8 = j3;
            final long j9 = j4;
            final TextStyle textStyle4 = textStyle2;
            final boolean z = isFlipped2;
            final boolean z2 = clickable2;
            final float f12 = alpha2;
            final Function0 function02 = onClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2) {
                    Unit IconText_H8uBujs$lambda$4;
                    IconText_H8uBujs$lambda$4 = WatchLaterWidgetKt.IconText_H8uBujs$lambda$4(text, modifier7, painter2, i16, f10, f11, j8, j9, textStyle4, z, z2, f12, function02, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return IconText_H8uBujs$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$1$0(Function0 $onClick) {
        if ($onClick != null) {
            $onClick.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$2$0(float $alpha, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setAlpha($alpha);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconText_H8uBujs$lambda$3$0$0(boolean $isFlipped, GraphicsLayerScope $this$graphicsLayer) {
        Intrinsics.checkNotNullParameter($this$graphicsLayer, "$this$graphicsLayer");
        $this$graphicsLayer.setScaleY($isFlipped ? -1.0f : 1.0f);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x0300, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L99;
     */
    /* renamed from: WatchLaterCheckBox-X34t5lA  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2599WatchLaterCheckBoxX34t5lA(final boolean checked, Modifier modifier, long j, long j2, Painter checkedIcon, long j3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long j4;
        long j5;
        long j6;
        Painter checkedIcon2;
        int $dirty;
        Modifier modifier3;
        long j7;
        long j8;
        long j9;
        long j10;
        int $dirty2;
        long j11;
        Function0 factory$iv$iv$iv;
        int i2;
        int i3;
        int i4;
        int i5;
        Painter checkedIcon3 = checkedIcon;
        Composer $composer2 = $composer.startRestartGroup(135669089);
        ComposerKt.sourceInformation($composer2, "C(WatchLaterCheckBox)N(checked,modifier,checkedColor:c#ui.graphics.Color,unCheckedColor:c#ui.graphics.Color,checkedIcon,checkedIconTint:c#ui.graphics.Color)126@4784L911:WatchLaterWidget.kt#b3vx81");
        int $dirty3 = $changed;
        if (($changed & 6) == 0) {
            $dirty3 |= $composer2.changed(checked) ? 4 : 2;
        }
        int i6 = i & 2;
        if (i6 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0 && $composer2.changed(j)) {
                i5 = 256;
                $dirty3 |= i5;
            }
            i5 = 128;
            $dirty3 |= i5;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j4 = j2;
                if ($composer2.changed(j4)) {
                    i4 = 2048;
                    $dirty3 |= i4;
                }
            } else {
                j4 = j2;
            }
            i4 = 1024;
            $dirty3 |= i4;
        } else {
            j4 = j2;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                if ((32768 & $changed) == 0 ? $composer2.changed(checkedIcon3) : $composer2.changedInstance(checkedIcon3)) {
                    i3 = 16384;
                    $dirty3 |= i3;
                }
            }
            i3 = 8192;
            $dirty3 |= i3;
        }
        if ((196608 & $changed) == 0) {
            if ((i & 32) == 0) {
                j5 = j3;
                if ($composer2.changed(j5)) {
                    i2 = 131072;
                    $dirty3 |= i2;
                }
            } else {
                j5 = j3;
            }
            i2 = 65536;
            $dirty3 |= i2;
        } else {
            j5 = j3;
        }
        if ($composer2.shouldExecute((74899 & $dirty3) != 74898, $dirty3 & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "121@4587L6,122@4644L6,123@4698L18,124@4757L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty3 &= -57345;
                }
                if ((i & 32) != 0) {
                    $dirty3 &= -458753;
                }
                j10 = j4;
                $dirty2 = $dirty3;
                j11 = j;
            } else {
                if (i6 != 0) {
                    modifier2 = (Modifier) Modifier.Companion;
                }
                if ((i & 4) == 0) {
                    j9 = j;
                } else {
                    j9 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $dirty3 &= -897;
                }
                if ((i & 8) == 0) {
                    j10 = j4;
                } else {
                    j10 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU();
                    $dirty3 &= -7169;
                }
                if ((i & 16) != 0) {
                    checkedIcon3 = BiliIconfont.INSTANCE.getCheckmark_line_500($composer2, 6);
                    $dirty3 &= -57345;
                }
                if ((i & 32) == 0) {
                    $dirty2 = $dirty3;
                    j11 = j9;
                } else {
                    j5 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU();
                    $dirty2 = $dirty3 & (-458753);
                    j11 = j9;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(135669089, $dirty2, -1, "kntr.watch.later.watchlater.compose.WatchLaterCheckBox (WatchLaterWidget.kt:125)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier2;
            modifier3 = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            j7 = j5;
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
            checkedIcon2 = checkedIcon3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i8 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -157193979, "C133@4962L17,134@4991L376,129@4834L533:WatchLaterWidget.kt#b3vx81");
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, -420709512, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit WatchLaterCheckBox_X34t5lA$lambda$0$0$0;
                        WatchLaterCheckBox_X34t5lA$lambda$0$0$0 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$0$0$0((ContentDrawScope) obj);
                        return WatchLaterCheckBox_X34t5lA$lambda$0$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier drawWithContent = DrawModifierKt.drawWithContent(fillMaxSize$default, (Function1) it$iv);
            ComposerKt.sourceInformationMarkerStart($composer2, -420708225, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 14) == 4) | (((($dirty2 & 896) ^ 384) > 256 && $composer2.changed(j11)) || ($dirty2 & 384) == 256) | (((($dirty2 & 7168) ^ 3072) > 2048 && $composer2.changed(j10)) || ($dirty2 & 3072) == 2048);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            final long j12 = j11;
            final long j13 = j10;
            Object value$iv2 = new Function1() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit WatchLaterCheckBox_X34t5lA$lambda$0$1$0;
                    WatchLaterCheckBox_X34t5lA$lambda$0$1$0 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$0$1$0(checked, j12, j13, (DrawScope) obj);
                    return WatchLaterCheckBox_X34t5lA$lambda$0$1$0;
                }
            };
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(drawWithContent, (Function1) it$iv2, $composer2, 0);
            if (checked) {
                $composer2.startReplaceGroup(-156647481);
                ComposerKt.sourceInformation($composer2, "148@5403L276");
                IconKt.Icon-ww6aTOc(checkedIcon2, (String) null, PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(3)), j7, $composer2, Painter.$stable | 432 | (($dirty2 >> 12) & 14) | (($dirty2 >> 6) & 7168), 0);
            } else {
                $composer2.startReplaceGroup(-162016805);
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
            j6 = j11;
            j8 = j10;
            $dirty = $dirty2;
        } else {
            $composer2.skipToGroupEnd();
            j6 = j;
            checkedIcon2 = checkedIcon3;
            $dirty = $dirty3;
            modifier3 = modifier2;
            j7 = j5;
            j8 = j4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final long j14 = j6;
            final long j15 = j8;
            final Painter painter = checkedIcon2;
            final long j16 = j7;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit WatchLaterCheckBox_X34t5lA$lambda$1;
                    WatchLaterCheckBox_X34t5lA$lambda$1 = WatchLaterWidgetKt.WatchLaterCheckBox_X34t5lA$lambda$1(checked, modifier4, j14, j15, painter, j16, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WatchLaterCheckBox_X34t5lA$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$0$0$0(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatchLaterCheckBox_X34t5lA$lambda$0$1$0(boolean $checked, long j, long j2, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        if ($checked) {
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j, 0.0f, 0L, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 126, (Object) null);
        } else {
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j2, (Size.getMinDimension-impl($this$Canvas.getSize-NH-jbRc()) - $this$Canvas.toPx-0680j_4(Dp.constructor-impl(2))) / 2, 0L, 0.0f, new Stroke($this$Canvas.toPx-0680j_4(Dp.constructor-impl(1)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, (int) ConstantsKt.RESERVATION_CARD_HEIGHT, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v17 */
    public static final void PageLoadingView(final String text, final Painter paintResource, boolean showRetry, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 function02;
        Composer $composer2;
        boolean showRetry2;
        Function0 onRetryClick;
        Composer $composer3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(paintResource, "paintResource");
        Composer $composer4 = $composer.startRestartGroup(-345692220);
        ComposerKt.sourceInformation($composer4, "C(PageLoadingView)N(text,paintResource,showRetry,onRetryClick)166@5850L2,168@5862L1056:WatchLaterWidget.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer4.changed(paintResource) : $composer4.changedInstance(paintResource) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            z = showRetry;
        } else if (($changed & 384) == 0) {
            z = showRetry;
            $dirty |= $composer4.changed(z) ? 256 : 128;
        } else {
            z = showRetry;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function02 = function0;
        } else if (($changed & 3072) == 0) {
            function02 = function0;
            $dirty |= $composer4.changedInstance(function02) ? 2048 : 1024;
        } else {
            function02 = function0;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            if (i2 != 0) {
                showRetry2 = false;
            } else {
                showRetry2 = z;
            }
            if (i3 == 0) {
                onRetryClick = function02;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer4, -1497737466, "CC(remember):WatchLaterWidget.kt#9igjgp");
                Object it$iv = $composer4.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onRetryClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                onRetryClick = onRetryClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-345692220, $dirty2, -1, "kntr.watch.later.watchlater.compose.PageLoadingView (WatchLaterWidget.kt:167)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.Companion;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 612873664, "C169@5931L138,174@6078L40,175@6163L6,175@6195L9,175@6127L82:WatchLaterWidget.kt#b3vx81");
            ImageKt.Image(paintResource, (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer4, (($dirty2 >> 3) & 14) | Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(6)), $composer4, 6);
            $composer2 = $composer4;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, $dirty2 & 14, 0, 131066);
            if (showRetry2) {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(613163885);
                ComposerKt.sourceInformation($composer3, "177@6247L41,179@6330L57,181@6469L9,182@6518L6,186@6676L6,178@6301L601");
                SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), $composer3, 6);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_432(CommonRes.INSTANCE.getString()), $composer3, 0), PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15))), false, (String) null, (Role) null, (MutableInteractionSource) null, onRetryClick, 15, (Object) null), Dp.constructor-impl(27), Dp.constructor-impl(5)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 0, 0, 130040);
            } else {
                $composer3 = $composer4;
                $composer3.startReplaceGroup(606958708);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
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
            showRetry2 = z;
            onRetryClick = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = showRetry2;
            final Function0 function03 = onRetryClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PageLoadingView$lambda$2;
                    PageLoadingView$lambda$2 = WatchLaterWidgetKt.PageLoadingView$lambda$2(text, paintResource, z2, function03, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PageLoadingView$lambda$2;
                }
            });
        }
    }

    public static final void FooterBatchEditView(final boolean checkedAll, final int checkedCount, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, final Function0<Unit> function04, final Function0<Unit> function05, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Object it$iv;
        Function0 factory$iv$iv$iv3;
        boolean z;
        String str;
        long j;
        long j2;
        long j3;
        long j4;
        Intrinsics.checkNotNullParameter(function0, "onCheckAllClick");
        Intrinsics.checkNotNullParameter(function02, "onCancelAllClick");
        Intrinsics.checkNotNullParameter(function03, "onDeleteClick");
        Intrinsics.checkNotNullParameter(function04, "onClickCopyTo");
        Intrinsics.checkNotNullParameter(function05, "onClickMoveTo");
        Composer $composer3 = $composer.startRestartGroup(-758249236);
        ComposerKt.sourceInformation($composer3, "C(FooterBatchEditView)N(checkedAll,checkedCount,onCheckAllClick,onCancelAllClick,onDeleteClick,onClickCopyTo,onClickMoveTo,modifier)206@7219L5844:WatchLaterWidget.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(checkedAll) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(checkedCount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function03) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function04) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(function05) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changed(modifier) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            } else {
                modifier2 = modifier;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-758249236, $dirty2, -1, "kntr.watch.later.watchlater.compose.FooterBatchEditView (WatchLaterWidget.kt:205)");
            }
            int $changed$iv = ($dirty2 >> 21) & 14;
            Modifier modifier$iv = modifier2;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 10302932, "C209@7272L559,230@8010L6,225@7840L200,241@8377L99,238@8239L3,244@8529L6,232@8049L5008:WatchLaterWidget.kt#b3vx81");
            BoxKt.Box(BackgroundKt.background$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(32)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), Color.box-impl(Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 6);
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), 0.0f, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer3, 6, 2);
            Modifier modifier3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(48));
            ComposerKt.sourceInformationMarkerStart($composer3, -1662205959, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv);
                it$iv2 = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1662210471, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit unit;
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv3 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU$default(ClickableKt.clickable-O2vRcR0$default(modifier3, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((384 >> 6) & 112) | 6;
            RowScope $this$FooterBatchEditView_u24lambda_u240_u242 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 826006320, "C254@8900L99,248@8662L950,273@9625L38,284@10108L9,293@10552L107,274@9676L1025,298@10714L40,300@10796L57,301@10889L9,310@11330L107,299@10767L712,315@11492L40,317@11574L63,318@11673L9,327@12114L107,316@11545L718,332@12276L40,334@12358L63,335@12457L9,344@12898L107,333@12329L718:WatchLaterWidget.kt#b3vx81");
            Modifier modifier4 = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer3, 2104858677, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(MutableInteractionSource);
                it$iv = MutableInteractionSource;
            } else {
                it$iv = it$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            Modifier modifier$iv3 = ClickableKt.clickable-O2vRcR0$default(modifier4, (MutableInteractionSource) it$iv, (Indication) null, false, (String) null, (Role) null, function0, 28, (Object) null);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 381288951, "C260@9120L185,266@9322L39,268@9411L63,269@9514L9,270@9567L6,267@9378L220:WatchLaterWidget.kt#b3vx81");
            m2599WatchLaterCheckBoxX34t5lA(checkedAll, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), 0L, 0L, null, 0L, $composer3, ($dirty2 & 14) | 48, 60);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer3, 6);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_241(FavoritesRes.INSTANCE.getString()), $composer3, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$FooterBatchEditView_u24lambda_u240_u242, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer3, 0);
            if (checkedCount <= 0) {
                z = true;
                $composer3.startReplaceGroup(827162433);
                ComposerKt.sourceInformation($composer3, "282@9987L63");
                String stringResource = StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_226(FavoritesRes.INSTANCE.getString()), $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource;
            } else {
                $composer3.startReplaceGroup(826953152);
                ComposerKt.sourceInformation($composer3, "277@9773L160");
                z = true;
                String stringResource2 = StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_237(FavoritesRes.INSTANCE.getString()), new Object[]{Integer.valueOf(checkedCount)}, $composer3, 0);
                $composer3.endReplaceGroup();
                str = stringResource2;
            }
            TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(2104899735);
                ComposerKt.sourceInformation($composer3, "285@10179L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(2104900631);
                ComposerKt.sourceInformation($composer3, "285@10207L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j5 = j;
            Modifier modifier5 = Modifier.Companion;
            boolean z2 = checkedCount > 0 ? z : false;
            ComposerKt.sourceInformationMarkerStart($composer3, 2104911549, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv3 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv3);
                it$iv5 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(str, ClickableKt.clickable-O2vRcR0$default(modifier5, (MutableInteractionSource) it$iv5, (Indication) null, z2, (String) null, (Role) null, function02, 24, (Object) null), j5, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t13, $composer3, 0, 0, 131064);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource3 = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_113(CommonRes.INSTANCE.getString()), $composer3, 0);
            TextStyle t132 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(2104924727);
                ComposerKt.sourceInformation($composer3, "302@10960L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(2104925623);
                ComposerKt.sourceInformation($composer3, "302@10988L6");
                j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j6 = j2;
            Modifier modifier6 = Modifier.Companion;
            boolean z3 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, 2104936445, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv6 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(stringResource3, ClickableKt.clickable-O2vRcR0$default(modifier6, (MutableInteractionSource) it$iv6, (Indication) null, z3, (String) null, (Role) null, function03, 24, (Object) null), j6, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t132, $composer3, 0, 0, 131064);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource4 = StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_121(FavoritesRes.INSTANCE.getString()), $composer3, 0);
            TextStyle t133 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(2104949815);
                ComposerKt.sourceInformation($composer3, "319@11744L6");
                j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(2104950711);
                ComposerKt.sourceInformation($composer3, "319@11772L6");
                j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j7 = j3;
            Modifier modifier7 = Modifier.Companion;
            boolean z4 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, 2104961533, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.Companion.getEmpty()) {
                Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv5);
                it$iv7 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(stringResource4, ClickableKt.clickable-O2vRcR0$default(modifier7, (MutableInteractionSource) it$iv7, (Indication) null, z4, (String) null, (Role) null, function04, 24, (Object) null), j7, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t133, $composer3, 0, 0, 131064);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer3, 6);
            String stringResource5 = StringResourcesKt.stringResource(bili.resource.favorites.String0_commonMainKt.getFavorites_global_string_152(FavoritesRes.INSTANCE.getString()), $composer3, 0);
            TextStyle t134 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13();
            if (checkedCount > 0) {
                $composer3.startReplaceGroup(2104974903);
                ComposerKt.sourceInformation($composer3, "336@12528L6");
                j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
            } else {
                $composer3.startReplaceGroup(2104975799);
                ComposerKt.sourceInformation($composer3, "336@12556L6");
                j4 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer3.endReplaceGroup();
            long j8 = j4;
            Modifier modifier8 = Modifier.Companion;
            boolean z5 = checkedCount > 0;
            ComposerKt.sourceInformationMarkerStart($composer3, 2104986621, "CC(remember):WatchLaterWidget.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.Companion.getEmpty()) {
                Object value$iv6 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv6);
                it$iv8 = value$iv6;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(stringResource5, ClickableKt.clickable-O2vRcR0$default(modifier8, (MutableInteractionSource) it$iv8, (Indication) null, z5, (String) null, (Role) null, function05, 24, (Object) null), j8, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t134, $composer3, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
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
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier9 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit FooterBatchEditView$lambda$1;
                    FooterBatchEditView$lambda$1 = WatchLaterWidgetKt.FooterBatchEditView$lambda$1(checkedAll, checkedCount, function0, function02, function03, function04, function05, modifier9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FooterBatchEditView$lambda$1;
                }
            });
        }
    }

    public static final void OnBottomReached(final LazyListState $this$OnBottomReached, final Object key, int buffer, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer $composer, final int $changed, final int i) {
        int i2;
        int buffer2;
        final int buffer3;
        Intrinsics.checkNotNullParameter($this$OnBottomReached, "<this>");
        Intrinsics.checkNotNullParameter(function1, "loadMore");
        Composer $composer2 = $composer.startRestartGroup(-1374293250);
        ComposerKt.sourceInformation($composer2, "C(OnBottomReached)N(key,buffer,loadMore)370@13462L395,380@13920L156,380@13862L215:WatchLaterWidget.kt#b3vx81");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$OnBottomReached) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(key) ? 32 : 16;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 384;
            i2 = buffer;
        } else if (($changed & 384) == 0) {
            i2 = buffer;
            $dirty |= $composer2.changed(i2) ? 256 : 128;
        } else {
            i2 = buffer;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            buffer2 = i2;
        } else {
            if (i3 != 0) {
                buffer3 = 12;
            } else {
                buffer3 = i2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1374293250, $dirty2, -1, "kntr.watch.later.watchlater.compose.OnBottomReached (WatchLaterWidget.kt:364)");
            }
            if (!(buffer3 >= 0)) {
                throw new IllegalArgumentException("buffer 值必须是正整数".toString());
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -2140845943, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv = $composer2.changed(key);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda6
                    public final Object invoke() {
                        boolean OnBottomReached$lambda$1$0;
                        OnBottomReached$lambda$1$0 = WatchLaterWidgetKt.OnBottomReached$lambda$1$0($this$OnBottomReached, buffer3);
                        return Boolean.valueOf(OnBottomReached$lambda$1$0);
                    }
                });
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            State shouldLoadMore = (State) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, -2140831526, "CC(remember):WatchLaterWidget.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changed(shouldLoadMore) | $composer2.changedInstance(function1);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new WatchLaterWidgetKt$OnBottomReached$2$1(shouldLoadMore, function1, null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(shouldLoadMore, key, (Function2) it$iv2, $composer2, $dirty2 & 112);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            buffer2 = buffer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final int i4 = buffer2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.watch.later.watchlater.compose.WatchLaterWidgetKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit OnBottomReached$lambda$3;
                    OnBottomReached$lambda$3 = WatchLaterWidgetKt.OnBottomReached$lambda$3($this$OnBottomReached, key, i4, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OnBottomReached$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean OnBottomReached$lambda$1$0(LazyListState $this_OnBottomReached, int $buffer) {
        LazyListItemInfo lastVisibleItem = (LazyListItemInfo) CollectionsKt.lastOrNull($this_OnBottomReached.getLayoutInfo().getVisibleItemsInfo());
        return lastVisibleItem == null || lastVisibleItem.getIndex() >= ($this_OnBottomReached.getLayoutInfo().getTotalItemsCount() - 1) - $buffer;
    }
}