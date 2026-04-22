package android.content.res;

import android.app.AndroidAppHelper;
import android.util.DisplayMetrics;

public class XModuleResources extends Resources {
    private XModuleResources(AssetManager assets, DisplayMetrics metrics, Configuration config) {
        super(assets, metrics, config);
    }

    public static XModuleResources createInstance(String path, XResources origRes) {
        XModuleResources res;
        if (path == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        AssetManager assets = new AssetManager();
        assets.addAssetPath(path);
        if (origRes != null) {
            res = new XModuleResources(assets, origRes.getDisplayMetrics(), origRes.getConfiguration());
        } else {
            res = new XModuleResources(assets, null, null);
        }
        AndroidAppHelper.addActiveResource(path, res);
        return res;
    }

    public XResForwarder fwd(int id) {
        return new XResForwarder(this, id);
    }
}