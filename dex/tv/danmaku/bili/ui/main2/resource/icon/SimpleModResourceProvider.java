package tv.danmaku.bili.ui.main2.resource.icon;

import android.content.Context;
import com.bilibili.lib.mod.ModResource;

public class SimpleModResourceProvider implements IModResourceProvider {
    private Context mContext;
    private ModResource mModResource;

    public SimpleModResourceProvider(Context context, ModResource mr) {
        this.mContext = context;
        this.mModResource = mr;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.icon.IModResourceProvider
    public Context forContext() {
        return this.mContext;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.icon.IModResourceProvider
    public synchronized ModResource forModeResource() {
        return this.mModResource;
    }
}