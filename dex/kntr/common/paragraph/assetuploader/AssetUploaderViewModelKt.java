package kntr.common.paragraph.assetuploader;

import com.bilibili.lib.gripper.api.hiltlike.Component_jvmKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.gripper.component.holder.Gripper_component_holder_androidKt;
import kntr.common.paragraph.assetuploader.di.AssetUploaderEntryPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AssetUploaderViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"getAssetUploaderViewModelFactory", "Lkntr/common/paragraph/assetuploader/AssetUploaderViewModelFactory;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "bucket", "", "assetuploader_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AssetUploaderViewModelKt {
    public static final AssetUploaderViewModelFactory getAssetUploaderViewModelFactory(CoroutineScope scope, String bucket) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Object $this$entryPoint$iv = Gripper_component_holder_androidKt.getRootGripperComponent();
        return ((AssetUploaderEntryPoint) Component_jvmKt.entryPoint($this$entryPoint$iv, Reflection.getOrCreateKotlinClass(AssetUploaderEntryPoint.class))).getAssetUploaderComponentFactory().build(scope, bucket).viewModelFactory();
    }
}