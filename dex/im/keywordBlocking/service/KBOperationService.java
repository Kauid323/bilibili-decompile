package im.keywordBlocking.service;

import com.bapis.bilibili.app.im.v1.KKeywordBlockingAddReply;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingAddReq;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingDeleteReply;
import com.bapis.bilibili.app.im.v1.KKeywordBlockingDeleteReq;
import com.bapis.bilibili.app.im.v1.KimMoss;
import im.keywordBlocking.KBListItem;
import im.keywordBlocking.di.KBScope;
import kntr.base.moss.api.KCallOptions;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.JobKt;

/* compiled from: KBOperationService.kt */
@KBScope
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0080@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lim/keywordBlocking/service/KBOperationService;", "", "<init>", "()V", "addItem", "Lkotlin/Result;", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingAddReply;", "text", "", "addItem-gIAlu-s$keyword_blocking_debug", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteItem", "Lcom/bapis/bilibili/app/im/v1/KKeywordBlockingDeleteReply;", "item", "Lim/keywordBlocking/KBListItem;", "deleteItem-gIAlu-s$keyword_blocking_debug", "(Lim/keywordBlocking/KBListItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBOperationService {
    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|17))|26|6|7|8|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0069, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* renamed from: addItem-gIAlu-s$keyword_blocking_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3188addItemgIAlus$keyword_blocking_debug(String text, Continuation<? super Result<KKeywordBlockingAddReply>> continuation) {
        KBOperationService$addItem$1 kBOperationService$addItem$1;
        Object keywordBlockingAdd;
        if (continuation instanceof KBOperationService$addItem$1) {
            kBOperationService$addItem$1 = (KBOperationService$addItem$1) continuation;
            if ((kBOperationService$addItem$1.label & Integer.MIN_VALUE) != 0) {
                kBOperationService$addItem$1.label -= Integer.MIN_VALUE;
                Object $result = kBOperationService$addItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBOperationService$addItem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KKeywordBlockingAddReq kKeywordBlockingAddReq = new KKeywordBlockingAddReq(text);
                        kBOperationService$addItem$1.L$0 = SpillingKt.nullOutSpilledVariable(text);
                        kBOperationService$addItem$1.I$0 = 0;
                        kBOperationService$addItem$1.I$1 = 0;
                        kBOperationService$addItem$1.label = 1;
                        keywordBlockingAdd = kimMoss.keywordBlockingAdd(kKeywordBlockingAddReq, kBOperationService$addItem$1);
                        if (keywordBlockingAdd != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = kBOperationService$addItem$1.I$1;
                        int i3 = kBOperationService$addItem$1.I$0;
                        String str = (String) kBOperationService$addItem$1.L$0;
                        ResultKt.throwOnFailure($result);
                        keywordBlockingAdd = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KKeywordBlockingAddReply) keywordBlockingAdd);
                JobKt.ensureActive(kBOperationService$addItem$1.getContext());
                return obj;
            }
        }
        kBOperationService$addItem$1 = new KBOperationService$addItem$1(this, continuation);
        Object $result2 = kBOperationService$addItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBOperationService$addItem$1.label) {
        }
        Object obj2 = Result.constructor-impl((KKeywordBlockingAddReply) keywordBlockingAdd);
        JobKt.ensureActive(kBOperationService$addItem$1.getContext());
        return obj2;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|8|15|16|17))|26|6|7|8|15|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006d, code lost:
        r4 = kotlin.Result.Companion;
        r2 = kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r2));
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003a  */
    /* renamed from: deleteItem-gIAlu-s$keyword_blocking_debug  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m3189deleteItemgIAlus$keyword_blocking_debug(KBListItem item, Continuation<? super Result<KKeywordBlockingDeleteReply>> continuation) {
        KBOperationService$deleteItem$1 kBOperationService$deleteItem$1;
        Object keywordBlockingDelete;
        if (continuation instanceof KBOperationService$deleteItem$1) {
            kBOperationService$deleteItem$1 = (KBOperationService$deleteItem$1) continuation;
            if ((kBOperationService$deleteItem$1.label & Integer.MIN_VALUE) != 0) {
                kBOperationService$deleteItem$1.label -= Integer.MIN_VALUE;
                Object $result = kBOperationService$deleteItem$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (kBOperationService$deleteItem$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Result.Companion companion = Result.Companion;
                        KimMoss kimMoss = new KimMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                        KKeywordBlockingDeleteReq kKeywordBlockingDeleteReq = new KKeywordBlockingDeleteReq(item.getKeyword());
                        kBOperationService$deleteItem$1.L$0 = SpillingKt.nullOutSpilledVariable(item);
                        kBOperationService$deleteItem$1.I$0 = 0;
                        kBOperationService$deleteItem$1.I$1 = 0;
                        kBOperationService$deleteItem$1.label = 1;
                        keywordBlockingDelete = kimMoss.keywordBlockingDelete(kKeywordBlockingDeleteReq, kBOperationService$deleteItem$1);
                        if (keywordBlockingDelete != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i2 = kBOperationService$deleteItem$1.I$1;
                        int i3 = kBOperationService$deleteItem$1.I$0;
                        KBListItem kBListItem = (KBListItem) kBOperationService$deleteItem$1.L$0;
                        ResultKt.throwOnFailure($result);
                        keywordBlockingDelete = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = Result.constructor-impl((KKeywordBlockingDeleteReply) keywordBlockingDelete);
                JobKt.ensureActive(kBOperationService$deleteItem$1.getContext());
                return obj;
            }
        }
        kBOperationService$deleteItem$1 = new KBOperationService$deleteItem$1(this, continuation);
        Object $result2 = kBOperationService$deleteItem$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (kBOperationService$deleteItem$1.label) {
        }
        Object obj2 = Result.constructor-impl((KKeywordBlockingDeleteReply) keywordBlockingDelete);
        JobKt.ensureActive(kBOperationService$deleteItem$1.getContext());
        return obj2;
    }
}