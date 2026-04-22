package tv.danmaku.bili.ui.main2.resource.icon;

import android.content.Context;
import com.bilibili.lib.mod.ModResource;

public interface IModResourceProvider {
    Context forContext();

    ModResource forModeResource();
}