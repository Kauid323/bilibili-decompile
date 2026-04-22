package kntr.app.tribee.steam.page;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import bili.resource.tribee.String0_commonMainKt;
import bili.resource.tribee.TribeeRes;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeData;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeDataItem;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.steam.track.SteamTrackerKt;
import kntr.app.tribee.steam.viewmodel.TribeeSteamStateAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.imp.InitGMultiDomainKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.FontResources_androidKt;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.common.compose.res.generated.resources.Font0_commonMainKt;
import srcs.common.compose.res.generated.resources.Res;

/* compiled from: TribeeSteamAccountInfo.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u001aU\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001a\u0011\u0010\u000e\u001a\u00020\u0005*\u00020\u0005H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0014X\u008a\u0084\u0002"}, d2 = {"TribeeSteamAccountInfo", "", "info", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;", "modifier", "Landroidx/compose/ui/Modifier;", "isMaster", "", "isUpdating", "isSharing", "onStateAction", "Lkotlin/Function1;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeData;Landroidx/compose/ui/Modifier;ZZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "infiniteRotation", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "consume_debug", "shadowColor", "Landroidx/compose/ui/graphics/Color;", "rotation", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSteamAccountInfoKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamAccountInfo$lambda$2(KTribeeSteamHomeData kTribeeSteamHomeData, Modifier modifier, boolean z, boolean z2, boolean z3, Function1 function1, int i, int i2, Composer composer, int i3) {
        TribeeSteamAccountInfo(kTribeeSteamHomeData, modifier, z, z2, z3, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamAccountInfo$lambda$0$0(TribeeSteamStateAction it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x098d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0999  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0bbf  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0c76  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0c82  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0c88  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0d09  */
    /* JADX WARN: Type inference failed for: r8v72 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void TribeeSteamAccountInfo(final KTribeeSteamHomeData info, Modifier modifier, boolean isMaster, boolean isUpdating, boolean isSharing, Function1<? super TribeeSteamStateAction, Unit> function1, Composer $composer, final int $changed, final int i) {
        boolean z;
        boolean isUpdating2;
        boolean isSharing2;
        Function1 onStateAction;
        Composer $composer2;
        Modifier modifier2;
        boolean isMaster2;
        boolean isUpdating3;
        Modifier modifier3;
        boolean isMaster3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        RowScope $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240;
        String str;
        String str2;
        String str3;
        Composer $composer$iv$iv;
        String str4;
        boolean isSharing3;
        String str5;
        Function1 onStateAction2;
        Object it$iv;
        Function0 factory$iv$iv$iv4;
        int it;
        KTribeeSteamHomeDataItem value;
        RowScope $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u242;
        boolean z2;
        int $changed$iv$iv$iv;
        String str6;
        String str7;
        boolean z3;
        MeasurePolicy measurePolicy$iv$iv;
        boolean z4;
        Function0 factory$iv$iv$iv5;
        Modifier rotationModifier;
        final Function1 onStateAction3;
        Function0 factory$iv$iv$iv6;
        Composer $composer3 = $composer.startRestartGroup(-5525839);
        ComposerKt.sourceInformation($composer3, "C(TribeeSteamAccountInfo)N(info,modifier,isMaster,isUpdating,isSharing,onStateAction)69@3024L2:TribeeSteamAccountInfo.kt#k3l5ii");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(info) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(modifier) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            z = isMaster;
        } else if (($changed & 384) == 0) {
            z = isMaster;
            $dirty |= $composer3.changed(z) ? 256 : 128;
        } else {
            z = isMaster;
        }
        int i4 = i & 8;
        if (i4 != 0) {
            $dirty |= 3072;
            isUpdating2 = isUpdating;
        } else if (($changed & 3072) == 0) {
            isUpdating2 = isUpdating;
            $dirty |= $composer3.changed(isUpdating2) ? 2048 : 1024;
        } else {
            isUpdating2 = isUpdating;
        }
        int i5 = i & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            isSharing2 = isSharing;
        } else if (($changed & 24576) == 0) {
            isSharing2 = isSharing;
            $dirty |= $composer3.changed(isSharing2) ? 16384 : 8192;
        } else {
            isSharing2 = isSharing;
        }
        int i6 = i & 32;
        if (i6 != 0) {
            $dirty |= 196608;
            onStateAction = function1;
        } else if ((196608 & $changed) == 0) {
            onStateAction = function1;
            $dirty |= $composer3.changedInstance(onStateAction) ? 131072 : 65536;
        } else {
            onStateAction = function1;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute((74899 & $dirty2) != 74898, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            isMaster2 = z;
            isUpdating3 = isUpdating2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier;
            }
            if (i3 == 0) {
                isMaster3 = z;
            } else {
                isMaster3 = false;
            }
            if (i4 != 0) {
                isUpdating2 = false;
            }
            if (i5 != 0) {
                isSharing2 = false;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1015355789, "CC(remember):TribeeSteamAccountInfo.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function1() { // from class: kntr.app.tribee.steam.page.TribeeSteamAccountInfoKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj) {
                            Unit TribeeSteamAccountInfo$lambda$0$0;
                            TribeeSteamAccountInfo$lambda$0$0 = TribeeSteamAccountInfoKt.TribeeSteamAccountInfo$lambda$0$0((TribeeSteamStateAction) obj);
                            return TribeeSteamAccountInfo$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv2 = value$iv;
                }
                Function1 onStateAction4 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                onStateAction = onStateAction4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-5525839, $dirty2, -1, "kntr.app.tribee.steam.page.TribeeSteamAccountInfo (TribeeSteamAccountInfo.kt:70)");
            }
            if (info == null) {
                $composer3.startReplaceGroup(-1411216721);
                ComposerKt.sourceInformation($composer3, "79@3325L6,72@3064L370");
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(SizeKt.height-3ABfNKs(PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(24), 0.0f, Dp.constructor-impl(32), 5, (Object) null), Dp.constructor-impl(129)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), $composer3, 0);
                $composer3.endReplaceGroup();
                modifier2 = modifier3;
                isMaster2 = isMaster3;
                isUpdating3 = isUpdating2;
                $composer2 = $composer3;
                isSharing3 = isSharing2;
                onStateAction2 = onStateAction;
            } else {
                $composer3.startReplaceGroup(-1410586181);
                ComposerKt.sourceInformation($composer3, "84@3456L8166");
                Modifier modifier$iv = ClipKt.clip(SizeKt.wrapContentHeight$default(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), (Alignment.Vertical) null, false, 3, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)));
                ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (0 << 3) & 112;
                modifier2 = modifier3;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv << 6) & 896) | 6;
                Function1 onStateAction5 = onStateAction;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer3.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv7;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                isUpdating3 = isUpdating2;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                int i8 = ((0 >> 6) & 112) | 6;
                BoxScope $this$TribeeSteamAccountInfo_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -1914875260, "C91@3691L137,94@3841L370,106@4225L566,121@4805L6807:TribeeSteamAccountInfo.kt#k3l5ii");
                ComposerKt.sourceInformationMarkerStart($composer3, 769506628, "CC(remember):TribeeSteamAccountInfo.kt#9igjgp");
                boolean invalid$iv = $composer3.changed(info);
                Object it$iv3 = $composer3.rememberedValue();
                if (!invalid$iv && it$iv3 != Composer.Companion.getEmpty()) {
                    MutableState shadowColor$delegate = (MutableState) it$iv3;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    String $this$asRequest$iv = info.getBgImage();
                    ImageRequest $this$TribeeSteamAccountInfo_u24lambda_u241_u242 = new ImageRequest($this$asRequest$iv);
                    $this$TribeeSteamAccountInfo_u24lambda_u241_u242.contentScale(ContentScale.Companion.getCrop());
                    BiliImageKt.BiliImage($this$TribeeSteamAccountInfo_u24lambda_u241_u242.build(), $this$TribeeSteamAccountInfo_u24lambda_u241.matchParentSize(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), "game background", null, null, null, null, null, null, $composer3, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                    SpacerKt.Spacer(BackgroundKt.background$default($this$TribeeSteamAccountInfo_u24lambda_u241.matchParentSize(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(TribeeSteamAccountInfo$lambda$1$1(shadowColor$delegate)), Color.box-impl(Color.copy-wmQWz5c$default(TribeeSteamAccountInfo$lambda$1$1(shadowColor$delegate), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), Float.POSITIVE_INFINITY, 0.0f, 0, 8, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                    Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(7), 0.0f, Dp.constructor-impl(16), 5, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    int $i$f$Column = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, $i$f$Column);
                    int $changed$iv$iv2 = (6 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                    $composer2 = $composer3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv8;
                        $composer3.createNode(factory$iv$iv$iv2);
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv8;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                    int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i10 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 479982340, "C128@5056L4391,225@9522L6,224@9465L218,230@9718L29,232@9807L79,235@9903L1695:TribeeSteamAccountInfo.kt#k3l5ii");
                    Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv3 = (390 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                    Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer3.createNode(factory$iv$iv$iv3);
                    } else {
                        factory$iv$iv$iv3 = factory$iv$iv$iv9;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                    int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    int i12 = ((390 >> 6) & 112) | 6;
                    $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -417791102, "C132@5225L345,141@5592L248:TribeeSteamAccountInfo.kt#k3l5ii");
                    String $this$asRequest_u24default$iv = info.getTitlePicUrl();
                    ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
                    Unit unit = Unit.INSTANCE;
                    BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), "steam icon", null, null, null, null, null, null, $composer3, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                    TextKt.Text-Nvy7gAk(info.getTitle(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 25008, 0, 262120);
                    if (!isSharing2 && isMaster3) {
                        $composer3.startReplaceGroup(-417187316);
                        ComposerKt.sourceInformation($composer3, "151@5990L56,150@5949L513");
                        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_25(TribeeRes.INSTANCE.getString()), $composer3, 0) + info.getSyncTimeText(), RowScope.-CC.weight$default($this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null), 1.0f, false, 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 0, 261096);
                        $composer3.endReplaceGroup();
                    } else {
                        $composer3.startReplaceGroup(-416626681);
                        ComposerKt.sourceInformation($composer3, "161@6516L454");
                        TextKt.Text-Nvy7gAk(info.getSyncTimeText(), RowScope.-CC.weight$default($this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null), 1.0f, false, 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 0, 261096);
                        $composer3.endReplaceGroup();
                    }
                    if (isMaster3 || isSharing2) {
                        isMaster2 = isMaster3;
                        str = "CC(remember):TribeeSteamAccountInfo.kt#9igjgp";
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $composer$iv$iv = $composer3;
                        str4 = "C101@5233L9:Row.kt#2w3rfo";
                        isSharing3 = isSharing2;
                        str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        onStateAction2 = onStateAction5;
                        $composer3.startReplaceGroup(-423105619);
                    } else {
                        $composer3.startReplaceGroup(-416000760);
                        ComposerKt.sourceInformation($composer3, "185@7579L39,187@7729L225,181@7386L2021");
                        if (isUpdating3) {
                            $composer3.startReplaceGroup(-415978254);
                            ComposerKt.sourceInformation($composer3, "177@7224L18");
                            rotationModifier = infiniteRotation(Modifier.Companion, $composer3, 6);
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-415882278);
                            $composer3.endReplaceGroup();
                            rotationModifier = RotateKt.rotate(Modifier.Companion, 0.0f);
                        }
                        Modifier modifier4 = Modifier.Companion;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1510614684, "CC(remember):TribeeSteamAccountInfo.kt#9igjgp");
                        Object it$iv4 = $composer3.rememberedValue();
                        if (it$iv4 == Composer.Companion.getEmpty()) {
                            Object value$iv2 = InteractionSourceKt.MutableInteractionSource();
                            $composer3.updateRememberedValue(value$iv2);
                            it$iv4 = value$iv2;
                        }
                        MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) it$iv4;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerStart($composer3, 1510619670, "CC(remember):TribeeSteamAccountInfo.kt#9igjgp");
                        boolean invalid$iv2 = ($dirty2 & 458752) == 131072;
                        Object it$iv5 = $composer3.rememberedValue();
                        if (!invalid$iv2 && it$iv5 != Composer.Companion.getEmpty()) {
                            isMaster2 = isMaster3;
                            onStateAction3 = onStateAction5;
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifier$iv4 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null);
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                            onStateAction2 = onStateAction3;
                            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                            isSharing3 = isSharing2;
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv4 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                            str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                            str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                            str = "CC(remember):TribeeSteamAccountInfo.kt#9igjgp";
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if (!$composer3.getInserting()) {
                                factory$iv$iv$iv6 = factory$iv$iv$iv10;
                                $composer3.createNode(factory$iv$iv$iv6);
                            } else {
                                factory$iv$iv$iv6 = factory$iv$iv$iv10;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer3);
                            str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                            $composer$iv$iv = $composer3;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
                            int i13 = ($changed$iv$iv$iv5 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i14 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 985229138, "C200@8450L6,194@8127L390,204@8608L22,205@8681L6,203@8547L401,213@9023L56,218@9333L6,212@8978L403:TribeeSteamAccountInfo.kt#k3l5ii");
                            str4 = "C101@5233L9:Row.kt#2w3rfo";
                            DividerKt.VerticalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null), Dp.constructor-impl((float) 0.5d), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, 54, 0);
                            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer3, 6), "refresh icon", SizeKt.size-3ABfNKs(rotationModifier, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                            TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_26(TribeeRes.INSTANCE.getString()), $composer3, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 0, 262120);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                        }
                        isMaster2 = isMaster3;
                        onStateAction3 = onStateAction5;
                        Object value$iv3 = new Function0() { // from class: kntr.app.tribee.steam.page.TribeeSteamAccountInfoKt$$ExternalSyntheticLambda1
                            public final Object invoke() {
                                Unit TribeeSteamAccountInfo$lambda$1$3$0$1$0;
                                TribeeSteamAccountInfo$lambda$1$3$0$1$0 = TribeeSteamAccountInfoKt.TribeeSteamAccountInfo$lambda$1$3$0$1$0(onStateAction3);
                                return TribeeSteamAccountInfo$lambda$1$3$0$1$0;
                            }
                        };
                        $composer3.updateRememberedValue(value$iv3);
                        it$iv5 = value$iv3;
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Modifier modifier$iv42 = ClickableKt.clickable-O2vRcR0$default(modifier4, mutableInteractionSource, (Indication) null, false, (String) null, (Role) null, (Function0) it$iv5, 28, (Object) null);
                        Alignment.Vertical verticalAlignment$iv22 = Alignment.Companion.getCenterVertically();
                        onStateAction2 = onStateAction3;
                        ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        Arrangement.Horizontal horizontalArrangement$iv22 = Arrangement.INSTANCE.getStart();
                        isSharing3 = isSharing2;
                        MeasurePolicy measurePolicy$iv42 = RowKt.rowMeasurePolicy(horizontalArrangement$iv22, verticalAlignment$iv22, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv42 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv42 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv42 = $composer3.getCurrentCompositionLocalMap();
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        Modifier materialized$iv$iv42 = ComposedModifierKt.materializeModifier($composer3, modifier$iv42);
                        Function0 factory$iv$iv$iv102 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv52 = (($changed$iv$iv42 << 6) & 896) | 6;
                        str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                        str = "CC(remember):TribeeSteamAccountInfo.kt#9igjgp";
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                        }
                        $composer3.startReusableNode();
                        if (!$composer3.getInserting()) {
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv42 = Updater.constructor-impl($composer3);
                        str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                        $composer$iv$iv = $composer3;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, measurePolicy$iv42, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, localMap$iv$iv42, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv42, Integer.valueOf(compositeKeyHash$iv$iv42), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv42, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv42, materialized$iv$iv42, ComposeUiNode.Companion.getSetModifier());
                        int i132 = ($changed$iv$iv$iv52 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                        RowScope rowScope2 = RowScopeInstance.INSTANCE;
                        int i142 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 985229138, "C200@8450L6,194@8127L390,204@8608L22,205@8681L6,203@8547L401,213@9023L56,218@9333L6,212@8978L403:TribeeSteamAccountInfo.kt#k3l5ii");
                        str4 = "C101@5233L9:Row.kt#2w3rfo";
                        DividerKt.VerticalDivider-9IZ8Weo(PaddingKt.padding-qDBjuR0$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), 0.0f, 0.0f, Dp.constructor-impl(4), 0.0f, 11, (Object) null), Dp.constructor-impl((float) 0.5d), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, 54, 0);
                        IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_refresh_line_500($composer3, 6), "refresh icon", SizeKt.size-3ABfNKs(rotationModifier, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), $composer3, Painter.$stable | 48, 0);
                        TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_global_string_26(TribeeRes.INSTANCE.getString()), $composer3, 0), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(2), 0.0f, 0.0f, 0.0f, 14, (Object) null), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24624, 0, 262120);
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
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 1, (Object) null), Dp.constructor-impl((float) 0.5d), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, 54, 0);
                    Font numberFont = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14);
                    ComposerKt.sourceInformationMarkerStart($composer3, 1955291520, str);
                    it$iv = $composer3.rememberedValue();
                    if (it$iv == Composer.Companion.getEmpty()) {
                        Object value$iv4 = FontFamilyKt.FontFamily(new Font[]{numberFont});
                        $composer3.updateRememberedValue(value$iv4);
                        it$iv = value$iv4;
                    }
                    FontFamily numberFontFamily = (FontFamily) it$iv;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv5 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(11), 0.0f, 0.0f, 13, (Object) null);
                    boolean z5 = true;
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, str5);
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getStart();
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                    int $changed$iv$iv5 = (6 << 3) & 112;
                    MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv5;
                    boolean z6 = false;
                    String str8 = str2;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str8);
                    int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv5);
                    Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
                    String str9 = str3;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str9);
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer3.createNode(factory$iv$iv$iv4);
                    } else {
                        factory$iv$iv$iv4 = factory$iv$iv$iv11;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                    int i15 = ($changed$iv$iv$iv6 >> 6) & 14;
                    boolean z7 = false;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, str4);
                    int i16 = ((6 >> 6) & 112) | 6;
                    RowScope $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u2422 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 852017654, "C:TribeeSteamAccountInfo.kt#k3l5ii");
                    $composer3.startReplaceGroup(720221101);
                    ComposerKt.sourceInformation($composer3, "");
                    it = 0;
                    while (it < 3) {
                        switch (it) {
                            case 0:
                                value = info.getValue();
                                break;
                            case 1:
                                value = info.getTime();
                                break;
                            case 2:
                                value = info.getCount();
                                break;
                            default:
                                value = null;
                                break;
                        }
                        KTribeeSteamHomeDataItem item = value;
                        if (item != null) {
                            $composer3.startReplaceGroup(2047526454);
                            ComposerKt.sourceInformation($composer3, "250@10484L1048");
                            Modifier modifier$iv6 = RowScope.-CC.weight$default($this$TribeeSteamAccountInfo_u24lambda_u241_u243_u2422, Modifier.Companion, 1.0f, false, 2, (Object) null);
                            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getCenterHorizontally();
                            $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u242 = $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u2422;
                            z2 = z5;
                            $changed$iv$iv$iv = $changed$iv$iv$iv6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                            z3 = z7;
                            MeasurePolicy measurePolicy$iv6 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv6 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str8);
                            int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv6 = $composer3.getCurrentCompositionLocalMap();
                            str7 = str8;
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer3, modifier$iv6);
                            Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str9);
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                                $composer3.createNode(factory$iv$iv$iv5);
                            } else {
                                factory$iv$iv$iv5 = factory$iv$iv$iv12;
                                $composer3.useNode();
                            }
                            str6 = str9;
                            Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer3);
                            z4 = z6;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                            int i17 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
                            int i18 = ((384 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1689383334, "C256@10817L6,254@10704L339,263@11190L6,261@11076L426:TribeeSteamAccountInfo.kt#k3l5ii");
                            TextKt.Text-Nvy7gAk(item.getNum(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 24576, 24960, 241642);
                            TextKt.Text-Nvy7gAk(item.getUnit(), (Modifier) null, Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, numberFontFamily, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, (TextStyle) null, $composer3, 12607488, 24960, 241514);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                        } else {
                            $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u242 = $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u2422;
                            z2 = z5;
                            $changed$iv$iv$iv = $changed$iv$iv$iv6;
                            str6 = str9;
                            str7 = str8;
                            z3 = z7;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            z4 = z6;
                            $composer3.startReplaceGroup(2037120870);
                        }
                        $composer3.endReplaceGroup();
                        it++;
                        measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                        z7 = z3;
                        $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u2422 = $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u242;
                        z5 = z2;
                        $changed$iv$iv$iv6 = $changed$iv$iv$iv;
                        str8 = str7;
                        z6 = z4;
                        str9 = str6;
                    }
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
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer2.endReplaceGroup();
                }
                String it2 = info.getBgColor();
                if (StringsKt.isBlank(it2)) {
                    it2 = null;
                }
                Object value$iv5 = SnapshotStateKt.mutableStateOf$default(Color.box-impl(it2 != null ? ComposeColorParserKt.parseColor(it2) : ColorKt.Color(4278852160L)), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv5);
                it$iv3 = value$iv5;
                MutableState shadowColor$delegate2 = (MutableState) it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                String $this$asRequest$iv2 = info.getBgImage();
                ImageRequest $this$TribeeSteamAccountInfo_u24lambda_u241_u2422 = new ImageRequest($this$asRequest$iv2);
                $this$TribeeSteamAccountInfo_u24lambda_u241_u2422.contentScale(ContentScale.Companion.getCrop());
                BiliImageKt.BiliImage($this$TribeeSteamAccountInfo_u24lambda_u241_u2422.build(), $this$TribeeSteamAccountInfo_u24lambda_u241.matchParentSize(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), "game background", null, null, null, null, null, null, $composer3, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                SpacerKt.Spacer(BackgroundKt.background$default($this$TribeeSteamAccountInfo_u24lambda_u241.matchParentSize(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null)), Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(TribeeSteamAccountInfo$lambda$1$1(shadowColor$delegate2)), Color.box-impl(Color.copy-wmQWz5c$default(TribeeSteamAccountInfo$lambda$1$1(shadowColor$delegate2), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null))}), Float.POSITIVE_INFINITY, 0.0f, 0, 8, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer3, 0);
                Modifier modifier$iv22 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, Dp.constructor-impl(7), 0.0f, Dp.constructor-impl(16), 5, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                int $i$f$Column2 = ((6 >> 3) & 14) | ((6 >> 3) & 112);
                MeasurePolicy measurePolicy$iv22 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer3, $i$f$Column2);
                int $changed$iv$iv22 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
                Function0 factory$iv$iv$iv82 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv32 = (($changed$iv$iv22 << 6) & 896) | 6;
                $composer2 = $composer3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                int i92 = ($changed$iv$iv$iv32 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope3 = ColumnScopeInstance.INSTANCE;
                int i102 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 479982340, "C128@5056L4391,225@9522L6,224@9465L218,230@9718L29,232@9807L79,235@9903L1695:TribeeSteamAccountInfo.kt#k3l5ii");
                Modifier modifier$iv32 = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Alignment.Vertical verticalAlignment$iv4 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv32 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                int $changed$iv$iv32 = (390 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv32 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv32 = ComposedModifierKt.materializeModifier($composer3, modifier$iv32);
                Function0 factory$iv$iv$iv92 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv42 = (($changed$iv$iv32 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv32 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, measurePolicy$iv32, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, localMap$iv$iv32, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv32, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv32, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv32, materialized$iv$iv32, ComposeUiNode.Companion.getSetModifier());
                int i112 = ($changed$iv$iv$iv42 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                int i122 = ((390 >> 6) & 112) | 6;
                $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, -417791102, "C132@5225L345,141@5592L248:TribeeSteamAccountInfo.kt#k3l5ii");
                String $this$asRequest_u24default$iv2 = info.getTitlePicUrl();
                ImageRequest imageRequest2 = new ImageRequest($this$asRequest_u24default$iv2);
                Unit unit2 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest2.build(), ClipKt.clip(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2))), "steam icon", null, null, null, null, null, null, $composer3, 384, InitGMultiDomainKt.HTTP_CODE_GATEWAY_TIMEOUT);
                TextKt.Text-Nvy7gAk(info.getTitle(), PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(6), 0.0f, 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 25008, 0, 262120);
                if (!isSharing2) {
                }
                $composer3.startReplaceGroup(-416626681);
                ComposerKt.sourceInformation($composer3, "161@6516L454");
                TextKt.Text-Nvy7gAk(info.getSyncTimeText(), RowScope.-CC.weight$default($this$TribeeSteamAccountInfo_u24lambda_u241_u243_u240, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, Dp.constructor-impl(8), 0.0f, Dp.constructor-impl(4), 0.0f, 10, (Object) null), 1.0f, false, 2, (Object) null), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getEnd-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, 24960, 0, 261096);
                $composer3.endReplaceGroup();
                if (isMaster3) {
                }
                isMaster2 = isMaster3;
                str = "CC(remember):TribeeSteamAccountInfo.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str3 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv = $composer3;
                str4 = "C101@5233L9:Row.kt#2w3rfo";
                isSharing3 = isSharing2;
                str5 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                onStateAction2 = onStateAction5;
                $composer3.startReplaceGroup(-423105619);
                $composer3.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                DividerKt.HorizontalDivider-9IZ8Weo(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(6), 1, (Object) null), Dp.constructor-impl((float) 0.5d), Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText_white-0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), $composer3, 54, 0);
                Font numberFont2 = FontResources_androidKt.Font-r4zq5rk(Font0_commonMainKt.getXx_bin_Regular(Res.font.INSTANCE), (FontWeight) null, 0, (FontVariation.Settings) null, $composer3, 0, 14);
                ComposerKt.sourceInformationMarkerStart($composer3, 1955291520, str);
                it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                }
                FontFamily numberFontFamily2 = (FontFamily) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier$iv52 = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(11), 0.0f, 0.0f, 13, (Object) null);
                boolean z52 = true;
                ComposerKt.sourceInformationMarkerStart($composer3, 844473419, str5);
                Arrangement.Horizontal horizontalArrangement$iv32 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv32 = Alignment.Companion.getTop();
                MeasurePolicy measurePolicy$iv52 = RowKt.rowMeasurePolicy(horizontalArrangement$iv32, verticalAlignment$iv32, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                int $changed$iv$iv52 = (6 << 3) & 112;
                MeasurePolicy measurePolicy$iv$iv22 = measurePolicy$iv52;
                boolean z62 = false;
                String str82 = str2;
                ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str82);
                int compositeKeyHash$iv$iv52 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                CompositionLocalMap localMap$iv$iv52 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv52 = ComposedModifierKt.materializeModifier($composer3, modifier$iv52);
                Function0 factory$iv$iv$iv112 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv62 = (($changed$iv$iv52 << 6) & 896) | 6;
                String str92 = str3;
                ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str92);
                if (!($composer3.getApplier() instanceof Applier)) {
                }
                $composer3.startReusableNode();
                if (!$composer3.getInserting()) {
                }
                Composer $this$Layout_u24lambda_u240$iv$iv52 = Updater.constructor-impl($composer3);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, measurePolicy$iv$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, localMap$iv$iv52, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv52, Integer.valueOf(compositeKeyHash$iv$iv52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv52, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv52, materialized$iv$iv52, ComposeUiNode.Companion.getSetModifier());
                int i152 = ($changed$iv$iv$iv62 >> 6) & 14;
                boolean z72 = false;
                ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, str4);
                int i162 = ((6 >> 6) & 112) | 6;
                RowScope $this$TribeeSteamAccountInfo_u24lambda_u241_u243_u24222 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer3, 852017654, "C:TribeeSteamAccountInfo.kt#k3l5ii");
                $composer3.startReplaceGroup(720221101);
                ComposerKt.sourceInformation($composer3, "");
                it = 0;
                while (it < 3) {
                }
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
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onStateAction = onStateAction2;
            isSharing2 = isSharing3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier2;
            final boolean z8 = isMaster2;
            final boolean z9 = isUpdating3;
            final boolean z10 = isSharing2;
            final Function1 function12 = onStateAction;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.steam.page.TribeeSteamAccountInfoKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeSteamAccountInfo$lambda$2;
                    TribeeSteamAccountInfo$lambda$2 = TribeeSteamAccountInfoKt.TribeeSteamAccountInfo$lambda$2(info, modifier5, z8, z9, z10, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeSteamAccountInfo$lambda$2;
                }
            });
        }
    }

    private static final long TribeeSteamAccountInfo$lambda$1$1(MutableState<Color> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Color) $this$getValue$iv.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeSteamAccountInfo$lambda$1$3$0$1$0(Function1 $onStateAction) {
        SteamTrackerKt.reportSteamPageClick("update");
        $onStateAction.invoke(new TribeeSteamStateAction.LaunchPolling(1));
        return Unit.INSTANCE;
    }

    public static final Modifier infiniteRotation(Modifier $this$infiniteRotation, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$infiniteRotation, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -385019796, "C(infiniteRotation):TribeeSteamAccountInfo.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-385019796, $changed, -1, "kntr.app.tribee.steam.page.infiniteRotation (TribeeSteamAccountInfo.kt:280)");
        }
        Modifier composed$default = ComposedModifierKt.composed$default($this$infiniteRotation, (Function1) null, new Function3() { // from class: kntr.app.tribee.steam.page.TribeeSteamAccountInfoKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Modifier infiniteRotation$lambda$0;
                infiniteRotation$lambda$0 = TribeeSteamAccountInfoKt.infiniteRotation$lambda$0((Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
                return infiniteRotation$lambda$0;
            }
        }, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return composed$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier infiniteRotation$lambda$0(Modifier $this$composed, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(1228558244);
        ComposerKt.sourceInformation($composer, "C281@11736L28,282@11808L307:TribeeSteamAccountInfo.kt#k3l5ii");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1228558244, $changed, -1, "kntr.app.tribee.steam.page.infiniteRotation.<anonymous> (TribeeSteamAccountInfo.kt:281)");
        }
        InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition((String) null, $composer, 0, 1);
        State rotation$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 360.0f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default((int) MediaAttrUtils.TYPE_PAY_SEASON, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), (String) null, $composer, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 9), 8);
        Modifier rotate = RotateKt.rotate($this$composed, infiniteRotation$lambda$0$0(rotation$delegate));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return rotate;
    }

    private static final float infiniteRotation$lambda$0$0(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }
}