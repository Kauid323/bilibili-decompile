package kntr.common.photonic.aphro.core;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.aphro.core.AphroState;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotAuthorizedLens.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000e\u001a\u0004\b\u000b\u0010\u000f\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u0010\u0012\u0004\u0012\u0002H\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0013\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\t0\u0010\"\b\b\u0000\u0010\f*\u00020\r*\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015¨\u0006\u0016"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized;", "Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/AphroState$NotAuthorized$Companion;)Lcom/bilibili/blens/BSimpleLens;", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getOption$annotations", "getOption", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "optionNullable$annotations", "optionNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NotAuthorizedLensKt {
    public static /* synthetic */ void getLens$annotations(AphroState.NotAuthorized.Companion companion) {
    }

    public static /* synthetic */ void getOption$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOption$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOption$annotations(AphroState.NotAuthorized.Companion companion) {
    }

    public static /* synthetic */ void optionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroState.NotAuthorized, AphroState.NotAuthorized> getLens(AphroState.NotAuthorized.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.NotAuthorized, AphroState.NotAuthorized>() { // from class: kntr.common.photonic.aphro.core.NotAuthorizedLensKt$special$$inlined$invoke$1
            public AphroState.NotAuthorized get(AphroState.NotAuthorized notAuthorized) {
                AphroState.NotAuthorized it = notAuthorized;
                return it;
            }

            public AphroState.NotAuthorized set(AphroState.NotAuthorized notAuthorized, AphroState.NotAuthorized notAuthorized2) {
                AphroState.NotAuthorized it = notAuthorized2;
                return it;
            }

            public AphroState.NotAuthorized modify(AphroState.NotAuthorized notAuthorized, Function1<? super AphroState.NotAuthorized, ? extends AphroState.NotAuthorized> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.NotAuthorized it = notAuthorized;
                return (AphroState.NotAuthorized) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroState.NotAuthorized, AphroSelectOption> getOption(AphroState.NotAuthorized.Companion $this$option) {
        Intrinsics.checkNotNullParameter($this$option, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.NotAuthorized, AphroSelectOption>() { // from class: kntr.common.photonic.aphro.core.NotAuthorizedLensKt$special$$inlined$invoke$2
            public AphroSelectOption get(AphroState.NotAuthorized notAuthorized) {
                AphroState.NotAuthorized it = notAuthorized;
                return it.getOption();
            }

            public AphroState.NotAuthorized set(AphroState.NotAuthorized notAuthorized, AphroSelectOption aphroSelectOption) {
                AphroSelectOption option = aphroSelectOption;
                AphroState.NotAuthorized it = notAuthorized;
                return it.copy(option);
            }

            public AphroState.NotAuthorized modify(AphroState.NotAuthorized notAuthorized, Function1<? super AphroSelectOption, ? extends AphroSelectOption> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.NotAuthorized it = notAuthorized;
                AphroSelectOption option = (AphroSelectOption) function1.invoke(it.getOption());
                AphroState.NotAuthorized it2 = notAuthorized;
                return it2.copy(option);
            }
        };
    }

    public static final <T> BSimpleLens<T, AphroSelectOption> getOption(BSimpleLens<T, AphroState.NotAuthorized> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOption(AphroState.NotAuthorized.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> optionNullable(BSimpleLens<T, AphroState.NotAuthorized> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOption(AphroState.NotAuthorized.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> getOption(BNullableLens<T, AphroState.NotAuthorized> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOption(AphroState.NotAuthorized.Companion));
    }
}