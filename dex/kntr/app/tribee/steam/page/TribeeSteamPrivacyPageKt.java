package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KLinkUrl;
import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountAbnormal;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Collection;
import java.util.Iterator;
import kntr.app.tribee.steam.state.TribeeSteamState;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.compose.res.CommonRes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.common.compose.res.generated.resources.Drawable0_commonMainKt;

/* compiled from: TribeeSteamPrivacyPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0093\u0001\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"TribeeSteamPrivacyPage", "", "page", "Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButPrivacyState;", "modifier", "Landroidx/compose/ui/Modifier;", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "onUIAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "(Lkntr/app/tribee/steam/state/TribeeSteamState$HasBoundButPrivacyState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamPrivacyContent", "picUrl", "", "text", "desc", "buttonString", "buttonUrl", "linkString", "linkUrl", "isUpdating", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;III)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamPrivacyPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyContent$lambda$3(Modifier modifier, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, Function1 function1, Function1 function12, int i, int i2, int i3, Composer composer, int i4) {
        TribeeSteamPrivacyContent(modifier, str, str2, str3, str4, str5, str6, str7, z, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyPage$lambda$3(TribeeSteamState.HasBoundButPrivacyState hasBoundButPrivacyState, Modifier modifier, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamPrivacyPage(hasBoundButPrivacyState, modifier, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyPage$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyPage$lambda$1$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04d4  */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSteamPrivacyPage(final TribeeSteamState.HasBoundButPrivacyState page, Modifier modifier, Function1<? super TribeeSteamStateAction, Unit> function1, Function1<? super TribeeSteamUIAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function1 function13;
        Function1 onUIAction;
        Composer $composer2;
        Modifier modifier3;
        Function1 onStateAction;
        Modifier modifier4;
        Function1 onStateAction2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        boolean z;
        boolean z2;
        String jumpUrl;
        String showWord;
        String desc;
        String title;
        String picUrl;
        Intrinsics.checkNotNullParameter(page, "page");
        Composer $composer3 = $composer.startRestartGroup(1230111575);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamPrivacyPage)N(page,modifier,onStateAction,onUIAction)48@2161L2,49@2213L2,64@2804L6,60@2690L1288:TribeeSteamPrivacyPage.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(page) ? 4 : 2;
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
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            function13 = function1;
        } else if (($changed & 384) == 0) {
            function13 = function1;
            $dirty |= $composer3.changedInstance(function13) ? 256 : 128;
        } else {
            function13 = function1;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            onUIAction = function12;
        } else if (($changed & 3072) == 0) {
            onUIAction = function12;
            $dirty |= $composer3.changedInstance(onUIAction) ? 2048 : 1024;
        } else {
            onUIAction = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onStateAction = function13;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1021222585, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamPrivacyPage$lambda$0$0;
                            TribeeSteamPrivacyPage$lambda$0$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyPage$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamPrivacyPage$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onStateAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onStateAction2 = function13;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, 1021224249, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamPrivacyPage$lambda$1$0;
                            TribeeSteamPrivacyPage$lambda$1$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyPage$lambda$1$0((TribeeSteamUIAction) obj);
                            return TribeeSteamPrivacyPage$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onUIAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onUIAction = onUIAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1230111575, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamPrivacyPage (TribeeSteamPrivacyPage.kt:50)");
            }
            KTribeeSteamHomeBindAccountAbnormal data = page.getData();
            KTipsCard fail = data.getFail();
            String picUrl2 = (fail == null || (picUrl = fail.getPicUrl()) == null) ? "" : picUrl;
            KTipsCard fail2 = data.getFail();
            String text = (fail2 == null || (title = fail2.getTitle()) == null) ? "" : title;
            KTipsCard fail3 = data.getFail();
            String desc2 = (fail3 == null || (desc = fail3.getDesc()) == null) ? "" : desc;
            KTipsCard fail4 = data.getFail();
            String confirmText = fail4 != null ? fail4.getConfirmText() : null;
            String buttonString = confirmText == null ? "" : confirmText;
            KTipsCard fail5 = data.getFail();
            String confirmTextJumpUrl = fail5 != null ? fail5.getConfirmTextJumpUrl() : null;
            String buttonUrl = confirmTextJumpUrl == null ? "" : confirmTextJumpUrl;
            KLinkUrl steamPrivateRule = data.getSteamPrivateRule();
            String linkString = (steamPrivateRule == null || (showWord = steamPrivateRule.getShowWord()) == null) ? "" : showWord;
            KLinkUrl steamPrivateRule2 = data.getSteamPrivateRule();
            String linkUrl = (steamPrivateRule2 == null || (jumpUrl = steamPrivateRule2.getJumpUrl()) == null) ? "" : jumpUrl;
            Modifier modifier$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            modifier3 = modifier4;
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
            int $changed2 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamPrivacyPage_u24lambda_u242 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -294513400, "C67@2874L934,92@3818L154:TribeeSteamPrivacyPage.kt#k3l5ii");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            $composer2 = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv2 = (438 << 3) & 112;
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
            int i7 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -563962386, "C72@3068L170,77@3251L547:TribeeSteamPrivacyPage.kt#k3l5ii");
            TribeeSteamNavigationKt.TribeeSteamNavigation(null, 0.0f, false, false, null, data.getThreeDot(), onUIAction, onStateAction2, $composer3, (($dirty2 << 9) & 3670016) | (($dirty2 << 15) & 29360128), 31);
            Modifier modifier5 = OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(90), 1, (Object) null);
            Iterable requestingActions = page.getRequestingActions();
            if (requestingActions != null) {
                Iterable $this$any$iv = requestingActions;
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Object element$iv = it.next();
                            TribeeSteamStateAction it2 = (TribeeSteamStateAction) element$iv;
                            if (it2 instanceof TribeeSteamStateAction.LaunchPolling) {
                                z2 = true;
                                break;
                            }
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    z = true;
                    TribeeSteamPrivacyContent(modifier5, picUrl2, text, desc2, buttonString, buttonUrl, linkString, linkUrl, z, onStateAction2, onUIAction, $composer3, (($dirty2 << 21) & 1879048192) | 6, ($dirty2 >> 9) & 14, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TipsFootCardKt.showKTipsFootCard($this$TribeeSteamPrivacyPage_u24lambda_u242, page.getTipsFootCard(), onStateAction2, null, onUIAction, $composer3, ($changed2 & 14) | ($dirty2 & 896) | (57344 & ($dirty2 << 3)), 4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    onStateAction = onStateAction2;
                }
            }
            z = false;
            TribeeSteamPrivacyContent(modifier5, picUrl2, text, desc2, buttonString, buttonUrl, linkString, linkUrl, z, onStateAction2, onUIAction, $composer3, (($dirty2 << 21) & 1879048192) | 6, ($dirty2 >> 9) & 14, 0);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            TipsFootCardKt.showKTipsFootCard($this$TribeeSteamPrivacyPage_u24lambda_u242, page.getTipsFootCard(), onStateAction2, null, onUIAction, $composer3, ($changed2 & 14) | ($dirty2 & 896) | (57344 & ($dirty2 << 3)), 4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            onStateAction = onStateAction2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final Function1 function14 = onStateAction;
            final Function1 function15 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamPrivacyPage$lambda$3;
                    TribeeSteamPrivacyPage$lambda$3 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyPage$lambda$3(TribeeSteamState.HasBoundButPrivacyState.this, modifier6, function14, function15, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamPrivacyPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyContent$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyContent$lambda$1$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x0640  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x064c  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0652  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0756  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x099a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TribeeSteamPrivacyContent(Modifier modifier, String picUrl, String text, String desc, String buttonString, String buttonUrl, String linkString, String linkUrl, boolean isUpdating, Function1<? super TribeeSteamStateAction, Unit> function1, Function1<? super TribeeSteamUIAction, Unit> function12, Composer $composer, final int $changed, final int $changed1, final int i) {
        Composer $composer2;
        Modifier modifier2;
        String picUrl2;
        String text2;
        String desc2;
        String buttonString2;
        String buttonUrl2;
        String linkString2;
        String linkUrl2;
        boolean isUpdating2;
        Function1 onStateAction;
        Function1 onUIAction;
        Function1 onStateAction2;
        Function1 onUIAction2;
        Function0 factory$iv$iv$iv;
        Function0 value$iv;
        final Function1 onUIAction3;
        final Function1 onStateAction3;
        Function0 factory$iv$iv$iv2;
        Modifier rotationModifier;
        final String linkUrl3;
        Object value$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1400023622);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamPrivacyContent)N(modifier,picUrl,text,desc,buttonString,buttonUrl,linkString,linkUrl,isUpdating,onStateAction,onUIAction)111@4340L2,112@4392L2,114@4404L4694:TribeeSteamPrivacyPage.kt#k3l5ii");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(picUrl) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(text) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(desc) ? 2048 : 1024;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(buttonString) ? 16384 : 8192;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty |= $composer3.changed(buttonUrl) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer3.changed(linkString) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer3.changed(linkUrl) ? 8388608 : 4194304;
        }
        int i10 = i & 256;
        if (i10 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 100663296) == 0) {
            $dirty |= $composer3.changed(isUpdating) ? 67108864 : 33554432;
        }
        int i11 = i & 512;
        if (i11 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 805306368) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 536870912 : 268435456;
        }
        int i12 = i & 1024;
        if (i12 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 6) == 0) {
            $dirty1 |= $composer3.changedInstance(function12) ? 4 : 2;
        }
        if ($composer3.shouldExecute((($dirty & 306783379) == 306783378 && ($dirty1 & 3) == 2) ? false : true, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            String picUrl3 = i3 != 0 ? "" : picUrl;
            String text3 = i4 != 0 ? "" : text;
            String desc3 = i5 != 0 ? "" : desc;
            String buttonString3 = i6 != 0 ? "" : buttonString;
            final String buttonUrl3 = i7 != 0 ? "" : buttonUrl;
            linkString2 = i8 != 0 ? "" : linkString;
            String linkUrl4 = i9 != 0 ? "" : linkUrl;
            boolean isUpdating3 = i10 != 0 ? false : isUpdating;
            if (i11 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1097926276, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamPrivacyContent$lambda$0$0;
                            TribeeSteamPrivacyContent$lambda$0$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyContent$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamPrivacyContent$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv;
                }
                onStateAction2 = (Function1) value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onStateAction2 = function1;
            }
            if (i12 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1097924612, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamPrivacyContent$lambda$1$0;
                            TribeeSteamPrivacyContent$lambda$1$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyContent$lambda$1$0((TribeeSteamUIAction) obj);
                            return TribeeSteamPrivacyContent$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                    it$iv2 = value$iv3;
                }
                onUIAction2 = (Function1) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onUIAction2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1400023622, $dirty, $dirty1, "kntr.app.tribee.steam.page.TribeeSteamPrivacyContent (TribeeSteamPrivacyPage.kt:113)");
            }
            String linkUrl5 = linkUrl4;
            boolean isUpdating4 = isUpdating3;
            modifier2 = modifier3;
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(48), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            $composer2 = $composer3;
            buttonString2 = buttonString3;
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function1 onStateAction4 = onStateAction2;
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
            Function1 onUIAction4 = onUIAction2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i13 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i14 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -2021599117, "C145@5383L6,146@5427L9,143@5322L172,152@5565L6,153@5609L9,150@5504L171,164@5929L6,167@6084L39,169@6202L487,157@5685L2509:TribeeSteamPrivacyPage.kt#k3l5ii");
            if (StringsKt.isBlank(picUrl3)) {
                picUrl2 = picUrl3;
                $composer3.startReplaceGroup(-2021356884);
                ComposerKt.sourceInformation($composer3, "135@5085L53,134@5052L250");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_privacy(CommonRes.INSTANCE.getDrawable()), $composer3, 0), "privacy_image", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-2021700953);
                ComposerKt.sourceInformation($composer3, "123@4703L319");
                String $this$asRequest$iv = picUrl3;
                ImageRequest $this$TribeeSteamPrivacyContent_u24lambda_u242_u240 = new ImageRequest($this$asRequest$iv);
                picUrl2 = picUrl3;
                $this$TribeeSteamPrivacyContent_u24lambda_u242_u240.contentScale(ContentScale.Companion.getInside());
                BiliImageKt.BiliImage($this$TribeeSteamPrivacyContent_u24lambda_u242_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), "privacy_image", null, null, null, null, null, null, $composer3, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                $composer3.endReplaceGroup();
            }
            TextKt.Text-Nvy7gAk(text3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), $composer3, ($dirty >> 6) & 14, 0, 130042);
            TextKt.Text-Nvy7gAk(desc3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, ($dirty >> 9) & 14, 0, 130042);
            text2 = text3;
            String desc4 = desc3;
            Modifier modifier4 = BackgroundKt.background-bw27NRU(SizeKt.wrapContentWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(30)), (Alignment.Horizontal) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1312097813, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv4 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1312093589, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
            boolean invalid$iv = ((458752 & $dirty) == 131072) | (($dirty1 & 14) == 4) | ((1879048192 & $dirty) == 536870912);
            Object it$iv4 = $composer3.rememberedValue();
            if (!invalid$iv && it$iv4 != Composer.Companion.getEmpty()) {
                value$iv = it$iv4;
                onUIAction3 = onUIAction4;
                onStateAction3 = onStateAction4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, value$iv, 28, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                Function1 onStateAction5 = onStateAction3;
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv2 = (432 << 3) & 112;
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
                    $composer3.useNode();
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.createNode(factory$iv$iv$iv2);
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                int i15 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i16 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -1292165327, "C:TribeeSteamPrivacyPage.kt#k3l5ii");
                if (StringsKt.isBlank(buttonUrl3)) {
                    $composer3.startReplaceGroup(-1292151502);
                    ComposerKt.sourceInformation($composer3, "187@6985L6,188@7042L9,185@6900L304");
                    TextKt.Text-Nvy7gAk(buttonString2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(20), 0.0f, Dp.constructor-impl(20), 0.0f, 10, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, (($dirty >> 12) & 14) | 48, 0, 131064);
                    $composer3.endReplaceGroup();
                    buttonUrl2 = buttonUrl3;
                } else {
                    $composer3.startReplaceGroup(-1291809758);
                    ComposerKt.sourceInformation($composer3, "201@7515L22,203@7633L6,200@7466L383,212@7952L6,213@8009L9,210@7867L303");
                    if (isUpdating4) {
                        $composer3.startReplaceGroup(-1291760809);
                        ComposerKt.sourceInformation($composer3, "196@7336L18");
                        rotationModifier = TribeeSteamAccountInfoKt.infiniteRotation(Modifier.Companion, $composer3, 6);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-1291680705);
                        $composer3.endReplaceGroup();
                        rotationModifier = RotateKt.rotate(Modifier.Companion, 0.0f);
                    }
                    buttonUrl2 = buttonUrl3;
                    IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer3, 6), "refresh icon", SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(16)).then(rotationModifier), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                    TextKt.Text-Nvy7gAk(buttonString2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, Dp.constructor-impl(10), 0.0f, 10, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, (($dirty >> 12) & 14) | 48, 0, 131064);
                    $composer3.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (!StringsKt.isBlank(linkString2) || StringsKt.isBlank(linkUrl5)) {
                    linkUrl3 = linkUrl5;
                    $composer3.startReplaceGroup(-2026364066);
                } else {
                    $composer3.startReplaceGroup(-2018133101);
                    ComposerKt.sourceInformation($composer3, "224@8346L6,225@8398L9,231@8645L39,233@8771L269,222@8271L811");
                    long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_link-0d7_KjU();
                    TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
                    int i17 = TextAlign.Companion.getCenter-e0LSkKk();
                    Modifier modifier5 = PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(18), 0.0f, 0.0f, 13, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1312015861, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                    Object it$iv5 = $composer3.rememberedValue();
                    if (it$iv5 == Composer.Companion.getEmpty()) {
                        Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv5 = value$iv5;
                    }
                    MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv5;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1312011599, "CC(remember):TribeeSteamPrivacyPage.kt#9igjgp");
                    boolean invalid$iv2 = (($dirty1 & 14) == 4) | ((29360128 & $dirty) == 8388608);
                    Object it$iv6 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv6 == Composer.Companion.getEmpty()) {
                        linkUrl3 = linkUrl5;
                        Object value$iv6 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit TribeeSteamPrivacyContent$lambda$2$5$0;
                                TribeeSteamPrivacyContent$lambda$2$5$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyContent$lambda$2$5$0(onUIAction3, linkUrl3);
                                return TribeeSteamPrivacyContent$lambda$2$5$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv6 = value$iv6;
                    } else {
                        linkUrl3 = linkUrl5;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.Text-Nvy7gAk(linkString2, ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv6, 28, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i17), 0L, 0, false, 0, 0, (Function1) null, t14, $composer3, ($dirty >> 18) & 14, 0, 130040);
                }
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                isUpdating2 = isUpdating4;
                desc2 = desc4;
                onStateAction = onStateAction5;
                onUIAction = onUIAction3;
                linkUrl2 = linkUrl3;
            }
            onUIAction3 = onUIAction4;
            onStateAction3 = onStateAction4;
            value$iv = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit TribeeSteamPrivacyContent$lambda$2$2$0;
                    TribeeSteamPrivacyContent$lambda$2$2$0 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyContent$lambda$2$2$0(buttonUrl3, onUIAction3, onStateAction3);
                    return TribeeSteamPrivacyContent$lambda$2$2$0;
                }
            };
            $composer3.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv22 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, value$iv, 28, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            Function1 onStateAction52 = onStateAction3;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv22 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
            Function0 factory$iv$iv$iv42 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
            }
            Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
            int i152 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i162 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1292165327, "C:TribeeSteamPrivacyPage.kt#k3l5ii");
            if (StringsKt.isBlank(buttonUrl3)) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (StringsKt.isBlank(linkString2)) {
            }
            linkUrl3 = linkUrl5;
            $composer3.startReplaceGroup(-2026364066);
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
            }
            isUpdating2 = isUpdating4;
            desc2 = desc4;
            onStateAction = onStateAction52;
            onUIAction = onUIAction3;
            linkUrl2 = linkUrl3;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            picUrl2 = picUrl;
            text2 = text;
            desc2 = desc;
            buttonString2 = buttonString;
            buttonUrl2 = buttonUrl;
            linkString2 = linkString;
            linkUrl2 = linkUrl;
            isUpdating2 = isUpdating;
            onStateAction = function1;
            onUIAction = function12;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final String str = picUrl2;
            final String str2 = text2;
            final String str3 = desc2;
            final String str4 = buttonString2;
            final String str5 = buttonUrl2;
            final String str6 = linkString2;
            final String str7 = linkUrl2;
            final boolean z = isUpdating2;
            final Function1 function13 = onStateAction;
            final Function1 function14 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamPrivacyPageKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamPrivacyContent$lambda$3;
                    TribeeSteamPrivacyContent$lambda$3 = TribeeSteamPrivacyPageKt.TribeeSteamPrivacyContent$lambda$3(modifier6, str, str2, str3, str4, str5, str6, str7, z, function13, function14, $changed, $changed1, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamPrivacyContent$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyContent$lambda$2$2$0(String $buttonUrl, Function1 $onUIAction, Function1 $onStateAction) {
        if (!StringsKt.isBlank($buttonUrl)) {
            $onUIAction.invoke(new TribeeSteamUIAction.RouterTo($buttonUrl));
        } else {
            $onStateAction.invoke(new TribeeSteamStateAction.LaunchPolling(1));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamPrivacyContent$lambda$2$5$0(Function1 $onUIAction, String $linkUrl) {
        $onUIAction.invoke(new TribeeSteamUIAction.RouterTo($linkUrl));
        return Unit.INSTANCE;
    }
}