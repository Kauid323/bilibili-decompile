package im.direct.notification.interactive;

import BottomSheetItemData$;
import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import com.bilibili.blens.Lens;
import com.tencent.open.SocialConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.datetime.Clock;

/* compiled from: INState.kt */
@Lens
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0087\b\u0018\u0000 X2\u00020\u0001:\u0001XB¡\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\u0006\u0010\u001d\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u0016¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010;\u001a\u00020\u00162\b\u0010<\u001a\u0004\u0018\u00010=H\u0096\u0002J\b\u0010>\u001a\u00020?H\u0017J\u0015\u0010@\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u0000H\u0000¢\u0006\u0002\bAJ\t\u0010D\u001a\u00020\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010H\u001a\u00020\u000bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\t\u0010M\u001a\u00020\u0016HÆ\u0003J\t\u0010N\u001a\u00020\u0016HÆ\u0003J\t\u0010O\u001a\u00020\u0016HÆ\u0003J\t\u0010P\u001a\u00020\u0016HÆ\u0003J\t\u0010Q\u001a\u00020\u0016HÆ\u0003J\u000e\u0010R\u001a\u00020\u001cHÀ\u0003¢\u0006\u0002\bSJ\t\u0010T\u001a\u00020\u000bHÆ\u0003J\t\u0010U\u001a\u00020\u0016HÆ\u0003JÅ\u0001\u0010V\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u00162\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0016HÆ\u0001J\t\u0010W\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u00103R\u0011\u0010\u0017\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00103R\u0011\u0010\u0018\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u00103R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0011\u0010\u001a\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\u001d\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0011\u0010\u001e\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u00103R\u0011\u00109\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b:\u0010*R\u0014\u0010B\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010*¨\u0006Y"}, d2 = {"Lim/direct/notification/interactive/INMessageCard;", "Lim/direct/notification/interactive/INCard;", "message", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;", "type", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgItem$IMsgCard;", "common", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;", "richTextContentByteArray", "", SocialConstants.PARAM_COMMENT, "", "commentCtrl", "Lim/direct/notification/interactive/CommentCtrl;", "likeCtrl", "Lim/direct/notification/interactive/LikeCtrl;", "thankCtrl", "Lim/direct/notification/interactive/ThankCtrl;", "minorOperations", "", "Lim/direct/notification/interactive/INMinorOperation;", "isMuted", "", "isPinned", "isUnread", "hasTopSeparator", "hasUnreadMark", "sourceID", "", "messageTips", "isNeedTeach", "<init>", "(Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgItem$IMsgCard;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;[BLjava/lang/String;Lim/direct/notification/interactive/CommentCtrl;Lim/direct/notification/interactive/LikeCtrl;Lim/direct/notification/interactive/ThankCtrl;Ljava/util/List;ZZZZZJLjava/lang/String;Z)V", "getMessage", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgFeedMsgCard;", "getType", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgItem$IMsgCard;", "getCommon", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCommonMsgCard;", "getRichTextContentByteArray", "()[B", "getDescription", "()Ljava/lang/String;", "getCommentCtrl", "()Lim/direct/notification/interactive/CommentCtrl;", "getLikeCtrl", "()Lim/direct/notification/interactive/LikeCtrl;", "getThankCtrl", "()Lim/direct/notification/interactive/ThankCtrl;", "getMinorOperations", "()Ljava/util/List;", "()Z", "getHasTopSeparator", "getHasUnreadMark", "getSourceID$interactive_debug", "()J", "getMessageTips", "timeDescription", "getTimeDescription", "equals", "other", "", "hashCode", "", "isSameWith", "isSameWith$interactive_debug", "itemId", "getItemId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component15$interactive_debug", "component16", "component17", "copy", "toString", "Companion", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INMessageCard implements INCard {
    public static final Companion Companion = new Companion(null);
    private final CommentCtrl commentCtrl;

    /* renamed from: common  reason: collision with root package name */
    private final KCommonMsgCard f1973common;
    private final String description;
    private final boolean hasTopSeparator;
    private final boolean hasUnreadMark;
    private final boolean isMuted;
    private final boolean isNeedTeach;
    private final boolean isPinned;
    private final boolean isUnread;
    private final String itemId;
    private final LikeCtrl likeCtrl;
    private final KMsgFeedMsgCard message;
    private final String messageTips;
    private final List<INMinorOperation> minorOperations;
    private final byte[] richTextContentByteArray;
    private final long sourceID;
    private final ThankCtrl thankCtrl;
    private final KMsgItem.IMsgCard type;

    public final KMsgFeedMsgCard component1() {
        return this.message;
    }

    public final boolean component10() {
        return this.isMuted;
    }

    public final boolean component11() {
        return this.isPinned;
    }

    public final boolean component12() {
        return this.isUnread;
    }

    public final boolean component13() {
        return this.hasTopSeparator;
    }

    public final boolean component14() {
        return this.hasUnreadMark;
    }

    public final long component15$interactive_debug() {
        return this.sourceID;
    }

    public final String component16() {
        return this.messageTips;
    }

    public final boolean component17() {
        return this.isNeedTeach;
    }

    public final KMsgItem.IMsgCard component2() {
        return this.type;
    }

    public final KCommonMsgCard component3() {
        return this.f1973common;
    }

    public final byte[] component4() {
        return this.richTextContentByteArray;
    }

    public final String component5() {
        return this.description;
    }

    public final CommentCtrl component6() {
        return this.commentCtrl;
    }

    public final LikeCtrl component7() {
        return this.likeCtrl;
    }

    public final ThankCtrl component8() {
        return this.thankCtrl;
    }

    public final List<INMinorOperation> component9() {
        return this.minorOperations;
    }

    public final INMessageCard copy(KMsgFeedMsgCard kMsgFeedMsgCard, KMsgItem.IMsgCard iMsgCard, KCommonMsgCard kCommonMsgCard, byte[] bArr, String str, CommentCtrl commentCtrl, LikeCtrl likeCtrl, ThankCtrl thankCtrl, List<? extends INMinorOperation> list, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, long j, String str2, boolean z6) {
        Intrinsics.checkNotNullParameter(kMsgFeedMsgCard, "message");
        Intrinsics.checkNotNullParameter(str, SocialConstants.PARAM_COMMENT);
        Intrinsics.checkNotNullParameter(list, "minorOperations");
        Intrinsics.checkNotNullParameter(str2, "messageTips");
        return new INMessageCard(kMsgFeedMsgCard, iMsgCard, kCommonMsgCard, bArr, str, commentCtrl, likeCtrl, thankCtrl, list, z, z2, z3, z4, z5, j, str2, z6);
    }

    public String toString() {
        KMsgFeedMsgCard kMsgFeedMsgCard = this.message;
        KMsgItem.IMsgCard iMsgCard = this.type;
        KCommonMsgCard kCommonMsgCard = this.f1973common;
        String arrays = Arrays.toString(this.richTextContentByteArray);
        String str = this.description;
        CommentCtrl commentCtrl = this.commentCtrl;
        LikeCtrl likeCtrl = this.likeCtrl;
        ThankCtrl thankCtrl = this.thankCtrl;
        List<INMinorOperation> list = this.minorOperations;
        boolean z = this.isMuted;
        boolean z2 = this.isPinned;
        boolean z3 = this.isUnread;
        boolean z4 = this.hasTopSeparator;
        boolean z5 = this.hasUnreadMark;
        long j = this.sourceID;
        String str2 = this.messageTips;
        return "INMessageCard(message=" + kMsgFeedMsgCard + ", type=" + iMsgCard + ", common=" + kCommonMsgCard + ", richTextContentByteArray=" + arrays + ", description=" + str + ", commentCtrl=" + commentCtrl + ", likeCtrl=" + likeCtrl + ", thankCtrl=" + thankCtrl + ", minorOperations=" + list + ", isMuted=" + z + ", isPinned=" + z2 + ", isUnread=" + z3 + ", hasTopSeparator=" + z4 + ", hasUnreadMark=" + z5 + ", sourceID=" + j + ", messageTips=" + str2 + ", isNeedTeach=" + this.isNeedTeach + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public INMessageCard(KMsgFeedMsgCard message, KMsgItem.IMsgCard type, KCommonMsgCard common2, byte[] richTextContentByteArray, String description, CommentCtrl commentCtrl, LikeCtrl likeCtrl, ThankCtrl thankCtrl, List<? extends INMinorOperation> list, boolean isMuted, boolean isPinned, boolean isUnread, boolean hasTopSeparator, boolean hasUnreadMark, long sourceID, String messageTips, boolean isNeedTeach) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(description, SocialConstants.PARAM_COMMENT);
        Intrinsics.checkNotNullParameter(list, "minorOperations");
        Intrinsics.checkNotNullParameter(messageTips, "messageTips");
        this.message = message;
        this.type = type;
        this.f1973common = common2;
        this.richTextContentByteArray = richTextContentByteArray;
        this.description = description;
        this.commentCtrl = commentCtrl;
        this.likeCtrl = likeCtrl;
        this.thankCtrl = thankCtrl;
        this.minorOperations = list;
        this.isMuted = isMuted;
        this.isPinned = isPinned;
        this.isUnread = isUnread;
        this.hasTopSeparator = hasTopSeparator;
        this.hasUnreadMark = hasUnreadMark;
        this.sourceID = sourceID;
        this.messageTips = messageTips;
        this.isNeedTeach = isNeedTeach;
        KMsgItem.IMsgCard iMsgCard = this.type;
        boolean z = this.isPinned;
        KCommonMsgCard kCommonMsgCard = this.f1973common;
        long id = kCommonMsgCard != null ? kCommonMsgCard.getId() : -1L;
        this.itemId = "INMessageCard type: " + iMsgCard + " pinned " + z + " msgId " + id + " now " + Clock.System.INSTANCE.now() + " + " + Random.Default.nextInt();
    }

    public final KMsgFeedMsgCard getMessage() {
        return this.message;
    }

    public final KMsgItem.IMsgCard getType() {
        return this.type;
    }

    public final KCommonMsgCard getCommon() {
        return this.f1973common;
    }

    public final byte[] getRichTextContentByteArray() {
        return this.richTextContentByteArray;
    }

    public final String getDescription() {
        return this.description;
    }

    public final CommentCtrl getCommentCtrl() {
        return this.commentCtrl;
    }

    public final LikeCtrl getLikeCtrl() {
        return this.likeCtrl;
    }

    public final ThankCtrl getThankCtrl() {
        return this.thankCtrl;
    }

    public final List<INMinorOperation> getMinorOperations() {
        return this.minorOperations;
    }

    public final boolean isMuted() {
        return this.isMuted;
    }

    public final boolean isPinned() {
        return this.isPinned;
    }

    public final boolean isUnread() {
        return this.isUnread;
    }

    public final boolean getHasTopSeparator() {
        return this.hasTopSeparator;
    }

    public final boolean getHasUnreadMark() {
        return this.hasUnreadMark;
    }

    public final long getSourceID$interactive_debug() {
        return this.sourceID;
    }

    public final String getMessageTips() {
        return this.messageTips;
    }

    public final boolean isNeedTeach() {
        return this.isNeedTeach;
    }

    /* compiled from: INState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/direct/notification/interactive/INMessageCard$Companion;", "", "<init>", "()V", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String getTimeDescription() {
        if (this.isMuted) {
            return GetStringById_androidKt.getStringById(441);
        }
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        INMessageCard iNMessageCard = (INMessageCard) other;
        if (!Intrinsics.areEqual(this.message, ((INMessageCard) other).message) || !Intrinsics.areEqual(this.type, ((INMessageCard) other).type) || !Intrinsics.areEqual(this.f1973common, ((INMessageCard) other).f1973common)) {
            return false;
        }
        if (this.richTextContentByteArray != null) {
            if (((INMessageCard) other).richTextContentByteArray == null || !Arrays.equals(this.richTextContentByteArray, ((INMessageCard) other).richTextContentByteArray)) {
                return false;
            }
        } else if (((INMessageCard) other).richTextContentByteArray != null) {
            return false;
        }
        if (Intrinsics.areEqual(getTimeDescription(), ((INMessageCard) other).getTimeDescription()) && Intrinsics.areEqual(this.commentCtrl, ((INMessageCard) other).commentCtrl) && Intrinsics.areEqual(this.likeCtrl, ((INMessageCard) other).likeCtrl) && Intrinsics.areEqual(this.thankCtrl, ((INMessageCard) other).thankCtrl) && Intrinsics.areEqual(this.minorOperations, ((INMessageCard) other).minorOperations) && this.isMuted == ((INMessageCard) other).isMuted && this.isPinned == ((INMessageCard) other).isPinned && this.isUnread == ((INMessageCard) other).isUnread && this.hasTopSeparator == ((INMessageCard) other).hasTopSeparator && this.hasUnreadMark == ((INMessageCard) other).hasUnreadMark) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = this.message.hashCode();
        int i2 = result * 31;
        KMsgItem.IMsgCard iMsgCard = this.type;
        int result2 = i2 + (iMsgCard != null ? iMsgCard.hashCode() : 0);
        int result3 = result2 * 31;
        KCommonMsgCard kCommonMsgCard = this.f1973common;
        int result4 = (result3 + (kCommonMsgCard != null ? kCommonMsgCard.hashCode() : 0)) * 31;
        byte[] bArr = this.richTextContentByteArray;
        int result5 = (((result4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + getTimeDescription().hashCode()) * 31;
        CommentCtrl commentCtrl = this.commentCtrl;
        int result6 = (result5 + (commentCtrl != null ? commentCtrl.hashCode() : 0)) * 31;
        LikeCtrl likeCtrl = this.likeCtrl;
        int result7 = (result6 + (likeCtrl != null ? likeCtrl.hashCode() : 0)) * 31;
        ThankCtrl thankCtrl = this.thankCtrl;
        return ((((((((((((result7 + (thankCtrl != null ? thankCtrl.hashCode() : 0)) * 31) + this.minorOperations.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMuted)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isPinned)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isUnread)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasTopSeparator)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.hasUnreadMark);
    }

    public final boolean isSameWith$interactive_debug(INMessageCard other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (this.message.getMsgId() == other.message.getMsgId() && this.isPinned == other.isPinned) {
            KMsgItem.IMsgCard iMsgCard = this.type;
            Intrinsics.checkNotNull(iMsgCard);
            Class<?> cls = iMsgCard.getClass();
            KMsgItem.IMsgCard iMsgCard2 = other.type;
            Intrinsics.checkNotNull(iMsgCard2);
            if (cls == iMsgCard2.getClass()) {
                return true;
            }
        }
        return false;
    }

    @Override // im.direct.notification.interactive.INCard
    public String getItemId() {
        return this.itemId;
    }
}