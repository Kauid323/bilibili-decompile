package tv.danmaku.bili.ui.favorite.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.bapis.bilibili.polymer.list.FavoriteTabItemOrBuilder;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.ui.audio.AudioIntentHelper;
import tv.danmaku.bili.ui.favorite.BaseFavoritesFragment;

public class FavoriteTab {
    @JSONField(name = BaseFavoritesFragment.TAB)
    public String id;
    @JSONField(name = ChannelRoutes.CHANNEL_NAME)
    public String name;
    @JSONField(name = AudioIntentHelper.ARGS_URI)
    public String uri;

    public boolean isFavoriteVideoTab() {
        return this.uri != null && this.uri.startsWith("bilibili://main/favorite/playlist");
    }

    public FavoriteTab() {
    }

    public FavoriteTab(String id, String name, String uri) {
        this.id = id;
        this.name = name;
        this.uri = uri;
    }

    public FavoriteTab(FavoriteTabItemOrBuilder builder) {
        this.id = builder.getType();
        this.name = builder.getName();
        this.uri = builder.getUri();
    }
}