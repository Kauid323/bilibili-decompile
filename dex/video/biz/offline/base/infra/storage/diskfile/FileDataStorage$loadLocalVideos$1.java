package video.biz.offline.base.infra.storage.diskfile;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.infra.storage.diskfile.FileDataStorage", f = "FileDataStorage.kt", i = {1}, l = {PlayerToastConfig.QUEUE_INSERT, PlayerToastConfig.QUEUE_REFRESH}, m = "loadLocalVideos", n = {"entities"}, s = {"L$0"}, v = 1)
public final class FileDataStorage$loadLocalVideos$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileDataStorage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileDataStorage$loadLocalVideos$1(FileDataStorage fileDataStorage, Continuation<? super FileDataStorage$loadLocalVideos$1> continuation) {
        super(continuation);
        this.this$0 = fileDataStorage;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadLocalVideos((Continuation) this);
    }
}