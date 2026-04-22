package im.keywordBlocking.service;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingListReply;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingListReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.keywordBlocking.di.KBScope;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: KBPageLoadService.kt */
@KBScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0080@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lim/keywordBlocking/service/KBPageLoadService;", "", "<init>", "()V", "load", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingListReply;", "load-IoAF18A$keyword_blocking_debug", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBPageLoadService {
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|17))|26|6|7|8|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* renamed from: load-IoAF18A$keyword_blocking_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3191loadIoAF18A$keyword_blocking_debug(Continuation<? super Result<KKeywordBlockingListReply>> continuation) {
        KBPageLoadService$load$1 kBPageLoadService$load$1;
        Object keywordBlockingList;
        if (continuation instanceof KBPageLoadService$load$1) {
            kBPageLoadService$load$1 = (KBPageLoadService$load$1) continuation;
            if ((kBPageLoadService$load$1.label & Integer.MIN_VALUE) != 0) {
                kBPageLoadService$load$1.label -= Integer.MIN_VALUE;
                Object $result = kBPageLoadService$load$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBPageLoadService$load$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KKeywordBlockingListReq kKeywordBlockingListReq = new KKeywordBlockingListReq();
                        kBPageLoadService$load$1.I$0 = 0;
                        kBPageLoadService$load$1.I$1 = 0;
                        kBPageLoadService$load$1.label = 1;
                        keywordBlockingList = kimMoss.keywordBlockingList(kKeywordBlockingListReq, kBPageLoadService$load$1);
                        if (keywordBlockingList != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = kBPageLoadService$load$1.I$1;
                        int i3 = kBPageLoadService$load$1.I$0;
                        ResultKt.throwOnFailure($result);
                        keywordBlockingList = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KKeywordBlockingListReply) keywordBlockingList);
                JobKt.ensureActive(kBPageLoadService$load$1.getContext());
                return obj;
            }
        }
        kBPageLoadService$load$1 = new KBPageLoadService$load$1(this, continuation);
        Object $result2 = kBPageLoadService$load$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBPageLoadService$load$1.label) {
        }
        Object obj2 = Result.constructor-impl((KKeywordBlockingListReply) keywordBlockingList);
        JobKt.ensureActive(kBPageLoadService$load$1.getContext());
        return obj2;
    }
}