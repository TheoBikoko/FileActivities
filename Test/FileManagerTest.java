import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {
    File directory;
    FileManager manager;

    @BeforeEach
    void initialize(){
        directory = new File("FilesDirectory");
        manager = new FileManager();
        manager.createDirectory(directory);
    }

    @Test
    void fileWithMaxLengthInDirectoryIsReturned(){}
//      assertEquals();
    }
