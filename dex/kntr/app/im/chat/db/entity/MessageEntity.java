package kntr.app.im.chat.db.entity;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;

/* compiled from: MessageEntity.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0000J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\rHÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u00104\u001a\u00020\u0013HÆ\u0003J\u0085\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001J\u0013\u00106\u001a\u00020\u00132\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\rHÖ\u0001J\t\u00108\u001a\u00020\nHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010&¨\u00069"}, d2 = {"Lkntr/app/im/chat/db/entity/MessageEntity;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lkntr/app/im/chat/db/entity/SessionIdEntity;", "msgKey", "sequenceNumber", "subsequenceNumber", "token", RoomRecommendViewModel.EMPTY_CURSOR, "content", "sendStatus", RoomRecommendViewModel.EMPTY_CURSOR, "createTime", "Lkotlinx/datetime/Instant;", "updateTime", "deleteTime", "isRealtimeMessage", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(JLkntr/app/im/chat/db/entity/SessionIdEntity;JJJLjava/lang/String;Ljava/lang/String;ILkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Lkotlinx/datetime/Instant;Z)V", "getId", "()J", "getSessionId", "()Lkntr/app/im/chat/db/entity/SessionIdEntity;", "getMsgKey", "getSequenceNumber", "getSubsequenceNumber", "getToken", "()Ljava/lang/String;", "getContent", "getSendStatus", "()I", "getCreateTime", "()Lkotlinx/datetime/Instant;", "getUpdateTime", "getDeleteTime", "()Z", "checkNeedUpdate", "other", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "hashCode", "toString", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MessageEntity {
    private final String content;
    private final Instant createTime;
    private final Instant deleteTime;
    private final long id;
    private final boolean isRealtimeMessage;
    private final long msgKey;
    private final int sendStatus;
    private final long sequenceNumber;
    private final SessionIdEntity sessionId;
    private final long subsequenceNumber;
    private final String token;
    private final Instant updateTime;

    public final long component1() {
        return this.id;
    }

    public final Instant component10() {
        return this.updateTime;
    }

    public final Instant component11() {
        return this.deleteTime;
    }

    public final boolean component12() {
        return this.isRealtimeMessage;
    }

    public final SessionIdEntity component2() {
        return this.sessionId;
    }

    public final long component3() {
        return this.msgKey;
    }

    public final long component4() {
        return this.sequenceNumber;
    }

    public final long component5() {
        return this.subsequenceNumber;
    }

    public final String component6() {
        return this.token;
    }

    public final String component7() {
        return this.content;
    }

    public final int component8() {
        return this.sendStatus;
    }

    public final Instant component9() {
        return this.createTime;
    }

    public final MessageEntity copy(long j2, SessionIdEntity sessionIdEntity, long j3, long j4, long j5, String str, String str2, int i, Instant instant, Instant instant2, Instant instant3, boolean z) {
        Intrinsics.checkNotNullParameter(sessionIdEntity, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(instant, "createTime");
        Intrinsics.checkNotNullParameter(instant2, "updateTime");
        return new MessageEntity(j2, sessionIdEntity, j3, j4, j5, str, str2, i, instant, instant2, instant3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageEntity) {
            MessageEntity messageEntity = (MessageEntity) obj;
            return this.id == messageEntity.id && Intrinsics.areEqual(this.sessionId, messageEntity.sessionId) && this.msgKey == messageEntity.msgKey && this.sequenceNumber == messageEntity.sequenceNumber && this.subsequenceNumber == messageEntity.subsequenceNumber && Intrinsics.areEqual(this.token, messageEntity.token) && Intrinsics.areEqual(this.content, messageEntity.content) && this.sendStatus == messageEntity.sendStatus && Intrinsics.areEqual(this.createTime, messageEntity.createTime) && Intrinsics.areEqual(this.updateTime, messageEntity.updateTime) && Intrinsics.areEqual(this.deleteTime, messageEntity.deleteTime) && this.isRealtimeMessage == messageEntity.isRealtimeMessage;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + this.sessionId.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.msgKey)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sequenceNumber)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.subsequenceNumber)) * 31) + (this.token == null ? 0 : this.token.hashCode())) * 31) + this.content.hashCode()) * 31) + this.sendStatus) * 31) + this.createTime.hashCode()) * 31) + this.updateTime.hashCode()) * 31) + (this.deleteTime != null ? this.deleteTime.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isRealtimeMessage);
    }

    public String toString() {
        long j2 = this.id;
        SessionIdEntity sessionIdEntity = this.sessionId;
        long j3 = this.msgKey;
        long j4 = this.sequenceNumber;
        long j5 = this.subsequenceNumber;
        String str = this.token;
        String str2 = this.content;
        int i = this.sendStatus;
        Instant instant = this.createTime;
        Instant instant2 = this.updateTime;
        Instant instant3 = this.deleteTime;
        return "MessageEntity(id=" + j2 + ", sessionId=" + sessionIdEntity + ", msgKey=" + j3 + ", sequenceNumber=" + j4 + ", subsequenceNumber=" + j5 + ", token=" + str + ", content=" + str2 + ", sendStatus=" + i + ", createTime=" + instant + ", updateTime=" + instant2 + ", deleteTime=" + instant3 + ", isRealtimeMessage=" + this.isRealtimeMessage + ")";
    }

    public MessageEntity(long id, SessionIdEntity sessionId, long msgKey, long sequenceNumber, long subsequenceNumber, String token, String content, int sendStatus, Instant createTime, Instant updateTime, Instant deleteTime, boolean isRealtimeMessage) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(updateTime, "updateTime");
        this.id = id;
        this.sessionId = sessionId;
        this.msgKey = msgKey;
        this.sequenceNumber = sequenceNumber;
        this.subsequenceNumber = subsequenceNumber;
        this.token = token;
        this.content = content;
        this.sendStatus = sendStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.isRealtimeMessage = isRealtimeMessage;
    }

    public /* synthetic */ MessageEntity(long j2, SessionIdEntity sessionIdEntity, long j3, long j4, long j5, String str, String str2, int i, Instant instant, Instant instant2, Instant instant3, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j2, sessionIdEntity, j3, j4, j5, (i2 & 32) != 0 ? null : str, str2, i, instant, instant2, (i2 & 1024) != 0 ? null : instant3, (i2 & 2048) != 0 ? false : z);
    }

    public final long getId() {
        return this.id;
    }

    public final SessionIdEntity getSessionId() {
        return this.sessionId;
    }

    public final long getMsgKey() {
        return this.msgKey;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final long getSubsequenceNumber() {
        return this.subsequenceNumber;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getSendStatus() {
        return this.sendStatus;
    }

    public final Instant getCreateTime() {
        return this.createTime;
    }

    public final Instant getUpdateTime() {
        return this.updateTime;
    }

    public final Instant getDeleteTime() {
        return this.deleteTime;
    }

    public final boolean isRealtimeMessage() {
        return this.isRealtimeMessage;
    }

    public final boolean checkNeedUpdate(MessageEntity other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return (this.sendStatus == other.sendStatus && Intrinsics.areEqual(this.content, other.content) && Intrinsics.areEqual(this.deleteTime, other.deleteTime) && Intrinsics.areEqual(this.updateTime, other.updateTime)) ? false : true;
    }
}