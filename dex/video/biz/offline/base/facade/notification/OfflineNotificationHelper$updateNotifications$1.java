package video.biz.offline.base.facade.notification;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineNotificationHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.notification.OfflineNotificationHelper$updateNotifications$1", f = "OfflineNotificationHelper.kt", i = {0, 0, 0, 0, 0}, l = {113}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "entity", "$i$f$forEach", "$i$a$-forEach-OfflineNotificationHelper$updateNotifications$1$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1"}, v = 1)
public final class OfflineNotificationHelper$updateNotifications$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OfflineVideoEntity> $entities;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ OfflineNotificationHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflineNotificationHelper$updateNotifications$1(List<OfflineVideoEntity> list, OfflineNotificationHelper offlineNotificationHelper, Continuation<? super OfflineNotificationHelper$updateNotifications$1> continuation) {
        super(2, continuation);
        this.$entities = list;
        this.this$0 = offlineNotificationHelper;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflineNotificationHelper$updateNotifications$1(this.$entities, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0077 -> B:14:0x0080). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterable $this$forEach$iv;
        OfflineNotificationHelper offlineNotificationHelper;
        int $i$f$forEach;
        Iterator it;
        OfflineNotificationHelper$updateNotifications$1 offlineNotificationHelper$updateNotifications$1;
        OfflineNotificationHelper$updateNotifications$1 offlineNotificationHelper$updateNotifications$12;
        Iterable $this$forEach$iv2;
        OfflineNotificationHelper offlineNotificationHelper2;
        Iterator it2;
        int $i$f$forEach2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Iterable $this$forEach$iv3 = this.$entities;
                $this$forEach$iv = $this$forEach$iv3;
                offlineNotificationHelper = this.this$0;
                $i$f$forEach = 0;
                it = $this$forEach$iv3.iterator();
                offlineNotificationHelper$updateNotifications$1 = this;
                break;
            case 1:
                int i = this.I$1;
                int $i$f$forEach3 = this.I$0;
                OfflineVideoEntity offlineVideoEntity = (OfflineVideoEntity) this.L$4;
                Object obj = this.L$3;
                ResultKt.throwOnFailure($result);
                $this$forEach$iv2 = (Iterable) this.L$0;
                offlineNotificationHelper2 = (OfflineNotificationHelper) this.L$1;
                it2 = (Iterator) this.L$2;
                $i$f$forEach2 = $i$f$forEach3;
                offlineNotificationHelper$updateNotifications$12 = this;
                offlineNotificationHelper$updateNotifications$1 = offlineNotificationHelper$updateNotifications$12;
                $i$f$forEach = $i$f$forEach2;
                it = it2;
                offlineNotificationHelper = offlineNotificationHelper2;
                $this$forEach$iv = $this$forEach$iv2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element$iv = it.next();
            OfflineVideoEntity entity = (OfflineVideoEntity) element$iv;
            offlineNotificationHelper$updateNotifications$1.L$0 = SpillingKt.nullOutSpilledVariable($this$forEach$iv);
            offlineNotificationHelper$updateNotifications$1.L$1 = offlineNotificationHelper;
            offlineNotificationHelper$updateNotifications$1.L$2 = it;
            offlineNotificationHelper$updateNotifications$1.L$3 = SpillingKt.nullOutSpilledVariable(element$iv);
            offlineNotificationHelper$updateNotifications$1.L$4 = SpillingKt.nullOutSpilledVariable(entity);
            offlineNotificationHelper$updateNotifications$1.I$0 = $i$f$forEach;
            offlineNotificationHelper$updateNotifications$1.I$1 = 0;
            offlineNotificationHelper$updateNotifications$1.label = 1;
            if (offlineNotificationHelper.updateNotification(entity, offlineNotificationHelper$updateNotifications$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            int i2 = $i$f$forEach;
            offlineNotificationHelper$updateNotifications$12 = offlineNotificationHelper$updateNotifications$1;
            $this$forEach$iv2 = $this$forEach$iv;
            offlineNotificationHelper2 = offlineNotificationHelper;
            it2 = it;
            $i$f$forEach2 = i2;
            offlineNotificationHelper$updateNotifications$1 = offlineNotificationHelper$updateNotifications$12;
            $i$f$forEach = $i$f$forEach2;
            it = it2;
            offlineNotificationHelper = offlineNotificationHelper2;
            $this$forEach$iv = $this$forEach$iv2;
            if (!it.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}