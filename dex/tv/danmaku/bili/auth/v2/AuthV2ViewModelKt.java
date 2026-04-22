package tv.danmaku.bili.auth.v2;

import com.bilibili.okretro.BiliApiDataCallback;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.BiliAuthServiceHelper;
import tv.danmaku.bili.api.bean.CardTypeBean;

/* compiled from: AuthV2ViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"fetch", "", "Ltv/danmaku/bili/api/bean/CardTypeBean;", "tmpCode", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthV2ViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Object fetch(String tmpCode, Continuation<? super List<CardTypeBean>> continuation) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuation cont = cancellableContinuationImpl;
        BiliAuthServiceHelper.getBiliPassportServiceHelper().getCardTypes("faceid", tmpCode, new BiliApiDataCallback<List<? extends CardTypeBean>>() { // from class: tv.danmaku.bili.auth.v2.AuthV2ViewModelKt$fetch$2$1
            public void onError(Throwable t) {
                if (cont.isActive()) {
                    Continuation continuation2 = cont;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(t == null ? new CancellationException("card types error") : t)));
                }
            }

            public void onDataSuccess(List<CardTypeBean> list) {
                if (cont.isActive()) {
                    Continuation continuation2 = cont;
                    Result.Companion companion = Result.Companion;
                    continuation2.resumeWith(Result.constructor-impl(list == null ? CollectionsKt.emptyList() : list));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}