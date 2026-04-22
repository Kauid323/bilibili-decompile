package video.biz.offline.base.model.error;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MigrateException.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00192\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\bR\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u001a"}, d2 = {"Lvideo/biz/offline/base/model/error/DataErrorType;", "Lvideo/biz/offline/base/model/error/OfflineErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "STORAGE_PATH_ERROR", "LOAD_TASK_FILE_ERROR", "LOAD_TASK_DRAMA_ERROR", "MIGRATION_TIMEOUT", "MIGRATION_OVER_TIMES", "MIGRATION_DB_READ_ERROR", "MIGRATION_DB_WRITE_ERROR", "MIGRATION_END_NOT_SAME", "TASK_FILE_INVALID", "errorCode", "getErrorCode", "trackMsg", "", "getTrackMsg", "()Ljava/lang/String;", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum DataErrorType implements OfflineErrorCode {
    UNKNOWN(4000),
    STORAGE_PATH_ERROR(4001),
    LOAD_TASK_FILE_ERROR(4002),
    LOAD_TASK_DRAMA_ERROR(4003),
    MIGRATION_TIMEOUT(4004),
    MIGRATION_OVER_TIMES(4005),
    MIGRATION_DB_READ_ERROR(4006),
    MIGRATION_DB_WRITE_ERROR(4007),
    MIGRATION_END_NOT_SAME(4008),
    TASK_FILE_INVALID(4009);
    
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    /* compiled from: MigrateException.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataErrorType.values().length];
            try {
                iArr[DataErrorType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DataErrorType.STORAGE_PATH_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DataErrorType.LOAD_TASK_FILE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DataErrorType.LOAD_TASK_DRAMA_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DataErrorType.MIGRATION_TIMEOUT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DataErrorType.MIGRATION_OVER_TIMES.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DataErrorType.MIGRATION_DB_READ_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DataErrorType.MIGRATION_DB_WRITE_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DataErrorType.MIGRATION_END_NOT_SAME.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[DataErrorType.TASK_FILE_INVALID.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<DataErrorType> getEntries() {
        return $ENTRIES;
    }

    DataErrorType(int code) {
        this.code = code;
    }

    @Override // video.biz.offline.base.model.error.OfflineErrorCode
    public int getCode() {
        return this.code;
    }

    /* compiled from: MigrateException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/error/DataErrorType$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/base/model/error/DataErrorType;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DataErrorType from(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = DataErrorType.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    DataErrorType it2 = (DataErrorType) element$iv;
                    if (it2.getCode() == value) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            DataErrorType dataErrorType = (DataErrorType) element$iv;
            return dataErrorType == null ? DataErrorType.UNKNOWN : dataErrorType;
        }
    }

    public final int getErrorCode() {
        return OfflineError.INSTANCE.generateErrorCode(OfflineErrorType.DATA_ERROR, this);
    }

    public final String getTrackMsg() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "未知错误类型";
            case 2:
                return "存储路径错误";
            case 3:
                return "加载task文件失败";
            case 4:
                return "加载drama文件失败";
            case 5:
                return "迁移超时";
            case 6:
                return "迁移超过最大重试次数";
            case 7:
                return "数据库读取失败";
            case 8:
                return "数据库写入失败";
            case 9:
                return "迁移后数据不一致";
            case 10:
                return "task文件无效";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}