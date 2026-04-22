package kntr.app.upcomingEpisode.list.ui;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.lib.brouter.uri.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.UnpublishedVideo;
import kntr.app.upcomingEpisode.list.model.UnwatchedVideo;
import kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.base.router.Router;
import kntr.common.router.RouterKt;
import kntr.common.router.UrisKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VideoUpdateCalendarCard.kt */
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0003\u001aQ\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\r\u001a#\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0011\u001aC\u0010\u0012\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a)\u0010\u0019\u001a\u00020\u0001*\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u001d¨\u0006\u001e²\u0006\n\u0010\u001f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010 \u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\u001c\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"0\u001bX\u008a\u008e\u0002²\u0006\n\u0010%\u001a\u00020#X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020$X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020$X\u008a\u008e\u0002"}, d2 = {"VideoUpdateCalendarCard", "", "data", "Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "pageVisible", "", "modifier", "Landroidx/compose/ui/Modifier;", "fromSpmid", "", "reportShow", "Lkotlin/Function0;", "reportClickVideo", "(Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;ZLandroidx/compose/ui/Modifier;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "Title", "Landroidx/compose/foundation/layout/ColumnScope;", "title", "(Landroidx/compose/foundation/layout/ColumnScope;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "UnWatchedList", "unwatchedVideo", "Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;", "coverSize", "Landroidx/compose/ui/unit/DpSize;", "UnWatchedList-VxoR3W4", "(Landroidx/compose/foundation/layout/ColumnScope;Lkntr/app/upcomingEpisode/list/model/UnwatchedVideo;JLjava/lang/String;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "UnPublished", "unpublishedVideoList", "", "Lkntr/app/upcomingEpisode/list/model/UnpublishedVideo;", "(Landroidx/compose/foundation/layout/ColumnScope;Ljava/util/List;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "main_debug", "lastData", "lastPageVisible", "lines", "Lkotlin/Pair;", "", "", "minPrefix", "toParent", "yInLocal"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoUpdateCalendarCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Title$lambda$1(ColumnScope columnScope, String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        Title(columnScope, str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnPublished$lambda$8(ColumnScope columnScope, List list, Modifier modifier, int i, int i2, Composer composer, int i3) {
        UnPublished(columnScope, list, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnWatchedList_VxoR3W4$lambda$2(ColumnScope columnScope, UnwatchedVideo unwatchedVideo, long j, String str, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        m1299UnWatchedListVxoR3W4(columnScope, unwatchedVideo, j, str, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit VideoUpdateCalendarCard$lambda$3(VideoUpdateCalendar videoUpdateCalendar, boolean z, Modifier modifier, String str, Function0 function0, Function0 function02, int i, int i2, Composer composer, int i3) {
        VideoUpdateCalendarCard(videoUpdateCalendar, z, modifier, str, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r8v20 */
    public static final void VideoUpdateCalendarCard(final VideoUpdateCalendar data, final boolean pageVisible, Modifier modifier, String fromSpmid, Function0<Unit> function0, Function0<Unit> function02, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        String fromSpmid2;
        Function0 reportShow;
        Function0 reportClickVideo;
        int $dirty;
        Modifier modifier3;
        String fromSpmid3;
        Function0 factory$iv$iv$iv;
        Function0 function03;
        Composer $composer2;
        Composer $composer$iv;
        Function0 reportShow2;
        Composer $composer$iv$iv;
        Composer $composer$iv$iv$iv;
        Function0 reportShow3;
        Boolean bool;
        Intrinsics.checkNotNullParameter(data, "data");
        Composer $composer3 = $composer.startRestartGroup(1392713329);
        ComposerKt.sourceInformation($composer3, "C(VideoUpdateCalendarCard)N(data,pageVisible,modifier,fromSpmid,reportShow,reportClickVideo)76@3645L2,77@3684L2,83@3811L6,79@3696L3197:VideoUpdateCalendarCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer3.changedInstance(data) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer3.changed(pageVisible) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty2 |= 3072;
            fromSpmid2 = fromSpmid;
        } else if (($changed & 3072) == 0) {
            fromSpmid2 = fromSpmid;
            $dirty2 |= $composer3.changed(fromSpmid2) ? 2048 : 1024;
        } else {
            fromSpmid2 = fromSpmid;
        }
        int i4 = i & 16;
        if (i4 != 0) {
            $dirty2 |= 24576;
            reportShow = function0;
        } else if (($changed & 24576) == 0) {
            reportShow = function0;
            $dirty2 |= $composer3.changedInstance(reportShow) ? 16384 : 8192;
        } else {
            reportShow = function0;
        }
        int i5 = i & 32;
        if (i5 != 0) {
            $dirty2 |= 196608;
            reportClickVideo = function02;
        } else if ((196608 & $changed) == 0) {
            reportClickVideo = function02;
            $dirty2 |= $composer3.changedInstance(reportClickVideo) ? 131072 : 65536;
        } else {
            reportClickVideo = function02;
        }
        if (!$composer3.shouldExecute(($dirty2 & 74899) != 74898, $dirty2 & 1)) {
            $dirty = $dirty2;
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            fromSpmid3 = fromSpmid2;
        } else {
            if (i2 != 0) {
                modifier2 = (Modifier) Modifier.Companion;
            }
            if (i3 != 0) {
                fromSpmid2 = "";
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1632281485, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                Object it$iv = $composer3.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda10
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 reportShow4 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                reportShow = reportShow4;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer3, -1632280237, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 reportClickVideo2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                reportClickVideo = reportClickVideo2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1392713329, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCard (VideoUpdateCalendarCard.kt:78)");
            }
            Modifier modifier$iv = PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(modifier2, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBg2-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8))), Dp.constructor-impl(12));
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i6 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            int $changed2 = ((48 >> 6) & 112) | 6;
            ColumnScope $this$VideoUpdateCalendarCard_u24lambda_u242 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, 287131702, "C91@4088L32,93@4146L33,94@4211L40,96@4295L1413,96@4261L1447,131@5718L58:VideoUpdateCalendarCard.kt#kr57tx");
            State exposureReporter = SnapshotStateKt.rememberUpdatedState(reportShow, $composer3, ($dirty2 >> 12) & 14);
            ComposerKt.sourceInformationMarkerStart($composer3, 147809448, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            Object value$iv3 = $composer3.rememberedValue();
            Modifier modifier4 = modifier2;
            if (value$iv3 == Composer.Companion.getEmpty()) {
                value$iv3 = SnapshotStateKt.mutableStateOf$default(data, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv3);
            }
            MutableState lastData$delegate = (MutableState) value$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerStart($composer3, 147811535, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                function03 = null;
                Object value$iv4 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(pageVisible), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(value$iv4);
                it$iv3 = value$iv4;
            } else {
                function03 = null;
            }
            MutableState lastPageVisible$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Boolean valueOf = Boolean.valueOf(pageVisible);
            ComposerKt.sourceInformationMarkerStart($composer3, 147815596, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(data) | (($dirty2 & 112) == 32) | $composer3.changed(exposureReporter);
            Object value$iv5 = $composer3.rememberedValue();
            if (invalid$iv || value$iv5 == Composer.Companion.getEmpty()) {
                $dirty = $dirty2;
                $composer2 = $composer3;
                $composer$iv = $composer3;
                modifier3 = modifier4;
                reportShow2 = reportShow;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                reportShow3 = null;
                bool = valueOf;
                value$iv5 = new VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1(data, pageVisible, lastData$delegate, lastPageVisible$delegate, exposureReporter, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                $composer$iv = $composer3;
                $composer2 = $composer3;
                reportShow2 = reportShow;
                $composer$iv$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                modifier3 = modifier4;
                bool = valueOf;
                reportShow3 = function03;
                $dirty = $dirty2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Composer $composer4 = $composer2;
            EffectsKt.LaunchedEffect(data, bool, (Function2) value$iv5, $composer4, ($dirty & 14) | ($dirty & 112));
            String title = data.getTitle();
            if (title == null) {
                title = "";
            }
            Title($this$VideoUpdateCalendarCard_u24lambda_u242, title, null, $composer4, $changed2 & 14, 2);
            UnwatchedVideo it = data.getUgc();
            if (it == null) {
                $composer4.startReplaceGroup(288775227);
            } else {
                $composer4.startReplaceGroup(288775228);
                ComposerKt.sourceInformation($composer4, "*136@5814L419");
                m1299UnWatchedListVxoR3W4($this$VideoUpdateCalendarCard_u24lambda_u242, it, DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float) ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH), Dp.constructor-impl(64)), fromSpmid2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, reportShow3), reportClickVideo, $composer4, ($changed2 & 14) | 24960 | ($dirty & 7168) | ($dirty & 458752), 0);
            }
            $composer4.endReplaceGroup();
            UnwatchedVideo it2 = data.getOgv();
            if (it2 == null) {
                $composer4.startReplaceGroup(289238491);
            } else {
                $composer4.startReplaceGroup(289238492);
                ComposerKt.sourceInformation($composer4, "*150@6281L419");
                m1299UnWatchedListVxoR3W4($this$VideoUpdateCalendarCard_u24lambda_u242, it2, DpKt.DpSize-YgX7TsA(Dp.constructor-impl(48), Dp.constructor-impl(64)), fromSpmid2, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, reportShow3), reportClickVideo, $composer4, ($changed2 & 14) | 24960 | ($dirty & 7168) | (458752 & $dirty), 0);
            }
            $composer4.endReplaceGroup();
            List it3 = data.getUnpublished();
            if (it3 == null) {
                $composer4.startReplaceGroup(289700453);
            } else {
                $composer4.startReplaceGroup(289700454);
                ComposerKt.sourceInformation($composer4, "*164@6756L121");
                UnPublished($this$VideoUpdateCalendarCard_u24lambda_u242, it3, SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, reportShow3), $composer4, ($changed2 & 14) | 384, 0);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            reportShow = reportShow2;
            fromSpmid3 = fromSpmid2;
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final String str = fromSpmid3;
            final Function0 function04 = reportShow;
            final Function0 function05 = reportClickVideo;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit VideoUpdateCalendarCard$lambda$3;
                    VideoUpdateCalendarCard$lambda$3 = VideoUpdateCalendarCardKt.VideoUpdateCalendarCard$lambda$3(VideoUpdateCalendar.this, pageVisible, modifier5, str, function04, function05, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return VideoUpdateCalendarCard$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoUpdateCalendar VideoUpdateCalendarCard$lambda$2$1(MutableState<VideoUpdateCalendar> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (VideoUpdateCalendar) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean VideoUpdateCalendarCard$lambda$2$4(MutableState<Boolean> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VideoUpdateCalendarCard$lambda$2$5(MutableState<Boolean> mutableState, boolean z) {
        Object value$iv = Boolean.valueOf(z);
        mutableState.setValue(value$iv);
    }

    public static final void Title(final ColumnScope $this$Title, final String title, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Intrinsics.checkNotNullParameter($this$Title, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Composer $composer3 = $composer.startRestartGroup(-1790417783);
        ComposerKt.sourceInformation($composer3, "C(Title)N(title,modifier)180@7025L669:VideoUpdateCalendarCard.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(title) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1790417783, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.Title (VideoUpdateCalendarCard.kt:179)");
            }
            Modifier modifier$iv = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), Dp.constructor-impl(18));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i4 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1355754859, "C188@7323L6,189@7367L9,186@7261L203,195@7515L28,198@7658L6,194@7474L214:VideoUpdateCalendarCard.kt#kr57tx");
            modifier3 = modifier4;
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13b(), $composer3, ($dirty2 >> 3) & 14, 24960, 110586);
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_forward_right_line_900($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getGraph_medium-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
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
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda9
                public final Object invoke(Object obj, Object obj2) {
                    Unit Title$lambda$1;
                    Title$lambda$1 = VideoUpdateCalendarCardKt.Title$lambda$1($this$Title, title, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return Title$lambda$1;
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0119, code lost:
        if (r3 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0956  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0978  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0a27  */
    /* renamed from: UnWatchedList-VxoR3W4  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1299UnWatchedListVxoR3W4(final ColumnScope $this$UnWatchedList_u2dVxoR3W4, final UnwatchedVideo unwatchedVideo, final long j, final String fromSpmid, Modifier modifier, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        int $dirty;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        String str;
        String str2;
        String str3;
        String str4;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv4;
        boolean z;
        String updateTime;
        Function0 factory$iv$iv$iv5;
        Intrinsics.checkNotNullParameter($this$UnWatchedList_u2dVxoR3W4, "$this$UnWatchedList");
        Intrinsics.checkNotNullParameter(unwatchedVideo, "unwatchedVideo");
        Intrinsics.checkNotNullParameter(fromSpmid, "fromSpmid");
        Intrinsics.checkNotNullParameter(function0, "reportClickVideo");
        Composer $composer4 = $composer.startRestartGroup(-1671350281);
        ComposerKt.sourceInformation($composer4, "C(UnWatchedList)N(unwatchedVideo,coverSize:c#ui.unit.DpSize,fromSpmid,modifier,reportClickVideo)211@7925L7,216@8041L529,212@7937L5197:VideoUpdateCalendarCard.kt#kr57tx");
        int $dirty2 = $changed;
        if (($changed & 48) == 0) {
            $dirty2 |= $composer4.changedInstance(unwatchedVideo) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer4.changed(j) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer4.changed(fromSpmid) ? 2048 : 1024;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer4.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if ((196608 & $changed) == 0) {
            $dirty2 |= $composer4.changedInstance(function0) ? 131072 : 65536;
        }
        int $dirty3 = $dirty2;
        if (!$composer4.shouldExecute((74897 & $dirty3) != 74896, $dirty3 & 1)) {
            $dirty = $dirty3;
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1671350281, $dirty3, -1, "kntr.app.upcomingEpisode.list.ui.UnWatchedList (VideoUpdateCalendarCard.kt:210)");
            }
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Router router = (Router) consume;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer4, 150159784, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            boolean invalid$iv = (($dirty3 & 7168) == 2048) | ((458752 & $dirty3) == 131072) | $composer4.changedInstance(router) | $composer4.changedInstance(unwatchedVideo);
            Object it$iv = $composer4.rememberedValue();
            if (invalid$iv) {
                modifier3 = modifier4;
            } else {
                modifier3 = modifier4;
            }
            Object value$iv = new Function0() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit UnWatchedList_VxoR3W4$lambda$0$0;
                    UnWatchedList_VxoR3W4$lambda$0$0 = VideoUpdateCalendarCardKt.UnWatchedList_VxoR3W4$lambda$0$0(function0, router, unwatchedVideo, fromSpmid);
                    return UnWatchedList_VxoR3W4$lambda$0$0;
                }
            };
            $composer4.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            $dirty = $dirty3;
            ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv6;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((432 >> 6) & 112) | 6;
            RowScope $this$UnWatchedList_VxoR3W4_u24lambda_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, 1210752549, "C234@8741L2558,297@11335L1793:VideoUpdateCalendarCard.kt#kr57tx");
            ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier modifier$iv2 = Modifier.Companion;
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
            $composer2 = $composer4;
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
            Function0 factory$iv$iv$iv7 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer4.startReusableNode();
            if ($composer4.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer4.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv7;
                $composer4.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer4);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$UnWatchedList_VxoR3W4_u24lambda_u241_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer4, -624551008, "C235@8759L1492:VideoUpdateCalendarCard.kt#kr57tx");
            String $this$asRequest_u24default$iv = unwatchedVideo.getCover();
            if ($this$asRequest_u24default$iv == null) {
                $this$asRequest_u24default$iv = "";
            }
            ImageRequest imageRequest = new ImageRequest($this$asRequest_u24default$iv);
            Unit unit = Unit.INSTANCE;
            BiliImageKt.BiliImage(imageRequest.build(), ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(64)), DpSize.getWidth-D9Ej5fM(j) / DpSize.getHeight-D9Ej5fM(j), false, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(4))), null, null, null, null, null, ComposableSingletons$VideoUpdateCalendarCardKt.INSTANCE.getLambda$1774088582$main_debug(), ComposableSingletons$VideoUpdateCalendarCardKt.INSTANCE.getLambda$1315202000$main_debug(), $composer4, 113246208, 124);
            String videoDuration = unwatchedVideo.getVideoDuration();
            if (videoDuration != null && (StringsKt.isBlank(videoDuration) ^ true)) {
                $composer4.startReplaceGroup(-623049927);
                ComposerKt.sourceInformation($composer4, "272@10339L936");
                Modifier modifier$iv3 = BackgroundKt.background-bw27NRU(SizeKt.width-3ABfNKs(SizeKt.height-3ABfNKs(PaddingKt.padding-3ABfNKs($this$UnWatchedList_VxoR3W4_u24lambda_u241_u240.align(Modifier.Companion, Alignment.Companion.getBottomEnd()), Dp.constructor-impl(4)), Dp.constructor-impl(16)), Dp.constructor-impl(31)), ColorKt.Color(2030043136), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(2)));
                Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                str2 = "CC(remember):VideoUpdateCalendarCard.kt#9igjgp";
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv8 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer4.createNode(factory$iv$iv$iv5);
                } else {
                    factory$iv$iv$iv5 = factory$iv$iv$iv8;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer3 = $composer4;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i8 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, 1650208477, "C288@11125L9,285@10965L292:VideoUpdateCalendarCard.kt#kr57tx");
                TextKt.Text-Nvy7gAk(unwatchedVideo.getVideoDuration(), (Modifier) null, ColorKt.Color(4294967295L), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT10(), $composer4, 384, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer3 = $composer4;
                str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                str2 = "CC(remember):VideoUpdateCalendarCard.kt#9igjgp";
                str3 = "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo";
                str4 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                $composer4.startReplaceGroup(-633319359);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv4 = SizeKt.fillMaxHeight$default(RowScope.-CC.weight$default($this$UnWatchedList_VxoR3W4_u24lambda_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), 0.0f, 1, (Object) null);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            Composer $composer$iv = $composer3;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv4 = (48 << 3) & 112;
            String str5 = str;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str5);
            int compositeKeyHash$iv$iv4 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv4);
            Function0 factory$iv$iv$iv9 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
            String str6 = str4;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str6);
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer$iv.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv9;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv4, Integer.valueOf(compositeKeyHash$iv$iv4), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv4, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.Companion.getSetModifier());
            int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i10 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 27227219, "C303@11582L9,306@11691L6,301@11487L281,310@11782L1336:VideoUpdateCalendarCard.kt#kr57tx");
            String title = unwatchedVideo.getTitle();
            TextKt.Text-Nvy7gAk(title == null ? "" : title, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 2, 2, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT14(), $composer$iv, 0, 221568, 77818);
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer$iv, 844473419, str3);
            Modifier modifier$iv5 = Modifier.Companion;
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
            int $i$f$Layout = ((384 >> 3) & 14) | ((384 >> 3) & 112);
            MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, $i$f$Layout);
            int $changed$iv$iv5 = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, str5);
            int compositeKeyHash$iv$iv5 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            CompositionLocalMap localMap$iv$iv5 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv5);
            Function0 factory$iv$iv$iv10 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, str6);
            if (!($composer$iv.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer$iv.startReusableNode();
            if ($composer$iv.getInserting()) {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer$iv.createNode(factory$iv$iv$iv4);
            } else {
                factory$iv$iv$iv4 = factory$iv$iv$iv10;
                $composer$iv.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.constructor-impl($composer$iv);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv5, Integer.valueOf(compositeKeyHash$iv$iv5), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv5, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.Companion.getSetModifier());
            int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i12 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1385017430, "C321@12284L553,335@12932L6,336@12984L9,333@12855L249:VideoUpdateCalendarCard.kt#kr57tx");
            String upIcon = unwatchedVideo.getUpIcon();
            if (upIcon != null && (StringsKt.isBlank(upIcon) ^ true)) {
                $composer$iv.startReplaceGroup(1385037579);
                ComposerKt.sourceInformation($composer$iv, "313@11999L158,317@12178L39");
                ImageRequest imageRequest2 = new ImageRequest(unwatchedVideo.getUpIcon());
                Unit unit2 = Unit.INSTANCE;
                BiliImageKt.BiliImage(imageRequest2.build(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), null, null, null, null, null, null, null, $composer$iv, 48, 508);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer$iv, 6);
            } else {
                $composer$iv.startReplaceGroup(1373147405);
            }
            $composer$iv.endReplaceGroup();
            String upName = unwatchedVideo.getUpName();
            String updateTime2 = unwatchedVideo.getUpdateTime();
            ComposerKt.sourceInformationMarkerStart($composer$iv, -509500578, str2);
            boolean invalid$iv2 = $composer$iv.changed(upName) | $composer$iv.changed(updateTime2);
            Object it$iv2 = $composer$iv.rememberedValue();
            if (!invalid$iv2 && it$iv2 != Composer.Companion.getEmpty()) {
                String text = (String) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT12(), $composer$iv, 0, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            StringBuilder $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240 = new StringBuilder();
            String upName2 = unwatchedVideo.getUpName();
            $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.append(upName2 == null ? "" : upName2);
            String upName3 = unwatchedVideo.getUpName();
            if (upName3 != null && (!StringsKt.isBlank(upName3))) {
                z = true;
                if (z) {
                    String updateTime3 = unwatchedVideo.getUpdateTime();
                    if (updateTime3 != null && (StringsKt.isBlank(updateTime3) ^ true)) {
                        $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.append(" • ");
                    }
                }
                updateTime = unwatchedVideo.getUpdateTime();
                if (updateTime == null) {
                    updateTime = "";
                }
                $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.append(updateTime);
                Object value$iv2 = $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.toString();
                $composer$iv.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
                String text2 = (String) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                TextKt.Text-Nvy7gAk(text2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT12(), $composer$iv, 0, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                }
            }
            z = false;
            if (z) {
            }
            updateTime = unwatchedVideo.getUpdateTime();
            if (updateTime == null) {
            }
            $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.append(updateTime);
            Object value$iv22 = $this$UnWatchedList_VxoR3W4_u24lambda_u241_u241_u240_u240_u240.toString();
            $composer$iv.updateRememberedValue(value$iv22);
            it$iv2 = value$iv22;
            String text22 = (String) it$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            TextKt.Text-Nvy7gAk(text22, (Modifier) null, BiliTheme.INSTANCE.getColors($composer$iv, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.Companion.getEllipsis-gIe3tQ8(), false, 1, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer$iv, BiliTheme.$stable).getT12(), $composer$iv, 0, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            $composer4.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnWatchedList_VxoR3W4$lambda$2;
                    UnWatchedList_VxoR3W4$lambda$2 = VideoUpdateCalendarCardKt.UnWatchedList_VxoR3W4$lambda$2($this$UnWatchedList_u2dVxoR3W4, unwatchedVideo, j, fromSpmid, modifier5, function0, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UnWatchedList_VxoR3W4$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnWatchedList_VxoR3W4$lambda$0$0(Function0 $reportClickVideo, Router $router, UnwatchedVideo $unwatchedVideo, String $fromSpmid) {
        $reportClickVideo.invoke();
        String url = $unwatchedVideo.getUrl();
        if (url == null) {
            url = "";
        }
        Builder $this$UnWatchedList_VxoR3W4_u24lambda_u240_u240_u240 = UrisKt.toUri(url).buildUpon();
        if (!StringsKt.isBlank($fromSpmid)) {
            $this$UnWatchedList_VxoR3W4_u24lambda_u240_u240_u240.appendQueryParameter("from_spmid", $fromSpmid);
        }
        $router.launch($this$UnWatchedList_VxoR3W4_u24lambda_u240_u240_u240.build());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0574  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0646  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0686  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x04e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void UnPublished(final ColumnScope $this$UnPublished, final List<UnpublishedVideo> list, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        long lineColor;
        Composer $composer$iv;
        Function0 factory$iv$iv$iv;
        int index$iv;
        int size;
        int compositeKeyHash$iv$iv;
        MutableFloatState yInLocal$delegate;
        Composer $composer3;
        Object it$iv;
        Function0 factory$iv$iv$iv2;
        boolean invalid$iv;
        Object it$iv2;
        Object it$iv3;
        String title;
        boolean z;
        Alignment.Horizontal horizontalAlignment$iv;
        Alignment.Horizontal horizontalAlignment$iv2;
        Intrinsics.checkNotNullParameter($this$UnPublished, "<this>");
        Intrinsics.checkNotNullParameter(list, "unpublishedVideoList");
        Composer $composer4 = $composer.startRestartGroup(-327921703);
        ComposerKt.sourceInformation($composer4, "C(UnPublished)N(unpublishedVideoList,modifier)350@13285L89,354@13397L67,358@13495L6,359@13543L6,360@13594L7,364@13682L1614,361@13606L4019:VideoUpdateCalendarCard.kt#kr57tx");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer4.changedInstance(list) ? 32 : 16;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer4.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer4.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            $composer2 = $composer4;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-327921703, $dirty2, -1, "kntr.app.upcomingEpisode.list.ui.UnPublished (VideoUpdateCalendarCard.kt:349)");
            }
            ComposerKt.sourceInformationMarkerStart($composer4, -1600139566, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            boolean invalid$iv2 = $composer4.changed(list);
            Object it$iv4 = $composer4.rememberedValue();
            if (invalid$iv2 || it$iv4 == Composer.Companion.getEmpty()) {
                Object value$iv = SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer4.updateRememberedValue(value$iv);
                it$iv4 = value$iv;
            }
            final MutableState lines$delegate = (MutableState) it$iv4;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerStart($composer4, -1600136004, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            boolean invalid$iv3 = $composer4.changed(list);
            Object it$iv5 = $composer4.rememberedValue();
            if (invalid$iv3 || it$iv5 == Composer.Companion.getEmpty()) {
                Object value$iv2 = SnapshotIntStateKt.mutableIntStateOf(0);
                $composer4.updateRememberedValue(value$iv2);
                it$iv5 = value$iv2;
            }
            MutableIntState minPrefix$delegate = (MutableIntState) it$iv5;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final long dotColor = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getGraph_weak-0d7_KjU();
            final long lineColor2 = BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getLine_regular-0d7_KjU();
            CompositionLocal this_$iv = CompositionLocalsKt.getLocalDensity();
            MutableIntState minPrefix$delegate2 = minPrefix$delegate;
            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer4.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer4);
            final Density density = (Density) consume;
            ComposerKt.sourceInformationMarkerStart($composer4, -1600125337, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
            boolean invalid$iv4 = $composer4.changed(density) | $composer4.changed(lines$delegate) | $composer4.changed(lineColor2) | $composer4.changed(dotColor);
            Object it$iv6 = $composer4.rememberedValue();
            if (!invalid$iv4 && it$iv6 != Composer.Companion.getEmpty()) {
                lineColor = lineColor2;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier4, (Function1) it$iv6), Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null);
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
                $composer$iv = $composer4;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                Alignment.Horizontal horizontalAlignment$iv3 = Alignment.Companion.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv3, $composer$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv = (48 << 3) & 112;
                String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
                modifier3 = modifier4;
                CompositionLocalMap localMap$iv$iv = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv);
                Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                $composer2 = $composer4;
                String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
                String str3 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if (!$composer$iv.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv3;
                    $composer$iv.useNode();
                }
                Function0 factory$iv$iv$iv4 = factory$iv$iv$iv;
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer$iv);
                Composer $composer$iv$iv = $composer$iv;
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                MeasurePolicy measurePolicy$iv$iv = measurePolicy$iv;
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                Composer $composer5 = $composer$iv;
                Composer $composer$iv2 = $composer$iv;
                ComposerKt.sourceInformationMarkerStart($composer5, -2030348532, "C:VideoUpdateCalendarCard.kt#kr57tx");
                $composer5.startReplaceGroup(1042886302);
                ComposerKt.sourceInformation($composer5, "*404@15593L36,405@15662L36,407@15773L410,407@15716L467,420@16291L90,418@16201L1404");
                List<UnpublishedVideo> $this$filter$iv = list;
                boolean z2 = false;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Iterable $this$filter$iv2 = $this$filter$iv;
                    UnpublishedVideo it = (UnpublishedVideo) element$iv$iv;
                    if (it.getTitle() != null) {
                        z = z2;
                        horizontalAlignment$iv = horizontalAlignment$iv3;
                        if (!StringsKt.isBlank(title)) {
                            horizontalAlignment$iv2 = 1;
                            if (horizontalAlignment$iv2 == null) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                            $this$filter$iv = $this$filter$iv2;
                            z2 = z;
                            horizontalAlignment$iv3 = horizontalAlignment$iv;
                        }
                    } else {
                        z = z2;
                        horizontalAlignment$iv = horizontalAlignment$iv3;
                    }
                    horizontalAlignment$iv2 = null;
                    if (horizontalAlignment$iv2 == null) {
                    }
                    $this$filter$iv = $this$filter$iv2;
                    z2 = z;
                    horizontalAlignment$iv3 = horizontalAlignment$iv;
                }
                Alignment.Horizontal horizontalAlignment$iv4 = horizontalAlignment$iv3;
                List $this$fastForEachIndexed$iv = (List) destination$iv$iv;
                index$iv = 0;
                size = $this$fastForEachIndexed$iv.size();
                while (index$iv < size) {
                    Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                    UnpublishedVideo video = (UnpublishedVideo) item$iv;
                    int index = index$iv;
                    int index$iv2 = index$iv;
                    ComposerKt.sourceInformationMarkerStart($composer5, -206832256, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    Composer $this$cache$iv = $composer5;
                    Object it$iv7 = $this$cache$iv.rememberedValue();
                    int i5 = size;
                    if (it$iv7 == Composer.Companion.getEmpty()) {
                        Object value$iv3 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        $this$cache$iv.updateRememberedValue(value$iv3);
                        it$iv7 = value$iv3;
                    }
                    final MutableFloatState toParent$delegate = (MutableFloatState) it$iv7;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    ComposerKt.sourceInformationMarkerStart($composer5, -206830048, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    Composer $this$cache$iv2 = $composer5;
                    Object it$iv8 = $this$cache$iv2.rememberedValue();
                    List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                    if (it$iv8 == Composer.Companion.getEmpty()) {
                        Object value$iv4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
                        $this$cache$iv2.updateRememberedValue(value$iv4);
                        it$iv8 = value$iv4;
                    }
                    MutableFloatState yInLocal$delegate2 = (MutableFloatState) it$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Float valueOf = Float.valueOf(UnPublished$lambda$7$1$1(toParent$delegate));
                    Float valueOf2 = Float.valueOf(UnPublished$lambda$7$1$4(yInLocal$delegate2));
                    Composer $composer$iv3 = $composer$iv;
                    ComposerKt.sourceInformationMarkerStart($composer5, -206826122, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    boolean invalid$iv5 = $composer5.changed(index) | $composer5.changed(lines$delegate);
                    Composer $this$cache$iv3 = $composer5;
                    Density density2 = density;
                    Object it$iv9 = $this$cache$iv3.rememberedValue();
                    if (invalid$iv5) {
                        compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                    } else {
                        compositeKeyHash$iv$iv = compositeKeyHash$iv$iv2;
                        if (it$iv9 != Composer.Companion.getEmpty()) {
                            yInLocal$delegate = yInLocal$delegate2;
                            ComposerKt.sourceInformationMarkerEnd($composer5);
                            Function0 factory$iv$iv$iv5 = factory$iv$iv$iv4;
                            long lineColor3 = lineColor;
                            MeasurePolicy measurePolicy$iv$iv2 = measurePolicy$iv$iv;
                            $composer3 = $composer5;
                            Composer $composer$iv$iv2 = $composer$iv$iv;
                            Composer $composer$iv4 = $composer$iv2;
                            final MutableFloatState yInLocal$delegate3 = yInLocal$delegate;
                            Alignment.Horizontal horizontalAlignment$iv5 = horizontalAlignment$iv4;
                            final MutableIntState minPrefix$delegate3 = minPrefix$delegate2;
                            EffectsKt.LaunchedEffect(valueOf, valueOf2, list, (Function2) it$iv9, $composer3, ($dirty2 << 3) & 896);
                            Modifier modifier5 = Modifier.Companion;
                            ComposerKt.sourceInformationMarkerStart($composer3, -206809866, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                            it$iv = $composer3.rememberedValue();
                            if (it$iv != Composer.Companion.getEmpty()) {
                                Object value$iv5 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj) {
                                        Unit UnPublished$lambda$7$1$7$0;
                                        UnPublished$lambda$7$1$7$0 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$7$0(toParent$delegate, (LayoutCoordinates) obj);
                                        return UnPublished$lambda$7$1$7$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv5);
                                it$iv = value$iv5;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Modifier modifier$iv2 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, (Function1) it$iv);
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv2 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str);
                            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            String str4 = str;
                            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str2);
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if (!$composer3.getInserting()) {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer3.createNode(factory$iv$iv$iv2);
                            } else {
                                factory$iv$iv$iv2 = factory$iv$iv$iv6;
                                $composer3.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                            String str5 = str2;
                            int $dirty3 = $dirty2;
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                            int i6 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                            RowScope rowScope = RowScopeInstance.INSTANCE;
                            int i7 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, -518425089, "C427@16603L6,428@16659L9,431@16846L7,432@16917L113,425@16495L558,439@17177L6,440@17233L9,443@17383L181,437@17075L512:VideoUpdateCalendarCard.kt#kr57tx");
                            String prefixTitle = video.getPrefixTitle();
                            String str6 = prefixTitle != null ? "" : prefixTitle;
                            long j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                            TextStyle t14 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
                            int i8 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                            CompositionLocal this_$iv2 = CompositionLocalsKt.getLocalDensity();
                            String str7 = str3;
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str7);
                            Object consume2 = $composer3.consume(this_$iv2);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density $this$UnPublished_u24lambda_u247_u241_u248_u240 = (Density) consume2;
                            Modifier modifier6 = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, Dp.box-impl($this$UnPublished_u24lambda_u247_u241_u248_u240.toDp-u2uoSUM(UnPublished$lambda$4(minPrefix$delegate3))).unbox-impl(), 0.0f, 2, (Object) null);
                            ComposerKt.sourceInformationMarkerStart($composer3, -2094920847, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                            invalid$iv = $composer3.changed(minPrefix$delegate3);
                            it$iv2 = $composer3.rememberedValue();
                            if (!invalid$iv || it$iv2 == Composer.Companion.getEmpty()) {
                                Object value$iv6 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda6
                                    public final Object invoke(Object obj) {
                                        Unit UnPublished$lambda$7$1$8$1$0;
                                        UnPublished$lambda$7$1$8$1$0 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$8$1$0(minPrefix$delegate3, (TextLayoutResult) obj);
                                        return UnPublished$lambda$7$1$8$1$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv6);
                                it$iv2 = value$iv6;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            TextKt.Text-Nvy7gAk(str6, modifier6, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i8, false, 1, 0, (Function1) it$iv2, t14, $composer3, 0, 24960, 45048);
                            String title2 = video.getTitle();
                            String str8 = title2 != null ? "" : title2;
                            long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                            TextStyle t142 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
                            int i9 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                            ComposerKt.sourceInformationMarkerStart($composer3, -2094905867, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                            it$iv3 = $composer3.rememberedValue();
                            if (it$iv3 != Composer.Companion.getEmpty()) {
                                Object value$iv7 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda7
                                    public final Object invoke(Object obj) {
                                        Unit UnPublished$lambda$7$1$8$2$0;
                                        UnPublished$lambda$7$1$8$2$0 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$8$2$0(yInLocal$delegate3, (TextLayoutResult) obj);
                                        return UnPublished$lambda$7$1$8$2$0;
                                    }
                                };
                                $composer3.updateRememberedValue(value$iv7);
                                it$iv3 = value$iv7;
                            }
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            TextKt.Text-Nvy7gAk(str8, (Modifier) null, j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i9, false, 1, 0, (Function1) it$iv3, t142, $composer3, 0, 1597824, 45050);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            index$iv = index$iv2 + 1;
                            $composer5 = $composer3;
                            horizontalAlignment$iv4 = horizontalAlignment$iv5;
                            str3 = str7;
                            density = density2;
                            $composer$iv2 = $composer$iv4;
                            size = i5;
                            $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                            $composer$iv = $composer$iv3;
                            str = str4;
                            compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                            $dirty2 = $dirty3;
                            str2 = str5;
                            minPrefix$delegate2 = minPrefix$delegate3;
                            factory$iv$iv$iv4 = factory$iv$iv$iv5;
                            measurePolicy$iv$iv = measurePolicy$iv$iv2;
                            $composer$iv$iv = $composer$iv$iv2;
                            lineColor = lineColor3;
                        }
                    }
                    Object value$iv8 = (Function2) new VideoUpdateCalendarCardKt$UnPublished$2$2$1$1(index, toParent$delegate, yInLocal$delegate2, lines$delegate, null);
                    yInLocal$delegate = yInLocal$delegate2;
                    $this$cache$iv3.updateRememberedValue(value$iv8);
                    it$iv9 = value$iv8;
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    Function0 factory$iv$iv$iv52 = factory$iv$iv$iv4;
                    long lineColor32 = lineColor;
                    MeasurePolicy measurePolicy$iv$iv22 = measurePolicy$iv$iv;
                    $composer3 = $composer5;
                    Composer $composer$iv$iv22 = $composer$iv$iv;
                    Composer $composer$iv42 = $composer$iv2;
                    final MutableFloatState yInLocal$delegate32 = yInLocal$delegate;
                    Alignment.Horizontal horizontalAlignment$iv52 = horizontalAlignment$iv4;
                    final MutableIntState minPrefix$delegate32 = minPrefix$delegate2;
                    EffectsKt.LaunchedEffect(valueOf, valueOf2, list, (Function2) it$iv9, $composer3, ($dirty2 << 3) & 896);
                    Modifier modifier52 = Modifier.Companion;
                    ComposerKt.sourceInformationMarkerStart($composer3, -206809866, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    it$iv = $composer3.rememberedValue();
                    if (it$iv != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Modifier modifier$iv22 = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier52, (Function1) it$iv);
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getTop();
                    MeasurePolicy measurePolicy$iv22 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                    int $changed$iv$iv22 = (54 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str);
                    int compositeKeyHash$iv$iv32 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv22 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv22 = ComposedModifierKt.materializeModifier($composer3, modifier$iv22);
                    Function0 factory$iv$iv$iv62 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv22 = (($changed$iv$iv22 << 6) & 896) | 6;
                    String str42 = str;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, str2);
                    if (!($composer3.getApplier() instanceof Applier)) {
                    }
                    $composer3.startReusableNode();
                    if (!$composer3.getInserting()) {
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv22 = Updater.constructor-impl($composer3);
                    String str52 = str2;
                    int $dirty32 = $dirty2;
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, measurePolicy$iv22, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, localMap$iv$iv22, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv22, Integer.valueOf(compositeKeyHash$iv$iv32), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv22, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv22, materialized$iv$iv22, ComposeUiNode.Companion.getSetModifier());
                    int i62 = ($changed$iv$iv$iv22 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope2 = RowScopeInstance.INSTANCE;
                    int i72 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -518425089, "C427@16603L6,428@16659L9,431@16846L7,432@16917L113,425@16495L558,439@17177L6,440@17233L9,443@17383L181,437@17075L512:VideoUpdateCalendarCard.kt#kr57tx");
                    String prefixTitle2 = video.getPrefixTitle();
                    if (prefixTitle2 != null) {
                    }
                    long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                    TextStyle t143 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
                    int i82 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    CompositionLocal this_$iv22 = CompositionLocalsKt.getLocalDensity();
                    String str72 = str3;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, str72);
                    Object consume22 = $composer3.consume(this_$iv22);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    Density $this$UnPublished_u24lambda_u247_u241_u248_u2402 = (Density) consume22;
                    Modifier modifier62 = SizeKt.widthIn-VpY3zN4$default(Modifier.Companion, Dp.box-impl($this$UnPublished_u24lambda_u247_u241_u248_u2402.toDp-u2uoSUM(UnPublished$lambda$4(minPrefix$delegate32))).unbox-impl(), 0.0f, 2, (Object) null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -2094920847, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    invalid$iv = $composer3.changed(minPrefix$delegate32);
                    it$iv2 = $composer3.rememberedValue();
                    if (!invalid$iv) {
                    }
                    Object value$iv62 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda6
                        public final Object invoke(Object obj) {
                            Unit UnPublished$lambda$7$1$8$1$0;
                            UnPublished$lambda$7$1$8$1$0 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$8$1$0(minPrefix$delegate32, (TextLayoutResult) obj);
                            return UnPublished$lambda$7$1$8$1$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv62);
                    it$iv2 = value$iv62;
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.Text-Nvy7gAk(str6, modifier62, j3, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i82, false, 1, 0, (Function1) it$iv2, t143, $composer3, 0, 24960, 45048);
                    String title22 = video.getTitle();
                    if (title22 != null) {
                    }
                    long j22 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU();
                    TextStyle t1422 = BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14();
                    int i92 = TextOverflow.Companion.getEllipsis-gIe3tQ8();
                    ComposerKt.sourceInformationMarkerStart($composer3, -2094905867, "CC(remember):VideoUpdateCalendarCard.kt#9igjgp");
                    it$iv3 = $composer3.rememberedValue();
                    if (it$iv3 != Composer.Companion.getEmpty()) {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    TextKt.Text-Nvy7gAk(str8, (Modifier) null, j22, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, i92, false, 1, 0, (Function1) it$iv3, t1422, $composer3, 0, 1597824, 45050);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    index$iv = index$iv2 + 1;
                    $composer5 = $composer3;
                    horizontalAlignment$iv4 = horizontalAlignment$iv52;
                    str3 = str72;
                    density = density2;
                    $composer$iv2 = $composer$iv42;
                    size = i5;
                    $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                    $composer$iv = $composer$iv3;
                    str = str42;
                    compositeKeyHash$iv$iv2 = compositeKeyHash$iv$iv;
                    $dirty2 = $dirty32;
                    str2 = str52;
                    minPrefix$delegate2 = minPrefix$delegate32;
                    factory$iv$iv$iv4 = factory$iv$iv$iv52;
                    measurePolicy$iv$iv = measurePolicy$iv$iv22;
                    $composer$iv$iv = $composer$iv$iv22;
                    lineColor = lineColor32;
                }
                Composer $composer6 = $composer5;
                $composer6.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            Object value$iv9 = new Function1() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj) {
                    Unit UnPublished$lambda$6$0;
                    UnPublished$lambda$6$0 = VideoUpdateCalendarCardKt.UnPublished$lambda$6$0(density, lines$delegate, lineColor2, dotColor, (DrawScope) obj);
                    return UnPublished$lambda$6$0;
                }
            };
            lineColor = lineColor2;
            $composer4.updateRememberedValue(value$iv9);
            it$iv6 = value$iv9;
            ComposerKt.sourceInformationMarkerEnd($composer4);
            Modifier modifier$iv3 = PaddingKt.padding-qDBjuR0$default(DrawModifierKt.drawBehind(modifier4, (Function1) it$iv6), Dp.constructor-impl(10), 0.0f, 0.0f, 0.0f, 14, (Object) null);
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            $composer$iv = $composer4;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv32 = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv32, $composer$iv, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv3 = (48 << 3) & 112;
            String str9 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer$iv, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv22 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer$iv, 0));
            modifier3 = modifier4;
            CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
            Function0 factory$iv$iv$iv32 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            $composer2 = $composer4;
            String str22 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
            String str32 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart($composer$iv, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer$iv.getApplier() instanceof Applier)) {
            }
            $composer$iv.startReusableNode();
            if (!$composer$iv.getInserting()) {
            }
            Function0 factory$iv$iv$iv42 = factory$iv$iv$iv;
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer$iv);
            Composer $composer$iv$iv3 = $composer$iv;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            MeasurePolicy measurePolicy$iv$iv3 = measurePolicy$iv3;
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv22), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i32 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i42 = ((48 >> 6) & 112) | 6;
            Composer $composer52 = $composer$iv;
            Composer $composer$iv22 = $composer$iv;
            ComposerKt.sourceInformationMarkerStart($composer52, -2030348532, "C:VideoUpdateCalendarCard.kt#kr57tx");
            $composer52.startReplaceGroup(1042886302);
            ComposerKt.sourceInformation($composer52, "*404@15593L36,405@15662L36,407@15773L410,407@15716L467,420@16291L90,418@16201L1404");
            List<UnpublishedVideo> $this$filter$iv3 = list;
            boolean z22 = false;
            Collection destination$iv$iv2 = new ArrayList();
            while (r20.hasNext()) {
            }
            Alignment.Horizontal horizontalAlignment$iv42 = horizontalAlignment$iv32;
            List $this$fastForEachIndexed$iv3 = (List) destination$iv$iv2;
            index$iv = 0;
            size = $this$fastForEachIndexed$iv3.size();
            while (index$iv < size) {
            }
            Composer $composer62 = $composer52;
            $composer62.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer62);
            ComposerKt.sourceInformationMarkerEnd($composer$iv22);
            $composer$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$$ExternalSyntheticLambda8
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnPublished$lambda$8;
                    UnPublished$lambda$8 = VideoUpdateCalendarCardKt.UnPublished$lambda$8($this$UnPublished, list, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return UnPublished$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Pair<Integer, Float>> UnPublished$lambda$1(MutableState<List<Pair<Integer, Float>>> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (List) $this$getValue$iv.getValue();
    }

    private static final int UnPublished$lambda$4(MutableIntState $minPrefix$delegate) {
        IntState $this$getValue$iv = (IntState) $minPrefix$delegate;
        return $this$getValue$iv.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnPublished$lambda$6$0(Density $density, MutableState $lines$delegate, long $lineColor, long $dotColor, DrawScope $this$drawBehind) {
        float f;
        float x;
        List $this$fastForEachIndexed$iv;
        int i;
        int index$iv;
        int i2;
        List $this$fastForEachIndexed$iv2;
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float x2 = $density.toPx-0680j_4(Dp.constructor-impl(3));
        float radius = $density.toPx-0680j_4(Dp.constructor-impl(2));
        float $this$dp$iv = Dp.constructor-impl(0.5f);
        float strokeWidth = $density.toPx-0680j_4($this$dp$iv);
        Iterable $this$sortedBy$iv = UnPublished$lambda$1($lines$delegate);
        List $this$UnPublished_u24lambda_u246_u240_u244 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$UnPublished$lambda$6$0$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair it = (Pair) t;
                Pair it2 = (Pair) t2;
                return ComparisonsKt.compareValues((Integer) it.getFirst(), (Integer) it2.getFirst());
            }
        });
        List $this$fastForEachIndexed$iv3 = $this$UnPublished_u24lambda_u246_u240_u244;
        int size = $this$fastForEachIndexed$iv3.size();
        int index$iv2 = 0;
        while (true) {
            f = 0.0f;
            if (index$iv2 >= size) {
                break;
            }
            Object item$iv = $this$fastForEachIndexed$iv3.get(index$iv2);
            int index = index$iv2;
            float y = ((Number) ((Pair) item$iv).component2()).floatValue();
            if (y <= 0.0f || index <= 0) {
                index$iv = index$iv2;
                i2 = size;
                $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv3;
            } else {
                Pair pair = (Pair) CollectionsKt.getOrNull(UnPublished$lambda$1($lines$delegate), index - 1);
                Float lastY = pair != null ? (Float) pair.getSecond() : null;
                if (lastY == null || lastY.floatValue() <= 0.0f) {
                    index$iv = index$iv2;
                    i2 = size;
                    $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv3;
                } else {
                    float y$iv = lastY.floatValue();
                    long v1$iv$iv = Float.floatToRawIntBits(x2);
                    long v2$iv$iv = Float.floatToRawIntBits(y$iv);
                    long v2$iv$iv2 = Offset.constructor-impl((v1$iv$iv << 32) | (v2$iv$iv & 4294967295L));
                    long v1$iv$iv2 = Float.floatToRawIntBits(x2);
                    long v2$iv$iv3 = Float.floatToRawIntBits(y);
                    index$iv = index$iv2;
                    i2 = size;
                    $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv3;
                    DrawScope.-CC.drawLine-NGM6Ib0$default($this$drawBehind, $lineColor, v2$iv$iv2, Offset.constructor-impl((v1$iv$iv2 << 32) | (v2$iv$iv3 & 4294967295L)), strokeWidth, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
                }
            }
            index$iv2 = index$iv + 1;
            size = i2;
            $this$fastForEachIndexed$iv3 = $this$fastForEachIndexed$iv2;
        }
        List $this$fastForEachIndexed$iv4 = $this$UnPublished_u24lambda_u246_u240_u244;
        int index$iv3 = 0;
        int size2 = $this$fastForEachIndexed$iv4.size();
        while (index$iv3 < size2) {
            Object item$iv2 = $this$fastForEachIndexed$iv4.get(index$iv3);
            float y2 = ((Number) ((Pair) item$iv2).component2()).floatValue();
            if (y2 <= f) {
                x = x2;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv4;
                i = size2;
            } else {
                float x$iv = x2;
                i = size2;
                long v1$iv$iv3 = Float.floatToRawIntBits(x$iv);
                x = x2;
                $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv4;
                long v2$iv$iv4 = Float.floatToRawIntBits(y2);
                DrawScope.-CC.drawCircle-VaOC9Bg$default($this$drawBehind, $dotColor, radius, Offset.constructor-impl((v1$iv$iv3 << 32) | (v2$iv$iv4 & 4294967295L)), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, (int) BackoffConfigKt.MAX_DELAY_SECONDS, (Object) null);
            }
            index$iv3++;
            size2 = i;
            x2 = x;
            $this$fastForEachIndexed$iv4 = $this$fastForEachIndexed$iv;
            f = 0.0f;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float UnPublished$lambda$7$1$1(MutableFloatState $toParent$delegate) {
        FloatState $this$getValue$iv = (FloatState) $toParent$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float UnPublished$lambda$7$1$4(MutableFloatState $yInLocal$delegate) {
        FloatState $this$getValue$iv = (FloatState) $yInLocal$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnPublished$lambda$7$1$7$0(MutableFloatState $toParent$delegate, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $toParent$delegate.setFloatValue(LayoutCoordinatesKt.boundsInParent(it).getTop());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnPublished$lambda$7$1$8$1$0(MutableIntState $minPrefix$delegate, TextLayoutResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        $minPrefix$delegate.setIntValue(Math.max((int) (result.getSize-YbymL2g() >> 32), UnPublished$lambda$4($minPrefix$delegate)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnPublished$lambda$7$1$8$2$0(MutableFloatState $yInLocal$delegate, TextLayoutResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        int bits$iv$iv$iv = (int) (4294967295L & result.getBoundingBox(0).getCenter-F1C5BW0());
        float it = Float.intBitsToFloat(bits$iv$iv$iv);
        $yInLocal$delegate.setFloatValue(it);
        return Unit.INSTANCE;
    }
}