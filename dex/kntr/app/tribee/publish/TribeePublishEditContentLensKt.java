package kntr.app.tribee.publish;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.tribee.publish.TribeePublishEditContent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishEditContentLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b¨\u0006\u001c"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/TribeePublishEditContent;", "Lkntr/app/tribee/publish/TribeePublishEditContent$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/TribeePublishEditContent$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/TribeePublishEditContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "getTribeeInfo$annotations", "getTribeeInfo", "contentId", "", "getContentId$annotations", "getContentId", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "tribeeInfoNullable$annotations", "tribeeInfoNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "contentIdNullable$annotations", "contentIdNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishEditContentLensKt {
    public static /* synthetic */ void contentIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContentId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContentId$annotations(TribeePublishEditContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TribeePublishEditContent.Companion companion) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTribeeInfo$annotations(TribeePublishEditContent.Companion companion) {
    }

    public static /* synthetic */ void tribeeInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TribeePublishEditContent, TribeePublishEditContent> getLens(TribeePublishEditContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishEditContent, TribeePublishEditContent>() { // from class: kntr.app.tribee.publish.TribeePublishEditContentLensKt$special$$inlined$invoke$1
            public TribeePublishEditContent get(TribeePublishEditContent tribeePublishEditContent) {
                TribeePublishEditContent it = tribeePublishEditContent;
                return it;
            }

            public TribeePublishEditContent set(TribeePublishEditContent tribeePublishEditContent, TribeePublishEditContent tribeePublishEditContent2) {
                TribeePublishEditContent it = tribeePublishEditContent2;
                return it;
            }

            public TribeePublishEditContent modify(TribeePublishEditContent tribeePublishEditContent, Function1<? super TribeePublishEditContent, ? extends TribeePublishEditContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishEditContent it = tribeePublishEditContent;
                return (TribeePublishEditContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeePublishEditContent, TribeeInfo> getTribeeInfo(TribeePublishEditContent.Companion $this$tribeeInfo) {
        Intrinsics.checkNotNullParameter($this$tribeeInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishEditContent, TribeeInfo>() { // from class: kntr.app.tribee.publish.TribeePublishEditContentLensKt$special$$inlined$invoke$2
            public TribeeInfo get(TribeePublishEditContent tribeePublishEditContent) {
                TribeePublishEditContent it = tribeePublishEditContent;
                return it.getTribeeInfo();
            }

            public TribeePublishEditContent set(TribeePublishEditContent tribeePublishEditContent, TribeeInfo tribeeInfo) {
                TribeeInfo tribeeInfo2 = tribeeInfo;
                TribeePublishEditContent it = tribeePublishEditContent;
                return TribeePublishEditContent.copy$default(it, tribeeInfo2, null, 2, null);
            }

            public TribeePublishEditContent modify(TribeePublishEditContent tribeePublishEditContent, Function1<? super TribeeInfo, ? extends TribeeInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishEditContent it = tribeePublishEditContent;
                TribeeInfo tribeeInfo = (TribeeInfo) function1.invoke(it.getTribeeInfo());
                TribeePublishEditContent it2 = tribeePublishEditContent;
                return TribeePublishEditContent.copy$default(it2, tribeeInfo, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<TribeePublishEditContent, String> getContentId(TribeePublishEditContent.Companion $this$contentId) {
        Intrinsics.checkNotNullParameter($this$contentId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishEditContent, String>() { // from class: kntr.app.tribee.publish.TribeePublishEditContentLensKt$special$$inlined$invoke$3
            public String get(TribeePublishEditContent tribeePublishEditContent) {
                TribeePublishEditContent it = tribeePublishEditContent;
                return it.getContentId();
            }

            public TribeePublishEditContent set(TribeePublishEditContent tribeePublishEditContent, String str) {
                String contentId = str;
                TribeePublishEditContent it = tribeePublishEditContent;
                return TribeePublishEditContent.copy$default(it, null, contentId, 1, null);
            }

            public TribeePublishEditContent modify(TribeePublishEditContent tribeePublishEditContent, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishEditContent it = tribeePublishEditContent;
                String contentId = (String) function1.invoke(it.getContentId());
                TribeePublishEditContent it2 = tribeePublishEditContent;
                return TribeePublishEditContent.copy$default(it2, null, contentId, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, TribeeInfo> getTribeeInfo(BSimpleLens<T, TribeePublishEditContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTribeeInfo(TribeePublishEditContent.Companion));
    }

    public static final <T> BSimpleLens<T, String> getContentId(BSimpleLens<T, TribeePublishEditContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContentId(TribeePublishEditContent.Companion));
    }

    public static final <T> BNullableLens<T, TribeeInfo> tribeeInfoNullable(BSimpleLens<T, TribeePublishEditContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTribeeInfo(TribeePublishEditContent.Companion));
    }

    public static final <T> BNullableLens<T, String> contentIdNullable(BSimpleLens<T, TribeePublishEditContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContentId(TribeePublishEditContent.Companion));
    }

    public static final <T> BNullableLens<T, TribeeInfo> getTribeeInfo(BNullableLens<T, TribeePublishEditContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTribeeInfo(TribeePublishEditContent.Companion));
    }

    public static final <T> BNullableLens<T, String> getContentId(BNullableLens<T, TribeePublishEditContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContentId(TribeePublishEditContent.Companion));
    }
}