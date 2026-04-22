package video.biz.offline.base.infra.migrate;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.migrate.MigrationContext;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.model.db.AppDatabase;
import video.biz.offline.base.model.db.OfflineDatabaseKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: IMigrateHandler.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001(B7\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J=\u0010 \u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationContext;", "", "cachedVideos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "dramaGroups", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "db", "Lvideo/biz/offline/base/model/db/AppDatabase;", "config", "Lvideo/biz/offline/base/infra/migrate/MigrationContext$Config;", "<init>", "(Ljava/util/List;Ljava/util/List;Lvideo/biz/offline/base/model/db/AppDatabase;Lvideo/biz/offline/base/infra/migrate/MigrationContext$Config;)V", "getCachedVideos", "()Ljava/util/List;", "getDramaGroups", "getDb", "()Lvideo/biz/offline/base/model/db/AppDatabase;", "getConfig", "()Lvideo/biz/offline/base/infra/migrate/MigrationContext$Config;", "setConfig", "(Lvideo/biz/offline/base/infra/migrate/MigrationContext$Config;)V", "currentStep", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getCurrentStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "setCurrentStep", "(Lvideo/biz/offline/base/infra/migrate/MigrationStep;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Config", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationContext {
    public static final int $stable = 8;
    private final List<OfflineVideoEntity> cachedVideos;
    private Config config;
    private MigrationStep currentStep;
    private final AppDatabase db;
    private final List<DramaGroupModel> dramaGroups;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MigrationContext copy$default(MigrationContext migrationContext, List list, List list2, AppDatabase appDatabase, Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            list = migrationContext.cachedVideos;
        }
        if ((i & 2) != 0) {
            list2 = migrationContext.dramaGroups;
        }
        if ((i & 4) != 0) {
            appDatabase = migrationContext.db;
        }
        if ((i & 8) != 0) {
            config = migrationContext.config;
        }
        return migrationContext.copy(list, list2, appDatabase, config);
    }

    public final List<OfflineVideoEntity> component1() {
        return this.cachedVideos;
    }

    public final List<DramaGroupModel> component2() {
        return this.dramaGroups;
    }

    public final AppDatabase component3() {
        return this.db;
    }

    public final Config component4() {
        return this.config;
    }

    public final MigrationContext copy(List<OfflineVideoEntity> list, List<DramaGroupModel> list2, AppDatabase appDatabase, Config config) {
        Intrinsics.checkNotNullParameter(list, "cachedVideos");
        Intrinsics.checkNotNullParameter(list2, "dramaGroups");
        Intrinsics.checkNotNullParameter(appDatabase, "db");
        Intrinsics.checkNotNullParameter(config, "config");
        return new MigrationContext(list, list2, appDatabase, config);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MigrationContext) {
            MigrationContext migrationContext = (MigrationContext) obj;
            return Intrinsics.areEqual(this.cachedVideos, migrationContext.cachedVideos) && Intrinsics.areEqual(this.dramaGroups, migrationContext.dramaGroups) && Intrinsics.areEqual(this.db, migrationContext.db) && Intrinsics.areEqual(this.config, migrationContext.config);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.cachedVideos.hashCode() * 31) + this.dramaGroups.hashCode()) * 31) + this.db.hashCode()) * 31) + this.config.hashCode();
    }

    public String toString() {
        List<OfflineVideoEntity> list = this.cachedVideos;
        List<DramaGroupModel> list2 = this.dramaGroups;
        AppDatabase appDatabase = this.db;
        return "MigrationContext(cachedVideos=" + list + ", dramaGroups=" + list2 + ", db=" + appDatabase + ", config=" + this.config + ")";
    }

    public MigrationContext(List<OfflineVideoEntity> list, List<DramaGroupModel> list2, AppDatabase db, Config config) {
        Intrinsics.checkNotNullParameter(list, "cachedVideos");
        Intrinsics.checkNotNullParameter(list2, "dramaGroups");
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(config, "config");
        this.cachedVideos = list;
        this.dramaGroups = list2;
        this.db = db;
        this.config = config;
        this.currentStep = MigrationStep.IDLE;
    }

    public /* synthetic */ MigrationContext(List list, List list2, AppDatabase appDatabase, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, (i & 4) != 0 ? OfflineDatabaseKt.getOfflineDB() : appDatabase, (i & 8) != 0 ? new Config(0, null, 3, null) : config);
    }

    public final List<OfflineVideoEntity> getCachedVideos() {
        return this.cachedVideos;
    }

    public final List<DramaGroupModel> getDramaGroups() {
        return this.dramaGroups;
    }

    public final AppDatabase getDb() {
        return this.db;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final void setConfig(Config config) {
        Intrinsics.checkNotNullParameter(config, "<set-?>");
        this.config = config;
    }

    public final MigrationStep getCurrentStep() {
        return this.currentStep;
    }

    public final void setCurrentStep(MigrationStep migrationStep) {
        Intrinsics.checkNotNullParameter(migrationStep, "<set-?>");
        this.currentStep = migrationStep;
    }

    /* compiled from: IMigrateHandler.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationContext$Config;", "", "maxAttempts", "", "strategy", "Lkotlin/Function1;", "Lkotlin/time/Duration;", "Lvideo/biz/offline/base/infra/migrate/TimeoutStrategy;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "getMaxAttempts", "()I", "getStrategy", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Config {
        public static final int $stable = 0;
        private final int maxAttempts;
        private final Function1<Integer, Duration> strategy;

        public Config() {
            this(0, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Config copy$default(Config config, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = config.maxAttempts;
            }
            if ((i2 & 2) != 0) {
                function1 = config.strategy;
            }
            return config.copy(i, function1);
        }

        public final int component1() {
            return this.maxAttempts;
        }

        public final Function1<Integer, Duration> component2() {
            return this.strategy;
        }

        public final Config copy(int i, Function1<? super Integer, Duration> function1) {
            Intrinsics.checkNotNullParameter(function1, "strategy");
            return new Config(i, function1);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Config) {
                Config config = (Config) obj;
                return this.maxAttempts == config.maxAttempts && Intrinsics.areEqual(this.strategy, config.strategy);
            }
            return false;
        }

        public int hashCode() {
            return (this.maxAttempts * 31) + this.strategy.hashCode();
        }

        public String toString() {
            int i = this.maxAttempts;
            return "Config(maxAttempts=" + i + ", strategy=" + this.strategy + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Config(int maxAttempts, Function1<? super Integer, Duration> function1) {
            Intrinsics.checkNotNullParameter(function1, "strategy");
            this.maxAttempts = maxAttempts;
            this.strategy = function1;
        }

        public /* synthetic */ Config(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new Function1() { // from class: video.biz.offline.base.infra.migrate.MigrationContext$Config$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Duration _init_$lambda$0;
                    _init_$lambda$0 = MigrationContext.Config._init_$lambda$0(((Integer) obj).intValue());
                    return _init_$lambda$0;
                }
            } : function1);
        }

        public final int getMaxAttempts() {
            return this.maxAttempts;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Duration _init_$lambda$0(int it) {
            return Duration.box-impl(Duration.Companion.getINFINITE-UwyO8pc());
        }

        public final Function1<Integer, Duration> getStrategy() {
            return this.strategy;
        }
    }
}