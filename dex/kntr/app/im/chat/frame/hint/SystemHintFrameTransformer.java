package kntr.app.im.chat.frame.hint;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import javax.inject.Inject;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kntr.app.im.chat.network.MsgModuleTransformers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: SystemHintFrameTransformer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkntr/app/im/chat/frame/hint/SystemHintFrameTransformer;", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$KSystemHintFrame;", "Lkntr/app/im/chat/frame/hint/SystemHintFrame;", "transformers", "Lkntr/app/im/chat/network/MsgModuleTransformers;", "<init>", "(Lkntr/app/im/chat/network/MsgModuleTransformers;)V", "kType", "Lkotlin/reflect/KClass;", "getKType", "()Lkotlin/reflect/KClass;", "type", "getType", "transformToMsgFrame", "kFrame", "transformToKFrame", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame;", "msgFrame", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SystemHintFrameTransformer implements MsgFrameTransformer<KMsgFrame.KSystemHintFrame, SystemHintFrame> {
    public static final int $stable = 8;
    private final MsgModuleTransformers transformers;

    @Inject
    public SystemHintFrameTransformer(MsgModuleTransformers transformers) {
        Intrinsics.checkNotNullParameter(transformers, "transformers");
        this.transformers = transformers;
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KClass<? extends KMsgFrame.KSystemHintFrame> getKType() {
        return Reflection.getOrCreateKotlinClass(KMsgFrame.KSystemHintFrame.class);
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KClass<? extends SystemHintFrame> getType() {
        return Reflection.getOrCreateKotlinClass(SystemHintFrame.class);
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public SystemHintFrame transformToMsgFrame(KMsgFrame.KSystemHintFrame kFrame) {
        Intrinsics.checkNotNullParameter(kFrame, "kFrame");
        return new SystemHintFrame(kFrame.getValue(), this.transformers.transformToMsgModules(kFrame.getValue().getMsgModules()));
    }

    @Override // kntr.app.im.chat.network.MsgFrameTransformer
    public KMsgFrame transformToKFrame(SystemHintFrame msgFrame) {
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        return new KMsgFrame(new KMsgFrame.KSystemHintFrame(msgFrame.getValue()));
    }
}