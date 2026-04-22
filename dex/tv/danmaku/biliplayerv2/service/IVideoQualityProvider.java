package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IVideoPlayDirectorService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideoQualityProvider;", "", "getExpectedQuality", "", "from", "Ltv/danmaku/biliplayerv2/service/IVideoQualityProvider$ResolveFrom;", "getRecommendStartQualityRange", "", "ResolveFrom", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IVideoQualityProvider {

    /* compiled from: IVideoPlayDirectorService.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/IVideoQualityProvider$ResolveFrom;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL_PLAY", "UPDATE_MEDIA_RESOURCE", "RELOAD", "ASSET_ITEM_UPDATE", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ResolveFrom {
        NORMAL_PLAY,
        UPDATE_MEDIA_RESOURCE,
        RELOAD,
        ASSET_ITEM_UPDATE;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ResolveFrom> getEntries() {
            return $ENTRIES;
        }
    }

    int getExpectedQuality(ResolveFrom resolveFrom);

    int[] getRecommendStartQualityRange();

    /* compiled from: IVideoPlayDirectorService.kt */
    /* renamed from: tv.danmaku.biliplayerv2.service.IVideoQualityProvider$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        public static int[] $default$getRecommendStartQualityRange(IVideoQualityProvider _this) {
            return null;
        }
    }
}