package kntr.base.dd.impl.internal.update;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateException.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0006\u000b\f\r\u000e\u000f\u0010B\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "", "<init>", "(ILjava/lang/String;)V", "getCode", "()I", "ParamsInvalid", "AlreadyUpdating", "NoNeedToUpdate", "DownloadFile", "ReadFile", "Serialize", "Lkntr/base/dd/impl/internal/update/UpdateException$AlreadyUpdating;", "Lkntr/base/dd/impl/internal/update/UpdateException$DownloadFile;", "Lkntr/base/dd/impl/internal/update/UpdateException$NoNeedToUpdate;", "Lkntr/base/dd/impl/internal/update/UpdateException$ParamsInvalid;", "Lkntr/base/dd/impl/internal/update/UpdateException$ReadFile;", "Lkntr/base/dd/impl/internal/update/UpdateException$Serialize;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class UpdateException extends Exception {
    private final int code;

    public /* synthetic */ UpdateException(int i, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str);
    }

    private UpdateException(int code, String message) {
        super(message);
        this.code = code;
    }

    public final int getCode() {
        return this.code;
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$ParamsInvalid;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "params", "", "<init>", "(Ljava/lang/String;)V", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ParamsInvalid extends UpdateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParamsInvalid(String params) {
            super(1, "parameter '" + params + "' is invalid.", null);
            Intrinsics.checkNotNullParameter(params, "params");
        }
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$AlreadyUpdating;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "<init>", "()V", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AlreadyUpdating extends UpdateException {
        public AlreadyUpdating() {
            super(2, "an update task is being performed.", null);
        }
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$NoNeedToUpdate;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "oldV", "", "newV", "ignorable", "", "<init>", "(JJZ)V", "getIgnorable", "()Z", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class NoNeedToUpdate extends UpdateException {
        private final boolean ignorable;

        public NoNeedToUpdate(long oldV, long newV, boolean ignorable) {
            super(3, "current version " + oldV + " does not need to be updated to " + newV + ".", null);
            this.ignorable = ignorable;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ NoNeedToUpdate(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, j2, r5);
            boolean z2;
            if ((i & 4) == 0) {
                z2 = z;
            } else {
                z2 = true;
            }
        }

        public final boolean getIgnorable() {
            return this.ignorable;
        }
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$DownloadFile;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "type", "", "<init>", "(Ljava/lang/String;)V", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DownloadFile extends UpdateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DownloadFile(String type) {
            super(4, "download " + type + " file error.", null);
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$ReadFile;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "type", "", "<init>", "(Ljava/lang/String;)V", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ReadFile extends UpdateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReadFile(String type) {
            super(5, "read " + type + " file error.", null);
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }

    /* compiled from: UpdateException.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkntr/base/dd/impl/internal/update/UpdateException$Serialize;", "Lkntr/base/dd/impl/internal/update/UpdateException;", "type", "", "<init>", "(Ljava/lang/String;)V", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Serialize extends UpdateException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Serialize(String type) {
            super(6, "serialize " + type + " error.", null);
            Intrinsics.checkNotNullParameter(type, "type");
        }
    }
}