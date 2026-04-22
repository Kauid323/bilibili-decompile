package kntr.app.im.chat.frame.push;

import com.bapis.bilibili.app.im.v1.KPushEmptyFrame;
import com.bapis.bilibili.app.im.v1.KPushEmptyFrame$;
import com.bilibili.blens.BSimpleLens;
import com.bilibili.blens.Lens;
import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.im.chat.core.model.MsgFrame;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PushEmptyFrame.kt */
@Lens
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002-.B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0019HÖ\u0001J%\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001¢\u0006\u0002\b,R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R,\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00138VX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006/"}, d2 = {"Lkntr/app/im/chat/frame/push/PushEmptyFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "value", "Lcom/bapis/bilibili/app/im/v1/KPushEmptyFrame;", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KPushEmptyFrame;Ljava/util/List;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KPushEmptyFrame;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KPushEmptyFrame;", "getModules", "()Ljava/util/List;", "modulesLens", "Lcom/bilibili/blens/BSimpleLens;", "getModulesLens$annotations", "()V", "getModulesLens", "()Lcom/bilibili/blens/BSimpleLens;", "url", RoomRecommendViewModel.EMPTY_CURSOR, "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "Companion", "$serializer", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PushEmptyFrame implements MsgFrame {
    public static final int $stable = 0;
    private final List<MsgModule> modules;
    private final KPushEmptyFrame value;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.frame.push.PushEmptyFrame$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = PushEmptyFrame._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PushEmptyFrame copy$default(PushEmptyFrame pushEmptyFrame, KPushEmptyFrame kPushEmptyFrame, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            kPushEmptyFrame = pushEmptyFrame.value;
        }
        if ((i & 2) != 0) {
            list = pushEmptyFrame.modules;
        }
        return pushEmptyFrame.copy(kPushEmptyFrame, list);
    }

    public static /* synthetic */ void getModulesLens$annotations() {
    }

    public final KPushEmptyFrame component1() {
        return this.value;
    }

    public final List<MsgModule> component2() {
        return this.modules;
    }

    public final PushEmptyFrame copy(KPushEmptyFrame kPushEmptyFrame, List<? extends MsgModule> list) {
        Intrinsics.checkNotNullParameter(kPushEmptyFrame, "value");
        Intrinsics.checkNotNullParameter(list, "modules");
        return new PushEmptyFrame(kPushEmptyFrame, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PushEmptyFrame) {
            PushEmptyFrame pushEmptyFrame = (PushEmptyFrame) obj;
            return Intrinsics.areEqual(this.value, pushEmptyFrame.value) && Intrinsics.areEqual(this.modules, pushEmptyFrame.modules);
        }
        return false;
    }

    public int hashCode() {
        return (this.value.hashCode() * 31) + this.modules.hashCode();
    }

    public String toString() {
        KPushEmptyFrame kPushEmptyFrame = this.value;
        return "PushEmptyFrame(value=" + kPushEmptyFrame + ", modules=" + this.modules + ")";
    }

    public /* synthetic */ PushEmptyFrame(int seen0, KPushEmptyFrame value, List modules, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, PushEmptyFrame$$serializer.INSTANCE.getDescriptor());
        }
        this.value = value;
        this.modules = modules;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PushEmptyFrame(KPushEmptyFrame value, List<? extends MsgModule> list) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(list, "modules");
        this.value = value;
        this.modules = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(MsgModule.class), new Annotation[0]));
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$biz_debug(PushEmptyFrame self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, KPushEmptyFrame$.serializer.INSTANCE, self.value);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.getModules());
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ boolean getRequireUpdate() {
        return MsgFrame.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ Object restoreFrame(Continuation<? super MsgFrame> continuation) {
        return MsgFrame.CC.restoreFrame$suspendImpl(this, continuation);
    }

    public final KPushEmptyFrame getValue() {
        return this.value;
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public List<MsgModule> getModules() {
        return this.modules;
    }

    /* compiled from: PushEmptyFrame.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/frame/push/PushEmptyFrame$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/frame/push/PushEmptyFrame;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PushEmptyFrame> serializer() {
            return PushEmptyFrame$$serializer.INSTANCE;
        }
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public BSimpleLens<MsgFrame, List<MsgModule>> getModulesLens() {
        BSimpleLens<PushEmptyFrame, List<MsgModule>> modules = PushEmptyFrameLensKt.getModules(Companion);
        Intrinsics.checkNotNull(modules, "null cannot be cast to non-null type com.bilibili.blens.BSimpleLens<kntr.app.im.chat.core.model.MsgFrame, kotlin.collections.List<kntr.app.im.chat.core.model.MsgModule>>");
        return modules;
    }

    public final String getUrl() {
        return this.value.getUrl();
    }
}