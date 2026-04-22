package kntr.app.im.chat.module;

import com.bapis.bilibili.app.im.v1.KPictureModule;
import com.bapis.bilibili.app.im.v1.KPictureModule$;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: PictureModuleTransformer.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006$"}, d2 = {"Lkntr/app/im/chat/module/PictureMsgModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "index", RoomRecommendViewModel.EMPTY_CURSOR, "value", "Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "<init>", "(ILcom/bapis/bilibili/app/im/v1/KPictureModule;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/bapis/bilibili/app/im/v1/KPictureModule;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIndex", "()I", "getValue", "()Lcom/bapis/bilibili/app/im/v1/KPictureModule;", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$biz_debug", "$serializer", "Companion", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class PictureMsgModule implements MsgModule {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final int index;
    private final KPictureModule value;

    public static /* synthetic */ PictureMsgModule copy$default(PictureMsgModule pictureMsgModule, int i, KPictureModule kPictureModule, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = pictureMsgModule.index;
        }
        if ((i2 & 2) != 0) {
            kPictureModule = pictureMsgModule.value;
        }
        return pictureMsgModule.copy(i, kPictureModule);
    }

    public final int component1() {
        return this.index;
    }

    public final KPictureModule component2() {
        return this.value;
    }

    public final PictureMsgModule copy(int i, KPictureModule kPictureModule) {
        Intrinsics.checkNotNullParameter(kPictureModule, "value");
        return new PictureMsgModule(i, kPictureModule);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PictureMsgModule) {
            PictureMsgModule pictureMsgModule = (PictureMsgModule) obj;
            return this.index == pictureMsgModule.index && Intrinsics.areEqual(this.value, pictureMsgModule.value);
        }
        return false;
    }

    public int hashCode() {
        return (this.index * 31) + this.value.hashCode();
    }

    public String toString() {
        int i = this.index;
        return "PictureMsgModule(index=" + i + ", value=" + this.value + ")";
    }

    /* compiled from: PictureModuleTransformer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/module/PictureMsgModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/module/PictureMsgModule;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PictureMsgModule> serializer() {
            return PictureMsgModule$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ PictureMsgModule(int seen0, int index, KPictureModule value, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, PictureMsgModule$$serializer.INSTANCE.getDescriptor());
        }
        this.index = index;
        this.value = value;
    }

    public PictureMsgModule(int index, KPictureModule value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.index = index;
        this.value = value;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$biz_debug(PictureMsgModule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.index);
        output.encodeSerializableElement(serialDesc, 1, KPictureModule$.serializer.INSTANCE, self.value);
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ boolean getRequireUpdate() {
        return MsgModule.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgModule
    public /* bridge */ Object rebuildModule(Continuation<? super MsgModule> continuation) {
        return MsgModule.CC.rebuildModule$suspendImpl(this, continuation);
    }

    public final int getIndex() {
        return this.index;
    }

    public final KPictureModule getValue() {
        return this.value;
    }
}