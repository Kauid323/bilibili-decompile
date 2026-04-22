package im.keywordBlocking;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KBPageData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lim/keywordBlocking/KBDropList;", "", "title", "", "actions", "", "Lim/keywordBlocking/KBDropListItem;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "item", "Lim/keywordBlocking/KBListItem;", "(Lim/keywordBlocking/KBListItem;)V", "getTitle", "()Ljava/lang/String;", "getActions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "keyword-blocking_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class KBDropList {
    private final List<KBDropListItem> actions;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KBDropList copy$default(KBDropList kBDropList, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = kBDropList.title;
        }
        if ((i2 & 2) != 0) {
            list = kBDropList.actions;
        }
        return kBDropList.copy(str, list);
    }

    public final String component1() {
        return this.title;
    }

    public final List<KBDropListItem> component2() {
        return this.actions;
    }

    public final KBDropList copy(String str, List<? extends KBDropListItem> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        return new KBDropList(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof KBDropList) {
            KBDropList kBDropList = (KBDropList) obj;
            return Intrinsics.areEqual(this.title, kBDropList.title) && Intrinsics.areEqual(this.actions, kBDropList.actions);
        }
        return false;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.actions.hashCode();
    }

    public String toString() {
        String str = this.title;
        return "KBDropList(title=" + str + ", actions=" + this.actions + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KBDropList(String title, List<? extends KBDropListItem> list) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.title = title;
        this.actions = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<KBDropListItem> getActions() {
        return this.actions;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KBDropList(KBListItem item) {
        this(item.getKeyword(), CollectionsKt.listOf(new KBDropListItemDelete(new KBActionDeleteItem(item))));
        Intrinsics.checkNotNullParameter(item, "item");
    }
}