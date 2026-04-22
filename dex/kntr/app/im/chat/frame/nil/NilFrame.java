package kntr.app.im.chat.frame.nil;

import com.bilibili.blens.BSetter;
import com.bilibili.blens.BSimpleLens;
import java.lang.annotation.Annotation;
import java.util.List;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: NilFrame.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00000\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lkntr/app/im/chat/frame/nil/NilFrame;", "Lkntr/app/im/chat/core/model/MsgFrame;", "<init>", "()V", "modules", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/MsgModule;", "getModules", "()Ljava/util/List;", "modulesLens", "Lcom/bilibili/blens/BSimpleLens;", "getModulesLens", "()Lcom/bilibili/blens/BSimpleLens;", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class NilFrame implements MsgFrame {
    public static final int $stable = 0;
    public static final NilFrame INSTANCE = new NilFrame();
    private static final BSimpleLens<MsgFrame, List<MsgModule>> modulesLens = new BSimpleLens<MsgFrame, List<? extends MsgModule>>() { // from class: kntr.app.im.chat.frame.nil.NilFrame$modulesLens$1
        public /* bridge */ /* synthetic */ Object modify(Object source, Function1 map) {
            return modify((MsgFrame) source, (Function1<? super List<? extends MsgModule>, ? extends List<? extends MsgModule>>) map);
        }

        public /* bridge */ MsgFrame set(MsgFrame source, List<? extends MsgModule> list) {
            return (MsgFrame) BSetter.-CC.$default$set(this, source, list);
        }

        public List<MsgModule> get(MsgFrame source) {
            Intrinsics.checkNotNullParameter(source, "source");
            return NilFrame.INSTANCE.getModules();
        }

        public MsgFrame modify(MsgFrame source, Function1<? super List<? extends MsgModule>, ? extends List<? extends MsgModule>> function1) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(function1, "map");
            return source;
        }
    };
    private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.frame.nil.NilFrame$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _init_$_anonymous_;
            _init_$_anonymous_ = NilFrame._init_$_anonymous_();
            return _init_$_anonymous_;
        }
    });

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NilFrame) {
            NilFrame nilFrame = (NilFrame) obj;
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 493599744;
    }

    public String toString() {
        return "NilFrame";
    }

    private NilFrame() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return new ObjectSerializer("kntr.app.im.chat.frame.nil.NilFrame", INSTANCE, new Annotation[0]);
    }

    private final /* synthetic */ KSerializer get$cachedSerializer() {
        return (KSerializer) $cachedSerializer$delegate.getValue();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ boolean getRequireUpdate() {
        return MsgFrame.CC.$default$getRequireUpdate(this);
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public /* bridge */ Object restoreFrame(Continuation<? super MsgFrame> continuation) {
        return MsgFrame.CC.restoreFrame$suspendImpl(this, continuation);
    }

    public final KSerializer<NilFrame> serializer() {
        return get$cachedSerializer();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public List<MsgModule> getModules() {
        return CollectionsKt.emptyList();
    }

    @Override // kntr.app.im.chat.core.model.MsgFrame
    public BSimpleLens<MsgFrame, List<MsgModule>> getModulesLens() {
        return modulesLens;
    }
}