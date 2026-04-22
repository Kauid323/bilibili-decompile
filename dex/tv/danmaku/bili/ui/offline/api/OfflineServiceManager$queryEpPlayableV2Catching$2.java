package tv.danmaku.bili.ui.offline.api;

import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import tv.danmaku.bili.ui.videospace.AuthorSpaceHeaderPlayableParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineServiceManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Ltv/danmaku/bili/ui/offline/api/OgvApiResponseV2;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.offline.api.OfflineServiceManager$queryEpPlayableV2Catching$2", f = "OfflineServiceManager.kt", i = {}, l = {AuthorSpaceHeaderPlayableParams.AUTHOR_SPACE_HEADER_PLAYER_REPORT_AUTO_PLAY}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class OfflineServiceManager$queryEpPlayableV2Catching$2 extends SuspendLambda implements Function1<Continuation<? super OgvApiResponseV2>, Object> {
    final /* synthetic */ String $accessKey;
    final /* synthetic */ RequestBody $requestBody;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineServiceManager$queryEpPlayableV2Catching$2(String str, RequestBody requestBody, Continuation<? super OfflineServiceManager$queryEpPlayableV2Catching$2> continuation) {
        super(1, continuation);
        this.$accessKey = str;
        this.$requestBody = requestBody;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OfflineServiceManager$queryEpPlayableV2Catching$2(this.$accessKey, this.$requestBody, continuation);
    }

    public final Object invoke(Continuation<? super OgvApiResponseV2> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                BiliCall<OgvApiResponseV2> queryEpPlayableV2 = ((OfflineApiService) ServiceGenerator.createService(OfflineApiService.class)).queryEpPlayableV2(this.$accessKey, this.$requestBody);
                Intrinsics.checkNotNullExpressionValue(queryEpPlayableV2, "queryEpPlayableV2(...)");
                this.label = 1;
                Object response = BiliCallExtKt.getResponse(queryEpPlayableV2, (Continuation) this);
                if (response != coroutine_suspended) {
                    $result = response;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Intrinsics.checkNotNull($result, "null cannot be cast to non-null type tv.danmaku.bili.ui.offline.api.OgvApiResponseV2");
        return (OgvApiResponseV2) $result;
    }
}