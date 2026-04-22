package video.biz.offline.base.infra.migrate;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IMigrateHandler.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "", "context", "Lvideo/biz/offline/base/infra/migrate/MigrationContext;", "getContext", "()Lvideo/biz/offline/base/infra/migrate/MigrationContext;", "proceed", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface MigrationChain {
    MigrationContext getContext();

    Object proceed(Continuation<? super MigrationResult> continuation);
}