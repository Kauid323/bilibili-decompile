package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.activity.OnBackPressedDispatcher;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.GarbInfo;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.common.trio.pagecontroller.LocalOnBackPressedDispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.list.logic.statemachine.OfflineBaseListStateMachine;
import video.biz.offline.list.ui.utils.ColorUtilsKt;

/* compiled from: OfflinePageHeader.kt */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0089\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\u001c\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0014¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001d\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"OfflinePageHeader", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "modifier", "Landroidx/compose/ui/Modifier;", "showBackIcon", "", "fitsSystemBar", "useHomeGarbColor", "titlePadding", "Landroidx/compose/ui/unit/Dp;", "titleTextStyle", "Landroidx/compose/ui/text/TextStyle;", "backInterceptor", "Lkotlin/Function0;", "Lvideo/biz/offline/list/logic/statemachine/OfflineBackInterceptor;", "operations", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "OfflinePageHeader-GmEhDVc", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZZFLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OfflineHeaderCancelOperation", "scope", "Lkotlinx/coroutines/CoroutineScope;", "machine", "Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;", "(Lkotlinx/coroutines/CoroutineScope;Lvideo/biz/offline/list/logic/statemachine/OfflineBaseListStateMachine;Landroidx/compose/runtime/Composer;I)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflinePageHeaderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHeaderCancelOperation$lambda$1(CoroutineScope coroutineScope, OfflineBaseListStateMachine offlineBaseListStateMachine, int i, Composer composer, int i2) {
        OfflineHeaderCancelOperation(coroutineScope, offlineBaseListStateMachine, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePageHeader_GmEhDVc$lambda$1(String str, Modifier modifier, boolean z, boolean z2, boolean z3, float f, TextStyle textStyle, Function0 function0, Function3 function3, int i, int i2, Composer composer, int i3) {
        m2949OfflinePageHeaderGmEhDVc(str, modifier, z, z2, z3, f, textStyle, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:175:0x0562, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L93;
     */
    /* renamed from: OfflinePageHeader-GmEhDVc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2949OfflinePageHeaderGmEhDVc(final String title, Modifier modifier, boolean showBackIcon, boolean fitsSystemBar, boolean useHomeGarbColor, float f, TextStyle titleTextStyle, Function0<Boolean> function0, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        boolean showBackIcon2;
        boolean fitsSystemBar2;
        boolean useHomeGarbColor2;
        Composer $composer2;
        Modifier modifier2;
        float f2;
        TextStyle titleTextStyle2;
        Function0 backInterceptor;
        boolean showBackIcon3;
        boolean fitsSystemBar3;
        boolean useHomeGarbColor3;
        Modifier modifier3;
        float f3;
        TextStyle titleTextStyle3;
        final Function0 backInterceptor2;
        Modifier modifier4;
        int $dirty;
        float paddingTop;
        Composer $composer$iv;
        boolean propagateMinConstraints$iv;
        Function0 factory$iv$iv$iv;
        String str;
        String str2;
        String str3;
        Composer $composer3;
        Function0 backInterceptor3;
        Composer $composer$iv$iv$iv;
        String str4;
        Composer $composer4;
        Function0 factory$iv$iv$iv2;
        boolean z;
        int i2;
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(function3, "operations");
        Composer $composer5 = $composer.startRestartGroup(-1545721007);
        ComposerKt.sourceInformation($composer5, "C(OfflinePageHeader)N(title,modifier,showBackIcon,fitsSystemBar,useHomeGarbColor,titlePadding:c#ui.unit.Dp,titleTextStyle,backInterceptor,operations)55@2458L7,63@2670L2431:OfflinePageHeader.kt#uys4uf");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer5.changed(title) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
        } else if (($changed & 48) == 0) {
            $dirty2 |= $composer5.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            showBackIcon2 = showBackIcon;
        } else if (($changed & 384) == 0) {
            showBackIcon2 = showBackIcon;
            $dirty2 |= $composer5.changed(showBackIcon2) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            showBackIcon2 = showBackIcon;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            fitsSystemBar2 = fitsSystemBar;
        } else if (($changed & 3072) == 0) {
            fitsSystemBar2 = fitsSystemBar;
            $dirty2 |= $composer5.changed(fitsSystemBar2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            fitsSystemBar2 = fitsSystemBar;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            useHomeGarbColor2 = useHomeGarbColor;
        } else if (($changed & 24576) == 0) {
            useHomeGarbColor2 = useHomeGarbColor;
            $dirty2 |= $composer5.changed(useHomeGarbColor2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            useHomeGarbColor2 = useHomeGarbColor;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer5.changed(f) ? 131072 : 65536;
        }
        if (($changed & 1572864) == 0) {
            if ((i & 64) == 0 && $composer5.changed(titleTextStyle)) {
                i2 = 1048576;
                $dirty2 |= i2;
            }
            i2 = 524288;
            $dirty2 |= i2;
        }
        int i8 = i & 128;
        if (i8 != 0) {
            $dirty2 |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty2 |= $composer5.changedInstance(function0) ? 8388608 : 4194304;
        }
        if (($changed & 100663296) == 0) {
            $dirty2 |= $composer5.changedInstance(function3) ? 67108864 : 33554432;
        }
        if ($composer5.shouldExecute(($dirty2 & 38347923) != 38347922, $dirty2 & 1)) {
            $composer5.startDefaults();
            ComposerKt.sourceInformation($composer5, "51@2283L9");
            if (($changed & 1) != 0 && !$composer5.getDefaultsInvalid()) {
                $composer5.skipToGroupEnd();
                if ((i & 64) != 0) {
                    $dirty2 &= -3670017;
                }
                modifier4 = modifier;
                f2 = f;
                titleTextStyle2 = titleTextStyle;
                backInterceptor2 = function0;
                showBackIcon3 = showBackIcon2;
                fitsSystemBar3 = fitsSystemBar2;
                useHomeGarbColor3 = useHomeGarbColor2;
                $dirty = $dirty2;
            } else {
                if (i3 != 0) {
                    modifier3 = (Modifier) Modifier.Companion;
                } else {
                    modifier3 = modifier;
                }
                if (i4 != 0) {
                    showBackIcon2 = true;
                }
                if (i5 != 0) {
                    fitsSystemBar2 = true;
                }
                if (i6 != 0) {
                    useHomeGarbColor2 = true;
                }
                if (i7 == 0) {
                    f3 = f;
                } else {
                    f3 = Dp.constructor-impl(70);
                }
                if ((i & 64) != 0) {
                    titleTextStyle3 = BiliTheme.INSTANCE.getTextStyle($composer5, BiliTheme.$stable).getT17b();
                    $dirty2 &= -3670017;
                } else {
                    titleTextStyle3 = titleTextStyle;
                }
                if (i8 == 0) {
                    backInterceptor2 = function0;
                    modifier4 = modifier3;
                    f2 = f3;
                    titleTextStyle2 = titleTextStyle3;
                    showBackIcon3 = showBackIcon2;
                    fitsSystemBar3 = fitsSystemBar2;
                    useHomeGarbColor3 = useHomeGarbColor2;
                    $dirty = $dirty2;
                } else {
                    backInterceptor2 = null;
                    modifier4 = modifier3;
                    f2 = f3;
                    titleTextStyle2 = titleTextStyle3;
                    showBackIcon3 = showBackIcon2;
                    fitsSystemBar3 = fitsSystemBar2;
                    useHomeGarbColor3 = useHomeGarbColor2;
                    $dirty = $dirty2;
                }
            }
            $composer5.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1545721007, $dirty, -1, "video.biz.offline.list.ui.widget.OfflinePageHeader (OfflinePageHeader.kt:54)");
            }
            final OnBackPressedDispatcher backHandler = LocalOnBackPressedDispatcher.INSTANCE.getCurrent($composer5, LocalOnBackPressedDispatcher.$stable);
            float f4 = Dp.constructor-impl(44);
            if (fitsSystemBar3) {
                $composer5.startReplaceGroup(2065343738);
                ComposerKt.sourceInformation($composer5, "59@2571L10,59@2582L17");
                float f5 = WindowInsetsKt.asPaddingValues(WindowInsets_androidKt.getStatusBars(WindowInsets.Companion, $composer5, 6), $composer5, 0).calculateTopPadding-D9Ej5fM();
                $composer5.endReplaceGroup();
                paddingTop = f5;
            } else {
                $composer5.startReplaceGroup(2065434165);
                $composer5.endReplaceGroup();
                paddingTop = Dp.constructor-impl(0);
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(modifier4, Dp.constructor-impl(paddingTop + f4));
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            modifier2 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(factory$iv$iv$iv3);
            } else {
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i10 = ((0 >> 6) & 112) | 6;
            BoxScope $this$OfflinePageHeader_GmEhDVc_u24lambda_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, -1383518331, "C75@3226L1056,102@4291L561:OfflinePageHeader.kt#uys4uf");
            if (fitsSystemBar3) {
                $composer5.startReplaceGroup(-1383558291);
                ComposerKt.sourceInformation($composer5, "65@2798L5");
                GarbInfo homeGarb = BiliTheme.INSTANCE.getTheme($composer5, BiliTheme.$stable);
                if (useHomeGarbColor3) {
                    if (homeGarb.getHomePrimaryBgPath().length() == 0) {
                        $composer5.startReplaceGroup(-1383462853);
                        $composer5.endReplaceGroup();
                        $composer$iv = $composer5;
                        z = true;
                    } else {
                        $composer5.startReplaceGroup(1756488528);
                        ComposerKt.sourceInformation($composer5, "66@2891L10");
                        $composer$iv = $composer5;
                        z = !BiliTheme.INSTANCE.getInHomePage($composer5, BiliTheme.$stable);
                        $composer5.endReplaceGroup();
                    }
                    if (!z) {
                        propagateMinConstraints$iv = false;
                    } else {
                        $composer5.startReplaceGroup(-1383419411);
                        ComposerKt.sourceInformation($composer5, "67@2928L74");
                        propagateMinConstraints$iv = false;
                        BoxKt.Box(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), ColorKt.Color(homeGarb.getPrimary()), (Shape) null, 2, (Object) null), $composer5, 0);
                        $composer5.endReplaceGroup();
                    }
                } else {
                    $composer$iv = $composer5;
                    propagateMinConstraints$iv = false;
                }
                $composer5.startReplaceGroup(-1383305858);
                ComposerKt.sourceInformation($composer5, "69@3040L153");
                String $this$asRequest_u24default$iv = homeGarb.getHomePrimaryBgPath();
                ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                Unit unit = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest.build(), SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, (Function4) null, $composer5, 48, 508);
                $composer5.endReplaceGroup();
            } else {
                $composer$iv = $composer5;
                propagateMinConstraints$iv = false;
                $composer5.startReplaceGroup(-1386310409);
            }
            $composer5.endReplaceGroup();
            Modifier modifier$iv2 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, paddingTop, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 13, (Object) null), f4);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv2 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int $changed2 = ((384 >> 6) & 112) | 6;
            RowScope $this$OfflinePageHeader_GmEhDVc_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 861241936, "C99@4209L38,100@4260L12:OfflinePageHeader.kt#uys4uf");
            if (showBackIcon3) {
                $composer5.startReplaceGroup(861256877);
                ComposerKt.sourceInformation($composer5, "83@3540L294,80@3432L750");
                Modifier modifier5 = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer5, 1274712013, "CC(remember):OfflinePageHeader.kt#9igjgp");
                boolean invalid$iv = ((29360128 & $dirty) == 8388608) | $composer5.changedInstance(backHandler);
                $composer3 = $composer5;
                Object it$iv = $composer5.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePageHeaderKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit OfflinePageHeader_GmEhDVc$lambda$0$0$0$0;
                        OfflinePageHeader_GmEhDVc$lambda$0$0$0$0 = OfflinePageHeaderKt.OfflinePageHeader_GmEhDVc$lambda$0$0$0$0(backInterceptor2, backHandler);
                        return OfflinePageHeader_GmEhDVc$lambda$0$0$0$0;
                    }
                };
                $composer5.updateRememberedValue(value$iv);
                it$iv = value$iv;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                backInterceptor3 = backInterceptor2;
                Modifier modifier$iv3 = PaddingKt.padding-VpY3zN4$default(ClickableKt.clickable-oSLSa3U$default(modifier5, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(12), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer5.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer5, modifier$iv3);
                Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer5.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer5.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv5;
                    $composer5.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer5);
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv = $composer5;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i12 = ($changed$iv$iv$iv3 >> 6) & 14;
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, str4);
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i13 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer5, -868802343, "C92@3957L24,93@4014L19,91@3904L260:OfflinePageHeader.kt#uys4uf");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_back_left_line_500($composer5, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), ColorUtilsKt.getHeaderTintIconColor($composer5, 0), $composer5, Painter.$stable | 432, 0);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
            } else {
                str = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer3 = $composer5;
                backInterceptor3 = backInterceptor2;
                $composer$iv$iv$iv = $composer5;
                str4 = "C72@3469L9:Box.kt#2w3rfo";
                $composer5.startReplaceGroup(857844955);
            }
            $composer5.endReplaceGroup();
            SpacerKt.Spacer(RowScope.-CC.weight$default($this$OfflinePageHeader_GmEhDVc_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), $composer5, 0);
            function3.invoke($this$OfflinePageHeader_GmEhDVc_u24lambda_u240_u240, $composer5, Integer.valueOf(($changed2 & 14) | (($dirty >> 21) & 112)));
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            Alignment contentAlignment$iv3 = Alignment.Companion.getCenter();
            Modifier modifier$iv4 = SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxSize$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), f2, paddingTop, f2, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 8, (Object) null), f4);
            ComposerKt.sourceInformationMarkerStart($composer5, 1042775818, str3);
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
            int $changed$iv$iv4 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, str2);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer5, modifier$iv4);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, str);
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                $composer5.createNode(factory$iv$iv$iv6);
            } else {
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i14 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1833054614, str4);
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i15 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -2037486851, "C112@4645L16,110@4585L257:OfflinePageHeader.kt#uys4uf");
            Composer $composer$iv2 = $composer$iv;
            backInterceptor = backInterceptor3;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, ColorUtilsKt.getHeaderTitleColor($composer5, 0), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 0, (Function1) null, titleTextStyle2, $composer5, $dirty & 14, (($dirty << 3) & 29360128) | 24960, 109562);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (!fitsSystemBar3) {
                $composer4 = $composer5;
                $composer4.startReplaceGroup(-1381460831);
                ComposerKt.sourceInformation($composer4, "123@5051L6,120@4895L190");
                DividerKt.HorizontalDivider-9IZ8Weo($this$OfflinePageHeader_GmEhDVc_u24lambda_u240.align(Modifier.Companion, Alignment.Companion.getBottomCenter()), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer4, 48, 0);
            } else {
                $composer4 = $composer5;
                $composer4.startReplaceGroup(-1386310409);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            f2 = f;
            titleTextStyle2 = titleTextStyle;
            backInterceptor = function0;
            showBackIcon3 = showBackIcon2;
            fitsSystemBar3 = fitsSystemBar2;
            useHomeGarbColor3 = useHomeGarbColor2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier2;
            final boolean z2 = showBackIcon3;
            final boolean z3 = fitsSystemBar3;
            final boolean z4 = useHomeGarbColor3;
            final float f6 = f2;
            final TextStyle textStyle = titleTextStyle2;
            final Function0 function02 = backInterceptor;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflinePageHeaderKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflinePageHeader_GmEhDVc$lambda$1;
                    OfflinePageHeader_GmEhDVc$lambda$1 = OfflinePageHeaderKt.OfflinePageHeader_GmEhDVc$lambda$1(title, modifier6, z2, z3, z4, f6, textStyle, function02, function3, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflinePageHeader_GmEhDVc$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinePageHeader_GmEhDVc$lambda$0$0$0$0(Function0 $backInterceptor, OnBackPressedDispatcher $backHandler) {
        if ($backInterceptor != null) {
            $backInterceptor.invoke();
        } else {
            $backHandler.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    public static final void OfflineHeaderCancelOperation(final CoroutineScope scope, final OfflineBaseListStateMachine machine, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(machine, "machine");
        Composer $composer2 = $composer.startRestartGroup(-1682231239);
        ComposerKt.sourceInformation($composer2, "C(OfflineHeaderCancelOperation)N(scope,machine)135@5273L117,134@5237L455:OfflinePageHeader.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(scope) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(machine) : $composer2.changedInstance(machine) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        boolean z = false;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1682231239, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineHeaderCancelOperation (OfflinePageHeader.kt:133)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1716512562, "CC(remember):OfflinePageHeader.kt#9igjgp");
            boolean changedInstance = $composer2.changedInstance(scope);
            if (($dirty2 & 112) == 32 || (($dirty2 & 64) != 0 && $composer2.changedInstance(machine))) {
                z = true;
            }
            boolean invalid$iv = changedInstance | z;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflinePageHeaderKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit OfflineHeaderCancelOperation$lambda$0$0;
                        OfflineHeaderCancelOperation$lambda$0$0 = OfflinePageHeaderKt.OfflineHeaderCancelOperation$lambda$0$0(scope, machine);
                        return OfflineHeaderCancelOperation$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            OfflineOperationComponentKt.OfflineOperation(null, false, (Function0) it$iv, ComposableSingletons$OfflinePageHeaderKt.INSTANCE.getLambda$1367181901$ui_debug(), $composer2, 3072, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflinePageHeaderKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineHeaderCancelOperation$lambda$1;
                    OfflineHeaderCancelOperation$lambda$1 = OfflinePageHeaderKt.OfflineHeaderCancelOperation$lambda$1(scope, machine, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineHeaderCancelOperation$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineHeaderCancelOperation$lambda$0$0(CoroutineScope $scope, OfflineBaseListStateMachine $machine) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflinePageHeaderKt$OfflineHeaderCancelOperation$1$1$1($machine, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}