package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTab;
import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bilibili.blens.Lens;
import im.base.ContentStatus;
import im.base.EmptyContent;
import im.base.ErrorContent;
import im.base.IdleContent;
import im.base.LoadingContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPageData.kt */
@Lens
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0001.BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000e\u0010#\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b$J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003JC\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001aHÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lim/contact/model/IMContactPageData;", "", "status", "Lim/contact/model/IMContactPageStatus;", "tabList", "", "Lim/contact/model/IMContactTab;", "toastHolder", "Lim/contact/model/ToastHolder;", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "clickedContact", "Lim/contact/model/IMContactClickedHolder;", "<init>", "(Lim/contact/model/IMContactPageStatus;Ljava/util/List;Lim/contact/model/ToastHolder;Lcom/bapis/bilibili/app/im/v1/KContactTabType;Lim/contact/model/IMContactClickedHolder;)V", "getStatus", "()Lim/contact/model/IMContactPageStatus;", "getTabList", "()Ljava/util/List;", "getToastHolder$contact_debug", "()Lim/contact/model/ToastHolder;", "getCurrentTab", "()Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getClickedContact", "()Lim/contact/model/IMContactClickedHolder;", "selectedIndex", "", "getSelectedIndex", "()I", "pageContentStatus", "Lim/base/ContentStatus;", "getPageContentStatus", "()Lim/base/ContentStatus;", "component1", "component2", "component3", "component3$contact_debug", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageData {
    public static final Companion Companion = new Companion(null);
    private static final IMContactPageData DEFAULT = new IMContactPageData(null, null, null, null, null, 31, null);
    private final IMContactClickedHolder clickedContact;
    private final KContactTabType currentTab;
    private final IMContactPageStatus status;
    private final List<IMContactTab> tabList;
    private final ToastHolder toastHolder;

    public IMContactPageData() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ IMContactPageData copy$default(IMContactPageData iMContactPageData, IMContactPageStatus iMContactPageStatus, List list, ToastHolder toastHolder, KContactTabType kContactTabType, IMContactClickedHolder iMContactClickedHolder, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iMContactPageStatus = iMContactPageData.status;
        }
        List<IMContactTab> list2 = list;
        if ((i2 & 2) != 0) {
            list2 = iMContactPageData.tabList;
        }
        List list3 = list2;
        if ((i2 & 4) != 0) {
            toastHolder = iMContactPageData.toastHolder;
        }
        ToastHolder toastHolder2 = toastHolder;
        if ((i2 & 8) != 0) {
            kContactTabType = iMContactPageData.currentTab;
        }
        KContactTabType kContactTabType2 = kContactTabType;
        if ((i2 & 16) != 0) {
            iMContactClickedHolder = iMContactPageData.clickedContact;
        }
        return iMContactPageData.copy(iMContactPageStatus, list3, toastHolder2, kContactTabType2, iMContactClickedHolder);
    }

    public final IMContactPageStatus component1() {
        return this.status;
    }

    public final List<IMContactTab> component2() {
        return this.tabList;
    }

    public final ToastHolder component3$contact_debug() {
        return this.toastHolder;
    }

    public final KContactTabType component4() {
        return this.currentTab;
    }

    public final IMContactClickedHolder component5() {
        return this.clickedContact;
    }

    public final IMContactPageData copy(IMContactPageStatus iMContactPageStatus, List<? extends IMContactTab> list, ToastHolder toastHolder, KContactTabType kContactTabType, IMContactClickedHolder iMContactClickedHolder) {
        Intrinsics.checkNotNullParameter(iMContactPageStatus, "status");
        Intrinsics.checkNotNullParameter(list, "tabList");
        Intrinsics.checkNotNullParameter(toastHolder, "toastHolder");
        Intrinsics.checkNotNullParameter(kContactTabType, "currentTab");
        return new IMContactPageData(iMContactPageStatus, list, toastHolder, kContactTabType, iMContactClickedHolder);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMContactPageData) {
            IMContactPageData iMContactPageData = (IMContactPageData) obj;
            return Intrinsics.areEqual(this.status, iMContactPageData.status) && Intrinsics.areEqual(this.tabList, iMContactPageData.tabList) && Intrinsics.areEqual(this.toastHolder, iMContactPageData.toastHolder) && Intrinsics.areEqual(this.currentTab, iMContactPageData.currentTab) && Intrinsics.areEqual(this.clickedContact, iMContactPageData.clickedContact);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.status.hashCode() * 31) + this.tabList.hashCode()) * 31) + this.toastHolder.hashCode()) * 31) + this.currentTab.hashCode()) * 31) + (this.clickedContact == null ? 0 : this.clickedContact.hashCode());
    }

    public String toString() {
        IMContactPageStatus iMContactPageStatus = this.status;
        List<IMContactTab> list = this.tabList;
        ToastHolder toastHolder = this.toastHolder;
        KContactTabType kContactTabType = this.currentTab;
        return "IMContactPageData(status=" + iMContactPageStatus + ", tabList=" + list + ", toastHolder=" + toastHolder + ", currentTab=" + kContactTabType + ", clickedContact=" + this.clickedContact + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IMContactPageData(IMContactPageStatus status, List<? extends IMContactTab> list, ToastHolder toastHolder, KContactTabType currentTab, IMContactClickedHolder clickedContact) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(list, "tabList");
        Intrinsics.checkNotNullParameter(toastHolder, "toastHolder");
        Intrinsics.checkNotNullParameter(currentTab, "currentTab");
        this.status = status;
        this.tabList = list;
        this.toastHolder = toastHolder;
        this.currentTab = currentTab;
        this.clickedContact = clickedContact;
    }

    public /* synthetic */ IMContactPageData(StatusIdle statusIdle, List list, ToastHolder toastHolder, KContactTabType kContactTabType, IMContactClickedHolder iMContactClickedHolder, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? StatusIdle.INSTANCE : statusIdle, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list, (i2 & 4) != 0 ? new ToastHolder(null, null, 3, null) : toastHolder, (i2 & 8) != 0 ? (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE : kContactTabType, (i2 & 16) == 0 ? iMContactClickedHolder : null);
    }

    public final IMContactPageStatus getStatus() {
        return this.status;
    }

    public final List<IMContactTab> getTabList() {
        return this.tabList;
    }

    public final ToastHolder getToastHolder$contact_debug() {
        return this.toastHolder;
    }

    public final KContactTabType getCurrentTab() {
        return this.currentTab;
    }

    public final IMContactClickedHolder getClickedContact() {
        return this.clickedContact;
    }

    /* compiled from: IMContactPageData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0017\u0010\u0004\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lim/contact/model/IMContactPageData$Companion;", "", "<init>", "()V", "DEFAULT", "Lim/contact/model/IMContactPageData;", "getDEFAULT$annotations", "getDEFAULT", "()Lim/contact/model/IMContactPageData;", "fromReply", "reply", "Lim/contact/model/ContactsReply;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEFAULT$annotations() {
        }

        private Companion() {
        }

        public final IMContactPageData getDEFAULT() {
            return IMContactPageData.DEFAULT;
        }

        public final IMContactPageData fromReply(ContactsReply reply) {
            KContactTabType kContactTabType;
            Intrinsics.checkNotNullParameter(reply, "reply");
            Iterable $this$map$iv = reply.getTab();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KContactTab tab = (KContactTab) item$iv$iv;
                destination$iv$iv.add(IMContactTabData.Companion.from(tab, Intrinsics.areEqual(reply.getCurrentTab(), tab.getTab()) ? reply.getContacts() : CollectionsKt.emptyList(), Intrinsics.areEqual(reply.getCurrentTab(), tab.getTab()) ? reply.getPaginationParams() : null));
            }
            ArrayList arrayList = (List) destination$iv$iv;
            KContactTabType it = reply.getCurrentTab();
            Iterable $this$map$iv2 = reply.getTab();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(((KContactTab) item$iv$iv2).getTab());
            }
            if (!((List) destination$iv$iv2).contains(it)) {
                it = null;
            }
            if (it == null) {
                KContactTab kContactTab = (KContactTab) CollectionsKt.firstOrNull(reply.getTab());
                KContactTabType tab2 = kContactTab != null ? kContactTab.getTab() : null;
                kContactTabType = tab2 == null ? (KContactTabType) KContactTabType.TAB_UNKNOWN.INSTANCE : tab2;
            } else {
                kContactTabType = it;
            }
            return new IMContactPageData(null, arrayList, null, kContactTabType, null, 21, null);
        }
    }

    public final int getSelectedIndex() {
        List $this$indexOfFirst$iv = this.tabList;
        int index$iv = 0;
        for (Object item$iv : $this$indexOfFirst$iv) {
            IMContactTab it = (IMContactTab) item$iv;
            if (Intrinsics.areEqual(it.getCurrentTab(), this.currentTab)) {
                return index$iv;
            }
            index$iv++;
        }
        return -1;
    }

    public final ContentStatus getPageContentStatus() {
        return (this.tabList.isEmpty() && Intrinsics.areEqual(this.status, StatusLoading.INSTANCE)) ? LoadingContent.INSTANCE : (this.tabList.isEmpty() && (this.status instanceof StatusError)) ? new ErrorContent(((StatusError) this.status).getMessage()) : (this.tabList.isEmpty() && Intrinsics.areEqual(this.status, StatusSuccess.INSTANCE)) ? EmptyContent.INSTANCE : IdleContent.INSTANCE;
    }
}