package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import im.session.model.IMSessionCardKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionUpdateService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lim/session/service/SessionRemovedFromTypeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "sessionId", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "cause", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Ljava/lang/Exception;)V", "getSessionId", "()Lcom/bapis/bilibili/app/im/v1/KSessionId;", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "Companion", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SessionRemovedFromTypeException extends Exception {
    public static final int CODE = 1217;
    public static final Companion Companion = new Companion(null);
    private final KSessionPageType pageType;
    private final KSessionId sessionId;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SessionRemovedFromTypeException(KSessionId sessionId, KSessionPageType pageType, Exception cause) {
        super("Session " + r0 + " removed from " + pageType.getName(), cause);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        String stringId = IMSessionCardKt.getStringId(sessionId);
        this.sessionId = sessionId;
        this.pageType = pageType;
    }

    public final KSessionId getSessionId() {
        return this.sessionId;
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    /* compiled from: IMSessionUpdateService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lim/session/service/SessionRemovedFromTypeException$Companion;", "", "<init>", "()V", "CODE", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}