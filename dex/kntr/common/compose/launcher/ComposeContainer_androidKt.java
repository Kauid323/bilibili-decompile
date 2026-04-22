package kntr.common.compose.launcher;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Response;
import kntr.base.router.Router;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.serialization.KSerializer;

/* compiled from: ComposeContainer.android.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\u0005\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0086@¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"TAG", "", ComposeContainer_androidKt.INTENT_KEY_KOMPONENT_RESULT, "BLROUTER_NATIVESTART", "launchKomponentForResult", "Lkotlin/Result;", "R", "Lkntr/base/router/Router;", "uri", "Lcom/bilibili/lib/brouter/uri/Uri;", "serializer", "Lkotlinx/serialization/KSerializer;", "(Lkntr/base/router/Router;Lcom/bilibili/lib/brouter/uri/Uri;Lkotlinx/serialization/KSerializer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "compose-launcher_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposeContainer_androidKt {
    private static final String BLROUTER_NATIVESTART = "blrouter.native.start";
    private static final String INTENT_KEY_KOMPONENT_RESULT = "INTENT_KEY_KOMPONENT_RESULT";
    private static final String TAG = "ComposeContainerActivity";

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object launchKomponentForResult(Router $this$launchKomponentForResult, Uri uri, KSerializer<R> kSerializer, Continuation<? super Result<? extends R>> continuation) {
        Continuation $continuation;
        Object obj;
        if (continuation instanceof ComposeContainer_androidKt$launchKomponentForResult$1) {
            $continuation = (ComposeContainer_androidKt$launchKomponentForResult$1) continuation;
            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                $continuation.label -= Integer.MIN_VALUE;
                Object $result = $continuation.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch ($continuation.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        $continuation.L$0 = $this$launchKomponentForResult;
                        $continuation.L$1 = uri;
                        $continuation.L$2 = kSerializer;
                        $continuation.I$0 = 0;
                        $continuation.label = 1;
                        Continuation uCont$iv = $continuation;
                        Continuation cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(uCont$iv), 1);
                        cancellableContinuationImpl.initCancellability();
                        Continuation continuation2 = (CancellableContinuation) cancellableContinuationImpl;
                        Response response = $this$launchKomponentForResult.newBuilder().addInterceptor(new ComposeContainer_androidKt$launchKomponentForResult$2$response$1(continuation2, kSerializer)).build().launch(uri);
                        if (!Intrinsics.areEqual(response, Response.Done.INSTANCE)) {
                            Result.Companion companion = Result.Companion;
                            Result m2635boximpl = Result.m2635boximpl(Result.m2636constructorimpl(ResultKt.createFailure(new IllegalStateException("Failed to launch. Response: " + response))));
                            Result.Companion companion2 = Result.Companion;
                            continuation2.resumeWith(Result.m2636constructorimpl(m2635boximpl));
                        }
                        Object result = cancellableContinuationImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            DebugProbesKt.probeCoroutineSuspended($continuation);
                        }
                        if (result != coroutine_suspended) {
                            obj = result;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        int i = $continuation.I$0;
                        KSerializer kSerializer2 = (KSerializer) $continuation.L$2;
                        Uri uri2 = (Uri) $continuation.L$1;
                        Router router = (Router) $continuation.L$0;
                        ResultKt.throwOnFailure($result);
                        obj = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) obj).m2645unboximpl();
            }
        }
        $continuation = new ComposeContainer_androidKt$launchKomponentForResult$1(continuation);
        Object $result2 = $continuation.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch ($continuation.label) {
        }
        return ((Result) obj).m2645unboximpl();
    }
}