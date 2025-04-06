import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FileTest {
    @BeforeEach
    void initialize(){
        java.io.File directory = new java.io.File("../../FilesDirectory");
    }

    @Test
    void directoryIsReturned() {

    }
}
