package im.session.base;

import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import com.google.common.base.Optional;
import im.base.config.IMConfigSetting;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: IMConversationDraftServiceKt_provideDraftService_Lambda.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BC\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00040\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0011\u001a\u00020\u0000H\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0018\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lim/session/base/IMConversationDraftServiceKt_provideDraftService_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "Lim/session/base/IMConversationDraftService;", "v0", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lim/base/config/IMConfigSetting;", "v1", "v2", "Lcom/google/common/base/Optional;", "compatJavaParam", "", "<init>", "(Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/bilibili/lib/gripper/api/SuspendProducer;Lcom/google/common/base/Optional;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "d_v1", "d_v2", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMConversationDraftServiceKt_provideDraftService_Lambda extends ProducerBase<IMConversationDraftService> {
    private GDeferred<IMConfigSetting> d_v0;
    private GDeferred<? extends IMConversationDraftService> d_v1;
    private GDeferred<? extends IMConversationDraftService> d_v2;
    private final SuspendProducer<IMConfigSetting> v0;
    private final SuspendProducer<IMConversationDraftService> v1;
    private final Optional<SuspendProducer<IMConversationDraftService>> v2;

    public IMConversationDraftServiceKt_provideDraftService_Lambda(SuspendProducer<IMConfigSetting> suspendProducer, SuspendProducer<IMConversationDraftService> suspendProducer2, Optional<SuspendProducer<IMConversationDraftService>> optional, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(suspendProducer, "v0");
        Intrinsics.checkNotNullParameter(suspendProducer2, "v1");
        Intrinsics.checkNotNullParameter(optional, "v2");
        this.v0 = suspendProducer;
        this.v1 = suspendProducer2;
        this.v2 = optional;
    }

    public IMConversationDraftServiceKt_provideDraftService_Lambda create() {
        return new IMConversationDraftServiceKt_provideDraftService_Lambda(this.v0, this.v1, this.v2, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferred(context, r, this.v0);
        this.d_v1 = GenerateHelper.deferred(context, r, this.v1);
        this.d_v2 = GenerateHelper.deferredIfPresent(context, r, this.v2);
        return r;
    }

    protected Object invokeProducer(Continuation<? super IMConversationDraftService> continuation) {
        GDeferred<IMConfigSetting> gDeferred = this.d_v0;
        if (gDeferred == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v0");
            gDeferred = null;
        }
        IMConfigSetting iMConfigSetting = (IMConfigSetting) gDeferred.getCompleted();
        GDeferred<? extends IMConversationDraftService> gDeferred2 = this.d_v1;
        if (gDeferred2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("d_v1");
            gDeferred2 = null;
        }
        IMConversationDraftService iMConversationDraftService = (IMConversationDraftService) gDeferred2.getCompleted();
        GDeferred<? extends IMConversationDraftService> gDeferred3 = this.d_v2;
        return IMConversationDraftServiceKt.provideDraftService(iMConfigSetting, iMConversationDraftService, gDeferred3 != null ? (IMConversationDraftService) gDeferred3.getCompleted() : null);
    }
}