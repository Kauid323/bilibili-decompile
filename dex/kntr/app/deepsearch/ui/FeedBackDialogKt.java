package kntr.app.deepsearch.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
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
import androidx.compose.ui.text.input.VisualTransformation;
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
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kntr.app.deepsearch.base.model.biz.DeepSearchAction;
import kntr.app.deepsearch.base.model.biz.DeepSearchTreadPopModel;
import kntr.app.deepsearch.base.model.biz.TextConfigModel;
import kntr.app.deepsearch.ui.bottomSheet.GeneralBottomSheetDialogKt;
import kntr.app.deepsearch.ui.input.ImeVisibleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.deepsearch.compose.generated.resources.Res;
import srcs.app.deepsearch.compose.generated.resources.String0_commonMainKt;

/* compiled from: FeedBackDialog.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a?\u0010\u0010\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\n\u0010\u0013\u001a\u00020\nX\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"FeedBackDialog", RoomRecommendViewModel.EMPTY_CURSOR, "showFeedBackDialog", RoomRecommendViewModel.EMPTY_CURSOR, "dispatcher", "Lkotlin/Function1;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchAction;", "onDismissRequest", "Lkotlin/Function0;", "queryId", RoomRecommendViewModel.EMPTY_CURSOR, "data", "Lkntr/app/deepsearch/base/model/biz/TextConfigModel;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/TextConfigModel;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "FeedBackDialogContent", "(Ljava/lang/String;Lkntr/app/deepsearch/base/model/biz/TextConfigModel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "compose_debug", "selectedOption", "suggestion"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FeedBackDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialog$lambda$1(boolean z, Function1 function1, Function0 function0, String str, TextConfigModel textConfigModel, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FeedBackDialog(z, function1, function0, str, textConfigModel, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialogContent$lambda$3(String str, TextConfigModel textConfigModel, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        FeedBackDialogContent(str, textConfigModel, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FeedBackDialog(final boolean showFeedBackDialog, final Function1<? super DeepSearchAction, Unit> function1, final Function0<Unit> function0, final String queryId, final TextConfigModel data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(function1, "dispatcher");
        Intrinsics.checkNotNullParameter(function0, "onDismissRequest");
        Intrinsics.checkNotNullParameter(queryId, "queryId");
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer2 = $composer.startRestartGroup(1904695877);
        ComposerKt.sourceInformation($composer2, "C(FeedBackDialog)N(showFeedBackDialog,dispatcher,onDismissRequest,queryId,data,modifier)64@2735L82,58@2525L292:FeedBackDialog.kt#7uvpm4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(showFeedBackDialog) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(queryId) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 16384 : 8192;
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
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1904695877, $dirty2, -1, "kntr.app.deepsearch.ui.FeedBackDialog (FeedBackDialog.kt:57)");
            }
            GeneralBottomSheetDialogKt.GeneralBottomSheetDialog(showFeedBackDialog, true, true, function0, modifier3, ComposableLambdaKt.rememberComposableLambda(-1782419733, true, new Function2() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedBackDialog$lambda$0;
                    FeedBackDialog$lambda$0 = FeedBackDialogKt.FeedBackDialog$lambda$0(queryId, data, function1, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedBackDialog$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 197040 | (($dirty2 << 3) & 7168) | (57344 & ($dirty2 >> 3)), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit FeedBackDialog$lambda$1;
                    FeedBackDialog$lambda$1 = FeedBackDialogKt.FeedBackDialog$lambda$1(showFeedBackDialog, function1, function0, queryId, data, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return FeedBackDialog$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialog$lambda$0(String $queryId, TextConfigModel $data, Function1 $dispatcher, Function0 $onDismissRequest, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C65@2745L66:FeedBackDialog.kt#7uvpm4");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1782419733, $changed, -1, "kntr.app.deepsearch.ui.FeedBackDialog.<anonymous> (FeedBackDialog.kt:65)");
            }
            FeedBackDialogContent($queryId, $data, $dispatcher, $onDismissRequest, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x09d0  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x09dc  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x09e2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0a5d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0a75  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x1148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void FeedBackDialogContent(final String queryId, final TextConfigModel data, final Function1<? super DeepSearchAction, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        int $dirty;
        Modifier modifier;
        Function0 factory$iv$iv$iv;
        List emptyList;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        final MutableState suggestion$delegate;
        long j2;
        Composer $composer$iv;
        Object obj;
        Composer $composer$iv2;
        final MutableState suggestion$delegate2;
        final MutableState selectedOption$delegate;
        float f;
        int i;
        long j3;
        Composer $composer$iv$iv;
        int rowIndex;
        Composer $composer2;
        Composer $composer3;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv$iv2;
        String str;
        Composer $composer$iv3;
        Composer $composer$iv4;
        CompositionLocalMap localMap$iv$iv;
        int $changed$iv$iv$iv;
        boolean z;
        String str2;
        Modifier materialized$iv$iv;
        String str3;
        Function0 factory$iv$iv$iv6;
        Function0 value$iv;
        final MutableState selectedOption$delegate2;
        Function0 factory$iv$iv$iv7;
        long j4;
        String title;
        Composer $composer4 = $composer.startRestartGroup(-1033790385);
        ComposerKt.sourceInformation($composer4, "C(FeedBackDialogContent)N(queryId,data,dispatcher,onDismissRequest)77@3066L7,78@3105L7,79@3144L46,95@3723L6,80@3195L7628:FeedBackDialog.kt#7uvpm4");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer4.changed(queryId) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changedInstance(data) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if ($composer4.shouldExecute(($dirty3 & 1171) != 1170, $dirty3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1033790385, $dirty3, -1, "kntr.app.deepsearch.ui.FeedBackDialogContent (FeedBackDialog.kt:76)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density density = (Density) consume;
            CompositionLocal this_$iv2 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Toaster toaster = (Toaster) consume2;
            final String outOfInputTextLength = StringResourcesKt.stringResource(String0_commonMainKt.getText_lengths_limits(Res.string.INSTANCE), $composer4, 0);
            $composer4.startReplaceGroup(-1335102158);
            ComposerKt.sourceInformation($composer4, "84@3290L12");
            Modifier modifier2 = Modifier.Companion;
            if (ImeVisibleKt.imeVisible($composer4, 0)) {
                $composer4.startReplaceGroup(-1419794013);
                $composer4.endReplaceGroup();
                modifier = modifier2;
            } else {
                $composer4.startReplaceGroup(-1419898638);
                ComposerKt.sourceInformation($composer4, "85@3374L14");
                Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(modifier2, WindowInsets_androidKt.getNavigationBars(WindowInsets.Companion, $composer4, 6));
                $composer4.endReplaceGroup();
                modifier = windowInsetsPadding;
            }
            $composer4.endReplaceGroup();
            $composer4.startReplaceGroup(-1335093005);
            ComposerKt.sourceInformation($composer4, "*92@3594L14");
            float f2 = density.toDp-u2uoSUM(DeepSearchPreview_androidKt.getImeHeight($composer4, 0).getIntValue());
            $composer4.endReplaceGroup();
            Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f2, 7, (Object) null), 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2_float-0d7_KjU(), (Shape) null, 2, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv8;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -399995619, "C98@3830L31,99@3888L31,103@4045L536,122@4591L4283,218@9051L6,213@8884L198,221@9121L827,247@10255L345,220@9091L1726:FeedBackDialog.kt#7uvpm4");
            ComposerKt.sourceInformationMarkerStart($composer4, -1536930012, "CC(remember):FeedBackDialog.kt#9igjgp");
            Object value$iv2 = $composer4.rememberedValue();
            if (value$iv2 == Composer.Companion.getEmpty()) {
                value$iv2 = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv2);
            }
            MutableState selectedOption$delegate3 = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1536928156, "CC(remember):FeedBackDialog.kt#9igjgp");
            Object value$iv3 = $composer4.rememberedValue();
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = SnapshotStateKt.mutableStateOf$default(RoomRecommendViewModel.EMPTY_CURSOR, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv3);
            }
            MutableState suggestion$delegate3 = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            DeepSearchTreadPopModel treadPop = data.getTreadPop();
            if (treadPop == null || (emptyList = treadPop.getReasons()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            List options = emptyList;
            DeepSearchTreadPopModel treadPop2 = data.getTreadPop();
            int maxChars = treadPop2 != null ? treadPop2.getMaxCountWords() : 200;
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(19));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            final int maxChars2 = maxChars;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
            String str6 = "CC(remember):FeedBackDialog.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv9;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            MutableState selectedOption$delegate4 = selectedOption$delegate3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1238714032, "C117@4519L6,110@4243L328:FeedBackDialog.kt#7uvpm4");
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(30)), Dp.constructor-impl(3)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGa3-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, Dp.constructor-impl(16), 0.0f, 10, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv3 = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv10;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv4 >> 6) & 14;
            Composer $composer$iv5 = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv5, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i7 = ((6 >> 6) & 112) | 6;
            Composer $composer5 = $composer$iv5;
            ComposerKt.sourceInformationMarkerStart($composer5, -333259684, "C127@4783L6,128@4831L9,125@4692L231,131@4936L2075,177@7267L6,171@7025L1796,210@8834L30:FeedBackDialog.kt#7uvpm4");
            DeepSearchTreadPopModel treadPop3 = data.getTreadPop();
            TextKt.Text-Nvy7gAk((treadPop3 == null || (title = treadPop3.getTitle()) == null) ? RoomRecommendViewModel.EMPTY_CURSOR : title, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(10), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT15b(), $composer5, 48, 0, 131064);
            Modifier modifier$iv4 = Modifier.Companion;
            Composer $composer$iv6 = $composer5;
            ComposerKt.sourceInformationMarkerStart($composer$iv6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
            int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer$iv6, $i$f$Column);
            int $changed$iv$iv4 = (6 << 3) & 112;
            Composer $composer$iv$iv2 = $composer$iv6;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv2, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv$iv2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv$iv2, modifier$iv4);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv3 = $composer$iv$iv2;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv3.startReusableNode();
            if ($composer$iv$iv$iv3.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
                $composer$iv$iv$iv3.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv11;
                $composer$iv$iv$iv3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv$iv$iv3);
            MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i8 = ($changed$iv$iv$iv5 >> 6) & 14;
            Composer $composer$iv7 = $composer$iv$iv$iv3;
            boolean z2 = false;
            ComposerKt.sourceInformationMarkerStart($composer$iv7, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
            int i9 = ((6 >> 6) & 112) | 6;
            Composer $composer$iv8 = $composer$iv7;
            ComposerKt.sourceInformationMarkerStart($composer$iv8, -364425997, "C:FeedBackDialog.kt#7uvpm4");
            $composer$iv8.startReplaceGroup(1512264976);
            ComposerKt.sourceInformation($composer$iv8, RoomRecommendViewModel.EMPTY_CURSOR);
            int rowIndex2 = 0;
            while (rowIndex2 < 2) {
                int startIndex = rowIndex2 * 2;
                MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                List rowOptions = CollectionsKt.take(CollectionsKt.drop(options, startIndex), 2);
                if (rowOptions.isEmpty()) {
                    $composer$iv$iv = $composer$iv$iv2;
                    rowIndex = rowIndex2;
                    $composer2 = $composer$iv8;
                    $composer3 = $composer5;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    $composer$iv$iv$iv2 = $composer$iv6;
                    str = str5;
                    $composer$iv3 = $composer$iv7;
                    $composer$iv4 = $composer$iv5;
                    localMap$iv$iv = localMap$iv$iv5;
                    $changed$iv$iv$iv = $changed$iv$iv$iv5;
                    z = z2;
                    str2 = str4;
                    materialized$iv$iv = materialized$iv$iv5;
                    str3 = str6;
                    $composer2.startReplaceGroup(-369431599);
                } else {
                    $composer$iv8.startReplaceGroup(-364235317);
                    ComposerKt.sourceInformation($composer$iv8, "136@5207L1685,166@6917L40");
                    localMap$iv$iv = localMap$iv$iv5;
                    $changed$iv$iv$iv = $changed$iv$iv$iv5;
                    z = z2;
                    Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    Composer $composer$iv9 = $composer$iv8;
                    materialized$iv$iv = materialized$iv$iv5;
                    ComposerKt.sourceInformationMarkerStart($composer$iv9, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv9, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                    int $changed$iv$iv5 = (54 << 3) & 112;
                    Composer $composer$iv$iv3 = $composer$iv9;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv3, -1159599143, str4);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv3, 0));
                    CompositionLocalMap localMap$iv$iv6 = $composer$iv$iv3.getCurrentCompositionLocalMap();
                    $composer$iv4 = $composer$iv5;
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv$iv3, modifier$iv5);
                    Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv = (($changed$iv$iv5 << 6) & 896) | 6;
                    $composer3 = $composer5;
                    Composer $composer$iv$iv$iv4 = $composer$iv$iv3;
                    $composer$iv$iv$iv2 = $composer$iv6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, str5);
                    if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv$iv$iv4.startReusableNode();
                    if ($composer$iv$iv$iv4.getInserting()) {
                        factory$iv$iv$iv6 = factory$iv$iv$iv12;
                        $composer$iv$iv$iv4.createNode(factory$iv$iv$iv6);
                    } else {
                        factory$iv$iv$iv6 = factory$iv$iv$iv12;
                        $composer$iv$iv$iv4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv$iv$iv4);
                    $composer$iv$iv = $composer$iv$iv2;
                    $composer$iv$iv$iv = $composer$iv$iv$iv3;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i10 = ($changed$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i11 = ((54 >> 6) & 112) | 6;
                    RowScope $this$FeedBackDialogContent_u24lambda_u242_u247_u240_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -1202748989, "C:FeedBackDialog.kt#7uvpm4");
                    $composer$iv$iv$iv4.startReplaceGroup(-1562819167);
                    ComposerKt.sourceInformation($composer$iv$iv$iv4, "*147@5846L6,148@5925L240,142@5547L1130");
                    Iterator it = rowOptions.iterator();
                    while (it.hasNext()) {
                        final String option = (String) it.next();
                        Iterator it2 = it;
                        final boolean isSelected = Intrinsics.areEqual(FeedBackDialogContent$lambda$2$1(selectedOption$delegate4), option);
                        int compositeKeyHash$iv$iv6 = compositeKeyHash$iv$iv5;
                        CompositionLocalMap localMap$iv$iv7 = localMap$iv$iv6;
                        int $changed$iv$iv$iv6 = $changed$iv;
                        Modifier modifier3 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(RowScope.-CC.weight$default($this$FeedBackDialogContent_u24lambda_u242_u247_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), BiliTheme.INSTANCE.getColors($composer$iv$iv$iv4, BiliTheme.$stable).getGraph_bg_bright-0d7_KjU(), (Shape) null, 2, (Object) null);
                        String str7 = str6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -1562803806, str7);
                        boolean invalid$iv = $composer$iv$iv$iv4.changed(isSelected) | $composer$iv$iv$iv4.changed(option);
                        Object it$iv = $composer$iv$iv$iv4.rememberedValue();
                        if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
                            value$iv = it$iv;
                            selectedOption$delegate2 = selectedOption$delegate4;
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            selectedOption$delegate4 = selectedOption$delegate2;
                            Modifier modifier$iv6 = SizeKt.height-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), Dp.constructor-impl(36));
                            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                            Composer $composer$iv10 = $composer$iv7;
                            int rowIndex3 = rowIndex2;
                            Composer $composer6 = $composer$iv8;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv6 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv6 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -1159599143, str4);
                            int compositeKeyHash$iv$iv7 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv4, 0));
                            CompositionLocalMap localMap$iv$iv8 = $composer$iv$iv$iv4.getCurrentCompositionLocalMap();
                            String str8 = str4;
                            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv4, modifier$iv6);
                            Function0 factory$iv$iv$iv13 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                            Composer $composer$iv11 = $composer$iv9;
                            Composer $composer$iv$iv$iv5 = $composer$iv$iv3;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, str5);
                            if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer$iv$iv$iv4.startReusableNode();
                            if ($composer$iv$iv$iv4.getInserting()) {
                                factory$iv$iv$iv7 = factory$iv$iv$iv13;
                                $composer$iv$iv$iv4.useNode();
                            } else {
                                factory$iv$iv$iv7 = factory$iv$iv$iv13;
                                $composer$iv$iv$iv4.createNode(factory$iv$iv$iv7);
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer$iv$iv$iv4);
                            String str9 = str5;
                            Composer $composer$iv$iv$iv6 = $composer$iv$iv$iv4;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv8, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv7), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv7, ComposeUiNode.Companion.getSetModifier());
                            int i12 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                            int i13 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1551087148, "C158@6566L9,155@6326L317:FeedBackDialog.kt#7uvpm4");
                            if (isSelected) {
                                $composer$iv$iv$iv4.startReplaceGroup(1989703007);
                                ComposerKt.sourceInformation($composer$iv$iv$iv4, "157@6494L6");
                                j4 = BiliTheme.INSTANCE.getColors($composer$iv$iv$iv4, BiliTheme.$stable).getText1-0d7_KjU();
                            } else {
                                $composer$iv$iv$iv4.startReplaceGroup(1989701956);
                                ComposerKt.sourceInformation($composer$iv$iv$iv4, "157@6461L6");
                                j4 = BiliTheme.INSTANCE.getColors($composer$iv$iv$iv4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                            }
                            $composer$iv$iv$iv4.endReplaceGroup();
                            TextKt.Text-Nvy7gAk(option, (Modifier) null, j4, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv$iv4, BiliTheme.$stable).getT14(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646143, (Object) null), $composer$iv$iv$iv4, 0, 0, 131066);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            $composer$iv$iv$iv4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                            localMap$iv$iv6 = localMap$iv$iv7;
                            str6 = str7;
                            $changed$iv = $changed$iv$iv$iv6;
                            $composer$iv7 = $composer$iv10;
                            it = it2;
                            compositeKeyHash$iv$iv5 = compositeKeyHash$iv$iv6;
                            rowIndex2 = rowIndex3;
                            $composer$iv8 = $composer6;
                            str4 = str8;
                            $composer$iv$iv3 = $composer$iv$iv$iv5;
                            $composer$iv9 = $composer$iv11;
                            str5 = str9;
                            $composer$iv$iv$iv4 = $composer$iv$iv$iv6;
                        }
                        selectedOption$delegate2 = selectedOption$delegate4;
                        value$iv = new Function0() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit FeedBackDialogContent$lambda$2$7$0$0$0$0;
                                FeedBackDialogContent$lambda$2$7$0$0$0$0 = FeedBackDialogKt.FeedBackDialogContent$lambda$2$7$0$0$0$0(isSelected, option, selectedOption$delegate2);
                                return FeedBackDialogContent$lambda$2$7$0$0$0$0;
                            }
                        };
                        $composer$iv$iv$iv4.updateRememberedValue(value$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        selectedOption$delegate4 = selectedOption$delegate2;
                        Modifier modifier$iv62 = SizeKt.height-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier3, false, (String) null, (Role) null, (MutableInteractionSource) null, value$iv, 15, (Object) null), Dp.constructor-impl(36));
                        Alignment contentAlignment$iv22 = Alignment.Companion.getCenter();
                        Composer $composer$iv102 = $composer$iv7;
                        int rowIndex32 = rowIndex2;
                        Composer $composer62 = $composer$iv8;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv62 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv22, false);
                        int $changed$iv$iv62 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -1159599143, str4);
                        int compositeKeyHash$iv$iv72 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv$iv$iv4, 0));
                        CompositionLocalMap localMap$iv$iv82 = $composer$iv$iv$iv4.getCurrentCompositionLocalMap();
                        String str82 = str4;
                        Modifier materialized$iv$iv72 = ComposedModifierKt.materializeModifier($composer$iv$iv$iv4, modifier$iv62);
                        Function0 factory$iv$iv$iv132 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv72 = (($changed$iv$iv62 << 6) & 896) | 6;
                        Composer $composer$iv112 = $composer$iv9;
                        Composer $composer$iv$iv$iv52 = $composer$iv$iv3;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, -553112988, str5);
                        if (!($composer$iv$iv$iv4.getApplier() instanceof Applier)) {
                        }
                        $composer$iv$iv$iv4.startReusableNode();
                        if ($composer$iv$iv$iv4.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv62 = Updater.constructor-impl($composer$iv$iv$iv4);
                        String str92 = str5;
                        Composer $composer$iv$iv$iv62 = $composer$iv$iv$iv4;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, measurePolicy$iv62, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, localMap$iv$iv82, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv62, Integer.valueOf(compositeKeyHash$iv$iv72), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv62, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv62, materialized$iv$iv72, ComposeUiNode.Companion.getSetModifier());
                        int i122 = ($changed$iv$iv$iv72 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope22 = BoxScopeInstance.INSTANCE;
                        int i132 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv4, 1551087148, "C158@6566L9,155@6326L317:FeedBackDialog.kt#7uvpm4");
                        if (isSelected) {
                        }
                        $composer$iv$iv$iv4.endReplaceGroup();
                        TextKt.Text-Nvy7gAk(option, (Modifier) null, j4, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, TextStyle.copy-p1EtxEg$default(BiliTheme.INSTANCE.getTextStyle($composer$iv$iv$iv4, BiliTheme.$stable).getT14(), 0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(20), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646143, (Object) null), $composer$iv$iv$iv4, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        $composer$iv$iv$iv4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                        localMap$iv$iv6 = localMap$iv$iv7;
                        str6 = str7;
                        $changed$iv = $changed$iv$iv$iv6;
                        $composer$iv7 = $composer$iv102;
                        it = it2;
                        compositeKeyHash$iv$iv5 = compositeKeyHash$iv$iv6;
                        rowIndex2 = rowIndex32;
                        $composer$iv8 = $composer62;
                        str4 = str82;
                        $composer$iv$iv3 = $composer$iv$iv$iv52;
                        $composer$iv9 = $composer$iv112;
                        str5 = str92;
                        $composer$iv$iv$iv4 = $composer$iv$iv$iv62;
                    }
                    rowIndex = rowIndex2;
                    Composer $composer$iv$iv4 = $composer$iv$iv3;
                    Composer $composer7 = $composer$iv8;
                    Composer $composer$iv$iv$iv7 = $composer$iv$iv$iv4;
                    str = str5;
                    $composer$iv3 = $composer$iv7;
                    Composer $composer$iv12 = $composer$iv9;
                    str2 = str4;
                    str3 = str6;
                    $composer$iv$iv$iv4.endReplaceGroup();
                    $composer$iv$iv$iv4.startReplaceGroup(-1562777964);
                    ComposerKt.sourceInformation($composer$iv$iv$iv4, "*163@6798L38");
                    int size = 2 - rowOptions.size();
                    for (int i14 = 0; i14 < size; i14++) {
                        SpacerKt.Spacer(RowScope.-CC.weight$default($this$FeedBackDialogContent_u24lambda_u242_u247_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer$iv$iv$iv4, 0);
                    }
                    $composer$iv$iv$iv4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv4);
                    $composer$iv$iv$iv7.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv7);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv12);
                    $composer2 = $composer7;
                    SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer2, 6);
                }
                $composer2.endReplaceGroup();
                $composer$iv8 = $composer2;
                measurePolicy$iv$iv = measurePolicy$iv$iv2;
                localMap$iv$iv5 = localMap$iv$iv;
                $changed$iv$iv$iv5 = $changed$iv$iv$iv;
                z2 = z;
                materialized$iv$iv5 = materialized$iv$iv;
                $composer$iv5 = $composer$iv4;
                $composer$iv6 = $composer$iv$iv$iv2;
                $composer5 = $composer3;
                $composer$iv$iv$iv3 = $composer$iv$iv$iv;
                str6 = str3;
                $composer$iv7 = $composer$iv3;
                str4 = str2;
                str5 = str;
                rowIndex2 = rowIndex + 1;
                $composer$iv$iv2 = $composer$iv$iv;
            }
            Composer $composer8 = $composer$iv8;
            Composer $composer9 = $composer5;
            Composer $composer$iv$iv$iv8 = $composer$iv$iv$iv3;
            String str10 = str5;
            Composer $composer$iv13 = $composer$iv5;
            String str11 = str6;
            $composer8.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer$iv7);
            $composer$iv$iv$iv8.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv8);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv6);
            Modifier modifier$iv7 = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(90)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(6))), BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getGraph_bg_bright-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer9, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv3 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv7 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv7 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer9, -1159599143, str4);
            int compositeKeyHash$iv$iv8 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer9, 0));
            CompositionLocalMap localMap$iv$iv9 = $composer9.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer9, modifier$iv7);
            Function0 factory$iv$iv$iv14 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer9, -553112988, str10);
            if (!($composer9.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer9.startReusableNode();
            if ($composer9.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv14;
                $composer9.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv14;
                $composer9.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.constructor-impl($composer9);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv7, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv9, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv7, Integer.valueOf(compositeKeyHash$iv$iv8), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv7, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv8, ComposeUiNode.Companion.getSetModifier());
            int i15 = ($changed$iv$iv$iv8 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer9, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i16 = ((0 >> 6) & 112) | 6;
            BoxScope $this$FeedBackDialogContent_u24lambda_u242_u247_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer9, -1608293641, "C181@7416L63,185@7661L6,187@7787L543,179@7324L1025,207@8775L9,200@8366L441:FeedBackDialog.kt#7uvpm4");
            String FeedBackDialogContent$lambda$2$4 = FeedBackDialogContent$lambda$2$4(suggestion$delegate3);
            ComposerKt.sourceInformationMarkerStart($composer9, 86668416, str11);
            Object value$iv4 = $composer9.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                suggestion$delegate = suggestion$delegate3;
                value$iv4 = new Function1() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj2) {
                        Unit FeedBackDialogContent$lambda$2$7$1$0$0;
                        FeedBackDialogContent$lambda$2$7$1$0$0 = FeedBackDialogKt.FeedBackDialogContent$lambda$2$7$1$0$0(suggestion$delegate, (String) obj2);
                        return FeedBackDialogContent$lambda$2$7$1$0$0;
                    }
                };
                $composer9.updateRememberedValue(value$iv4);
            } else {
                suggestion$delegate = suggestion$delegate3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer9);
            BasicTextFieldKt.BasicTextField(FeedBackDialogContent$lambda$2$4, (Function1) value$iv4, SizeKt.fillMaxSize$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(12), Dp.constructor-impl(20)), 0.0f, 1, (Object) null), false, false, new TextStyle(BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (VisualTransformation) null, (Function1) null, (MutableInteractionSource) null, new SolidColor(Color.Companion.getRed-0d7_KjU(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-482076354, true, new Function3() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    Unit FeedBackDialogContent$lambda$2$7$1$1;
                    FeedBackDialogContent$lambda$2$7$1$1 = FeedBackDialogKt.FeedBackDialogContent$lambda$2$7$1$1(TextConfigModel.this, suggestion$delegate, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return FeedBackDialogContent$lambda$2$7$1$1;
                }
            }, $composer9, 54), $composer9, 48, 221184, 16344);
            String str12 = FeedBackDialogContent$lambda$2$4(suggestion$delegate).length() + "/" + maxChars2;
            Modifier modifier4 = PaddingKt.padding-qDBjuR0$default($this$FeedBackDialogContent_u24lambda_u242_u247_u241.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), 0.0f, 0.0f, Dp.constructor-impl(8), Dp.constructor-impl(4), 3, (Object) null);
            if (FeedBackDialogContent$lambda$2$4(suggestion$delegate).length() > maxChars2) {
                $composer9.startReplaceGroup(86709355);
                ComposerKt.sourceInformation($composer9, "206@8690L6");
                j2 = BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getStress_red-0d7_KjU();
            } else {
                $composer9.startReplaceGroup(86710406);
                ComposerKt.sourceInformation($composer9, "206@8723L6");
                j2 = BiliTheme.INSTANCE.getColors($composer9, BiliTheme.$stable).getText4-0d7_KjU();
            }
            $composer9.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str12, modifier4, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer9, BiliTheme.$stable).getT12(), $composer9, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            $composer9.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer9, 6);
            ComposerKt.sourceInformationMarkerEnd($composer9);
            ComposerKt.sourceInformationMarkerEnd($composer$iv13);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), (Shape) null, 2, (Object) null), $composer4, 0);
            ComposerKt.sourceInformationMarkerStart($composer4, -1536759904, str11);
            $composer4 = $composer4;
            boolean invalid$iv2 = $composer4.changed(maxChars2) | $composer4.changedInstance(toaster) | $composer4.changed(outOfInputTextLength) | (($dirty3 & 896) == 256) | (($dirty3 & 14) == 4) | (($dirty3 & 7168) == 2048);
            Object value$iv5 = $composer4.rememberedValue();
            if (invalid$iv2 || value$iv5 == Composer.Companion.getEmpty()) {
                $composer$iv = $composer4;
                obj = null;
                $composer$iv2 = $composer4;
                suggestion$delegate2 = suggestion$delegate;
                selectedOption$delegate = selectedOption$delegate4;
                $dirty = $dirty3;
                f = 0.0f;
                i = 1;
                value$iv5 = new Function0() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit FeedBackDialogContent$lambda$2$8$0;
                        FeedBackDialogContent$lambda$2$8$0 = FeedBackDialogKt.FeedBackDialogContent$lambda$2$8$0(maxChars2, toaster, outOfInputTextLength, function1, queryId, function0, selectedOption$delegate, suggestion$delegate2);
                        return FeedBackDialogContent$lambda$2$8$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv5);
            } else {
                i = 1;
                f = 0.0f;
                obj = null;
                suggestion$delegate2 = suggestion$delegate;
                $dirty = $dirty3;
                $composer$iv2 = $composer4;
                $composer$iv = $composer4;
                selectedOption$delegate = selectedOption$delegate4;
            }
            Function0 function02 = (Function0) value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(PaddingKt.padding-qDBjuR0(Modifier.Companion, Dp.constructor-impl(16), Dp.constructor-impl((float) 7.5d), Dp.constructor-impl(16), Dp.constructor-impl(8)), f, i, obj), Dp.constructor-impl(44));
            Shape shape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(30));
            ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
            if ((FeedBackDialogContent$lambda$2$1(selectedOption$delegate).length() > 0 ? i : 0) == 0) {
                if ((FeedBackDialogContent$lambda$2$4(suggestion$delegate2).length() > 0 ? i : 0) == 0) {
                    $composer4.startReplaceGroup(-393592105);
                    ComposerKt.sourceInformation($composer4, "252@10519L6");
                    long j5 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                    $composer4.endReplaceGroup();
                    j3 = j5;
                    ButtonKt.Button(function02, modifier5, false, shape, buttonDefaults.buttonColors-ro_MJ88(j3, 0L, 0L, 0L, $composer4, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$FeedBackDialogKt.INSTANCE.m672getLambda$1113932747$compose_debug(), $composer4, 805306368, 484);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
            $composer4.startReplaceGroup(-393680982);
            ComposerKt.sourceInformation($composer4, "250@10430L6");
            long j6 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
            $composer4.endReplaceGroup();
            j3 = j6;
            ButtonKt.Button(function02, modifier5, false, shape, buttonDefaults.buttonColors-ro_MJ88(j3, 0L, 0L, 0L, $composer4, ButtonDefaults.$stable << 12, 14), (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$FeedBackDialogKt.INSTANCE.m672getLambda$1113932747$compose_debug(), $composer4, 805306368, 484);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            if (ComposerKt.isTraceInProgress()) {
            }
        } else {
            $dirty = $dirty3;
            $composer4.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.deepsearch.ui.FeedBackDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj2, Object obj3) {
                    Unit FeedBackDialogContent$lambda$3;
                    FeedBackDialogContent$lambda$3 = FeedBackDialogKt.FeedBackDialogContent$lambda$3(queryId, data, function1, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                    return FeedBackDialogContent$lambda$3;
                }
            });
        }
    }

    private static final String FeedBackDialogContent$lambda$2$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    private static final String FeedBackDialogContent$lambda$2$4(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialogContent$lambda$2$7$0$0$0$0(boolean $isSelected, String $option, MutableState $selectedOption$delegate) {
        if (!$isSelected) {
            $selectedOption$delegate.setValue($option);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialogContent$lambda$2$7$1$0$0(MutableState $suggestion$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $suggestion$delegate.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FeedBackDialogContent$lambda$2$7$1$1(TextConfigModel $data, MutableState $suggestion$delegate, Function2 innerTextField, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String str;
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        ComposerKt.sourceInformation($composer, "CN(innerTextField)188@7831L477:FeedBackDialog.kt#7uvpm4");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changedInstance(innerTextField) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-482076354, $dirty, -1, "kntr.app.deepsearch.ui.FeedBackDialogContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (FeedBackDialog.kt:188)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (6 << 3) & 112;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1107975146, "C196@8266L16:FeedBackDialog.kt#7uvpm4");
            if (FeedBackDialogContent$lambda$2$4($suggestion$delegate).length() == 0) {
                $composer.startReplaceGroup(-1107951556);
                ComposerKt.sourceInformation($composer, "192@8091L6,193@8159L9,190@7949L258");
                DeepSearchTreadPopModel treadPop = $data.getTreadPop();
                if (treadPop == null || (str = treadPop.getInputPlaceholder()) == null) {
                    str = RoomRecommendViewModel.EMPTY_CURSOR;
                }
                TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT13(), $composer, 0, 0, 131066);
            } else {
                $composer.startReplaceGroup(-1115814210);
            }
            $composer.endReplaceGroup();
            innerTextField.invoke($composer, Integer.valueOf($dirty & 14));
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        if ((FeedBackDialogContent$lambda$2$4(r10).length() > 0) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit FeedBackDialogContent$lambda$2$8$0(int $maxChars, Toaster $toaster, String $outOfInputTextLength, Function1 $dispatcher, String $queryId, Function0 $onDismissRequest, MutableState $selectedOption$delegate, MutableState $suggestion$delegate) {
        if (!(FeedBackDialogContent$lambda$2$1($selectedOption$delegate).length() > 0)) {
        }
        if (FeedBackDialogContent$lambda$2$4($suggestion$delegate).length() > $maxChars) {
            $toaster.showToast($outOfInputTextLength, ToastDuration.Short);
            return Unit.INSTANCE;
        }
        $dispatcher.invoke(new DeepSearchAction.SubmitTreadAction($queryId, FeedBackDialogContent$lambda$2$1($selectedOption$delegate), FeedBackDialogContent$lambda$2$4($suggestion$delegate)));
        $dispatcher.invoke(new DeepSearchAction.TrackerAction.SubmitDisLikeClick($queryId, FeedBackDialogContent$lambda$2$1($selectedOption$delegate), FeedBackDialogContent$lambda$2$4($suggestion$delegate)));
        $onDismissRequest.invoke();
        return Unit.INSTANCE;
    }
}