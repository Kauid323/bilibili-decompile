package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationResult;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.MigrationException;

/* compiled from: MigrationRetryHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationRetryHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationRetryHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.RETRY;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x007f -> B:19:0x0086). Please submit an issue!!! */
    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        MigrationRetryHandler$doHandle$1 migrationRetryHandler$doHandle$1;
        Object $result;
        MigrationRetryHandler migrationRetryHandler;
        int currentAttempt;
        int currentAttempt2;
        Object obj;
        MigrationResult result;
        if (continuation instanceof MigrationRetryHandler$doHandle$1) {
            migrationRetryHandler$doHandle$1 = (MigrationRetryHandler$doHandle$1) continuation;
            if ((migrationRetryHandler$doHandle$1.label & Integer.MIN_VALUE) != 0) {
                migrationRetryHandler$doHandle$1.label -= Integer.MIN_VALUE;
                Object $result2 = migrationRetryHandler$doHandle$1.result;
                Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (migrationRetryHandler$doHandle$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result2);
                        MigrationRetryHandler migrationRetryHandler2 = this;
                        int maxAttempts = 1;
                        int currentAttempt3 = chain.getContext().getConfig().getMaxAttempts();
                        if (maxAttempts > currentAttempt3) {
                            new DataLog().info("MigrationRetryHandler do handle, attempt: " + maxAttempts);
                            migrationRetryHandler$doHandle$1.L$0 = chain;
                            migrationRetryHandler$doHandle$1.I$0 = maxAttempts;
                            migrationRetryHandler$doHandle$1.I$1 = currentAttempt3;
                            migrationRetryHandler$doHandle$1.label = 1;
                            Object proceed = chain.proceed(migrationRetryHandler$doHandle$1);
                            if (proceed == $result3) {
                                return $result3;
                            }
                            Object obj2 = $result3;
                            $result = $result2;
                            $result2 = proceed;
                            migrationRetryHandler = migrationRetryHandler2;
                            currentAttempt = maxAttempts;
                            currentAttempt2 = currentAttempt3;
                            obj = obj2;
                            result = (MigrationResult) $result2;
                            if (result instanceof MigrationResult.Success) {
                                return result;
                            }
                            if (!(result instanceof MigrationResult.Failure)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            int currentAttempt4 = currentAttempt + 1;
                            if (currentAttempt == currentAttempt2) {
                                return result;
                            }
                            $result2 = $result;
                            $result3 = obj;
                            currentAttempt3 = currentAttempt2;
                            migrationRetryHandler2 = migrationRetryHandler;
                            maxAttempts = currentAttempt4;
                            if (maxAttempts > currentAttempt3) {
                                MigrationException error = new MigrationException(DataErrorType.MIGRATION_OVER_TIMES.getCode(), DataErrorType.MIGRATION_OVER_TIMES.getTrackMsg());
                                return new MigrationResult.Failure(error);
                            }
                        }
                    case 1:
                        int maxAttempts2 = migrationRetryHandler$doHandle$1.I$1;
                        int currentAttempt5 = migrationRetryHandler$doHandle$1.I$0;
                        chain = (MigrationChain) migrationRetryHandler$doHandle$1.L$0;
                        ResultKt.throwOnFailure($result2);
                        migrationRetryHandler = this;
                        currentAttempt = currentAttempt5;
                        currentAttempt2 = maxAttempts2;
                        obj = $result3;
                        $result = $result2;
                        result = (MigrationResult) $result2;
                        if (result instanceof MigrationResult.Success) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        migrationRetryHandler$doHandle$1 = new MigrationRetryHandler$doHandle$1(this, continuation);
        Object $result22 = migrationRetryHandler$doHandle$1.result;
        Object $result32 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (migrationRetryHandler$doHandle$1.label) {
        }
    }
}