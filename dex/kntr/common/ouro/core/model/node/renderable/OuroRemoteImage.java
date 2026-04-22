package kntr.common.ouro.core.model.node.renderable;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.renderable.OuroRenderable;
import kntr.common.ouro.core.utils.RandomUuidKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: OuroRemoteImage.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u000e\u000fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "Lkntr/common/ouro/core/model/node/renderable/OuroRenderable$BuiltIn;", "lightImageURL", "", "getLightImageURL", "()Ljava/lang/String;", "darkImageURL", "getDarkImageURL", "width", "", "getWidth", "()I", "height", "getHeight", "Image", "Sticker", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Image;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Sticker;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface OuroRemoteImage extends OuroRenderable.BuiltIn {
    String getDarkImageURL();

    int getHeight();

    String getLightImageURL();

    int getWidth();

    /* compiled from: OuroRemoteImage.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bB+\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\rBQ\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\n\u0010\u0011J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\b\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016¨\u0006$"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Image;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "lightImageURL", "", "darkImageURL", "width", "", "height", "reuseIdentifier", "AIGenMark", "<init>", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;I)V", "url", "(Ljava/lang/String;III)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getLightImageURL", "()Ljava/lang/String;", "getDarkImageURL", "getWidth", "()I", "getHeight", "getReuseIdentifier", "getAIGenMark", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Image implements OuroRemoteImage {
        public static final Companion Companion = new Companion(null);
        private final int AIGenMark;
        private final String darkImageURL;
        private final int height;
        private final String lightImageURL;
        private final String reuseIdentifier;
        private final int width;

        /* compiled from: OuroRemoteImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Image$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Image;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Image> serializer() {
                return OuroRemoteImage$Image$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Image(int seen0, String lightImageURL, String darkImageURL, int width, int height, String reuseIdentifier, int AIGenMark, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (seen0 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 15, OuroRemoteImage$Image$$serializer.INSTANCE.getDescriptor());
            }
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.width = width;
            this.height = height;
            if ((seen0 & 16) == 0) {
                this.reuseIdentifier = RandomUuidKt.randomUuid();
            } else {
                this.reuseIdentifier = reuseIdentifier;
            }
            if ((seen0 & 32) == 0) {
                this.AIGenMark = 0;
            } else {
                this.AIGenMark = AIGenMark;
            }
        }

        public Image(String lightImageURL, String darkImageURL, int width, int height, String reuseIdentifier, int AIGenMark) {
            Intrinsics.checkNotNullParameter(lightImageURL, "lightImageURL");
            Intrinsics.checkNotNullParameter(darkImageURL, "darkImageURL");
            Intrinsics.checkNotNullParameter(reuseIdentifier, "reuseIdentifier");
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.width = width;
            this.height = height;
            this.reuseIdentifier = reuseIdentifier;
            this.AIGenMark = AIGenMark;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Image self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.getLightImageURL());
            output.encodeStringElement(serialDesc, 1, self.getDarkImageURL());
            output.encodeIntElement(serialDesc, 2, self.getWidth());
            output.encodeIntElement(serialDesc, 3, self.getHeight());
            if (output.shouldEncodeElementDefault(serialDesc, 4) || !Intrinsics.areEqual(self.getReuseIdentifier(), RandomUuidKt.randomUuid())) {
                output.encodeStringElement(serialDesc, 4, self.getReuseIdentifier());
            }
            if (output.shouldEncodeElementDefault(serialDesc, 5) || self.AIGenMark != 0) {
                output.encodeIntElement(serialDesc, 5, self.AIGenMark);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ Image(String str, String str2, int i, int i2, String str3, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, i2, r5, r6);
            String str4;
            int i5;
            if ((i4 & 16) == 0) {
                str4 = str3;
            } else {
                str4 = RandomUuidKt.randomUuid();
            }
            if ((i4 & 32) == 0) {
                i5 = i3;
            } else {
                i5 = 0;
            }
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public String getLightImageURL() {
            return this.lightImageURL;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public String getDarkImageURL() {
            return this.darkImageURL;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public int getWidth() {
            return this.width;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public int getHeight() {
            return this.height;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRenderable
        public String getReuseIdentifier() {
            return this.reuseIdentifier;
        }

        public final int getAIGenMark() {
            return this.AIGenMark;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Image(String url, int width, int height, int AIGenMark) {
            this(url, url, width, height, (String) null, AIGenMark, 16, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(url, "url");
        }

        public /* synthetic */ Image(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, (i4 & 8) != 0 ? 0 : i3);
        }
    }

    /* compiled from: OuroRemoteImage.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0002%&B;\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u000eBS\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000b\u0010\u0012J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\n\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014¨\u0006'"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Sticker;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage;", "Lkntr/common/ouro/core/model/node/OuroNode$Copyable;", "rawText", "", "lightImageURL", "darkImageURL", "width", "", "height", "reuseIdentifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "url", "(Ljava/lang/String;Ljava/lang/String;II)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRawText", "()Ljava/lang/String;", "getLightImageURL", "getDarkImageURL", "getWidth", "()I", "getHeight", "getReuseIdentifier", "copyText", "getCopyText", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "$serializer", "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Serializable
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Sticker implements OuroRemoteImage, OuroNode.Copyable {
        public static final Companion Companion = new Companion(null);
        private final String darkImageURL;
        private final int height;
        private final String lightImageURL;
        private final String rawText;
        private final String reuseIdentifier;
        private final int width;

        /* compiled from: OuroRemoteImage.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Sticker$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/common/ouro/core/model/node/renderable/OuroRemoteImage$Sticker;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
        /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Sticker> serializer() {
                return OuroRemoteImage$Sticker$$serializer.INSTANCE;
            }
        }

        public /* synthetic */ Sticker(int seen0, String rawText, String lightImageURL, String darkImageURL, int width, int height, String reuseIdentifier, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (seen0 & 31)) {
                PluginExceptionsKt.throwMissingFieldException(seen0, 31, OuroRemoteImage$Sticker$$serializer.INSTANCE.getDescriptor());
            }
            this.rawText = rawText;
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.width = width;
            this.height = height;
            if ((seen0 & 32) == 0) {
                this.reuseIdentifier = RandomUuidKt.randomUuid();
            } else {
                this.reuseIdentifier = reuseIdentifier;
            }
        }

        private Sticker(String rawText, String lightImageURL, String darkImageURL, int width, int height, String reuseIdentifier) {
            this.rawText = rawText;
            this.lightImageURL = lightImageURL;
            this.darkImageURL = darkImageURL;
            this.width = width;
            this.height = height;
            this.reuseIdentifier = reuseIdentifier;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$core_debug(Sticker self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.rawText);
            output.encodeStringElement(serialDesc, 1, self.getLightImageURL());
            output.encodeStringElement(serialDesc, 2, self.getDarkImageURL());
            output.encodeIntElement(serialDesc, 3, self.getWidth());
            output.encodeIntElement(serialDesc, 4, self.getHeight());
            if (output.shouldEncodeElementDefault(serialDesc, 5) || !Intrinsics.areEqual(self.getReuseIdentifier(), RandomUuidKt.randomUuid())) {
                output.encodeStringElement(serialDesc, 5, self.getReuseIdentifier());
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        /* synthetic */ Sticker(String str, String str2, String str3, int i, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, i, i2, r6);
            String str5;
            if ((i3 & 32) == 0) {
                str5 = str4;
            } else {
                str5 = RandomUuidKt.randomUuid();
            }
        }

        public final String getRawText() {
            return this.rawText;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public String getLightImageURL() {
            return this.lightImageURL;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public String getDarkImageURL() {
            return this.darkImageURL;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public int getWidth() {
            return this.width;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRemoteImage
        public int getHeight() {
            return this.height;
        }

        @Override // kntr.common.ouro.core.model.node.renderable.OuroRenderable
        public String getReuseIdentifier() {
            return this.reuseIdentifier;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Sticker(String rawText, String url, int width, int height) {
            this(rawText, url, url, width, height, (String) null, 32, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(rawText, "rawText");
            Intrinsics.checkNotNullParameter(url, "url");
        }

        @Override // kntr.common.ouro.core.model.node.OuroNode.Copyable
        public String getCopyText() {
            return this.rawText;
        }
    }
}