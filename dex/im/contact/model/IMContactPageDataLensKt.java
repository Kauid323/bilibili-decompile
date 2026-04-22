package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.contact.model.IMContactPageData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactPageDataLens.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"0\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"*\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\",\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u001f\u001a\u0004\b\u0010\u0010 \"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00120\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u001f\u001a\u0004\b\u0014\u0010 \"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00160\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010 \"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001c\u0010 \"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$\"H\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$\"B\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00120!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$\"B\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00160!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010$\"D\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010-\u001a\u0004\b\u000b\u0010.\"F\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010-\u001a\u0004\b\u0010\u0010.\"@\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00120!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010-\u001a\u0004\b\u0014\u0010.\"@\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00160!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010-\u001a\u0004\b\u0018\u0010.\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010-\u001a\u0004\b\u001c\u0010/¨\u00060"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/contact/model/IMContactPageData;", "Lim/contact/model/IMContactPageData$Companion;", "getLens$annotations", "(Lim/contact/model/IMContactPageData$Companion;)V", "getLens", "(Lim/contact/model/IMContactPageData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "status", "Lim/contact/model/IMContactPageStatus;", "getStatus$annotations", "getStatus", "tabList", "", "Lim/contact/model/IMContactTab;", "getTabList$annotations", "getTabList", "toastHolder", "Lim/contact/model/ToastHolder;", "getToastHolder$annotations", "getToastHolder", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getCurrentTab$annotations", "getCurrentTab", "clickedContact", "Lim/contact/model/IMContactClickedHolder;", "getClickedContact$annotations", "getClickedContact", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "tabListNullable$annotations", "tabListNullable", "toastHolderNullable$annotations", "toastHolderNullable", "currentTabNullable$annotations", "currentTabNullable", "clickedContactNullable$annotations", "clickedContactNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "contact_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactPageDataLensKt {
    public static /* synthetic */ void clickedContactNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void currentTabNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getClickedContact$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getClickedContact$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getClickedContact$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void getTabList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTabList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTabList$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void getToastHolder$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToastHolder$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToastHolder$annotations(IMContactPageData.Companion companion) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void tabListNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void toastHolderNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMContactPageData, IMContactPageData> getLens(IMContactPageData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, IMContactPageData>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$1
            public IMContactPageData get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it;
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, IMContactPageData iMContactPageData2) {
                IMContactPageData it = iMContactPageData2;
                return it;
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super IMContactPageData, ? extends IMContactPageData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                return (IMContactPageData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMContactPageData, IMContactPageStatus> getStatus(IMContactPageData.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, IMContactPageStatus>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$2
            public IMContactPageStatus get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it.getStatus();
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, IMContactPageStatus iMContactPageStatus) {
                IMContactPageStatus status = iMContactPageStatus;
                IMContactPageData it = iMContactPageData;
                return IMContactPageData.copy$default(it, status, null, null, null, null, 30, null);
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super IMContactPageStatus, ? extends IMContactPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                IMContactPageStatus status = (IMContactPageStatus) function1.invoke(it.getStatus());
                IMContactPageData it2 = iMContactPageData;
                return IMContactPageData.copy$default(it2, status, null, null, null, null, 30, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMContactPageData, List<IMContactTab>> getTabList(IMContactPageData.Companion $this$tabList) {
        Intrinsics.checkNotNullParameter($this$tabList, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, List<? extends IMContactTab>>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$3
            public List<? extends IMContactTab> get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it.getTabList();
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, List<? extends IMContactTab> list) {
                List<? extends IMContactTab> tabList = list;
                IMContactPageData it = iMContactPageData;
                return IMContactPageData.copy$default(it, null, tabList, null, null, null, 29, null);
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super List<? extends IMContactTab>, ? extends List<? extends IMContactTab>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                List tabList = (List) function1.invoke(it.getTabList());
                IMContactPageData it2 = iMContactPageData;
                return IMContactPageData.copy$default(it2, null, tabList, null, null, null, 29, null);
            }
        };
    }

    public static final BSimpleLens<IMContactPageData, ToastHolder> getToastHolder(IMContactPageData.Companion $this$toastHolder) {
        Intrinsics.checkNotNullParameter($this$toastHolder, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, ToastHolder>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$4
            public ToastHolder get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it.getToastHolder$contact_debug();
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, ToastHolder toastHolder) {
                ToastHolder toastHolder2 = toastHolder;
                IMContactPageData it = iMContactPageData;
                return IMContactPageData.copy$default(it, null, null, toastHolder2, null, null, 27, null);
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super ToastHolder, ? extends ToastHolder> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                ToastHolder toastHolder = (ToastHolder) function1.invoke(it.getToastHolder$contact_debug());
                IMContactPageData it2 = iMContactPageData;
                return IMContactPageData.copy$default(it2, null, null, toastHolder, null, null, 27, null);
            }
        };
    }

    public static final BSimpleLens<IMContactPageData, KContactTabType> getCurrentTab(IMContactPageData.Companion $this$currentTab) {
        Intrinsics.checkNotNullParameter($this$currentTab, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, KContactTabType>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$5
            public KContactTabType get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it.getCurrentTab();
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, KContactTabType kContactTabType) {
                KContactTabType currentTab = kContactTabType;
                IMContactPageData it = iMContactPageData;
                return IMContactPageData.copy$default(it, null, null, null, currentTab, null, 23, null);
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super KContactTabType, ? extends KContactTabType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                KContactTabType currentTab = (KContactTabType) function1.invoke(it.getCurrentTab());
                IMContactPageData it2 = iMContactPageData;
                return IMContactPageData.copy$default(it2, null, null, null, currentTab, null, 23, null);
            }
        };
    }

    public static final BSimpleLens<IMContactPageData, IMContactClickedHolder> getClickedContact(IMContactPageData.Companion $this$clickedContact) {
        Intrinsics.checkNotNullParameter($this$clickedContact, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactPageData, IMContactClickedHolder>() { // from class: im.contact.model.IMContactPageDataLensKt$special$$inlined$invoke$6
            public IMContactClickedHolder get(IMContactPageData iMContactPageData) {
                IMContactPageData it = iMContactPageData;
                return it.getClickedContact();
            }

            public IMContactPageData set(IMContactPageData iMContactPageData, IMContactClickedHolder iMContactClickedHolder) {
                IMContactClickedHolder clickedContact = iMContactClickedHolder;
                IMContactPageData it = iMContactPageData;
                return IMContactPageData.copy$default(it, null, null, null, null, clickedContact, 15, null);
            }

            public IMContactPageData modify(IMContactPageData iMContactPageData, Function1<? super IMContactClickedHolder, ? extends IMContactClickedHolder> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactPageData it = iMContactPageData;
                IMContactClickedHolder clickedContact = (IMContactClickedHolder) function1.invoke(it.getClickedContact());
                IMContactPageData it2 = iMContactPageData;
                return IMContactPageData.copy$default(it2, null, null, null, null, clickedContact, 15, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, IMContactPageStatus> getStatus(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMContactTab>> getTabList(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTabList(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, ToastHolder> getToastHolder(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getToastHolder(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, KContactTabType> getCurrentTab(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCurrentTab(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMContactClickedHolder> getClickedContact(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getClickedContact(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> statusNullable(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactTab>> tabListNullable(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTabList(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, ToastHolder> toastHolderNullable(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getToastHolder(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, KContactTabType> currentTabNullable(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCurrentTab(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMContactClickedHolder> clickedContactNullable(BSimpleLens<T, IMContactPageData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getClickedContact(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> getStatus(BNullableLens<T, IMContactPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactTab>> getTabList(BNullableLens<T, IMContactPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTabList(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, ToastHolder> getToastHolder(BNullableLens<T, IMContactPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getToastHolder(IMContactPageData.Companion));
    }

    public static final <T> BNullableLens<T, KContactTabType> getCurrentTab(BNullableLens<T, IMContactPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCurrentTab(IMContactPageData.Companion));
    }

    public static final <T> BSimpleLens<T, IMContactClickedHolder> getClickedContact(BNullableLens<T, IMContactPageData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getClickedContact(IMContactPageData.Companion));
    }
}