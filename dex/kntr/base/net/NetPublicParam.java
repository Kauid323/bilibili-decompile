package kntr.base.net;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Gnet.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\"\u0012\u0019\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\u000bJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\tR-\u0010\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\b\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0007¨\u0006\u0012"}, d2 = {"Lkntr/base/net/NetPublicParam;", "Lkntr/base/net/GNetPublicParam;", "pa", "Lkotlin/Function1;", "Lkntr/base/net/Param;", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "key", "", "v", "(Ljava/lang/String;Ljava/lang/String;)V", "getPa", "()Lkotlin/jvm/functions/Function1;", "setPa", "param", "valueParam", "value", "net_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetPublicParam implements GNetPublicParam {
    private Function1<? super NetPublicParam, Param> pa;

    public NetPublicParam(Function1<? super NetPublicParam, Param> function1) {
        Intrinsics.checkNotNullParameter(function1, "pa");
        this.pa = function1;
    }

    public final Function1<NetPublicParam, Param> getPa() {
        return this.pa;
    }

    public final void setPa(Function1<? super NetPublicParam, Param> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.pa = function1;
    }

    @Override // kntr.base.net.GNetPublicParam
    public Param param() {
        return (Param) this.pa.invoke(this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NetPublicParam(final String key, final String v) {
        this(new Function1() { // from class: kntr.base.net.NetPublicParam$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Param _init_$lambda$0;
                _init_$lambda$0 = NetPublicParam._init_$lambda$0(v, key, (NetPublicParam) obj);
                return _init_$lambda$0;
            }
        });
        Intrinsics.checkNotNullParameter(key, "key");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Param _init_$lambda$0(String $v, String $key, NetPublicParam netPublicParam) {
        Intrinsics.checkNotNullParameter(netPublicParam, "<this>");
        if ($v != null) {
            return new Param($key, $v);
        }
        return null;
    }

    public final Param valueParam(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            return new Param(key, value);
        }
        return null;
    }
}