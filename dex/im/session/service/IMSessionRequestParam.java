package im.session.service;

import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bapis.bilibili.app.im.v1.KSessionFilterType;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionRequestServiceLike.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lim/session/service/IMSessionRequestParam;", "", "paginationParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "filterType", "Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KPaginationParams;Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;)V", "getPaginationParams", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getFilterType", "()Lcom/bapis/bilibili/app/im/v1/KSessionFilterType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionRequestParam {
    private final KSessionFilterType filterType;
    private final KSessionPageType pageType;
    private final KPaginationParams paginationParams;

    public IMSessionRequestParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ IMSessionRequestParam copy$default(IMSessionRequestParam iMSessionRequestParam, KPaginationParams kPaginationParams, KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kPaginationParams = iMSessionRequestParam.paginationParams;
        }
        if ((i2 & 2) != 0) {
            kSessionPageType = iMSessionRequestParam.pageType;
        }
        if ((i2 & 4) != 0) {
            kSessionFilterType = iMSessionRequestParam.filterType;
        }
        return iMSessionRequestParam.copy(kPaginationParams, kSessionPageType, kSessionFilterType);
    }

    public final KPaginationParams component1() {
        return this.paginationParams;
    }

    public final KSessionPageType component2() {
        return this.pageType;
    }

    public final KSessionFilterType component3() {
        return this.filterType;
    }

    public final IMSessionRequestParam copy(KPaginationParams kPaginationParams, KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType) {
        Intrinsics.checkNotNullParameter(kSessionPageType, "pageType");
        Intrinsics.checkNotNullParameter(kSessionFilterType, "filterType");
        return new IMSessionRequestParam(kPaginationParams, kSessionPageType, kSessionFilterType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMSessionRequestParam) {
            IMSessionRequestParam iMSessionRequestParam = (IMSessionRequestParam) obj;
            return Intrinsics.areEqual(this.paginationParams, iMSessionRequestParam.paginationParams) && Intrinsics.areEqual(this.pageType, iMSessionRequestParam.pageType) && Intrinsics.areEqual(this.filterType, iMSessionRequestParam.filterType);
        }
        return false;
    }

    public int hashCode() {
        return ((((this.paginationParams == null ? 0 : this.paginationParams.hashCode()) * 31) + this.pageType.hashCode()) * 31) + this.filterType.hashCode();
    }

    public String toString() {
        KPaginationParams kPaginationParams = this.paginationParams;
        KSessionPageType kSessionPageType = this.pageType;
        return "IMSessionRequestParam(paginationParams=" + kPaginationParams + ", pageType=" + kSessionPageType + ", filterType=" + this.filterType + ")";
    }

    public IMSessionRequestParam(KPaginationParams paginationParams, KSessionPageType pageType, KSessionFilterType filterType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(filterType, "filterType");
        this.paginationParams = paginationParams;
        this.pageType = pageType;
        this.filterType = filterType;
    }

    public /* synthetic */ IMSessionRequestParam(KPaginationParams kPaginationParams, KSessionPageType kSessionPageType, KSessionFilterType kSessionFilterType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : kPaginationParams, (i2 & 2) != 0 ? (KSessionPageType) KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE : kSessionPageType, (i2 & 4) != 0 ? (KSessionFilterType) KSessionFilterType.FILTER_DEFAULT.INSTANCE : kSessionFilterType);
    }

    public final KPaginationParams getPaginationParams() {
        return this.paginationParams;
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    public final KSessionFilterType getFilterType() {
        return this.filterType;
    }
}