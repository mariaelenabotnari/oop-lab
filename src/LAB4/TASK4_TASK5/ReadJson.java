package LAB4.TASK4_TASK5;

import LAB4.TASK1.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ReadJson {
    public static void readJsonData (String path, Queue<Car> queue) throws IOException, InterruptedException {
        Path folderPath = Paths.get(path);
        DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.json");

        ObjectMapper mapper = new ObjectMapper();

        for (Path filePath : stream) {
            Car car = mapper.readValue(filePath.toFile(), Car.class);
            queue.add(car);
            Thread.sleep(3000);
        }
    }
}
