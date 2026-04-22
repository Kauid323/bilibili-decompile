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

/* compiled from: InitLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001f\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001f\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001f\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001b\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010&\u001a\u0004\b\u000b\u0010'\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010&\u001a\u0004\b\u000f\u0010'\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010&\u001a\u0004\b\u0013\u0010'\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010&\u001a\u0004\b\u0017\u0010(¨\u0006)"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/AphroState$Init;", "Lkntr/common/photonic/aphro/core/AphroState$Init$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/AphroState$Init$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/AphroState$Init$Companion;)Lcom/bilibili/blens/BSimpleLens;", "preSelected", "Lkntr/common/photonic/aphro/core/AphroSelection;", "getPreSelected$annotations", "getPreSelected", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getOption$annotations", "getOption", "requiredAssetCount", "", "getRequiredAssetCount$annotations", "getRequiredAssetCount", "initialAlbumId", "", "getInitialAlbumId$annotations", "getInitialAlbumId", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "preSelectedNullable$annotations", "preSelectedNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "optionNullable$annotations", "optionNullable", "requiredAssetCountNullable$annotations", "requiredAssetCountNullable", "initialAlbumIdNullable$annotations", "initialAlbumIdNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InitLensKt {
    public static /* synthetic */ void getInitialAlbumId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInitialAlbumId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInitialAlbumId$annotations(AphroState.Init.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroState.Init.Companion companion) {
    }

    public static /* synthetic */ void getOption$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOption$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOption$annotations(AphroState.Init.Companion companion) {
    }

    public static /* synthetic */ void getPreSelected$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPreSelected$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPreSelected$annotations(AphroState.Init.Companion companion) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(AphroState.Init.Companion companion) {
    }

    public static /* synthetic */ void initialAlbumIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void optionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void preSelectedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requiredAssetCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroState.Init, AphroState.Init> getLens(AphroState.Init.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.Init, AphroState.Init>() { // from class: kntr.common.photonic.aphro.core.InitLensKt$special$$inlined$invoke$1
            public AphroState.Init get(AphroState.Init init) {
                AphroState.Init it = init;
                return it;
            }

            public AphroState.Init set(AphroState.Init init, AphroState.Init init2) {
                AphroState.Init it = init2;
                return it;
            }

            public AphroState.Init modify(AphroState.Init init, Function1<? super AphroState.Init, ? extends AphroState.Init> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.Init it = init;
                return (AphroState.Init) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroState.Init, AphroSelection> getPreSelected(AphroState.Init.Companion $this$preSelected) {
        Intrinsics.checkNotNullParameter($this$preSelected, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.Init, AphroSelection>() { // from class: kntr.common.photonic.aphro.core.InitLensKt$special$$inlined$invoke$2
            public AphroSelection get(AphroState.Init init) {
                AphroState.Init it = init;
                return it.getPreSelected();
            }

            public AphroState.Init set(AphroState.Init init, AphroSelection aphroSelection) {
                AphroSelection preSelected = aphroSelection;
                AphroState.Init it = init;
                return AphroState.Init.copy$default(it, preSelected, null, 0, null, 14, null);
            }

            public AphroState.Init modify(AphroState.Init init, Function1<? super AphroSelection, ? extends AphroSelection> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.Init it = init;
                AphroSelection preSelected = (AphroSelection) function1.invoke(it.getPreSelected());
                AphroState.Init it2 = init;
                return AphroState.Init.copy$default(it2, preSelected, null, 0, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.Init, AphroSelectOption> getOption(AphroState.Init.Companion $this$option) {
        Intrinsics.checkNotNullParameter($this$option, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.Init, AphroSelectOption>() { // from class: kntr.common.photonic.aphro.core.InitLensKt$special$$inlined$invoke$3
            public AphroSelectOption get(AphroState.Init init) {
                AphroState.Init it = init;
                return it.getOption();
            }

            public AphroState.Init set(AphroState.Init init, AphroSelectOption aphroSelectOption) {
                AphroSelectOption option = aphroSelectOption;
                AphroState.Init it = init;
                return AphroState.Init.copy$default(it, null, option, 0, null, 13, null);
            }

            public AphroState.Init modify(AphroState.Init init, Function1<? super AphroSelectOption, ? extends AphroSelectOption> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.Init it = init;
                AphroSelectOption option = (AphroSelectOption) function1.invoke(it.getOption());
                AphroState.Init it2 = init;
                return AphroState.Init.copy$default(it2, null, option, 0, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.Init, Integer> getRequiredAssetCount(AphroState.Init.Companion $this$requiredAssetCount) {
        Intrinsics.checkNotNullParameter($this$requiredAssetCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.Init, Integer>() { // from class: kntr.common.photonic.aphro.core.InitLensKt$special$$inlined$invoke$4
            public Integer get(AphroState.Init init) {
                AphroState.Init it = init;
                return Integer.valueOf(it.getRequiredAssetCount());
            }

            public AphroState.Init set(AphroState.Init init, Integer num) {
                int requiredAssetCount = num.intValue();
                AphroState.Init it = init;
                return AphroState.Init.copy$default(it, null, null, requiredAssetCount, null, 11, null);
            }

            public AphroState.Init modify(AphroState.Init init, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.Init it = init;
                int requiredAssetCount = ((Number) function1.invoke(Integer.valueOf(it.getRequiredAssetCount()))).intValue();
                AphroState.Init it2 = init;
                return AphroState.Init.copy$default(it2, null, null, requiredAssetCount, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.Init, String> getInitialAlbumId(AphroState.Init.Companion $this$initialAlbumId) {
        Intrinsics.checkNotNullParameter($this$initialAlbumId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.Init, String>() { // from class: kntr.common.photonic.aphro.core.InitLensKt$special$$inlined$invoke$5
            public String get(AphroState.Init init) {
                AphroState.Init it = init;
                return it.getInitialAlbumId();
            }

            public AphroState.Init set(AphroState.Init init, String str) {
                String initialAlbumId = str;
                AphroState.Init it = init;
                return AphroState.Init.copy$default(it, null, null, 0, initialAlbumId, 7, null);
            }

            public AphroState.Init modify(AphroState.Init init, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.Init it = init;
                String initialAlbumId = (String) function1.invoke(it.getInitialAlbumId());
                AphroState.Init it2 = init;
                return AphroState.Init.copy$default(it2, null, null, 0, initialAlbumId, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, AphroSelection> getPreSelected(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPreSelected(AphroState.Init.Companion));
    }

    public static final <T> BSimpleLens<T, AphroSelectOption> getOption(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOption(AphroState.Init.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getRequiredAssetCount(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.Init.Companion));
    }

    public static final <T> BSimpleLens<T, String> getInitialAlbumId(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getInitialAlbumId(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelection> preSelectedNullable(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPreSelected(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> optionNullable(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOption(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, Integer> requiredAssetCountNullable(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.Init.Companion));
    }

    public static final <T> BSimpleLens<T, String> initialAlbumIdNullable(BSimpleLens<T, AphroState.Init> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getInitialAlbumId(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelection> getPreSelected(BNullableLens<T, AphroState.Init> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPreSelected(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> getOption(BNullableLens<T, AphroState.Init> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOption(AphroState.Init.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getRequiredAssetCount(BNullableLens<T, AphroState.Init> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequiredAssetCount(AphroState.Init.Companion));
    }

    public static final <T> BSimpleLens<T, String> getInitialAlbumId(BNullableLens<T, AphroState.Init> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getInitialAlbumId(AphroState.Init.Companion));
    }
}