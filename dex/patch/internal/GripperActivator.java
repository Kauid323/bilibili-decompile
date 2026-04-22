package patch.internal;

import android.app.Application;
import com.bilibili.lib.gripper.api.BaseSettingsFetcher;
import com.bilibili.lib.gripper.api.internal.GripperSettings;
import com.bilibili.lib.tribe.runtime.BundleActivator;
import dagger.hilt.EntryPoints;
import gripper.internal.plugins.codegen.Patch;

public final class GripperActivator implements BundleActivator {
    public void onActivate(Application app) {
        GripperSettings settings = ((BaseSettingsFetcher) EntryPoints.get(app, BaseSettingsFetcher.class)).getSettings();
        settings.applyPlugin("patch", new Patch());
    }
}