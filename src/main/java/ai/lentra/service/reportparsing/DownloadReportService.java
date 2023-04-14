package ai.lentra.service.reportparsing;

import java.io.ByteArrayInputStream;
import java.util.List;

public interface DownloadReportService {
    ByteArrayInputStream load(List<String> fields);
}
