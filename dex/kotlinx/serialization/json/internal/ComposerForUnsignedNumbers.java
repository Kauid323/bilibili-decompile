package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composers.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/JsonWriter;", "forceQuoting", "", "(Lkotlinx/serialization/json/internal/JsonWriter;Z)V", "print", "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter writer, boolean forceQuoting) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = forceQuoting;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        if (this.forceQuoting) {
            printQuoted(ComposerForUnsignedNumbers$$ExternalSyntheticBackport2.m(UInt.constructor-impl(v)));
        } else {
            print(ComposerForUnsignedNumbers$$ExternalSyntheticBackport2.m(UInt.constructor-impl(v)));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        String m;
        String m2;
        if (this.forceQuoting) {
            m2 = ComposerForUnsignedNumbers$$ExternalSyntheticBackport3.m(ULong.constructor-impl(v), 10);
            printQuoted(m2);
            return;
        }
        m = ComposerForUnsignedNumbers$$ExternalSyntheticBackport3.m(ULong.constructor-impl(v), 10);
        print(m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        if (this.forceQuoting) {
            printQuoted(UByte.toString-impl(UByte.constructor-impl(v)));
        } else {
            print(UByte.toString-impl(UByte.constructor-impl(v)));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        if (this.forceQuoting) {
            printQuoted(UShort.toString-impl(UShort.constructor-impl(v)));
        } else {
            print(UShort.toString-impl(UShort.constructor-impl(v)));
        }
    }
}