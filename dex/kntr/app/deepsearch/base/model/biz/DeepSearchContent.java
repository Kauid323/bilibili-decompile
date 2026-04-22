package kntr.app.deepsearch.base.model.biz;

import BottomSheetItemData$;
import com.bapis.bilibili.app.dynamic.v2.KModuleParagraph;
import com.bapis.bilibili.broadcast.message.deepsearch.KAuthorCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KGreetings;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCard;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardItem;
import com.bapis.bilibili.broadcast.message.deepsearch.KPictureCardPreview;
import com.bapis.bilibili.broadcast.message.deepsearch.KThinking;
import com.bapis.bilibili.broadcast.message.deepsearch.KVideoCard;
import java.util.List;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepSearchContent.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000f\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0082\u0001\u000f\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", RoomRecommendViewModel.EMPTY_CURSOR, "Greet", "ThinkNavigation", "ThinkContent", "Query", "Author", "Video", "Text", "Picture", "PictureCardItem", "PictureCardPreview", "EmbedModule", "Retry", "AnswerStop", "SessionEndTimeLine", "Placeholder", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$AnswerStop;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$EmbedModule;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Greet;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Picture;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardItem;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardPreview;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Placeholder;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Query;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Retry;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$SessionEndTimeLine;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Text;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$ThinkContent;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$ThinkNavigation;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Video;", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchContent {

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Greet;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KGreetings;", "avatar", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KGreetings;Ljava/lang/String;)V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KGreetings;", "getAvatar", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Greet implements DeepSearchContent {
        private final String avatar;
        private final KGreetings value;

        public static /* synthetic */ Greet copy$default(Greet greet, KGreetings kGreetings, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                kGreetings = greet.value;
            }
            if ((i & 2) != 0) {
                str = greet.avatar;
            }
            return greet.copy(kGreetings, str);
        }

        public final KGreetings component1() {
            return this.value;
        }

        public final String component2() {
            return this.avatar;
        }

        public final Greet copy(KGreetings kGreetings, String str) {
            Intrinsics.checkNotNullParameter(kGreetings, "value");
            Intrinsics.checkNotNullParameter(str, "avatar");
            return new Greet(kGreetings, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Greet) {
                Greet greet = (Greet) obj;
                return Intrinsics.areEqual(this.value, greet.value) && Intrinsics.areEqual(this.avatar, greet.avatar);
            }
            return false;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + this.avatar.hashCode();
        }

        public String toString() {
            KGreetings kGreetings = this.value;
            return "Greet(value=" + kGreetings + ", avatar=" + this.avatar + ")";
        }

        public Greet(KGreetings value, String avatar) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            this.value = value;
            this.avatar = avatar;
        }

        public final KGreetings getValue() {
            return this.value;
        }

        public final String getAvatar() {
            return this.avatar;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$ThinkNavigation;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "text", RoomRecommendViewModel.EMPTY_CURSOR, "content", "isAvatarAnimation", RoomRecommendViewModel.EMPTY_CURSOR, AdAlarmExtraKey.STATUS, "Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkStatus;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLkntr/app/deepsearch/base/model/biz/DeepSearchThinkStatus;)V", "thinkStatus", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/bapis/bilibili/broadcast/message/deepsearch/KThinking$KStatus;)V", "getText", "()Ljava/lang/String;", "getContent", "()Z", "getStatus", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchThinkStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ThinkNavigation implements DeepSearchContent {
        private final String content;
        private final boolean isAvatarAnimation;
        private final DeepSearchThinkStatus status;
        private final String text;

        public static /* synthetic */ ThinkNavigation copy$default(ThinkNavigation thinkNavigation, String str, String str2, boolean z, DeepSearchThinkStatus deepSearchThinkStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = thinkNavigation.text;
            }
            if ((i & 2) != 0) {
                str2 = thinkNavigation.content;
            }
            if ((i & 4) != 0) {
                z = thinkNavigation.isAvatarAnimation;
            }
            if ((i & 8) != 0) {
                deepSearchThinkStatus = thinkNavigation.status;
            }
            return thinkNavigation.copy(str, str2, z, deepSearchThinkStatus);
        }

        public final String component1() {
            return this.text;
        }

        public final String component2() {
            return this.content;
        }

        public final boolean component3() {
            return this.isAvatarAnimation;
        }

        public final DeepSearchThinkStatus component4() {
            return this.status;
        }

        public final ThinkNavigation copy(String str, String str2, boolean z, DeepSearchThinkStatus deepSearchThinkStatus) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(str2, "content");
            Intrinsics.checkNotNullParameter(deepSearchThinkStatus, AdAlarmExtraKey.STATUS);
            return new ThinkNavigation(str, str2, z, deepSearchThinkStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ThinkNavigation) {
                ThinkNavigation thinkNavigation = (ThinkNavigation) obj;
                return Intrinsics.areEqual(this.text, thinkNavigation.text) && Intrinsics.areEqual(this.content, thinkNavigation.content) && this.isAvatarAnimation == thinkNavigation.isAvatarAnimation && this.status == thinkNavigation.status;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.text.hashCode() * 31) + this.content.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isAvatarAnimation)) * 31) + this.status.hashCode();
        }

        public String toString() {
            String str = this.text;
            String str2 = this.content;
            boolean z = this.isAvatarAnimation;
            return "ThinkNavigation(text=" + str + ", content=" + str2 + ", isAvatarAnimation=" + z + ", status=" + this.status + ")";
        }

        public ThinkNavigation(String text, String content, boolean isAvatarAnimation, DeepSearchThinkStatus status) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(status, AdAlarmExtraKey.STATUS);
            this.text = text;
            this.content = content;
            this.isAvatarAnimation = isAvatarAnimation;
            this.status = status;
        }

        public final String getText() {
            return this.text;
        }

        public final String getContent() {
            return this.content;
        }

        public final boolean isAvatarAnimation() {
            return this.isAvatarAnimation;
        }

        public final DeepSearchThinkStatus getStatus() {
            return this.status;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ThinkNavigation(String text, String content, boolean isAvatarAnimation, KThinking.KStatus thinkStatus) {
            this(text, content, isAvatarAnimation, r0);
            DeepSearchThinkStatus deepSearchThinkStatus;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(thinkStatus, "thinkStatus");
            if (thinkStatus instanceof KThinking.KStatus.INVALID) {
                deepSearchThinkStatus = DeepSearchThinkStatus.START;
            } else if (thinkStatus instanceof KThinking.KStatus.THINKING) {
                deepSearchThinkStatus = DeepSearchThinkStatus.THINKING;
            } else if (thinkStatus instanceof KThinking.KStatus.FINISH) {
                deepSearchThinkStatus = DeepSearchThinkStatus.END;
            } else {
                deepSearchThinkStatus = DeepSearchThinkStatus.NONE;
            }
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$ThinkContent;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getValue$annotations", "()V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ThinkContent implements DeepSearchContent {
        private final String value;

        public static /* synthetic */ ThinkContent copy$default(ThinkContent thinkContent, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = thinkContent.value;
            }
            return thinkContent.copy(str);
        }

        public static /* synthetic */ void getValue$annotations() {
        }

        public final String component1() {
            return this.value;
        }

        public final ThinkContent copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new ThinkContent(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ThinkContent) && Intrinsics.areEqual(this.value, ((ThinkContent) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "ThinkContent(value=" + this.value + ")";
        }

        public ThinkContent(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Query;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "query", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Query implements DeepSearchContent {
        private final String query;

        public static /* synthetic */ Query copy$default(Query query, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = query.query;
            }
            return query.copy(str);
        }

        public final String component1() {
            return this.query;
        }

        public final Query copy(String str) {
            Intrinsics.checkNotNullParameter(str, "query");
            return new Query(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Query) && Intrinsics.areEqual(this.query, ((Query) obj).query);
        }

        public int hashCode() {
            return this.query.hashCode();
        }

        public String toString() {
            return "Query(query=" + this.query + ")";
        }

        public Query(String query) {
            Intrinsics.checkNotNullParameter(query, "query");
            this.query = query;
        }

        public final String getQuery() {
            return this.query;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KAuthorCard;", "textLayout", "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KAuthorCard;Lkntr/app/deepsearch/base/model/biz/TextLayout;)V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KAuthorCard;", "getTextLayout", "()Lkntr/app/deepsearch/base/model/biz/TextLayout;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Author implements DeepSearchContent {
        private final TextLayout textLayout;
        private final KAuthorCard value;

        public static /* synthetic */ Author copy$default(Author author, KAuthorCard kAuthorCard, TextLayout textLayout, int i, Object obj) {
            if ((i & 1) != 0) {
                kAuthorCard = author.value;
            }
            if ((i & 2) != 0) {
                textLayout = author.textLayout;
            }
            return author.copy(kAuthorCard, textLayout);
        }

        public final KAuthorCard component1() {
            return this.value;
        }

        public final TextLayout component2() {
            return this.textLayout;
        }

        public final Author copy(KAuthorCard kAuthorCard, TextLayout textLayout) {
            Intrinsics.checkNotNullParameter(kAuthorCard, "value");
            return new Author(kAuthorCard, textLayout);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Author) {
                Author author = (Author) obj;
                return Intrinsics.areEqual(this.value, author.value) && Intrinsics.areEqual(this.textLayout, author.textLayout);
            }
            return false;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + (this.textLayout == null ? 0 : this.textLayout.hashCode());
        }

        public String toString() {
            KAuthorCard kAuthorCard = this.value;
            return "Author(value=" + kAuthorCard + ", textLayout=" + this.textLayout + ")";
        }

        public Author(KAuthorCard value, TextLayout textLayout) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
            this.textLayout = textLayout;
        }

        public /* synthetic */ Author(KAuthorCard kAuthorCard, TextLayout textLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kAuthorCard, (i & 2) != 0 ? null : textLayout);
        }

        public final KAuthorCard getValue() {
            return this.value;
        }

        public final TextLayout getTextLayout() {
            return this.textLayout;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Video;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KVideoCard;", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KVideoCard;)V", "getValue$annotations", "()V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KVideoCard;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Video implements DeepSearchContent {
        private final KVideoCard value;

        public static /* synthetic */ Video copy$default(Video video, KVideoCard kVideoCard, int i, Object obj) {
            if ((i & 1) != 0) {
                kVideoCard = video.value;
            }
            return video.copy(kVideoCard);
        }

        public static /* synthetic */ void getValue$annotations() {
        }

        public final KVideoCard component1() {
            return this.value;
        }

        public final Video copy(KVideoCard kVideoCard) {
            Intrinsics.checkNotNullParameter(kVideoCard, "value");
            return new Video(kVideoCard);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Video) && Intrinsics.areEqual(this.value, ((Video) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Video(value=" + this.value + ")";
        }

        public Video(KVideoCard value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final KVideoCard getValue() {
            return this.value;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Text;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "textLayout", "Lkntr/app/deepsearch/base/model/biz/TextLayout;", "<init>", "(Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;Lkntr/app/deepsearch/base/model/biz/TextLayout;)V", "getValue", "()Lcom/bapis/bilibili/app/dynamic/v2/KModuleParagraph;", "getTextLayout", "()Lkntr/app/deepsearch/base/model/biz/TextLayout;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Text implements DeepSearchContent {
        private final TextLayout textLayout;
        private final KModuleParagraph value;

        public static /* synthetic */ Text copy$default(Text text, KModuleParagraph kModuleParagraph, TextLayout textLayout, int i, Object obj) {
            if ((i & 1) != 0) {
                kModuleParagraph = text.value;
            }
            if ((i & 2) != 0) {
                textLayout = text.textLayout;
            }
            return text.copy(kModuleParagraph, textLayout);
        }

        public final KModuleParagraph component1() {
            return this.value;
        }

        public final TextLayout component2() {
            return this.textLayout;
        }

        public final Text copy(KModuleParagraph kModuleParagraph, TextLayout textLayout) {
            return new Text(kModuleParagraph, textLayout);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Text) {
                Text text = (Text) obj;
                return Intrinsics.areEqual(this.value, text.value) && Intrinsics.areEqual(this.textLayout, text.textLayout);
            }
            return false;
        }

        public int hashCode() {
            return ((this.value == null ? 0 : this.value.hashCode()) * 31) + (this.textLayout != null ? this.textLayout.hashCode() : 0);
        }

        public String toString() {
            KModuleParagraph kModuleParagraph = this.value;
            return "Text(value=" + kModuleParagraph + ", textLayout=" + this.textLayout + ")";
        }

        public Text(KModuleParagraph value, TextLayout textLayout) {
            this.value = value;
            this.textLayout = textLayout;
        }

        public /* synthetic */ Text(KModuleParagraph kModuleParagraph, TextLayout textLayout, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(kModuleParagraph, (i & 2) != 0 ? null : textLayout);
        }

        public final KModuleParagraph getValue() {
            return this.value;
        }

        public final TextLayout getTextLayout() {
            return this.textLayout;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Picture;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;", "items", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardItem;", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;Ljava/util/List;)V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCard;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Picture implements DeepSearchContent {
        private final List<PictureCardItem> items;
        private final KPictureCard value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Picture copy$default(Picture picture, KPictureCard kPictureCard, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                kPictureCard = picture.value;
            }
            if ((i & 2) != 0) {
                list = picture.items;
            }
            return picture.copy(kPictureCard, list);
        }

        public final KPictureCard component1() {
            return this.value;
        }

        public final List<PictureCardItem> component2() {
            return this.items;
        }

        public final Picture copy(KPictureCard kPictureCard, List<PictureCardItem> list) {
            Intrinsics.checkNotNullParameter(kPictureCard, "value");
            Intrinsics.checkNotNullParameter(list, "items");
            return new Picture(kPictureCard, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Picture) {
                Picture picture = (Picture) obj;
                return Intrinsics.areEqual(this.value, picture.value) && Intrinsics.areEqual(this.items, picture.items);
            }
            return false;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + this.items.hashCode();
        }

        public String toString() {
            KPictureCard kPictureCard = this.value;
            return "Picture(value=" + kPictureCard + ", items=" + this.items + ")";
        }

        public Picture(KPictureCard value, List<PictureCardItem> list) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(list, "items");
            this.value = value;
            this.items = list;
        }

        public final KPictureCard getValue() {
            return this.value;
        }

        public final List<PictureCardItem> getItems() {
            return this.items;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardItem;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardItem;", "preview", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardPreview;", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardItem;Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardPreview;)V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardItem;", "getPreview", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardPreview;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PictureCardItem implements DeepSearchContent {
        private final PictureCardPreview preview;
        private final KPictureCardItem value;

        public static /* synthetic */ PictureCardItem copy$default(PictureCardItem pictureCardItem, KPictureCardItem kPictureCardItem, PictureCardPreview pictureCardPreview, int i, Object obj) {
            if ((i & 1) != 0) {
                kPictureCardItem = pictureCardItem.value;
            }
            if ((i & 2) != 0) {
                pictureCardPreview = pictureCardItem.preview;
            }
            return pictureCardItem.copy(kPictureCardItem, pictureCardPreview);
        }

        public final KPictureCardItem component1() {
            return this.value;
        }

        public final PictureCardPreview component2() {
            return this.preview;
        }

        public final PictureCardItem copy(KPictureCardItem kPictureCardItem, PictureCardPreview pictureCardPreview) {
            Intrinsics.checkNotNullParameter(kPictureCardItem, "value");
            Intrinsics.checkNotNullParameter(pictureCardPreview, "preview");
            return new PictureCardItem(kPictureCardItem, pictureCardPreview);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PictureCardItem) {
                PictureCardItem pictureCardItem = (PictureCardItem) obj;
                return Intrinsics.areEqual(this.value, pictureCardItem.value) && Intrinsics.areEqual(this.preview, pictureCardItem.preview);
            }
            return false;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + this.preview.hashCode();
        }

        public String toString() {
            KPictureCardItem kPictureCardItem = this.value;
            return "PictureCardItem(value=" + kPictureCardItem + ", preview=" + this.preview + ")";
        }

        public PictureCardItem(KPictureCardItem value, PictureCardPreview preview) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(preview, "preview");
            this.value = value;
            this.preview = preview;
        }

        public final KPictureCardItem getValue() {
            return this.value;
        }

        public final PictureCardPreview getPreview() {
            return this.preview;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$PictureCardPreview;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardPreview;", "authorCard", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;", "<init>", "(Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardPreview;Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;)V", "getValue", "()Lcom/bapis/bilibili/broadcast/message/deepsearch/KPictureCardPreview;", "getAuthorCard", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Author;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class PictureCardPreview implements DeepSearchContent {
        private final Author authorCard;
        private final KPictureCardPreview value;

        public static /* synthetic */ PictureCardPreview copy$default(PictureCardPreview pictureCardPreview, KPictureCardPreview kPictureCardPreview, Author author, int i, Object obj) {
            if ((i & 1) != 0) {
                kPictureCardPreview = pictureCardPreview.value;
            }
            if ((i & 2) != 0) {
                author = pictureCardPreview.authorCard;
            }
            return pictureCardPreview.copy(kPictureCardPreview, author);
        }

        public final KPictureCardPreview component1() {
            return this.value;
        }

        public final Author component2() {
            return this.authorCard;
        }

        public final PictureCardPreview copy(KPictureCardPreview kPictureCardPreview, Author author) {
            return new PictureCardPreview(kPictureCardPreview, author);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof PictureCardPreview) {
                PictureCardPreview pictureCardPreview = (PictureCardPreview) obj;
                return Intrinsics.areEqual(this.value, pictureCardPreview.value) && Intrinsics.areEqual(this.authorCard, pictureCardPreview.authorCard);
            }
            return false;
        }

        public int hashCode() {
            return ((this.value == null ? 0 : this.value.hashCode()) * 31) + (this.authorCard != null ? this.authorCard.hashCode() : 0);
        }

        public String toString() {
            KPictureCardPreview kPictureCardPreview = this.value;
            return "PictureCardPreview(value=" + kPictureCardPreview + ", authorCard=" + this.authorCard + ")";
        }

        public PictureCardPreview(KPictureCardPreview value, Author authorCard) {
            this.value = value;
            this.authorCard = authorCard;
        }

        public final KPictureCardPreview getValue() {
            return this.value;
        }

        public final Author getAuthorCard() {
            return this.authorCard;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$EmbedModule;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataItem;", "<init>", "(Ljava/util/List;)V", "getValue", "()Ljava/util/List;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class EmbedModule implements DeepSearchContent {
        private final List<DeepSearchDataItem> value;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmbedModule copy$default(EmbedModule embedModule, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = embedModule.value;
            }
            return embedModule.copy(list);
        }

        public final List<DeepSearchDataItem> component1() {
            return this.value;
        }

        public final EmbedModule copy(List<DeepSearchDataItem> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            return new EmbedModule(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EmbedModule) && Intrinsics.areEqual(this.value, ((EmbedModule) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "EmbedModule(value=" + this.value + ")";
        }

        public EmbedModule(List<DeepSearchDataItem> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            this.value = list;
        }

        public final List<DeepSearchDataItem> getValue() {
            return this.value;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Retry;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "value", "Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;)V", "getValue$annotations", "()V", "getValue", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchRetryChatModel;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Retry implements DeepSearchContent {
        private final DeepSearchRetryChatModel value;

        public static /* synthetic */ Retry copy$default(Retry retry, DeepSearchRetryChatModel deepSearchRetryChatModel, int i, Object obj) {
            if ((i & 1) != 0) {
                deepSearchRetryChatModel = retry.value;
            }
            return retry.copy(deepSearchRetryChatModel);
        }

        public static /* synthetic */ void getValue$annotations() {
        }

        public final DeepSearchRetryChatModel component1() {
            return this.value;
        }

        public final Retry copy(DeepSearchRetryChatModel deepSearchRetryChatModel) {
            Intrinsics.checkNotNullParameter(deepSearchRetryChatModel, "value");
            return new Retry(deepSearchRetryChatModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Retry) && Intrinsics.areEqual(this.value, ((Retry) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Retry(value=" + this.value + ")";
        }

        public Retry(DeepSearchRetryChatModel value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        public final DeepSearchRetryChatModel getValue() {
            return this.value;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$AnswerStop;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "queryId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "getQueryId", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class AnswerStop implements DeepSearchContent {
        private final String queryId;
        private final String sessionId;

        public AnswerStop() {
            this(null, null, 3, null);
        }

        public static /* synthetic */ AnswerStop copy$default(AnswerStop answerStop, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = answerStop.sessionId;
            }
            if ((i & 2) != 0) {
                str2 = answerStop.queryId;
            }
            return answerStop.copy(str, str2);
        }

        public final String component1() {
            return this.sessionId;
        }

        public final String component2() {
            return this.queryId;
        }

        public final AnswerStop copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "sessionId");
            Intrinsics.checkNotNullParameter(str2, "queryId");
            return new AnswerStop(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AnswerStop) {
                AnswerStop answerStop = (AnswerStop) obj;
                return Intrinsics.areEqual(this.sessionId, answerStop.sessionId) && Intrinsics.areEqual(this.queryId, answerStop.queryId);
            }
            return false;
        }

        public int hashCode() {
            return (this.sessionId.hashCode() * 31) + this.queryId.hashCode();
        }

        public String toString() {
            String str = this.sessionId;
            return "AnswerStop(sessionId=" + str + ", queryId=" + this.queryId + ")";
        }

        public AnswerStop(String sessionId, String queryId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(queryId, "queryId");
            this.sessionId = sessionId;
            this.queryId = queryId;
        }

        public /* synthetic */ AnswerStop(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str2);
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final String getQueryId() {
            return this.queryId;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$SessionEndTimeLine;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "sessionEndModel", "Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "<init>", "(Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;)V", "getSessionEndModel", "()Lkntr/app/deepsearch/base/model/biz/DeepSearchSessionEndModel;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SessionEndTimeLine implements DeepSearchContent {
        private final DeepSearchSessionEndModel sessionEndModel;

        public static /* synthetic */ SessionEndTimeLine copy$default(SessionEndTimeLine sessionEndTimeLine, DeepSearchSessionEndModel deepSearchSessionEndModel, int i, Object obj) {
            if ((i & 1) != 0) {
                deepSearchSessionEndModel = sessionEndTimeLine.sessionEndModel;
            }
            return sessionEndTimeLine.copy(deepSearchSessionEndModel);
        }

        public final DeepSearchSessionEndModel component1() {
            return this.sessionEndModel;
        }

        public final SessionEndTimeLine copy(DeepSearchSessionEndModel deepSearchSessionEndModel) {
            Intrinsics.checkNotNullParameter(deepSearchSessionEndModel, "sessionEndModel");
            return new SessionEndTimeLine(deepSearchSessionEndModel);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionEndTimeLine) && Intrinsics.areEqual(this.sessionEndModel, ((SessionEndTimeLine) obj).sessionEndModel);
        }

        public int hashCode() {
            return this.sessionEndModel.hashCode();
        }

        public String toString() {
            return "SessionEndTimeLine(sessionEndModel=" + this.sessionEndModel + ")";
        }

        public SessionEndTimeLine(DeepSearchSessionEndModel sessionEndModel) {
            Intrinsics.checkNotNullParameter(sessionEndModel, "sessionEndModel");
            this.sessionEndModel = sessionEndModel;
        }

        public final DeepSearchSessionEndModel getSessionEndModel() {
            return this.sessionEndModel;
        }
    }

    /* compiled from: DeepSearchContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchContent$Placeholder;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchContent;", "<init>", "()V", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Placeholder implements DeepSearchContent {
        public static final Placeholder INSTANCE = new Placeholder();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1239621037;
        }

        public String toString() {
            return "Placeholder";
        }

        private Placeholder() {
        }
    }
}