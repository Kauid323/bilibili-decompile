package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.DateKt;
import video.biz.offline.base.infra.migrate.MigrationResult;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.infra.utils.NeuronKt;
import video.biz.offline.base.infra.utils.OfflineNeuron;
import video.biz.offline.base.infra.utils.OfflineTrackType;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* compiled from: MigrationMonitorHandler.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationMonitorHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "trackMigrate", "", "result", "count", "", "duration", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationMonitorHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.MONITOR;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0101  */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationMonitorHandler$doHandle$1 migrationMonitorHandler$doHandle$1;
        Object proceed;
        long startTime;
        MigrationResult result;
        if (continuation instanceof MigrationMonitorHandler$doHandle$1) {
            migrationMonitorHandler$doHandle$1 = (MigrationMonitorHandler$doHandle$1) continuation;
            if ((migrationMonitorHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                migrationMonitorHandler$doHandle$1.label -= Integer.MIN_VALUE;
                Object $result = migrationMonitorHandler$doHandle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (migrationMonitorHandler$doHandle$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        long startTime2 = DateKt.getCurrentTimeMillis();
                        new DataLog().info("MigrationMonitorHandler: migration start " + startTime2);
                        migrationMonitorHandler$doHandle$1.L$0 = chain;
                        migrationMonitorHandler$doHandle$1.J$0 = startTime2;
                        migrationMonitorHandler$doHandle$1.label = 1;
                        proceed = chain.proceed(migrationMonitorHandler$doHandle$1);
                        if (proceed == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        startTime = startTime2;
                        break;
                    case 1:
                        startTime = migrationMonitorHandler$doHandle$1.J$0;
                        chain = (MigrationChain) migrationMonitorHandler$doHandle$1.L$0;
                        ResultKt.throwOnFailure($result);
                        proceed = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                result = (MigrationResult) proceed;
                long endTime = DateKt.getCurrentTimeMillis();
                new DataLog().info("MigrationMonitorHandler: migration end " + endTime + ".");
                long duration = endTime - startTime;
                new DataLog().info("MigrationMonitorHandler: current step " + chain.getContext().getCurrentStep());
                if (chain.getContext().getCurrentStep().compareTo(MigrationStep.PRE_CHECK) > 0) {
                    trackMigrate(result, chain.getContext().getCachedVideos().size(), duration);
                }
                if (!(result instanceof MigrationResult.Success)) {
                    new DataLog().info("MigrationMonitorHandler Migration success: " + duration + " ms");
                } else if (!(result instanceof MigrationResult.Failure)) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    new DataLog().error("Migration failed: " + duration + " ms, reason: " + ((MigrationResult.Failure) result).getError());
                }
                return result;
            }
        }
        migrationMonitorHandler$doHandle$1 = new MigrationMonitorHandler$doHandle$1(this, continuation);
        Object $result2 = migrationMonitorHandler$doHandle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (migrationMonitorHandler$doHandle$1.label) {
        }
        result = (MigrationResult) proceed;
        long endTime2 = DateKt.getCurrentTimeMillis();
        new DataLog().info("MigrationMonitorHandler: migration end " + endTime2 + ".");
        long duration2 = endTime2 - startTime;
        new DataLog().info("MigrationMonitorHandler: current step " + chain.getContext().getCurrentStep());
        if (chain.getContext().getCurrentStep().compareTo(MigrationStep.PRE_CHECK) > 0) {
        }
        if (!(result instanceof MigrationResult.Success)) {
        }
        return result;
    }

    private final void trackMigrate(MigrationResult result, int count, long duration) {
        DataErrorType errorType;
        OfflineNeuron.Companion.dataStartTrackT();
        Config.Companion.setDbMigrateTimes(Config.Companion.getDbMigrateTimes() + 1);
        new DataLog().info("MigrationMonitorHandler current time: " + Config.Companion.getDbMigrateTimes());
        if (result instanceof MigrationResult.Success) {
            OfflineNeuron.Companion.dataSuccessTrackT(Config.Companion.getDbMigrateTimes());
            OfflineNeuron.Companion.trackT$default(OfflineNeuron.Companion, OfflineTrackType.MIGRATEDATA, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, String.valueOf(count)), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(duration))}), null, 4, null);
        } else if (!(result instanceof MigrationResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            if (((MigrationResult.Failure) result).getError() instanceof MigrationException) {
                errorType = DataErrorType.Companion.from(((MigrationException) ((MigrationResult.Failure) result).getError()).getCode());
            } else {
                errorType = DataErrorType.Companion.from(DataErrorType.UNKNOWN.getCode());
            }
            OfflineNeuron.Companion.dataErrorTrackT(errorType);
        }
    }
}