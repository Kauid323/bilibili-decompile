package kntr.app.tribee.publish;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishCreate.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final /* synthetic */ class TribeePublishCreateKt$TribeePublishCreate$1$2$1 extends FunctionReferenceImpl implements Function2<TribeePublishAction, Continuation<? super Unit>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TribeePublishCreateKt$TribeePublishCreate$1$2$1(Object obj) {
        super(2, obj, TribeePublishViewModel.class, "dispatch", "dispatch(Lkntr/app/tribee/publish/TribeePublishAction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(TribeePublishAction p0, Continuation<? super Unit> continuation) {
        return ((TribeePublishViewModel) this.receiver).dispatch(p0, continuation);
    }
}