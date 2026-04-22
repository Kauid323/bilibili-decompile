package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bilibili.blens.Lens;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactTabData.kt */
@Lens
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\b\u0018\u0000 92\u00020\u0001:\u00019B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b%J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b)J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b+JC\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010-\u001a\u00020\u001c2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0014\u0010\"\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0012\u00103\u001a\u000204X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0012\u00107\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010\u0014¨\u0006:"}, d2 = {"Lim/contact/model/IMContactSearchingTabData;", "Lim/contact/model/IMContactTab;", "original", "Lim/contact/model/IMContactTabData;", "status", "Lim/contact/model/IMContactPageStatus;", "searchWord", "", "searchResult", "", "Lim/contact/model/IMContactItem;", "pagingParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "<init>", "(Lim/contact/model/IMContactTabData;Lim/contact/model/IMContactPageStatus;Ljava/lang/String;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;)V", "getOriginal$contact_debug", "()Lim/contact/model/IMContactTabData;", "getStatus", "()Lim/contact/model/IMContactPageStatus;", "getSearchWord", "()Ljava/lang/String;", "getSearchResult$contact_debug", "()Ljava/util/List;", "getPagingParams$contact_debug", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "showList", "getShowList", "canSearch", "", "getCanSearch", "()Z", "inSearch", "getInSearch", "toNormalData", "hasMore", "getHasMore$contact_debug", "component1", "component1$contact_debug", "component2", "component3", "component4", "component4$contact_debug", "component5", "component5$contact_debug", "copy", "equals", "other", "", "hashCode", "", "toString", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getCurrentTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", ContentDisposition.Parameters.Name, "getName", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactSearchingTabData implements IMContactTab {
    public static final Companion Companion = new Companion(null);
    private final IMContactTabData original;
    private final KPaginationParams pagingParams;
    private final List<IMContactItem> searchResult;
    private final String searchWord;
    private final IMContactPageStatus status;

    public static /* synthetic */ IMContactSearchingTabData copy$default(IMContactSearchingTabData iMContactSearchingTabData, IMContactTabData iMContactTabData, IMContactPageStatus iMContactPageStatus, String str, List list, KPaginationParams kPaginationParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMContactTabData = iMContactSearchingTabData.original;
        }
        if ((i2 & 2) != 0) {
            iMContactPageStatus = iMContactSearchingTabData.status;
        }
        IMContactPageStatus iMContactPageStatus2 = iMContactPageStatus;
        if ((i2 & 4) != 0) {
            str = iMContactSearchingTabData.searchWord;
        }
        String str2 = str;
        List<IMContactItem> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = iMContactSearchingTabData.searchResult;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            kPaginationParams = iMContactSearchingTabData.pagingParams;
        }
        return iMContactSearchingTabData.copy(iMContactTabData, iMContactPageStatus2, str2, list3, kPaginationParams);
    }

    public final IMContactTabData component1$contact_debug() {
        return this.original;
    }

    public final IMContactPageStatus component2() {
        return this.status;
    }

    public final String component3() {
        return this.searchWord;
    }

    public final List<IMContactItem> component4$contact_debug() {
        return this.searchResult;
    }

    public final KPaginationParams component5$contact_debug() {
        return this.pagingParams;
    }

    public final IMContactSearchingTabData copy(IMContactTabData iMContactTabData, IMContactPageStatus iMContactPageStatus, String str, List<IMContactItem> list, KPaginationParams kPaginationParams) {
        Intrinsics.checkNotNullParameter(iMContactTabData, "original");
        Intrinsics.checkNotNullParameter(iMContactPageStatus, "status");
        Intrinsics.checkNotNullParameter(str, "searchWord");
        Intrinsics.checkNotNullParameter(list, "searchResult");
        return new IMContactSearchingTabData(iMContactTabData, iMContactPageStatus, str, list, kPaginationParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactSearchingTabData) {
            IMContactSearchingTabData iMContactSearchingTabData = (IMContactSearchingTabData) obj;
            return Intrinsics.areEqual(this.original, iMContactSearchingTabData.original) && Intrinsics.areEqual(this.status, iMContactSearchingTabData.status) && Intrinsics.areEqual(this.searchWord, iMContactSearchingTabData.searchWord) && Intrinsics.areEqual(this.searchResult, iMContactSearchingTabData.searchResult) && Intrinsics.areEqual(this.pagingParams, iMContactSearchingTabData.pagingParams);
        }
        return false;
    }

    @Override // im.contact.model.IMContactTab
    public KContactTabType getCurrentTab() {
        return this.original.getCurrentTab();
    }

    @Override // im.contact.model.IMContactTab
    public String getName() {
        return this.original.getName();
    }

    public int hashCode() {
        return (((((((this.original.hashCode() * 31) + this.status.hashCode()) * 31) + this.searchWord.hashCode()) * 31) + this.searchResult.hashCode()) * 31) + (this.pagingParams == null ? 0 : this.pagingParams.hashCode());
    }

    public String toString() {
        IMContactTabData iMContactTabData = this.original;
        IMContactPageStatus iMContactPageStatus = this.status;
        String str = this.searchWord;
        List<IMContactItem> list = this.searchResult;
        return "IMContactSearchingTabData(original=" + iMContactTabData + ", status=" + iMContactPageStatus + ", searchWord=" + str + ", searchResult=" + list + ", pagingParams=" + this.pagingParams + ")";
    }

    public IMContactSearchingTabData(IMContactTabData original, IMContactPageStatus status, String searchWord, List<IMContactItem> list, KPaginationParams pagingParams) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(list, "searchResult");
        this.original = original;
        this.status = status;
        this.searchWord = searchWord;
        this.searchResult = list;
        this.pagingParams = pagingParams;
    }

    public /* synthetic */ IMContactSearchingTabData(IMContactTabData iMContactTabData, IMContactPageStatus iMContactPageStatus, String str, List list, KPaginationParams kPaginationParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iMContactTabData, (i2 & 2) != 0 ? StatusIdle.INSTANCE : iMContactPageStatus, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? null : kPaginationParams);
    }

    public final IMContactTabData getOriginal$contact_debug() {
        return this.original;
    }

    @Override // im.contact.model.IMContactTab
    public IMContactPageStatus getStatus() {
        return this.status;
    }

    @Override // im.contact.model.IMContactTab
    public String getSearchWord() {
        return this.searchWord;
    }

    public final List<IMContactItem> getSearchResult$contact_debug() {
        return this.searchResult;
    }

    public final KPaginationParams getPagingParams$contact_debug() {
        return this.pagingParams;
    }

    /* compiled from: IMContactTabData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/contact/model/IMContactSearchingTabData$Companion;", "", "<init>", "()V", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // im.contact.model.IMContactTab
    public List<IMContactItem> getShowList() {
        return this.searchResult;
    }

    @Override // im.contact.model.IMContactTab
    public boolean getCanSearch() {
        return true;
    }

    @Override // im.contact.model.IMContactTab
    public boolean getInSearch() {
        return true;
    }

    public final IMContactTabData toNormalData() {
        return this.original;
    }

    public final boolean getHasMore$contact_debug() {
        KPaginationParams kPaginationParams = this.pagingParams;
        boolean z = false;
        if (kPaginationParams != null && !kPaginationParams.getHasMore()) {
            z = true;
        }
        return !z;
    }
}