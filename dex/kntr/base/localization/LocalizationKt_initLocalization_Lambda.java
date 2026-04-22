package kntr.base.localization;

import com.bilibili.gripper.api.log.GLog;
import com.bilibili.lib.gripper.api.GDeferred;
import com.bilibili.lib.gripper.api.SuspendProducer;
import com.bilibili.lib.gripper.api.internal.GenerateHelper;
import com.bilibili.lib.gripper.api.internal.ProducerBase;
import com.google.common.base.Optional;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: LocalizationKt_initLocalization_Lambda.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\u0000H\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\u000e\u0010\u0012\u001a\u00020\u0002H\u0094@¢\u0006\u0002\u0010\u0013R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/base/localization/LocalizationKt_initLocalization_Lambda;", "Lcom/bilibili/lib/gripper/api/internal/ProducerBase;", "", "v0", "Lcom/google/common/base/Optional;", "Lcom/bilibili/lib/gripper/api/SuspendProducer;", "Lcom/bilibili/gripper/api/log/GLog;", "compatJavaParam", "<init>", "(Lcom/google/common/base/Optional;Lkotlin/Unit;)V", "d_v0", "Lcom/bilibili/lib/gripper/api/GDeferred;", "create", "prepareParams", "", "Lkotlinx/coroutines/Job;", "context", "Lkotlin/coroutines/CoroutineContext;", "invokeProducer", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LocalizationKt_initLocalization_Lambda extends ProducerBase<Unit> {
    public static final int $stable = 8;
    private GDeferred<? extends GLog> d_v0;
    private final Optional<SuspendProducer<GLog>> v0;

    public LocalizationKt_initLocalization_Lambda(Optional<SuspendProducer<GLog>> optional, Unit compatJavaParam) {
        Intrinsics.checkNotNullParameter(optional, "v0");
        this.v0 = optional;
    }

    public LocalizationKt_initLocalization_Lambda create() {
        return new LocalizationKt_initLocalization_Lambda(this.v0, null);
    }

    protected Collection<Job> prepareParams(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set r = new LinkedHashSet();
        this.d_v0 = GenerateHelper.deferredIfPresent(context, r, this.v0);
        return r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invokeProducer(Continuation<? super Unit> continuation) {
        LocalizationKt_initLocalization_Lambda$invokeProducer$1 localizationKt_initLocalization_Lambda$invokeProducer$1;
        if (continuation instanceof LocalizationKt_initLocalization_Lambda$invokeProducer$1) {
            localizationKt_initLocalization_Lambda$invokeProducer$1 = (LocalizationKt_initLocalization_Lambda$invokeProducer$1) continuation;
            if ((localizationKt_initLocalization_Lambda$invokeProducer$1.label & Integer.MIN_VALUE) != 0) {
                localizationKt_initLocalization_Lambda$invokeProducer$1.label -= Integer.MIN_VALUE;
                Object $result = localizationKt_initLocalization_Lambda$invokeProducer$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (localizationKt_initLocalization_Lambda$invokeProducer$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        GDeferred<? extends GLog> gDeferred = this.d_v0;
                        GLog gLog = gDeferred != null ? (GLog) gDeferred.getCompleted() : null;
                        localizationKt_initLocalization_Lambda$invokeProducer$1.label = 1;
                        if (Localization_androidKt.initLocalization(gLog, localizationKt_initLocalization_Lambda$invokeProducer$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        localizationKt_initLocalization_Lambda$invokeProducer$1 = new LocalizationKt_initLocalization_Lambda$invokeProducer$1(this, continuation);
        Object $result2 = localizationKt_initLocalization_Lambda$invokeProducer$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (localizationKt_initLocalization_Lambda$invokeProducer$1.label) {
        }
        return Unit.INSTANCE;
    }
}