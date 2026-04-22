package im.contact.model;

import com.bapis.bilibili.app.im.v1.KPaginationParams;
import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import im.contact.model.IMContactSearchingTabData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMContactSearchingTabDataLens.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"0\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\",\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0005\u001a\u0004\b\u001c\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001f\u001a\u0004\b\u000b\u0010 \"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001f\u001a\u0004\b\u000f\u0010 \"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u001f\u001a\u0004\b\u0013\u0010 \"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u001f\u001a\u0004\b\u0018\u0010 \"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u001f\u001a\u0004\b\u001c\u0010 \"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010$\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b'\u0010\u001f\u001a\u0004\b(\u0010$\"H\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010$\"D\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001f\u001a\u0004\b,\u0010 \"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\t0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\n\u0010-\u001a\u0004\b\u000b\u0010.\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\r0!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010-\u001a\u0004\b\u000f\u0010.\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00110!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010-\u001a\u0004\b\u0013\u0010.\"F\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150!\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010-\u001a\u0004\b\u0018\u0010.\"B\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u000e\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u00020\u00020!8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010-\u001a\u0004\b\u001c\u0010/¨\u00060"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lim/contact/model/IMContactSearchingTabData;", "Lim/contact/model/IMContactSearchingTabData$Companion;", "getLens$annotations", "(Lim/contact/model/IMContactSearchingTabData$Companion;)V", "getLens", "(Lim/contact/model/IMContactSearchingTabData$Companion;)Lcom/bilibili/blens/BSimpleLens;", "original", "Lim/contact/model/IMContactTabData;", "getOriginal$annotations", "getOriginal", "status", "Lim/contact/model/IMContactPageStatus;", "getStatus$annotations", "getStatus", "searchWord", "", "getSearchWord$annotations", "getSearchWord", "searchResult", "", "Lim/contact/model/IMContactItem;", "getSearchResult$annotations", "getSearchResult", "pagingParams", "Lcom/bapis/bilibili/app/im/v1/KPaginationParams;", "getPagingParams$annotations", "getPagingParams", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "originalNullable$annotations", "originalNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "statusNullable$annotations", "statusNullable", "searchWordNullable$annotations", "searchWordNullable", "searchResultNullable$annotations", "searchResultNullable", "pagingParamsNullable$annotations", "pagingParamsNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "contact_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMContactSearchingTabDataLensKt {
    public static /* synthetic */ void getLens$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void getOriginal$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOriginal$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOriginal$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void getPagingParams$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPagingParams$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPagingParams$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void getSearchResult$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSearchResult$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSearchResult$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void getSearchWord$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getSearchWord$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getSearchWord$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void getStatus$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getStatus$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getStatus$annotations(IMContactSearchingTabData.Companion companion) {
    }

    public static /* synthetic */ void originalNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void pagingParamsNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void searchResultNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void searchWordNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void statusNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<IMContactSearchingTabData, IMContactSearchingTabData> getLens(IMContactSearchingTabData.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, IMContactSearchingTabData>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$1
            public IMContactSearchingTabData get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it;
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, IMContactSearchingTabData iMContactSearchingTabData2) {
                IMContactSearchingTabData it = iMContactSearchingTabData2;
                return it;
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super IMContactSearchingTabData, ? extends IMContactSearchingTabData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return (IMContactSearchingTabData) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<IMContactSearchingTabData, IMContactTabData> getOriginal(IMContactSearchingTabData.Companion $this$original) {
        Intrinsics.checkNotNullParameter($this$original, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, IMContactTabData>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$2
            public IMContactTabData get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it.getOriginal$contact_debug();
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, IMContactTabData iMContactTabData) {
                IMContactTabData original = iMContactTabData;
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it, original, null, null, null, null, 30, null);
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super IMContactTabData, ? extends IMContactTabData> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                IMContactTabData original = (IMContactTabData) function1.invoke(it.getOriginal$contact_debug());
                IMContactSearchingTabData it2 = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it2, original, null, null, null, null, 30, null);
            }
        };
    }

    public static final BSimpleLens<IMContactSearchingTabData, IMContactPageStatus> getStatus(IMContactSearchingTabData.Companion $this$status) {
        Intrinsics.checkNotNullParameter($this$status, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, IMContactPageStatus>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$3
            public IMContactPageStatus get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it.getStatus();
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, IMContactPageStatus iMContactPageStatus) {
                IMContactPageStatus status = iMContactPageStatus;
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it, null, status, null, null, null, 29, null);
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super IMContactPageStatus, ? extends IMContactPageStatus> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                IMContactPageStatus status = (IMContactPageStatus) function1.invoke(it.getStatus());
                IMContactSearchingTabData it2 = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it2, null, status, null, null, null, 29, null);
            }
        };
    }

    public static final BSimpleLens<IMContactSearchingTabData, String> getSearchWord(IMContactSearchingTabData.Companion $this$searchWord) {
        Intrinsics.checkNotNullParameter($this$searchWord, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, String>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$4
            public String get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it.getSearchWord();
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, String str) {
                String searchWord = str;
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it, null, null, searchWord, null, null, 27, null);
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                String searchWord = (String) function1.invoke(it.getSearchWord());
                IMContactSearchingTabData it2 = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it2, null, null, searchWord, null, null, 27, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<IMContactSearchingTabData, List<IMContactItem>> getSearchResult(IMContactSearchingTabData.Companion $this$searchResult) {
        Intrinsics.checkNotNullParameter($this$searchResult, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, List<? extends IMContactItem>>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$5
            public List<? extends IMContactItem> get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it.getSearchResult$contact_debug();
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, List<? extends IMContactItem> list) {
                List<? extends IMContactItem> searchResult = list;
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it, null, null, null, searchResult, null, 23, null);
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super List<? extends IMContactItem>, ? extends List<? extends IMContactItem>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                List searchResult = (List) function1.invoke(it.getSearchResult$contact_debug());
                IMContactSearchingTabData it2 = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it2, null, null, null, searchResult, null, 23, null);
            }
        };
    }

    public static final BSimpleLens<IMContactSearchingTabData, KPaginationParams> getPagingParams(IMContactSearchingTabData.Companion $this$pagingParams) {
        Intrinsics.checkNotNullParameter($this$pagingParams, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<IMContactSearchingTabData, KPaginationParams>() { // from class: im.contact.model.IMContactSearchingTabDataLensKt$special$$inlined$invoke$6
            public KPaginationParams get(IMContactSearchingTabData iMContactSearchingTabData) {
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return it.getPagingParams$contact_debug();
            }

            public IMContactSearchingTabData set(IMContactSearchingTabData iMContactSearchingTabData, KPaginationParams kPaginationParams) {
                KPaginationParams pagingParams = kPaginationParams;
                IMContactSearchingTabData it = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it, null, null, null, null, pagingParams, 15, null);
            }

            public IMContactSearchingTabData modify(IMContactSearchingTabData iMContactSearchingTabData, Function1<? super KPaginationParams, ? extends KPaginationParams> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                IMContactSearchingTabData it = iMContactSearchingTabData;
                KPaginationParams pagingParams = (KPaginationParams) function1.invoke(it.getPagingParams$contact_debug());
                IMContactSearchingTabData it2 = iMContactSearchingTabData;
                return IMContactSearchingTabData.copy$default(it2, null, null, null, null, pagingParams, 15, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, IMContactTabData> getOriginal(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOriginal(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, IMContactPageStatus> getStatus(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getStatus(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, String> getSearchWord(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSearchWord(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, List<IMContactItem>> getSearchResult(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getSearchResult(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPagingParams(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getPagingParams(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactTabData> originalNullable(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOriginal(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> statusNullable(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getStatus(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, String> searchWordNullable(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSearchWord(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactItem>> searchResultNullable(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getSearchResult(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> pagingParamsNullable(BSimpleLens<T, IMContactSearchingTabData> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getPagingParams(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactTabData> getOriginal(BNullableLens<T, IMContactSearchingTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOriginal(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, IMContactPageStatus> getStatus(BNullableLens<T, IMContactSearchingTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getStatus(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, String> getSearchWord(BNullableLens<T, IMContactSearchingTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSearchWord(IMContactSearchingTabData.Companion));
    }

    public static final <T> BNullableLens<T, List<IMContactItem>> getSearchResult(BNullableLens<T, IMContactSearchingTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getSearchResult(IMContactSearchingTabData.Companion));
    }

    public static final <T> BSimpleLens<T, KPaginationParams> getPagingParams(BNullableLens<T, IMContactSearchingTabData> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getPagingParams(IMContactSearchingTabData.Companion));
    }
}