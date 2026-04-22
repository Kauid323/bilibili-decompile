package im.session.service;

import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionUpdateService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lim/session/service/IMSessionUpdateParam;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "filterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "updateSessionParams", "Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;)V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getFilterType", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "getUpdateSessionParams", "()Lcom/bapis/bilibili/app/im/v1/KUpdateSessionParams;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionUpdateParam {
    private final KSessionFilterType filterType;
    private final KSessionPageType pageType;
    private final KUpdateSessionParams updateSessionParams;

    public IMSessionUpdateParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ IMSessionUpdateParam copy$default(IMSessionUpdateParam iMSessionUpdateParam, KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, KUpdateSessionParams kUpdateSessionParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kSessionPageType = iMSessionUpdateParam.pageType;
        }
        if ((i2 & 2) != 0) {
            kSessionFilterType = iMSessionUpdateParam.filterType;
        }
        if ((i2 & 4) != 0) {
            kUpdateSessionParams = iMSessionUpdateParam.updateSessionParams;
        }
        return iMSessionUpdateParam.copy(kSessionPageType, kSessionFilterType, kUpdateSessionParams);
    }

    public final KSessionPageType component1() {
        return this.pageType;
    }

    public final KSessionFilterType component2() {
        return this.filterType;
    }

    public final KUpdateSessionParams component3() {
        return this.updateSessionParams;
    }

    public final IMSessionUpdateParam copy(KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, KUpdateSessionParams kUpdateSessionParams) {
        Intrinsics.checkNotNullParameter(kSessionPageType, "pageType");
        Intrinsics.checkNotNullParameter(kSessionFilterType, "filterType");
        return new IMSessionUpdateParam(kSessionPageType, kSessionFilterType, kUpdateSessionParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionUpdateParam) {
            IMSessionUpdateParam iMSessionUpdateParam = (IMSessionUpdateParam) obj;
            return Intrinsics.areEqual(this.pageType, iMSessionUpdateParam.pageType) && Intrinsics.areEqual(this.filterType, iMSessionUpdateParam.filterType) && Intrinsics.areEqual(this.updateSessionParams, iMSessionUpdateParam.updateSessionParams);
        }
        return false;
    }

    public int hashCode() {
        return (((this.pageType.hashCode() * 31) + this.filterType.hashCode()) * 31) + (this.updateSessionParams == null ? 0 : this.updateSessionParams.hashCode());
    }

    public String toString() {
        KSessionPageType kSessionPageType = this.pageType;
        KSessionFilterType kSessionFilterType = this.filterType;
        return "IMSessionUpdateParam(pageType=" + kSessionPageType + ", filterType=" + kSessionFilterType + ", updateSessionParams=" + this.updateSessionParams + ")";
    }

    public IMSessionUpdateParam(KSessionPageType pageType, KSessionFilterType filterType, KUpdateSessionParams updateSessionParams) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.pageType = pageType;
        this.filterType = filterType;
        this.updateSessionParams = updateSessionParams;
    }

    public /* synthetic */ IMSessionUpdateParam(KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, KUpdateSessionParams kUpdateSessionParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? (KSessionPageType) KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE : kSessionPageType, (i2 & 2) != 0 ? (KSessionFilterType) KSessionFilterType.FILTER_DEFAULT.INSTANCE : kSessionFilterType, (i2 & 4) != 0 ? null : kUpdateSessionParams);
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    public final KSessionFilterType getFilterType() {
        return this.filterType;
    }

    public final KUpdateSessionParams getUpdateSessionParams() {
        return this.updateSessionParams;
    }
}