package im.contact.model;

import kotlin.Metadata;

/* compiled from: IMContactAction.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lim/contact/model/IMContactActionEnterSearch;", "Lim/contact/model/IMContactAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactActionEnterSearch implements IMContactAction {
    public static final IMContactActionEnterSearch INSTANCE = new IMContactActionEnterSearch();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactActionEnterSearch) {
            IMContactActionEnterSearch iMContactActionEnterSearch = (IMContactActionEnterSearch) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 602261259;
    }

    public String toString() {
        return "IMContactActionEnterSearch";
    }

    private IMContactActionEnterSearch() {
    }
}