package kntr.common.ouro.preview.tool;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonToolItem.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aq\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001aE\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001ac\u0010\u0018\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0019\u001a\u0018\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u001a¢\u0006\u0002\b\u001c¢\u0006\u0002\b\u001dH\u0003¢\u0006\u0002\u0010\u001e\u001a7\u0010\u001f\u001a\u00020\u0001*\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"TextImageToolItem", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "text", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "tintColor", "Landroidx/compose/ui/graphics/Color;", "isSelected", "", "isDisable", "isDisableStyle", "TextImageToolItem-Ccamzx0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/painter/Painter;JZZZLandroidx/compose/runtime/Composer;II)V", "BackgroundColorToolItem", "color", "BackgroundColorToolItem-iWX5oaw", "(Landroidx/compose/ui/graphics/Color;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/runtime/Composer;II)V", "CommonToolItem", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TextImageContent", "TextImageContent-qFjXxE8", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/painter/Painter;JLandroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CommonToolItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorToolItem_iWX5oaw$lambda$1(Color color, Function0 function0, Modifier modifier, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        m2076BackgroundColorToolItemiWX5oaw(color, function0, modifier, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonToolItem$lambda$4(Function0 function0, Modifier modifier, boolean z, boolean z2, boolean z3, Function3 function3, int i, int i2, Composer composer, int i3) {
        CommonToolItem(function0, modifier, z, z2, z3, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextImageContent_qFjXxE8$lambda$0(RowScope rowScope, String str, TextStyle textStyle, Painter painter, long j, int i, Composer composer, int i2) {
        m2077TextImageContentqFjXxE8(rowScope, str, textStyle, painter, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextImageToolItem_Ccamzx0$lambda$1(Function0 function0, Modifier modifier, String str, TextStyle textStyle, Painter painter, long j, boolean z, boolean z2, boolean z3, int i, int i2, Composer composer, int i3) {
        m2078TextImageToolItemCcamzx0(function0, modifier, str, textStyle, painter, j, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: TextImageToolItem-Ccamzx0  reason: not valid java name */
    public static final void m2078TextImageToolItemCcamzx0(final Function0<Unit> function0, Modifier modifier, String text, TextStyle textStyle, Painter painter, long j, boolean isSelected, boolean isDisable, boolean isDisableStyle, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle2;
        long j2;
        boolean isSelected2;
        Modifier modifier2;
        String text2;
        Painter painter2;
        boolean isDisable2;
        boolean isDisableStyle2;
        TextStyle textStyle3;
        boolean isSelected3;
        long j3;
        Modifier modifier3;
        String text3;
        TextStyle textStyle4;
        Painter painter3;
        long j4;
        boolean isDisable3;
        boolean isDisableStyle3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-1415810970);
        ComposerKt.sourceInformation($composer2, "C(TextImageToolItem)N(onClick,modifier,text,textStyle,painter,tintColor:c#ui.graphics.Color,isSelected,isDisable,isDisableStyle)45@1677L110,39@1494L293:CommonToolItem.kt#gd7kur");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i6 = i & 4;
        if (i6 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(text) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                textStyle2 = textStyle;
                if ($composer2.changed(textStyle2)) {
                    i4 = 2048;
                    $dirty |= i4;
                }
            } else {
                textStyle2 = textStyle;
            }
            i4 = 1024;
            $dirty |= i4;
        } else {
            textStyle2 = textStyle;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= (32768 & $changed) == 0 ? $composer2.changed(painter) : $composer2.changedInstance(painter) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i3 = 131072;
                    $dirty |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = 65536;
            $dirty |= i3;
        } else {
            j2 = j;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
            isSelected2 = isSelected;
        } else if (($changed & 1572864) == 0) {
            isSelected2 = isSelected;
            $dirty |= $composer2.changed(isSelected2) ? 1048576 : 524288;
        } else {
            isSelected2 = isSelected;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changed(isDisable) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            if ((i & 256) == 0 && $composer2.changed(isDisableStyle)) {
                i2 = 67108864;
                $dirty |= i2;
            }
            i2 = 33554432;
            $dirty |= i2;
        }
        if ($composer2.shouldExecute(($dirty & 38347923) != 38347922, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "32@1288L9,34@1366L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 256) != 0) {
                    text3 = text;
                    painter3 = painter;
                    isDisable3 = isDisable;
                    $dirty &= -234881025;
                    textStyle4 = textStyle2;
                    j4 = j2;
                    modifier3 = modifier;
                    isDisableStyle3 = isDisableStyle;
                } else {
                    modifier3 = modifier;
                    text3 = text;
                    painter3 = painter;
                    isDisable3 = isDisable;
                    textStyle4 = textStyle2;
                    j4 = j2;
                    isDisableStyle3 = isDisableStyle;
                }
            } else {
                if (i5 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i6 == 0) {
                    text3 = text;
                } else {
                    text3 = null;
                }
                if ((i & 8) == 0) {
                    textStyle4 = textStyle2;
                } else {
                    textStyle4 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13();
                    $dirty &= -7169;
                }
                if (i7 == 0) {
                    painter3 = painter;
                } else {
                    painter3 = null;
                }
                if ((i & 32) == 0) {
                    j4 = j2;
                } else {
                    j4 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                    $dirty &= -458753;
                }
                if (i8 != 0) {
                    isSelected2 = false;
                }
                if (i9 == 0) {
                    isDisable3 = isDisable;
                } else {
                    isDisable3 = false;
                }
                if ((i & 256) == 0) {
                    isDisableStyle3 = isDisableStyle;
                } else {
                    isDisableStyle3 = isDisable3;
                    $dirty &= -234881025;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1415810970, $dirty, -1, "kntr.common.ouro.preview.tool.TextImageToolItem (CommonToolItem.kt:38)");
            }
            final String str = text3;
            final TextStyle textStyle5 = textStyle4;
            final Painter painter4 = painter3;
            final long j5 = j4;
            String text4 = text3;
            CommonToolItem(function0, modifier3, isSelected2, isDisable3, isDisableStyle3, ComposableLambdaKt.rememberComposableLambda(872844790, true, new Function3() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TextImageToolItem_Ccamzx0$lambda$0;
                    TextImageToolItem_Ccamzx0$lambda$0 = CommonToolItemKt.TextImageToolItem_Ccamzx0$lambda$0(str, textStyle5, painter4, j5, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TextImageToolItem_Ccamzx0$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty & 14) | 196608 | ($dirty & 112) | (($dirty >> 12) & 896) | (($dirty >> 12) & 7168) | (57344 & ($dirty >> 12)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isDisable2 = isDisable3;
            textStyle3 = textStyle4;
            painter2 = painter3;
            j3 = j4;
            isSelected3 = isSelected2;
            isDisableStyle2 = isDisableStyle3;
            text2 = text4;
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            text2 = text;
            painter2 = painter;
            isDisable2 = isDisable;
            isDisableStyle2 = isDisableStyle;
            textStyle3 = textStyle2;
            isSelected3 = isSelected2;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final String str2 = text2;
            final TextStyle textStyle6 = textStyle3;
            final Painter painter5 = painter2;
            final long j6 = j3;
            final boolean z = isSelected3;
            final boolean z2 = isDisable2;
            final boolean z3 = isDisableStyle2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextImageToolItem_Ccamzx0$lambda$1;
                    TextImageToolItem_Ccamzx0$lambda$1 = CommonToolItemKt.TextImageToolItem_Ccamzx0$lambda$1(function0, modifier4, str2, textStyle6, painter5, j6, z, z2, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextImageToolItem_Ccamzx0$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextImageToolItem_Ccamzx0$lambda$0(String $text, TextStyle $textStyle, Painter $painter, long j, RowScope $this$CommonToolItem, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$CommonToolItem, "$this$CommonToolItem");
        ComposerKt.sourceInformation($composer, "C46@1687L94:CommonToolItem.kt#gd7kur");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$CommonToolItem) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(872844790, $dirty2, -1, "kntr.common.ouro.preview.tool.TextImageToolItem.<anonymous> (CommonToolItem.kt:46)");
            }
            m2077TextImageContentqFjXxE8($this$CommonToolItem, $text, $textStyle, $painter, j, $composer, ($dirty2 & 14) | (Painter.$stable << 9));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* renamed from: BackgroundColorToolItem-iWX5oaw  reason: not valid java name */
    public static final void m2076BackgroundColorToolItemiWX5oaw(final Color color, final Function0<Unit> function0, Modifier modifier, boolean isSelected, boolean isDisable, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        boolean isDisable2;
        boolean isSelected2;
        Modifier modifier3;
        Modifier modifier4;
        boolean isSelected3;
        boolean isDisable3;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Composer $composer2 = $composer.startRestartGroup(-903384911);
        ComposerKt.sourceInformation($composer2, "C(BackgroundColorToolItem)N(color:c#ui.graphics.Color,onClick,modifier,isSelected,isDisable)63@2135L515,58@1993L657:CommonToolItem.kt#gd7kur");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            z = isSelected;
        } else if (($changed & 3072) == 0) {
            z = isSelected;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = isSelected;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            isDisable2 = isDisable;
        } else if (($changed & 24576) == 0) {
            isDisable2 = isDisable;
            $dirty |= $composer2.changed(isDisable2) ? 16384 : 8192;
        } else {
            isDisable2 = isDisable;
        }
        if (!$composer2.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            isSelected2 = z;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                isSelected3 = z;
            } else {
                isSelected3 = false;
            }
            if (i4 == 0) {
                isDisable3 = isDisable2;
            } else {
                isDisable3 = false;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903384911, $dirty, -1, "kntr.common.ouro.preview.tool.BackgroundColorToolItem (CommonToolItem.kt:57)");
            }
            CommonToolItem(function0, modifier4, isSelected3, isDisable3, false, ComposableLambdaKt.rememberComposableLambda(1028590881, true, new Function3() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit BackgroundColorToolItem_iWX5oaw$lambda$0;
                    BackgroundColorToolItem_iWX5oaw$lambda$0 = CommonToolItemKt.BackgroundColorToolItem_iWX5oaw$lambda$0(color, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return BackgroundColorToolItem_iWX5oaw$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 196608 | (($dirty >> 3) & 112) | (($dirty >> 3) & 896) | (($dirty >> 3) & 7168), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            isSelected2 = isSelected3;
            isDisable2 = isDisable3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final boolean z2 = isSelected2;
            final boolean z3 = isDisable2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BackgroundColorToolItem_iWX5oaw$lambda$1;
                    BackgroundColorToolItem_iWX5oaw$lambda$1 = CommonToolItemKt.BackgroundColorToolItem_iWX5oaw$lambda$1(color, function0, modifier5, z2, z3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BackgroundColorToolItem_iWX5oaw$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BackgroundColorToolItem_iWX5oaw$lambda$0(Color $color, RowScope $this$CommonToolItem, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$CommonToolItem, "$this$CommonToolItem");
        ComposerKt.sourceInformation($composer, "C:CommonToolItem.kt#gd7kur");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1028590881, $changed, -1, "kntr.common.ouro.preview.tool.BackgroundColorToolItem.<anonymous> (CommonToolItem.kt:64)");
            }
            if ($color == null) {
                $composer.startReplaceGroup(-1840681810);
                ComposerKt.sourceInformation($composer, "71@2425L6,65@2178L315");
                BoxKt.Box(BackgroundKt.background-bw27NRU(GraphicsLayerModifierKt.graphicsLayer-_6ThJ44$default(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(1)), Dp.constructor-impl(18)), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 45.0f, 0.0f, 0L, (Shape) null, false, (RenderEffect) null, 0L, 0L, 0, 0, (ColorFilter) null, 524031, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 0.5d))), $composer, 0);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1840345894);
                ComposerKt.sourceInformation($composer, "74@2523L111");
                BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Dp.constructor-impl(12)), $color.unbox-impl(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer, 0);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void CommonToolItem(final Function0<Unit> function0, Modifier modifier, boolean isSelected, boolean isDisable, boolean isDisableStyle, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean isSelected2;
        boolean isDisable2;
        boolean isDisableStyle2;
        Function3 content;
        Modifier modifier3;
        boolean isSelected3;
        Modifier modifier4;
        Modifier modifier5;
        Modifier it;
        Modifier modifier6;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-671503278);
        ComposerKt.sourceInformation($composer2, "C(CommonToolItem)N(onClick,modifier,isSelected,isDisable,isDisableStyle,content)88@2915L1450:CommonToolItem.kt#gd7kur");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            isSelected2 = isSelected;
        } else if (($changed & 384) == 0) {
            isSelected2 = isSelected;
            $dirty |= $composer2.changed(isSelected2) ? 256 : 128;
        } else {
            isSelected2 = isSelected;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            isDisable2 = isDisable;
        } else if (($changed & 3072) == 0) {
            isDisable2 = isDisable;
            $dirty |= $composer2.changed(isDisable2) ? 2048 : 1024;
        } else {
            isDisable2 = isDisable;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            isDisableStyle2 = isDisableStyle;
        } else if (($changed & 24576) == 0) {
            isDisableStyle2 = isDisableStyle;
            $dirty |= $composer2.changed(isDisableStyle2) ? 16384 : 8192;
        } else {
            isDisableStyle2 = isDisableStyle;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if (!$composer2.shouldExecute(($dirty & 74899) != 74898, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            content = function3;
            modifier3 = modifier2;
            isSelected3 = isSelected2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                isSelected2 = false;
            }
            if (i4 != 0) {
                isDisable2 = false;
            }
            if (i5 != 0) {
                isDisableStyle2 = false;
            }
            Function3 content2 = i6 != 0 ? ComposableSingletons$CommonToolItemKt.INSTANCE.m2079getLambda$1672299161$ui_debug() : function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-671503278, $dirty, -1, "kntr.common.ouro.preview.tool.CommonToolItem (CommonToolItem.kt:87)");
            }
            $composer2.startReplaceGroup(-1069514544);
            ComposerKt.sourceInformation($composer2, "");
            $composer2.startReplaceGroup(-1069544306);
            ComposerKt.sourceInformation($composer2, "");
            Modifier it2 = SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(32));
            if (isSelected2) {
                $composer2.startReplaceGroup(501555474);
                ComposerKt.sourceInformation($composer2, "96@3170L6,100@3394L6");
                modifier5 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(it2, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(502029464);
                ComposerKt.sourceInformation($composer2, "105@3623L6");
                modifier5 = BackgroundKt.background-bw27NRU(it2, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getGraph_bg_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
                $composer2.endReplaceGroup();
            }
            $composer2.endReplaceGroup();
            Modifier it3 = modifier5;
            if (isDisableStyle2) {
                it = AlphaKt.alpha(it3, 0.5f);
            } else {
                it = it3;
            }
            if (!isDisable2) {
                $composer2.startReplaceGroup(1072945420);
                ComposerKt.sourceInformation($composer2, "117@4037L13");
                ComposerKt.sourceInformationMarkerStart($composer2, -519576999, "CC(remember):CommonToolItem.kt#9igjgp");
                boolean invalid$iv = ($dirty & 14) == 4;
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit CommonToolItem$lambda$2$0$0;
                            CommonToolItem$lambda$2$0$0 = CommonToolItemKt.CommonToolItem$lambda$2$0$0(function0);
                            return CommonToolItem$lambda$2$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                modifier6 = ClickableKt.clickable-oSLSa3U$default(it, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1073024036);
                $composer2.endReplaceGroup();
                modifier6 = it;
            }
            $composer2.endReplaceGroup();
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(modifier6, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(4), Alignment.Companion.getCenterHorizontally());
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            boolean isSelected4 = isSelected2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            boolean isDisable3 = isDisable2;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope $this$CommonToolItem_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1056457316, "C125@4350L9:CommonToolItem.kt#gd7kur");
            content2.invoke($this$CommonToolItem_u24lambda_u243, $composer2, Integer.valueOf(((((432 >> 6) & 112) | 6) & 14) | (($dirty >> 12) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            isSelected3 = isSelected4;
            content = content2;
            isDisable2 = isDisable3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            final boolean z = isSelected3;
            final boolean z2 = isDisable2;
            final boolean z3 = isDisableStyle2;
            final Function3 function32 = content;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit CommonToolItem$lambda$4;
                    CommonToolItem$lambda$4 = CommonToolItemKt.CommonToolItem$lambda$4(function0, modifier7, z, z2, z3, function32, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CommonToolItem$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CommonToolItem$lambda$2$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: TextImageContent-qFjXxE8  reason: not valid java name */
    private static final void m2077TextImageContentqFjXxE8(final RowScope $this$TextImageContent_u2dqFjXxE8, final String text, final TextStyle textStyle, final Painter painter, final long j, Composer $composer, final int $changed) {
        Composer $composer2;
        int i;
        Composer $composer3 = $composer.startRestartGroup(2082400389);
        ComposerKt.sourceInformation($composer3, "C(TextImageContent)N(text,textStyle,painter,tintColor:c#ui.graphics.Color):CommonToolItem.kt#gd7kur");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(text) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(textStyle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= ($changed & 4096) == 0 ? $composer3.changed(painter) : $composer3.changedInstance(painter) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(j) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 9361) != 9360, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2082400389, $dirty2, -1, "kntr.common.ouro.preview.tool.TextImageContent (CommonToolItem.kt:135)");
            }
            if (painter != null) {
                $composer3.startReplaceGroup(282519533);
                ComposerKt.sourceInformation($composer3, "137@4549L160");
                i = 278010397;
                IconKt.Icon-ww6aTOc(painter, text, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), j, $composer3, Painter.$stable | 384 | (($dirty2 >> 9) & 14) | ($dirty2 & 112) | (($dirty2 >> 3) & 7168), 0);
            } else {
                i = 278010397;
                $composer3.startReplaceGroup(278010397);
            }
            $composer3.endReplaceGroup();
            if (text != null) {
                $composer3.startReplaceGroup(282723296);
                ComposerKt.sourceInformation($composer3, "145@4796L6,145@4748L61");
                TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer3, ($dirty2 >> 3) & 14, ($dirty2 << 15) & 29360128, 131066);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(i);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.common.ouro.preview.tool.CommonToolItemKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextImageContent_qFjXxE8$lambda$0;
                    TextImageContent_qFjXxE8$lambda$0 = CommonToolItemKt.TextImageContent_qFjXxE8$lambda$0($this$TextImageContent_u2dqFjXxE8, text, textStyle, painter, j, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return TextImageContent_qFjXxE8$lambda$0;
                }
            });
        }
    }
}