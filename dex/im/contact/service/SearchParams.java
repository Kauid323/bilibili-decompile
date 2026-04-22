package im.contact.service;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactSearchService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lim/contact/service/SearchParams;", "", "searchWord", "", "tab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "paging", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lcom/bapis/bilibili/app/im/v1/KPaginationParams;)V", "getSearchWord", "()Ljava/lang/String;", "getTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getPaging", "()Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchParams {
    private final KPaginationParams paging;
    private final String searchWord;
    private final KContactTabType tab;

    public static /* synthetic */ SearchParams copy$default(SearchParams searchParams, String str, KContactTabType kContactTabType, KPaginationParams kPaginationParams, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchParams.searchWord;
        }
        if ((i2 & 2) != 0) {
            kContactTabType = searchParams.tab;
        }
        if ((i2 & 4) != 0) {
            kPaginationParams = searchParams.paging;
        }
        return searchParams.copy(str, kContactTabType, kPaginationParams);
    }

    public final String component1() {
        return this.searchWord;
    }

    public final KContactTabType component2() {
        return this.tab;
    }

    public final KPaginationParams component3() {
        return this.paging;
    }

    public final SearchParams copy(String str, KContactTabType kContactTabType, KPaginationParams kPaginationParams) {
        Intrinsics.checkNotNullParameter(str, "searchWord");
        Intrinsics.checkNotNullParameter(kContactTabType, "tab");
        return new SearchParams(str, kContactTabType, kPaginationParams);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchParams) {
            SearchParams searchParams = (SearchParams) obj;
            return Intrinsics.areEqual(this.searchWord, searchParams.searchWord) && Intrinsics.areEqual(this.tab, searchParams.tab) && Intrinsics.areEqual(this.paging, searchParams.paging);
        }
        return false;
    }

    public int hashCode() {
        return (((this.searchWord.hashCode() * 31) + this.tab.hashCode()) * 31) + (this.paging == null ? 0 : this.paging.hashCode());
    }

    public String toString() {
        String str = this.searchWord;
        KContactTabType kContactTabType = this.tab;
        return "SearchParams(searchWord=" + str + ", tab=" + kContactTabType + ", paging=" + this.paging + ")";
    }

    public SearchParams(String searchWord, KContactTabType tab, KPaginationParams paging) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(tab, "tab");
        this.searchWord = searchWord;
        this.tab = tab;
        this.paging = paging;
    }

    public /* synthetic */ SearchParams(String str, KContactTabType kContactTabType, KPaginationParams kPaginationParams, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE : kContactTabType, (i2 & 4) != 0 ? null : kPaginationParams);
    }

    public final String getSearchWord() {
        return this.searchWord;
    }

    public final KContactTabType getTab() {
        return this.tab;
    }

    public final KPaginationParams getPaging() {
        return this.paging;
    }
}