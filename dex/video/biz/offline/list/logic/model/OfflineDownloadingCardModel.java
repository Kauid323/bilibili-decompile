package video.biz.offline.list.logic.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import java.util.List;
import kntr.base.reachability.KReachabilityKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.utils.VBNumberExtKt;
import video.biz.offline.base.infra.utils.Config;
import video.biz.offline.base.infra.utils.EntryScannerKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;
import video.biz.offline.base.model.error.DownloadErrorType;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.base.model.error.OfflineErrorType;
import video.interfacee.bridge.freeBandwidth.KFreeBandwidthKt;

/* compiled from: OfflineCacheCardModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\t\u0010A\u001a\u00020\u000eHÆ\u0003J\t\u0010B\u001a\u00020\u000eHÆ\u0003J\t\u0010C\u001a\u00020\u0011HÆ\u0003J\t\u0010D\u001a\u00020\u0013HÆ\u0003J\t\u0010E\u001a\u00020\u0011HÆ\u0003J\u0083\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0011HÆ\u0001J\u0013\u0010G\u001a\u00020\u00112\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\fHÖ\u0001J\t\u0010J\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b)\u0010&R\u001b\u0010*\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b+\u0010\u0018R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0011\u00100\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b0\u0010&R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0018R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\f08X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\f08X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lvideo/biz/offline/list/logic/model/OfflineDownloadingCardModel;", "", "key", "", "coverUrl", "cardTag", "Lvideo/biz/offline/list/logic/model/CardTag;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "pageTitle", "state", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "errorCode", "", "totalSize", "", "downloadedSize", "selected", "", "bizType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "canPlay", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/list/logic/model/CardTag;Ljava/lang/String;Ljava/lang/String;Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;IJJZLvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;Z)V", "getKey", "()Ljava/lang/String;", "getCoverUrl", "getCardTag", "()Lvideo/biz/offline/list/logic/model/CardTag;", "getTitle", "getPageTitle", "getState", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$State;", "getErrorCode", "()I", "getTotalSize", "()J", "getDownloadedSize", "getSelected", "()Z", "getBizType", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "getCanPlay", "totalSizeDesc", "getTotalSizeDesc", "totalSizeDesc$delegate", "Lkotlin/Lazy;", "stateDesc", "getStateDesc", "isDownloading", "downloadProgress", "", "getDownloadProgress", "()F", "errorDesc", "getErrorDesc", "noSpaceList", "", "needDeleteList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineDownloadingCardModel {
    public static final int $stable = 8;
    private final OfflineVideoEntity.BizType bizType;
    private final boolean canPlay;
    private final CardTag cardTag;
    private final String coverUrl;
    private final long downloadedSize;
    private final int errorCode;
    private final String key;
    private final List<Integer> needDeleteList;
    private final List<Integer> noSpaceList;
    private final String pageTitle;
    private final boolean selected;
    private final OfflineVideoEntity.State state;
    private final String title;
    private final long totalSize;
    private final Lazy totalSizeDesc$delegate;

    /* compiled from: OfflineCacheCardModel.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DownloadErrorType.values().length];
            try {
                iArr[DownloadErrorType.NETWORK_DISCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DownloadErrorType.ADDRESS_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DownloadErrorType.STORAGE_SPACE_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DownloadErrorType.NOT_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DownloadErrorType.TOO_LARGE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DownloadErrorType.PLAYVIEW_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OfflineErrorType.values().length];
            try {
                iArr2[OfflineErrorType.BANDWIDTH_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr2[OfflineErrorType.DOWNLOAD_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final String component1() {
        return this.key;
    }

    public final boolean component10() {
        return this.selected;
    }

    public final OfflineVideoEntity.BizType component11() {
        return this.bizType;
    }

    public final boolean component12() {
        return this.canPlay;
    }

    public final String component2() {
        return this.coverUrl;
    }

    public final CardTag component3() {
        return this.cardTag;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.pageTitle;
    }

    public final OfflineVideoEntity.State component6() {
        return this.state;
    }

    public final int component7() {
        return this.errorCode;
    }

    public final long component8() {
        return this.totalSize;
    }

    public final long component9() {
        return this.downloadedSize;
    }

    public final OfflineDownloadingCardModel copy(String str, String str2, CardTag cardTag, String str3, String str4, OfflineVideoEntity.State state, int i, long j, long j2, boolean z, OfflineVideoEntity.BizType bizType, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "coverUrl");
        Intrinsics.checkNotNullParameter(cardTag, "cardTag");
        Intrinsics.checkNotNullParameter(str3, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        return new OfflineDownloadingCardModel(str, str2, cardTag, str3, str4, state, i, j, j2, z, bizType, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineDownloadingCardModel) {
            OfflineDownloadingCardModel offlineDownloadingCardModel = (OfflineDownloadingCardModel) obj;
            return Intrinsics.areEqual(this.key, offlineDownloadingCardModel.key) && Intrinsics.areEqual(this.coverUrl, offlineDownloadingCardModel.coverUrl) && this.cardTag == offlineDownloadingCardModel.cardTag && Intrinsics.areEqual(this.title, offlineDownloadingCardModel.title) && Intrinsics.areEqual(this.pageTitle, offlineDownloadingCardModel.pageTitle) && Intrinsics.areEqual(this.state, offlineDownloadingCardModel.state) && this.errorCode == offlineDownloadingCardModel.errorCode && this.totalSize == offlineDownloadingCardModel.totalSize && this.downloadedSize == offlineDownloadingCardModel.downloadedSize && this.selected == offlineDownloadingCardModel.selected && this.bizType == offlineDownloadingCardModel.bizType && this.canPlay == offlineDownloadingCardModel.canPlay;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.key.hashCode() * 31) + this.coverUrl.hashCode()) * 31) + this.cardTag.hashCode()) * 31) + this.title.hashCode()) * 31) + (this.pageTitle == null ? 0 : this.pageTitle.hashCode())) * 31) + this.state.hashCode()) * 31) + this.errorCode) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.totalSize)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.downloadedSize)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.selected)) * 31) + this.bizType.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.canPlay);
    }

    public String toString() {
        String str = this.key;
        String str2 = this.coverUrl;
        CardTag cardTag = this.cardTag;
        String str3 = this.title;
        String str4 = this.pageTitle;
        OfflineVideoEntity.State state = this.state;
        int i = this.errorCode;
        long j = this.totalSize;
        long j2 = this.downloadedSize;
        boolean z = this.selected;
        OfflineVideoEntity.BizType bizType = this.bizType;
        return "OfflineDownloadingCardModel(key=" + str + ", coverUrl=" + str2 + ", cardTag=" + cardTag + ", title=" + str3 + ", pageTitle=" + str4 + ", state=" + state + ", errorCode=" + i + ", totalSize=" + j + ", downloadedSize=" + j2 + ", selected=" + z + ", bizType=" + bizType + ", canPlay=" + this.canPlay + ")";
    }

    public OfflineDownloadingCardModel(String key, String coverUrl, CardTag cardTag, String title, String pageTitle, OfflineVideoEntity.State state, int errorCode, long totalSize, long downloadedSize, boolean selected, OfflineVideoEntity.BizType bizType, boolean canPlay) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(cardTag, "cardTag");
        Intrinsics.checkNotNullParameter(title, RankRouter.BundleKey.ACTION_PARAM_TITLE);
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        this.key = key;
        this.coverUrl = coverUrl;
        this.cardTag = cardTag;
        this.title = title;
        this.pageTitle = pageTitle;
        this.state = state;
        this.errorCode = errorCode;
        this.totalSize = totalSize;
        this.downloadedSize = downloadedSize;
        this.selected = selected;
        this.bizType = bizType;
        this.canPlay = canPlay;
        this.totalSizeDesc$delegate = LazyKt.lazy(new Function0() { // from class: video.biz.offline.list.logic.model.OfflineDownloadingCardModel$$ExternalSyntheticLambda0
            public final Object invoke() {
                String str;
                str = OfflineDownloadingCardModel.totalSizeDesc_delegate$lambda$0(OfflineDownloadingCardModel.this);
                return str;
            }
        });
        this.noSpaceList = CollectionsKt.listOf(new Integer[]{100005, 606});
        this.needDeleteList = CollectionsKt.listOf(new Integer[]{100010, 100011, 100012, 605});
    }

    public /* synthetic */ OfflineDownloadingCardModel(String str, String str2, CardTag cardTag, String str3, String str4, OfflineVideoEntity.State state, int i, long j, long j2, boolean z, OfflineVideoEntity.BizType bizType, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? CardTag.NONE : cardTag, str3, (i2 & 16) != 0 ? null : str4, state, i, j, j2, (i2 & 512) != 0 ? false : z, bizType, z2);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final CardTag getCardTag() {
        return this.cardTag;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final OfflineVideoEntity.State getState() {
        return this.state;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final long getTotalSize() {
        return this.totalSize;
    }

    public final long getDownloadedSize() {
        return this.downloadedSize;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final OfflineVideoEntity.BizType getBizType() {
        return this.bizType;
    }

    public final boolean getCanPlay() {
        return this.canPlay;
    }

    public final String getTotalSizeDesc() {
        return (String) this.totalSizeDesc$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String totalSizeDesc_delegate$lambda$0(OfflineDownloadingCardModel this$0) {
        return VBNumberExtKt.toFileSize(this$0.totalSize);
    }

    public final String getStateDesc() {
        OfflineVideoEntity.State state = this.state;
        if (Intrinsics.areEqual(state, OfflineVideoEntity.State.IDLE.INSTANCE)) {
            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2229(PlayerbaseresRes.INSTANCE.getString()));
        }
        if (state instanceof OfflineVideoEntity.State.PAUSED) {
            return PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1345(PlayerbaseresRes.INSTANCE.getString()));
        }
        if (Intrinsics.areEqual(state, OfflineVideoEntity.State.PENDING.INSTANCE)) {
            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2162(PlayerbaseresRes.INSTANCE.getString()));
        }
        if (Intrinsics.areEqual(state, OfflineVideoEntity.State.RESOLVING.INSTANCE)) {
            return PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2234(PlayerbaseresRes.INSTANCE.getString()));
        }
        if (state instanceof OfflineVideoEntity.State.DOWNLOADING) {
            if (KFreeBandwidthKt.getKFreeBandwidth().isFreeBandwidthActive() && KReachabilityKt.getKReachability().isReachableViaWWAN() && !Config.Companion.getEnableDownloadWithWWAN()) {
                String string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2192(PlayerbaseresRes.INSTANCE.getString()));
                String fileSize = VBNumberExtKt.toFileSize(this.downloadedSize);
                return string + " " + fileSize + EntryScannerKt.PATH_SEPARATOR + VBNumberExtKt.toFileSize(this.totalSize);
            }
            String string2 = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2204(PlayerbaseresRes.INSTANCE.getString()));
            String fileSize2 = VBNumberExtKt.toFileSize(this.downloadedSize);
            return string2 + " " + fileSize2 + EntryScannerKt.PATH_SEPARATOR + VBNumberExtKt.toFileSize(this.totalSize);
        } else if (Intrinsics.areEqual(state, OfflineVideoEntity.State.COMPLETED.INSTANCE)) {
            return VBNumberExtKt.toFileSize(this.downloadedSize);
        } else {
            if (state instanceof OfflineVideoEntity.State.ERROR) {
                return getErrorDesc();
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean isDownloading() {
        return this.state.isDownloading();
    }

    public final float getDownloadProgress() {
        if (this.totalSize == 0) {
            return DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        }
        if (this.downloadedSize >= this.totalSize) {
            return 1.0f;
        }
        return (((float) this.downloadedSize) * 1.0f) / ((float) this.totalSize);
    }

    private final String getErrorDesc() {
        String string;
        DownloadErrorType from;
        OfflineErrorType errorType = OfflineError.INSTANCE.getErrorType(this.errorCode);
        String tip = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2208(PlayerbaseresRes.INSTANCE.getString()));
        switch (WhenMappings.$EnumSwitchMapping$1[errorType.ordinal()]) {
            case 1:
                string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2271(PlayerbaseresRes.INSTANCE.getString()));
                break;
            case 2:
                int errorCode = OfflineError.INSTANCE.getErrorNumber(this.errorCode);
                if (this.noSpaceList.contains(Integer.valueOf(errorCode))) {
                    from = DownloadErrorType.STORAGE_SPACE_FULL;
                } else {
                    from = this.needDeleteList.contains(Integer.valueOf(errorCode)) ? DownloadErrorType.ADDRESS_EMPTY : DownloadErrorType.Companion.from(errorCode);
                }
                DownloadErrorType downloadErrorType = from;
                switch (WhenMappings.$EnumSwitchMapping$0[downloadErrorType.ordinal()]) {
                    case 1:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2217(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 2:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2189(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 3:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2228(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 4:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2243(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 5:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2259(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 6:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2173(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    case 7:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2189(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                    default:
                        string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2260(PlayerbaseresRes.INSTANCE.getString()));
                        break;
                }
            default:
                string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2260(PlayerbaseresRes.INSTANCE.getString()));
                break;
        }
        return tip + string;
    }
}