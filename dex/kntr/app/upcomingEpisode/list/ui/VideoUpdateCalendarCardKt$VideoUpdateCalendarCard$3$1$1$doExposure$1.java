package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.runtime.State;
import com.bapis.bilibili.community.interfacess.watch.v1.KAddWatchExposeRecordReq;
import com.bapis.bilibili.community.interfacess.watch.v1.KWatchInterfaceMoss;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upcomingEpisode.list.model.VideoUpdateCalendar;
import kntr.base.log.KLog_androidKt;
import kntr.base.moss.api.KCallOptions;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: VideoUpdateCalendarCard.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1", f = "VideoUpdateCalendarCard.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ VideoUpdateCalendar $data;
    final /* synthetic */ State<Function0<Unit>> $exposureReporter;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1(State<? extends Function0<Unit>> state, VideoUpdateCalendar videoUpdateCalendar, Continuation<? super VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1> continuation) {
        super(1, continuation);
        this.$exposureReporter = state;
        this.$data = videoUpdateCalendar;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new VideoUpdateCalendarCardKt$VideoUpdateCalendarCard$3$1$1$doExposure$1(this.$exposureReporter, this.$data, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        String trackInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    ((Function0) this.$exposureReporter.getValue()).invoke();
                    boolean z = false;
                    if (this.$data.getTrackInfo() != null && (!StringsKt.isBlank(trackInfo))) {
                        z = true;
                    }
                    if (z) {
                        this.label = 1;
                        if (new KWatchInterfaceMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null).addWatchExposeRecord(new KAddWatchExposeRecordReq(this.$data.getTrackInfo()), (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } catch (Exception e) {
            KLog_androidKt.getKLog().w("WatchInterfaceMoss().addWatchExposeRecord", ExceptionsKt.stackTraceToString(e));
        }
        return Unit.INSTANCE;
    }
}