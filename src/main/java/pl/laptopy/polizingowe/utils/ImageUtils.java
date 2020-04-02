package pl.laptopy.polizingowe.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.laptopy.polizingowe.dto.ProductDto;
import pl.laptopy.polizingowe.entity.Product;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class ImageUtils {


    public static void render(HttpServletResponse response, ProductDto productDto) throws IOException {
        if (productDto.getImage() != null) {
            byte[] byteArray = new byte[productDto.getImage().length];
            int i = 0;

            for (Byte wrappedByte : productDto.getImage()){
                byteArray[i++] = wrappedByte;
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

    public static void convertImageToBytes(MultipartFile file, Product product) throws IOException {
        Byte[] byteObjects = new Byte[file.getBytes().length];

        int i = 0;

        for (byte b : file.getBytes()){
            byteObjects[i++] = b;
        }

        product.setImage(byteObjects);
    }
}
