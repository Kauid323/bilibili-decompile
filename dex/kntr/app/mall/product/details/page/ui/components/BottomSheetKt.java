package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ModalBottomSheetKt;
import androidx.compose.material3.ModalBottomSheetProperties;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.mall.product.details.page.utils.ScreenKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BottomSheet.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ac\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001ac\u0010\u0013\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001am\u0010\u0017\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00052\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"BottomSheet", "", "onDismiss", "Lkotlin/Function0;", "show", "", "sheetPaddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "containerShape", "Landroidx/compose/ui/graphics/Shape;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-fWhpE4E", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/layout/PaddingValues;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "CustomizedBottomSheet", "Landroidx/compose/foundation/layout/BoxScope;", "CustomizedBottomSheet-FU0evQE", "(Lkotlin/jvm/functions/Function0;ZJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "WrapContentBottomSheet", "needBottomSafeAreaInset", "WrapContentBottomSheet-hYmLsZ8", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/foundation/layout/PaddingValues;JLandroidx/compose/ui/graphics/Shape;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_fWhpE4E$lambda$4(Function0 function0, boolean z, PaddingValues paddingValues, long j, Shape shape, Function3 function3, int i, int i2, Composer composer, int i3) {
        m415BottomSheetfWhpE4E(function0, z, paddingValues, j, shape, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomizedBottomSheet_FU0evQE$lambda$1(Function0 function0, boolean z, long j, Shape shape, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        m416CustomizedBottomSheetFU0evQE(function0, z, j, shape, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapContentBottomSheet_hYmLsZ8$lambda$4(Function0 function0, boolean z, PaddingValues paddingValues, long j, Shape shape, boolean z2, Function3 function3, int i, int i2, Composer composer, int i3) {
        m417WrapContentBottomSheethYmLsZ8(function0, z, paddingValues, j, shape, z2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01b0, code lost:
        if (r3 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /* renamed from: BottomSheet-fWhpE4E  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m415BottomSheetfWhpE4E(final Function0<Unit> function0, boolean show, PaddingValues sheetPaddingValues, long j, Shape containerShape, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        final PaddingValues sheetPaddingValues2;
        long j2;
        Shape shape;
        PaddingValues sheetPaddingValues3;
        long j3;
        Shape containerShape2;
        boolean show2;
        boolean show3;
        Shape containerShape3;
        boolean show4;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(-725653815);
        ComposerKt.sourceInformation($composer2, "C(BottomSheet)N(onDismiss,show,sheetPaddingValues,containerColor:c#ui.graphics.Color,containerShape,content)58@2502L59,61@2627L207,61@2606L228:BottomSheet.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            z = show;
        } else if (($changed & 48) == 0) {
            z = show;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = show;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetPaddingValues2 = sheetPaddingValues;
                if ($composer2.changed(sheetPaddingValues2)) {
                    i4 = 256;
                    $dirty |= i4;
                }
            } else {
                sheetPaddingValues2 = sheetPaddingValues;
            }
            i4 = 128;
            $dirty |= i4;
        } else {
            sheetPaddingValues2 = sheetPaddingValues;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            j2 = j;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                shape = containerShape;
                if ($composer2.changed(shape)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                shape = containerShape;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            shape = containerShape;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "54@2322L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                show3 = z;
                containerShape3 = shape;
            } else {
                if (i5 != 0) {
                    show3 = false;
                } else {
                    show3 = z;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    sheetPaddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(24), Dp.constructor-impl(16), Dp.constructor-impl(16));
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
                }
                if ((i & 16) == 0) {
                    containerShape3 = shape;
                } else {
                    containerShape3 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
                    $dirty &= -57345;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-725653815, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.BottomSheet (BottomSheet.kt:57)");
            }
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) null, $composer2, 6, 2);
            Boolean valueOf = Boolean.valueOf(show3);
            ComposerKt.sourceInformationMarkerStart($composer2, -1568595080, "CC(remember):BottomSheet.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | $composer2.changed(sheetState);
            BottomSheetKt$BottomSheet$1$1 value$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            value$iv = new BottomSheetKt$BottomSheet$1$1(show3, sheetState, null);
            $composer2.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) value$iv, $composer2, ($dirty >> 3) & 14);
            if (!show3 && !sheetState.isVisible()) {
                $composer2.startReplaceGroup(-1384420615);
                $composer2.endReplaceGroup();
                show4 = show3;
            } else {
                $composer2.startReplaceGroup(-1381457046);
                ComposerKt.sourceInformation($composer2, "72@3047L28,77@3254L522,70@2961L815");
                ComposerKt.sourceInformationMarkerStart($composer2, -1568581819, "CC(remember):BottomSheet.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                show4 = show3;
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda7
                        public final Object invoke() {
                            Unit BottomSheet_fWhpE4E$lambda$1$0;
                            BottomSheet_fWhpE4E$lambda$1$0 = BottomSheetKt.BottomSheet_fWhpE4E$lambda$1$0(function0);
                            return BottomSheet_fWhpE4E$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv, (Modifier) null, sheetState, 0.0f, false, containerShape3, j2, 0L, 0.0f, 0L, (Function2) null, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj, Object obj2) {
                        WindowInsets BottomSheet_fWhpE4E$lambda$2;
                        BottomSheet_fWhpE4E$lambda$2 = BottomSheetKt.BottomSheet_fWhpE4E$lambda$2((Composer) obj, ((Integer) obj2).intValue());
                        return BottomSheet_fWhpE4E$lambda$2;
                    }
                }, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1528823298, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit BottomSheet_fWhpE4E$lambda$3;
                        BottomSheet_fWhpE4E$lambda$3 = BottomSheetKt.BottomSheet_fWhpE4E$lambda$3(sheetPaddingValues2, function3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return BottomSheet_fWhpE4E$lambda$3;
                    }
                }, $composer2, 54), $composer2, (458752 & ($dirty << 3)) | 6 | (($dirty << 9) & 3670016), 3078, 5018);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            show2 = show4;
            containerShape2 = containerShape3;
            sheetPaddingValues3 = sheetPaddingValues2;
            j3 = j2;
        } else {
            $composer2.skipToGroupEnd();
            sheetPaddingValues3 = sheetPaddingValues2;
            j3 = j2;
            containerShape2 = shape;
            show2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = show2;
            final PaddingValues paddingValues = sheetPaddingValues3;
            final long j4 = j3;
            final Shape shape2 = containerShape2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheet_fWhpE4E$lambda$4;
                    BottomSheet_fWhpE4E$lambda$4 = BottomSheetKt.BottomSheet_fWhpE4E$lambda$4(function0, z2, paddingValues, j4, shape2, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheet_fWhpE4E$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_fWhpE4E$lambda$1$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets BottomSheet_fWhpE4E$lambda$2(Composer $composer, int $changed) {
        $composer.startReplaceGroup(-970676018);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-970676018, $changed, -1, "kntr.app.mall.product.details.page.ui.components.BottomSheet.<anonymous> (BottomSheet.kt:76)");
        }
        WindowInsets WindowInsets$default = WindowInsetsKt.WindowInsets$default(0, 0, 0, 0, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return WindowInsets$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheet_fWhpE4E$lambda$3(PaddingValues $sheetPaddingValues, Function3 $content, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C81@3364L17,84@3528L12,86@3638L17,78@3268L498:BottomSheet.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1528823298, $changed, -1, "kntr.app.mall.product.details.page.ui.components.BottomSheet.<anonymous> (BottomSheet.kt:78)");
            }
            Modifier modifier$iv = PaddingKt.padding(PaddingKt.padding(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(ScreenKt.getScreenHeight($composer, 0) * 0.8f)), $sheetPaddingValues), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0));
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope $this$BottomSheet_fWhpE4E_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1842128978, "C90@3743L9:BottomSheet.kt#o90vz8");
            $content.invoke($this$BottomSheet_fWhpE4E_u24lambda_u243_u240, $composer, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer);
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

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0335, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L84;
     */
    /* renamed from: CustomizedBottomSheet-FU0evQE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m416CustomizedBottomSheetFU0evQE(final Function0<Unit> function0, boolean show, long j, Shape containerShape, PaddingValues sheetPaddingValues, final Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean z;
        long j2;
        Shape containerShape2;
        PaddingValues sheetPaddingValues2;
        boolean show2;
        long j3;
        Shape containerShape3;
        PaddingValues sheetPaddingValues3;
        boolean show3;
        Function0 factory$iv$iv$iv;
        boolean show4;
        Function0 factory$iv$iv$iv2;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(1392567368);
        ComposerKt.sourceInformation($composer2, "C(CustomizedBottomSheet)N(onDismiss,show,containerColor:c#ui.graphics.Color,containerShape,sheetPaddingValues,content)111@4276L17,112@4298L1694:BottomSheet.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            z = show;
        } else if (($changed & 48) == 0) {
            z = show;
            $dirty |= $composer2.changed(z) ? 32 : 16;
        } else {
            z = show;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i4 = 256;
                    $dirty |= i4;
                }
            } else {
                j2 = j;
            }
            i4 = 128;
            $dirty |= i4;
        } else {
            j2 = j;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                containerShape2 = containerShape;
                if ($composer2.changed(containerShape2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                containerShape2 = containerShape;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            containerShape2 = containerShape;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                sheetPaddingValues2 = sheetPaddingValues;
                if ($composer2.changed(sheetPaddingValues2)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                sheetPaddingValues2 = sheetPaddingValues;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            sheetPaddingValues2 = sheetPaddingValues;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 131072 : 65536;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "100@3926L6");
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                show3 = z;
            } else {
                if (i5 != 0) {
                    show3 = false;
                } else {
                    show3 = z;
                }
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    containerShape2 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    sheetPaddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(16), Dp.constructor-impl(24), Dp.constructor-impl(16), Dp.constructor-impl(16));
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392567368, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.CustomizedBottomSheet (BottomSheet.kt:110)");
            }
            float screenHeight = ScreenKt.getScreenHeight($composer2, 0);
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            sheetPaddingValues3 = sheetPaddingValues2;
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
            j3 = j2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i7 = ((6 >> 6) & 112) | 6;
            BoxScope $this$CustomizedBottomSheet_FU0evQE_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 1394757771, "C118@4494L284,114@4376L402,130@4824L61,132@4916L310,132@4895L331:BottomSheet.kt#o90vz8");
            AnimatedVisibilityKt.AnimatedVisibility(show3, (Modifier) null, EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1926400090, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit CustomizedBottomSheet_FU0evQE$lambda$0$0;
                    CustomizedBottomSheet_FU0evQE$lambda$0$0 = BottomSheetKt.CustomizedBottomSheet_FU0evQE$lambda$0$0(function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return CustomizedBottomSheet_FU0evQE$lambda$0$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 3) & 14) | 200064, 18);
            ComposerKt.sourceInformationMarkerStart($composer2, 2123214955, "CC(remember):BottomSheet.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = AnimatableKt.Animatable$default(show3 ? 0.0f : screenHeight, 0.0f, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            Animatable offsetYAnim = (Animatable) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Boolean valueOf = Boolean.valueOf(show3);
            ComposerKt.sourceInformationMarkerStart($composer2, 2123218148, "CC(remember):BottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(offsetYAnim) | (($dirty & 112) == 32) | $composer2.changed(screenHeight);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv2 = (Function2) new BottomSheetKt$CustomizedBottomSheet$1$2$1(offsetYAnim, show3, screenHeight, null);
            $composer2.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv2, $composer2, ($dirty >> 3) & 14);
            if (show3 || ((Number) offsetYAnim.getValue()).floatValue() < screenHeight) {
                $composer2.startReplaceGroup(1395634202);
                ComposerKt.sourceInformation($composer2, "154@5765L12,156@5875L17,144@5302L674");
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                float other$iv = Dp.constructor-impl(screenHeight * 0.8f);
                Modifier align = $this$CustomizedBottomSheet_FU0evQE_u24lambda_u240.align(SizeKt.height-3ABfNKs(fillMaxWidth$default, other$iv), Alignment.Companion.getBottomCenter());
                float $this$dp$iv = ((Number) offsetYAnim.getValue()).floatValue();
                show4 = show3;
                Modifier modifier$iv2 = PaddingKt.padding(PaddingKt.padding(BackgroundKt.background-bw27NRU(OffsetKt.offset-VpY3zN4$default(align, 0.0f, Dp.constructor-impl($this$dp$iv), 1, (Object) null), j3, containerShape2), sheetPaddingValues3), WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer2, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer2, 0));
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                containerShape3 = containerShape2;
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i8 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope $this$CustomizedBottomSheet_FU0evQE_u24lambda_u240_u243 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -110483253, "C159@5953L9:BottomSheet.kt#o90vz8");
                function3.invoke($this$CustomizedBottomSheet_FU0evQE_u24lambda_u240_u243, $composer2, Integer.valueOf(((((0 >> 6) & 112) | 6) & 14) | (($dirty >> 12) & 112)));
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1390365876);
                $composer2.endReplaceGroup();
                show4 = show3;
                containerShape3 = containerShape2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            show2 = show4;
        } else {
            $composer2.skipToGroupEnd();
            show2 = z;
            j3 = j2;
            containerShape3 = containerShape2;
            sheetPaddingValues3 = sheetPaddingValues2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = show2;
            final long j4 = j3;
            final Shape shape = containerShape3;
            final PaddingValues paddingValues = sheetPaddingValues3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomizedBottomSheet_FU0evQE$lambda$1;
                    CustomizedBottomSheet_FU0evQE$lambda$1 = BottomSheetKt.CustomizedBottomSheet_FU0evQE$lambda$1(function0, z2, j4, shape, paddingValues, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomizedBottomSheet_FU0evQE$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomizedBottomSheet_FU0evQE$lambda$0$0(final Function0 $onDismiss, AnimatedVisibilityScope $this$AnimatedVisibility, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C125@4738L15,120@4535L233:BottomSheet.kt#o90vz8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1926400090, $changed, -1, "kntr.app.mall.product.details.page.ui.components.CustomizedBottomSheet.<anonymous>.<anonymous> (BottomSheet.kt:120)");
        }
        Modifier modifier = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getBlack-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -139574091, "CC(remember):BottomSheet.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onDismiss);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit CustomizedBottomSheet_FU0evQE$lambda$0$0$0$0;
                    CustomizedBottomSheet_FU0evQE$lambda$0$0$0$0 = BottomSheetKt.CustomizedBottomSheet_FU0evQE$lambda$0$0$0$0($onDismiss);
                    return CustomizedBottomSheet_FU0evQE$lambda$0$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        BoxKt.Box(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomizedBottomSheet_FU0evQE$lambda$0$0$0$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x01e0, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L75;
     */
    /* renamed from: WrapContentBottomSheet-hYmLsZ8  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m417WrapContentBottomSheethYmLsZ8(final Function0<Unit> function0, boolean show, PaddingValues sheetPaddingValues, long j, Shape containerShape, boolean needBottomSafeAreaInset, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean show2;
        final PaddingValues sheetPaddingValues2;
        long j2;
        Shape containerShape2;
        boolean z;
        boolean show3;
        PaddingValues sheetPaddingValues3;
        Shape containerShape3;
        boolean needBottomSafeAreaInset2;
        long j3;
        boolean show4;
        final boolean needBottomSafeAreaInset3;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(function3, "content");
        Composer $composer2 = $composer.startRestartGroup(514848946);
        ComposerKt.sourceInformation($composer2, "C(WrapContentBottomSheet)N(onDismiss,show,sheetPaddingValues,containerColor:c#ui.graphics.Color,containerShape,needBottomSafeAreaInset,content)186@6628L59,189@6753L92,189@6732L113:BottomSheet.kt#o90vz8");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        int i5 = i & 2;
        if (i5 != 0) {
            $dirty |= 48;
            show2 = show;
        } else if (($changed & 48) == 0) {
            show2 = show;
            $dirty |= $composer2.changed(show2) ? 32 : 16;
        } else {
            show2 = show;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                sheetPaddingValues2 = sheetPaddingValues;
                if ($composer2.changed(sheetPaddingValues2)) {
                    i4 = 256;
                    $dirty |= i4;
                }
            } else {
                sheetPaddingValues2 = sheetPaddingValues;
            }
            i4 = 128;
            $dirty |= i4;
        } else {
            sheetPaddingValues2 = sheetPaddingValues;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                j2 = j;
                if ($composer2.changed(j2)) {
                    i3 = 2048;
                    $dirty |= i3;
                }
            } else {
                j2 = j;
            }
            i3 = 1024;
            $dirty |= i3;
        } else {
            j2 = j;
        }
        if (($changed & 24576) == 0) {
            if ((i & 16) == 0) {
                containerShape2 = containerShape;
                if ($composer2.changed(containerShape2)) {
                    i2 = 16384;
                    $dirty |= i2;
                }
            } else {
                containerShape2 = containerShape;
            }
            i2 = 8192;
            $dirty |= i2;
        } else {
            containerShape2 = containerShape;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            z = needBottomSafeAreaInset;
        } else if ((196608 & $changed) == 0) {
            z = needBottomSafeAreaInset;
            $dirty |= $composer2.changed(z) ? 131072 : 65536;
        } else {
            z = needBottomSafeAreaInset;
        }
        if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 1048576 : 524288;
        }
        if ($composer2.shouldExecute(($dirty & 599187) != 599186, $dirty & 1)) {
            $composer2.startDefaults();
            ComposerKt.sourceInformation($composer2, "181@6403L6");
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                if (i5 != 0) {
                    show2 = false;
                }
                if ((i & 4) != 0) {
                    show4 = show2;
                    $dirty &= -897;
                    sheetPaddingValues2 = PaddingKt.PaddingValues-a9UjIt4(Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(46));
                } else {
                    show4 = show2;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                    j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                    containerShape2 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null);
                }
                if (i6 != 0) {
                    needBottomSafeAreaInset3 = true;
                    show2 = show4;
                } else {
                    show2 = show4;
                    needBottomSafeAreaInset3 = z;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty &= -7169;
                }
                if ((i & 16) != 0) {
                    $dirty &= -57345;
                }
                needBottomSafeAreaInset3 = z;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(514848946, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.WrapContentBottomSheet (BottomSheet.kt:185)");
            }
            SheetState sheetState = ModalBottomSheetKt.rememberModalBottomSheetState(true, (Function1) null, $composer2, 6, 2);
            Boolean valueOf = Boolean.valueOf(show2);
            ComposerKt.sourceInformationMarkerStart($composer2, 848618926, "CC(remember):BottomSheet.kt#9igjgp");
            boolean invalid$iv = (($dirty & 112) == 32) | $composer2.changed(sheetState);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = (Function2) new BottomSheetKt$WrapContentBottomSheet$1$1(show2, sheetState, null);
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer2, ($dirty >> 3) & 14);
            if (show2 || sheetState.isVisible()) {
                $composer2.startReplaceGroup(537632327);
                ComposerKt.sourceInformation($composer2, "199@7058L28,204@7265L836,197@6972L1129");
                ComposerKt.sourceInformationMarkerStart($composer2, 848628622, "CC(remember):BottomSheet.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit WrapContentBottomSheet_hYmLsZ8$lambda$1$0;
                            WrapContentBottomSheet_hYmLsZ8$lambda$1$0 = BottomSheetKt.WrapContentBottomSheet_hYmLsZ8$lambda$1$0(function0);
                            return WrapContentBottomSheet_hYmLsZ8$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ModalBottomSheetKt.ModalBottomSheet-YbuCTN8((Function0) it$iv2, (Modifier) null, sheetState, 0.0f, false, containerShape2, j2, 0L, 0.0f, 0L, (Function2) null, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda3
                    public final Object invoke(Object obj, Object obj2) {
                        WindowInsets WrapContentBottomSheet_hYmLsZ8$lambda$2;
                        WrapContentBottomSheet_hYmLsZ8$lambda$2 = BottomSheetKt.WrapContentBottomSheet_hYmLsZ8$lambda$2((Composer) obj, ((Integer) obj2).intValue());
                        return WrapContentBottomSheet_hYmLsZ8$lambda$2;
                    }
                }, (ModalBottomSheetProperties) null, ComposableLambdaKt.rememberComposableLambda(1154137305, true, new Function3() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit WrapContentBottomSheet_hYmLsZ8$lambda$3;
                        WrapContentBottomSheet_hYmLsZ8$lambda$3 = BottomSheetKt.WrapContentBottomSheet_hYmLsZ8$lambda$3(sheetPaddingValues2, needBottomSafeAreaInset3, function3, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return WrapContentBottomSheet_hYmLsZ8$lambda$3;
                    }
                }, $composer2, 54), $composer2, (458752 & ($dirty << 3)) | 6 | (($dirty << 9) & 3670016), 3078, 5018);
            } else {
                $composer2.startReplaceGroup(530680112);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            needBottomSafeAreaInset2 = needBottomSafeAreaInset3;
            show3 = show2;
            sheetPaddingValues3 = sheetPaddingValues2;
            j3 = j2;
            containerShape3 = containerShape2;
        } else {
            $composer2.skipToGroupEnd();
            show3 = show2;
            sheetPaddingValues3 = sheetPaddingValues2;
            containerShape3 = containerShape2;
            needBottomSafeAreaInset2 = z;
            j3 = j2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final boolean z2 = show3;
            final PaddingValues paddingValues = sheetPaddingValues3;
            final long j4 = j3;
            final Shape shape = containerShape3;
            final boolean z3 = needBottomSafeAreaInset2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.BottomSheetKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit WrapContentBottomSheet_hYmLsZ8$lambda$4;
                    WrapContentBottomSheet_hYmLsZ8$lambda$4 = BottomSheetKt.WrapContentBottomSheet_hYmLsZ8$lambda$4(function0, z2, paddingValues, j4, shape, z3, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return WrapContentBottomSheet_hYmLsZ8$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapContentBottomSheet_hYmLsZ8$lambda$1$0(Function0 $onDismiss) {
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets WrapContentBottomSheet_hYmLsZ8$lambda$2(Composer $composer, int $changed) {
        $composer.startReplaceGroup(1620616845);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1620616845, $changed, -1, "kntr.app.mall.product.details.page.ui.components.WrapContentBottomSheet.<anonymous> (BottomSheet.kt:203)");
        }
        WindowInsets WindowInsets$default = WindowInsetsKt.WindowInsets$default(0, 0, 0, 0, 14, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return WindowInsets$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapContentBottomSheet_hYmLsZ8$lambda$3(PaddingValues $sheetPaddingValues, boolean $needBottomSafeAreaInset, Function3 $content, ColumnScope $this$ModalBottomSheet, Composer $composer, int $changed) {
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$ModalBottomSheet, "$this$ModalBottomSheet");
        ComposerKt.sourceInformation($composer, "C205@7279L812:BottomSheet.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1154137305, $changed, -1, "kntr.app.mall.product.details.page.ui.components.WrapContentBottomSheet.<anonymous> (BottomSheet.kt:205)");
            }
            Modifier padding = PaddingKt.padding(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), $sheetPaddingValues);
            if ($needBottomSafeAreaInset) {
                $composer.startReplaceGroup(1691517237);
                ComposerKt.sourceInformation($composer, "214@7676L12,216@7810L17");
                modifier = PaddingKt.padding(Modifier.Companion, WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer, 0));
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1691882913);
                $composer.endReplaceGroup();
                modifier = Modifier.Companion;
            }
            Modifier modifier$iv = padding.then(modifier);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope $this$WrapContentBottomSheet_hYmLsZ8_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1050305035, "C224@8068L9:BottomSheet.kt#o90vz8");
            $content.invoke($this$WrapContentBottomSheet_hYmLsZ8_u24lambda_u243_u240, $composer, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer);
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
}