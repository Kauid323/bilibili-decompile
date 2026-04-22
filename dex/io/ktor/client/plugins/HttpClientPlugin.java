package io.ktor.client.plugins;

import faceverify.q;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientPlugin.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001J*\u0010\b\u001a\u00028\u00012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/client/plugins/HttpClientPlugin;", "", "TConfig", "TPlugin", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "prepare", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "plugin", "Lio/ktor/client/HttpClient;", "scope", "install", "(Ljava/lang/Object;Lio/ktor/client/HttpClient;)V", "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", q.KEY_RES_9_KEY, "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HttpClientPlugin<TConfig, TPlugin> {
    AttributeKey<TPlugin> getKey();

    void install(TPlugin tplugin, HttpClient httpClient);

    TPlugin prepare(Function1<? super TConfig, Unit> function1);

    /* compiled from: HttpClientPlugin.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object prepare$default(HttpClientPlugin httpClientPlugin, Function1 function1, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    function1 = new Function1() { // from class: io.ktor.client.plugins.HttpClientPlugin$DefaultImpls$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj2) {
                            Unit prepare$lambda$0;
                            prepare$lambda$0 = HttpClientPlugin.DefaultImpls.prepare$lambda$0(obj2);
                            return prepare$lambda$0;
                        }
                    };
                }
                return httpClientPlugin.prepare(function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prepare");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Unit prepare$lambda$0(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "<this>");
            return Unit.INSTANCE;
        }
    }
}