package im.contact.service;

import im.contact.model.ContactsSearchReply;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContactSearchService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lim/contact/service/SearchResult;", "", "searchWord", "", "reply", "Lim/contact/model/ContactsSearchReply;", "<init>", "(Ljava/lang/String;Lim/contact/model/ContactsSearchReply;)V", "getSearchWord", "()Ljava/lang/String;", "getReply", "()Lim/contact/model/ContactsSearchReply;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchResult {
    private final ContactsSearchReply reply;
    private final String searchWord;

    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, String str, ContactsSearchReply contactsSearchReply, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = searchResult.searchWord;
        }
        if ((i2 & 2) != 0) {
            contactsSearchReply = searchResult.reply;
        }
        return searchResult.copy(str, contactsSearchReply);
    }

    public final String component1() {
        return this.searchWord;
    }

    public final ContactsSearchReply component2() {
        return this.reply;
    }

    public final SearchResult copy(String str, ContactsSearchReply contactsSearchReply) {
        Intrinsics.checkNotNullParameter(str, "searchWord");
        Intrinsics.checkNotNullParameter(contactsSearchReply, "reply");
        return new SearchResult(str, contactsSearchReply);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SearchResult) {
            SearchResult searchResult = (SearchResult) obj;
            return Intrinsics.areEqual(this.searchWord, searchResult.searchWord) && Intrinsics.areEqual(this.reply, searchResult.reply);
        }
        return false;
    }

    public int hashCode() {
        return (this.searchWord.hashCode() * 31) + this.reply.hashCode();
    }

    public String toString() {
        String str = this.searchWord;
        return "SearchResult(searchWord=" + str + ", reply=" + this.reply + ")";
    }

    public SearchResult(String searchWord, ContactsSearchReply reply) {
        Intrinsics.checkNotNullParameter(searchWord, "searchWord");
        Intrinsics.checkNotNullParameter(reply, "reply");
        this.searchWord = searchWord;
        this.reply = reply;
    }

    public final String getSearchWord() {
        return this.searchWord;
    }

    public final ContactsSearchReply getReply() {
        return this.reply;
    }
}