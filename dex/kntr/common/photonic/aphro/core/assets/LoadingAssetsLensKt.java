package kntr.common.photonic.aphro.core.assets;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingAssetsLens.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\u000b\u0010\u0013\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0012\u001a\u0004\b\u0015\u0010\u0013\"B\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0016\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u001a\u001a\u0004\b\u000b\u0010\u001b\"@\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\r0\u0016\"\b\b\u0000\u0010\u0010*\u00020\u0011*\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u000f\u0010\u001c¨\u0006\u001d"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$LoadingAssets$Companion;)Lcom/bilibili/blens/BSimpleLens;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "getAlbumInfo$annotations", "getAlbumInfo", "requiredAssetCount", "", "getRequiredAssetCount$annotations", "getRequiredAssetCount", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "albumInfoNullable$annotations", "albumInfoNullable", "Lcom/bilibili/blens/BNullableLens;", "requiredAssetCountNullable$annotations", "requiredAssetCountNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LoadingAssetsLensKt {
    public static /* synthetic */ void albumInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(AphroAssetsState.LoadingAssets.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroAssetsState.LoadingAssets.Companion companion) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getRequiredAssetCount$annotations(AphroAssetsState.LoadingAssets.Companion companion) {
    }

    public static /* synthetic */ void requiredAssetCountNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroAssetsState.LoadingAssets, AphroAssetsState.LoadingAssets> getLens(AphroAssetsState.LoadingAssets.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.LoadingAssets, AphroAssetsState.LoadingAssets>() { // from class: kntr.common.photonic.aphro.core.assets.LoadingAssetsLensKt$special$$inlined$invoke$1
            public AphroAssetsState.LoadingAssets get(AphroAssetsState.LoadingAssets loadingAssets) {
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return it;
            }

            public AphroAssetsState.LoadingAssets set(AphroAssetsState.LoadingAssets loadingAssets, AphroAssetsState.LoadingAssets loadingAssets2) {
                AphroAssetsState.LoadingAssets it = loadingAssets2;
                return it;
            }

            public AphroAssetsState.LoadingAssets modify(AphroAssetsState.LoadingAssets loadingAssets, Function1<? super AphroAssetsState.LoadingAssets, ? extends AphroAssetsState.LoadingAssets> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return (AphroAssetsState.LoadingAssets) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroAssetsState.LoadingAssets, AlbumInfo> getAlbumInfo(AphroAssetsState.LoadingAssets.Companion $this$albumInfo) {
        Intrinsics.checkNotNullParameter($this$albumInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.LoadingAssets, AlbumInfo>() { // from class: kntr.common.photonic.aphro.core.assets.LoadingAssetsLensKt$special$$inlined$invoke$2
            public AlbumInfo get(AphroAssetsState.LoadingAssets loadingAssets) {
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return it.getAlbumInfo();
            }

            public AphroAssetsState.LoadingAssets set(AphroAssetsState.LoadingAssets loadingAssets, AlbumInfo albumInfo) {
                AlbumInfo albumInfo2 = albumInfo;
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return AphroAssetsState.LoadingAssets.copy$default(it, albumInfo2, 0, 2, null);
            }

            public AphroAssetsState.LoadingAssets modify(AphroAssetsState.LoadingAssets loadingAssets, Function1<? super AlbumInfo, ? extends AlbumInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.LoadingAssets it = loadingAssets;
                AlbumInfo albumInfo = (AlbumInfo) function1.invoke(it.getAlbumInfo());
                AphroAssetsState.LoadingAssets it2 = loadingAssets;
                return AphroAssetsState.LoadingAssets.copy$default(it2, albumInfo, 0, 2, null);
            }
        };
    }

    public static final BSimpleLens<AphroAssetsState.LoadingAssets, Integer> getRequiredAssetCount(AphroAssetsState.LoadingAssets.Companion $this$requiredAssetCount) {
        Intrinsics.checkNotNullParameter($this$requiredAssetCount, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.LoadingAssets, Integer>() { // from class: kntr.common.photonic.aphro.core.assets.LoadingAssetsLensKt$special$$inlined$invoke$3
            public Integer get(AphroAssetsState.LoadingAssets loadingAssets) {
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return Integer.valueOf(it.getRequiredAssetCount());
            }

            public AphroAssetsState.LoadingAssets set(AphroAssetsState.LoadingAssets loadingAssets, Integer num) {
                int requiredAssetCount = num.intValue();
                AphroAssetsState.LoadingAssets it = loadingAssets;
                return AphroAssetsState.LoadingAssets.copy$default(it, null, requiredAssetCount, 1, null);
            }

            public AphroAssetsState.LoadingAssets modify(AphroAssetsState.LoadingAssets loadingAssets, Function1<? super Integer, ? extends Integer> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.LoadingAssets it = loadingAssets;
                int requiredAssetCount = ((Number) function1.invoke(Integer.valueOf(it.getRequiredAssetCount()))).intValue();
                AphroAssetsState.LoadingAssets it2 = loadingAssets;
                return AphroAssetsState.LoadingAssets.copy$default(it2, null, requiredAssetCount, 1, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getAlbumInfo(BSimpleLens<T, AphroAssetsState.LoadingAssets> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getAlbumInfo(AphroAssetsState.LoadingAssets.Companion));
    }

    public static final <T> BSimpleLens<T, Integer> getRequiredAssetCount(BSimpleLens<T, AphroAssetsState.LoadingAssets> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getRequiredAssetCount(AphroAssetsState.LoadingAssets.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> albumInfoNullable(BSimpleLens<T, AphroAssetsState.LoadingAssets> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getAlbumInfo(AphroAssetsState.LoadingAssets.Companion));
    }

    public static final <T> BNullableLens<T, Integer> requiredAssetCountNullable(BSimpleLens<T, AphroAssetsState.LoadingAssets> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getRequiredAssetCount(AphroAssetsState.LoadingAssets.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getAlbumInfo(BNullableLens<T, AphroAssetsState.LoadingAssets> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getAlbumInfo(AphroAssetsState.LoadingAssets.Companion));
    }

    public static final <T> BNullableLens<T, Integer> getRequiredAssetCount(BNullableLens<T, AphroAssetsState.LoadingAssets> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getRequiredAssetCount(AphroAssetsState.LoadingAssets.Companion));
    }
}