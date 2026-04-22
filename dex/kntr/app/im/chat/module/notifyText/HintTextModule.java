package kntr.app.im.chat.module.notifyText;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KMsgModule$KHintTextModule$;
import com.bilibili.blens.Lens;
import im.base.serializer.InstantMicroSecondSerializer;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.MessageSequence$$serializer;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: HintTextModule.kt */
@Lens
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lkntr/app/im/chat/module/notifyText/HintTextModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "value", "Lcom/bapis/bilibili/app/im/v1/KMsgModule$KHintTextModule;", "relatedMessage", "Lkntr/app/im/chat/core/model/MessageSequence;", "relatedTimeStamp", "Lkotlinx/datetime/Instant;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KMsgModule$KHintTextModule;Lkntr/app/im/chat/core/model/MessageSequence;Lkotlinx/datetime/Instant;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KMsgModule$KHintTextModule;Lkntr/app/im/chat/core/model/MessageSequence;Lkotlinx/datetime/Instant;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KMsgModule$KHintTextModule;", "getRelatedMessage", "()Lkntr/app/im/chat/core/model/MessageSequence;", "getRelatedTimeStamp$annotations", "()V", "getRelatedTimeStamp", "()Lkotlinx/datetime/Instant;", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "Companion", "$serializer", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class HintTextModule implements MsgModule {
    public static final int $stable = 0;
    private final MessageSequence relatedMessage;
    private final Instant relatedTimeStamp;
    private final KMsgModule.KHintTextModule value;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.module.notifyText.HintTextModule$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = HintTextModule._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    public static /* synthetic */ HintTextModule copy$default(HintTextModule hintTextModule, KMsgModule.KHintTextModule kHintTextModule, MessageSequence messageSequence, Instant instant, int i, Object obj) {
        if ((i & 1) != 0) {
            kHintTextModule = hintTextModule.value;
        }
        if ((i & 2) != 0) {
            messageSequence = hintTextModule.relatedMessage;
        }
        if ((i & 4) != 0) {
            instant = hintTextModule.relatedTimeStamp;
        }
        return hintTextModule.copy(kHintTextModule, messageSequence, instant);
    }

    @Serializable(with = InstantMicroSecondSerializer.class)
    public static /* synthetic */ void getRelatedTimeStamp$annotations() {
    }

    public final KMsgModule.KHintTextModule component1() {
        return this.value;
    }

    public final MessageSequence component2() {
        return this.relatedMessage;
    }

    public final Instant component3() {
        return this.relatedTimeStamp;
    }

    public final HintTextModule copy(KMsgModule.KHintTextModule kHintTextModule, MessageSequence messageSequence, Instant instant) {
        Intrinsics.checkNotNullParameter(kHintTextModule, "value");
        return new HintTextModule(kHintTextModule, messageSequence, instant);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HintTextModule) {
            HintTextModule hintTextModule = (HintTextModule) obj;
            return Intrinsics.areEqual(this.value, hintTextModule.value) && Intrinsics.areEqual(this.relatedMessage, hintTextModule.relatedMessage) && Intrinsics.areEqual(this.relatedTimeStamp, hintTextModule.relatedTimeStamp);
        }
        return false;
    }

    public int hashCode() {
        return (((this.value.hashCode() * 31) + (this.relatedMessage == null ? 0 : this.relatedMessage.hashCode())) * 31) + (this.relatedTimeStamp != null ? this.relatedTimeStamp.hashCode() : 0);
    }

    public String toString() {
        KMsgModule.KHintTextModule kHintTextModule = this.value;
        MessageSequence messageSequence = this.relatedMessage;
        return "HintTextModule(value=" + kHintTextModule + ", relatedMessage=" + messageSequence + ", relatedTimeStamp=" + this.relatedTimeStamp + ")";
    }

    public /* synthetic */ HintTextModule(int seen0, KMsgModule.KHintTextModule value, MessageSequence relatedMessage, Instant relatedTimeStamp, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, HintTextModule$$serializer.INSTANCE.getDescriptor());
        }
        this.value = value;
        if ((seen0 & 2) == 0) {
            this.relatedMessage = null;
        } else {
            this.relatedMessage = relatedMessage;
        }
        if ((seen0 & 4) == 0) {
            this.relatedTimeStamp = null;
        } else {
            this.relatedTimeStamp = relatedTimeStamp;
        }
    }

    public HintTextModule(KMsgModule.KHintTextModule value, MessageSequence relatedMessage, Instant relatedTimeStamp) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.relatedMessage = relatedMessage;
        this.relatedTimeStamp = relatedTimeStamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new InstantMicroSecondSerializer();
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$biz_debug(HintTextModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, KMsgModule$KHintTextModule$.serializer.INSTANCE, self.value);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.relatedMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, MessageSequence$$serializer.INSTANCE, self.relatedMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.relatedTimeStamp != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.relatedTimeStamp);
        }
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ boolean getRequireUpdate() {
        return MsgModule.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ Object rebuildModule(Continuation<? super MsgModule> continuation) {
        return MsgModule.CC.rebuildModule$suspendImpl(this, continuation);
    }

    public /* synthetic */ HintTextModule(KMsgModule.KHintTextModule kHintTextModule, MessageSequence messageSequence, Instant instant, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kHintTextModule, (i & 2) != 0 ? null : messageSequence, (i & 4) != 0 ? null : instant);
    }

    public final KMsgModule.KHintTextModule getValue() {
        return this.value;
    }

    public final MessageSequence getRelatedMessage() {
        return this.relatedMessage;
    }

    public final Instant getRelatedTimeStamp() {
        return this.relatedTimeStamp;
    }

    /* compiled from: HintTextModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/notifyText/HintTextModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/module/notifyText/HintTextModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<HintTextModule> serializer() {
            return HintTextModule$$serializer.INSTANCE;
        }
    }
}