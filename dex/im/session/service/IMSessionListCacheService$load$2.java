package im.session.service;

import im.base.IMLog;
import im.session.log.LogTagKt;
import im.session.model.IMSessionPageData;
import im.session.model.serializer.IMSessionHomePageDataSerializer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.protobuf.ProtoBuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionCacheService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lim/session/model/IMSessionPageData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.service.IMSessionListCacheService$load$2", f = "IMSessionCacheService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionListCacheService$load$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IMSessionPageData>, Object> {
    final /* synthetic */ Long $userID;
    int label;
    final /* synthetic */ IMSessionListCacheService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionListCacheService$load$2(Long l, IMSessionListCacheService iMSessionListCacheService, Continuation<? super IMSessionListCacheService$load$2> continuation) {
        super(2, continuation);
        this.$userID = l;
        this.this$0 = iMSessionListCacheService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionListCacheService$load$2(this.$userID, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IMSessionPageData> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IMSessionDataCacheService iMSessionDataCacheService;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                IMSessionCacheKey key = new IMSessionCacheKey(this.$userID.longValue());
                iMSessionDataCacheService = this.this$0.dataCacheService;
                byte[] byteArray = iMSessionDataCacheService.load(key.getKeyString());
                if (byteArray == null) {
                    IMLog.Companion.i(LogTagKt.getCacheLogTag(), "当前用户暂无会话列表缓存");
                    return null;
                }
                IMLog.Companion.i(LogTagKt.getCacheLogTag(), "读取到会话列表缓存, 大小 " + byteArray.length + " Bytes");
                return (IMSessionPageData) ProtoBuf.Default.decodeFromByteArray(IMSessionHomePageDataSerializer.INSTANCE, byteArray);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}