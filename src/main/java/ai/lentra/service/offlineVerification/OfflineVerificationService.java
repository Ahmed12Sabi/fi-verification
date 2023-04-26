package ai.lentra.service.offlineVerification;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface OfflineVerificationService {
    public String getOffLinePDF(HttpServletRequest request) throws Exception;
}
