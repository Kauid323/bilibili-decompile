package tv.danmaku.biliplayerv2.service.resolve;

import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.media.resource.MediaResource;
import com.bilibili.player.history.IMediaHistoryKeyParams;
import com.bilibili.player.history.IMediaHistoryStorage;
import com.bilibili.player.history.MediaHistoryEntry;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: CommonResolveTasks.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\f\r\u000e\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016¨\u0006\u0010"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask;", "Ltv/danmaku/biliplayerv2/service/resolve/Task;", "Lcom/bilibili/lib/media/resource/MediaResource;", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ErrorInfo;", "<init>", "()V", "getBackupResult", "setHistoryProgressReader", "", "reader", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$HistoryProgressReader;", "ErrorInfo", "ActionType", "IHistoryProgressReader", "HistoryProgressReader", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class AbsMediaResourceResolveTask extends Task<MediaResource, ErrorInfo> {

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ActionType;", "", "<init>", "(Ljava/lang/String;I)V", "RETURN", "RELOAD", "REDIRECT", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public enum ActionType {
        RETURN,
        RELOAD,
        REDIRECT;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<ActionType> getEntries() {
            return $ENTRIES;
        }
    }

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ErrorInfo;", "", "<init>", "()V", "hint", "", "getHint", "()Ljava/lang/String;", "setHint", "(Ljava/lang/String;)V", "actionMsg", "getActionMsg", "setActionMsg", "actionUrl", "getActionUrl", "setActionUrl", "actionType", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ActionType;", "getActionType", "()Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ActionType;", "setActionType", "(Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$ActionType;)V", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ErrorInfo {
        private Exception exception;
        private String hint = "";
        private String actionMsg = "";
        private String actionUrl = "";
        private ActionType actionType = ActionType.RELOAD;

        public final String getHint() {
            return this.hint;
        }

        public final void setHint(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.hint = str;
        }

        public final String getActionMsg() {
            return this.actionMsg;
        }

        public final void setActionMsg(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.actionMsg = str;
        }

        public final String getActionUrl() {
            return this.actionUrl;
        }

        public final void setActionUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.actionUrl = str;
        }

        public final ActionType getActionType() {
            return this.actionType;
        }

        public final void setActionType(ActionType actionType) {
            Intrinsics.checkNotNullParameter(actionType, "<set-?>");
            this.actionType = actionType;
        }

        public final Exception getException() {
            return this.exception;
        }

        public final void setException(Exception exc) {
            this.exception = exc;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaResource getBackupResult() {
        if (getBackupTask() != null) {
            Task<?, ?> backupTask = getBackupTask();
            Intrinsics.checkNotNull(backupTask);
            Object result = backupTask.getResult();
            if (result instanceof MediaResource) {
                return (MediaResource) result;
            }
            return null;
        }
        return null;
    }

    public void setHistoryProgressReader(IHistoryProgressReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
    }

    public void setHistoryProgressReader(HistoryProgressReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
    }

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "", "read", "", "mediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "isForceAccurateSeek", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface IHistoryProgressReader {
        boolean isForceAccurateSeek();

        int read();

        int read(MediaResource mediaResource);

        /* compiled from: CommonResolveTasks.kt */
        /* renamed from: tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask$IHistoryProgressReader$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
        public final /* synthetic */ class CC {
        }
    }

    /* compiled from: CommonResolveTasks.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$HistoryProgressReader;", "Ltv/danmaku/biliplayerv2/service/resolve/AbsMediaResourceResolveTask$IHistoryProgressReader;", "mPlayableParams", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "mHistoryStorage", "Lcom/bilibili/player/history/IMediaHistoryStorage;", "Lcom/bilibili/player/history/MediaHistoryEntry;", "<init>", "(Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;Lcom/bilibili/player/history/IMediaHistoryStorage;)V", "getMediaHistoryStorage", "mediaHistoryKeyParams", "Lcom/bilibili/player/history/IMediaHistoryKeyParams;", "read", "", "mediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "isForceAccurateSeek", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class HistoryProgressReader implements IHistoryProgressReader {
        private final IMediaHistoryStorage<MediaHistoryEntry> mHistoryStorage;
        private final Video.PlayableParams mPlayableParams;

        public HistoryProgressReader(Video.PlayableParams mPlayableParams, IMediaHistoryStorage<MediaHistoryEntry> iMediaHistoryStorage) {
            Intrinsics.checkNotNullParameter(mPlayableParams, "mPlayableParams");
            this.mPlayableParams = mPlayableParams;
            this.mHistoryStorage = iMediaHistoryStorage;
        }

        public /* synthetic */ HistoryProgressReader(Video.PlayableParams playableParams, IMediaHistoryStorage iMediaHistoryStorage, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(playableParams, (i & 2) != 0 ? null : iMediaHistoryStorage);
        }

        private final IMediaHistoryStorage<MediaHistoryEntry> getMediaHistoryStorage(IMediaHistoryKeyParams mediaHistoryKeyParams) {
            if (mediaHistoryKeyParams == null) {
                return null;
            }
            Object obj = BLRouter.INSTANCE.get(IMediaHistoryStorage.class, mediaHistoryKeyParams.getType());
            if (obj instanceof IMediaHistoryStorage) {
                return (IMediaHistoryStorage) obj;
            }
            return null;
        }

        @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
        public int read(MediaResource mediaResource) {
            IMediaHistoryKeyParams historyKeyParams = this.mPlayableParams.getMediaHistoryKayParams();
            if (historyKeyParams == null) {
                return 0;
            }
            IMediaHistoryStorage historyStorage = this.mHistoryStorage;
            if (historyStorage == null && (historyStorage = getMediaHistoryStorage(historyKeyParams)) == null) {
                return 0;
            }
            MediaHistoryEntry historyEntry = historyStorage.read(historyKeyParams);
            BLog.i("history-progress: " + (historyEntry != null ? historyEntry.getProgress() : 0));
            if (historyEntry != null) {
                return historyEntry.getProgress();
            }
            return 0;
        }

        @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
        public int read() {
            IMediaHistoryKeyParams historyKeyParams = this.mPlayableParams.getMediaHistoryKayParams();
            if (historyKeyParams == null) {
                return 0;
            }
            IMediaHistoryStorage historyStorage = this.mHistoryStorage;
            if (historyStorage == null && (historyStorage = getMediaHistoryStorage(historyKeyParams)) == null) {
                return 0;
            }
            MediaHistoryEntry historyEntry = historyStorage.read(historyKeyParams);
            BLog.i("history-progress: " + (historyEntry != null ? historyEntry.getProgress() : 0));
            if (historyEntry != null) {
                return historyEntry.getProgress();
            }
            return 0;
        }

        @Override // tv.danmaku.biliplayerv2.service.resolve.AbsMediaResourceResolveTask.IHistoryProgressReader
        public boolean isForceAccurateSeek() {
            MediaHistoryEntry historyEntry;
            IMediaHistoryKeyParams historyKeyParams = this.mPlayableParams.getMediaHistoryKayParams();
            if (historyKeyParams == null) {
                return false;
            }
            IMediaHistoryStorage historyStorage = this.mHistoryStorage;
            if ((historyStorage == null && (historyStorage = getMediaHistoryStorage(historyKeyParams)) == null) || (historyEntry = historyStorage.read(historyKeyParams)) == null) {
                return false;
            }
            return historyEntry.isForceStartAccurateSeek();
        }
    }
}