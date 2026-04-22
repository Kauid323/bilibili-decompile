package im.contact.model;

import com.bapis.bilibili.app.im.v1.KContactTabType;
import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.contact.model.IMContactTabData;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactTabDataLens.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"0\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\",\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000f\u0010 \"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0013\u0010 \"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010 \"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001c\u0010 \"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$\"H\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010$\"D\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010-\u001a\u0004\b\u000b\u0010.\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010-\u001a\u0004\b\u000f\u0010.\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010-\u001a\u0004\b\u0013\u0010.\"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010-\u001a\u0004\b\u0018\u0010.\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010-\u001a\u0004\b\u001c\u0010/¨\u00060"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/contact/model/IMContactTabData;", "Lim/contact/model/IMContactTabData$Companion;", "getLens$annotations", "(Lim/contact/model/IMContactTabData$Companion;)V", "getLens", "(Lim/contact/model/IMContactTabData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "status", "Lim/contact/model/IMContactPageStatus;", "getStatus$annotations", "getStatus", ContentDisposition.Parameters.Name, "", "getName$annotations", "getName", "currentTab", "Lcom/bapis/bilibili/app/im/v1/KContactTabType;", "getCurrentTab$annotations", "getCurrentTab", "contacts", "", "Lim/contact/model/IMContactItem;", "getContacts$annotations", "getContacts", "pagingParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "getPagingParams$annotations", "getPagingParams", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "nameNullable$annotations", "nameNullable", "currentTabNullable$annotations", "currentTabNullable", "contactsNullable$annotations", "contactsNullable", "pagingParamsNullable$annotations", "pagingParamsNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "contact_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactTabDataLensKt {
    public static /* synthetic */ void contactsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void currentTabNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContacts$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContacts$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContacts$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getCurrentTab$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void getName$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getName$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getName$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void getPagingParams$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPagingParams$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPagingParams$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(IMContactTabData.Companion companion) {
    }

    public static /* synthetic */ void nameNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pagingParamsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMContactTabData, IMContactTabData> getLens(IMContactTabData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, IMContactTabData>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$1
            public IMContactTabData get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it;
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, IMContactTabData iMContactTabData2) {
                IMContactTabData it = iMContactTabData2;
                return it;
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super IMContactTabData, ? extends IMContactTabData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                return (IMContactTabData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMContactTabData, IMContactPageStatus> getStatus(IMContactTabData.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, IMContactPageStatus>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$2
            public IMContactPageStatus get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it.getStatus();
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, IMContactPageStatus iMContactPageStatus) {
                IMContactPageStatus status = iMContactPageStatus;
                IMContactTabData it = iMContactTabData;
                return IMContactTabData.copy$default(it, status, null, null, null, null, 30, null);
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super IMContactPageStatus, ? extends IMContactPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                IMContactPageStatus status = (IMContactPageStatus) function1.invoke(it.getStatus());
                IMContactTabData it2 = iMContactTabData;
                return IMContactTabData.copy$default(it2, status, null, null, null, null, 30, null);
            }
        };
    }

    public static final BSimpleLens<IMContactTabData, String> getName(IMContactTabData.Companion $this$name) {
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, String>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$3
            public String get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it.getName();
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, String str) {
                String name = str;
                IMContactTabData it = iMContactTabData;
                return IMContactTabData.copy$default(it, null, name, null, null, null, 29, null);
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                String name = (String) function1.invoke(it.getName());
                IMContactTabData it2 = iMContactTabData;
                return IMContactTabData.copy$default(it2, null, name, null, null, null, 29, null);
            }
        };
    }

    public static final BSimpleLens<IMContactTabData, KContactTabType> getCurrentTab(IMContactTabData.Companion $this$currentTab) {
        Intrinsics.checkNotNullParameter($this$currentTab, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, KContactTabType>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$4
            public KContactTabType get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it.getCurrentTab();
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, KContactTabType kContactTabType) {
                KContactTabType currentTab = kContactTabType;
                IMContactTabData it = iMContactTabData;
                return IMContactTabData.copy$default(it, null, null, currentTab, null, null, 27, null);
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super KContactTabType, ? extends KContactTabType> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                KContactTabType currentTab = (KContactTabType) function1.invoke(it.getCurrentTab());
                IMContactTabData it2 = iMContactTabData;
                return IMContactTabData.copy$default(it2, null, null, currentTab, null, null, 27, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMContactTabData, List<IMContactItem>> getContacts(IMContactTabData.Companion $this$contacts) {
        Intrinsics.checkNotNullParameter($this$contacts, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, List<? extends IMContactItem>>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$5
            public List<? extends IMContactItem> get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it.getContacts$contact_debug();
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, List<? extends IMContactItem> list) {
                List<? extends IMContactItem> contacts = list;
                IMContactTabData it = iMContactTabData;
                return IMContactTabData.copy$default(it, null, null, null, contacts, null, 23, null);
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super List<? extends IMContactItem>, ? extends List<? extends IMContactItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                List contacts = (List) function1.invoke(it.getContacts$contact_debug());
                IMContactTabData it2 = iMContactTabData;
                return IMContactTabData.copy$default(it2, null, null, null, contacts, null, 23, null);
            }
        };
    }

    public static final BSimpleLens<IMContactTabData, KPaginationParams> getPagingParams(IMContactTabData.Companion $this$pagingParams) {
        Intrinsics.checkNotNullParameter($this$pagingParams, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactTabData, KPaginationParams>() { // from class: im.contact.model.IMContactTabDataLensKt$special$$inlined$invoke$6
            public KPaginationParams get(IMContactTabData iMContactTabData) {
                IMContactTabData it = iMContactTabData;
                return it.getPagingParams$contact_debug();
            }

            public IMContactTabData set(IMContactTabData iMContactTabData, KPaginationParams kPaginationParams) {
                KPaginationParams pagingParams = kPaginationParams;
                IMContactTabData it = iMContactTabData;
                return IMContactTabData.copy$default(it, null, null, null, null, pagingParams, 15, null);
            }

            public IMContactTabData modify(IMContactTabData iMContactTabData, Function1<? super KPaginationParams, ? extends KPaginationParams> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactTabData it = iMContactTabData;
                KPaginationParams pagingParams = (KPaginationParams) function1.invoke(it.getPagingParams$contact_debug());
                IMContactTabData it2 = iMContactTabData;
                return IMContactTabData.copy$default(it2, null, null, null, null, pagingParams, 15, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, IMContactPageStatus> getStatus(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getName(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getName(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KContactTabType> getCurrentTab(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getCurrentTab(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMContactItem>> getContacts(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContacts(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPagingParams(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getPagingParams(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> statusNullable(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, String> nameNullable(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getName(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, KContactTabType> currentTabNullable(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getCurrentTab(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactItem>> contactsNullable(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContacts(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> pagingParamsNullable(BSimpleLens<T, IMContactTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getPagingParams(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> getStatus(BNullableLens<T, IMContactTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, String> getName(BNullableLens<T, IMContactTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getName(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, KContactTabType> getCurrentTab(BNullableLens<T, IMContactTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getCurrentTab(IMContactTabData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactItem>> getContacts(BNullableLens<T, IMContactTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContacts(IMContactTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPagingParams(BNullableLens<T, IMContactTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getPagingParams(IMContactTabData.Companion));
    }
}