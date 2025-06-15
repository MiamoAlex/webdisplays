package net.montoyo.wd.utilities.browser.handlers.js.queries;

import com.google.gson.JsonObject;
import net.montoyo.wd.utilities.browser.WDBrowser;
import net.montoyo.wd.utilities.browser.handlers.js.JSQueryHandler;
import net.montoyo.wd.utilities.math.Vector2i;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.callback.CefQueryCallback;

public class GetPositionQuery extends JSQueryHandler {
    public GetPositionQuery() {
        super("GetPosition");
    }

    @Override
    public boolean handle(CefBrowser browser, CefFrame frame, JsonObject data, boolean persistent, CefQueryCallback callback) {
        if (browser instanceof WDBrowser wdBrowser) {
            if (wdBrowser.getSide() != null) {
                var blockPos = wdBrowser.getBe().getBlockPos();
                callback.success("{\"x\":" + blockPos.getX() + ",\"y\":" + blockPos.getY() + ",\"z\":" + blockPos.getZ() + "}");
                return true;
            }
        }
        callback.failure(404, "Screen has been removed.");
        return true;
    }

}
