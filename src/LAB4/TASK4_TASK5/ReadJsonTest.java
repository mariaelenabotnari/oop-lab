package LAB4.TASK4_TASK5;

import LAB4.TASK1.*;
import LAB4.TASK2.*;
import LAB4.TASK3.CarStation;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class ReadJsonTest {
    public static void readJsonDataTest (String path, Queue<Car> queue) throws IOException {
        Path folderPath = Paths.get(path);
        DirectoryStream<Path> stream = Files.newDirectoryStream(folderPath, "*.json");

        ObjectMapper mapper = new ObjectMapper();

        for (Path filePath : stream) {
            Car car = mapper.readValue(filePath.toFile(), Car.class);
            queue.add(car);
        }
    }
}
