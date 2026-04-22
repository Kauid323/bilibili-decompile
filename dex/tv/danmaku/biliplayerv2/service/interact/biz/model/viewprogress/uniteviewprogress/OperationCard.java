package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.coreV2.transformer.MediaItemParams;

/* compiled from: DmResource.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006*"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/OperationCard;", "", "<init>", "()V", "id", "", "getId", "()J", "setId", "(J)V", "from", "", "getFrom", "()I", "setFrom", "(I)V", "to", "getTo", "setTo", "status", "", "getStatus", "()Z", "setStatus", "(Z)V", MediaItemParams.IJK_REPORT_KEY_BIZ_TYPE, "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/BizType;", "getBiz_type", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/BizType;", "setBiz_type", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/BizType;)V", "content", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/OperationCardContent;", "getContent", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/OperationCardContent;", "setContent", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/OperationCardContent;)V", "param", "getParam", "()Ljava/lang/Object;", "setParam", "(Ljava/lang/Object;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OperationCard {
    private BizType biz_type;
    private OperationCardContent content;
    private long id;
    private Object param;
    private boolean status;
    private int from = 2;
    private int to = 2;

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final int getFrom() {
        return this.from;
    }

    public final void setFrom(int i) {
        this.from = i;
    }

    public final int getTo() {
        return this.to;
    }

    public final void setTo(int i) {
        this.to = i;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final void setStatus(boolean z) {
        this.status = z;
    }

    public final BizType getBiz_type() {
        return this.biz_type;
    }

    public final void setBiz_type(BizType bizType) {
        this.biz_type = bizType;
    }

    public final OperationCardContent getContent() {
        return this.content;
    }

    public final void setContent(OperationCardContent operationCardContent) {
        this.content = operationCardContent;
    }

    public final Object getParam() {
        return this.param;
    }

    public final void setParam(Object obj) {
        this.param = obj;
    }
}