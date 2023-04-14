package ai.lentra.service.offlineVerification;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface OfflineVerificationService {
    public HttpServletResponse getOffLinePDF(HttpServletResponse response) throws Exception;
}
