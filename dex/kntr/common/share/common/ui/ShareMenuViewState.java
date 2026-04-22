package kntr.common.share.common.ui;

import BottomSheetItemData$;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ShareContent;
import kntr.common.share.common.ShareResult;
import kntr.common.share.common.ShareTarget;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuVM.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lkntr/common/share/common/ui/ShareMenuViewState;", "", "isVisible", "", "isLoading", "isLoadedChannelList", "channels", "Lkntr/common/share/common/ui/ShareChannelList;", "selectedChannel", "Lkntr/common/share/common/ShareTarget;", "shareContent", "Lkntr/common/share/common/ShareContent;", "shareResult", "Lkntr/common/share/common/ShareResult;", "<init>", "(ZZZLkntr/common/share/common/ui/ShareChannelList;Lkntr/common/share/common/ShareTarget;Lkntr/common/share/common/ShareContent;Lkntr/common/share/common/ShareResult;)V", "()Z", "getChannels", "()Lkntr/common/share/common/ui/ShareChannelList;", "getSelectedChannel", "()Lkntr/common/share/common/ShareTarget;", "getShareContent", "()Lkntr/common/share/common/ShareContent;", "getShareResult", "()Lkntr/common/share/common/ShareResult;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "common-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareMenuViewState {
    public static final int $stable = 8;
    private final ShareChannelList channels;
    private final boolean isLoadedChannelList;
    private final boolean isLoading;
    private final boolean isVisible;
    private final ShareTarget selectedChannel;
    private final ShareContent shareContent;
    private final ShareResult shareResult;

    public ShareMenuViewState() {
        this(false, false, false, null, null, null, null, 127, null);
    }

    public static /* synthetic */ ShareMenuViewState copy$default(ShareMenuViewState shareMenuViewState, boolean z, boolean z2, boolean z3, ShareChannelList shareChannelList, ShareTarget shareTarget, ShareContent shareContent, ShareResult shareResult, int i, Object obj) {
        if ((i & 1) != 0) {
            z = shareMenuViewState.isVisible;
        }
        if ((i & 2) != 0) {
            z2 = shareMenuViewState.isLoading;
        }
        boolean z4 = z2;
        if ((i & 4) != 0) {
            z3 = shareMenuViewState.isLoadedChannelList;
        }
        boolean z5 = z3;
        if ((i & 8) != 0) {
            shareChannelList = shareMenuViewState.channels;
        }
        ShareChannelList shareChannelList2 = shareChannelList;
        if ((i & 16) != 0) {
            shareTarget = shareMenuViewState.selectedChannel;
        }
        ShareTarget shareTarget2 = shareTarget;
        if ((i & 32) != 0) {
            shareContent = shareMenuViewState.shareContent;
        }
        ShareContent shareContent2 = shareContent;
        if ((i & 64) != 0) {
            shareResult = shareMenuViewState.shareResult;
        }
        return shareMenuViewState.copy(z, z4, z5, shareChannelList2, shareTarget2, shareContent2, shareResult);
    }

    public final boolean component1() {
        return this.isVisible;
    }

    public final boolean component2() {
        return this.isLoading;
    }

    public final boolean component3() {
        return this.isLoadedChannelList;
    }

    public final ShareChannelList component4() {
        return this.channels;
    }

    public final ShareTarget component5() {
        return this.selectedChannel;
    }

    public final ShareContent component6() {
        return this.shareContent;
    }

    public final ShareResult component7() {
        return this.shareResult;
    }

    public final ShareMenuViewState copy(boolean z, boolean z2, boolean z3, ShareChannelList shareChannelList, ShareTarget shareTarget, ShareContent shareContent, ShareResult shareResult) {
        Intrinsics.checkNotNullParameter(shareChannelList, "channels");
        return new ShareMenuViewState(z, z2, z3, shareChannelList, shareTarget, shareContent, shareResult);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShareMenuViewState) {
            ShareMenuViewState shareMenuViewState = (ShareMenuViewState) obj;
            return this.isVisible == shareMenuViewState.isVisible && this.isLoading == shareMenuViewState.isLoading && this.isLoadedChannelList == shareMenuViewState.isLoadedChannelList && Intrinsics.areEqual(this.channels, shareMenuViewState.channels) && Intrinsics.areEqual(this.selectedChannel, shareMenuViewState.selectedChannel) && Intrinsics.areEqual(this.shareContent, shareMenuViewState.shareContent) && this.shareResult == shareMenuViewState.shareResult;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isVisible) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoading)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isLoadedChannelList)) * 31) + this.channels.hashCode()) * 31) + (this.selectedChannel == null ? 0 : this.selectedChannel.hashCode())) * 31) + (this.shareContent == null ? 0 : this.shareContent.hashCode())) * 31) + (this.shareResult != null ? this.shareResult.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.isVisible;
        boolean z2 = this.isLoading;
        boolean z3 = this.isLoadedChannelList;
        ShareChannelList shareChannelList = this.channels;
        ShareTarget shareTarget = this.selectedChannel;
        ShareContent shareContent = this.shareContent;
        return "ShareMenuViewState(isVisible=" + z + ", isLoading=" + z2 + ", isLoadedChannelList=" + z3 + ", channels=" + shareChannelList + ", selectedChannel=" + shareTarget + ", shareContent=" + shareContent + ", shareResult=" + this.shareResult + ")";
    }

    public ShareMenuViewState(boolean isVisible, boolean isLoading, boolean isLoadedChannelList, ShareChannelList channels, ShareTarget selectedChannel, ShareContent shareContent, ShareResult shareResult) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        this.isVisible = isVisible;
        this.isLoading = isLoading;
        this.isLoadedChannelList = isLoadedChannelList;
        this.channels = channels;
        this.selectedChannel = selectedChannel;
        this.shareContent = shareContent;
        this.shareResult = shareResult;
    }

    public /* synthetic */ ShareMenuViewState(boolean z, boolean z2, boolean z3, ShareChannelList shareChannelList, ShareTarget shareTarget, ShareContent shareContent, ShareResult shareResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) == 0 ? z3 : false, (i & 8) != 0 ? new ShareChannelList(null, 1, null) : shareChannelList, (i & 16) != 0 ? null : shareTarget, (i & 32) != 0 ? null : shareContent, (i & 64) != 0 ? null : shareResult);
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isLoadedChannelList() {
        return this.isLoadedChannelList;
    }

    public final ShareChannelList getChannels() {
        return this.channels;
    }

    public final ShareTarget getSelectedChannel() {
        return this.selectedChannel;
    }

    public final ShareContent getShareContent() {
        return this.shareContent;
    }

    public final ShareResult getShareResult() {
        return this.shareResult;
    }
}