package io.ktor.serialization;

import com.xiaomi.mipush.sdk.MiPushClient;
import io.ktor.http.ContentType;
import io.ktor.serialization.Configuration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ContentConverter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JD\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0019\b\u0002\u0010\n\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\b\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/serialization/Configuration;", "", "Lio/ktor/serialization/ContentConverter;", "T", "Lio/ktor/http/ContentType;", "contentType", "converter", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "configuration", MiPushClient.COMMAND_REGISTER, "(Lio/ktor/http/ContentType;Lio/ktor/serialization/ContentConverter;Lkotlin/jvm/functions/Function1;)V", "ktor-serialization"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Configuration {
    <T extends ContentConverter> void register(ContentType contentType, T t, Function1<? super T, Unit> function1);

    /* compiled from: ContentConverter.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void register$default(Configuration configuration, ContentType contentType, ContentConverter contentConverter, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
            }
            if ((i2 & 4) != 0) {
                function1 = new Function1() { // from class: io.ktor.serialization.Configuration$DefaultImpls$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        Unit register$lambda$0;
                        register$lambda$0 = Configuration.DefaultImpls.register$lambda$0((ContentConverter) obj2);
                        return register$lambda$0;
                    }
                };
            }
            configuration.register(contentType, contentConverter, function1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit register$lambda$0(ContentConverter contentConverter) {
            Intrinsics.checkNotNullParameter(contentConverter, "<this>");
            return Unit.INSTANCE;
        }
    }
}