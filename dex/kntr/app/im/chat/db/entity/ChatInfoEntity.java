package kntr.app.im.chat.db.entity;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KChatInfoReply;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Clock;
import kotlinx.serialization.json.Json;

/* compiled from: ChatInfoEntity.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\r\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006!"}, d2 = {"Lkntr/app/im/chat/db/entity/ChatInfoEntity;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "content", RoomRecommendViewModel.EMPTY_CURSOR, "createTime", RoomRecommendViewModel.EMPTY_CURSOR, "updateTime", "<init>", "(Lkntr/app/im/chat/db/entity/SessionIdEntity;Ljava/lang/String;JJ)V", "getSessionId", "()Lkntr/app/im/chat/db/entity/SessionIdEntity;", "getContent", "()Ljava/lang/String;", "getCreateTime", "()J", "getUpdateTime", "Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "json", "Lkotlinx/serialization/json/Json;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatInfoEntity {
    public static final Companion Companion = new Companion(null);
    private final String content;
    private final long createTime;
    private final SessionIdEntity sessionId;
    private final long updateTime;

    public static /* synthetic */ ChatInfoEntity copy$default(ChatInfoEntity chatInfoEntity, SessionIdEntity sessionIdEntity, String str, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            sessionIdEntity = chatInfoEntity.sessionId;
        }
        if ((i & 2) != 0) {
            str = chatInfoEntity.content;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j2 = chatInfoEntity.createTime;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = chatInfoEntity.updateTime;
        }
        return chatInfoEntity.copy(sessionIdEntity, str2, j4, j3);
    }

    public final SessionIdEntity component1() {
        return this.sessionId;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.createTime;
    }

    public final long component4() {
        return this.updateTime;
    }

    public final ChatInfoEntity copy(SessionIdEntity sessionIdEntity, String str, long j2, long j3) {
        Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionId");
        Intrinsics.checkNotNullParameter(str, "content");
        return new ChatInfoEntity(sessionIdEntity, str, j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChatInfoEntity) {
            ChatInfoEntity chatInfoEntity = (ChatInfoEntity) obj;
            return Intrinsics.areEqual(this.sessionId, chatInfoEntity.sessionId) && Intrinsics.areEqual(this.content, chatInfoEntity.content) && this.createTime == chatInfoEntity.createTime && this.updateTime == chatInfoEntity.updateTime;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.content.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.createTime)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.updateTime);
    }

    public String toString() {
        SessionIdEntity sessionIdEntity = this.sessionId;
        String str = this.content;
        long j2 = this.createTime;
        return "ChatInfoEntity(sessionId=" + sessionIdEntity + ", content=" + str + ", createTime=" + j2 + ", updateTime=" + this.updateTime + ")";
    }

    public ChatInfoEntity(SessionIdEntity sessionId, String content, long createTime, long updateTime) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(content, "content");
        this.sessionId = sessionId;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ChatInfoEntity(SessionIdEntity sessionIdEntity, String str, long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionIdEntity, str, r3, r5);
        long j4;
        long j5;
        if ((i & 4) == 0) {
            j4 = j2;
        } else {
            j4 = Clock.System.INSTANCE.now().toEpochMilliseconds();
        }
        if ((i & 8) == 0) {
            j5 = j3;
        } else {
            j5 = j4;
        }
    }

    public final SessionIdEntity getSessionId() {
        return this.sessionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* compiled from: ChatInfoEntity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lkntr/app/im/chat/db/entity/ChatInfoEntity$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", ReportBuildInParam.BUILD, "Lkntr/app/im/chat/db/entity/ChatInfoEntity;", "json", "Lkotlinx/serialization/json/Json;", "sessionIdEntity", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "content", "Lcom/bapis/bilibili/app/im/v1/KChatInfoReply;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ChatInfoEntity build(Json json, SessionIdEntity sessionIdEntity, KChatInfoReply content) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionIdEntity");
            Intrinsics.checkNotNullParameter(content, "content");
            return new ChatInfoEntity(sessionIdEntity, json.encodeToString(KChatInfoReply.Companion.serializer(), content), 0L, 0L, 12, null);
        }
    }

    public final KChatInfoReply getContent(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        return (KChatInfoReply) json.decodeFromString(KChatInfoReply.Companion.serializer(), this.content);
    }
}