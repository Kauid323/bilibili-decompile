package kntr.app.live.room.multivideo.poll;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: LivePollConnection.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0018B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lkntr/app/live/room/multivideo/poll/LivePollConnection;", "T", "Lkntr/app/live/room/multivideo/poll/ILivePollConnection;", "livePollParam", "Lkntr/app/live/room/multivideo/poll/LivePollParam;", "<init>", "(Lkntr/app/live/room/multivideo/poll/LivePollParam;)V", "messageFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "job", "Lkotlinx/coroutines/Job;", "lastOffset", RoomRecommendViewModel.EMPTY_CURSOR, "start", RoomRecommendViewModel.EMPTY_CURSOR, "subscribeMessageAsFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "isActive", RoomRecommendViewModel.EMPTY_CURSOR, "subscribeMessageAsData", "onReceiveMsg", "Lkotlin/Function1;", "updateInterval", "interval", "Companion", "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class LivePollConnection<T> implements ILivePollConnection<T> {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_INTERVAL = 2000;
    public static final String TAG = "LivePollConnection";
    private Job job;
    private long lastOffset;
    private LivePollParam<T> livePollParam;
    private final MutableSharedFlow<T> messageFlow;

    public LivePollConnection(LivePollParam<T> livePollParam) {
        Intrinsics.checkNotNullParameter(livePollParam, "livePollParam");
        this.livePollParam = livePollParam;
        this.messageFlow = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    @Override // kntr.app.live.room.multivideo.poll.ILivePollConnection
    public void start() {
        Job job = this.job;
        boolean z = false;
        if (job != null && job.isActive()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.job = BuildersKt.launch$default(this.livePollParam.getScope(), (CoroutineExceptionHandler) new LivePollConnection$start$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this), (CoroutineStart) null, new LivePollConnection$start$2(this, null), 2, (Object) null);
    }

    @Override // kntr.app.live.room.multivideo.poll.ILivePollConnection
    public SharedFlow<T> subscribeMessageAsFlow() {
        return this.messageFlow;
    }

    @Override // kntr.app.live.room.multivideo.poll.ILivePollConnection
    public boolean isActive() {
        Job job = this.job;
        return job != null && job.isActive();
    }

    @Override // kntr.app.live.room.multivideo.poll.ILivePollConnection
    public void subscribeMessageAsData(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onReceiveMsg");
        BuildersKt.launch$default(this.livePollParam.getScope(), (CoroutineContext) null, (CoroutineStart) null, new LivePollConnection$subscribeMessageAsData$1(this, function1, null), 3, (Object) null);
    }

    @Override // kntr.app.live.room.multivideo.poll.ILivePollConnection
    public void updateInterval(long interval) {
        if (interval != this.livePollParam.getDelay()) {
            this.livePollParam = LivePollParam.copy$default(this.livePollParam, null, interval, null, null, false, 29, null);
        }
    }

    /* compiled from: LivePollConnection.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkntr/app/live/room/multivideo/poll/LivePollConnection$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "TAG", RoomRecommendViewModel.EMPTY_CURSOR, "DEFAULT_INTERVAL", RoomRecommendViewModel.EMPTY_CURSOR, "multivideo_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}