package kntr.app.tribee.steam.state;

import BottomSheetItemData$;
import com.bapis.bilibili.entitle.hub.interfaces.KGetShareGameDataUrlRsp;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamShareState.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017BA\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u0082\u0001\u0004\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "", "isFromScreenShot", "", "isShareAllGame", "shareImage", "Lkntr/common/share/common/ShareImage;", "shareLink", "", "allShareLinks", "Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "<init>", "(ZZLkntr/common/share/common/ShareImage;Ljava/lang/String;Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;)V", "()Z", "getShareImage", "()Lkntr/common/share/common/ShareImage;", "getShareLink", "()Ljava/lang/String;", "getAllShareLinks", "()Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "InitialState", "LoadingState", "MaterialLoadedSuccessState", "MaterialRefreshState", "Lkntr/app/tribee/steam/state/TribeeSteamShareState$InitialState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState$LoadingState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState$MaterialLoadedSuccessState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState$MaterialRefreshState;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public abstract class TribeeSteamShareState {
    public static final int $stable = 0;
    private final KGetShareGameDataUrlRsp allShareLinks;
    private final boolean isFromScreenShot;
    private final boolean isShareAllGame;
    private final ShareImage shareImage;
    private final String shareLink;

    public /* synthetic */ TribeeSteamShareState(boolean z, boolean z2, ShareImage shareImage, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, shareImage, str, kGetShareGameDataUrlRsp);
    }

    private TribeeSteamShareState(boolean isFromScreenShot, boolean isShareAllGame, ShareImage shareImage, String shareLink, KGetShareGameDataUrlRsp allShareLinks) {
        this.isFromScreenShot = isFromScreenShot;
        this.isShareAllGame = isShareAllGame;
        this.shareImage = shareImage;
        this.shareLink = shareLink;
        this.allShareLinks = allShareLinks;
    }

    public /* synthetic */ TribeeSteamShareState(boolean z, boolean z2, ShareImage shareImage, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : shareImage, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : kGetShareGameDataUrlRsp, null);
    }

    public boolean isFromScreenShot() {
        return this.isFromScreenShot;
    }

    public boolean isShareAllGame() {
        return this.isShareAllGame;
    }

    public ShareImage getShareImage() {
        return this.shareImage;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public KGetShareGameDataUrlRsp getAllShareLinks() {
        return this.allShareLinks;
    }

    /* compiled from: TribeeSteamShareState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamShareState$InitialState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class InitialState extends TribeeSteamShareState {
        public static final int $stable = 0;
        public static final InitialState INSTANCE = new InitialState();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof InitialState) {
                InitialState initialState = (InitialState) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 890814504;
        }

        public String toString() {
            return "InitialState";
        }

        private InitialState() {
            super(false, false, null, null, null, 31, null);
        }
    }

    /* compiled from: TribeeSteamShareState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamShareState$LoadingState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "isFromScreenShot", "", "isShareAllGame", "shareLink", "", "allShareLinks", "Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "<init>", "(ZZLjava/lang/String;Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;)V", "()Z", "getShareLink", "()Ljava/lang/String;", "getAllShareLinks", "()Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LoadingState extends TribeeSteamShareState {
        public static final int $stable = 0;
        private final KGetShareGameDataUrlRsp allShareLinks;
        private final boolean isFromScreenShot;
        private final boolean isShareAllGame;
        private final String shareLink;

        public LoadingState() {
            this(false, false, null, null, 15, null);
        }

        public static /* synthetic */ LoadingState copy$default(LoadingState loadingState, boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, int i, Object obj) {
            if ((i & 1) != 0) {
                z = loadingState.isFromScreenShot;
            }
            if ((i & 2) != 0) {
                z2 = loadingState.isShareAllGame;
            }
            if ((i & 4) != 0) {
                str = loadingState.shareLink;
            }
            if ((i & 8) != 0) {
                kGetShareGameDataUrlRsp = loadingState.allShareLinks;
            }
            return loadingState.copy(z, z2, str, kGetShareGameDataUrlRsp);
        }

        public final boolean component1() {
            return this.isFromScreenShot;
        }

        public final boolean component2() {
            return this.isShareAllGame;
        }

        public final String component3() {
            return this.shareLink;
        }

        public final KGetShareGameDataUrlRsp component4() {
            return this.allShareLinks;
        }

        public final LoadingState copy(boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp) {
            return new LoadingState(z, z2, str, kGetShareGameDataUrlRsp);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof LoadingState) {
                LoadingState loadingState = (LoadingState) obj;
                return this.isFromScreenShot == loadingState.isFromScreenShot && this.isShareAllGame == loadingState.isShareAllGame && Intrinsics.areEqual(this.shareLink, loadingState.shareLink) && Intrinsics.areEqual(this.allShareLinks, loadingState.allShareLinks);
            }
            return false;
        }

        public int hashCode() {
            return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromScreenShot) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShareAllGame)) * 31) + (this.shareLink == null ? 0 : this.shareLink.hashCode())) * 31) + (this.allShareLinks != null ? this.allShareLinks.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isFromScreenShot;
            boolean z2 = this.isShareAllGame;
            String str = this.shareLink;
            return "LoadingState(isFromScreenShot=" + z + ", isShareAllGame=" + z2 + ", shareLink=" + str + ", allShareLinks=" + this.allShareLinks + ")";
        }

        public LoadingState(boolean isFromScreenShot, boolean isShareAllGame, String shareLink, KGetShareGameDataUrlRsp allShareLinks) {
            super(false, false, null, null, null, 31, null);
            this.isFromScreenShot = isFromScreenShot;
            this.isShareAllGame = isShareAllGame;
            this.shareLink = shareLink;
            this.allShareLinks = allShareLinks;
        }

        public /* synthetic */ LoadingState(boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : kGetShareGameDataUrlRsp);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isFromScreenShot() {
            return this.isFromScreenShot;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isShareAllGame() {
            return this.isShareAllGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public String getShareLink() {
            return this.shareLink;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public KGetShareGameDataUrlRsp getAllShareLinks() {
            return this.allShareLinks;
        }
    }

    /* compiled from: TribeeSteamShareState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JK\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u000e¨\u0006\""}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamShareState$MaterialLoadedSuccessState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "isFromScreenShot", "", "isShareAllGame", "shareImage", "Lkntr/common/share/common/ShareImage;", "shareLink", "", "allShareLinks", "Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "isStartedCapture", "<init>", "(ZZLkntr/common/share/common/ShareImage;Ljava/lang/String;Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;Z)V", "()Z", "getShareImage", "()Lkntr/common/share/common/ShareImage;", "getShareLink", "()Ljava/lang/String;", "getAllShareLinks", "()Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MaterialLoadedSuccessState extends TribeeSteamShareState {
        public static final int $stable = 0;
        private final KGetShareGameDataUrlRsp allShareLinks;
        private final boolean isFromScreenShot;
        private final boolean isShareAllGame;
        private final boolean isStartedCapture;
        private final ShareImage shareImage;
        private final String shareLink;

        public MaterialLoadedSuccessState() {
            this(false, false, null, null, null, false, 63, null);
        }

        public static /* synthetic */ MaterialLoadedSuccessState copy$default(MaterialLoadedSuccessState materialLoadedSuccessState, boolean z, boolean z2, ShareImage shareImage, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z = materialLoadedSuccessState.isFromScreenShot;
            }
            if ((i & 2) != 0) {
                z2 = materialLoadedSuccessState.isShareAllGame;
            }
            boolean z4 = z2;
            if ((i & 4) != 0) {
                shareImage = materialLoadedSuccessState.shareImage;
            }
            ShareImage shareImage2 = shareImage;
            if ((i & 8) != 0) {
                str = materialLoadedSuccessState.shareLink;
            }
            String str2 = str;
            if ((i & 16) != 0) {
                kGetShareGameDataUrlRsp = materialLoadedSuccessState.allShareLinks;
            }
            KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp2 = kGetShareGameDataUrlRsp;
            if ((i & 32) != 0) {
                z3 = materialLoadedSuccessState.isStartedCapture;
            }
            return materialLoadedSuccessState.copy(z, z4, shareImage2, str2, kGetShareGameDataUrlRsp2, z3);
        }

        public final boolean component1() {
            return this.isFromScreenShot;
        }

        public final boolean component2() {
            return this.isShareAllGame;
        }

        public final ShareImage component3() {
            return this.shareImage;
        }

        public final String component4() {
            return this.shareLink;
        }

        public final KGetShareGameDataUrlRsp component5() {
            return this.allShareLinks;
        }

        public final boolean component6() {
            return this.isStartedCapture;
        }

        public final MaterialLoadedSuccessState copy(boolean z, boolean z2, ShareImage shareImage, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, boolean z3) {
            return new MaterialLoadedSuccessState(z, z2, shareImage, str, kGetShareGameDataUrlRsp, z3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MaterialLoadedSuccessState) {
                MaterialLoadedSuccessState materialLoadedSuccessState = (MaterialLoadedSuccessState) obj;
                return this.isFromScreenShot == materialLoadedSuccessState.isFromScreenShot && this.isShareAllGame == materialLoadedSuccessState.isShareAllGame && Intrinsics.areEqual(this.shareImage, materialLoadedSuccessState.shareImage) && Intrinsics.areEqual(this.shareLink, materialLoadedSuccessState.shareLink) && Intrinsics.areEqual(this.allShareLinks, materialLoadedSuccessState.allShareLinks) && this.isStartedCapture == materialLoadedSuccessState.isStartedCapture;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromScreenShot) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShareAllGame)) * 31) + (this.shareImage == null ? 0 : this.shareImage.hashCode())) * 31) + (this.shareLink == null ? 0 : this.shareLink.hashCode())) * 31) + (this.allShareLinks != null ? this.allShareLinks.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isStartedCapture);
        }

        public String toString() {
            boolean z = this.isFromScreenShot;
            boolean z2 = this.isShareAllGame;
            ShareImage shareImage = this.shareImage;
            String str = this.shareLink;
            KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp = this.allShareLinks;
            return "MaterialLoadedSuccessState(isFromScreenShot=" + z + ", isShareAllGame=" + z2 + ", shareImage=" + shareImage + ", shareLink=" + str + ", allShareLinks=" + kGetShareGameDataUrlRsp + ", isStartedCapture=" + this.isStartedCapture + ")";
        }

        public MaterialLoadedSuccessState(boolean isFromScreenShot, boolean isShareAllGame, ShareImage shareImage, String shareLink, KGetShareGameDataUrlRsp allShareLinks, boolean isStartedCapture) {
            super(false, false, null, null, null, 31, null);
            this.isFromScreenShot = isFromScreenShot;
            this.isShareAllGame = isShareAllGame;
            this.shareImage = shareImage;
            this.shareLink = shareLink;
            this.allShareLinks = allShareLinks;
            this.isStartedCapture = isStartedCapture;
        }

        public /* synthetic */ MaterialLoadedSuccessState(boolean z, boolean z2, ShareImage shareImage, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : shareImage, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : kGetShareGameDataUrlRsp, (i & 32) != 0 ? false : z3);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isFromScreenShot() {
            return this.isFromScreenShot;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isShareAllGame() {
            return this.isShareAllGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public ShareImage getShareImage() {
            return this.shareImage;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public String getShareLink() {
            return this.shareLink;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public KGetShareGameDataUrlRsp getAllShareLinks() {
            return this.allShareLinks;
        }

        public final boolean isStartedCapture() {
            return this.isStartedCapture;
        }
    }

    /* compiled from: TribeeSteamShareState.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lkntr/app/tribee/steam/state/TribeeSteamShareState$MaterialRefreshState;", "Lkntr/app/tribee/steam/state/TribeeSteamShareState;", "isFromScreenShot", "", "isShareAllGame", "shareLink", "", "allShareLinks", "Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "<init>", "(ZZLjava/lang/String;Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;)V", "()Z", "getShareLink", "()Ljava/lang/String;", "getAllShareLinks", "()Lcom/bapis/bilibili/entitle/hub/interfaces/KGetShareGameDataUrlRsp;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class MaterialRefreshState extends TribeeSteamShareState {
        public static final int $stable = 0;
        private final KGetShareGameDataUrlRsp allShareLinks;
        private final boolean isFromScreenShot;
        private final boolean isShareAllGame;
        private final String shareLink;

        public MaterialRefreshState() {
            this(false, false, null, null, 15, null);
        }

        public static /* synthetic */ MaterialRefreshState copy$default(MaterialRefreshState materialRefreshState, boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, int i, Object obj) {
            if ((i & 1) != 0) {
                z = materialRefreshState.isFromScreenShot;
            }
            if ((i & 2) != 0) {
                z2 = materialRefreshState.isShareAllGame;
            }
            if ((i & 4) != 0) {
                str = materialRefreshState.shareLink;
            }
            if ((i & 8) != 0) {
                kGetShareGameDataUrlRsp = materialRefreshState.allShareLinks;
            }
            return materialRefreshState.copy(z, z2, str, kGetShareGameDataUrlRsp);
        }

        public final boolean component1() {
            return this.isFromScreenShot;
        }

        public final boolean component2() {
            return this.isShareAllGame;
        }

        public final String component3() {
            return this.shareLink;
        }

        public final KGetShareGameDataUrlRsp component4() {
            return this.allShareLinks;
        }

        public final MaterialRefreshState copy(boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp) {
            return new MaterialRefreshState(z, z2, str, kGetShareGameDataUrlRsp);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MaterialRefreshState) {
                MaterialRefreshState materialRefreshState = (MaterialRefreshState) obj;
                return this.isFromScreenShot == materialRefreshState.isFromScreenShot && this.isShareAllGame == materialRefreshState.isShareAllGame && Intrinsics.areEqual(this.shareLink, materialRefreshState.shareLink) && Intrinsics.areEqual(this.allShareLinks, materialRefreshState.allShareLinks);
            }
            return false;
        }

        public int hashCode() {
            return (((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromScreenShot) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShareAllGame)) * 31) + (this.shareLink == null ? 0 : this.shareLink.hashCode())) * 31) + (this.allShareLinks != null ? this.allShareLinks.hashCode() : 0);
        }

        public String toString() {
            boolean z = this.isFromScreenShot;
            boolean z2 = this.isShareAllGame;
            String str = this.shareLink;
            return "MaterialRefreshState(isFromScreenShot=" + z + ", isShareAllGame=" + z2 + ", shareLink=" + str + ", allShareLinks=" + this.allShareLinks + ")";
        }

        public MaterialRefreshState(boolean isFromScreenShot, boolean isShareAllGame, String shareLink, KGetShareGameDataUrlRsp allShareLinks) {
            super(false, false, null, null, null, 31, null);
            this.isFromScreenShot = isFromScreenShot;
            this.isShareAllGame = isShareAllGame;
            this.shareLink = shareLink;
            this.allShareLinks = allShareLinks;
        }

        public /* synthetic */ MaterialRefreshState(boolean z, boolean z2, String str, KGetShareGameDataUrlRsp kGetShareGameDataUrlRsp, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : kGetShareGameDataUrlRsp);
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isFromScreenShot() {
            return this.isFromScreenShot;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public boolean isShareAllGame() {
            return this.isShareAllGame;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public String getShareLink() {
            return this.shareLink;
        }

        @Override // kntr.app.tribee.steam.state.TribeeSteamShareState
        public KGetShareGameDataUrlRsp getAllShareLinks() {
            return this.allShareLinks;
        }
    }
}