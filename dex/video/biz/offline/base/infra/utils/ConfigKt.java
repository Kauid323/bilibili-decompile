package video.biz.offline.base.infra.utils;

import java.util.Map;
import kntr.base.device.KDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.log.LogKt;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a,\u0010\u0017\u001a\u00020\u00182\u001c\u0010\u0019\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001aH\u0087@¢\u0006\u0002\u0010\u001d\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"C_SP_NAME_KEY", "", "C_MIGRATE_TIMES_KEY", "C_MIGRATE_SUCCESS_TIMES_KEY", "C_AUTO_RESUMPTION_KEY", "C_MAX_CONCURRENT_KEY", "C_OFFLINE_USER_INFO", "C_SP_ENABLE_WWAN_DOWNLOAD", "C_SP_OFFLINE_FORCE_MIGRATE_VERSION", "C_SP_DELETE_INVALID_FILE_VERSION", "C_MIGRATE_RETRY_MAX_TIMES", "", "C_MIGRATE_COMPLETE_FLAG", "C_LAST_DELETE_INVALID_FILE_TIME", "FF_HIT_NEW_OFFLINE_KEY", "FF_HIT_DEPRECATED_FILE_STORAGE", "FF_DELETE_DB_IF_ERROR", "FF_OFFLINE_FORCE_MIGRATE_MAP", "FF_DOWNLOAD_SCOPE_PARALLELISM_LIMIT", "FF_STORAGE_SCOPE_PARALLELISM_LIMIT", "FF_DELETE_INVALID_FILE_DELAY", "FF_DELETE_INVALID_FILE_INTERVAL", "FF_DELETE_INVALID_FILE_MAP", "checkForceMigrate", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ConfigKt {
    public static final String C_AUTO_RESUMPTION_KEY = "c_auto_resumption_download";
    public static final String C_LAST_DELETE_INVALID_FILE_TIME = "c_last_delete_invalid_file_time";
    public static final String C_MAX_CONCURRENT_KEY = "c_max_concurrent";
    public static final int C_MIGRATE_COMPLETE_FLAG = 3;
    public static final int C_MIGRATE_RETRY_MAX_TIMES = 3;
    public static final String C_MIGRATE_SUCCESS_TIMES_KEY = "c_db_migrate_success_times";
    public static final String C_MIGRATE_TIMES_KEY = "c_db_migrate_times";
    public static final String C_OFFLINE_USER_INFO = "c_offline_user_info";
    public static final String C_SP_DELETE_INVALID_FILE_VERSION = "c_delete_invalid_file_version";
    public static final String C_SP_ENABLE_WWAN_DOWNLOAD = "c_enable_wwan_download";
    public static final String C_SP_NAME_KEY = "c_video_offline";
    public static final String C_SP_OFFLINE_FORCE_MIGRATE_VERSION = "c_offline_force_migrate_version";
    public static final String FF_DELETE_DB_IF_ERROR = "ff_delete_db_if_error";
    public static final String FF_DELETE_INVALID_FILE_DELAY = "ff_delete_invalid_file_delay";
    public static final String FF_DELETE_INVALID_FILE_INTERVAL = "ff_delete_invalid_file_interval";
    public static final String FF_DELETE_INVALID_FILE_MAP = "ff_delete_invalid_file_map";
    public static final String FF_DOWNLOAD_SCOPE_PARALLELISM_LIMIT = "ff_download_scope_parallelism_limit";
    public static final String FF_HIT_DEPRECATED_FILE_STORAGE = "ff_deprecate_file_storage";
    public static final String FF_HIT_NEW_OFFLINE_KEY = "ff_hit_new_offline";
    public static final String FF_OFFLINE_FORCE_MIGRATE_MAP = "ff_offline_force_migrate_map";
    public static final String FF_STORAGE_SCOPE_PARALLELISM_LIMIT = "ff_storage_scope_parallelism_limit";

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object checkForceMigrate(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        ConfigKt$checkForceMigrate$1 configKt$checkForceMigrate$1;
        int targetVersion;
        if (continuation instanceof ConfigKt$checkForceMigrate$1) {
            configKt$checkForceMigrate$1 = (ConfigKt$checkForceMigrate$1) continuation;
            if ((configKt$checkForceMigrate$1.label & Integer.MIN_VALUE) != 0) {
                configKt$checkForceMigrate$1.label -= Integer.MIN_VALUE;
                Object $result = configKt$checkForceMigrate$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (configKt$checkForceMigrate$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Map map = Config.Companion.getForceMigrateMap();
                        if (map.isEmpty()) {
                            return Unit.INSTANCE;
                        }
                        String buvid = KDevice.INSTANCE.getBuvid();
                        LogKt.getVBLog().info("checkForceMigrate: buvid=" + buvid + ", local version=" + Config.Companion.getForceMigrateVersion() + ", map=" + map);
                        Integer num = map.get(buvid);
                        if (num == null) {
                            return Unit.INSTANCE;
                        }
                        int targetVersion2 = num.intValue();
                        if (targetVersion2 > Config.Companion.getForceMigrateVersion()) {
                            configKt$checkForceMigrate$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            configKt$checkForceMigrate$1.L$1 = SpillingKt.nullOutSpilledVariable(map);
                            configKt$checkForceMigrate$1.L$2 = SpillingKt.nullOutSpilledVariable(buvid);
                            configKt$checkForceMigrate$1.I$0 = targetVersion2;
                            configKt$checkForceMigrate$1.label = 1;
                            if (function1.invoke(configKt$checkForceMigrate$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            targetVersion = targetVersion2;
                            Config.Companion.setForceMigrateVersion(targetVersion);
                            new DataLog().info("checkForceMigrate hit force migrate, version: " + Config.Companion.getForceMigrateVersion());
                            break;
                        }
                        break;
                    case 1:
                        targetVersion = configKt$checkForceMigrate$1.I$0;
                        String str = (String) configKt$checkForceMigrate$1.L$2;
                        Map map2 = (Map) configKt$checkForceMigrate$1.L$1;
                        Function1 function12 = (Function1) configKt$checkForceMigrate$1.L$0;
                        ResultKt.throwOnFailure($result);
                        Config.Companion.setForceMigrateVersion(targetVersion);
                        new DataLog().info("checkForceMigrate hit force migrate, version: " + Config.Companion.getForceMigrateVersion());
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        configKt$checkForceMigrate$1 = new ConfigKt$checkForceMigrate$1(continuation);
        Object $result2 = configKt$checkForceMigrate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (configKt$checkForceMigrate$1.label) {
        }
        return Unit.INSTANCE;
    }
}