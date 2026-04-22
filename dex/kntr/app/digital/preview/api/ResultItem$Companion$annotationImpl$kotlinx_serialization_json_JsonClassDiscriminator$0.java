package kntr.app.digital.preview.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonClassDiscriminator;

/* compiled from: CardPreviewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final /* synthetic */ class ResultItem$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0 implements JsonClassDiscriminator {
    private final /* synthetic */ String discriminator;

    public ResultItem$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0(String str) {
        Intrinsics.checkNotNullParameter(str, "discriminator");
        this.discriminator = str;
    }

    public final /* synthetic */ Class annotationType() {
        return JsonClassDiscriminator.class;
    }

    public final /* synthetic */ String discriminator() {
        return this.discriminator;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof JsonClassDiscriminator) && Intrinsics.areEqual(discriminator(), ((JsonClassDiscriminator) obj).discriminator());
    }

    public final int hashCode() {
        return ("discriminator".hashCode() * 127) ^ this.discriminator.hashCode();
    }

    public final String toString() {
        return "@kotlinx.serialization.json.JsonClassDiscriminator(discriminator=" + this.discriminator + ")";
    }
}