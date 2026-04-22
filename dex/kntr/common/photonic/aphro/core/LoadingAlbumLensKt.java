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

/* compiled from: LoadingAlbumLens.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\",\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0007\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001b\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u001a\u001a\u0004\b\u0013\u0010\u001b\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u001a\u001a\u0004\b\u0017\u0010\u001b\"B\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001f\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001f\"B\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001f\"D\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001b\"@\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\t0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010&\u001a\u0004\b\u000b\u0010'\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\r0\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010&\u001a\u0004\b\u000f\u0010'\"@\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00110\u001c\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010&\u001a\u0004\b\u0013\u0010'\"B\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0001\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00020\u001c8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010&\u001a\u0004\b\u0017\u0010(¨\u0006)"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum;", "Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/AphroState$LoadingAlbum$Companion;)Lcom/bilibili/blens/BSimpleLens;", "preSelected", "Lkntr/common/photonic/aphro/core/AphroSelection;", "getPreSelected$annotations", "getPreSelected", WatchLaterReporterKt.KEY_OPTION, "Lkntr/common/photonic/aphro/core/AphroSelectOption;", "getOption$annotations", "getOption", "requiredAssetCount", "", "getRequiredAssetCount$annotations", "getRequiredAssetCount", "initialAlbumId", "", "getInitialAlbumId$annotations", "getInitialAlbumId", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "Lcom/bilibili/blens/BNullableLens;", "preSelectedNullable$annotations", "preSelectedNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "optionNullable$annotations", "optionNullable", "requiredAssetCountNullable$annotations", "requiredAssetCountNullable", "initialAlbumIdNullable$annotations", "initialAlbumIdNullable", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LoadingAlbumLensKt {
    public static /* synthetic */ void getInitialAlbumId$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getInitialAlbumId$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getInitialAlbumId$annotations(AphroState.LoadingAlbum.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroState.LoadingAlbum.Companion companion) {
    }

    public static /* synthetic */ void getOption$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getOption$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getOption$annotations(AphroState.LoadingAlbum.Companion companion) {
    }

    public static /* synthetic */ void getPreSelected$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getPreSelected$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getPreSelected$annotations(AphroState.LoadingAlbum.Companion companion) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(AphroState.LoadingAlbum.Companion companion) {
    }

    public static /* synthetic */ void initialAlbumIdNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void optionNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void preSelectedNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void requiredAssetCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroState.LoadingAlbum, AphroState.LoadingAlbum> getLens(AphroState.LoadingAlbum.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.LoadingAlbum, AphroState.LoadingAlbum>() { // from class: kntr.common.photonic.aphro.core.LoadingAlbumLensKt$special$$inlined$invoke$1
            public AphroState.LoadingAlbum get(AphroState.LoadingAlbum loadingAlbum) {
                AphroState.LoadingAlbum it = loadingAlbum;
                return it;
            }

            public AphroState.LoadingAlbum set(AphroState.LoadingAlbum loadingAlbum, AphroState.LoadingAlbum loadingAlbum2) {
                AphroState.LoadingAlbum it = loadingAlbum2;
                return it;
            }

            public AphroState.LoadingAlbum modify(AphroState.LoadingAlbum loadingAlbum, Function1<? super AphroState.LoadingAlbum, ? extends AphroState.LoadingAlbum> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.LoadingAlbum it = loadingAlbum;
                return (AphroState.LoadingAlbum) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroState.LoadingAlbum, AphroSelection> getPreSelected(AphroState.LoadingAlbum.Companion $this$preSelected) {
        Intrinsics.checkNotNullParameter($this$preSelected, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.LoadingAlbum, AphroSelection>() { // from class: kntr.common.photonic.aphro.core.LoadingAlbumLensKt$special$$inlined$invoke$2
            public AphroSelection get(AphroState.LoadingAlbum loadingAlbum) {
                AphroState.LoadingAlbum it = loadingAlbum;
                return it.getPreSelected();
            }

            public AphroState.LoadingAlbum set(AphroState.LoadingAlbum loadingAlbum, AphroSelection aphroSelection) {
                AphroSelection preSelected = aphroSelection;
                AphroState.LoadingAlbum it = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it, preSelected, null, 0, null, 14, null);
            }

            public AphroState.LoadingAlbum modify(AphroState.LoadingAlbum loadingAlbum, Function1<? super AphroSelection, ? extends AphroSelection> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.LoadingAlbum it = loadingAlbum;
                AphroSelection preSelected = (AphroSelection) function1.invoke(it.getPreSelected());
                AphroState.LoadingAlbum it2 = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it2, preSelected, null, 0, null, 14, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.LoadingAlbum, AphroSelectOption> getOption(AphroState.LoadingAlbum.Companion $this$option) {
        Intrinsics.checkNotNullParameter($this$option, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.LoadingAlbum, AphroSelectOption>() { // from class: kntr.common.photonic.aphro.core.LoadingAlbumLensKt$special$$inlined$invoke$3
            public AphroSelectOption get(AphroState.LoadingAlbum loadingAlbum) {
                AphroState.LoadingAlbum it = loadingAlbum;
                return it.getOption();
            }

            public AphroState.LoadingAlbum set(AphroState.LoadingAlbum loadingAlbum, AphroSelectOption aphroSelectOption) {
                AphroSelectOption option = aphroSelectOption;
                AphroState.LoadingAlbum it = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it, null, option, 0, null, 13, null);
            }

            public AphroState.LoadingAlbum modify(AphroState.LoadingAlbum loadingAlbum, Function1<? super AphroSelectOption, ? extends AphroSelectOption> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.LoadingAlbum it = loadingAlbum;
                AphroSelectOption option = (AphroSelectOption) function1.invoke(it.getOption());
                AphroState.LoadingAlbum it2 = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it2, null, option, 0, null, 13, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.LoadingAlbum, Integer> getRequiredAssetCount(AphroState.LoadingAlbum.Companion $this$requiredAssetCount) {
        Intrinsics.checkNotNullParameter($this$requiredAssetCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.LoadingAlbum, Integer>() { // from class: kntr.common.photonic.aphro.core.LoadingAlbumLensKt$special$$inlined$invoke$4
            public Integer get(AphroState.LoadingAlbum loadingAlbum) {
                AphroState.LoadingAlbum it = loadingAlbum;
                return Integer.valueOf(it.getRequiredAssetCount());
            }

            public AphroState.LoadingAlbum set(AphroState.LoadingAlbum loadingAlbum, Integer num) {
                int requiredAssetCount = num.intValue();
                AphroState.LoadingAlbum it = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it, null, null, requiredAssetCount, null, 11, null);
            }

            public AphroState.LoadingAlbum modify(AphroState.LoadingAlbum loadingAlbum, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.LoadingAlbum it = loadingAlbum;
                int requiredAssetCount = ((Number) function1.invoke(Integer.valueOf(it.getRequiredAssetCount()))).intValue();
                AphroState.LoadingAlbum it2 = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it2, null, null, requiredAssetCount, null, 11, null);
            }
        };
    }

    public static final BSimpleLens<AphroState.LoadingAlbum, String> getInitialAlbumId(AphroState.LoadingAlbum.Companion $this$initialAlbumId) {
        Intrinsics.checkNotNullParameter($this$initialAlbumId, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroState.LoadingAlbum, String>() { // from class: kntr.common.photonic.aphro.core.LoadingAlbumLensKt$special$$inlined$invoke$5
            public String get(AphroState.LoadingAlbum loadingAlbum) {
                AphroState.LoadingAlbum it = loadingAlbum;
                return it.getInitialAlbumId();
            }

            public AphroState.LoadingAlbum set(AphroState.LoadingAlbum loadingAlbum, String str) {
                String initialAlbumId = str;
                AphroState.LoadingAlbum it = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it, null, null, 0, initialAlbumId, 7, null);
            }

            public AphroState.LoadingAlbum modify(AphroState.LoadingAlbum loadingAlbum, Function1<? super String, ? extends String> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroState.LoadingAlbum it = loadingAlbum;
                String initialAlbumId = (String) function1.invoke(it.getInitialAlbumId());
                AphroState.LoadingAlbum it2 = loadingAlbum;
                return AphroState.LoadingAlbum.copy$default(it2, null, null, 0, initialAlbumId, 7, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, AphroSelection> getPreSelected(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getPreSelected(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BSimpleLens<T, AphroSelectOption> getOption(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getOption(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getRequiredAssetCount(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BSimpleLens<T, String> getInitialAlbumId(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getInitialAlbumId(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelection> preSelectedNullable(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getPreSelected(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> optionNullable(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getOption(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, Integer> requiredAssetCountNullable(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequiredAssetCount(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BSimpleLens<T, String> initialAlbumIdNullable(BSimpleLens<T, AphroState.LoadingAlbum> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getInitialAlbumId(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelection> getPreSelected(BNullableLens<T, AphroState.LoadingAlbum> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getPreSelected(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, AphroSelectOption> getOption(BNullableLens<T, AphroState.LoadingAlbum> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getOption(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getRequiredAssetCount(BNullableLens<T, AphroState.LoadingAlbum> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequiredAssetCount(AphroState.LoadingAlbum.Companion));
    }

    public static final <T> BSimpleLens<T, String> getInitialAlbumId(BNullableLens<T, AphroState.LoadingAlbum> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getInitialAlbumId(AphroState.LoadingAlbum.Companion));
    }
}