package im.chat.legacy;

import com.bilibili.lib.brouter.uri.Uri;
import com.bilibili.lib.gripper.api.GripperKt;
import com.bilibili.lib.gripper.api.ProducerContainer;
import com.bilibili.lib.gripper.api.SuspendProducer;
import im.base.IMLog;
import im.base.config.IMConfigSetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.base.router.target.RouterTarget;
import kntr.base.router.target.RouterTargetContext;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: ChatPageRedirector.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"redirectPersonalChat", "", "url", "redirectAssistantChat", "redirectChat", "Lcom/bilibili/lib/brouter/uri/Uri;", "setting", "Lim/base/config/IMConfigSetting;", "originUrl", "getId", "Lkotlin/Function1;", "", "redirectSystemChat", "Lkntr/base/router/target/RouterTarget;", "Lkntr/base/router/target/RouterTargetContext;", "legacy_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageRedirectorKt {
    public static final String redirectPersonalChat(String url) {
        IMConfigSetting setting;
        Intrinsics.checkNotNullParameter(url, "url");
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IMConfigSetting.class), (String) null, 2, (Object) null);
        if (suspendProducer == null || (setting = (IMConfigSetting) suspendProducer.get()) == null) {
            setting = new IMConfigSetting(false, false, 0L, 0L, 15, null);
        }
        IMLog.Companion.i("ChatPageRedirector", "IMConfigSetting: " + setting);
        final Uri originUrl = Uri.Companion.parse(url);
        Uri newUrl = redirectChat(setting, originUrl, new Function1() { // from class: im.chat.legacy.ChatPageRedirectorKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Long redirectPersonalChat$lambda$0;
                redirectPersonalChat$lambda$0 = ChatPageRedirectorKt.redirectPersonalChat$lambda$0(originUrl, (Uri) obj);
                return redirectPersonalChat$lambda$0;
            }
        });
        return newUrl.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long redirectPersonalChat$lambda$0(Uri $originUrl, Uri it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = (String) CollectionsKt.getOrNull($originUrl.getPathSegments(), 2);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }

    public static final String redirectAssistantChat(String url) {
        IMConfigSetting setting;
        Intrinsics.checkNotNullParameter(url, "url");
        SuspendProducer suspendProducer = ProducerContainer.DefaultImpls.get$default(GripperKt.getGripper(Gripper_component_holder_androidKt.getRootGripperComponent()).getContainer(), Reflection.getOrCreateKotlinClass(IMConfigSetting.class), (String) null, 2, (Object) null);
        if (suspendProducer == null || (setting = (IMConfigSetting) suspendProducer.get()) == null) {
            setting = new IMConfigSetting(false, false, 0L, 0L, 15, null);
        }
        IMLog.Companion.i("ChatPageRedirector", "IMConfigSetting: " + setting);
        final Uri originUrl = Uri.Companion.parse(url);
        Uri newUrl = redirectChat(setting, originUrl, new Function1() { // from class: im.chat.legacy.ChatPageRedirectorKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Long redirectAssistantChat$lambda$0;
                redirectAssistantChat$lambda$0 = ChatPageRedirectorKt.redirectAssistantChat$lambda$0(originUrl, (Uri) obj);
                return redirectAssistantChat$lambda$0;
            }
        });
        return newUrl.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Long redirectAssistantChat$lambda$0(Uri $originUrl, Uri it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = (String) CollectionsKt.getOrNull($originUrl.getPathSegments(), 3);
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }

    public static final Uri redirectChat(IMConfigSetting setting, Uri originUrl, Function1<? super Uri, Long> function1) {
        Uri newUrl;
        Intrinsics.checkNotNullParameter(setting, "setting");
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(function1, "getId");
        IMLog.Companion.i("ChatPageRedirector", "IMConfigSetting: " + setting);
        if (setting.getBffChatEnabled()) {
            Uri.Builder $this$redirectChat_u24lambda_u240 = new Uri.Builder().scheme(originUrl.getScheme()).authority(originUrl.getAuthority()).appendPath("compose");
            boolean z = false;
            Iterable $this$forEach$iv = originUrl.getPathSegments();
            for (Object element$iv : $this$forEach$iv) {
                $this$redirectChat_u24lambda_u240.appendPath((String) element$iv);
            }
            Iterable $this$flatMap$iv = originUrl.getQueryParameterNames();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                String key = (String) element$iv$iv;
                Iterable $this$map$iv = originUrl.getQueryParameters(key);
                boolean z2 = z;
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Iterable $this$map$iv2 = $this$map$iv;
                    destination$iv$iv2.add(TuplesKt.to(key, (String) item$iv$iv));
                    $this$map$iv = $this$map$iv2;
                }
                Iterable list$iv$iv = (List) destination$iv$iv2;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
                z = z2;
                $this$flatMap$iv = $this$flatMap$iv2;
            }
            Iterable $this$forEach$iv2 = (List) destination$iv$iv;
            for (Object element$iv2 : $this$forEach$iv2) {
                Pair it = (Pair) element$iv2;
                $this$redirectChat_u24lambda_u240.appendQueryParameter((String) it.getFirst(), (String) it.getSecond());
            }
            newUrl = $this$redirectChat_u24lambda_u240.build();
        } else {
            Long id = (Long) function1.invoke(originUrl);
            newUrl = Uri.Companion.parse("bilibili://im/conversation").buildUpon().appendQueryParameter("user_id", String.valueOf(id)).build();
        }
        IMLog.Companion.i("ChatPageRedirector", "Redirecting " + originUrl + " to " + newUrl);
        return newUrl;
    }

    public static final RouterTarget redirectSystemChat(RouterTargetContext $this$redirectSystemChat) {
        Intrinsics.checkNotNullParameter($this$redirectSystemChat, "<this>");
        Uri url = $this$redirectSystemChat.getUri();
        Uri it = Uri.Companion.parse("https://message.bilibili.com/h5/app/system-message#");
        IMLog.Companion.i("ChatPageRedirector", "Redirecting " + url + " to " + it);
        return $this$redirectSystemChat.find(it);
    }
}