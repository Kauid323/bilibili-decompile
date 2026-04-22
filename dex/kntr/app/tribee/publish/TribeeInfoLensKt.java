package kntr.app.tribee.publish;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeInfoLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0017\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b¨\u0006\u001c"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/TribeeInfo;", "Lkntr/app/tribee/publish/TribeeInfo$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/TribeeInfo$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/TribeeInfo$Companion;)Lcom/bilibili/blens/BSimpleLens;", "tribeeId", "", "getTribeeId$annotations", "getTribeeId", "title", "", "getTitle$annotations", "getTitle", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "tribeeIdNullable$annotations", "tribeeIdNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "titleNullable$annotations", "titleNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeInfoLensKt {
    public static /* synthetic */ void getLens$annotations(TribeeInfo.Companion companion) {
    }

    public static /* synthetic */ void getTitle$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTitle$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTitle$annotations(TribeeInfo.Companion companion) {
    }

    public static /* synthetic */ void getTribeeId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getTribeeId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getTribeeId$annotations(TribeeInfo.Companion companion) {
    }

    public static /* synthetic */ void titleNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void tribeeIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TribeeInfo, TribeeInfo> getLens(TribeeInfo.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeeInfo, TribeeInfo>() { // from class: kntr.app.tribee.publish.TribeeInfoLensKt$special$$inlined$invoke$1
            public TribeeInfo get(TribeeInfo tribeeInfo) {
                TribeeInfo it = tribeeInfo;
                return it;
            }

            public TribeeInfo set(TribeeInfo tribeeInfo, TribeeInfo tribeeInfo2) {
                TribeeInfo it = tribeeInfo2;
                return it;
            }

            public TribeeInfo modify(TribeeInfo tribeeInfo, Function1<? super TribeeInfo, ? extends TribeeInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeeInfo it = tribeeInfo;
                return (TribeeInfo) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeeInfo, Long> getTribeeId(TribeeInfo.Companion $this$tribeeId) {
        Intrinsics.checkNotNullParameter($this$tribeeId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeeInfo, Long>() { // from class: kntr.app.tribee.publish.TribeeInfoLensKt$special$$inlined$invoke$2
            public Long get(TribeeInfo tribeeInfo) {
                TribeeInfo it = tribeeInfo;
                return Long.valueOf(it.getTribeeId());
            }

            public TribeeInfo set(TribeeInfo tribeeInfo, Long l) {
                long tribeeId = l.longValue();
                TribeeInfo it = tribeeInfo;
                return TribeeInfo.copy$default(it, tribeeId, null, 2, null);
            }

            public TribeeInfo modify(TribeeInfo tribeeInfo, Function1<? super Long, ? extends Long> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeeInfo it = tribeeInfo;
                long tribeeId = ((Number) function1.invoke(Long.valueOf(it.getTribeeId()))).longValue();
                TribeeInfo it2 = tribeeInfo;
                return TribeeInfo.copy$default(it2, tribeeId, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<TribeeInfo, String> getTitle(TribeeInfo.Companion $this$title) {
        Intrinsics.checkNotNullParameter($this$title, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeeInfo, String>() { // from class: kntr.app.tribee.publish.TribeeInfoLensKt$special$$inlined$invoke$3
            public String get(TribeeInfo tribeeInfo) {
                TribeeInfo it = tribeeInfo;
                return it.getTitle();
            }

            public TribeeInfo set(TribeeInfo tribeeInfo, String str) {
                String title = str;
                TribeeInfo it = tribeeInfo;
                return TribeeInfo.copy$default(it, 0L, title, 1, null);
            }

            public TribeeInfo modify(TribeeInfo tribeeInfo, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeeInfo it = tribeeInfo;
                String title = (String) function1.invoke(it.getTitle());
                TribeeInfo it2 = tribeeInfo;
                return TribeeInfo.copy$default(it2, 0L, title, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, Long> getTribeeId(BSimpleLens<T, TribeeInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTribeeId(TribeeInfo.Companion));
    }

    public static final <T> BSimpleLens<T, String> getTitle(BSimpleLens<T, TribeeInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getTitle(TribeeInfo.Companion));
    }

    public static final <T> BNullableLens<T, Long> tribeeIdNullable(BSimpleLens<T, TribeeInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTribeeId(TribeeInfo.Companion));
    }

    public static final <T> BNullableLens<T, String> titleNullable(BSimpleLens<T, TribeeInfo> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getTitle(TribeeInfo.Companion));
    }

    public static final <T> BNullableLens<T, Long> getTribeeId(BNullableLens<T, TribeeInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTribeeId(TribeeInfo.Companion));
    }

    public static final <T> BNullableLens<T, String> getTitle(BNullableLens<T, TribeeInfo> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getTitle(TribeeInfo.Companion));
    }
}