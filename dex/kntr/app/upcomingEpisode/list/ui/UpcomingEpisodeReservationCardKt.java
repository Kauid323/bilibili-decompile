package kntr.app.upcomingEpisode.list.ui;

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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import bili.resource.watching.Res;
import bili.resource.watching.String0_commonMainKt;
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveCardInfo;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeExtensionsKt;
import kntr.app.upcomingEpisode.list.utils.UpcomingEpisodeUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: UpcomingEpisodeReservationCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u001ao\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0007¢\u0006\u0002\u0010\u0010\u001aC\u0010\u0011\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\r2\u0006\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"UpcomingEpisodeReservationCard", "", "upInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "reserveCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveCardInfo;", "modifier", "Landroidx/compose/ui/Modifier;", "reservedCount", "", "isReserved", "", "onAuthorLayoutClick", "Lkotlin/Function0;", "onReservationClick", "onCancelReservationClick", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveCardInfo;Landroidx/compose/ui/Modifier;JZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "UpcomingEpisodeReservationContent", "reservationTitle", "", "reservationCount", "(Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "main_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeReservationCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeReservationCard$lambda$4(KUpInfo kUpInfo, KReserveCardInfo kReserveCardInfo, Modifier modifier, long j, boolean z, Function0 function0, Function0 function02, Function0 function03, int i, int i2, Composer composer, int i3) {
        UpcomingEpisodeReservationCard(kUpInfo, kReserveCardInfo, modifier, j, z, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeReservationContent$lambda$1(String str, long j, Function0 function0, Function0 function02, boolean z, int i, Composer composer, int i2) {
        UpcomingEpisodeReservationContent(str, j, function0, function02, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r7v14 */
    public static final void UpcomingEpisodeReservationCard(final KUpInfo upInfo, final KReserveCardInfo reserveCardInfo, Modifier modifier, long reservedCount, boolean isReserved, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Composer $composer, final int $changed, final int i) {
        boolean z;
        Function0 function04;
        Modifier modifier2;
        long reservedCount2;
        Function0 onReservationClick;
        boolean isReserved2;
        Function0 onAuthorLayoutClick;
        Function0 onCancelReservationClick;
        Function0 onCancelReservationClick2;
        Composer $composer2 = $composer.startRestartGroup(633477105);
        ComposerKt.sourceInformation($composer2, "C(UpcomingEpisodeReservationCard)N(upInfo,reserveCardInfo,modifier,reservedCount,isReserved,onAuthorLayoutClick,onReservationClick,onCancelReservationClick)54@2476L2,55@2517L2,56@2564L2,66@2846L6,65@2791L80,68@2879L959,58@2576L1262:UpcomingEpisodeReservationCard.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(upInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(reserveCardInfo) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(modifier) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(reservedCount) ? 2048 : 1024;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            z = isReserved;
        } else if (($changed & 24576) == 0) {
            z = isReserved;
            $dirty |= $composer2.changed(z) ? 16384 : 8192;
        } else {
            z = isReserved;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            function04 = function0;
        } else if ((196608 & $changed) == 0) {
            function04 = function0;
            $dirty |= $composer2.changedInstance(function04) ? 131072 : 65536;
        } else {
            function04 = function0;
        }
        int i6 = i & 64;
        if (i6 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 1572864) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 1048576 : 524288;
        }
        int i7 = i & 128;
        if (i7 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function03) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            reservedCount2 = i3 != 0 ? 0L : reservedCount;
            isReserved2 = i4 != 0 ? false : z;
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1113850637, "CC(remember):UpcomingEpisodeReservationCard.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onAuthorLayoutClick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onAuthorLayoutClick = onAuthorLayoutClick2;
            } else {
                onAuthorLayoutClick = function04;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1113849325, "CC(remember):UpcomingEpisodeReservationCard.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onReservationClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onReservationClick = onReservationClick2;
            } else {
                onReservationClick = function02;
            }
            if (i7 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1113847821, "CC(remember):UpcomingEpisodeReservationCard.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                onCancelReservationClick2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onCancelReservationClick2 = function03;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(633477105, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCard (UpcomingEpisodeReservationCard.kt:57)");
            }
            final Function0 function05 = onAuthorLayoutClick;
            final long j = reservedCount2;
            final Function0 function06 = onReservationClick;
            final Function0 function07 = onCancelReservationClick2;
            final boolean z2 = isReserved2;
            modifier2 = modifier3;
            CardKt.Card(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, (Object) null), Dp.constructor-impl((float) ConstantsKt.RESERVATION_CARD_HEIGHT)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), CardDefaults.INSTANCE.cardColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg2-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1787967551, true, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit UpcomingEpisodeReservationCard$lambda$3;
                    UpcomingEpisodeReservationCard$lambda$3 = UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard$lambda$3(upInfo, function05, reserveCardInfo, j, function06, function07, z2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodeReservationCard$lambda$3;
                }
            }, $composer2, 54), $composer2, 196608, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onCancelReservationClick = onCancelReservationClick2;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            reservedCount2 = reservedCount;
            onReservationClick = function02;
            isReserved2 = z;
            onAuthorLayoutClick = function04;
            onCancelReservationClick = function03;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final long j2 = reservedCount2;
            final boolean z3 = isReserved2;
            final Function0 function08 = onAuthorLayoutClick;
            final Function0 function09 = onReservationClick;
            final Function0 function010 = onCancelReservationClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeReservationCard$lambda$4;
                    UpcomingEpisodeReservationCard$lambda$4 = UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationCard$lambda$4(upInfo, reserveCardInfo, modifier4, j2, z3, function08, function09, function010, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeReservationCard$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeReservationCard$lambda$3(KUpInfo $upInfo, Function0 $onAuthorLayoutClick, KReserveCardInfo $reserveCardInfo, long $reservedCount, Function0 $onReservationClick, Function0 $onCancelReservationClick, boolean $isReserved, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C69@2889L943:UpcomingEpisodeReservationCard.kt#kr57tx");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1787967551, $changed, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCard.<anonymous> (UpcomingEpisodeReservationCard.kt:69)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl(8), Dp.constructor-impl(12), Dp.constructor-impl(12));
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
            int i2 = ((0 >> 6) & 112) | 6;
            ColumnScope $this$UpcomingEpisodeReservationCard_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1938579542, "C85@3425L6,81@3242L269,88@3524L47,89@3584L238:UpcomingEpisodeReservationCard.kt#kr57tx");
            UpcomingEpisodeUtilsKt.m1310SetUpIconNamewC_cr3g($upInfo != null ? $upInfo.getAvatar() : null, $upInfo != null ? $upInfo.getName() : null, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), $onAuthorLayoutClick, ColumnScope.-CC.weight$default($this$UpcomingEpisodeReservationCard_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, $composer, 0, 32);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(9)), $composer, 6);
            UpcomingEpisodeReservationContent($reserveCardInfo != null ? $reserveCardInfo.getTitle() : null, $reservedCount, $onReservationClick, $onCancelReservationClick, $isReserved, $composer, 0);
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

    private static final void UpcomingEpisodeReservationContent(final String reservationTitle, final long reservationCount, final Function0<Unit> function0, final Function0<Unit> function02, final boolean isReserved, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer$iv$iv$iv;
        Composer $composer$iv$iv;
        Composer $composer3;
        Composer $composer$iv$iv2;
        String str;
        Composer $composer$iv$iv3;
        Composer $composer$iv;
        Composer $composer4;
        int $dirty;
        String str2;
        Composer $composer$iv$iv$iv2;
        Composer $composer$iv2;
        String str3;
        Composer $composer$iv3;
        Composer $composer$iv4;
        String str4;
        Composer $composer$iv$iv$iv3;
        long buttonColor;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        Composer $composer5;
        Composer $composer6 = $composer.startRestartGroup(-1262770919);
        ComposerKt.sourceInformation($composer6, "C(UpcomingEpisodeReservationContent)N(reservationTitle,reservationCount,onReservationClick,onCancelReservationClick,isReserved)114@4289L6,108@4071L4061:UpcomingEpisodeReservationCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer6.changed(reservationTitle) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer6.changed(reservationCount) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer6.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer6.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty2 |= $composer6.changed(isReserved) ? 16384 : 8192;
        }
        if ($composer6.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1262770919, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationContent (UpcomingEpisodeReservationCard.kt:107)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(60)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getBg1_float-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl((float) 9.5d), Dp.constructor-impl(12), Dp.constructor-impl((float) 9.5d));
            ComposerKt.sourceInformationMarkerStart($composer6, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer6, modifier$iv);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer6.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv5;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 920935005, "C122@4523L3603:UpcomingEpisodeReservationCard.kt#kr57tx");
            int $dirty3 = $dirty2;
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer6, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer6, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer6, modifier$iv2);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer6.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((390 >> 6) & 112) | 6;
            RowScope $this$UpcomingEpisodeReservationContent_u24lambda_u240_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer6, -227048, "C128@4696L974,152@5683L39,166@6299L252,159@5942L2174:UpcomingEpisodeReservationCard.kt#kr57tx");
            Modifier modifier$iv3 = $this$UpcomingEpisodeReservationContent_u24lambda_u240_u240.align(RowScope.-CC.weight$default($this$UpcomingEpisodeReservationContent_u24lambda_u240_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer6, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer6, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer6, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer6, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer6.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer6, modifier$iv3);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer6.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer6.startReusableNode();
            if ($composer6.getInserting()) {
                $composer6.createNode(factory$iv$iv$iv7);
            } else {
                $composer6.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer6);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer6, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer6, 1603698154, "C144@5293L40,146@5419L59,147@5518L9,149@5625L6,145@5350L306:UpcomingEpisodeReservationCard.kt#kr57tx");
            if (reservationTitle == null) {
                $composer6.startReplaceGroup(1603703670);
                $composer6.endReplaceGroup();
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv2 = $composer6;
                $composer$iv2 = $composer6;
                str = "C72@3469L9:Box.kt#2w3rfo";
                $composer$iv$iv$iv3 = $composer6;
                $composer$iv$iv$iv = $composer6;
                $dirty = $dirty3;
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer$iv3 = $composer6;
                $composer3 = $composer6;
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer4 = $composer6;
                $composer$iv = $composer6;
                $composer$iv$iv2 = $composer6;
                $composer$iv4 = $composer6;
                $composer$iv$iv = $composer6;
                $composer2 = $composer6;
                $composer$iv$iv3 = $composer6;
            } else {
                $composer6.startReplaceGroup(1603703671);
                ComposerKt.sourceInformation($composer6, "*137@5015L9,140@5169L6,135@4932L326");
                $composer$iv$iv$iv = $composer6;
                $composer$iv$iv = $composer6;
                $composer3 = $composer6;
                $composer$iv$iv2 = $composer6;
                str = "C72@3469L9:Box.kt#2w3rfo";
                $composer$iv$iv3 = $composer6;
                $composer$iv = $composer6;
                $composer4 = $composer6;
                $dirty = $dirty3;
                str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer$iv$iv$iv2 = $composer6;
                $composer$iv2 = $composer6;
                str3 = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                $composer$iv3 = $composer6;
                $composer$iv4 = $composer6;
                $composer2 = $composer6;
                str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                $composer$iv$iv$iv3 = $composer6;
                TextKt.Text-Nvy7gAk(reservationTitle, (Modifier) null, BiliTheme.INSTANCE.getColors($composer6, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, new FontWeight(500), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer6, BiliTheme.$stable).getT14b(), $composer$iv, 1572864, 24960, 110522);
                Unit unit = Unit.INSTANCE;
                $composer$iv.endReplaceGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            Composer $composer7 = $composer$iv;
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer7, 6);
            TextKt.Text-Nvy7gAk(UpcomingEpisodeExtensionsKt.readableString(reservationCount) + StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_5(Res.string.INSTANCE), $composer7, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer7, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer7, BiliTheme.$stable).getT12(), $composer7, 0, 384, 126970);
            ComposerKt.sourceInformationMarkerEnd($composer7);
            ComposerKt.sourceInformationMarkerEnd($composer$iv2);
            $composer$iv$iv$iv3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Composer $composer8 = $composer3;
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer8, 6);
            if (isReserved) {
                $composer8.startReplaceGroup(749420);
                ComposerKt.sourceInformation($composer8, "155@5817L6");
                long j = BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU();
                $composer8.endReplaceGroup();
                buttonColor = j;
            } else {
                $composer8.startReplaceGroup(825680);
                ComposerKt.sourceInformation($composer8, "157@5894L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer8.endReplaceGroup();
                buttonColor = j2;
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(56)), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), buttonColor, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer8, -831243189, "CC(remember):UpcomingEpisodeReservationCard.kt#9igjgp");
            int $dirty4 = $dirty;
            boolean invalid$iv = ((57344 & $dirty4) == 16384) | (($dirty4 & 7168) == 2048) | (($dirty4 & 896) == 256);
            Object it$iv = $composer8.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit UpcomingEpisodeReservationContent$lambda$0$0$1$0;
                        UpcomingEpisodeReservationContent$lambda$0$0$1$0 = UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationContent$lambda$0$0$1$0(isReserved, function02, function0);
                        return UpcomingEpisodeReservationContent$lambda$0$0$1$0;
                    }
                };
                $composer8.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer8);
            Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer8, 1042775818, str3);
            MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv4 = (48 << 3) & 112;
            String str5 = str4;
            ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, str5);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer8.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer8, modifier$iv4);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            String str6 = str2;
            ComposerKt.sourceInformationMarkerStart($composer8, -553112988, str6);
            if (!($composer8.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer8.startReusableNode();
            if ($composer8.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer8.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv8;
                $composer8.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer8);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer8, 1833054614, str);
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i8 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer8, -1729579829, "C:UpcomingEpisodeReservationCard.kt#kr57tx");
            if (isReserved) {
                $composer8.startReplaceGroup(-1729577350);
                ComposerKt.sourceInformation($composer8, "178@6754L60,179@6858L6,180@6914L9,177@6717L287");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_10(Res.string.INSTANCE), $composer8, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT13(), $composer8, 0, 0, 130042);
                $composer8.endReplaceGroup();
                $composer5 = $composer8;
            } else {
                $composer8.startReplaceGroup(-1729244441);
                ComposerKt.sourceInformation($composer8, "185@7090L994");
                Modifier modifier$iv5 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer8, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer8, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv5 = (438 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer8, -1159599143, str5);
                int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer8, 0));
                CompositionLocalMap localMap$iv$iv5 = $composer8.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer8, modifier$iv5);
                Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer8, -553112988, str6);
                if (!($composer8.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer8.startReusableNode();
                if ($composer8.getInserting()) {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer8.createNode(factory$iv$iv$iv4);
                } else {
                    factory$iv$iv$iv4 = factory$iv$iv$iv9;
                    $composer8.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer8);
                $composer5 = $composer8;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer8, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope = RowScopeInstance.INSTANCE;
                int i10 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer8, -474971244, "C191@7433L21,194@7617L6,190@7376L286,196@7687L39,198@7792L59,199@7899L6,200@7964L9,197@7751L311:UpcomingEpisodeReservationCard.kt#kr57tx");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getBell_reserve_line_500($composer8, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getGraph_white-0d7_KjU(), $composer8, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer8, 6);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_6(Res.string.INSTANCE), $composer8, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer8, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer8, BiliTheme.$stable).getT13(), $composer8, 0, 0, 130042);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                $composer8.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                ComposerKt.sourceInformationMarkerEnd($composer8);
                $composer8.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            $composer8.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer8);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            ComposerKt.sourceInformationMarkerEnd($composer6);
            $composer$iv$iv$iv2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv2);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer6;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeReservationCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeReservationContent$lambda$1;
                    UpcomingEpisodeReservationContent$lambda$1 = UpcomingEpisodeReservationCardKt.UpcomingEpisodeReservationContent$lambda$1(reservationTitle, reservationCount, function0, function02, isReserved, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeReservationContent$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeReservationContent$lambda$0$0$1$0(boolean $isReserved, Function0 $onCancelReservationClick, Function0 $onReservationClick) {
        if ($isReserved) {
            $onCancelReservationClick.invoke();
        } else {
            $onReservationClick.invoke();
        }
        return Unit.INSTANCE;
    }
}