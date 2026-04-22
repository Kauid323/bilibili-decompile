package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KPushArticleModule;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PushArticleModuleTransformer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lkntr/app/im/chat/module/PushArticleMsgModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "value", "Lcom/bapis/bilibili/app/im/v1/KPushArticleModule;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KPushArticleModule;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KPushArticleModule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KPushArticleModule;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "$serializer", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PushArticleMsgModule implements MsgModule {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final KPushArticleModule value;

    public static /* synthetic */ PushArticleMsgModule copy$default(PushArticleMsgModule pushArticleMsgModule, KPushArticleModule kPushArticleModule, int i, Object obj) {
        if ((i & 1) != 0) {
            kPushArticleModule = pushArticleMsgModule.value;
        }
        return pushArticleMsgModule.copy(kPushArticleModule);
    }

    public final KPushArticleModule component1() {
        return this.value;
    }

    public final PushArticleMsgModule copy(KPushArticleModule kPushArticleModule) {
        Intrinsics.checkNotNullParameter(kPushArticleModule, "value");
        return new PushArticleMsgModule(kPushArticleModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PushArticleMsgModule) && Intrinsics.areEqual(this.value, ((PushArticleMsgModule) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "PushArticleMsgModule(value=" + this.value + ")";
    }

    /* compiled from: PushArticleModuleTransformer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/PushArticleMsgModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/module/PushArticleMsgModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PushArticleMsgModule> serializer() {
            return PushArticleMsgModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PushArticleMsgModule(int seen0, KPushArticleModule value, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, PushArticleMsgModule$$serializer.INSTANCE.getDescriptor());
        }
        this.value = value;
    }

    public PushArticleMsgModule(KPushArticleModule value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ boolean getRequireUpdate() {
        return MsgModule.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ Object rebuildModule(Continuation<? super MsgModule> continuation) {
        return MsgModule.CC.rebuildModule$suspendImpl(this, continuation);
    }

    public final KPushArticleModule getValue() {
        return this.value;
    }
}