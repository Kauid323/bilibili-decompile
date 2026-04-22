package kntr.app.tribee.invite.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.InlineTextContent;
import androidx.compose.foundation.text.InlineTextContentKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.PlaceholderVerticalAlign;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.common.Res;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KInviteCodeStatus;
import com.bapis.bilibili.app.dynamic.v2.KLightDarkIcon;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeAllResp;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeDesc;
import com.bapis.bilibili.app.dynamic.v2.KTribeeInviteCodeItem;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeDayNight;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.page.TribeePageStatusComposeKt;
import kntr.app.tribee.consume.widget.PriorityTextKt;
import kntr.app.tribee.invite.page.InviteItem;
import kntr.app.tribee.invite.track.InviteTrackerKt;
import kntr.app.tribee.invite.viewmodel.TribeeInviteUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kntr.common.trio.toast.ToasterKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeInviteList.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a;\u0010\f\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\r\u001aE\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0004\b\u0015\u0010\u0016\u001a1\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001a\u001a\u001f\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0003¢\u0006\u0002\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001a#\u0010#\u001a\u00020\u0001*\u00020$2\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020\u0014¢\u0006\u0004\b(\u0010)\u001a\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020-2\u0006\u0010.\u001a\u00020/\u001a\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020,0+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020-0+\u001a*\u00102\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020,032\u0018\u00104\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020/050+\u001a&\u00107\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020,032\f\u00101\u001a\b\u0012\u0004\u0012\u00020-0+2\u0006\u00108\u001a\u00020,\u001a>\u00109\u001a\u00020\u0001\"\u0004\b\u0000\u0010:*\b\u0012\u0004\u0012\u0002H:0+2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020/0\u00072\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00010\u0007¨\u0006="}, d2 = {"InviteCodeList", "", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/invite/viewmodel/TribeeInviteUIAction;", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/foundation/lazy/LazyListState;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InviteCodeListWithContent", "(Lkotlin/jvm/functions/Function1;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TribeeItemRow", "topPadding", "Landroidx/compose/ui/unit/Dp;", "tribee", "Lkntr/app/tribee/invite/page/InviteItem$TribeeItem;", "radius", "", "TribeeItemRow-PBTpf3Q", "(FLkntr/app/tribee/invite/page/InviteItem$TribeeItem;FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "InviteCodeRow", "inviteCode", "Lkntr/app/tribee/invite/page/InviteItem$CodeItem;", "(Lkntr/app/tribee/invite/page/InviteItem$CodeItem;FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Header", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeAllResp;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Subtitle", "subtitle", "", "number", "", "(Ljava/lang/String;JLandroidx/compose/runtime/Composer;I)V", "drawDivider", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "dividerColor", "Landroidx/compose/ui/graphics/Color;", "y", "drawDivider-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "mapChildrenToInviteItems", "", "Lkntr/app/tribee/invite/page/InviteItem;", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeInviteCodeItem;", "needFold", "", "initialInviteList", "dataList", "updateListBackground", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "itemIndexBoundaryMap", "Lkotlin/Pair;", "", "updateListBy", "inviteItem", "checkIndexOfFirst", "T", "predicate", "onContinue", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInviteListKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Header$lambda$1(KTribeeInviteCodeAllResp kTribeeInviteCodeAllResp, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Header(kTribeeInviteCodeAllResp, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeList$lambda$1(LazyListState lazyListState, KTribeeInviteCodeAllResp kTribeeInviteCodeAllResp, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InviteCodeList(lazyListState, kTribeeInviteCodeAllResp, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$6(Function1 function1, KTribeeInviteCodeAllResp kTribeeInviteCodeAllResp, LazyListState lazyListState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        InviteCodeListWithContent(function1, kTribeeInviteCodeAllResp, lazyListState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$4(InviteItem.CodeItem codeItem, float f, Function1 function1, int i, Composer composer, int i2) {
        InviteCodeRow(codeItem, f, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Subtitle$lambda$4(String str, long j, int i, Composer composer, int i2) {
        Subtitle(str, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeItemRow_PBTpf3Q$lambda$2(float f, InviteItem.TribeeItem tribeeItem, float f2, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m800TribeeItemRowPBTpf3Q(f, tribeeItem, f2, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void InviteCodeList(final LazyListState lazyListState, final KTribeeInviteCodeAllResp data, final Function1<? super TribeeInviteUIAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer2;
        Composer $composer$iv;
        Composer $composer$iv2;
        Composer $composer$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(function1, "onUIAction");
        Composer $composer3 = $composer.startRestartGroup(-1944236787);
        ComposerKt.sourceInformation($composer3, "C(InviteCodeList)N(lazyListState,data,onUIAction,modifier)97@4399L1000:TribeeInviteList.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(lazyListState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(data) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
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
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1944236787, $dirty2, -1, "kntr.app.tribee.invite.page.InviteCodeList (TribeeInviteList.kt:96)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(24), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
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
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1026830373, "C:TribeeInviteList.kt#8mvn07");
            if (data.getItems().isEmpty()) {
                $composer3.startReplaceGroup(1026849561);
                ComposerKt.sourceInformation($composer3, "104@4578L618");
                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
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
                modifier3 = modifier4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i6 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1843363346, "C105@4639L139,112@4930L6,114@5021L56,115@5107L56,109@4795L387:TribeeInviteList.kt#8mvn07");
                Header(data, PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(4), 1, (Object) null), $composer3, (($dirty2 >> 3) & 14) | 48, 0);
                TribeePageStatusComposeKt.TribeeEmpty(PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(Modifier.Companion, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg3-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS), 0.0f, 0.0f, 13, (Object) null), StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_11(TribeeRes.INSTANCE.getString()), $composer3, 0), StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_12(TribeeRes.INSTANCE.getString()), $composer3, 0), $composer3, 0, 0);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                $composer$iv = $composer3;
                $composer$iv$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
            } else {
                modifier3 = modifier4;
                $composer3.startReplaceGroup(1027478086);
                ComposerKt.sourceInformation($composer3, "119@5226L157");
                $composer$iv$iv = $composer3;
                $composer2 = $composer3;
                $composer$iv = $composer3;
                $composer$iv2 = $composer3;
                $composer$iv$iv$iv = $composer3;
                InviteCodeListWithContent(function1, data, lazyListState, null, $composer3, (($dirty2 >> 6) & 14) | ($dirty2 & 112) | (($dirty2 << 6) & 896), 8);
                $composer2.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit InviteCodeList$lambda$1;
                    InviteCodeList$lambda$1 = TribeeInviteListKt.InviteCodeList$lambda$1(lazyListState, data, function1, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InviteCodeList$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x041a, code lost:
        if (r2 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0157, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void InviteCodeListWithContent(final Function1<? super TribeeInviteUIAction, Unit> function1, final KTribeeInviteCodeAllResp data, final LazyListState lazyListState, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Composer $composer3;
        String str;
        final BiliColors colors;
        float tribeeTitleHeight;
        Intrinsics.checkNotNullParameter(function1, "onUIAction");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(lazyListState, "lazyListState");
        Composer $composer4 = $composer.startRestartGroup(2001507056);
        ComposerKt.sourceInformation($composer4, "C(InviteCodeListWithContent)N(onUIAction,data,lazyListState,modifier)135@5638L7,136@5690L6,137@5743L7,139@5798L106,143@5944L680,160@6659L148,160@6629L178,167@6813L6496:TribeeInviteList.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(data) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changed(lazyListState) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer4.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2001507056, $dirty2, -1, "kntr.app.tribee.invite.page.InviteCodeListWithContent (TribeeInviteList.kt:134)");
            }
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density $this$InviteCodeListWithContent_u24lambda_u240 = (Density) consume;
            final float radius = $this$InviteCodeListWithContent_u24lambda_u240.toPx-0680j_4(Dp.constructor-impl(8));
            BiliColors colors2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable);
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer4.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Density $this$InviteCodeListWithContent_u24lambda_u241 = (Density) consume2;
            final float tribeeTitleHeight2 = $this$InviteCodeListWithContent_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl(72));
            List items = data.getItems();
            ComposerKt.sourceInformationMarkerStart($composer4, -697055430, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv = $composer4.changed(items);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.toMutableStateList(initialInviteList(data.getItems()));
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final SnapshotStateList inviteList = (SnapshotStateList) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -697050184, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 896) == 256) | $composer4.changed(inviteList);
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda26
                public final Object invoke() {
                    List InviteCodeListWithContent$lambda$3$0;
                    InviteCodeListWithContent$lambda$3$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$3$0(lazyListState, tribeeTitleHeight2);
                    return InviteCodeListWithContent$lambda$3$0;
                }
            });
            $composer4.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
            State itemIndexBoundaryMap = (State) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -697027836, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv3 = $composer4.changed(itemIndexBoundaryMap) | $composer4.changed(inviteList);
            Object it$iv3 = $composer4.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = (Function2) new TribeeInviteListKt$InviteCodeListWithContent$1$1(itemIndexBoundaryMap, inviteList, null);
                $composer4.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            EffectsKt.LaunchedEffect(lazyListState, (Function2) it$iv3, $composer4, ($dirty2 >> 6) & 14);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -1492225051, "C172@7029L4802,168@6863L4968,276@11881L857,295@12790L513,295@12747L556:TribeeInviteList.kt#8mvn07");
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.constructor-impl((float) BackoffConfigKt.MAX_DELAY_SECONDS), 7, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -2126342600, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv4 = $composer4.changedInstance(data) | $composer4.changed(inviteList) | $composer4.changed(radius) | (($dirty2 & 14) == 4) | $composer4.changed(colors2);
            Object value$iv4 = $composer4.rememberedValue();
            if (invalid$iv4 || value$iv4 == Composer.Companion.getEmpty()) {
                $composer3 = $composer4;
                str = "CC(remember):TribeeInviteList.kt#9igjgp";
                colors = colors2;
                tribeeTitleHeight = tribeeTitleHeight2;
                value$iv4 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda27
                    public final Object invoke(Object obj) {
                        Unit InviteCodeListWithContent$lambda$5$0$0;
                        InviteCodeListWithContent$lambda$5$0$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0(inviteList, data, radius, function1, colors, (LazyListScope) obj);
                        return InviteCodeListWithContent$lambda$5$0$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv4);
            } else {
                str = "CC(remember):TribeeInviteList.kt#9igjgp";
                colors = colors2;
                tribeeTitleHeight = tribeeTitleHeight2;
                $composer3 = $composer4;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            modifier3 = modifier4;
            $composer2 = $composer4;
            LazyDslKt.LazyColumn(fillMaxWidth$default, lazyListState, paddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv4, $composer3, (($dirty2 >> 3) & 112) | 390, (int) InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            Composer $composer5 = $composer3;
            String str2 = str;
            ComposerKt.sourceInformationMarkerStart($composer5, -2126191281, str2);
            boolean invalid$iv5 = $composer2.changed(inviteList) | (($dirty2 & 896) == 256);
            Object it$iv4 = $composer5.rememberedValue();
            if (invalid$iv5 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv5 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda28
                    public final Object invoke() {
                        List InviteCodeListWithContent$lambda$5$1$0;
                        InviteCodeListWithContent$lambda$5$1$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$1$0(lazyListState, inviteList);
                        return InviteCodeListWithContent$lambda$5$1$0;
                    }
                });
                $composer5.updateRememberedValue(value$iv5);
                it$iv4 = value$iv5;
            }
            final State expandedTribeeOffsets = (State) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer5, -2126162537, str2);
            final BiliColors colors3 = colors;
            final float tribeeTitleHeight3 = tribeeTitleHeight;
            boolean invalid$iv6 = $composer5.changed(expandedTribeeOffsets) | $composer5.changed(colors3) | $composer5.changed(radius) | $composer5.changed(tribeeTitleHeight3);
            Object value$iv6 = $composer5.rememberedValue();
            if (invalid$iv6) {
            }
            value$iv6 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda29
                public final Object invoke(Object obj) {
                    Unit InviteCodeListWithContent$lambda$5$2$0;
                    InviteCodeListWithContent$lambda$5$2$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$2$0(expandedTribeeOffsets, colors3, radius, tribeeTitleHeight3, (DrawScope) obj);
                    return InviteCodeListWithContent$lambda$5$2$0;
                }
            };
            $composer5.updateRememberedValue(value$iv6);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            CanvasKt.Canvas(fillMaxWidth$default2, (Function1) value$iv6, $composer5, 6);
            ComposerKt.sourceInformationMarkerEnd($composer5);
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
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda30
                public final Object invoke(Object obj, Object obj2) {
                    Unit InviteCodeListWithContent$lambda$6;
                    InviteCodeListWithContent$lambda$6 = TribeeInviteListKt.InviteCodeListWithContent$lambda$6(function1, data, lazyListState, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return InviteCodeListWithContent$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List InviteCodeListWithContent$lambda$3$0(LazyListState $lazyListState, float $tribeeTitleHeight) {
        boolean z;
        List itemsInfo;
        Pair pair;
        List it$iv$iv = $lazyListState.getLayoutInfo().getVisibleItemsInfo();
        List $this$filter$iv = it$iv$iv;
        Collection destination$iv$iv = new ArrayList();
        Iterator it = $this$filter$iv.iterator();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            LazyListItemInfo it2 = (LazyListItemInfo) element$iv$iv;
            if (it2.getContentType() == ContentSectionPosition.InBottom) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            LazyListItemInfo item = (LazyListItemInfo) element$iv$iv$iv;
            int index = item.getIndex() - 1;
            boolean toHidden = ((float) item.getOffset()) < $tribeeTitleHeight ? z : false;
            if (index >= 0) {
                itemsInfo = it$iv$iv;
                pair = TuplesKt.to(Integer.valueOf(index), Boolean.valueOf(toHidden));
            } else {
                itemsInfo = it$iv$iv;
                pair = null;
            }
            if (pair != null) {
                destination$iv$iv2.add(pair);
            }
            it$iv$iv = itemsInfo;
            z = true;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0(final SnapshotStateList $inviteList, final KTribeeInviteCodeAllResp $data, final float $radius, final Function1 $onUIAction, final BiliColors $colors, LazyListScope $this$LazyColumn) {
        final InviteItem inviteInfo;
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, (Object) null, ComposableLambdaKt.composableLambdaInstance(-1776050165, true, new Function3() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda19
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit InviteCodeListWithContent$lambda$5$0$0$0;
                InviteCodeListWithContent$lambda$5$0$0$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$0($data, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return InviteCodeListWithContent$lambda$5$0$0$0;
            }
        }), 3, (Object) null);
        Iterable $this$forEachIndexed$iv = (Iterable) $inviteList;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            InviteItem inviteInfo2 = (InviteItem) item$iv;
            final InviteItem.TribeeItem tribee = inviteInfo2 instanceof InviteItem.TribeeItem ? (InviteItem.TribeeItem) inviteInfo2 : null;
            if (tribee == null) {
                inviteInfo = inviteInfo2;
            } else {
                inviteInfo = inviteInfo2;
                LazyListScope.-CC.stickyHeader$default($this$LazyColumn, (Object) null, ContentSectionPosition.InTop, ComposableLambdaKt.composableLambdaInstance(-975483187, true, new Function4() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda20
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$0;
                        InviteCodeListWithContent$lambda$5$0$0$1$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$0(InviteItem.TribeeItem.this, $inviteList, $data, $radius, $onUIAction, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                        return InviteCodeListWithContent$lambda$5$0$0$1$0;
                    }
                }), 1, (Object) null);
            }
            InviteItem.CodeItem inviteCode = inviteInfo instanceof InviteItem.CodeItem ? (InviteItem.CodeItem) inviteInfo : null;
            if (inviteCode != null) {
                $this$LazyColumn.item(inviteCode.getCode().getInviteCode(), inviteCode.getInSectionEnd() ? ContentSectionPosition.InBottom : ContentSectionPosition.InMiddle, ComposableLambdaKt.composableLambdaInstance(-1576167496, true, new Function3() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda22
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$1;
                        InviteCodeListWithContent$lambda$5$0$0$1$1 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$1(InviteItem.this, $radius, $onUIAction, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InviteCodeListWithContent$lambda$5$0$0$1$1;
                    }
                }));
            }
            InviteItem.Expandable expandable = inviteInfo instanceof InviteItem.Expandable ? (InviteItem.Expandable) inviteInfo : null;
            if (expandable != null) {
                final InviteItem.Expandable expandable2 = expandable;
                LazyListScope.-CC.item$default($this$LazyColumn, (Object) null, ContentSectionPosition.InBottom, ComposableLambdaKt.composableLambdaInstance(-1880025031, true, new Function3() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda23
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$2;
                        InviteCodeListWithContent$lambda$5$0$0$1$2 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$2($radius, $colors, $inviteList, $data, expandable2, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return InviteCodeListWithContent$lambda$5$0$0$1$2;
                    }
                }), 1, (Object) null);
            }
            index$iv = index$iv2;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$0(KTribeeInviteCodeAllResp $data, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C174@7066L149:TribeeInviteList.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1776050165, $changed, -1, "kntr.app.tribee.invite.page.InviteCodeListWithContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeInviteList.kt:174)");
            }
            Header($data, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(9), 0.0f, Dp.constructor-impl(4), 5, (Object) null), $composer, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$0(final InviteItem.TribeeItem $tribee, final SnapshotStateList $inviteList, final KTribeeInviteCodeAllResp $data, float $radius, Function1 $onUIAction, LazyItemScope $this$stickyHeader, int it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$stickyHeader, "$this$stickyHeader");
        ComposerKt.sourceInformation($composer, "CN(it)193@7901L39,194@7988L123,186@7546L680:TribeeInviteList.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 129) != 128, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975483187, $changed, -1, "kntr.app.tribee.invite.page.InviteCodeListWithContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeInviteList.kt:186)");
            }
            float f = Dp.constructor-impl(16);
            Modifier modifier = Modifier.Companion;
            ComposerKt.sourceInformationMarkerStart($composer, -1136459948, "CC(remember):TribeeInviteList.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier2 = modifier;
            ComposerKt.sourceInformationMarkerStart($composer, -1136457080, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv = $composer.changed($inviteList) | $composer.changedInstance($data) | $composer.changed($tribee);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda7
                    public final Object invoke() {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$0$1$0;
                        InviteCodeListWithContent$lambda$5$0$0$1$0$1$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$0$1$0($inviteList, $data, $tribee);
                        return InviteCodeListWithContent$lambda$5$0$0$1$0$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            m800TribeeItemRowPBTpf3Q(f, $tribee, $radius, $onUIAction, ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), $composer, 6, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$0$1$0(SnapshotStateList $inviteList, KTribeeInviteCodeAllResp $data, InviteItem.TribeeItem $tribee) {
        updateListBy($inviteList, $data.getItems(), $tribee);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$1(InviteItem $inviteInfo, float $radius, Function1 $onUIAction, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C209@8647L191:TribeeInviteList.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1576167496, $changed, -1, "kntr.app.tribee.invite.page.InviteCodeListWithContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeInviteList.kt:209)");
            }
            InviteCodeRow((InviteItem.CodeItem) $inviteInfo, $radius, $onUIAction, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$2(float $radius, final BiliColors $colors, final SnapshotStateList $inviteList, final KTribeeInviteCodeAllResp $data, final InviteItem.Expandable $expandable, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        StringResource tribee_global_string_3;
        Painter painter;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C227@9381L6,229@9552L127,235@9933L39,236@10024L135,222@9137L2630:TribeeInviteList.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1880025031, $changed, -1, "kntr.app.tribee.invite.page.InviteCodeListWithContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeInviteList.kt:222)");
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape$default(0.0f, 0.0f, $radius, $radius, 3, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer, 1477191064, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv = $composer.changed($colors);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda24
                    public final Object invoke(Object obj) {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$2$0$0;
                        InviteCodeListWithContent$lambda$5$0$0$1$2$0$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$2$0$0($colors, (DrawScope) obj);
                        return InviteCodeListWithContent$lambda$5$0$0$1$2$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier, (Function1) it$iv), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1477203168, "CC(remember):TribeeInviteList.kt#9igjgp");
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 1477206176, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($inviteList) | $composer.changedInstance($data) | $composer.changedInstance($expandable);
            Object it$iv3 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda25
                    public final Object invoke() {
                        Unit InviteCodeListWithContent$lambda$5$0$0$1$2$2$0;
                        InviteCodeListWithContent$lambda$5$0$0$1$2$2$0 = TribeeInviteListKt.InviteCodeListWithContent$lambda$5$0$0$1$2$2$0($inviteList, $data, $expandable);
                        return InviteCodeListWithContent$lambda$5$0$0$1$2$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            Modifier modifier$iv = ClickableKt.clickable-O2vRcR0$default(modifier2, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-D5KLDUw(Dp.constructor-impl(2), Alignment.Companion.getCenterHorizontally());
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1351054738, "C249@10682L385,247@10601L601,267@11698L6,259@11231L510:TribeeInviteList.kt#8mvn07");
            if ($expandable.isExpandedAll()) {
                tribee_global_string_3 = String0_commonMainKt.getTribee_global_string_2(TribeeRes.INSTANCE.getString());
            } else {
                tribee_global_string_3 = String0_commonMainKt.getTribee_global_string_3(TribeeRes.INSTANCE.getString());
            }
            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(tribee_global_string_3, $composer, 0), (Modifier) null, $colors.getText3-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262122);
            if ($expandable.isExpandedAll()) {
                $composer.startReplaceGroup(1351762033);
                ComposerKt.sourceInformation($composer, "262@11401L23");
                Painter arrow_collapse_line_900 = BiliIconfont.INSTANCE.getArrow_collapse_line_900($composer, 6);
                $composer.endReplaceGroup();
                painter = arrow_collapse_line_900;
            } else {
                $composer.startReplaceGroup(1351882995);
                ComposerKt.sourceInformation($composer, "264@11523L21");
                Painter arrow_expand_line_900 = BiliIconfont.INSTANCE.getArrow_expand_line_900($composer, 6);
                $composer.endReplaceGroup();
                painter = arrow_expand_line_900;
            }
            BiliIconfontKt.BiliIcon-ww6aTOc(painter, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), (String) null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), $composer, Painter.$stable | 48, 4);
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
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$2$0$0(BiliColors $colors, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        m802drawDividerbw27NRU$default($this$drawBehind, $colors.getLine_regular-0d7_KjU(), 0.0f, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$0$0$1$2$2$0(SnapshotStateList $inviteList, KTribeeInviteCodeAllResp $data, InviteItem.Expandable $expandable) {
        updateListBy($inviteList, $data.getItems(), $expandable);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final List InviteCodeListWithContent$lambda$5$1$0(LazyListState $lazyListState, SnapshotStateList $inviteList) {
        boolean z;
        Integer valueOf;
        Object it$iv$iv = $lazyListState.getLayoutInfo().getVisibleItemsInfo();
        Iterable $this$filter$iv = (Iterable) it$iv$iv;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((LazyListItemInfo) element$iv$iv).getContentType() == ContentSectionPosition.InTop) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$mapNotNull$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            LazyListItemInfo item = (LazyListItemInfo) element$iv$iv$iv;
            int index = item.getIndex() - 1;
            Object orNull = CollectionsKt.getOrNull((List) $inviteList, index);
            Object itemsInfo = it$iv$iv;
            InviteItem.TribeeItem tribeeItem = orNull instanceof InviteItem.TribeeItem ? (InviteItem.TribeeItem) orNull : null;
            if (tribeeItem != null) {
                InviteItem.TribeeItem it = tribeeItem;
                if (it.isCollapsed() || it.getChildrenIsHidden()) {
                    z = true;
                    valueOf = z ? null : Integer.valueOf(item.getOffset());
                    if (valueOf == null) {
                        destination$iv$iv2.add(valueOf);
                    }
                    it$iv$iv = itemsInfo;
                }
            }
            z = false;
            if (z) {
            }
            if (valueOf == null) {
            }
            it$iv$iv = itemsInfo;
        }
        return (List) destination$iv$iv2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeListWithContent$lambda$5$2$0(State $expandedTribeeOffsets, BiliColors $colors, float $radius, float $tribeeTitleHeight, DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        Iterable $this$forEach$iv = (Iterable) $expandedTribeeOffsets.getValue();
        for (Object element$iv : $this$forEach$iv) {
            int offset = ((Number) element$iv).intValue();
            long j = $colors.getBg3-0d7_KjU();
            float y$iv = offset + $tribeeTitleHeight;
            long v1$iv$iv = Float.floatToRawIntBits(0.0f);
            Iterable $this$forEach$iv2 = $this$forEach$iv;
            long v2$iv$iv = Float.floatToRawIntBits(y$iv);
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j, $radius, Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
            long j2 = $colors.getBg3-0d7_KjU();
            int bits$iv$iv$iv = (int) ($this$Canvas.getSize-NH-jbRc() >> 32);
            float x$iv = Float.intBitsToFloat(bits$iv$iv$iv);
            float y$iv2 = offset + $tribeeTitleHeight;
            long v1$iv$iv2 = Float.floatToRawIntBits(x$iv);
            long v2$iv$iv2 = Float.floatToRawIntBits(y$iv2);
            DrawScope.-CC.drawCircle-VaOC9Bg$default($this$Canvas, j2, $radius, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
            $this$forEach$iv = $this$forEach$iv2;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0329, code lost:
        if (r6 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L78;
     */
    /* renamed from: TribeeItemRow-PBTpf3Q  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void m800TribeeItemRowPBTpf3Q(final float f, final InviteItem.TribeeItem tribee, final float radius, final Function1<? super TribeeInviteUIAction, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        RoundedCornerShape roundedCornerShape;
        Function0 factory$iv$iv$iv;
        Painter arrow_collapse_line_900;
        Composer $composer3 = $composer.startRestartGroup(-2094114011);
        ComposerKt.sourceInformation($composer3, "C(TribeeItemRow)N(topPadding:c#ui.unit.Dp,tribee,radius,onUIAction,modifier)320@13540L6,326@13700L209,321@13551L2717:TribeeInviteList.kt#8mvn07");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(f) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(tribee) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(radius) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty3 = $dirty2;
        if (!$composer3.shouldExecute(($dirty3 & 9363) != 9362, $dirty3 & 1)) {
            $dirty = $dirty3;
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
                ComposerKt.traceEventStart(-2094114011, $dirty3, -1, "kntr.app.tribee.invite.page.TribeeItemRow (TribeeInviteList.kt:319)");
            }
            final BiliColors colors = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable);
            Modifier modifier5 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(Dp.constructor-impl(56) + f));
            ComposerKt.sourceInformationMarkerStart($composer3, 1896109206, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(colors) | (($dirty3 & 14) == 4) | (($dirty3 & 896) == 256);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda37
                    public final Object invoke(Object obj) {
                        Unit TribeeItemRow_PBTpf3Q$lambda$0$0;
                        TribeeItemRow_PBTpf3Q$lambda$0$0 = TribeeInviteListKt.TribeeItemRow_PBTpf3Q$lambda$0$0(colors, f, radius, (DrawScope) obj);
                        return TribeeItemRow_PBTpf3Q$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $dirty = $dirty3;
            Modifier modifier6 = PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier5, (Function1) it$iv), 0.0f, f, 0.0f, 0.0f, 13, (Object) null);
            long j = colors.getBg1-0d7_KjU();
            if (tribee.isCollapsed() || tribee.getChildrenIsHidden()) {
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8));
            } else {
                roundedCornerShape = RoundedCornerShapeKt.RoundedCornerShape-a9UjIt4(Dp.constructor-impl(8), Dp.constructor-impl(8), Dp.constructor-impl(0), Dp.constructor-impl(0));
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(modifier6, j, (Shape) roundedCornerShape), Dp.constructor-impl(24), 0.0f, 2, (Object) null);
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
            modifier3 = modifier4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeItemRow_PBTpf3Q_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 755039478, "C355@14904L39,357@15022L113,348@14618L551,364@15223L85,371@15556L39,373@15674L113,363@15179L845,388@16239L6,385@16034L228:TribeeInviteList.kt#8mvn07");
            String $this$asRequest_u24default$iv = tribee.getTribeeFaceUrl();
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            ImmutableImageRequest build = imageRequest.build();
            Modifier clip = ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float) 4.8d)));
            ComposerKt.sourceInformationMarkerStart($composer3, 994194984, "CC(remember):TribeeInviteList.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 994198834, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv2 = (($dirty & 7168) == 2048) | (($dirty & 112) == 32);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv3 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit TribeeItemRow_PBTpf3Q$lambda$1$1$0;
                    TribeeItemRow_PBTpf3Q$lambda$1$1$0 = TribeeInviteListKt.TribeeItemRow_PBTpf3Q$lambda$1$1$0(function1, tribee);
                    return TribeeItemRow_PBTpf3Q$lambda$1$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv3);
            it$iv3 = value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BiliImageKt.BiliImage(build, ClickableKt.clickable-O2vRcR0$default(clip, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null), null, null, null, null, null, null, null, $composer3, 0, 508);
            String stringResource = StringResourcesKt.stringResource(srcs.app.tribee.consume.generated.resources.String0_commonMainKt.getTribee_station(Res.string.INSTANCE), $composer3, 0);
            String tribeeTitle = tribee.getTribeeTitle();
            $composer2 = $composer3;
            Modifier modifier7 = PaddingKt.padding-VpY3zN4$default(RowScope.-CC.weight$default($this$TribeeItemRow_PBTpf3Q_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 994215848, "CC(remember):TribeeInviteList.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv4 = value$iv4;
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 994219698, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv3 = (($dirty & 7168) == 2048) | (($dirty & 112) == 32);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv5 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit TribeeItemRow_PBTpf3Q$lambda$1$3$0;
                        TribeeItemRow_PBTpf3Q$lambda$1$3$0 = TribeeInviteListKt.TribeeItemRow_PBTpf3Q$lambda$1$3$0(function1, tribee);
                        return TribeeItemRow_PBTpf3Q$lambda$1$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
                it$iv5 = value$iv5;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            PriorityTextKt.PriorityOverflowText(stringResource, tribeeTitle, ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null), new TextStyle(colors.getText1-0d7_KjU(), TextUnitKt.getSp(14), FontWeight.Companion.getBold(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777208, (DefaultConstructorMarker) null), $composer3, 0, 0);
            if (tribee.isCollapsed()) {
                $composer3.startReplaceGroup(994233238);
                ComposerKt.sourceInformation($composer3, "386@16100L21");
                arrow_collapse_line_900 = BiliIconfont.INSTANCE.getArrow_expand_line_900($composer3, 6);
            } else {
                $composer3.startReplaceGroup(994234520);
                ComposerKt.sourceInformation($composer3, "386@16140L23");
                arrow_collapse_line_900 = BiliIconfont.INSTANCE.getArrow_collapse_line_900($composer3, 6);
            }
            $composer3.endReplaceGroup();
            BiliIconfontKt.BiliIcon-ww6aTOc(arrow_collapse_line_900, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), (String) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 48, 4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeItemRow_PBTpf3Q$lambda$2;
                    TribeeItemRow_PBTpf3Q$lambda$2 = TribeeInviteListKt.TribeeItemRow_PBTpf3Q$lambda$2(f, tribee, radius, function1, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeItemRow_PBTpf3Q$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeItemRow_PBTpf3Q$lambda$0$0(BiliColors $colors, float f, float $radius, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        long j = $colors.getBg3-0d7_KjU();
        int bits$iv$iv$iv = (int) ($this$drawBehind.getSize-NH-jbRc() >> 32);
        float width$iv = Float.intBitsToFloat(bits$iv$iv$iv);
        float height$iv = $this$drawBehind.toPx-0680j_4(f) + $radius;
        long v1$iv$iv = Float.floatToRawIntBits(width$iv);
        long v2$iv$iv = Float.floatToRawIntBits(height$iv);
        DrawScope.-CC.drawRect-n-J9OG0$default($this$drawBehind, j, 0L, Size.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 122, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeItemRow_PBTpf3Q$lambda$1$1$0(Function1 $onUIAction, InviteItem.TribeeItem $tribee) {
        $onUIAction.invoke(new TribeeInviteUIAction.RouterTo($tribee.getJumpUrl()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeItemRow_PBTpf3Q$lambda$1$3$0(Function1 $onUIAction, InviteItem.TribeeItem $tribee) {
        $onUIAction.invoke(new TribeeInviteUIAction.RouterTo($tribee.getJumpUrl()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x04d0, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x050a, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:126:0x08cd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x08d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void InviteCodeRow(final InviteItem.CodeItem inviteCode, final float radius, final Function1<? super TribeeInviteUIAction, Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        KInviteCodeStatus status;
        BiliColors colors;
        String str;
        long j;
        Modifier modifier;
        Shape rectangleShape;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        ImmutableImageRequest it;
        String $this$asRequest_u24default$iv;
        Function0 factory$iv$iv$iv3;
        Composer $composer3 = $composer.startRestartGroup(-1293544302);
        ComposerKt.sourceInformation($composer3, "C(InviteCodeRow)N(inviteCode,radius,onUIAction)399@16450L66,399@16423L93,402@16552L7,403@16587L6,405@16683L7,406@16722L7,407@16749L55,408@16834L476,437@17860L87,422@17315L4821:TribeeInviteList.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(inviteCode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(radius) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1293544302, $dirty2, -1, "kntr.app.tribee.invite.page.InviteCodeRow (TribeeInviteList.kt:398)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1850520556, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(inviteCode);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new TribeeInviteListKt$InviteCodeRow$1$1(inviteCode, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(inviteCode, (Function2) it$iv, $composer3, $dirty2 & 14);
            CompositionLocal this_$iv = BiliThemeKt.getLocalDayNightTheme();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ThemeDayNight theme = (ThemeDayNight) consume;
            BiliColors colors2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable);
            final KInviteCodeStatus status2 = inviteCode.getCode().getStatus();
            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalClipboardManager();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume2 = $composer3.consume(this_$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final ClipboardManager clipboardManager = (ClipboardManager) consume2;
            CompositionLocal this_$iv3 = ToasterKt.getLocalToaster();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final Toaster toaster = (Toaster) consume3;
            final String copyTips = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_1(TribeeRes.INSTANCE.getString()), $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, -1850507858, "CC(remember):TribeeInviteList.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changedInstance(status2) | $composer3.changedInstance(inviteCode) | $composer3.changedInstance(clipboardManager) | $composer3.changedInstance(toaster) | $composer3.changed(copyTips);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                status = status2;
                colors = colors2;
                str = "CC(remember):TribeeInviteList.kt#9igjgp";
                value$iv2 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda31
                    public final Object invoke() {
                        Unit InviteCodeRow$lambda$1$0;
                        InviteCodeRow$lambda$1$0 = TribeeInviteListKt.InviteCodeRow$lambda$1$0(status2, inviteCode, clipboardManager, toaster, copyTips);
                        return InviteCodeRow$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                status = status2;
                colors = colors2;
                str = "CC(remember):TribeeInviteList.kt#9igjgp";
            }
            final Function0 onCopy = (Function0) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            long j2 = colors.getBg1-0d7_KjU();
            if (inviteCode.getInSectionEnd()) {
                j = j2;
                modifier = fillMaxWidth$default;
                rectangleShape = (Shape) RoundedCornerShapeKt.RoundedCornerShape$default(0.0f, 0.0f, radius, radius, 3, (Object) null);
            } else {
                j = j2;
                modifier = fillMaxWidth$default;
                rectangleShape = RectangleShapeKt.getRectangleShape();
            }
            Modifier modifier2 = BackgroundKt.background-bw27NRU(modifier, j, rectangleShape);
            ComposerKt.sourceInformationMarkerStart($composer3, -1850475415, str);
            final BiliColors colors3 = colors;
            boolean invalid$iv3 = $composer3.changed(colors3);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda32
                    public final Object invoke(Object obj) {
                        Unit InviteCodeRow$lambda$2$0;
                        InviteCodeRow$lambda$2$0 = TribeeInviteListKt.InviteCodeRow$lambda$2$0(colors3, (DrawScope) obj);
                        return InviteCodeRow$lambda$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv2 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier2, (Function1) it$iv2), Dp.constructor-impl(12), 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, Dp.constructor-impl(16), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i2 = ((0 >> 6) & 112) | 6;
            RowScope $this$InviteCodeRow_u24lambda_u243 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 1798052018, "C442@18031L1097:TribeeInviteList.kt#8mvn07");
            Modifier modifier$iv2 = $this$InviteCodeRow_u24lambda_u243.align(PaddingKt.padding-qDBjuR0$default(RowScope.-CC.weight$default($this$InviteCodeRow_u24lambda_u243, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl(12), 0.0f, Dp.constructor-impl(16), 0.0f, 10, (Object) null), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv2 = (0 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 395409558, "C459@18776L12,458@18724L12,449@18265L561,463@18840L278:TribeeInviteList.kt#8mvn07");
            String inviteCode2 = inviteCode.getCode().getInviteCode();
            long sp = TextUnitKt.getSp(18);
            FontWeight medium = FontWeight.Companion.getMedium();
            long j3 = Intrinsics.areEqual(status, KInviteCodeStatus.UNUSED.INSTANCE) ? colors3.getText1-0d7_KjU() : colors3.getText4-0d7_KjU();
            Modifier modifier3 = Modifier.Companion;
            MutableInteractionSource MutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, -2065439324, str);
            boolean invalid$iv4 = $composer3.changed(onCopy);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv4) {
            }
            Object value$iv4 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda33
                public final Object invoke() {
                    Unit InviteCodeRow$lambda$3$0$0$0;
                    InviteCodeRow$lambda$3$0$0$0 = TribeeInviteListKt.InviteCodeRow$lambda$3$0$0$0(onCopy);
                    return InviteCodeRow$lambda$3$0$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv4);
            it$iv3 = value$iv4;
            Function0 function0 = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -2065440988, str);
            boolean invalid$iv5 = $composer3.changed(onCopy);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv5) {
            }
            Object value$iv5 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda34
                public final Object invoke() {
                    Unit InviteCodeRow$lambda$3$0$1$0;
                    InviteCodeRow$lambda$3$0$1$0 = TribeeInviteListKt.InviteCodeRow$lambda$3$0$1$0(onCopy);
                    return InviteCodeRow$lambda$3$0$1$0;
                }
            };
            $composer3.updateRememberedValue(value$iv5);
            it$iv4 = value$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TextKt.Text-Nvy7gAk(inviteCode2, ClickableKt.combinedClickable-auXiCPI$default(modifier4, MutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (String) null, function0, (Function0) null, false, (Function0) it$iv4, 444, (Object) null), j3, (TextAutoSize) null, sp, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 1597440, 0, 262056);
            TextKt.Text-Nvy7gAk(inviteCode.getCode().getStatText(), (Modifier) null, Intrinsics.areEqual(status, KInviteCodeStatus.UNUSED.INSTANCE) ? colors3.getText1-0d7_KjU() : colors3.getText4-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 24960, 241642);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier codeStatusModifier = $this$InviteCodeRow_u24lambda_u243.align(Modifier.Companion, Alignment.Companion.getCenterVertically());
            if (Intrinsics.areEqual(status, KInviteCodeStatus.UNUSED.INSTANCE)) {
                $composer3.startReplaceGroup(1799212657);
                ComposerKt.sourceInformation($composer3, "490@20038L351,476@19320L1827");
                Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(codeStatusModifier, 0.0f, 0.0f, Dp.constructor-impl(24), 0.0f, 11, (Object) null), Dp.constructor-impl(64)), Dp.constructor-impl(1), colors3.getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), Dp.constructor-impl(9), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl((float) 2.5d), 0.0f, Dp.constructor-impl((float) 3.5d), 5, (Object) null);
                MutableInteractionSource MutableInteractionSource2 = InteractionSourceKt.MutableInteractionSource();
                ComposerKt.sourceInformationMarkerStart($composer3, -911769171, str);
                $composer2 = $composer3;
                boolean invalid$iv6 = $composer2.changedInstance(inviteCode) | (($dirty2 & 896) == 256);
                Object it$iv5 = $composer3.rememberedValue();
                if (invalid$iv6 || it$iv5 == Composer.Companion.getEmpty()) {
                    $composer$iv$iv$iv = $composer3;
                    Object value$iv6 = new Function0() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda35
                        public final Object invoke() {
                            Unit InviteCodeRow$lambda$3$1$0;
                            InviteCodeRow$lambda$3$1$0 = TribeeInviteListKt.InviteCodeRow$lambda$3$1$0(InviteItem.CodeItem.this, function1);
                            return InviteCodeRow$lambda$3$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv6);
                    it$iv5 = value$iv6;
                } else {
                    $composer$iv$iv$iv = $composer3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv3 = ClickableKt.clickable-O2vRcR0$default(modifier5, MutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null);
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
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i6 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -565185222, "C501@20584L20,500@20530L263,508@20852L50,507@20815L314:TribeeInviteList.kt#8mvn07");
                BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_share_line_500($composer3, 6), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), "share icon", colors3.getBrand_pink-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_31(Res.string.INSTANCE), $composer3, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), colors3.getBrand_pink-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 48, 260072);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endReplaceGroup();
                Unit unit = Unit.INSTANCE;
            } else {
                $composer$iv$iv$iv = $composer3;
                $composer2 = $composer3;
                if (Intrinsics.areEqual(status, KInviteCodeStatus.USED.INSTANCE)) {
                    $composer3.startReplaceGroup(1801160108);
                    ComposerKt.sourceInformation($composer3, "");
                    KLightDarkIcon inviteCodeUsedIcon = inviteCode.getCode().getInviteCodeUsedIcon();
                    if (inviteCodeUsedIcon != null && ($this$asRequest_u24default$iv = TribeeExtensionsKt.getUrl(inviteCodeUsedIcon, theme)) != null) {
                        ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                        Unit unit2 = Unit.INSTANCE;
                        it = imageRequest.build();
                        if (it != null) {
                            $composer3.startReplaceGroup(1801160107);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(1801160108);
                            ComposerKt.sourceInformation($composer3, "*519@21309L252");
                            BiliImageKt.BiliImage(it, SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(codeStatusModifier, 0.0f, 0.0f, Dp.constructor-impl(24), 0.0f, 11, (Object) null), Dp.constructor-impl(64)), null, null, null, null, null, null, null, $composer3, 0, 508);
                            Unit unit3 = Unit.INSTANCE;
                            $composer3.endReplaceGroup();
                            Unit unit4 = Unit.INSTANCE;
                        }
                        $composer3.endReplaceGroup();
                    }
                    it = null;
                    if (it != null) {
                    }
                    $composer3.endReplaceGroup();
                } else if (!Intrinsics.areEqual(status, KInviteCodeStatus.EXPIRED.INSTANCE)) {
                    if (status instanceof KInviteCodeStatus.UNRECOGNIZED) {
                        $composer3.startReplaceGroup(1801979314);
                        $composer3.endReplaceGroup();
                        Unit unit5 = Unit.INSTANCE;
                    } else {
                        $composer3.startReplaceGroup(-911792974);
                        $composer3.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    $composer3.startReplaceGroup(1801531333);
                    ComposerKt.sourceInformation($composer3, "531@21687L50,530@21654L399");
                    TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_26(Res.string.INSTANCE), $composer3, 0), SizeKt.width-3ABfNKs(PaddingKt.padding-qDBjuR0$default(codeStatusModifier, 0.0f, 0.0f, Dp.constructor-impl(24), 0.0f, 11, (Object) null), Dp.constructor-impl(64)), colors3.getText4-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 0, 261096);
                    $composer3.endReplaceGroup();
                    Unit unit6 = Unit.INSTANCE;
                }
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2) {
                    Unit InviteCodeRow$lambda$4;
                    InviteCodeRow$lambda$4 = TribeeInviteListKt.InviteCodeRow$lambda$4(InviteItem.CodeItem.this, radius, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return InviteCodeRow$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$1$0(KInviteCodeStatus $status, InviteItem.CodeItem $inviteCode, ClipboardManager $clipboardManager, Toaster $toaster, String $copyTips) {
        if (Intrinsics.areEqual($status, KInviteCodeStatus.UNUSED.INSTANCE)) {
            InviteTrackerKt.inviteCodeClick($inviteCode.getTribeeId(), "copy");
            $clipboardManager.setText(new AnnotatedString($inviteCode.getCode().getInviteCode(), (List) null, 2, (DefaultConstructorMarker) null));
            AnnotatedString text = $clipboardManager.getText();
            if (Intrinsics.areEqual(text != null ? text.getText() : null, $inviteCode.getCode().getInviteCode())) {
                $toaster.showToast($copyTips, ToastDuration.Short);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$2$0(BiliColors $colors, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        m802drawDividerbw27NRU$default($this$drawBehind, $colors.getLine_regular-0d7_KjU(), 0.0f, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$3$0$1$0(Function0 $onCopy) {
        $onCopy.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$3$0$0$0(Function0 $onCopy) {
        $onCopy.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InviteCodeRow$lambda$3$1$0(InviteItem.CodeItem $inviteCode, Function1 $onUIAction) {
        InviteTrackerKt.inviteCodeClick($inviteCode.getTribeeId(), "share");
        $onUIAction.invoke(new TribeeInviteUIAction.ShareCode($inviteCode));
        return Unit.INSTANCE;
    }

    private static final void Header(final KTribeeInviteCodeAllResp data, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(338214720);
        ComposerKt.sourceInformation($composer2, "C(Header)N(data,modifier)552@22251L519:TribeeInviteList.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(data) ? 4 : 2;
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
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(338214720, $dirty, -1, "kntr.app.tribee.invite.page.Header (TribeeInviteList.kt:551)");
            }
            int $changed$iv = ($dirty >> 3) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i4 = (($changed$iv >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 706267983, "C558@22435L6,554@22306L323,568@22720L44:TribeeInviteList.kt#8mvn07");
            TextKt.Text-Nvy7gAk(data.getTitle(), PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(4), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(22), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(31), 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 1597488, 48, 260008);
            long used = data.getUsed();
            String subtitle = data.getDesc();
            Subtitle(subtitle, used, $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Header$lambda$1;
                    Header$lambda$1 = TribeeInviteListKt.Header$lambda$1(data, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Header$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void Subtitle(final String subtitle, final long number, Composer $composer, final int $changed) {
        Composer $composer2;
        Map inlineContent;
        boolean z;
        boolean z2;
        Composer $composer3 = $composer.startRestartGroup(-374955112);
        ComposerKt.sourceInformation($composer3, "C(Subtitle)N(subtitle,number)580@22953L6,585@23079L6,590@23243L22,637@25174L767:TribeeInviteList.kt#8mvn07");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(subtitle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(number) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-374955112, $dirty2, -1, "kntr.app.tribee.invite.page.Subtitle (TribeeInviteList.kt:576)");
            }
            SpanStyle normalStyle = new SpanStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), TextUnitKt.getSp(13), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65532, (DefaultConstructorMarker) null);
            final TextStyle specialStyle = new TextStyle(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), TextUnitKt.getSp(13), FontWeight.Companion.getMedium(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, TextAlign.Companion.getCenter-e0LSkKk(), 0, TextUnitKt.getSp(18), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16613368, (DefaultConstructorMarker) null);
            TextMeasurer textMeasure = TextMeasurerHelperKt.rememberTextMeasurer(0, $composer3, 0, 1);
            AnnotatedString.Builder $this$Subtitle_u24lambda_u243 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
            SpanStyle style$iv = specialStyle.toSpanStyle();
            int index$iv = $this$Subtitle_u24lambda_u243.pushStyle(style$iv);
            try {
                $this$Subtitle_u24lambda_u243.append(String.valueOf(number));
                Unit unit = Unit.INSTANCE;
                $this$Subtitle_u24lambda_u243.pop(index$iv);
                TextLayoutResult layoutResult = TextMeasurer.measure-xDpz5zY$default(textMeasure, $this$Subtitle_u24lambda_u243.toAnnotatedString(), specialStyle, 0, false, 0, (List) null, 0L, (LayoutDirection) null, (Density) null, (FontFamily.Resolver) null, false, 2044, (Object) null);
                if (number > 0) {
                    $composer3.startReplaceGroup(923052921);
                    ComposerKt.sourceInformation($composer3, "607@23791L7,611@24048L1059");
                    String valueOf = String.valueOf(number);
                    CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume = $composer3.consume(this_$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density $this$Subtitle_u24lambda_u241 = (Density) consume;
                    Map mapOf = MapsKt.mapOf(TuplesKt.to(valueOf, new InlineTextContent(new Placeholder($this$Subtitle_u24lambda_u241.toSp-kPz2Gy4(layoutResult.getMultiParagraph().getWidth() + $this$Subtitle_u24lambda_u241.toPx-0680j_4(Dp.constructor-impl(12))), TextUnitKt.getSp(18), PlaceholderVerticalAlign.Companion.getTextBottom-J6kI3mc(), (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(771668671, true, new Function3() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda10
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            Unit Subtitle$lambda$2;
                            Subtitle$lambda$2 = TribeeInviteListKt.Subtitle$lambda$2(number, specialStyle, (String) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            return Subtitle$lambda$2;
                        }
                    }, $composer3, 54))));
                    $composer3.endReplaceGroup();
                    inlineContent = mapOf;
                } else {
                    $composer3.startReplaceGroup(924521515);
                    $composer3.endReplaceGroup();
                    inlineContent = MapsKt.emptyMap();
                }
                $this$Subtitle_u24lambda_u243 = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
                String it = StringsKt.substringBefore$default(subtitle, String.valueOf(number), (String) null, 2, (Object) null);
                if (!(it.length() < subtitle.length())) {
                    it = null;
                }
                String before = it;
                String it2 = StringsKt.substringAfter$default(subtitle, String.valueOf(number), (String) null, 2, (Object) null);
                int length = it2.length();
                int $i$f$buildAnnotatedString = subtitle.length();
                if (!(length < $i$f$buildAnnotatedString)) {
                    it2 = null;
                }
                String after = it2;
                try {
                    if (before != null) {
                        if (before.length() > 0) {
                            z = true;
                            if (z && !inlineContent.isEmpty()) {
                                if (after != null) {
                                    if (after.length() > 0) {
                                        z2 = true;
                                        if (z2) {
                                            index$iv = $this$Subtitle_u24lambda_u243.pushStyle(normalStyle);
                                            try {
                                                $this$Subtitle_u24lambda_u243.append(before);
                                                Unit unit2 = Unit.INSTANCE;
                                                $this$Subtitle_u24lambda_u243.pop(index$iv);
                                                InlineTextContentKt.appendInlineContent$default($this$Subtitle_u24lambda_u243, String.valueOf(number), (String) null, 2, (Object) null);
                                                index$iv = $this$Subtitle_u24lambda_u243.pushStyle(normalStyle);
                                                try {
                                                    $this$Subtitle_u24lambda_u243.append(after);
                                                    Unit unit3 = Unit.INSTANCE;
                                                    $composer2 = $composer3;
                                                    TextKt.Text-Z58ophY($this$Subtitle_u24lambda_u243.toAnnotatedString(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, inlineContent, (Function1) null, (TextStyle) null, $composer2, 0, 48, 456702);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                } finally {
                                                }
                                            } finally {
                                            }
                                        }
                                    }
                                }
                                z2 = false;
                                if (z2) {
                                }
                            }
                            index$iv = $this$Subtitle_u24lambda_u243.pushStyle(normalStyle);
                            $this$Subtitle_u24lambda_u243.append(subtitle);
                            Unit unit4 = Unit.INSTANCE;
                            $composer2 = $composer3;
                            TextKt.Text-Z58ophY($this$Subtitle_u24lambda_u243.toAnnotatedString(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, inlineContent, (Function1) null, (TextStyle) null, $composer2, 0, 48, 456702);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                        }
                    }
                    $this$Subtitle_u24lambda_u243.append(subtitle);
                    Unit unit42 = Unit.INSTANCE;
                    $composer2 = $composer3;
                    TextKt.Text-Z58ophY($this$Subtitle_u24lambda_u243.toAnnotatedString(), (Modifier) null, 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, TextUnitKt.getSp(18), 0, false, 0, 0, inlineContent, (Function1) null, (TextStyle) null, $composer2, 0, 48, 456702);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                } finally {
                }
                z = false;
                if (z) {
                    if (after != null) {
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
                index$iv = $this$Subtitle_u24lambda_u243.pushStyle(normalStyle);
            } finally {
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj, Object obj2) {
                    Unit Subtitle$lambda$4;
                    Subtitle$lambda$4 = TribeeInviteListKt.Subtitle$lambda$4(subtitle, number, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Subtitle$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Subtitle$lambda$2(long $number, TextStyle $specialStyle, String it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)616@24285L7,619@24471L6,612@24074L1011:TribeeInviteList.kt#8mvn07");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(771668671, $changed, -1, "kntr.app.tribee.invite.page.Subtitle.<anonymous> (TribeeInviteList.kt:612)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 2, (Object) null);
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            Density $this$Subtitle_u24lambda_u242_u240 = (Density) consume;
            Modifier modifier$iv = BorderKt.border-xT4_qwU(SizeKt.height-3ABfNKs(modifier, $this$Subtitle_u24lambda_u242_u240.toDp-GaN1DYA(TextUnitKt.getSp(18))), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
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
            ComposerKt.sourceInformationMarkerStart($composer, 107808561, "C624@24726L333:TribeeInviteList.kt#8mvn07");
            TextKt.Text-Nvy7gAk(String.valueOf($number), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(4), 0.0f, 2, (Object) null), 0L, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), TextUnitKt.getSp(18), 0, false, 0, 0, (Function1) null, $specialStyle, $composer, 48, 48, 127996);
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

    /* renamed from: drawDivider-bw27NRU$default  reason: not valid java name */
    public static /* synthetic */ void m802drawDividerbw27NRU$default(DrawScope drawScope, long j, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = drawScope.toPx-0680j_4(Dp.constructor-impl(1));
        }
        m801drawDividerbw27NRU(drawScope, j, f);
    }

    /* renamed from: drawDivider-bw27NRU  reason: not valid java name */
    public static final void m801drawDividerbw27NRU(DrawScope $this$drawDivider_u2dbw27NRU, long j, float y) {
        Intrinsics.checkNotNullParameter($this$drawDivider_u2dbw27NRU, "$this$drawDivider");
        PathEffect dashPathEffect = PathEffect.Companion.dashPathEffect(new float[]{$this$drawDivider_u2dbw27NRU.toPx-0680j_4(Dp.constructor-impl(2)), $this$drawDivider_u2dbw27NRU.toPx-0680j_4(Dp.constructor-impl(2))}, 0.0f);
        float f = $this$drawDivider_u2dbw27NRU.toPx-0680j_4(Dp.constructor-impl(1));
        float x$iv = $this$drawDivider_u2dbw27NRU.toPx-0680j_4(Dp.constructor-impl(24));
        long v1$iv$iv = Float.floatToRawIntBits(x$iv);
        long v2$iv$iv = Float.floatToRawIntBits(y);
        long j2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
        int bits$iv$iv$iv = (int) ($this$drawDivider_u2dbw27NRU.getSize-NH-jbRc() >> 32);
        float x$iv2 = Float.intBitsToFloat(bits$iv$iv$iv) - $this$drawDivider_u2dbw27NRU.toPx-0680j_4(Dp.constructor-impl(24));
        long v1$iv$iv2 = Float.floatToRawIntBits(x$iv2);
        long v2$iv$iv2 = Float.floatToRawIntBits(y);
        DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawDivider_u2dbw27NRU, j, j2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv2 & 4294967295L)), f, 0, dashPathEffect, 0.0f, (ColorFilter) null, 0, 464, (Object) null);
    }

    public static final List<InviteItem> mapChildrenToInviteItems(KTribeeInviteCodeItem $this$mapChildrenToInviteItems, boolean needFold) {
        Intrinsics.checkNotNullParameter($this$mapChildrenToInviteItems, "<this>");
        if (!needFold) {
            Iterable $this$mapIndexed$iv = $this$mapChildrenToInviteItems.getInviteCodes();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KTribeeInviteCodeDesc code = (KTribeeInviteCodeDesc) item$iv$iv;
                destination$iv$iv.add(new InviteItem.CodeItem(code, $this$mapChildrenToInviteItems.getTribeeId(), $this$mapChildrenToInviteItems.getTribeeTitle(), $this$mapChildrenToInviteItems.getTribeeFaceUrl(), index$iv$iv == $this$mapChildrenToInviteItems.getInviteCodes().size() - 1));
                index$iv$iv = index$iv$iv2;
            }
            return (List) destination$iv$iv;
        }
        List $this$mapChildrenToInviteItems_u24lambda_u241 = new ArrayList();
        Iterable $this$mapIndexed$iv2 = $this$mapChildrenToInviteItems.getInviteCodes().subList(0, (int) $this$mapChildrenToInviteItems.getShowLength());
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv2, 10));
        int index$iv$iv3 = 0;
        for (Object item$iv$iv2 : $this$mapIndexed$iv2) {
            int index$iv$iv4 = index$iv$iv3 + 1;
            if (index$iv$iv3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KTribeeInviteCodeDesc code2 = (KTribeeInviteCodeDesc) item$iv$iv2;
            destination$iv$iv2.add(new InviteItem.CodeItem(code2, $this$mapChildrenToInviteItems.getTribeeId(), $this$mapChildrenToInviteItems.getTribeeTitle(), $this$mapChildrenToInviteItems.getTribeeFaceUrl(), false));
            index$iv$iv3 = index$iv$iv4;
        }
        $this$mapChildrenToInviteItems_u24lambda_u241.addAll((List) destination$iv$iv2);
        long tribeeId = $this$mapChildrenToInviteItems.getTribeeId();
        int showLength = (int) $this$mapChildrenToInviteItems.getShowLength();
        Iterable $this$map$iv = $this$mapChildrenToInviteItems.getInviteCodes().subList((int) $this$mapChildrenToInviteItems.getShowLength(), $this$mapChildrenToInviteItems.getInviteCodes().size());
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv3 : $this$map$iv) {
            KTribeeInviteCodeDesc code3 = (KTribeeInviteCodeDesc) item$iv$iv3;
            destination$iv$iv3.add(new InviteItem.CodeItem(code3, $this$mapChildrenToInviteItems.getTribeeId(), $this$mapChildrenToInviteItems.getTribeeTitle(), $this$mapChildrenToInviteItems.getTribeeFaceUrl(), false));
        }
        $this$mapChildrenToInviteItems_u24lambda_u241.add(new InviteItem.Expandable(false, showLength, (List) destination$iv$iv3, tribeeId));
        return $this$mapChildrenToInviteItems_u24lambda_u241;
    }

    public static final List<InviteItem> initialInviteList(List<KTribeeInviteCodeItem> list) {
        Intrinsics.checkNotNullParameter(list, "dataList");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            KTribeeInviteCodeItem tribeeTitle = (KTribeeInviteCodeItem) next;
            boolean needFold = ((long) tribeeTitle.getInviteCodes().size()) > tribeeTitle.getShowLength();
            boolean isCollapsed = tribeeTitle.isFold();
            Iterator it2 = it;
            List $this$initialInviteList_u24lambda_u240_u240 = CollectionsKt.mutableListOf(new InviteItem[]{new InviteItem.TribeeItem(tribeeTitle.getTribeeId(), tribeeTitle.getTribeeTitle(), tribeeTitle.getTribeeFaceUrl(), tribeeTitle.getJumpUrl(), isCollapsed, false, tribeeTitle.getInviteCodes().size(), (int) tribeeTitle.getShowLength())});
            if (!isCollapsed) {
                $this$initialInviteList_u24lambda_u240_u240.addAll(mapChildrenToInviteItems(tribeeTitle, needFold));
            }
            CollectionsKt.addAll(arrayList, $this$initialInviteList_u24lambda_u240_u240);
            i = i2;
            it = it2;
        }
        return arrayList;
    }

    public static final void updateListBackground(final SnapshotStateList<InviteItem> snapshotStateList, List<Pair<Integer, Boolean>> list) {
        InviteItem.TribeeItem copy;
        Intrinsics.checkNotNullParameter(snapshotStateList, "<this>");
        Intrinsics.checkNotNullParameter(list, "itemIndexBoundaryMap");
        if (list.isEmpty()) {
            ListIterator iterator = snapshotStateList.listIterator();
            while (iterator.hasNext()) {
                InviteItem item = (InviteItem) iterator.next();
                if (item instanceof InviteItem.TribeeItem) {
                    copy = r5.copy((r20 & 1) != 0 ? r5.tribeeId : 0L, (r20 & 2) != 0 ? r5.tribeeTitle : null, (r20 & 4) != 0 ? r5.tribeeFaceUrl : null, (r20 & 8) != 0 ? r5.jumpUrl : null, (r20 & 16) != 0 ? r5.isCollapsed : false, (r20 & 32) != 0 ? r5.childrenIsHidden : false, (r20 & 64) != 0 ? r5.codesSize : 0, (r20 & 128) != 0 ? ((InviteItem.TribeeItem) item).showLength : 0);
                    iterator.set(copy);
                }
            }
            return;
        }
        List<Pair<Integer, Boolean>> $this$forEach$iv = list;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair) element$iv;
            int index = ((Number) pair.getFirst()).intValue();
            final boolean toHidden = ((Boolean) pair.getSecond()).booleanValue();
            InviteItem inviteItem = (InviteItem) CollectionsKt.getOrNull((List) snapshotStateList, index);
            if (inviteItem != null) {
                final long tribeeId = inviteItem.getTribeeId();
                checkIndexOfFirst((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda4
                    public final Object invoke(Object obj) {
                        boolean updateListBackground$lambda$0$0$0;
                        updateListBackground$lambda$0$0$0 = TribeeInviteListKt.updateListBackground$lambda$0$0$0(tribeeId, (InviteItem) obj);
                        return Boolean.valueOf(updateListBackground$lambda$0$0$0);
                    }
                }, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda5
                    public final Object invoke(Object obj) {
                        Unit updateListBackground$lambda$0$0$1;
                        updateListBackground$lambda$0$0$1 = TribeeInviteListKt.updateListBackground$lambda$0$0$1(snapshotStateList, toHidden, ((Integer) obj).intValue());
                        return updateListBackground$lambda$0$0$1;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBackground$lambda$0$0$0(long $tribeeId, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTribeeId() == $tribeeId && (it instanceof InviteItem.TribeeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateListBackground$lambda$0$0$1(SnapshotStateList $this_updateListBackground, boolean $toHidden, int changedTribeeIndex) {
        Object orNull = CollectionsKt.getOrNull((List) $this_updateListBackground, changedTribeeIndex);
        InviteItem.TribeeItem tribeeItem = null;
        InviteItem.TribeeItem tribeeItem2 = orNull instanceof InviteItem.TribeeItem ? (InviteItem.TribeeItem) orNull : null;
        if (tribeeItem2 != null) {
            tribeeItem = tribeeItem2.copy((r20 & 1) != 0 ? tribeeItem2.tribeeId : 0L, (r20 & 2) != 0 ? tribeeItem2.tribeeTitle : null, (r20 & 4) != 0 ? tribeeItem2.tribeeFaceUrl : null, (r20 & 8) != 0 ? tribeeItem2.jumpUrl : null, (r20 & 16) != 0 ? tribeeItem2.isCollapsed : false, (r20 & 32) != 0 ? tribeeItem2.childrenIsHidden : $toHidden, (r20 & 64) != 0 ? tribeeItem2.codesSize : 0, (r20 & 128) != 0 ? tribeeItem2.showLength : 0);
        }
        InviteItem.TribeeItem newItem = tribeeItem;
        if (newItem != null) {
            $this_updateListBackground.set(changedTribeeIndex, newItem);
        }
        return Unit.INSTANCE;
    }

    public static final void updateListBy(final SnapshotStateList<InviteItem> snapshotStateList, final List<KTribeeInviteCodeItem> list, InviteItem inviteItem) {
        Intrinsics.checkNotNullParameter(snapshotStateList, "<this>");
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(inviteItem, "inviteItem");
        final InviteItem.TribeeItem tribeeItem = inviteItem instanceof InviteItem.TribeeItem ? (InviteItem.TribeeItem) inviteItem : null;
        if (tribeeItem != null) {
            if (tribeeItem.isCollapsed()) {
                checkIndexOfFirst((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda8
                    public final Object invoke(Object obj) {
                        boolean updateListBy$lambda$0;
                        updateListBy$lambda$0 = TribeeInviteListKt.updateListBy$lambda$0(InviteItem.TribeeItem.this, (InviteItem) obj);
                        return Boolean.valueOf(updateListBy$lambda$0);
                    }
                }, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj) {
                        Unit updateListBy$lambda$1;
                        updateListBy$lambda$1 = TribeeInviteListKt.updateListBy$lambda$1(snapshotStateList, tribeeItem, list, ((Integer) obj).intValue());
                        return updateListBy$lambda$1;
                    }
                });
                return;
            }
            CollectionsKt.removeAll((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj) {
                    boolean updateListBy$lambda$2;
                    updateListBy$lambda$2 = TribeeInviteListKt.updateListBy$lambda$2(InviteItem.TribeeItem.this, (InviteItem) obj);
                    return Boolean.valueOf(updateListBy$lambda$2);
                }
            });
            checkIndexOfFirst((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj) {
                    boolean updateListBy$lambda$3;
                    updateListBy$lambda$3 = TribeeInviteListKt.updateListBy$lambda$3(InviteItem.TribeeItem.this, (InviteItem) obj);
                    return Boolean.valueOf(updateListBy$lambda$3);
                }
            }, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj) {
                    Unit updateListBy$lambda$4;
                    updateListBy$lambda$4 = TribeeInviteListKt.updateListBy$lambda$4(snapshotStateList, tribeeItem, ((Integer) obj).intValue());
                    return updateListBy$lambda$4;
                }
            });
            return;
        }
        final InviteItem.Expandable expandableItem = inviteItem instanceof InviteItem.Expandable ? (InviteItem.Expandable) inviteItem : null;
        if (expandableItem != null) {
            if (expandableItem.isExpandedAll()) {
                CollectionsKt.removeAll((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj) {
                        boolean updateListBy$lambda$5;
                        updateListBy$lambda$5 = TribeeInviteListKt.updateListBy$lambda$5(InviteItem.Expandable.this, (InviteItem) obj);
                        return Boolean.valueOf(updateListBy$lambda$5);
                    }
                });
                checkIndexOfFirst((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj) {
                        boolean updateListBy$lambda$6;
                        updateListBy$lambda$6 = TribeeInviteListKt.updateListBy$lambda$6(InviteItem.Expandable.this, (InviteItem) obj);
                        return Boolean.valueOf(updateListBy$lambda$6);
                    }
                }, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda16
                    public final Object invoke(Object obj) {
                        Unit updateListBy$lambda$7;
                        updateListBy$lambda$7 = TribeeInviteListKt.updateListBy$lambda$7(snapshotStateList, expandableItem, ((Integer) obj).intValue());
                        return updateListBy$lambda$7;
                    }
                });
                return;
            }
            checkIndexOfFirst((List) snapshotStateList, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj) {
                    boolean updateListBy$lambda$8;
                    updateListBy$lambda$8 = TribeeInviteListKt.updateListBy$lambda$8(InviteItem.Expandable.this, (InviteItem) obj);
                    return Boolean.valueOf(updateListBy$lambda$8);
                }
            }, new Function1() { // from class: kntr.app.tribee.invite.page.TribeeInviteListKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj) {
                    Unit updateListBy$lambda$9;
                    updateListBy$lambda$9 = TribeeInviteListKt.updateListBy$lambda$9(snapshotStateList, expandableItem, ((Integer) obj).intValue());
                    return updateListBy$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$0(InviteItem.TribeeItem $tribeeItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof InviteItem.TribeeItem) && ((InviteItem.TribeeItem) it).getTribeeId() == $tribeeItem.getTribeeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateListBy$lambda$1(SnapshotStateList $this_updateListBy, InviteItem.TribeeItem $tribeeItem, List $dataList, int index) {
        InviteItem.TribeeItem copy;
        Object obj;
        List<InviteItem> mapChildrenToInviteItems;
        boolean z;
        copy = $tribeeItem.copy((r20 & 1) != 0 ? $tribeeItem.tribeeId : 0L, (r20 & 2) != 0 ? $tribeeItem.tribeeTitle : null, (r20 & 4) != 0 ? $tribeeItem.tribeeFaceUrl : null, (r20 & 8) != 0 ? $tribeeItem.jumpUrl : null, (r20 & 16) != 0 ? $tribeeItem.isCollapsed : false, (r20 & 32) != 0 ? $tribeeItem.childrenIsHidden : false, (r20 & 64) != 0 ? $tribeeItem.codesSize : 0, (r20 & 128) != 0 ? $tribeeItem.showLength : 0);
        $this_updateListBy.set(index, copy);
        int i = index + 1;
        Iterator it = $dataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            KTribeeInviteCodeItem it2 = (KTribeeInviteCodeItem) obj;
            if (it2.getTribeeId() == $tribeeItem.getTribeeId()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        KTribeeInviteCodeItem kTribeeInviteCodeItem = (KTribeeInviteCodeItem) obj;
        $this_updateListBy.addAll(i, (kTribeeInviteCodeItem == null || (mapChildrenToInviteItems = mapChildrenToInviteItems(kTribeeInviteCodeItem, $tribeeItem.needFold())) == null) ? CollectionsKt.emptyList() : mapChildrenToInviteItems);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$2(InviteItem.TribeeItem $tribeeItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTribeeId() == $tribeeItem.getTribeeId() && !(it instanceof InviteItem.TribeeItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$3(InviteItem.TribeeItem $tribeeItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof InviteItem.TribeeItem) && ((InviteItem.TribeeItem) it).getTribeeId() == $tribeeItem.getTribeeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateListBy$lambda$4(SnapshotStateList $this_updateListBy, InviteItem.TribeeItem $tribeeItem, int index) {
        InviteItem.TribeeItem copy;
        copy = $tribeeItem.copy((r20 & 1) != 0 ? $tribeeItem.tribeeId : 0L, (r20 & 2) != 0 ? $tribeeItem.tribeeTitle : null, (r20 & 4) != 0 ? $tribeeItem.tribeeFaceUrl : null, (r20 & 8) != 0 ? $tribeeItem.jumpUrl : null, (r20 & 16) != 0 ? $tribeeItem.isCollapsed : true, (r20 & 32) != 0 ? $tribeeItem.childrenIsHidden : true, (r20 & 64) != 0 ? $tribeeItem.codesSize : 0, (r20 & 128) != 0 ? $tribeeItem.showLength : 0);
        $this_updateListBy.set(index, copy);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$5(InviteItem.Expandable $expandableItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getTribeeId() == $expandableItem.getTribeeId() && (it instanceof InviteItem.CodeItem) && $expandableItem.getExpandableChildren().contains(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$6(InviteItem.Expandable $expandableItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof InviteItem.Expandable) && ((InviteItem.Expandable) it).getTribeeId() == $expandableItem.getTribeeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateListBy$lambda$7(SnapshotStateList $this_updateListBy, InviteItem.Expandable $expandableItem, int index) {
        $this_updateListBy.set(index, InviteItem.Expandable.copy$default($expandableItem, false, 0, null, 0L, 14, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateListBy$lambda$8(InviteItem.Expandable $expandableItem, InviteItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (it instanceof InviteItem.Expandable) && ((InviteItem.Expandable) it).getTribeeId() == $expandableItem.getTribeeId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateListBy$lambda$9(SnapshotStateList $this_updateListBy, InviteItem.Expandable $expandableItem, int index) {
        $this_updateListBy.set(index, InviteItem.Expandable.copy$default($expandableItem, true, 0, null, 0L, 14, null));
        $this_updateListBy.addAll(index, $expandableItem.getExpandableChildren());
        return Unit.INSTANCE;
    }

    public static final <T> void checkIndexOfFirst(List<? extends T> list, Function1<? super T, Boolean> function1, Function1<? super Integer, Unit> function12) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        Intrinsics.checkNotNullParameter(function12, "onContinue");
        int index$iv = 0;
        Iterator<? extends T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                if (((Boolean) function1.invoke(item$iv)).booleanValue()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = index$iv;
        if (index >= 0) {
            function12.invoke(Integer.valueOf(index));
        }
    }
}