package kntr.base.dd.impl.internal.downloader;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.utils.CoroutineExJvmKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: DDDownloader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkntr/base/dd/impl/internal/downloader/DDDownloader;", "", "<init>", "()V", "download", "Lkotlin/Result;", "", "url", "", "path", "totalMD5", "download-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDDownloader {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* renamed from: download-BWLJW6A  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1355downloadBWLJW6A(String url, String path, String totalMD5, Continuation<? super Result<Unit>> continuation) {
        DDDownloader$download$1 dDDownloader$download$1;
        Object withContext;
        if (continuation instanceof DDDownloader$download$1) {
            dDDownloader$download$1 = (DDDownloader$download$1) continuation;
            if ((dDDownloader$download$1.label & Integer.MIN_VALUE) != 0) {
                dDDownloader$download$1.label -= Integer.MIN_VALUE;
                Object $result = dDDownloader$download$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (dDDownloader$download$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dDDownloader$download$1.L$0 = SpillingKt.nullOutSpilledVariable(url);
                        dDDownloader$download$1.L$1 = SpillingKt.nullOutSpilledVariable(path);
                        dDDownloader$download$1.L$2 = SpillingKt.nullOutSpilledVariable(totalMD5);
                        dDDownloader$download$1.label = 1;
                        withContext = BuildersKt.withContext(CoroutineExJvmKt.getIoContext(), new DDDownloader$download$2(path, totalMD5, url, this, null), dDDownloader$download$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        String str = (String) dDDownloader$download$1.L$2;
                        String str2 = (String) dDDownloader$download$1.L$1;
                        String str3 = (String) dDDownloader$download$1.L$0;
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) withContext).m2645unboximpl();
            }
        }
        dDDownloader$download$1 = new DDDownloader$download$1(this, continuation);
        Object $result2 = dDDownloader$download$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (dDDownloader$download$1.label) {
        }
        return ((Result) withContext).m2645unboximpl();
    }
}