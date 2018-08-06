package witstore.Tools;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public class upLoadImg {
    public static String upload(MultipartFile file,String realPath) throws IOException {
        if (!file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null){
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + "imgs\\userImg\\" + trueFileName;
                    file.transferTo(new File(path));
                    return "http://localhost:8080/imgs/userImg/"+trueFileName;
                }
            }
        }
        return "error";
    }
}