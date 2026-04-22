package kntr.app.tribee.steam.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.KThreeDot;
import com.bapis.bilibili.app.dynamic.v2.KToastDialog;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeAchievementItem;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGame;
import com.bapis.bilibili.app.dynamic.v2.KTribeeSteamHomeGameItem;
import kntr.app.tribee.consume.viewmodel.state.TribeeToast;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TribeeSteamStateAction.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000b\f\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "", "ToastTips", "RouterTo", "ToastDialog", "ClickMenu", "ShowGameListBottomSheet", "ShowGameAchievementBottomSheet", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ClickMenu;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$RouterTo;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameAchievementBottomSheet;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameListBottomSheet;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ToastDialog;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ToastTips;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeSteamUIAction {

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ToastTips;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "tribeeToast", "Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "toastType", "", "<init>", "(Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;Ljava/lang/String;)V", "getTribeeToast", "()Lkntr/app/tribee/consume/viewmodel/state/TribeeToast;", "getToastType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastTips implements TribeeSteamUIAction {
        public static final int $stable = 0;
        private final String toastType;
        private final TribeeToast tribeeToast;

        public static /* synthetic */ ToastTips copy$default(ToastTips toastTips, TribeeToast tribeeToast, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                tribeeToast = toastTips.tribeeToast;
            }
            if ((i & 2) != 0) {
                str = toastTips.toastType;
            }
            return toastTips.copy(tribeeToast, str);
        }

        public final TribeeToast component1() {
            return this.tribeeToast;
        }

        public final String component2() {
            return this.toastType;
        }

        public final ToastTips copy(TribeeToast tribeeToast, String str) {
            return new ToastTips(tribeeToast, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ToastTips) {
                ToastTips toastTips = (ToastTips) obj;
                return Intrinsics.areEqual(this.tribeeToast, toastTips.tribeeToast) && Intrinsics.areEqual(this.toastType, toastTips.toastType);
            }
            return false;
        }

        public int hashCode() {
            return ((this.tribeeToast == null ? 0 : this.tribeeToast.hashCode()) * 31) + (this.toastType != null ? this.toastType.hashCode() : 0);
        }

        public String toString() {
            TribeeToast tribeeToast = this.tribeeToast;
            return "ToastTips(tribeeToast=" + tribeeToast + ", toastType=" + this.toastType + ")";
        }

        public ToastTips(TribeeToast tribeeToast, String toastType) {
            this.tribeeToast = tribeeToast;
            this.toastType = toastType;
        }

        public /* synthetic */ ToastTips(TribeeToast tribeeToast, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(tribeeToast, (i & 2) != 0 ? null : str);
        }

        public final TribeeToast getTribeeToast() {
            return this.tribeeToast;
        }

        public final String getToastType() {
            return this.toastType;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$RouterTo;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class RouterTo implements TribeeSteamUIAction {
        public static final int $stable = 0;
        private final String url;

        public static /* synthetic */ RouterTo copy$default(RouterTo routerTo, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = routerTo.url;
            }
            return routerTo.copy(str);
        }

        public final String component1() {
            return this.url;
        }

        public final RouterTo copy(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new RouterTo(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RouterTo) && Intrinsics.areEqual(this.url, ((RouterTo) obj).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        public String toString() {
            return "RouterTo(url=" + this.url + ")";
        }

        public RouterTo(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ToastDialog;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "dialog", "Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;)V", "getDialog", "()Lcom/bapis/bilibili/app/dynamic/v2/KToastDialog;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ToastDialog implements TribeeSteamUIAction {
        public static final int $stable = 8;
        private final KToastDialog dialog;

        public static /* synthetic */ ToastDialog copy$default(ToastDialog toastDialog, KToastDialog kToastDialog, int i, Object obj) {
            if ((i & 1) != 0) {
                kToastDialog = toastDialog.dialog;
            }
            return toastDialog.copy(kToastDialog);
        }

        public final KToastDialog component1() {
            return this.dialog;
        }

        public final ToastDialog copy(KToastDialog kToastDialog) {
            Intrinsics.checkNotNullParameter(kToastDialog, "dialog");
            return new ToastDialog(kToastDialog);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ToastDialog) && Intrinsics.areEqual(this.dialog, ((ToastDialog) obj).dialog);
        }

        public int hashCode() {
            return this.dialog.hashCode();
        }

        public String toString() {
            return "ToastDialog(dialog=" + this.dialog + ")";
        }

        public ToastDialog(KToastDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.dialog = dialog;
        }

        public final KToastDialog getDialog() {
            return this.dialog;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ClickMenu;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "threeDot", "Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;)V", "getThreeDot", "()Lcom/bapis/bilibili/app/dynamic/v2/KThreeDot;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ClickMenu implements TribeeSteamUIAction {
        public static final int $stable = 8;
        private final KThreeDot threeDot;

        public static /* synthetic */ ClickMenu copy$default(ClickMenu clickMenu, KThreeDot kThreeDot, int i, Object obj) {
            if ((i & 1) != 0) {
                kThreeDot = clickMenu.threeDot;
            }
            return clickMenu.copy(kThreeDot);
        }

        public final KThreeDot component1() {
            return this.threeDot;
        }

        public final ClickMenu copy(KThreeDot kThreeDot) {
            return new ClickMenu(kThreeDot);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickMenu) && Intrinsics.areEqual(this.threeDot, ((ClickMenu) obj).threeDot);
        }

        public int hashCode() {
            if (this.threeDot == null) {
                return 0;
            }
            return this.threeDot.hashCode();
        }

        public String toString() {
            return "ClickMenu(threeDot=" + this.threeDot + ")";
        }

        public ClickMenu(KThreeDot threeDot) {
            this.threeDot = threeDot;
        }

        public final KThreeDot getThreeDot() {
            return this.threeDot;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameListBottomSheet;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "gameListInfo", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "selectedGame", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;)V", "getGameListInfo", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGame;", "getSelectedGame", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeGameItem;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowGameListBottomSheet implements TribeeSteamUIAction {
        public static final int $stable = 8;
        private final KTribeeSteamHomeGame gameListInfo;
        private final KTribeeSteamHomeGameItem selectedGame;

        public static /* synthetic */ ShowGameListBottomSheet copy$default(ShowGameListBottomSheet showGameListBottomSheet, KTribeeSteamHomeGame kTribeeSteamHomeGame, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeGame = showGameListBottomSheet.gameListInfo;
            }
            if ((i & 2) != 0) {
                kTribeeSteamHomeGameItem = showGameListBottomSheet.selectedGame;
            }
            return showGameListBottomSheet.copy(kTribeeSteamHomeGame, kTribeeSteamHomeGameItem);
        }

        public final KTribeeSteamHomeGame component1() {
            return this.gameListInfo;
        }

        public final KTribeeSteamHomeGameItem component2() {
            return this.selectedGame;
        }

        public final ShowGameListBottomSheet copy(KTribeeSteamHomeGame kTribeeSteamHomeGame, KTribeeSteamHomeGameItem kTribeeSteamHomeGameItem) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGame, "gameListInfo");
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeGameItem, "selectedGame");
            return new ShowGameListBottomSheet(kTribeeSteamHomeGame, kTribeeSteamHomeGameItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ShowGameListBottomSheet) {
                ShowGameListBottomSheet showGameListBottomSheet = (ShowGameListBottomSheet) obj;
                return Intrinsics.areEqual(this.gameListInfo, showGameListBottomSheet.gameListInfo) && Intrinsics.areEqual(this.selectedGame, showGameListBottomSheet.selectedGame);
            }
            return false;
        }

        public int hashCode() {
            return (this.gameListInfo.hashCode() * 31) + this.selectedGame.hashCode();
        }

        public String toString() {
            KTribeeSteamHomeGame kTribeeSteamHomeGame = this.gameListInfo;
            return "ShowGameListBottomSheet(gameListInfo=" + kTribeeSteamHomeGame + ", selectedGame=" + this.selectedGame + ")";
        }

        public ShowGameListBottomSheet(KTribeeSteamHomeGame gameListInfo, KTribeeSteamHomeGameItem selectedGame) {
            Intrinsics.checkNotNullParameter(gameListInfo, "gameListInfo");
            Intrinsics.checkNotNullParameter(selectedGame, "selectedGame");
            this.gameListInfo = gameListInfo;
            this.selectedGame = selectedGame;
        }

        public final KTribeeSteamHomeGame getGameListInfo() {
            return this.gameListInfo;
        }

        public final KTribeeSteamHomeGameItem getSelectedGame() {
            return this.selectedGame;
        }
    }

    /* compiled from: TribeeSteamStateAction.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction$ShowGameAchievementBottomSheet;", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamUIAction;", "achievement", "Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;)V", "getAchievement", "()Lcom/bapis/bilibili/app/dynamic/v2/KTribeeSteamHomeAchievementItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class ShowGameAchievementBottomSheet implements TribeeSteamUIAction {
        public static final int $stable = 8;
        private final KTribeeSteamHomeAchievementItem achievement;

        public static /* synthetic */ ShowGameAchievementBottomSheet copy$default(ShowGameAchievementBottomSheet showGameAchievementBottomSheet, KTribeeSteamHomeAchievementItem kTribeeSteamHomeAchievementItem, int i, Object obj) {
            if ((i & 1) != 0) {
                kTribeeSteamHomeAchievementItem = showGameAchievementBottomSheet.achievement;
            }
            return showGameAchievementBottomSheet.copy(kTribeeSteamHomeAchievementItem);
        }

        public final KTribeeSteamHomeAchievementItem component1() {
            return this.achievement;
        }

        public final ShowGameAchievementBottomSheet copy(KTribeeSteamHomeAchievementItem kTribeeSteamHomeAchievementItem) {
            Intrinsics.checkNotNullParameter(kTribeeSteamHomeAchievementItem, "achievement");
            return new ShowGameAchievementBottomSheet(kTribeeSteamHomeAchievementItem);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowGameAchievementBottomSheet) && Intrinsics.areEqual(this.achievement, ((ShowGameAchievementBottomSheet) obj).achievement);
        }

        public int hashCode() {
            return this.achievement.hashCode();
        }

        public String toString() {
            return "ShowGameAchievementBottomSheet(achievement=" + this.achievement + ")";
        }

        public ShowGameAchievementBottomSheet(KTribeeSteamHomeAchievementItem achievement) {
            Intrinsics.checkNotNullParameter(achievement, "achievement");
            this.achievement = achievement;
        }

        public final KTribeeSteamHomeAchievementItem getAchievement() {
            return this.achievement;
        }
    }
}