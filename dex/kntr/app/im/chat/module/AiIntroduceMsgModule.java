package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KAiIntroduceModule;
import com.bapis.bilibili.dagw.component.avatar.v1.KAvatarItem;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.compose.avatar.model.AvatarItem;
import kntr.compose.avatar.parser.protobuf.AvatarKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.Transient;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AiIntroduceModule.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lkntr/app/im/chat/module/AiIntroduceMsgModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "value", "Lcom/bapis/bilibili/app/im/v1/KAiIntroduceModule;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KAiIntroduceModule;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KAiIntroduceModule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KAiIntroduceModule;", "avatar", "Lkntr/compose/avatar/model/AvatarItem;", "getAvatar$annotations", "()V", "getAvatar", "()Lkntr/compose/avatar/model/AvatarItem;", "component1", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "$serializer", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class AiIntroduceMsgModule implements MsgModule {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final AvatarItem avatar;
    private final KAiIntroduceModule value;

    public static /* synthetic */ AiIntroduceMsgModule copy$default(AiIntroduceMsgModule aiIntroduceMsgModule, KAiIntroduceModule kAiIntroduceModule, int i, Object obj) {
        if ((i & 1) != 0) {
            kAiIntroduceModule = aiIntroduceMsgModule.value;
        }
        return aiIntroduceMsgModule.copy(kAiIntroduceModule);
    }

    @Transient
    public static /* synthetic */ void getAvatar$annotations() {
    }

    public final KAiIntroduceModule component1() {
        return this.value;
    }

    public final AiIntroduceMsgModule copy(KAiIntroduceModule kAiIntroduceModule) {
        Intrinsics.checkNotNullParameter(kAiIntroduceModule, "value");
        return new AiIntroduceMsgModule(kAiIntroduceModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AiIntroduceMsgModule) && Intrinsics.areEqual(this.value, ((AiIntroduceMsgModule) obj).value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "AiIntroduceMsgModule(value=" + this.value + ")";
    }

    /* compiled from: AiIntroduceModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/AiIntroduceMsgModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/module/AiIntroduceMsgModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AiIntroduceMsgModule> serializer() {
            return AiIntroduceMsgModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ AiIntroduceMsgModule(int seen0, KAiIntroduceModule value, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, AiIntroduceMsgModule$$serializer.INSTANCE.getDescriptor());
        }
        this.value = value;
        KAvatarItem avatar = this.value.getAvatar();
        this.avatar = avatar != null ? AvatarKt.toAvatarItem(avatar) : null;
    }

    public AiIntroduceMsgModule(KAiIntroduceModule value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        KAvatarItem avatar = this.value.getAvatar();
        this.avatar = avatar != null ? AvatarKt.toAvatarItem(avatar) : null;
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ boolean getRequireUpdate() {
        return MsgModule.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ Object rebuildModule(Continuation<? super MsgModule> continuation) {
        return MsgModule.CC.rebuildModule$suspendImpl(this, continuation);
    }

    public final KAiIntroduceModule getValue() {
        return this.value;
    }

    public final AvatarItem getAvatar() {
        return this.avatar;
    }
}