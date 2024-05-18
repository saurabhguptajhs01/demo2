package TestNGExample;

import com.squareup.gifencoder.FloydSteinbergDitherer;
import com.squareup.gifencoder.GifEncoder;
import com.squareup.gifencoder.ImageOptions;
import org.testng.IExecutionVisualiser;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.annotations.Ignore;
import org.testng.xml.XmlSuite;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SampleVisualiser implements IExecutionVisualiser, IReporter {

    private final AtomicInteger counter = new AtomicInteger(1);
    private final Path tmpdir;

    private final List<String> pngFiles = new ArrayList<>();

    public SampleVisualiser() throws IOException {
        tmpdir = Files.createTempDirectory(Paths.get("target"), "dot-");
    }

    @Override
    public void consumeDotDefinition(String dotDefinition) {
        /*String filePrefix = counter.getAndIncrement() + "-" + UUID.randomUUID();
        Path input = Path.of(tmpdir.toFile().getAbsolutePath(), filePrefix + "-input.dot");
        try {
            Files.writeString(input, dotDefinition);
            Path output = Path.of(tmpdir.toFile().getAbsolutePath(), filePrefix + "-output.png");
            if (generatePngFileFromDotContent(input, output)) {
                pngFiles.add(output.toFile().getAbsolutePath());
            }
        } catch (IOException | InterruptedException e) {
            //throw new RuntimeException(e);
        }*/
    }

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        //The GIF image will be created with file name "animation.gif"
        File writeTo = new File(tmpdir.toFile().getAbsolutePath(), "animation.gif");
        try (FileOutputStream outputStream = new FileOutputStream(writeTo)) {
            ImageOptions options = new ImageOptions();

            //Set 500ms between each frame
            options.setDelay(500, TimeUnit.MILLISECONDS);
            //Use Floyd Steinberg dithering as it yields the best quality
            options.setDitherer(FloydSteinbergDitherer.INSTANCE);
            GifEncoder encoder = new GifEncoder(outputStream, 1600, 1200, 0);
            for (String pngFile : pngFiles) {
                encoder.addImage(convertImageToArray(new File(pngFile)), options);
            }
            encoder.finishEncoding();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.err.println("The gif has been generated in :" + writeTo.getAbsolutePath());
    }

    private int[][] convertImageToArray(File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        int[][] rgbArray = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                rgbArray[i][j] = bufferedImage.getRGB(j, i);
            }
        }
        return rgbArray;
    }

    private static boolean generatePngFileFromDotContent(Path input, Path output) throws IOException, InterruptedException {
        String[] cmds = {
                "dot",
                "-Tpng",
                input.toFile().getAbsolutePath(),
                "-o",
                output.toFile().getAbsolutePath()
        };
        Process process = new ProcessBuilder().command(cmds).start();
        handleInputErrorFrom(process);
        int exitCode = process.waitFor();
        System.err.println("PNG file written to " + output.toFile().getAbsolutePath());
        return exitCode == 0;
    }

    private static void handleInputErrorFrom(Process process) throws IOException {
        processStream(process.getInputStream());
        processStream(process.getErrorStream());
    }

    private static void processStream(InputStream stream) throws IOException {
        if (stream == null) {
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}