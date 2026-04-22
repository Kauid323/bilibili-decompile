package tv.danmaku.biliplayerimpl.toast.left;

import android.os.Handler;
import android.view.ViewGroup;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageVH;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.CustomMessageVH;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.NormalMessageVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToast;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.log.PlayerLog;

/* compiled from: ToastRecyclerViewAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerimpl/toast/left/ToastRecyclerViewAdapter;", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastListAdapter;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "loopToastState", "", "toastList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ltv/danmaku/biliplayerv2/widget/toast/PlayerToast;", "toast", "dispatchToastAdd", "createToastViewHolder", "Ltv/danmaku/biliplayerimpl/toast/left/AbsToastViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "biliplayerimpl_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ToastRecyclerViewAdapter extends AbsToastListAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToastRecyclerViewAdapter(Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(handler, "handler");
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter
    public void loopToastState(CopyOnWriteArrayList<PlayerToast> copyOnWriteArrayList, PlayerToast toast) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "toastList");
        Intrinsics.checkNotNullParameter(toast, "toast");
        if (toast.getDuration() == PlayerToastConfig.DURATION_FOREVER) {
            if (toast.getRefreshDuration() > -1 && PlayerToast.Companion.generateCreateTimeMillis() - toast.getCreateTime() >= toast.getRefreshDuration()) {
                toast.setRefreshDuration(-1L);
                notifyItemChanged(copyOnWriteArrayList.indexOf(toast));
                return;
            }
            return;
        }
        long diff = PlayerToast.Companion.generateCreateTimeMillis() - toast.getCreateTime();
        long refreshDuration = toast.getRefreshDuration();
        boolean z = false;
        if (0 <= refreshDuration && refreshDuration <= diff) {
            z = true;
        }
        if (z) {
            toast.setRefreshDuration(-1L);
            notifyItemChanged(copyOnWriteArrayList.indexOf(toast));
        } else if (diff >= toast.getDuration()) {
            int index = copyOnWriteArrayList.indexOf(toast);
            copyOnWriteArrayList.remove(index);
            notifyItemRemoved(index);
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter
    public void dispatchToastAdd(CopyOnWriteArrayList<PlayerToast> copyOnWriteArrayList, PlayerToast toast) {
        Intrinsics.checkNotNullParameter(copyOnWriteArrayList, "toastList");
        int size = copyOnWriteArrayList.size();
        Intrinsics.checkNotNull(toast);
        if (toast.getQueueType() == 49) {
            switch (size) {
                case 0:
                    insertToastToQueue(0, toast);
                    return;
                case 1:
                    PlayerToast p0 = copyOnWriteArrayList.get(0);
                    if (toast.getToastType() == p0.getToastType()) {
                        refreshToastItem(0, toast);
                        return;
                    } else if (toast.getLevel() >= p0.getLevel()) {
                        insertToastToQueue(1, toast);
                        return;
                    } else {
                        insertToastToQueue(0, toast);
                        return;
                    }
                case 2:
                    PlayerToast p02 = copyOnWriteArrayList.get(0);
                    PlayerToast p03 = p02;
                    PlayerToast p1 = copyOnWriteArrayList.get(1);
                    if (toast.getToastType() == p03.getToastType()) {
                        refreshToastItem(0, toast);
                        return;
                    } else if (toast.getToastType() == p1.getToastType()) {
                        refreshToastItem(1, toast);
                        return;
                    } else if (toast.getLevel() < p03.getLevel()) {
                        insertToastToQueue(0, toast);
                        return;
                    } else if (toast.getLevel() < p1.getLevel()) {
                        insertToastToQueue(1, toast);
                        return;
                    } else {
                        insertToastToQueue(2, toast);
                        return;
                    }
                case 3:
                    PlayerToast p04 = copyOnWriteArrayList.get(0);
                    PlayerToast p12 = copyOnWriteArrayList.get(1);
                    PlayerToast p2 = copyOnWriteArrayList.get(2);
                    if (toast.getToastType() != p04.getToastType()) {
                        if (toast.getToastType() != p12.getToastType()) {
                            if (toast.getToastType() == p2.getToastType()) {
                                refreshToastItem(2, toast);
                                return;
                            } else if (toast.getLevel() >= p04.getLevel()) {
                                if (p04.getDuration() == PlayerToastConfig.DURATION_FOREVER) {
                                    removeForeverToastTemporary();
                                } else {
                                    Intrinsics.checkNotNull(p04);
                                    removeToast(p04, false);
                                }
                                if (toast.getLevel() >= p12.getLevel()) {
                                    if (toast.getLevel() >= p2.getLevel()) {
                                        insertToastToQueue(2, toast);
                                        return;
                                    } else {
                                        insertToastToQueue(1, toast);
                                        return;
                                    }
                                }
                                insertToastToQueue(0, toast);
                                return;
                            } else {
                                PlayerLog.d(getTag(), "refresh : max Toast exist, current level is not enough to show!");
                                return;
                            }
                        }
                        refreshToastItem(1, toast);
                        return;
                    }
                    refreshToastItem(0, toast);
                    return;
                default:
                    return;
            }
        } else if (toast.getQueueType() == 48) {
            switch (size) {
                case 0:
                    insertToastToQueue(0, toast);
                    return;
                case 1:
                    if (toast.getLevel() >= copyOnWriteArrayList.get(0).getLevel()) {
                        insertToastToQueue(1, toast);
                        return;
                    } else {
                        insertToastToQueue(0, toast);
                        return;
                    }
                case 2:
                    PlayerToast p05 = copyOnWriteArrayList.get(0);
                    PlayerToast p13 = copyOnWriteArrayList.get(1);
                    if (toast.getLevel() < p05.getLevel()) {
                        PlayerLog.d(getTag(), "insert : max Toast exist, current level is not enough to show!");
                        return;
                    }
                    if (p05.getDuration() == PlayerToastConfig.DURATION_FOREVER) {
                        removeForeverToastTemporary();
                    } else {
                        Intrinsics.checkNotNull(p05);
                        removeToast(p05, false);
                    }
                    if (toast.getLevel() < p13.getLevel()) {
                        insertToastToQueue(0, toast);
                        return;
                    } else {
                        insertToastToQueue(1, toast);
                        return;
                    }
                default:
                    return;
            }
        } else {
            throw new IllegalArgumentException("toast queue type must use the defined value in PlayerToastConfig! but current type is" + toast.getQueueType());
        }
    }

    @Override // tv.danmaku.biliplayerimpl.toast.left.AbsToastListAdapter
    public AbsToastViewHolder createToastViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 17:
                return NormalMessageVH.Companion.create(parent);
            case 18:
                return ActionMessageVH.Companion.create(parent);
            case 19:
                return CustomMessageVH.Companion.create(parent);
            case 20:
            default:
                return NormalMessageVH.Companion.create(parent);
            case 21:
                return ActionMessageWithAnimationVH.Companion.create(parent);
        }
    }
}