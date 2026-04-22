package tv.danmaku.bili.ui.rank.model;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import tv.danmaku.bili.ui.rank.RankVideoListViewModel;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IRankLoadModel.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ltv/danmaku/bili/ui/rank/model/RankListViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "type", "", "tid", "<init>", "(II)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "rank_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RankListViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 0;
    private final int tid;
    private final int type;

    public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, cls, creationExtras);
    }

    public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
        return ViewModelProvider.Factory.-CC.$default$create(this, kClass, creationExtras);
    }

    public RankListViewModelFactory(int type, int tid) {
        this.type = type;
        this.tid = tid;
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        BaseRankBRpcModel model;
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (RankVideoListViewModel.class.isAssignableFrom(cls)) {
            if (this.type < 0 && this.tid > 0) {
                model = new RankBRpcCategoryModel(this.tid);
            } else {
                model = new RankBRpcOriginalModel(this.type);
            }
            try {
                Class<?> cls2 = Integer.TYPE;
                T newInstance = cls.getConstructor(cls2, cls2, IRankLoadModel.class).newInstance(Integer.valueOf(this.tid), Integer.valueOf(this.type), model);
                Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
                return newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
        throw new UnsupportedOperationException("RankBRpcModelFactory should only be used to create RankVideoListViewModel");
    }
}