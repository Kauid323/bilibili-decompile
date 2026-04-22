package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KHeadTips;
import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeUserInfo;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.viewmodel.TribeeSteamUIAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.common.compose.res.LoadingAnimateImageKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.ImageResourcesKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.consume.generated.resources.Drawable0_commonMainKt;
import srcs.app.tribee.consume.generated.resources.Res;

/* compiled from: TribeeSteamEmptyDataContent.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ae\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001f\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"TribeeSteamEmptyDataContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "syncTips", "Lcom/bapis/bilibili/app/dynamic/v2/KHeadTips;", "userInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;", "threeDotInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "achievementsIcon", "", "achievementsTitle", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "(Landroidx/compose/ui/Modifier;Lcom/bapis/bilibili/app/dynamic/v2/KHeadTips;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeUserInfo;Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamDataLoadingTips", "(Lcom/bapis/bilibili/app/dynamic/v2/KHeadTips;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamEmptyDataContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamDataLoadingTips$lambda$1(KHeadTips kHeadTips, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeSteamDataLoadingTips(kHeadTips, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamEmptyDataContent$lambda$2(Modifier modifier, KHeadTips kHeadTips, KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo, KThreeDot kThreeDot, String str, String str2, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeSteamEmptyDataContent(modifier, kHeadTips, kTribeeSteamHomeUserInfo, kThreeDot, str, str2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamEmptyDataContent$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v38 */
    public static final void TribeeSteamEmptyDataContent(Modifier modifier, KHeadTips syncTips, KTribeeSteamHomeUserInfo userInfo, KThreeDot threeDotInfo, String achievementsIcon, String achievementsTitle, Function1<? super TribeeSteamUIAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        KHeadTips syncTips2;
        KTribeeSteamHomeUserInfo userInfo2;
        KThreeDot threeDotInfo2;
        String achievementsIcon2;
        int $dirty;
        Composer $composer2;
        Modifier modifier2;
        String achievementsTitle2;
        Function1 onUIAction;
        KHeadTips syncTips3;
        KTribeeSteamHomeUserInfo userInfo3;
        String achievementsIcon3;
        Modifier modifier3;
        String achievementsTitle3;
        Function1 onUIAction2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Function0 factory$iv$iv$iv5;
        Composer $composer3 = $composer.startRestartGroup(520296939);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamEmptyDataContent)N(modifier,syncTips,userInfo,threeDotInfo,achievementsIcon,achievementsTitle,onUIAction)50@2129L2,56@2263L6,52@2141L5086:TribeeSteamEmptyDataContent.kt#k3l5ii");
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
            syncTips2 = syncTips;
        } else if (($changed & 48) == 0) {
            syncTips2 = syncTips;
            $dirty2 |= $composer3.changedInstance(syncTips2) ? 32 : 16;
        } else {
            syncTips2 = syncTips;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            userInfo2 = userInfo;
        } else if (($changed & 384) == 0) {
            userInfo2 = userInfo;
            $dirty2 |= $composer3.changedInstance(userInfo2) ? 256 : 128;
        } else {
            userInfo2 = userInfo;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            threeDotInfo2 = threeDotInfo;
        } else if (($changed & 3072) == 0) {
            threeDotInfo2 = threeDotInfo;
            $dirty2 |= $composer3.changedInstance(threeDotInfo2) ? 2048 : 1024;
        } else {
            threeDotInfo2 = threeDotInfo;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            achievementsIcon2 = achievementsIcon;
        } else if (($changed & 24576) == 0) {
            achievementsIcon2 = achievementsIcon;
            $dirty2 |= $composer3.changed(achievementsIcon2) ? 16384 : 8192;
        } else {
            achievementsIcon2 = achievementsIcon;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty2 |= 196608;
        } else if (($changed & 196608) == 0) {
            $dirty2 |= $composer3.changed(achievementsTitle) ? 131072 : 65536;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty2 |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 1048576 : 524288;
        }
        if (!$composer3.shouldExecute(($dirty2 & 599187) != 599186, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            achievementsTitle2 = achievementsTitle;
            onUIAction = function1;
            syncTips3 = syncTips2;
            userInfo3 = userInfo2;
            achievementsIcon3 = achievementsIcon2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 != 0) {
                syncTips2 = null;
            }
            if (i4 != 0) {
                userInfo2 = null;
            }
            if (i5 != 0) {
                threeDotInfo2 = null;
            }
            if (i6 != 0) {
                achievementsIcon2 = "";
            }
            if (i7 == 0) {
                achievementsTitle3 = achievementsTitle;
            } else {
                achievementsTitle3 = "";
            }
            if (i8 == 0) {
                onUIAction2 = function1;
            } else {
                ComposerKt.sourceInformationMarkerStart($composer3, 1789161805, "CC(remember):TribeeSteamEmptyDataContent.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamEmptyDataContentKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamEmptyDataContent$lambda$0$0;
                            TribeeSteamEmptyDataContent$lambda$0$0 = TribeeSteamEmptyDataContentKt.TribeeSteamEmptyDataContent$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamEmptyDataContent$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onUIAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(520296939, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamEmptyDataContent (TribeeSteamEmptyDataContent.kt:51)");
            }
            Modifier modifier$iv$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier3, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier2 = modifier3;
            String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            $composer2 = $composer3;
            String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            achievementsTitle2 = achievementsTitle3;
            achievementsIcon3 = achievementsIcon2;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i10 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -580114415, "C59@2321L49,58@2292L267,67@2569L4652:TribeeSteamEmptyDataContent.kt#k3l5ii");
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getTribee_steam_bg_dot(Res.drawable.INSTANCE), $composer3, 0), "background", AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0901163f, false, 2, (Object) null), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(16), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            Composer $composer$iv$iv$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv$iv$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv$iv$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv$iv$iv.startReusableNode();
            if ($composer$iv$iv$iv.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv$iv$iv.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer$iv$iv$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer$iv$iv$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv2 >> 6) & 14;
            Composer $composer$iv = $composer$iv$iv$iv;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i12 = ((390 >> 6) & 112) | 6;
            Composer $composer4 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer4, -611228772, "C73@2763L122,82@3014L250,98@3567L6,91@3278L410,108@3921L6,103@3702L1082,138@5073L6,131@4798L395:TribeeSteamEmptyDataContent.kt#k3l5ii");
            TribeeSteamNavigationKt.TribeeSteamNavigation(null, 0.0f, false, false, null, threeDotInfo2, onUIAction2, null, $composer4, (($dirty2 << 6) & 458752) | (3670016 & $dirty2), 159);
            if (syncTips2 != null) {
                $composer4.startReplaceGroup(-611207476);
                ComposerKt.sourceInformation($composer4, "79@2939L47");
                TribeeSteamDataLoadingTips(syncTips2, null, $composer4, ($dirty2 >> 3) & 14, 2);
            } else {
                $composer4.startReplaceGroup(-614108549);
            }
            $composer4.endReplaceGroup();
            syncTips3 = syncTips2;
            TribeeUserInfoKt.m1152TribeeUserInfoTN_CM5M(userInfo2, PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(14), 0.0f, 0.0f, 13, (Object) null), 0.0f, null, onUIAction2, $composer4, (($dirty2 >> 6) & 14) | 48 | (($dirty2 >> 6) & 57344), 12);
            $dirty = $dirty2;
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(32), 5, (Object) null), Dp.constructor-impl(129)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), $composer4, 0);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null);
            onUIAction = onUIAction2;
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv3 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            userInfo3 = userInfo2;
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            KThreeDot threeDotInfo3 = threeDotInfo2;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i13 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i14 = ((384 >> 6) & 112) | 6;
            RowScope $this$TribeeSteamEmptyDataContent_u24lambda_u241_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1357518853, "C111@4015L190,120@4438L6,117@4223L547:TribeeSteamEmptyDataContent.kt#k3l5ii");
            ImageRequest imageRequest = new ImageRequest(achievementsIcon3);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), "icon", null, null, null, null, null, null, $composer4, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            String str3 = !StringsKt.isBlank(achievementsTitle2) ? achievementsTitle2 : null;
            if (str3 == null) {
                $composer4.startReplaceGroup(-648937181);
                ComposerKt.sourceInformation($composer4, "118@4304L56");
                str3 = StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_27(TribeeRes.INSTANCE.getString()), $composer4, 0);
            } else {
                $composer4.startReplaceGroup(-648938669);
            }
            $composer4.endReplaceGroup();
            TextKt.Text-Nvy7gAk(str3, RowScope.-CC.weight$default($this$TribeeSteamEmptyDataContent_u24lambda_u241_u240_u240, PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer4, 1597440, 24960, 241576);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, 0.0f, 0.0f, Dp.constructor-impl(12), 7, (Object) null), Dp.constructor-impl(36)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), $composer4, 0);
            $composer4.startReplaceGroup(257453371);
            ComposerKt.sourceInformation($composer4, "*144@5236L1961");
            int i15 = 0;
            while (i15 < 10) {
                Modifier modifier$iv$iv2 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                int $changed$iv = 6;
                Composer $composer$iv2 = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv4 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str);
                int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                CompositionLocalMap localMap$iv$iv4 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv$iv2);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str2);
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer$iv2.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv2);
                Composer $composer$iv$iv$iv2 = $composer$iv$iv$iv;
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                int i16 = ($changed$iv$iv$iv4 >> 6) & 14;
                boolean z = false;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i17 = ((6 >> 6) & 112) | 6;
                RowScope $this$TribeeSteamEmptyDataContent_u24lambda_u241_u240_u241_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -2038588809, "C:TribeeSteamEmptyDataContent.kt#k3l5ii");
                $composer$iv2.startReplaceGroup(1458259724);
                ComposerKt.sourceInformation($composer$iv2, "*146@5334L1823");
                int i18 = 0;
                while (i18 < 3) {
                    Modifier modifier$iv3 = RowScope.-CC.weight$default($this$TribeeSteamEmptyDataContent_u24lambda_u241_u240_u241_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                    Modifier materialized$iv$iv5 = materialized$iv$iv4;
                    int $changed$iv2 = $changed$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                    MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer$iv2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv5 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -1159599143, str);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv2, 0));
                    String str4 = str;
                    CompositionLocalMap localMap$iv$iv5 = $composer$iv2.getCurrentCompositionLocalMap();
                    boolean z2 = z;
                    Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv3);
                    Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    Composer $composer5 = $composer4;
                    Composer $composer$iv3 = $composer$iv;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, -553112988, str2);
                    if (!($composer$iv2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer$iv2.startReusableNode();
                    if ($composer$iv2.getInserting()) {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv2.createNode(factory$iv$iv$iv5);
                    } else {
                        factory$iv$iv$iv5 = factory$iv$iv$iv10;
                        $composer$iv2.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv2);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                    int i19 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                    int i20 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv2, 1248869430, "C158@5949L6,152@5607L510,168@6418L6,163@6147L439,178@6963L6,172@6615L516:TribeeSteamEmptyDataContent.kt#k3l5ii");
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(15), 0.0f, Dp.constructor-impl(13), 5, (Object) null), Dp.constructor-impl(48)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), $composer$iv2, 0);
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(74), Dp.constructor-impl(15)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer$iv2, 0);
                    SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.size-VpY3zN4(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 0.0f, Dp.constructor-impl(16), 5, (Object) null), Dp.constructor-impl(74), Dp.constructor-impl(15)), BiliTheme.INSTANCE.getColors($composer$iv2, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), $composer$iv2, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    $composer$iv2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                    i18++;
                    $composer$iv2 = $composer$iv2;
                    $composer4 = $composer5;
                    measurePolicy$iv$iv = measurePolicy$iv$iv2;
                    materialized$iv$iv4 = materialized$iv$iv5;
                    $changed$iv = $changed$iv2;
                    z = z2;
                    str = str4;
                    $composer$iv = $composer$iv3;
                    i15 = i15;
                    str2 = str2;
                }
                $composer$iv2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                i15++;
                $composer$iv$iv$iv = $composer$iv$iv$iv2;
                str = str;
            }
            Composer $composer6 = $composer4;
            Composer $composer$iv$iv$iv3 = $composer$iv$iv$iv;
            $composer6.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
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
            threeDotInfo2 = threeDotInfo3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final KHeadTips kHeadTips = syncTips3;
            final KTribeeSteamHomeUserInfo kTribeeSteamHomeUserInfo = userInfo3;
            final KThreeDot kThreeDot = threeDotInfo2;
            final String str5 = achievementsIcon3;
            final String str6 = achievementsTitle2;
            final Function1 function12 = onUIAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamEmptyDataContentKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamEmptyDataContent$lambda$2;
                    TribeeSteamEmptyDataContent$lambda$2 = TribeeSteamEmptyDataContentKt.TribeeSteamEmptyDataContent$lambda$2(modifier4, kHeadTips, kTribeeSteamHomeUserInfo, kThreeDot, str5, str6, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamEmptyDataContent$lambda$2;
                }
            });
        }
    }

    private static final void TribeeSteamDataLoadingTips(final KHeadTips syncTips, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1632245684);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamDataLoadingTips)N(syncTips,modifier)201@7526L6,195@7351L826:TribeeSteamEmptyDataContent.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(syncTips) ? 4 : 2;
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
                ComposerKt.traceEventStart(1632245684, $dirty, -1, "kntr.app.tribee.steam.page.TribeeSteamDataLoadingTips (TribeeSteamEmptyDataContent.kt:194)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl(40)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink_thin-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier4 = modifier3;
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
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 35108331, "C207@7756L27,206@7723L177,215@8011L6,212@7910L261:TribeeSteamEmptyDataContent.kt#k3l5ii");
            String $this$asRequest_u24default$iv = LoadingAnimateImageKt.getLoadingAnimateImageUri($composer2, 0);
            BiliImageKt.BiliImage(new ImageRequest($this$asRequest_u24default$iv).build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), "loading icon", null, null, null, null, null, null, $composer2, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
            TextKt.Text-Nvy7gAk(syncTips.getTitle(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer2, 24624, 24960, 241640);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamEmptyDataContentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamDataLoadingTips$lambda$1;
                    TribeeSteamDataLoadingTips$lambda$1 = TribeeSteamEmptyDataContentKt.TribeeSteamDataLoadingTips$lambda$1(syncTips, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamDataLoadingTips$lambda$1;
                }
            });
        }
    }
}