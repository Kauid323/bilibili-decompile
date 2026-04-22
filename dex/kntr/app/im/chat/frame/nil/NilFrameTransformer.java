package kntr.app.im.chat.frame.nil;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import com.bapis.bilibili.app.im.v1.KNilFrame;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: NilFrame.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001c\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/frame/nil/NilFrameTransformer;", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$KNilFrame;", "Lkntr/app/im/chat/frame/nil/NilFrame;", "<init>", "()V", "kType", "Lkotlin/reflect/KClass;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "transformToMsgFrame", "kFrame", "transformToKFrame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame;", "msgFrame", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NilFrameTransformer implements MsgFrameTransformer<KMsgFrame.KNilFrame, NilFrame> {
    public static final int $stable = 0;

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KClass<? extends KMsgFrame.KNilFrame> getKType() {
        return Reflection.getOrCreateKotlinClass(KMsgFrame.KNilFrame.class);
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KClass<? extends NilFrame> getType() {
        return Reflection.getOrCreateKotlinClass(NilFrame.class);
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public NilFrame transformToMsgFrame(KMsgFrame.KNilFrame kFrame) {
        Intrinsics.checkNotNullParameter(kFrame, "kFrame");
        return NilFrame.INSTANCE;
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KMsgFrame transformToKFrame(NilFrame msgFrame) {
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        return new KMsgFrame(new KMsgFrame.KNilFrame(new KNilFrame()));
    }
}