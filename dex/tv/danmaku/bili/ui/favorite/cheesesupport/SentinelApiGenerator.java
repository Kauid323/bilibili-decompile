package tv.danmaku.bili.ui.favorite.cheesesupport;

import com.bilibili.okretro.ServiceGenerator;

public class SentinelApiGenerator {
    public static <T> T create(Class<T> serviceClass) {
        return (T) ServiceGenerator.createService(serviceClass);
    }
}