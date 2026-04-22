package kntr.app.pegasus.feedbackdialog;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import java.util.List;
import kntr.app.pegasus.feedbackdialog.model.Feedback;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItem;
import kntr.app.pegasus.feedbackdialog.model.FeedbackItemType;
import kntr.app.pegasus.feedbackdialog.model.FeedbackStyle;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedbackDialog.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aS\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0010\u001a3\u0010\u0011\u001a\u00020\u00012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"FeedbackDialog", "", "onDismiss", "Lkotlin/Function1;", "Lkntr/app/pegasus/feedbackdialog/model/FeedbackItemType;", "modifier", "Landroidx/compose/ui/Modifier;", "dataList", "", "Lkntr/app/pegasus/feedbackdialog/model/Feedback;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "maxHeight", "FeedbackDialog-6PoWaU8", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/util/List;FFLandroidx/compose/runtime/Composer;II)V", "BottomSheetDragHandle", "(Landroidx/compose/runtime/Composer;I)V", "BottomSheetContent", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "feedbackdialog_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class FeedbackDialogKt {

    /* compiled from: FeedbackDialog.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeedbackStyle.values().length];
            try {
                iArr[FeedbackStyle.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[FeedbackStyle.GRID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[FeedbackStyle.COVER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[FeedbackStyle.DEFAULT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContent$lambda$1(List list, Function1 function1, int i, int i2, Composer composer, int i3) {
        BottomSheetContent(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetDragHandle$lambda$1(int i, Composer composer, int i2) {
        BottomSheetDragHandle(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackDialog_6PoWaU8$lambda$1(Function1 function1, Modifier modifier, List list, float f, float f2, int i, int i2, Composer composer, int i3) {
        m666FeedbackDialog6PoWaU8(function1, modifier, list, f, f2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: FeedbackDialog-6PoWaU8  reason: not valid java name */
    public static final void m666FeedbackDialog6PoWaU8(final Function1<? super FeedbackItemType, Unit> function1, Modifier modifier, List<Feedback> list, float f, float f2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        List list2;
        float f3;
        float f4;
        Modifier modifier3;
        List dataList;
        float f5;
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(1372408299);
        ComposerKt.sourceInformation($composer2, "C(FeedbackDialog)N(onDismiss,modifier,dataList,minHeight:c#ui.unit.Dp,maxHeight:c#ui.unit.Dp)33@1338L576,33@1328L586:FeedbackDialog.kt#36vyx9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
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
            list2 = list;
        } else if (($changed & 384) == 0) {
            list2 = list;
            $dirty |= $composer2.changedInstance(list2) ? 256 : 128;
        } else {
            list2 = list;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            f3 = f;
        } else if (($changed & 3072) == 0) {
            f3 = f;
            $dirty |= $composer2.changed(f3) ? 2048 : 1024;
        } else {
            f3 = f;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            f4 = f2;
        } else if (($changed & 24576) == 0) {
            f4 = f2;
            $dirty |= $composer2.changed(f4) ? 16384 : 8192;
        } else {
            f4 = f2;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            dataList = list2;
            f5 = f3;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 == 0) {
                dataList = list2;
            } else {
                dataList = null;
            }
            if (i4 != 0) {
                f3 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            if (i5 != 0) {
                f4 = Dp.Companion.getUnspecified-D9Ej5fM();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1372408299, $dirty2, -1, "kntr.app.pegasus.feedbackdialog.FeedbackDialog (FeedbackDialog.kt:32)");
            }
            final Modifier modifier4 = modifier3;
            final float f6 = f3;
            final float f7 = f4;
            final List list3 = dataList;
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(-1284399821, true, new Function2() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedbackDialog_6PoWaU8$lambda$0;
                    FeedbackDialog_6PoWaU8$lambda$0 = FeedbackDialogKt.FeedbackDialog_6PoWaU8$lambda$0(modifier4, f6, f7, list3, function1, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedbackDialog_6PoWaU8$lambda$0;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f5 = f3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final List list4 = dataList;
            final float f8 = f5;
            final float f9 = f4;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedbackDialog_6PoWaU8$lambda$1;
                    FeedbackDialog_6PoWaU8$lambda$1 = FeedbackDialogKt.FeedbackDialog_6PoWaU8$lambda$1(function1, modifier5, list4, f8, f9, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedbackDialog_6PoWaU8$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedbackDialog_6PoWaU8$lambda$0(Modifier $modifier, float f, float f2, List $dataList, Function1 $onDismiss, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C40@1579L6,34@1348L560:FeedbackDialog.kt#36vyx9");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1284399821, $changed, -1, "kntr.app.pegasus.feedbackdialog.FeedbackDialog.<anonymous> (FeedbackDialog.kt:34)");
            }
            Modifier modifier$iv = ClipKt.clip(BackgroundKt.background-bw27NRU(SizeKt.heightIn-VpY3zN4(SizeKt.fillMaxWidth$default($modifier, 0.0f, 1, (Object) null), f, f2), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null)), RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4$default(Dp.constructor-impl(12), Dp.constructor-impl(12), 0.0f, 0.0f, 12, (Object) null));
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1253660077, "C44@1789L109:FeedbackDialog.kt#36vyx9");
            BottomSheetContent($dataList, $onDismiss, $composer, 0, 0);
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

    public static final void BottomSheetDragHandle(Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1113096802);
        ComposerKt.sourceInformation($composer2, "C(BottomSheetDragHandle)59@2127L6,54@1973L547:FeedbackDialog.kt#36vyx9");
        if (!$composer2.shouldExecute($changed != 0, $changed & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1113096802, $changed, -1, "kntr.app.pegasus.feedbackdialog.BottomSheetDragHandle (FeedbackDialog.kt:53)");
            }
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(19)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1690301544, "C67@2391L6,62@2207L307:FeedbackDialog.kt#36vyx9");
            BoxKt.Box(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(30), Dp.constructor-impl(3)), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBa0_s-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetDragHandle$lambda$1;
                    BottomSheetDragHandle$lambda$1 = FeedbackDialogKt.BottomSheetDragHandle$lambda$1($changed, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetDragHandle$lambda$1;
                }
            });
        }
    }

    public static final void BottomSheetContent(List<Feedback> list, final Function1<? super FeedbackItemType, Unit> function1, Composer $composer, final int $changed, final int i) {
        final List dataList;
        Composer $composer2;
        final List dataList2;
        Intrinsics.checkNotNullParameter(function1, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-1571720360);
        ComposerKt.sourceInformation($composer3, "C(BottomSheetContent)N(dataList,onDismiss)82@2815L1440,80@2701L1554:FeedbackDialog.kt#36vyx9");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            dataList = list;
        } else if (($changed & 6) == 0) {
            dataList = list;
            $dirty |= $composer3.changedInstance(dataList) ? 4 : 2;
        } else {
            dataList = list;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (i2 != 0) {
                dataList2 = null;
            } else {
                dataList2 = dataList;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1571720360, $dirty2, -1, "kntr.app.pegasus.feedbackdialog.BottomSheetContent (FeedbackDialog.kt:79)");
            }
            Modifier modifier = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16), 0.0f, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(20), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1405231000, "CC(remember):FeedbackDialog.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(dataList2) | (($dirty2 & 112) == 32);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        Unit BottomSheetContent$lambda$0$0;
                        BottomSheetContent$lambda$0$0 = FeedbackDialogKt.BottomSheetContent$lambda$0$0(dataList2, function1, (LazyListScope) obj);
                        return BottomSheetContent$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            List dataList3 = dataList2;
            $composer2 = $composer3;
            LazyDslKt.LazyColumn(modifier, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer3, 6, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            dataList = dataList3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit BottomSheetContent$lambda$1;
                    BottomSheetContent$lambda$1 = FeedbackDialogKt.BottomSheetContent$lambda$1(dataList, function1, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BottomSheetContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContent$lambda$0$0(final List $dataList, final Function1 $onDismiss, LazyListScope $this$LazyColumn) {
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.stickyHeader$default($this$LazyColumn, (Object) null, (Object) null, ComposableSingletons$FeedbackDialogKt.INSTANCE.getLambda$644208441$feedbackdialog_debug(), 3, (Object) null);
        if ($dataList != null) {
            List $this$forEachIndexed$iv = $dataList;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final Feedback feedback = (Feedback) item$iv;
                final int index = index$iv;
                LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(1857051936, true, new Function3() { // from class: kntr.app.pegasus.feedbackdialog.FeedbackDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit BottomSheetContent$lambda$0$0$0$0;
                        BottomSheetContent$lambda$0$0$0$0 = FeedbackDialogKt.BottomSheetContent$lambda$0$0$0$0(Feedback.this, index, $dataList, $onDismiss, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return BottomSheetContent$lambda$0$0$0$0;
                    }
                }), 3, (Object) null);
                index$iv = index$iv2;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomSheetContent$lambda$0$0$0$0(Feedback $feedback, int $index, List $dataList, Function1 $onDismiss, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C:FeedbackDialog.kt#36vyx9");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1857051936, $changed, -1, "kntr.app.pegasus.feedbackdialog.BottomSheetContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FeedbackDialog.kt:88)");
            }
            List<FeedbackItem> items = $feedback.getItems();
            if (items == null || items.isEmpty()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
            boolean isLast = $index == $dataList.size() - 1;
            switch (WhenMappings.$EnumSwitchMapping$0[$feedback.getStyle().ordinal()]) {
                case 1:
                    $composer.startReplaceGroup(-39301707);
                    ComposerKt.sourceInformation($composer, "92@3187L145");
                    ListIconTextKt.ListIconText($feedback.getItems(), $onDismiss, $composer, 0);
                    if (isLast) {
                        $composer.startReplaceGroup(-42448734);
                    } else {
                        $composer.startReplaceGroup(-39096735);
                        ComposerKt.sourceInformation($composer, "97@3405L41");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
                    }
                    $composer.endReplaceGroup();
                    $composer.endReplaceGroup();
                    break;
                case 2:
                    $composer.startReplaceGroup(-38926111);
                    ComposerKt.sourceInformation($composer, "102@3564L197");
                    GridIconTextKt.GridIconText($feedback.getItems(), $feedback.getTitle(), $onDismiss, $composer, 0, 0);
                    if (isLast) {
                        $composer.startReplaceGroup(-42448734);
                    } else {
                        $composer.startReplaceGroup(-38671167);
                        ComposerKt.sourceInformation($composer, "108@3834L41");
                        SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer, 6);
                    }
                    $composer.endReplaceGroup();
                    $composer.endReplaceGroup();
                    break;
                case 3:
                    $composer.startReplaceGroup(-38505596);
                    ComposerKt.sourceInformation($composer, "113@3994L142");
                    ImageTextKt.ImageText($feedback.getItems(), $onDismiss, $composer, 0);
                    $composer.endReplaceGroup();
                    break;
                case 4:
                    $composer.startReplaceGroup(-38276320);
                    $composer.endReplaceGroup();
                    break;
                default:
                    $composer.startReplaceGroup(-2079479094);
                    $composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}