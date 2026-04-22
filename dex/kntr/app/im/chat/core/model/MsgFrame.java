package kntr.app.im.chat.core.model;

import com.bilibili.blens.BSimpleLens;
import java.util.Collection;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: MsgFrame.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0000H\u0096@¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/MsgFrame;", RoomRecommendViewModel.EMPTY_CURSOR, "restoreFrame", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "getModules", "()Ljava/util/List;", "modulesLens", "Lcom/bilibili/blens/BSimpleLens;", "getModulesLens", "()Lcom/bilibili/blens/BSimpleLens;", "requireUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "getRequireUpdate", "()Z", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MsgFrame {
    List<MsgModule> getModules();

    BSimpleLens<MsgFrame, List<MsgModule>> getModulesLens();

    boolean getRequireUpdate();

    Object restoreFrame(Continuation<? super MsgFrame> continuation);

    /* compiled from: MsgFrame.kt */
    /* renamed from: kntr.app.im.chat.core.model.MsgFrame$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Object restoreFrame$suspendImpl(MsgFrame $this, Continuation<? super MsgFrame> continuation) {
            return $this;
        }

        public static boolean $default$getRequireUpdate(MsgFrame _this) {
            Iterable $this$any$iv = _this.getModules();
            if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                return false;
            }
            for (Object element$iv : $this$any$iv) {
                MsgModule it = (MsgModule) element$iv;
                if (it.getRequireUpdate()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: MsgFrame.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object restoreFrame(MsgFrame $this, Continuation<? super MsgFrame> continuation) {
            return CC.restoreFrame$suspendImpl($this, continuation);
        }

        @Deprecated
        public static boolean getRequireUpdate(MsgFrame $this) {
            return CC.$default$getRequireUpdate($this);
        }
    }
}