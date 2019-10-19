package selenium.test.project.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.List;

public class DataReader {

    public Object [][] readData(String file){
        try {
            Reader reader = Files.newBufferedReader(new CustomFileUtils().getResourceFilePath(file));

            CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build(); //withSkipLines(1) -  it means skip description (name of columns)

            List<String[]> lines = csvReader.readAll();
            Object[][] data = new Object[lines.size()][];
            int lineIndex = 0;
            for (String[] line : lines) {
                    data[lineIndex] = line;
                    lineIndex++;
            }
            return data;

        } catch (IOException e) {
            e.printStackTrace();
            return new Object[][]{};
        }
    }
}

