package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.StorageInfoImpl_androidKt;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/list/ResolveStorageProvider;", "Lvideo/biz/offline/list/logic/list/IResolveProvider;", "video", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;)V", "getVideo", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ResolveStorageProvider implements IResolveProvider {
    public static final int $stable = OfflineVideoEntity.$stable;

    /* renamed from: video  reason: collision with root package name */
    private final OfflineVideoEntity f30video;

    public ResolveStorageProvider(OfflineVideoEntity video2) {
        Intrinsics.checkNotNullParameter(video2, "video");
        this.f30video = video2;
    }

    public final OfflineVideoEntity getVideo() {
        return this.f30video;
    }

    @Override // video.biz.offline.list.logic.list.IResolveProvider
    public Object title(Continuation<? super String> continuation) {
        return "存储目录:";
    }

    @Override // video.biz.offline.list.logic.list.IResolveProvider
    public Object content(Continuation<? super String> continuation) {
        return StorageInfoImpl_androidKt.pathInPrimaryStorage(this.f30video.getStoragePath()) ? "手机默认存储" : "外置存储";
    }
}