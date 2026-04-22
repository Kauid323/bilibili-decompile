package kntr.app.im.chat.frame.nil;

import com.bapis.bilibili.app.im.v1.KMsgFrame;
import dagger.internal.Factory;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.network.MsgFrameTransformer;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NilFrameModule_ProvideNilFrameBuilderFactory.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \b2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016¨\u0006\t"}, d2 = {"Lkntr/app/im/chat/frame/nil/NilFrameModule_ProvideNilFrameBuilderFactory;", "Ldagger/internal/Factory;", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "<init>", "()V", "get", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NilFrameModule_ProvideNilFrameBuilderFactory implements Factory<MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame>> {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final NilFrameModule_ProvideNilFrameBuilderFactory INSTANCE = new NilFrameModule_ProvideNilFrameBuilderFactory();

    public MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> get() {
        return Companion.provideNilFrameBuilder();
    }

    /* compiled from: NilFrameModule_ProvideNilFrameBuilderFactory.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/im/chat/frame/nil/NilFrameModule_ProvideNilFrameBuilderFactory$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "INSTANCE", "Lkntr/app/im/chat/frame/nil/NilFrameModule_ProvideNilFrameBuilderFactory;", "create", "provideNilFrameBuilder", "Lkntr/app/im/chat/network/MsgFrameTransformer;", "Lcom/bapis/bilibili/app/im/v1/KMsgFrame$IFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final NilFrameModule_ProvideNilFrameBuilderFactory create() {
            return NilFrameModule_ProvideNilFrameBuilderFactory.INSTANCE;
        }

        @JvmStatic
        public final MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> provideNilFrameBuilder() {
            return NilFrameModule.INSTANCE.provideNilFrameBuilder();
        }
    }

    @JvmStatic
    public static final NilFrameModule_ProvideNilFrameBuilderFactory create() {
        return Companion.create();
    }

    @JvmStatic
    public static final MsgFrameTransformer<KMsgFrame.IFrame, MsgFrame> provideNilFrameBuilder() {
        return Companion.provideNilFrameBuilder();
    }
}