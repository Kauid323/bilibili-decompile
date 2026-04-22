package tv.danmaku.bili.ui.personinfo.event;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ModifyPersonInfoEvent.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/ui/personinfo/event/ModifyPersonInfoEvent;", "", "modifyType", "Ltv/danmaku/bili/ui/personinfo/event/ModifyType;", "response", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "(Ltv/danmaku/bili/ui/personinfo/event/ModifyType;Ljava/lang/Object;Ljava/lang/Exception;)V", "personinfo_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ModifyPersonInfoEvent {
    public static final int $stable = 8;
    public final Exception error;
    public final ModifyType modifyType;
    public final Object response;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModifyPersonInfoEvent(ModifyType modifyType) {
        this(modifyType, null, null, 6, null);
        Intrinsics.checkNotNullParameter(modifyType, "modifyType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ModifyPersonInfoEvent(ModifyType modifyType, Object obj) {
        this(modifyType, obj, null, 4, null);
        Intrinsics.checkNotNullParameter(modifyType, "modifyType");
    }

    public ModifyPersonInfoEvent(ModifyType modifyType, Object response, Exception error) {
        Intrinsics.checkNotNullParameter(modifyType, "modifyType");
        this.modifyType = modifyType;
        this.response = response;
        this.error = error;
    }

    public /* synthetic */ ModifyPersonInfoEvent(ModifyType modifyType, Object obj, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modifyType, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : exc);
    }
}