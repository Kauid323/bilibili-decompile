package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamNavigation.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ay\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"TribeeSteamNavigation", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollProgress", "", "showShareIcon", "", "showTopAvatar", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "threeDotInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "onStateAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Landroidx/compose/ui/Modifier;FZZLcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamNavigationKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$5(Modifier modifier, float f, boolean z, boolean z2, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KThreeDot kThreeDot, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamNavigation(modifier, f, z, z2, kTribeeSteamHomeUserInfo, kThreeDot, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x01d5, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0685, code lost:
        if (r11 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L107;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:167:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x057d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x05f7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x06ce  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x06f5  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0821  */
    /* JADX WARN: Type inference failed for: r14v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSteamNavigation(Modifier modifier, float scrollProgress, boolean showShareIcon, boolean showTopAvatar, KTribeeSteamHomeUserInfo userInfo, KThreeDot threeDotInfo, Function1<? super TribeeSteamUIAction, Unit> function1, Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        boolean z;
        KTribeeSteamHomeUserInfo userInfo2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        float scrollProgress2;
        boolean showShareIcon2;
        KThreeDot threeDotInfo2;
        Function1 onUIAction;
        Function1 onStateAction;
        boolean showTopAvatar2;
        Function1 onUIAction2;
        final Function1 onStateAction2;
        Function0 factory$iv$iv$iv;
        KTribeeSteamHomeUserInfo userInfo3;
        Object it$iv;
        Object it$iv2;
        Function0 factory$iv$iv$iv2;
        final Function1 onUIAction3;
        final KThreeDot threeDotInfo3;
        boolean z2;
        List item;
        Composer $composer3 = $composer.startRestartGroup(-828659097);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamNavigation)N(modifier,scrollProgress,showShareIcon,showTopAvatar,userInfo,threeDotInfo,onUIAction,onStateAction)42@1775L2,43@1833L2,46@1872L101,49@2025L7,51@2058L92,59@2238L6,56@2155L3113:TribeeSteamNavigation.kt#k3l5ii");
        int $dirty2 = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty2 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changed(modifier) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(scrollProgress) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
        } else if (($changed & 384) == 0) {
            $dirty2 |= $composer3.changed(showShareIcon) ? 256 : 128;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            z = showTopAvatar;
        } else if (($changed & 3072) == 0) {
            z = showTopAvatar;
            $dirty2 |= $composer3.changed(z) ? 2048 : 1024;
        } else {
            z = showTopAvatar;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            userInfo2 = userInfo;
        } else if (($changed & 24576) == 0) {
            userInfo2 = userInfo;
            $dirty2 |= $composer3.changedInstance(userInfo2) ? 16384 : 8192;
        } else {
            userInfo2 = userInfo;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changedInstance(threeDotInfo) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        int i9 = i & 128;
        if (i9 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 8388608 : 4194304;
        }
        if ($composer3.shouldExecute(($dirty2 & 4793491) != 4793490, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            float scrollProgress3 = i3 != 0 ? 0.0f : scrollProgress;
            boolean showShareIcon3 = i4 != 0 ? false : showShareIcon;
            boolean showTopAvatar3 = i5 != 0 ? false : z;
            KTribeeSteamHomeUserInfo userInfo4 = i6 != 0 ? null : userInfo2;
            KThreeDot threeDotInfo4 = i7 != 0 ? null : threeDotInfo;
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1772432887, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                Object it$iv3 = $composer3.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamNavigation$lambda$0$0;
                            TribeeSteamNavigation$lambda$0$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamNavigation$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv3 = value$iv;
                }
                onUIAction2 = (Function1) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onUIAction2 = function1;
            }
            if (i9 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1772431031, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                Object it$iv4 = $composer3.rememberedValue();
                if (it$iv4 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamNavigation$lambda$1$0;
                            TribeeSteamNavigation$lambda$1$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamNavigation$lambda$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv4 = value$iv2;
                }
                onStateAction2 = it$iv4;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            } else {
                onStateAction2 = function12;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-828659097, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamNavigation (TribeeSteamNavigation.kt:44)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -1772429684, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(threeDotInfo4);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv3 = Boolean.valueOf((threeDotInfo4 == null || threeDotInfo4.getItem().isEmpty()) ? false : true);
            $composer3.updateRememberedValue(value$iv3);
            it$iv5 = value$iv3;
            boolean showMenuIcon = ((Boolean) it$iv5).booleanValue();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer3, LocalOnBackPressedDispatcher.$stable);
            ComposerKt.sourceInformationMarkerStart($composer3, -1772423741, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
            Object value$iv4 = $composer3.rememberedValue();
            if (value$iv4 == Composer.Companion.getEmpty()) {
                value$iv4 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit TribeeSteamNavigation$lambda$3$0;
                        TribeeSteamNavigation$lambda$3$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$3$0(backHandler);
                        return TribeeSteamNavigation$lambda$3$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            }
            final Function0 onBack = (Function0) value$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier4 = modifier3;
            float scrollProgress4 = scrollProgress3;
            Modifier modifier$iv = SizeKt.height-3ABfNKs(WindowInsetsPadding_androidKt.statusBarsPadding(SizeKt.fillMaxWidth$default(BackgroundKt.background-bw27NRU$default(modifier4, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), scrollProgress3, 0.0f, 0.0f, 0.0f, 14, (Object) null), (Shape) null, 2, (Object) null), 0.0f, 1, (Object) null)), Dp.constructor-impl(44));
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Function1 onUIAction4 = onUIAction2;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            KThreeDot threeDotInfo5 = threeDotInfo4;
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
            int i10 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i11 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeSteamNavigation_u24lambda_u244 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -1765332668, "C80@2944L24,86@3187L39,88@3305L64,92@3423L6,79@2903L589,96@3502L1760:TribeeSteamNavigation.kt#k3l5ii");
            if (showTopAvatar3) {
                if ((userInfo4 != null ? userInfo4.getFaceUrl() : null) != null) {
                    $composer3.startReplaceGroup(-1765359980);
                    ComposerKt.sourceInformation($composer3, "65@2458L425");
                    String $this$asRequest$iv = userInfo4.getFaceUrl();
                    showTopAvatar2 = showTopAvatar3;
                    ImageRequest $this$TribeeSteamNavigation_u24lambda_u244_u240 = new ImageRequest($this$asRequest$iv);
                    userInfo3 = userInfo4;
                    $this$TribeeSteamNavigation_u24lambda_u244_u240.contentScale(ContentScale.Companion.getCrop());
                    BiliImageKt.BiliImage($this$TribeeSteamNavigation_u24lambda_u244_u240.build(), $this$TribeeSteamNavigation_u24lambda_u244.align(ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), RoundedCornerShapeKt.getCircleShape()), Alignment.Companion.getCenter()), "user's avatar in top", null, null, null, null, null, null, $composer3, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                    $composer3.endReplaceGroup();
                    Painter arrow_back_left_line_500 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer3, 6);
                    Modifier modifier5 = PaddingKt.padding-3ABfNKs(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(48), Dp.constructor-impl(44)), Dp.constructor-impl(10));
                    ComposerKt.sourceInformationMarkerStart($composer3, -1996586380, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                    it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv5 = InteractionSourceKt.MutableInteractionSource();
                        $composer3.updateRememberedValue(value$iv5);
                        it$iv = value$iv5;
                    }
                    MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerStart($composer3, -1996582579, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                    it$iv2 = $composer3.rememberedValue();
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        Object value$iv6 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda3
                            public final Object invoke() {
                                Unit TribeeSteamNavigation$lambda$4$2$0;
                                TribeeSteamNavigation$lambda$4$2$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$4$2$0(onBack);
                                return TribeeSteamNavigation$lambda$4$2$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                        it$iv2 = value$iv6;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    IconKt.Icon-ww6aTOc(arrow_back_left_line_500, "back icon", ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                    Modifier modifier$iv2 = $this$TribeeSteamNavigation_u24lambda_u244.align(Modifier.Companion, Alignment.Companion.getCenterEnd());
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
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
                    int i12 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i13 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1128795893, "C:TribeeSteamNavigation.kt#k3l5ii");
                    if (showShareIcon3) {
                        showShareIcon2 = showShareIcon3;
                        $composer3.startReplaceGroup(1125181137);
                    } else {
                        $composer3.startReplaceGroup(1128804293);
                        ComposerKt.sourceInformation($composer3, "101@3677L20,107@3964L39,109@4098L122,113@4290L6,100@3628L748");
                        Painter arrow_share_line_500 = BiliIconfont.INSTANCE.getArrow_share_line_500($composer3, 6);
                        showShareIcon2 = showShareIcon3;
                        Modifier modifier6 = PaddingKt.padding-3ABfNKs(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(44), Dp.constructor-impl(44)), Dp.constructor-impl(10));
                        ComposerKt.sourceInformationMarkerStart($composer3, -656313576, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                        Object it$iv6 = $composer3.rememberedValue();
                        if (it$iv6 == Composer.Companion.getEmpty()) {
                            Object value$iv7 = InteractionSourceKt.MutableInteractionSource();
                            $composer3.updateRememberedValue(value$iv7);
                            it$iv6 = value$iv7;
                        }
                        MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) it$iv6;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, -656309205, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                        boolean invalid$iv2 = (29360128 & $dirty2) == 8388608;
                        Object it$iv7 = $composer3.rememberedValue();
                        if (invalid$iv2) {
                        }
                        Object value$iv8 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda4
                            public final Object invoke() {
                                Unit TribeeSteamNavigation$lambda$4$3$1$0;
                                TribeeSteamNavigation$lambda$4$3$1$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$4$3$1$0(onStateAction2);
                                return TribeeSteamNavigation$lambda$4$3$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                        it$iv7 = value$iv8;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        IconKt.Icon-ww6aTOc(arrow_share_line_500, "share icon", ClickableKt.clickable-O2vRcR0$default(modifier6, mutableInteractionSource2, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv7, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                    }
                    $composer3.endReplaceGroup();
                    if (showMenuIcon) {
                        if (threeDotInfo5 != null && (item = threeDotInfo5.getItem()) != null) {
                            if (!item.isEmpty()) {
                                z2 = true;
                                if (z2) {
                                    $composer3.startReplaceGroup(1129653631);
                                    ComposerKt.sourceInformation($composer3, "120@4533L22,126@4822L39,128@4956L127,132@5153L6,119@4484L754");
                                    Painter more_vertical_fill_500 = BiliIconfont.INSTANCE.getMore_vertical_fill_500($composer3, 6);
                                    onStateAction = onStateAction2;
                                    Modifier modifier7 = PaddingKt.padding-3ABfNKs(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(44), Dp.constructor-impl(44)), Dp.constructor-impl(10));
                                    ComposerKt.sourceInformationMarkerStart($composer3, -656286120, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                                    Object it$iv8 = $composer3.rememberedValue();
                                    if (it$iv8 == Composer.Companion.getEmpty()) {
                                        Object value$iv9 = InteractionSourceKt.MutableInteractionSource();
                                        $composer3.updateRememberedValue(value$iv9);
                                        it$iv8 = value$iv9;
                                    }
                                    MutableInteractionSource mutableInteractionSource3 = (MutableInteractionSource) it$iv8;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    ComposerKt.sourceInformationMarkerStart($composer3, -656281744, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
                                    $composer2 = $composer3;
                                    threeDotInfo3 = threeDotInfo5;
                                    boolean invalid$iv3 = ((3670016 & $dirty2) == 1048576) | $composer2.changedInstance(threeDotInfo3);
                                    Object it$iv9 = $composer3.rememberedValue();
                                    if (invalid$iv3) {
                                        $dirty = $dirty2;
                                    } else {
                                        $dirty = $dirty2;
                                        if (it$iv9 != Composer.Companion.getEmpty()) {
                                            onUIAction3 = onUIAction4;
                                            ComposerKt.sourceInformationMarkerEnd($composer3);
                                            IconKt.Icon-ww6aTOc(more_vertical_fill_500, "menu icon", ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource3, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv9, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                                            $composer3.endReplaceGroup();
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
                                            scrollProgress2 = scrollProgress4;
                                            threeDotInfo2 = threeDotInfo3;
                                            onUIAction = onUIAction3;
                                            userInfo2 = userInfo3;
                                        }
                                    }
                                    onUIAction3 = onUIAction4;
                                    Object value$iv10 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda5
                                        public final Object invoke() {
                                            Unit TribeeSteamNavigation$lambda$4$3$3$0;
                                            TribeeSteamNavigation$lambda$4$3$3$0 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$4$3$3$0(onUIAction3, threeDotInfo3);
                                            return TribeeSteamNavigation$lambda$4$3$3$0;
                                        }
                                    };
                                    $composer3.updateRememberedValue(value$iv10);
                                    it$iv9 = value$iv10;
                                    ComposerKt.sourceInformationMarkerEnd($composer3);
                                    IconKt.Icon-ww6aTOc(more_vertical_fill_500, "menu icon", ClickableKt.clickable-O2vRcR0$default(modifier7, mutableInteractionSource3, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv9, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                                    $composer3.endReplaceGroup();
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
                                    }
                                    modifier2 = modifier4;
                                    scrollProgress2 = scrollProgress4;
                                    threeDotInfo2 = threeDotInfo3;
                                    onUIAction = onUIAction3;
                                    userInfo2 = userInfo3;
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                    onStateAction = onStateAction2;
                    $dirty = $dirty2;
                    onUIAction3 = onUIAction4;
                    $composer2 = $composer3;
                    threeDotInfo3 = threeDotInfo5;
                    $composer3.startReplaceGroup(1125181137);
                    $composer3.endReplaceGroup();
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
                    }
                    modifier2 = modifier4;
                    scrollProgress2 = scrollProgress4;
                    threeDotInfo2 = threeDotInfo3;
                    onUIAction = onUIAction3;
                    userInfo2 = userInfo3;
                }
            }
            showTopAvatar2 = showTopAvatar3;
            userInfo3 = userInfo4;
            $composer3.startReplaceGroup(-1767799339);
            $composer3.endReplaceGroup();
            Painter arrow_back_left_line_5002 = BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer3, 6);
            Modifier modifier52 = PaddingKt.padding-3ABfNKs(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(48), Dp.constructor-impl(44)), Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, -1996586380, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
            it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
            }
            MutableInteractionSource mutableInteractionSource4 = (MutableInteractionSource) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1996582579, "CC(remember):TribeeSteamNavigation.kt#9igjgp");
            it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            IconKt.Icon-ww6aTOc(arrow_back_left_line_5002, "back icon", ClickableKt.clickable-O2vRcR0$default(modifier52, mutableInteractionSource4, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv2, 28, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
            Modifier modifier$iv22 = $this$TribeeSteamNavigation_u24lambda_u244.align(Modifier.Companion, Alignment.Companion.getCenterEnd());
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv22 = (0 << 3) & 112;
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
            int i122 = ($changed$iv$iv$iv22 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope2 = RowScopeInstance.INSTANCE;
            int i132 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1128795893, "C:TribeeSteamNavigation.kt#k3l5ii");
            if (showShareIcon3) {
            }
            $composer3.endReplaceGroup();
            if (showMenuIcon) {
            }
            onStateAction = onStateAction2;
            $dirty = $dirty2;
            onUIAction3 = onUIAction4;
            $composer2 = $composer3;
            threeDotInfo3 = threeDotInfo5;
            $composer3.startReplaceGroup(1125181137);
            $composer3.endReplaceGroup();
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
            }
            modifier2 = modifier4;
            scrollProgress2 = scrollProgress4;
            threeDotInfo2 = threeDotInfo3;
            onUIAction = onUIAction3;
            userInfo2 = userInfo3;
        } else {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            scrollProgress2 = scrollProgress;
            showShareIcon2 = showShareIcon;
            threeDotInfo2 = threeDotInfo;
            onUIAction = function1;
            onStateAction = function12;
            showTopAvatar2 = z;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier2;
            final float f = scrollProgress2;
            final boolean z3 = showShareIcon2;
            final boolean z4 = showTopAvatar2;
            final KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo = userInfo2;
            final KThreeDot kThreeDot = threeDotInfo2;
            final Function1 function13 = onUIAction;
            final Function1 function14 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamNavigationKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamNavigation$lambda$5;
                    TribeeSteamNavigation$lambda$5 = TribeeSteamNavigationKt.TribeeSteamNavigation$lambda$5(modifier8, f, z3, z4, kTribeeSteamHomeUserInfo, kThreeDot, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamNavigation$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$3$0(OnBackPressedDispatcher $backHandler) {
        $backHandler.onBackPressed();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$4$2$0(Function0 $onBack) {
        $onBack.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$4$3$1$0(Function1 $onStateAction) {
        $onStateAction.invoke(new TribeeSteamStateAction.StartShare(false, 1, null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamNavigation$lambda$4$3$3$0(Function1 $onUIAction, KThreeDot $threeDotInfo) {
        $onUIAction.invoke(new TribeeSteamUIAction.ClickMenu($threeDotInfo));
        return Unit.INSTANCE;
    }
}