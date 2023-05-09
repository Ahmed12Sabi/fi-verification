package ai.lentra.controller.notification.inAppnotification.longpolling.longpolling;


import org.springframework.web.context.request.async.DeferredResult;

public class LongPollingSession {

    private final String username;
    private final DeferredResult<String> deferredResult;

    public LongPollingSession(final String username, final DeferredResult<String> deferredResult) {
        this.username = username;
        this.deferredResult = deferredResult;
    }

    public String getUsername() {
        return username;
    }

    public DeferredResult<String> getDeferredResult() {
        return deferredResult;
    }
}
