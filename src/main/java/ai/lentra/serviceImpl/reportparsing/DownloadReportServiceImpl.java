package ai.lentra.serviceImpl.reportparsing;

import ai.lentra.service.reportparsing.DownloadReportService;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DownloadReportServiceImpl implements DownloadReportService {

    @Override
    public ByteArrayInputStream load(List<String> fields, String fileName) throws IOException {
        return writeDataToCsv(fields, fileName);
    }

    private ByteArrayInputStream writeDataToCsv(final List<String> fields, String fileName) throws IOException {



        fields.add("applicantId");
        fields.add("applicationId");
        fields.add("agencyId");

        String[] headers = fields.toArray(String[]::new);

        try (final ByteArrayOutputStream stream = new ByteArrayOutputStream();
             final CSVWriter writer = new CSVWriter(new PrintWriter(stream))) {

            List<String[]> data = new ArrayList<>();
            data.add(headers);
            writer.writeAll(data);

            // closing writer connection
            writer.close();

            return new ByteArrayInputStream(stream.toByteArray());
        } catch (final IOException e) {
            throw new RuntimeException("Csv writing error: " + e.getMessage());
        }
    }
}
