package tv.danmaku.bili.ui.video.main;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Util.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/video/main/Channel;", "", "channel", "", "", "<init>", "(Ljava/util/List;)V", "getChannel", "()Ljava/util/List;", "setChannel", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Channel {
    public static final int $stable = 8;
    @SerializedName("channel")
    private List<String> channel;

    public Channel() {
        this(null, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Channel copy$default(Channel channel, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = channel.channel;
        }
        return channel.copy(list);
    }

    public final List<String> component1() {
        return this.channel;
    }

    public final Channel copy(List<String> list) {
        return new Channel(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Channel) && Intrinsics.areEqual(this.channel, ((Channel) obj).channel);
    }

    public int hashCode() {
        if (this.channel == null) {
            return 0;
        }
        return this.channel.hashCode();
    }

    public String toString() {
        return "Channel(channel=" + this.channel + ")";
    }

    public Channel(List<String> list) {
        this.channel = list;
    }

    public /* synthetic */ Channel(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list);
    }

    public final List<String> getChannel() {
        return this.channel;
    }

    public final void setChannel(List<String> list) {
        this.channel = list;
    }
}