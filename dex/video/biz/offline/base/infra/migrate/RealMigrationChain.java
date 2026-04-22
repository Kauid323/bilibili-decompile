package video.biz.offline.base.infra.migrate;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationResult;

/* compiled from: RealMigrationChain.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/RealMigrationChain;", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "context", "Lvideo/biz/offline/base/infra/migrate/MigrationContext;", "handlers", "", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "index", "", "<init>", "(Lvideo/biz/offline/base/infra/migrate/MigrationContext;Ljava/util/List;I)V", "getContext", "()Lvideo/biz/offline/base/infra/migrate/MigrationContext;", "proceed", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RealMigrationChain implements MigrationChain {
    public static final int $stable = 8;
    private final MigrationContext context;
    private final List<IMigrateHandler> handlers;
    private final int index;

    /* JADX WARN: Multi-variable type inference failed */
    public RealMigrationChain(MigrationContext context, List<? extends IMigrateHandler> list, int index) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "handlers");
        this.context = context;
        this.handlers = list;
        this.index = index;
    }

    public /* synthetic */ RealMigrationChain(MigrationContext migrationContext, List list, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(migrationContext, list, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // video.biz.offline.base.infra.migrate.MigrationChain
    public MigrationContext getContext() {
        return this.context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    @Override // video.biz.offline.base.infra.migrate.MigrationChain
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object proceed(Continuation<? super MigrationResult> continuation) {
        RealMigrationChain$proceed$1 realMigrationChain$proceed$1;
        Exception e;
        Object doHandle;
        if (continuation instanceof RealMigrationChain$proceed$1) {
            realMigrationChain$proceed$1 = (RealMigrationChain$proceed$1) continuation;
            if ((realMigrationChain$proceed$1.label & Integer.MIN_VALUE) != 0) {
                realMigrationChain$proceed$1.label -= Integer.MIN_VALUE;
                Object $result = realMigrationChain$proceed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (realMigrationChain$proceed$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        if (this.index >= this.handlers.size()) {
                            return MigrationResult.Success.INSTANCE;
                        }
                        RealMigrationChain next = new RealMigrationChain(getContext(), this.handlers, this.index + 1);
                        try {
                            getContext().setCurrentStep(this.handlers.get(this.index).getStep());
                            realMigrationChain$proceed$1.L$0 = SpillingKt.nullOutSpilledVariable(next);
                            realMigrationChain$proceed$1.label = 1;
                            doHandle = this.handlers.get(this.index).doHandle(next, realMigrationChain$proceed$1);
                            return doHandle == coroutine_suspended ? coroutine_suspended : (MigrationResult) doHandle;
                        } catch (CancellationException e2) {
                            throw e2;
                        } catch (Exception e3) {
                            e = e3;
                            return new MigrationResult.Failure(e);
                        }
                    case 1:
                        RealMigrationChain realMigrationChain = (RealMigrationChain) realMigrationChain$proceed$1.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            doHandle = $result;
                        } catch (CancellationException e4) {
                            throw e4;
                        } catch (Exception e5) {
                            e = e5;
                            return new MigrationResult.Failure(e);
                        }
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        realMigrationChain$proceed$1 = new RealMigrationChain$proceed$1(this, continuation);
        Object $result2 = realMigrationChain$proceed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (realMigrationChain$proceed$1.label) {
        }
    }
}