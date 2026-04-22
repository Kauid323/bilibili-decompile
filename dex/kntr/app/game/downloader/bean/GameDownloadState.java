package kntr.app.game.downloader.bean;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GameDownloadState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0016\u001a\u00020\u0000H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lkntr/app/game/downloader/bean/GameDownloadState;", RoomRecommendViewModel.EMPTY_CURSOR, "progress", RoomRecommendViewModel.EMPTY_CURSOR, "mainText", RoomRecommendViewModel.EMPTY_CURSOR, "inDownload", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(ILjava/lang/String;Z)V", "getProgress", "()I", "setProgress", "(I)V", "getMainText", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", "getInDownload", "()Z", "setInDownload", "(Z)V", "reset", "toString", "Companion", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GameDownloadState {
    private static final int DEFAULT_POOL_SIZE = 10;
    private boolean inDownload;
    private String mainText;
    private int progress;
    public static final Companion Companion = new Companion(null);
    private static final Object queueLock = new Object();
    private static final ArrayDeque<GameDownloadState> queue = new ArrayDeque<>(10);

    public GameDownloadState() {
        this(0, null, false, 7, null);
    }

    public GameDownloadState(int progress, String mainText, boolean inDownload) {
        Intrinsics.checkNotNullParameter(mainText, "mainText");
        this.progress = progress;
        this.mainText = mainText;
        this.inDownload = inDownload;
    }

    public /* synthetic */ GameDownloadState(int i, String str, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? RoomRecommendViewModel.EMPTY_CURSOR : str, (i2 & 4) != 0 ? false : z);
    }

    public final int getProgress() {
        return this.progress;
    }

    public final void setProgress(int i) {
        this.progress = i;
    }

    public final String getMainText() {
        return this.mainText;
    }

    public final void setMainText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mainText = str;
    }

    public final boolean getInDownload() {
        return this.inDownload;
    }

    public final void setInDownload(boolean z) {
        this.inDownload = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GameDownloadState reset() {
        this.progress = 0;
        this.mainText = RoomRecommendViewModel.EMPTY_CURSOR;
        this.inDownload = false;
        return this;
    }

    public String toString() {
        int i = this.progress;
        String str = this.mainText;
        return "GameDownloadState(progress=" + i + ", mainText='" + str + "', inDownload=" + this.inDownload + ")";
    }

    /* compiled from: GameDownloadState.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bR\u0012\u0010\u0004\u001a\u00060\u0001j\u0002`\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkntr/app/game/downloader/bean/GameDownloadState$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "queueLock", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "queue", "Lkotlin/collections/ArrayDeque;", "Lkntr/app/game/downloader/bean/GameDownloadState;", "DEFAULT_POOL_SIZE", RoomRecommendViewModel.EMPTY_CURSOR, "obtain", "progress", "mainText", RoomRecommendViewModel.EMPTY_CURSOR, "inDownload", RoomRecommendViewModel.EMPTY_CURSOR, "recycle", RoomRecommendViewModel.EMPTY_CURSOR, "state", "downloader_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GameDownloadState obtain$default(Companion companion, int i, String str, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            if ((i2 & 2) != 0) {
                str = "下载";
            }
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.obtain(i, str, z);
        }

        public final GameDownloadState obtain(int progress, String mainText, boolean inDownload) {
            GameDownloadState gameDownloadState;
            Intrinsics.checkNotNullParameter(mainText, "mainText");
            synchronized (GameDownloadState.queueLock) {
                if (!GameDownloadState.queue.isEmpty()) {
                    Object removeFirst = GameDownloadState.queue.removeFirst();
                    GameDownloadState $this$obtain_u24lambda_u240_u240 = (GameDownloadState) removeFirst;
                    $this$obtain_u24lambda_u240_u240.setProgress(progress);
                    $this$obtain_u24lambda_u240_u240.setMainText(mainText);
                    $this$obtain_u24lambda_u240_u240.setInDownload(inDownload);
                    gameDownloadState = (GameDownloadState) removeFirst;
                } else {
                    gameDownloadState = null;
                }
            }
            if (gameDownloadState == null) {
                gameDownloadState = new GameDownloadState(progress, mainText, inDownload);
            }
            GameDownloadState state = gameDownloadState;
            return state;
        }

        public final void recycle(GameDownloadState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            synchronized (GameDownloadState.queueLock) {
                if (GameDownloadState.queue.size() < 20) {
                    GameDownloadState.queue.addLast(state.reset());
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    static {
        for (int i = 0; i < 10; i++) {
            synchronized (queueLock) {
                queue.addLast(new GameDownloadState(0, null, false, 7, null));
                Unit unit = Unit.INSTANCE;
            }
        }
    }
}