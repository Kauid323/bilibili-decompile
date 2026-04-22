package im.setting.service;

import com.tencent.open.SocialConstants;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingRequestService.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.setting.service.IMSettingRequestServiceImpl", f = "SettingRequestService.kt", i = {0, 0}, l = {TraceLevel.ABOVE_DEBUG}, m = SocialConstants.TYPE_REQUEST, n = {"type", "req"}, s = {"L$0", "L$1"}, v = 1)
public final class IMSettingRequestServiceImpl$request$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IMSettingRequestServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSettingRequestServiceImpl$request$1(IMSettingRequestServiceImpl iMSettingRequestServiceImpl, Continuation<? super IMSettingRequestServiceImpl$request$1> continuation) {
        super(continuation);
        this.this$0 = iMSettingRequestServiceImpl;
    }

    public final Object invokeSuspend(Object obj) {
        Object request;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        request = this.this$0.request((Continuation) this);
        return request;
    }
}