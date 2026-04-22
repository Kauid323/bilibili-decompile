package kntr.base.dd;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.common.upper.trace.config.AppKey;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IDeviceDecisionUpdater.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001\u000eJ*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H'J\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH§@¢\u0006\u0002\u0010\u000b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/IDeviceDecisionUpdater;", "", "update", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "from", "", AppKey.VERSION, "env", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "(Ljava/lang/String;Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateToLatest", "(Ljava/lang/String;Lkntr/base/dd/IDeviceDecision$Version$Env;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "remoteData", "fallback", "Result", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDeviceDecisionUpdater {
    Object fallback(String str, IDeviceDecision.Version.Env env, Continuation<? super Result> continuation);

    Object update(String str, String str2, IDeviceDecision.Version.Env env, Continuation<? super Result> continuation);

    Result update(String str, String str2);

    Object updateToLatest(String str, IDeviceDecision.Version.Env env, Continuation<? super Result> continuation);

    /* compiled from: IDeviceDecisionUpdater.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "", "<init>", "()V", "Success", "Error", "Lkntr/base/dd/IDeviceDecisionUpdater$Result$Error;", "Lkntr/base/dd/IDeviceDecisionUpdater$Result$Success;", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        /* compiled from: IDeviceDecisionUpdater.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/base/dd/IDeviceDecisionUpdater$Result$Success;", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Success extends Result {
            public static final Success INSTANCE = new Success();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof Success) {
                    Success success = (Success) obj;
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return -593981100;
            }

            public String toString() {
                return "Success";
            }

            private Success() {
                super(null);
            }
        }

        /* compiled from: IDeviceDecisionUpdater.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/base/dd/IDeviceDecisionUpdater$Result$Error;", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Error extends Result {
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                return error.copy(str);
            }

            public final String component1() {
                return this.message;
            }

            public final Error copy(String str) {
                Intrinsics.checkNotNullParameter(str, "message");
                return new Error(str);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Error) && Intrinsics.areEqual(this.message, ((Error) obj).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "Error(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    /* compiled from: IDeviceDecisionUpdater.kt */
    /* renamed from: kntr.base.dd.IDeviceDecisionUpdater$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object update$default(IDeviceDecisionUpdater iDeviceDecisionUpdater, String str, String str2, IDeviceDecision.Version.Env env, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    env = null;
                }
                return iDeviceDecisionUpdater.update(str, str2, env, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: update");
        }

        public static /* synthetic */ Object updateToLatest$default(IDeviceDecisionUpdater iDeviceDecisionUpdater, String str, IDeviceDecision.Version.Env env, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    env = null;
                }
                return iDeviceDecisionUpdater.updateToLatest(str, env, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateToLatest");
        }

        public static /* synthetic */ Object fallback$default(IDeviceDecisionUpdater iDeviceDecisionUpdater, String str, IDeviceDecision.Version.Env env, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    env = null;
                }
                return iDeviceDecisionUpdater.fallback(str, env, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fallback");
        }
    }

    /* compiled from: IDeviceDecisionUpdater.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
    }
}