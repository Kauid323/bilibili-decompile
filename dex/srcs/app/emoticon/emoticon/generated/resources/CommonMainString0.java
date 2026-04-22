package srcs.app.emoticon.emoticon.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;
import tv.danmaku.bili.BR;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/app/emoticon/emoticon/generated/resources/CommonMainString0;", "", "<init>", "()V", "emoticon_no_access_text", "Lorg/jetbrains/compose/resources/StringResource;", "getEmoticon_no_access_text", "()Lorg/jetbrains/compose/resources/StringResource;", "emoticon_no_access_text$delegate", "Lkotlin/Lazy;", "emoticon_reorder", "getEmoticon_reorder", "emoticon_reorder$delegate", "emoticon_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy emoticon_no_access_text$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.emoticon.emoticon.generated.resources.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource emoticon_no_access_text_delegate$lambda$0;
            emoticon_no_access_text_delegate$lambda$0 = CommonMainString0.emoticon_no_access_text_delegate$lambda$0();
            return emoticon_no_access_text_delegate$lambda$0;
        }
    });
    private static final Lazy emoticon_reorder$delegate = LazyKt.lazy(new Function0() { // from class: srcs.app.emoticon.emoticon.generated.resources.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource emoticon_reorder_delegate$lambda$0;
            emoticon_reorder_delegate$lambda$0 = CommonMainString0.emoticon_reorder_delegate$lambda$0();
            return emoticon_reorder_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource emoticon_no_access_text_delegate$lambda$0() {
        StringResource init_emoticon_no_access_text;
        init_emoticon_no_access_text = String0_commonMainKt.init_emoticon_no_access_text();
        return init_emoticon_no_access_text;
    }

    public final StringResource getEmoticon_no_access_text() {
        return (StringResource) emoticon_no_access_text$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource emoticon_reorder_delegate$lambda$0() {
        StringResource init_emoticon_reorder;
        init_emoticon_reorder = String0_commonMainKt.init_emoticon_reorder();
        return init_emoticon_reorder;
    }

    public final StringResource getEmoticon_reorder() {
        return (StringResource) emoticon_reorder$delegate.getValue();
    }
}