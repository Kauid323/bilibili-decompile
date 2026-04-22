package kntr.app.im.chat.frame.bubble;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.compose.avatar.model.AvatarItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatBubbleFrame.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/frame/bubble/UserInfoHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "avatarItem", "Lkntr/compose/avatar/model/AvatarItem;", "avatarUrl", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/compose/avatar/model/AvatarItem;Ljava/lang/String;)V", "getAvatarItem", "()Lkntr/compose/avatar/model/AvatarItem;", "getAvatarUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserInfoHolder {
    public static final int $stable = 0;
    private final AvatarItem avatarItem;
    private final String avatarUrl;

    public static /* synthetic */ UserInfoHolder copy$default(UserInfoHolder userInfoHolder, AvatarItem avatarItem, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            avatarItem = userInfoHolder.avatarItem;
        }
        if ((i & 2) != 0) {
            str = userInfoHolder.avatarUrl;
        }
        return userInfoHolder.copy(avatarItem, str);
    }

    public final AvatarItem component1() {
        return this.avatarItem;
    }

    public final String component2() {
        return this.avatarUrl;
    }

    public final UserInfoHolder copy(AvatarItem avatarItem, String str) {
        Intrinsics.checkNotNullParameter(str, "avatarUrl");
        return new UserInfoHolder(avatarItem, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserInfoHolder) {
            UserInfoHolder userInfoHolder = (UserInfoHolder) obj;
            return Intrinsics.areEqual(this.avatarItem, userInfoHolder.avatarItem) && Intrinsics.areEqual(this.avatarUrl, userInfoHolder.avatarUrl);
        }
        return false;
    }

    public int hashCode() {
        return ((this.avatarItem == null ? 0 : this.avatarItem.hashCode()) * 31) + this.avatarUrl.hashCode();
    }

    public String toString() {
        AvatarItem avatarItem = this.avatarItem;
        return "UserInfoHolder(avatarItem=" + avatarItem + ", avatarUrl=" + this.avatarUrl + ")";
    }

    public UserInfoHolder(AvatarItem avatarItem, String avatarUrl) {
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        this.avatarItem = avatarItem;
        this.avatarUrl = avatarUrl;
    }

    public final AvatarItem getAvatarItem() {
        return this.avatarItem;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }
}