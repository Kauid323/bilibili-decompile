package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTab;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010.\u001a\u00020/J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\n0\tHÀ\u0003¢\u0006\u0002\b4J\u0010\u00105\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\b6JC\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u00108\u001a\u00020\u001e2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020<HÖ\u0001J\t\u0010=\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u00058VX\u0096\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0010\u001a\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0010\u001a\u0004\b'\u0010!R \u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0010\u001a\u0004\b*\u0010\u001aR\u001a\u0010+\u001a\u00020\u001e8@X\u0080\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0010\u001a\u0004\b-\u0010!¨\u0006?"}, d2 = {"Lim/contact/model/IMContactTabData;", "Lim/contact/model/IMContactTab;", "status", "Lim/contact/model/IMContactPageStatus;", ContentDisposition.Parameters.Name, "", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "contacts", "", "Lim/contact/model/IMContactItem;", "pagingParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "<init>", "(Lim/contact/model/IMContactPageStatus;Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Ljava/util/List;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;)V", "getStatus$annotations", "()V", "getStatus", "()Lim/contact/model/IMContactPageStatus;", "getName$annotations", "getName", "()Ljava/lang/String;", "getCurrentTab$annotations", "getCurrentTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getContacts$contact_debug", "()Ljava/util/List;", "getPagingParams$contact_debug", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "canSearch", "", "getCanSearch$annotations", "getCanSearch", "()Z", "searchWord", "getSearchWord$annotations", "getSearchWord", "inSearch", "getInSearch$annotations", "getInSearch", "showList", "getShowList$annotations", "getShowList", "hasMore", "getHasMore$contact_debug$annotations", "getHasMore$contact_debug", "toSearchData", "Lim/contact/model/IMContactSearchingTabData;", "component1", "component2", "component3", "component4", "component4$contact_debug", "component5", "component5$contact_debug", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactTabData implements IMContactTab {
    public static final Companion Companion = new Companion(null);
    private static final IMContactTabData DEFAULT = new IMContactTabData(null, null, null, null, null, 31, null);
    private final List<IMContactItem> contacts;
    private final KContactTabType currentTab;
    private final String name;
    private final KPaginationParams pagingParams;
    private final IMContactPageStatus status;

    public IMContactTabData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ IMContactTabData copy$default(IMContactTabData iMContactTabData, IMContactPageStatus iMContactPageStatus, String str, KContactTabType kContactTabType, List list, KPaginationParams kPaginationParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMContactPageStatus = iMContactTabData.status;
        }
        if ((i2 & 2) != 0) {
            str = iMContactTabData.name;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            kContactTabType = iMContactTabData.currentTab;
        }
        KContactTabType kContactTabType2 = kContactTabType;
        List<IMContactItem> list2 = list;
        if ((i2 & 8) != 0) {
            list2 = iMContactTabData.contacts;
        }
        List list3 = list2;
        if ((i2 & 16) != 0) {
            kPaginationParams = iMContactTabData.pagingParams;
        }
        return iMContactTabData.copy(iMContactPageStatus, str2, kContactTabType2, list3, kPaginationParams);
    }

    public static /* synthetic */ void getCanSearch$annotations() {
    }

    public static /* synthetic */ void getCurrentTab$annotations() {
    }

    public static /* synthetic */ void getHasMore$contact_debug$annotations() {
    }

    public static /* synthetic */ void getInSearch$annotations() {
    }

    public static /* synthetic */ void getName$annotations() {
    }

    public static /* synthetic */ void getSearchWord$annotations() {
    }

    public static /* synthetic */ void getShowList$annotations() {
    }

    public static /* synthetic */ void getStatus$annotations() {
    }

    public final IMContactPageStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.name;
    }

    public final KContactTabType component3() {
        return this.currentTab;
    }

    public final List<IMContactItem> component4$contact_debug() {
        return this.contacts;
    }

    public final KPaginationParams component5$contact_debug() {
        return this.pagingParams;
    }

    public final IMContactTabData copy(IMContactPageStatus iMContactPageStatus, String str, KContactTabType kContactTabType, List<IMContactItem> list, KPaginationParams kPaginationParams) {
        Intrinsics.checkNotNullParameter(iMContactPageStatus, "status");
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(kContactTabType, "currentTab");
        Intrinsics.checkNotNullParameter(list, "contacts");
        return new IMContactTabData(iMContactPageStatus, str, kContactTabType, list, kPaginationParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactTabData) {
            IMContactTabData iMContactTabData = (IMContactTabData) obj;
            return Intrinsics.areEqual(this.status, iMContactTabData.status) && Intrinsics.areEqual(this.name, iMContactTabData.name) && Intrinsics.areEqual(this.currentTab, iMContactTabData.currentTab) && Intrinsics.areEqual(this.contacts, iMContactTabData.contacts) && Intrinsics.areEqual(this.pagingParams, iMContactTabData.pagingParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.status.hashCode() * 31) + this.name.hashCode()) * 31) + this.currentTab.hashCode()) * 31) + this.contacts.hashCode()) * 31) + (this.pagingParams == null ? 0 : this.pagingParams.hashCode());
    }

    public String toString() {
        IMContactPageStatus iMContactPageStatus = this.status;
        String str = this.name;
        KContactTabType kContactTabType = this.currentTab;
        List<IMContactItem> list = this.contacts;
        return "IMContactTabData(status=" + iMContactPageStatus + ", name=" + str + ", currentTab=" + kContactTabType + ", contacts=" + list + ", pagingParams=" + this.pagingParams + ")";
    }

    public IMContactTabData(IMContactPageStatus status, String name, KContactTabType currentTab, List<IMContactItem> list, KPaginationParams pagingParams) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(currentTab, "currentTab");
        Intrinsics.checkNotNullParameter(list, "contacts");
        this.status = status;
        this.name = name;
        this.currentTab = currentTab;
        this.contacts = list;
        this.pagingParams = pagingParams;
    }

    public /* synthetic */ IMContactTabData(StatusIdle statusIdle, String str, KContactTabType kContactTabType, List list, KPaginationParams kPaginationParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? StatusIdle.INSTANCE : statusIdle, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE : kContactTabType, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list, (i2 & 16) != 0 ? null : kPaginationParams);
    }

    @Override // im.contact.model.IMContactTab
    public IMContactPageStatus getStatus() {
        return this.status;
    }

    @Override // im.contact.model.IMContactTab
    public String getName() {
        return this.name;
    }

    @Override // im.contact.model.IMContactTab
    public KContactTabType getCurrentTab() {
        return this.currentTab;
    }

    public final List<IMContactItem> getContacts$contact_debug() {
        return this.contacts;
    }

    public final KPaginationParams getPagingParams$contact_debug() {
        return this.pagingParams;
    }

    /* compiled from: IMContactTabData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lim/contact/model/IMContactTabData$Companion;", "", "<init>", "()V", "DEFAULT", "Lim/contact/model/IMContactTabData;", "getDEFAULT", "()Lim/contact/model/IMContactTabData;", "from", "tab", "Lcom/bapis/bilibili/app/im/v1/KContactTab;", "contacts", "", "Lim/contact/model/IMContactItem;", "pagingParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IMContactTabData getDEFAULT() {
            return IMContactTabData.DEFAULT;
        }

        public static /* synthetic */ IMContactTabData from$default(Companion companion, KContactTab kContactTab, List list, KPaginationParams kPaginationParams, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                kPaginationParams = null;
            }
            return companion.from(kContactTab, list, kPaginationParams);
        }

        public final IMContactTabData from(KContactTab tab, List<IMContactItem> list, KPaginationParams pagingParams) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            Intrinsics.checkNotNullParameter(list, "contacts");
            return new IMContactTabData(list.isEmpty() ? StatusIdle.INSTANCE : StatusSuccess.INSTANCE, tab.getName(), tab.getTab(), list, pagingParams);
        }
    }

    @Override // im.contact.model.IMContactTab
    public boolean getCanSearch() {
        return Intrinsics.areEqual(getCurrentTab(), KContactTabType.TAB_FOLLOW.INSTANCE) && !getShowList().isEmpty();
    }

    @Override // im.contact.model.IMContactTab
    public String getSearchWord() {
        return "";
    }

    @Override // im.contact.model.IMContactTab
    public boolean getInSearch() {
        return false;
    }

    @Override // im.contact.model.IMContactTab
    public List<IMContactItem> getShowList() {
        return this.contacts;
    }

    public final boolean getHasMore$contact_debug() {
        KPaginationParams kPaginationParams = this.pagingParams;
        boolean z = false;
        if (kPaginationParams != null && !kPaginationParams.getHasMore()) {
            z = true;
        }
        return !z;
    }

    public final IMContactSearchingTabData toSearchData() {
        return new IMContactSearchingTabData(this, null, null, null, null, 30, null);
    }
}