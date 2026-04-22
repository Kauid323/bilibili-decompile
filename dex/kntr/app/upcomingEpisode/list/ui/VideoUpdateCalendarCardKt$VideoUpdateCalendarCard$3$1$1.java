package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUpdateCalendarCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1", f = "VideoUpdateCalendarCard.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {BackoffConfigKt.MAX_DELAY_SECONDS, 126, 127}, m = "invokeSuspend", n = {"doExposure", "invokingByData", "invokingByPV", "doExposure", "invokingByData", "invokingByPV", "doExposure", "invokingByData", "invokingByPV"}, s = {"L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"}, v = 1)
public final class VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoUpdateCalendar $data;
    final /* synthetic */ State<Function0<Unit>> $exposureReporter;
    final /* synthetic */ MutableState<VideoUpdateCalendar> $lastData$delegate;
    final /* synthetic */ MutableState<Boolean> $lastPageVisible$delegate;
    final /* synthetic */ boolean $pageVisible;
    int I$0;
    int I$1;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1(VideoUpdateCalendar videoUpdateCalendar, boolean z, MutableState<VideoUpdateCalendar> mutableState, MutableState<Boolean> mutableState2, State<? extends Function0<Unit>> state, Continuation<? super VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1> continuation) {
        super(2, continuation);
        this.$data = videoUpdateCalendar;
        this.$pageVisible = z;
        this.$lastData$delegate = mutableState;
        this.$lastPageVisible$delegate = mutableState2;
        this.$exposureReporter = state;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1(this.$data, this.$pageVisible, this.$lastData$delegate, this.$lastPageVisible$delegate, this.$exposureReporter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        VideoUpdateCalendar VideoUpdateCalendarCard$lambda$2$1;
        boolean VideoUpdateCalendarCard$lambda$2$4;
        int i;
        int i2;
        Function1 doExposure;
        int i3;
        Function1 doExposure2;
        int i4;
        Function1 doExposure3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                VideoUpdateCalendar videoUpdateCalendar = this.$data;
                VideoUpdateCalendarCard$lambda$2$1 = VideoUpdateCalendarCardKt.VideoUpdateCalendarCard$lambda$2$1(this.$lastData$delegate);
                int i5 = !Intrinsics.areEqual(videoUpdateCalendar, VideoUpdateCalendarCard$lambda$2$1) ? 1 : 0;
                boolean z = this.$pageVisible;
                VideoUpdateCalendarCard$lambda$2$4 = VideoUpdateCalendarCardKt.VideoUpdateCalendarCard$lambda$2$4(this.$lastPageVisible$delegate);
                int i6 = z != VideoUpdateCalendarCard$lambda$2$4 ? 1 : 0;
                this.$lastData$delegate.setValue(this.$data);
                VideoUpdateCalendarCardKt.VideoUpdateCalendarCard$lambda$2$5(this.$lastPageVisible$delegate, this.$pageVisible);
                Function1 doExposure4 = new VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1(this.$exposureReporter, this.$data, null);
                if (this.$pageVisible) {
                    if (i5 != 0) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(doExposure4);
                        this.I$0 = i5;
                        this.I$1 = i6;
                        this.label = 1;
                        if (doExposure4.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i3 = i6;
                        doExposure2 = doExposure4;
                    } else if (i6 != 0) {
                        Duration.Companion companion = Duration.Companion;
                        this.L$0 = doExposure4;
                        this.I$0 = i5;
                        this.I$1 = i6;
                        this.label = 2;
                        if (DelayKt.delay-VtjQ1oo(DurationKt.toDuration((int) MediaAttrUtils.TYPE_PAY_SEASON, DurationUnit.MILLISECONDS), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i5;
                        i2 = i6;
                        doExposure = doExposure4;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(doExposure);
                        this.I$0 = i;
                        this.I$1 = i2;
                        this.label = 3;
                        if (doExposure.invoke(this) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i4 = i2;
                        doExposure3 = doExposure;
                    }
                }
                return Unit.INSTANCE;
            case 1:
                i3 = this.I$1;
                int i7 = this.I$0;
                doExposure2 = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            case 2:
                i2 = this.I$1;
                i = this.I$0;
                doExposure = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                this.L$0 = SpillingKt.nullOutSpilledVariable(doExposure);
                this.I$0 = i;
                this.I$1 = i2;
                this.label = 3;
                if (doExposure.invoke(this) != coroutine_suspended) {
                }
                break;
            case 3:
                i4 = this.I$1;
                int i8 = this.I$0;
                doExposure3 = (Function1) this.L$0;
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}