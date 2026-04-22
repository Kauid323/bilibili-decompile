package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INAction.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lim/direct/notification/interactive/INActionRequestListSuccess;", "Lim/direct/notification/interactive/INAction;", "response", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListRsp;", "requestScope", "Lim/direct/notification/interactive/RequestScope;", "<init>", "(Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListRsp;Lim/direct/notification/interactive/RequestScope;)V", "getResponse", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListRsp;", "getRequestScope", "()Lim/direct/notification/interactive/RequestScope;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INActionRequestListSuccess implements INAction {
    private final RequestScope requestScope;
    private final KMsgListRsp response;

    public static /* synthetic */ INActionRequestListSuccess copy$default(INActionRequestListSuccess iNActionRequestListSuccess, KMsgListRsp kMsgListRsp, RequestScope requestScope, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kMsgListRsp = iNActionRequestListSuccess.response;
        }
        if ((i2 & 2) != 0) {
            requestScope = iNActionRequestListSuccess.requestScope;
        }
        return iNActionRequestListSuccess.copy(kMsgListRsp, requestScope);
    }

    public final KMsgListRsp component1() {
        return this.response;
    }

    public final RequestScope component2() {
        return this.requestScope;
    }

    public final INActionRequestListSuccess copy(KMsgListRsp kMsgListRsp, RequestScope requestScope) {
        Intrinsics.checkNotNullParameter(kMsgListRsp, "response");
        Intrinsics.checkNotNullParameter(requestScope, "requestScope");
        return new INActionRequestListSuccess(kMsgListRsp, requestScope);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof INActionRequestListSuccess) {
            INActionRequestListSuccess iNActionRequestListSuccess = (INActionRequestListSuccess) obj;
            return Intrinsics.areEqual(this.response, iNActionRequestListSuccess.response) && this.requestScope == iNActionRequestListSuccess.requestScope;
        }
        return false;
    }

    public int hashCode() {
        return (this.response.hashCode() * 31) + this.requestScope.hashCode();
    }

    public String toString() {
        KMsgListRsp kMsgListRsp = this.response;
        return "INActionRequestListSuccess(response=" + kMsgListRsp + ", requestScope=" + this.requestScope + ")";
    }

    public INActionRequestListSuccess(KMsgListRsp response, RequestScope requestScope) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(requestScope, "requestScope");
        this.response = response;
        this.requestScope = requestScope;
    }

    public final KMsgListRsp getResponse() {
        return this.response;
    }

    public final RequestScope getRequestScope() {
        return this.requestScope;
    }
}