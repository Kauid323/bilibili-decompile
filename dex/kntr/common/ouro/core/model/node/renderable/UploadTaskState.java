package kntr.common.ouro.core.model.node.renderable;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.collection.DoubleList$;
import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.renderable.UploadTaskState;
import kntr.common.paragraph.assetuploader.UploadTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.ContextualSerializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroLocalImage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u000f2\u00020\u0001:\u0006\n\u000b\f\r\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b\u0082\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "", "identifier", "", "getIdentifier", "()Ljava/lang/String;", "isFailed", "", "()Z", "isSuccess", "Unfinished", "Idle", "Uploading", "Success", "Failure", "Companion", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Failure;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Success;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable
public interface UploadTaskState {
    public static final Companion Companion = Companion.$$INSTANCE;

    String getIdentifier();

    boolean isFailed();

    boolean isSuccess();

    /* compiled from: OuroLocalImage.kt */
    /* renamed from: kntr.common.ouro.core.model.node.renderable.UploadTaskState$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        static {
            Companion companion = UploadTaskState.Companion;
        }

        public static boolean $default$isFailed(UploadTaskState _this) {
            return _this instanceof Failure;
        }

        public static boolean $default$isSuccess(UploadTaskState _this) {
            return _this instanceof Success;
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final KSerializer<UploadTaskState> serializer() {
            return new SealedClassSerializer<>("kntr.common.ouro.core.model.node.renderable.UploadTaskState", Reflection.getOrCreateKotlinClass(UploadTaskState.class), new KClass[]{Reflection.getOrCreateKotlinClass(Failure.class), Reflection.getOrCreateKotlinClass(Success.class), Reflection.getOrCreateKotlinClass(Idle.class), Reflection.getOrCreateKotlinClass(Uploading.class)}, new KSerializer[]{UploadTaskState$Failure$$serializer.INSTANCE, UploadTaskState$Success$$serializer.INSTANCE, UploadTaskState$Idle$$serializer.INSTANCE, UploadTaskState$Uploading$$serializer.INSTANCE}, new Annotation[0]);
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u0082\u0001\u0002\u0003\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "Companion", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Idle;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Unfinished extends UploadTaskState {
        public static final Companion Companion = Companion.$$INSTANCE;

        /* compiled from: OuroLocalImage.kt */
        /* renamed from: kntr.common.ouro.core.model.node.renderable.UploadTaskState$Unfinished$-CC  reason: invalid class name */
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public final /* synthetic */ class CC {
            static {
                Companion companion = Unfinished.Companion;
            }
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            public final KSerializer<Unfinished> serializer() {
                return new SealedClassSerializer<>("kntr.common.ouro.core.model.node.renderable.UploadTaskState.Unfinished", Reflection.getOrCreateKotlinClass(Unfinished.class), new KClass[]{Reflection.getOrCreateKotlinClass(Idle.class), Reflection.getOrCreateKotlinClass(Uploading.class)}, new KSerializer[]{UploadTaskState$Idle$$serializer.INSTANCE, UploadTaskState$Uploading$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class DefaultImpls {
            @Deprecated
            public static boolean isFailed(Unfinished $this) {
                return CC.$default$isFailed($this);
            }

            @Deprecated
            public static boolean isSuccess(Unfinished $this) {
                return CC.$default$isSuccess($this);
            }
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Idle;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished;", "identifier", "", "<init>", "(Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Idle implements Unfinished {
        public static final Companion Companion = new Companion(null);
        private final String identifier;

        public static /* synthetic */ Idle copy$default(Idle idle, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idle.identifier;
            }
            return idle.copy(str);
        }

        public final String component1() {
            return this.identifier;
        }

        public final Idle copy(String str) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            return new Idle(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Idle) && Intrinsics.areEqual(this.identifier, ((Idle) obj).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        public String toString() {
            return "Idle(identifier=" + this.identifier + ")";
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Idle$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Idle;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Idle> serializer() {
                return UploadTaskState$Idle$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Idle(int seen0, String identifier, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (seen0 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 1, UploadTaskState$Idle$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = identifier;
        }

        public Idle(String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isFailed() {
            return CC.$default$isFailed(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isSuccess() {
            return CC.$default$isSuccess(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public String getIdentifier() {
            return this.identifier;
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u0016\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0017J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J'\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J%\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0001¢\u0006\u0002\b'R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Unfinished;", "identifier", "", "task", "Lkntr/common/paragraph/assetuploader/UploadTask;", "progress", "", "<init>", "(Ljava/lang/String;Lkntr/common/paragraph/assetuploader/UploadTask;F)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkntr/common/paragraph/assetuploader/UploadTask;FLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIdentifier", "()Ljava/lang/String;", "getTask$core_debug", "()Lkntr/common/paragraph/assetuploader/UploadTask;", "getProgress", "()F", "component1", "component2", "component2$core_debug", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Uploading implements Unfinished {
        private final String identifier;
        private final float progress;
        private final UploadTask task;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.node.renderable.UploadTaskState$Uploading$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = UploadTaskState.Uploading._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        }), null};

        public static /* synthetic */ Uploading copy$default(Uploading uploading, String str, UploadTask uploadTask, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = uploading.identifier;
            }
            if ((i & 2) != 0) {
                uploadTask = uploading.task;
            }
            if ((i & 4) != 0) {
                f = uploading.progress;
            }
            return uploading.copy(str, uploadTask, f);
        }

        public final String component1() {
            return this.identifier;
        }

        public final UploadTask component2$core_debug() {
            return this.task;
        }

        public final float component3() {
            return this.progress;
        }

        public final Uploading copy(String str, UploadTask uploadTask, float f) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            Intrinsics.checkNotNullParameter(uploadTask, "task");
            return new Uploading(str, uploadTask, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Uploading) {
                Uploading uploading = (Uploading) obj;
                return Intrinsics.areEqual(this.identifier, uploading.identifier) && Intrinsics.areEqual(this.task, uploading.task) && Float.compare(this.progress, uploading.progress) == 0;
            }
            return false;
        }

        public int hashCode() {
            return (((this.identifier.hashCode() * 31) + this.task.hashCode()) * 31) + Float.floatToIntBits(this.progress);
        }

        public String toString() {
            String str = this.identifier;
            UploadTask uploadTask = this.task;
            return "Uploading(identifier=" + str + ", task=" + uploadTask + ", progress=" + this.progress + ")";
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Uploading;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Uploading> serializer() {
                return UploadTaskState$Uploading$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Uploading(int seen0, String identifier, UploadTask task, float progress, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (seen0 & 7)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 7, UploadTaskState$Uploading$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = identifier;
            this.task = task;
            this.progress = progress;
        }

        public Uploading(String identifier, UploadTask task, float progress) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(task, "task");
            this.identifier = identifier;
            this.task = task;
            this.progress = progress;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(UploadTask.class), new Annotation[0]);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Uploading self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getIdentifier());
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.task);
            output.encodeFloatElement(serialDesc, 2, self.progress);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isFailed() {
            return CC.$default$isFailed(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isSuccess() {
            return CC.$default$isSuccess(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public String getIdentifier() {
            return this.identifier;
        }

        public final UploadTask getTask$core_debug() {
            return this.task;
        }

        public final float getProgress() {
            return this.progress;
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rBO\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u000bHÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00063"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Success;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "identifier", "", "imageUrl", "imageWidth", "", "imageHeight", "imageSize", "", "AIGenMark", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJDI)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;JJDILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIdentifier", "()Ljava/lang/String;", "getImageUrl", "getImageWidth", "()J", "getImageHeight", "getImageSize", "()D", "getAIGenMark", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Success implements UploadTaskState {
        public static final Companion Companion = new Companion(null);
        private final int AIGenMark;
        private final String identifier;
        private final long imageHeight;
        private final double imageSize;
        private final String imageUrl;
        private final long imageWidth;

        public final String component1() {
            return this.identifier;
        }

        public final String component2() {
            return this.imageUrl;
        }

        public final long component3() {
            return this.imageWidth;
        }

        public final long component4() {
            return this.imageHeight;
        }

        public final double component5() {
            return this.imageSize;
        }

        public final int component6() {
            return this.AIGenMark;
        }

        public final Success copy(String str, String str2, long j, long j2, double d, int i) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            Intrinsics.checkNotNullParameter(str2, "imageUrl");
            return new Success(str, str2, j, j2, d, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.identifier, success.identifier) && Intrinsics.areEqual(this.imageUrl, success.imageUrl) && this.imageWidth == success.imageWidth && this.imageHeight == success.imageHeight && Double.compare(this.imageSize, success.imageSize) == 0 && this.AIGenMark == success.AIGenMark;
            }
            return false;
        }

        public int hashCode() {
            return (((((((((this.identifier.hashCode() * 31) + this.imageUrl.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.imageWidth)) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.imageHeight)) * 31) + DoubleList$.ExternalSyntheticBackport0.m(this.imageSize)) * 31) + this.AIGenMark;
        }

        public String toString() {
            String str = this.identifier;
            String str2 = this.imageUrl;
            long j = this.imageWidth;
            long j2 = this.imageHeight;
            double d = this.imageSize;
            return "Success(identifier=" + str + ", imageUrl=" + str2 + ", imageWidth=" + j + ", imageHeight=" + j2 + ", imageSize=" + d + ", AIGenMark=" + this.AIGenMark + ")";
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Success$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Success;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Success> serializer() {
                return UploadTaskState$Success$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Success(int seen0, String identifier, String imageUrl, long imageWidth, long imageHeight, double imageSize, int AIGenMark, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (seen0 & 63)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 63, UploadTaskState$Success$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = identifier;
            this.imageUrl = imageUrl;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.imageSize = imageSize;
            this.AIGenMark = AIGenMark;
        }

        public Success(String identifier, String imageUrl, long imageWidth, long imageHeight, double imageSize, int AIGenMark) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
            this.identifier = identifier;
            this.imageUrl = imageUrl;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
            this.imageSize = imageSize;
            this.AIGenMark = AIGenMark;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Success self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.getIdentifier());
            output.encodeStringElement(serialDesc, 1, self.imageUrl);
            output.encodeLongElement(serialDesc, 2, self.imageWidth);
            output.encodeLongElement(serialDesc, 3, self.imageHeight);
            output.encodeDoubleElement(serialDesc, 4, self.imageSize);
            output.encodeIntElement(serialDesc, 5, self.AIGenMark);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isFailed() {
            return CC.$default$isFailed(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isSuccess() {
            return CC.$default$isSuccess(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public String getIdentifier() {
            return this.identifier;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final long getImageWidth() {
            return this.imageWidth;
        }

        public final long getImageHeight() {
            return this.imageHeight;
        }

        public final double getImageSize() {
            return this.imageSize;
        }

        public final int getAIGenMark() {
            return this.AIGenMark;
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Failure;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState;", "identifier", "", "error", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Throwable;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getIdentifier", "()Ljava/lang/String;", "getError$annotations", "()V", "getError", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Failure implements UploadTaskState {
        private final transient Throwable error;
        private final String identifier;
        public static final Companion Companion = new Companion(null);
        private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.common.ouro.core.model.node.renderable.UploadTaskState$Failure$$ExternalSyntheticLambda0
            public final Object invoke() {
                KSerializer _childSerializers$_anonymous_;
                _childSerializers$_anonymous_ = UploadTaskState.Failure._childSerializers$_anonymous_();
                return _childSerializers$_anonymous_;
            }
        })};

        public static /* synthetic */ Failure copy$default(Failure failure, String str, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.identifier;
            }
            if ((i & 2) != 0) {
                th = failure.error;
            }
            return failure.copy(str, th);
        }

        public static /* synthetic */ void getError$annotations() {
        }

        public final String component1() {
            return this.identifier;
        }

        public final Throwable component2() {
            return this.error;
        }

        public final Failure copy(String str, Throwable th) {
            Intrinsics.checkNotNullParameter(str, "identifier");
            Intrinsics.checkNotNullParameter(th, "error");
            return new Failure(str, th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return Intrinsics.areEqual(this.identifier, failure.identifier) && Intrinsics.areEqual(this.error, failure.error);
            }
            return false;
        }

        public int hashCode() {
            return (this.identifier.hashCode() * 31) + this.error.hashCode();
        }

        public String toString() {
            String str = this.identifier;
            return "Failure(identifier=" + str + ", error=" + this.error + ")";
        }

        /* compiled from: OuroLocalImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Failure$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/UploadTaskState$Failure;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Failure> serializer() {
                return UploadTaskState$Failure$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Failure(int seen0, String identifier, Throwable error, SerializationConstructorMarker serializationConstructorMarker) {
            if (3 != (seen0 & 3)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 3, UploadTaskState$Failure$$serializer.INSTANCE.getDescriptor());
            }
            this.identifier = identifier;
            this.error = error;
        }

        public Failure(String identifier, Throwable error) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(error, "error");
            this.identifier = identifier;
            this.error = error;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ContextualSerializer(Reflection.getOrCreateKotlinClass(Throwable.class), (KSerializer) null, new KSerializer[0]);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Failure self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
            output.encodeStringElement(serialDesc, 0, self.getIdentifier());
            output.encodeSerializableElement(serialDesc, 1, lazyArr[1].getValue(), self.error);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isFailed() {
            return CC.$default$isFailed(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public /* bridge */ boolean isSuccess() {
            return CC.$default$isSuccess(this);
        }

        @Override // kntr.common.ouro.core.model.node.renderable.UploadTaskState
        public String getIdentifier() {
            return this.identifier;
        }

        public final Throwable getError() {
            return this.error;
        }
    }

    /* compiled from: OuroLocalImage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isFailed(UploadTaskState $this) {
            return CC.$default$isFailed($this);
        }

        @Deprecated
        public static boolean isSuccess(UploadTaskState $this) {
            return CC.$default$isSuccess($this);
        }
    }
}