package im.session.common;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableState;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.ContentColorKt;
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
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import bili.resource.im.Res;
import bili.resource.im.String1_commonMainKt;
import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bapis.bilibili.app.im.v1.KBehaviorAlertToast;
import com.bapis.bilibili.app.im.v1.KSessionListExtraInfo;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import com.yalantis.ucrop.view.CropImageView;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IMListStatusKt;
import im.base.IMPageStatusKt;
import im.base.IMStatusKt;
import im.base.IMTopBarKt;
import im.base.IdleContent;
import im.base.LoadingContent;
import im.session.IMActionChangeFilter;
import im.session.IMActionClearAllSessions;
import im.session.IMActionClearUnread;
import im.session.IMActionSessionDeleteConfirm;
import im.session.IMState;
import im.session.bottomsheet.BottomSheetHolder;
import im.session.bottomsheet.IMConversationBottomSheetKt;
import im.session.bottomsheet.IMPageBottomSheetMenuKt;
import im.session.bottomsheet.PageMoreMenu;
import im.session.bottomsheet.SessionContextMenu;
import im.session.home.AutoReplyBubbleKt;
import im.session.home.IMQuickLinkKt;
import im.session.model.IMQuickLink;
import im.session.model.IMSessionAlert;
import im.session.model.IMSessionAntiHarassmentAlert;
import im.session.model.IMSessionBehaviorAlert;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardKt;
import im.session.model.IMSessionCardOperation;
import im.session.model.IMSessionFilter;
import im.session.model.IMSessionPageData;
import im.session.model.IMThreeDotItem;
import im.setting.UtilsKt;
import java.util.List;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.imageloader.ImmutableImageRequest;
import kntr.common.trio.list.DefaultListModifierKt;
import kntr.common.trio.systemui.ScrollToTopKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.compose.resources.StringResource;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: IMSessionPage.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a\u001d\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a\u001d\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0016\u001a\u001d\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0019\u001a\u001d\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0011\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0001¢\u0006\u0002\u0010!\u001a\u0015\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"IMSessionPage", "", "pageState", "Lim/session/common/IMSessionPageState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lim/session/common/IMSessionPageState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "IMSessionPageContent", "pageData", "Lim/session/IMState;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Lim/session/common/IMSessionPageState;Lim/session/IMState;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "IMSessionFilterTabs", "page", "Lim/session/model/IMSessionPageData;", "onAction", "Lim/session/common/IMSessionActionHandler;", "(Lim/session/model/IMSessionPageData;Lim/session/common/IMSessionActionHandler;Landroidx/compose/runtime/Composer;I)V", "FilterTab", "tab", "Lim/session/model/IMSessionFilter;", "(Lim/session/model/IMSessionFilter;Lim/session/common/IMSessionActionHandler;Landroidx/compose/runtime/Composer;I)V", "IMSessionPageActions", UtilsKt.DATA_KEY, "(Lim/session/model/IMSessionPageData;Lim/session/common/IMSessionPageState;Landroidx/compose/runtime/Composer;I)V", "IMSessionIconAction", AuthActivity.ACTION_KEY, "Lim/session/model/IMThreeDotItem;", "(Lim/session/model/IMThreeDotItem;Lim/session/common/IMSessionPageState;Landroidx/compose/runtime/Composer;I)V", "rememberTitle", "Lorg/jetbrains/compose/resources/StringResource;", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Landroidx/compose/runtime/Composer;I)Lorg/jetbrains/compose/resources/StringResource;", "CustomerHint", "title", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CustomerHint$lambda$1(String str, int i2, Composer composer, int i3) {
        CustomerHint(str, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterTab$lambda$2(IMSessionFilter iMSessionFilter, IMSessionActionHandler iMSessionActionHandler, int i2, Composer composer, int i3) {
        FilterTab(iMSessionFilter, iMSessionActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionFilterTabs$lambda$1(IMSessionPageData iMSessionPageData, IMSessionActionHandler iMSessionActionHandler, int i2, Composer composer, int i3) {
        IMSessionFilterTabs(iMSessionPageData, iMSessionActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionIconAction$lambda$2(IMThreeDotItem iMThreeDotItem, IMSessionPageState iMSessionPageState, int i2, Composer composer, int i3) {
        IMSessionIconAction(iMThreeDotItem, iMSessionPageState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$11(IMSessionPageState iMSessionPageState, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        IMSessionPage(iMSessionPageState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageActions$lambda$1(IMSessionPageData iMSessionPageData, IMSessionPageState iMSessionPageState, int i2, Composer composer, int i3) {
        IMSessionPageActions(iMSessionPageData, iMSessionPageState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$2(IMSessionPageState iMSessionPageState, IMState iMState, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        IMSessionPageContent(iMSessionPageState, iMState, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x032b, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0369, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void IMSessionPage(final IMSessionPageState pageState, Modifier modifier, Composer $composer, final int $changed, final int i2) {
        final Modifier modifier2;
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        int i3;
        Intrinsics.checkNotNullParameter(pageState, "pageState");
        Composer $composer3 = $composer.startRestartGroup(128150340);
        ComposerKt.sourceInformation($composer3, "C(IMSessionPage)N(pageState,modifier)101@4250L1071,191@7203L24,215@8030L165,215@7963L232:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(pageState) ? 4 : 2;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            Modifier modifier3 = i4 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(128150340, $dirty2, -1, "im.session.common.IMSessionPage (IMSessionPage.kt:99)");
            }
            final IMState page = (IMState) pageState.getPage().getValue();
            int $changed$iv = ($dirty2 >> 3) & 14;
            Modifier modifier$iv = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = ($changed$iv << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int $changed2 = (($changed$iv >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            BoxScope $this$IMSessionPage_u24lambda_u240 = boxScope;
            ComposerKt.sourceInformationMarkerStart($composer3, 1517050047, "C106@4426L6,102@4285L868:IMSessionPage.kt#yqxgzx");
            Modifier modifier$iv2 = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1008227027, "C108@4508L65,108@4575L133,108@4463L245:IMSessionPage.kt#yqxgzx");
            IMTopBarKt.m3090IMTopBarnWoaYo(ComposableLambdaKt.rememberComposableLambda(-953833863, true, new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionPage$lambda$0$0$0;
                    IMSessionPage$lambda$0$0$0 = IMSessionPageKt.IMSessionPage$lambda$0$0$0(IMSessionPageState.this, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionPage$lambda$0$0$0;
                }
            }, $composer3, 54), null, 0L, 0L, false, false, null, null, ComposableLambdaKt.rememberComposableLambda(-153528975, true, new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionPage$lambda$0$0$1;
                    IMSessionPage$lambda$0$0$1 = IMSessionPageKt.IMSessionPage$lambda$0$0$1(IMState.this, pageState, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionPage$lambda$0$0$1;
                }
            }, $composer3, 54), $composer3, 100687878, TbsListener.ErrorCode.TPATCH_FAIL);
            if (Intrinsics.areEqual(page.getPageContentStatus(), IdleContent.INSTANCE)) {
                $composer3.startReplaceGroup(1008776718);
                ComposerKt.sourceInformation($composer3, "122@5053L76");
                IMSessionPageContent(pageState, page, pageState.getEventHandler(), $composer3, $dirty2 & 14);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1008529617);
                ComposerKt.sourceInformation($composer3, "118@4928L16,119@4978L18,115@4782L233");
                boolean isLoggedIn = page.isLoggedIn();
                ContentStatus pageContentStatus = page.getPageContentStatus();
                ComposerKt.sourceInformationMarkerStart($composer3, -383104328, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv = ($dirty2 & 14) == 4;
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = (KFunction) new IMSessionPageKt$IMSessionPage$1$1$3$1(pageState);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                Function2 function2 = (KFunction) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, -383102726, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 14) == 4;
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2) {
                }
                Object value$iv2 = (KFunction) new IMSessionPageKt$IMSessionPage$1$1$4$1(pageState);
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IMPageStatusKt.IMPageStatus(pageContentStatus, isLoggedIn, null, null, function2, (KFunction) it$iv2, $composer3, 0, 12);
                $composer3.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            KAutoReplyToast autoReply = (KAutoReplyToast) pageState.getAutoReplyBubble().getValue();
            if (autoReply != null) {
                $composer3.startReplaceGroup(1517968762);
                ComposerKt.sourceInformation($composer3, "127@5255L50");
                AutoReplyBubbleKt.AutoReplyBubble($this$IMSessionPage_u24lambda_u240, autoReply, pageState.getEventHandler(), $composer3, $changed2 & 14);
            } else {
                $composer3.startReplaceGroup(1512766404);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            BottomSheetHolder bottomSheet = pageState.getLongClickedCard();
            if (bottomSheet instanceof SessionContextMenu) {
                $composer2 = $composer3;
                $composer2.startReplaceGroup(-497854223);
                ComposerKt.sourceInformation($composer2, "135@5531L29,133@5427L213");
                List<IMSessionCardOperation> cardOperations = ((SessionContextMenu) bottomSheet).getCard().getCardOperations();
                ComposerKt.sourceInformationMarkerStart($composer2, -1401529567, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv3 = ($dirty2 & 14) == 4;
                Object it$iv3 = $composer2.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = (KFunction) new IMSessionPageKt$IMSessionPage$2$1(pageState);
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                IMConversationBottomSheetKt.IMConversationBottomSheet(cardOperations, (KFunction) it$iv3, pageState.getEventHandler().getActionHandler(), $composer2, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2 = $composer3;
                if (bottomSheet instanceof PageMoreMenu) {
                    $composer2.startReplaceGroup(-497593296);
                    ComposerKt.sourceInformation($composer2, "141@5693L118");
                    IMPageBottomSheetMenuKt.IMPageBottomSheetMenu(((PageMoreMenu) bottomSheet).getThreeDotItems(), pageState, $composer2, ($dirty2 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW);
                    $composer2.endReplaceGroup();
                } else {
                    $composer2.startReplaceGroup(-497438916);
                    $composer2.endReplaceGroup();
                }
            }
            if (((Boolean) pageState.getClearUnreadState().getValue()).booleanValue()) {
                $composer2.startReplaceGroup(-497380016);
                ComposerKt.sourceInformation($composer2, "152@5997L146,150@5900L254");
                MutableState<Boolean> clearUnreadState = pageState.getClearUnreadState();
                ComposerKt.sourceInformationMarkerStart($composer2, -1401514538, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv4 = ($dirty2 & 14) == 4;
                Composer $this$cache$iv = $composer2;
                Object it$iv4 = $this$cache$iv.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv4 = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda11
                        public final Object invoke() {
                            Unit IMSessionPage$lambda$2$0;
                            IMSessionPage$lambda$2$0 = IMSessionPageKt.IMSessionPage$lambda$2$0(IMSessionPageState.this);
                            return IMSessionPage$lambda$2$0;
                        }
                    };
                    $this$cache$iv.updateRememberedValue(value$iv4);
                    it$iv4 = value$iv4;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ReadClearConfirmDialogKt.ReadClearConfirmDialog(clearUnreadState, (Function0) it$iv4, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-503232258);
            }
            $composer2.endReplaceGroup();
            if (((Boolean) pageState.getClearConversationState().getValue()).booleanValue()) {
                $composer2.startReplaceGroup(-497061956);
                ComposerKt.sourceInformation($composer2, "162@6326L157,160@6220L274");
                MutableState<Boolean> clearConversationState = pageState.getClearConversationState();
                ComposerKt.sourceInformationMarkerStart($composer2, -1401503999, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv5 = ($dirty2 & 14) == 4;
                Composer $this$cache$iv2 = $composer2;
                Object it$iv5 = $this$cache$iv2.rememberedValue();
                if (invalid$iv5 || it$iv5 == Composer.Companion.getEmpty()) {
                    Object value$iv5 = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda12
                        public final Object invoke() {
                            Unit IMSessionPage$lambda$3$0;
                            IMSessionPage$lambda$3$0 = IMSessionPageKt.IMSessionPage$lambda$3$0(IMSessionPageState.this);
                            return IMSessionPage$lambda$3$0;
                        }
                    };
                    $this$cache$iv2.updateRememberedValue(value$iv5);
                    it$iv5 = value$iv5;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ClearSessionConfirmDialogKt.ClearSessionConfirmDialog(clearConversationState, (Function0) it$iv5, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-503232258);
            }
            $composer2.endReplaceGroup();
            final IMSessionCard sessionDelete = page.getData().getSessionToDelete();
            if (sessionDelete != null) {
                $composer2.startReplaceGroup(-496683415);
                ComposerKt.sourceInformation($composer2, "172@6644L230,180@6902L229,171@6593L549");
                ComposerKt.sourceInformationMarkerStart($composer2, -1401493750, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv6 = (($dirty2 & 14) == 4) | $composer2.changed(sessionDelete);
                Composer $this$cache$iv3 = $composer2;
                Object it$iv6 = $this$cache$iv3.rememberedValue();
                if (invalid$iv6 || it$iv6 == Composer.Companion.getEmpty()) {
                    Object value$iv6 = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            Unit IMSessionPage$lambda$4$0;
                            IMSessionPage$lambda$4$0 = IMSessionPageKt.IMSessionPage$lambda$4$0(IMSessionPageState.this, sessionDelete);
                            return IMSessionPage$lambda$4$0;
                        }
                    };
                    $this$cache$iv3.updateRememberedValue(value$iv6);
                    it$iv6 = value$iv6;
                }
                Function0 function0 = (Function0) it$iv6;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1401485495, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv7 = (($dirty2 & 14) == 4) | $composer2.changed(sessionDelete);
                Composer $this$cache$iv4 = $composer2;
                Object it$iv7 = $this$cache$iv4.rememberedValue();
                if (invalid$iv7 || it$iv7 == Composer.Companion.getEmpty()) {
                    Object value$iv7 = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda14
                        public final Object invoke() {
                            Unit IMSessionPage$lambda$5$0;
                            IMSessionPage$lambda$5$0 = IMSessionPageKt.IMSessionPage$lambda$5$0(IMSessionPageState.this, sessionDelete);
                            return IMSessionPage$lambda$5$0;
                        }
                    };
                    $this$cache$iv4.updateRememberedValue(value$iv7);
                    it$iv7 = value$iv7;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ConfirmSessionDeleteDialogKt.ConfirmSessionDeleteDialog(function0, (Function0) it$iv7, $composer2, 0);
            } else {
                $composer2.startReplaceGroup(-503232258);
            }
            $composer2.endReplaceGroup();
            IMSessionAlert alert = (IMSessionAlert) pageState.getAlert().getValue();
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer$iv, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer$iv.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer$iv);
                $composer$iv.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (Intrinsics.areEqual(alert, IMSessionAntiHarassmentAlert.INSTANCE)) {
                $composer2.startReplaceGroup(-495993851);
                ComposerKt.sourceInformation($composer2, "195@7350L23,196@7403L140,194@7301L257");
                ComposerKt.sourceInformationMarkerStart($composer2, -1401471365, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv8 = ($dirty2 & 14) == 4;
                Composer $this$cache$iv5 = $composer2;
                Object it$iv8 = $this$cache$iv5.rememberedValue();
                if (invalid$iv8 || it$iv8 == Composer.Companion.getEmpty()) {
                    Object value$iv8 = (KFunction) new IMSessionPageKt$IMSessionPage$7$1(pageState);
                    $this$cache$iv5.updateRememberedValue(value$iv8);
                    it$iv8 = value$iv8;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Function0 function02 = (KFunction) it$iv8;
                ComposerKt.sourceInformationMarkerStart($composer2, -1401469552, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv9 = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
                Composer $this$cache$iv6 = $composer2;
                Object it$iv9 = $this$cache$iv6.rememberedValue();
                if (invalid$iv9 || it$iv9 == Composer.Companion.getEmpty()) {
                    Object value$iv9 = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda15
                        public final Object invoke() {
                            Unit IMSessionPage$lambda$7$0;
                            IMSessionPage$lambda$7$0 = IMSessionPageKt.IMSessionPage$lambda$7$0(scope, pageState);
                            return IMSessionPage$lambda$7$0;
                        }
                    };
                    $this$cache$iv6.updateRememberedValue(value$iv9);
                    it$iv9 = value$iv9;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                AntiHarassmentDialogKt.AntiHarassmentDialog(function02, (Function0) it$iv9, $composer2, 0);
                $composer2.endReplaceGroup();
                i3 = 0;
            } else if (alert instanceof IMSessionBehaviorAlert) {
                $composer2.startReplaceGroup(-495662864);
                ComposerKt.sourceInformation($composer2, "207@7745L57,208@7831L23,209@7884L23,204@7620L302");
                KBehaviorAlertToast content = ((IMSessionBehaviorAlert) alert).getContent();
                String stringResource = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_194(Res.string.INSTANCE), $composer2, 0);
                ComposerKt.sourceInformationMarkerStart($composer2, -1401455973, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv10 = ($dirty2 & 14) == 4;
                Composer $this$cache$iv7 = $composer2;
                Object it$iv10 = $this$cache$iv7.rememberedValue();
                if (invalid$iv10 || it$iv10 == Composer.Companion.getEmpty()) {
                    Object value$iv10 = (KFunction) new IMSessionPageKt$IMSessionPage$9$1(pageState);
                    $this$cache$iv7.updateRememberedValue(value$iv10);
                    it$iv10 = value$iv10;
                }
                Function0 function03 = (KFunction) it$iv10;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, -1401454277, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv11 = ($dirty2 & 14) == 4;
                Composer $this$cache$iv8 = $composer2;
                Object it$iv11 = $this$cache$iv8.rememberedValue();
                if (invalid$iv11 || it$iv11 == Composer.Companion.getEmpty()) {
                    Object value$iv11 = (KFunction) new IMSessionPageKt$IMSessionPage$10$1(pageState);
                    $this$cache$iv8.updateRememberedValue(value$iv11);
                    it$iv11 = value$iv11;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i3 = 0;
                IMAlertDialogKt.IMAlertDialog(content, function03, (KFunction) it$iv11, null, stringResource, $composer2, 3072, 0);
                $composer2.endReplaceGroup();
            } else {
                i3 = 0;
                if (alert != null) {
                    $composer2.startReplaceGroup(-1401474439);
                    $composer2.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                $composer2.startReplaceGroup(-495345796);
                $composer2.endReplaceGroup();
            }
            Boolean valueOf = Boolean.valueOf(page.getData().isCache());
            Boolean valueOf2 = Boolean.valueOf(!page.getData().getSessions().isEmpty());
            ComposerKt.sourceInformationMarkerStart($composer2, -1401449463, "CC(remember):IMSessionPage.kt#9igjgp");
            int i8 = ($composer2.changed(page) ? 1 : 0) | (($dirty2 & 14) == 4 ? 1 : i3);
            Composer $this$cache$iv9 = $composer2;
            Object it$iv12 = $this$cache$iv9.rememberedValue();
            if (i8 != 0 || it$iv12 == Composer.Companion.getEmpty()) {
                Object value$iv12 = (Function2) new IMSessionPageKt$IMSessionPage$11$1(page, pageState, null);
                $this$cache$iv9.updateRememberedValue(value$iv12);
                it$iv12 = value$iv12;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(valueOf, valueOf2, (Function2) it$iv12, $composer2, i3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionPage$lambda$11;
                    IMSessionPage$lambda$11 = IMSessionPageKt.IMSessionPage$lambda$11(IMSessionPageState.this, modifier2, $changed, i2, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionPage$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$0$0$0(IMSessionPageState $pageState, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C108@4554L15,108@4520L50,108@4510L61:IMSessionPage.kt#yqxgzx");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-953833863, $changed, -1, "im.session.common.IMSessionPage.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:108)");
            }
            IMTopBarKt.TextTitle(StringResourcesKt.stringResource(rememberTitle($pageState.getPageType(), $composer, 0), $composer, 0), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$0$0$1(IMState $page, IMSessionPageState $pageState, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C109@4593L101:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-153528975, $changed, -1, "im.session.common.IMSessionPage.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:109)");
            }
            IMSessionPageActions($page.getData(), $pageState, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$2$0(IMSessionPageState $pageState) {
        $pageState.getClearUnreadState().setValue(false);
        $pageState.getEventHandler().getActionHandler().invoke(IMActionClearUnread.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$3$0(IMSessionPageState $pageState) {
        $pageState.getClearConversationState().setValue(false);
        $pageState.getEventHandler().getActionHandler().invoke(IMActionClearAllSessions.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$4$0(IMSessionPageState $pageState, IMSessionCard $sessionDelete) {
        $pageState.getEventHandler().getActionHandler().invoke(new IMActionSessionDeleteConfirm($sessionDelete, false));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$5$0(IMSessionPageState $pageState, IMSessionCard $sessionDelete) {
        $pageState.getEventHandler().getActionHandler().invoke(new IMActionSessionDeleteConfirm($sessionDelete, true));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPage$lambda$7$0(CoroutineScope $scope, IMSessionPageState $pageState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMSessionPageKt$IMSessionPage$8$1$1($pageState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void IMSessionPageContent(final IMSessionPageState pageState, final IMState pageData, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Composer $composer2;
        ScrollableState state;
        Composer $composer3 = $composer.startRestartGroup(1758020889);
        ComposerKt.sourceInformation($composer3, "C(IMSessionPageContent)N(pageState,pageData,eventHandler)231@8430L17,233@8480L30,235@8537L32,236@8595L25,238@8663L142,238@8626L179,245@8864L24,245@8889L39,248@9013L12,250@9091L17,251@9116L1956,244@8810L2262:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(pageState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(pageData) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(eventHandler) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1758020889, $dirty2, -1, "im.session.common.IMSessionPageContent (IMSessionPage.kt:227)");
            }
            final IMSessionPageData page = pageData.getData();
            ScrollableState columnState = pageState.getColumnState();
            IMSessionPageStateKt.configListState(pageState, $composer3, $dirty2 & 14);
            final SwipeCancellingToken swipeCancellingToken = SwipeActionKt.rememberSwipeCancellingToken($composer3, 0);
            SwipeActionKt.cancelOnLazyListScrolling(swipeCancellingToken, columnState, $composer3, 0);
            SwipeActionKt.cancelOnLifecyclePaused(swipeCancellingToken, $composer3, 0);
            IMSessionCard sessionToDelete = page.getSessionToDelete();
            ComposerKt.sourceInformationMarkerStart($composer3, 1535941351, "CC(remember):IMSessionPage.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(page) | $composer3.changedInstance(swipeCancellingToken);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (Function2) new IMSessionPageKt$IMSessionPageContent$1$1(page, swipeCancellingToken, null);
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            EffectsKt.LaunchedEffect(sessionToDelete, (Function2) it$iv, $composer3, 0);
            Modifier defaultVerticalScrollableEffects = DefaultListModifierKt.defaultVerticalScrollableEffects(ScrollToTopKt.preferScrollToTop(SizeKt.fillMaxSize$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), columnState, (Flow) null, $composer3, 6, 2), columnState, $composer3, 0);
            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsetsKt.only-bOOhFvg(WindowInsets_androidKt.getSafeGestures(WindowInsets.Companion, $composer3, 6), WindowInsetsSides.Companion.getBottom-JoeWqyM()), $composer3, 0);
            ComposerKt.sourceInformationMarkerStart($composer3, 1535957661, "CC(remember):IMSessionPage.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 14) == 4) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32) | $composer3.changed(page) | (($dirty2 & 896) == 256) | $composer3.changedInstance(swipeCancellingToken);
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.Companion.getEmpty()) {
                state = columnState;
                $composer2 = $composer3;
                value$iv2 = new Function1() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda25
                    public final Object invoke(Object obj) {
                        Unit IMSessionPageContent$lambda$1$0;
                        IMSessionPageContent$lambda$1$0 = IMSessionPageKt.IMSessionPageContent$lambda$1$0(IMState.this, pageState, page, eventHandler, swipeCancellingToken, (LazyListScope) obj);
                        return IMSessionPageContent$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                state = columnState;
                $composer2 = $composer3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyColumn(defaultVerticalScrollableEffects, state, asPaddingValues, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) value$iv2, $composer2, 0, (int) TbsListener.ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_FAILED);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionPageContent$lambda$2;
                    IMSessionPageContent$lambda$2 = IMSessionPageKt.IMSessionPageContent$lambda$2(IMSessionPageState.this, pageData, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionPageContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0(final IMState $pageData, final IMSessionPageState $pageState, final IMSessionPageData $page, final IMSessionEventHandler $eventHandler, final SwipeCancellingToken $swipeCancellingToken, LazyListScope $this$LazyColumn) {
        final IMQuickLink it;
        Intrinsics.checkNotNullParameter($this$LazyColumn, "$this$LazyColumn");
        if (!Intrinsics.areEqual($pageData.getHeadStatus(), IdleContent.INSTANCE)) {
            LazyListScope.-CC.item$default($this$LazyColumn, "head-status", (Object) null, ComposableLambdaKt.composableLambdaInstance(2134041065, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda10
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$0;
                    IMSessionPageContent$lambda$1$0$0 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$0(IMState.this, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$0;
                }
            }), 2, (Object) null);
        }
        if ($pageState.getShowQuickLink() && (it = $page.getQuickLinks()) != null) {
            LazyListScope.-CC.item$default($this$LazyColumn, "quickLinks", (Object) null, ComposableLambdaKt.composableLambdaInstance(-673018476, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda18
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$1$0;
                    IMSessionPageContent$lambda$1$0$1$0 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$1$0(IMQuickLink.this, $eventHandler, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$1$0;
                }
            }), 2, (Object) null);
        }
        KSessionListExtraInfo extraInfo = $page.getExtraInfo();
        final String hint = extraInfo != null ? extraInfo.getCustomerHintTitle() : null;
        boolean z = false;
        if (hint != null && (!StringsKt.isBlank(hint))) {
            z = true;
        }
        if (z) {
            LazyListScope.-CC.item$default($this$LazyColumn, "customerHint", (Object) null, ComposableLambdaKt.composableLambdaInstance(-1053881231, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$2;
                    IMSessionPageContent$lambda$1$0$2 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$2(hint, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$2;
                }
            }), 2, (Object) null);
        }
        if ($pageState.getShowFilter() && !$page.getFilters().isEmpty()) {
            LazyListScope.-CC.item$default($this$LazyColumn, "filters", (Object) null, ComposableLambdaKt.composableLambdaInstance(-2084009707, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda20
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$3;
                    IMSessionPageContent$lambda$1$0$3 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$3(IMSessionPageData.this, $eventHandler, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$3;
                }
            }), 2, (Object) null);
        }
        if (!$page.getSessions().isEmpty()) {
            final List items$iv = $page.getSessions();
            final Function1 key$iv = new Function1() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda21
                public final Object invoke(Object obj) {
                    Object IMSessionPageContent$lambda$1$0$4;
                    IMSessionPageContent$lambda$1$0$4 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$4((IMSessionCard) obj);
                    return IMSessionPageContent$lambda$1$0$4;
                }
            };
            final Function1 contentType$iv = new Function1() { // from class: im.session.common.IMSessionPageKt$IMSessionPageContent$lambda$1$0$$inlined$items$default$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return m3279invoke((IMSessionCard) p1);
                }

                /* renamed from: invoke  reason: collision with other method in class */
                public final Void m3279invoke(IMSessionCard iMSessionCard) {
                    return null;
                }
            };
            $this$LazyColumn.items(items$iv.size(), new Function1<Integer, Object>() { // from class: im.session.common.IMSessionPageKt$IMSessionPageContent$lambda$1$0$$inlined$items$default$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    return key$iv.invoke(items$iv.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: im.session.common.IMSessionPageKt$IMSessionPageContent$lambda$1$0$$inlined$items$default$3
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke(((Number) p1).intValue());
                }

                public final Object invoke(int index) {
                    return contentType$iv.invoke(items$iv.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(802480018, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: im.session.common.IMSessionPageKt$IMSessionPageContent$lambda$1$0$$inlined$items$default$4
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3, Object p4) {
                    invoke((LazyItemScope) p1, ((Number) p2).intValue(), (Composer) p3, ((Number) p4).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, int it2, Composer $composer, int $changed) {
                    ComposerKt.sourceInformation($composer, "CN(it)178@8834L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it2) ? 32 : 16;
                    }
                    if (!$composer.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(802480018, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                    }
                    $composer.startReplaceGroup(-423257994);
                    ComposerKt.sourceInformation($composer, "CN(it)*288@10188L186:IMSessionPage.kt#yqxgzx");
                    IMConversation_androidKt.IMConversation((IMSessionCard) items$iv.get(it2), $swipeCancellingToken, $eventHandler, $composer, (($dirty & 14) >> 3) & 14);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
        if (!Intrinsics.areEqual($pageData.getPartialContentStatus(), IdleContent.INSTANCE)) {
            LazyListScope.-CC.item$default($this$LazyColumn, "content-status", (Object) null, ComposableLambdaKt.composableLambdaInstance(1218885710, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$6;
                    IMSessionPageContent$lambda$1$0$6 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$6(IMState.this, $pageState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$6;
                }
            }), 2, (Object) null);
        } else if (!Intrinsics.areEqual($pageData.getTailContentStatus(), IdleContent.INSTANCE)) {
            LazyListScope.-CC.item$default($this$LazyColumn, "foot-status", (Object) null, ComposableLambdaKt.composableLambdaInstance(906225797, true, new Function3() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda23
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit IMSessionPageContent$lambda$1$0$7;
                    IMSessionPageContent$lambda$1$0$7 = IMSessionPageKt.IMSessionPageContent$lambda$1$0$7(IMState.this, $pageState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return IMSessionPageContent$lambda$1$0$7;
                }
            }), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$0(IMState $pageData, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C254@9224L45:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2134041065, $changed, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:254)");
            }
            IMListStatusKt.IMPageHeadStatus($pageData.getHeadStatus(), null, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$1$0(IMQuickLink $it, IMSessionEventHandler $eventHandler, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C261@9432L57:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-673018476, $changed, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:261)");
            }
            IMQuickLinkKt.QuickLinkRow($it, $eventHandler, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$2(String $hint, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C269@9685L18:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1053881231, $changed, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:269)");
            }
            CustomerHint($hint, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$3(IMSessionPageData $page, IMSessionEventHandler $eventHandler, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C276@9870L64:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2084009707, $changed, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:276)");
            }
            IMSessionFilterTabs($page, $eventHandler.getActionHandler(), $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object IMSessionPageContent$lambda$1$0$4(IMSessionCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return IMSessionCardKt.getStringId(it.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$6(IMState $pageData, IMSessionPageState $pageState, LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C298@10519L243:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed($this$item) ? 4 : 2;
        }
        if ($composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1218885710, $dirty, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:298)");
            }
            Modifier modifier$iv = LazyItemScope.-CC.fillParentMaxHeight$default($this$item, Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 596521887, "C299@10588L156:IMSessionPage.kt#yqxgzx");
            ContentStatus state$iv = $pageData.getPartialContentStatus();
            final Function0 onRefresh$iv = new IMSessionPageKt$IMSessionPageContent$2$1$7$1$1($pageState);
            ComposerKt.sourceInformationMarkerStart($composer, 1569220625, "CC(IMModuleStatus)N(state,emptyText,onRefresh)23@642L50,26@746L502:IMModuleStatus.kt#uu6lp7");
            String emptyText$iv = StringResourcesKt.stringResource(String0_commonMainKt.getCommon_global_string_66(Res.string.INSTANCE), $composer, 0);
            Modifier modifier$iv$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(40), (float) CropImageView.DEFAULT_ASPECT_RATIO, (float) CropImageView.DEFAULT_ASPECT_RATIO, 13, (Object) null);
            Alignment contentAlignment$iv$iv = Alignment.Companion.getTopCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv$iv, false);
            int $changed$iv$iv$iv2 = (54 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
            Function0 factory$iv$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv$iv = (($changed$iv$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv$iv);
            } else {
                factory$iv$iv$iv$iv = factory$iv$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, localMap$iv$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv$iv, materialized$iv$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i4 = ($changed$iv$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i5 = ((54 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1719516304, "C:IMModuleStatus.kt#uu6lp7");
            if (Intrinsics.areEqual(state$iv, IdleContent.INSTANCE)) {
                $composer.startReplaceGroup(1719548233);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual(state$iv, LoadingContent.INSTANCE)) {
                $composer.startReplaceGroup(1719582240);
                ComposerKt.sourceInformation($composer, "36@1019L11");
                IMStatusKt.IMLoading(null, $composer, 0, 1);
                $composer.endReplaceGroup();
            } else if (state$iv instanceof ErrorContent) {
                $composer.startReplaceGroup(1719658407);
                ComposerKt.sourceInformation($composer, "40@1095L36");
                IMStatusKt.IMError(null, false, new Function0<Unit>() { // from class: im.session.common.IMSessionPageKt$IMSessionPageContent$lambda$1$0$6$0$$inlined$IMModuleStatus$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3280invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: collision with other method in class */
                    public final void m3280invoke() {
                        onRefresh$iv.invoke();
                    }
                }, $composer, 0, 3);
                $composer.endReplaceGroup();
            } else if (Intrinsics.areEqual(state$iv, EmptyContent.INSTANCE)) {
                $composer.startReplaceGroup(1719755282);
                ComposerKt.sourceInformation($composer, "44@1193L25");
                IMStatusKt.IMEmpty(null, emptyText$iv, $composer, 0 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW, 1);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-775815725);
                $composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
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
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageContent$lambda$1$0$7(IMState $pageData, IMSessionPageState $pageState, LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C309@11001L22,307@10897L145:IMSessionPage.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(906225797, $changed, -1, "im.session.common.IMSessionPageContent.<anonymous>.<anonymous>.<anonymous> (IMSessionPage.kt:307)");
            }
            ContentStatus tailContentStatus = $pageData.getTailContentStatus();
            ComposerKt.sourceInformationMarkerStart($composer, -995366245, "CC(remember):IMSessionPage.kt#9igjgp");
            boolean invalid$iv = $composer.changed($pageState);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = (KFunction) new IMSessionPageKt$IMSessionPageContent$2$1$8$1$1($pageState);
                $composer.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            IMListStatusKt.IMPageFootStatus(tailContentStatus, null, (KFunction) it$iv, $composer, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void IMSessionFilterTabs(final IMSessionPageData page, final IMSessionActionHandler onAction, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(453816977);
        ComposerKt.sourceInformation($composer2, "C(IMSessionFilterTabs)N(page,onAction)326@11387L21,321@11196L432:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(page) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(453816977, $dirty, -1, "im.session.common.IMSessionFilterTabs (IMSessionPage.kt:320)");
            }
            Modifier modifier$iv = ScrollKt.horizontalScroll$default(PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(6), Dp.constructor-impl(12), Dp.constructor-impl(6)), ScrollKt.rememberScrollState(0, $composer2, 0, 1), false, (FlingBehavior) null, false, 14, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv << 6;
            int $changed$iv$iv$iv = ($i$f$Row & 896) | 6;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 484966719, "C:IMSessionPage.kt#yqxgzx");
            $composer2.startReplaceGroup(431286487);
            ComposerKt.sourceInformation($composer2, "*331@11578L34");
            Iterable $this$forEach$iv = page.getFilters();
            boolean z = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                IMSessionFilter it = (IMSessionFilter) element$iv;
                boolean z2 = z;
                int $i$f$forEach = $dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                FilterTab(it, onAction, $composer2, $i$f$forEach);
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
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
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda24
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionFilterTabs$lambda$1;
                    IMSessionFilterTabs$lambda$1 = IMSessionPageKt.IMSessionFilterTabs$lambda$1(IMSessionPageData.this, onAction, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionFilterTabs$lambda$1;
                }
            });
        }
    }

    private static final void FilterTab(final IMSessionFilter tab, final IMSessionActionHandler onAction, Composer $composer, final int $changed) {
        long background;
        long textColor;
        TextStyle textStyle;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-347114491);
        ComposerKt.sourceInformation($composer2, "C(FilterTab)N(tab,onAction)366@12391L91,360@12195L567:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(tab) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 32 : 16;
        }
        boolean z = true;
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-347114491, $dirty, -1, "im.session.common.FilterTab (IMSessionPage.kt:340)");
            }
            if (tab.isSelected()) {
                $composer2.startReplaceGroup(1393580069);
                ComposerKt.sourceInformation($composer2, "343@11808L6");
                background = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU();
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(1393641108);
                $composer2.endReplaceGroup();
                background = Color.Companion.getTransparent-0d7_KjU();
            }
            if (tab.isSelected()) {
                $composer2.startReplaceGroup(1393730698);
                ComposerKt.sourceInformation($composer2, "349@11960L6");
                long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer2.endReplaceGroup();
                textColor = j;
            } else {
                $composer2.startReplaceGroup(1393787087);
                ComposerKt.sourceInformation($composer2, "351@12017L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU();
                $composer2.endReplaceGroup();
                textColor = j2;
            }
            if (tab.isSelected()) {
                $composer2.startReplaceGroup(1393881389);
                ComposerKt.sourceInformation($composer2, "355@12112L9");
                TextStyle t13b = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13b();
                $composer2.endReplaceGroup();
                textStyle = t13b;
            } else {
                $composer2.startReplaceGroup(1393934926);
                ComposerKt.sourceInformation($composer2, "357@12166L9");
                TextStyle t13 = BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT13();
                $composer2.endReplaceGroup();
                textStyle = t13;
            }
            Modifier modifier = BackgroundKt.background-bw27NRU(Modifier.Companion, background, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4)));
            ComposerKt.sourceInformationMarkerStart($composer2, 1430446976, "CC(remember):IMSessionPage.kt#9igjgp");
            if (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) != 32 && (($dirty & 64) == 0 || !$composer2.changedInstance(onAction))) {
                z = false;
            }
            boolean invalid$iv = $composer2.changedInstance(tab) | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        Unit FilterTab$lambda$0$0;
                        FilterTab$lambda$0$0 = IMSessionPageKt.FilterTab$lambda$0$0(IMSessionActionHandler.this, tab);
                        return FilterTab$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(8), Dp.constructor-impl((float) 6.5d));
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1001495470, "C374@12650L106:IMSessionPage.kt#yqxgzx");
            TextKt.Text-Nvy7gAk(tab.getName(), (Modifier) null, textColor, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, textStyle, $composer2, 0, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit FilterTab$lambda$2;
                    FilterTab$lambda$2 = IMSessionPageKt.FilterTab$lambda$2(IMSessionFilter.this, onAction, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return FilterTab$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterTab$lambda$0$0(IMSessionActionHandler $onAction, IMSessionFilter $tab) {
        $onAction.invoke(new IMActionChangeFilter($tab.getType()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x034e, code lost:
        if (r14 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0402, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void IMSessionPageActions(final IMSessionPageData data, final IMSessionPageState pageState, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(106909011);
        ComposerKt.sourceInformation($composer3, "C(IMSessionPageActions)N(data,pageState)387@12884L1572:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(pageState) ? 32 : 16;
        }
        if ($composer3.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(106909011, $dirty, -1, "im.session.common.IMSessionPageActions (IMSessionPage.kt:386)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1124609353, "C:IMSessionPage.kt#yqxgzx");
            $composer3.startReplaceGroup(1144655793);
            ComposerKt.sourceInformation($composer3, "*396@13201L34");
            Iterable $this$forEach$iv = data.getOutsideActions();
            boolean z = false;
            for (Object element$iv : $this$forEach$iv) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                IMThreeDotItem it = (IMThreeDotItem) element$iv;
                boolean z2 = z;
                int $i$f$forEach = $dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                IMSessionIconAction(it, pageState, $composer3, $i$f$forEach);
                $this$forEach$iv = $this$forEach$iv2;
                z = z2;
            }
            $composer3.endReplaceGroup();
            if (data.getThreeDots().isEmpty()) {
                $composer$iv$iv = $composer3;
                $composer$iv = $composer3;
                $composer3.startReplaceGroup(1111514611);
            } else {
                $composer3.startReplaceGroup(1124733321);
                ComposerKt.sourceInformation($composer3, "400@13302L1138");
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.Companion;
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                $composer$iv = $composer3;
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
                $composer$iv$iv = $composer3;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i5 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                BoxScope $this$IMSessionPageActions_u24lambda_u240_u241 = boxScope;
                ComposerKt.sourceInformationMarkerStart($composer3, -1363954425, "C402@13373L22,403@13442L7,407@13605L48,401@13324L396:IMSessionPage.kt#yqxgzx");
                Painter more_vertical_fill_500 = BiliIconfont.INSTANCE.getMore_vertical_fill_500($composer3, 6);
                CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                long j = ((Color) consume).unbox-impl();
                Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart($composer3, 2034219390, "CC(remember):IMSessionPage.kt#9igjgp");
                boolean invalid$iv = (($dirty & 14) == 4) | (($dirty & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit IMSessionPageActions$lambda$0$1$0$0;
                        IMSessionPageActions$lambda$0$1$0$0 = IMSessionPageKt.IMSessionPageActions$lambda$0$1$0$0(IMSessionPageState.this, data);
                        return IMSessionPageActions$lambda$0$1$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                IconKt.Icon-ww6aTOc(more_vertical_fill_500, (String) null, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, $composer3, Painter.$stable | 48, 0);
                if (data.getHasThreeDotsRedDot()) {
                    $composer3.startReplaceGroup(-1363529664);
                    ComposerKt.sourceInformation($composer3, "411@13819L7,417@14095L38,418@14206L6,420@14346L6,412@13877L531");
                    CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer3.consume(this_$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density $this$IMSessionPageActions_u24lambda_u240_u241_u241 = (Density) consume2;
                    final int offset = MathKt.roundToInt($this$IMSessionPageActions_u24lambda_u240_u241_u241.toPx-0680j_4(Dp.constructor-impl(2)));
                    Modifier align = $this$IMSessionPageActions_u24lambda_u240_u241.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), Alignment.Companion.getTopEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 2034235060, "CC(remember):IMSessionPage.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changed(offset);
                    Object value$iv2 = $composer3.rememberedValue();
                    if (invalid$iv2) {
                    }
                    value$iv2 = new Function1() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            IntOffset IMSessionPageActions$lambda$0$1$2$0;
                            IMSessionPageActions$lambda$0$1$2$0 = IMSessionPageKt.IMSessionPageActions$lambda$0$1$2$0(offset, (Density) obj);
                            return IMSessionPageActions$lambda$0$1$2$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    BoxKt.Box(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(BorderKt.border-xT4_qwU(OffsetKt.offset(align, (Function1) value$iv2), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getStress_red-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer3, 0);
                } else {
                    $composer3.startReplaceGroup(-1377206988);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionPageActions$lambda$1;
                    IMSessionPageActions$lambda$1 = IMSessionPageKt.IMSessionPageActions$lambda$1(IMSessionPageData.this, pageState, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionPageActions$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionPageActions$lambda$0$1$0$0(IMSessionPageState $pageState, IMSessionPageData $data) {
        $pageState.showMoreActionMenu($data.getThreeDots());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset IMSessionPageActions$lambda$0$1$2$0(int $offset, Density $this$offset) {
        Intrinsics.checkNotNullParameter($this$offset, "$this$offset");
        int y$iv = -$offset;
        return IntOffset.box-impl(IntOffset.constructor-impl(($offset << 32) | (y$iv & 4294967295L)));
    }

    private static final void IMSessionIconAction(final IMThreeDotItem action, final IMSessionPageState pageState, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(492088765);
        ComposerKt.sourceInformation($composer3, "C(IMSessionIconAction)N(action,pageState)433@14588L24,442@14866L138,434@14617L394:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(action) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(pageState) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(492088765, $dirty2, -1, "im.session.common.IMSessionIconAction (IMSessionPage.kt:432)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer3, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer3.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3);
                $composer3.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.startReplaceGroup(450906783);
            ComposerKt.sourceInformation($composer3, "*437@14745L7");
            String $this$asRequest$iv = action.getIcon();
            ImageRequest $this$IMSessionIconAction_u24lambda_u240 = new ImageRequest($this$asRequest$iv);
            ColorFilter.Companion companion = ColorFilter.Companion;
            CompositionLocal this_$iv = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer3.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $this$IMSessionIconAction_u24lambda_u240.colorFilter(ColorFilter.Companion.tint-xETnrds$default(companion, ((Color) consume).unbox-impl(), 0, 2, (Object) null));
            ImmutableImageRequest build = $this$IMSessionIconAction_u24lambda_u240.build();
            $composer3.endReplaceGroup();
            Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
            ComposerKt.sourceInformationMarkerStart($composer3, 450913095, "CC(remember):IMSessionPage.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(scope) | (($dirty2 & 14) == 4) | (($dirty2 & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) == 32);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit IMSessionIconAction$lambda$1$0;
                        IMSessionIconAction$lambda$1$0 = IMSessionPageKt.IMSessionIconAction$lambda$1$0(scope, action, pageState);
                        return IMSessionIconAction$lambda$1$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            BiliImageKt.BiliImage(build, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer3, 0, (int) TbsListener.ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMSessionIconAction$lambda$2;
                    IMSessionIconAction$lambda$2 = IMSessionPageKt.IMSessionIconAction$lambda$2(IMThreeDotItem.this, pageState, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMSessionIconAction$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMSessionIconAction$lambda$1$0(CoroutineScope $scope, IMThreeDotItem $action, IMSessionPageState $pageState) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMSessionPageKt$IMSessionIconAction$2$1$1($action, $pageState, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final StringResource rememberTitle(KSessionPageType $this$rememberTitle, Composer $composer, int $changed) {
        Object im_global_string_66;
        Intrinsics.checkNotNullParameter($this$rememberTitle, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 1039120948, "C(rememberTitle)452@15095L863:IMSessionPage.kt#yqxgzx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1039120948, $changed, -1, "im.session.common.rememberTitle (IMSessionPage.kt:452)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -2132146189, "CC(remember):IMSessionPage.kt#9igjgp");
        boolean invalid$iv = $composer.changed($this$rememberTitle);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_AI.INSTANCE)) {
                im_global_string_66 = String1_commonMainKt.getIm_global_string_844(Res.string.INSTANCE);
            } else if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_DUSTBIN.INSTANCE)) {
                im_global_string_66 = bili.resource.im.String0_commonMainKt.getIm_global_string_143(Res.string.INSTANCE);
            } else if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_GROUP.INSTANCE)) {
                im_global_string_66 = bili.resource.im.String0_commonMainKt.getIm_global_string_542(Res.string.INSTANCE);
            } else if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_HUA_HUO.INSTANCE)) {
                im_global_string_66 = String1_commonMainKt.getIm_global_string_870(Res.string.INSTANCE);
            } else if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_STRANGER.INSTANCE)) {
                im_global_string_66 = bili.resource.im.String0_commonMainKt.getIm_global_string_128(Res.string.INSTANCE);
            } else if (Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_UNFOLLOWED.INSTANCE)) {
                im_global_string_66 = bili.resource.im.String0_commonMainKt.getIm_global_string_495(Res.string.INSTANCE);
            } else if (!Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_UNKNOWN.INSTANCE) && !Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE) && !Intrinsics.areEqual($this$rememberTitle, KSessionPageType.SESSION_PAGE_TYPE_CUSTOMER.INSTANCE) && !($this$rememberTitle instanceof KSessionPageType.UNRECOGNIZED)) {
                throw new NoWhenBranchMatchedException();
            } else {
                im_global_string_66 = bili.resource.im.String0_commonMainKt.getIm_global_string_66(Res.string.INSTANCE);
            }
            Object value$iv = im_global_string_66;
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        StringResource stringResource = (StringResource) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringResource;
    }

    private static final void CustomerHint(final String title, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-796163044);
        ComposerKt.sourceInformation($composer3, "C(CustomerHint)N(title)476@16240L6,470@16018L890:IMSessionPage.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 3) != 2, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-796163044, $dirty2, -1, "im.session.common.CustomerHint (IMSessionPage.kt:469)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(BackgroundKt.background-bw27NRU(PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(12), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(10), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(8), Dp.constructor-impl(4));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            int $changed$iv$iv = (432 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
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
            int i2 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i3 = ((432 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1229990165, "C482@16527L25,483@16583L6,481@16486L204,490@16762L6,491@16806L9,488@16700L202:IMSessionPage.kt#yqxgzx");
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getInfo_help_circle_line_500($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer3, $dirty2 & 14, 24960, 110586);
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
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMSessionPageKt$$ExternalSyntheticLambda17
                public final Object invoke(Object obj, Object obj2) {
                    Unit CustomerHint$lambda$1;
                    CustomerHint$lambda$1 = IMSessionPageKt.CustomerHint$lambda$1(title, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return CustomerHint$lambda$1;
                }
            });
        }
    }
}