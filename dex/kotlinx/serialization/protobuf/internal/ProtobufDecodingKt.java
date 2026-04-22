package kotlinx.serialization.protobuf.internal;

import kotlin.Metadata;

/* compiled from: ProtobufDecoding.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0002¨\u0006\u0007"}, d2 = {"makeDelimited", "Lkotlinx/serialization/protobuf/internal/ProtobufReader;", "decoder", "parentTag", "", "Lkotlinx/serialization/protobuf/internal/ProtoDesc;", "makeDelimitedForced", "kotlinx-serialization-protobuf"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ProtobufDecodingKt {
    public static final ProtobufReader makeDelimited(ProtobufReader decoder, long parentTag) {
        boolean tagless = parentTag == ProtobufTaggedBaseKt.MISSING_TAG;
        ByteArrayInput input = tagless ? decoder.objectTaglessInput() : decoder.objectInput();
        return new ProtobufReader(input);
    }

    public static final ProtobufReader makeDelimitedForced(ProtobufReader decoder, long parentTag) {
        boolean tagless = parentTag == ProtobufTaggedBaseKt.MISSING_TAG;
        ByteArrayInput input = tagless ? decoder.objectTaglessInput() : decoder.objectInput();
        return new ProtobufReader(input);
    }
}