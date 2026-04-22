package video.biz.offline.base.infra.migrate;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationContext;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: IMigrateHandler.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0006\u0010\u0013\u001a\u00020\u0000J\u0014\u0010\u0014\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0016J\u0014\u0010\u0017\u001a\u00020\u00002\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0016J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\fJ\u001e\u0010\u001b\u001a\u00020\u00002\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010J\u0006\u0010\u001d\u001a\u00020\u001eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/Builder;", "", "<init>", "()V", "handlers", "", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "cachedVideos", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "dramaGroups", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "retryTimes", "", "timeoutStrategy", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lvideo/biz/offline/base/infra/migrate/TimeoutStrategy;", "addHandler", "handler", "addDefaultHandlers", "addCachedVideos", "videos", "", "addDramaMap", "groups", "setRetryTimes", "times", "setTimeoutStrategy", "strategy", "build", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Builder {
    public static final int $stable = 8;
    private final List<IMigrateHandler> handlers = new ArrayList();
    private final List<OfflineVideoEntity> cachedVideos = new ArrayList();
    private final List<DramaGroupModel> dramaGroups = new ArrayList();
    private int retryTimes = 3;
    private Function1<? super Integer, Duration> timeoutStrategy = new Function1() { // from class: video.biz.offline.base.infra.migrate.Builder$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            Duration timeoutStrategy$lambda$0;
            timeoutStrategy$lambda$0 = Builder.timeoutStrategy$lambda$0(((Integer) obj).intValue());
            return timeoutStrategy$lambda$0;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static final Duration timeoutStrategy$lambda$0(int it) {
        return Duration.box-impl(Duration.Companion.getINFINITE-UwyO8pc());
    }

    private final Builder addHandler(IMigrateHandler handler) {
        this.handlers.add(handler);
        return this;
    }

    public final Builder addDefaultHandlers() {
        addHandler(new MigrationMonitorHandler());
        addHandler(new MigrationTimeoutHandler());
        addHandler(new MigrationRetryHandler());
        addHandler(new MigrationPreCheckHandler());
        addHandler(new MigrationDramaHandler());
        addHandler(new MigrationVideoHandler());
        addHandler(new MigrationValidateHandler());
        return this;
    }

    public final Builder addCachedVideos(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "videos");
        this.cachedVideos.addAll(list);
        return this;
    }

    public final Builder addDramaMap(List<DramaGroupModel> list) {
        Intrinsics.checkNotNullParameter(list, "groups");
        this.dramaGroups.addAll(list);
        return this;
    }

    public final Builder setRetryTimes(int times) {
        this.retryTimes = times;
        return this;
    }

    public final Builder setTimeoutStrategy(Function1<? super Integer, Duration> function1) {
        Intrinsics.checkNotNullParameter(function1, "strategy");
        this.timeoutStrategy = function1;
        return this;
    }

    public final MigrationChain build() {
        return new RealMigrationChain(new MigrationContext(this.cachedVideos, this.dramaGroups, null, new MigrationContext.Config(this.retryTimes, this.timeoutStrategy), 4, null), this.handlers, 0, 4, null);
    }
}