package kntr.app.deepsearch.history.service;

import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListReply;
import com.bapis.bilibili.app.search.deepsearch.v1.KChatHistoryListReq;
import com.bapis.bilibili.app.search.deepsearch.v1.KDeepSearchMoss;
import kntr.app.deepsearch.history.di.DSHistoryScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: DSHistoryLoadService.kt */
@DSHistoryScope
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/app/deepsearch/history/service/DSHistoryLoadService;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "load", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/search/deepsearch/v1/KChatHistoryListReply;", "cursor", RoomRecommendViewModel.EMPTY_CURSOR, "load-gIAlu-s$history_debug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DSHistoryLoadService {
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|17))|26|6|7|8|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        r3 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /* renamed from: load-gIAlu-s$history_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m641loadgIAlus$history_debug(String cursor, Continuation<? super Result<KChatHistoryListReply>> continuation) {
        DSHistoryLoadService$load$1 dSHistoryLoadService$load$1;
        Object chatHistoryList;
        if (continuation instanceof DSHistoryLoadService$load$1) {
            dSHistoryLoadService$load$1 = (DSHistoryLoadService$load$1) continuation;
            if ((dSHistoryLoadService$load$1.label & Integer.MIN_VALUE) != 0) {
                dSHistoryLoadService$load$1.label -= Integer.MIN_VALUE;
                Object $result = dSHistoryLoadService$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dSHistoryLoadService$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KDeepSearchMoss kDeepSearchMoss = new KDeepSearchMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KChatHistoryListReq kChatHistoryListReq = new KChatHistoryListReq(cursor);
                        dSHistoryLoadService$load$1.L$0 = SpillingKt.nullOutSpilledVariable(cursor);
                        dSHistoryLoadService$load$1.I$0 = 0;
                        dSHistoryLoadService$load$1.label = 1;
                        chatHistoryList = kDeepSearchMoss.chatHistoryList(kChatHistoryListReq, dSHistoryLoadService$load$1);
                        if (chatHistoryList != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = dSHistoryLoadService$load$1.I$0;
                        String str = (String) dSHistoryLoadService$load$1.L$0;
                        ResultKt.throwOnFailure($result);
                        chatHistoryList = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KChatHistoryListReply) chatHistoryList);
                JobKt.ensureActive(dSHistoryLoadService$load$1.getContext());
                return obj;
            }
        }
        dSHistoryLoadService$load$1 = new DSHistoryLoadService$load$1(this, continuation);
        Object $result2 = dSHistoryLoadService$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dSHistoryLoadService$load$1.label) {
        }
        Object obj2 = Result.constructor-impl((KChatHistoryListReply) chatHistoryList);
        JobKt.ensureActive(dSHistoryLoadService$load$1.getContext());
        return obj2;
    }
}