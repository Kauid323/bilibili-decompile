package tv.danmaku.bili.ui.main2.mine.holder;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.ThemeStrategy;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar;
import kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.ui.main2.api.MVideoUpdateCalendar;

/* compiled from: MineUpComingHolder.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/holder/MineUpComingHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "pageVisibility", "Lkotlinx/coroutines/flow/StateFlow;", "", "<init>", "(Landroid/view/View;Lkotlinx/coroutines/flow/StateFlow;)V", AuthResultCbHelper.ARGS_STATE, "Landroidx/compose/runtime/MutableState;", "Lkntr/app/upcomingEpisode/list/model/VideoUpdateCalendar;", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "bind", "", "videoUpdateCalendar", "Ltv/danmaku/bili/ui/main2/api/MVideoUpdateCalendar;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineUpComingHolder extends RecyclerView.ViewHolder {
    private final ComposeView composeView;
    private final StateFlow<Boolean> pageVisibility;
    private final MutableState<VideoUpdateCalendar> state;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineUpComingHolder(final View itemView, StateFlow<Boolean> stateFlow) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(stateFlow, "pageVisibility");
        this.pageVisibility = stateFlow;
        this.state = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        ComposeView findViewById = itemView.findViewById(R.id.compose_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.composeView = findViewById;
        this.composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-729492769, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder$$ExternalSyntheticLambda4
            public final Object invoke(Object obj, Object obj2) {
                Unit _init_$lambda$0;
                _init_$lambda$0 = MineUpComingHolder._init_$lambda$0(MineUpComingHolder.this, itemView, (Composer) obj, ((Integer) obj2).intValue());
                return _init_$lambda$0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(final MineUpComingHolder this$0, final View $itemView, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C48@1709L1992,48@1699L2002:MineUpComingHolder.kt#qbb11z");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-729492769, $changed, -1, "tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder.<anonymous> (MineUpComingHolder.kt:48)");
            }
            BiliThemeKt.BiliTheme((ThemeStrategy) null, false, ComposableLambdaKt.rememberComposableLambda(1622527527, true, new Function2() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    return MineUpComingHolder.lambda$0$0(MineUpComingHolder.this, $itemView, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), $composer, (int) BR.negativeBtnVisible, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0(MineUpComingHolder this$0, final View $itemView, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C:MineUpComingHolder.kt#qbb11z");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1622527527, $changed, -1, "tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder.<anonymous>.<anonymous> (MineUpComingHolder.kt:49)");
            }
            final VideoUpdateCalendar data = (VideoUpdateCalendar) this$0.state.getValue();
            if (data != null) {
                $composer.startReplaceGroup(1155741068);
                ComposerKt.sourceInformation($composer, "53@1921L16,57@2129L714,71@2960L288,79@3293L354,51@1806L1863");
                boolean booleanValue = ((Boolean) SnapshotStateKt.collectAsState(this$0.pageVisibility, (CoroutineContext) null, $composer, 0, 1).getValue()).booleanValue();
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null), 0.0f, 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 175839153, "CC(remember):MineUpComingHolder.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(data) | $composer.changedInstance($itemView);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            return MineUpComingHolder.lambda$0$0$0$0(data, $itemView);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier = ClickableKt.clickable-oSLSa3U$default(fillMaxWidth$default, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 175865319, "CC(remember):MineUpComingHolder.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(data);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder$$ExternalSyntheticLambda2
                        public final Object invoke() {
                            return MineUpComingHolder.lambda$0$0$1$0(data);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 function0 = (Function0) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerStart($composer, 175876041, "CC(remember):MineUpComingHolder.kt#9igjgp");
                boolean invalid$iv3 = $composer.changedInstance(data);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function0() { // from class: tv.danmaku.bili.ui.main2.mine.holder.MineUpComingHolder$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            return MineUpComingHolder.lambda$0$0$2$0(data);
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                VideoUpdateCalendarCardKt.VideoUpdateCalendarCard(data, booleanValue, modifier, "main.my-information.reserve-calendar.0", function0, (Function0) it$iv3, $composer, VideoUpdateCalendar.$stable | 3072, 0);
            } else {
                $composer.startReplaceGroup(1153911355);
            }
            $composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$0$0(VideoUpdateCalendar $data, View $itemView) {
        Uri uri;
        String $this$toUri$iv = $data.getUrl();
        if ($this$toUri$iv != null && (uri = Uri.parse($this$toUri$iv)) != null) {
            Map reportParams = $data.getReportParams();
            if (reportParams == null) {
                reportParams = MapsKt.emptyMap();
            }
            Neurons.reportClick(false, "main.my-information.reserve-calendar.0.click", MapsKt.plus(reportParams, TuplesKt.to("button_type", "reserve_calendar")));
            BLRouter.routeTo(RouteRequestKt.toRouteRequest(uri), $itemView.getContext());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$1$0(VideoUpdateCalendar $data) {
        Map reportParams = $data.getReportParams();
        if (reportParams == null) {
            reportParams = MapsKt.emptyMap();
        }
        Neurons.reportExposure$default(false, "main.my-information.reserve-calendar.0.show", reportParams, (List) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$0$0$2$0(VideoUpdateCalendar $data) {
        Map reportParams = $data.getReportParams();
        if (reportParams == null) {
            reportParams = MapsKt.emptyMap();
        }
        Neurons.reportClick(false, "main.my-information.reserve-calendar.0.click", MapsKt.plus(reportParams, TuplesKt.to("button_type", "video")));
        return Unit.INSTANCE;
    }

    public final void bind(MVideoUpdateCalendar videoUpdateCalendar) {
        VideoUpdateCalendar k = videoUpdateCalendar != null ? videoUpdateCalendar.toK() : null;
        this.state.setValue(k);
        View $this$updateLayoutParams$iv = this.composeView;
        ViewGroup.LayoutParams params$iv$iv = $this$updateLayoutParams$iv.getLayoutParams();
        if (params$iv$iv == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        params$iv$iv.height = k != null ? ListExtentionsKt.toPx(k.getHeightDp()) : 0;
        $this$updateLayoutParams$iv.setLayoutParams(params$iv$iv);
    }

    /* compiled from: MineUpComingHolder.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/holder/MineUpComingHolder$Companion;", "", "<init>", "()V", "create", "Ltv/danmaku/bili/ui/main2/mine/holder/MineUpComingHolder;", "parent", "Landroid/view/ViewGroup;", "pageVisibility", "Lkotlinx/coroutines/flow/StateFlow;", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MineUpComingHolder create(ViewGroup parent, StateFlow<Boolean> stateFlow) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(stateFlow, "pageVisibility");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.bili_layout_main_user_center_compose, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new MineUpComingHolder(inflate, stateFlow);
        }
    }
}