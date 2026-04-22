package kntr.app.tribee.steam.viewmodel;

import BottomSheetItemData$;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareImage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamStateAction.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\n\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\u0082\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "", "Initiate", "GoToSteamBind", "AwaitSteamBindResult", "UnbindSteamAccount", "ToggleGameAchievement", "LaunchPolling", "StartShare", "EndShare", "CaptureScreenShot", "ToggleShareRange", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$AwaitSteamBindResult;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$CaptureScreenShot;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$EndShare;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$GoToSteamBind;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$Initiate;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$LaunchPolling;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$StartShare;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$ToggleGameAchievement;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$ToggleShareRange;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$UnbindSteamAccount;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeSteamStateAction {

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$Initiate;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Initiate implements TribeeSteamStateAction {
        public static final int $stable = 0;
        public static final Initiate INSTANCE = new Initiate();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Initiate) {
                Initiate initiate = (Initiate) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -106416204;
        }

        public String toString() {
            return "Initiate";
        }

        private Initiate() {
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$GoToSteamBind;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "steamBindUrl", "", "bindTribeeDialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "<init>", "(Ljava/lang/String;Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;)V", "getSteamBindUrl", "()Ljava/lang/String;", "getBindTribeeDialog", "()Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class GoToSteamBind implements TribeeSteamStateAction {
        public static final int $stable = 8;
        private final KToastDialog bindTribeeDialog;
        private final String steamBindUrl;

        public static /* synthetic */ GoToSteamBind copy$default(GoToSteamBind goToSteamBind, String str, KToastDialog kToastDialog, int i, Object obj) {
            if ((i & 1) != 0) {
                str = goToSteamBind.steamBindUrl;
            }
            if ((i & 2) != 0) {
                kToastDialog = goToSteamBind.bindTribeeDialog;
            }
            return goToSteamBind.copy(str, kToastDialog);
        }

        public final String component1() {
            return this.steamBindUrl;
        }

        public final KToastDialog component2() {
            return this.bindTribeeDialog;
        }

        public final GoToSteamBind copy(String str, KToastDialog kToastDialog) {
            Intrinsics.checkNotNullParameter(str, "steamBindUrl");
            return new GoToSteamBind(str, kToastDialog);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof GoToSteamBind) {
                GoToSteamBind goToSteamBind = (GoToSteamBind) obj;
                return Intrinsics.areEqual(this.steamBindUrl, goToSteamBind.steamBindUrl) && Intrinsics.areEqual(this.bindTribeeDialog, goToSteamBind.bindTribeeDialog);
            }
            return false;
        }

        public int hashCode() {
            return (this.steamBindUrl.hashCode() * 31) + (this.bindTribeeDialog == null ? 0 : this.bindTribeeDialog.hashCode());
        }

        public String toString() {
            String str = this.steamBindUrl;
            return "GoToSteamBind(steamBindUrl=" + str + ", bindTribeeDialog=" + this.bindTribeeDialog + ")";
        }

        public GoToSteamBind(String steamBindUrl, KToastDialog bindTribeeDialog) {
            Intrinsics.checkNotNullParameter(steamBindUrl, "steamBindUrl");
            this.steamBindUrl = steamBindUrl;
            this.bindTribeeDialog = bindTribeeDialog;
        }

        public /* synthetic */ GoToSteamBind(String str, KToastDialog kToastDialog, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : kToastDialog);
        }

        public final String getSteamBindUrl() {
            return this.steamBindUrl;
        }

        public final KToastDialog getBindTribeeDialog() {
            return this.bindTribeeDialog;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$AwaitSteamBindResult;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class AwaitSteamBindResult implements TribeeSteamStateAction {
        public static final int $stable = 0;
        public static final AwaitSteamBindResult INSTANCE = new AwaitSteamBindResult();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AwaitSteamBindResult) {
                AwaitSteamBindResult awaitSteamBindResult = (AwaitSteamBindResult) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1164329841;
        }

        public String toString() {
            return "AwaitSteamBindResult";
        }

        private AwaitSteamBindResult() {
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$UnbindSteamAccount;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class UnbindSteamAccount implements TribeeSteamStateAction {
        public static final int $stable = 0;
        public static final UnbindSteamAccount INSTANCE = new UnbindSteamAccount();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UnbindSteamAccount) {
                UnbindSteamAccount unbindSteamAccount = (UnbindSteamAccount) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -512018546;
        }

        public String toString() {
            return "UnbindSteamAccount";
        }

        private UnbindSteamAccount() {
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$ToggleGameAchievement;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;)V", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToggleGameAchievement implements TribeeSteamStateAction {
        public static final int $stable = 8;
        private final KTribeeSteamHomeGameItem selectedGame;

        public static /* synthetic */ ToggleGameAchievement copy$default(ToggleGameAchievement toggleGameAchievement, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeGameItem = toggleGameAchievement.selectedGame;
            }
            return toggleGameAchievement.copy(kTribeeSteamHomeGameItem);
        }

        public final KTribeeSteamHomeGameItem component1() {
            return this.selectedGame;
        }

        public final ToggleGameAchievement copy(KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new ToggleGameAchievement(kTribeeSteamHomeGameItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToggleGameAchievement) && Intrinsics.areEqual(this.selectedGame, ((ToggleGameAchievement) obj).selectedGame);
        }

        public int hashCode() {
            return this.selectedGame.hashCode();
        }

        public String toString() {
            return "ToggleGameAchievement(selectedGame=" + this.selectedGame + ")";
        }

        public ToggleGameAchievement(KTribeeSteamHomeGameItem selectedGame) {
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.selectedGame = selectedGame;
        }

        public final KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$LaunchPolling;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "count", "", "<init>", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class LaunchPolling implements TribeeSteamStateAction {
        public static final int $stable = 0;
        private final int count;

        public LaunchPolling() {
            this(0, 1, null);
        }

        public static /* synthetic */ LaunchPolling copy$default(LaunchPolling launchPolling, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = launchPolling.count;
            }
            return launchPolling.copy(i);
        }

        public final int component1() {
            return this.count;
        }

        public final LaunchPolling copy(int i) {
            return new LaunchPolling(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LaunchPolling) && this.count == ((LaunchPolling) obj).count;
        }

        public int hashCode() {
            return this.count;
        }

        public String toString() {
            return "LaunchPolling(count=" + this.count + ")";
        }

        public LaunchPolling(int count) {
            this.count = count;
        }

        public /* synthetic */ LaunchPolling(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }

        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$StartShare;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "isFromScreenShot", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class StartShare implements TribeeSteamStateAction {
        public static final int $stable = 0;
        private final boolean isFromScreenShot;

        public StartShare() {
            this(false, 1, null);
        }

        public static /* synthetic */ StartShare copy$default(StartShare startShare, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = startShare.isFromScreenShot;
            }
            return startShare.copy(z);
        }

        public final boolean component1() {
            return this.isFromScreenShot;
        }

        public final StartShare copy(boolean z) {
            return new StartShare(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartShare) && this.isFromScreenShot == ((StartShare) obj).isFromScreenShot;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFromScreenShot);
        }

        public String toString() {
            return "StartShare(isFromScreenShot=" + this.isFromScreenShot + ")";
        }

        public StartShare(boolean isFromScreenShot) {
            this.isFromScreenShot = isFromScreenShot;
        }

        public /* synthetic */ StartShare(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z);
        }

        public final boolean isFromScreenShot() {
            return this.isFromScreenShot;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$EndShare;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class EndShare implements TribeeSteamStateAction {
        public static final int $stable = 0;
        public static final EndShare INSTANCE = new EndShare();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof EndShare) {
                EndShare endShare = (EndShare) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1338625247;
        }

        public String toString() {
            return "EndShare";
        }

        private EndShare() {
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$CaptureScreenShot;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "image", "Lkntr/common/share/common/ShareImage;", "<init>", "(Lkntr/common/share/common/ShareImage;)V", "getImage", "()Lkntr/common/share/common/ShareImage;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class CaptureScreenShot implements TribeeSteamStateAction {
        public static final int $stable = 8;
        private final ShareImage image;

        public static /* synthetic */ CaptureScreenShot copy$default(CaptureScreenShot captureScreenShot, ShareImage shareImage, int i, Object obj) {
            if ((i & 1) != 0) {
                shareImage = captureScreenShot.image;
            }
            return captureScreenShot.copy(shareImage);
        }

        public final ShareImage component1() {
            return this.image;
        }

        public final CaptureScreenShot copy(ShareImage shareImage) {
            Intrinsics.checkNotNullParameter(shareImage, "image");
            return new CaptureScreenShot(shareImage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CaptureScreenShot) && Intrinsics.areEqual(this.image, ((CaptureScreenShot) obj).image);
        }

        public int hashCode() {
            return this.image.hashCode();
        }

        public String toString() {
            return "CaptureScreenShot(image=" + this.image + ")";
        }

        public CaptureScreenShot(ShareImage image) {
            Intrinsics.checkNotNullParameter(image, "image");
            this.image = image;
        }

        public final ShareImage getImage() {
            return this.image;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction$ToggleShareRange;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateAction;", "isShareAllGame", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToggleShareRange implements TribeeSteamStateAction {
        public static final int $stable = 0;
        private final boolean isShareAllGame;

        public static /* synthetic */ ToggleShareRange copy$default(ToggleShareRange toggleShareRange, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = toggleShareRange.isShareAllGame;
            }
            return toggleShareRange.copy(z);
        }

        public final boolean component1() {
            return this.isShareAllGame;
        }

        public final ToggleShareRange copy(boolean z) {
            return new ToggleShareRange(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToggleShareRange) && this.isShareAllGame == ((ToggleShareRange) obj).isShareAllGame;
        }

        public int hashCode() {
            return BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isShareAllGame);
        }

        public String toString() {
            return "ToggleShareRange(isShareAllGame=" + this.isShareAllGame + ")";
        }

        public ToggleShareRange(boolean isShareAllGame) {
            this.isShareAllGame = isShareAllGame;
        }

        public final boolean isShareAllGame() {
            return this.isShareAllGame;
        }
    }
}