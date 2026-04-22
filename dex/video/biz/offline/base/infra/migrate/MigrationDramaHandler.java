package video.biz.offline.base.infra.migrate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.infra.storage.diskfile.model.DramaItemModel;
import video.biz.offline.base.infra.utils.DataLog;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: MigrationDramaHandler.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lvideo/biz/offline/base/infra/migrate/MigrationDramaHandler;", "Lvideo/biz/offline/base/infra/migrate/IMigrateHandler;", "<init>", "()V", "step", "Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "getStep", "()Lvideo/biz/offline/base/infra/migrate/MigrationStep;", "doHandle", "Lvideo/biz/offline/base/infra/migrate/MigrationResult;", "chain", "Lvideo/biz/offline/base/infra/migrate/MigrationChain;", "(Lvideo/biz/offline/base/infra/migrate/MigrationChain;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MigrationDramaHandler implements IMigrateHandler {
    public static final int $stable = 0;
    private final MigrationStep step = MigrationStep.DRAMA;

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public MigrationStep getStep() {
        return this.step;
    }

    @Override // video.biz.offline.base.infra.migrate.IMigrateHandler
    public Object doHandle(MigrationChain chain, Continuation<? super MigrationResult> continuation) {
        DramaGroupModel dramaGroupModel;
        Object obj;
        boolean z;
        Object obj2;
        boolean z2;
        boolean z3;
        List dramaGroups = chain.getContext().getDramaGroups();
        List cachedVideos = chain.getContext().getCachedVideos();
        new DataLog().info("MigrationDramaHandler start to handle drama data, size=" + dramaGroups.size() + ", video size=" + cachedVideos.size());
        List $this$map$iv = dramaGroups;
        boolean z4 = false;
        int i = 10;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DramaGroupModel it = (DramaGroupModel) item$iv$iv;
            Iterable $this$map$iv2 = it.getItems();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, i));
            for (Object item$iv$iv2 : $this$map$iv2) {
                destination$iv$iv2.add(Boxing.boxLong(((DramaItemModel) item$iv$iv2).getAid()));
            }
            ArrayList arrayList = (List) destination$iv$iv2;
            new DataLog().info("MigrationDramaHandler groupId:" + it.getId() + " title:" + it.getTitle() + " children" + arrayList);
            destination$iv$iv.add(arrayList);
            $this$map$iv = $this$map$iv;
            z4 = z4;
            i = 10;
        }
        Set dramaAids = CollectionsKt.toSet(CollectionsKt.flatten((List) destination$iv$iv));
        List $this$forEach$iv = cachedVideos;
        for (Object element$iv : $this$forEach$iv) {
            OfflineVideoEntity item = (OfflineVideoEntity) element$iv;
            if (dramaAids.contains(Boxing.boxLong(item.getVideoId()))) {
                Iterator<T> it2 = dramaGroups.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    Iterable $this$any$iv = ((DramaGroupModel) obj2).getItems();
                    if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                        Iterator<T> it3 = $this$any$iv.iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Object element$iv2 = it3.next();
                                if (((DramaItemModel) element$iv2).getAid() == item.getVideoId()) {
                                    z3 = true;
                                    continue;
                                } else {
                                    z3 = false;
                                    continue;
                                }
                                if (z3) {
                                    z2 = true;
                                    continue;
                                    break;
                                }
                            } else {
                                z2 = false;
                                continue;
                                break;
                            }
                        }
                    } else {
                        z2 = false;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
                dramaGroupModel = (DramaGroupModel) obj2;
            } else {
                dramaGroupModel = null;
            }
            DramaGroupModel drama = dramaGroupModel;
            if (drama != null) {
                item.setGroupId(drama.getId());
                item.setGroupTitle(drama.getTitle());
                Iterator<T> it4 = drama.getItems().iterator();
                while (true) {
                    if (!it4.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it4.next();
                    if (((DramaItemModel) obj).getAid() == item.getVideoId()) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                DramaItemModel it5 = (DramaItemModel) obj;
                if (it5 != null) {
                    item.setVideoIndex((it5.getSection() * ((long) IjkMediaCodecInfo.RANK_MAX)) + it5.getIdx());
                }
                item.addAttr(OfflineVideoEntity.VideoAttr.DramaVideo);
            } else {
                item.setGroupId(item.getVideoId());
                if (item.getBizType() != OfflineVideoEntity.BizType.OGV) {
                    item.setGroupTitle(item.getVideoTitle());
                }
            }
        }
        return chain.proceed(continuation);
    }
}