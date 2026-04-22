package kntr.app.tribee.publish;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.tribee.publish.TribeePublishFailed;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishFailedLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\",\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017\"D\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\t0\u0014\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"B\u0010\f\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00148FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/TribeePublishFailed;", "Lkntr/app/tribee/publish/TribeePublishFailed$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/TribeePublishFailed$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/TribeePublishFailed$Companion;)Lcom/bilibili/blens/BSimpleLens;", "content", "Lkntr/app/tribee/publish/TribeePublishContent;", "getContent$annotations", "getContent", "error", "", "getError$annotations", "getError", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "contentNullable$annotations", "contentNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "errorNullable$annotations", "errorNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishFailedLensKt {
    public static /* synthetic */ void contentNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void errorNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getContent$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getContent$annotations(TribeePublishFailed.Companion companion) {
    }

    public static /* synthetic */ void getError$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getError$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getError$annotations(TribeePublishFailed.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(TribeePublishFailed.Companion companion) {
    }

    public static final BSimpleLens<TribeePublishFailed, TribeePublishFailed> getLens(TribeePublishFailed.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishFailed, TribeePublishFailed>() { // from class: kntr.app.tribee.publish.TribeePublishFailedLensKt$special$$inlined$invoke$1
            public TribeePublishFailed get(TribeePublishFailed tribeePublishFailed) {
                TribeePublishFailed it = tribeePublishFailed;
                return it;
            }

            public TribeePublishFailed set(TribeePublishFailed tribeePublishFailed, TribeePublishFailed tribeePublishFailed2) {
                TribeePublishFailed it = tribeePublishFailed2;
                return it;
            }

            public TribeePublishFailed modify(TribeePublishFailed tribeePublishFailed, Function1<? super TribeePublishFailed, ? extends TribeePublishFailed> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishFailed it = tribeePublishFailed;
                return (TribeePublishFailed) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeePublishFailed, TribeePublishContent> getContent(TribeePublishFailed.Companion $this$content) {
        Intrinsics.checkNotNullParameter($this$content, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishFailed, TribeePublishContent>() { // from class: kntr.app.tribee.publish.TribeePublishFailedLensKt$special$$inlined$invoke$2
            public TribeePublishContent get(TribeePublishFailed tribeePublishFailed) {
                TribeePublishFailed it = tribeePublishFailed;
                return it.getContent();
            }

            public TribeePublishFailed set(TribeePublishFailed tribeePublishFailed, TribeePublishContent tribeePublishContent) {
                TribeePublishContent content = tribeePublishContent;
                TribeePublishFailed it = tribeePublishFailed;
                return TribeePublishFailed.copy$default(it, content, null, 2, null);
            }

            public TribeePublishFailed modify(TribeePublishFailed tribeePublishFailed, Function1<? super TribeePublishContent, ? extends TribeePublishContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishFailed it = tribeePublishFailed;
                TribeePublishContent content = (TribeePublishContent) function1.invoke(it.getContent());
                TribeePublishFailed it2 = tribeePublishFailed;
                return TribeePublishFailed.copy$default(it2, content, null, 2, null);
            }
        };
    }

    public static final BSimpleLens<TribeePublishFailed, Throwable> getError(TribeePublishFailed.Companion $this$error) {
        Intrinsics.checkNotNullParameter($this$error, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishFailed, Throwable>() { // from class: kntr.app.tribee.publish.TribeePublishFailedLensKt$special$$inlined$invoke$3
            public Throwable get(TribeePublishFailed tribeePublishFailed) {
                TribeePublishFailed it = tribeePublishFailed;
                return it.getError();
            }

            public TribeePublishFailed set(TribeePublishFailed tribeePublishFailed, Throwable th) {
                Throwable error = th;
                TribeePublishFailed it = tribeePublishFailed;
                return TribeePublishFailed.copy$default(it, null, error, 1, null);
            }

            public TribeePublishFailed modify(TribeePublishFailed tribeePublishFailed, Function1<? super Throwable, ? extends Throwable> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishFailed it = tribeePublishFailed;
                Throwable error = (Throwable) function1.invoke(it.getError());
                TribeePublishFailed it2 = tribeePublishFailed;
                return TribeePublishFailed.copy$default(it2, null, error, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, TribeePublishContent> getContent(BSimpleLens<T, TribeePublishFailed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getContent(TribeePublishFailed.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getError(BSimpleLens<T, TribeePublishFailed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getError(TribeePublishFailed.Companion));
    }

    public static final <T> BNullableLens<T, TribeePublishContent> contentNullable(BSimpleLens<T, TribeePublishFailed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getContent(TribeePublishFailed.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> errorNullable(BSimpleLens<T, TribeePublishFailed> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getError(TribeePublishFailed.Companion));
    }

    public static final <T> BNullableLens<T, TribeePublishContent> getContent(BNullableLens<T, TribeePublishFailed> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getContent(TribeePublishFailed.Companion));
    }

    public static final <T> BSimpleLens<T, Throwable> getError(BNullableLens<T, TribeePublishFailed> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getError(TribeePublishFailed.Companion));
    }
}