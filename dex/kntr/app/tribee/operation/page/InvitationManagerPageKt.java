package kntr.app.tribee.operation.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import bili.resource.common.Res;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSendInviteCodeOptionsResp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import java.util.List;
import java.util.Map;
import kntr.app.tribee.operation.bottomsheet.TribeeStationListBottomSheetKt;
import kntr.app.tribee.operation.common.TribeeToast;
import kntr.app.tribee.operation.ui.Screen_androidKt;
import kntr.app.tribee.operation.viewmodel.TribeeOperationComponent;
import kntr.app.tribee.operation.viewmodel.TribeeOperationEntryPoint;
import kntr.app.tribee.operation.viewmodel.TribeeOperationStateAction;
import kntr.app.tribee.operation.viewmodel.TribeeOperationUIAction;
import kntr.app.tribee.operation.viewmodel.TribeeOperationViewModel;
import kntr.app.tribee.operation.viewmodel.state.TribeeOperationState;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImageState;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kntr.common.trio.systemui.SystemUI_androidKt;
import kntr.common.trio.systemui.SystemUiController;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: InvitationManagerPage.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001aK\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u0010\u001a-\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u0012\u001a?\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u001a\u001aI\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010!\u001aI\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u001d2\u0006\u0010%\u001a\u00020$2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010&\u001a\u001f\u0010'\u001a\u00020\u00012\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010*\u001a?\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020 2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00172\b\u0010.\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010/¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"TribeeInvitationManagerPage", "", "inviteeMid", "", "opusTribeeId", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "TribeeOperationContent", "state", "Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;", "modifier", "Landroidx/compose/ui/Modifier;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateAction;", "onUIAction", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationUIAction;", "(Lkntr/app/tribee/operation/viewmodel/state/TribeeOperationState$TribeeOperationContentState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NavigationLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SelectTribeeRow", "title", "chooseHint", "onClick", "Lkotlin/Function0;", "selectedItem", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectInviteType", "inviteTypeList", "", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteTypeItem;", "selectedType", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteType;", "(Ljava/lang/String;Ljava/util/List;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteType;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NumberRow", "numberList", "", "selectedNumber", "(Ljava/lang/String;Ljava/util/List;JLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NotifyPreview", "noticePreview", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KNoticeCardPreview;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KNoticeCardPreview;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SubmitPanel", "buttonText", "selectedSendType", "selectedTribee", "(Ljava/lang/String;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KInviteType;Lkotlin/jvm/functions/Function0;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSendInviteCodeOptionsResp$KTribeeSelectItem;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "operation_debug", "showStationListState", "", "imageUrl"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InvitationManagerPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationLayout$lambda$2(Modifier modifier, Function1 function1, int i, int i2, Composer composer, int i3) {
        NavigationLayout(modifier, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyPreview$lambda$1(KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview kNoticeCardPreview, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotifyPreview(kNoticeCardPreview, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberRow$lambda$1(String str, List list, long j, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NumberRow(str, list, j, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectInviteType$lambda$1(String str, List list, KTribeeSendInviteCodeOptionsResp.KInviteType kInviteType, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SelectInviteType(str, list, kInviteType, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeRow$lambda$2(String str, String str2, Function0 function0, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SelectTribeeRow(str, str2, function0, kTribeeSelectItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubmitPanel$lambda$2(String str, KTribeeSendInviteCodeOptionsResp.KInviteType kInviteType, Function0 function0, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem kTribeeSelectItem, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SubmitPanel(str, kInviteType, function0, kTribeeSelectItem, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitationManagerPage$lambda$2(String str, String str2, int i, int i2, Composer composer, int i3) {
        TribeeInvitationManagerPage(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$3(TribeeOperationState.TribeeOperationContentState tribeeOperationContentState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeOperationContent(tribeeOperationContentState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeInvitationManagerPage(String inviteeMid, String opusTribeeId, Composer $composer, final int $changed, final int i) {
        String str;
        String str2;
        final String inviteeMid2;
        final String opusTribeeId2;
        Long longOrNull;
        Long longOrNull2;
        Composer $composer2 = $composer.startRestartGroup(1396354830);
        ComposerKt.sourceInformation($composer2, "C(TribeeInvitationManagerPage)N(inviteeMid,opusTribeeId)77@3711L24,79@3790L293,87@4099L4089,87@4089L4099:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            str = inviteeMid;
        } else if (($changed & 6) == 0) {
            str = inviteeMid;
            $dirty |= $composer2.changed(str) ? 4 : 2;
        } else {
            str = inviteeMid;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str2 = opusTribeeId;
        } else if (($changed & 48) == 0) {
            str2 = opusTribeeId;
            $dirty |= $composer2.changed(str2) ? 32 : 16;
        } else {
            str2 = opusTribeeId;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            inviteeMid2 = i2 != 0 ? null : str;
            opusTribeeId2 = i3 != 0 ? null : str2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1396354830, $dirty2, -1, "kntr.app.tribee.operation.page.TribeeInvitationManagerPage (InvitationManagerPage.kt:76)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 1867203795, "CC(remember):InvitationManagerPage.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
                TribeeOperationComponent.Builder tribeeOperationComponentFactory = ((TribeeOperationEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(TribeeOperationEntryPoint.class))).getTribeeOperationComponentFactory();
                long j = 0;
                long longValue = (inviteeMid2 == null || (longOrNull2 = StringsKt.toLongOrNull(inviteeMid2)) == null) ? 0L : longOrNull2.longValue();
                if (opusTribeeId2 != null && (longOrNull = StringsKt.toLongOrNull(opusTribeeId2)) != null) {
                    j = longOrNull.longValue();
                }
                Object value$iv = tribeeOperationComponentFactory.build(scope, longValue, j).viewModel();
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final TribeeOperationViewModel viewModel = (TribeeOperationViewModel) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(82982598, true, new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInvitationManagerPage$lambda$1;
                    TribeeInvitationManagerPage$lambda$1 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1(TribeeOperationViewModel.this, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInvitationManagerPage$lambda$1;
                }
            }, $composer2, 54), $composer2, 384, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            inviteeMid2 = str;
            opusTribeeId2 = str2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeInvitationManagerPage$lambda$2;
                    TribeeInvitationManagerPage$lambda$2 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$2(inviteeMid2, opusTribeeId2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeInvitationManagerPage$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0133, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0173, code lost:
        if (r4 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x04d4, code lost:
        if (r9 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeInvitationManagerPage$lambda$1(TribeeOperationViewModel $viewModel, Composer $composer, int $changed) {
        Toaster toaster;
        MutableState showStationListState$delegate;
        final TribeeOperationViewModel tribeeOperationViewModel;
        TribeeOperationState pageState;
        Function0 onBack;
        Function0 factory$iv$iv$iv;
        List emptyList;
        final MutableState showStationListState$delegate2;
        Object value$iv;
        KTribeeSendInviteCodeOptionsResp pageContent;
        Function0 factory$iv$iv$iv2;
        ComposerKt.sourceInformation($composer, "C88@4128L28,89@4189L13,90@4258L64,90@4234L88,94@4379L7,96@4420L108,102@4570L16,104@4630L34,105@4700L7,106@4768L820,131@5618L119,131@5597L140:InvitationManagerPage.kt#4gfcoj");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(82982598, $changed, -1, "kntr.app.tribee.operation.page.TribeeInvitationManagerPage.<anonymous> (InvitationManagerPage.kt:88)");
            }
            SystemUiController uiController = SystemUI_androidKt.rememberSystemUiController($composer, 0);
            boolean isNight = BiliTheme.INSTANCE.getDayNightTheme($composer, BiliTheme.$stable) == ThemeDayNight.Night;
            Boolean valueOf = Boolean.valueOf(isNight);
            ComposerKt.sourceInformationMarkerStart($composer, -1858096794, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed(uiController) | $composer.changed(isNight);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new InvitationManagerPageKt$TribeeInvitationManagerPage$1$1$1(uiController, isNight, null);
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(valueOf, (Function2) it$iv, $composer, 0);
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer, -1858091566, "CC(remember):InvitationManagerPage.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda30
                    public final Object invoke() {
                        Unit TribeeInvitationManagerPage$lambda$1$1$0;
                        TribeeInvitationManagerPage$lambda$1$1$0 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1$1$0(backHandler);
                        return TribeeInvitationManagerPage$lambda$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            final Function0 onBack2 = (Function0) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TribeeOperationState pageState2 = (TribeeOperationState) SnapshotStateKt.collectAsState($viewModel.getState(), (CoroutineContext) null, $composer, 0, 1).getValue();
            ComposerKt.sourceInformationMarkerStart($composer, -1858084920, "CC(remember):InvitationManagerPage.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            final MutableState showStationListState$delegate3 = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Toaster toaster2 = (Toaster) consume;
            ComposerKt.sourceInformationMarkerStart($composer, -1858079718, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changedInstance(toaster2);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv5 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit TribeeInvitationManagerPage$lambda$1$5$0;
                    TribeeInvitationManagerPage$lambda$1$5$0 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1$5$0(onBack2, toaster2, showStationListState$delegate3, (TribeeOperationUIAction) obj);
                    return TribeeInvitationManagerPage$lambda$1$5$0;
                }
            };
            $composer.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            Function1 onUIAction = (Function1) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -1858053219, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv3 = $composer.changedInstance($viewModel) | $composer.changed(onUIAction);
            Object it$iv5 = $composer.rememberedValue();
            if (invalid$iv3) {
            }
            Object value$iv6 = (Function2) new InvitationManagerPageKt$TribeeInvitationManagerPage$1$2$1($viewModel, onUIAction, null);
            $composer.updateRememberedValue(value$iv6);
            it$iv5 = value$iv6;
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) it$iv5, $composer, 6);
            if (pageState2 instanceof TribeeOperationState.TribeeOperationInitiateState) {
                $composer.startReplaceGroup(-1764845756);
                ComposerKt.sourceInformation($composer, "143@6025L6,139@5852L568");
                toaster = toaster2;
                Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null))), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, $i$f$Column);
                int $changed$iv$iv = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                showStationListState$delegate = showStationListState$delegate3;
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
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1919214246, "C148@6237L88,151@6346L56:InvitationManagerPage.kt#4gfcoj");
                NavigationLayout(null, onUIAction, $composer, 0, 1);
                TribeePageStatusComposeKt.TribeeLoading(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null), $composer, 6, 0);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                tribeeOperationViewModel = $viewModel;
                pageState = pageState2;
                onBack = onBack2;
            } else {
                toaster = toaster2;
                showStationListState$delegate = showStationListState$delegate3;
                if (pageState2 instanceof TribeeOperationState.TribeeOperationErrorState) {
                    $composer.startReplaceGroup(-1764180837);
                    ComposerKt.sourceInformation($composer, "160@6692L6,156@6519L673");
                    Modifier modifier$iv2 = PaddingKt.padding-VpY3zN4$default(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null))), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
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
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -292953274, "C165@6904L88,168@7068L106,168@7013L161:InvitationManagerPage.kt#4gfcoj");
                    NavigationLayout(null, onUIAction, $composer, 0, 1);
                    Modifier modifier = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer, -1394918343, "CC(remember):InvitationManagerPage.kt#9igjgp");
                    tribeeOperationViewModel = $viewModel;
                    boolean invalid$iv4 = $composer.changedInstance(tribeeOperationViewModel);
                    Object it$iv6 = $composer.rememberedValue();
                    if (invalid$iv4) {
                    }
                    Object value$iv7 = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit TribeeInvitationManagerPage$lambda$1$8$0$0;
                            TribeeInvitationManagerPage$lambda$1$8$0$0 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1$8$0$0(TribeeOperationViewModel.this);
                            return TribeeInvitationManagerPage$lambda$1$8$0$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv7);
                    it$iv6 = value$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    TribeePageStatusComposeKt.TribeeError(modifier, false, (Function0) it$iv6, $composer, 6, 2);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    pageState = pageState2;
                    onBack = onBack2;
                } else {
                    tribeeOperationViewModel = $viewModel;
                    if (!(pageState2 instanceof TribeeOperationState.TribeeOperationContentState)) {
                        $composer.startReplaceGroup(-1858047458);
                        $composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    $composer.startReplaceGroup(-1763428250);
                    ComposerKt.sourceInformation($composer, "177@7392L19,175@7293L182");
                    TribeeOperationState.TribeeOperationContentState tribeeOperationContentState = (TribeeOperationState.TribeeOperationContentState) pageState2;
                    ComposerKt.sourceInformationMarkerStart($composer, -1857996551, "CC(remember):InvitationManagerPage.kt#9igjgp");
                    boolean invalid$iv5 = $composer.changedInstance(tribeeOperationViewModel);
                    Object it$iv7 = $composer.rememberedValue();
                    if (invalid$iv5 || it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv8 = (KFunction) new InvitationManagerPageKt$TribeeInvitationManagerPage$1$5$1(tribeeOperationViewModel);
                        $composer.updateRememberedValue(value$iv8);
                        it$iv7 = value$iv8;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    pageState = pageState2;
                    onBack = onBack2;
                    TribeeOperationContent(tribeeOperationContentState, null, (KFunction) it$iv7, onUIAction, $composer, 0, 2);
                    $composer.endReplaceGroup();
                }
            }
            if (TribeeInvitationManagerPage$lambda$1$3(showStationListState$delegate)) {
                $composer.startReplaceGroup(-1763143763);
                ComposerKt.sourceInformation($composer, "185@7608L17,191@8028L67,192@8125L32,184@7549L623");
                float f = RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(Screen_androidKt.getScreenHeight($composer, 0) * 0.7f)), Dp.box-impl(Dp.constructor-impl(560))).unbox-impl();
                TribeeOperationState.TribeeOperationContentState tribeeOperationContentState2 = pageState instanceof TribeeOperationState.TribeeOperationContentState ? (TribeeOperationState.TribeeOperationContentState) pageState : null;
                if (tribeeOperationContentState2 == null || (pageContent = tribeeOperationContentState2.getPageContent()) == null || (emptyList = pageContent.getTribeeList()) == null) {
                    emptyList = CollectionsKt.emptyList();
                }
                TribeeOperationState.TribeeOperationContentState tribeeOperationContentState3 = pageState instanceof TribeeOperationState.TribeeOperationContentState ? (TribeeOperationState.TribeeOperationContentState) pageState : null;
                KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedTribee = tribeeOperationContentState3 != null ? tribeeOperationContentState3.getSelectedTribee() : null;
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, -1857976151, "CC(remember):InvitationManagerPage.kt#9igjgp");
                boolean invalid$iv6 = $composer.changedInstance(tribeeOperationViewModel);
                Object it$iv8 = $composer.rememberedValue();
                if (invalid$iv6 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit TribeeInvitationManagerPage$lambda$1$10$0;
                            TribeeInvitationManagerPage$lambda$1$10$0 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1$10$0(TribeeOperationViewModel.this, (KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem) obj);
                            return TribeeInvitationManagerPage$lambda$1$10$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv9);
                    it$iv8 = value$iv9;
                }
                Function1 function1 = (Function1) it$iv8;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, -1857973082, "CC(remember):InvitationManagerPage.kt#9igjgp");
                Object it$iv9 = $composer.rememberedValue();
                if (it$iv9 == Composer.Companion.getEmpty()) {
                    showStationListState$delegate2 = showStationListState$delegate;
                    value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit TribeeInvitationManagerPage$lambda$1$11$0;
                            TribeeInvitationManagerPage$lambda$1$11$0 = InvitationManagerPageKt.TribeeInvitationManagerPage$lambda$1$11$0(showStationListState$delegate2);
                            return TribeeInvitationManagerPage$lambda$1$11$0;
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    showStationListState$delegate2 = showStationListState$delegate;
                    value$iv = it$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                TribeeStationListBottomSheetKt.m819TribeeStationListBottomSheetQ1bl1hc(f, emptyList, function1, (Function0) value$iv, selectedTribee, fillMaxWidth$default, $composer, 199680, 0);
            } else {
                $composer.startReplaceGroup(-1770652676);
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
    public static final Unit TribeeInvitationManagerPage$lambda$1$1$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    private static final boolean TribeeInvitationManagerPage$lambda$1$3(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void TribeeInvitationManagerPage$lambda$1$4(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitationManagerPage$lambda$1$5$0(Function0 $onBack, Toaster $toaster, MutableState $showStationListState$delegate, TribeeOperationUIAction uiAction) {
        String it;
        Intrinsics.checkNotNullParameter(uiAction, "uiAction");
        if (uiAction instanceof TribeeOperationUIAction.ToastTips) {
            TribeeToast tribeeToast = ((TribeeOperationUIAction.ToastTips) uiAction).getTribeeToast();
            if (tribeeToast != null && (it = tribeeToast.getContent()) != null) {
                if (StringsKt.isBlank(it)) {
                    it = null;
                }
                if (it != null) {
                    Toaster.CC.showToast$default($toaster, it, null, 2, null);
                }
            }
        } else if (uiAction instanceof TribeeOperationUIAction.OpenTribeeListBottomSheet) {
            TribeeInvitationManagerPage$lambda$1$4($showStationListState$delegate, true);
        } else if (uiAction instanceof TribeeOperationUIAction.Finish) {
            String it2 = ((TribeeOperationUIAction.Finish) uiAction).getResultTips();
            if (StringsKt.isBlank(it2)) {
                it2 = null;
            }
            if (it2 != null) {
                Toaster.CC.showToast$default($toaster, it2, null, 2, null);
            }
            $onBack.invoke();
        } else if (!(uiAction instanceof TribeeOperationUIAction.Back)) {
            throw new NoWhenBranchMatchedException();
        } else {
            $onBack.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitationManagerPage$lambda$1$8$0$0(TribeeOperationViewModel $viewModel) {
        $viewModel.dispatch(TribeeOperationStateAction.RefreshPage.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitationManagerPage$lambda$1$10$0(TribeeOperationViewModel $viewModel, KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.dispatch(new TribeeOperationStateAction.UpdateTribee(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeInvitationManagerPage$lambda$1$11$0(MutableState $showStationListState$delegate) {
        TribeeInvitationManagerPage$lambda$1$4($showStationListState$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$0$0(TribeeOperationStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$1$0(TribeeOperationUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r15v6 */
    private static final void TribeeOperationContent(final TribeeOperationState.TribeeOperationContentState state, Modifier modifier, Function1<? super TribeeOperationStateAction, Unit> function1, Function1<? super TribeeOperationUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function13;
        Function1 onUIAction;
        Function1 onStateAction;
        Modifier modifier3;
        final Function1 onStateAction2;
        final Function1 onUIAction2;
        Composer $composer2 = $composer.startRestartGroup(1686671538);
        ComposerKt.sourceInformation($composer2, "C(TribeeOperationContent)N(state,modifier,onStateAction,onUIAction)202@8394L2,203@8450L2,209@8599L6,213@8741L2503,205@8462L2782:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
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
            function13 = function1;
        } else if (($changed & 384) == 0) {
            function13 = function1;
            $dirty |= $composer2.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onUIAction = function12;
        } else if (($changed & 3072) == 0) {
            onUIAction = function12;
            $dirty |= $composer2.changedInstance(onUIAction) ? 2048 : 1024;
        } else {
            onUIAction = function12;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1688683252, "CC(remember):InvitationManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj) {
                            Unit TribeeOperationContent$lambda$0$0;
                            TribeeOperationContent$lambda$0$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$0$0((TribeeOperationStateAction) obj);
                            return TribeeOperationContent$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onStateAction2 = function13;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1688685044, "CC(remember):InvitationManagerPage.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda9
                        public final Object invoke(Object obj) {
                            Unit TribeeOperationContent$lambda$1$0;
                            TribeeOperationContent$lambda$1$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$1$0((TribeeOperationUIAction) obj);
                            return TribeeOperationContent$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                onUIAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onUIAction2 = onUIAction;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1686671538, $dirty, -1, "kntr.app.tribee.operation.page.TribeeOperationContent (InvitationManagerPage.kt:204)");
            }
            BoxWithConstraintsKt.BoxWithConstraints(PaddingKt.padding-VpY3zN4$default(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null))), Dp.constructor-impl(12), 0.0f, 2, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(909979656, true, new Function3() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit TribeeOperationContent$lambda$2;
                    TribeeOperationContent$lambda$2 = InvitationManagerPageKt.TribeeOperationContent$lambda$2(TribeeOperationState.TribeeOperationContentState.this, onStateAction2, onUIAction2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return TribeeOperationContent$lambda$2;
                }
            }, $composer2, 54), $composer2, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onStateAction = onStateAction2;
            onUIAction = onUIAction2;
        } else {
            $composer2.skipToGroupEnd();
            onStateAction = function13;
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function1 function14 = onStateAction;
            final Function1 function15 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeOperationContent$lambda$3;
                    TribeeOperationContent$lambda$3 = InvitationManagerPageKt.TribeeOperationContent$lambda$3(TribeeOperationState.TribeeOperationContentState.this, modifier5, function14, function15, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeOperationContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01a7, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0224, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x02b7, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeOperationContent$lambda$2(TribeeOperationState.TribeeOperationContentState $state, final Function1 $onStateAction, final Function1 $onUIAction, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C218@8887L21,214@8751L2114,272@11084L80,268@10875L363:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(909979656, $dirty2, -1, "kntr.app.tribee.operation.page.TribeeOperationContent.<anonymous> (InvitationManagerPage.kt:214)");
            }
            Modifier modifier$iv = ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
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
            ComposerKt.sourceInformationMarkerStart($composer, -455176827, "C220@8935L72,226@9125L56,227@9209L101,224@9021L357,233@9448L6,233@9392L76,239@9716L96,235@9482L345,265@10813L42:InvitationManagerPage.kt#4gfcoj");
            NavigationLayout(null, $onUIAction, $composer, 0, 1);
            String selectMdlTitle = $state.getPageContent().getSelectMdlTitle();
            String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_72(TribeeRes.INSTANCE.getString()), $composer, 0);
            ComposerKt.sourceInformationMarkerStart($composer, 1647891811, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onUIAction);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit TribeeOperationContent$lambda$2$0$0$0;
                    TribeeOperationContent$lambda$2$0$0$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$2$0$0$0($onUIAction);
                    return TribeeOperationContent$lambda$2$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SelectTribeeRow(selectMdlTitle, stringResource, (Function0) it$iv, $state.getSelectedTribee(), null, $composer, 0, 16);
            DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 1);
            String inviteMdlTitle = $state.getPageContent().getInviteMdlTitle();
            List inviteTypeItems = $state.getPageContent().getInviteTypeItems();
            KTribeeSendInviteCodeOptionsResp.KInviteType type = $state.getSelectedSendTypeItem().getType();
            ComposerKt.sourceInformationMarkerStart($composer, 1647908030, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onStateAction);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj) {
                    Unit TribeeOperationContent$lambda$2$0$1$0;
                    TribeeOperationContent$lambda$2$0$1$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$2$0$1$0($onStateAction, (KTribeeSendInviteCodeOptionsResp.KInviteTypeItem) obj);
                    return TribeeOperationContent$lambda$2$0$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            SelectInviteType(inviteMdlTitle, inviteTypeItems, type, (Function1) it$iv2, null, $composer, 0, 16);
            if (Intrinsics.areEqual($state.getSelectedSendTypeItem().getType(), KTribeeSendInviteCodeOptionsResp.KInviteType.GRANT_INVITE.INSTANCE)) {
                $composer.startReplaceGroup(-454224849);
                ComposerKt.sourceInformation($composer, "245@10013L6,245@9957L76,250@10302L105,246@10050L376");
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 1);
                String sendCountTitle = $state.getSelectedSendTypeItem().getSendCountTitle();
                long selectedSendCount = $state.getSelectedSendCount();
                List sendCountOptions = $state.getSelectedSendTypeItem().getSendCountOptions();
                ComposerKt.sourceInformationMarkerStart($composer, 1647926791, "CC(remember):InvitationManagerPage.kt#9igjgp");
                boolean invalid$iv3 = $composer.changed($onStateAction);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3) {
                }
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda6
                    public final Object invoke(Object obj) {
                        Unit TribeeOperationContent$lambda$2$0$2$0;
                        TribeeOperationContent$lambda$2$0$2$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$2$0$2$0($onStateAction, ((Long) obj).longValue());
                        return TribeeOperationContent$lambda$2$0$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                NumberRow(sendCountTitle, sendCountOptions, selectedSendCount, (Function1) it$iv3, null, $composer, 0, 16);
            } else {
                $composer.startReplaceGroup(-464100860);
            }
            $composer.endReplaceGroup();
            if ($state.getSelectedSendTypeItem().getNoticePreview() != null) {
                $composer.startReplaceGroup(-453666911);
                ComposerKt.sourceInformation($composer, "257@10582L6,257@10526L76");
                DividerKt.HorizontalDivider-9IZ8Weo((Modifier) null, Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 48, 1);
                KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview it = $state.getSelectedSendTypeItem().getNoticePreview();
                if (it == null) {
                    $composer.startReplaceGroup(-453520313);
                } else {
                    $composer.startReplaceGroup(-453520312);
                    ComposerKt.sourceInformation($composer, "*259@10687L80");
                    NotifyPreview(it, null, $composer, 0, 2);
                }
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-464100860);
            }
            $composer.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(117)), $composer, 6);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            String confirmBtnText = $state.getPageContent().getConfirmBtnText();
            KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedTribee = $state.getSelectedTribee();
            KTribeeSendInviteCodeOptionsResp.KInviteType type2 = $state.getSelectedSendTypeItem().getType();
            Modifier align = $this$BoxWithConstraints.align(Modifier.Companion, Alignment.Companion.getBottomCenter());
            ComposerKt.sourceInformationMarkerStart($composer, -1682803912, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv4 = $composer.changed($onStateAction);
            Object it$iv4 = $composer.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit TribeeOperationContent$lambda$2$1$0;
                        TribeeOperationContent$lambda$2$1$0 = InvitationManagerPageKt.TribeeOperationContent$lambda$2$1$0($onStateAction);
                        return TribeeOperationContent$lambda$2$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            SubmitPanel(confirmBtnText, type2, (Function0) it$iv4, selectedTribee, align, $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$2$0$0$0(Function1 $onUIAction) {
        $onUIAction.invoke(TribeeOperationUIAction.OpenTribeeListBottomSheet.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$2$0$1$0(Function1 $onStateAction, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $onStateAction.invoke(new TribeeOperationStateAction.UpdateType(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$2$0$2$0(Function1 $onStateAction, long it) {
        $onStateAction.invoke(new TribeeOperationStateAction.UpdateCount(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeOperationContent$lambda$2$1$0(Function1 $onStateAction) {
        $onStateAction.invoke(TribeeOperationStateAction.Submit.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationLayout$lambda$0$0(TribeeOperationUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v12 */
    private static final void NavigationLayout(Modifier modifier, Function1<? super TribeeOperationUIAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Function1 function12;
        final Function1 onUIAction;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(880377388);
        ComposerKt.sourceInformation($composer2, "C(NavigationLayout)N(modifier,onUIAction)283@11377L2,285@11389L808:InvitationManagerPage.kt#4gfcoj");
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
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            function12 = function1;
        } else if (($changed & 48) == 0) {
            function12 = function1;
            $dirty |= $composer2.changedInstance(function12) ? 32 : 16;
        } else {
            function12 = function1;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            onUIAction = function12;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -65883954, "CC(remember):InvitationManagerPage.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda26
                        public final Object invoke(Object obj) {
                            Unit NavigationLayout$lambda$0$0;
                            NavigationLayout$lambda$0$0 = InvitationManagerPageKt.NavigationLayout$lambda$0$0((TribeeOperationUIAction) obj);
                            return NavigationLayout$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onUIAction = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onUIAction = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(880377388, $dirty, -1, "kntr.app.tribee.operation.page.NavigationLayout (InvitationManagerPage.kt:284)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier$iv$iv = modifier3;
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
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i5 = ((0 >> 6) & 112) | 6;
            BoxScope $this$NavigationLayout_u24lambda_u241 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1796178722, "C289@11493L56,290@11581L9,291@11627L6,288@11468L296,297@11815L24,302@12003L88,306@12168L6,296@11774L417:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_71(TribeeRes.INSTANCE.getString()), $composer2, 0), $this$NavigationLayout_u24lambda_u241.align(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Alignment.Companion.getCenter()), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT17b(), $composer2, 0, 0, 130040);
            Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer2, 6);
            Modifier align = $this$NavigationLayout_u24lambda_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), Alignment.Companion.getCenterStart());
            ComposerKt.sourceInformationMarkerStart($composer2, -1997587414, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv = ($dirty & 112) == 32;
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda27
                    public final Object invoke() {
                        Unit NavigationLayout$lambda$1$0$0;
                        NavigationLayout$lambda$1$0$0 = InvitationManagerPageKt.NavigationLayout$lambda$1$0$0(onUIAction);
                        return NavigationLayout$lambda$1$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_500, "back icon", ClickableKt.clickable-oSLSa3U$default(align, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier$iv$iv;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda28
                public final Object invoke(Object obj, Object obj2) {
                    Unit NavigationLayout$lambda$2;
                    NavigationLayout$lambda$2 = InvitationManagerPageKt.NavigationLayout$lambda$2(modifier2, onUIAction, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NavigationLayout$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NavigationLayout$lambda$1$0$0(Function1 $onUIAction) {
        $onUIAction.invoke(TribeeOperationUIAction.Back.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void SelectTribeeRow(final String title, final String chooseHint, final Function0<Unit> function0, final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedItem, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer4 = $composer.startRestartGroup(-1572070367);
        ComposerKt.sourceInformation($composer4, "C(SelectTribeeRow)N(title,chooseHint,onClick,selectedItem,modifier)324@12571L49,319@12424L1884:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changed(chooseHint) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer4.changedInstance(selectedItem) ? 2048 : 1024;
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
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1572070367, $dirty2, -1, "kntr.app.tribee.operation.page.SelectTribeeRow (InvitationManagerPage.kt:318)");
            }
            Modifier modifier5 = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(12), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1068876754, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda19
                    public final Object invoke() {
                        Unit SelectTribeeRow$lambda$0$0;
                        SelectTribeeRow$lambda$0$0 = InvitationManagerPageKt.SelectTribeeRow$lambda$0$0(function0);
                        return SelectTribeeRow$lambda$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            $composer2 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$SelectTribeeRow_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -1233935586, "C331@12756L6,332@12800L9,329@12694L246,337@12949L1129,369@14128L28,372@14279L6,368@14087L215:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(title, RowScope.-CC.weight$default($this$SelectTribeeRow_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14(), $composer4, $dirty2 & 14, 24960, 110584);
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$SelectTribeeRow_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getEnd();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1670570698, "C:InvitationManagerPage.kt#4gfcoj");
            if (selectedItem != null) {
                $composer4.startReplaceGroup(1670586600);
                ComposerKt.sourceInformation($composer4, "346@13265L30,349@13450L6,345@13216L265,353@13589L6,354@13641L9,351@13498L263");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getBrandtv_small_station_line_500($composer4, 6), "small station icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(selectedItem.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 24960, 110586);
                $composer4.endReplaceGroup();
                $composer$iv = $composer4;
                $composer3 = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
            } else {
                $composer4.startReplaceGroup(1671172810);
                ComposerKt.sourceInformation($composer4, "361@13882L6,362@13934L9,359@13799L255");
                $composer3 = $composer4;
                $composer$iv$iv = $composer4;
                $composer$iv$iv$iv = $composer4;
                $composer$iv = $composer4;
                TextKt.Text-Nvy7gAk(chooseHint, (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer3, ($dirty2 >> 3) & 14, 24960, 110586);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_500($composer4, 6), "arrow icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectTribeeRow$lambda$2;
                    SelectTribeeRow$lambda$2 = InvitationManagerPageKt.SelectTribeeRow$lambda$2(title, chooseHint, function0, selectedItem, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectTribeeRow$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectTribeeRow$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0485, code lost:
        if (r8 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SelectInviteType(final String title, final List<KTribeeSendInviteCodeOptionsResp.KInviteTypeItem> list, final KTribeeSendInviteCodeOptionsResp.KInviteType selectedType, final Function1<? super KTribeeSendInviteCodeOptionsResp.KInviteTypeItem, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Modifier normalModifier;
        int i2;
        long j;
        int $changed$iv$iv$iv;
        List<KTribeeSendInviteCodeOptionsResp.KInviteTypeItem> list2 = list;
        KTribeeSendInviteCodeOptionsResp.KInviteType kInviteType = selectedType;
        Composer $composer2 = $composer.startRestartGroup(1825630018);
        ComposerKt.sourceInformation($composer2, "C(SelectInviteType)N(title,inviteTypeList,selectedType,onClick,modifier)385@14629L1793:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(kInviteType) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i3 = i & 16;
        if (i3 != 0) {
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
            if (i3 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1825630018, $dirty2, -1, "kntr.app.tribee.operation.page.SelectInviteType (InvitationManagerPage.kt:384)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            modifier3 = modifier4;
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i5 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -204823035, "C388@14744L6,389@14788L9,386@14682L261,395@14953L1463:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty2 & 14) | 48, 24960, 110584);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
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
            int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i7 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 858690969, "C404@15274L6,409@15476L6:InvitationManagerPage.kt#4gfcoj");
            Modifier selectedModifier = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            Modifier normalModifier2 = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            $composer2.startReplaceGroup(1551732793);
            ComposerKt.sourceInformation($composer2, "");
            int size = list.size();
            int i8 = 0;
            while (i8 < size) {
                int it = i8;
                final KTribeeSendInviteCodeOptionsResp.KInviteTypeItem item = (KTribeeSendInviteCodeOptionsResp.KInviteTypeItem) CollectionsKt.getOrNull(list2, it);
                if (item == null) {
                    normalModifier = normalModifier2;
                    $composer2.startReplaceGroup(494496306);
                    $composer2.endReplaceGroup();
                    i2 = size;
                    $changed$iv$iv$iv = $changed$iv$iv$iv3;
                } else {
                    normalModifier = normalModifier2;
                    $composer2.startReplaceGroup(494496307);
                    ComposerKt.sourceInformation($composer2, "*418@15831L9,424@16266L85,415@15687L687");
                    String text = item.getText();
                    int i9 = TextAlign.Companion.getCenter-e0LSkKk();
                    i2 = size;
                    TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14();
                    if (Intrinsics.areEqual(kInviteType, item.getType())) {
                        $composer2.startReplaceGroup(-1284435014);
                        ComposerKt.sourceInformation($composer2, "419@15919L6");
                        j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    } else {
                        $composer2.startReplaceGroup(-1284433963);
                        ComposerKt.sourceInformation($composer2, "419@15952L6");
                        j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                    }
                    $composer2.endReplaceGroup();
                    long j2 = j;
                    $changed$iv$iv$iv = $changed$iv$iv$iv3;
                    Modifier modifier5 = PaddingKt.padding-VpY3zN4(Modifier.Companion.then(Intrinsics.areEqual(kInviteType, item.getType()) ? selectedModifier : normalModifier), Dp.constructor-impl(12), Dp.constructor-impl(6));
                    ComposerKt.sourceInformationMarkerStart($composer2, -1284424059, "CC(remember):InvitationManagerPage.kt#9igjgp");
                    boolean invalid$iv = (($dirty2 & 7168) == 2048) | $composer2.changedInstance(item);
                    Object it$iv = $composer2.rememberedValue();
                    if (invalid$iv) {
                    }
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda17
                        public final Object invoke() {
                            Unit SelectInviteType$lambda$0$0$0$0$0$0;
                            SelectInviteType$lambda$0$0$0$0$0$0 = InvitationManagerPageKt.SelectInviteType$lambda$0$0$0$0$0$0(function1, item);
                            return SelectInviteType$lambda$0$0$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    TextKt.Text-Nvy7gAk(text, ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i9), 0L, 0, false, 0, 0, (Function1) null, t14, $composer2, 0, 0, 130040);
                    Unit unit = Unit.INSTANCE;
                    $composer2.endReplaceGroup();
                    Unit unit2 = Unit.INSTANCE;
                }
                i8++;
                list2 = list;
                kInviteType = selectedType;
                normalModifier2 = normalModifier;
                size = i2;
                $changed$iv$iv$iv3 = $changed$iv$iv$iv;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            final Modifier modifier6 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2) {
                    Unit SelectInviteType$lambda$1;
                    SelectInviteType$lambda$1 = InvitationManagerPageKt.SelectInviteType$lambda$1(title, list, selectedType, function1, modifier6, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SelectInviteType$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectInviteType$lambda$0$0$0$0$0$0(Function1 $onClick, KTribeeSendInviteCodeOptionsResp.KInviteTypeItem $item) {
        $onClick.invoke($item);
        return Unit.INSTANCE;
    }

    private static final void NumberRow(final String title, final List<Long> list, final long selectedNumber, final Function1<? super Long, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int $changed$iv;
        long j;
        Modifier modifier5;
        List<Long> list2 = list;
        long j2 = selectedNumber;
        Composer $composer2 = $composer.startRestartGroup(248459854);
        ComposerKt.sourceInformation($composer2, "C(NumberRow)N(title,numberList,selectedNumber,onClick,modifier)444@16688L6,449@16850L6,453@16927L1411:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list2) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(j2) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
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
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(248459854, $dirty2, -1, "kntr.app.tribee.operation.page.NumberRow (InvitationManagerPage.kt:441)");
            }
            Modifier selectedModifier = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            Modifier normalModifier = BackgroundKt.background-bw27NRU(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape(50));
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1728329033, "C456@17042L6,457@17086L9,454@16980L261,463@17251L1081:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(title, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT14(), $composer2, ($dirty2 & 14) | 48, 24960, 110584);
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            int $changed$iv2 = 54;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
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
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((54 >> 6) & 112) | 6;
            RowScope $this$NumberRow_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 586456999, "C:InvitationManagerPage.kt#4gfcoj");
            $composer2.startReplaceGroup(434559964);
            ComposerKt.sourceInformation($composer2, "*485@18210L79,471@17524L784");
            int size = list.size();
            int i7 = 0;
            while (i7 < size) {
                int it = i7;
                int i8 = size;
                boolean z2 = z;
                final long number = list2.get(it).longValue();
                String valueOf = String.valueOf(number);
                int i9 = TextAlign.Companion.getCenter-e0LSkKk();
                if (j2 == number) {
                    $composer2.startReplaceGroup(2122273090);
                    ComposerKt.sourceInformation($composer2, "474@17686L6");
                    BiliTheme biliTheme = BiliTheme.INSTANCE;
                    $changed$iv = $changed$iv2;
                    int $changed$iv3 = BiliTheme.$stable;
                    j = biliTheme.getColors($composer2, $changed$iv3).getBrand_pink-0d7_KjU();
                } else {
                    $changed$iv = $changed$iv2;
                    $composer2.startReplaceGroup(2122274141);
                    ComposerKt.sourceInformation($composer2, "474@17719L6");
                    j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                }
                $composer2.endReplaceGroup();
                long j3 = j;
                Modifier weight$default = RowScope.-CC.weight$default($this$NumberRow_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                if (number == j2) {
                    modifier5 = selectedModifier;
                } else {
                    modifier5 = normalModifier;
                }
                Modifier materialized$iv$iv3 = materialized$iv$iv2;
                Modifier modifier6 = PaddingKt.padding-VpY3zN4$default(weight$default.then(modifier5), 0.0f, Dp.constructor-impl(5), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer2, 2122289703, "CC(remember):InvitationManagerPage.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 7168) == 2048) | $composer2.changed(number);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit NumberRow$lambda$0$0$0$0$0;
                            NumberRow$lambda$0$0$0$0$0 = InvitationManagerPageKt.NumberRow$lambda$0$0$0$0$0(function1, number);
                            return NumberRow$lambda$0$0$0$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TextKt.Text-Nvy7gAk(valueOf, ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i9), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 261112);
                i7++;
                list2 = list;
                j2 = selectedNumber;
                materialized$iv$iv2 = materialized$iv$iv3;
                z = z2;
                size = i8;
                $changed$iv2 = $changed$iv;
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    Unit NumberRow$lambda$1;
                    NumberRow$lambda$1 = InvitationManagerPageKt.NumberRow$lambda$1(title, list, selectedNumber, function1, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NumberRow$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NumberRow$lambda$0$0$0$0$0(Function1 $onClick, long $number) {
        $onClick.invoke(Long.valueOf($number));
        return Unit.INSTANCE;
    }

    private static final void NotifyPreview(final KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview noticePreview, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(347576163);
        ComposerKt.sourceInformation($composer3, "C(NotifyPreview)N(noticePreview,modifier)499@18496L4165:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(noticePreview) ? 4 : 2;
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
        if (!$composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(347576163, $dirty, -1, "kntr.app.tribee.operation.page.NotifyPreview (InvitationManagerPage.kt:498)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -195146068, "C506@18669L6,507@18713L9,504@18593L312,520@19082L6,515@18915L3740:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(noticePreview.getTitle(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(12), 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, 48, 24960, 110584);
            Modifier modifier$iv2 = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, $i$f$Column);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 614634036, "C537@19725L2920,535@19639L3006:InvitationManagerPage.kt#4gfcoj");
            String it = noticePreview.getTips();
            String tips = !StringsKt.isBlank(it) ? it : null;
            if (tips == null) {
                $composer3.startReplaceGroup(614585581);
            } else {
                $composer3.startReplaceGroup(614585582);
                ComposerKt.sourceInformation($composer3, "*527@19375L6,528@19427L9,525@19298L313");
                TextKt.Text-Nvy7gAk(tips, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 48, 24960, 110584);
            }
            $composer3.endReplaceGroup();
            BoxWithConstraintsKt.BoxWithConstraints(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment) null, false, ComposableLambdaKt.rememberComposableLambda(677649957, true, new Function3() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit NotifyPreview$lambda$0$0$2;
                    NotifyPreview$lambda$0$0$2 = InvitationManagerPageKt.NotifyPreview$lambda$0$0$2(noticePreview, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return NotifyPreview$lambda$0$0$2;
                }
            }, $composer3, 54), $composer3, 3078, 6);
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
            modifier2 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda25
                public final Object invoke(Object obj, Object obj2) {
                    Unit NotifyPreview$lambda$1;
                    NotifyPreview$lambda$1 = InvitationManagerPageKt.NotifyPreview$lambda$1(noticePreview, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return NotifyPreview$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyPreview$lambda$0$0$2(final KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview $noticePreview, BoxWithConstraintsScope $this$BoxWithConstraints, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation($composer, "C538@19759L85,542@19918L7,553@20405L145,558@20590L2022,547@20153L2478:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$BoxWithConstraints) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(677649957, $dirty2, -1, "kntr.app.tribee.operation.page.NotifyPreview.<anonymous>.<anonymous>.<anonymous> (InvitationManagerPage.kt:538)");
            }
            ComposerKt.sourceInformationMarkerStart($composer, -1613419142, "CC(remember):InvitationManagerPage.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default($noticePreview.getPicUrl(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final MutableState imageUrl$delegate = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$NotifyPreview_u24lambda_u240_u240_u242_u243 = (Density) consume;
            float scaledHeight = $this$NotifyPreview_u24lambda_u240_u240_u242_u243.toDp-u2uoSUM((float) (($this$NotifyPreview_u24lambda_u240_u240_u242_u243.toPx-0680j_4($this$BoxWithConstraints.getMaxWidth-D9Ej5fM()) / $noticePreview.getWidth()) * $noticePreview.getHeight()));
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), scaledHeight);
            String $this$asRequest_u24default$iv = NotifyPreview$lambda$0$0$2$1(imageUrl$delegate);
            ImmutableImageRequest build = new ImageRequest($this$asRequest_u24default$iv).build();
            ComposerKt.sourceInformationMarkerStart($composer, -1613398410, "CC(remember):InvitationManagerPage.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function1() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        Unit NotifyPreview$lambda$0$0$2$4$0;
                        NotifyPreview$lambda$0$0$2$4$0 = InvitationManagerPageKt.NotifyPreview$lambda$0$0$2$4$0(imageUrl$delegate, (ImageState) obj);
                        return NotifyPreview$lambda$0$0$2$4$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            BiliImageKt.BiliImage(build, modifier, null, (Function1) it$iv2, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-68996332, true, new Function4() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit NotifyPreview$lambda$0$0$2$5;
                    NotifyPreview$lambda$0$0$2$5 = InvitationManagerPageKt.NotifyPreview$lambda$0$0$2$5($noticePreview, imageUrl$delegate, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return NotifyPreview$lambda$0$0$2$5;
                }
            }, $composer, 54), $composer, 100666368, 244);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String NotifyPreview$lambda$0$0$2$1(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyPreview$lambda$0$0$2$4$0(MutableState $imageUrl$delegate, ImageState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof ImageState.Error) {
            $imageUrl$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x03ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit NotifyPreview$lambda$0$0$2$5(final KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview $noticePreview, final MutableState $imageUrl$delegate, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)565@20912L6,559@20616L1974:InvitationManagerPage.kt#4gfcoj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-68996332, $changed, -1, "kntr.app.tribee.operation.page.NotifyPreview.<anonymous>.<anonymous>.<anonymous>.<anonymous> (InvitationManagerPage.kt:559)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
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
            factory$iv$iv$iv = factory$iv$iv$iv3;
            $composer.createNode(factory$iv$iv$iv);
        } else {
            factory$iv$iv$iv = factory$iv$iv$iv3;
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
        ComposerKt.sourceInformationMarkerStart($composer, -950339413, "C574@21360L119,570@21158L1406:InvitationManagerPage.kt#4gfcoj");
        Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, -1970313583, "CC(remember):InvitationManagerPage.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($noticePreview);
        Object it$iv = $composer.rememberedValue();
        if (!invalid$iv && it$iv != Composer.Companion.getEmpty()) {
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
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
            if (!$composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
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
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 263927892, "C582@21837L21,584@21985L6,580@21703L329,588@22115L50,589@22221L6,590@22289L9,587@22066L468:InvitationManagerPage.kt#4gfcoj");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer, 6), "replay icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_38(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 48, 24960, 110584);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
        Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda29
            public final Object invoke() {
                Unit NotifyPreview$lambda$0$0$2$5$0$0$0;
                NotifyPreview$lambda$0$0$2$5$0$0$0 = InvitationManagerPageKt.NotifyPreview$lambda$0$0$2$5$0$0$0($noticePreview, $imageUrl$delegate);
                return NotifyPreview$lambda$0$0$2$5$0$0$0;
            }
        };
        $composer.updateRememberedValue(value$iv);
        it$iv = value$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv22 = ClickableKt.clickable-oSLSa3U$default(fillMaxSize$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
        int $changed$iv$iv22 = (432 << 3) & 112;
        ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
        CompositionLocalMap localMap$iv$iv22 = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer, modifier$iv22);
        Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
        int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!($composer.getApplier() instanceof Applier)) {
        }
        $composer.startReusableNode();
        if (!$composer.getInserting()) {
        }
        Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer);
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
        int i32 = ($changed$iv$iv$iv22 >> 6) & 14;
        ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
        int i42 = ((432 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 263927892, "C582@21837L21,584@21985L6,580@21703L329,588@22115L50,589@22221L6,590@22289L9,587@22066L468:InvitationManagerPage.kt#4gfcoj");
        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_replay_line_500($composer, 6), "replay icon", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 432, 0);
        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_38(Res.string.INSTANCE), $composer, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(2), 0.0f, 0.0f, 13, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT10(), $composer, 48, 24960, 110584);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotifyPreview$lambda$0$0$2$5$0$0$0(KTribeeSendInviteCodeOptionsResp.KNoticeCardPreview $noticePreview, MutableState $imageUrl$delegate) {
        $imageUrl$delegate.setValue($noticePreview.getPicUrl());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x02b8, code lost:
        if (r12 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SubmitPanel(final String buttonText, final KTribeeSendInviteCodeOptionsResp.KInviteType selectedSendType, final Function0<Unit> function0, final KTribeeSendInviteCodeOptionsResp.KTribeeSelectItem selectedTribee, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        String str;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv;
        String str2;
        long j;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(1882559745);
        ComposerKt.sourceInformation($composer3, "C(SubmitPanel)N(buttonText,selectedSendType,onClick,selectedTribee,modifier)629@23490L6,624@23325L2115:InvitationManagerPage.kt#4gfcoj");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(buttonText) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(selectedSendType) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(selectedTribee) ? 2048 : 1024;
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
        if (!$composer3.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1882559745, $dirty2, -1, "kntr.app.tribee.operation.page.SubmitPanel (InvitationManagerPage.kt:611)");
            }
            boolean enableSubmit = selectedTribee != null;
            if (selectedTribee != null) {
                if (Intrinsics.areEqual(selectedSendType, KTribeeSendInviteCodeOptionsResp.KInviteType.GRANT_INVITE.INSTANCE)) {
                    str = selectedTribee.getTipsSend();
                } else {
                    str = selectedTribee.getTipsUsed();
                }
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            String submitHint = str;
            Long submitTintNumber = selectedTribee != null ? Long.valueOf(selectedTribee.getCodeCount()) : null;
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.requiredHeight-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(81)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl(4), 0.0f, 0.0f, 13, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer$iv = $composer3;
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                $composer$iv = $composer3;
                factory$iv$iv$iv = factory$iv$iv$iv3;
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
            int i4 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$SubmitPanel_u24lambda_u241 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1061049174, "C645@24112L57,632@23556L900,674@25205L9,659@24513L921:InvitationManagerPage.kt#4gfcoj");
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(44));
            if (enableSubmit) {
                $composer3.startReplaceGroup(1061226896);
                ComposerKt.sourceInformation($composer3, "640@23835L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                j = j2;
            } else {
                $composer3.startReplaceGroup(1061323709);
                ComposerKt.sourceInformation($composer3, "642@23932L6");
                long j3 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
                $composer3.endReplaceGroup();
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                j = j3;
            }
            Modifier modifier6 = BackgroundKt.background-bw27NRU(modifier5, j, RoundedCornerShapeKt.RoundedCornerShape(50));
            ComposerKt.sourceInformationMarkerStart($composer3, 449885360, "CC(remember):InvitationManagerPage.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda13
                public final Object invoke() {
                    Unit SubmitPanel$lambda$1$0$0;
                    SubmitPanel$lambda$1$0$0 = InvitationManagerPageKt.SubmitPanel$lambda$1$0$0(function0);
                    return SubmitPanel$lambda$1$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-oSLSa3U$default(modifier6, enableSubmit, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 14, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str2);
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -802774244, "C653@24365L6,654@24418L9,650@24244L202:InvitationManagerPage.kt#4gfcoj");
            TextKt.Text-Nvy7gAk(buttonText, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, $dirty2 & 14, 0, 130042);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            String numberString = String.valueOf(submitTintNumber);
            $composer3.startReplaceGroup(449900066);
            ComposerKt.sourceInformation($composer3, "*662@24643L6");
            AnnotatedString.Builder $this$SubmitPanel_u24lambda_u241_u242 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            SpanStyle style$iv = new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null);
            int index$iv = $this$SubmitPanel_u24lambda_u241_u242.pushStyle(style$iv);
            try {
                $this$SubmitPanel_u24lambda_u241_u242.append(submitHint);
                Unit unit = Unit.INSTANCE;
                $this$SubmitPanel_u24lambda_u241_u242.pop(index$iv);
                Integer valueOf = Integer.valueOf(StringsKt.indexOf$default(submitHint, numberString, 0, false, 6, (Object) null));
                int it = valueOf.intValue();
                if (!(it >= 0)) {
                    valueOf = null;
                }
                if (valueOf == null) {
                    $composer3.startReplaceGroup(-2131135176);
                    $composer3.endReplaceGroup();
                } else {
                    $composer3.startReplaceGroup(-2131135175);
                    ComposerKt.sourceInformation($composer3, "*668@25006L6");
                    int start = valueOf.intValue();
                    int end = RangesKt.coerceIn(numberString.length() + start, 1, submitHint.length());
                    $this$SubmitPanel_u24lambda_u241_u242.addStyle(new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null), start, end);
                    Unit unit2 = Unit.INSTANCE;
                    $composer3.endReplaceGroup();
                    Unit unit3 = Unit.INSTANCE;
                }
                AnnotatedString annotatedString = $this$SubmitPanel_u24lambda_u241_u242.toAnnotatedString();
                $composer3.endReplaceGroup();
                TextKt.Text-Z58ophY(annotatedString, PaddingKt.padding-VpY3zN4$default(ColumnScope.-CC.weight$default($this$SubmitPanel_u24lambda_u241, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null), 0.0f, Dp.constructor-impl(8), 1, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Map) null, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT12(), $composer3, 0, 0, 261116);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th) {
                $this$SubmitPanel_u24lambda_u241_u242.pop(index$iv);
                throw th;
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.operation.page.InvitationManagerPageKt$$ExternalSyntheticLambda14
                public final Object invoke(Object obj, Object obj2) {
                    Unit SubmitPanel$lambda$2;
                    SubmitPanel$lambda$2 = InvitationManagerPageKt.SubmitPanel$lambda$2(buttonText, selectedSendType, function0, selectedTribee, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SubmitPanel$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubmitPanel$lambda$1$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }
}