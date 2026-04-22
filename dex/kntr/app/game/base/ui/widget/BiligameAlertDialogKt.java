package kntr.app.game.base.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BiligameAlertDialog.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a£\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"BiligameAlertDialog", RoomRecommendViewModel.EMPTY_CURSOR, "onDismissRequest", "Lkotlin/Function0;", "title", RoomRecommendViewModel.EMPTY_CURSOR, "content", "leftBtnText", "rightBtnText", "leftBtnColor", "Landroidx/compose/ui/graphics/Color;", "rightBtnColor", "onLeftClick", "onRightClick", "dismissOnBackPress", RoomRecommendViewModel.EMPTY_CURSOR, "dismissOnClickOutside", "usePlatformDefaultWidth", "BiligameAlertDialog-gsb-d_E", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZZLandroidx/compose/runtime/Composer;III)V", "base-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BiligameAlertDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameAlertDialog_gsb_d_E$lambda$1(Function0 function0, String str, String str2, String str3, String str4, long j2, long j3, Function0 function02, Function0 function03, boolean z, boolean z2, boolean z3, int i, int i2, int i3, Composer composer, int i4) {
        m1095BiligameAlertDialoggsbd_E(function0, str, str2, str3, str4, j2, j3, function02, function03, z, z2, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* renamed from: BiligameAlertDialog-gsb-d_E  reason: not valid java name */
    public static final void m1095BiligameAlertDialoggsbd_E(final Function0<Unit> function0, String title, String content, String leftBtnText, String rightBtnText, long j2, long j3, Function0<Unit> function02, Function0<Unit> function03, boolean dismissOnBackPress, boolean dismissOnClickOutside, boolean usePlatformDefaultWidth, Composer $composer, final int $changed, final int $changed1, final int i) {
        int $dirty;
        String title2;
        String content2;
        String leftBtnText2;
        long j4;
        long j5;
        Function0 onLeftClick;
        Function0 onRightClick;
        boolean dismissOnBackPress2;
        boolean dismissOnClickOutside2;
        boolean usePlatformDefaultWidth2;
        String rightBtnText2;
        String title3;
        String content3;
        String leftBtnText3;
        String rightBtnText3;
        long j6;
        long j7;
        Function0 onLeftClick2;
        Function0 onRightClick2;
        boolean dismissOnBackPress3;
        boolean dismissOnClickOutside3;
        boolean usePlatformDefaultWidth3;
        int $dirty2;
        int $dirty3;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Composer $composer2 = $composer.startRestartGroup(2041378459);
        ComposerKt.sourceInformation($composer2, "C(BiligameAlertDialog)N(onDismissRequest,title,content,leftBtnText,rightBtnText,leftBtnColor:c#ui.graphics.Color,rightBtnColor:c#ui.graphics.Color,onLeftClick,onRightClick,dismissOnBackPress,dismissOnClickOutside,usePlatformDefaultWidth)43@1613L2384,43@1576L2421:BiligameAlertDialog.kt#kw4tct");
        int $dirty4 = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty4 |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty4 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty4 |= $composer2.changed(title) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty4 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty4 |= $composer2.changed(content) ? 256 : 128;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty4 |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty4 |= $composer2.changed(leftBtnText) ? 2048 : 1024;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty4 |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty4 |= $composer2.changed(rightBtnText) ? 16384 : 8192;
        }
        if (($changed & 196608) == 0) {
            if ((i & 32) == 0 && $composer2.changed(j2)) {
                i3 = 131072;
                $dirty4 |= i3;
            }
            i3 = 65536;
            $dirty4 |= i3;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0) {
                $dirty3 = $dirty4;
                if ($composer2.changed(j3)) {
                    i2 = 1048576;
                    $dirty = $dirty3 | i2;
                }
            } else {
                $dirty3 = $dirty4;
            }
            i2 = 524288;
            $dirty = $dirty3 | i2;
        } else {
            $dirty = $dirty4;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 8388608 : 4194304;
        }
        int i9 = i & 256;
        if (i9 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer2.changedInstance(function03) ? 67108864 : 33554432;
        }
        int i10 = i & 512;
        if (i10 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changed(dismissOnBackPress) ? 536870912 : 268435456;
        }
        int i11 = i & 1024;
        if (i11 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changed(dismissOnClickOutside) ? 4 : 2;
        }
        int i12 = i & 2048;
        if (i12 != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 48) == 0) {
            $dirty1 |= $composer2.changed(usePlatformDefaultWidth) ? 32 : 16;
        }
        if ($composer2.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 19) == 18) ? false : true, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "34@1185L6,35@1236L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 32) != 0) {
                    $dirty &= -458753;
                }
                if ((i & 64) != 0) {
                    title3 = title;
                    content3 = content;
                    leftBtnText3 = leftBtnText;
                    rightBtnText3 = rightBtnText;
                    j6 = j2;
                    j7 = j3;
                    onRightClick2 = function03;
                    dismissOnBackPress3 = dismissOnBackPress;
                    dismissOnClickOutside3 = dismissOnClickOutside;
                    usePlatformDefaultWidth3 = usePlatformDefaultWidth;
                    $dirty2 = $dirty & (-3670017);
                    onLeftClick2 = function02;
                } else {
                    title3 = title;
                    content3 = content;
                    leftBtnText3 = leftBtnText;
                    rightBtnText3 = rightBtnText;
                    j6 = j2;
                    j7 = j3;
                    onLeftClick2 = function02;
                    onRightClick2 = function03;
                    dismissOnBackPress3 = dismissOnBackPress;
                    dismissOnClickOutside3 = dismissOnClickOutside;
                    usePlatformDefaultWidth3 = usePlatformDefaultWidth;
                    $dirty2 = $dirty;
                }
            } else {
                if (i4 != 0) {
                    title3 = null;
                } else {
                    title3 = title;
                }
                if (i5 == 0) {
                    content3 = content;
                } else {
                    content3 = null;
                }
                if (i6 == 0) {
                    leftBtnText3 = leftBtnText;
                } else {
                    leftBtnText3 = null;
                }
                if (i7 == 0) {
                    rightBtnText3 = rightBtnText;
                } else {
                    rightBtnText3 = null;
                }
                if ((i & 32) == 0) {
                    j6 = j2;
                } else {
                    j6 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU();
                    $dirty &= -458753;
                }
                if ((i & 64) == 0) {
                    j7 = j3;
                } else {
                    j7 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $dirty &= -3670017;
                }
                if (i8 == 0) {
                    onLeftClick2 = function02;
                } else {
                    onLeftClick2 = null;
                }
                if (i9 == 0) {
                    onRightClick2 = function03;
                } else {
                    onRightClick2 = null;
                }
                if (i10 == 0) {
                    dismissOnBackPress3 = dismissOnBackPress;
                } else {
                    dismissOnBackPress3 = true;
                }
                if (i11 == 0) {
                    dismissOnClickOutside3 = dismissOnClickOutside;
                } else {
                    dismissOnClickOutside3 = true;
                }
                if (i12 == 0) {
                    usePlatformDefaultWidth3 = usePlatformDefaultWidth;
                    $dirty2 = $dirty;
                } else {
                    usePlatformDefaultWidth3 = true;
                    $dirty2 = $dirty;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2041378459, $dirty2, $dirty1, "kntr.app.game.base.ui.widget.BiligameAlertDialog (BiligameAlertDialog.kt:41)");
            }
            DialogProperties properties = new DialogProperties(dismissOnBackPress3, dismissOnClickOutside3, usePlatformDefaultWidth3);
            final String str = title3;
            final String str2 = content3;
            final String str3 = leftBtnText3;
            final Function0 onLeftClick3 = onLeftClick2;
            final String str4 = rightBtnText3;
            final Function0 function04 = onRightClick2;
            final long j8 = j6;
            final long j9 = j7;
            Function2 function2 = new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameAlertDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameAlertDialog_gsb_d_E$lambda$0;
                    BiligameAlertDialog_gsb_d_E$lambda$0 = BiligameAlertDialogKt.BiligameAlertDialog_gsb_d_E$lambda$0(str, str2, str3, onLeftClick3, str4, function04, j8, j9, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameAlertDialog_gsb_d_E$lambda$0;
                }
            };
            Function0 onRightClick3 = onRightClick2;
            AndroidDialog_androidKt.Dialog(function0, properties, ComposableLambdaKt.rememberComposableLambda(-1500196238, true, function2, $composer2, 54), $composer2, ($dirty2 & 14) | 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onLeftClick = onLeftClick3;
            onRightClick = onRightClick3;
            dismissOnBackPress2 = dismissOnBackPress3;
            dismissOnClickOutside2 = dismissOnClickOutside3;
            usePlatformDefaultWidth2 = usePlatformDefaultWidth3;
            leftBtnText2 = leftBtnText3;
            rightBtnText2 = rightBtnText3;
            j5 = j7;
            j4 = j6;
            title2 = title3;
            content2 = content3;
        } else {
            $composer2.skipToGroupEnd();
            title2 = title;
            content2 = content;
            leftBtnText2 = leftBtnText;
            j4 = j2;
            j5 = j3;
            onLeftClick = function02;
            onRightClick = function03;
            dismissOnBackPress2 = dismissOnBackPress;
            dismissOnClickOutside2 = dismissOnClickOutside;
            usePlatformDefaultWidth2 = usePlatformDefaultWidth;
            rightBtnText2 = rightBtnText;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final String str5 = title2;
            final String str6 = content2;
            final String str7 = leftBtnText2;
            final String str8 = rightBtnText2;
            final long j10 = j4;
            final long j11 = j5;
            final Function0 function05 = onLeftClick;
            final Function0 function06 = onRightClick;
            final boolean z = dismissOnBackPress2;
            final boolean z2 = dismissOnClickOutside2;
            final boolean z3 = usePlatformDefaultWidth2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.game.base.ui.widget.BiligameAlertDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BiligameAlertDialog_gsb_d_E$lambda$1;
                    BiligameAlertDialog_gsb_d_E$lambda$1 = BiligameAlertDialogKt.BiligameAlertDialog_gsb_d_E$lambda$1(function0, str5, str6, str7, str8, j10, j11, function05, function06, z, z2, z3, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BiligameAlertDialog_gsb_d_E$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0456, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit BiligameAlertDialog_gsb_d_E$lambda$0(String $title, String $content, String $leftBtnText, final Function0 $onLeftClick, String $rightBtnText, final Function0 $onRightClick, long j2, long j3, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer2;
        String str;
        Composer $composer$iv;
        String str2;
        Composer $composer$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        ComposerKt.sourceInformation($composer, "C45@1684L6,44@1623L2368:BiligameAlertDialog.kt#kw4tct");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1500196238, $changed, -1, "kntr.app.game.base.ui.widget.BiligameAlertDialog.<anonymous> (BiligameAlertDialog.kt:44)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getWh0-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
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
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1244600481, "C67@2627L6,64@2465L196,69@2674L1307:BiligameAlertDialog.kt#kw4tct");
            String str3 = $title;
            if (str3 == null || StringsKt.isBlank(str3)) {
                $composer.startReplaceGroup(1242735706);
            } else {
                $composer.startReplaceGroup(1244586685);
                ComposerKt.sourceInformation($composer, "51@1935L9,52@1989L6,49@1857L253");
                TextStyle t16b = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b();
                TextKt.Text-Nvy7gAk($title, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), Dp.constructor-impl(24), Dp.constructor-impl(20), 0.0f, 8, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16b, $composer, 0, 0, 131064);
            }
            $composer.endReplaceGroup();
            String str4 = $content;
            if (str4 == null || StringsKt.isBlank(str4)) {
                $composer.startReplaceGroup(1242735706);
            } else {
                $composer.startReplaceGroup(1244912061);
                ComposerKt.sourceInformation($composer, "59@2265L9,60@2318L6,57@2185L253");
                TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13();
                TextKt.Text-Nvy7gAk($content, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), Dp.constructor-impl(6), Dp.constructor-impl(20), 0.0f, 8, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t13, $composer, 0, 0, 131064);
            }
            $composer.endReplaceGroup();
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(24), 0.0f, 0.0f, 13, (Object) null), 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 54, 0);
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv2 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((6 >> 6) & 112) | 6;
            RowScope $this$BiligameAlertDialog_gsb_d_E_u24lambda_u240_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1296595118, "C:BiligameAlertDialog.kt#kw4tct");
            String str5 = $leftBtnText;
            if (str5 == null || StringsKt.isBlank(str5)) {
                $composer$iv$iv$iv = $composer;
                $composer$iv$iv = $composer;
                $composer2 = $composer;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv = $composer;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv2 = $composer;
                $composer.startReplaceGroup(-1299357994);
            } else {
                $composer.startReplaceGroup(-1296581696);
                ComposerKt.sourceInformation($composer, "73@2920L85,71@2802L526");
                $composer2 = $composer;
                Modifier weight = $this$BiligameAlertDialog_gsb_d_E_u24lambda_u240_u240_u240.weight(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, true);
                ComposerKt.sourceInformationMarkerStart($composer, -2120031199, "CC(remember):BiligameAlertDialog.kt#9igjgp");
                boolean invalid$iv = $composer.changed($onLeftClick);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: kntr.app.game.base.ui.widget.BiligameAlertDialogKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit BiligameAlertDialog_gsb_d_E$lambda$0$0$0$0$0;
                        BiligameAlertDialog_gsb_d_E$lambda$0$0$0$0$0 = BiligameAlertDialogKt.BiligameAlertDialog_gsb_d_E$lambda$0$0$0$0$0($onLeftClick);
                        return BiligameAlertDialog_gsb_d_E$lambda$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(weight, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                $composer$iv = $composer;
                $composer$iv$iv = $composer;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                $composer$iv$iv$iv = $composer;
                $composer$iv$iv$iv2 = $composer;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv7;
                    $composer.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv7;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -1413178760, "C80@3216L9,78@3116L190:BiligameAlertDialog.kt#kw4tct");
                TextKt.Text-Nvy7gAk($leftBtnText, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            }
            $composer.endReplaceGroup();
            String str6 = $rightBtnText;
            if (str6 == null || StringsKt.isBlank(str6)) {
                $composer.startReplaceGroup(-1299357994);
            } else {
                $composer.startReplaceGroup(-1295968547);
                ComposerKt.sourceInformation($composer, "88@3538L86,86@3420L529");
                Modifier weight2 = $this$BiligameAlertDialog_gsb_d_E_u24lambda_u240_u240_u240.weight(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(44)), 1.0f, true);
                ComposerKt.sourceInformationMarkerStart($composer, -2120011422, "CC(remember):BiligameAlertDialog.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed($onRightClick);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.game.base.ui.widget.BiligameAlertDialogKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit BiligameAlertDialog_gsb_d_E$lambda$0$0$0$2$0;
                            BiligameAlertDialog_gsb_d_E$lambda$0$0$0$2$0 = BiligameAlertDialogKt.BiligameAlertDialog_gsb_d_E$lambda$0$0$0$2$0($onRightClick);
                            return BiligameAlertDialog_gsb_d_E$lambda$0$0$0$2$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(weight2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv4 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, str);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -553112988, str2);
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv8;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -2025209377, "C95@3836L9,93@3735L192:BiligameAlertDialog.kt#kw4tct");
                TextKt.Text-Nvy7gAk($rightBtnText, (Modifier) null, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16(), $composer, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameAlertDialog_gsb_d_E$lambda$0$0$0$0$0(Function0 $onLeftClick) {
        if ($onLeftClick != null) {
            $onLeftClick.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BiligameAlertDialog_gsb_d_E$lambda$0$0$0$2$0(Function0 $onRightClick) {
        if ($onRightClick != null) {
            $onRightClick.invoke();
        }
        return Unit.INSTANCE;
    }
}