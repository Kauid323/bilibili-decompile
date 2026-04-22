package tv.danmaku.bili.ui.main2.mine.provider;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.comm.list.common.utils.BiliCallLifeCycleObserverKt;
import com.bilibili.app.comm.restrict.RestrictedMode;
import com.bilibili.app.comm.restrict.RestrictedType;
import com.bilibili.app.provider.UtilKt;
import com.bilibili.biligame.GameCenterService;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.homepage.mine.MenuGroup;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GameCenterMineSolution.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/provider/GameMineMenuItemSolution;", "Ltv/danmaku/bili/ui/main2/mine/DefaultMineMenuSolution;", "<init>", "()V", "mItem", "Lcom/bilibili/lib/homepage/mine/MenuGroup$Item;", "job", "Lkotlinx/coroutines/Job;", "onMenuCreated", "", "context", "Landroid/content/Context;", "item", "onMenuItemUpdate", "onMenuDestroy", "onMenuItemClick", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class GameMineMenuItemSolution extends DefaultMineMenuSolution {
    private Job job;
    private MenuGroup.Item mItem;

    @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
    public void onMenuCreated(Context context, MenuGroup.Item item) {
        LifecycleOwner lifecycleOwner;
        CoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        super.onMenuCreated(context, item);
        GameCenterService gameCenterService = (GameCenterService) BLRouter.INSTANCE.get(GameCenterService.class, AppConfig.HOST_GAME_CENTER);
        if (gameCenterService != null) {
            Job job = this.job;
            Job job2 = null;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            Activity findActivityOrNull = UtilKt.findActivityOrNull(context);
            if (findActivityOrNull != null && (lifecycleOwner = BiliCallLifeCycleObserverKt.getLifecycleOwner(findActivityOrNull)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
                job2 = BuildersKt.launch$default(lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new GameMineMenuItemSolution$onMenuCreated$1(gameCenterService, context, this, item, null), 3, (Object) null);
            }
            this.job = job2;
        }
    }

    @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
    public void onMenuItemUpdate(Context context, MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        super.onMenuItemUpdate(context, item);
        this.mItem = item;
    }

    @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
    public void onMenuDestroy(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onMenuDestroy(context);
        BLog.d("GameCenterMineSolution", "onMenuDestroy");
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // tv.danmaku.bili.ui.main2.mine.DefaultMineMenuSolution
    public void onMenuItemClick(Context context, MenuGroup.Item item) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        super.onMenuItemClick(context, item);
        if (RestrictedMode.isEnable(RestrictedType.LESSONS, "GameCenterMineSolution")) {
            setVisible(item, false);
        }
    }
}