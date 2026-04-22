package kntr.common.share.domain.http;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareApiService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.share.domain.http.ShareApiServiceKt", f = "ShareApiService.kt", i = {0}, l = {95}, m = "handleApiException", n = {"block"}, s = {"L$0"}, v = 1)
public final class ShareApiServiceKt$handleApiException$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShareApiServiceKt$handleApiException$1(Continuation<? super ShareApiServiceKt$handleApiException$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object handleApiException;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        handleApiException = ShareApiServiceKt.handleApiException(null, (Continuation) this);
        return handleApiException;
    }
}