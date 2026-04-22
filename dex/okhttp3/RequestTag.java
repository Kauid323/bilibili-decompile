package okhttp3;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RequestTag {
    @Nonnull
    private Map<String, Object> mContent = new HashMap();

    private RequestTag() {
    }

    public void set(@Nonnull String key, @Nullable Object value) {
        this.mContent.put(key, value);
    }

    @Nullable
    public Object get(@Nonnull String key) {
        return this.mContent.get(key);
    }

    public void clear() {
        this.mContent.clear();
    }

    public static RequestTag obtain() {
        return new RequestTag();
    }
}