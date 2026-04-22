package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bapis.bilibili.app.dynamic.v2.KTipsCard;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeBindAccountAbnormal;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.iconfont.BiliIconfontKt;
import com.bilibili.compose.theme.BiliTheme;
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

/* compiled from: TribeeSteamSyncFailed.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\u000b\u001aK\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"TribeeSteamSyncFailedPage", "", "modifier", "Landroidx/compose/ui/Modifier;", "data", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;", "onUIAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "onStateAction", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Landroidx/compose/ui/Modifier;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeBindAccountAbnormal;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "TribeeSteamSyncFailedContent", "picUrl", "", "desc", "buttonString", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamSyncFailedKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedContent$lambda$2(Modifier modifier, String str, String str2, String str3, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeSteamSyncFailedContent(modifier, str, str2, str3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedPage$lambda$3(Modifier modifier, KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal, Function1 function1, Function1 function12, int i, int i2, Composer composer, int i3) {
        TribeeSteamSyncFailedPage(modifier, kTribeeSteamHomeBindAccountAbnormal, function1, function12, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedPage$lambda$0$0(TribeeSteamUIAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedPage$lambda$1$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static final void TribeeSteamSyncFailedPage(Modifier modifier, KTribeeSteamHomeBindAccountAbnormal data, Function1<? super TribeeSteamUIAction, Unit> function1, Function1<? super TribeeSteamStateAction, Unit> function12, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal;
        Function1 onUIAction;
        Function1 onStateAction;
        Modifier modifier3;
        KTribeeSteamHomeBindAccountAbnormal data2;
        Modifier modifier4;
        KTribeeSteamHomeBindAccountAbnormal data3;
        Function0 factory$iv$iv$iv;
        KTipsCard fail;
        String confirmText;
        KTipsCard fail2;
        String desc;
        KTipsCard fail3;
        String picUrl;
        Composer $composer2 = $composer.startRestartGroup(143007995);
        ComposerKt.sourceInformation($composer2, "C(TribeeSteamSyncFailedPage)N(modifier,data,onUIAction,onStateAction)45@2030L2,46@2088L2,56@2375L6,52@2258L686:TribeeSteamSyncFailed.kt#k3l5ii");
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
            kTribeeSteamHomeBindAccountAbnormal = data;
        } else if (($changed & 48) == 0) {
            kTribeeSteamHomeBindAccountAbnormal = data;
            $dirty |= $composer2.changedInstance(kTribeeSteamHomeBindAccountAbnormal) ? 32 : 16;
        } else {
            kTribeeSteamHomeBindAccountAbnormal = data;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onUIAction = function1;
        } else if (($changed & 384) == 0) {
            onUIAction = function1;
            $dirty |= $composer2.changedInstance(onUIAction) ? 256 : 128;
        } else {
            onUIAction = function1;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onStateAction = function12;
        } else if (($changed & 3072) == 0) {
            onStateAction = function12;
            $dirty |= $composer2.changedInstance(onStateAction) ? 2048 : 1024;
        } else {
            onStateAction = function12;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            data2 = kTribeeSteamHomeBindAccountAbnormal;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                data3 = kTribeeSteamHomeBindAccountAbnormal;
            } else {
                data3 = null;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -8264867, "CC(remember):TribeeSteamSyncFailed.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamSyncFailedPage$lambda$0$0;
                            TribeeSteamSyncFailedPage$lambda$0$0 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedPage$lambda$0$0((TribeeSteamUIAction) obj);
                            return TribeeSteamSyncFailedPage$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onUIAction2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onUIAction = onUIAction2;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -8263011, "CC(remember):TribeeSteamSyncFailed.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamSyncFailedPage$lambda$1$0;
                            TribeeSteamSyncFailedPage$lambda$1$0 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedPage$lambda$1$0((TribeeSteamStateAction) obj);
                            return TribeeSteamSyncFailedPage$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onStateAction2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onStateAction = onStateAction2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(143007995, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamSyncFailedPage (TribeeSteamSyncFailed.kt:47)");
            }
            String picUrl2 = (data3 == null || (fail3 = data3.getFail()) == null || (picUrl = fail3.getPicUrl()) == null) ? "" : picUrl;
            String desc2 = (data3 == null || (fail2 = data3.getFail()) == null || (desc = fail2.getDesc()) == null) ? "" : desc;
            String buttonString = (data3 == null || (fail = data3.getFail()) == null || (confirmText = fail.getConfirmText()) == null) ? "" : confirmText;
            Modifier modifier$iv$iv = WindowInsetsPadding_androidKt.navigationBarsPadding(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(modifier4, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), (Shape) null, 2, (Object) null));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv$iv);
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
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i7 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1385057436, "C61@2552L112,65@2673L265:TribeeSteamSyncFailed.kt#k3l5ii");
            TribeeSteamNavigationKt.TribeeSteamNavigation(null, 0.0f, false, false, null, data3 != null ? data3.getThreeDot() : null, onUIAction, null, $composer2, ($dirty2 << 12) & 3670016, 159);
            data2 = data3;
            Function1 onUIAction3 = onUIAction;
            TribeeSteamSyncFailedContent(OffsetKt.offset-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(90), 1, (Object) null), picUrl2, desc2, buttonString, onStateAction, $composer2, (57344 & ($dirty2 << 3)) | 6, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onUIAction = onUIAction3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final KTribeeSteamHomeBindAccountAbnormal kTribeeSteamHomeBindAccountAbnormal2 = data2;
            final Function1 function13 = onUIAction;
            final Function1 function14 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamSyncFailedPage$lambda$3;
                    TribeeSteamSyncFailedPage$lambda$3 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedPage$lambda$3(modifier5, kTribeeSteamHomeBindAccountAbnormal2, function13, function14, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamSyncFailedPage$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedContent$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v13 */
    private static final void TribeeSteamSyncFailedContent(Modifier modifier, String picUrl, String desc, String buttonString, Function1<? super TribeeSteamStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String str;
        String desc2;
        String buttonString2;
        final Function1 onStateAction;
        Composer $composer2;
        Modifier modifier3;
        String picUrl2;
        Function1 onStateAction2;
        Modifier modifier4;
        String picUrl3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-372237674);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamSyncFailedContent)N(modifier,picUrl,desc,buttonString,onStateAction)83@3170L2,85@3182L2541:TribeeSteamSyncFailed.kt#k3l5ii");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            str = picUrl;
        } else if (($changed & 48) == 0) {
            str = picUrl;
            $dirty |= $composer3.changed(str) ? 32 : 16;
        } else {
            str = picUrl;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            desc2 = desc;
        } else if (($changed & 384) == 0) {
            desc2 = desc;
            $dirty |= $composer3.changed(desc2) ? 256 : 128;
        } else {
            desc2 = desc;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            buttonString2 = buttonString;
        } else if (($changed & 3072) == 0) {
            buttonString2 = buttonString;
            $dirty |= $composer3.changed(buttonString2) ? 2048 : 1024;
        } else {
            buttonString2 = buttonString;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            onStateAction = function1;
        } else if (($changed & 24576) == 0) {
            onStateAction = function1;
            $dirty |= $composer3.changedInstance(onStateAction) ? 16384 : 8192;
        } else {
            onStateAction = function1;
        }
        if (!$composer3.shouldExecute(($dirty & 9363) != 9362, $dirty & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            picUrl2 = str;
            onStateAction2 = onStateAction;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                picUrl3 = str;
            } else {
                picUrl3 = "";
            }
            if (i4 != 0) {
                desc2 = "";
            }
            if (i5 != 0) {
                buttonString2 = "";
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1238112680, "CC(remember):TribeeSteamSyncFailed.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamSyncFailedContent$lambda$0$0;
                            TribeeSteamSyncFailedContent$lambda$0$0 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedContent$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamSyncFailedContent$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function1 onStateAction3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-372237674, $dirty, -1, "kntr.app.tribee.steam.page.TribeeSteamSyncFailedContent (TribeeSteamSyncFailed.kt:84)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(48), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i8 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 750774880, "C116@4168L6,117@4212L9,114@4107L171,128@4532L6,131@4687L39,133@4805L118,121@4288L1429:TribeeSteamSyncFailed.kt#k3l5ii");
            if (!StringsKt.isBlank(picUrl3)) {
                $composer3.startReplaceGroup(750739911);
                ComposerKt.sourceInformation($composer3, "94@3481L323");
                String $this$asRequest$iv = picUrl3;
                picUrl2 = picUrl3;
                ImageRequest $this$TribeeSteamSyncFailedContent_u24lambda_u241_u240 = new ImageRequest($this$asRequest$iv);
                $this$TribeeSteamSyncFailedContent_u24lambda_u241_u240.contentScale(ContentScale.Companion.getInside());
                BiliImageKt.BiliImage($this$TribeeSteamSyncFailedContent_u24lambda_u241_u240.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), "sync_failed_image", null, null, null, null, null, null, $composer3, 432, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                $composer3.endReplaceGroup();
            } else {
                picUrl2 = picUrl3;
                $composer3.startReplaceGroup(751087917);
                ComposerKt.sourceInformation($composer3, "106@3867L52,105@3834L253");
                ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_status_failed(CommonRes.INSTANCE.getDrawable()), $composer3, 0), "sync_failed_image", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(140)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer3, Painter.$stable | 432, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
                $composer3.endReplaceGroup();
            }
            TextKt.Text-Nvy7gAk(desc2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, ($dirty >> 6) & 14, 0, 130042);
            Modifier modifier5 = BackgroundKt.background-bw27NRU(SizeKt.wrapContentWidth$default(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 0.0f, 0.0f, 13, (Object) null), Dp.constructor-impl(30)), (Alignment.Horizontal) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(15)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1499764505, "CC(remember):TribeeSteamSyncFailed.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                $composer3.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, -1499760650, "CC(remember):TribeeSteamSyncFailed.kt#9igjgp");
            boolean invalid$iv = (57344 & $dirty) == 16384;
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda4
                    public final Object invoke() {
                        Unit TribeeSteamSyncFailedContent$lambda$1$2$0;
                        TribeeSteamSyncFailedContent$lambda$1$2$0 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedContent$lambda$1$2$0(onStateAction);
                        return TribeeSteamSyncFailedContent$lambda$1$2$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv2 = ClickableKt.clickable-O2vRcR0$default(modifier5, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv3, 28, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            String desc3 = desc2;
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
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            onStateAction2 = onStateAction;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i10 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1741888068, "C141@5134L22,143@5244L6,140@5088L330,152@5509L6,153@5562L9,150@5432L275:TribeeSteamSyncFailed.kt#k3l5ii");
            BiliIconfontKt.BiliIcon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer3, 6), SizeKt.size-3ABfNKs(PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null), Dp.constructor-impl(16)), "refresh icon", BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            TextKt.Text-Nvy7gAk(buttonString2, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, Dp.constructor-impl(10), 0.0f, 10, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, (($dirty >> 9) & 14) | 48, 0, 131064);
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
            desc2 = desc3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier6 = modifier3;
            final String str2 = picUrl2;
            final String str3 = desc2;
            final String str4 = buttonString2;
            final Function1 function12 = onStateAction2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamSyncFailedKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamSyncFailedContent$lambda$2;
                    TribeeSteamSyncFailedContent$lambda$2 = TribeeSteamSyncFailedKt.TribeeSteamSyncFailedContent$lambda$2(modifier6, str2, str3, str4, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamSyncFailedContent$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamSyncFailedContent$lambda$1$2$0(Function1 $onStateAction) {
        $onStateAction.invoke(new TribeeSteamStateAction.LaunchPolling(1));
        return Unit.INSTANCE;
    }
}