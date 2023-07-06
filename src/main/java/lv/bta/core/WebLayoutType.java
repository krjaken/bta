package lv.bta.core;

import lombok.Getter;
import org.apache.commons.lang3.NotImplementedException;

@Getter
public enum WebLayoutType {

    DESKTOP(1280, Integer.MAX_VALUE),
    LAPTOP(1100, 1279),
    TABLET(813, 1099),
    MOBILE(0, 812);

    private final int minWidth;
    private final int maxWidth;

    WebLayoutType(int minWidth, int maxWidth) {
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
    }

    public static WebLayoutType parsLayoutType(int width) {
        for (WebLayoutType type : WebLayoutType.values()) {
            if (type.getMinWidth() <= width && type.maxWidth >= width) {
                return type;
            }
        }
        throw new NotImplementedException("Not implemented layout type for width: " + width);
    }
}
