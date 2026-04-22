package tv.danmaku.bili.ui.rank.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bapis.bilibili.app.show.rank.v1.Item;
import com.bapis.bilibili.app.show.rank.v1.RankListReply;
import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.MossResponseHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: RankBRpcModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH$J*\u0010\u0014\u001a$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\u0016H\u0016R0\u0010\u0004\u001a$\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/ui/rank/model/BaseRankBRpcModel;", "Ltv/danmaku/bili/ui/rank/model/IRankLoadModel;", "<init>", "()V", "resp", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bilibili/lib/arch/lifecycle/Resource;", "", "Ltv/danmaku/bili/ui/rank/model/RankModel;", "Lcom/bilibili/lib/arch/lifecycle/MutableLiveResource;", "isLoading", "", "load", "", "doLoad", "callback", "Lcom/bilibili/lib/moss/api/MossResponseHandler;", "Lcom/bapis/bilibili/app/show/rank/v1/RankListReply;", "getCallback", "()Lcom/bilibili/lib/moss/api/MossResponseHandler;", "getLiveResp", "Landroidx/lifecycle/LiveData;", "Lcom/bilibili/lib/arch/lifecycle/LiveResource;", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public abstract class BaseRankBRpcModel implements IRankLoadModel {
    public static final int $stable = 8;
    private boolean isLoading;
    private final MutableLiveData<Resource<List<RankModel>>> resp = new MutableLiveData<>();
    private final MossResponseHandler<RankListReply> callback = new MossResponseHandler<RankListReply>() { // from class: tv.danmaku.bili.ui.rank.model.BaseRankBRpcModel$callback$1
        public /* synthetic */ void onHeaders(Map map) {
            MossResponseHandler.-CC.$default$onHeaders(this, map);
        }

        public /* synthetic */ long onNextForAck(Object obj) {
            return MossResponseHandler.-CC.$default$onNextForAck(this, obj);
        }

        public /* synthetic */ void onUpstreamAck(Long l) {
            MossResponseHandler.-CC.$default$onUpstreamAck(this, l);
        }

        public /* synthetic */ void onValid() {
            MossResponseHandler.-CC.$default$onValid(this);
        }

        public void onNext(RankListReply value) {
            MutableLiveData mutableLiveData;
            Collection destination$iv$iv;
            BaseRankBRpcModel.this.isLoading = false;
            if (value != null) {
                mutableLiveData = BaseRankBRpcModel.this.resp;
                Resource.Companion companion = Resource.Companion;
                Iterable itemsList = value.getItemsList();
                if (itemsList == null) {
                    destination$iv$iv = null;
                } else {
                    Iterable $this$map$iv = itemsList;
                    Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                    for (Object item$iv$iv : $this$map$iv) {
                        Item it = (Item) item$iv$iv;
                        Intrinsics.checkNotNull(it);
                        destination$iv$iv2.add(new RankModel(it));
                    }
                    destination$iv$iv = (List) destination$iv$iv2;
                }
                mutableLiveData.postValue(companion.success(destination$iv$iv));
            }
        }

        public void onError(MossException t) {
            MutableLiveData mutableLiveData;
            BaseRankBRpcModel.this.isLoading = false;
            mutableLiveData = BaseRankBRpcModel.this.resp;
            mutableLiveData.postValue(Resource.Companion.error(t != null ? (Exception) t : new Exception()));
        }

        public void onCompleted() {
        }
    };

    protected abstract void doLoad();

    @Override // tv.danmaku.bili.ui.rank.model.IRankLoadModel
    public void load() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        MutableLiveData<Resource<List<RankModel>>> mutableLiveData = this.resp;
        Resource.Companion companion = Resource.Companion;
        Resource resource = (Resource) this.resp.getValue();
        mutableLiveData.setValue(companion.loading(resource != null ? (List) resource.getData() : null));
        doLoad();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MossResponseHandler<RankListReply> getCallback() {
        return this.callback;
    }

    @Override // tv.danmaku.bili.ui.rank.model.IRankLoadModel
    public LiveData<Resource<List<RankModel>>> getLiveResp() {
        return this.resp;
    }
}