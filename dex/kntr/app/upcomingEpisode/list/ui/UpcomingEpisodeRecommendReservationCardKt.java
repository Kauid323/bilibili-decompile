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
import com.bapis.bilibili.community.interfacess.watch.v1.KReserveRecommend;
import com.bapis.bilibili.community.interfacess.watch.v1.KUpInfo;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: UpcomingEpisodeRecommendReservationCard.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\u001aã\u0001\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u000728\b\u0002\u0010\b\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\t2>\b\u0002\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\t2>\b\u0002\u0010\u0010\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0011\u001a\u0091\u0001\u0010\u0012\u001a\u00020\u00012<\u0010\r\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\t2<\u0010\u0010\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"UpcomingEpisodeRecommendReservationCard", "", "upInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;", "reserveCardInfo", "Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;", "modifier", "Landroidx/compose/ui/Modifier;", "onRecommendReservationAuthorClick", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "data", "onRecommendReservationClick", "Lkotlin/Function0;", "onReservationSuccess", "onCancelRecommendReservationClick", "(Lcom/bapis/bilibili/community/interfacess/watch/v1/KUpInfo;Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "UpcomingEpisodeRecommendReservationContent", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/bapis/bilibili/community/interfacess/watch/v1/KReserveRecommend;Landroidx/compose/runtime/Composer;I)V", "main_debug", "isReserve", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpcomingEpisodeRecommendReservationCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$4(KUpInfo kUpInfo, KReserveRecommend kReserveRecommend, Modifier modifier, Function2 function2, Function2 function22, Function2 function23, int i, int i2, Composer composer, int i3) {
        UpcomingEpisodeRecommendReservationCard(kUpInfo, kReserveRecommend, modifier, function2, function22, function23, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationContent$lambda$4(Function2 function2, Function2 function22, KReserveRecommend kReserveRecommend, int i, Composer composer, int i2) {
        UpcomingEpisodeRecommendReservationContent(function2, function22, kReserveRecommend, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$0$0(KUpInfo kUpInfo, KReserveRecommend kReserveRecommend) {
        Intrinsics.checkNotNullParameter(kUpInfo, "<unused var>");
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$1$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$2$0(KReserveRecommend kReserveRecommend, Function0 function0) {
        Intrinsics.checkNotNullParameter(kReserveRecommend, "<unused var>");
        Intrinsics.checkNotNullParameter(function0, "<unused var>");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public static final void UpcomingEpisodeRecommendReservationCard(final KUpInfo upInfo, final KReserveRecommend reserveCardInfo, Modifier modifier, Function2<? super KUpInfo, ? super KReserveRecommend, Unit> function2, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function22, Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function23, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function2 function24;
        Function2 onRecommendReservationClick;
        Function2 function25;
        Modifier modifier3;
        Function2 onRecommendReservationAuthorClick;
        Function2 onCancelRecommendReservationClick;
        Function2 onRecommendReservationClick2;
        Intrinsics.checkNotNullParameter(reserveCardInfo, "reserveCardInfo");
        Composer $composer2 = $composer.startRestartGroup(1181568297);
        ComposerKt.sourceInformation($composer2, "C(UpcomingEpisodeRecommendReservationCard)N(upInfo,reserveCardInfo,modifier,onRecommendReservationAuthorClick,onRecommendReservationClick,onCancelRecommendReservationClick)57@2719L11,58@2835L11,59@2957L11,69@3258L6,68@3203L86,71@3297L1035,61@2978L1354:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
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
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function24 = function2;
        } else if (($changed & 3072) == 0) {
            function24 = function2;
            $dirty |= $composer2.changedInstance(function24) ? 2048 : 1024;
        } else {
            function24 = function2;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty |= 24576;
            onRecommendReservationClick = function22;
        } else if (($changed & 24576) == 0) {
            onRecommendReservationClick = function22;
            $dirty |= $composer2.changedInstance(onRecommendReservationClick) ? 16384 : 8192;
        } else {
            onRecommendReservationClick = function22;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty |= 196608;
            function25 = function23;
        } else if ((196608 & $changed) == 0) {
            function25 = function23;
            $dirty |= $composer2.changedInstance(function25) ? 131072 : 65536;
        } else {
            function25 = function23;
        }
        if ($composer2.shouldExecute((74899 & $dirty) != 74898, $dirty & 1)) {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1615774772, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj, Object obj2) {
                            Unit UpcomingEpisodeRecommendReservationCard$lambda$0$0;
                            UpcomingEpisodeRecommendReservationCard$lambda$0$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$0$0((KUpInfo) obj, (KReserveRecommend) obj2);
                            return UpcomingEpisodeRecommendReservationCard$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function2 onRecommendReservationAuthorClick2 = (Function2) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onRecommendReservationAuthorClick = onRecommendReservationAuthorClick2;
            } else {
                onRecommendReservationAuthorClick = function24;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1615778484, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit UpcomingEpisodeRecommendReservationCard$lambda$1$0;
                            UpcomingEpisodeRecommendReservationCard$lambda$1$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$1$0((KReserveRecommend) obj, (Function0) obj2);
                            return UpcomingEpisodeRecommendReservationCard$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function2 onRecommendReservationClick3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onRecommendReservationClick2 = onRecommendReservationClick3;
            } else {
                onRecommendReservationClick2 = onRecommendReservationClick;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1615782388, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda3
                        public final Object invoke(Object obj, Object obj2) {
                            Unit UpcomingEpisodeRecommendReservationCard$lambda$2$0;
                            UpcomingEpisodeRecommendReservationCard$lambda$2$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$2$0((KReserveRecommend) obj, (Function0) obj2);
                            return UpcomingEpisodeRecommendReservationCard$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function2 onCancelRecommendReservationClick2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onCancelRecommendReservationClick = onCancelRecommendReservationClick2;
            } else {
                onCancelRecommendReservationClick = function25;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1181568297, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCard (UpcomingEpisodeRecommendReservationCard.kt:60)");
            }
            final Function2 function26 = onRecommendReservationAuthorClick;
            modifier3 = modifier2;
            final Function2 function27 = onRecommendReservationClick2;
            final Function2 function28 = onCancelRecommendReservationClick;
            CardKt.Card(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, (Object) null), Dp.constructor-impl((float) ConstantsKt.RECOMMEND_RESERVATION_CARD_HEIGHT)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), CardDefaults.INSTANCE.cardColors-ro_MJ88(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-1798604041, true, new Function3() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit UpcomingEpisodeRecommendReservationCard$lambda$3;
                    UpcomingEpisodeRecommendReservationCard$lambda$3 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$3(upInfo, function26, reserveCardInfo, function27, function28, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return UpcomingEpisodeRecommendReservationCard$lambda$3;
                }
            }, $composer2, 54), $composer2, 196608, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onRecommendReservationClick = onRecommendReservationClick2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onRecommendReservationAuthorClick = function24;
            onCancelRecommendReservationClick = function25;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            final Function2 function29 = onRecommendReservationAuthorClick;
            final Function2 function210 = onRecommendReservationClick;
            final Function2 function211 = onCancelRecommendReservationClick;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda5
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeRecommendReservationCard$lambda$4;
                    UpcomingEpisodeRecommendReservationCard$lambda$4 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$4(upInfo, reserveCardInfo, modifier4, function29, function210, function211, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeRecommendReservationCard$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x01de, code lost:
        if (r7 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$3(final KUpInfo $upInfo, final Function2 $onRecommendReservationAuthorClick, final KReserveRecommend $reserveCardInfo, Function2 $onRecommendReservationClick, Function2 $onCancelRecommendReservationClick, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C72@3307L1019:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1798604041, $changed, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCard.<anonymous> (UpcomingEpisodeRecommendReservationCard.kt:72)");
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
            ColumnScope $this$UpcomingEpisodeRecommendReservationCard_u24lambda_u243_u240 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1362746194, "C88@3843L6,89@3895L111,84@3660L397,94@4070L47,95@4130L186:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            Modifier weight$default = ColumnScope.-CC.weight$default($this$UpcomingEpisodeRecommendReservationCard_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            KAvatarItem avatar = $upInfo != null ? $upInfo.getAvatar() : null;
            String name = $upInfo != null ? $upInfo.getName() : null;
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU();
            float f = Dp.constructor-impl(30);
            ComposerKt.sourceInformationMarkerStart($composer, -1618601456, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
            boolean invalid$iv = $composer.changed($onRecommendReservationAuthorClick) | $composer.changedInstance($upInfo) | $composer.changedInstance($reserveCardInfo);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda6
                public final Object invoke() {
                    Unit UpcomingEpisodeRecommendReservationCard$lambda$3$0$0$0;
                    UpcomingEpisodeRecommendReservationCard$lambda$3$0$0$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationCard$lambda$3$0$0$0($onRecommendReservationAuthorClick, $upInfo, $reserveCardInfo);
                    return UpcomingEpisodeRecommendReservationCard$lambda$3$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            UpcomingEpisodeUtilsKt.m1310SetUpIconNamewC_cr3g(avatar, name, j, (Function0) it$iv, weight$default, f, $composer, 196608, 0);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(9)), $composer, 6);
            UpcomingEpisodeRecommendReservationContent($onRecommendReservationClick, $onCancelRecommendReservationClick, $reserveCardInfo, $composer, 0);
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
    public static final Unit UpcomingEpisodeRecommendReservationCard$lambda$3$0$0$0(Function2 $onRecommendReservationAuthorClick, KUpInfo $upInfo, KReserveRecommend $reserveCardInfo) {
        $onRecommendReservationAuthorClick.invoke($upInfo == null ? new KUpInfo(0L, (String) null, (KAvatarItem) null, (String) null, 15, (DefaultConstructorMarker) null) : $upInfo, $reserveCardInfo);
        return Unit.INSTANCE;
    }

    private static final void UpcomingEpisodeRecommendReservationContent(final Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function2, final Function2<? super KReserveRecommend, ? super Function0<Unit>, Unit> function22, final KReserveRecommend reserveCardInfo, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        long buttonColor;
        final MutableState isReserve$delegate;
        Function0 factory$iv$iv$iv5;
        Function0 factory$iv$iv$iv6;
        Composer $composer3;
        Composer $composer4 = $composer.startRestartGroup(212432143);
        ComposerKt.sourceInformation($composer4, "C(UpcomingEpisodeRecommendReservationContent)N(onRecommendReservationClick,onCancelRecommendReservationClick,reserveCardInfo)110@4679L75,119@4977L6,113@4759L4973:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer4.changedInstance(function2) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(function22) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer4.changedInstance(reserveCardInfo) ? 256 : 128;
        }
        if (!$composer4.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(212432143, $dirty, -1, "kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationContent (UpcomingEpisodeRecommendReservationCard.kt:109)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -2011130374, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
            Object it$iv = $composer4.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(reserveCardInfo.getReserveState() == 1), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            MutableState isReserve$delegate2 = (MutableState) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0(BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(60)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null), Dp.constructor-impl(12), Dp.constructor-impl((float) 9.5d), Dp.constructor-impl(12), Dp.constructor-impl((float) 9.5d));
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv7;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -441605679, "C127@5205L4521:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((390 >> 3) & 14) | ((390 >> 3) & 112));
            int $changed$iv$iv2 = (390 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv8;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((390 >> 6) & 112) | 6;
            RowScope $this$UpcomingEpisodeRecommendReservationContent_u24lambda_u243_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 739674252, "C133@5378L1684,171@7075L39,185@7690L478,178@7333L2383:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            Modifier modifier$iv3 = $this$UpcomingEpisodeRecommendReservationContent_u24lambda_u243_u240.align(RowScope.-CC.weight$default($this$UpcomingEpisodeRecommendReservationContent_u24lambda_u243_u240, Modifier.Companion, 1.0f, false, 2, (Object) null), Alignment.Companion.getCenterVertically());
            ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            int $changed$iv$iv$iv3 = ((0 >> 3) & 14) | ((0 >> 3) & 112);
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, $changed$iv$iv$iv3);
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer4.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
            int $dirty2 = $dirty;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 1525725230, "C141@5664L9,144@5806L6,139@5570L317,147@5904L40,148@5961L1087:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            TextKt.Text-Nvy7gAk(reserveCardInfo.getTitle(), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, new FontWeight(500), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT14b(), $composer4, 1572864, 24960, 110522);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(4)), $composer4, 6);
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier modifier$iv4 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv4 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer4.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i7 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i8 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 766773093, "C164@6785L51,165@6880L9,167@6995L6,163@6700L330:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            $composer4.startReplaceGroup(-1914927889);
            ComposerKt.sourceInformation($composer4, "*157@6426L9,159@6549L6,150@6033L624");
            String convertTimestampToFormattedString = reserveCardInfo.getReserveType() == 1 ? UpcomingEpisodeExtensionsKt.convertTimestampToFormattedString(reserveCardInfo.getReservedTs()) : UpcomingEpisodeExtensionsKt.convertTimestampToFormattedString(reserveCardInfo.getReservedTs()) + "开播";
            TextKt.Text-Nvy7gAk(convertTimestampToFormattedString, PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, Dp.constructor-impl(6), 0.0f, 11, (Object) null), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 48, 384, 126968);
            Unit unit = Unit.INSTANCE;
            $composer4.endReplaceGroup();
            TextKt.Text-Nvy7gAk(UpcomingEpisodeExtensionsKt.readableString(reserveCardInfo.getReserveTotal()) + StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_5(Res.string.INSTANCE), $composer4, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 384, 126970);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer4, 6);
            if (UpcomingEpisodeRecommendReservationContent$lambda$1(isReserve$delegate2)) {
                $composer4.startReplaceGroup(741325590);
                ComposerKt.sourceInformation($composer4, "174@7208L6");
                long j = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_bg_thick-0d7_KjU();
                $composer4.endReplaceGroup();
                buttonColor = j;
            } else {
                $composer4.startReplaceGroup(741401850);
                ComposerKt.sourceInformation($composer4, "176@7285L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer4.endReplaceGroup();
                buttonColor = j2;
            }
            Modifier modifier = BackgroundKt.background-bw27NRU$default(ClipKt.clip(SizeKt.height-3ABfNKs(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(56)), Dp.constructor-impl(24)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12))), buttonColor, (Shape) null, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, -668806077, "CC(remember):UpcomingEpisodeRecommendReservationCard.kt#9igjgp");
            boolean invalid$iv = (($dirty2 & 112) == 32) | $composer4.changedInstance(reserveCardInfo) | (($dirty2 & 14) == 4);
            Object it$iv2 = $composer4.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                isReserve$delegate = isReserve$delegate2;
                Object value$iv2 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda9
                    public final Object invoke() {
                        Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0;
                        UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0(function22, reserveCardInfo, function2, isReserve$delegate);
                        return UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0;
                    }
                };
                $composer4.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            } else {
                isReserve$delegate = isReserve$delegate2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv5 = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null);
            Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv5 = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
            Function0 factory$iv$iv$iv11 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer4.createNode(factory$iv$iv$iv5);
            } else {
                factory$iv$iv$iv5 = factory$iv$iv$iv11;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer4);
            $composer2 = $composer4;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv6 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
            int i10 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, 832141062, "C:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
            if (UpcomingEpisodeRecommendReservationContent$lambda$1(isReserve$delegate)) {
                $composer4.startReplaceGroup(832142828);
                ComposerKt.sourceInformation($composer4, "201@8370L52,202@8466L6,203@8522L9,200@8333L279");
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_10(Res.string.INSTANCE), $composer4, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), $composer4, 0, 0, 130042);
                $composer4.endReplaceGroup();
                $composer3 = $composer4;
            } else {
                $composer4.startReplaceGroup(832467801);
                ComposerKt.sourceInformation($composer4, "208@8698L986");
                Modifier modifier$iv6 = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.getCenter();
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv6 = (438 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv6 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                Function0 factory$iv$iv$iv12 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                    $composer4.createNode(factory$iv$iv$iv6);
                } else {
                    factory$iv$iv$iv6 = factory$iv$iv$iv12;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.constructor-impl($composer4);
                $composer3 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv6, Integer.valueOf(compositeKeyHash$iv$iv6), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv6, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.Companion.getSetModifier());
                int i11 = ($changed$iv$iv$iv7 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i12 = ((438 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -1308215578, "C214@9041L21,217@9225L6,213@8984L286,219@9295L39,221@9400L51,222@9499L6,223@9564L9,220@9359L303:UpcomingEpisodeRecommendReservationCard.kt#kr57tx");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getBell_reserve_line_500($composer4, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_white-0d7_KjU(), $composer4, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer4, 6);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getWatching_global_string_6(Res.string.INSTANCE), $composer4, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText_white-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT13(), $composer4, 0, 0, 130042);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
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
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit UpcomingEpisodeRecommendReservationContent$lambda$4;
                    UpcomingEpisodeRecommendReservationContent$lambda$4 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationContent$lambda$4(function2, function22, reserveCardInfo, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return UpcomingEpisodeRecommendReservationContent$lambda$4;
                }
            });
        }
    }

    private static final boolean UpcomingEpisodeRecommendReservationContent$lambda$1(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    private static final void UpcomingEpisodeRecommendReservationContent$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0(Function2 $onCancelRecommendReservationClick, KReserveRecommend $reserveCardInfo, Function2 $onRecommendReservationClick, final MutableState $isReserve$delegate) {
        if (UpcomingEpisodeRecommendReservationContent$lambda$1($isReserve$delegate)) {
            $onCancelRecommendReservationClick.invoke($reserveCardInfo, new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda7
                public final Object invoke() {
                    Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$0;
                    UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$0 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$0($isReserve$delegate);
                    return UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$0;
                }
            });
        } else {
            $onRecommendReservationClick.invoke($reserveCardInfo, new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.UpcomingEpisodeRecommendReservationCardKt$$ExternalSyntheticLambda8
                public final Object invoke() {
                    Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$1;
                    UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$1 = UpcomingEpisodeRecommendReservationCardKt.UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$1($isReserve$delegate);
                    return UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$1;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$0(MutableState $isReserve$delegate) {
        UpcomingEpisodeRecommendReservationContent$lambda$2($isReserve$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UpcomingEpisodeRecommendReservationContent$lambda$3$0$1$0$1(MutableState $isReserve$delegate) {
        UpcomingEpisodeRecommendReservationContent$lambda$2($isReserve$delegate, true);
        return Unit.INSTANCE;
    }
}