package kntr.app.tribee.publish.core.v2.model;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.tribee.publish.core.v2.model.TribeePublishClosing;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeePublishClosingLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u000f\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00128FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0013\u001a\u0004\b\u000b\u0010\u0014¨\u0006\u0015"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishClosing;", "Lkntr/app/tribee/publish/core/v2/model/TribeePublishClosing$Companion;", "getLens$annotations", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishClosing$Companion;)V", "getLens", "(Lkntr/app/tribee/publish/core/v2/model/TribeePublishClosing$Companion;)Lcom/bilibili/blens/BSimpleLens;", "toast", "", "getToast$annotations", "getToast", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "toastNullable$annotations", "toastNullable", "Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePublishClosingLensKt {
    public static /* synthetic */ void getLens$annotations(TribeePublishClosing.Companion companion) {
    }

    public static /* synthetic */ void getToast$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getToast$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getToast$annotations(TribeePublishClosing.Companion companion) {
    }

    public static /* synthetic */ void toastNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<TribeePublishClosing, TribeePublishClosing> getLens(TribeePublishClosing.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishClosing, TribeePublishClosing>() { // from class: kntr.app.tribee.publish.core.v2.model.TribeePublishClosingLensKt$special$$inlined$invoke$1
            public TribeePublishClosing get(TribeePublishClosing tribeePublishClosing) {
                TribeePublishClosing it = tribeePublishClosing;
                return it;
            }

            public TribeePublishClosing set(TribeePublishClosing tribeePublishClosing, TribeePublishClosing tribeePublishClosing2) {
                TribeePublishClosing it = tribeePublishClosing2;
                return it;
            }

            public TribeePublishClosing modify(TribeePublishClosing tribeePublishClosing, Function1<? super TribeePublishClosing, ? extends TribeePublishClosing> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishClosing it = tribeePublishClosing;
                return (TribeePublishClosing) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<TribeePublishClosing, String> getToast(TribeePublishClosing.Companion $this$toast) {
        Intrinsics.checkNotNullParameter($this$toast, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<TribeePublishClosing, String>() { // from class: kntr.app.tribee.publish.core.v2.model.TribeePublishClosingLensKt$special$$inlined$invoke$2
            public String get(TribeePublishClosing tribeePublishClosing) {
                TribeePublishClosing it = tribeePublishClosing;
                return it.getToast();
            }

            public TribeePublishClosing set(TribeePublishClosing tribeePublishClosing, String str) {
                String toast = str;
                TribeePublishClosing it = tribeePublishClosing;
                return it.copy(toast);
            }

            public TribeePublishClosing modify(TribeePublishClosing tribeePublishClosing, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                TribeePublishClosing it = tribeePublishClosing;
                String toast = (String) function1.invoke(it.getToast());
                TribeePublishClosing it2 = tribeePublishClosing;
                return it2.copy(toast);
            }
        };
    }

    public static final <T> BSimpleLens<T, String> getToast(BSimpleLens<T, TribeePublishClosing> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getToast(TribeePublishClosing.Companion));
    }

    public static final <T> BSimpleLens<T, String> toastNullable(BSimpleLens<T, TribeePublishClosing> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getToast(TribeePublishClosing.Companion));
    }

    public static final <T> BSimpleLens<T, String> getToast(BNullableLens<T, TribeePublishClosing> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getToast(TribeePublishClosing.Companion));
    }
}