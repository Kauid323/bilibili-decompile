package kntr.base.brotli.epoch.impl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.brotli.IBrotli;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.brotli.wrapper.enc.BrotliOutputStream;

/* compiled from: KBrotli.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"mPlatformBrotli", "Lkntr/base/brotli/IBrotli;", "getMPlatformBrotli", "()Lkntr/base/brotli/IBrotli;", "mPlatformBrotli$delegate", "Lkotlin/Lazy;", "brotli_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KBrotli_androidKt {
    private static final Lazy mPlatformBrotli$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.brotli.epoch.impl.KBrotli_androidKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            KBrotli_androidKt$mPlatformBrotli$2$1 mPlatformBrotli_delegate$lambda$0;
            mPlatformBrotli_delegate$lambda$0 = KBrotli_androidKt.mPlatformBrotli_delegate$lambda$0();
            return mPlatformBrotli_delegate$lambda$0;
        }
    });

    public static final IBrotli getMPlatformBrotli() {
        return (IBrotli) mPlatformBrotli$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [kntr.base.brotli.epoch.impl.KBrotli_androidKt$mPlatformBrotli$2$1] */
    public static final KBrotli_androidKt$mPlatformBrotli$2$1 mPlatformBrotli_delegate$lambda$0() {
        return new IBrotli() { // from class: kntr.base.brotli.epoch.impl.KBrotli_androidKt$mPlatformBrotli$2$1
            @Override // kntr.base.brotli.IBrotli
            public byte[] compress(byte[] data) {
                Intrinsics.checkNotNullParameter(data, "data");
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
                BrotliOutputStream brotliOutputStream = (Closeable) new BrotliOutputStream(outputStream);
                try {
                    BrotliOutputStream bos = brotliOutputStream;
                    bos.write(data);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(brotliOutputStream, (Throwable) null);
                    byte[] byteArray = outputStream.toByteArray();
                    Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                    return byteArray;
                } finally {
                }
            }
        };
    }
}