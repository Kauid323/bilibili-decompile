package video.biz.offline.base.infra.utils;

import java.util.Map;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kntr.base.config.SerializableSharedPreferences;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import tv.danmaku.bili.update.internal.report.ConstsKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;
import video.biz.offline.base.infra.utils.Config;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b7\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lvideo/biz/offline/base/infra/utils/Config;", "", "<init>", "()V", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class Config {
    public static final int $stable = 0;
    private static final Lazy<Map<String, Integer>> deleteInvalidFileMap$delegate;
    private static final Lazy<Boolean> deprecateFileStorage$delegate;
    private static final Lazy<Integer> downloadScopeParallelismLimit$delegate;
    private static final SerializableSharedPreferencesProperty<Boolean> enableDownloadWithWWAN$delegate;
    private static final Lazy<Map<String, Integer>> forceMigrateMap$delegate;
    private static final Lazy<Boolean> hitFreeBandWidthFix865$delegate;
    private static final Lazy<Boolean> hitNew$delegate;
    private static final Lazy<Boolean> hitTaskTrustFinishOnly$delegate;
    private static final Lazy<Integer> storageScopeParallelismLimit$delegate;
    private static final SerializableSharedPreferencesProperty<OfflineUserInfo> userInfo$delegate;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<SerializableSharedPreferences> sp$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda0
        public final Object invoke() {
            SerializableSharedPreferences sp_delegate$lambda$0;
            sp_delegate$lambda$0 = Config.sp_delegate$lambda$0();
            return sp_delegate$lambda$0;
        }
    });

    public /* synthetic */ Config(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: Config.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R$\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u000e\"\u0004\b\u001f\u0010\u0010R+\u0010!\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00148F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\u001b\u0010&\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b'\u0010\u0017R\u001b\u0010)\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\t\u001a\u0004\b*\u0010\u0017R\u001b\u0010,\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b-\u0010\u000eR\u001b\u0010/\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b0\u0010\u000eR\u001b\u00102\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b3\u0010\u0017R\u001b\u00105\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\t\u001a\u0004\b6\u0010\u0017R'\u00108\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000b098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b;\u0010<R/\u0010?\u001a\u0004\u0018\u00010>2\b\u0010 \u001a\u0004\u0018\u00010>8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bD\u0010%\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR'\u0010E\u001a\u000e\u0012\u0004\u0012\u00020:\u0012\u0004\u0012\u00020\u000b098FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\t\u001a\u0004\bF\u0010<R$\u0010H\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010\u000e\"\u0004\bJ\u0010\u0010R$\u0010L\u001a\u00020K2\u0006\u0010\n\u001a\u00020K8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lvideo/biz/offline/base/infra/utils/Config$Companion;", "", "<init>", "()V", "sp", "Lkntr/base/config/SerializableSharedPreferences;", "getSp", "()Lkntr/base/config/SerializableSharedPreferences;", "sp$delegate", "Lkotlin/Lazy;", "value", "", "dbMigrateTimes", "getDbMigrateTimes", "()I", "setDbMigrateTimes", "(I)V", "dbMigrateSuccessTimes", "getDbMigrateSuccessTimes", "setDbMigrateSuccessTimes", "", "autoResumption", "getAutoResumption", "()Z", "setAutoResumption", "(Z)V", "maxConcurrent", "getMaxConcurrent", "setMaxConcurrent", "forceMigrateVersion", "getForceMigrateVersion", "setForceMigrateVersion", "<set-?>", "enableDownloadWithWWAN", "getEnableDownloadWithWWAN", "setEnableDownloadWithWWAN", "enableDownloadWithWWAN$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "hitNew", "getHitNew", "hitNew$delegate", "deprecateFileStorage", "getDeprecateFileStorage", "deprecateFileStorage$delegate", "downloadScopeParallelismLimit", "getDownloadScopeParallelismLimit", "downloadScopeParallelismLimit$delegate", "storageScopeParallelismLimit", "getStorageScopeParallelismLimit", "storageScopeParallelismLimit$delegate", "hitFreeBandWidthFix865", "getHitFreeBandWidthFix865", "hitFreeBandWidthFix865$delegate", "hitTaskTrustFinishOnly", "getHitTaskTrustFinishOnly", "hitTaskTrustFinishOnly$delegate", "forceMigrateMap", "", "", "getForceMigrateMap", "()Ljava/util/Map;", "forceMigrateMap$delegate", "Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;", "userInfo", "getUserInfo", "()Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;", "setUserInfo", "(Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;)V", "userInfo$delegate", "deleteInvalidFileMap", "getDeleteInvalidFileMap", "deleteInvalidFileMap$delegate", "deleteInvalidVersion", "getDeleteInvalidVersion", "setDeleteInvalidVersion", "", "lastDeleteInvalidTime", "getLastDeleteInvalidTime", "()J", "setLastDeleteInvalidTime", "(J)V", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "enableDownloadWithWWAN", "getEnableDownloadWithWWAN()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(Companion.class, "userInfo", "getUserInfo()Lvideo/biz/offline/base/infra/utils/OfflineUserInfo;", 0))};

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final SerializableSharedPreferences getSp() {
            return (SerializableSharedPreferences) Config.sp$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int _get_dbMigrateTimes_$lambda$0() {
            return 0;
        }

        public final int getDbMigrateTimes() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_MIGRATE_TIMES_KEY, IntSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda1
                public final Object invoke() {
                    int _get_dbMigrateTimes_$lambda$0;
                    _get_dbMigrateTimes_$lambda$0 = Config.Companion._get_dbMigrateTimes_$lambda$0();
                    return Integer.valueOf(_get_dbMigrateTimes_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).intValue();
        }

        public final void setDbMigrateTimes(int value) {
            getSp().setValue(ConfigKt.C_MIGRATE_TIMES_KEY, Integer.valueOf(value), IntSerializer.INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int _get_dbMigrateSuccessTimes_$lambda$0() {
            return 0;
        }

        public final int getDbMigrateSuccessTimes() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_MIGRATE_SUCCESS_TIMES_KEY, IntSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda4
                public final Object invoke() {
                    int _get_dbMigrateSuccessTimes_$lambda$0;
                    _get_dbMigrateSuccessTimes_$lambda$0 = Config.Companion._get_dbMigrateSuccessTimes_$lambda$0();
                    return Integer.valueOf(_get_dbMigrateSuccessTimes_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).intValue();
        }

        public final void setDbMigrateSuccessTimes(int value) {
            getSp().setValue(ConfigKt.C_MIGRATE_SUCCESS_TIMES_KEY, Integer.valueOf(value), IntSerializer.INSTANCE);
        }

        public final boolean getAutoResumption() {
            return ConfigImpl_androidKt.getAutoDownloadConfig();
        }

        public final void setAutoResumption(boolean value) {
            ConfigImpl_androidKt.setAutoDownloadConfig(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int _get_maxConcurrent_$lambda$0() {
            return 1;
        }

        public final int getMaxConcurrent() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_MAX_CONCURRENT_KEY, IntSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda5
                public final Object invoke() {
                    int _get_maxConcurrent_$lambda$0;
                    _get_maxConcurrent_$lambda$0 = Config.Companion._get_maxConcurrent_$lambda$0();
                    return Integer.valueOf(_get_maxConcurrent_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).intValue();
        }

        public final void setMaxConcurrent(int value) {
            getSp().setValue(ConfigKt.C_MAX_CONCURRENT_KEY, Integer.valueOf(value), IntSerializer.INSTANCE);
        }

        public final int getForceMigrateVersion() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_SP_OFFLINE_FORCE_MIGRATE_VERSION, IntSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda0
                public final Object invoke() {
                    int _get_forceMigrateVersion_$lambda$0;
                    _get_forceMigrateVersion_$lambda$0 = Config.Companion._get_forceMigrateVersion_$lambda$0();
                    return Integer.valueOf(_get_forceMigrateVersion_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int _get_forceMigrateVersion_$lambda$0() {
            return 0;
        }

        public final void setForceMigrateVersion(int value) {
            getSp().setValue(ConfigKt.C_SP_OFFLINE_FORCE_MIGRATE_VERSION, Integer.valueOf(value), IntSerializer.INSTANCE);
        }

        public final boolean getEnableDownloadWithWWAN() {
            return ((Boolean) Config.enableDownloadWithWWAN$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
        }

        public final void setEnableDownloadWithWWAN(boolean z) {
            Config.enableDownloadWithWWAN$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
        }

        public final boolean getHitNew() {
            return ((Boolean) Config.hitNew$delegate.getValue()).booleanValue();
        }

        public final boolean getDeprecateFileStorage() {
            return ((Boolean) Config.deprecateFileStorage$delegate.getValue()).booleanValue();
        }

        public final int getDownloadScopeParallelismLimit() {
            return ((Number) Config.downloadScopeParallelismLimit$delegate.getValue()).intValue();
        }

        public final int getStorageScopeParallelismLimit() {
            return ((Number) Config.storageScopeParallelismLimit$delegate.getValue()).intValue();
        }

        public final boolean getHitFreeBandWidthFix865() {
            return ((Boolean) Config.hitFreeBandWidthFix865$delegate.getValue()).booleanValue();
        }

        public final boolean getHitTaskTrustFinishOnly() {
            return ((Boolean) Config.hitTaskTrustFinishOnly$delegate.getValue()).booleanValue();
        }

        public final Map<String, Integer> getForceMigrateMap() {
            return (Map) Config.forceMigrateMap$delegate.getValue();
        }

        public final OfflineUserInfo getUserInfo() {
            return (OfflineUserInfo) Config.userInfo$delegate.getValue(this, $$delegatedProperties[1]);
        }

        public final void setUserInfo(OfflineUserInfo offlineUserInfo) {
            Config.userInfo$delegate.setValue(this, $$delegatedProperties[1], offlineUserInfo);
        }

        public final Map<String, Integer> getDeleteInvalidFileMap() {
            return (Map) Config.deleteInvalidFileMap$delegate.getValue();
        }

        public final int getDeleteInvalidVersion() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_SP_DELETE_INVALID_FILE_VERSION, IntSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda2
                public final Object invoke() {
                    int _get_deleteInvalidVersion_$lambda$0;
                    _get_deleteInvalidVersion_$lambda$0 = Config.Companion._get_deleteInvalidVersion_$lambda$0();
                    return Integer.valueOf(_get_deleteInvalidVersion_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).intValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int _get_deleteInvalidVersion_$lambda$0() {
            return 0;
        }

        public final void setDeleteInvalidVersion(int value) {
            getSp().setValue(ConfigKt.C_SP_DELETE_INVALID_FILE_VERSION, Integer.valueOf(value), IntSerializer.INSTANCE);
        }

        public final long getLastDeleteInvalidTime() {
            return ((Number) SerializableSharedPreferences.getValue$default(getSp(), ConfigKt.C_LAST_DELETE_INVALID_FILE_TIME, LongSerializer.INSTANCE, new Function0() { // from class: video.biz.offline.base.infra.utils.Config$Companion$$ExternalSyntheticLambda3
                public final Object invoke() {
                    long _get_lastDeleteInvalidTime_$lambda$0;
                    _get_lastDeleteInvalidTime_$lambda$0 = Config.Companion._get_lastDeleteInvalidTime_$lambda$0();
                    return Long.valueOf(_get_lastDeleteInvalidTime_$lambda$0);
                }
            }, (Function2) null, 8, (Object) null)).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final long _get_lastDeleteInvalidTime_$lambda$0() {
            return 0L;
        }

        public final void setLastDeleteInvalidTime(long value) {
            getSp().setValue(ConfigKt.C_LAST_DELETE_INVALID_FILE_TIME, Long.valueOf(value), LongSerializer.INSTANCE);
        }
    }

    private Config() {
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean enableDownloadWithWWAN_delegate$lambda$0;
                enableDownloadWithWWAN_delegate$lambda$0 = Config.enableDownloadWithWWAN_delegate$lambda$0();
                return Boolean.valueOf(enableDownloadWithWWAN_delegate$lambda$0);
            }
        };
        enableDownloadWithWWAN$delegate = new SerializableSharedPreferencesProperty<>(ConfigKt.C_SP_NAME_KEY, true, BooleanSerializer.INSTANCE, ConfigKt.C_SP_ENABLE_WWAN_DOWNLOAD, initializer$iv, (Function2) null);
        hitNew$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda4
            public final Object invoke() {
                boolean hitNew_delegate$lambda$0;
                hitNew_delegate$lambda$0 = Config.hitNew_delegate$lambda$0();
                return Boolean.valueOf(hitNew_delegate$lambda$0);
            }
        });
        deprecateFileStorage$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda5
            public final Object invoke() {
                boolean deprecateFileStorage_delegate$lambda$0;
                deprecateFileStorage_delegate$lambda$0 = Config.deprecateFileStorage_delegate$lambda$0();
                return Boolean.valueOf(deprecateFileStorage_delegate$lambda$0);
            }
        });
        downloadScopeParallelismLimit$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda6
            public final Object invoke() {
                int downloadScopeParallelismLimit_delegate$lambda$0;
                downloadScopeParallelismLimit_delegate$lambda$0 = Config.downloadScopeParallelismLimit_delegate$lambda$0();
                return Integer.valueOf(downloadScopeParallelismLimit_delegate$lambda$0);
            }
        });
        storageScopeParallelismLimit$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda7
            public final Object invoke() {
                int storageScopeParallelismLimit_delegate$lambda$0;
                storageScopeParallelismLimit_delegate$lambda$0 = Config.storageScopeParallelismLimit_delegate$lambda$0();
                return Integer.valueOf(storageScopeParallelismLimit_delegate$lambda$0);
            }
        });
        hitFreeBandWidthFix865$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda8
            public final Object invoke() {
                boolean hitFreeBandWidthFix865_delegate$lambda$0;
                hitFreeBandWidthFix865_delegate$lambda$0 = Config.hitFreeBandWidthFix865_delegate$lambda$0();
                return Boolean.valueOf(hitFreeBandWidthFix865_delegate$lambda$0);
            }
        });
        hitTaskTrustFinishOnly$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda9
            public final Object invoke() {
                boolean hitTaskTrustFinishOnly_delegate$lambda$0;
                hitTaskTrustFinishOnly_delegate$lambda$0 = Config.hitTaskTrustFinishOnly_delegate$lambda$0();
                return Boolean.valueOf(hitTaskTrustFinishOnly_delegate$lambda$0);
            }
        });
        forceMigrateMap$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda10
            public final Object invoke() {
                Map forceMigrateMap_delegate$lambda$0;
                forceMigrateMap_delegate$lambda$0 = Config.forceMigrateMap_delegate$lambda$0();
                return forceMigrateMap_delegate$lambda$0;
            }
        });
        Function0 initializer$iv2 = new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda1
            public final Object invoke() {
                OfflineUserInfo userInfo_delegate$lambda$0;
                userInfo_delegate$lambda$0 = Config.userInfo_delegate$lambda$0();
                return userInfo_delegate$lambda$0;
            }
        };
        userInfo$delegate = new SerializableSharedPreferencesProperty<>(ConfigKt.C_SP_NAME_KEY, true, BuiltinSerializersKt.getNullable(OfflineUserInfo.Companion.serializer()), ConfigKt.C_OFFLINE_USER_INFO, initializer$iv2, (Function2) null);
        deleteInvalidFileMap$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.base.infra.utils.Config$$ExternalSyntheticLambda2
            public final Object invoke() {
                Map deleteInvalidFileMap_delegate$lambda$0;
                deleteInvalidFileMap_delegate$lambda$0 = Config.deleteInvalidFileMap_delegate$lambda$0();
                return deleteInvalidFileMap_delegate$lambda$0;
            }
        });
        Companion.setEnableDownloadWithWWAN(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerializableSharedPreferences sp_delegate$lambda$0() {
        return new SerializableSharedPreferences(ConfigKt.C_SP_NAME_KEY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableDownloadWithWWAN_delegate$lambda$0() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitNew_delegate$lambda$0() {
        boolean it = IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, ConfigKt.FF_HIT_NEW_OFFLINE_KEY, false, 2, (Object) null);
        LogKt.getVBLog().info("Config: hitNew=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deprecateFileStorage_delegate$lambda$0() {
        boolean it = KConfig.INSTANCE.ff(ConfigKt.FF_HIT_DEPRECATED_FILE_STORAGE, false);
        LogKt.getVBLog().info("Config: deprecateFileStorage=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int downloadScopeParallelismLimit_delegate$lambda$0() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config(ConfigKt.FF_DOWNLOAD_SCOPE_PARALLELISM_LIMIT, ConstsKt.ARG_INCREMENT_DOWNLOAD_FAILURE);
        int intValue = (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) ? 5 : intOrNull.intValue();
        int it = intValue;
        LogKt.getVBLog().info("Config: downloadScopeParallelismLimit=" + it);
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int storageScopeParallelismLimit_delegate$lambda$0() {
        Integer intOrNull;
        String config = KConfig.INSTANCE.config(ConfigKt.FF_STORAGE_SCOPE_PARALLELISM_LIMIT, "2");
        int intValue = (config == null || (intOrNull = StringsKt.toIntOrNull(config)) == null) ? 2 : intOrNull.intValue();
        int it = intValue;
        LogKt.getVBLog().info("Config: storageScopeParallelismLimit=" + it);
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitFreeBandWidthFix865_delegate$lambda$0() {
        boolean it = KConfig.INSTANCE.ff("ff_offline_free_bandwidth_865", true);
        LogKt.getVBLog().info("ff_offline_free_bandwidth_865=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hitTaskTrustFinishOnly_delegate$lambda$0() {
        boolean it = KConfig.INSTANCE.ff("ff_offline_trust_finish_868", true);
        LogKt.getVBLog().info("ff_offline_trust_finish_868=" + it);
        return it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map forceMigrateMap_delegate$lambda$0() {
        String jsonStr = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, ConfigKt.FF_OFFLINE_FORCE_MIGRATE_MAP, (String) null, 2, (Object) null);
        String str = jsonStr;
        if (str == null || str.length() == 0) {
            LogKt.getVBLog().info("forceMigrate json string is empty, return empty map");
            return MapsKt.emptyMap();
        }
        LogKt.getVBLog().info("forceMigrate json string: " + jsonStr);
        try {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            return (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE), jsonStr);
        } catch (Exception e) {
            LogKt.getVBLog().error("forceMigrate parse error: " + e);
            return MapsKt.emptyMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfflineUserInfo userInfo_delegate$lambda$0() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map deleteInvalidFileMap_delegate$lambda$0() {
        String jsonStr = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, ConfigKt.FF_DELETE_INVALID_FILE_MAP, (String) null, 2, (Object) null);
        String str = jsonStr;
        if (str == null || str.length() == 0) {
            LogKt.getVBLog().info("deleteInvalid json string is empty, return empty map");
            return MapsKt.emptyMap();
        }
        LogKt.getVBLog().info("deleteInvalid json string: " + jsonStr);
        try {
            Json this_$iv = Json.Default;
            this_$iv.getSerializersModule();
            return (Map) this_$iv.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE), jsonStr);
        } catch (Exception e) {
            LogKt.getVBLog().error("deleteInvalid parse error: " + e);
            return MapsKt.emptyMap();
        }
    }
}