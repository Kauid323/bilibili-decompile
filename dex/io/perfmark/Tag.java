package io.perfmark;

import javax.annotation.Nullable;

public final class Tag {
    final long tagId;
    @Nullable
    final String tagName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tag(@Nullable String tagName, long tagId) {
        this.tagName = tagName;
        this.tagId = tagId;
    }
}