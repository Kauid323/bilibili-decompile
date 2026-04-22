package kntr.app.mall.product.details.page.vm;

import androidx.lifecycle.ViewModel;
import com.bilibili.framework.simpleplayer.SimplePlayer;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.time.Duration;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b&\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020!H\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020!H\u0000¢\u0006\u0002\b)J\u0017\u0010*\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001dH\u0000¢\u0006\u0004\b,\u0010-J\u0015\u0010=\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0002\b>J\u0015\u0010?\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0000¢\u0006\u0002\b@J\r\u0010A\u001a\u00020!H\u0000¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020!H\u0000¢\u0006\u0002\bDJ\u0017\u0010E\u001a\u00020!2\u0006\u0010+\u001a\u00020\u001dH\u0000¢\u0006\u0004\bF\u0010-R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R \u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0\u001c0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0\u001c0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001c\u0010.\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0014R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0014R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0014R \u0010:\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0\u001c0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001d0\u001c0\u0012¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0014¨\u0006G"}, d2 = {"Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "wrapper", "Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "getWrapper", "()Lkntr/app/mall/product/details/page/vm/VideoPlayerViewModelWrapper;", "upSayPlayer", "Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "getUpSayPlayer", "()Lcom/bilibili/framework/simpleplayer/SimplePlayer;", "setUpSayPlayer", "(Lcom/bilibili/framework/simpleplayer/SimplePlayer;)V", "_mutedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "mutedFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getMutedFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_pauseFlow", "pauseFlow", "getPauseFlow", "_pauseByOtherFlow", "pauseByOtherFlow", "getPauseByOtherFlow", "_firstFrameRenderedFlow", "Lkotlin/Pair;", "Lkotlin/time/Duration;", "firstFrameRenderedFlow", "getFirstFrameRenderedFlow", "updatePause", "", "pause", "updatePause$product_details_page_debug", "updatePauseByOther", "updatePauseByOther$product_details_page_debug", "toggleMuted", "toggleMuted$product_details_page_debug", "togglePause", "togglePause$product_details_page_debug", "firstFrameRendered", "duration", "firstFrameRendered-LRDsOJo$product_details_page_debug", "(J)V", "simplePlayer", "getSimplePlayer", "setSimplePlayer", "_upSayMutedFlow", "upSayMutedFlow", "getUpSayMutedFlow", "_upSayPauseFlow", "upSayPauseFlow", "getUpSayPauseFlow", "_upSayPauseByOtherFlow", "upSayPauseByOtherFlow", "getUpSayPauseByOtherFlow", "_upSayFirstFrameRenderedFlow", "upSayFirstFrameRenderedFlow", "getUpSayFirstFrameRenderedFlow", "upSayUpdatePause", "upSayUpdatePause$product_details_page_debug", "upSayUpdatePauseByOther", "upSayUpdatePauseByOther$product_details_page_debug", "upSayToggleMuted", "upSayToggleMuted$product_details_page_debug", "upSayTogglePause", "upSayTogglePause$product_details_page_debug", "upSayFirstFrameRendered", "upSayFirstFrameRendered-LRDsOJo$product_details_page_debug", "product-details-page_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class VideoPlayerViewModel extends ViewModel {
    public static final int $stable = 8;
    private SimplePlayer simplePlayer;
    private SimplePlayer upSayPlayer;
    private final VideoPlayerViewModelWrapper wrapper = new VideoPlayerViewModelWrapper(this);
    private final MutableStateFlow<Boolean> _mutedFlow = StateFlowKt.MutableStateFlow(true);
    private final StateFlow<Boolean> mutedFlow = FlowKt.asStateFlow(this._mutedFlow);
    private final MutableStateFlow<Boolean> _pauseFlow = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> pauseFlow = FlowKt.asStateFlow(this._pauseFlow);
    private final MutableStateFlow<Boolean> _pauseByOtherFlow = StateFlowKt.MutableStateFlow(true);
    private final StateFlow<Boolean> pauseByOtherFlow = FlowKt.asStateFlow(this._pauseByOtherFlow);
    private final MutableStateFlow<Pair<Boolean, Duration>> _firstFrameRenderedFlow = StateFlowKt.MutableStateFlow(new Pair(false, Duration.box-impl(Duration.Companion.getZERO-UwyO8pc())));
    private final StateFlow<Pair<Boolean, Duration>> firstFrameRenderedFlow = FlowKt.asStateFlow(this._firstFrameRenderedFlow);
    private final MutableStateFlow<Boolean> _upSayMutedFlow = StateFlowKt.MutableStateFlow(true);
    private final StateFlow<Boolean> upSayMutedFlow = FlowKt.asStateFlow(this._upSayMutedFlow);
    private final MutableStateFlow<Boolean> _upSayPauseFlow = StateFlowKt.MutableStateFlow(false);
    private final StateFlow<Boolean> upSayPauseFlow = FlowKt.asStateFlow(this._upSayPauseFlow);
    private final MutableStateFlow<Boolean> _upSayPauseByOtherFlow = StateFlowKt.MutableStateFlow(true);
    private final StateFlow<Boolean> upSayPauseByOtherFlow = FlowKt.asStateFlow(this._upSayPauseByOtherFlow);
    private final MutableStateFlow<Pair<Boolean, Duration>> _upSayFirstFrameRenderedFlow = StateFlowKt.MutableStateFlow(new Pair(false, Duration.box-impl(Duration.Companion.getZERO-UwyO8pc())));
    private final StateFlow<Pair<Boolean, Duration>> upSayFirstFrameRenderedFlow = FlowKt.asStateFlow(this._upSayFirstFrameRenderedFlow);

    public final VideoPlayerViewModelWrapper getWrapper() {
        return this.wrapper;
    }

    public final SimplePlayer getUpSayPlayer() {
        return this.upSayPlayer;
    }

    public final void setUpSayPlayer(SimplePlayer simplePlayer) {
        this.upSayPlayer = simplePlayer;
    }

    public final StateFlow<Boolean> getMutedFlow() {
        return this.mutedFlow;
    }

    public final StateFlow<Boolean> getPauseFlow() {
        return this.pauseFlow;
    }

    public final StateFlow<Boolean> getPauseByOtherFlow() {
        return this.pauseByOtherFlow;
    }

    public final StateFlow<Pair<Boolean, Duration>> getFirstFrameRenderedFlow() {
        return this.firstFrameRenderedFlow;
    }

    public final void updatePause$product_details_page_debug(boolean pause) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._pauseFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(pause);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void updatePauseByOther$product_details_page_debug(boolean pause) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._pauseByOtherFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(pause);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void toggleMuted$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._mutedFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            boolean it = ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(!it);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void togglePause$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._pauseFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            boolean it = ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(!it);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    /* renamed from: firstFrameRendered-LRDsOJo$product_details_page_debug  reason: not valid java name */
    public final void m647firstFrameRenderedLRDsOJo$product_details_page_debug(long j) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._firstFrameRenderedFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            Pair pair = (Pair) prevValue$iv;
            nextValue$iv = new Pair(true, Duration.box-impl(j));
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final SimplePlayer getSimplePlayer() {
        return this.simplePlayer;
    }

    public final void setSimplePlayer(SimplePlayer simplePlayer) {
        this.simplePlayer = simplePlayer;
    }

    public final StateFlow<Boolean> getUpSayMutedFlow() {
        return this.upSayMutedFlow;
    }

    public final StateFlow<Boolean> getUpSayPauseFlow() {
        return this.upSayPauseFlow;
    }

    public final StateFlow<Boolean> getUpSayPauseByOtherFlow() {
        return this.upSayPauseByOtherFlow;
    }

    public final StateFlow<Pair<Boolean, Duration>> getUpSayFirstFrameRenderedFlow() {
        return this.upSayFirstFrameRenderedFlow;
    }

    public final void upSayUpdatePause$product_details_page_debug(boolean pause) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._upSayPauseFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(pause);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void upSayUpdatePauseByOther$product_details_page_debug(boolean pause) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._upSayPauseByOtherFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(pause);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void upSayToggleMuted$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._upSayMutedFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            boolean it = ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(!it);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    public final void upSayTogglePause$product_details_page_debug() {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._upSayPauseFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            boolean it = ((Boolean) prevValue$iv).booleanValue();
            nextValue$iv = Boolean.valueOf(!it);
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }

    /* renamed from: upSayFirstFrameRendered-LRDsOJo$product_details_page_debug  reason: not valid java name */
    public final void m648upSayFirstFrameRenderedLRDsOJo$product_details_page_debug(long j) {
        Object prevValue$iv;
        Object nextValue$iv;
        MutableStateFlow $this$update$iv = this._upSayFirstFrameRenderedFlow;
        do {
            prevValue$iv = $this$update$iv.getValue();
            Pair pair = (Pair) prevValue$iv;
            nextValue$iv = new Pair(true, Duration.box-impl(j));
        } while (!$this$update$iv.compareAndSet(prevValue$iv, nextValue$iv));
    }
}