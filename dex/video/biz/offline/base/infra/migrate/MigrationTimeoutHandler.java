package video.biz.offline.base.infra.migrate;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.time.Duration;
import kotlinx.coroutines.TimeoutKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationResult;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* compiled from: MigrationTimeoutHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationTimeoutHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationTimeoutHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.TIMEOUT;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationTimeoutHandler$doHandle$1 migrationTimeoutHandler$doHandle$1;
        List<OfflineVideoEntity> cachedVideos;
        Object obj;
        List<OfflineVideoEntity> list;
        if (continuation instanceof MigrationTimeoutHandler$doHandle$1) {
            migrationTimeoutHandler$doHandle$1 = (MigrationTimeoutHandler$doHandle$1) continuation;
            if ((migrationTimeoutHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                migrationTimeoutHandler$doHandle$1.label -= Integer.MIN_VALUE;
                Object $result = migrationTimeoutHandler$doHandle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (migrationTimeoutHandler$doHandle$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        cachedVideos = chain.getContext().getCachedVideos();
                        long timeout = ((Duration) chain.getContext().getConfig().getStrategy().invoke(Boxing.boxInt(cachedVideos.size()))).unbox-impl();
                        new DataLog().info("MigrationTimeoutHandler migrate with timeout: " + Duration.toString-impl(timeout));
                        try {
                            migrationTimeoutHandler$doHandle$1.L$0 = SpillingKt.nullOutSpilledVariable(chain);
                            migrationTimeoutHandler$doHandle$1.L$1 = SpillingKt.nullOutSpilledVariable(cachedVideos);
                            migrationTimeoutHandler$doHandle$1.J$0 = timeout;
                            migrationTimeoutHandler$doHandle$1.label = 1;
                            Object obj2 = TimeoutKt.withTimeout-KLykuaI(timeout, new MigrationTimeoutHandler$doHandle$result$1(chain, null), migrationTimeoutHandler$doHandle$1);
                            if (obj2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            obj = obj2;
                            list = cachedVideos;
                            try {
                                MigrationResult result = (MigrationResult) obj;
                                return result;
                            } catch (Exception e) {
                                cachedVideos = list;
                                MigrationException error = new MigrationException(DataErrorType.MIGRATION_TIMEOUT.getCode(), DataErrorType.MIGRATION_TIMEOUT.getTrackMsg());
                                MigrationResult result2 = new MigrationResult.Failure(error);
                                return result2;
                            }
                        } catch (Exception e2) {
                            MigrationException error2 = new MigrationException(DataErrorType.MIGRATION_TIMEOUT.getCode(), DataErrorType.MIGRATION_TIMEOUT.getTrackMsg());
                            MigrationResult result22 = new MigrationResult.Failure(error2);
                            return result22;
                        }
                    case 1:
                        long j = migrationTimeoutHandler$doHandle$1.J$0;
                        cachedVideos = (List) migrationTimeoutHandler$doHandle$1.L$1;
                        MigrationChain migrationChain = (MigrationChain) migrationTimeoutHandler$doHandle$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            list = cachedVideos;
                            obj = $result;
                            MigrationResult result3 = (MigrationResult) obj;
                            return result3;
                        } catch (Exception e3) {
                            MigrationException error22 = new MigrationException(DataErrorType.MIGRATION_TIMEOUT.getCode(), DataErrorType.MIGRATION_TIMEOUT.getTrackMsg());
                            MigrationResult result222 = new MigrationResult.Failure(error22);
                            return result222;
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        migrationTimeoutHandler$doHandle$1 = new MigrationTimeoutHandler$doHandle$1(this, continuation);
        Object $result2 = migrationTimeoutHandler$doHandle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (migrationTimeoutHandler$doHandle$1.label) {
        }
    }
}