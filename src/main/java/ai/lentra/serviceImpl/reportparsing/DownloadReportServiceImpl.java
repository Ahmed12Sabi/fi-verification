package ai.lentra.serviceImpl.reportparsing;

import ai.lentra.service.reportparsing.DownloadReportService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Service
@Transactional
public class DownloadReportServiceImpl implements DownloadReportService {

    @Override
    public ByteArrayInputStream load(List<String> fields) {
        return writeDataToCsv(fields);
    }

    private ByteArrayInputStream writeDataToCsv(final List<String> fields) {



        fields.add("applicantId");
        String[] headers = fields.toArray(String[]::new);

        try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
             final CSVPrinter printer = new CSVPrinter(new PrintWriter(stream),  CSVFormat.DEFAULT.withHeader(headers))) {


            printer.flush();
            return new ByteArrayInputStream(stream.toByteArray());
        } catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
        }
    }
}
