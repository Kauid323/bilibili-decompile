package video.biz.offline.base.model.error;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MigrateException.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lvideo/biz/offline/base/model/error/MigrationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationException extends Exception {
    public static final int $stable = 8;
    private final int code;
    private final String message;

    public static /* synthetic */ MigrationException copy$default(MigrationException migrationException, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = migrationException.code;
        }
        if ((i2 & 2) != 0) {
            str = migrationException.message;
        }
        return migrationException.copy(i, str);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.message;
    }

    public final MigrationException copy(int i, String str) {
        return new MigrationException(i, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MigrationException) {
            MigrationException migrationException = (MigrationException) obj;
            return this.code == migrationException.code && Intrinsics.areEqual(this.message, migrationException.message);
        }
        return false;
    }

    public int hashCode() {
        return (this.code * 31) + (this.message == null ? 0 : this.message.hashCode());
    }

    @Override // java.lang.Throwable
    public String toString() {
        int i = this.code;
        return "MigrationException(code=" + i + ", message=" + this.message + ")";
    }

    public MigrationException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public /* synthetic */ MigrationException(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : str);
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}