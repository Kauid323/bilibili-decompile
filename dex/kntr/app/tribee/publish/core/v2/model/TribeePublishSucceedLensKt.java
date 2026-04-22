package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.tribee.publish.core.v2.model.TribeePublishSucceed;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishSucceedLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0016"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSucceed;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishSucceed$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishSucceed$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishSucceed$Companion;)Lcom/bilibili/blens/BSimpleLens;", "content", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishContent;", "getContent$annotations", "getContent", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishSucceedLensKt {
    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(TribeePublishSucceed.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TribeePublishSucceed.Companion companion) {
    }

    public static final BSimpleLens<TribeePublishSucceed, TribeePublishSucceed> getLens(TribeePublishSucceed.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishSucceed, TribeePublishSucceed>() { // from class: kntr.app.tribee.publish.core.v2.model.TribeePublishSucceedLensKt$special$$inlined$invoke$1
            public TribeePublishSucceed get(TribeePublishSucceed tribeePublishSucceed) {
                TribeePublishSucceed it = tribeePublishSucceed;
                return it;
            }

            public TribeePublishSucceed set(TribeePublishSucceed tribeePublishSucceed, TribeePublishSucceed tribeePublishSucceed2) {
                TribeePublishSucceed it = tribeePublishSucceed2;
                return it;
            }

            public TribeePublishSucceed modify(TribeePublishSucceed tribeePublishSucceed, Function1<? super TribeePublishSucceed, ? extends TribeePublishSucceed> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishSucceed it = tribeePublishSucceed;
                return (TribeePublishSucceed) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeePublishSucceed, TribeePublishContent> getContent(TribeePublishSucceed.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishSucceed, TribeePublishContent>() { // from class: kntr.app.tribee.publish.core.v2.model.TribeePublishSucceedLensKt$special$$inlined$invoke$2
            public TribeePublishContent get(TribeePublishSucceed tribeePublishSucceed) {
                TribeePublishSucceed it = tribeePublishSucceed;
                return it.getContent();
            }

            public TribeePublishSucceed set(TribeePublishSucceed tribeePublishSucceed, TribeePublishContent tribeePublishContent) {
                TribeePublishContent content = tribeePublishContent;
                TribeePublishSucceed it = tribeePublishSucceed;
                return it.copy(content);
            }

            public TribeePublishSucceed modify(TribeePublishSucceed tribeePublishSucceed, Function1<? super TribeePublishContent, ? extends TribeePublishContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishSucceed it = tribeePublishSucceed;
                TribeePublishContent content = (TribeePublishContent) function1.invoke(it.getContent());
                TribeePublishSucceed it2 = tribeePublishSucceed;
                return it2.copy(content);
            }
        };
    }

    public static final <T> BSimpleLens<T, TribeePublishContent> getContent(BSimpleLens<T, TribeePublishSucceed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(TribeePublishSucceed.Companion));
    }

    public static final <T> BNullableLens<T, TribeePublishContent> contentNullable(BSimpleLens<T, TribeePublishSucceed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(TribeePublishSucceed.Companion));
    }

    public static final <T> BNullableLens<T, TribeePublishContent> getContent(BNullableLens<T, TribeePublishSucceed> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(TribeePublishSucceed.Companion));
    }
}