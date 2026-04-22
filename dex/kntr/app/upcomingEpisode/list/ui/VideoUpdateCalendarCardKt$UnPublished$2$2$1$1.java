package kntr.app.upcomingEpisode.list.ui;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.ILogger;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoUpdateCalendarCard.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upcomingEpisode.list.ui.VideoUpdateCalendarCardKt$UnPublished$2$2$1$1", f = "VideoUpdateCalendarCard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class VideoUpdateCalendarCardKt$UnPublished$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ MutableState<List<Pair<Integer, Float>>> $lines$delegate;
    final /* synthetic */ MutableFloatState $toParent$delegate;
    final /* synthetic */ MutableFloatState $yInLocal$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoUpdateCalendarCardKt$UnPublished$2$2$1$1(int i, MutableFloatState mutableFloatState, MutableFloatState mutableFloatState2, MutableState<List<Pair<Integer, Float>>> mutableState, Continuation<? super VideoUpdateCalendarCardKt$UnPublished$2$2$1$1> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$toParent$delegate = mutableFloatState;
        this.$yInLocal$delegate = mutableFloatState2;
        this.$lines$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoUpdateCalendarCardKt$UnPublished$2$2$1$1(this.$index, this.$toParent$delegate, this.$yInLocal$delegate, this.$lines$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        float UnPublished$lambda$7$1$1;
        float UnPublished$lambda$7$1$4;
        float UnPublished$lambda$7$1$12;
        float UnPublished$lambda$7$1$42;
        Iterable UnPublished$lambda$1;
        float UnPublished$lambda$7$1$13;
        float UnPublished$lambda$7$1$43;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                UnPublished$lambda$7$1$1 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$1(this.$toParent$delegate);
                UnPublished$lambda$7$1$4 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$4(this.$yInLocal$delegate);
                if (UnPublished$lambda$7$1$1 + UnPublished$lambda$7$1$4 > 0.0f) {
                    ILogger kLog = KLog_androidKt.getKLog();
                    int i = this.$index;
                    UnPublished$lambda$7$1$12 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$1(this.$toParent$delegate);
                    UnPublished$lambda$7$1$42 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$4(this.$yInLocal$delegate);
                    kLog.d("calendar", "index: " + i + ", toParent: " + UnPublished$lambda$7$1$12 + ", yInLocal: " + UnPublished$lambda$7$1$42);
                    MutableState<List<Pair<Integer, Float>>> mutableState = this.$lines$delegate;
                    UnPublished$lambda$1 = VideoUpdateCalendarCardKt.UnPublished$lambda$1(this.$lines$delegate);
                    Iterable $this$filterNot$iv = UnPublished$lambda$1;
                    int i2 = this.$index;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filterNot$iv) {
                        Pair it = (Pair) element$iv$iv;
                        if (!(((Number) it.getFirst()).intValue() == i2)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                    }
                    Integer boxInt = Boxing.boxInt(this.$index);
                    UnPublished$lambda$7$1$13 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$1(this.$toParent$delegate);
                    UnPublished$lambda$7$1$43 = VideoUpdateCalendarCardKt.UnPublished$lambda$7$1$4(this.$yInLocal$delegate);
                    mutableState.setValue(CollectionsKt.plus((List) destination$iv$iv, TuplesKt.to(boxInt, Boxing.boxFloat(UnPublished$lambda$7$1$13 + UnPublished$lambda$7$1$43))));
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}