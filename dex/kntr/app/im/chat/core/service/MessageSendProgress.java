package kntr.app.im.chat.core.service;

import kntr.app.im.chat.core.model.EntityMessage;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageSendService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001:\u0007\u0006\u0007\b\t\n\u000b\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0001\u0007\r\u000e\u000f\u0010\u0011\u0012\u0013¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress;", RoomRecommendViewModel.EMPTY_CURSOR, "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "Init", "Pending", "Uploading", "ReadyToSend", "Sending", "SendSuccess", "SendFailed", "Lkntr/app/im/chat/core/service/MessageSendProgress$Init;", "Lkntr/app/im/chat/core/service/MessageSendProgress$Pending;", "Lkntr/app/im/chat/core/service/MessageSendProgress$ReadyToSend;", "Lkntr/app/im/chat/core/service/MessageSendProgress$SendFailed;", "Lkntr/app/im/chat/core/service/MessageSendProgress$SendSuccess;", "Lkntr/app/im/chat/core/service/MessageSendProgress$Sending;", "Lkntr/app/im/chat/core/service/MessageSendProgress$Uploading;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MessageSendProgress {
    boolean getEndState();

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$Init;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "<init>", "()V", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Init implements MessageSendProgress {
        public static final int $stable = 0;
        public static final Init INSTANCE = new Init();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Init) {
                Init init = (Init) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 742591588;
        }

        public String toString() {
            return "Init";
        }

        private Init() {
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return false;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$Pending;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "<init>", "()V", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Pending implements MessageSendProgress {
        public static final int $stable = 0;
        public static final Pending INSTANCE = new Pending();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pending) {
                Pending pending = (Pending) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 833597891;
        }

        public String toString() {
            return "Pending";
        }

        private Pending() {
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return false;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$Uploading;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "progress", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(F)V", "getProgress", "()F", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Uploading implements MessageSendProgress {
        public static final int $stable = 0;
        private final float progress;

        public static /* synthetic */ Uploading copy$default(Uploading uploading, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = uploading.progress;
            }
            return uploading.copy(f);
        }

        public final float component1() {
            return this.progress;
        }

        public final Uploading copy(float f) {
            return new Uploading(f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Uploading) && Float.compare(this.progress, ((Uploading) obj).progress) == 0;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.progress);
        }

        public String toString() {
            return "Uploading(progress=" + this.progress + ")";
        }

        public Uploading(float progress) {
            this.progress = progress;
        }

        public final float getProgress() {
            return this.progress;
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return false;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$ReadyToSend;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "<init>", "()V", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class ReadyToSend implements MessageSendProgress {
        public static final int $stable = 0;
        public static final ReadyToSend INSTANCE = new ReadyToSend();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ReadyToSend) {
                ReadyToSend readyToSend = (ReadyToSend) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1343786578;
        }

        public String toString() {
            return "ReadyToSend";
        }

        private ReadyToSend() {
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return false;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$Sending;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "<init>", "()V", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Sending implements MessageSendProgress {
        public static final int $stable = 0;
        public static final Sending INSTANCE = new Sending();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Sending) {
                Sending sending = (Sending) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -798858362;
        }

        public String toString() {
            return "Sending";
        }

        private Sending() {
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return false;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$SendSuccess;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "serverMessage", "Lkntr/app/im/chat/core/model/EntityMessage;", "<init>", "(Lkntr/app/im/chat/core/model/EntityMessage;)V", "getServerMessage", "()Lkntr/app/im/chat/core/model/EntityMessage;", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SendSuccess implements MessageSendProgress {
        public static final int $stable = 0;
        private final EntityMessage serverMessage;

        public static /* synthetic */ SendSuccess copy$default(SendSuccess sendSuccess, EntityMessage entityMessage, int i, Object obj) {
            if ((i & 1) != 0) {
                entityMessage = sendSuccess.serverMessage;
            }
            return sendSuccess.copy(entityMessage);
        }

        public final EntityMessage component1() {
            return this.serverMessage;
        }

        public final SendSuccess copy(EntityMessage entityMessage) {
            Intrinsics.checkNotNullParameter(entityMessage, "serverMessage");
            return new SendSuccess(entityMessage);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendSuccess) && Intrinsics.areEqual(this.serverMessage, ((SendSuccess) obj).serverMessage);
        }

        public int hashCode() {
            return this.serverMessage.hashCode();
        }

        public String toString() {
            return "SendSuccess(serverMessage=" + this.serverMessage + ")";
        }

        public SendSuccess(EntityMessage serverMessage) {
            Intrinsics.checkNotNullParameter(serverMessage, "serverMessage");
            this.serverMessage = serverMessage;
        }

        public final EntityMessage getServerMessage() {
            return this.serverMessage;
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return true;
        }
    }

    /* compiled from: MessageSendService.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\r\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\u0017\u0010\u000e\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lkntr/app/im/chat/core/service/MessageSendProgress$SendFailed;", "Lkntr/app/im/chat/core/service/MessageSendProgress;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ljava/lang/Exception;)V", "getError", "()Ljava/lang/Exception;", "endState", RoomRecommendViewModel.EMPTY_CURSOR, "getEndState", "()Z", "component1", "copy", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class SendFailed implements MessageSendProgress {
        public static final int $stable = 8;
        private final Exception error;

        public static /* synthetic */ SendFailed copy$default(SendFailed sendFailed, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                exc = sendFailed.error;
            }
            return sendFailed.copy(exc);
        }

        public final Exception component1() {
            return this.error;
        }

        public final SendFailed copy(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "error");
            return new SendFailed(exc);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SendFailed) && Intrinsics.areEqual(this.error, ((SendFailed) obj).error);
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "SendFailed(error=" + this.error + ")";
        }

        public SendFailed(Exception error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public final Exception getError() {
            return this.error;
        }

        @Override // kntr.app.im.chat.core.service.MessageSendProgress
        public boolean getEndState() {
            return true;
        }
    }
}