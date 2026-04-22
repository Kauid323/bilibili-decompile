package im.contact.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactAction.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lim/contact/model/IMContactOnContactClick;", "Lim/contact/model/IMContactAction;", "contact", "Lim/contact/model/IMContactItem;", "<init>", "(Lim/contact/model/IMContactItem;)V", "getContact", "()Lim/contact/model/IMContactItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactOnContactClick implements IMContactAction {
    private final IMContactItem contact;

    public static /* synthetic */ IMContactOnContactClick copy$default(IMContactOnContactClick iMContactOnContactClick, IMContactItem iMContactItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMContactItem = iMContactOnContactClick.contact;
        }
        return iMContactOnContactClick.copy(iMContactItem);
    }

    public final IMContactItem component1() {
        return this.contact;
    }

    public final IMContactOnContactClick copy(IMContactItem iMContactItem) {
        Intrinsics.checkNotNullParameter(iMContactItem, "contact");
        return new IMContactOnContactClick(iMContactItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof IMContactOnContactClick) && Intrinsics.areEqual(this.contact, ((IMContactOnContactClick) obj).contact);
    }

    public int hashCode() {
        return this.contact.hashCode();
    }

    public String toString() {
        return "IMContactOnContactClick(contact=" + this.contact + ")";
    }

    public IMContactOnContactClick(IMContactItem contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        this.contact = contact;
    }

    public final IMContactItem getContact() {
        return this.contact;
    }
}