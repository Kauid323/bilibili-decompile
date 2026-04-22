package kntr.app.im.chat.core.model;

import com.bilibili.blens.Lens;
import java.lang.annotation.Annotation;
import kntr.app.im.chat.core.model.MsgModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ObjectSerializer;

/* compiled from: MsgModule.kt */
@Lens
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \b2\u00020\u0001:\u0002\b\tJ\u000e\u0010\u0002\u001a\u00020\u0000H\u0096@¢\u0006\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/im/chat/core/model/MsgModule;", RoomRecommendViewModel.EMPTY_CURSOR, "rebuildModule", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "getRequireUpdate", "()Z", "Companion", "UnknownModule", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface MsgModule {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean getRequireUpdate();

    Object rebuildModule(Continuation<? super MsgModule> continuation);

    /* compiled from: MsgModule.kt */
    /* renamed from: kntr.app.im.chat.core.model.MsgModule$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = MsgModule.Companion;
        }

        public static /* synthetic */ Object rebuildModule$suspendImpl(MsgModule $this, Continuation<? super MsgModule> continuation) {
            return $this;
        }

        public static boolean $default$getRequireUpdate(MsgModule _this) {
            return false;
        }
    }

    /* compiled from: MsgModule.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/MsgModule$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* compiled from: MsgModule.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static Object rebuildModule(MsgModule $this, Continuation<? super MsgModule> continuation) {
            return CC.rebuildModule$suspendImpl($this, continuation);
        }

        @Deprecated
        public static boolean getRequireUpdate(MsgModule $this) {
            return CC.$default$getRequireUpdate($this);
        }
    }

    /* compiled from: MsgModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00000\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lkntr/app/im/chat/core/model/MsgModule$UnknownModule;", "Lkntr/app/im/chat/core/model/MsgModule;", "<init>", "()V", "requireUpdate", RoomRecommendViewModel.EMPTY_CURSOR, "getRequireUpdate", "()Z", "equals", "other", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "serializer", "Lkotlinx/serialization/KSerializer;", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Serializable
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class UnknownModule implements MsgModule {
        public static final int $stable = 0;
        public static final UnknownModule INSTANCE = new UnknownModule();
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.core.model.MsgModule$UnknownModule$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = MsgModule.UnknownModule._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UnknownModule) {
                UnknownModule unknownModule = (UnknownModule) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -65379769;
        }

        public String toString() {
            return "UnknownModule";
        }

        private UnknownModule() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("kntr.app.im.chat.core.model.MsgModule.UnknownModule", INSTANCE, new Annotation[0]);
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        @Override // kntr.app.im.chat.core.model.MsgModule
        public /* bridge */ Object rebuildModule(Continuation<? super MsgModule> continuation) {
            return CC.rebuildModule$suspendImpl(this, continuation);
        }

        public final KSerializer<UnknownModule> serializer() {
            return get$cachedSerializer();
        }

        @Override // kntr.app.im.chat.core.model.MsgModule
        public boolean getRequireUpdate() {
            return true;
        }
    }
}