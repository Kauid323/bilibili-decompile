package srcs.common.paragraph.input.ui.generated.resources;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.compose.resources.StringResource;
import tv.danmaku.bili.BR;

/* compiled from: String0.commonMain.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Lsrcs/common/paragraph/input/ui/generated/resources/CommonMainString0;", "", "<init>", "()V", "image_upload_failed", "Lorg/jetbrains/compose/resources/StringResource;", "getImage_upload_failed", "()Lorg/jetbrains/compose/resources/StringResource;", "image_upload_failed$delegate", "Lkotlin/Lazy;", "image_uploading", "getImage_uploading", "image_uploading$delegate", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = BR.badgeVisibility)
final class CommonMainString0 {
    public static final CommonMainString0 INSTANCE = new CommonMainString0();
    private static final Lazy image_upload_failed$delegate = LazyKt.lazy(new Function0() { // from class: srcs.common.paragraph.input.ui.generated.resources.CommonMainString0$$ExternalSyntheticLambda0
        public final Object invoke() {
            StringResource image_upload_failed_delegate$lambda$0;
            image_upload_failed_delegate$lambda$0 = CommonMainString0.image_upload_failed_delegate$lambda$0();
            return image_upload_failed_delegate$lambda$0;
        }
    });
    private static final Lazy image_uploading$delegate = LazyKt.lazy(new Function0() { // from class: srcs.common.paragraph.input.ui.generated.resources.CommonMainString0$$ExternalSyntheticLambda1
        public final Object invoke() {
            StringResource image_uploading_delegate$lambda$0;
            image_uploading_delegate$lambda$0 = CommonMainString0.image_uploading_delegate$lambda$0();
            return image_uploading_delegate$lambda$0;
        }
    });

    private CommonMainString0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource image_upload_failed_delegate$lambda$0() {
        StringResource init_image_upload_failed;
        init_image_upload_failed = String0_commonMainKt.init_image_upload_failed();
        return init_image_upload_failed;
    }

    public final StringResource getImage_upload_failed() {
        return (StringResource) image_upload_failed$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StringResource image_uploading_delegate$lambda$0() {
        StringResource init_image_uploading;
        init_image_uploading = String0_commonMainKt.init_image_uploading();
        return init_image_uploading;
    }

    public final StringResource getImage_uploading() {
        return (StringResource) image_uploading$delegate.getValue();
    }
}