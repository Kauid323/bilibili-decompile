package kntr.common.photonic.aphro.core.assets;

import com.bilibili.blens.BGetter;
import com.bilibili.blens.BNullableLens;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.OperatorKt;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.photonic.AlbumInfo;
import kntr.common.photonic.Asset;
import kntr.common.photonic.aphro.core.assets.AphroAssetsState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: AphroContentLens.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\"*\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\",\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"8\u0010\f\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r0\u0001*\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0005\u001a\u0004\b\u0011\u0010\u0007\"0\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0017\u001a\u0004\b\u000b\u0010\u0018\"N\u0010\f\u001a\u001c\u0012\u0004\u0012\u0002H\u0015\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"F\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u00018FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018\"D\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0018\"P\u0010\f\u001a\u001c\u0012\u0004\u0012\u0002H\u0015\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018AX\u0081\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0018\"H\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u001d\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010 \"B\u0010\b\u001a\u0010\u0012\u0004\u0012\u0002H\u0015\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010!\u001a\u0004\b\u000b\u0010\"\"N\u0010\f\u001a\u001c\u0012\u0004\u0012\u0002H\u0015\u0012\u0012\u0012\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\r0\u0001\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u001d8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010!\u001a\u0004\b\u0011\u0010\"\"F\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u001d\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u00020\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010!\u001a\u0004\b\u0014\u0010#¨\u0006$"}, d2 = {"lens", "Lcom/bilibili/blens/BSimpleLens;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent;", "Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent$Companion;", "getLens$annotations", "(Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent$Companion;)V", "getLens", "(Lkntr/common/photonic/aphro/core/assets/AphroAssetsState$AphroContent$Companion;)Lcom/bilibili/blens/BSimpleLens;", "albumInfo", "Lkntr/common/photonic/AlbumInfo;", "getAlbumInfo$annotations", "getAlbumInfo", "reader", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkntr/common/photonic/Asset;", "getReader$annotations", "getReader", "assetList", "getAssetList$annotations", "getAssetList", "T", "", "(Lcom/bilibili/blens/BSimpleLens;)V", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BSimpleLens;", "albumInfoNullable$annotations", "albumInfoNullable", "readerNullable$annotations", "readerNullable", "Lcom/bilibili/blens/BNullableLens;", "assetListNullable$annotations", "assetListNullable", "(Lcom/bilibili/blens/BSimpleLens;)Lcom/bilibili/blens/BNullableLens;", "(Lcom/bilibili/blens/BNullableLens;)V", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BSimpleLens;", "(Lcom/bilibili/blens/BNullableLens;)Lcom/bilibili/blens/BNullableLens;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AphroContentLensKt {
    public static /* synthetic */ void albumInfoNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void assetListNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAlbumInfo$annotations(AphroAssetsState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getAssetList$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getAssetList$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getAssetList$annotations(AphroAssetsState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getLens$annotations(AphroAssetsState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void getReader$annotations(BNullableLens bNullableLens) {
    }

    public static /* synthetic */ void getReader$annotations(BSimpleLens bSimpleLens) {
    }

    public static /* synthetic */ void getReader$annotations(AphroAssetsState.AphroContent.Companion companion) {
    }

    public static /* synthetic */ void readerNullable$annotations(BSimpleLens bSimpleLens) {
    }

    public static final BSimpleLens<AphroAssetsState.AphroContent, AphroAssetsState.AphroContent> getLens(AphroAssetsState.AphroContent.Companion $this$lens) {
        Intrinsics.checkNotNullParameter($this$lens, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.AphroContent, AphroAssetsState.AphroContent>() { // from class: kntr.common.photonic.aphro.core.assets.AphroContentLensKt$special$$inlined$invoke$1
            public AphroAssetsState.AphroContent get(AphroAssetsState.AphroContent aphroContent) {
                AphroAssetsState.AphroContent it = aphroContent;
                return it;
            }

            public AphroAssetsState.AphroContent set(AphroAssetsState.AphroContent aphroContent, AphroAssetsState.AphroContent aphroContent2) {
                AphroAssetsState.AphroContent it = aphroContent2;
                return it;
            }

            public AphroAssetsState.AphroContent modify(AphroAssetsState.AphroContent aphroContent, Function1<? super AphroAssetsState.AphroContent, ? extends AphroAssetsState.AphroContent> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.AphroContent it = aphroContent;
                return (AphroAssetsState.AphroContent) function1.invoke(it);
            }
        };
    }

    public static final BSimpleLens<AphroAssetsState.AphroContent, AlbumInfo> getAlbumInfo(AphroAssetsState.AphroContent.Companion $this$albumInfo) {
        Intrinsics.checkNotNullParameter($this$albumInfo, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.AphroContent, AlbumInfo>() { // from class: kntr.common.photonic.aphro.core.assets.AphroContentLensKt$special$$inlined$invoke$2
            public AlbumInfo get(AphroAssetsState.AphroContent aphroContent) {
                AphroAssetsState.AphroContent it = aphroContent;
                return it.getAlbumInfo();
            }

            public AphroAssetsState.AphroContent set(AphroAssetsState.AphroContent aphroContent, AlbumInfo albumInfo) {
                AlbumInfo albumInfo2 = albumInfo;
                AphroAssetsState.AphroContent it = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it, albumInfo2, null, null, 6, null);
            }

            public AphroAssetsState.AphroContent modify(AphroAssetsState.AphroContent aphroContent, Function1<? super AlbumInfo, ? extends AlbumInfo> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.AphroContent it = aphroContent;
                AlbumInfo albumInfo = (AlbumInfo) function1.invoke(it.getAlbumInfo());
                AphroAssetsState.AphroContent it2 = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it2, albumInfo, null, null, 6, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<AphroAssetsState.AphroContent, ReceiveChannel<List<Asset>>> getReader(AphroAssetsState.AphroContent.Companion $this$reader) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.AphroContent, ReceiveChannel<? extends List<? extends Asset>>>() { // from class: kntr.common.photonic.aphro.core.assets.AphroContentLensKt$special$$inlined$invoke$3
            public ReceiveChannel<? extends List<? extends Asset>> get(AphroAssetsState.AphroContent aphroContent) {
                AphroAssetsState.AphroContent it = aphroContent;
                return it.getReader$core_debug();
            }

            public AphroAssetsState.AphroContent set(AphroAssetsState.AphroContent aphroContent, ReceiveChannel<? extends List<? extends Asset>> receiveChannel) {
                ReceiveChannel<? extends List<? extends Asset>> reader = receiveChannel;
                AphroAssetsState.AphroContent it = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it, null, reader, null, 5, null);
            }

            public AphroAssetsState.AphroContent modify(AphroAssetsState.AphroContent aphroContent, Function1<? super ReceiveChannel<? extends List<? extends Asset>>, ? extends ReceiveChannel<? extends List<? extends Asset>>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.AphroContent it = aphroContent;
                ReceiveChannel reader = (ReceiveChannel) function1.invoke(it.getReader$core_debug());
                AphroAssetsState.AphroContent it2 = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it2, null, reader, null, 5, null);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final BSimpleLens<AphroAssetsState.AphroContent, List<Asset>> getAssetList(AphroAssetsState.AphroContent.Companion $this$assetList) {
        Intrinsics.checkNotNullParameter($this$assetList, "<this>");
        BSimpleLens.Companion companion = BSimpleLens.Companion;
        return new BSimpleLens<AphroAssetsState.AphroContent, List<? extends Asset>>() { // from class: kntr.common.photonic.aphro.core.assets.AphroContentLensKt$special$$inlined$invoke$4
            public List<? extends Asset> get(AphroAssetsState.AphroContent aphroContent) {
                AphroAssetsState.AphroContent it = aphroContent;
                return it.getAssetList();
            }

            public AphroAssetsState.AphroContent set(AphroAssetsState.AphroContent aphroContent, List<? extends Asset> list) {
                List<? extends Asset> assetList = list;
                AphroAssetsState.AphroContent it = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it, null, null, assetList, 3, null);
            }

            public AphroAssetsState.AphroContent modify(AphroAssetsState.AphroContent aphroContent, Function1<? super List<? extends Asset>, ? extends List<? extends Asset>> function1) {
                Intrinsics.checkNotNullParameter(function1, "map");
                AphroAssetsState.AphroContent it = aphroContent;
                List assetList = (List) function1.invoke(it.getAssetList());
                AphroAssetsState.AphroContent it2 = aphroContent;
                return AphroAssetsState.AphroContent.copy$default(it2, null, null, assetList, 3, null);
            }
        };
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getAlbumInfo(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getAlbumInfo(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ReceiveChannel<List<Asset>>> getReader(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bSimpleLens, getReader(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, List<Asset>> getAssetList(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.plus((BGetter) bSimpleLens, getAssetList(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> albumInfoNullable(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getAlbumInfo(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ReceiveChannel<List<Asset>>> readerNullable(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlusNullable((BGetter) bSimpleLens, getReader(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> assetListNullable(BSimpleLens<T, AphroAssetsState.AphroContent> bSimpleLens) {
        Intrinsics.checkNotNullParameter(bSimpleLens, "<this>");
        return OperatorKt.nullablePlus((BGetter) bSimpleLens, getAssetList(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, AlbumInfo> getAlbumInfo(BNullableLens<T, AphroAssetsState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getAlbumInfo(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BSimpleLens<T, ReceiveChannel<List<Asset>>> getReader(BNullableLens<T, AphroAssetsState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.nullablePlusNullable2((BGetter) bNullableLens, getReader(AphroAssetsState.AphroContent.Companion));
    }

    public static final <T> BNullableLens<T, List<Asset>> getAssetList(BNullableLens<T, AphroAssetsState.AphroContent> bNullableLens) {
        Intrinsics.checkNotNullParameter(bNullableLens, "<this>");
        return OperatorKt.plus((BGetter) bNullableLens, getAssetList(AphroAssetsState.AphroContent.Companion));
    }
}